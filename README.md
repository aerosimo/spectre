![MIT License](/img/MIT.png "MIT")

<details>
  <summary>License</summary>

**MIT License © 2025 Aerosimo**

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE  
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER  
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,  
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  
SOFTWARE.

The characters, names, events, articles, templates, or information provided by  
Aerosimo Ltd are fictional and for reference only. While we strive to keep the  
information up to date and correct, we make no representations or warranties of  
any kind, express or implied, about the completeness, accuracy, reliability,  
suitability, or availability with respect to the information, articles, templates,  
or related graphics contained in this document or any part of the project.  
Any reliance you place on such information is therefore strictly at your own risk.
</details>

---

![Project Cover](/img/cover.jpg "Spectre")
# Spectre
> *Spectre is a lightweight, cross-platform service designed to log and track errors across applications and services. It provides both SOAP and REST APIs, along with a simple JSP-based interface for reviewing logged errors.*

---

## Project Structure

This `README.md` gives an overview of the project structure and instructions on how to build and deploy the application.

## Features

1. **SOAP & REST Web Service**: Exposes a `recordError(String faultCode, String faultMessage, String faultService)` method to record new error.
2. **SOAP & REST Web Service**: Exposes a `getTopErrors(int records)` method to show number of recent errors based on number specified.

## Getting Started

![Project Codes & Tasks](/img/code.jpg "Project Codes and Task")

---

### Prerequisites

>- **Apache TomEE 10**: is the application server used during development, but any Jakarta EE 10-compliant server should work.
>- **Java 23**: Ensure you have Java 23 installed as TomEE 10 targets Jakarta EE 10.
>- **Maven**: The project uses Maven for dependency management with any IDE of choice.

### Dependencies

The required dependencies are defined in `pom.xml`. Below are the key dependencies:

- **Jakarta EE 10 API**: Provides JAX-WS support.
- **JAX-WS**: For SOAP web service implementation.

### Building and Running the Application

## Quickstart

1. **Clone the repository**:

    ```bash
    git clone https://github.com/aerosimo/spectre.git
    cd spectre
    ```

2. **Build the project using Maven**:

    ```bash
    mvn clean install
    ```

3. **Deploy the WAR file**:

   After building the project, deploy the generated `WAR` file from the `target/` directory into the `webapps/` folder of your preferred Jakarta EE 10-compatible server.

4. **Start your preferred Jakarta EE 10-compatible server**:

   Start server and access the application:

    - SOAP Service: WSDL at `http://localhost:8081/soap/spectre?wsdl`
    - REST Service: http://localhost:8081/spectre/api/errors
    - Web Interface: `http://localhost:8081/spectre/index.jsp`

## Detailed Explanation of Components

### 1. **SOAP Web Service** (JAX-WS)

The SOAP web service is implemented in `com.aerosimo.ominet.spectre.service.api.SpectreSOAP.java`.

Example recordError SOAP Request:
```xml
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" 
               xmlns:err="https://aerosimo.com/api/ws/spectre">
    <soap:Header/>
    <soap:Body>
        <err:recordError>
            <faultcode>TE10001</faultcode>
            <faultmessage>Random system fault</faultmessage>
            <faultservicename>SoapUI</faultservicename>
        </err:recordError>
    </soap:Body>
</soap:Envelope>
```
Example recordError SOAP Response:
```xml
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
    <soap:Body>
        <err:recordErrorResponse xmlns:err="https://aerosimo.com/api/ws/spectre">
            <recordError>ERR|DCWINE62CGH28KQ3DSA0</recordError>
        </err:recordErrorResponse>
    </soap:Body>
</soap:Envelope>
```
Example getTopErrors SOAP Request:
```xml
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" 
               xmlns:err="https://aerosimo.com/api/ws/spectre">
    <soap:Header/>
    <soap:Body>
        <err:getTopErrors>
            <records>2</records>
        </err:getTopErrors>
    </soap:Body>
</soap:Envelope>
```
Example getTopErrors SOAP Response:
```xml
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope">
    <soap:Body>
        <err:getTopErrorsResponse xmlns:err="https://aerosimo.com/api/ws/spectre">
            <getTopErrors>
                <errorID>6</errorID>
                <errorRef>ERR|H13B8DNF47G4ZYCBUIWT</errorRef>
                <errorTime>2025-09-18 23:46:04.18626 +1:00</errorTime>
                <errorCode>-1722</errorCode>
                <errorMessage>ORA-01722: invalid number</errorMessage>
                <errorService>auth_pkg (LOG AUDIT): babyboi@omisore.co.uk</errorService>
            </getTopErrors>
            <getTopErrors>
                <errorID>5</errorID>
                <errorRef>ERR|CC4LEQH95INM78P55JR2</errorRef>
                <errorTime>2025-09-18 23:39:35.909077 +1:00</errorTime>
                <errorCode>-1722</errorCode>
                <errorMessage>ORA-01722: invalid number</errorMessage>
                <errorService>auth_pkg (LOG AUDIT): babyboi@omisore.co.uk</errorService>
            </getTopErrors>
        </err:getTopErrorsResponse>
    </soap:Body>
</soap:Envelope>
```
### 2. **REST Web Service** (JAX-RS)

The REST web service is implemented in `com.aerosimo.ominet.spectre.service.api.SpectreREST.java`.

Example recordError REST Request:
```json
      {
        "faultCode": "ERR1234",
        "faultMessage": "Null pointer exception in service layer",
        "faultService": "Postman"
      }

```
Example recordError REST Response:
```json
    {
      "errorRef": "ERR|AK0IHE"
    }
```
Example getTopErrors REST Request:
```curl
GET: http://ominet.aerosimo.com:8081/spectre/api/errors?records=2
```
Example getTopErrors REST Response:
```json
[
  {
    "errorID": 9,
    "errorRef": "ERR|AK0IHE",
    "errorTime": "2025-09-20 22:10:34.889266 +1:00",
    "errorCode": "ERR1234",
    "errorMessage": "Null pointer exception in service layer",
    "errorService": "Postman"
  },
  {
    "errorID": 8,
    "errorRef": "ERR|98EK1X",
    "errorTime": "2025-09-20 00:48:21.816125 +1:00",
    "errorCode": "-1722",
    "errorMessage": "ORA-01722: invalid number",
    "errorService": "SoapUI"
  }
]
```
## Contributing

We welcome feedback and contributions. Please open an issue or submit a pull request.

---

![Aerosimo Logo.!](/img/logo.png "Aerosimo")
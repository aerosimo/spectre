![MIT License](/src/main/webapp/assets/img/MIT.png "MIT")

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

![Project Cover](/src/main/webapp/assets/img/cover.jpg "Spectre")
# Spectre
> *Spectre is a lightweight, cross-platform service designed to log and track errors across applications and services. It provides both SOAP and REST APIs, along with a simple JSP-based interface for reviewing logged errors.*

---

## Project Structure

This `README.md` gives an overview of the project structure and instructions on how to build and deploy the application.

## Features

1. **REST Web Service**: Exposes a `stow(String faultCode, String faultMessage, String faultService)` method to record new error.
2. **REST Web Service**: Exposes a `retrieve(int records)` method to show number of recent errors based on number specified.
3. **REST Web Service**: Exposes a `overhaul(String faultReference, String faultStatus)` method to update the error status.

## Getting Started

![Project Codes & Tasks](/src/main/webapp/assets/img/code.jpg "Project Codes and Task")

---

## 🧠 Project Badges & Tech Stack

<p align="center">
  <img src="https://img.shields.io/badge/Java-25%2B-orange?logo=java&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Jakarta%20EE-10-blue?logo=jakartaee&logoColor=white" alt="Jakarta EE 10">
  <img src="https://img.shields.io/badge/Apache%20TomEE-10.1.44-critical?logo=apachetomcat&logoColor=white" alt="Apache TomEE">
  <img src="https://img.shields.io/badge/Oracle%20Database-19c-red?logo=oracle&logoColor=white" alt="Oracle 19c">
  <img src="https://img.shields.io/badge/Maven-3.9%2B-C71A36?logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/REST%20API-JAX--RS-green?logo=rest&logoColor=white" alt="JAX-RS">
  <img src="https://img.shields.io/badge/Frontend-JSP%20%2F%20FetchAPI-purple?logo=html5&logoColor=white" alt="JSP + Fetch API">
  <img src="https://img.shields.io/badge/Logging-Log4j-yellow?logo=apache&logoColor=white" alt="Log4j">
</p>

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

    - REST Service: http://localhost:8081/spectre/api/errors/stow
    - Web Interface: `http://localhost:8081/spectre/index.jsp`

![Project Cover](/src/main/webapp/assets/img/coding.jpg "Coding")

## Detailed Explanation of Components

###  **REST Web Service** (JAX-RS)

The REST web service is implemented in `rest.api.com.aerosimo.ominet.api.SpectreREST.java`.

Example stow REST Request:

```curl
POST: https://localhost:8080/spectre/api/errors/stow
```
```json
      {
        "faultCode": "ERR1234",
        "faultMessage": "Null pointer exception in service layer",
        "faultService": "Postman"
      }

```
Example stow REST Response:
```json
    {
      "status": "success",
      "message": "ERR|AK0IHE"
    }
```
Example retrieve REST Request:
```curl
GET: http://localhost:8080/spectre/api/retrieve?records=2
```
Example retrieve REST Response:
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
Example overhaul REST Request:
```curl
POST: http://localhost:8080/spectre/api/errors/overhaul
```
Example overhaul REST Request:
```json
  {
    "faultReference": "ERR|AK0IHE",
    "faultStatus": "Resolved"
  }
```
Example overhaul REST Response:
```json
  {
    "status": "unsuccessful",
    "message": "missing required fields"
  }
```
## Contributing

We welcome feedback and contributions. Please open an issue or submit a pull request.

---

![Aerosimo Logo.!](/src/main/webapp/assets/img/logo.png "Aerosimo")
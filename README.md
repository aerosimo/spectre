![MIT License.!](/img/MIT.png "MIT")

##### MIT License Copyright (c) 2025 Aerosimo

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

---

# Spectre (EHS)

![Project Cover.!](/img/cover.jpg "Spectre")
# Spectre
> *Spectre (EHS) is a lightweight service that will be implemented and made available across all platforms to facilitate the logging of errors in at different stages of each service, applications across the domain.*

---
This project is a **Spectre** built using **core Java**. Error logging mechanism for tracking system anomalies and exposes **SOAP** web services. The project also includes a simple **JSP-based web interface** for reviewing and managing errors.

## Project Structure

This `README.md` gives an overview of the project structure, dependencies, and instructions on how to build and deploy the application.

## Features

1. **SOAP Web Service**: Exposes a `recordError(String faultCode, String faultMessage, String faultService)` method to record new error.
2. **SOAP Web Service**: Exposes a `getTopErrors(int records)` method to show number of recent errors based on number specified.

## Getting Started

![Project Codes & Tasks.!](/img/code.jpg "Project Codes and Task")

---

### Prerequisites

>- **Apache TomEE 10**: Make sure TomEE is installed and running.
>- **Java 23**: Ensure you have Java 23 installed as TomEE 10 targets Jakarta EE 10.
>- **Maven**: The project uses Maven for dependency management with any IDE of choice.

### Dependencies

The required dependencies are defined in `pom.xml`. Below are the key dependencies:

- **Jakarta EE 10 API**: Provides JAX-WS support.
- **JAX-WS**: For SOAP web service implementation.

### Building and Running the Application

1. **Clone the repository**:

    ```bash
    git clone https://github.com/aerosimo/spectre.git
    cd cardvalidator
    ```

2. **Build the project using Maven**:

    ```bash
    mvn clean install
    ```

3. **Deploy the WAR file**:

   After building the project, deploy the generated `WAR` file from the `target/` directory into the `webapps/` folder of your TomEE installation.

4. **Start TomEE**:

   Start TomEE and access the application:

    - SOAP Service: WSDL at `http://localhost:8080/soap/spectre?wsdl`
    - Web Interface: `http://localhost:8080/spectre/index.jsp`

## Detailed Explanation of Components

### 1. **SOAP Web Service** (JAX-WS)

The SOAP web service is implemented in `com.aerosimo.ominet.spectre.service.api.SpectreSOAP.java`.

Example SOAP Request:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
                  xmlns:card="http://service.ominet.aerosimo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <card:validateCard>
         <CardLongNumber>1234567890123456</CardLongNumber>
      </card:validateCard>
   </soapenv:Body>
</soapenv:Envelope>
```

---

![Aerosimo Logo.!](/img/logo.png "Aerosimo")
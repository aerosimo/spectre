<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  ~ This piece of work is to enhance spectre project functionality.           ~
  ~                                                                           ~
  ~ Author:    eomisore                                                       ~
  ~ File:      index.jsp                                                      ~
  ~ Created:   19/09/2025, 01:56                                              ~
  ~ Modified:  19/09/2025, 10:08                                              ~
  ~                                                                           ~
  ~ Copyright (c)  2025.  Aerosimo Ltd                                        ~
  ~                                                                           ~
  ~ Permission is hereby granted, free of charge, to any person obtaining a   ~
  ~ copy of this software and associated documentation files (the "Software"),~
  ~ to deal in the Software without restriction, including without limitation ~
  ~ the rights to use, copy, modify, merge, publish, distribute, sublicense,  ~
  ~ and/or sell copies of the Software, and to permit persons to whom the     ~
  ~ Software is furnished to do so, subject to the following conditions:      ~
  ~                                                                           ~
  ~ The above copyright notice and this permission notice shall be included   ~
  ~ in all copies or substantial portions of the Software.                    ~
  ~                                                                           ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,           ~
  ~ EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES           ~
  ~ OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                  ~
  ~ NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                ~
  ~ HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,              ~
  ~ WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING              ~
  ~ FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                ~
  ~ OR OTHER DEALINGS IN THE SOFTWARE.                                        ~
  ~                                                                           ~
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" +
                     request.getServerPort() + request.getContextPath() + "/api/errors";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="Elijah Omisore" name="author">
    <meta content="Aerosimo 1.0.0" name="generator">
    <meta content="Aerosimo" name="application-name">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="Aerosimo IT Consultancy" name="description">
    <meta content="Aerosimo" name="apple-mobile-web-app-title">
    <meta content="Oracle, Java, Tomcat, Maven, Jenkins, Bitbucket, Github" name="keywords">
    <meta content="width=device-width, initial-scale=1, user-scalable=no" name="viewport" />
    <!-- Title -->
    <title>Spectre Tester | Aerosimo Ltd</title>
    <!-- Favicon-->
    <link href="assets/img/favicon.ico" rel="shortcut icon"/>
    <link href="assets/img/favicon.ico" rel="icon" type="image/x-icon">
    <link href="assets/img/favicon-32x32.png" rel="icon" sizes="32x32" type="image/png">
    <link href="assets/img/favicon-16x16.png" rel="icon" sizes="16x16" type="image/png">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" sizes="180x180">
    <link href="assets/img/android-chrome-192x192.png" rel="android-chrome" sizes="192x192">
    <style>
        /* -------------------- Sentinel Theme Core Styles -------------------- */
        body { font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif; background: #f4f4f4; margin: 0; padding: 0;}
        .container { max-width: 1000px; margin: 40px auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 12px rgba(0,0,0,0.1);}
        h1, h2 { color: #4d3b7a; margin-bottom: 20px;}
        p { font-size: 16px; line-height: 1.6; margin-bottom: 20px;}
        input, select, button { font-size: 14px; padding: 10px; margin: 5px 0; border-radius: 4px; border: 1px solid #ccc; }
        input:focus, select:focus { outline: none; border-color: #4d3b7a; box-shadow: 0 0 5px rgba(77, 59, 122, 0.3);}
        button { background-color: #4d3b7a; color: #fff; border: none; cursor: pointer; transition: 0.2s; }
        button:hover { background-color: #39286b; }
        .btn-primary { background-color: #4d3b7a; color: #fff; }
        .btn-secondary { background-color: #888; color: #fff; }
        .btn-warning { background-color: #ff9800; color: #fff; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        table th, table td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        table th { background-color: #f0f0f0; }
        .response-box { margin-top: 10px; padding: 10px; border: 1px solid #ccc; background: #f9f9f9; white-space: pre-wrap; border-radius: 4px; font-family: monospace; }
    </style>
</head>
<body>
<div class="container">
    <h1>Spectre REST Tester</h1>
    <p>Interact with Spectre endpoints in real-time. This is a standalone interface for testing and monitoring errors.</p>
    <p>baseUrl = ${baseUrl}</p>

    <!-- Store Error Form -->
    <h2>Store New Error</h2>
    <form id="stowForm">
        <input type="text" id="faultCode" placeholder="Fault Code" required />
        <input type="text" id="faultMessage" placeholder="Fault Message" required />
        <input type="text" id="faultService" placeholder="Service Name" required />
        <button type="submit" class="btn btn-primary">Send</button>
    </form>
    <div id="stowResponse" class="response-box"></div>

    <!-- Retrieve Top Errors -->
    <h2>Top Errors</h2>
    <input type="number" id="topRecords" placeholder="Number of records" value="10" />
    <button id="fetchTop" class="btn btn-secondary">Fetch</button>
    <table id="topErrorsTable">
        <thead>
            <tr>
                <th>Reference</th>
                <th>Fault Code</th>
                <th>Message</th>
                <th>Service</th>
                <th>Status</th>
                <th>Timestamp</th>
            </tr>
        </thead>
        <tbody></tbody>
    </table>

    <!-- Update Error Form -->
    <h2>Update Error Status</h2>
    <form id="updateForm">
        <input type="text" id="faultReference" placeholder="Fault Reference" required />
        <select id="faultStatus" required>
            <option value="">--Select Status--</option>
            <option value="OPEN">OPEN</option>
            <option value="RESOLVED">RESOLVED</option>
            <option value="IGNORED">IGNORED</option>
        </select>
        <button type="submit" class="btn btn-warning">Update</button>
    </form>
    <div id="updateResponse" class="response-box"></div>
</div>

<script>
    const baseUrl = '<%=baseUrl%>';

    // ---- Store Error ----
    document.getElementById('stowForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const data = {
            faultCode: document.getElementById('faultCode').value,
            faultMessage: document.getElementById('faultMessage').value,
            faultService: document.getElementById('faultService').value
        };
        fetch(baseUrl + '/stow', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        }).then(res => res.json())
          .then(resp => document.getElementById('stowResponse').innerText = JSON.stringify(resp, null, 2))
          .catch(err => document.getElementById('stowResponse').innerText = err);
    });

    // ---- Fetch Top Errors ----
    document.getElementById('fetchTop').addEventListener('click', function() {
        const records = document.getElementById('topRecords').value || 2;
        fetch(baseUrl + '/retrieve?records=' + records)
            .then(res => res.json())
            .then(errors => {
                const tbody = document.querySelector('#topErrorsTable tbody');
                tbody.innerHTML = '';
                errors.forEach(err => {
                    tbody.innerHTML += `<tr>
                        <td>${err.faultReference}</td>
                        <td>${err.faultCode}</td>
                        <td>${err.faultMessage}</td>
                        <td>${err.faultService}</td>
                        <td>${err.faultStatus}</td>
                        <td>${err.faultTimestamp}</td>
                    </tr>`;
                });
            })
            .catch(err => alert('Failed to fetch errors: ' + err));
    });

    // ---- Update Error ----
    document.getElementById('updateForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const data = {
            faultReference: document.getElementById('faultReference').value,
            faultStatus: document.getElementById('faultStatus').value
        };
        fetch(baseUrl + '/overhaul', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        }).then(res => res.json())
          .then(resp => document.getElementById('updateResponse').innerText = JSON.stringify(resp, null, 2))
          .catch(err => document.getElementById('updateResponse').innerText = err);
    });
</script>
</body>
</html>
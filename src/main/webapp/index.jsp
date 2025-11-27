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
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%
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
    <link href="assets/img/favicon.ico" rel="shortcut icon" />
    <link href="assets/img/favicon.ico" rel="icon" type="image/x-icon">
    <link href="assets/img/favicon-32x32.png" rel="icon" sizes="32x32" type="image/png">
    <link href="assets/img/favicon-16x16.png" rel="icon" sizes="16x16" type="image/png">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon" sizes="180x180">
    <link href="assets/img/android-chrome-192x192.png" rel="android-chrome" sizes="192x192">
    <style>
      /* -------------------- Dark Sentinel Theme -------------------- */
      body {
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background: #1e1e2f;
        margin: 0;
        padding: 0;
        color: #ddd;
      }

      .container {
        max-width: 1000px;
        margin: 40px auto;
        background: #2b2b3c;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.5);
      }

      h1,
      h2 {
        color: #cfa6ff;
        margin-bottom: 20px;
      }

      p {
        font-size: 16px;
        line-height: 1.6;
        margin-bottom: 20px;
      }

      /* Inputs, selects, buttons */
      input,
      select,
      button {
        font-size: 14px;
        padding: 10px;
        margin: 5px 0;
        border-radius: 4px;
        border: 1px solid #555;
        background: #333;
        color: #ddd;
      }

      input:focus,
      select:focus {
        outline: none;
        border-color: #cfa6ff;
        box-shadow: 0 0 5px rgba(207, 166, 255, 0.5);
      }

      button {
        border: none;
        cursor: pointer;
        transition: 0.2s;
      }

      .btn-primary {
        background-color: #7356c8;
        color: #fff;
      }

      .btn-primary:hover {
        background-color: #4d3b7a;
      }

      .btn-secondary {
        background-color: #555;
        color: #fff;
      }

      .btn-secondary:hover {
        background-color: #777;
      }

      .btn-warning {
        background-color: #ff9800;
        color: #1e1e2f;
      }

      .btn-warning:hover {
        background-color: #e68a00;
      }

      /* Response Box */
      .response-box {
        margin-top: 10px;
        padding: 10px;
        border: 1px solid #555;
        background: #1e1e2f;
        color: #ddd;
        white-space: pre-wrap;
        border-radius: 4px;
        font-family: monospace;
      }

      /* Table Styles */
      table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
        color: #ddd;
      }

      table th,
      table td {
        border: 1px solid #444;
        padding: 10px;
        text-align: left;
      }

      table th {
        background-color: #3a3a4f;
      }

      table tr:nth-child(even) {
        background-color: #2e2e41;
      }

      table tr:hover {
        background-color: #3e3e5a;
      }

      /* Cards */
      .card {
        background: #2b2b3c;
        border-radius: 12px;
        padding: 20px;
        margin-bottom: 20px;
        box-shadow: 0 3px 10px rgba(0, 0, 0, 0.4);
        border-left: 6px solid transparent;
        transition: 0.3s;
      }

      .card:hover,
      .card:focus-within {
        background: #3e2e5a;
        border-left-color: #cfa6ff;
        box-shadow: 0 4px 14px rgba(0, 0, 0, 0.6);
      }
    </style>
  </head>
  <body>
    <div class="container">
      <div class="header" style="text-align:center; margin-bottom: 30px;">
          <img src="https://thumbs4.imagebam.com/3e/10/82/MED2HDH_t.png" alt="Aerosimo Logo"
               style="height:100px; display:block; margin:0 auto;" />
          <h1 style="color:#cfa6ff; margin-top:20px;">Spectre REST Tester</h1>
          <p style="color:#ddd; font-size:16px; max-width:600px; margin:10px auto 0 auto;">
              Interact with Spectre endpoints in real-time. This standalone interface allows testing and monitoring errors.
          </p>
      </div>
      <!-- CARD 1: Store Error -->
      <div class="card">
        <h2>Store New Error</h2>
        <form id="stowForm">
          <input type="text" id="faultCode" placeholder="Fault Code" required />
          <input type="text" id="faultMessage" placeholder="Fault Message" required />
          <input type="text" id="faultService" placeholder="Service Name" required />
          <button type="submit" class="btn-primary">Send</button>
        </form>
        <div id="stowResponse" class="response-box"></div>
      </div>
      <!-- CARD 2: Retrieve Errors -->
      <div class="card">
        <h2>Top Errors</h2>
        <input type="number" id="topRecords" placeholder="Number of records" value="10" />
        <button id="fetchTop" class="btn-secondary">Fetch</button>
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
      </div>
      <!-- CARD 3: Update Error -->
      <div class="card">
        <h2>Update Error Status</h2>
        <form id="updateForm">
          <input type="text" id="faultReference" placeholder="Fault Reference" required />
          <select id="faultStatus" required>
            <option value="">--Select Status--</option>
            <option value="OPEN">OPEN</option>
            <option value="RESOLVED">RESOLVED</option>
            <option value="IGNORED">IGNORED</option>
          </select>
          <button type="submit" class="btn-warning">Update</button>
        </form>
        <div id="updateResponse" class="response-box"></div>
      </div>
    </div>
    <script>
    // Inject JSP base URL into JavaScript
    const baseUrl = '<%= baseUrl %>';

    // ---- Store Error ----
    document.getElementById('stowForm').addEventListener('submit', async function(e) {
        e.preventDefault();

        const data = {
            faultCode: document.getElementById('faultCode').value,
            faultMessage: document.getElementById('faultMessage').value,
            faultService: document.getElementById('faultService').value
        };

        const res = await fetch(baseUrl + '/stow', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        document.getElementById('stowResponse').innerText = await res.text();
    });

    // ---- Fetch Top Errors ----
    document.getElementById('fetchTop').addEventListener('click', async function() {
        const records = document.getElementById('topRecords').value || 10;

        const res = await fetch(baseUrl + '/retrieve?records=' + records);
        const text = await res.text();

        // Just show raw text for now (until JSON parsing is needed)
        const table = document.getElementById('topErrorsTable');
        table.style.display = 'none';

        // Add a new output box for raw text if you want
        if (!document.getElementById('retrieveOutput')) {
            const output = document.createElement('div');
            output.id = 'retrieveOutput';
            output.className = 'response-box';
            table.parentNode.insertBefore(output, table);
        }

        document.getElementById('retrieveOutput').innerText = text;
    });

    // ---- Update Error ----
    document.getElementById('updateForm').addEventListener('submit', async function(e) {
        e.preventDefault();

        const data = {
            faultReference: document.getElementById('faultReference').value,
            faultStatus: document.getElementById('faultStatus').value
        };

        const res = await fetch(baseUrl + '/overhaul', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        document.getElementById('updateResponse').innerText = await res.text();
    });
    </script>

  </body>
</html>
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
      body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: #f5f5f8;
        color: #333;
      }

      /* Wavy Header */
      .header {
        position: relative;
        background: linear-gradient(135deg, #4d3b7a 0%, #7356c8 100%);
        height: 180px;
        color: white;
        display: flex;
        align-items: center;
        padding-left: 40px;
      }

      .header img {
        height: 80px;
        margin-right: 20px;
      }

      .header-title {
        font-size: 32px;
        font-weight: bold;
      }

      /* Wave Shape */
      .header::after {
        content: "";
        position: absolute;
        bottom: -40px;
        left: 0;
        width: 100%;
        height: 80px;
        background: url('data:image/svg+xml;utf8,
<svg viewBox="0 0 1440 320"
            xmlns="http://www.w3.org/2000/svg"> <path fill="%23f5f5f8"d="M0,224L48,186.7C96,149,192,75,288,42.7C384,11,480,21,576,53.3C672,85,768,139,864,160C960,181,1056,171,1152,170.7C1248,171,1344,181,1392,186.7L1440,192L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"/> </svg>');
background-size: cover;
        }

        /* Content Container */
        .content {
          max-width: 900px;
          margin: 80px auto 40px auto;
          padding: 20px;
        }

        /* Cards */
        .card {
          background: white;
          border-radius: 12px;
          padding: 20px;
          margin-bottom: 20px;
          box-shadow: 0 3px 10px rgba(0, 0, 0, 0.1);
          border-left: 6px solid transparent;
          transition: 0.3s;
        }

        .card:hover,
        .card:focus-within {
          background: #fff9d6;
          border-left-color: #e6b800;
          box-shadow: 0 4px 14px rgba(0, 0, 0, 0.15);
        }

        h2 {
          margin-top: 0;
          color: #4d3b7a;
        }

        label {
          display: block;
          margin-top: 10px;
          font-weight: bold;
        }

        input, textarea {
          width: 100%;
          padding: 10px;
          border-radius: 6px;
          border: 1px solid #ccc;
          margin-top: 5px;
        }

        button {
          margin-top: 15px;
          padding: 10px 15px;
          background: #4d3b7a;
          color: white;
          border: none;
          border-radius: 6px;
          cursor: pointer;
        }

        button:hover {
          background: #382c5d;
        }

        .output {
          background: #eee;
          padding: 15px;
          border-radius: 8px;
          margin-top: 10px;
          white-space: pre-wrap;
        }

        .header {
          position: relative;
          background: linear-gradient(135deg, #4d3b7a 0%, #7356c8 100%);
          height: 240px;
          color: white;
          display: flex;
          justify-content: center;
          align-items: center;
          text-align: center;
        }

        .header-inner img {
          height: 90px;
          display: block;
          margin: 0 auto 10px auto;
        }

        .header-title {
          font-size: 34px;
          font-weight: bold;
        }

        .header::after {
          content: "";
          position: absolute;
          bottom: -60px;
          left: 0;
          width: 100%;
          height: 120px;
          background: url('data:image/svg+xml;utf8,
<svg xmlns="http://www.w3.org/2000/svg"viewBox="0 0 1440 320"> <path fill="%23f5f5f8"d="M0,256L48,234.7C96,213,192,171,288,144C384,117,480,107,576,133.3C672,160,768,224,864,245.3C960,267,1056,245,1152,229.3C1248,213,1344,203,1392,197.3L1440,192L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"></path> </svg>');
background-size: cover;
          }

          /* CARD GRID */
          .grid {
            display: grid; grid-template-columns: repeat(2, 1fr); gap: 20px;
          }

          .full {
            grid-column: span 2;
          }
    </style>
  </head>
  <body>
    <!-- HEADER WITH WAVE + LOGO -->
    <div class="header">
      <div class="header-inner">
        <img src="https://thumbs4.imagebam.com/3e/10/82/MED2HDH_t.png" alt="Aerosimo Logo" />
        <div class="header-title">Spectre REST Tester</div>
      </div>
    </div>
    </div>
    <div class="content">
      <div class="grid">
        <!-- BASE URL CALCULATION --><%
            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/api/errors";
        %> <p>
          <strong>Base URL:</strong><%= baseUrl %>
        </p>
        <!-- CARD 1: STORE ERROR -->
        <div class="card">
          <h2>Store Error (POST /stow)</h2>
          <label>Fault Code</label>
          <input id="stowCode" />
          <label>Fault Message</label>
          <textarea id="stowMessage"></textarea>
          <label>Fault Service</label>
          <input id="stowService" />
          <button onclick="storeError()">Send</button>
          <div id="stowOutput" class="output"></div>
        </div>
        <!-- CARD 3: UPDATE ERROR -->
        <div class="card">
          <h2>Update Error (POST /overhaul)</h2>
          <label>Fault Reference</label>
          <input id="updateRef" />
          <label>New Status</label>
          <input id="updateStatus" />
          <button onclick="updateError()">Update</button>
          <div id="updateOutput" class="output"></div>
        </div>
        <!-- CARD 2: RETRIEVE ERRORS -->
        <div class="card full">
          <h2>Retrieve Errors (GET /retrieve)</h2>
          <label>Number of Records</label>
          <input id="retrieveCount" value="10" />
          <button onclick="retrieveErrors()">Retrieve</button>
          <div id="retrieveOutput" class="output"></div>
        </div>
        <!-- END GRID -->
      </div>
    </div>
    <script>
      const base = '<%= baseUrl %>';
      async function storeError() {
        const body = {
          faultCode: document.getElementById('stowCode').value,
          faultMessage: document.getElementById('stowMessage').value,
          faultService: document.getElementById('stowService').value
        };
        const res = await fetch(base + '/stow', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(body)
        });
        document.getElementById('stowOutput').innerText = await res.text();
      }
      async function retrieveErrors() {
        const count = document.getElementById('retrieveCount').value;
        const res = await fetch(base + '/retrieve?records=' + count);
        document.getElementById('retrieveOutput').innerText = await res.text();
      }
      async function updateError() {
        const body = {
          faultReference: document.getElementById('updateRef').value,
          faultStatus: document.getElementById('updateStatus').value
        };
        const res = await fetch(base + '/overhaul', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(body)
        });
        document.getElementById('updateOutput').innerText = await res.text();
      }
    </script>
  </body>
</html>
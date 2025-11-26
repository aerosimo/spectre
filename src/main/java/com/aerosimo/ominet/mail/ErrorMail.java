/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ErrorMail.java                                                  *
 * Created:   26/11/2025, 16:11                                               *
 * Modified:  26/11/2025, 16:11                                               *
 *                                                                            *
 * Copyright (c)  2025.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.mail;

import com.aerosimo.ominet.core.models.Herald;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorMail {

    private static final Logger log = LogManager.getLogger(ErrorMail.class.getName());

    public static String mail(String faultref, String faultcode, String faultmessage) {
        log.info("Preparing error email body content with Error Code: - {}, Error Reference: - {}", faultcode, faultref);
        try {
            StringBuilder message =  new StringBuilder("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Ominet Error Notification</title>\n" +
                    "    <style>\n" +
                    "        body {\n" +
                    "            margin: 0;\n" +
                    "            padding: 0;\n" +
                    "            background: #f4f4f7;\n" +
                    "            font-family: Poppins, Arial, sans-serif;\n" +
                    "        }\n" +
                    "        .container {\n" +
                    "            max-width: 560px;\n" +
                    "            margin: 30px auto;\n" +
                    "            background: #ffffff;\n" +
                    "            border-radius: 8px;\n" +
                    "            border-top: 6px solid #FCA311;\n" +
                    "            box-shadow: 0 4px 14px rgba(0,0,0,0.08);\n" +
                    "            padding: 0;\n" +
                    "        }\n" +
                    "        .header {\n" +
                    "            background: #14213D;\n" +
                    "            color: #ffffff;\n" +
                    "            text-align: center;\n" +
                    "            padding: 25px 20px;\n" +
                    "            border-radius: 8px 8px 0 0;\n" +
                    "        }\n" +
                    "        .header h1 {\n" +
                    "            margin: 0;\n" +
                    "            font-size: 22px;\n" +
                    "            font-weight: 600;\n" +
                    "            letter-spacing: 0.5px;\n" +
                    "        }\n" +
                    "        .title-block {\n" +
                    "            padding: 20px 30px 10px;\n" +
                    "            text-align: left;\n" +
                    "        }\n" +
                    "        .title-block span.ref {\n" +
                    "            display: inline-block;\n" +
                    "            background: #FCA311;\n" +
                    "            color: #14213D;\n" +
                    "            padding: 6px 12px;\n" +
                    "            border-radius: 6px;\n" +
                    "            font-weight: 600;\n" +
                    "            font-size: 12px;\n" +
                    "            text-transform: uppercase;\n" +
                    "        }\n" +
                    "        .title-block h2 {\n" +
                    "            margin-top: 15px;\n" +
                    "            font-size: 20px;\n" +
                    "            color: #14213D;\n" +
                    "            font-weight: 600;\n" +
                    "        }\n" +
                    "        .error-section {\n" +
                    "            padding: 10px 30px 20px;\n" +
                    "            font-size: 14px;\n" +
                    "            line-height: 22px;\n" +
                    "            color: #444444;\n" +
                    "        }\n" +
                    "        .error-section p strong {\n" +
                    "            color: #14213D;\n" +
                    "        }\n" +
                    "        .illustration {\n" +
                    "            text-align: center;\n" +
                    "            padding: 25px 0 10px;\n" +
                    "        }\n" +
                    "        .illustration img {\n" +
                    "            width: 65%;\n" +
                    "            border-radius: 6px;\n" +
                    "            box-shadow: 0 6px 20px rgba(0,0,0,0.1);\n" +
                    "        }\n" +
                    "        .footer {\n" +
                    "            text-align: center;\n" +
                    "            font-size: 12px;\n" +
                    "            color: #717171;\n" +
                    "            padding: 25px;\n" +
                    "            border-top: 1px solid #eeeeee;\n" +
                    "        }\n" +
                    "        .cta-btn {\n" +
                    "            display: inline-block;\n" +
                    "            margin: 22px auto;\n" +
                    "            background: #14213D;\n" +
                    "            color: #ffffff !important;\n" +
                    "            padding: 12px 32px;\n" +
                    "            border-radius: 30px;\n" +
                    "            font-size: 14px;\n" +
                    "            font-weight: 600;\n" +
                    "            text-decoration: none;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <div class=\"header\">\n" +
                    "            <h1>OMINET ERROR ALERT</h1>\n" +
                    "        </div>\n" +
                    "        <div class=\"illustration\">\n" +
                    "            <img src=\"https://thumbs4.imagebam.com/3a/3d/f2/MEC3A8I_t.jpg\" alt=\"Error\">\n" +
                    "        </div>\n" +
                    "        <div class=\"title-block\">\n" +
                    "            <span class=\"ref\">REF:");
            message.append(faultref);
            message.append("</span>\n" +
                    "            <h2>An exception has been recorded in Spectre</h2>\n" +
                    "        </div>\n" +
                    "        <div class=\"error-section\">\n" +
                    "            <p><strong>Error Code:</strong> ");
            message.append(faultcode);
            message.append("</p>\n" +
                    "            <p><strong>Error Message:</strong> ");
            message.append(faultmessage);
            message.append("</p>\n" +
                    "            <p>This error has been logged by Ominet and forwarded automatically by Spectre for administrative review.</p>\n" +
                    "        </div>\n" +
                    "        <div style=\"text-align:center;\">\n" +
                    "            <a class=\"cta-btn\">Aerosimo Support Team</a>\n" +
                    "        </div>\n" +
                    "        <div class=\"footer\">\n" +
                    "            &copy; <script>document.write(new Date().getFullYear());</script> Aerosimo Ltd. All rights reserved.<br><br>\n" +
                    "            <span style=\"font-size:10px;\">\n" +
                    "                This email is confidential and may contain privileged information.  \n" +
                    "                If you are not the intended recipient, please notify the sender immediately.\n" +
                    "            </span>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
            return Herald.announce("Aerosimo Support<support@aerosimo.com>","Fault Notification",message.toString(),"");
        }catch (Exception err) {
            log.info("Error email body content failed to be sent with the following - {}", err.getMessage());
            return "internal server error";
        }
    }
}
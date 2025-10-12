/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ErrorMail.java                                                  *
 * Created:   19/09/2025, 19:17                                               *
 * Modified:  19/09/2025, 19:17                                               *
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

package com.aerosimo.ominet.spectre.mail;

import com.aerosimo.ominet.spectre.core.models.Postmaster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorMail {

    private static final Logger log;

    static {
        log = LogManager.getLogger(ErrorMail.class.getName());
    }

    static String response;

    public static String mail(String faultref, String faultcode, String faultmessage) {
        log.info("Preparing Email body content");
        StringBuilder message;
        try {
            message = new StringBuilder("""
                    <!DOCTYPE html>
                        <html>
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                            <style>
                                * {
                                    margin: 0;
                                    padding: 0;
                                    font-family: Poppins;
                                }
                               \s
                                img {
                                    display: inline-block;
                                }

                                .container {
                                    max-width: 500px;
                                    margin: 20px auto;
                                    border-radius: 4px;
                                    border: 1px solid rgba(0, 0, 0, .1);
                                    border-top: 3px solid #016FB9;
                                    min-height: 100px;
                                    position: relative;
                                    &::before {
                                        content: '';
                                        position: absolute;
                                        top: 0;
                                        left: 0;
                                        width: 100%;
                                        height: 3px;
                                        background: linear-gradient(to right, #0267C1, #D65108);
                                    }
                                }

                                .illustration {
                                    width: 100%;
                                    text-align: center;
                                    box-shadow: 0 10px 20px -5px rgba(0, 0, 0, .05);
                                    border-radius: 0 0 50% 50% / 1%;
                                }

                                .illustration img {
                                    width: 70%;
                                    margin: 50px auto;
                                }

                                .separator {
                                    display: block;
                                    height: 3px;
                                    width: 70%;
                                    margin: 10px auto;
                                    background-color: rgba(0, 0, 0, .05);
                                    border-radius: 10px;
                                    position: relative;
                                    overflow: hidden;
                                    &::before, &::after {
                                        content: '';
                                        position: absolute;
                                        left: 0;
                                        top: 0;
                                        height: 100%;
                                        width: 33%;
                                        border-radius: inherit;
                                        opacity: .05;
                                    }
                                    &::before {
                                        left: 0;
                                        background: #EFA00B;
                                    }
                                    &::after {
                                        left: initial;
                                        right: 0;
                                        background: #D65108;
                                    }
                                }

                                .hgroup {
                                    text-align: center;
                                    padding: 50px 30px 30px;
                                }

                                .name {
                                    display: block;
                                    text-transform: uppercase;
                                    margin-bottom: 5px;
                                    color: #0267C1;
                                    font-weight: 600;
                                }

                                .hgroup h1 {
                                    font-size: 20px;
                                    font-weight: 600;
                                    color: #333;
                                }

                                .hgroup h2 {
                                    font-size: 19px;
                                }

                                .hgroup p {
                                    font-size: 14px;
                                    color: slategrey;
                                    margin-top: 15px;
                                    text-align: justify;
                                    line-height: 25px;
                                }

                                .items {
                                    padding: 30px;
                                    display: grid;
                                    grid-template-columns: repeat(2, 1fr);
                                }

                                .item {
                                    margin-bottom: 10px;
                                    text-align: center;
                                    width: 100%;
                                    margin: 0 auto 50px;
                                }

                                .item .icon {
                                    margin-bottom: 10px;
                                }

                                .item .icon img {
                                    width: 60px;
                                }

                                .item .title {
                                    margin-bottom: 5px;
                                    font-size: 16px;
                                    font-weight: 600;
                                }

                                .item .subtitle {
                                    font-size: 13px;
                                    color: slategrey;
                                    padding: 1rem;
                                }

                                .button-wrap {
                                    text-align: center;
                                    padding: 2rem;
                                }

                                button.explore {
                                    padding: 15px 25px;
                                    font: inherit;
                                    background: linear-gradient(to right, #0267C1, #0280EF);
                                    border-radius: 50px;
                                    border: 0;
                                    color: #fff;
                                    margin: auto;
                                    display: inline-block;
                                    transition: all .2s ease-in-out;
                                    cursor: pointer;
                                    box-shadow: 0 5px 10px rgba(0, 0, 0, .1);
                                }

                                button.explore:hover {
                                    transform: translateY(-5px);
                                    box-shadow: 0 15px 10px -7px rgba(0, 0, 0, .1);
                                }

                                footer {
                                    font-size: 12px;
                                    color: slategrey;
                                    text-align: center;
                                    padding: 30px;
                                }
                            </style>
                        </head>
                        <body>
                            <div class="container">
                                <div class="illustration">
                                    <a href="https://www.imagebam.com/view/MEC3A8I" target="_blank">
                                        <img src="https://thumbs4.imagebam.com/3a/3d/f2/MEC3A8I_t.jpg" alt="Error"/>
                                    </a>
                                </div>
                                <!-- <span class="separator"></span> -->
                                <div class="hgroup">
                                    <span class="name">\s"""
            );
            message.append(faultref);
            message.append("""
                    </span><br>
                                                        <h1>Notification Message from Spectre</h1>
                                                        <div class="error-details">
                                                        <p><strong>Error Code:</strong>
                    """);
            message.append(faultcode);
            message.append("</p>\n" +
                    "                    <p><strong>Error Message:</strong> ");
            message.append(faultmessage);
            message.append("""
                    </p>
                                    </div>
                                </div>
                                <div class="hgroup">
                                    <h2>Thank you so much for compliance</h2>
                                </div>
                                <div class="button-wrap">
                                    <button class="explore">Aerosimo Support Team</button>
                                </div>
                                <footer>
                                    <p>&copy; <script>document.write(new Date().getFullYear());</script> Sentinel by Aerosimo Ltd. All rights reserved.</p>
                                </footer>
                                <span style="font-size:10px;">This is a confidential email and may also be privileged. If you are not the intended recipient, please inform us immediately.</span>
                            </div>
                        </body>
                        </html>""");
            response = Postmaster.sendEmail("Aerosimo Support<support@aerosimo.com>",
                    "Fault Notification",message.toString(),"");
            log.info("Email Response: {}", response);
        } catch (Exception err) {
            response = "Fault notification email failed";
            log.error("Fault notification email service {} failed with error - {}", ErrorMail.class.getName(), err);
        }
        return response;
    }
}
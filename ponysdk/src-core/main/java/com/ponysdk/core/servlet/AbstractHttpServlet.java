/*
 * Copyright (c) 2011 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *  Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *  Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *  
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.ponysdk.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public abstract class AbstractHttpServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(AbstractHttpServlet.class);

    protected AbstractApplicationManager applicationManager;

    @Override
    public void init() throws ServletException {
        super.init();

        applicationManager = createApplicationManager();
    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        doProcess(req, resp);
    }

    protected void doProcess(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json; charset=utf-8");

        final Session session = SessionManager.get().getSession(req.getSession().getId());
        try {
            applicationManager.process(new HttpRequest(session, req), new HttpResponse(resp));
        } catch (final Throwable e) {
            resp.sendError(501, e.getMessage());
            log.error("Failed to process request", e);
        }
    }

    protected abstract AbstractApplicationManager createApplicationManager();

}

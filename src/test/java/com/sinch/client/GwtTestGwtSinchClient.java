/*
 * Copyright 2018, Dotweblabs Web Technologies, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.sinch.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.Window;
import com.sinch.client.jso.*;

public class GwtTestGwtSinchClient extends GWTTestCase {

    private static final int DELAY_TIMEOUT = 10000;
    private static final String APPLICATION_KEY = "";

    @Override
    public String getModuleName() {
        return "com.sinch.GwtSinchClient";
    }

    @Override
    protected void gwtSetUp() throws Exception {
        super.gwtSetUp();
    }

    public void testInitSinchClient() {
        delayTestFinish(DELAY_TIMEOUT);
        Capabilities capabilities = Capabilities.newInstance();
        capabilities.setCalling(true);
        capabilities.setMessaging(false);


        GwtSinchClient.load();
        GwtSinchClient.init(APPLICATION_KEY,
                    capabilities,
                    false,
                    false,
                    null);
            finishTest();
        if(GwtSinchClient.isLoaded()) {

        }

    }

    public void testGetSession() {
        delayTestFinish(DELAY_TIMEOUT);
        Capabilities capabilities = Capabilities.newInstance();
        capabilities.setCalling(true);
        capabilities.setMessaging(false);
        GwtSinchClient.load();
        if(GwtSinchClient.isLoaded()) {

        }
        GwtSinchClient.init(
                APPLICATION_KEY,
                capabilities,
                false,
                false,
                null);
        LoginObject loginObject = LoginObject.newInstance();
        loginObject.setUsername("asdf");
        loginObject.setPassword("asdfasdf");
        GwtSinchClient.start(loginObject, new Callback<JavaScriptObject>() {
            @Override
            public void success(JavaScriptObject jso) {
                Window.alert(GwtSinchClient.stringify(jso));
                SessionObject session = GwtSinchClient.getSession();
                assertNotNull(session);
                Window.alert("Session:         " + GwtSinchClient.stringify(session));
                Window.alert("Session ID:      " + session.getSessionId());
                Window.alert("Session Secret:  " + session.getSessionSecret());
                Window.alert("Session User ID: " + session.getUserId());
                finishTest();
            }
            @Override
            public void failure(JavaScriptObject jso) {
                fail();
            }
        });

    }

    public void testCallPhone() {
        delayTestFinish(DELAY_TIMEOUT);
        GwtSinchClient.load();
        if(GwtSinchClient.isLoaded()) {

        }
        Capabilities capabilities = Capabilities.newInstance();
        capabilities.setCalling(true);
        capabilities.setMessaging(false);
        GwtSinchClient.init(
                APPLICATION_KEY,
                capabilities,
                false,
                false,
                null);
        LoginObject loginObject = LoginObject.newInstance();
        loginObject.setUsername("asdf");
        loginObject.setPassword("asdfasdf");
        GwtSinchClient.start(loginObject, new Callback<JavaScriptObject>() {
            @Override
            public void success(JavaScriptObject jso) {
                Window.alert(GwtSinchClient.stringify(jso));
                SessionObject session = GwtSinchClient.getSession();
                CallClient callClient = GwtSinchClient.getCallClient();
                Window.alert("Session:         " + GwtSinchClient.stringify(session));
                Window.alert("Session ID:      " + session.getSessionId());
                Window.alert("Session Secret:  " + session.getSessionSecret());
                Window.alert("Session User ID: " + session.getUserId());
                Window.alert("Calling phone...");
                assertNotNull(callClient);
                callClient.callPhoneNumber("+639322930904");
                finishTest();
            }
            @Override
            public void failure(JavaScriptObject jso) {
                fail();
            }
        });

    }
}

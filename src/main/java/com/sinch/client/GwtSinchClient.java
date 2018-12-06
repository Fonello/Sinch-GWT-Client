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
import com.google.gwt.user.client.Window;
import com.sinch.client.jso.*;
import com.sinch.client.resources.GwtSinchClientResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import jsfunction.gwt.JsFunction;

public class GwtSinchClient {
    private GwtSinchClient() {}
    public static native boolean isLoaded() /*-{
        return $wnd.sinchClient !== undefined;
    }-*/;
    public static void load() {
        if (!isLoaded()) {
            GwtSinchClientResources resources = GWT.create(GwtSinchClientResources.class);
            ScriptInjector.fromString(resources.js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }
    public static native void init(String applicationKey, Capabilities capabilities,
                                   Boolean supportActiveConnection, Boolean startActiveConnection,
                                   JsFunction onLogMessage)/*-{
        $wnd.sinchClient = new $wnd.SinchClient({
            applicationKey: applicationKey,
            capabilities: capabilities,
            supportActiveConnection : supportActiveConnection,
            startActiveConnection: startActiveConnection, //NOTE: This is only required if application is to receive calls / instant messages.
            //Note: For additional loging, please uncomment the three rows below
            onLogMessage: onLogMessage
        });
    }-*/;
    public static native void init(String applicationKey, Capabilities capabilities,
                                        Boolean supportActiveConnection, Boolean startActiveConnection)/*-{
        $wnd.sinchClient = new $wnd.SinchClient({
            applicationKey: applicationKey,
            capabilities: {calling: true},
            supportActiveConnection : supportActiveConnection,
            startActiveConnection: startActiveConnection //NOTE: This is only required if application is to receive calls / instant messages.
        });
    }-*/;
    public static native void start(SessionObject sessionObject, JsFunction handleSuccess, JsFunction handleFailure) /*-{
        $wnd.sinchClient.start(sessionObject, handleSuccess, handleFailure);
    }-*/;
    public static native void start(SessionObject sessionObject, Callback<JavaScriptObject> callback) /*-{
        var handleFailure = function(error) {
            @com.sinch.client.GwtSinchClient::callbackFailure(*)(callback, error);
        }
        var handleSuccess = function(success) {
            @com.sinch.client.GwtSinchClient::callbackSuccess(*)(callback, success);
        }
        $wnd.sinchClient.start(sessionObject, handleSuccess, handleFailure);
    }-*/;
    public static native void start(LoginObject loginObject, Callback<JavaScriptObject> callback) /*-{
        var handleFailure = function(error) {
            @com.sinch.client.GwtSinchClient::callbackFailure(*)(callback, error);
        }
        var handleSuccess = function(success) {
            @com.sinch.client.GwtSinchClient::callbackSuccess(*)(callback, success);
        }
        $wnd.sinchClient.start(loginObject, handleSuccess).fail(handleFailure);
    }-*/;

    public static native void start(SignupObject signupObject, Callback<JavaScriptObject> callback) /*-{
        var handleFailure = function(error) {
            @com.sinch.client.GwtSinchClient::callbackFailure(*)(callback, error);
        }
        var handleSuccess = function(success) {
            @com.sinch.client.GwtSinchClient::callbackSuccess(*)(callback, success);
        }
        $wnd.sinchClient.start(signupObject, handleSuccess, handleFailure);
    }-*/;
    public static native void start(String authTicket, Callback<JavaScriptObject> callback) /*-{
        var handleFailure = function(error) {
            @com.sinch.client.GwtSinchClient::callbackFailure(*)(callback, error);
        }
        var handleSuccess = function(success) {
            @com.sinch.client.GwtSinchClient::callbackSuccess(*)(callback, success);
        }
        $wnd.sinchClient.start(authTicket, handleSuccess, handleFailure);
    }-*/;
    public static native void newUser(JavaScriptObject signUpObj, Callback<JavaScriptObject> callback) /*-{
        var handleFailure = function(error) {
            @com.sinch.client.GwtSinchClient::callbackFailure(*)(callback, error);
        }
        var handleSuccess = function(success) {
            @com.sinch.client.GwtSinchClient::callbackSuccess(*)(callback, success);
        }
        $wnd.sinchClient.newUser(signUpObj, handleSuccess, handleFailure);
    }-*/;




    public static native void start(SignupObject signupObject, JsFunction handleSuccess, JsFunction handleFailure) /*-{
        $wnd.sinchClient.start(signupObject, handleSuccess, handleFailure);
    }-*/;
    public static native void start(String authTicket, JsFunction handleSuccess, JsFunction handleFailure) /*-{
        $wnd.sinchClient.start(authTicket, handleSuccess, handleFailure);
    }-*/;
    public static native void newUser(JavaScriptObject signUpObj, JsFunction handleSuccess, JsFunction handleFailure) /*-{
        $wnd.sinchClient.newUser(loginObj, handleSuccess, handleFailure);
    }-*/;
    public static native CallClient getCallClient() /*-{
        return $wnd.sinchClient.getCallClient();
    }-*/;
    public static native CallClient callUser(String remoteUserId) /*-{
        return $wnd.sinchClient.callUser(remoteUserId);
    }-*/;
    public static native SessionObject getSession() /*-{
        return $wnd.sinchClient.getSession();
    }-*/;
    public static native void terminate() /*-{
        $wnd.sinchClient.terminate();
    }-*/;
    public static native String stringify(JavaScriptObject jso) /*-{
        return JSON.stringify(jso);
    }-*/;

    /**
     * Common success callback method
     *
     * @param callback
     * @param response
     */
    @SuppressWarnings("unused")
    protected static void callbackSuccess(Callback<JavaScriptObject> callback, JavaScriptObject response){
        callback.success(response);
    }

    /**
     * Common failure callback method
     *
     * @param callback
     * @param response
     */
    @SuppressWarnings("unused")
    protected static void callbackFailure(Callback<JavaScriptObject> callback, JavaScriptObject response){
        callback.failure(response);
    }
    public static native String getApplicationKey() /*-{
        return $wnd.sinchClient.applicationKey;
    }-*/;
}

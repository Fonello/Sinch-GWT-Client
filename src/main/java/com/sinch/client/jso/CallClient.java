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
package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import jsfunction.gwt.functions.NoArgsFunction;

public class CallClient extends JavaScriptObject {
    protected CallClient() {}
    public static native CallClient newInstance() /*-{
        return {};
    }-*/;
    public final native void initStream(NoArgsFunction noArgsFunction) /*-{
        this.initStream.then(noArgsFunction);
    }-*/;
    public final native void callPhoneNumber(String phoneNumber) /*-{
        this.callPhoneNumber(phoneNumber);
    }-*/;
    public final native void addEventListener(CallListenersObject callListeners) /*-{
        this.addEventListener(callListeners);
    }-*/;
    public final native void answer() /*-{
        this.answer();
    }-*/;
    public final native void hangup() /*-{
        this.hangup();
    }-*/;
    public final native JavaScriptObject getIncomingStream() /*-{
        return this.incomingStream;
    }-*/;
    public final native CallDetails getDetails() /*-{
        return this.getDetails();
    }-*/;
}

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

public class SessionObject extends JavaScriptObject {
    protected SessionObject() {}
    public static native SessionObject newInstance() /*-{
        return {};
    }-*/;
    public final native String getUserId() /*-{
        return this.userId;
    }-*/;
    public final native String getSessionId() /*-{
        return this.sessionId;
    }-*/;
    public final native String getSessionSecret() /*-{
        return this.sessionSecret;
    }-*/;
}

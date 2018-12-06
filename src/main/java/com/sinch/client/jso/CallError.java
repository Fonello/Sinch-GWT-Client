package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class CallError extends JavaScriptObject {
    protected CallError() {
    }
    public final native String getMessage() /*-{
        return this.message;
    }-*/;
}

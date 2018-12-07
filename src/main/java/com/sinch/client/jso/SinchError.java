package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class SinchError extends JavaScriptObject {
    protected SinchError() {
    }
    public final native String getName() /*-{
        return this.name;
    }-*/;
    public final native Long getDomain() /*-{
        return this.domain;
    }-*/;
    public final native Long getCode() /*-{
        return this.code;
    }-*/;
    public final native String getResponse() /*-{
        return this.response;
    }-*/;
    public final native String getMessage() /*-{
        return this.message;
    }-*/;
}

package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class CallDetails extends JavaScriptObject {
    protected CallDetails() {
    }
    public final native Long getEstablishedTime() /*-{
        return this.establishedTime;
    }-*/;
    public final native Long getEndedTime() /*-{
        return this.endedTime;
    }-*/;
    public final native Long getDuration() /*-{
        return this.duration;
    }-*/;
    public final native CallError getError() /*-{
        return this.error;
    }-*/;
}

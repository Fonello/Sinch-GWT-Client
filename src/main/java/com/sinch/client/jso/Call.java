package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class Call extends JavaScriptObject {
    protected Call() {
    }
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

package com.sinch.client.jso;

import com.google.gwt.core.client.JavaScriptObject;

public interface Callback<T> {
    void success(T jso);
    void failure(SinchError error);
}

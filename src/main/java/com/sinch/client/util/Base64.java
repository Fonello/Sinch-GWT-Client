package com.sinch.client.util;

public class Base64 {
    public static native String btoa(String decoded) /*-{
        return btoa(decoded);
    }-*/;
    public static native String atob(String encoded) /*-{
        return atob(encoded);
    }-*/;
}

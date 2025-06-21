package com.umeng.commonsdk.vchannel;

/* loaded from: classes19.dex */
public class a {
    public static java.lang.String a = "https://pslog.umeng.com";
    public static java.lang.String b = "https://pslog.umeng.com/";
    public static java.lang.String c = "explog";
    public static final java.lang.String d = "analytics";
    public static final java.lang.String e = "ekv";
    public static final java.lang.String f = "id";
    public static final java.lang.String g = "ts";
    public static final java.lang.String h = "ds";
    public static final java.lang.String i = "pn";
    public static java.lang.String j = "";

    static {
        java.lang.String str = "SUB" + java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(java.lang.String.format("%0" + (32 - str.length()) + "d", 0));
        j = sb.toString();
    }
}

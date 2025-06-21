package com.tencent.open.log;

/* loaded from: classes19.dex */
public class c {
    public static int a = 60;
    public static int b = 60;
    public static java.lang.String c = "OpenSDK.Client.File.Tracer";
    public static java.lang.String d;
    public static java.lang.String e;
    public static long f;
    public static int g;
    public static int h;
    public static int i;
    public static java.lang.String j;
    public static java.lang.String k;
    public static java.lang.String l;
    public static int m;
    public static long n;
    public static java.lang.String o;

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Tencent");
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        d = sb.toString();
        e = com.anythink.china.common.a.a.f;
        f = 8388608L;
        g = 262144;
        h = 1024;
        i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = com.tencent.connect.common.Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}

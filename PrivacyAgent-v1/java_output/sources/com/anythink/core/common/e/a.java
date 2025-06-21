package com.anythink.core.common.e;

/* loaded from: classes12.dex */
public final class a {
    protected static final java.lang.String a = com.anythink.core.common.o.d.b("YXBpLnRoZWJpZGluLmNvbQ==");
    protected static final java.lang.String b = com.anythink.core.common.o.d.b("dGsudGhlYmlkaW4uY29t");
    protected static final java.lang.String c;
    protected static final java.lang.String d;
    protected static final java.lang.String e = "tpnapi-new.moji.com";
    public static final java.lang.String f;
    public static final java.lang.String g;
    public static final java.lang.String h;
    public static final java.lang.String i;
    public static final java.lang.String j;
    public static final java.lang.String k;
    public static final java.lang.String l;
    public static final java.lang.String m;
    public static final java.lang.String n;
    public static final java.lang.String o = "";
    public static final java.lang.String p;
    public static final java.lang.String q;

    static {
        java.lang.String b2 = com.anythink.core.common.o.d.b("ZGEudGhlYmlkaW4uY29t");
        c = b2;
        d = com.anythink.core.common.o.d.b("YWR4LW9zLnRoZWJpZGluLmNvbQ==");
        f = "https://" + a() + "/v2/open/app";
        g = "https://" + a() + "/v2/open/placement";
        java.lang.StringBuilder sb = new java.lang.StringBuilder("https://");
        if (!com.anythink.core.common.e.c.a().b()) {
            b2 = "tpnda-new.moji.com";
        }
        sb.append(b2);
        sb.append("/v1/open/da");
        h = sb.toString();
        i = "https://" + b() + "/v1/open/tk";
        j = "https://" + a() + "/v2/open/eu";
        k = "https://" + d() + "/bid";
        l = "https://" + d() + "/request";
        m = "https://adx" + b() + "/v1";
        n = "https://" + d() + "/openapi/req";
        p = "https://" + b() + "/ss/rrd";
        q = "https://" + a() + "/v2/open/area";
    }

    private static java.lang.String a() {
        return com.anythink.core.common.e.c.a().b() ? a : e;
    }

    private static java.lang.String b() {
        return com.anythink.core.common.e.c.a().b() ? b : "tpntk-new.moji.com";
    }

    private static java.lang.String c() {
        return com.anythink.core.common.e.c.a().b() ? c : "tpnda-new.moji.com";
    }

    private static java.lang.String d() {
        return com.anythink.core.common.e.c.a().b() ? d : "tpnadx-new.moji.com";
    }
}

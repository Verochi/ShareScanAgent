package com.heytap.openid.sdk;

/* loaded from: classes22.dex */
public class OpenIDSDK {
    public static java.lang.String a(android.content.Context context) {
        java.lang.String str;
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getAUID");
        if (!com.heytap.openid.o_a.o_a.a) {
            str = "SDK Need Init First!";
        } else {
            if (com.heytap.openid.o_a.o_a.b) {
                return com.heytap.openid.o_a.o_d.o_a.a.a(com.heytap.openid.o_a.o_a.a(context), "AUID");
            }
            str = "NOT Supported";
        }
        com.heytap.openid.o_a.o_b.b("HeyTapID", str);
        return "";
    }

    public static boolean a() {
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "isSupported");
        if (!com.heytap.openid.o_a.o_a.a) {
            com.heytap.openid.o_a.o_b.b("HeyTapID", "SDK Need Init First!");
        }
        return com.heytap.openid.o_a.o_a.b;
    }

    public static java.lang.String b(android.content.Context context) {
        java.lang.String str;
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getOUID");
        if (!com.heytap.openid.o_a.o_a.a) {
            str = "SDK Need Init First!";
        } else {
            if (com.heytap.openid.o_a.o_a.b) {
                return com.heytap.openid.o_a.o_d.o_a.a.a(com.heytap.openid.o_a.o_a.a(context), "OUID");
            }
            str = "NOT Supported";
        }
        com.heytap.openid.o_a.o_b.b("HeyTapID", str);
        return "";
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String str;
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "getDUID");
        if (!com.heytap.openid.o_a.o_a.a) {
            str = "SDK Need Init First!";
        } else {
            if (com.heytap.openid.o_a.o_a.b) {
                return com.heytap.openid.o_a.o_d.o_a.a.a(com.heytap.openid.o_a.o_a.a(context), "DUID");
            }
            str = "NOT Supported";
        }
        com.heytap.openid.o_a.o_b.b("HeyTapID", str);
        return "";
    }

    public static void d(android.content.Context context) {
        if (com.heytap.openid.o_a.o_a.a) {
            return;
        }
        com.heytap.openid.o_a.o_b.a("OpenIDHelper", "init");
        com.heytap.openid.o_a.o_a.b = com.heytap.openid.o_a.o_d.o_a.a.a(com.heytap.openid.o_a.o_a.a(context));
        com.heytap.openid.o_a.o_a.a = true;
    }
}

package com.bun.miitmdid.b;

/* loaded from: classes.dex */
public class a {
    private static java.lang.String a;

    public static java.lang.String a() {
        if (!android.text.TextUtils.isEmpty(a)) {
            return a;
        }
        java.lang.String str = "miitmdid(sdkv_" + com.bun.lib.sysParamters.f().d() + ")";
        a = str;
        return str;
    }
}

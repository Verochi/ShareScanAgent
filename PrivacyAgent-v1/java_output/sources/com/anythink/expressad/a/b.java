package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public final class b {
    private static java.lang.String a(java.lang.String str) {
        return str;
    }

    private static java.lang.String a(java.lang.String str, java.util.List<java.lang.String> list, java.lang.String str2) {
        if (list != null) {
            for (java.lang.String str3 : list) {
                if (!android.text.TextUtils.isEmpty(str3)) {
                    str = str.replaceAll(str3, str2);
                }
            }
        }
        return str;
    }
}

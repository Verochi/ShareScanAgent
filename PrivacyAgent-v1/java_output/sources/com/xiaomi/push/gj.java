package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class gj {
    public static boolean a(android.content.Context context) {
        java.lang.String str;
        if (context == null) {
            return false;
        }
        com.xiaomi.push.service.co a = com.xiaomi.push.service.cp.a(context);
        if (a != null && !android.text.TextUtils.isEmpty(a.a)) {
            java.lang.String[] split = a.a.split("@");
            if (split.length > 0) {
                str = split[0];
                return android.text.TextUtils.isEmpty(str) && com.xiaomi.push.ez.a() == com.xiaomi.push.jd.a(str.substring(str.length() - 1, str.length()), -1);
            }
        }
        str = null;
        if (android.text.TextUtils.isEmpty(str)) {
        }
    }
}

package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class w {
    private static final java.lang.String a = "StringUtils";

    public static boolean a(java.lang.String str) {
        return str == null || android.text.TextUtils.isEmpty(str.trim()) || com.igexin.push.core.b.m.equals(str);
    }

    public static boolean b(java.lang.String str) {
        return (str == null || android.text.TextUtils.isEmpty(str.trim()) || com.igexin.push.core.b.m.equals(str)) ? false : true;
    }
}

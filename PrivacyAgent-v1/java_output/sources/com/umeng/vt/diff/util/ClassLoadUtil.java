package com.umeng.vt.diff.util;

/* loaded from: classes19.dex */
public class ClassLoadUtil {
    public static java.lang.Class<?> findClass(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return java.lang.Class.forName(str);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}

package com.huawei.hms.opendevice;

/* loaded from: classes22.dex */
public class t {
    public static boolean a(java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}

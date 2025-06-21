package com.huawei.secure.android.common.ssl.util;

/* loaded from: classes22.dex */
public class c {
    public static android.content.Context a;

    public static android.content.Context a() {
        return a;
    }

    public static void a(android.content.Context context) {
        if (context == null || a != null) {
            return;
        }
        a = context.getApplicationContext();
    }
}

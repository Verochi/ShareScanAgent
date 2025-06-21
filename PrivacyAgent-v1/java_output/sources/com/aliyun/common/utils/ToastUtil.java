package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class ToastUtil {
    public static void showToast(android.content.Context context, int i) {
        showToast(context, i, 81, 0);
    }

    public static void showToast(android.content.Context context, int i, int i2, int i3) {
        showToast(context, context.getString(i), i2, 0, 0, i3);
    }

    public static void showToast(android.content.Context context, java.lang.String str) {
        showToast(context, str, 81, 0);
    }

    public static void showToast(android.content.Context context, java.lang.String str, int i, int i2) {
        showToast(context, str, i, 0, 0, i2);
    }

    public static void showToast(android.content.Context context, java.lang.String str, int i, int i2, int i3, int i4) {
        android.widget.Toast.makeText(context, str, i4).show();
    }
}

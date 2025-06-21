package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class s {
    public static float a;

    public static int a(android.content.Context context, float f) {
        if (a == 0.0f) {
            a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((f * a) + 0.5f);
    }
}

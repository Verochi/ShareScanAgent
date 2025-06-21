package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class av extends com.baidu.mobads.sdk.internal.ay.a {
    public static final java.lang.String a = "debug";

    private static void a(int i, java.lang.String str, java.lang.String str2) {
        try {
            if (i == 7) {
                android.util.Log.wtf(str, str2);
            } else {
                android.util.Log.println(i, str, str2);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    @androidx.annotation.NonNull
    public java.lang.String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public void a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(i, str, str2);
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public boolean a(java.lang.String str, int i) {
        return com.baidu.mobads.sdk.internal.ay.a.equals(str);
    }
}

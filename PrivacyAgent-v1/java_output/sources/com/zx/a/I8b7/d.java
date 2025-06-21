package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class d {
    public static android.content.pm.Signature[] a(java.lang.String str) {
        try {
            return com.zx.a.I8b7.i3.a(str, 64).signatures;
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.zx.a.I8b7.r2.a(e);
            return null;
        }
    }
}

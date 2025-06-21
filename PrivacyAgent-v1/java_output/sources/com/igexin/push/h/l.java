package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class l {
    private static android.graphics.Bitmap a(java.lang.String str) {
        if (str != null) {
            try {
                android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str);
                if (decodeFile != null) {
                    return decodeFile;
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        return null;
    }
}

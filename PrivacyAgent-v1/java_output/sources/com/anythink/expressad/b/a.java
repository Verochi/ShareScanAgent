package com.anythink.expressad.b;

/* loaded from: classes12.dex */
public class a {
    private static volatile com.anythink.expressad.b.a a;

    private a() {
    }

    private static com.anythink.expressad.b.a a() {
        if (a == null) {
            synchronized (com.anythink.expressad.b.a.class) {
                if (a == null) {
                    a = new com.anythink.expressad.b.a();
                }
            }
        }
        return a;
    }

    private void a(java.io.File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (java.io.File file2 : file.listFiles()) {
                a(new java.io.File(file2.getAbsolutePath()));
            }
            file.delete();
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            throw new java.io.IOException("zipFilePath or destDirectory is null");
        }
        new com.anythink.expressad.b.c();
        com.anythink.expressad.b.c.a(str, str2);
    }
}

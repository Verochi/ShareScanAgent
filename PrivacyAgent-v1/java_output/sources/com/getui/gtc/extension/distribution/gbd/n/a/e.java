package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class e {
    private static final java.lang.String a = "GBDIOUtil";

    private static void a(android.database.Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    public static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException e) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e);
            }
        }
    }
}

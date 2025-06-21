package com.tramini.plugin.api;

/* loaded from: classes19.dex */
public class TraminiContentProvider extends android.content.ContentProvider {
    public static final java.lang.String TAG = "TraminiContentProvider";

    /* renamed from: com.tramini.plugin.api.TraminiContentProvider$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tramini.plugin.a.b.c.a().a(com.tramini.plugin.api.TraminiContentProvider.this.getContext().getApplicationContext());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.tramini.plugin.api.TraminiContentProvider.AnonymousClass1(), 500L);
        return true;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }
}

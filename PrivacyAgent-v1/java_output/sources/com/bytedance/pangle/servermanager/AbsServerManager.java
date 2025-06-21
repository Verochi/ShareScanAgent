package com.bytedance.pangle.servermanager;

@androidx.annotation.Keep
/* loaded from: classes.dex */
public abstract class AbsServerManager extends android.content.ContentProvider {
    static final java.lang.String BUNDLE_BINDER = "binder";
    static final java.lang.String METHOD_QUERY_BINDER = "query_binder";
    static final java.lang.String PACKAGE_QUERY_BINDER = "package";
    static final java.lang.String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public android.os.Bundle call(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        android.os.IBinder onBind;
        if (!METHOD_QUERY_BINDER.equals(str) || (onBind = onBind(str2)) == null) {
            return null;
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putParcelable(BUNDLE_BINDER, new com.bytedance.pangle.servermanager.a(onBind));
        return bundle2;
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

    public android.os.IBinder onBind(java.lang.String str) {
        str.hashCode();
        if (str.equals("package")) {
            return com.bytedance.pangle.f.a.b();
        }
        if (str.equals("service")) {
            return com.bytedance.pangle.service.a.a.b();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
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

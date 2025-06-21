package com.bytedance.sdk.openadsdk.multipro;

/* loaded from: classes22.dex */
public class TTMultiProvider extends android.content.ContentProvider {
    private com.bytedance.sdk.openadsdk.ITTProvider vw() {
        if (com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager() != null) {
            return (com.bytedance.sdk.openadsdk.ITTProvider) com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager().getExtra(com.bytedance.sdk.openadsdk.ITTProvider.class, null);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        if (vw() != null) {
            return vw().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return vw() != null ? vw().getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        if (vw() != null) {
            return vw().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        if (vw() != null) {
            return vw().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        if (vw() != null) {
            return vw().update(uri, contentValues, str, strArr);
        }
        return 0;
    }
}

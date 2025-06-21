package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface ITTProvider {
    int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr);

    java.lang.String getTableName();

    java.lang.String getType(android.net.Uri uri);

    void init();

    void injectContext(android.content.Context context);

    android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues);

    android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2);

    int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr);
}

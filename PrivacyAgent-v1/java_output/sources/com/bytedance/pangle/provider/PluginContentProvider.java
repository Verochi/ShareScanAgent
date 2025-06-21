package com.bytedance.pangle.provider;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public abstract class PluginContentProvider extends android.content.ContentProvider {
    protected android.net.Uri pluginUri;

    @Override // android.content.ContentProvider
    public abstract int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr);

    @Override // android.content.ContentProvider
    public abstract java.lang.String getType(android.net.Uri uri);

    @Override // android.content.ContentProvider
    public abstract android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues);

    @Override // android.content.ContentProvider
    public abstract android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2);

    @Override // android.content.ContentProvider
    public abstract int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr);
}

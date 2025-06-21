package com.sensorsdata.analytics.android.sdk.data;

/* loaded from: classes19.dex */
public class SensorsDataContentProvider extends android.content.ContentProvider {
    private static final android.content.UriMatcher uriMatcher = new android.content.UriMatcher(-1);
    private com.sensorsdata.analytics.android.sdk.data.SAProviderHelper mProviderHelper;

    @Override // android.content.ContentProvider
    public int bulkInsert(android.net.Uri uri, android.content.ContentValues[] contentValuesArr) {
        try {
            return this.mProviderHelper.bulkInsert(uri, contentValuesArr);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        try {
            int match = uriMatcher.match(uri);
            if (1 == match) {
                return this.mProviderHelper.deleteEvents(str, strArr);
            }
            if (match == 15) {
                return this.mProviderHelper.removeSP(uri.getQueryParameter(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.REMOVE_SP_KEY));
            }
            return 0;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        if (contentValues != null && contentValues.size() != 0) {
            try {
                int match = uriMatcher.match(uri);
                if (match == 1) {
                    return this.mProviderHelper.insertEvent(uri, contentValues);
                }
                if (match == 8) {
                    return this.mProviderHelper.insertChannelPersistent(uri, contentValues);
                }
                this.mProviderHelper.insertPersistent(match, uri, contentValues);
                return uri;
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
        return uri;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        java.lang.String str;
        try {
            android.content.Context context = getContext();
            if (context == null) {
                return true;
            }
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (java.lang.UnsupportedOperationException unused) {
                str = "com.sensorsdata.analytics.android.sdk.test";
            }
            com.sensorsdata.analytics.android.sdk.data.SAProviderHelper sAProviderHelper = com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.getInstance(context);
            this.mProviderHelper = sAProviderHelper;
            sAProviderHelper.appendUri(uriMatcher, str + ".SensorsDataContentProvider");
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        try {
            int match = uriMatcher.match(uri);
            return match == 1 ? this.mProviderHelper.queryByTable("events", strArr, str, strArr2, str2) : match == 8 ? this.mProviderHelper.queryByTable(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_CHANNEL_PERSISTENT, strArr, str, strArr2, str2) : this.mProviderHelper.queryPersistent(match, uri);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }
}

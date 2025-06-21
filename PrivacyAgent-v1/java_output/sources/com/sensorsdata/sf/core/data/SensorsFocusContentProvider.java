package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
public class SensorsFocusContentProvider extends android.content.ContentProvider {
    private static final android.content.UriMatcher uriMatcher = new android.content.UriMatcher(-1);
    private com.sensorsdata.sf.core.data.SFProviderHelper mProviderHelper;

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        try {
            if (uriMatcher.match(uri) != 1) {
                return 0;
            }
            return this.mProviderHelper.deletePlan("plans", str, strArr);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        android.net.Uri insert;
        int match = uriMatcher.match(uri);
        if (match == 2 && "migration_data".equals(uri.getQueryParameter("insert_action"))) {
            this.mProviderHelper.migrationData();
            return uri;
        }
        if (contentValues == null || contentValues.size() == 0) {
            return uri;
        }
        try {
            if (match == 1) {
                insert = this.mProviderHelper.insert("plans", uri, contentValues);
            } else {
                if (match != 2) {
                    if (match != 3) {
                        return null;
                    }
                    this.mProviderHelper.setSPValue(uri.getQueryParameter("sp_parameter_set"), contentValues.getAsString("sp_parameter_set"));
                    return null;
                }
                insert = this.mProviderHelper.insert("users", uri, contentValues);
            }
            return insert;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            android.content.Context context = getContext();
            if (context != null) {
                java.lang.String packageName = context.getApplicationContext().getPackageName();
                this.mProviderHelper = new com.sensorsdata.sf.core.data.SFProviderHelper(new com.sensorsdata.sf.core.data.SensorsFocusDBHelper(context), context);
                android.content.UriMatcher uriMatcher2 = uriMatcher;
                uriMatcher2.addURI(packageName + ".SensorsFocusContentProvider", "plans", 1);
                uriMatcher2.addURI(packageName + ".SensorsFocusContentProvider", "users", 2);
                uriMatcher2.addURI(packageName + ".SensorsFocusContentProvider", "com.sensorsdata.sf.cache", 3);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        android.database.Cursor queryByTable;
        try {
            int match = uriMatcher.match(uri);
            if (match == 1) {
                queryByTable = this.mProviderHelper.queryByTable("plans", strArr, str, strArr2, str2);
            } else if (match == 2) {
                queryByTable = this.mProviderHelper.queryByTable("users", strArr, str, strArr2, str2);
            } else {
                if (match != 3) {
                    return null;
                }
                queryByTable = this.mProviderHelper.getSPValue(uri.getQueryParameter("sp_parameter_get"));
            }
            return queryByTable;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        int update;
        int match = uriMatcher.match(uri);
        int i = -1;
        if (contentValues == null || contentValues.size() == 0) {
            return -1;
        }
        try {
            if (match == 1) {
                update = this.mProviderHelper.update("plans", contentValues, str, strArr);
            } else {
                if (match != 2) {
                    return -1;
                }
                update = this.mProviderHelper.update("users", contentValues, str, strArr);
            }
            i = update;
            return i;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return i;
        }
    }
}

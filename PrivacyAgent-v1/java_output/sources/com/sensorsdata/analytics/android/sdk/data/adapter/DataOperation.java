package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
abstract class DataOperation {
    java.lang.String TAG = "EventDataOperation";
    android.content.ContentResolver contentResolver;
    private final android.content.Context mContext;
    private java.io.File mDatabaseFile;

    public DataOperation(android.content.Context context) {
        this.mContext = context;
        this.contentResolver = context.getContentResolver();
    }

    private boolean belowMemThreshold() {
        if (this.mDatabaseFile == null) {
            this.mDatabaseFile = this.mContext.getDatabasePath(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME);
        }
        return this.mDatabaseFile.exists() && this.mDatabaseFile.length() >= getMaxCacheSize(this.mContext);
    }

    private java.lang.String buildIds(org.json.JSONArray jSONArray) throws org.json.JSONException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                sb.append(jSONArray.get(i));
                sb.append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        sb.append(")");
        return sb.toString();
    }

    private long getMaxCacheSize(android.content.Context context) {
        try {
            return com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance(context).getMaxCacheSize();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return 33554432L;
        }
    }

    public void deleteData(android.net.Uri uri, java.lang.String str) {
        try {
            if ("DB_DELETE_ALL".equals(str)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, "deleteData DB_DELETE_ALL");
                this.contentResolver.delete(uri, null, null);
            } else {
                this.contentResolver.delete(uri, "_id <= ?", new java.lang.String[]{str});
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void deleteData(android.net.Uri uri, org.json.JSONArray jSONArray) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, "deleteData ids = " + jSONArray);
            this.mContext.getContentResolver().delete(uri, "_id in " + buildIds(jSONArray), null);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public int deleteDataLowMemory(android.net.Uri uri) {
        if (belowMemThreshold()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, "There is not enough space left on the device to store events, so will delete 100 oldest events");
            java.lang.String[] queryData = queryData(uri, 100);
            if (queryData == null) {
                return -2;
            }
            deleteData(uri, queryData[0]);
            if (queryDataCount(uri, 2) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    public java.lang.String getFirstRowId(android.net.Uri uri, java.lang.String str) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = this.contentResolver.query(uri, new java.lang.String[]{"_id"}, "is_instant_event=?", new java.lang.String[]{str}, "created_at ASC LIMIT 1");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                if (cursor == null) {
                    return "";
                }
            }
            if (cursor != null) {
                java.lang.String string = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                cursor.close();
                return string;
            }
            if (cursor == null) {
                return "";
            }
            cursor.close();
            return "";
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public abstract int insertData(android.net.Uri uri, android.content.ContentValues contentValues);

    public abstract int insertData(android.net.Uri uri, org.json.JSONObject jSONObject);

    public java.lang.String parseData(java.lang.String str) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("\t");
        if (lastIndexOf > -1) {
            java.lang.String replaceFirst = str.substring(lastIndexOf).replaceFirst("\t", "");
            str = str.substring(0, lastIndexOf);
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(replaceFirst)) {
                if (!replaceFirst.equals(java.lang.String.valueOf(str.hashCode()))) {
                }
            }
            return "";
        }
        return str;
    }

    public abstract java.lang.String[] queryData(android.net.Uri uri, int i);

    public abstract java.lang.String[] queryData(android.net.Uri uri, boolean z, int i);

    public int queryDataCount(android.net.Uri uri, int i) {
        java.lang.String[] strArr = i != 0 ? i != 1 ? null : new java.lang.String[]{"1"} : new java.lang.String[]{"0"};
        return strArr != null ? queryDataCount(uri, new java.lang.String[]{"_id"}, "is_instant_event=?", strArr, null) : queryDataCount(uri, new java.lang.String[]{"_id"}, null, null, null);
    }

    public int queryDataCount(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = this.contentResolver.query(uri, strArr, str, strArr2, str2);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                if (cursor == null) {
                    return 0;
                }
            }
            if (cursor != null) {
                int count = cursor.getCount();
                cursor.close();
                return count;
            }
            if (cursor == null) {
                return 0;
            }
            cursor.close();
            return 0;
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}

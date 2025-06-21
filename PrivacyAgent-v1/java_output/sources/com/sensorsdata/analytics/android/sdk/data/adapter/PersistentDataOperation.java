package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
class PersistentDataOperation extends com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation {
    public PersistentDataOperation(android.content.Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int handleInsertUri(android.net.Uri uri, org.json.JSONObject jSONObject) {
        char c;
        if (uri == null) {
            return -1;
        }
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            java.lang.String path = uri.getPath();
            if (android.text.TextUtils.isEmpty(path)) {
                return 0;
            }
            java.lang.String substring = path.substring(1);
            switch (substring.hashCode()) {
                case -1437430111:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1436067305:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1173524450:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1109940413:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -456824111:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -266152892:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 791585128:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 923005325:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 947194773:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1776312250:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 1964784692:
                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT, java.lang.Integer.valueOf(jSONObject.optInt("value")));
                    break;
                case 1:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA, jSONObject.optString("value"));
                    break;
                case 2:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME, java.lang.Long.valueOf(jSONObject.optLong("value")));
                    break;
                case 3:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME, java.lang.Long.valueOf(jSONObject.optLong("value")));
                    break;
                case 4:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID, jSONObject.optString("value"));
                    break;
                case 5:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, java.lang.Boolean.valueOf(jSONObject.optBoolean("value")));
                    break;
                case 6:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START, java.lang.Boolean.valueOf(jSONObject.optBoolean("value")));
                    break;
                case 7:
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG, jSONObject.optString("value"));
                    break;
                case '\b':
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID, jSONObject.optString("value"));
                    break;
                case '\t':
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, jSONObject.optString("value"));
                    break;
                case '\n':
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, jSONObject.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY));
                    contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE, jSONObject.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE));
                    break;
                default:
                    return -1;
            }
            try {
                this.contentResolver.insert(uri, contentValues);
                return 0;
            } catch (java.lang.Exception e) {
                e = e;
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return 0;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00dd, code lost:
    
        if (r11 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00ef, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ec, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ea, code lost:
    
        if (r11 == null) goto L74;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f3  */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String[] handleQueryUri(android.net.Uri uri) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        char c;
        if (uri == 0) {
            return null;
        }
        java.lang.String path = uri.getPath();
        if (android.text.TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            try {
                java.lang.String substring = path.substring(1);
                cursor = this.contentResolver.query(uri, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToNext();
                            switch (substring.hashCode()) {
                                case -1437430111:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT)) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1436067305:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID)) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1173524450:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME)) {
                                        c = '\t';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1109940413:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START)) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -456824111:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY)) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -266152892:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID)) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 791585128:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME)) {
                                        c = '\n';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 923005325:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA)) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 947194773:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG)) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1776312250:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY)) {
                                        c = '\b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1964784692:
                                    if (substring.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA)) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                case 1:
                                case 2:
                                    java.lang.String[] strArr = {java.lang.String.valueOf(cursor.getInt(0))};
                                    cursor.close();
                                    return strArr;
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case '\b':
                                    java.lang.String[] strArr2 = {cursor.getString(0)};
                                    cursor.close();
                                    return strArr2;
                                case '\t':
                                case '\n':
                                    java.lang.String[] strArr3 = {java.lang.String.valueOf(cursor.getLong(0))};
                                    cursor.close();
                                    return strArr3;
                                default:
                                    cursor.close();
                                    return null;
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (uri != 0) {
                    uri.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            uri = 0;
            if (uri != 0) {
            }
            throw th;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public void deleteData(android.net.Uri uri, java.lang.String str) {
        this.contentResolver.delete(uri.buildUpon().appendQueryParameter(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.REMOVE_SP_KEY, str).build(), null, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public int insertData(android.net.Uri uri, android.content.ContentValues contentValues) {
        this.contentResolver.insert(uri, contentValues);
        return 0;
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public int insertData(android.net.Uri uri, org.json.JSONObject jSONObject) {
        return handleInsertUri(uri, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, int i) {
        return handleQueryUri(uri);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, boolean z, int i) {
        return handleQueryUri(uri);
    }
}

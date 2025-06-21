package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
class EventDataOperation extends com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation {
    public EventDataOperation(android.content.Context context) {
        super(context);
        this.TAG = "EventDataOperation";
    }

    private java.lang.String[] handleBigException(android.net.Uri uri, boolean z) {
        try {
            return queryDataInner(uri, z, 1);
        } catch (android.database.sqlite.SQLiteBlobTooBigException e) {
            deleteData(uri, getFirstRowId(uri, z ? "1" : "0"));
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String[] queryDataInner(android.net.Uri uri, boolean z, int i) {
        android.database.Cursor cursor;
        java.lang.String str;
        java.lang.String str2;
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.lang.String str3 = z ? "1" : "0";
        try {
            cursor = this.contentResolver.query(uri, null, "is_instant_event=?", new java.lang.String[]{str3}, "created_at ASC LIMIT " + i);
            if (cursor != null) {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.lang.String str4 = ",";
                    sb.append("[");
                    while (cursor.moveToNext()) {
                        if (cursor.isLast()) {
                            str4 = "]";
                        }
                        java.lang.String str5 = str4;
                        jSONArray.put(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
                        try {
                            java.lang.String parseData = parseData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
                            if (!android.text.TextUtils.isEmpty(parseData)) {
                                sb.append((java.lang.CharSequence) parseData, 0, parseData.length() - 1);
                                sb.append(",\"_flush_time\":");
                                sb.append(java.lang.System.currentTimeMillis());
                                sb.append(com.alipay.sdk.m.u.i.d);
                                sb.append(str5);
                            }
                        } catch (java.lang.Exception e) {
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        }
                        str4 = str5;
                    }
                    str = sb.toString();
                    try {
                        str2 = jSONArray.length() > 0 ? jSONArray.toString() : null;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        try {
                            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, th.getMessage());
                            if (cursor != null) {
                                cursor.close();
                            }
                            str2 = null;
                            if (str2 != null) {
                            }
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    str = null;
                    com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, th.getMessage());
                    if (cursor != null) {
                    }
                    str2 = null;
                    if (str2 != null) {
                    }
                }
            } else {
                str2 = null;
                str = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
            str = null;
        }
        if (str2 != null) {
            return new java.lang.String[]{str2, str, "1"};
        }
        return null;
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public void deleteData(android.net.Uri uri, java.lang.String str) {
        super.deleteData(uri, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public int insertData(android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return 0;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public int insertData(android.net.Uri uri, org.json.JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            int isInstantEvent = com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils.isInstantEvent(jSONObject);
            android.content.ContentValues contentValues = new android.content.ContentValues();
            java.lang.String jSONObject2 = jSONObject.toString();
            contentValues.put("data", jSONObject2 + "\t" + jSONObject2.hashCode());
            contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT, java.lang.Integer.valueOf(isInstantEvent));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, th.getMessage());
            return 0;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, int i) {
        return queryData(uri, false, i);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, boolean z, int i) {
        try {
            return queryDataInner(uri, z, i);
        } catch (android.database.sqlite.SQLiteBlobTooBigException e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, "Could not pull records for SensorsData out of database events. SQLiteBlobTooBigException ", e);
            return handleBigException(uri, z);
        } catch (android.database.sqlite.SQLiteException e2) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, "Could not pull records for SensorsData out of database events. Waiting to send.", e2);
            return null;
        }
    }
}

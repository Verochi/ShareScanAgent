package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
class EncryptDataOperation extends com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation {
    protected boolean mDbEncrypt;

    public EncryptDataOperation(android.content.Context context) {
        super(context);
        this.mDbEncrypt = true;
    }

    private java.lang.String decryptValue(java.lang.String str) {
        java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_LOAD_EVENT, str);
        return android.text.TextUtils.isEmpty(str2) ? str : str2;
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
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, th.getMessage());
        }
        if (deleteDataLowMemory(uri) != 0) {
            return -2;
        }
        int isInstantEvent = com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils.isInstantEvent(jSONObject);
        org.json.JSONObject jSONObject2 = (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA, jSONObject);
        if (jSONObject2 != null) {
            jSONObject = jSONObject2;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
        contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT, java.lang.Integer.valueOf(isInstantEvent));
        this.contentResolver.insert(uri, contentValues);
        return 0;
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, int i) {
        return queryData(uri, false, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d6  */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String[]] */
    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String[] queryData(android.net.Uri uri, boolean z, int i) {
        android.database.Cursor cursor;
        java.lang.String str;
        android.database.Cursor cursor2;
        java.lang.String str2;
        java.lang.String str3;
        java.util.HashMap hashMap;
        org.json.JSONArray jSONArray;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String string;
        java.lang.String parseData;
        com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation encryptDataOperation = this;
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        org.json.JSONArray jSONArray3 = new org.json.JSONArray();
        java.lang.String str6 = "9";
        try {
            hashMap = new java.util.HashMap();
            jSONArray = new org.json.JSONArray();
            str4 = "1";
            java.lang.String str7 = z ? "1" : "0";
            cursor2 = encryptDataOperation.contentResolver.query(uri, null, "is_instant_event=?", new java.lang.String[]{str7}, "created_at ASC LIMIT " + i);
        } catch (java.lang.Exception e) {
            e = e;
            str = "9";
            encryptDataOperation = null;
            cursor2 = null;
        } catch (java.lang.Throwable th) {
            th = th;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursor2 != null) {
            while (cursor2.moveToNext()) {
                try {
                    try {
                        try {
                            string = cursor2.getString(cursor2.getColumnIndexOrThrow("_id"));
                            parseData = encryptDataOperation.parseData(cursor2.getString(cursor2.getColumnIndexOrThrow("data")));
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            str = str6;
                            str5 = str4;
                        }
                        if (!android.text.TextUtils.isEmpty(parseData)) {
                            if (com.sensorsdata.analytics.android.sdk.util.JSONUtils.isJson(parseData)) {
                                org.json.JSONObject jSONObject = new org.json.JSONObject(parseData);
                                boolean has = jSONObject.has("ekey");
                                if (jSONObject.has("payloads") && !has) {
                                    jSONObject = new org.json.JSONObject(encryptDataOperation.decryptValue(jSONObject.optString("payloads")));
                                }
                                if (has || !encryptDataOperation.mDbEncrypt) {
                                    str = str6;
                                    str5 = str4;
                                } else {
                                    str = str6;
                                    str5 = str4;
                                    try {
                                        org.json.JSONObject jSONObject2 = (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA, jSONObject);
                                        if (jSONObject2 != null) {
                                            jSONObject = jSONObject2;
                                        }
                                    } catch (java.lang.Exception e3) {
                                        e = e3;
                                        try {
                                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                                            encryptDataOperation = this;
                                            str6 = str;
                                            str4 = str5;
                                        } catch (java.lang.Exception e4) {
                                            e = e4;
                                            encryptDataOperation = null;
                                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            str2 = str;
                                            str3 = null;
                                            if (str3 == null) {
                                            }
                                        }
                                    }
                                }
                                if (jSONObject.has("ekey")) {
                                    java.lang.String str8 = jSONObject.getString("ekey") + "$" + jSONObject.getInt("pkv");
                                    if (hashMap.containsKey(str8)) {
                                        ((org.json.JSONArray) hashMap.get(str8)).put(jSONObject.optString("payloads"));
                                    } else {
                                        org.json.JSONArray jSONArray4 = new org.json.JSONArray();
                                        jSONArray4.put(jSONObject.optString("payloads"));
                                        hashMap.put(str8, jSONArray4);
                                    }
                                    jSONArray2.put(string);
                                } else {
                                    jSONObject.put("_flush_time", java.lang.System.currentTimeMillis());
                                    jSONArray.put(jSONObject);
                                    jSONArray3.put(string);
                                }
                                encryptDataOperation = this;
                                str6 = str;
                                str4 = str5;
                            } else {
                                com.sensorsdata.analytics.android.sdk.SALog.i(encryptDataOperation.TAG, "Error is not json data, v = " + parseData);
                            }
                        }
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        str = str6;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            str = str6;
            java.lang.String str9 = str4;
            try {
                if (hashMap.size() > 0) {
                    org.json.JSONArray jSONArray5 = new org.json.JSONArray();
                    for (java.lang.String str10 : hashMap.keySet()) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        jSONObject3.put("ekey", str10.substring(0, str10.indexOf("$")));
                        jSONObject3.put("pkv", java.lang.Integer.valueOf(str10.substring(str10.indexOf("$") + 1)));
                        jSONObject3.put("payloads", hashMap.get(str10));
                        jSONObject3.put("flush_time", java.lang.System.currentTimeMillis());
                        jSONArray5.put(jSONObject3);
                    }
                    ?? jSONArray6 = jSONArray5.toString();
                    str3 = jSONArray2.toString();
                    str2 = str;
                    encryptDataOperation = jSONArray6;
                } else if (jSONArray.length() > 0) {
                    ?? jSONArray7 = jSONArray.toString();
                    str3 = jSONArray3.toString();
                    str2 = str9;
                    encryptDataOperation = jSONArray7;
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
            } catch (java.lang.Exception e6) {
                e = e6;
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                if (cursor2 != null) {
                }
                str2 = str;
                str3 = null;
                if (str3 == null) {
                }
            }
            if (str3 == null) {
                return new java.lang.String[]{str3, encryptDataOperation, str2};
            }
            return null;
        }
        str = "9";
        str2 = str;
        str3 = null;
        encryptDataOperation = null;
        if (cursor2 != null) {
        }
        if (str3 == null) {
        }
    }
}

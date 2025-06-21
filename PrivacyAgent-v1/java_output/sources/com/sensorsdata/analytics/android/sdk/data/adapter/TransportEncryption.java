package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
public class TransportEncryption extends com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation {
    private java.lang.Object mSupportTransport;

    public TransportEncryption(android.content.Context context) {
        super(context);
        this.mSupportTransport = null;
        this.mDbEncrypt = false;
    }

    private java.lang.String encryptValue(java.lang.String str) {
        java.lang.String str2 = isSupportTransport() ? (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_STORE_EVENT, str) : "";
        if (android.text.TextUtils.isEmpty(str2)) {
            return str;
        }
        return "{\"payloads\": \"" + str2 + "\"}";
    }

    private boolean isSupportTransport() {
        if (this.mSupportTransport == null) {
            this.mSupportTransport = com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_VERIFY_SUPPORT_TRANSPORT, new java.lang.Object[0]);
        }
        java.lang.Object obj = this.mSupportTransport;
        return obj != null && ((java.lang.Boolean) obj).booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public /* bridge */ /* synthetic */ void deleteData(android.net.Uri uri, org.json.JSONArray jSONArray) {
        super.deleteData(uri, jSONArray);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation, com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public int insertData(android.net.Uri uri, org.json.JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            int isInstantEvent = com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils.isInstantEvent(jSONObject);
            android.content.ContentValues contentValues = new android.content.ContentValues();
            java.lang.String encryptValue = encryptValue(jSONObject.toString());
            contentValues.put("data", encryptValue + "\t" + encryptValue.hashCode());
            contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT, java.lang.Integer.valueOf(isInstantEvent));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(this.TAG, th.getMessage());
            return 0;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation, com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, int i) {
        return queryData(uri, false, i);
    }

    @Override // com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation, com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation
    public java.lang.String[] queryData(android.net.Uri uri, boolean z, int i) {
        try {
            java.lang.String[] queryData = super.queryData(uri, z, i);
            if (queryData != null && queryData.length >= 3 && "1".equals(queryData[2]) && isSupportTransport()) {
                java.lang.String str = queryData[0];
                java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA, queryData[1]);
                try {
                    if (!android.text.TextUtils.isEmpty(str2) && str2.contains("payloads")) {
                        org.json.JSONArray jSONArray = new org.json.JSONArray();
                        org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                        jSONObject.put("flush_time", java.lang.System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                        return new java.lang.String[]{str, jSONArray.toString(), "13"};
                    }
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            return queryData;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            return null;
        }
    }
}

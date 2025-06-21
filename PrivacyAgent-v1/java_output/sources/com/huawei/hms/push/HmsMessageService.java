package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class HmsMessageService extends android.app.Service {
    public static final java.lang.String PROXY_TYPE = "proxy_type";
    public static final java.lang.String SUBJECT_ID = "subject_id";
    public final android.os.Messenger a = new android.os.Messenger(new com.huawei.hms.push.t(new com.huawei.hms.push.HmsMessageService.a(this, null)));

    public class a implements com.huawei.hms.push.t.a {
        public a() {
        }

        public /* synthetic */ a(com.huawei.hms.push.HmsMessageService hmsMessageService, com.huawei.hms.push.a aVar) {
            this();
        }

        @Override // com.huawei.hms.push.t.a
        public void handleMessage(android.os.Message message) {
            if (message == null) {
                com.huawei.hms.support.log.HMSLog.e("HmsMessageService", "receive message is null");
                return;
            }
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "handle message start...");
            android.os.Bundle data = android.os.Message.obtain(message).getData();
            if (data != null) {
                android.content.Intent intent = new android.content.Intent();
                intent.putExtras(data);
                intent.putExtra(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE, data.getInt(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE, -1));
                com.huawei.hms.push.HmsMessageService.this.handleIntentMessage(intent);
            }
        }
    }

    public final android.os.Bundle a(android.content.Intent intent) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY));
        bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    public final synchronized void a(android.content.Intent intent, android.os.Bundle bundle, java.lang.String str) {
        java.lang.String stringExtra = intent.getStringExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN);
        a(stringExtra, str);
        android.content.Context applicationContext = getApplicationContext();
        boolean z = !android.text.TextUtils.isEmpty(com.huawei.hms.aaid.utils.BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onNewToken to host app.");
            onNewToken(stringExtra);
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] subjectIds = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i = 0; i < subjectIds.length; i++) {
                    android.os.Bundle bundle2 = new android.os.Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i]);
                    com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + subjectIds[i]);
                    onNewToken(stringExtra, bundle2);
                    a(stringExtra, subjectIds[i]);
                }
                com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(applicationContext);
            }
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onNewToken to host app with bundle.");
            bundle.putString("belongId", intent.getStringExtra("belongId"));
            onNewToken(stringExtra, bundle);
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + str);
        onNewToken(stringExtra, bundle);
    }

    public final synchronized void a(android.content.Intent intent, android.os.Bundle bundle, java.lang.String str, int i) {
        android.content.Context applicationContext = getApplicationContext();
        boolean z = !android.text.TextUtils.isEmpty(com.huawei.hms.aaid.utils.BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onTokenError to host app.");
            onTokenError(new com.huawei.hms.push.BaseException(i));
            com.huawei.hms.aaid.utils.BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (android.text.TextUtils.isEmpty(str)) {
            java.lang.String[] subjectIds = com.huawei.hms.aaid.utils.BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i2 = 0; i2 < subjectIds.length; i2++) {
                    android.os.Bundle bundle2 = new android.os.Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i2]);
                    com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + subjectIds[i2]);
                    onTokenError(new com.huawei.hms.push.BaseException(i), bundle2);
                }
                com.huawei.hms.aaid.utils.BaseUtils.clearSubjectIds(applicationContext);
            }
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onTokenError to host app with bundle.");
            onTokenError(new com.huawei.hms.push.BaseException(i), bundle);
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + str);
        onTokenError(new com.huawei.hms.push.BaseException(i), bundle);
    }

    public final void a(android.content.Intent intent, java.lang.String str) {
        com.huawei.hms.aaid.constant.ErrorEnum errorEnum = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS;
        int intExtra = intent.getIntExtra("error", errorEnum.getInternalCode());
        a(com.huawei.hms.support.api.entity.push.PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        java.lang.String stringExtra = intent.getStringExtra("subjectId");
        java.lang.String stringExtra2 = intent.getStringExtra("message_proxy_type");
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        android.os.Bundle bundle = new android.os.Bundle();
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!android.text.TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == errorEnum.getInternalCode()) {
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            a(intent, bundle, stringExtra);
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
        a(intent, bundle, stringExtra, intExtra);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.content.Context applicationContext = getApplicationContext();
        if (str.equals(com.huawei.hms.aaid.utils.BaseUtils.getLocalToken(applicationContext, str2))) {
            com.huawei.hms.aaid.utils.BaseUtils.reportAaidToken(applicationContext, str);
        } else {
            com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
            com.huawei.hms.aaid.utils.BaseUtils.saveToken(applicationContext, str2, str);
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, int i) {
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = com.igexin.push.core.b.m;
        }
        com.huawei.hms.push.utils.PushBiUtil.reportExit(getApplicationContext(), str, str2, i);
    }

    public final void b(android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "parse batch response.");
        java.lang.String stringExtra = intent.getStringExtra("batchMsgbody");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(stringExtra);
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                java.lang.String optString = jSONObject.optString("transactionId");
                java.lang.String optString2 = jSONObject.optString(com.huawei.hms.push.constant.RemoteMessageConst.MSGID);
                int optInt = jSONObject.optInt("ret", com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                if (com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                    b(optString, optString2);
                } else {
                    b(optString, optString2, optInt);
                }
            }
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.w("HmsMessageService", "parse batch response failed.");
        }
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        a(com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG_ASYNC_RSP, str, com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    public final void b(java.lang.String str, java.lang.String str2, int i) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i + ", transactionId: " + str);
        a(com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_MSG_ASYNC_RSP, str, i);
        onSendError(str2, new com.huawei.hms.push.SendException(i));
    }

    public void doMsgReceived(android.content.Intent intent) {
        onMessageReceived(new com.huawei.hms.push.RemoteMessage(a(intent)));
    }

    public void handleIntentMessage(android.content.Intent intent) {
        if (intent == null) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            java.lang.String stringExtra = intent.getStringExtra("message_id");
            java.lang.String stringExtra2 = intent.getStringExtra("message_type");
            java.lang.String stringExtra3 = intent.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID);
            if ("new_token".equals(stringExtra2)) {
                com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "onNewToken");
                a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("onMessageReceived, message id:");
                sb.append(stringExtra);
                com.huawei.hms.support.log.HMSLog.i("HmsMessageService", sb.toString());
                a(com.huawei.hms.support.api.entity.push.PushNaming.RECEIVE_MSG_RSP, stringExtra, com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                b(stringExtra3, stringExtra);
            } else if ("send_error".equals(stringExtra2)) {
                b(stringExtra3, stringExtra, intent.getIntExtra("error", com.huawei.hms.aaid.constant.ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if ("delivery".equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("error", com.huawei.hms.aaid.constant.ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("onMessageDelivery, message id:");
                sb2.append(stringExtra);
                sb2.append(", status:");
                sb2.append(intExtra);
                sb2.append(", transactionId: ");
                sb2.append(stringExtra3);
                com.huawei.hms.support.log.HMSLog.i("HmsMessageService", sb2.toString());
                a(com.huawei.hms.support.api.entity.push.PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new com.huawei.hms.push.SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("delete message, message id:");
                sb3.append(stringExtra);
                com.huawei.hms.support.log.HMSLog.i("HmsMessageService", sb3.toString());
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                b(intent);
            } else {
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("Receive unknown message: ");
                sb4.append(stringExtra2);
                com.huawei.hms.support.log.HMSLog.e("HmsMessageService", sb4.toString());
            }
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessageService", "handle intent RuntimeException: " + e.getMessage());
        } catch (java.lang.Exception e2) {
            com.huawei.hms.support.log.HMSLog.e("HmsMessageService", "handle intent exception: " + e2.getMessage());
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "start to bind");
        return this.a.getBinder();
    }

    public void onDeletedMessages() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(java.lang.String str, java.lang.Exception exc) {
    }

    public void onMessageReceived(com.huawei.hms.push.RemoteMessage remoteMessage) {
    }

    public void onMessageSent(java.lang.String str) {
    }

    public void onNewToken(java.lang.String str) {
    }

    public void onNewToken(java.lang.String str, android.os.Bundle bundle) {
    }

    public void onSendError(java.lang.String str, java.lang.Exception exc) {
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.huawei.hms.support.log.HMSLog.i("HmsMessageService", "start to command , startId = " + i2);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(java.lang.Exception exc) {
    }

    public void onTokenError(java.lang.Exception exc, android.os.Bundle bundle) {
    }
}

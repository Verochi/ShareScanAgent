package com.huawei.hms.support.api.push;

/* loaded from: classes22.dex */
public final class PushReceiver extends android.content.BroadcastReceiver {

    public static class a implements java.lang.Runnable {
        public android.content.Context a;
        public android.content.Intent b;

        public a(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        public /* synthetic */ a(android.content.Context context, android.content.Intent intent, com.huawei.hms.push.f fVar) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.b.getPackage());
            try {
                org.json.JSONObject b = com.huawei.hms.support.api.push.PushReceiver.b(this.b);
                java.lang.String string = com.huawei.hms.push.utils.JsonUtil.getString(b, "moduleName", "");
                int i = com.huawei.hms.push.utils.JsonUtil.getInt(b, com.sensorsdata.sf.ui.view.UIProperty.msgType, 0);
                int i2 = com.huawei.hms.push.utils.JsonUtil.getInt(b, "status", 0);
                if (com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode() != i2) {
                    i2 = com.huawei.hms.aaid.constant.ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                android.os.Bundle bundle = new android.os.Bundle();
                if ("Push".equals(string) && i == 1) {
                    bundle.putString("message_type", "delivery");
                    bundle.putString("message_id", com.huawei.hms.push.utils.JsonUtil.getString(b, com.huawei.hms.push.constant.RemoteMessageConst.MSGID, ""));
                    bundle.putInt("error", i2);
                    bundle.putString(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, com.huawei.hms.push.utils.JsonUtil.getString(b, "transactionId", ""));
                } else {
                    if (this.b.getExtras() != null) {
                        bundle.putAll(this.b.getExtras());
                    }
                    bundle.putString("message_type", "received_message");
                    bundle.putString("message_id", this.b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(com.huawei.hms.push.constant.RemoteMessageConst.MSGBODY, this.b.getByteArrayExtra("msg_data"));
                    bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.w.a(this.b.getByteArrayExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(com.huawei.hms.push.constant.RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.b.getStringExtra("message_proxy_type"));
                }
                if (new com.huawei.hms.push.h().a(this.a, bundle, intent)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("receive ");
                    sb.append(this.b.getAction());
                    sb.append(" and start service success");
                    com.huawei.hms.support.log.HMSLog.i("PushReceiver", sb.toString());
                    return;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("receive ");
                sb2.append(this.b.getAction());
                sb2.append(" and start service failed");
                com.huawei.hms.support.log.HMSLog.e("PushReceiver", sb2.toString());
            } catch (java.lang.RuntimeException unused) {
                com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handle push message occur exception.");
            }
        }
    }

    public static class b implements java.lang.Runnable {
        public android.content.Context a;
        public android.content.Intent b;

        public b(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        public /* synthetic */ b(android.content.Context context, android.content.Intent intent, com.huawei.hms.push.f fVar) {
            this(context, intent);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.b.getByteArrayExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("receive a push token: ");
                    sb.append(this.a.getPackageName());
                    com.huawei.hms.support.log.HMSLog.i("PushReceiver", sb.toString());
                    android.content.Intent intent = new android.content.Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.b.getPackage());
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putString("message_type", "new_token");
                    bundle.putString(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.w.a(byteArrayExtra));
                    bundle.putString(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID, this.b.getStringExtra(com.huawei.hms.adapter.internal.CommonCode.MapKey.TRANSACTION_ID));
                    bundle.putString("subjectId", this.b.getStringExtra("subjectId"));
                    bundle.putInt("error", this.b.getIntExtra("error", com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.b.getStringExtra("belongId"));
                    if (new com.huawei.hms.push.h().a(this.a, bundle, intent)) {
                        return;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("receive ");
                    sb2.append(this.b.getAction());
                    sb2.append(" and start service failed");
                    com.huawei.hms.support.log.HMSLog.e("PushReceiver", sb2.toString());
                    return;
                }
                com.huawei.hms.support.log.HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (java.util.concurrent.RejectedExecutionException unused) {
                com.huawei.hms.support.log.HMSLog.e("PushReceiver", "execute task error");
            } catch (java.lang.Exception unused2) {
                com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handle push token error");
            }
        }
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }

    public static org.json.JSONObject a(byte[] bArr) {
        try {
            return new org.json.JSONObject(com.huawei.hms.push.w.a(bArr));
        } catch (org.json.JSONException unused) {
            com.huawei.hms.support.log.HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static org.json.JSONObject b(android.content.Intent intent) throws java.lang.RuntimeException {
        org.json.JSONObject a2 = a(intent.getByteArrayExtra("msg_data"));
        org.json.JSONObject a3 = a(a2);
        java.lang.String string = com.huawei.hms.push.utils.JsonUtil.getString(a3, "data", null);
        if (com.huawei.hms.push.s.a(a3, b(a3), string)) {
            return a2;
        }
        if (android.text.TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new org.json.JSONObject(string);
        } catch (org.json.JSONException unused) {
            return null;
        }
    }

    public static org.json.JSONObject b(org.json.JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public final void a(android.content.Context context, android.content.Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                com.huawei.hms.push.v.a().execute(new com.huawei.hms.support.api.push.PushReceiver.a(context, intent, null));
            } else {
                com.huawei.hms.support.log.HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (java.lang.RuntimeException unused) {
            com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    public final void b(android.content.Context context, android.content.Intent intent) {
        try {
            if (intent.hasExtra(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN)) {
                com.huawei.hms.push.v.a().execute(new com.huawei.hms.support.api.push.PushReceiver.b(context, intent, null));
            } else {
                com.huawei.hms.support.log.HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (java.lang.RuntimeException unused) {
            com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (java.lang.Exception unused2) {
            com.huawei.hms.support.log.HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            java.lang.String action = intent.getAction();
            if (com.huawei.hms.utils.ResourceLoaderUtil.getmContext() == null) {
                com.huawei.hms.utils.ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                b(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                a(context, intent);
            } else {
                com.huawei.hms.support.log.HMSLog.i("PushReceiver", "message can't be recognised.");
            }
        } catch (java.lang.Exception unused) {
            com.huawei.hms.support.log.HMSLog.e("PushReceiver", "intent has some error");
        }
    }
}

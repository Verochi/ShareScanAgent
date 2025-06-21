package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public abstract class a<T> implements com.meizu.cloud.pushsdk.handler.c {
    private com.meizu.cloud.pushsdk.handler.a a;
    private android.content.Context b;
    private android.util.SparseArray<java.lang.String> c;

    public a(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("Context must not be null.");
        }
        this.b = context.getApplicationContext();
        this.a = aVar;
        android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>();
        this.c = sparseArray;
        sparseArray.put(2, "MESSAGE_TYPE_PUSH_SERVICE_V2");
        this.c.put(4, "MESSAGE_TYPE_PUSH_SERVICE_V3");
        this.c.put(16, "MESSAGE_TYPE_REGISTER");
        this.c.put(32, "MESSAGE_TYPE_UNREGISTER");
        this.c.put(8, "MESSAGE_TYPE_THROUGH");
        this.c.put(64, "MESSAGE_TYPE_NOTIFICATION_CLICK");
        this.c.put(128, "MESSAGE_TYPE_NOTIFICATION_DELETE");
        this.c.put(256, "MESSAGE_TYPE_PUSH_SWITCH_STATUS");
        this.c.put(512, "MESSAGE_TYPE_PUSH_REGISTER_STATUS");
        this.c.put(2048, "MESSAGE_TYPE_PUSH_SUBTAGS_STATUS");
        this.c.put(1024, "MESSAGE_TYPE_PUSH_UNREGISTER_STATUS");
        this.c.put(4096, "MESSAGE_TYPE_PUSH_SUBALIAS_STATUS");
        this.c.put(8192, "MESSAGE_TYPE_SCHEDULE_NOTIFICATION");
        this.c.put(16384, "MESSAGE_TYPE_RECEIVE_NOTIFY_MESSAGE");
        this.c.put(32768, "MESSAGE_TYPE_NOTIFICATION_STATE");
        this.c.put(65536, "MESSAGE_TYPE_UPLOAD_FILE_LOG");
        this.c.put(131072, "MESSAGE_TYPE_NOTIFICATION_ARRIVED");
        this.c.put(262144, "MESSAGE_TYPE_NOTIFICATION_WITHDRAW");
        this.c.put(524288, "MESSAGE_TYPE_BRIGHT_NOTIFICATION");
        this.c.put(1048576, "MESSAGE_TYPE_NOTIFICATION_CLOSE");
    }

    private java.lang.String a(int i) {
        return this.c.get(i);
    }

    private boolean a(java.lang.String str, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str2) {
        java.lang.String str3;
        if (!android.text.TextUtils.isEmpty(str)) {
            str3 = "sa, public key not empty";
        } else if (!com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(str2)) {
            str3 = "sa, message not click method";
        } else {
            if (com.meizu.cloud.pushsdk.util.b.l(d(), messageV3.getPackageName())) {
                com.meizu.cloud.pushsdk.util.b.c(d(), messageV3.getPackageName(), false);
                return true;
            }
            str3 = "sa, not first request";
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", str3);
        return false;
    }

    private boolean b(java.lang.String str, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "security check fail, public key is null");
            return false;
        }
        java.lang.String a = com.meizu.cloud.pushsdk.util.c.a(str, str2);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "decrypt sign: " + a);
        boolean a2 = com.meizu.cloud.pushsdk.handler.a.c.e.a(a, messageV3);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "check public key result: " + a2);
        return a2;
    }

    private java.lang.String e() {
        java.lang.String str = null;
        for (int i = 0; i < 2; i++) {
            str = b();
            if (!android.text.TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public com.meizu.cloud.pushsdk.notification.c a(T t) {
        return null;
    }

    public void a(android.content.Context context, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.handler.a.a.a b;
        com.meizu.cloud.pushsdk.notification.model.a a;
        if (messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage()) || (b = com.meizu.cloud.pushsdk.b.a(context).b()) == null || (a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3)) == null) {
            return;
        }
        b.a(a.a());
    }

    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3 == null || messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdPackage())) {
            if (!com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon()) {
                c().b(d(), com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3));
                return;
            }
            if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isRunningProcess(d(), messageV3.getUploadDataPackageName())) {
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "send notification arrived message to " + messageV3.getUploadDataPackageName());
                android.content.Intent intent = new android.content.Intent();
                if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportTransmitMessageValue(this.b, messageV3.getUploadDataPackageName())) {
                    intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE, com.meizu.cloud.pushsdk.handler.d.a(messageV3));
                } else {
                    intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE, messageV3);
                }
                intent.putExtra("method", "notification_arrived");
                com.meizu.cloud.pushsdk.util.MzSystemUtils.sendMessageFromBroadcast(d(), intent, com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION, messageV3.getUploadDataPackageName());
            }
        }
    }

    public abstract void a(T t, com.meizu.cloud.pushsdk.notification.c cVar);

    public boolean a(int i, java.lang.String str) {
        boolean z;
        if (i == 0) {
            z = com.meizu.cloud.pushsdk.util.b.e(d(), str);
        } else {
            z = true;
            if (i == 1) {
                z = com.meizu.cloud.pushsdk.util.b.h(d(), str);
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(i == 0 ? " canNotificationMessage " : " canThroughMessage ");
        sb.append(z);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", sb.toString());
        return z;
    }

    public final boolean a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str) {
        java.lang.String a = com.meizu.cloud.pushsdk.handler.a.c.e.a(messageV3);
        if (android.text.TextUtils.isEmpty(a)) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "message does not contain signature field");
            return false;
        }
        java.lang.String k = com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName());
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "local public key is: " + k);
        if (a(k, messageV3, str)) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "message special approval no check");
            return true;
        }
        if (b(k, messageV3, a)) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "security check passed");
            return true;
        }
        java.lang.String e = e();
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "network request public key: " + e);
        if (!b(e, messageV3, a)) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "security check fail");
            return false;
        }
        com.meizu.cloud.pushsdk.util.b.k(d(), messageV3.getPackageName(), e);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "security check passed");
        return true;
    }

    public boolean a(T t, java.lang.String str) {
        return true;
    }

    public boolean a(java.lang.String str) {
        try {
            return d().getPackageName().equals(new org.json.JSONObject(str).getString(com.anythink.expressad.videocommon.e.b.u));
        } catch (java.lang.Exception unused) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "parse notification error");
            return false;
        }
    }

    public java.lang.String b() {
        return new com.meizu.cloud.pushsdk.handler.a.c.e.a((java.lang.String) com.meizu.cloud.pushsdk.c.a.a(com.meizu.cloud.pushsdk.constants.PushConstants.GET_PUBLIC_KEY).a().a().a()).a();
    }

    public java.lang.String b(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject(com.anythink.expressad.d.a.b.bU);
            return (!jSONObject.has("pkg") || android.text.TextUtils.isEmpty(jSONObject.getString("pkg"))) ? "" : jSONObject.getString("pkg");
        } catch (java.lang.Exception unused) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "parse desk top json error");
            return "";
        }
    }

    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (!com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportSetDrawableSmallIcon()) {
            c(messageV3);
            return;
        }
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "delete notifyId " + a.a() + " notifyKey " + a.b());
            if (android.text.TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void b(T t) {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a7 A[ADDED_TO_REGION] */
    @Override // com.meizu.cloud.pushsdk.handler.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(android.content.Intent intent) {
        java.lang.String str;
        java.lang.String str2;
        boolean z = false;
        if (!a(intent)) {
            return false;
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "current message Type " + a(a()));
        T c = c(intent);
        if (!a((com.meizu.cloud.pushsdk.handler.a.a<T>) c, k(intent))) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "invalid push message");
            return false;
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "current Handler message " + c);
        b((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
        int d = d((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
        boolean z2 = true;
        if (d != 0) {
            if (d != 1) {
                if (d != 2) {
                    if (d == 3) {
                        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "schedule notification");
                        e((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                    } else {
                        if (d != 4) {
                            str2 = d == 5 ? "ad cannot show message" : "expire notification, don't show message";
                            z2 = false;
                            boolean g = g((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "can send message " + g);
                            if (z && z2 && g) {
                                a((com.meizu.cloud.pushsdk.handler.a.a<T>) c, a((com.meizu.cloud.pushsdk.handler.a.a<T>) c));
                                c((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "send message end ");
                            }
                            return z;
                        }
                        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "bright notification");
                        f((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                    }
                    z = true;
                    z2 = false;
                    boolean g2 = g((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "can send message " + g2);
                    if (z) {
                        a((com.meizu.cloud.pushsdk.handler.a.a<T>) c, a((com.meizu.cloud.pushsdk.handler.a.a<T>) c));
                        c((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
                        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "send message end ");
                    }
                    return z;
                }
                str = "notification on time ,show message";
            }
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", str2);
            z2 = false;
            boolean g22 = g((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "can send message " + g22);
            if (z) {
            }
            return z;
        }
        str = "schedule send message off, send message directly";
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", str);
        z = true;
        boolean g222 = g((com.meizu.cloud.pushsdk.handler.a.a<T>) c);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "can send message " + g222);
        if (z) {
        }
        return z;
    }

    public com.meizu.cloud.pushsdk.handler.a c() {
        return this.a;
    }

    public abstract T c(android.content.Intent intent);

    public void c(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.a a = com.meizu.cloud.pushsdk.notification.model.a.a(messageV3);
        if (a != null) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "delete notifyKey " + a.b() + " notifyId " + a.a());
            if (android.text.TextUtils.isEmpty(a.b())) {
                com.meizu.cloud.pushsdk.notification.c.b.c(d(), messageV3.getUploadDataPackageName(), a.a());
            } else {
                com.meizu.cloud.pushsdk.notification.c.b.a(d(), messageV3.getUploadDataPackageName(), a.b());
            }
        }
    }

    public void c(T t) {
    }

    public int d(T t) {
        return 0;
    }

    public android.content.Context d() {
        return this.b;
    }

    public java.lang.String d(android.content.Intent intent) {
        java.lang.String stringExtra = intent != null ? intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY) : null;
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        java.lang.String a = com.meizu.cloud.pushsdk.b.c.a(d());
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "force get deviceId " + a);
        return a;
    }

    public java.lang.String e(android.content.Intent intent) {
        return intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_TASK_ID);
    }

    public void e(T t) {
    }

    public java.lang.String f(android.content.Intent intent) {
        return intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SEQ_ID);
    }

    public void f(T t) {
    }

    public java.lang.String g(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SERVICE_DEFAULT_PACKAGE_NAME);
        return android.text.TextUtils.isEmpty(stringExtra) ? d().getPackageName() : stringExtra;
    }

    public boolean g(T t) {
        return true;
    }

    public java.lang.String h(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_TASK_TIMES_TAMP);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "receive push timestamp from pushservice " + stringExtra);
        return android.text.TextUtils.isEmpty(stringExtra) ? java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000) : stringExtra;
    }

    public boolean i(android.content.Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_WHITE_LIST, false);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "receive push whiteList from pushservice " + booleanExtra);
        return booleanExtra;
    }

    public long j(android.content.Intent intent) {
        long longExtra = intent.getLongExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "receive push delayedReportMillis from pushservice " + longExtra);
        return longExtra;
    }

    public java.lang.String k(android.content.Intent intent) {
        return intent.getStringExtra("method");
    }
}

package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public abstract class MiPushClient {
    public static final java.lang.String COMMAND_REGISTER = "register";
    public static final java.lang.String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final java.lang.String COMMAND_SET_ACCOUNT = "set-account";
    public static final java.lang.String COMMAND_SET_ALIAS = "set-alias";
    public static final java.lang.String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final java.lang.String COMMAND_UNREGISTER = "unregister";
    public static final java.lang.String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final java.lang.String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final java.lang.String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final java.lang.String PREF_EXTRA = "mipush_extra";
    private static android.content.Context sContext;
    private static long sCurMsgId = java.lang.System.currentTimeMillis();

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$1, reason: invalid class name */
    final class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$alias;
        final /* synthetic */ java.lang.String val$appID;
        final /* synthetic */ java.lang.String val$appToken;
        final /* synthetic */ com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult val$iCallbackResult;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult iCallbackResult) {
            this.val$appID = str;
            this.val$appToken = str2;
            this.val$alias = str3;
            this.val$iCallbackResult = iCallbackResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.xiaomi.mipush.sdk.MiPushClient.initialize(com.xiaomi.mipush.sdk.MiPushClient.sContext, this.val$appID, this.val$appToken, null, this.val$alias, this.val$iCallbackResult);
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$2, reason: invalid class name */
    final class AnonymousClass2 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            com.xiaomi.push.cr a = com.xiaomi.push.cr.a(com.xiaomi.mipush.sdk.MiPushClient.sContext);
            com.xiaomi.push.m.a(a.a).a(new com.xiaomi.push.cs(a), 0);
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$3, reason: invalid class name */
    final class AnonymousClass3 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            if (com.xiaomi.push.iu.f()) {
                return;
            }
            if (com.xiaomi.push.ib.c(com.xiaomi.mipush.sdk.MiPushClient.sContext) != null || com.xiaomi.push.aa.a(com.xiaomi.mipush.sdk.MiPushClient.sContext).a()) {
                com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
                hkVar.d = com.xiaomi.mipush.sdk.b.m126a(com.xiaomi.mipush.sdk.MiPushClient.sContext).m127a();
                hkVar.e = com.xiaomi.push.gu.ClientInfoUpdate.ah;
                hkVar.c = com.xiaomi.push.service.ag.a();
                hkVar.h = new java.util.HashMap();
                java.lang.String c = com.xiaomi.push.ib.c(com.xiaomi.mipush.sdk.MiPushClient.sContext);
                java.lang.String str = "";
                if (!android.text.TextUtils.isEmpty(c)) {
                    str = "" + com.xiaomi.push.ao.a(c);
                }
                java.lang.String e = com.xiaomi.push.ib.e(com.xiaomi.mipush.sdk.MiPushClient.sContext);
                if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(e)) {
                    str = str + "," + e;
                }
                if (!android.text.TextUtils.isEmpty(str)) {
                    hkVar.h.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_IMEI_MD5, str);
                }
                com.xiaomi.push.aa.a(com.xiaomi.mipush.sdk.MiPushClient.sContext).a(hkVar.h);
                int a = com.xiaomi.push.ib.a();
                if (a >= 0) {
                    hkVar.h.put("space_id", java.lang.Integer.toString(a));
                }
                com.xiaomi.mipush.sdk.ao.a(com.xiaomi.mipush.sdk.MiPushClient.sContext).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
            }
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$4, reason: invalid class name */
    final class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;
        final /* synthetic */ java.lang.String[] val$packageNames;

        public AnonymousClass4(java.lang.String[] strArr, android.content.Context context) {
            this.val$packageNames = strArr;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.content.pm.PackageInfo packageInfo;
            try {
                for (java.lang.String str : this.val$packageNames) {
                    if (!android.text.TextUtils.isEmpty(str) && (packageInfo = this.val$context.getPackageManager().getPackageInfo(str, 4)) != null) {
                        com.xiaomi.mipush.sdk.MiPushClient.awakePushServiceByPackageInfo(this.val$context, packageInfo);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
            }
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$5, reason: invalid class name */
    final class AnonymousClass5 implements com.xiaomi.push.Cdo.a {
        @Override // com.xiaomi.push.Cdo.a
        public final void uploader(android.content.Context context, com.xiaomi.push.go goVar) {
            com.xiaomi.mipush.sdk.MiTinyDataClient.upload(context, goVar);
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$6, reason: invalid class name */
    final class AnonymousClass6 extends com.xiaomi.push.service.ad.a {
        final /* synthetic */ android.content.Context val$context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(int i, java.lang.String str, android.content.Context context) {
            super(i, str);
            this.val$context = context;
        }

        @Override // com.xiaomi.push.service.ad.a
        public final void onCallback() {
            com.xiaomi.push.Cdo.a(this.val$context);
        }
    }

    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @java.lang.Deprecated
    public static abstract class MiPushClientCallback {
        private java.lang.String category;

        public java.lang.String getCategory() {
            return this.category;
        }

        public void onCommandResult(java.lang.String str, long j, java.lang.String str2, java.util.List<java.lang.String> list) {
        }

        public void onInitializeResult(long j, java.lang.String str, java.lang.String str2) {
        }

        public void onReceiveMessage(com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        }

        public void onSubscribeResult(long j, java.lang.String str, java.lang.String str2) {
        }

        public void onUnsubscribeResult(long j, java.lang.String str, java.lang.String str2) {
        }

        public void setCategory(java.lang.String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        private java.lang.String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public java.lang.String getToken() {
            return this.token;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public void setToken(java.lang.String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult<com.xiaomi.mipush.sdk.MiPushClient.TokenResult> {
    }

    public interface UPSTurnCallBack extends com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult<com.xiaomi.mipush.sdk.MiPushClient.CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult<com.xiaomi.mipush.sdk.MiPushClient.TokenResult> {
    }

    private static boolean acceptTimeSet(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.equals(getAcceptTime(context), str + "," + str2);
    }

    public static long accountSetTime(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_".concat(java.lang.String.valueOf(str)), -1L);
    }

    public static synchronized void addAcceptTime(android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            edit.apply();
        }
    }

    public static synchronized void addAccount(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void addAlias(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(android.content.Context context) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", java.lang.System.currentTimeMillis());
        edit.apply();
    }

    private static void addRegRequestTime(android.content.Context context) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", java.lang.System.currentTimeMillis());
        edit.apply();
    }

    public static synchronized void addTopic(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_".concat(java.lang.String.valueOf(str)), java.lang.System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_".concat(java.lang.String.valueOf(str)), -1L);
    }

    public static void awakeApps(android.content.Context context, java.lang.String[] strArr) {
        com.xiaomi.push.m.a(context).a(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass4(strArr, context), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void awakePushServiceByPackageInfo(android.content.Context context, android.content.pm.PackageInfo packageInfo) {
        android.content.pm.ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        java.lang.Thread.sleep(((long) ((java.lang.Math.random() * 2.0d) + 1.0d)) * 1000);
                        android.content.Intent intent = new android.content.Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        com.xiaomi.mipush.sdk.PushMessageHandler.a(context, intent);
                        return;
                    } catch (java.lang.Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(java.lang.Object obj, java.lang.String str) {
        if (obj != null) {
            return;
        }
        throw new java.lang.IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void clearExtras(android.content.Context context) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(android.content.Context context) {
        android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        java.util.Iterator<java.lang.String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_".concat(java.lang.String.valueOf(it.next())));
        }
        java.util.Iterator<java.lang.String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_".concat(java.lang.String.valueOf(it2.next())));
        }
        java.util.Iterator<java.lang.String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_".concat(java.lang.String.valueOf(it3.next())));
        }
        edit.remove(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).f();
    }

    public static void clearNotification(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a(-1);
    }

    public static void clearNotification(android.content.Context context, int i) {
        com.xiaomi.mipush.sdk.ao.a(context).a(i);
    }

    public static void clearNotification(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.xiaomi.mipush.sdk.ao.a(context).a(str, str2);
    }

    public static void disablePush(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a(true);
    }

    public static void enablePush(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a(false);
    }

    public static java.lang.String getAcceptTime(android.content.Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static java.util.List<java.lang.String> getAllAlias(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getAllTopic(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static java.util.List<java.lang.String> getAllUserAccount(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static java.lang.String getAppRegion(android.content.Context context) {
        if (com.xiaomi.mipush.sdk.b.m126a(context).m135c()) {
            return com.xiaomi.mipush.sdk.b.m126a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return com.xiaomi.push.iu.b();
    }

    public static boolean getOpenFCMPush(android.content.Context context) {
        checkNotNull(context, "context");
        return com.xiaomi.mipush.sdk.f.a(context).b(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(android.content.Context context) {
        checkNotNull(context, "context");
        return com.xiaomi.mipush.sdk.f.a(context).b(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(android.content.Context context) {
        checkNotNull(context, "context");
        return com.xiaomi.mipush.sdk.f.a(context).b(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(android.content.Context context) {
        return com.xiaomi.mipush.sdk.f.a(context).b(com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS);
    }

    public static java.lang.String getRegId(android.content.Context context) {
        if (com.xiaomi.mipush.sdk.b.m126a(context).m135c()) {
            return com.xiaomi.mipush.sdk.b.m126a(context).m134c();
        }
        return null;
    }

    private static void initEventPerfLogic(android.content.Context context) {
        com.xiaomi.push.Cdo.a(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass5());
        com.xiaomi.a.a.a b = com.xiaomi.push.Cdo.b(context);
        com.xiaomi.a.b.b.a(context).f = "4_9_0";
        com.xiaomi.a.b.a.a(context, b, new com.xiaomi.push.dm(context), new com.xiaomi.push.dn(context));
        com.xiaomi.mipush.sdk.a.a(context);
        com.xiaomi.mipush.sdk.t.a(context, b);
        com.xiaomi.push.service.ad.a(context).a(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass6(100, "perf event job update", context));
    }

    @java.lang.Deprecated
    public static void initialize(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initialize(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback miPushClientCallback, java.lang.String str3, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.channel.commonutils.logger.b.a(context.getApplicationContext());
            com.xiaomi.channel.commonutils.logger.b.f("sdk_version = 4_9_0");
            com.xiaomi.push.aa.a(context);
            com.xiaomi.push.ce.a();
            if (miPushClientCallback != null) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(iCallbackResult);
            }
            if (com.xiaomi.push.jc.b(sContext)) {
                com.xiaomi.mipush.sdk.v.a(sContext);
            }
            boolean z = com.xiaomi.mipush.sdk.b.m126a(sContext).a() != com.xiaomi.mipush.sdk.Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                com.xiaomi.mipush.sdk.ao.a(sContext).m117a();
                com.xiaomi.channel.commonutils.logger.b.a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !com.xiaomi.mipush.sdk.b.m126a(sContext).a(str, str2) || com.xiaomi.mipush.sdk.b.m126a(sContext).m138f()) {
                java.lang.String a = com.xiaomi.push.ao.a(6);
                com.xiaomi.mipush.sdk.b.m126a(sContext).m128a();
                com.xiaomi.mipush.sdk.b.m126a(sContext).a(com.xiaomi.mipush.sdk.Constants.a());
                com.xiaomi.mipush.sdk.b.m126a(sContext).a(str, str2, a);
                com.xiaomi.mipush.sdk.MiTinyDataClient.a.a().b(com.xiaomi.mipush.sdk.MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                com.xiaomi.push.hl hlVar = new com.xiaomi.push.hl();
                hlVar.c = com.xiaomi.push.service.ag.a();
                hlVar.d = str;
                hlVar.g = str2;
                hlVar.f = sContext.getPackageName();
                hlVar.h = a;
                android.content.Context context2 = sContext;
                hlVar.e = com.xiaomi.push.ga.a(context2, context2.getPackageName());
                android.content.Context context3 = sContext;
                hlVar.a(com.xiaomi.push.ga.b(context3, context3.getPackageName()));
                hlVar.l = "4_9_0";
                hlVar.a();
                hlVar.t = com.xiaomi.push.gy.Init;
                if (!android.text.TextUtils.isEmpty(str3)) {
                    hlVar.i = str3;
                }
                if (!com.xiaomi.push.iu.f()) {
                    java.lang.String d = com.xiaomi.push.ib.d(sContext);
                    if (!android.text.TextUtils.isEmpty(d)) {
                        hlVar.r = com.xiaomi.push.ao.a(d) + "," + com.xiaomi.push.ib.f(sContext);
                    }
                }
                int a2 = com.xiaomi.push.ib.a();
                if (a2 >= 0) {
                    hlVar.b(a2);
                }
                com.xiaomi.mipush.sdk.ao.a(sContext).a(hlVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, com.xiaomi.mipush.sdk.b.m126a(sContext).m134c());
                } else {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    arrayList.add(com.xiaomi.mipush.sdk.b.m126a(sContext).m134c());
                    com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(sContext, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_REGISTER.k, arrayList, 0L, null, null, null));
                }
                com.xiaomi.mipush.sdk.ao.a(sContext).m117a();
                if (com.xiaomi.mipush.sdk.b.m126a(sContext).m130a()) {
                    com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
                    hkVar.d = com.xiaomi.mipush.sdk.b.m126a(sContext).m127a();
                    hkVar.e = com.xiaomi.push.gu.ClientInfoUpdate.ah;
                    hkVar.c = com.xiaomi.push.service.ag.a();
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hkVar.h = hashMap;
                    android.content.Context context4 = sContext;
                    hashMap.put("app_version", com.xiaomi.push.ga.a(context4, context4.getPackageName()));
                    java.util.Map<java.lang.String, java.lang.String> map = hkVar.h;
                    android.content.Context context5 = sContext;
                    map.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, java.lang.Integer.toString(com.xiaomi.push.ga.b(context5, context5.getPackageName())));
                    hkVar.h.put("push_sdk_vn", "4_9_0");
                    hkVar.h.put("push_sdk_vc", java.lang.Integer.toString(40090));
                    java.lang.String e = com.xiaomi.mipush.sdk.b.m126a(sContext).e();
                    if (!android.text.TextUtils.isEmpty(e)) {
                        hkVar.h.put("deviceid", e);
                    }
                    com.xiaomi.mipush.sdk.ao.a(sContext).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null);
                }
                if (!android.preference.PreferenceManager.getDefaultSharedPreferences(sContext).getBoolean("update_devId", false)) {
                    updateImeiOrOaid();
                    android.preference.PreferenceManager.getDefaultSharedPreferences(sContext).edit().putBoolean("update_devId", true).commit();
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    com.xiaomi.push.hk hkVar2 = new com.xiaomi.push.hk();
                    hkVar2.d = com.xiaomi.mipush.sdk.b.m126a(sContext).m127a();
                    hkVar2.e = com.xiaomi.push.gu.PullOfflineMessage.ah;
                    hkVar2.c = com.xiaomi.push.service.ag.a();
                    hkVar2.a(false);
                    com.xiaomi.mipush.sdk.ao.a(sContext).a((com.xiaomi.mipush.sdk.ao) hkVar2, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            com.xiaomi.mipush.sdk.av.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (com.xiaomi.mipush.sdk.Logger.getUserLogger() != null) {
                    com.xiaomi.mipush.sdk.Logger.setLogger(sContext, com.xiaomi.mipush.sdk.Logger.getUserLogger());
                }
                com.xiaomi.channel.commonutils.logger.b.a();
            }
            operateSyncAction(context);
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    private static void operateSyncAction(android.content.Context context) {
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(sContext).a(com.xiaomi.mipush.sdk.au.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(android.content.Context context, java.lang.String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(android.content.Context context, com.xiaomi.push.gy gyVar) {
        com.xiaomi.channel.commonutils.logger.b.f("re-register reason: ".concat(java.lang.String.valueOf(gyVar)));
        java.lang.String a = com.xiaomi.push.ao.a(6);
        java.lang.String m127a = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        java.lang.String b = com.xiaomi.mipush.sdk.b.m126a(context).b();
        com.xiaomi.mipush.sdk.b.m126a(context).m128a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        com.xiaomi.mipush.sdk.b.m126a(context).a(com.xiaomi.mipush.sdk.Constants.a());
        com.xiaomi.mipush.sdk.b.m126a(context).a(m127a, b, a);
        com.xiaomi.push.hl hlVar = new com.xiaomi.push.hl();
        hlVar.c = com.xiaomi.push.service.ag.a();
        hlVar.d = m127a;
        hlVar.g = b;
        hlVar.h = a;
        hlVar.f = context.getPackageName();
        hlVar.e = com.xiaomi.push.ga.a(context, context.getPackageName());
        hlVar.a(com.xiaomi.push.ga.b(context, context.getPackageName()));
        hlVar.l = "4_9_0";
        hlVar.a();
        hlVar.t = gyVar;
        int a2 = com.xiaomi.push.ib.a();
        if (a2 >= 0) {
            hlVar.b(a2);
        }
        com.xiaomi.mipush.sdk.ao.a(context).a(hlVar, false);
    }

    @java.lang.Deprecated
    public static void registerCrashHandler(java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        java.lang.Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(android.content.Context context) {
        try {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            com.xiaomi.push.iw.a(context.getApplicationContext(), new com.xiaomi.push.service.receivers.NetworkStatusReceiver(null), intentFilter);
            com.xiaomi.push.iw.a(context, com.xiaomi.push.service.receivers.NetworkStatusReceiver.class);
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("dynamic register network status receiver failed:".concat(java.lang.String.valueOf(th)));
        }
    }

    public static void registerPush(android.content.Context context, java.lang.String str, java.lang.String str2) {
        registerPush(context, str, str2, new com.xiaomi.mipush.sdk.PushConfiguration());
    }

    public static void registerPush(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(android.content.Context context, java.lang.String str, java.lang.String str2, com.xiaomi.mipush.sdk.PushConfiguration pushConfiguration, java.lang.String str3, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, com.heytap.mcssdk.constant.b.u);
        checkNotNull(str2, "appToken");
        android.content.Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        android.content.Context context2 = sContext;
        com.xiaomi.push.jc.a(context2);
        if (!com.xiaomi.push.service.receivers.NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        com.xiaomi.mipush.sdk.f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.m.a(context2).a(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass1(str, str2, str3, iCallbackResult), 0);
    }

    public static void registerPush(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        registerPush(context, str, str2, new com.xiaomi.mipush.sdk.PushConfiguration(), str3, null);
    }

    public static void registerToken(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.xiaomi.mipush.sdk.MiPushClient.UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new com.xiaomi.mipush.sdk.PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_ACCEPT_TIME);
            edit.apply();
        }
    }

    public static synchronized void removeAccount(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_".concat(java.lang.String.valueOf(str))).commit();
        }
    }

    public static synchronized void removeAlias(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_".concat(java.lang.String.valueOf(str))).commit();
        }
    }

    public static synchronized void removeAllAccounts(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            java.util.Iterator<java.lang.String> it = getAllUserAccount(context).iterator();
            while (it.hasNext()) {
                removeAccount(context, it.next());
            }
        }
    }

    public static synchronized void removeAllAliases(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            java.util.Iterator<java.lang.String> it = getAllAlias(context).iterator();
            while (it.hasNext()) {
                removeAlias(context, it.next());
            }
        }
    }

    public static synchronized void removeAllTopics(android.content.Context context) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            java.util.Iterator<java.lang.String> it = getAllTopic(context).iterator();
            while (it.hasNext()) {
                removeTopic(context, it.next());
            }
        }
    }

    public static synchronized void removeTopic(android.content.Context context, java.lang.String str) {
        synchronized (com.xiaomi.mipush.sdk.MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_".concat(java.lang.String.valueOf(str))).commit();
        }
    }

    public static void removeWindow(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).m125e();
    }

    public static void reportAppRunInBackground(android.content.Context context, boolean z) {
        if (com.xiaomi.mipush.sdk.b.m126a(context).m133b()) {
            com.xiaomi.push.gu guVar = z ? com.xiaomi.push.gu.APP_SLEEP : com.xiaomi.push.gu.APP_WAKEUP;
            com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
            hkVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
            hkVar.e = guVar.ah;
            hkVar.i = context.getPackageName();
            hkVar.c = com.xiaomi.push.service.ag.a();
            hkVar.a(false);
            com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, (com.xiaomi.push.gx) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(android.content.Context context, java.lang.String str, com.xiaomi.push.gx gxVar, java.lang.String str2, java.lang.String str3) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        if (android.text.TextUtils.isEmpty(str3)) {
            com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
            return;
        }
        hkVar.d = str3;
        hkVar.e = "bar:click";
        hkVar.c = str;
        hkVar.a(false);
        com.xiaomi.mipush.sdk.ao.a(context).a(hkVar, com.xiaomi.push.gk.Notification, false, true, gxVar, true, str2, str3);
    }

    public static void reportMessageClicked(android.content.Context context, com.xiaomi.mipush.sdk.MiPushMessage miPushMessage) {
        com.xiaomi.push.gx gxVar = new com.xiaomi.push.gx();
        gxVar.a = miPushMessage.getMessageId();
        gxVar.c = miPushMessage.getTopic();
        gxVar.e = miPushMessage.getDescription();
        gxVar.d = miPushMessage.getTitle();
        gxVar.c(miPushMessage.getNotifyId());
        gxVar.a(miPushMessage.getNotifyType());
        gxVar.b(miPushMessage.getPassThrough());
        gxVar.j = miPushMessage.getExtra();
        reportMessageClicked(context, miPushMessage.getMessageId(), gxVar, null);
    }

    @java.lang.Deprecated
    public static void reportMessageClicked(android.content.Context context, java.lang.String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void reportMessageClicked(android.content.Context context, java.lang.String str, com.xiaomi.push.gx gxVar, java.lang.String str2) {
        com.xiaomi.push.hk hkVar = new com.xiaomi.push.hk();
        if (android.text.TextUtils.isEmpty(str2)) {
            if (!com.xiaomi.mipush.sdk.b.m126a(context).m133b()) {
                com.xiaomi.channel.commonutils.logger.b.d("do not report clicked message");
                return;
            }
            str2 = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        }
        hkVar.d = str2;
        hkVar.e = "bar:click";
        hkVar.c = str;
        hkVar.a(false);
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hkVar, com.xiaomi.push.gk.Notification, false, gxVar);
    }

    public static void resumePush(android.content.Context context, java.lang.String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(android.content.Context context) {
        if (com.xiaomi.push.service.ad.a(sContext).a(com.xiaomi.push.gp.DataCollectionSwitch.bw, getDefaultSwitch())) {
            com.xiaomi.push.co.a().a = new com.xiaomi.mipush.sdk.r(context);
            com.xiaomi.push.m.a(sContext).a(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass2(), 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.m.a(sContext).a(new com.xiaomi.mipush.sdk.ae(sContext), com.xiaomi.push.service.ad.a(sContext).a(com.xiaomi.push.gp.OcVersionCheckFrequency.bw, 86400), 5);
    }

    public static void setAcceptTime(android.content.Context context, int i, int i2, int i3, int i4, java.lang.String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new java.lang.IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((java.util.TimeZone.getTimeZone("GMT+08").getRawOffset() - java.util.TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j = ((((i * 60) + i2) + rawOffset) + 1440) % 1440;
        long j2 = ((((i3 * 60) + i4) + rawOffset) + 1440) % 1440;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Long.valueOf(j / 60), java.lang.Long.valueOf(j % 60)));
        arrayList.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Long.valueOf(j2 / 60), java.lang.Long.valueOf(j2 % 60)));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2)));
        arrayList2.add(java.lang.String.format("%1$02d:%2$02d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (java.lang.String) arrayList.get(0), (java.lang.String) arrayList.get(1))) {
            setCommand(context, com.xiaomi.push.dx.COMMAND_SET_ACCEPT_TIME.k, (java.util.ArrayList<java.lang.String>) arrayList, str);
        } else if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(context)) {
            com.xiaomi.mipush.sdk.PushMessageHandler.a(context, str, com.xiaomi.push.dx.COMMAND_SET_ACCEPT_TIME.k, 0L, null, arrayList2);
        } else {
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(context, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_SET_ACCEPT_TIME.k, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, com.xiaomi.push.dx.COMMAND_SET_ALIAS.k, str, str2);
    }

    public static void setCommand(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!android.text.TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        com.xiaomi.push.dx dxVar = com.xiaomi.push.dx.COMMAND_SET_ALIAS;
        if (dxVar.k.equalsIgnoreCase(str) && java.lang.Math.abs(java.lang.System.currentTimeMillis() - aliasSetTime(context, str2)) < 86400000) {
            if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(context)) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(context, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(dxVar.k, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (com.xiaomi.push.dx.COMMAND_UNSET_ALIAS.k.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
            com.xiaomi.channel.commonutils.logger.b.a("Don't cancel alias for " + com.xiaomi.push.ao.a(arrayList.toString(), 3) + " is unseted");
            return;
        }
        com.xiaomi.push.dx dxVar2 = com.xiaomi.push.dx.COMMAND_SET_ACCOUNT;
        if (dxVar2.k.equalsIgnoreCase(str) && java.lang.Math.abs(java.lang.System.currentTimeMillis() - accountSetTime(context, str2)) < 3600000) {
            if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(context)) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(context, str3, str, 0L, null, arrayList);
                return;
            } else {
                com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(context, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(dxVar2.k, arrayList, 0L, null, str3, null));
                return;
            }
        }
        if (!com.xiaomi.push.dx.COMMAND_UNSET_ACCOUNT.k.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
            setCommand(context, str, (java.util.ArrayList<java.lang.String>) arrayList, str3);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("Don't cancel account for " + com.xiaomi.push.ao.a(arrayList.toString(), 3) + " is unseted");
    }

    public static void setCommand(android.content.Context context, java.lang.String str, java.util.ArrayList<java.lang.String> arrayList, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.xiaomi.mipush.sdk.b.m126a(context).m127a())) {
            return;
        }
        com.xiaomi.push.hf hfVar = new com.xiaomi.push.hf();
        java.lang.String a = com.xiaomi.push.service.ag.a();
        hfVar.b = a;
        hfVar.c = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hfVar.d = str;
        java.util.Iterator<java.lang.String> it = arrayList.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            if (hfVar.e == null) {
                hfVar.e = new java.util.ArrayList();
            }
            hfVar.e.add(next);
        }
        hfVar.g = str2;
        hfVar.f = context.getPackageName();
        com.xiaomi.channel.commonutils.logger.b.f("cmd:" + str + ", " + a);
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hfVar, com.xiaomi.push.gk.Command, (com.xiaomi.push.gx) null);
    }

    public static void setLocalNotificationType(android.content.Context context, int i) {
        com.xiaomi.mipush.sdk.ao.a(context).b(i & (-1));
    }

    public static void setUserAccount(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, com.xiaomi.push.dx.COMMAND_SET_ACCOUNT.k, str, str2);
    }

    private static boolean shouldPullNotification(android.content.Context context) {
        return java.lang.Math.abs(java.lang.System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(android.content.Context context) {
        return java.lang.Math.abs(java.lang.System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(android.content.Context context) {
        return com.xiaomi.mipush.sdk.ao.a(context).m119a();
    }

    public static void subscribe(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.xiaomi.mipush.sdk.b.m126a(context).m127a()) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(context)) {
                com.xiaomi.mipush.sdk.PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(str);
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(context, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(com.xiaomi.push.dx.COMMAND_SUBSCRIBE_TOPIC.k, arrayList, 0L, null, null, null));
            return;
        }
        com.xiaomi.push.hp hpVar = new com.xiaomi.push.hp();
        java.lang.String a = com.xiaomi.push.service.ag.a();
        hpVar.c = a;
        hpVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
        hpVar.e = str;
        hpVar.f = context.getPackageName();
        hpVar.g = str2;
        com.xiaomi.channel.commonutils.logger.b.f("cmd:" + com.xiaomi.push.dx.COMMAND_SUBSCRIBE_TOPIC + ", " + a);
        com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) hpVar, com.xiaomi.push.gk.Subscription, (com.xiaomi.push.gx) null);
    }

    public static void syncAssembleCOSPushToken(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a((java.lang.String) null, com.xiaomi.mipush.sdk.au.UPLOAD_COS_TOKEN, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a((java.lang.String) null, com.xiaomi.mipush.sdk.au.UPLOAD_FCM_TOKEN, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a((java.lang.String) null, com.xiaomi.mipush.sdk.au.UPLOAD_FTOS_TOKEN, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(android.content.Context context) {
        com.xiaomi.mipush.sdk.ao.a(context).a((java.lang.String) null, com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_".concat(java.lang.String.valueOf(str)), -1L);
    }

    public static void turnOffPush(android.content.Context context, com.xiaomi.mipush.sdk.MiPushClient.UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            com.xiaomi.mipush.sdk.MiPushClient.CodeResult codeResult = new com.xiaomi.mipush.sdk.MiPushClient.CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(android.content.Context context, com.xiaomi.mipush.sdk.MiPushClient.UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            com.xiaomi.mipush.sdk.MiPushClient.CodeResult codeResult = new com.xiaomi.mipush.sdk.MiPushClient.CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(android.content.Context context, com.xiaomi.mipush.sdk.MiPushClient.UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            com.xiaomi.mipush.sdk.MiPushClient.TokenResult tokenResult = new com.xiaomi.mipush.sdk.MiPushClient.TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(android.content.Context context) {
        com.xiaomi.mipush.sdk.i.c(context);
        com.xiaomi.push.service.ad.a(context).a();
        if (com.xiaomi.mipush.sdk.b.m126a(context).m133b()) {
            com.xiaomi.push.hr hrVar = new com.xiaomi.push.hr();
            hrVar.c = com.xiaomi.push.service.ag.a();
            hrVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
            hrVar.e = com.xiaomi.mipush.sdk.b.m126a(context).m134c();
            hrVar.h = com.xiaomi.mipush.sdk.b.m126a(context).b();
            hrVar.g = context.getPackageName();
            com.xiaomi.mipush.sdk.ao.a(context).a(hrVar);
            com.xiaomi.mipush.sdk.PushMessageHandler.a();
            com.xiaomi.mipush.sdk.PushMessageHandler.b();
            com.xiaomi.mipush.sdk.b.m126a(context).m132b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(android.content.Context context, java.lang.String str, java.lang.String str2) {
        setCommand(context, com.xiaomi.push.dx.COMMAND_UNSET_ALIAS.k, str, str2);
    }

    public static void unsetUserAccount(android.content.Context context, java.lang.String str, java.lang.String str2) {
        setCommand(context, com.xiaomi.push.dx.COMMAND_UNSET_ACCOUNT.k, str, str2);
    }

    public static void unsubscribe(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (com.xiaomi.mipush.sdk.b.m126a(context).m133b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.channel.commonutils.logger.b.a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            com.xiaomi.push.ht htVar = new com.xiaomi.push.ht();
            java.lang.String a = com.xiaomi.push.service.ag.a();
            htVar.c = a;
            htVar.d = com.xiaomi.mipush.sdk.b.m126a(context).m127a();
            htVar.e = str;
            htVar.f = context.getPackageName();
            htVar.g = str2;
            com.xiaomi.channel.commonutils.logger.b.f("cmd:" + com.xiaomi.push.dx.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a);
            com.xiaomi.mipush.sdk.ao.a(context).a((com.xiaomi.mipush.sdk.ao) htVar, com.xiaomi.push.gk.UnSubscription, (com.xiaomi.push.gx) null);
        }
    }

    private static void updateImeiOrOaid() {
        new java.lang.Thread(new com.xiaomi.mipush.sdk.MiPushClient.AnonymousClass3()).start();
    }
}

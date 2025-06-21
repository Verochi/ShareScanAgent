package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class v {

    public static class a extends java.lang.RuntimeException {
        public a(java.lang.String str) {
            super(str);
        }
    }

    public static class b {
        public java.lang.String a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f58a;
        public java.lang.String b;

        /* renamed from: b, reason: collision with other field name */
        public boolean f59b;

        public b(java.lang.String str, boolean z, boolean z2, java.lang.String str2) {
            this.a = str;
            this.f58a = z;
            this.f59b = z2;
            this.b = str2;
        }
    }

    private static android.content.pm.ActivityInfo a(android.content.pm.PackageManager packageManager, android.content.Intent intent, java.lang.Class<?> cls) {
        java.util.Iterator<android.content.pm.ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (it.hasNext()) {
            android.content.pm.ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(android.content.Context context) {
        new java.lang.Thread(new com.xiaomi.mipush.sdk.w(context)).start();
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.lang.String packageName = context.getPackageName();
        android.content.Intent intent = new android.content.Intent(str);
        intent.setPackage(packageName);
        java.util.Iterator<android.content.pm.ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        boolean z = false;
        while (it.hasNext()) {
            android.content.pm.ActivityInfo activityInfo = it.next().activityInfo;
            z = (activityInfo == null || android.text.TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) ? false : true;
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    private static void a(android.content.pm.ActivityInfo activityInfo, java.lang.Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        }
        if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    private static boolean a(android.content.pm.PackageInfo packageInfo, java.lang.String[] strArr) {
        for (android.content.pm.ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(java.lang.String[] strArr, java.lang.String str) {
        if (strArr != null && str != null) {
            for (java.lang.String str2 : strArr) {
                if (android.text.TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2 A[EDGE_INSN: B:23:0x00a2->B:24:0x00a2 BREAK  A[LOOP:0: B:8:0x006e->B:37:0x006e], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.lang.String packageName = context.getPackageName();
        android.content.Intent intent = new android.content.Intent(com.xiaomi.push.service.an.p);
        intent.setPackage(packageName);
        try {
            android.content.pm.ActivityInfo a2 = a(packageManager, intent, com.xiaomi.push.jc.a(context, "com.xiaomi.push.service.receivers.PingReceiver"));
            if (com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(context)) {
                if (a2 != null) {
                    a(a2, new java.lang.Boolean[]{java.lang.Boolean.TRUE, java.lang.Boolean.FALSE});
                }
            } else {
                if (a2 == null) {
                    throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", "com.xiaomi.push.service.receivers.PingReceiver"));
                }
                a(a2, new java.lang.Boolean[]{java.lang.Boolean.TRUE, java.lang.Boolean.FALSE});
            }
        } catch (java.lang.ClassNotFoundException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        android.content.Intent intent2 = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent2.setPackage(packageName);
        java.util.Iterator<android.content.pm.ResolveInfo> it = packageManager.queryBroadcastReceivers(intent2, 16384).iterator();
        boolean z = false;
        while (it.hasNext()) {
            android.content.pm.ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null) {
                try {
                } catch (java.lang.ClassNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
                if (!android.text.TextUtils.isEmpty(activityInfo.name) && com.xiaomi.mipush.sdk.PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.jc.a(context, activityInfo.name)) && activityInfo.enabled) {
                    z = true;
                    if (!z) {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        if (!z) {
            throw new com.xiaomi.mipush.sdk.v.a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        }
        if (com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(context)) {
            a(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
            a(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
        }
        if (com.xiaomi.mipush.sdk.MiPushClient.getOpenVIVOPush(context)) {
            a(context, "com.vivo.pushclient.action.RECEIVE", "com.xiaomi.assemble.control.FTOSPushMessageReceiver");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(android.content.Context context, android.content.pm.PackageInfo packageInfo) {
        boolean z;
        java.util.HashSet hashSet = new java.util.HashSet();
        java.lang.String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(java.util.Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        android.content.pm.PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (android.content.pm.PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        java.lang.String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (java.lang.String str2 : strArr) {
                if (!android.text.TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(android.content.Context context, android.content.pm.PackageInfo packageInfo) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashMap hashMap2 = new java.util.HashMap();
        hashMap2.put(com.xiaomi.mipush.sdk.PushMessageHandler.class.getCanonicalName(), new com.xiaomi.mipush.sdk.v.b(com.xiaomi.mipush.sdk.PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(com.xiaomi.mipush.sdk.MessageHandleService.class.getCanonicalName(), new com.xiaomi.mipush.sdk.v.b(com.xiaomi.mipush.sdk.MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new java.lang.String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new com.xiaomi.mipush.sdk.v.b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new com.xiaomi.mipush.sdk.v.b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (com.xiaomi.mipush.sdk.MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new com.xiaomi.mipush.sdk.v.b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new com.xiaomi.mipush.sdk.v.b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (com.xiaomi.mipush.sdk.MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new com.xiaomi.mipush.sdk.v.b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        android.content.pm.ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                if (!android.text.TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    com.xiaomi.mipush.sdk.v.b bVar = (com.xiaomi.mipush.sdk.v.b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f58a;
                    boolean z2 = bVar.f59b;
                    java.lang.String str = bVar.b;
                    if (z != serviceInfo.enabled) {
                        throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, java.lang.Boolean.valueOf(z)));
                    }
                    if (z2 != serviceInfo.exported) {
                        throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, java.lang.Boolean.valueOf(z2)));
                    }
                    if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.equals(str, serviceInfo.permission)) {
                        throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    hashMap.put(serviceInfo.name, serviceInfo.processName);
                    if (hashMap2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
        }
        if (!android.text.TextUtils.equals((java.lang.CharSequence) hashMap.get(com.xiaomi.mipush.sdk.PushMessageHandler.class.getCanonicalName()), (java.lang.CharSequence) hashMap.get(com.xiaomi.mipush.sdk.MessageHandleService.class.getCanonicalName()))) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", com.xiaomi.mipush.sdk.PushMessageHandler.class.getCanonicalName(), com.xiaomi.mipush.sdk.MessageHandleService.class.getCanonicalName()));
        }
        if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !android.text.TextUtils.equals((java.lang.CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (java.lang.CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new com.xiaomi.mipush.sdk.v.a(java.lang.String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }
}

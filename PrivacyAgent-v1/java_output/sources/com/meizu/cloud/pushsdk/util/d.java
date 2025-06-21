package com.meizu.cloud.pushsdk.util;

/* loaded from: classes23.dex */
public class d {

    /* renamed from: com.meizu.cloud.pushsdk.util.d$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;
        final /* synthetic */ long c;
        final /* synthetic */ boolean d;
        final /* synthetic */ java.util.Map e;

        public AnonymousClass1(android.content.Context context, android.content.Intent intent, long j, boolean z, java.util.Map map) {
            this.a = context;
            this.b = intent;
            this.c = j;
            this.d = z;
            this.e = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.startService(this.b);
                com.meizu.cloud.pushinternal.DebugLogger.i("UxIPUtils", "delayed " + this.c + " ms start tracker data in mz_tracker process " + this.b.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", "delayed startRemotePushTracker error " + e.getMessage());
                com.meizu.cloud.pushsdk.util.d.a(this.a, this.d, (java.lang.String) this.e.get("en"), (java.util.Map<java.lang.String, java.lang.String>) this.e);
            }
        }
    }

    private static int a(android.content.Context context) {
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isMeizu(context)) {
            return 1;
        }
        if (com.meizu.cloud.pushsdk.util.MzSystemUtils.isXiaoMi()) {
            return 2;
        }
        return com.meizu.cloud.pushsdk.util.MzSystemUtils.isHuaWei() ? 3 : 0;
    }

    private static android.content.Intent a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str;
        java.lang.String str2;
        java.util.List<android.content.pm.ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new android.content.Intent(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION), 0);
        if (queryIntentServices != null) {
            java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentServices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    str2 = null;
                    break;
                }
                android.content.pm.ResolveInfo next = it.next();
                if (com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                    android.content.pm.ServiceInfo serviceInfo = next.serviceInfo;
                    str2 = serviceInfo.packageName;
                    str = serviceInfo.name;
                    break;
                }
            }
            if (android.text.TextUtils.isEmpty(str) && queryIntentServices.size() > 0) {
                str2 = queryIntentServices.get(0).serviceInfo.packageName;
                str = queryIntentServices.get(0).serviceInfo.name;
            }
        } else {
            str = null;
            str2 = null;
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("UxIPUtils", "current process packageName " + str2);
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                java.lang.String jSONObject = com.meizu.cloud.pushsdk.d.f.e.a((java.util.Map) map).toString();
                android.content.Intent intent = new android.content.Intent();
                intent.setPackage(str2);
                intent.setAction(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_TRACKER_SERVICE_ACTION);
                intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA, jSONObject);
                return intent;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", "getRemotePushTrackerIntent error " + e.getMessage());
            }
        }
        return null;
    }

    public static com.meizu.cloud.pushsdk.handler.a.c.d a(java.lang.String str) {
        java.lang.String str2;
        com.meizu.cloud.pushsdk.handler.a.c.d dVar = new com.meizu.cloud.pushsdk.handler.a.c.d();
        if (android.text.TextUtils.isEmpty(str)) {
            str2 = "the platformExtra is empty";
        } else {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return com.meizu.cloud.pushsdk.handler.a.c.d.a().a(jSONObject.has("task_id") ? jSONObject.getString("task_id") : null).d(jSONObject.has("device_id") ? jSONObject.getString("device_id") : null).c(jSONObject.has(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP) ? jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.PUSH_TIMESTAMP) : null).b(jSONObject.has(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID) ? jSONObject.getString(com.meizu.cloud.pushsdk.constants.PushConstants.SEQ_ID) : null).a();
            } catch (java.lang.Exception unused) {
                str2 = "the platformExtra parse error";
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", str2);
        return dVar;
    }

    public static java.lang.String a(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_TASK_ID);
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        try {
            com.meizu.cloud.pushsdk.notification.MPushMessage mPushMessage = (com.meizu.cloud.pushsdk.notification.MPushMessage) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            return mPushMessage != null ? mPushMessage.getTaskId() : stringExtra;
        } catch (java.lang.Exception e) {
            com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", "parse MessageV2 error " + e.getMessage());
            return "no push platform task";
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, java.lang.String str, int i) {
        a(context, intent, com.meizu.cloud.pushsdk.PushManager.TAG, str, i);
    }

    public static void a(android.content.Context context, android.content.Intent intent, java.lang.String str, java.lang.String str2, int i) {
        if (android.text.TextUtils.isEmpty(a(intent))) {
            return;
        }
        a(context, context.getPackageName(), intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), a(intent), str, str2, i);
    }

    public static void a(android.content.Context context, java.lang.String str, int i, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        a(context, context.getPackageName(), str3, str2, com.meizu.cloud.pushsdk.PushManager.TAG, str, i);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, true, str, str2, str3, str4, "dpm", str5);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i) {
        java.util.HashMap hashMap = new java.util.HashMap(8);
        hashMap.put(com.ss.android.socialbase.downloader.constants.DBDefinition.TASK_ID, str3);
        hashMap.put("deviceId", str2);
        hashMap.put("timestamp", java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
        hashMap.put("package_name", str);
        hashMap.put("pushsdk_version", str4);
        hashMap.put("push_info", str5);
        hashMap.put("push_info_type", java.lang.String.valueOf(i));
        a(context, false, "notification_service_message", (java.util.Map<java.lang.String, java.lang.String>) hashMap);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, true, str, str2, str3, str4, "spm", str5, j);
    }

    public static void a(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        a(context, z, str, str2, str3, str4, str5, str6, 0L);
    }

    public static void a(android.content.Context context, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, long j) {
        java.util.HashMap hashMap = new java.util.HashMap(8);
        hashMap.put("en", str5);
        hashMap.put("ti", str3);
        hashMap.put(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, str2);
        if (android.text.TextUtils.isEmpty(str6)) {
            str6 = java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000);
        }
        hashMap.put("ts", str6);
        hashMap.put("pn", str);
        hashMap.put(com.umeng.analytics.pro.f.T, com.meizu.cloud.pushsdk.PushManager.TAG);
        hashMap.put("nm", java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000));
        if (!android.text.TextUtils.isEmpty(str4)) {
            hashMap.put("si", str4);
        }
        if (a(context, hashMap, z, j)) {
            return;
        }
        a(context, z, str5, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.meizu.cloud.pushsdk.d.c.b$a] */
    public static void a(android.content.Context context, boolean z, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", "onLogEvent eventName [" + str + "] properties = " + map);
        if ("notification_service_message".equals(str)) {
            return;
        }
        com.meizu.cloud.pushsdk.d.a.a(context, (com.meizu.cloud.pushsdk.c.c.a) null, (com.meizu.cloud.pushsdk.d.b.f) null).a(((com.meizu.cloud.pushsdk.d.c.b.a) com.meizu.cloud.pushsdk.d.c.b.d().a(str).a(a(context)).a(java.lang.Long.valueOf(map.get("ts")).longValue())).h(map.get("nm") != null ? map.get("nm") : java.lang.String.valueOf(java.lang.System.currentTimeMillis() / 1000)).c(map.get(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON)).e(map.get("pn")).d(map.get(com.umeng.analytics.pro.f.T)).b(map.get("ti")).f(android.text.TextUtils.isEmpty(map.get("si")) ? "" : map.get("si")).g(java.lang.String.valueOf(com.meizu.cloud.pushsdk.util.b.j(context, map.get("pn")))).b(), z);
    }

    private static boolean a(android.content.Context context, android.content.Intent intent, boolean z, java.util.Map<java.lang.String, java.lang.String> map, long j) {
        java.lang.String str;
        if (intent == null) {
            str = "startRemotePushTracker error intent is null";
        } else {
            if (j != 0) {
                new android.os.Handler(context.getMainLooper()).postDelayed(new com.meizu.cloud.pushsdk.util.d.AnonymousClass1(context, intent, j, z, map), j);
                return true;
            }
            try {
                context.startService(intent);
                com.meizu.cloud.pushinternal.DebugLogger.i("UxIPUtils", "immediately start tracker data in mz_tracker process " + intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_PUSH_TRACKER_JSON_DATA));
                return true;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                str = "startRemotePushTracker error " + e.getMessage();
            }
        }
        com.meizu.cloud.pushinternal.DebugLogger.e("UxIPUtils", str);
        return false;
    }

    private static boolean a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map, boolean z, long j) {
        return a(context, a(context, map), z, map, j);
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, false, str, str2, str3, str4, "rpe", str5);
    }

    public static void b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, false, str, str2, str3, str4, "rpe", str5, j);
    }

    public static void c(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, true, str, str2, str3, str4, "rpe", str5);
    }

    public static void c(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, false, str, str2, str3, str4, "sipm", str5, j);
    }

    public static void d(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, true, str, str2, str3, str4, "cpm", str5);
    }

    public static void d(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, false, str, str2, str3, str4, "nspm", str5, j);
    }

    public static void e(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, true, str, str2, str3, str4, "acce", str5);
    }

    public static void e(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, false, str, str2, str3, str4, "fspm", str5, j);
    }

    public static void f(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        a(context, true, str, str2, str3, str4, "acsm", str5);
    }

    public static void f(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        a(context, false, str, str2, str3, str4, "npm", str5, j);
    }
}

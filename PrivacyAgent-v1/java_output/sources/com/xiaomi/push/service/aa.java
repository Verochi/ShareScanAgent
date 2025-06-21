package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class aa {
    private static android.content.Context c;
    private static java.lang.Object d;
    private static boolean e;
    private static java.util.WeakHashMap<java.lang.Integer, com.xiaomi.push.service.aa> f = new java.util.WeakHashMap<>();
    java.lang.String a;
    java.lang.String b;

    private aa(java.lang.String str) {
        this.a = str;
    }

    public static android.content.Context a() {
        return c;
    }

    public static com.xiaomi.push.service.aa a(android.content.Context context, java.lang.String str) {
        b(context);
        int hashCode = str.hashCode();
        com.xiaomi.push.service.aa aaVar = f.get(java.lang.Integer.valueOf(hashCode));
        if (aaVar != null) {
            return aaVar;
        }
        com.xiaomi.push.service.aa aaVar2 = new com.xiaomi.push.service.aa(str);
        f.put(java.lang.Integer.valueOf(hashCode), aaVar2);
        return aaVar2;
    }

    private static <T> T a(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (T) obj.getClass().getMethod("getList", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static java.lang.Object a(java.util.List list) {
        return java.lang.Class.forName("android.content.pm.ParceledListSlice").getConstructor(java.util.List.class).newInstance(list);
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String a = a("mipush|%s|%s", str2, "");
        return str.startsWith(a) ? a("mipush_%s_%s", str2, str.replace(a, "")) : str;
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return android.text.TextUtils.isEmpty(str) ? "" : java.lang.String.format(str, str2, str3);
    }

    public static boolean a(android.content.Context context) {
        b(context);
        return e();
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return !e() ? str2 : str;
    }

    private static void b(android.content.Context context) {
        if (c == null) {
            c = context.getApplicationContext();
            android.app.NotificationManager d2 = d();
            java.lang.Boolean bool = (java.lang.Boolean) com.xiaomi.push.aj.a((java.lang.Object) d2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            d("fwk is support.init:".concat(java.lang.String.valueOf(bool)));
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            e = booleanValue;
            if (booleanValue) {
                d = com.xiaomi.push.aj.a((java.lang.Object) d2, "getService", new java.lang.Object[0]);
            }
        }
    }

    private static int c(java.lang.String str) {
        int packageUid;
        if (android.os.Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            packageUid = c.getPackageManager().getPackageUid(str, 0);
            return packageUid;
        } catch (java.lang.Exception unused) {
            return -1;
        }
    }

    private static android.app.NotificationManager d() {
        return (android.app.NotificationManager) c.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
    }

    private static void d(java.lang.String str) {
        com.xiaomi.channel.commonutils.logger.b.a("NMHelper:".concat(java.lang.String.valueOf(str)));
    }

    private static boolean e() {
        if (com.xiaomi.push.iu.a() && com.xiaomi.push.service.ad.a(c).a(com.xiaomi.push.gp.NotificationBelongToAppSwitch.bw, true)) {
            return e;
        }
        return false;
    }

    private static android.service.notification.StatusBarNotification[] f() {
        if (!com.xiaomi.push.iu.a(c)) {
            return null;
        }
        try {
            java.lang.Object a = com.xiaomi.push.aj.a(d, "getActiveNotifications", c.getPackageName());
            if (a instanceof android.service.notification.StatusBarNotification[]) {
                return (android.service.notification.StatusBarNotification[]) a;
            }
            return null;
        } catch (java.lang.Throwable th) {
            d("getAllNotifications error ".concat(java.lang.String.valueOf(th)));
            return null;
        }
    }

    public final java.lang.String a(java.lang.String str) {
        return a(e() ? "mipush|%s|%s" : "mipush_%s_%s", this.a, str);
    }

    public final void a(int i) {
        java.lang.String str = this.a;
        try {
            if (!e()) {
                d().cancel(i);
                return;
            }
            int a = com.xiaomi.push.ib.a();
            java.lang.String packageName = c.getPackageName();
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                com.xiaomi.push.aj.b(d, "cancelNotificationWithTag", str, packageName, null, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(a));
            } else {
                com.xiaomi.push.aj.b(d, "cancelNotificationWithTag", str, null, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(a));
            }
            d("cancel succ:".concat(java.lang.String.valueOf(i)));
        } catch (java.lang.Exception e2) {
            d("cancel error".concat(java.lang.String.valueOf(e2)));
        }
    }

    public final void a(int i, android.app.Notification notification) {
        java.lang.String str = this.a;
        android.app.NotificationManager d2 = d();
        try {
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (!e()) {
                d2.notify(i, notification);
                return;
            }
            notification.extras.putString("xmsf_target_package", str);
            if (i2 >= 29) {
                d2.notifyAsPackage(str, null, i, notification);
            } else {
                d2.notify(i, notification);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    @android.annotation.TargetApi(26)
    public final void a(android.app.NotificationChannel notificationChannel) {
        java.lang.String str = this.a;
        try {
            if (!e()) {
                d().createNotificationChannel(notificationChannel);
                return;
            }
            int c2 = c(str);
            if (c2 != -1) {
                com.xiaomi.push.aj.b(d, "createNotificationChannelsForPackage", str, java.lang.Integer.valueOf(c2), a(java.util.Arrays.asList(notificationChannel)));
            }
        } catch (java.lang.Exception e2) {
            d("createNotificationChannel error".concat(java.lang.String.valueOf(e2)));
        }
    }

    public final void a(android.app.NotificationChannel notificationChannel, boolean z) {
        java.lang.String str = this.a;
        try {
            if (!z) {
                a(notificationChannel);
                return;
            }
            int c2 = c(str);
            if (c2 != -1) {
                com.xiaomi.push.aj.b(d, "updateNotificationChannelForPackage", str, java.lang.Integer.valueOf(c2), notificationChannel);
            }
        } catch (java.lang.Exception e2) {
            d("updateNotificationChannel error ".concat(java.lang.String.valueOf(e2)));
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003e -> B:12:0x003f). Please report as a decompilation issue!!! */
    @android.annotation.TargetApi(26)
    public final android.app.NotificationChannel b(java.lang.String str) {
        android.app.NotificationChannel notificationChannel;
        java.lang.String id;
        try {
        } catch (java.lang.Exception e2) {
            d("getNotificationChannel error".concat(java.lang.String.valueOf(e2)));
        }
        if (e()) {
            java.util.List<android.app.NotificationChannel> b = b();
            if (b != null) {
                java.util.Iterator<android.app.NotificationChannel> it = b.iterator();
                while (it.hasNext()) {
                    notificationChannel = it.next();
                    id = notificationChannel.getId();
                    if (str.equals(id)) {
                        break;
                    }
                }
            }
            notificationChannel = null;
        } else {
            notificationChannel = d().getNotificationChannel(str);
        }
        return notificationChannel;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @android.annotation.TargetApi(26)
    public final java.util.List<android.app.NotificationChannel> b() {
        java.lang.String str;
        java.lang.String id;
        java.lang.String str2 = this.a;
        java.util.List<android.app.NotificationChannel> list = null;
        try {
            if (e()) {
                int c2 = c(str2);
                if (c2 != -1) {
                    java.lang.Object obj = d;
                    java.lang.Object[] objArr = {str2, java.lang.Integer.valueOf(c2), java.lang.Boolean.FALSE};
                    str = "mipush|%s|%s";
                    list = (java.util.List) a(com.xiaomi.push.aj.a(obj, "getNotificationChannelsForPackage", objArr));
                } else {
                    str = null;
                }
            } else {
                list = d().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!com.xiaomi.push.iu.a() || list == null) {
                return list;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.lang.String a = a(str, str2, "");
            for (android.app.NotificationChannel notificationChannel : list) {
                id = notificationChannel.getId();
                if (id.startsWith(a)) {
                    arrayList.add(notificationChannel);
                }
            }
            return arrayList;
        } catch (java.lang.Exception e2) {
            d("getNotificationChannels error ".concat(java.lang.String.valueOf(e2)));
            return list;
        }
    }

    public final java.util.List<android.service.notification.StatusBarNotification> c() {
        java.lang.String str = this.a;
        android.app.NotificationManager d2 = d();
        java.util.ArrayList arrayList = null;
        try {
            if (e()) {
                int a = com.xiaomi.push.ib.a();
                if (a != -1) {
                    return (java.util.List) a(com.xiaomi.push.aj.a(d, "getAppActiveNotifications", str, java.lang.Integer.valueOf(a)));
                }
                return null;
            }
            android.service.notification.StatusBarNotification[] activeNotifications = android.os.Build.VERSION.SDK_INT >= 23 ? d2.getActiveNotifications() : f();
            boolean a2 = com.xiaomi.push.iu.a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            try {
                for (android.service.notification.StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!a2 || str.equals(com.xiaomi.push.service.ab.d(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (java.lang.Throwable th) {
                th = th;
                arrayList = arrayList2;
                d("getActiveNotifications error ".concat(java.lang.String.valueOf(th)));
                return arrayList;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final java.lang.String toString() {
        return "NotificationManagerHelper{" + this.a + com.alipay.sdk.m.u.i.d;
    }
}

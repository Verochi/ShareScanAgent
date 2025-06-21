package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class o {
    public static int a;

    public static android.app.Notification a(android.content.Context context, com.huawei.hms.push.k kVar, int[] iArr) {
        android.app.Notification.Builder builder = new android.app.Notification.Builder(context);
        if (com.huawei.hms.push.m.a(kVar) == com.huawei.hms.push.n.STYLE_BIGTEXT) {
            com.huawei.hms.push.m.a(builder, kVar.g(), kVar);
        }
        com.huawei.hms.push.l.a(context, builder, kVar);
        b(kVar, builder);
        d(kVar, builder);
        a(context, kVar, builder);
        a(builder);
        a(kVar, builder);
        c(kVar, builder);
        builder.setContentIntent(c(context, kVar, iArr));
        builder.setDeleteIntent(b(context, kVar, iArr));
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        b(context, builder, kVar);
        a(context, builder, kVar);
        return builder.build();
    }

    public static android.content.Intent a(android.content.Context context, com.huawei.hms.push.k kVar, int[] iArr, java.lang.String str, int i) {
        android.content.Intent intent = new android.content.Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", kVar.o()).putExtra("selfshow_token", kVar.y()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
        return intent;
    }

    public static void a(android.app.Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(java.lang.System.currentTimeMillis());
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void a(android.content.Context context, android.app.Notification.Builder builder, com.huawei.hms.push.k kVar) {
        if (com.huawei.hms.android.HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !com.huawei.hms.push.q.a(context)) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        java.lang.String k = kVar.k();
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "the package name of notification is:" + k);
        if (!android.text.TextUtils.isEmpty(k)) {
            java.lang.String a2 = com.huawei.hms.push.q.a(context, k);
            com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "the app name is:" + a2);
            if (a2 != null) {
                bundle.putCharSequence("android.extraAppName", a2);
            }
        }
        builder.setExtras(bundle);
    }

    public static void a(android.content.Context context, android.content.Intent intent, long j, int i) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("enter setDelayAlarm(interval:");
            sb.append(j);
            sb.append("ms.");
            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", sb.toString());
            android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService(androidx.core.app.NotificationCompat.CATEGORY_ALARM);
            if (alarmManager != null) {
                alarmManager.set(0, java.lang.System.currentTimeMillis() + j, android.app.PendingIntent.getBroadcast(context, i, intent, com.huawei.hms.push.q.b()));
            }
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.w("PushSelfShowLog", "set DelayAlarm error." + e.toString());
        }
    }

    public static synchronized void a(android.content.Context context, com.huawei.hms.push.k kVar) {
        int hashCode;
        int i;
        int i2;
        int hashCode2;
        synchronized (com.huawei.hms.push.o.class) {
            if (context != null) {
                if (!a(kVar)) {
                    com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "showNotification, the msg id = " + kVar.p());
                    if (a == 0) {
                        a = (context.getPackageName() + java.lang.System.currentTimeMillis()).hashCode();
                    }
                    if (android.text.TextUtils.isEmpty(kVar.l())) {
                        java.lang.String q = kVar.q();
                        if (!android.text.TextUtils.isEmpty(q)) {
                            int hashCode3 = q.hashCode();
                            kVar.a(hashCode3);
                            com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (kVar.s() != -1) {
                            hashCode = kVar.s();
                            i = (kVar.k() + java.lang.System.currentTimeMillis()).hashCode();
                            i2 = i + 1;
                            hashCode2 = (kVar.s() + kVar.k() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = a + 1;
                            i = hashCode + 1;
                            i2 = i + 1;
                            hashCode2 = i2 + 1;
                            a = hashCode2;
                        }
                    } else {
                        hashCode = (kVar.l() + kVar.k()).hashCode();
                        i = a + 1;
                        i2 = i + 1;
                        a = i2;
                        hashCode2 = (kVar.l() + kVar.k() + context.getPackageName()).hashCode();
                    }
                    com.huawei.hms.support.log.HMSLog.d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i + ",delNotifyId:" + i2 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i;
                    iArr[2] = i2;
                    if (kVar.f() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    android.app.Notification a2 = com.huawei.hms.push.q.e() ? a(context, kVar, iArr) : null;
                    android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
                    if (notificationManager != null && a2 != null) {
                        if (android.os.Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new android.app.NotificationChannel("HwPushChannelID", context.getString(com.huawei.hms.utils.ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, a2);
                        d(context, kVar, iArr);
                        com.huawei.hms.push.e.a(context, kVar.p(), kVar.b(), "100");
                    }
                }
            }
        }
    }

    public static void a(android.content.Context context, com.huawei.hms.push.k kVar, android.app.Notification.Builder builder) {
        android.graphics.Bitmap a2 = com.huawei.hms.push.l.a(context, kVar);
        if (a2 != null) {
            builder.setLargeIcon(a2);
        }
    }

    public static void a(com.huawei.hms.push.k kVar, android.app.Notification.Builder builder) {
        builder.setAutoCancel(kVar.e() == 1);
        builder.setOngoing(false);
    }

    public static boolean a() {
        return android.os.Build.VERSION.SDK_INT >= 30;
    }

    public static boolean a(com.huawei.hms.push.k kVar) {
        return kVar == null || (android.text.TextUtils.isEmpty(kVar.u()) && android.text.TextUtils.isEmpty(kVar.j()));
    }

    public static android.app.PendingIntent b(android.content.Context context, com.huawei.hms.push.k kVar, int[] iArr) {
        android.content.Intent a2 = a(context, kVar, iArr, "2", 268435456);
        if (!a()) {
            return android.app.PendingIntent.getBroadcast(context, iArr[2], a2, com.huawei.hms.push.q.b());
        }
        a2.setClass(context, com.huawei.hms.support.api.push.TransActivity.class);
        a2.setFlags(268468224);
        return android.app.PendingIntent.getActivity(context, iArr[2], a2, com.huawei.hms.push.q.b());
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static void b(android.content.Context context, android.app.Notification.Builder builder, com.huawei.hms.push.k kVar) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            android.os.Bundle bundle = new android.os.Bundle();
            java.lang.String k = kVar.k();
            if (android.text.TextUtils.isEmpty(k)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", k);
            builder.setExtras(bundle);
        }
    }

    public static void b(com.huawei.hms.push.k kVar, android.app.Notification.Builder builder) {
        java.lang.String t = kVar.t();
        if (android.text.TextUtils.isEmpty(t)) {
            return;
        }
        builder.setSubText(t);
    }

    public static android.app.PendingIntent c(android.content.Context context, com.huawei.hms.push.k kVar, int[] iArr) {
        android.content.Intent a2 = a(context, kVar, iArr, "1", 268435456);
        if (!a()) {
            return android.app.PendingIntent.getBroadcast(context, iArr[1], a2, com.huawei.hms.push.q.b());
        }
        a2.setClass(context, com.huawei.hms.support.api.push.TransActivity.class);
        a2.setFlags(268468224);
        return android.app.PendingIntent.getActivity(context, iArr[1], a2, com.huawei.hms.push.q.b());
    }

    public static void c(com.huawei.hms.push.k kVar, android.app.Notification.Builder builder) {
        builder.setTicker(kVar.x());
    }

    public static void d(android.content.Context context, com.huawei.hms.push.k kVar, int[] iArr) {
        com.huawei.hms.support.log.HMSLog.i("PushSelfShowLog", "setAutoClear time is: " + kVar.f());
        if (kVar.f() <= 0) {
            return;
        }
        a(context, a(context, kVar, iArr, "-1", 32), kVar.f(), iArr[3]);
    }

    public static void d(com.huawei.hms.push.k kVar, android.app.Notification.Builder builder) {
        java.lang.String u = kVar.u();
        java.lang.String j = kVar.j();
        if (android.text.TextUtils.isEmpty(j)) {
            builder.setContentText(u);
            return;
        }
        builder.setContentText(j);
        if (android.text.TextUtils.isEmpty(u)) {
            return;
        }
        builder.setContentTitle(u);
    }
}

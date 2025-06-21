package com.anythink.china.common.b;

/* loaded from: classes12.dex */
public class a implements com.anythink.china.common.b.b {
    public static final java.lang.String a = "a";
    public static final java.lang.String b = "anythink_action_notification_click";
    public static final java.lang.String c = "anythink_action_notification_cannel";
    public static final java.lang.String d = "anythink_broadcast_receiver_extra_url";
    public static final java.lang.String e = "anythink_broadcast_receiver_extra_unique_id";
    public static final java.lang.String f = "anythink_broadcast_receiver_extra_request_status";
    public static final java.lang.String g = "anythink_broadcast_receiver_extra_notification_id";
    private static volatile com.anythink.china.common.b.a j;
    java.util.Map<java.lang.String, com.anythink.china.common.b.c> h = new java.util.HashMap();
    private android.app.NotificationManager i;
    private android.content.Context k;
    private int l;

    private a(android.content.Context context) {
        this.k = context;
        this.i = b(context);
    }

    private static int a(long j2, long j3) {
        return (int) (((j2 * 1.0f) / j3) * 100.0f);
    }

    public static com.anythink.china.common.b.a a(android.content.Context context) {
        if (j == null) {
            synchronized (com.anythink.china.common.b.a.class) {
                if (j == null) {
                    j = new com.anythink.china.common.b.a(context);
                }
            }
        }
        return j;
    }

    private void a(com.anythink.china.common.a.e eVar, androidx.core.app.NotificationCompat.Builder builder, com.anythink.china.common.b.c cVar) {
        com.anythink.china.common.a.e.a aVar = cVar.d;
        if (aVar == null || aVar != eVar.a()) {
            cVar.d = eVar.a();
            android.content.Intent intent = new android.content.Intent(b);
            intent.putExtra(e, eVar.n);
            intent.putExtra(d, eVar.b);
            intent.putExtra(f, eVar.a().toString());
            intent.putExtra(g, cVar.a);
            intent.setClass(this.k, com.anythink.china.common.NotificationBroadcaseReceiver.class);
            int i = android.os.Build.VERSION.SDK_INT;
            int i2 = i >= 31 ? 201326592 : 134217728;
            android.content.Context context = this.k;
            int i3 = cVar.a;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context, i3, intent, i2);
            android.app.PendingIntent broadcast = android.app.PendingIntent.getBroadcast(context, i3, intent, i2);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, i3, intent, i2);
            android.content.Intent intent2 = new android.content.Intent(c);
            intent2.putExtra(e, eVar.n);
            intent2.putExtra(d, eVar.b);
            intent2.putExtra(f, eVar.a().toString());
            intent2.putExtra(g, cVar.a);
            intent2.setClass(this.k, com.anythink.china.common.NotificationBroadcaseReceiver.class);
            int i4 = i >= 31 ? 201326592 : 134217728;
            android.content.Context context2 = this.k;
            int i5 = cVar.a;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context2, i5, intent2, i4);
            android.app.PendingIntent broadcast2 = android.app.PendingIntent.getBroadcast(context2, i5, intent2, i4);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast2, context2, i5, intent2, i4);
            builder.setContentIntent(broadcast).setDeleteIntent(broadcast2);
        }
    }

    private void d(com.anythink.china.common.a.e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private void e(com.anythink.china.common.a.e eVar) {
        a(eVar, 0L, 100L, true);
    }

    private com.anythink.china.common.b.c f(com.anythink.china.common.a.e eVar) {
        java.lang.String str = eVar.n;
        com.anythink.china.common.b.c cVar = this.h.get(str);
        if (cVar != null) {
            return cVar;
        }
        androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(this.k, str);
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 24 && i >= 26) {
            android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(str, str, 3);
            notificationChannel.setSound(null, null);
            this.i.createNotificationChannel(notificationChannel);
        }
        this.l++;
        builder.setOngoing(true).setSound(null).setPriority(0).setOnlyAlertOnce(true).setAutoCancel(false);
        try {
            builder.setSmallIcon(this.k.getPackageManager().getApplicationInfo(this.k.getPackageName(), 128).icon);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            builder.setSmallIcon(com.anythink.core.common.o.i.a(this.k, "core_icon_close", com.anythink.expressad.foundation.h.i.c));
        }
        builder.setContentTitle(eVar.c).setLargeIcon(eVar.d);
        com.anythink.china.common.b.c cVar2 = new com.anythink.china.common.b.c();
        cVar2.a = this.l;
        cVar2.b = builder;
        cVar2.c = -1;
        this.h.put(str, cVar2);
        return cVar2;
    }

    public final void a() {
        try {
            android.app.NotificationManager notificationManager = this.i;
            if (notificationManager != null) {
                notificationManager.cancelAll();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        if (i < 0) {
            return;
        }
        try {
            this.i.cancel(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(com.anythink.china.common.a.e eVar) {
        a(eVar, 100L, 100L, true);
    }

    public final void a(com.anythink.china.common.a.e eVar, long j2, long j3) {
        a(eVar, j2, j3, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0163 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:11:0x000f, B:13:0x0013, B:14:0x001b, B:16:0x0025, B:18:0x00c8, B:21:0x00d4, B:25:0x015d, B:27:0x0163, B:28:0x0167, B:30:0x0179, B:31:0x0188, B:35:0x0181, B:36:0x00e4, B:39:0x00f0, B:47:0x010f, B:49:0x0117, B:54:0x0122, B:57:0x012b, B:59:0x0131, B:61:0x0135, B:62:0x0149, B:64:0x002b, B:67:0x0070, B:70:0x00b3), top: B:10:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0179 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:11:0x000f, B:13:0x0013, B:14:0x001b, B:16:0x0025, B:18:0x00c8, B:21:0x00d4, B:25:0x015d, B:27:0x0163, B:28:0x0167, B:30:0x0179, B:31:0x0188, B:35:0x0181, B:36:0x00e4, B:39:0x00f0, B:47:0x010f, B:49:0x0117, B:54:0x0122, B:57:0x012b, B:59:0x0131, B:61:0x0135, B:62:0x0149, B:64:0x002b, B:67:0x0070, B:70:0x00b3), top: B:10:0x000f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0181 A[Catch: all -> 0x0198, TryCatch #0 {all -> 0x0198, blocks: (B:11:0x000f, B:13:0x0013, B:14:0x001b, B:16:0x0025, B:18:0x00c8, B:21:0x00d4, B:25:0x015d, B:27:0x0163, B:28:0x0167, B:30:0x0179, B:31:0x0188, B:35:0x0181, B:36:0x00e4, B:39:0x00f0, B:47:0x010f, B:49:0x0117, B:54:0x0122, B:57:0x012b, B:59:0x0131, B:61:0x0135, B:62:0x0149, B:64:0x002b, B:67:0x0070, B:70:0x00b3), top: B:10:0x000f, outer: #1 }] */
    @Override // com.anythink.china.common.b.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(com.anythink.china.common.a.e eVar, long j2, long j3, boolean z) {
        int i;
        if (eVar != null) {
            if (!android.text.TextUtils.isEmpty(eVar.b)) {
                try {
                    if (this.i == null) {
                        this.i = b(this.k);
                    }
                    com.anythink.china.common.b.c f2 = f(eVar);
                    androidx.core.app.NotificationCompat.Builder builder = f2.b;
                    com.anythink.china.common.a.e.a aVar = f2.d;
                    if (aVar == null || aVar != eVar.a()) {
                        f2.d = eVar.a();
                        android.content.Intent intent = new android.content.Intent(b);
                        intent.putExtra(e, eVar.n);
                        intent.putExtra(d, eVar.b);
                        intent.putExtra(f, eVar.a().toString());
                        intent.putExtra(g, f2.a);
                        intent.setClass(this.k, com.anythink.china.common.NotificationBroadcaseReceiver.class);
                        int i2 = android.os.Build.VERSION.SDK_INT;
                        int i3 = 201326592;
                        int i4 = i2 >= 31 ? 201326592 : 134217728;
                        android.content.Context context = this.k;
                        int i5 = f2.a;
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context, i5, intent, i4);
                        android.app.PendingIntent broadcast = android.app.PendingIntent.getBroadcast(context, i5, intent, i4);
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, i5, intent, i4);
                        android.content.Intent intent2 = new android.content.Intent(c);
                        intent2.putExtra(e, eVar.n);
                        intent2.putExtra(d, eVar.b);
                        intent2.putExtra(f, eVar.a().toString());
                        intent2.putExtra(g, f2.a);
                        intent2.setClass(this.k, com.anythink.china.common.NotificationBroadcaseReceiver.class);
                        if (i2 < 31) {
                            i3 = 134217728;
                        }
                        android.content.Context context2 = this.k;
                        int i6 = f2.a;
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context2, i6, intent2, i3);
                        android.app.PendingIntent broadcast2 = android.app.PendingIntent.getBroadcast(context2, i6, intent2, i3);
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast2, context2, i6, intent2, i3);
                        builder.setContentIntent(broadcast).setDeleteIntent(broadcast2);
                    }
                    int i7 = f2.c;
                    boolean z2 = eVar.p == 2;
                    java.lang.String str = "default";
                    if (!eVar.f()) {
                        if (eVar.g()) {
                            str = "点击安装";
                            i = 100;
                        } else if (eVar.h()) {
                            str = "下载失败，可点击重试";
                        } else {
                            i = (int) (((j2 * 1.0f) / j3) * 100.0f);
                            if (!z && i7 == i) {
                                return;
                            }
                            f2.c = i;
                            if (eVar.b()) {
                                str = eVar.q == 2 ? "等待下载中" : "等待下载中（点击可暂停）";
                            } else if (eVar.c()) {
                                str = "点击继续下载";
                            } else if (eVar.d()) {
                                if (eVar.q == 2) {
                                    str = "（下载中：" + i + "%)";
                                } else {
                                    str = "点击暂停下载（下载中：" + i + "%)";
                                }
                            }
                            z2 = false;
                        }
                        if (eVar.d()) {
                            builder = builder.setProgress(100, i, false);
                        }
                        builder.setContentText(str).setStyle(new androidx.core.app.NotificationCompat.BigTextStyle().bigText(str));
                        if (z2) {
                            builder.setOngoing(true).setAutoCancel(false);
                        } else {
                            builder.setOngoing(false).setAutoCancel(true);
                        }
                        android.app.NotificationManager notificationManager = this.i;
                        int i8 = f2.a;
                        android.app.Notification build = builder.build();
                        notificationManager.notify(i8, build);
                        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, i8, build);
                    }
                    str = "点击打开";
                    z2 = true;
                    i = 0;
                    if (eVar.d()) {
                    }
                    builder.setContentText(str).setStyle(new androidx.core.app.NotificationCompat.BigTextStyle().bigText(str));
                    if (z2) {
                    }
                    android.app.NotificationManager notificationManager2 = this.i;
                    int i82 = f2.a;
                    android.app.Notification build2 = builder.build();
                    notificationManager2.notify(i82, build2);
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager2, i82, build2);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.anythink.china.common.b.b
    public final android.app.NotificationManager b(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
    }

    @Override // com.anythink.china.common.b.b
    public final java.lang.String b(com.anythink.china.common.a.e eVar) {
        return eVar.n;
    }

    public final void c(com.anythink.china.common.a.e eVar) {
        if (eVar == null || android.text.TextUtils.isEmpty(eVar.b) || this.i == null) {
            return;
        }
        try {
            this.i.cancel(f(eVar).a);
            this.h.remove(eVar.n);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}

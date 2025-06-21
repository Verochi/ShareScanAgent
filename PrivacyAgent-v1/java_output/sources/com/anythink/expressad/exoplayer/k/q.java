package com.anythink.expressad.exoplayer.k;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes12.dex */
public final class q {
    public static final int a = -1000;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    private q() {
    }

    private static void a(android.content.Context context, int i, @androidx.annotation.Nullable android.app.Notification notification) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notification == null) {
            notificationManager.cancel(i);
        } else {
            notificationManager.notify(i, notification);
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, i, notification);
        }
    }

    private static void a(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, int i2) {
        if (com.anythink.expressad.exoplayer.k.af.a >= 26) {
            ((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).createNotificationChannel(new android.app.NotificationChannel(str, context.getString(i), i2));
        }
    }
}

package com.google.android.exoplayer2.util;

@android.annotation.SuppressLint({"InlinedApi"})
/* loaded from: classes22.dex */
public final class NotificationUtil {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    @java.lang.Deprecated
    public static void createNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, int i2) {
        createNotificationChannel(context, str, i, 0, i2);
    }

    public static void createNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2, int i3) {
        if (com.google.android.exoplayer2.util.Util.SDK_INT >= 26) {
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION));
            android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(str, context.getString(i), i3);
            if (i2 != 0) {
                notificationChannel.setDescription(context.getString(i2));
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static void setNotification(android.content.Context context, int i, @androidx.annotation.Nullable android.app.Notification notification) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION));
        if (notification != null) {
            notificationManager.notify(i, notification);
        } else {
            notificationManager.cancel(i);
        }
    }
}

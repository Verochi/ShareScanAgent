package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CustomNotification {
    private static java.lang.String mChannel = "down";

    @androidx.annotation.DrawableRes
    private static int mSmallIcon = 17301634;
    private androidx.core.app.NotificationCompat.Style mStyle = new androidx.core.app.NotificationCompat.DecoratedCustomViewStyle();

    public static void initNotification(@androidx.annotation.DrawableRes int i, java.lang.String str) {
        mSmallIcon = i;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationChannel(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationIcon(@androidx.annotation.DrawableRes int i) {
        mSmallIcon = i;
    }

    private void setRemoteViewText(android.widget.RemoteViews remoteViews, int i, java.lang.String str) {
        if (remoteViews != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                remoteViews.setViewVisibility(i, 8);
            } else {
                remoteViews.setTextViewText(i, str);
                remoteViews.setViewVisibility(i, 0);
            }
        }
    }

    @android.annotation.TargetApi(16)
    public android.app.Notification getCustomNotification(android.content.Context context, java.lang.String str, java.lang.String str2, android.graphics.Bitmap bitmap, java.lang.String str3, java.lang.String str4, java.lang.String str5, boolean z, int i, int i2, java.lang.String str6, android.app.PendingIntent pendingIntent) {
        androidx.core.app.NotificationCompat.Builder builder;
        if (com.baidu.mobads.sdk.internal.bm.a(context).a() < 26) {
            builder = new androidx.core.app.NotificationCompat.Builder(context);
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                builder = new androidx.core.app.NotificationCompat.Builder(context, str);
            } catch (java.lang.NoSuchMethodError unused) {
                builder = new androidx.core.app.NotificationCompat.Builder(context);
            }
        }
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(context.getPackageName(), com.baidu.mobads.proxy.R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(com.baidu.mobads.proxy.R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(com.baidu.mobads.proxy.R.id.left_icon, com.baidu.mobads.proxy.R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, com.baidu.mobads.proxy.R.id.notification_title, str3);
        if (android.text.TextUtils.isEmpty(str4) && android.text.TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(com.baidu.mobads.proxy.R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(com.baidu.mobads.proxy.R.id.content_layout, 0);
            setRemoteViewText(remoteViews, com.baidu.mobads.proxy.R.id.content_text, str4);
            setRemoteViewText(remoteViews, com.baidu.mobads.proxy.R.id.content_status, str5);
        }
        if (i < 0 || i > 100) {
            remoteViews.setViewVisibility(com.baidu.mobads.proxy.R.id.progress_bar, 8);
        } else {
            int i3 = com.baidu.mobads.proxy.R.id.progress_bar;
            remoteViews.setProgressBar(i3, 100, i, false);
            remoteViews.setViewVisibility(i3, 0);
        }
        int i4 = com.baidu.mobads.proxy.R.id.btn_action;
        remoteViews.setTextViewText(i4, str6);
        remoteViews.setOnClickPendingIntent(i4, pendingIntent);
        return builder.setSmallIcon(i2).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(java.lang.System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }

    @android.annotation.TargetApi(16)
    public android.app.Notification getNewNotification(android.content.Context context, java.lang.String str, boolean z, android.graphics.Bitmap bitmap, java.lang.String str2, java.lang.String str3, int i, boolean z2, java.lang.String str4, android.app.PendingIntent pendingIntent, java.lang.String str5, android.app.PendingIntent pendingIntent2) {
        androidx.core.app.NotificationCompat.Builder builder;
        if (com.baidu.mobads.sdk.internal.bm.a(context).a() < 26) {
            builder = new androidx.core.app.NotificationCompat.Builder(context);
        } else {
            try {
                builder = new androidx.core.app.NotificationCompat.Builder(context, mChannel);
            } catch (java.lang.NoSuchMethodError unused) {
                builder = new androidx.core.app.NotificationCompat.Builder(context);
            }
        }
        android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(context.getPackageName(), com.baidu.mobads.proxy.R.layout.baidu_mobads_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(com.baidu.mobads.proxy.R.id.icon, bitmap);
        } else {
            remoteViews.setImageViewResource(com.baidu.mobads.proxy.R.id.icon, com.baidu.mobads.proxy.R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, com.baidu.mobads.proxy.R.id.title, str2);
        setRemoteViewText(remoteViews, com.baidu.mobads.proxy.R.id.desc, str3);
        if (i < 0 || i > 100) {
            remoteViews.setViewVisibility(com.baidu.mobads.proxy.R.id.progress, 8);
        } else {
            int i2 = com.baidu.mobads.proxy.R.id.progress;
            remoteViews.setProgressBar(i2, 100, i, z2);
            remoteViews.setViewVisibility(i2, 0);
        }
        int i3 = com.baidu.mobads.proxy.R.id.button1;
        remoteViews.setTextViewText(i3, str4);
        remoteViews.setOnClickPendingIntent(i3, pendingIntent);
        if (android.text.TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(com.baidu.mobads.proxy.R.id.button2, 8);
        } else {
            int i4 = com.baidu.mobads.proxy.R.id.button2;
            remoteViews.setViewVisibility(i4, 0);
            remoteViews.setTextViewText(i4, str5);
            remoteViews.setOnClickPendingIntent(i4, pendingIntent2);
        }
        return builder.setStyle(this.mStyle).setSmallIcon(mSmallIcon).setOngoing(false).setTicker(str).setAutoCancel(z).setWhen(java.lang.System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}

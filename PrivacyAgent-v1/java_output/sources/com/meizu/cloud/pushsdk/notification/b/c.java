package com.meizu.cloud.pushsdk.notification.b;

/* loaded from: classes23.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.a(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.e(this.a), messageV3.getContent());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.c.c.f(this.a), "setTime", java.lang.System.currentTimeMillis());
            a(remoteViews, messageV3);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), 8);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.h(this.a), 8);
            notification.contentView = remoteViews;
        }
    }

    public void a(android.widget.RemoteViews remoteViews, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.graphics.Bitmap a;
        if (messageV3.getAppIconSetting() == null || a() || messageV3.getAppIconSetting().isDefaultLargeIcon() || (a = a(messageV3.getAppIconSetting().getLargeIconUrl())) == null) {
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.k(this.a), a(this.a, messageV3.getUploadDataPackageName()));
        } else {
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.k(this.a), a);
        }
    }
}

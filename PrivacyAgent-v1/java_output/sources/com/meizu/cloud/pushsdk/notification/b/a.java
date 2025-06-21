package com.meizu.cloud.pushsdk.notification.b;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.notification.b.c {
    public a(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    private void b(android.widget.RemoteViews remoteViews, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.graphics.Bitmap a;
        if (messageV3.getNotificationStyle() == null || a()) {
            return;
        }
        if (android.text.TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getNotificationStyle().getExpandableImageUrl())) == null) {
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), 8);
        } else {
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), 0);
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.g(this.a), a);
        }
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent) {
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.a(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.d(this.a), messageV3.getTitle());
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.e(this.a), messageV3.getContent());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.c.c.f(this.a), "setTime", java.lang.System.currentTimeMillis());
            a(remoteViews, messageV3);
            b(remoteViews, messageV3);
            notification.bigContentView = remoteViews;
        }
    }
}

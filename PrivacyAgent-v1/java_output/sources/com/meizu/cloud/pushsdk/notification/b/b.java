package com.meizu.cloud.pushsdk.notification.b;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.notification.b.c {
    public b(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent) {
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.b(this.a));
            remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.d(this.a), messageV3.getTitle());
            remoteViews.setLong(com.meizu.cloud.pushsdk.notification.c.c.f(this.a), "setTime", java.lang.System.currentTimeMillis());
            a(remoteViews, messageV3);
            if (messageV3.getNotificationStyle() != null && !android.text.TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableText())) {
                remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.h(this.a), 0);
                remoteViews.setTextViewText(com.meizu.cloud.pushsdk.notification.c.c.h(this.a), messageV3.getNotificationStyle().getExpandableText());
            }
            notification.bigContentView = remoteViews;
        }
    }
}

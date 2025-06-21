package com.meizu.cloud.pushsdk.notification;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.notification.b.c {
    public b(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, android.app.PendingIntent pendingIntent) {
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.graphics.Bitmap a = a(messageV3.getNotificationStyle().getBannerImageUrl());
            if (a() || a == null) {
                return;
            }
            android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.c(this.a));
            remoteViews.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), a);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), 8);
            remoteViews.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), 0);
            notification.contentView = remoteViews;
            if (messageV3.getNotificationStyle().getInnerStyle() == com.meizu.cloud.pushsdk.notification.model.styleenum.InnerStyleLayout.EXPANDABLE_PIC.getCode()) {
                android.graphics.Bitmap a2 = a(messageV3.getNotificationStyle().getExpandableImageUrl());
                if (a() || a2 == null) {
                    return;
                }
                android.widget.RemoteViews remoteViews2 = new android.widget.RemoteViews(this.a.getPackageName(), com.meizu.cloud.pushsdk.notification.c.c.c(this.a));
                remoteViews2.setImageViewBitmap(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), a2);
                remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.j(this.a), 0);
                remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.i(this.a), 8);
                notification.bigContentView = remoteViews2;
                if (messageV3.getAdvertisementOption() == null || android.text.TextUtils.isEmpty(messageV3.getAdvertisementOption().getAdInstallPackage())) {
                    return;
                }
                remoteViews2.setViewVisibility(com.meizu.cloud.pushsdk.notification.c.c.m(this.a), 0);
                remoteViews2.setOnClickPendingIntent(com.meizu.cloud.pushsdk.notification.c.c.m(this.a), pendingIntent);
            }
        }
    }
}

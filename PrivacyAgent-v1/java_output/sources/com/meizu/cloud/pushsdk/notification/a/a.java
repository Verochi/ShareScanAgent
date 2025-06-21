package com.meizu.cloud.pushsdk.notification.a;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.notification.a.c {
    public a(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.graphics.Bitmap a;
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.app.Notification.BigPictureStyle bigPictureStyle = new android.app.Notification.BigPictureStyle();
            if (messageV3.getNotificationStyle() == null || a() || android.text.TextUtils.isEmpty(messageV3.getNotificationStyle().getExpandableImageUrl()) || (a = a(messageV3.getNotificationStyle().getExpandableImageUrl())) == null) {
                return;
            }
            bigPictureStyle.setBigContentTitle(messageV3.getTitle());
            bigPictureStyle.bigPicture(a);
            builder.setStyle(bigPictureStyle);
        }
    }
}

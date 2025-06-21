package com.meizu.cloud.pushsdk.notification.a;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.notification.a.c {
    public b(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationBuild()) {
            android.app.Notification.BigTextStyle bigTextStyle = new android.app.Notification.BigTextStyle();
            bigTextStyle.setBigContentTitle(messageV3.getTitle());
            bigTextStyle.bigText(messageV3.getNotificationStyle().getExpandableText());
            builder.setStyle(bigTextStyle);
        }
    }
}

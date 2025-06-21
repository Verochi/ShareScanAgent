package com.meizu.cloud.pushsdk.notification.a;

/* loaded from: classes23.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(android.app.Notification.Builder builder, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.notification.model.AppIconSetting appIconSetting;
        android.graphics.Bitmap a;
        java.lang.String str;
        if ((!com.meizu.cloud.pushsdk.util.MzSystemUtils.isInternational() || com.meizu.cloud.pushsdk.util.MzSystemUtils.isMeizuAndFlyme()) && (appIconSetting = messageV3.getAppIconSetting()) != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder = this.b;
                if (pushNotificationBuilder == null || pushNotificationBuilder.getLargeIcon() == 0) {
                    com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder2 = this.b;
                    if (pushNotificationBuilder2 == null || pushNotificationBuilder2.getAppLargeIcon() == null) {
                        a = a(this.a, messageV3.getUploadDataPackageName());
                        str = "set largeIcon by package default large icon";
                    } else {
                        a = this.b.getAppLargeIcon();
                        str = "set largeIcon by bitmap provided by user setting";
                    }
                } else {
                    a = android.graphics.BitmapFactory.decodeResource(this.a.getResources(), this.b.getLargeIcon());
                    str = "set largeIcon by resource id";
                }
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", str);
            } else {
                if (java.lang.Thread.currentThread() == this.a.getMainLooper().getThread()) {
                    return;
                }
                android.graphics.Bitmap a2 = a(appIconSetting.getLargeIconUrl());
                if (a2 != null) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a2);
                    return;
                }
                a = a(this.a, messageV3.getUploadDataPackageName());
            }
            builder.setLargeIcon(a);
        }
    }
}

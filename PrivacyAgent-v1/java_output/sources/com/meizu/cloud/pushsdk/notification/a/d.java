package com.meizu.cloud.pushsdk.notification.a;

/* loaded from: classes23.dex */
public class d extends com.meizu.cloud.pushsdk.notification.a.c {

    /* renamed from: com.meizu.cloud.pushsdk.notification.a.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (java.io.File file : com.meizu.cloud.pushsdk.notification.c.a.b(this.a, java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 86400000))) {
                com.meizu.cloud.pushsdk.notification.c.a.b(file.getPath());
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "Delete file directory " + file.getName() + "\n");
            }
        }
    }

    public d(android.content.Context context, com.meizu.cloud.pushsdk.notification.PushNotificationBuilder pushNotificationBuilder) {
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

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void a(android.app.Notification notification, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        super.a(notification, messageV3);
        com.meizu.cloud.pushsdk.handler.MessageV4 parse = com.meizu.cloud.pushsdk.handler.MessageV4.parse(messageV3);
        if (parse.getActVideoSetting() == null) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "only wifi can download act");
            return;
        }
        if (parse.getActVideoSetting().isWifiDisplay() && !com.meizu.cloud.pushsdk.util.a.b(this.a)) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractPushNotification", "only wifi can download act");
            return;
        }
        java.lang.String str = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdkAct/" + messageV3.getUploadDataPackageName();
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        java.lang.String actUrl = parse.getActVideoSetting().getActUrl();
        if (!android.text.TextUtils.isEmpty(actUrl) && com.meizu.cloud.pushsdk.c.a.a(actUrl, str, valueOf).a().c().b()) {
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", "down load " + actUrl + " success");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            java.lang.String str2 = java.io.File.separator;
            sb.append(str2);
            sb.append("ACT-");
            sb.append(valueOf);
            java.lang.String sb2 = sb.toString();
            boolean a = new com.meizu.cloud.pushsdk.notification.c.e(str + str2 + valueOf, sb2).a();
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("zip file ");
            sb3.append(a);
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractPushNotification", sb3.toString());
            if (a) {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("path", sb2);
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putBundle("big", bundle);
                if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportVideoNotification()) {
                    notification.extras.putBundle("flyme.active", bundle2);
                }
            }
        }
        com.meizu.cloud.pushsdk.d.b.a.b.a(new com.meizu.cloud.pushsdk.notification.a.d.AnonymousClass1(str));
    }
}

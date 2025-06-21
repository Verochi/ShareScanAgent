package com.heytap.mcssdk.b;

/* loaded from: classes22.dex */
public class a {
    private static final java.lang.String a = "Heytap PUSH";
    private static final java.lang.String b = "System Default Channel";
    private static final int c = 3;

    /* renamed from: com.heytap.mcssdk.b.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass1(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.heytap.mcssdk.utils.e.f().a()) {
                return;
            }
            java.lang.String string = this.a.getString(com.pushsdk.R.string.system_default_channel);
            if (android.text.TextUtils.isEmpty(string)) {
                string = com.heytap.mcssdk.b.a.b;
            }
            com.heytap.mcssdk.utils.e.f().a(com.heytap.mcssdk.b.a.this.a(this.a, com.heytap.mcssdk.b.a.a, string, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.TargetApi(26)
    public boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        android.app.NotificationManager notificationManager;
        if (context == null || (notificationManager = (android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)) == null) {
            return false;
        }
        notificationManager.createNotificationChannel(new android.app.NotificationChannel(str, str2, i));
        return true;
    }

    public void a(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return;
        }
        com.heytap.mcssdk.utils.f.a(new com.heytap.mcssdk.b.a.AnonymousClass1(context));
    }
}

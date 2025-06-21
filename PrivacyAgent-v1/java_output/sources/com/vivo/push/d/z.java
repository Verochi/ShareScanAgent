package com.vivo.push.d;

/* loaded from: classes19.dex */
public abstract class z extends com.vivo.push.l {
    protected com.vivo.push.sdk.PushMessageCallback b;

    public z(com.vivo.push.o oVar) {
        super(oVar);
    }

    public final void a(com.vivo.push.sdk.PushMessageCallback pushMessageCallback) {
        this.b = pushMessageCallback;
    }

    public final boolean a(java.security.PublicKey publicKey, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        if (!com.vivo.push.e.a().d()) {
            com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
            return true;
        }
        if (publicKey == null) {
            str3 = "vertify key is null";
        } else if (android.text.TextUtils.isEmpty(str)) {
            str3 = "contentTag is null";
        } else if (android.text.TextUtils.isEmpty(str2)) {
            str3 = "vertify id is null";
        } else {
            try {
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", str.hashCode() + " = " + str2);
                if (com.vivo.push.util.u.a(str.getBytes("UTF-8"), publicKey, android.util.Base64.decode(str2, 2))) {
                    com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify id is success");
                    return true;
                }
                com.vivo.push.util.p.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(str));
                com.vivo.push.util.p.c(this.a, "vertify fail srcDigest is ".concat(str));
                return false;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                str3 = "vertify exception";
            }
        }
        com.vivo.push.util.p.d("OnVerifyCallBackCommand", str3);
        return false;
    }

    public final int b() {
        android.app.NotificationChannel notificationChannel;
        int importance;
        boolean areNotificationsEnabled;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i < 24) {
            return 0;
        }
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) this.a.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            if (!areNotificationsEnabled) {
                return 2104;
            }
        }
        if (i < 26 || notificationManager == null) {
            return 0;
        }
        try {
            notificationChannel = notificationManager.getNotificationChannel(com.vivo.push.util.NotifyAdapterUtil.PRIMARY_CHANNEL);
            if (notificationChannel == null) {
                return 0;
            }
            importance = notificationChannel.getImportance();
            return importance == 0 ? 2121 : 0;
        } catch (java.lang.Exception unused) {
            com.vivo.push.util.p.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
            return 0;
        }
    }
}

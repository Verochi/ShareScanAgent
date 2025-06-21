package com.liulishuo.filedownloader.services;

@android.annotation.TargetApi(26)
/* loaded from: classes23.dex */
public class ForegroundServiceConfig {
    public int a;
    public java.lang.String b;
    public java.lang.String c;
    public android.app.Notification d;
    public boolean e;

    public static class Builder {
        public int a;
        public java.lang.String b;
        public java.lang.String c;
        public android.app.Notification d;
        public boolean e;

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig build() {
            com.liulishuo.filedownloader.services.ForegroundServiceConfig foregroundServiceConfig = new com.liulishuo.filedownloader.services.ForegroundServiceConfig(null);
            java.lang.String str = this.b;
            if (str == null) {
                str = "filedownloader_channel";
            }
            foregroundServiceConfig.setNotificationChannelId(str);
            java.lang.String str2 = this.c;
            if (str2 == null) {
                str2 = "Filedownloader";
            }
            foregroundServiceConfig.setNotificationChannelName(str2);
            int i = this.a;
            if (i == 0) {
                i = android.R.drawable.arrow_down_float;
            }
            foregroundServiceConfig.setNotificationId(i);
            foregroundServiceConfig.setNeedRecreateChannelId(this.e);
            foregroundServiceConfig.setNotification(this.d);
            return foregroundServiceConfig;
        }

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder needRecreateChannelId(boolean z) {
            this.e = z;
            return this;
        }

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder notification(android.app.Notification notification) {
            this.d = notification;
            return this;
        }

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder notificationChannelId(java.lang.String str) {
            this.b = str;
            return this;
        }

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder notificationChannelName(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.liulishuo.filedownloader.services.ForegroundServiceConfig.Builder notificationId(int i) {
            this.a = i;
            return this;
        }
    }

    public ForegroundServiceConfig() {
    }

    public /* synthetic */ ForegroundServiceConfig(com.liulishuo.filedownloader.services.ForegroundServiceConfig.AnonymousClass1 anonymousClass1) {
        this();
    }

    public final android.app.Notification a(android.content.Context context) {
        java.lang.String string = context.getString(com.liulishuo.filedownloader.R.string.default_filedownloader_notification_title);
        java.lang.String string2 = context.getString(com.liulishuo.filedownloader.R.string.default_filedownloader_notification_content);
        android.app.Notification.Builder builder = new android.app.Notification.Builder(context, this.b);
        builder.setContentTitle(string).setContentText(string2).setSmallIcon(android.R.drawable.arrow_down_float);
        return builder.build();
    }

    public android.app.Notification getNotification(android.content.Context context) {
        if (this.d == null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "build default notification", new java.lang.Object[0]);
            }
            this.d = a(context);
        }
        return this.d;
    }

    public java.lang.String getNotificationChannelId() {
        return this.b;
    }

    public java.lang.String getNotificationChannelName() {
        return this.c;
    }

    public int getNotificationId() {
        return this.a;
    }

    public boolean isNeedRecreateChannelId() {
        return this.e;
    }

    public void setNeedRecreateChannelId(boolean z) {
        this.e = z;
    }

    public void setNotification(android.app.Notification notification) {
        this.d = notification;
    }

    public void setNotificationChannelId(java.lang.String str) {
        this.b = str;
    }

    public void setNotificationChannelName(java.lang.String str) {
        this.c = str;
    }

    public void setNotificationId(int i) {
        this.a = i;
    }

    public java.lang.String toString() {
        return "ForegroundServiceConfig{notificationId=" + this.a + ", notificationChannelId='" + this.b + "', notificationChannelName='" + this.c + "', notification=" + this.d + ", needRecreateChannelId=" + this.e + '}';
    }
}

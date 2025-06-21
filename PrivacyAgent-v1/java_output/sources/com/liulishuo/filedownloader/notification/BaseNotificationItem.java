package com.liulishuo.filedownloader.notification;

/* loaded from: classes23.dex */
public abstract class BaseNotificationItem {
    public int a;
    public int b;
    public int c;
    public java.lang.String d;
    public java.lang.String e;
    public int f = 0;
    public int g = 0;
    public android.app.NotificationManager h;

    public BaseNotificationItem(int i, java.lang.String str, java.lang.String str2) {
        this.a = i;
        this.d = str;
        this.e = str2;
    }

    public void cancel() {
        getManager().cancel(this.a);
    }

    public java.lang.String getDesc() {
        return this.e;
    }

    public int getId() {
        return this.a;
    }

    public int getLastStatus() {
        return this.g;
    }

    public android.app.NotificationManager getManager() {
        if (this.h == null) {
            this.h = (android.app.NotificationManager) com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        }
        return this.h;
    }

    public int getSofar() {
        return this.b;
    }

    public int getStatus() {
        int i = this.f;
        this.g = i;
        return i;
    }

    public java.lang.String getTitle() {
        return this.d;
    }

    public int getTotal() {
        return this.c;
    }

    public boolean isChanged() {
        return this.g != this.f;
    }

    public void setDesc(java.lang.String str) {
        this.e = str;
    }

    public void setId(int i) {
        this.a = i;
    }

    public void setSofar(int i) {
        this.b = i;
    }

    public void setStatus(int i) {
        this.f = i;
    }

    public void setTitle(java.lang.String str) {
        this.d = str;
    }

    public void setTotal(int i) {
        this.c = i;
    }

    public void show(boolean z) {
        show(isChanged(), getStatus(), z);
    }

    public abstract void show(boolean z, int i, boolean z2);

    public void update(int i, int i2) {
        this.b = i;
        this.c = i2;
        show(true);
    }

    public void updateStatus(int i) {
        this.f = i;
    }
}

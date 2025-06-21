package com.huawei.hms.adapter;

/* loaded from: classes22.dex */
public class CoreBaseResponse implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public android.content.Intent intent;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String jsonBody;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String jsonHeader;

    @com.huawei.hms.core.aidl.annotation.Packed
    public android.app.PendingIntent pendingIntent;

    public android.content.Intent getIntent() {
        return this.intent;
    }

    public java.lang.String getJsonBody() {
        return this.jsonBody;
    }

    public java.lang.String getJsonHeader() {
        return this.jsonHeader;
    }

    public android.app.PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setIntent(android.content.Intent intent) {
        this.intent = intent;
    }

    public void setJsonBody(java.lang.String str) {
        this.jsonBody = str;
    }

    public void setJsonHeader(java.lang.String str) {
        this.jsonHeader = str;
    }

    public void setPendingIntent(android.app.PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }
}

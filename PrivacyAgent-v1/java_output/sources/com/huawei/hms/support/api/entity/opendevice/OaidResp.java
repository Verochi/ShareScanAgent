package com.huawei.hms.support.api.entity.opendevice;

/* loaded from: classes22.dex */
public class OaidResp extends com.huawei.hms.core.aidl.AbstractMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String id;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isTrackLimited;

    @com.huawei.hms.core.aidl.annotation.Packed
    public android.app.PendingIntent settingIntent;

    public java.lang.String getId() {
        return this.id;
    }

    public android.app.PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public void setSettingIntent(android.app.PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z) {
        this.isTrackLimited = z;
    }
}

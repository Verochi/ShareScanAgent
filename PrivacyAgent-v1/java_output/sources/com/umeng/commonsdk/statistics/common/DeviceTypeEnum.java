package com.umeng.commonsdk.statistics.common;

/* loaded from: classes19.dex */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID("android_id", "android_id"),
    MAC("mac", "mac"),
    SERIALNO("serial_no", "serial_no"),
    IDFA(com.anythink.expressad.foundation.g.a.bj, com.anythink.expressad.foundation.g.a.bj),
    DEFAULT(com.igexin.push.core.b.m, com.igexin.push.core.b.m);

    private java.lang.String description;
    private java.lang.String deviceIdType;

    DeviceTypeEnum(java.lang.String str, java.lang.String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public java.lang.String getDeviceIdType() {
        return this.deviceIdType;
    }
}

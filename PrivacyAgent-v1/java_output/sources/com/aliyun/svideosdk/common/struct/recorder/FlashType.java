package com.aliyun.svideosdk.common.struct.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum FlashType {
    OFF(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF),
    ON(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON),
    AUTO("auto"),
    TORCH("torch");

    private java.lang.String type;

    FlashType(java.lang.String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return this.type;
    }
}

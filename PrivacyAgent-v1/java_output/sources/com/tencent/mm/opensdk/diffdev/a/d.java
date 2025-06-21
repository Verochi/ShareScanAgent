package com.tencent.mm.opensdk.diffdev.a;

/* loaded from: classes19.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(com.bytedance.sdk.openadsdk.TTAdConstant.INTERACTION_TYPE_CODE),
    UUID_ERROR(500);

    private int a;

    d(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Enum
    public java.lang.String toString() {
        return "UUIDStatusCode:" + this.a;
    }
}

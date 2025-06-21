package com.aliyun.svideosdk.conan;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public enum AlivcConanBusinessType {
    AlivcConanBusinessNone(0),
    AlivcConanBusinessSvideo(1),
    AlivcConanBusinessPusher(2),
    AlivcConanBusinessPlayer(3),
    AlivcConanBusinessIlive(4),
    AlivcConanBusinessWboard(5);

    private int a;

    @com.aliyun.svideosdk.conan.DoNotProguard
    AlivcConanBusinessType(int i) {
        this.a = i;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int getBizType() {
        return this.a;
    }
}

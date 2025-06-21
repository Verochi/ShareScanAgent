package com.aliyun.svideosdk.conan;

@com.aliyun.svideosdk.conan.DoNotProguard
/* loaded from: classes12.dex */
public enum AlivcSDKEnvironment {
    ENV_DAILY(1),
    ENV_PRE(2),
    EN_ONLINE(3);

    private int a;

    @com.aliyun.svideosdk.conan.DoNotProguard
    AlivcSDKEnvironment(int i) {
        this.a = i;
    }

    @com.aliyun.svideosdk.conan.DoNotProguard
    public int getSDKEnv() {
        return this.a;
    }
}

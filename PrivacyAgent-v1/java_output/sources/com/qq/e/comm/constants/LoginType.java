package com.qq.e.comm.constants;

/* loaded from: classes19.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);

    private int a;

    LoginType(int i) {
        this.a = i;
        ordinal();
    }

    public int getValue() {
        return this.a;
    }
}

package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public enum g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, "none");

    public int a;
    public java.lang.String b;

    g(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public static com.alipay.sdk.m.u.g a(int i) {
        for (com.alipay.sdk.m.u.g gVar : values()) {
            if (gVar.a() == i) {
                return gVar;
            }
        }
        return NONE;
    }

    public final int a() {
        return this.a;
    }

    public final java.lang.String b() {
        return this.b;
    }
}

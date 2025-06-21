package com.huawei.agconnect;

/* loaded from: classes22.dex */
public final class AGCRoutePolicy {
    public final int a;
    public static final com.huawei.agconnect.AGCRoutePolicy UNKNOWN = new com.huawei.agconnect.AGCRoutePolicy(0);
    public static final com.huawei.agconnect.AGCRoutePolicy CHINA = new com.huawei.agconnect.AGCRoutePolicy(1);
    public static final com.huawei.agconnect.AGCRoutePolicy GERMANY = new com.huawei.agconnect.AGCRoutePolicy(2);
    public static final com.huawei.agconnect.AGCRoutePolicy RUSSIA = new com.huawei.agconnect.AGCRoutePolicy(3);
    public static final com.huawei.agconnect.AGCRoutePolicy SINGAPORE = new com.huawei.agconnect.AGCRoutePolicy(4);

    public AGCRoutePolicy(int i) {
        this.a = i;
    }

    public final int a(java.lang.Object... objArr) {
        return java.util.Arrays.hashCode(objArr);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && com.huawei.agconnect.AGCRoutePolicy.class == obj.getClass() && this.a == ((com.huawei.agconnect.AGCRoutePolicy) obj).a;
    }

    public java.lang.String getRouteName() {
        int i = this.a;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN : "SG" : "RU" : "DE" : "CN";
    }

    public int hashCode() {
        return a(java.lang.Integer.valueOf(this.a));
    }
}

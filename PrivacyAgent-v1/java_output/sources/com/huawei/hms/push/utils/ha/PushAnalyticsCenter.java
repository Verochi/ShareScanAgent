package com.huawei.hms.push.utils.ha;

/* loaded from: classes22.dex */
public class PushAnalyticsCenter {
    public com.huawei.hms.push.utils.ha.PushBaseAnalytics a;

    public static class a {
        public static com.huawei.hms.push.utils.ha.PushAnalyticsCenter a = new com.huawei.hms.push.utils.ha.PushAnalyticsCenter();
    }

    public static com.huawei.hms.push.utils.ha.PushAnalyticsCenter getInstance() {
        return com.huawei.hms.push.utils.ha.PushAnalyticsCenter.a.a;
    }

    public com.huawei.hms.push.utils.ha.PushBaseAnalytics getPushAnalytics() {
        return this.a;
    }

    public void register(com.huawei.hms.push.utils.ha.PushBaseAnalytics pushBaseAnalytics) {
        this.a = pushBaseAnalytics;
    }
}

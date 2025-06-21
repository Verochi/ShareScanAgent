package com.huawei.hms.framework.network.grs.h;

/* loaded from: classes22.dex */
public class d {
    private static final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.h.d.a> a = new java.util.concurrent.ConcurrentHashMap(16);

    public static class a {
        private final long a;
        private final long b;

        public a(long j, long j2) {
            this.a = j;
            this.b = j2;
        }

        public boolean a() {
            return android.os.SystemClock.elapsedRealtime() - this.b <= this.a;
        }
    }

    public static com.huawei.hms.framework.network.grs.h.d.a a(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("map size of get is before:");
        java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.h.d.a> map = a;
        sb.append(map.size());
        com.huawei.hms.framework.common.Logger.v("RequestUtil", sb.toString());
        com.huawei.hms.framework.network.grs.h.d.a aVar = map.get(str);
        com.huawei.hms.framework.common.Logger.v("RequestUtil", "map size of get is after:" + map.size());
        return aVar;
    }

    public static void a(java.lang.String str, com.huawei.hms.framework.network.grs.h.d.a aVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("map size of put is before:");
        java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.h.d.a> map = a;
        sb.append(map.size());
        com.huawei.hms.framework.common.Logger.v("RequestUtil", sb.toString());
        map.put(str, aVar);
        com.huawei.hms.framework.common.Logger.v("RequestUtil", "map size of put is after:" + map.size());
    }
}

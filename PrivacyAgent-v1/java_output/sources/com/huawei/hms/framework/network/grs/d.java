package com.huawei.hms.framework.network.grs;

/* loaded from: classes22.dex */
public class d {
    private static final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.c> a = new java.util.concurrent.ConcurrentHashMap(16);
    private static final java.lang.Object b = new java.lang.Object();

    public static com.huawei.hms.framework.network.grs.c a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, android.content.Context context) {
        synchronized (b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.c> map = a;
            com.huawei.hms.framework.network.grs.c cVar = map.get(context.getPackageName() + uniqueCode);
            if (cVar == null) {
                com.huawei.hms.framework.network.grs.c cVar2 = new com.huawei.hms.framework.network.grs.c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar2);
                return cVar2;
            }
            if (cVar.a((java.lang.Object) new com.huawei.hms.framework.network.grs.c(grsBaseInfo))) {
                return cVar;
            }
            com.huawei.hms.framework.network.grs.c cVar3 = new com.huawei.hms.framework.network.grs.c(context, grsBaseInfo);
            map.put(context.getPackageName() + uniqueCode, cVar3);
            return cVar3;
        }
    }
}

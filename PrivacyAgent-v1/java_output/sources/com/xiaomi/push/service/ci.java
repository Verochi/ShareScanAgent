package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ci {
    private static final java.util.Map<java.lang.String, java.lang.Long> a = new java.util.HashMap();

    private static void a() {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        java.util.Map<java.lang.String, java.lang.Long> map = a;
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : map.entrySet()) {
            if (elapsedRealtime - entry.getValue().longValue() > 60000) {
                arrayList.add(entry.getKey());
            }
        }
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a.remove((java.lang.String) it.next());
        }
    }

    public static boolean a(byte[] bArr, java.lang.String str) {
        boolean z = false;
        if (bArr != null && bArr.length > 0 && !android.text.TextUtils.isEmpty(str)) {
            java.lang.String a2 = com.xiaomi.push.ao.a(bArr);
            if (!android.text.TextUtils.isEmpty(a2)) {
                java.util.Map<java.lang.String, java.lang.Long> map = a;
                synchronized (map) {
                    if (map.get(a2 + str) != null) {
                        z = true;
                    } else {
                        map.put(a2 + str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                    }
                    a();
                }
            }
        }
        return z;
    }
}

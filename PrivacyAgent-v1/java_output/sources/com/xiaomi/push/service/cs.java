package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class cs {
    private static final java.util.Map<java.lang.String, byte[]> a = new java.util.HashMap();
    private static java.util.ArrayList<android.util.Pair<java.lang.String, byte[]>> b = new java.util.ArrayList<>();

    public static void a(android.content.Context context, int i, java.lang.String str) {
        java.util.Map<java.lang.String, byte[]> map = a;
        synchronized (map) {
            for (java.lang.String str2 : map.keySet()) {
                com.xiaomi.channel.commonutils.logger.b.a("notify registration error. ".concat(java.lang.String.valueOf(str2)));
                a(context, str2, a.get(str2), i, str);
            }
            a.clear();
        }
    }

    public static void a(android.content.Context context, java.lang.String str, byte[] bArr, int i, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, com.xiaomi.push.service.l.a(str));
    }

    public static void a(com.xiaomi.push.service.c cVar) {
        try {
            java.util.Map<java.lang.String, byte[]> map = a;
            synchronized (map) {
                for (java.lang.String str : map.keySet()) {
                    com.xiaomi.channel.commonutils.logger.b.a("processing pending registration request. ".concat(java.lang.String.valueOf(str)));
                    com.xiaomi.push.service.l.a(cVar, str, a.get(str));
                    if (!com.xiaomi.push.jd.a()) {
                        try {
                            java.lang.Thread.sleep(200L);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                }
                a.clear();
            }
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to deal with pending register request. ".concat(java.lang.String.valueOf(e)));
            cVar.a(10, e);
        }
    }

    public static void a(java.lang.String str, byte[] bArr) {
        java.util.Map<java.lang.String, byte[]> map = a;
        synchronized (map) {
            com.xiaomi.channel.commonutils.logger.b.a("pending registration request. ".concat(java.lang.String.valueOf(str)));
            map.put(str, bArr);
        }
    }

    public static void b(com.xiaomi.push.service.c cVar) {
        java.util.ArrayList<android.util.Pair<java.lang.String, byte[]>> arrayList;
        try {
            synchronized (b) {
                arrayList = b;
                b = new java.util.ArrayList<>();
            }
            boolean a2 = com.xiaomi.push.jd.a();
            java.util.Iterator<android.util.Pair<java.lang.String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                android.util.Pair<java.lang.String, byte[]> next = it.next();
                com.xiaomi.push.service.l.a(cVar, (java.lang.String) next.first, (byte[]) next.second);
                if (!a2) {
                    try {
                        java.lang.Thread.sleep(100L);
                    } catch (java.lang.InterruptedException unused) {
                    }
                }
            }
        } catch (com.xiaomi.push.fh e) {
            com.xiaomi.channel.commonutils.logger.b.d("meet error when process pending message. ".concat(java.lang.String.valueOf(e)));
            cVar.a(10, e);
        }
    }

    public static void b(java.lang.String str, byte[] bArr) {
        synchronized (b) {
            b.add(new android.util.Pair<>(str, bArr));
            if (b.size() > 50) {
                b.remove(0);
            }
        }
    }
}

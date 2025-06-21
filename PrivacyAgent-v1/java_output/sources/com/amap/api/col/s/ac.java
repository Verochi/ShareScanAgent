package com.amap.api.col.s;

/* loaded from: classes12.dex */
final class ac {
    public static volatile boolean a;

    public static synchronized void a() {
        synchronized (com.amap.api.col.s.ac.class) {
            if (!a) {
                com.amap.api.col.s.ad.a().a("regeo", new com.amap.api.col.s.af("/geocode/regeo"));
                com.amap.api.col.s.ad.a().a("placeAround", new com.amap.api.col.s.af("/place/around"));
                com.amap.api.col.s.ad.a().a("placeText", new com.amap.api.col.s.ae("/place/text"));
                com.amap.api.col.s.ad.a().a("geo", new com.amap.api.col.s.ae("/geocode/geo"));
                a = true;
            }
        }
    }
}

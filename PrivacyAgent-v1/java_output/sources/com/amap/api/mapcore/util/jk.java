package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class jk {
    private static volatile com.amap.api.mapcore.util.jk g;
    private static java.lang.Object h = new java.lang.Object();
    private java.lang.Object e = new java.lang.Object();
    private java.lang.Object f = new java.lang.Object();
    private android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> a = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> b = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> c = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> d = new android.util.LongSparseArray<>();

    public static class a {
        int a;
        long b;
        boolean c;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    private jk() {
    }

    public static com.amap.api.mapcore.util.jk a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new com.amap.api.mapcore.util.jk();
                }
            }
        }
        return g;
    }

    private static void a(java.util.List<com.amap.api.mapcore.util.jj> list, android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> longSparseArray, android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> longSparseArray2) {
        long b = b();
        int size = longSparseArray.size();
        java.util.Iterator<com.amap.api.mapcore.util.jj> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                com.amap.api.mapcore.util.jj next = it.next();
                com.amap.api.mapcore.util.jk.a aVar = new com.amap.api.mapcore.util.jk.a((byte) 0);
                aVar.a = next.b();
                aVar.b = b;
                aVar.c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it.hasNext()) {
            com.amap.api.mapcore.util.jj next2 = it.next();
            long a2 = next2.a();
            com.amap.api.mapcore.util.jk.a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new com.amap.api.mapcore.util.jk.a((byte) 0);
            } else if (aVar2.a == next2.b()) {
                longSparseArray2.put(a2, aVar2);
            }
            aVar2.a = next2.b();
            aVar2.b = b;
            aVar2.c = true;
            longSparseArray2.put(a2, aVar2);
        }
    }

    private static long b() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public final void a(java.util.List<com.amap.api.mapcore.util.jj> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.a, this.b);
            android.util.LongSparseArray<com.amap.api.mapcore.util.jk.a> longSparseArray = this.a;
            this.a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }
}

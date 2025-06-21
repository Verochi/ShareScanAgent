package com.loc;

/* loaded from: classes23.dex */
public final class dw {
    private static volatile com.loc.dw g;
    private static java.lang.Object h = new java.lang.Object();
    private java.lang.Object e = new java.lang.Object();
    private java.lang.Object f = new java.lang.Object();
    private android.util.LongSparseArray<com.loc.dw.a> a = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.loc.dw.a> b = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.loc.dw.a> c = new android.util.LongSparseArray<>();
    private android.util.LongSparseArray<com.loc.dw.a> d = new android.util.LongSparseArray<>();

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

    private dw() {
    }

    public static com.loc.dw a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new com.loc.dw();
                }
            }
        }
        return g;
    }

    private static short a(android.util.LongSparseArray<com.loc.dw.a> longSparseArray, long j) {
        synchronized (longSparseArray) {
            com.loc.dw.a aVar = longSparseArray.get(j);
            if (aVar == null) {
                return (short) 0;
            }
            short max = (short) java.lang.Math.max(1L, java.lang.Math.min(32767L, (b() - aVar.b) / 1000));
            if (!aVar.c) {
                max = (short) (-max);
            }
            return max;
        }
    }

    private static void a(java.util.List<com.loc.dv> list, android.util.LongSparseArray<com.loc.dw.a> longSparseArray, android.util.LongSparseArray<com.loc.dw.a> longSparseArray2) {
        long b = b();
        int size = longSparseArray.size();
        java.util.Iterator<com.loc.dv> it = list.iterator();
        if (size == 0) {
            while (it.hasNext()) {
                com.loc.dv next = it.next();
                com.loc.dw.a aVar = new com.loc.dw.a((byte) 0);
                aVar.a = next.b();
                aVar.b = b;
                aVar.c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it.hasNext()) {
            com.loc.dv next2 = it.next();
            long a2 = next2.a();
            com.loc.dw.a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new com.loc.dw.a((byte) 0);
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

    public final short a(long j) {
        return a(this.a, j);
    }

    public final void a(java.util.List<com.loc.dv> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.e) {
            a(list, this.a, this.b);
            android.util.LongSparseArray<com.loc.dw.a> longSparseArray = this.a;
            this.a = this.b;
            this.b = longSparseArray;
            longSparseArray.clear();
        }
    }

    public final short b(long j) {
        return a(this.c, j);
    }

    public final void b(java.util.List<com.loc.dv> list) {
        if (list.isEmpty()) {
            return;
        }
        synchronized (this.f) {
            a(list, this.c, this.d);
            android.util.LongSparseArray<com.loc.dw.a> longSparseArray = this.c;
            this.c = this.d;
            this.d = longSparseArray;
            longSparseArray.clear();
        }
    }
}

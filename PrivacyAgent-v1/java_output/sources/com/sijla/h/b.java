package com.sijla.h;

/* loaded from: classes19.dex */
final class b implements java.lang.Runnable {
    private /* synthetic */ com.sijla.h.a.C0454a a;

    public b(com.sijla.h.a.C0454a c0454a) {
        this.a = c0454a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        java.util.concurrent.atomic.AtomicLong atomicLong;
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        java.util.Map map;
        java.io.File[] listFiles = this.a.a.listFiles();
        if (listFiles != null) {
            int i = 0;
            int i2 = 0;
            for (java.io.File file : listFiles) {
                i = (int) (i + file.length());
                i2++;
                map = this.a.f;
                map.put(file, java.lang.Long.valueOf(file.lastModified()));
            }
            atomicLong = this.a.b;
            atomicLong.set(i);
            atomicInteger = this.a.c;
            atomicInteger.set(i2);
        }
    }
}

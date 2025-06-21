package com.meizu.cloud.pushsdk.d.d;

/* loaded from: classes23.dex */
public class c implements com.meizu.cloud.pushsdk.d.d.d {
    private final int a;
    private final java.util.concurrent.atomic.AtomicLong b = new java.util.concurrent.atomic.AtomicLong(0);
    private final java.util.Map<java.lang.Long, byte[]> c = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.List<java.lang.Long> d = new java.util.concurrent.CopyOnWriteArrayList();

    public c(int i) {
        this.a = i;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public void a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        b(aVar);
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a() {
        return true;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public boolean a(long j) {
        return this.d.remove(java.lang.Long.valueOf(j)) && this.c.remove(java.lang.Long.valueOf(j)) != null;
    }

    public long b(com.meizu.cloud.pushsdk.d.a.a aVar) {
        byte[] a = com.meizu.cloud.pushsdk.d.d.a.a((java.util.Map<java.lang.String, java.lang.String>) aVar.a());
        long andIncrement = this.b.getAndIncrement();
        this.d.add(java.lang.Long.valueOf(andIncrement));
        this.c.put(java.lang.Long.valueOf(andIncrement), a);
        return andIncrement;
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public long c() {
        return this.d.size();
    }

    @Override // com.meizu.cloud.pushsdk.d.d.d
    public com.meizu.cloud.pushsdk.d.b.c d() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int c = (int) c();
        int i = this.a;
        if (c > i) {
            c = i;
        }
        for (int i2 = 0; i2 < c; i2++) {
            java.lang.Long l = this.d.get(i2);
            if (l != null) {
                com.meizu.cloud.pushsdk.d.a.c cVar = new com.meizu.cloud.pushsdk.d.a.c();
                cVar.a(com.meizu.cloud.pushsdk.d.d.a.a(this.c.get(l)));
                com.meizu.cloud.pushsdk.d.f.c.c("MemoryStore", " current key " + l + " payload " + cVar, new java.lang.Object[0]);
                linkedList.add(l);
                arrayList.add(cVar);
            }
        }
        return new com.meizu.cloud.pushsdk.d.b.c(arrayList, linkedList);
    }
}

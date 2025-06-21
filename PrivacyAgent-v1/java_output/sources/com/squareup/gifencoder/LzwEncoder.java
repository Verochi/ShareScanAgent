package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class LzwEncoder {
    public static final java.util.List<java.lang.Integer> g = java.util.Collections.singletonList(-1);
    public static final java.util.List<java.lang.Integer> h = java.util.Collections.singletonList(-2);
    public final int a;
    public java.util.Map<java.util.List<java.lang.Integer>, java.lang.Integer> d;
    public int e;
    public final java.util.BitSet b = new java.util.BitSet();
    public int c = 0;
    public java.util.List<java.lang.Integer> f = new java.util.ArrayList();

    public LzwEncoder(int i) {
        if (!com.squareup.gifencoder.GifMath.a(i)) {
            throw new java.lang.IllegalArgumentException("Color table size must be a power of 2");
        }
        this.a = c(i);
        h();
    }

    public static <T> java.util.List<T> b(java.util.List<T> list, T t) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list);
        arrayList.add(t);
        return arrayList;
    }

    public static int c(int i) {
        int i2 = 2;
        while (i > (1 << i2)) {
            i2++;
        }
        return i2;
    }

    public final void a(java.util.List<java.lang.Integer> list) {
        int size = this.d.size();
        this.d.put(list, java.lang.Integer.valueOf(size));
        int i = this.e;
        if (size == (1 << i)) {
            this.e = i + 1;
        }
    }

    public final java.util.Map<java.util.List<java.lang.Integer>, java.lang.Integer> d() {
        java.util.HashMap hashMap = new java.util.HashMap();
        int i = 1 << this.a;
        for (int i2 = 0; i2 < i; i2++) {
            hashMap.put(java.util.Collections.singletonList(java.lang.Integer.valueOf(i2)), java.lang.Integer.valueOf(i2));
        }
        hashMap.put(g, java.lang.Integer.valueOf(hashMap.size()));
        hashMap.put(h, java.lang.Integer.valueOf(hashMap.size()));
        return hashMap;
    }

    public byte[] e(int[] iArr) {
        j(this.d.get(g).intValue());
        for (int i : iArr) {
            g(i);
        }
        j(this.d.get(this.f).intValue());
        j(this.d.get(h).intValue());
        return i();
    }

    public int f() {
        return this.a;
    }

    public final void g(int i) {
        java.util.List<java.lang.Integer> b = b(this.f, java.lang.Integer.valueOf(i));
        if (this.d.containsKey(b)) {
            this.f = b;
            return;
        }
        j(this.d.get(this.f).intValue());
        if (this.d.size() == 4096) {
            j(this.d.get(g).intValue());
            h();
        } else {
            a(b);
        }
        this.f = java.util.Collections.singletonList(java.lang.Integer.valueOf(i));
    }

    public final void h() {
        this.d = d();
        this.e = this.a + 1;
    }

    public final byte[] i() {
        int i = this.c;
        byte[] bArr = new byte[(i + 7) / 8];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 / 8;
            bArr[i3] = (byte) (((this.b.get(i2) ? 1 : 0) << (i2 % 8)) | bArr[i3]);
        }
        return bArr;
    }

    public final void j(int i) {
        for (int i2 = 0; i2 < this.e; i2++) {
            boolean z = true;
            if (((i >>> i2) & 1) == 0) {
                z = false;
            }
            java.util.BitSet bitSet = this.b;
            int i3 = this.c;
            this.c = i3 + 1;
            bitSet.set(i3, z);
        }
    }
}

package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes22.dex */
class ObjectCountLinkedHashMap<K> extends com.google.common.collect.ObjectCountHashMap<K> {

    @com.google.common.annotations.VisibleForTesting
    public transient long[] i;
    public transient int j;
    public transient int k;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public ObjectCountLinkedHashMap(int i) {
        this(i, 1.0f);
    }

    public ObjectCountLinkedHashMap(int i, float f) {
        super(i, f);
    }

    public ObjectCountLinkedHashMap(com.google.common.collect.ObjectCountHashMap<K> objectCountHashMap) {
        n(objectCountHashMap.C(), 1.0f);
        int e = objectCountHashMap.e();
        while (e != -1) {
            u(objectCountHashMap.i(e), objectCountHashMap.k(e));
            e = objectCountHashMap.s(e);
        }
    }

    public final int E(int i) {
        return (int) (this.i[i] >>> 32);
    }

    public final int F(int i) {
        return (int) this.i[i];
    }

    public final void G(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT) | (i2 << 32);
    }

    public final void H(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            I(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            G(i2, i);
        }
    }

    public final void I(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int e() {
        int i = this.j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void n(int i, float f) {
        super.n(i, f);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i];
        this.i = jArr;
        java.util.Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void o(int i, K k, int i2, int i3) {
        super.o(i, k, i2, i3);
        H(this.k, i);
        H(i, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void p(int i) {
        int C = C() - 1;
        H(E(i), F(i));
        if (i < C) {
            H(E(C), i);
            H(i, F(C));
        }
        super.p(i);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int s(int i) {
        int F = F(i);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int t(int i, int i2) {
        return i == C() ? i2 : i;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void y(int i) {
        super.y(i);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = java.util.Arrays.copyOf(jArr, i);
        this.i = copyOf;
        java.util.Arrays.fill(copyOf, length, i, -1L);
    }
}

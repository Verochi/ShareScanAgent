package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public class jad_hu<T, Y> {
    public final java.util.Map<T, com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y>> jad_an = new java.util.LinkedHashMap(100, 0.75f, true);
    public long jad_bo;
    public long jad_cp;

    public static final class jad_an<Y> {
        public final Y jad_an;
        public final int jad_bo;

        public jad_an(Y y, int i) {
            this.jad_an = y;
            this.jad_bo = i;
        }
    }

    public jad_hu(long j) {
        this.jad_bo = j;
    }

    @androidx.annotation.Nullable
    public synchronized Y jad_an(@androidx.annotation.NonNull T t) {
        com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y> jad_anVar;
        jad_anVar = this.jad_an.get(t);
        return jad_anVar != null ? jad_anVar.jad_an : null;
    }

    public synchronized void jad_an(long j) {
        while (this.jad_cp > j) {
            java.util.Iterator<java.util.Map.Entry<T, com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y>>> it = this.jad_an.entrySet().iterator();
            java.util.Map.Entry<T, com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y>> next = it.next();
            com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y> value = next.getValue();
            this.jad_cp -= value.jad_bo;
            T key = next.getKey();
            it.remove();
            jad_an(key, value.jad_an);
        }
    }

    public void jad_an(@androidx.annotation.NonNull T t, @androidx.annotation.Nullable Y y) {
    }

    public int jad_bo(@androidx.annotation.Nullable Y y) {
        return 1;
    }

    @androidx.annotation.Nullable
    public synchronized Y jad_bo(@androidx.annotation.NonNull T t, @androidx.annotation.Nullable Y y) {
        int jad_bo = jad_bo(y);
        long j = jad_bo;
        if (j >= this.jad_bo) {
            jad_an(t, y);
            return null;
        }
        if (y != null) {
            this.jad_cp += j;
        }
        com.jd.ad.sdk.jad_ir.jad_hu.jad_an<Y> put = this.jad_an.put(t, y == null ? null : new com.jd.ad.sdk.jad_ir.jad_hu.jad_an<>(y, jad_bo));
        if (put != null) {
            this.jad_cp -= put.jad_bo;
            if (!put.jad_an.equals(y)) {
                jad_an(t, put.jad_an);
            }
        }
        jad_an(this.jad_bo);
        return put != null ? put.jad_an : null;
    }
}

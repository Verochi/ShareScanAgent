package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public class jad_hu<K extends com.jd.ad.sdk.jad_ny.jad_mz, V> {
    public final com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_an = new com.jd.ad.sdk.jad_ny.jad_hu.jad_an<>();
    public final java.util.Map<K, com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V>> jad_bo = new java.util.HashMap();

    public static class jad_an<K, V> {
        public final K jad_an;
        public java.util.List<V> jad_bo;
        public com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_cp;
        public com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_dq;

        public jad_an() {
            this(null);
        }

        public jad_an(K k) {
            this.jad_dq = this;
            this.jad_cp = this;
            this.jad_an = k;
        }

        @androidx.annotation.Nullable
        public V jad_an() {
            java.util.List<V> list = this.jad_bo;
            int size = list != null ? list.size() : 0;
            if (size > 0) {
                return this.jad_bo.remove(size - 1);
            }
            return null;
        }
    }

    @androidx.annotation.Nullable
    public V jad_an() {
        for (com.jd.ad.sdk.jad_ny.jad_hu.jad_an jad_anVar = this.jad_an.jad_dq; !jad_anVar.equals(this.jad_an); jad_anVar = jad_anVar.jad_dq) {
            V v = (V) jad_anVar.jad_an();
            if (v != null) {
                return v;
            }
            com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            this.jad_bo.remove(jad_anVar.jad_an);
            ((com.jd.ad.sdk.jad_ny.jad_mz) jad_anVar.jad_an).jad_an();
        }
        return null;
    }

    @androidx.annotation.Nullable
    public V jad_an(K k) {
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new com.jd.ad.sdk.jad_ny.jad_hu.jad_an<>(k);
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
        jad_anVar2.jad_cp = jad_anVar.jad_cp;
        jad_anVar.jad_cp.jad_dq = jad_anVar2;
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar3 = this.jad_an;
        jad_anVar.jad_dq = jad_anVar3;
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar4 = jad_anVar3.jad_cp;
        jad_anVar.jad_cp = jad_anVar4;
        jad_anVar4.jad_dq = jad_anVar;
        jad_anVar.jad_dq.jad_cp = jad_anVar;
        return jad_anVar.jad_an();
    }

    public void jad_an(K k, V v) {
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar = this.jad_bo.get(k);
        if (jad_anVar == null) {
            jad_anVar = new com.jd.ad.sdk.jad_ny.jad_hu.jad_an<>(k);
            com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar2 = jad_anVar.jad_dq;
            jad_anVar2.jad_cp = jad_anVar.jad_cp;
            jad_anVar.jad_cp.jad_dq = jad_anVar2;
            com.jd.ad.sdk.jad_ny.jad_hu.jad_an<K, V> jad_anVar3 = this.jad_an;
            jad_anVar.jad_dq = jad_anVar3.jad_dq;
            jad_anVar.jad_cp = jad_anVar3;
            jad_anVar3.jad_dq = jad_anVar;
            jad_anVar.jad_dq.jad_cp = jad_anVar;
            this.jad_bo.put(k, jad_anVar);
        } else {
            k.jad_an();
        }
        if (jad_anVar.jad_bo == null) {
            jad_anVar.jad_bo = new java.util.ArrayList();
        }
        jad_anVar.jad_bo.add(v);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GroupedLinkedMap( ");
        com.jd.ad.sdk.jad_ny.jad_hu.jad_an jad_anVar = this.jad_an.jad_cp;
        boolean z = false;
        while (!jad_anVar.equals(this.jad_an)) {
            sb.append('{');
            sb.append(jad_anVar.jad_an);
            sb.append(':');
            java.util.List<V> list = jad_anVar.jad_bo;
            sb.append(list != null ? list.size() : 0);
            sb.append("}, ");
            jad_anVar = jad_anVar.jad_cp;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}

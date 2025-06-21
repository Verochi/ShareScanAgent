package com.jd.ad.sdk.jad_ox;

/* loaded from: classes23.dex */
public abstract class jad_an<K, A> {
    public final com.jd.ad.sdk.jad_ox.jad_an.jad_cp<K> jad_cp;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_yh.jad_cp<A> jad_er;
    public final java.util.List<com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an> jad_an = new java.util.ArrayList(1);
    public boolean jad_bo = false;
    public float jad_dq = 0.0f;

    @androidx.annotation.Nullable
    public A jad_fs = null;
    public float jad_jt = -1.0f;
    public float jad_hu = -1.0f;

    /* renamed from: com.jd.ad.sdk.jad_ox.jad_an$jad_an, reason: collision with other inner class name */
    public interface InterfaceC0397jad_an {
        void jad_an();
    }

    public static final class jad_bo<T> implements com.jd.ad.sdk.jad_ox.jad_an.jad_cp<T> {
        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return 1.0f;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return 0.0f;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f) {
            throw new java.lang.IllegalStateException("not implemented");
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            throw new java.lang.IllegalStateException("not implemented");
        }
    }

    public interface jad_cp<T> {
        boolean isEmpty();

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        float jad_an();

        boolean jad_an(float f);

        @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
        float jad_bo();

        boolean jad_bo(float f);

        com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp();
    }

    public static final class jad_dq<T> implements com.jd.ad.sdk.jad_ox.jad_an.jad_cp<T> {
        public final java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> jad_an;
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp = null;
        public float jad_dq = -1.0f;

        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_bo = jad_cp(0.0f);

        public jad_dq(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
            this.jad_an = list;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return this.jad_an.get(r0.size() - 1).jad_an();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f) {
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = this.jad_bo;
            if (f >= jad_anVar.jad_bo() && f < jad_anVar.jad_an()) {
                return !this.jad_bo.jad_cp();
            }
            this.jad_bo = jad_cp(f);
            return true;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return this.jad_an.get(0).jad_bo();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f) {
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = this.jad_cp;
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = this.jad_bo;
            if (jad_anVar == jad_anVar2 && this.jad_dq == f) {
                return true;
            }
            this.jad_cp = jad_anVar2;
            this.jad_dq = f;
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        @androidx.annotation.NonNull
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            return this.jad_bo;
        }

        public final com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp(float f) {
            java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list = this.jad_an;
            com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar = list.get(list.size() - 1);
            if (f >= jad_anVar.jad_bo()) {
                return jad_anVar;
            }
            int size = this.jad_an.size() - 2;
            while (true) {
                boolean z = false;
                if (size < 1) {
                    return this.jad_an.get(0);
                }
                com.jd.ad.sdk.jad_yh.jad_an<T> jad_anVar2 = this.jad_an.get(size);
                if (this.jad_bo != jad_anVar2) {
                    if (f >= jad_anVar2.jad_bo() && f < jad_anVar2.jad_an()) {
                        z = true;
                    }
                    if (z) {
                        return jad_anVar2;
                    }
                }
                size--;
            }
        }
    }

    public static final class jad_er<T> implements com.jd.ad.sdk.jad_ox.jad_an.jad_cp<T> {

        @androidx.annotation.NonNull
        public final com.jd.ad.sdk.jad_yh.jad_an<T> jad_an;
        public float jad_bo = -1.0f;

        public jad_er(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
            this.jad_an = list.get(0);
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean isEmpty() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_an() {
            return this.jad_an.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_an(float f) {
            return !this.jad_an.jad_cp();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public float jad_bo() {
            return this.jad_an.jad_bo();
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public boolean jad_bo(float f) {
            if (this.jad_bo == f) {
                return true;
            }
            this.jad_bo = f;
            return false;
        }

        @Override // com.jd.ad.sdk.jad_ox.jad_an.jad_cp
        public com.jd.ad.sdk.jad_yh.jad_an<T> jad_cp() {
            return this.jad_an;
        }
    }

    public jad_an(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<K>> list) {
        this.jad_cp = jad_an(list);
    }

    public static <T> com.jd.ad.sdk.jad_ox.jad_an.jad_cp<T> jad_an(java.util.List<? extends com.jd.ad.sdk.jad_yh.jad_an<T>> list) {
        return list.isEmpty() ? new com.jd.ad.sdk.jad_ox.jad_an.jad_bo() : list.size() == 1 ? new com.jd.ad.sdk.jad_ox.jad_an.jad_er(list) : new com.jd.ad.sdk.jad_ox.jad_an.jad_dq(list);
    }

    public com.jd.ad.sdk.jad_yh.jad_an<K> jad_an() {
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_cp2 = this.jad_cp.jad_cp();
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("BaseKeyframeAnimation#getCurrentKeyframe");
        return jad_cp2;
    }

    public abstract A jad_an(com.jd.ad.sdk.jad_yh.jad_an<K> jad_anVar, float f);

    public A jad_an(com.jd.ad.sdk.jad_yh.jad_an<K> jad_anVar, float f, float f2, float f3) {
        throw new java.lang.UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void jad_an(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.jad_cp.isEmpty()) {
            return;
        }
        if (this.jad_jt == -1.0f) {
            this.jad_jt = this.jad_cp.jad_bo();
        }
        float f2 = this.jad_jt;
        if (f < f2) {
            if (f2 == -1.0f) {
                this.jad_jt = this.jad_cp.jad_bo();
            }
            f = this.jad_jt;
        } else if (f > jad_bo()) {
            f = jad_bo();
        }
        if (f == this.jad_dq) {
            return;
        }
        this.jad_dq = f;
        if (this.jad_cp.jad_an(f)) {
            jad_jt();
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0397jad_an interfaceC0397jad_an) {
        this.jad_an.add(interfaceC0397jad_an);
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<A> jad_cpVar) {
        this.jad_er = jad_cpVar;
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public float jad_bo() {
        if (this.jad_hu == -1.0f) {
            this.jad_hu = this.jad_cp.jad_an();
        }
        return this.jad_hu;
    }

    public float jad_cp() {
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        if (jad_an.jad_cp()) {
            return 0.0f;
        }
        return jad_an.jad_dq.getInterpolation(jad_dq());
    }

    public float jad_dq() {
        if (this.jad_bo) {
            return 0.0f;
        }
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        if (jad_an.jad_cp()) {
            return 0.0f;
        }
        return (this.jad_dq - jad_an.jad_bo()) / (jad_an.jad_an() - jad_an.jad_bo());
    }

    public float jad_er() {
        return this.jad_dq;
    }

    public A jad_fs() {
        float jad_dq2 = jad_dq();
        if (this.jad_er == null && this.jad_cp.jad_bo(jad_dq2)) {
            return this.jad_fs;
        }
        com.jd.ad.sdk.jad_yh.jad_an<K> jad_an = jad_an();
        android.view.animation.Interpolator interpolator = jad_an.jad_er;
        A jad_an2 = (interpolator == null || jad_an.jad_fs == null) ? jad_an(jad_an, jad_cp()) : jad_an(jad_an, jad_dq2, interpolator.getInterpolation(jad_dq2), jad_an.jad_fs.getInterpolation(jad_dq2));
        this.jad_fs = jad_an2;
        return jad_an2;
    }

    public void jad_jt() {
        for (int i = 0; i < this.jad_an.size(); i++) {
            this.jad_an.get(i).jad_an();
        }
    }
}

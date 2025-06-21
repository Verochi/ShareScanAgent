package com.jd.ad.sdk.jad_js;

/* loaded from: classes23.dex */
public final class jad_an {
    public static final com.jd.ad.sdk.jad_js.jad_an.jad_er<java.lang.Object> jad_an = new com.jd.ad.sdk.jad_js.jad_an.C0384jad_an();

    /* renamed from: com.jd.ad.sdk.jad_js.jad_an$jad_an, reason: collision with other inner class name */
    public class C0384jad_an implements com.jd.ad.sdk.jad_js.jad_an.jad_er<java.lang.Object> {
        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_er
        public void jad_an(@androidx.annotation.NonNull java.lang.Object obj) {
        }
    }

    public interface jad_bo<T> {
        T jad_an();
    }

    public static final class jad_cp<T> implements androidx.core.util.Pools.Pool<T> {
        public final com.jd.ad.sdk.jad_js.jad_an.jad_bo<T> jad_an;
        public final com.jd.ad.sdk.jad_js.jad_an.jad_er<T> jad_bo;
        public final androidx.core.util.Pools.Pool<T> jad_cp;

        public jad_cp(@androidx.annotation.NonNull androidx.core.util.Pools.Pool<T> pool, @androidx.annotation.NonNull com.jd.ad.sdk.jad_js.jad_an.jad_bo<T> jad_boVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_js.jad_an.jad_er<T> jad_erVar) {
            this.jad_cp = pool;
            this.jad_an = jad_boVar;
            this.jad_bo = jad_erVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.jad_cp.acquire();
            if (acquire == null) {
                acquire = this.jad_an.jad_an();
                if (android.util.Log.isLoggable("FactoryPools", 2)) {
                    java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Created new ");
                    jad_an.append(acquire.getClass());
                    com.jd.ad.sdk.logger.Logger.v("FactoryPools", jad_an.toString());
                }
            }
            if (acquire instanceof com.jd.ad.sdk.jad_js.jad_an.jad_dq) {
                ((com.jd.ad.sdk.jad_js.jad_dq.jad_bo) acquire.jad_an()).jad_an = false;
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@androidx.annotation.NonNull T t) {
            if (t instanceof com.jd.ad.sdk.jad_js.jad_an.jad_dq) {
                ((com.jd.ad.sdk.jad_js.jad_dq.jad_bo) ((com.jd.ad.sdk.jad_js.jad_an.jad_dq) t).jad_an()).jad_an = true;
            }
            this.jad_bo.jad_an(t);
            return this.jad_cp.release(t);
        }
    }

    public interface jad_dq {
        @androidx.annotation.NonNull
        com.jd.ad.sdk.jad_js.jad_dq jad_an();
    }

    public interface jad_er<T> {
        void jad_an(@androidx.annotation.NonNull T t);
    }

    @androidx.annotation.NonNull
    public static <T> androidx.core.util.Pools.Pool<java.util.List<T>> jad_an() {
        return new com.jd.ad.sdk.jad_js.jad_an.jad_cp(new androidx.core.util.Pools.SynchronizedPool(20), new com.jd.ad.sdk.jad_js.jad_bo(), new com.jd.ad.sdk.jad_js.jad_cp());
    }

    @androidx.annotation.NonNull
    public static <T extends com.jd.ad.sdk.jad_js.jad_an.jad_dq> androidx.core.util.Pools.Pool<T> jad_an(int i, @androidx.annotation.NonNull com.jd.ad.sdk.jad_js.jad_an.jad_bo<T> jad_boVar) {
        return new com.jd.ad.sdk.jad_js.jad_an.jad_cp(new androidx.core.util.Pools.SynchronizedPool(i), jad_boVar, jad_an);
    }
}

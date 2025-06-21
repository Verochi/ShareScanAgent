package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class wg {
    static final com.ss.android.downloadlib.bt.wg.vw vw = new com.ss.android.downloadlib.bt.wg.C0472wg(null);

    public static class vw {
        private vw() {
        }

        public /* synthetic */ vw(com.ss.android.downloadlib.bt.wg.AnonymousClass1 anonymousClass1) {
            this();
        }

        public <T> void vw(android.os.AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @android.annotation.TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.bt.wg$wg, reason: collision with other inner class name */
    public static class C0472wg extends com.ss.android.downloadlib.bt.wg.vw {
        private C0472wg() {
            super(null);
        }

        public /* synthetic */ C0472wg(com.ss.android.downloadlib.bt.wg.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.ss.android.downloadlib.bt.wg.vw
        public <T> void vw(android.os.AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(android.os.AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static <T> void vw(android.os.AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        vw.vw(asyncTask, tArr);
    }
}

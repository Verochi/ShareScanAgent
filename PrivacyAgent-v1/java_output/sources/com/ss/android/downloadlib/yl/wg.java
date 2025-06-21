package com.ss.android.downloadlib.yl;

/* loaded from: classes19.dex */
public class wg {

    /* renamed from: com.ss.android.downloadlib.yl.wg$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.ss.android.downloadlib.yl.wg.vw<java.lang.Void> {
        final /* synthetic */ java.lang.Runnable vw;

        public AnonymousClass1(java.lang.Runnable runnable) {
            this.vw = runnable;
        }

        @Override // com.ss.android.downloadlib.yl.wg.vw
        /* renamed from: vw, reason: merged with bridge method [inline-methods] */
        public java.lang.Void wg() {
            this.vw.run();
            return null;
        }
    }

    public interface vw<T> {
        T wg();
    }

    public static <T> T vw(com.ss.android.downloadlib.yl.wg.vw<T> vwVar) {
        return (T) vw(true, null, vwVar);
    }

    public static <T> T vw(boolean z, java.lang.String str, @androidx.annotation.NonNull com.ss.android.downloadlib.yl.wg.vw<T> vwVar) {
        try {
            return vwVar.wg();
        } catch (java.lang.Throwable th) {
            if (th instanceof com.ss.android.downloadlib.yl.vw) {
                throw th;
            }
            com.ss.android.downloadlib.yl.t.vw().vw(z, th, str);
            if (android.text.TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static void vw(java.lang.Runnable runnable) {
        vw(new com.ss.android.downloadlib.yl.wg.AnonymousClass1(runnable));
    }
}

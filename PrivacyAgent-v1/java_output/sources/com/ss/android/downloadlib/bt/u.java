package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class u extends android.os.Handler {
    java.lang.ref.WeakReference<com.ss.android.downloadlib.bt.u.vw> vw;

    public interface vw {
        void vw(android.os.Message message);
    }

    public u(android.os.Looper looper, com.ss.android.downloadlib.bt.u.vw vwVar) {
        super(looper);
        this.vw = new java.lang.ref.WeakReference<>(vwVar);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.ss.android.downloadlib.bt.u.vw vwVar = this.vw.get();
        if (vwVar == null || message == null) {
            return;
        }
        vwVar.vw(message);
    }
}

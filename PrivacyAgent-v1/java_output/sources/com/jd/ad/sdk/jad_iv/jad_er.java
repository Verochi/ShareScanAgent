package com.jd.ad.sdk.jad_iv;

/* loaded from: classes23.dex */
public class jad_er extends android.os.Handler {
    public final java.lang.ref.WeakReference jad_an;

    public interface jad_an {
        void jad_an(android.os.Message message);
    }

    public jad_er(android.os.Looper looper, com.jd.ad.sdk.jad_iv.jad_er.jad_an jad_anVar) {
        super(looper);
        this.jad_an = new java.lang.ref.WeakReference(jad_anVar);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.jd.ad.sdk.jad_iv.jad_er.jad_an jad_anVar = (com.jd.ad.sdk.jad_iv.jad_er.jad_an) this.jad_an.get();
        if (jad_anVar == null || message == null) {
            return;
        }
        jad_anVar.jad_an(message);
    }
}

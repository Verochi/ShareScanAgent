package com.jd.ad.sdk.jad_mx;

/* loaded from: classes23.dex */
public class jad_cn {
    public boolean jad_an;
    public final android.os.Handler jad_bo = new android.os.Handler(android.os.Looper.getMainLooper(), new com.jd.ad.sdk.jad_mx.jad_cn.jad_an());

    public static final class jad_an implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            ((com.jd.ad.sdk.jad_mx.jad_xk) message.obj).jad_dq();
            return true;
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_mx.jad_xk<?> jad_xkVar, boolean z) {
        if (!this.jad_an && !z) {
            this.jad_an = true;
            jad_xkVar.jad_dq();
            this.jad_an = false;
        }
        this.jad_bo.obtainMessage(1, jad_xkVar).sendToTarget();
    }
}

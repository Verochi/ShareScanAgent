package com.jd.ad.sdk.jad_fo;

/* loaded from: classes23.dex */
public final class jad_cp<Z> extends com.jd.ad.sdk.jad_fo.jad_an<Z> {
    public static final android.os.Handler jad_er = new android.os.Handler(android.os.Looper.getMainLooper(), new com.jd.ad.sdk.jad_fo.jad_cp.jad_an());
    public final com.jd.ad.sdk.jad_gr.jad_jw jad_dq;

    public class jad_an implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return false;
            }
            com.jd.ad.sdk.jad_fo.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_fo.jad_cp) message.obj;
            jad_cpVar.jad_dq.jad_an(jad_cpVar);
            return true;
        }
    }

    public jad_cp(com.jd.ad.sdk.jad_gr.jad_jw jad_jwVar, int i, int i2) {
        super(i, i2);
        this.jad_dq = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(@androidx.annotation.NonNull Z z, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo<? super Z> jad_boVar) {
        com.jd.ad.sdk.jad_en.jad_dq jad_dqVar = this.jad_cp;
        if (jad_dqVar == null || !jad_dqVar.jad_cp()) {
            return;
        }
        jad_er.obtainMessage(1, this).sendToTarget();
    }
}

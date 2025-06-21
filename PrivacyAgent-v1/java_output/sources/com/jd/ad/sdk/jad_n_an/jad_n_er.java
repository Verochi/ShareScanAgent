package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_er implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_an;

    public jad_n_er(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar) {
        this.jad_n_an = jad_n_ivVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.jad_n_an.jad_n_pc) {
            return;
        }
        this.jad_n_an.jad_n_an(com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onUserCancelJdJump(this.jad_n_an.jad_n_fs.getContext(), this.jad_n_an.jad_n_an.getInstanceId()));
    }
}

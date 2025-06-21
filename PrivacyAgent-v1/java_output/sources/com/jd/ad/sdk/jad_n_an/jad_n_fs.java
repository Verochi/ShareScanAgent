package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_fs extends com.jd.ad.sdk.bl.dynamicrender.ShakeListener {
    public final /* synthetic */ float jad_n_an;
    public final /* synthetic */ float jad_n_bo;
    public final /* synthetic */ float jad_n_cp;
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_dq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_n_fs(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.content.Context context, float f, float f2, float f3, boolean z, float f4, float f5, float f6) {
        super(context, f, f2, f3, z);
        this.jad_n_dq = jad_n_ivVar;
        this.jad_n_an = f4;
        this.jad_n_bo = f5;
        this.jad_n_cp = f6;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        com.jd.ad.sdk.nativead.JADNative jADNative = this.jad_n_dq.jad_n_an;
        if (jADNative == null || jADNative.getSlot() == null) {
            return;
        }
        if (this.jad_n_dq.jad_n_an.getSlot().getAdType() == 1) {
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar = this.jad_n_dq;
            if (com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(jad_n_ivVar, jad_n_ivVar.jad_n_fs)) {
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar2 = this.jad_n_dq;
                jad_n_ivVar2.jad_n_jw = com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(jad_n_ivVar2, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar3 = this.jad_n_dq;
                jad_n_ivVar3.jad_n_bo(jad_n_ivVar3.jad_n_fs);
                return;
            }
            return;
        }
        com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar4 = this.jad_n_dq;
        if (jad_n_ivVar4.jad_n_an(jad_n_ivVar4.jad_n_fs)) {
            com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar5 = this.jad_n_dq;
            if (com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(jad_n_ivVar5, jad_n_ivVar5.jad_n_fs.getContext(), this.jad_n_dq.jad_n_an.getInstanceId())) {
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar6 = this.jad_n_dq;
                jad_n_ivVar6.jad_n_jw = com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(jad_n_ivVar6, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar7 = this.jad_n_dq;
                jad_n_ivVar7.jad_n_bo(jad_n_ivVar7.jad_n_fs);
            }
        }
    }
}

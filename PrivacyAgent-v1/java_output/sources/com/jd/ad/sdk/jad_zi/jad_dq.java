package com.jd.ad.sdk.jad_zi;

/* loaded from: classes23.dex */
public class jad_dq extends com.jd.ad.sdk.jad_hu.jad_an {
    public final /* synthetic */ java.lang.String jad_er;
    public final /* synthetic */ int jad_fs;
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener jad_jt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_dq(com.jd.ad.sdk.jad_zi.jad_er jad_erVar, java.lang.String str, java.lang.String str2, int i, com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener) {
        super(str);
        this.jad_er = str2;
        this.jad_fs = i;
        this.jad_jt = iDynamicInteractionListener;
    }

    @Override // com.jd.ad.sdk.jad_hu.jad_an
    public void jad_an(android.view.View view) {
        int i = this.jad_dq;
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render click layer name:");
        jad_an.append(this.jad_er);
        jad_an.append(", adAnimationType:");
        jad_an.append(this.jad_fs);
        jad_an.append(", adTriggerSourceType:");
        jad_an.append(i);
        com.jd.ad.sdk.logger.Logger.d(jad_an.toString());
        com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener iDynamicInteractionListener = this.jad_jt;
        if (iDynamicInteractionListener != null) {
            iDynamicInteractionListener.onAdClicked(this.jad_fs, this.jad_dq);
        }
    }
}

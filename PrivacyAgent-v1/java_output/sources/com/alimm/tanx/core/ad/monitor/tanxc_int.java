package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public class tanxc_int extends com.alimm.tanx.core.ad.monitor.tanxc_do {
    public tanxc_int(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.monitor.ITanxExposureCallback iTanxExposureCallback, int i, java.lang.String str) {
        super(tanxAdView, iTanxExposureCallback, i, str);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_do() {
        this.tanxc_char = 0L;
        this.tanxc_case = 0.5f;
    }
}

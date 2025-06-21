package com.alimm.tanx.core.ad.event.track.tanxc_do;

/* loaded from: classes.dex */
public class tanxc_do {
    private static com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do tanxc_do;

    /* renamed from: com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.d("BiddingUpload", str2);
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(java.lang.Object obj) {
            com.alimm.tanx.core.utils.LogUtils.d("BiddingUpload", obj.toString());
        }
    }

    public static com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do.class) {
                if (tanxc_do == null) {
                    tanxc_do = new com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do();
                }
            }
        }
        return tanxc_do;
    }

    public void tanxc_do(java.util.List<com.alimm.tanx.core.ad.ITanxAd> list) {
        if (list != null) {
            for (com.alimm.tanx.core.ad.ITanxAd iTanxAd : list) {
                if (iTanxAd != null) {
                    try {
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        com.alimm.tanx.core.utils.LogUtils.e("BiddingUpload", e);
                        com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "BiddingUpload", com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
                    }
                    if (iTanxAd.getBidInfo() != null && !android.text.TextUtils.isEmpty(iTanxAd.getBidInfo().getWinNoticeUrl())) {
                        com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(iTanxAd.getBidInfo().getWinNoticeUrl()).build();
                        build.setOverrideError(true);
                        com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpGet(build, java.lang.Object.class, false, false, new com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do.AnonymousClass1());
                    }
                }
                com.alimm.tanx.core.utils.LogUtils.d("BiddingUpload", "uploadBidding iTanxAd.getBidInfo().getWinNoticeUrl() 为空");
                return;
            }
        }
    }
}

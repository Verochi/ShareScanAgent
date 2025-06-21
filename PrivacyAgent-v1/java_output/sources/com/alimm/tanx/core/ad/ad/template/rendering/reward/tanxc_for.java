package com.alimm.tanx.core.ad.ad.template.rendering.reward;

/* loaded from: classes.dex */
public class tanxc_for {
    private final com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_do;
    private com.alimm.tanx.core.ad.interaction.AdClickInfo tanxc_for;
    private com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd tanxc_if;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.ad.listener.ITanxInteractionListener<com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd> {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        public /* synthetic */ void onAdClicked(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            tanxc_do();
        }

        public void tanxc_do() {
            com.alimm.tanx.core.utils.LogUtils.d("RewardNewBrowseManager", "onAdClicked");
        }

        @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
        /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
        public void onAdShow(com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd) {
            com.alimm.tanx.core.utils.LogUtils.d("RewardNewBrowseManager", "onAdShow");
            if (com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.this.tanxc_do != null && com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.this.tanxc_do.tanxc_for() != null) {
                com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.this.tanxc_do.tanxc_for().onAdShow(iTanxRewardVideoAd);
            }
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.this.tanxc_if.clickUpload();
        }
    }

    public tanxc_for(com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_new tanxc_newVar) {
        this.tanxc_do = tanxc_newVar;
        if (tanxc_newVar != null) {
            this.tanxc_if = tanxc_newVar.tanxc_if;
        }
    }

    private boolean tanxc_if(android.content.Context context) {
        com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd iTanxRewardVideoAd;
        if (this.tanxc_do == null || (iTanxRewardVideoAd = this.tanxc_if) == null) {
            return false;
        }
        iTanxRewardVideoAd.bindRewardVideoAdView(new com.alimm.tanx.core.ad.view.TanxAdView(context), new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_for.AnonymousClass1());
        return true;
    }

    public boolean tanxc_do(android.content.Context context) {
        if (this.tanxc_do != null && this.tanxc_if != null) {
            com.alimm.tanx.core.ad.interaction.AdClickHandler adClickHandler = new com.alimm.tanx.core.ad.interaction.AdClickHandler();
            com.alimm.tanx.core.ad.interaction.AdClickInfo tanxc_do = new com.alimm.tanx.core.utils.tanxc_do().tanxc_do(this.tanxc_if.getAdSlot(), this.tanxc_if.getBidInfo(), com.alimm.tanx.core.ut.AdUtConstants.REWARD_NEW_BROWSE_NAVIGATE);
            this.tanxc_for = tanxc_do;
            if (adClickHandler.handleClickAndUt(context, tanxc_do, true, true)) {
                tanxc_if(context);
                this.tanxc_if.onResourceLoadSuccess();
                try {
                    com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_if = new com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_try(this.tanxc_if.getAdSlot().getPid(), this.tanxc_if.getAdSlot().getMediaUid(), this.tanxc_if.getBidInfo().getSessionId(), this.tanxc_if.getAdSlot().getRewardParam());
                } catch (java.lang.Exception e) {
                    com.alimm.tanx.core.utils.LogUtils.e("RewardNewBrowseManager", e);
                }
                return true;
            }
        }
        return false;
    }
}

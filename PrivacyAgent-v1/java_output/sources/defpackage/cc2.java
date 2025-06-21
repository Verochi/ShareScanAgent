package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class cc2 implements com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener {
    public final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity a;

    public /* synthetic */ cc2(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.a = rewardVideoPortraitActivity;
    }

    @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
    public final void onStateChange(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.view.player.core.PlayerState playerState) {
        this.a.lambda$initVideo$7(iTanxPlayer, playerState);
    }
}

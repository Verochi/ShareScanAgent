package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class dc2 implements com.alimm.tanx.core.view.player.core.OnVideoBufferingListener {
    public final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity a;

    public /* synthetic */ dc2(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.a = rewardVideoPortraitActivity;
    }

    @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
    public final void OnBufferStateChanged(com.alimm.tanx.core.view.player.core.PlayerBufferingState playerBufferingState) {
        this.a.lambda$initVideo$8(playerBufferingState);
    }
}

package defpackage;

/* loaded from: classes.dex */
public final /* synthetic */ class ec2 implements com.alimm.tanx.core.view.player.core.OnVideoErrorListener {
    public final /* synthetic */ com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity a;

    public /* synthetic */ ec2(com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity rewardVideoPortraitActivity) {
        this.a = rewardVideoPortraitActivity;
    }

    @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
    public final boolean onError(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer, com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError) {
        boolean lambda$initVideo$9;
        lambda$initVideo$9 = this.a.lambda$initVideo$9(iTanxPlayer, tanxPlayerError);
        return lambda$initVideo$9;
    }
}

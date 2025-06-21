package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class bl2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.weathersence.adavatar.SkeletonAdAvatarActor n;
    public final /* synthetic */ com.moji.weathersence.adavatar.PlayControlData t;

    public /* synthetic */ bl2(com.moji.weathersence.adavatar.SkeletonAdAvatarActor skeletonAdAvatarActor, com.moji.weathersence.adavatar.PlayControlData playControlData) {
        this.n = skeletonAdAvatarActor;
        this.t = playControlData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.weathersence.adavatar.SkeletonAdAvatarActor.complete.1.a(this.n, this.t);
    }
}

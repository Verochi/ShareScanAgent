package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class od2 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.sence.scenestore.model.SceneSwitchHelper n;
    public final /* synthetic */ com.moji.sence.scenestore.model.BgStoreModel t;

    public /* synthetic */ od2(com.moji.sence.scenestore.model.SceneSwitchHelper sceneSwitchHelper, com.moji.sence.scenestore.model.BgStoreModel bgStoreModel) {
        this.n = sceneSwitchHelper;
        this.t = bgStoreModel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.sence.scenestore.model.SceneSwitchHelper.c(this.n, this.t);
    }
}

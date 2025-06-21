package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class i72 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.rapeflowers.RFlowersViewModel n;

    public /* synthetic */ i72(com.moji.rapeflowers.RFlowersViewModel rFlowersViewModel) {
        this.n = rFlowersViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.rapeflowers.RFlowersViewModel.a(this.n, (moji.com.mjweatherservicebase.card.RFlowersMapInfo) obj);
    }
}

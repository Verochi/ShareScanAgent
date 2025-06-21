package defpackage;

/* loaded from: classes10.dex */
public final /* synthetic */ class my1 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.peachflowers.PeachFlowersViewModel n;

    public /* synthetic */ my1(com.moji.peachflowers.PeachFlowersViewModel peachFlowersViewModel) {
        this.n = peachFlowersViewModel;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.peachflowers.PeachFlowersViewModel.b(this.n, (moji.com.mjweatherservicebase.card.RFlowersMapInfo) obj);
    }
}

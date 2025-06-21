package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class xu1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.card.view.OpCardContainerView n;

    public /* synthetic */ xu1(com.moji.card.view.OpCardContainerView opCardContainerView) {
        this.n = opCardContainerView;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.card.view.OpCardContainerView.c(this.n, (com.moji.card.event.OpCardChangeEvent) obj);
    }
}

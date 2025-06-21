package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class wo0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjfishing.adapter.HotFishermenAdapter n;

    public /* synthetic */ wo0(com.moji.mjfishing.adapter.HotFishermenAdapter hotFishermenAdapter) {
        this.n = hotFishermenAdapter;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjfishing.adapter.HotFishermenAdapter.a(this.n, (com.moji.newliveview.rank.AttentionEvent) obj);
    }
}

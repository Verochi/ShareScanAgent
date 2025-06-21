package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class zx0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.attention.ui.LiveViewAttentionFragment n;

    public /* synthetic */ zx0(com.moji.newliveview.attention.ui.LiveViewAttentionFragment liveViewAttentionFragment) {
        this.n = liveViewAttentionFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.attention.ui.LiveViewAttentionFragment.b(this.n, (com.moji.http.snsforum.entity.ExpertPersonListResult) obj);
    }
}

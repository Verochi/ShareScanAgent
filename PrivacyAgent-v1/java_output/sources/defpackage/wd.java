package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wd implements com.moji.swiperefreshlayout.SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ com.moji.newliveview.attention.presenter.AttentionLoginPresenter a;

    public /* synthetic */ wd(com.moji.newliveview.attention.presenter.AttentionLoginPresenter attentionLoginPresenter) {
        this.a = attentionLoginPresenter;
    }

    public final void onRefresh() {
        com.moji.newliveview.attention.presenter.AttentionLoginPresenter.b(this.a);
    }
}

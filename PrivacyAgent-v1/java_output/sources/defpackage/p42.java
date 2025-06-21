package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class p42 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.PraiseVideoFragment n;

    public /* synthetic */ p42(com.moji.user.homepage.fragment.PraiseVideoFragment praiseVideoFragment) {
        this.n = praiseVideoFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.PraiseVideoFragment.c(this.n, (com.moji.http.feedvideo.entity.PraiseVideoListResult) obj);
    }
}

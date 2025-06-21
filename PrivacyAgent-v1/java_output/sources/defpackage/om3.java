package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class om3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.WorksArticleFragment n;

    public /* synthetic */ om3(com.moji.user.homepage.fragment.WorksArticleFragment worksArticleFragment) {
        this.n = worksArticleFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.WorksArticleFragment.a(this.n, (com.moji.http.snsforum.entity.UserArticleListResult) obj);
    }
}

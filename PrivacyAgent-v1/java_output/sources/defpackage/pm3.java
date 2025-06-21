package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class pm3 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.user.homepage.fragment.WorksArticleFragment n;

    public /* synthetic */ pm3(com.moji.user.homepage.fragment.WorksArticleFragment worksArticleFragment) {
        this.n = worksArticleFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.user.homepage.fragment.WorksArticleFragment.b(this.n, (com.moji.newliveview.detail.data.PicturePraiseData) obj);
    }
}

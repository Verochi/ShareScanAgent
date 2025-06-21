package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class dn0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.adapter.HomeArticleViewHolder n;
    public final /* synthetic */ kotlin.jvm.functions.Function1 t;

    public /* synthetic */ dn0(com.moji.mjweather.feed.newvideo.adapter.HomeArticleViewHolder homeArticleViewHolder, kotlin.jvm.functions.Function1 function1) {
        this.n = homeArticleViewHolder;
        this.t = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.feed.newvideo.adapter.HomeArticleViewHolder.a(this.n, this.t, view);
    }
}

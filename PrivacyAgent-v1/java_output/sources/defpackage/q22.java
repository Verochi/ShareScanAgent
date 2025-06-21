package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class q22 implements android.view.View.OnClickListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef n;
    public final /* synthetic */ com.moji.newliveview.databinding.ArticleDetailItemPictureBinding t;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder u;
    public final /* synthetic */ android.view.ViewGroup.LayoutParams v;
    public final /* synthetic */ int w;
    public final /* synthetic */ float x;
    public final /* synthetic */ com.moji.imageview.FourCornerImageView y;

    public /* synthetic */ q22(kotlin.jvm.internal.Ref.BooleanRef booleanRef, com.moji.newliveview.databinding.ArticleDetailItemPictureBinding articleDetailItemPictureBinding, com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder pictureTextViewHolder, android.view.ViewGroup.LayoutParams layoutParams, int i, float f, com.moji.imageview.FourCornerImageView fourCornerImageView) {
        this.n = booleanRef;
        this.t = articleDetailItemPictureBinding;
        this.u = pictureTextViewHolder;
        this.v = layoutParams;
        this.w = i;
        this.x = f;
        this.y = fourCornerImageView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.detail.viewholder.PictureTextViewHolder.a(this.n, this.t, this.u, this.v, this.w, this.x, this.y, view);
    }
}

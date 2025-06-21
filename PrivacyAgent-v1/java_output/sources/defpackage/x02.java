package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class x02 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.detail.PicTextLiveAdapter n;
    public final /* synthetic */ android.widget.ImageView t;
    public final /* synthetic */ java.util.List u;

    public /* synthetic */ x02(com.moji.newliveview.detail.PicTextLiveAdapter picTextLiveAdapter, android.widget.ImageView imageView, java.util.List list) {
        this.n = picTextLiveAdapter;
        this.t = imageView;
        this.u = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.detail.PicTextLiveAdapter.l(this.n, this.t, this.u, view);
    }
}

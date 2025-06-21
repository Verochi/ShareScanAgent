package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class d62 implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.liveview_finalversion.data.discover.LivePromotionItem t;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.discover.PromotionView u;

    public /* synthetic */ d62(int i, com.moji.liveview_finalversion.data.discover.LivePromotionItem livePromotionItem, com.moji.liveview_finalversion.ui.discover.PromotionView promotionView) {
        this.n = i;
        this.t = livePromotionItem;
        this.u = promotionView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview_finalversion.ui.discover.PromotionView.PromotionBannerAdapter.e(this.n, this.t, this.u, view);
    }
}

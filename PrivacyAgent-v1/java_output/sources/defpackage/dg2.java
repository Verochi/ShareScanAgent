package defpackage;

/* loaded from: classes18.dex */
public final /* synthetic */ class dg2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.videoshopcard.ShopOnLineVideoActivity n;

    public /* synthetic */ dg2(com.moji.videoshopcard.ShopOnLineVideoActivity shopOnLineVideoActivity) {
        this.n = shopOnLineVideoActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.videoshopcard.ShopOnLineVideoActivity.c(this.n, (com.moji.videoshopcard.data.ShopVideoResp) obj);
    }
}

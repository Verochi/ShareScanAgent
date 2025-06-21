package defpackage;

/* loaded from: classes18.dex */
public final /* synthetic */ class eg2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.videoshopcard.ShopOnLineVideoActivity n;

    public /* synthetic */ eg2(com.moji.videoshopcard.ShopOnLineVideoActivity shopOnLineVideoActivity) {
        this.n = shopOnLineVideoActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.videoshopcard.ShopOnLineVideoActivity.e(this.n, (com.moji.videoshopcard.data.HttpStatus) obj);
    }
}

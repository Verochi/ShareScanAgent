package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class aa1 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.share.activity.MainShareActivity n;

    public /* synthetic */ aa1(com.moji.share.activity.MainShareActivity mainShareActivity) {
        this.n = mainShareActivity;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.share.activity.MainShareActivity.initData.1.a(this.n, (java.lang.String) obj);
    }
}

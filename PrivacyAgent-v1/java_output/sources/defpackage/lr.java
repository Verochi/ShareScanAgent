package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class lr implements io.reactivex.functions.Consumer {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon t;

    public /* synthetic */ lr(android.view.View view, com.moji.mjad.common.data.AdCommon adCommon) {
        this.n = view;
        this.t = adCommon;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjad.util.CommonAdDataManager.a(this.n, this.t, (java.lang.Long) obj);
    }
}

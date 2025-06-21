package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class xu0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkHomeActivity n;

    public /* synthetic */ xu0(com.moji.mjkinsfolk.ui.KinsfolkHomeActivity kinsfolkHomeActivity) {
        this.n = kinsfolkHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjkinsfolk.ui.KinsfolkHomeActivity.e(this.n, (com.moji.mjkinsfolk.model.KinsfolkDataResult) obj);
    }
}

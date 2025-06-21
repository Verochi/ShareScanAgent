package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class vu0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkHomeActivity n;

    public /* synthetic */ vu0(com.moji.mjkinsfolk.ui.KinsfolkHomeActivity kinsfolkHomeActivity) {
        this.n = kinsfolkHomeActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjkinsfolk.ui.KinsfolkHomeActivity.b(this.n, (com.moji.location.entity.MJLocation) obj);
    }
}

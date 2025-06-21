package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class cv0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjkinsfolk.ui.KinsfolkInfoWriteActivity n;

    public /* synthetic */ cv0(com.moji.mjkinsfolk.ui.KinsfolkInfoWriteActivity kinsfolkInfoWriteActivity) {
        this.n = kinsfolkInfoWriteActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjkinsfolk.ui.KinsfolkInfoWriteActivity.b(this.n, (com.moji.mjkinsfolk.model.UpdateInfoResult) obj);
    }
}

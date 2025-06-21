package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class xd2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.camera.activity.SearchLocationActivity n;

    public /* synthetic */ xd2(com.moji.newliveview.camera.activity.SearchLocationActivity searchLocationActivity) {
        this.n = searchLocationActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.camera.activity.SearchLocationActivity.c(this.n, (java.util.List) obj);
    }
}

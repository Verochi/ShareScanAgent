package defpackage;

/* loaded from: classes19.dex */
public final /* synthetic */ class j7 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.mojiweather.area.AddAreaFragment n;

    public /* synthetic */ j7(com.mojiweather.area.AddAreaFragment addAreaFragment) {
        this.n = addAreaFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.mojiweather.area.AddAreaFragment.g(this.n, (java.util.List) obj);
    }
}

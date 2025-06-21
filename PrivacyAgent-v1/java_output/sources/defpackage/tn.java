package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class tn implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjcitypicker.CityPickerFragment n;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView t;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView u;
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView v;

    public /* synthetic */ tn(com.moji.mjcitypicker.CityPickerFragment cityPickerFragment, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView recyclerView3) {
        this.n = cityPickerFragment;
        this.t = recyclerView;
        this.u = recyclerView2;
        this.v = recyclerView3;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjcitypicker.CityPickerFragment.a(this.n, this.t, this.u, this.v, (com.moji.mjcitypicker.data.PickerData) obj);
    }
}

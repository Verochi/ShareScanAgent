package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class un implements java.lang.Runnable {
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView n;
    public final /* synthetic */ int t;

    public /* synthetic */ un(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        this.n = recyclerView;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjcitypicker.CityPickerFragment.b(this.n, this.t);
    }
}

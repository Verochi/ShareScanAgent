package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class b43 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.mjtravel.adapter.TripEditWayAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ b43(com.moji.mjtravel.adapter.TripEditWayAdapter tripEditWayAdapter, int i) {
        this.n = tripEditWayAdapter;
        this.t = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.mjtravel.adapter.TripEditWayAdapter.a(this.n, this.t, compoundButton, z);
    }
}

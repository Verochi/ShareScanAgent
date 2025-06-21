package defpackage;

/* loaded from: classes6.dex */
public final /* synthetic */ class a43 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ com.moji.mjtravel.adapter.TripEditIndexAdapter n;
    public final /* synthetic */ int t;

    public /* synthetic */ a43(com.moji.mjtravel.adapter.TripEditIndexAdapter tripEditIndexAdapter, int i) {
        this.n = tripEditIndexAdapter;
        this.t = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.mjtravel.adapter.TripEditIndexAdapter.a(this.n, this.t, compoundButton, z);
    }
}

package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class as0 implements java.lang.Runnable {
    public final /* synthetic */ androidx.recyclerview.widget.RecyclerView n;
    public final /* synthetic */ int t;

    public /* synthetic */ as0(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        this.n = recyclerView;
        this.t = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.influenza.view.InfluenzaSubscribeCityDialog.a(this.n, this.t);
    }
}

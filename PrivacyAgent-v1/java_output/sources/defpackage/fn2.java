package defpackage;

/* loaded from: classes15.dex */
public final /* synthetic */ class fn2 implements android.view.View.OnClickListener {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ com.moji.snow.adapter.SnowDetailHolder t;

    public /* synthetic */ fn2(android.view.View view, com.moji.snow.adapter.SnowDetailHolder snowDetailHolder) {
        this.n = view;
        this.t = snowDetailHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.snow.adapter.SnowDetailHolder.b(this.n, this.t, view);
    }
}

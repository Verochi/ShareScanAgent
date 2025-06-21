package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class iv implements android.view.View.OnClickListener {
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef n;
    public final /* synthetic */ com.moji.dialog.MJDialog t;
    public final /* synthetic */ com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity u;

    public /* synthetic */ iv(kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.dialog.MJDialog mJDialog, com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity dangerousDrivingForecastActivity) {
        this.n = objectRef;
        this.t = mJDialog;
        this.u = dangerousDrivingForecastActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.dangerousdrivingforecast.DangerousDrivingForecastActivity.g(this.n, this.t, this.u, view);
    }
}

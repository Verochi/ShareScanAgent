package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class px implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mj40dayforecast.Days40ViewModel n;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity t;

    public /* synthetic */ px(com.moji.mj40dayforecast.Days40ViewModel days40ViewModel, androidx.fragment.app.FragmentActivity fragmentActivity) {
        this.n = days40ViewModel;
        this.t = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mj40dayforecast.fragment.Days40CurveFragment.c(this.n, this.t, view);
    }
}

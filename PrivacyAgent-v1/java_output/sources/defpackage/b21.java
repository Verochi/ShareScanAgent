package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b21 implements java.lang.Runnable {
    public final /* synthetic */ android.widget.TextView n;
    public final /* synthetic */ android.view.View t;
    public final /* synthetic */ android.widget.ScrollView u;

    public /* synthetic */ b21(android.widget.TextView textView, android.view.View view, android.widget.ScrollView scrollView) {
        this.n = textView;
        this.t = view;
        this.u = scrollView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.dialog.control.MJDialogMemberCancelAutoConsumeControl.d(this.n, this.t, this.u);
    }
}

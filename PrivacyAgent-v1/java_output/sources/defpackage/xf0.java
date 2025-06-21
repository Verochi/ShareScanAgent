package defpackage;

/* loaded from: classes3.dex */
public final /* synthetic */ class xf0 implements android.widget.CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ android.app.Dialog n;

    public /* synthetic */ xf0(android.app.Dialog dialog) {
        this.n = dialog;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        com.moji.mjfloatball.FloatBallPresenter.b(this.n, compoundButton, z);
    }
}

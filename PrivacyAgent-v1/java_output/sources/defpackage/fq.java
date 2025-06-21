package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class fq implements android.view.View.OnClickListener {
    public final /* synthetic */ android.app.Dialog n;

    public /* synthetic */ fq(android.app.Dialog dialog) {
        this.n = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjcommand.CommandDialog.b(this.n, view);
    }
}

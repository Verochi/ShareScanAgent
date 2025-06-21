package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class qf1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;
    public final /* synthetic */ int t;

    public /* synthetic */ qf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager, int i) {
        this.n = memberDialogManager;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.g(this.n, this.t, view);
    }
}

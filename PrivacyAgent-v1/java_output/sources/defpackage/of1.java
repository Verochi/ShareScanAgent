package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class of1 implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager t;

    public /* synthetic */ of1(int i, com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager) {
        this.n = i;
        this.t = memberDialogManager;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.f(this.n, this.t, view);
    }
}

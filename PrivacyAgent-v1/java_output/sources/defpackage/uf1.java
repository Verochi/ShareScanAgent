package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class uf1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;
    public final /* synthetic */ com.moji.shorttime.ui.ShortMemberDialogType t;
    public final /* synthetic */ int u;

    public /* synthetic */ uf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager, com.moji.shorttime.ui.ShortMemberDialogType shortMemberDialogType, int i) {
        this.n = memberDialogManager;
        this.t = shortMemberDialogType;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.a(this.n, this.t, this.u, view);
    }
}

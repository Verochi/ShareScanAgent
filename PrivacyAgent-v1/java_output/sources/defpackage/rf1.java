package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class rf1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;
    public final /* synthetic */ com.moji.shorttime.ui.ShortMemberDialogType t;
    public final /* synthetic */ int u;
    public final /* synthetic */ com.moji.http.member.entity.ShortMemberDialogResult.Config v;

    public /* synthetic */ rf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager, com.moji.shorttime.ui.ShortMemberDialogType shortMemberDialogType, int i, com.moji.http.member.entity.ShortMemberDialogResult.Config config) {
        this.n = memberDialogManager;
        this.t = shortMemberDialogType;
        this.u = i;
        this.v = config;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.h(this.n, this.t, this.u, this.v, view);
    }
}

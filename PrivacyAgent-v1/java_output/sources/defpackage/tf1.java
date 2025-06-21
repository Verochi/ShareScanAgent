package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class tf1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.member_control.MemberDialogManager n;

    public /* synthetic */ tf1(com.moji.shorttime.ui.member_control.MemberDialogManager memberDialogManager) {
        this.n = memberDialogManager;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.member_control.MemberDialogManager.e(this.n, (com.moji.http.member.entity.ShortMemberDialogResult) obj);
    }
}

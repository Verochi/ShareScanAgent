package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class qk1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.member.entity.MemberTabResultNew.RightType.Right n;
    public final /* synthetic */ com.moji.newmember.newtab.adapter.MemberUnVipPrivilegeAdapter t;
    public final /* synthetic */ int u;

    public /* synthetic */ qk1(com.moji.http.member.entity.MemberTabResultNew.RightType.Right right, com.moji.newmember.newtab.adapter.MemberUnVipPrivilegeAdapter memberUnVipPrivilegeAdapter, int i) {
        this.n = right;
        this.t = memberUnVipPrivilegeAdapter;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.adapter.MemberUnVipPrivilegeAdapter.ItemHolder.a(this.n, this.t, this.u, view);
    }
}

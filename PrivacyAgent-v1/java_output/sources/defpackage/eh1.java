package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class eh1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter n;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity t;
    public final /* synthetic */ int u;

    public /* synthetic */ eh1(com.moji.newmember.personal.adapter.MemberNotificationItemAdapter memberNotificationItemAdapter, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity, int i) {
        this.n = memberNotificationItemAdapter;
        this.t = subEquity;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder.a(this.n, this.t, this.u, view);
    }
}

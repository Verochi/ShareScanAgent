package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ch1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity u;

    public /* synthetic */ ch1(com.moji.newmember.personal.adapter.MemberNotificationItemAdapter memberNotificationItemAdapter, int i, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity) {
        this.n = memberNotificationItemAdapter;
        this.t = i;
        this.u = subEquity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder.b(this.n, this.t, this.u, view);
    }
}

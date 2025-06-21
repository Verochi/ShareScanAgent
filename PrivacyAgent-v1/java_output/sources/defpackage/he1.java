package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class he1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity n;
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberAddNotificationForLocationAdapter t;
    public final /* synthetic */ int u;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity v;

    public /* synthetic */ he1(com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity, com.moji.newmember.personal.adapter.MemberAddNotificationForLocationAdapter memberAddNotificationForLocationAdapter, int i, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity2) {
        this.n = subEquity;
        this.t = memberAddNotificationForLocationAdapter;
        this.u = i;
        this.v = subEquity2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberAddNotificationForLocationAdapter.NotificationHolder.a(this.n, this.t, this.u, this.v, view);
    }
}

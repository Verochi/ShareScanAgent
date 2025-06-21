package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class gh1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter n;
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder t;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity u;

    public /* synthetic */ gh1(com.moji.newmember.personal.adapter.MemberNotificationItemAdapter memberNotificationItemAdapter, com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder notificationHolder, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity) {
        this.n = memberNotificationItemAdapter;
        this.t = notificationHolder;
        this.u = subEquity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder.d(this.n, this.t, this.u, view);
    }
}

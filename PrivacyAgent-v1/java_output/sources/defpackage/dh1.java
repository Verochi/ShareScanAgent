package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class dh1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity n;
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter t;
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder u;

    public /* synthetic */ dh1(com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity, com.moji.newmember.personal.adapter.MemberNotificationItemAdapter memberNotificationItemAdapter, com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder notificationHolder) {
        this.n = subEquity;
        this.t = memberNotificationItemAdapter;
        this.u = notificationHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberNotificationItemAdapter.NotificationHolder.c(this.n, this.t, this.u, view);
    }
}

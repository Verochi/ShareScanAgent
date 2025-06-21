package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class vg1 implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.Condition t;
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder u;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity v;

    public /* synthetic */ vg1(int i, com.moji.http.msc.entity.SubMemberListRes.Condition condition, com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder notificationHolder, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity) {
        this.n = i;
        this.t = condition;
        this.u = notificationHolder;
        this.v = subEquity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder.g(this.n, this.t, this.u, this.v, view);
    }
}

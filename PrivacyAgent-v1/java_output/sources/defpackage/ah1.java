package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ah1 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder a;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.SubEquity b;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.Condition c;

    public /* synthetic */ ah1(com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder notificationHolder, com.moji.http.msc.entity.SubMemberListRes.SubEquity subEquity, com.moji.http.msc.entity.SubMemberListRes.Condition condition) {
        this.a = notificationHolder;
        this.b = subEquity;
        this.c = condition;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder.b(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}

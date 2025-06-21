package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wg1 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder a;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberListRes.Condition b;

    public /* synthetic */ wg1(com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder notificationHolder, com.moji.http.msc.entity.SubMemberListRes.Condition condition) {
        this.a = notificationHolder;
        this.b = condition;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newmember.personal.adapter.MemberNotificationDetailsAdapter.NotificationHolder.f(this.a, this.b, mJDialog, eTypeAction);
    }
}

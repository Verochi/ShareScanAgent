package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class lj1 implements android.view.View.OnClickListener {
    public final /* synthetic */ java.lang.String n;
    public final /* synthetic */ int t;

    public /* synthetic */ lj1(java.lang.String str, int i) {
        this.n = str;
        this.t = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberScenicAreaNotificationAdapter.NotificationHolder.a(this.n, this.t, view);
    }
}

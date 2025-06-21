package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class qi1 implements android.view.View.OnClickListener {
    public final /* synthetic */ android.widget.EditText n;
    public final /* synthetic */ com.moji.newmember.personal.MemberRemindActivityV2 t;

    public /* synthetic */ qi1(android.widget.EditText editText, com.moji.newmember.personal.MemberRemindActivityV2 memberRemindActivityV2) {
        this.n = editText;
        this.t = memberRemindActivityV2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.MemberRemindActivityV2.q(this.n, this.t, view);
    }
}

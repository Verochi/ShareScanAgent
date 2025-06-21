package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class za0 implements android.view.View.OnClickListener {
    public final /* synthetic */ int n;
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberActivity t;
    public final /* synthetic */ android.widget.EditText u;
    public final /* synthetic */ com.moji.http.member.entity.GroupMember v;

    public /* synthetic */ za0(int i, com.moji.newmember.familymember.ui.FamilyMemberActivity familyMemberActivity, android.widget.EditText editText, com.moji.http.member.entity.GroupMember groupMember) {
        this.n = i;
        this.t = familyMemberActivity;
        this.u = editText;
        this.v = groupMember;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.familymember.ui.FamilyMemberActivity.d(this.n, this.t, this.u, this.v, view);
    }
}

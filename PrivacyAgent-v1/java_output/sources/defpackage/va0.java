package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class va0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberActivity n;

    public /* synthetic */ va0(com.moji.newmember.familymember.ui.FamilyMemberActivity familyMemberActivity) {
        this.n = familyMemberActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.familymember.ui.FamilyMemberActivity.g(this.n, (com.moji.http.member.entity.FamilyGroupDetailResult) obj);
    }
}

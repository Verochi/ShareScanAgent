package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ua0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberActivity n;

    public /* synthetic */ ua0(com.moji.newmember.familymember.ui.FamilyMemberActivity familyMemberActivity) {
        this.n = familyMemberActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.familymember.ui.FamilyMemberActivity.h(this.n, (com.moji.http.member.entity.FamilyGroupAddResult) obj);
    }
}

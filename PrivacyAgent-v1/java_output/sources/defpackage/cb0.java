package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class cb0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberUpdateGroupNameActivity n;

    public /* synthetic */ cb0(com.moji.newmember.familymember.ui.FamilyMemberUpdateGroupNameActivity familyMemberUpdateGroupNameActivity) {
        this.n = familyMemberUpdateGroupNameActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.familymember.ui.FamilyMemberUpdateGroupNameActivity.b(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}

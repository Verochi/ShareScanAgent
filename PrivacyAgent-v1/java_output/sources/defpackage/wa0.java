package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wa0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.familymember.ui.FamilyMemberActivity n;

    public /* synthetic */ wa0(com.moji.newmember.familymember.ui.FamilyMemberActivity familyMemberActivity) {
        this.n = familyMemberActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.familymember.ui.FamilyMemberActivity.f(this.n, (java.lang.String) obj);
    }
}

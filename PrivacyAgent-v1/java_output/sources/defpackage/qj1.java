package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class qj1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberScenicAreaSubListActivity n;

    public /* synthetic */ qj1(com.moji.newmember.personal.MemberScenicAreaSubListActivity memberScenicAreaSubListActivity) {
        this.n = memberScenicAreaSubListActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberScenicAreaSubListActivity.d(this.n, (com.moji.requestcore.entity.MJBaseRespRc) obj);
    }
}

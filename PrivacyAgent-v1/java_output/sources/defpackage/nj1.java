package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class nj1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberScenicAreaSubListActivity n;

    public /* synthetic */ nj1(com.moji.newmember.personal.MemberScenicAreaSubListActivity memberScenicAreaSubListActivity) {
        this.n = memberScenicAreaSubListActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberScenicAreaSubListActivity.e(this.n, (com.moji.http.msc.entity.SubMemberScenicAreaListRes) obj);
    }
}

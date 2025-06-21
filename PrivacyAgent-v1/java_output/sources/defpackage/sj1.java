package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class sj1 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.MemberScenicAreaSubListAdapter n;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberScenicAreaListRes.SpotSub t;
    public final /* synthetic */ int u;

    public /* synthetic */ sj1(com.moji.newmember.personal.adapter.MemberScenicAreaSubListAdapter memberScenicAreaSubListAdapter, com.moji.http.msc.entity.SubMemberScenicAreaListRes.SpotSub spotSub, int i) {
        this.n = memberScenicAreaSubListAdapter;
        this.t = spotSub;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.MemberScenicAreaSubListAdapter.NotificationHolder.a(this.n, this.t, this.u, view);
    }
}

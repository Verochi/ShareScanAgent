package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ls2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.adapter.SubNormalSpotNewAdapter n;
    public final /* synthetic */ int t;
    public final /* synthetic */ com.moji.http.msc.entity.SubMemberScenicAreaListRes.SpotSubBean u;

    public /* synthetic */ ls2(com.moji.newmember.personal.adapter.SubNormalSpotNewAdapter subNormalSpotNewAdapter, int i, com.moji.http.msc.entity.SubMemberScenicAreaListRes.SpotSubBean spotSubBean) {
        this.n = subNormalSpotNewAdapter;
        this.t = i;
        this.u = spotSubBean;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.adapter.SubNormalSpotNewAdapter.NotificationHolder.b(this.n, this.t, this.u, view);
    }
}

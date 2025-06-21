package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class m8 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.personal.AllSceneSubListActivity.SubListAdapter n;
    public final /* synthetic */ java.util.List t;
    public final /* synthetic */ int u;

    public /* synthetic */ m8(com.moji.newmember.personal.AllSceneSubListActivity.SubListAdapter subListAdapter, java.util.List list, int i) {
        this.n = subListAdapter;
        this.t = list;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.personal.AllSceneSubListActivity.SubListAdapter.NormalSpotHolder.a(this.n, this.t, this.u, view);
    }
}

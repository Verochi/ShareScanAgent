package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class bx2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.newtab.holder.TabMemberDataHolder n;
    public final /* synthetic */ com.moji.newmember.newtab.controller.TabMemberSystemNotifyLayout t;

    public /* synthetic */ bx2(com.moji.newmember.newtab.holder.TabMemberDataHolder tabMemberDataHolder, com.moji.newmember.newtab.controller.TabMemberSystemNotifyLayout tabMemberSystemNotifyLayout) {
        this.n = tabMemberDataHolder;
        this.t = tabMemberSystemNotifyLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.controller.TabMemberSystemNotifyLayout.j(this.n, this.t, view);
    }
}

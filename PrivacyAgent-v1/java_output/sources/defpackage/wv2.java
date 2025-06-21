package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wv2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.newtab.controller.TabMemberFamilyVipLayout n;
    public final /* synthetic */ com.moji.newmember.newtab.holder.TabMemberDataHolder t;

    public /* synthetic */ wv2(com.moji.newmember.newtab.controller.TabMemberFamilyVipLayout tabMemberFamilyVipLayout, com.moji.newmember.newtab.holder.TabMemberDataHolder tabMemberDataHolder) {
        this.n = tabMemberFamilyVipLayout;
        this.t = tabMemberDataHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.controller.TabMemberFamilyVipLayout.a(this.n, this.t, view);
    }
}

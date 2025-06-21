package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class uw2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.newtab.holder.TabMemberDataHolder n;
    public final /* synthetic */ com.moji.newmember.newtab.controller.TabMemberLocationSettingLayout t;

    public /* synthetic */ uw2(com.moji.newmember.newtab.holder.TabMemberDataHolder tabMemberDataHolder, com.moji.newmember.newtab.controller.TabMemberLocationSettingLayout tabMemberLocationSettingLayout) {
        this.n = tabMemberDataHolder;
        this.t = tabMemberLocationSettingLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.controller.TabMemberLocationSettingLayout.e(this.n, this.t, view);
    }
}

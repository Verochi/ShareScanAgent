package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ex2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayout n;
    public final /* synthetic */ com.moji.newmember.newtab.holder.TabMemberDataHolder t;

    public /* synthetic */ ex2(com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayout tabMemberWeatherRemindLayout, com.moji.newmember.newtab.holder.TabMemberDataHolder tabMemberDataHolder) {
        this.n = tabMemberWeatherRemindLayout;
        this.t = tabMemberDataHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayout.c(this.n, this.t, view);
    }
}

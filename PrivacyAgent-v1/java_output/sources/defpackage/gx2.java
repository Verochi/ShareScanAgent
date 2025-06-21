package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class gx2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayoutNew n;
    public final /* synthetic */ com.moji.newmember.newtab.holder.TabMemberDataHolder t;

    public /* synthetic */ gx2(com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayoutNew tabMemberWeatherRemindLayoutNew, com.moji.newmember.newtab.holder.TabMemberDataHolder tabMemberDataHolder) {
        this.n = tabMemberWeatherRemindLayoutNew;
        this.t = tabMemberDataHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newmember.newtab.controller.TabMemberWeatherRemindLayoutNew.a(this.n, this.t, view);
    }
}

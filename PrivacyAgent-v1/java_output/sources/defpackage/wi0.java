package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class wi0 implements com.moji.mjweather.ipc.view.liveviewcomment.MenuPopWindow.OnMenuItemClickListener {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.FriendDynamicActivity n;

    public /* synthetic */ wi0(com.moji.newliveview.frienddynamic.FriendDynamicActivity friendDynamicActivity) {
        this.n = friendDynamicActivity;
    }

    public final void onMenuItemClick(java.lang.String str, java.lang.Object obj) {
        com.moji.newliveview.frienddynamic.FriendDynamicActivity.d(this.n, str, (com.moji.http.snsforum.ILiveViewComment) obj);
    }
}

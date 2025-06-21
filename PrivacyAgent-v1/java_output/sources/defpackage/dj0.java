package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class dj0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.FriendDynamicActivity n;

    public /* synthetic */ dj0(com.moji.newliveview.frienddynamic.FriendDynamicActivity friendDynamicActivity) {
        this.n = friendDynamicActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.frienddynamic.FriendDynamicActivity.g(this.n, (com.moji.newliveview.frienddynamic.data.AddPraiseData) obj);
    }
}

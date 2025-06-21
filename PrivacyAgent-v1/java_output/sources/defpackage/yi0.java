package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class yi0 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.FriendDynamicActivity n;

    public /* synthetic */ yi0(com.moji.newliveview.frienddynamic.FriendDynamicActivity friendDynamicActivity) {
        this.n = friendDynamicActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.frienddynamic.FriendDynamicActivity.b(this.n, (com.moji.http.snsforum.entity.DynamicDetailResp) obj);
    }
}

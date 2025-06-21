package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class zd implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.AttentionTabFriendFragment n;

    public /* synthetic */ zd(com.moji.newliveview.frienddynamic.AttentionTabFriendFragment attentionTabFriendFragment) {
        this.n = attentionTabFriendFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.frienddynamic.AttentionTabFriendFragment.c(this.n, (com.moji.http.snsforum.entity.FriendDynamicListResult) obj);
    }
}

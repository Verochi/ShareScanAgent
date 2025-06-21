package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class rd implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.newliveview.frienddynamic.AttentionDynamicAdapter.AttentionDynamicViewHolder n;
    public final /* synthetic */ com.moji.newliveview.frienddynamic.AttentionDynamicAdapter t;

    public /* synthetic */ rd(com.moji.newliveview.frienddynamic.AttentionDynamicAdapter.AttentionDynamicViewHolder attentionDynamicViewHolder, com.moji.newliveview.frienddynamic.AttentionDynamicAdapter attentionDynamicAdapter) {
        this.n = attentionDynamicViewHolder;
        this.t = attentionDynamicAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.newliveview.frienddynamic.AttentionDynamicAdapter.AttentionDynamicViewHolder.c(this.n, this.t, view);
    }
}

package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class nd2 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.sence.scenestore.list.SceneStoreListAdapter.CardItemViewHolder n;
    public final /* synthetic */ com.moji.sence.scenestore.model.BgStoreModel t;

    public /* synthetic */ nd2(com.moji.sence.scenestore.list.SceneStoreListAdapter.CardItemViewHolder cardItemViewHolder, com.moji.sence.scenestore.model.BgStoreModel bgStoreModel) {
        this.n = cardItemViewHolder;
        this.t = bgStoreModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.sence.scenestore.list.SceneStoreListAdapter.CardItemViewHolder.a(this.n, this.t, view);
    }
}

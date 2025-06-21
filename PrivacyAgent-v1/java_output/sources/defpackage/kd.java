package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class kd implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.atlas.AtlasActivity n;

    public /* synthetic */ kd(com.moji.newliveview.atlas.AtlasActivity atlasActivity) {
        this.n = atlasActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.atlas.AtlasActivity.c(this.n, (com.moji.newliveview.detail.data.AddPictureCommentData) obj);
    }
}

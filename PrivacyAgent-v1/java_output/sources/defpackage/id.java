package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class id implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.atlas.AtlasActivity n;

    public /* synthetic */ id(com.moji.newliveview.atlas.AtlasActivity atlasActivity) {
        this.n = atlasActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.atlas.AtlasActivity.d(this.n, (com.moji.http.snsforum.entity.PictureDetailResult) obj);
    }
}

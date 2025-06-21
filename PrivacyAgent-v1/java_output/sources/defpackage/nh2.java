package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class nh2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.mjshortvideo.ShortVideoShareActivity n;

    public /* synthetic */ nh2(com.moji.mjshortvideo.ShortVideoShareActivity shortVideoShareActivity) {
        this.n = shortVideoShareActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.mjshortvideo.ShortVideoShareActivity.b(this.n, (com.moji.http.feedvideo.entity.VideoShareDetails) obj);
    }
}

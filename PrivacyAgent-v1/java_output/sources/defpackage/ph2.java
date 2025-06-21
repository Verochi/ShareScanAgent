package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class ph2 implements io.reactivex.functions.Consumer {
    public final /* synthetic */ com.moji.mjshortvideo.ShortVideoShareActivity n;
    public final /* synthetic */ com.moji.share.entity.ShareChannelType t;

    public /* synthetic */ ph2(com.moji.mjshortvideo.ShortVideoShareActivity shortVideoShareActivity, com.moji.share.entity.ShareChannelType shareChannelType) {
        this.n = shortVideoShareActivity;
        this.t = shareChannelType;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(java.lang.Object obj) {
        com.moji.mjshortvideo.ShortVideoShareActivity.onCreate.4.b(this.n, this.t, (java.lang.String) obj);
    }
}

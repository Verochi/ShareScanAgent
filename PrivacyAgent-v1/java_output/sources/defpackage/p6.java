package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class p6 implements fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged {
    public final /* synthetic */ com.moji.mjad.common.view.creater.maincard.AdVideoViewForMainCard a;

    public /* synthetic */ p6(com.moji.mjad.common.view.creater.maincard.AdVideoViewForMainCard adVideoViewForMainCard) {
        this.a = adVideoViewForMainCard;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged
    public final void onProcessChanged(int i) {
        com.moji.mjad.common.view.creater.maincard.AdVideoViewForMainCard.c(this.a, i);
    }
}

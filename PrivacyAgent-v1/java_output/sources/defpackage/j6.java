package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class j6 implements fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged {
    public final /* synthetic */ com.moji.mjad.common.view.creater.maincard.AdVideoViewForFeedCard a;

    public /* synthetic */ j6(com.moji.mjad.common.view.creater.maincard.AdVideoViewForFeedCard adVideoViewForFeedCard) {
        this.a = adVideoViewForFeedCard;
    }

    @Override // fm.jiecao.jcvideoplayer_lib.IVideoPlayProcessChanged
    public final void onProcessChanged(int i) {
        com.moji.mjad.common.view.creater.maincard.AdVideoViewForFeedCard.b(this.a, i);
    }
}

package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class c6 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoGDTCreater n;
    public final /* synthetic */ com.moji.mjad.view.AdTouchLayerView t;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon u;

    public /* synthetic */ c6(com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoGDTCreater adStyleFeedDetailVideoGDTCreater, com.moji.mjad.view.AdTouchLayerView adTouchLayerView, com.moji.mjad.common.data.AdCommon adCommon) {
        this.n = adStyleFeedDetailVideoGDTCreater;
        this.t = adTouchLayerView;
        this.u = adCommon;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoGDTCreater.o(this.n, this.t, this.u);
    }
}

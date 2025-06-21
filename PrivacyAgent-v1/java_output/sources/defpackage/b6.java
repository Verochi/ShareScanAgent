package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class b6 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoBDCreater n;
    public final /* synthetic */ com.moji.mjad.view.AdTouchLayerView t;
    public final /* synthetic */ com.moji.mjad.common.data.AdCommon u;

    public /* synthetic */ b6(com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoBDCreater adStyleFeedDetailVideoBDCreater, com.moji.mjad.view.AdTouchLayerView adTouchLayerView, com.moji.mjad.common.data.AdCommon adCommon) {
        this.n = adStyleFeedDetailVideoBDCreater;
        this.t = adTouchLayerView;
        this.u = adCommon;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.common.view.creater.feed.AdStyleFeedDetailVideoBDCreater.o(this.n, this.t, this.u);
    }
}

package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ib0 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJFeedDetail a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ com.moji.liveview_finalversion.ui.detail.FeedDetailWrapperFragment d;

    public /* synthetic */ ib0(com.moji.liveview_finalversion.data.base.MJFeedDetail mJFeedDetail, boolean z, long j, com.moji.liveview_finalversion.ui.detail.FeedDetailWrapperFragment feedDetailWrapperFragment) {
        this.a = mJFeedDetail;
        this.b = z;
        this.c = j;
        this.d = feedDetailWrapperFragment;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.liveview_finalversion.ui.detail.FeedDetailWrapperFragment.f(this.a, this.b, this.c, this.d, mJDialog, eTypeAction);
    }
}

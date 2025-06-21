package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class kb0 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ android.widget.LinearLayout a;
    public final /* synthetic */ com.moji.newliveview.detail.RadioGroupExtend b;
    public final /* synthetic */ com.moji.liveview_finalversion.data.base.MJFeedDetail c;

    public /* synthetic */ kb0(android.widget.LinearLayout linearLayout, com.moji.newliveview.detail.RadioGroupExtend radioGroupExtend, com.moji.liveview_finalversion.data.base.MJFeedDetail mJFeedDetail) {
        this.a = linearLayout;
        this.b = radioGroupExtend;
        this.c = mJFeedDetail;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.liveview_finalversion.ui.detail.FeedDetailWrapperFragment.b(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}

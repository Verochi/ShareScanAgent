package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class xb0 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.moji.mjweather.feed.FeedH5Fragment b;

    public /* synthetic */ xb0(java.lang.String str, com.moji.mjweather.feed.FeedH5Fragment feedH5Fragment) {
        this.a = str;
        this.b = feedH5Fragment;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.feed.FeedH5Fragment.c(this.a, this.b, mJDialog, eTypeAction);
    }
}

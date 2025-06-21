package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class zq implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.newliveview.detail.CommentManager a;
    public final /* synthetic */ com.moji.http.snsforum.ILiveViewComment b;

    public /* synthetic */ zq(com.moji.newliveview.detail.CommentManager commentManager, com.moji.http.snsforum.ILiveViewComment iLiveViewComment) {
        this.a = commentManager;
        this.b = iLiveViewComment;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newliveview.detail.CommentManager.mItemClickCallBack.1.a(this.a, this.b, mJDialog, eTypeAction);
    }
}

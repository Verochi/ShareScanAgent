package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class n22 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ android.widget.LinearLayout a;
    public final /* synthetic */ com.moji.newliveview.detail.RadioGroupExtend b;
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity c;

    public /* synthetic */ n22(android.widget.LinearLayout linearLayout, com.moji.newliveview.detail.RadioGroupExtend radioGroupExtend, com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.a = linearLayout;
        this.b = radioGroupExtend;
        this.c = pictureStoryActivity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newliveview.story.ui.PictureStoryActivity.p(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}

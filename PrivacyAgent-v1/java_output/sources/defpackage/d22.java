package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class d22 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ java.util.ArrayList a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ com.moji.newliveview.story.ui.PictureStoryActivity e;

    public /* synthetic */ d22(java.util.ArrayList arrayList, boolean z, long j, long j2, com.moji.newliveview.story.ui.PictureStoryActivity pictureStoryActivity) {
        this.a = arrayList;
        this.b = z;
        this.c = j;
        this.d = j2;
        this.e = pictureStoryActivity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newliveview.story.ui.PictureStoryActivity.d(this.a, this.b, this.c, this.d, this.e, mJDialog, eTypeAction);
    }
}

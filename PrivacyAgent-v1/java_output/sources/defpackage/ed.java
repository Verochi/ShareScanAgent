package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class ed implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ android.widget.LinearLayout a;
    public final /* synthetic */ com.moji.newliveview.detail.RadioGroupExtend b;
    public final /* synthetic */ com.moji.newliveview.atlas.AtlasActivity c;

    public /* synthetic */ ed(android.widget.LinearLayout linearLayout, com.moji.newliveview.detail.RadioGroupExtend radioGroupExtend, com.moji.newliveview.atlas.AtlasActivity atlasActivity) {
        this.a = linearLayout;
        this.b = radioGroupExtend;
        this.c = atlasActivity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newliveview.atlas.AtlasActivity.g(this.a, this.b, this.c, mJDialog, eTypeAction);
    }
}

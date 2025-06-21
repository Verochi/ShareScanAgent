package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class bd implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ java.util.ArrayList a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ com.moji.newliveview.atlas.AtlasActivity e;

    public /* synthetic */ bd(java.util.ArrayList arrayList, boolean z, long j, long j2, com.moji.newliveview.atlas.AtlasActivity atlasActivity) {
        this.a = arrayList;
        this.b = z;
        this.c = j;
        this.d = j2;
        this.e = atlasActivity;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.newliveview.atlas.AtlasActivity.m(this.a, this.b, this.c, this.d, this.e, mJDialog, eTypeAction);
    }
}

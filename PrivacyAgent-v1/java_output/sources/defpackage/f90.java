package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class f90 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newliveview.camera.activity.EditLableActivity n;

    public /* synthetic */ f90(com.moji.newliveview.camera.activity.EditLableActivity editLableActivity) {
        this.n = editLableActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newliveview.camera.activity.EditLableActivity.b(this.n, (java.util.List) obj);
    }
}

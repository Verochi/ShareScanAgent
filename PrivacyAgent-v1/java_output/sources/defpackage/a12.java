package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class a12 implements com.moji.pickerview.listener.OnItemSelectedListener {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.view.PickTimeDialog n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef v;

    public /* synthetic */ a12(com.moji.dangerousdrivingforecast.view.PickTimeDialog pickTimeDialog, kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.internal.Ref.ObjectRef objectRef2, kotlin.jvm.internal.Ref.ObjectRef objectRef3) {
        this.n = pickTimeDialog;
        this.t = objectRef;
        this.u = objectRef2;
        this.v = objectRef3;
    }

    public final void onItemSelected(int i) {
        com.moji.dangerousdrivingforecast.view.PickTimeDialog.b(this.n, this.t, this.u, this.v, i);
    }
}

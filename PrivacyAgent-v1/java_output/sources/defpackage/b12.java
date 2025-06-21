package defpackage;

/* loaded from: classes30.dex */
public final /* synthetic */ class b12 implements com.moji.pickerview.listener.OnItemSelectedListener {
    public final /* synthetic */ com.moji.dangerousdrivingforecast.view.PickTimeDialog n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;

    public /* synthetic */ b12(com.moji.dangerousdrivingforecast.view.PickTimeDialog pickTimeDialog, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = pickTimeDialog;
        this.t = objectRef;
    }

    public final void onItemSelected(int i) {
        com.moji.dangerousdrivingforecast.view.PickTimeDialog.a(this.n, this.t, i);
    }
}

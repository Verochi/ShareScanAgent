package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class cd2 implements com.moji.pickerview.listener.OnItemSelectedListener {
    public final /* synthetic */ com.moji.pickerview.lib.WheelView n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ com.moji.sakura.SakuraSearchActivity u;
    public final /* synthetic */ kotlin.jvm.internal.Ref.IntRef v;

    public /* synthetic */ cd2(com.moji.pickerview.lib.WheelView wheelView, kotlin.jvm.internal.Ref.ObjectRef objectRef, com.moji.sakura.SakuraSearchActivity sakuraSearchActivity, kotlin.jvm.internal.Ref.IntRef intRef) {
        this.n = wheelView;
        this.t = objectRef;
        this.u = sakuraSearchActivity;
        this.v = intRef;
    }

    public final void onItemSelected(int i) {
        com.moji.sakura.SakuraSearchActivity.f(this.n, this.t, this.u, this.v, i);
    }
}

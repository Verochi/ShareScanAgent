package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class v81 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;

    public /* synthetic */ v81(com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter, kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.internal.Ref.ObjectRef objectRef2) {
        this.n = mainDiamondPositionAdapter;
        this.t = objectRef;
        this.u = objectRef2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.a(this.n, this.t, this.u);
    }
}

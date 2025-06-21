package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class p81 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef u;

    public /* synthetic */ p81(com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter, kotlin.jvm.internal.Ref.ObjectRef objectRef, kotlin.jvm.internal.Ref.ObjectRef objectRef2) {
        this.n = mainDiamondPositionAdapter;
        this.t = objectRef;
        this.u = objectRef2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.g(this.n, this.t, this.u);
    }
}

package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class n81 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;

    public /* synthetic */ n81(com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = mainDiamondPositionAdapter;
        this.t = objectRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.i(this.n, this.t);
    }
}

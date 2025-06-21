package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class r81 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.diamon.adapter.MainDiamondPositionAdapter n;
    public final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef t;

    public /* synthetic */ r81(com.moji.diamon.adapter.MainDiamondPositionAdapter mainDiamondPositionAdapter, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        this.n = mainDiamondPositionAdapter;
        this.t = objectRef;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.adapter.MainDiamondPositionAdapter.h(this.n, this.t);
    }
}

package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class k10 implements java.lang.Runnable {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.diamon.anim.DiamondMainItemAnimator t;

    public /* synthetic */ k10(java.util.ArrayList arrayList, com.moji.diamon.anim.DiamondMainItemAnimator diamondMainItemAnimator) {
        this.n = arrayList;
        this.t = diamondMainItemAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.anim.DiamondMainItemAnimator.b(this.n, this.t);
    }
}

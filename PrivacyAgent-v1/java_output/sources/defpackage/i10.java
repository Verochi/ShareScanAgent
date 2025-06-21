package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class i10 implements java.lang.Runnable {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.diamon.anim.DiamondEditItemAnimator t;

    public /* synthetic */ i10(java.util.ArrayList arrayList, com.moji.diamon.anim.DiamondEditItemAnimator diamondEditItemAnimator) {
        this.n = arrayList;
        this.t = diamondEditItemAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.anim.DiamondEditItemAnimator.c(this.n, this.t);
    }
}

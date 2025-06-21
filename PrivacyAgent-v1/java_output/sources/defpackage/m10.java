package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class m10 implements java.lang.Runnable {
    public final /* synthetic */ java.util.ArrayList n;
    public final /* synthetic */ com.moji.diamon.anim.DiamondMainItemAnimator t;

    public /* synthetic */ m10(java.util.ArrayList arrayList, com.moji.diamon.anim.DiamondMainItemAnimator diamondMainItemAnimator) {
        this.n = arrayList;
        this.t = diamondMainItemAnimator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.diamon.anim.DiamondMainItemAnimator.a(this.n, this.t);
    }
}

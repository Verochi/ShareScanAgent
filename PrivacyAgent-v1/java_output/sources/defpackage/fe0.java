package defpackage;

/* loaded from: classes2.dex */
public final /* synthetic */ class fe0 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjfishing.control.FishingMainHeadViewControl n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ fe0(com.moji.mjfishing.control.FishingMainHeadViewControl fishingMainHeadViewControl, java.lang.String str) {
        this.n = fishingMainHeadViewControl;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjfishing.control.FishingMainHeadViewControl.b(this.n, this.t);
    }
}

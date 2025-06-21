package defpackage;

/* loaded from: classes28.dex */
public final /* synthetic */ class z5 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.mjad.statistics.AdStatistics n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ z5(com.moji.mjad.statistics.AdStatistics adStatistics, java.lang.String str) {
        this.n = adStatistics;
        this.t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.mjad.statistics.AdStatistics.a(this.n, this.t);
    }
}

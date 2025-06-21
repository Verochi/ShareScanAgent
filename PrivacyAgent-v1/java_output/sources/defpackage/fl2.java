package defpackage;

/* loaded from: classes17.dex */
public final /* synthetic */ class fl2 implements java.io.FileFilter {
    public final /* synthetic */ java.lang.String a;

    public /* synthetic */ fl2(java.lang.String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public final boolean accept(java.io.File file) {
        return com.moji.weathersence.skeletonad.SkeletonAdBgLoader.a(this.a, file);
    }
}

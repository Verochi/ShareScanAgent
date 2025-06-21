package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class w10 implements com.moji.tool.preferences.core.IPreferKey {
    public final /* synthetic */ long n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ w10(long j, java.lang.String str) {
        this.n = j;
        this.t = str;
    }

    public final java.lang.String name() {
        return com.moji.diamon.viewmodel.DiamondPreferences.e(this.n, this.t);
    }
}

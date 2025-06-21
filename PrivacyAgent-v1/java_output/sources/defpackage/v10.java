package defpackage;

/* loaded from: classes23.dex */
public final /* synthetic */ class v10 implements com.moji.tool.preferences.core.IPreferKey {
    public final /* synthetic */ long n;
    public final /* synthetic */ java.lang.String t;

    public /* synthetic */ v10(long j, java.lang.String str) {
        this.n = j;
        this.t = str;
    }

    public final java.lang.String name() {
        return com.moji.diamon.viewmodel.DiamondPreferences.d(this.n, this.t);
    }
}

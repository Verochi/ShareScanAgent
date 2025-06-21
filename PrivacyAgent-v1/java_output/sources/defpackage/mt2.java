package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class mt2 implements android.os.Handler.Callback {
    public final /* synthetic */ com.moji.sunglow.SunglowMainActivity n;

    public /* synthetic */ mt2(com.moji.sunglow.SunglowMainActivity sunglowMainActivity) {
        this.n = sunglowMainActivity;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        return com.moji.sunglow.SunglowMainActivity.n(this.n, message);
    }
}

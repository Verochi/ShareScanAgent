package com.jd.ad.sdk.jad_mv;

/* loaded from: classes23.dex */
public class jad_an extends android.graphics.Paint {
    public jad_an() {
    }

    public jad_an(int i) {
        super(i);
    }

    public jad_an(int i, android.graphics.PorterDuff.Mode mode) {
        super(i);
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }

    public jad_an(android.graphics.PorterDuff.Mode mode) {
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@androidx.annotation.NonNull android.os.LocaleList localeList) {
    }
}

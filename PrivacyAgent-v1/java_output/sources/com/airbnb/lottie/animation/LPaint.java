package com.airbnb.lottie.animation;

/* loaded from: classes.dex */
public class LPaint extends android.graphics.Paint {
    public LPaint() {
    }

    public LPaint(int i) {
        super(i);
    }

    public LPaint(int i, android.graphics.PorterDuff.Mode mode) {
        super(i);
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }

    public LPaint(android.graphics.PorterDuff.Mode mode) {
        setXfermode(new android.graphics.PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@androidx.annotation.NonNull android.os.LocaleList localeList) {
    }
}

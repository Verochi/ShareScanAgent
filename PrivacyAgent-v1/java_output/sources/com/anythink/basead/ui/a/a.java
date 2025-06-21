package com.anythink.basead.ui.a;

/* loaded from: classes12.dex */
public final class a extends android.graphics.drawable.Drawable {
    android.graphics.Paint a = new android.graphics.Paint();

    @Override // android.graphics.drawable.Drawable
    public final void draw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        int max = java.lang.Math.max(canvas.getHeight(), canvas.getWidth());
        canvas.drawColor(-13750739);
        float f = max / 2;
        this.a.setShader(new android.graphics.RadialGradient(canvas.getWidth() / 2, canvas.getHeight() / 2, f, -1, 0, android.graphics.Shader.TileMode.CLAMP));
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, f, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@androidx.annotation.Nullable android.graphics.ColorFilter colorFilter) {
    }
}

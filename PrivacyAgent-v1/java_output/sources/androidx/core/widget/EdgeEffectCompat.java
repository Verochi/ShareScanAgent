package androidx.core.widget;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    private android.widget.EdgeEffect mEdgeEffect;

    @java.lang.Deprecated
    public EdgeEffectCompat(android.content.Context context) {
        this.mEdgeEffect = new android.widget.EdgeEffect(context);
    }

    public static void onPull(@androidx.annotation.NonNull android.widget.EdgeEffect edgeEffect, float f, float f2) {
        edgeEffect.onPull(f, f2);
    }

    @java.lang.Deprecated
    public boolean draw(android.graphics.Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @java.lang.Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @java.lang.Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @java.lang.Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @java.lang.Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @java.lang.Deprecated
    public boolean onPull(float f, float f2) {
        onPull(this.mEdgeEffect, f, f2);
        return true;
    }

    @java.lang.Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @java.lang.Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }
}

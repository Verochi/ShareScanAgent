package com.alimm.tanx.core.ad.ad.template.rendering.splash.component;

/* loaded from: classes.dex */
public class AdAnimatableImageView extends androidx.appcompat.widget.AppCompatImageView {
    private int tanxc_byte;
    private final android.content.Context tanxc_case;
    private final java.util.Set<com.alimm.tanx.core.ad.ad.template.rendering.splash.component.AdAnimatableImageView.OnAnimationEndListener> tanxc_do;
    private android.graphics.Paint tanxc_for;
    private boolean tanxc_if;
    private int tanxc_int;
    private int tanxc_new;
    private int tanxc_try;

    public interface OnAnimationEndListener {
        void onAnimationEnd();
    }

    public AdAnimatableImageView(android.content.Context context) {
        this(context, null);
    }

    public AdAnimatableImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdAnimatableImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tanxc_do = new java.util.concurrent.CopyOnWriteArraySet();
        this.tanxc_if = false;
        this.tanxc_case = context;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        if (!this.tanxc_if) {
            super.onDraw(canvas);
            return;
        }
        canvas.save();
        canvas.translate(0.0f, this.tanxc_byte);
        canvas.clipRect(0.0f, this.tanxc_new, getRight(), this.tanxc_try, android.graphics.Region.Op.INTERSECT);
        super.onDraw(canvas);
        canvas.restore();
        canvas.drawRect(0.0f, 0.0f, getRight(), this.tanxc_new + this.tanxc_byte, this.tanxc_for);
        canvas.drawRect(0.0f, this.tanxc_try + this.tanxc_byte, getRight(), this.tanxc_int, this.tanxc_for);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }
}

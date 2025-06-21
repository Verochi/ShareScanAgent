package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class CloseImageView extends android.widget.ImageView implements com.anythink.basead.ui.a {
    private final java.lang.String a;
    private float b;
    private android.graphics.Rect c;

    /* renamed from: com.anythink.basead.ui.CloseImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.CloseImageView.this.c = new android.graphics.Rect();
            com.anythink.basead.ui.CloseImageView closeImageView = com.anythink.basead.ui.CloseImageView.this;
            closeImageView.getHitRect(closeImageView.c);
            int width = ((int) (com.anythink.basead.ui.CloseImageView.this.c.width() * (com.anythink.basead.ui.CloseImageView.this.b - 1.0f))) / 2;
            int height = ((int) (com.anythink.basead.ui.CloseImageView.this.c.height() * (com.anythink.basead.ui.CloseImageView.this.b - 1.0f))) / 2;
            com.anythink.basead.ui.CloseImageView.this.c.top -= height;
            com.anythink.basead.ui.CloseImageView.this.c.bottom += height;
            com.anythink.basead.ui.CloseImageView.this.c.left -= width;
            com.anythink.basead.ui.CloseImageView.this.c.right += width;
        }
    }

    public CloseImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getClass().getSimpleName();
        this.b = 1.0f;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        float f = this.b;
        if (f > 1.0f) {
            com.anythink.core.common.o.w.a(this, f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action;
        if (this.b >= 1.0f || (!((action = motionEvent.getAction()) == 0 || action == 5) || this.c.contains(getLeft() + ((int) motionEvent.getX()), getTop() + ((int) motionEvent.getY())))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.anythink.basead.ui.a
    public void setClickAreaScaleFactor(float f) {
        this.b = f;
        if (f <= 0.0f) {
            this.b = 1.0f;
        }
        float f2 = this.b;
        if (f2 < 1.0f) {
            post(new com.anythink.basead.ui.CloseImageView.AnonymousClass1());
        } else if (f2 > 1.0f) {
            com.anythink.core.common.o.w.a(this, f2);
        }
    }
}

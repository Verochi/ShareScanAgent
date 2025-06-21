package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class CloseFrameLayout extends android.widget.FrameLayout implements com.anythink.basead.ui.a {
    private static final java.lang.String a = "CloseFrameLayout";
    private float b;
    private android.graphics.Rect c;

    /* renamed from: com.anythink.basead.ui.CloseFrameLayout$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.CloseFrameLayout.this.c = new android.graphics.Rect();
            com.anythink.basead.ui.CloseFrameLayout closeFrameLayout = com.anythink.basead.ui.CloseFrameLayout.this;
            closeFrameLayout.getHitRect(closeFrameLayout.c);
            int width = ((int) (com.anythink.basead.ui.CloseFrameLayout.this.c.width() * (com.anythink.basead.ui.CloseFrameLayout.this.b - 1.0f))) / 2;
            int height = ((int) (com.anythink.basead.ui.CloseFrameLayout.this.c.height() * (com.anythink.basead.ui.CloseFrameLayout.this.b - 1.0f))) / 2;
            com.anythink.basead.ui.CloseFrameLayout.this.c.top -= height;
            com.anythink.basead.ui.CloseFrameLayout.this.c.bottom += height;
            com.anythink.basead.ui.CloseFrameLayout.this.c.left -= width;
            com.anythink.basead.ui.CloseFrameLayout.this.c.right += width;
        }
    }

    public CloseFrameLayout(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
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
            post(new com.anythink.basead.ui.CloseFrameLayout.AnonymousClass1());
        } else if (f2 > 1.0f) {
            com.anythink.core.common.o.w.a(this, f2);
        }
    }
}

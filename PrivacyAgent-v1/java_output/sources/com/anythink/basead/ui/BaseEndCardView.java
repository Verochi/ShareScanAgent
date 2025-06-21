package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseEndCardView extends android.widget.RelativeLayout {
    protected java.lang.String a;
    protected com.anythink.core.common.f.l b;
    protected com.anythink.core.common.f.m c;
    protected com.anythink.core.common.f.n d;
    private boolean e;

    public BaseEndCardView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        super(context);
        this.a = getClass().getSimpleName();
        super.setWillNotDraw(false);
        this.b = lVar;
        this.c = mVar;
        this.d = mVar.n;
    }

    private static android.graphics.RectF a(int i, int i2) {
        int i3 = i / 2;
        float f = i2;
        int i4 = (int) (1.0f * f);
        android.graphics.RectF rectF = new android.graphics.RectF();
        rectF.left = i3 - i4;
        rectF.top = i2 - (i4 * 2);
        rectF.right = i3 + i4;
        rectF.bottom = f;
        return rectF;
    }

    public abstract void a();

    public android.graphics.drawable.Drawable b() {
        return null;
    }

    @Override // android.view.View
    public void draw(android.graphics.Canvas canvas) {
        try {
            if (this.e) {
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
                super.draw(canvas);
                int width = getWidth();
                int height = getHeight();
                int width2 = getWidth();
                int i = width2 / 2;
                float height2 = getHeight();
                int i2 = (int) (1.0f * height2);
                android.graphics.RectF rectF = new android.graphics.RectF();
                rectF.left = i - i2;
                rectF.top = r4 - (i2 * 2);
                rectF.right = i + i2;
                rectF.bottom = height2;
                com.anythink.core.common.o.w.a(canvas, width, height, rectF);
                canvas.restoreToCount(saveLayer);
                return;
            }
        } catch (java.lang.Exception unused) {
        }
        super.draw(canvas);
    }

    public void setNeedArc(boolean z) {
        this.e = z;
        postInvalidate();
    }
}

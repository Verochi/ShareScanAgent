package com.alimm.tanx.core.ad.ad.template.rendering.feed.view;

/* loaded from: classes.dex */
public class TouchTraceView extends android.view.View {
    private float tanxc_byte;
    private float tanxc_case;
    private float tanxc_char;
    android.content.Context tanxc_do;
    private int tanxc_else;
    float tanxc_for;
    private final boolean tanxc_goto;
    com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack tanxc_if;
    private final android.graphics.Paint tanxc_int;
    private final int tanxc_long;
    private final android.graphics.Path tanxc_new;
    private final int tanxc_this;
    private float tanxc_try;

    public interface InteractionCallBack {
        void onInteractionEnd(int i, int i2, int i3);

        void onInteractionStart();
    }

    public TouchTraceView(android.content.Context context, android.util.AttributeSet attributeSet, com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack interactionCallBack) {
        super(context, attributeSet);
        this.tanxc_else = 3;
        this.tanxc_goto = false;
        this.tanxc_long = 55;
        this.tanxc_this = 120;
        this.tanxc_for = 0.56f;
        this.tanxc_do = context;
        this.tanxc_new = new android.graphics.Path();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.tanxc_int = paint;
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setStrokeWidth(10.0f);
        this.tanxc_if = interactionCallBack;
    }

    private int tanxc_do(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (int) java.lang.Math.sqrt((f5 * f5) + (f6 * f6));
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "onDraw");
        canvas.drawPath(this.tanxc_new, this.tanxc_int);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int) (android.view.View.MeasureSpec.getSize(i) * this.tanxc_for), 1073741824));
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "ACTION_DOWN");
            this.tanxc_case = x;
            this.tanxc_char = y;
            this.tanxc_new.moveTo(x, y);
            com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack interactionCallBack = this.tanxc_if;
            if (interactionCallBack != null) {
                interactionCallBack.onInteractionStart();
            }
        } else {
            if (actionMasked == 1) {
                com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "ACTION_UP");
                com.alimm.tanx.core.utils.LogUtils.d("touch--->", "x: " + (x - this.tanxc_case) + " y:" + (y - this.tanxc_char));
                this.tanxc_new.reset();
                requestLayout();
                com.alimm.tanx.core.ad.ad.template.rendering.feed.view.TouchTraceView.InteractionCallBack interactionCallBack2 = this.tanxc_if;
                float f = this.tanxc_case;
                float f2 = this.tanxc_char;
                interactionCallBack2.onInteractionEnd((int) (x - f), (int) (y - f2), tanxc_do(x, f, y, f2));
                return true;
            }
            if (actionMasked != 2) {
                com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "default");
                this.tanxc_new.reset();
            } else {
                com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "ACTION_MOVE");
                this.tanxc_new.quadTo(this.tanxc_try, this.tanxc_byte, x, y);
            }
        }
        invalidate();
        this.tanxc_try = x;
        this.tanxc_byte = y;
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        android.graphics.Path path;
        super.onVisibilityAggregated(z);
        com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "onVisibilityAggregated:" + z);
        if (z || (path = this.tanxc_new) == null) {
            return;
        }
        path.reset();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        android.graphics.Path path;
        super.onWindowFocusChanged(z);
        if (!z && (path = this.tanxc_new) != null) {
            path.reset();
        }
        com.alimm.tanx.core.utils.LogUtils.d("TouchTraceView", "onWindowFocusChanged:" + z);
    }

    public void tanxc_do(float f) {
        this.tanxc_for = f;
    }
}

package com.otaliastudios.cameraview.internal;

/* loaded from: classes19.dex */
public class GridLinesLayout extends android.view.View {
    public static final int DEFAULT_COLOR = android.graphics.Color.argb(com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 255, 255, 255);
    public com.otaliastudios.cameraview.controls.Grid n;
    public int t;
    public android.graphics.drawable.ColorDrawable u;
    public android.graphics.drawable.ColorDrawable v;
    public final float w;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.internal.GridLinesLayout.DrawCallback x;

    /* renamed from: com.otaliastudios.cameraview.internal.GridLinesLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.controls.Grid.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.controls.Grid.OFF.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Grid.DRAW_3X3.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Grid.DRAW_PHI.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Grid.DRAW_4X4.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public interface DrawCallback {
        void a(int i);
    }

    public GridLinesLayout(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public GridLinesLayout(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = DEFAULT_COLOR;
        this.u = new android.graphics.drawable.ColorDrawable(this.t);
        this.v = new android.graphics.drawable.ColorDrawable(this.t);
        this.w = android.util.TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    private int getLineCount() {
        int i = com.otaliastudios.cameraview.internal.GridLinesLayout.AnonymousClass1.a[this.n.ordinal()];
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 0 : 3;
    }

    public final float a(int i) {
        return this.n == com.otaliastudios.cameraview.controls.Grid.DRAW_PHI ? i == 1 ? 0.38196602f : 0.618034f : (1.0f / (getLineCount() + 1)) * (i + 1.0f);
    }

    public int getGridColor() {
        return this.t;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Grid getGridMode() {
        return this.n;
    }

    @Override // android.view.View
    public void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int lineCount = getLineCount();
        for (int i = 0; i < lineCount; i++) {
            float a = a(i);
            canvas.translate(0.0f, getHeight() * a);
            this.u.draw(canvas);
            float f = -a;
            canvas.translate(0.0f, getHeight() * f);
            canvas.translate(a * getWidth(), 0.0f);
            this.v.draw(canvas);
            canvas.translate(f * getWidth(), 0.0f);
        }
        com.otaliastudios.cameraview.internal.GridLinesLayout.DrawCallback drawCallback = this.x;
        if (drawCallback != null) {
            drawCallback.a(lineCount);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.u.setBounds(i, 0, i3, (int) this.w);
        this.v.setBounds(0, i2, (int) this.w, i4);
    }

    public void setGridColor(@androidx.annotation.ColorInt int i) {
        this.t = i;
        this.u.setColor(i);
        this.v.setColor(i);
        postInvalidate();
    }

    public void setGridMode(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Grid grid) {
        this.n = grid;
        postInvalidate();
    }
}

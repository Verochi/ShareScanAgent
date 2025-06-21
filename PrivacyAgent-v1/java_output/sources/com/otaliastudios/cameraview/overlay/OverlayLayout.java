package com.otaliastudios.cameraview.overlay;

@android.annotation.SuppressLint({"CustomViewStyleable"})
/* loaded from: classes19.dex */
public class OverlayLayout extends android.widget.FrameLayout implements com.otaliastudios.cameraview.overlay.Overlay {
    public static final com.otaliastudios.cameraview.CameraLogger t = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.overlay.OverlayLayout.class.getSimpleName());

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.overlay.Overlay.Target n;

    /* renamed from: com.otaliastudios.cameraview.overlay.OverlayLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.overlay.Overlay.Target.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.overlay.Overlay.Target.PREVIEW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.overlay.Overlay.Target.VIDEO_SNAPSHOT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.otaliastudios.cameraview.overlay.Overlay.Target.PICTURE_SNAPSHOT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public boolean drawOnPictureSnapshot;
        public boolean drawOnPreview;
        public boolean drawOnVideoSnapshot;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.drawOnPreview = false;
            this.drawOnPictureSnapshot = false;
            this.drawOnVideoSnapshot = false;
        }

        public LayoutParams(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.drawOnPreview = false;
            this.drawOnPictureSnapshot = false;
            this.drawOnVideoSnapshot = false;
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.otaliastudios.cameraview.R.styleable.CameraView_Layout);
            try {
                this.drawOnPreview = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnPreview, false);
                this.drawOnPictureSnapshot = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnPictureSnapshot, false);
                this.drawOnVideoSnapshot = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnVideoSnapshot, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        @androidx.annotation.VisibleForTesting
        public boolean a(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target) {
            return (target == com.otaliastudios.cameraview.overlay.Overlay.Target.PREVIEW && this.drawOnPreview) || (target == com.otaliastudios.cameraview.overlay.Overlay.Target.VIDEO_SNAPSHOT && this.drawOnVideoSnapshot) || (target == com.otaliastudios.cameraview.overlay.Overlay.Target.PICTURE_SNAPSHOT && this.drawOnPictureSnapshot);
        }

        @androidx.annotation.NonNull
        public java.lang.String toString() {
            return getClass().getName() + "[drawOnPreview:" + this.drawOnPreview + ",drawOnPictureSnapshot:" + this.drawOnPictureSnapshot + ",drawOnVideoSnapshot:" + this.drawOnVideoSnapshot + "]";
        }
    }

    public OverlayLayout(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
        this.n = com.otaliastudios.cameraview.overlay.Overlay.Target.PREVIEW;
        setWillNotDraw(false);
    }

    @androidx.annotation.VisibleForTesting
    public boolean a(android.graphics.Canvas canvas, android.view.View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"MissingSuperCall"})
    public void draw(android.graphics.Canvas canvas) {
        t.i("normal draw called.");
        com.otaliastudios.cameraview.overlay.Overlay.Target target = com.otaliastudios.cameraview.overlay.Overlay.Target.PREVIEW;
        if (drawsOn(target)) {
            drawOn(target, canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(android.graphics.Canvas canvas, android.view.View view, long j) {
        com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams layoutParams = (com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams.a(this.n)) {
            t.v("Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.n, "params:", layoutParams);
            return a(canvas, view, j);
        }
        t.v("Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.n, "params:", layoutParams);
        return false;
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public void drawOn(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target, @androidx.annotation.NonNull android.graphics.Canvas canvas) {
        synchronized (this) {
            this.n = target;
            int i = com.otaliastudios.cameraview.overlay.OverlayLayout.AnonymousClass1.a[target.ordinal()];
            if (i == 1) {
                super.draw(canvas);
            } else if (i == 2 || i == 3) {
                canvas.save();
                float width = canvas.getWidth() / getWidth();
                float height = canvas.getHeight() / getHeight();
                t.v(com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "target:", target, "canvas:", canvas.getWidth() + "x" + canvas.getHeight(), "view:", getWidth() + "x" + getHeight(), "widthScale:", java.lang.Float.valueOf(width), "heightScale:", java.lang.Float.valueOf(height));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    @Override // com.otaliastudios.cameraview.overlay.Overlay
    public boolean drawsOn(@androidx.annotation.NonNull com.otaliastudios.cameraview.overlay.Overlay.Target target) {
        for (int i = 0; i < getChildCount(); i++) {
            if (((com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams) getChildAt(i).getLayoutParams()).a(target)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams(getContext(), attributeSet);
    }

    public boolean isOverlay(@androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            return false;
        }
        android.content.res.TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.otaliastudios.cameraview.R.styleable.CameraView_Layout);
        boolean z = obtainStyledAttributes.hasValue(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnPreview) || obtainStyledAttributes.hasValue(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnPictureSnapshot) || obtainStyledAttributes.hasValue(com.otaliastudios.cameraview.R.styleable.CameraView_Layout_layout_drawOnVideoSnapshot);
        obtainStyledAttributes.recycle();
        return z;
    }

    public boolean isOverlay(@androidx.annotation.NonNull android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof com.otaliastudios.cameraview.overlay.OverlayLayout.LayoutParams;
    }
}

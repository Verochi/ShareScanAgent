package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public abstract class BaseAliyunPasterView extends android.view.ViewGroup {
    public static final int MODE_DEVICE = 2;
    public static final int MODE_NORMALIZED = 1;
    public static final int MODE_VIEWPORT = 3;
    private static final float[] POINT_LIST = new float[8];
    private static final java.lang.String TAG = "EditOverlay";
    private int height;
    private boolean isMirror;
    private final android.graphics.Matrix mInverseTransform;
    private boolean mInverseTransformInvalidated;
    private com.aliyun.svideo.editor.widget.BaseAliyunPasterView.OnChangeListener mListener;
    protected final com.aliyun.svideo.editor.util.MatrixUtil mMatrixUtil;
    protected final android.graphics.Matrix mTransform;
    private int mTransformMode;
    private int mViewportHeight;
    private int mViewportWidth;
    private int width;

    /* renamed from: com.aliyun.svideo.editor.widget.BaseAliyunPasterView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) com.aliyun.svideo.editor.widget.BaseAliyunPasterView.this.getParent();
            if (viewGroup != null) {
                com.aliyun.svideo.editor.widget.BaseAliyunPasterView.this.width = viewGroup.getWidth();
                com.aliyun.svideo.editor.widget.BaseAliyunPasterView.this.height = viewGroup.getHeight();
            }
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.editor.R.styleable.EditOverlay_Layout);
            this.gravity = obtainStyledAttributes.getInteger(com.aliyun.svideo.editor.R.styleable.EditOverlay_Layout_android_layout_gravity, 51);
            obtainStyledAttributes.recycle();
        }
    }

    public interface OnChangeListener {
        void onChange(com.aliyun.svideo.editor.widget.BaseAliyunPasterView baseAliyunPasterView);
    }

    public BaseAliyunPasterView(android.content.Context context) {
        this(context, null);
    }

    public BaseAliyunPasterView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseAliyunPasterView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mViewportWidth = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        this.mViewportHeight = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        this.mTransform = new android.graphics.Matrix();
        this.mTransformMode = 2;
        this.mInverseTransform = new android.graphics.Matrix();
        this.mInverseTransformInvalidated = false;
        this.mMatrixUtil = new com.aliyun.svideo.editor.util.MatrixUtil();
        post(new com.aliyun.svideo.editor.widget.BaseAliyunPasterView.AnonymousClass1());
    }

    private void commit() {
        com.aliyun.svideo.editor.widget.BaseAliyunPasterView.OnChangeListener onChangeListener = this.mListener;
        if (onChangeListener != null) {
            onChangeListener.onChange(this);
        }
    }

    private android.graphics.Matrix converge() {
        return this.mTransform;
    }

    private int getPointFromMatrix(int i) {
        int i2 = i & 112;
        int i3 = i & 7;
        return (((i3 == 3 || i3 != 5) ? 0 : 1) + (((i2 == 48 || i2 != 80) ? 0 : 1) * 2)) * 2;
    }

    private void onLayoutContent() {
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Content ");
        sb.append(this.mMatrixUtil.toString());
        float contentWidth = (this.mMatrixUtil.scaleX * getContentWidth()) / 2.0f;
        float contentHeight = (this.mMatrixUtil.scaleY * getContentHeight()) / 2.0f;
        float[] center = getCenter();
        float f = center[0];
        float f2 = center[1];
        getContentView().setRotation(this.mMatrixUtil.getRotationDeg());
        getContentView().layout((int) (f - contentWidth), (int) (f2 - contentHeight), (int) (f + contentWidth), (int) (f2 + contentHeight));
    }

    public boolean contentContains(float f, float f2) {
        fromEditorToContent(f, f2);
        float[] fArr = POINT_LIST;
        return java.lang.Math.abs(fArr[0]) <= ((float) (getContentWidth() / 2)) && java.lang.Math.abs(fArr[1]) <= ((float) (getContentHeight() / 2));
    }

    public final void fromContentToEditor(float f, float f2) {
        float[] fArr = POINT_LIST;
        fArr[2] = f;
        fArr[3] = f2;
        this.mTransform.mapPoints(fArr, 0, fArr, 2, 1);
        fArr[0] = fArr[0] + (this.width / 2);
        fArr[1] = fArr[1] + (this.height / 2);
    }

    public final void fromEditorToContent(float f, float f2) {
        if (this.mInverseTransformInvalidated) {
            converge().invert(this.mInverseTransform);
            this.mInverseTransformInvalidated = false;
        }
        float[] fArr = POINT_LIST;
        fArr[2] = f - (this.width / 2);
        fArr[3] = f2 - (this.height / 2);
        this.mInverseTransform.mapPoints(fArr, 0, fArr, 2, 1);
    }

    @Override // android.view.ViewGroup
    public com.aliyun.svideo.editor.widget.BaseAliyunPasterView.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new com.aliyun.svideo.editor.widget.BaseAliyunPasterView.LayoutParams(getContext(), attributeSet);
    }

    public float[] getCenter() {
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return null;
        }
        return new float[]{(getWidth() / 2) + this.mMatrixUtil.translateX, (getHeight() / 2) + this.mMatrixUtil.translateY};
    }

    public abstract int getContentHeight();

    public abstract android.view.View getContentView();

    public abstract int getContentWidth();

    public int getLayoutHeight() {
        return this.height;
    }

    public int getLayoutWidth() {
        return this.width;
    }

    public com.aliyun.svideo.editor.util.MatrixUtil getMatrixUtil() {
        return this.mMatrixUtil;
    }

    @Override // android.view.View
    public float getRotation() {
        return this.mMatrixUtil.getRotation();
    }

    public float[] getScale() {
        com.aliyun.svideo.editor.util.MatrixUtil matrixUtil = this.mMatrixUtil;
        return new float[]{matrixUtil.scaleX, matrixUtil.scaleY};
    }

    public android.view.View getTextLabel() {
        return null;
    }

    public android.graphics.Matrix getTransform() {
        return this.mTransform;
    }

    public void invalidateTransform() {
        this.mInverseTransformInvalidated = true;
        validateTransform();
        requestLayout();
    }

    public boolean isCouldShowLabel() {
        return false;
    }

    public boolean isMirror() {
        return this.isMirror;
    }

    public void moveContent(float f, float f2) {
        this.mTransform.postTranslate(f, f2);
        invalidateTransform();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        validateTransform();
        onLayoutContent();
        float contentWidth = getContentWidth() / 2;
        float contentHeight = getContentHeight() / 2;
        float[] fArr = POINT_LIST;
        float f = -contentWidth;
        fArr[0] = f;
        float f2 = -contentHeight;
        fArr[1] = f2;
        fArr[2] = contentWidth;
        fArr[3] = f2;
        fArr[4] = f;
        fArr[5] = contentHeight;
        fArr[6] = contentWidth;
        fArr[7] = contentHeight;
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        converge().mapPoints(fArr);
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            android.view.View childAt = getChildAt(i5);
            if (childAt != getContentView()) {
                int pointFromMatrix = getPointFromMatrix(((com.aliyun.svideo.editor.widget.BaseAliyunPasterView.LayoutParams) childAt.getLayoutParams()).gravity);
                float[] fArr2 = POINT_LIST;
                int i6 = ((int) fArr2[pointFromMatrix]) + width;
                int i7 = ((int) fArr2[pointFromMatrix + 1]) + height;
                int measuredWidth = childAt.getMeasuredWidth() / 2;
                int measuredHeight = childAt.getMeasuredHeight() / 2;
                int i8 = i6 - measuredWidth;
                int i9 = i7 - measuredHeight;
                int i10 = i6 + measuredWidth;
                int i11 = i7 + measuredHeight;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("child_left : ");
                sb.append(i8);
                sb.append(" child_top : ");
                sb.append(i9);
                sb.append(" child_right : ");
                sb.append(i10);
                sb.append(" child_bottom : ");
                sb.append(i11);
                childAt.layout(i8, i9, i10, i11);
            }
        }
    }

    public void reset() {
        this.mTransform.reset();
        this.mTransformMode = 2;
        invalidateTransform();
    }

    public void rotateContent(float f) {
        this.mTransform.postRotate((float) java.lang.Math.toDegrees(f));
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        invalidateTransform();
    }

    public void rotateContent(float f, float f2, float f3) {
        this.mTransform.postRotate((float) java.lang.Math.toDegrees(f), f2, f3);
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        invalidateTransform();
    }

    public void scaleContent(float f, float f2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.set(this.mTransform);
        matrix.preScale(f, f2);
        this.mMatrixUtil.decomposeTSR(matrix);
        int contentWidth = (int) (this.mMatrixUtil.scaleX * getContentWidth());
        int contentHeight = (int) (this.mMatrixUtil.scaleY * getContentHeight());
        android.util.TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        android.graphics.Point screenPoint = com.aliyun.svideo.common.utils.ScreenUtils.getScreenPoint(getContext());
        float max = java.lang.Math.max(screenPoint.x, screenPoint.y);
        float applyDimension = android.util.TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
        float f3 = contentWidth;
        if (((f3 < max && contentHeight < max) || f <= 1.0f) && ((f3 > applyDimension && contentHeight > applyDimension) || f >= 1.0f)) {
            this.mTransform.set(matrix);
        }
        invalidateTransform();
    }

    public abstract void setContentHeight(int i);

    public abstract void setContentWidth(int i);

    public void setEditCompleted(boolean z) {
    }

    public void setMirror(boolean z) {
        this.isMirror = z;
    }

    public void setOnChangeListener(com.aliyun.svideo.editor.widget.BaseAliyunPasterView.OnChangeListener onChangeListener) {
        this.mListener = onChangeListener;
    }

    public void setShowTextLabel(boolean z) {
    }

    public void setViewport(int i, int i2) {
        this.mViewportWidth = i;
        this.mViewportHeight = i2;
    }

    public void validateTransform() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("before validateTransform : ");
        sb.append(this.mTransform.toString());
        sb.append("mode : ");
        sb.append(this.mTransformMode);
        if (getContentWidth() == 0 || getContentHeight() == 0) {
            return;
        }
        int i = this.mTransformMode;
        if (i == 1) {
            this.mTransform.preTranslate(0.5f, 0.5f);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("content_width : ");
            sb2.append(getContentWidth());
            sb2.append(" content_height : ");
            sb2.append(getContentHeight());
            this.mTransform.preScale(1.0f / getContentWidth(), 1.0f / getContentHeight());
            this.mTransform.postTranslate(-0.5f, -0.5f);
            this.mTransform.postScale(getWidth(), getHeight());
        } else {
            if (i == 2) {
                return;
            }
            if (i == 3) {
                this.mTransform.postScale(getWidth() / this.mViewportWidth, getHeight() / this.mViewportHeight);
            }
        }
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("after validateTransform : ");
        sb3.append(this.mTransform.toString());
        sb3.append("mode : ");
        sb3.append(this.mTransformMode);
        this.mTransformMode = 2;
    }
}

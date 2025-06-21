package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AliyunPasterCaptionBorderView extends com.aliyun.svideo.editor.widget.BaseAliyunPasterView {
    private boolean isFirstTouch;
    private float mCenterX;
    private float mCenterY;
    private int mContentHeight;
    private com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener mContentLayoutChange;
    private android.view.View mContentView;
    private int mContentWidth;
    private com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener mOnCaptionControllerChangeListener;
    private final android.view.View.OnTouchListener mRotationScaleBinding;
    private android.view.View.OnTouchListener onTouchListener;
    private float[] originalCenter;

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener
        public void onLayoutChanged(int i, int i2, int i3, int i4) {
            if (com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.mOnCaptionControllerChangeListener != null) {
                com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.mOnCaptionControllerChangeListener.onControllerChanged(com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.getRotation(), com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.getScale(), i, i2, i3, i4);
            }
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean val$captionSize;

        public AnonymousClass2(com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean alivcCaptionBorderBean) {
            this.val$captionSize = alivcCaptionBorderBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.reSizeBorder(this.val$captionSize);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener val$onCaptionControllerChangeListener;

        public AnonymousClass3(com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener onCaptionControllerChangeListener) {
            this.val$onCaptionControllerChangeListener = onCaptionControllerChangeListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.mOnCaptionControllerChangeListener = this.val$onCaptionControllerChangeListener;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean val$captionSize;

        public AnonymousClass4(com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean alivcCaptionBorderBean) {
            this.val$captionSize = alivcCaptionBorderBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.reSizeBorder(this.val$captionSize);
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnTouchListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0 && com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.isFirstTouch) {
                com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this;
                aliyunPasterCaptionBorderView.originalCenter = aliyunPasterCaptionBorderView.getCenter();
                com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.isFirstTouch = false;
            }
            return false;
        }
    }

    /* renamed from: com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnTouchListener {
        private float mLastX;
        private float mLastY;

        public AnonymousClass6() {
        }

        private void update(float f, float f2) {
            android.view.View contentView = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.getContentView();
            float left = contentView.getLeft() + (contentView.getWidth() / 2);
            float top = contentView.getTop() + (contentView.getHeight() / 2);
            float f3 = f - left;
            float f4 = f2 - top;
            float length = android.graphics.PointF.length(f3, f4) / java.lang.Math.max(android.graphics.PointF.length(this.mLastX - left, this.mLastY - top), android.graphics.PointF.length(contentView.getWidth() / 2, contentView.getHeight() / 2));
            float atan2 = (float) (java.lang.Math.atan2(f4, f3) - java.lang.Math.atan2(this.mLastY - top, this.mLastX - left));
            if (java.lang.Float.isInfinite(length) || java.lang.Float.isNaN(length) || java.lang.Float.isInfinite(atan2) || java.lang.Float.isNaN(atan2)) {
                return;
            }
            this.mLastX = f;
            this.mLastY = f2;
            com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.scaleContent(length, length);
            com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this;
            aliyunPasterCaptionBorderView.rotateContent(atan2, aliyunPasterCaptionBorderView.mCenterX, com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.mCenterY);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.isFirstTouch) {
                    com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this;
                    aliyunPasterCaptionBorderView.originalCenter = aliyunPasterCaptionBorderView.getCenter();
                    com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.isFirstTouch = false;
                }
                this.mLastX = view.getLeft() + motionEvent.getX();
                this.mLastY = view.getTop() + motionEvent.getY();
                float[] center = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this.getCenter();
                com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView2 = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this;
                aliyunPasterCaptionBorderView2.mCenterX = center[0] - aliyunPasterCaptionBorderView2.originalCenter[0];
                com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView aliyunPasterCaptionBorderView3 = com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.this;
                aliyunPasterCaptionBorderView3.mCenterY = center[1] - aliyunPasterCaptionBorderView3.originalCenter[1];
            } else if (actionMasked == 2) {
                update(view.getLeft() + motionEvent.getX(), view.getTop() + motionEvent.getY());
            }
            return true;
        }
    }

    public interface OnCaptionControllerChangeListener {
        void onControllerChanged(float f, float[] fArr, int i, int i2, int i3, int i4);
    }

    public AliyunPasterCaptionBorderView(android.content.Context context) {
        this(context, null);
    }

    public AliyunPasterCaptionBorderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AliyunPasterCaptionBorderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isFirstTouch = true;
        this.mContentLayoutChange = new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass1();
        this.onTouchListener = new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass5();
        this.mRotationScaleBinding = new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSizeBorder(com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean alivcCaptionBorderBean) {
        this.mMatrixUtil.clear();
        android.graphics.Matrix transform = getTransform();
        transform.reset();
        if (getCenter() != null) {
            this.originalCenter = getCenter();
            this.isFirstTouch = false;
        }
        android.graphics.RectF rectF = alivcCaptionBorderBean.rectF;
        int width = (int) (rectF.left + (rectF.width() / 2.0f));
        android.graphics.RectF rectF2 = alivcCaptionBorderBean.rectF;
        int height = (int) (rectF2.top + (rectF2.height() / 2.0f));
        int width2 = getWidth() / 2;
        int height2 = getHeight() / 2;
        setContentSize(alivcCaptionBorderBean.rectF);
        int i = width - width2;
        int i2 = height - height2;
        if (getWidth() != 0) {
            transform.postTranslate(i, i2);
        }
        float f = alivcCaptionBorderBean.scale;
        scaleContent(f, f);
        float f2 = alivcCaptionBorderBean.roation;
        float[] center = getCenter();
        if (center != null) {
            float f3 = center[0];
            float[] fArr = this.originalCenter;
            this.mCenterX = f3 - fArr[0];
            this.mCenterY = center[1] - fArr[1];
        }
        rotateContent(-f2, this.mCenterX, this.mCenterY);
        invalidateTransform();
        setVisibility(0);
        bringToFront();
        if (getWidth() == 0) {
            post(new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass4(alivcCaptionBorderBean));
        }
    }

    private void setContentSize(int i, int i2) {
        android.view.View view = this.mContentView;
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i2;
            this.mContentView.setLayoutParams(layoutParams);
        }
    }

    public void bind(com.aliyun.svideo.editor.bean.AlivcCaptionBorderBean alivcCaptionBorderBean, com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.OnCaptionControllerChangeListener onCaptionControllerChangeListener) {
        this.mOnCaptionControllerChangeListener = null;
        if (getWidth() == 0) {
            post(new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass2(alivcCaptionBorderBean));
        } else {
            reSizeBorder(alivcCaptionBorderBean);
        }
        post(new com.aliyun.svideo.editor.widget.AliyunPasterCaptionBorderView.AnonymousClass3(onCaptionControllerChangeListener));
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentHeight() {
        return this.mContentView.getMeasuredHeight();
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public android.view.View getContentView() {
        return this.mContentView;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentWidth() {
        return this.mContentView.getMeasuredWidth();
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public android.view.View getTextLabel() {
        return null;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mContentView = findViewById(android.R.id.content);
        android.view.View findViewById = findViewById(com.aliyun.svideo.editor.R.id.qupai_btn_edit_overlay_transform);
        if (findViewById != null) {
            findViewById.setOnTouchListener(this.mRotationScaleBinding);
        }
        setOnTouchListener(this.onTouchListener);
        setContentSize(this.mContentWidth, this.mContentHeight);
        android.view.View view = this.mContentView;
        if (view instanceof com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView) {
            ((com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView) view).setOnLayoutChangeListener(this.mContentLayoutChange);
        }
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mMatrixUtil.decomposeTSR(this.mTransform);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        validateTransform();
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        super.onMeasure(i, i2);
        measureChildren(i, i2);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setContentSize(android.graphics.RectF rectF) {
        if (rectF == null) {
            return;
        }
        this.mContentWidth = (int) rectF.width();
        int height = (int) rectF.height();
        this.mContentHeight = height;
        setContentSize(this.mContentWidth, height);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentWidth(int i) {
        this.mContentWidth = i;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setEditCompleted(boolean z) {
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setShowTextLabel(boolean z) {
    }
}

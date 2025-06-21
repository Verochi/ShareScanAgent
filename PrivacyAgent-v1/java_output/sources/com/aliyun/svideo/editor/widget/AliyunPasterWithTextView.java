package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AliyunPasterWithTextView extends com.aliyun.svideo.editor.widget.BaseAliyunPasterView {
    private boolean isCouldShowLabel;
    private boolean isEditCompleted;
    private int mContentHeight;
    private android.view.View mContentView;
    private int mContentWidth;
    private android.view.View mTextLabel;

    public AliyunPasterWithTextView(android.content.Context context) {
        this(context, null);
    }

    public AliyunPasterWithTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AliyunPasterWithTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentHeight() {
        return this.isEditCompleted ? this.mContentHeight : this.mContentView.getMeasuredHeight();
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public android.view.View getContentView() {
        return this.mContentView;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentWidth() {
        return this.isEditCompleted ? this.mContentWidth : this.mContentView.getMeasuredWidth();
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public android.view.View getTextLabel() {
        return this.mTextLabel;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public boolean isCouldShowLabel() {
        return this.isCouldShowLabel;
    }

    public boolean isEditCompleted() {
        return this.isEditCompleted;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mContentView = findViewById(android.R.id.content);
        this.mTextLabel = findViewById(com.aliyun.svideo.editor.R.id.qupai_bg_overlay_text_label);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTextLabel == null) {
            this.isCouldShowLabel = false;
            return;
        }
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        if (this.mMatrixUtil.getRotationDeg() != 0.0f) {
            this.mTextLabel.layout(0, 0, 0, 0);
            this.isCouldShowLabel = false;
        } else {
            this.isCouldShowLabel = true;
            float f = getCenter()[1];
            float contentHeight = (this.mMatrixUtil.scaleY * getContentHeight()) / 2.0f;
            this.mTextLabel.layout(0, (int) (f - contentHeight), getWidth(), (int) (f + contentHeight));
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        validateTransform();
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        if (!this.isEditCompleted) {
            super.onMeasure(i, i2);
            measureChildren(i, i2);
            return;
        }
        com.aliyun.svideo.editor.util.MatrixUtil matrixUtil = this.mMatrixUtil;
        int i3 = (int) (matrixUtil.scaleX * this.mContentWidth);
        int i4 = (int) (matrixUtil.scaleY * this.mContentHeight);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Measure width : ");
        sb.append(i3);
        sb.append("scaleX : ");
        sb.append(this.mMatrixUtil.scaleX);
        sb.append("mContentWidth : ");
        sb.append(this.mContentWidth);
        sb.append(" mContentHeight : ");
        sb.append(this.mContentHeight);
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        super.onMeasure(i, i2);
        measureChildren(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentWidth(int i) {
        this.mContentWidth = i;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setEditCompleted(boolean z) {
        int contentWidth = getContentWidth();
        int contentHeight = getContentHeight();
        this.isEditCompleted = z;
        if (contentWidth == 0 || contentHeight == 0) {
            return;
        }
        if (z) {
            requestLayout();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("EditCompleted : ");
        sb.append(z);
        sb.append("mContentWidth : ");
        sb.append(this.mContentWidth);
        sb.append(" mContentHeight : ");
        sb.append(this.mContentHeight);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setShowTextLabel(boolean z) {
        android.view.View view = this.mTextLabel;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}

package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AliyunPasterWithImageView extends com.aliyun.svideo.editor.widget.BaseAliyunPasterView {
    private int contentHeight;
    private int contentWidth;
    private android.view.View mContentView;

    public AliyunPasterWithImageView(android.content.Context context) {
        this(context, null);
    }

    public AliyunPasterWithImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AliyunPasterWithImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentHeight() {
        return this.contentHeight;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public android.view.View getContentView() {
        return this.mContentView;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public int getContentWidth() {
        return this.contentWidth;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mContentView = findViewById(android.R.id.content);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        validateTransform();
        this.mMatrixUtil.decomposeTSR(this.mTransform);
        com.aliyun.svideo.editor.util.MatrixUtil matrixUtil = this.mMatrixUtil;
        int i3 = (int) (matrixUtil.scaleX * this.contentWidth);
        int i4 = (int) (matrixUtil.scaleY * this.contentHeight);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Measure width : ");
        sb.append(i3);
        sb.append("scaleX :  screen width : ");
        sb.append(getWidth());
        sb.append(" 1/8 width : ");
        sb.append(getWidth() / 8);
        int makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        super.onMeasure(i, i2);
        measureChildren(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentHeight(int i) {
        this.contentHeight = i;
    }

    @Override // com.aliyun.svideo.editor.widget.BaseAliyunPasterView
    public void setContentWidth(int i) {
        this.contentWidth = i;
    }
}

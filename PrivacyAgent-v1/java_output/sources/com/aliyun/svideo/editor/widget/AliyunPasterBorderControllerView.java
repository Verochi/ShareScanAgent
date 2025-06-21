package com.aliyun.svideo.editor.widget;

/* loaded from: classes12.dex */
public class AliyunPasterBorderControllerView extends android.view.View {
    private com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener mOnLayoutChangeListener;

    public interface OnLayoutChangeListener {
        void onLayoutChanged(int i, int i2, int i3, int i4);
    }

    public AliyunPasterBorderControllerView(android.content.Context context) {
        super(context);
    }

    public AliyunPasterBorderControllerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AliyunPasterBorderControllerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener onLayoutChangeListener = this.mOnLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            onLayoutChangeListener.onLayoutChanged(i, i2, i3, i4);
        }
    }

    public void setOnLayoutChangeListener(com.aliyun.svideo.editor.widget.AliyunPasterBorderControllerView.OnLayoutChangeListener onLayoutChangeListener) {
        this.mOnLayoutChangeListener = onLayoutChangeListener;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        super.setRotation(f);
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
    }
}

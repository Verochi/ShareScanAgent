package com.aliyun.player.videoview;

/* loaded from: classes.dex */
public class AliDisplayView extends android.widget.FrameLayout {
    private static final java.lang.String TAG = "AliDisplayView";
    private com.aliyun.player.nativeclass.DisplayViewHelper mDisplayViewHelper;
    private com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener mOutOnViewStatusListener;
    private com.aliyun.player.videoview.AliDisplayView.DisplayViewType mPreferDisplayViewType;

    public enum DisplayViewType {
        Either,
        SurfaceView,
        TextureView
    }

    public interface OnViewStatusListener {
        void onSurfaceCreated();

        void onSurfaceDestroy();

        void onSurfaceSizeChanged();

        void onViewCreated(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType);
    }

    public AliDisplayView(android.content.Context context) {
        super(context);
        this.mDisplayViewHelper = null;
        this.mPreferDisplayViewType = null;
        this.mOutOnViewStatusListener = null;
        init();
    }

    public AliDisplayView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDisplayViewHelper = null;
        this.mPreferDisplayViewType = null;
        this.mOutOnViewStatusListener = null;
        init();
    }

    public AliDisplayView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDisplayViewHelper = null;
        this.mPreferDisplayViewType = null;
        this.mOutOnViewStatusListener = null;
        init();
    }

    private void init() {
        this.mDisplayViewHelper = new com.aliyun.player.nativeclass.DisplayViewHelper(this);
    }

    public com.aliyun.player.nativeclass.DisplayViewHelper getDisplayViewHelper() {
        return this.mDisplayViewHelper;
    }

    public com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener getOnViewStatusListener() {
        return this.mOutOnViewStatusListener;
    }

    public com.aliyun.player.videoview.AliDisplayView.DisplayViewType getPreferDisplayViewType() {
        return this.mPreferDisplayViewType;
    }

    public void setOnViewStatusListener(com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener) {
        this.mOutOnViewStatusListener = onViewStatusListener;
    }

    public void setPreferDisplayView(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType) {
        this.mPreferDisplayViewType = displayViewType;
    }

    public void setSurfaceReuse(boolean z) {
        this.mDisplayViewHelper.setSurfaceReuse(z);
    }
}

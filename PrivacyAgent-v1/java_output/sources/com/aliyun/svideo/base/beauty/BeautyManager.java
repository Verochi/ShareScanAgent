package com.aliyun.svideo.base.beauty;

/* loaded from: classes.dex */
public class BeautyManager implements com.aliyun.svideo.base.beauty.api.BeautyInterface, com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener {
    private com.aliyun.svideo.base.beauty.ui.BeautySettingChooser mBeautySettingChooser;
    private int mCurrentLevel = 60;
    private com.aliyun.svideo.base.beauty.api.OnBeautyLayoutChangeListener mOnBeautyLayoutChangeListener;
    private com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener mOnDefaultBeautyLevelChangeListener;

    /* renamed from: com.aliyun.svideo.base.beauty.BeautyManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.svideo.base.BaseChooser.DialogVisibleListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.svideo.base.BaseChooser.DialogVisibleListener
        public void onDialogDismiss() {
            if (com.aliyun.svideo.base.beauty.BeautyManager.this.mOnBeautyLayoutChangeListener != null) {
                com.aliyun.svideo.base.beauty.BeautyManager.this.mOnBeautyLayoutChangeListener.onLayoutChange(8);
            }
        }

        @Override // com.aliyun.svideo.base.BaseChooser.DialogVisibleListener
        public void onDialogShow() {
            if (com.aliyun.svideo.base.beauty.BeautyManager.this.mOnBeautyLayoutChangeListener != null) {
                com.aliyun.svideo.base.beauty.BeautyManager.this.mOnBeautyLayoutChangeListener.onLayoutChange(0);
            }
        }
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void addDefaultBeautyLevelChangeListener(com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener onDefaultBeautyLevelChangeListener) {
        this.mOnDefaultBeautyLevelChangeListener = onDefaultBeautyLevelChangeListener;
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public com.aliyun.svideo.base.beauty.api.constant.BeautySDKType getSdkType() {
        return com.aliyun.svideo.base.beauty.api.constant.BeautySDKType.DEFAULT;
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public java.lang.String getVersion() {
        return null;
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void init(android.content.Context context, com.aliyun.svideo.base.beauty.api.IAliyunBeautyInitCallback iAliyunBeautyInitCallback) {
        if (iAliyunBeautyInitCallback != null) {
            iAliyunBeautyInitCallback.onInit(0);
        }
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void initParams() {
    }

    @Override // com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener
    public void onDefaultBeautyLevelChange(int i) {
        this.mCurrentLevel = i;
        com.aliyun.svideo.base.beauty.api.OnDefaultBeautyLevelChangeListener onDefaultBeautyLevelChangeListener = this.mOnDefaultBeautyLevelChangeListener;
        if (onDefaultBeautyLevelChangeListener != null) {
            onDefaultBeautyLevelChangeListener.onDefaultBeautyLevelChange(i);
        }
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void onFrameBack(byte[] bArr, int i, int i2, android.hardware.Camera.CameraInfo cameraInfo) {
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public int onTextureIdBack(int i, int i2, int i3, float[] fArr, int i4) {
        return i;
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void release() {
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void setDebug(boolean z) {
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void setDeviceOrientation(int i, int i2) {
    }

    @Override // com.aliyun.svideo.base.beauty.api.BeautyInterface
    public void showControllerView(androidx.fragment.app.FragmentManager fragmentManager, com.aliyun.svideo.base.beauty.api.OnBeautyLayoutChangeListener onBeautyLayoutChangeListener) {
        if (this.mBeautySettingChooser == null) {
            this.mBeautySettingChooser = new com.aliyun.svideo.base.beauty.ui.BeautySettingChooser();
        }
        this.mOnBeautyLayoutChangeListener = onBeautyLayoutChangeListener;
        this.mBeautySettingChooser.setOnDefaultBeautyLevelChangeListener(this);
        this.mBeautySettingChooser.setDismissListener(new com.aliyun.svideo.base.beauty.BeautyManager.AnonymousClass1());
        this.mBeautySettingChooser.show(fragmentManager, "beauty", this.mCurrentLevel);
    }
}

package com.aliyun.svideosdk.common.callback.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface OnChoosePictureSizeCallback {
    android.hardware.Camera.Size onChoosePictureSize(java.util.List<android.hardware.Camera.Size> list);

    com.aliyun.common.utils.Size onChoosePictureSize(java.util.SortedSet<com.aliyun.common.utils.Size> sortedSet);
}

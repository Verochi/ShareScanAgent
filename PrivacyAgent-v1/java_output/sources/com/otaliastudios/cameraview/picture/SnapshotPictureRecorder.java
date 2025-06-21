package com.otaliastudios.cameraview.picture;

/* loaded from: classes19.dex */
public abstract class SnapshotPictureRecorder extends com.otaliastudios.cameraview.picture.PictureRecorder {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.picture.SnapshotPictureRecorder.class.getSimpleName());

    public SnapshotPictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener pictureResultListener) {
        super(stub, pictureResultListener);
    }
}

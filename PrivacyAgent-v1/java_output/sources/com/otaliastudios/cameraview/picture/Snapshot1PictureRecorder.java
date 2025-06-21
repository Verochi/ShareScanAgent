package com.otaliastudios.cameraview.picture;

/* loaded from: classes19.dex */
public class Snapshot1PictureRecorder extends com.otaliastudios.cameraview.picture.SnapshotPictureRecorder {
    public com.otaliastudios.cameraview.engine.Camera1Engine u;
    public android.hardware.Camera v;
    public com.otaliastudios.cameraview.size.AspectRatio w;
    public int x;

    /* renamed from: com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.hardware.Camera.PreviewCallback {

        /* renamed from: com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC04301 implements java.lang.Runnable {
            public final /* synthetic */ byte[] n;
            public final /* synthetic */ com.otaliastudios.cameraview.size.Size t;
            public final /* synthetic */ int u;
            public final /* synthetic */ com.otaliastudios.cameraview.size.Size v;

            public RunnableC04301(byte[] bArr, com.otaliastudios.cameraview.size.Size size, int i, com.otaliastudios.cameraview.size.Size size2) {
                this.n = bArr;
                this.t = size;
                this.u = i;
                this.v = size2;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.graphics.YuvImage yuvImage = new android.graphics.YuvImage(com.otaliastudios.cameraview.internal.RotationHelper.rotate(this.n, this.t, this.u), com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.x, this.v.getWidth(), this.v.getHeight(), null);
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                android.graphics.Rect computeCrop = com.otaliastudios.cameraview.internal.CropHelper.computeCrop(this.v, com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.w);
                yuvImage.compressToJpeg(computeCrop, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                com.otaliastudios.cameraview.PictureResult.Stub stub = com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.n;
                stub.data = byteArray;
                stub.size = new com.otaliastudios.cameraview.size.Size(computeCrop.width(), computeCrop.height());
                com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder snapshot1PictureRecorder = com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this;
                snapshot1PictureRecorder.n.rotation = 0;
                snapshot1PictureRecorder.dispatchResult();
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@androidx.annotation.NonNull byte[] bArr, android.hardware.Camera camera) {
            com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.dispatchOnShutter(false);
            com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder snapshot1PictureRecorder = com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this;
            com.otaliastudios.cameraview.PictureResult.Stub stub = snapshot1PictureRecorder.n;
            int i = stub.rotation;
            com.otaliastudios.cameraview.size.Size size = stub.size;
            com.otaliastudios.cameraview.size.Size previewStreamSize = snapshot1PictureRecorder.u.getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR);
            if (previewStreamSize == null) {
                throw new java.lang.IllegalStateException("Preview stream size should never be null here.");
            }
            com.otaliastudios.cameraview.internal.WorkerHandler.execute(new com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.AnonymousClass1.RunnableC04301(bArr, previewStreamSize, i, size));
            camera.setPreviewCallbackWithBuffer(null);
            camera.setPreviewCallbackWithBuffer(com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.u);
            com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.u.getFrameManager().setUp(com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.x, previewStreamSize, com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.this.u.getAngles());
        }
    }

    public Snapshot1PictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera1Engine camera1Engine, @androidx.annotation.NonNull android.hardware.Camera camera, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio) {
        super(stub, camera1Engine);
        this.u = camera1Engine;
        this.v = camera;
        this.w = aspectRatio;
        this.x = camera.getParameters().getPreviewFormat();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0;
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        this.v.setOneShotPreviewCallback(new com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.AnonymousClass1());
    }
}

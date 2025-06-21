package com.otaliastudios.cameraview.picture;

/* loaded from: classes19.dex */
public class Full1PictureRecorder extends com.otaliastudios.cameraview.picture.FullPictureRecorder {
    public final android.hardware.Camera u;
    public final com.otaliastudios.cameraview.engine.Camera1Engine v;

    /* renamed from: com.otaliastudios.cameraview.picture.Full1PictureRecorder$1, reason: invalid class name */
    public class AnonymousClass1 implements android.hardware.Camera.ShutterCallback {
        public AnonymousClass1() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG.i("take(): got onShutter callback.");
            com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.dispatchOnShutter(true);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.picture.Full1PictureRecorder$2, reason: invalid class name */
    public class AnonymousClass2 implements android.hardware.Camera.PictureCallback {
        public AnonymousClass2() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, android.hardware.Camera camera) {
            int i;
            com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG.i("take(): got picture callback.");
            try {
                i = com.otaliastudios.cameraview.internal.ExifHelper.getOrientation(new androidx.exifinterface.media.ExifInterface(new java.io.ByteArrayInputStream(bArr)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
            } catch (java.io.IOException unused) {
                i = 0;
            }
            com.otaliastudios.cameraview.PictureResult.Stub stub = com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.n;
            stub.data = bArr;
            stub.rotation = i;
            com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG.i("take(): starting preview again. ", java.lang.Thread.currentThread());
            if (com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v.getState().isAtLeast(com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v);
                com.otaliastudios.cameraview.size.Size previewStreamSize = com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v.getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR);
                if (previewStreamSize == null) {
                    throw new java.lang.IllegalStateException("Preview stream size should never be null here.");
                }
                com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v.getFrameManager().setUp(com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v.getFrameProcessingFormat(), previewStreamSize, com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.v.getAngles());
                camera.startPreview();
            }
            com.otaliastudios.cameraview.picture.Full1PictureRecorder.this.dispatchResult();
        }
    }

    public Full1PictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera1Engine camera1Engine, @androidx.annotation.NonNull android.hardware.Camera camera) {
        super(stub, camera1Engine);
        this.v = camera1Engine;
        this.u = camera;
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.n.rotation);
        camera.setParameters(parameters);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void dispatchResult() {
        com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG.i("dispatching result. Thread:", java.lang.Thread.currentThread());
        super.dispatchResult();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG;
        cameraLogger.i("take() called.");
        this.u.setPreviewCallbackWithBuffer(null);
        this.v.getFrameManager().release();
        this.u.takePicture(new com.otaliastudios.cameraview.picture.Full1PictureRecorder.AnonymousClass1(), null, null, new com.otaliastudios.cameraview.picture.Full1PictureRecorder.AnonymousClass2());
        cameraLogger.i("take() returned.");
    }
}

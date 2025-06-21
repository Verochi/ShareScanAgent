package com.otaliastudios.cameraview.picture;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Full2PictureRecorder extends com.otaliastudios.cameraview.picture.FullPictureRecorder implements android.media.ImageReader.OnImageAvailableListener {
    public final com.otaliastudios.cameraview.engine.action.ActionHolder u;
    public final com.otaliastudios.cameraview.engine.action.Action v;
    public final android.media.ImageReader w;
    public final android.hardware.camera2.CaptureRequest.Builder x;
    public android.hardware.camera2.DngCreator y;

    /* renamed from: com.otaliastudios.cameraview.picture.Full2PictureRecorder$1, reason: invalid class name */
    public class AnonymousClass1 extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            com.otaliastudios.cameraview.picture.Full2PictureRecorder full2PictureRecorder = com.otaliastudios.cameraview.picture.Full2PictureRecorder.this;
            if (full2PictureRecorder.n.format == com.otaliastudios.cameraview.controls.PictureFormat.DNG) {
                full2PictureRecorder.y = new android.hardware.camera2.DngCreator(actionHolder.getCharacteristics(this), totalCaptureResult);
                com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.y.setOrientation(com.otaliastudios.cameraview.internal.ExifHelper.getExifOrientation(com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.n.rotation));
                com.otaliastudios.cameraview.picture.Full2PictureRecorder full2PictureRecorder2 = com.otaliastudios.cameraview.picture.Full2PictureRecorder.this;
                if (full2PictureRecorder2.n.location != null) {
                    full2PictureRecorder2.y.setLocation(com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.n.location);
                }
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureStarted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest) {
            super.onCaptureStarted(actionHolder, captureRequest);
            if (captureRequest.getTag() == 2) {
                com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG.i("onCaptureStarted:", "Dispatching picture shutter.");
                com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.dispatchOnShutter(false);
                setState(Integer.MAX_VALUE);
            }
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
            super.onStart(actionHolder);
            com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.x.addTarget(com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.w.getSurface());
            com.otaliastudios.cameraview.picture.Full2PictureRecorder full2PictureRecorder = com.otaliastudios.cameraview.picture.Full2PictureRecorder.this;
            if (full2PictureRecorder.n.format == com.otaliastudios.cameraview.controls.PictureFormat.JPEG) {
                full2PictureRecorder.x.set(android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION, java.lang.Integer.valueOf(com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.n.rotation));
            }
            com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.x.setTag(2);
            try {
                actionHolder.applyBuilder(this, com.otaliastudios.cameraview.picture.Full2PictureRecorder.this.x);
            } catch (android.hardware.camera2.CameraAccessException e) {
                com.otaliastudios.cameraview.picture.Full2PictureRecorder full2PictureRecorder2 = com.otaliastudios.cameraview.picture.Full2PictureRecorder.this;
                full2PictureRecorder2.n = null;
                full2PictureRecorder2.mError = e;
                full2PictureRecorder2.dispatchResult();
                setState(Integer.MAX_VALUE);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.picture.Full2PictureRecorder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.controls.PictureFormat.values().length];
            a = iArr;
            try {
                iArr[com.otaliastudios.cameraview.controls.PictureFormat.JPEG.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.PictureFormat.DNG.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public Full2PictureRecorder(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.NonNull android.media.ImageReader imageReader) {
        super(stub, camera2Engine);
        this.u = camera2Engine;
        this.x = builder;
        this.w = imageReader;
        imageReader.setOnImageAvailableListener(this, com.otaliastudios.cameraview.internal.WorkerHandler.get().getHandler());
        this.v = new com.otaliastudios.cameraview.picture.Full2PictureRecorder.AnonymousClass1();
    }

    public final void e(@androidx.annotation.NonNull android.media.Image image) {
        java.nio.ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        com.otaliastudios.cameraview.PictureResult.Stub stub = this.n;
        stub.data = bArr;
        stub.rotation = 0;
        try {
            int attributeInt = new androidx.exifinterface.media.ExifInterface(new java.io.ByteArrayInputStream(this.n.data)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            this.n.rotation = com.otaliastudios.cameraview.internal.ExifHelper.getOrientation(attributeInt);
        } catch (java.io.IOException unused) {
        }
    }

    public final void f(@androidx.annotation.NonNull android.media.Image image) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(byteArrayOutputStream);
        try {
            this.y.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.n.data = byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException e) {
            this.y.close();
            try {
                bufferedOutputStream.close();
            } catch (java.io.IOException unused) {
            }
            throw new java.lang.RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    @Override // android.media.ImageReader.OnImageAvailableListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onImageAvailable(android.media.ImageReader imageReader) {
        android.media.Image image;
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.picture.FullPictureRecorder.LOG;
        cameraLogger.i("onImageAvailable started.");
        android.media.Image image2 = 0;
        try {
            try {
                image = imageReader.acquireNextImage();
                try {
                    int i = com.otaliastudios.cameraview.picture.Full2PictureRecorder.AnonymousClass2.a[this.n.format.ordinal()];
                    if (i == 1) {
                        e(image);
                    } else {
                        if (i != 2) {
                            throw new java.lang.IllegalStateException("Unknown format: " + this.n.format);
                        }
                        f(image);
                    }
                    if (image != null) {
                        image.close();
                    }
                    cameraLogger.i("onImageAvailable ended.");
                    dispatchResult();
                } catch (java.lang.Exception e) {
                    e = e;
                    this.n = null;
                    this.mError = e;
                    dispatchResult();
                    if (image != null) {
                        image.close();
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                image2 = imageReader;
                if (image2 != 0) {
                    image2.close();
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            image = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (image2 != 0) {
            }
            throw th;
        }
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public void take() {
        this.v.start(this.u);
    }
}

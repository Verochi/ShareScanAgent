package com.alivc.component.encoder;

@android.annotation.TargetApi(19)
/* loaded from: classes.dex */
public class SurfaceReader {
    private static final java.lang.String TAG = "SurfaceReader";
    private android.os.Handler mBackgroundHandler;
    private android.os.HandlerThread mBackgroundThread;
    private android.media.ImageReader.OnImageAvailableListener mOnImageAvailableListener;
    private android.media.ImageReader mReader;
    private long mBufferCallback = 0;
    private long timeStamp = 0;

    /* renamed from: com.alivc.component.encoder.SurfaceReader$1, reason: invalid class name */
    public class AnonymousClass1 implements android.media.ImageReader.OnImageAvailableListener {
        public AnonymousClass1() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(android.media.ImageReader imageReader) {
            android.media.Image acquireNextImage = imageReader.acquireNextImage();
            if (acquireNextImage == null) {
                return;
            }
            if (acquireNextImage.getFormat() == 1) {
                com.alivc.component.encoder.SurfaceReader surfaceReader = com.alivc.component.encoder.SurfaceReader.this;
                surfaceReader.nativeWriteRGBABuffer(surfaceReader.mBufferCallback, acquireNextImage.getPlanes()[0].getRowStride(), acquireNextImage.getWidth(), acquireNextImage.getHeight(), com.alivc.component.encoder.SurfaceReader.this.timeStamp, acquireNextImage.getPlanes()[0].getBuffer());
                com.alivc.component.encoder.SurfaceReader.this.timeStamp += 40000;
            } else {
                int length = acquireNextImage.getPlanes().length;
                java.nio.ByteBuffer[] byteBufferArr = new java.nio.ByteBuffer[length];
                for (int i = 0; i < length; i++) {
                    byteBufferArr[i] = acquireNextImage.getPlanes()[i].getBuffer();
                }
                com.alivc.component.encoder.SurfaceReader surfaceReader2 = com.alivc.component.encoder.SurfaceReader.this;
                surfaceReader2.nativeWriteYUV420Buffer(surfaceReader2.mBufferCallback, acquireNextImage.getWidth(), acquireNextImage.getHeight(), com.alivc.component.encoder.SurfaceReader.this.timeStamp, byteBufferArr);
                com.alivc.component.encoder.SurfaceReader.this.timeStamp += 40000;
            }
            acquireNextImage.close();
        }
    }

    public SurfaceReader(int i, int i2, int i3, int i4) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(TAG);
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new android.os.Handler(this.mBackgroundThread.getLooper());
        this.mReader = android.media.ImageReader.newInstance(i, i2, i3, i4);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ImageReader format ");
        sb.append(this.mReader.getImageFormat());
        sb.append("maximage");
        sb.append(this.mReader.getMaxImages());
        com.alivc.component.encoder.SurfaceReader.AnonymousClass1 anonymousClass1 = new com.alivc.component.encoder.SurfaceReader.AnonymousClass1();
        this.mOnImageAvailableListener = anonymousClass1;
        this.mReader.setOnImageAvailableListener(anonymousClass1, this.mBackgroundHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeWriteRGBABuffer(long j, int i, int i2, int i3, long j2, java.nio.ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeWriteYUV420Buffer(long j, int i, int i2, long j2, java.nio.ByteBuffer[] byteBufferArr);

    @com.alivc.component.encoder.NativeUsed
    public android.view.Surface getSurface() {
        android.media.ImageReader imageReader = this.mReader;
        if (imageReader != null) {
            return imageReader.getSurface();
        }
        return null;
    }

    @com.alivc.component.encoder.NativeUsed
    public void release() {
        android.media.ImageReader imageReader = this.mReader;
        if (imageReader != null) {
            android.media.Image acquireLatestImage = imageReader.acquireLatestImage();
            if (acquireLatestImage != null) {
                acquireLatestImage.close();
            }
            this.mReader.close();
        }
        this.mReader = null;
        this.mOnImageAvailableListener = null;
        this.mBackgroundThread.quitSafely();
        try {
            this.mBackgroundThread.join();
            this.mBackgroundThread = null;
            this.mBackgroundHandler = null;
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    @com.alivc.component.encoder.NativeUsed
    public void setBufferCallback(long j) {
        this.mBufferCallback = j;
    }
}

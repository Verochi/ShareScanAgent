package com.cicada.player.utils;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes31.dex */
public class DecoderSurfaceTexture implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
    private static final int CREATE_SURFACE_MSG = 12345;
    private int mTextureId = 0;
    private long mDecoderHandler = 0;
    private android.graphics.SurfaceTexture mSurfaceTexture = null;
    private android.view.Surface mSurface = null;
    private android.os.HandlerThread mHandleThread = new android.os.HandlerThread("DecoderSurfaceTexture");
    private android.os.Handler mHandler = null;
    private java.util.concurrent.CountDownLatch mCountDown = new java.util.concurrent.CountDownLatch(1);

    /* renamed from: com.cicada.player.utils.DecoderSurfaceTexture$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != com.cicada.player.utils.DecoderSurfaceTexture.CREATE_SURFACE_MSG) {
                super.handleMessage(message);
                return;
            }
            com.cicada.player.utils.DecoderSurfaceTexture.this.mSurfaceTexture = new android.graphics.SurfaceTexture(com.cicada.player.utils.DecoderSurfaceTexture.this.mTextureId);
            com.cicada.player.utils.DecoderSurfaceTexture.this.mSurfaceTexture.setOnFrameAvailableListener((com.cicada.player.utils.DecoderSurfaceTexture) message.obj);
            com.cicada.player.utils.DecoderSurfaceTexture.this.mSurface = new android.view.Surface(com.cicada.player.utils.DecoderSurfaceTexture.this.mSurfaceTexture);
            com.cicada.player.utils.DecoderSurfaceTexture.this.mCountDown.countDown();
        }
    }

    public DecoderSurfaceTexture() {
        this.mHandleThread.start();
    }

    private native void onFrameAvailable(long j);

    @com.cicada.player.utils.NativeUsed
    public android.view.Surface createSurface(int i, long j) {
        if (i <= 0) {
            return null;
        }
        this.mTextureId = i;
        this.mDecoderHandler = j;
        try {
            this.mHandler = new com.cicada.player.utils.DecoderSurfaceTexture.AnonymousClass1(this.mHandleThread.getLooper());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        android.os.Message message = new android.os.Message();
        message.what = CREATE_SURFACE_MSG;
        message.obj = this;
        this.mHandler.sendMessage(message);
        try {
            this.mCountDown.await();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return this.mSurface;
    }

    @com.cicada.player.utils.NativeUsed
    public void dispose() {
        this.mSurface.release();
        this.mHandleThread.quit();
    }

    @com.cicada.player.utils.NativeUsed
    public void getTransformMatrix(float[] fArr) {
        android.graphics.SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return;
        }
        surfaceTexture.getTransformMatrix(fArr);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
        onFrameAvailable(this.mDecoderHandler);
    }

    @com.cicada.player.utils.NativeUsed
    public void updateTexImage() {
        this.mSurfaceTexture.updateTexImage();
    }
}

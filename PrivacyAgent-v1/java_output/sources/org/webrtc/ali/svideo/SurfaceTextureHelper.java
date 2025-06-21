package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
public class SurfaceTextureHelper {
    private static final java.lang.String TAG = "SurfaceTextureHelper";
    private static java.util.concurrent.locks.ReentrantLock updateTexLock = new java.util.concurrent.locks.ReentrantLock();
    private final org.webrtc.ali.svideo.EglBase eglBase;
    private final android.os.Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private org.webrtc.ali.svideo.SurfaceTextureHelper.OnTextureFrameAvailableListener listener;
    public volatile int mTextureType;
    private final int oesTextureId;
    private org.webrtc.ali.svideo.SurfaceTextureHelper.OnTextureFrameAvailableListener pendingListener;
    final java.lang.Runnable setListenerRunnable;
    private final android.graphics.SurfaceTexture surfaceTexture;
    private org.webrtc.ali.svideo.YuvConverter yuvConverter;

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.Callable<org.webrtc.ali.svideo.SurfaceTextureHelper> {
        final /* synthetic */ android.os.Handler val$handler;
        final /* synthetic */ org.webrtc.ali.svideo.EglBase.Context val$sharedContext;
        final /* synthetic */ java.lang.String val$threadName;

        public AnonymousClass1(org.webrtc.ali.svideo.EglBase.Context context, android.os.Handler handler, java.lang.String str) {
            this.val$sharedContext = context;
            this.val$handler = handler;
            this.val$threadName = str;
        }

        @Override // java.util.concurrent.Callable
        public org.webrtc.ali.svideo.SurfaceTextureHelper call() {
            try {
                return new org.webrtc.ali.svideo.SurfaceTextureHelper(this.val$sharedContext, this.val$handler, null);
            } catch (java.lang.RuntimeException e) {
                org.webrtc.svideo.utils.AlivcLog.b(org.webrtc.ali.svideo.SurfaceTextureHelper.TAG, this.val$threadName + " create failure:" + e.getMessage());
                return null;
            }
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            org.webrtc.svideo.utils.AlivcLog.a(org.webrtc.ali.svideo.SurfaceTextureHelper.TAG, "Setting listener to " + org.webrtc.ali.svideo.SurfaceTextureHelper.this.pendingListener);
            org.webrtc.ali.svideo.SurfaceTextureHelper surfaceTextureHelper = org.webrtc.ali.svideo.SurfaceTextureHelper.this;
            surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.pendingListener = null;
            if (org.webrtc.ali.svideo.SurfaceTextureHelper.this.hasPendingTexture) {
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.updateTexImage();
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.hasPendingTexture = false;
            }
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$3, reason: invalid class name */
    public class AnonymousClass3 implements android.graphics.SurfaceTexture.OnFrameAvailableListener {
        public AnonymousClass3() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(android.graphics.SurfaceTexture surfaceTexture) {
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.hasPendingTexture = true;
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.tryDeliverTextureFrame();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.listener = null;
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.pendingListener = null;
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.isTextureInUse = false;
            if (org.webrtc.ali.svideo.SurfaceTextureHelper.this.isQuitting) {
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.release();
            } else {
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.tryDeliverTextureFrame();
            }
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.isQuitting = true;
            if (org.webrtc.ali.svideo.SurfaceTextureHelper.this.isTextureInUse) {
                return;
            }
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.release();
        }
    }

    /* renamed from: org.webrtc.ali.svideo.SurfaceTextureHelper$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.nio.ByteBuffer val$buf;
        final /* synthetic */ int val$height;
        final /* synthetic */ int val$stride;
        final /* synthetic */ int val$textureId;
        final /* synthetic */ int val$textureType;
        final /* synthetic */ float[] val$transformMatrix;
        final /* synthetic */ int val$width;

        public AnonymousClass7(int i, java.nio.ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, float[] fArr) {
            this.val$textureType = i;
            this.val$buf = byteBuffer;
            this.val$width = i2;
            this.val$height = i3;
            this.val$stride = i4;
            this.val$textureId = i5;
            this.val$transformMatrix = fArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$textureType != org.webrtc.ali.svideo.SurfaceTextureHelper.this.mTextureType) {
                if (org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter != null) {
                    org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter.release();
                    org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter = null;
                }
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.mTextureType = this.val$textureType;
            }
            if (org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter == null) {
                org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter = new org.webrtc.ali.svideo.YuvConverter(this.val$textureType);
            }
            org.webrtc.ali.svideo.SurfaceTextureHelper.updateTexLock.lock();
            org.webrtc.ali.svideo.SurfaceTextureHelper.this.yuvConverter.convert(this.val$buf, this.val$width, this.val$height, this.val$stride, this.val$textureId, this.val$textureType, this.val$transformMatrix);
            org.webrtc.ali.svideo.SurfaceTextureHelper.updateTexLock.unlock();
        }
    }

    public interface OnTextureFrameAvailableListener {
        void onTextureFrameAvailable(int i, float[] fArr, long j);
    }

    private SurfaceTextureHelper(org.webrtc.ali.svideo.EglBase.Context context, android.os.Handler handler) {
        this.hasPendingTexture = false;
        this.isTextureInUse = false;
        this.isQuitting = false;
        this.setListenerRunnable = new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass2();
        this.mTextureType = 0;
        if (handler.getLooper().getThread() != java.lang.Thread.currentThread()) {
            throw new java.lang.IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        org.webrtc.ali.svideo.EglBase create = org.webrtc.ali.svideo.EglBase.create(context, org.webrtc.ali.svideo.EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = create;
        try {
            create.createDummyPbufferSurface();
            create.makeCurrent();
            int generateTexture = org.webrtc.ali.svideo.GlUtil.generateTexture(36197);
            this.oesTextureId = generateTexture;
            android.graphics.SurfaceTexture surfaceTexture = new android.graphics.SurfaceTexture(generateTexture);
            this.surfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass3());
        } catch (java.lang.RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    public /* synthetic */ SurfaceTextureHelper(org.webrtc.ali.svideo.EglBase.Context context, android.os.Handler handler, org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass1 anonymousClass1) {
        this(context, handler);
    }

    public static org.webrtc.ali.svideo.SurfaceTextureHelper create(java.lang.String str, org.webrtc.ali.svideo.EglBase.Context context) {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(str);
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        return (org.webrtc.ali.svideo.SurfaceTextureHelper) org.webrtc.ali.svideo.ThreadUtils.invokeAtFrontUninterruptibly(handler, new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass1(context, handler, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.handler.getLooper().getThread() != java.lang.Thread.currentThread()) {
            throw new java.lang.IllegalStateException("Wrong thread.");
        }
        if (this.isTextureInUse || !this.isQuitting) {
            throw new java.lang.IllegalStateException("Unexpected release.");
        }
        org.webrtc.ali.svideo.YuvConverter yuvConverter = this.yuvConverter;
        if (yuvConverter != null) {
            yuvConverter.release();
        }
        android.opengl.GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != java.lang.Thread.currentThread()) {
            throw new java.lang.IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
            return;
        }
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        this.listener.onTextureFrameAvailable(this.oesTextureId, fArr, this.surfaceTexture.getTimestamp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        updateTexLock.lock();
        synchronized (org.webrtc.ali.svideo.EglBase.lock) {
            this.surfaceTexture.updateTexImage();
        }
        updateTexLock.unlock();
    }

    public void dispose() {
        org.webrtc.svideo.utils.AlivcLog.a(TAG, "dispose()");
        org.webrtc.ali.svideo.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass6());
    }

    public android.os.Handler getHandler() {
        return this.handler;
    }

    public android.graphics.SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void lockBeforeUseTexture() {
        updateTexLock.lock();
    }

    public void returnTextureFrame() {
        this.handler.post(new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass5());
    }

    public void startListening(org.webrtc.ali.svideo.SurfaceTextureHelper.OnTextureFrameAvailableListener onTextureFrameAvailableListener) {
        if (this.listener != null || this.pendingListener != null) {
            throw new java.lang.IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = onTextureFrameAvailableListener;
        this.handler.post(this.setListenerRunnable);
    }

    public void stopListening() {
        org.webrtc.svideo.utils.AlivcLog.a(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        org.webrtc.ali.svideo.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass4());
    }

    public void textureToYUV(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5, float[] fArr) {
        org.webrtc.ali.svideo.ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new org.webrtc.ali.svideo.SurfaceTextureHelper.AnonymousClass7(i5, byteBuffer, i, i2, i3, i4, fArr));
    }

    public void unlockAfterUseTexture() {
        updateTexLock.unlock();
    }
}

package com.otaliastudios.cameraview.engine;

/* loaded from: classes19.dex */
public abstract class CameraEngine implements com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback, com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener {
    protected static final com.otaliastudios.cameraview.CameraLogger LOG = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.engine.CameraEngine.class.getSimpleName());
    protected static final java.lang.String TAG = "CameraEngine";
    public com.otaliastudios.cameraview.internal.WorkerHandler n;
    public final com.otaliastudios.cameraview.engine.CameraEngine.Callback u;
    public final com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator v = new com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator(new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass1());

    @androidx.annotation.VisibleForTesting
    public android.os.Handler t = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$1, reason: invalid class name */
    public class AnonymousClass1 implements com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback {
        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        @androidx.annotation.NonNull
        public com.otaliastudios.cameraview.internal.WorkerHandler getJobWorker(@androidx.annotation.NonNull java.lang.String str) {
            return com.otaliastudios.cameraview.engine.CameraEngine.this.n;
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        public void handleJobException(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.Exception exc) {
            com.otaliastudios.cameraview.engine.CameraEngine.this.e(exc, false);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$10, reason: invalid class name */
    public class AnonymousClass10 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public AnonymousClass10() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            return com.otaliastudios.cameraview.engine.CameraEngine.this.onStartPreview();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$11, reason: invalid class name */
    public class AnonymousClass11 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public AnonymousClass11() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            return com.otaliastudios.cameraview.engine.CameraEngine.this.onStopPreview();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Throwable n;

        public AnonymousClass2(java.lang.Throwable th) {
            this.n = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.Throwable th = this.n;
            if (th instanceof com.otaliastudios.cameraview.CameraException) {
                com.otaliastudios.cameraview.CameraException cameraException = (com.otaliastudios.cameraview.CameraException) th;
                if (cameraException.isUnrecoverable()) {
                    com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                    com.otaliastudios.cameraview.engine.CameraEngine.this.destroy(false);
                }
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("EXCEPTION:", "Got CameraException. Dispatching to callback.");
                com.otaliastudios.cameraview.engine.CameraEngine.this.u.dispatchError(cameraException);
                return;
            }
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
            cameraLogger.e("EXCEPTION:", "Unexpected error! Executing destroy(true).");
            com.otaliastudios.cameraview.engine.CameraEngine.this.destroy(true);
            cameraLogger.e("EXCEPTION:", "Unexpected error! Throwing.");
            java.lang.Throwable th2 = this.n;
            if (!(th2 instanceof java.lang.RuntimeException)) {
                throw new java.lang.RuntimeException(this.n);
            }
            throw ((java.lang.RuntimeException) th2);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$3, reason: invalid class name */
    public class AnonymousClass3 implements com.google.android.gms.tasks.OnCompleteListener<java.lang.Void> {
        public final /* synthetic */ java.util.concurrent.CountDownLatch a;

        public AnonymousClass3(java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(@androidx.annotation.NonNull com.google.android.gms.tasks.Task<java.lang.Void> task) {
            this.a.countDown();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$4, reason: invalid class name */
    public class AnonymousClass4 implements com.google.android.gms.tasks.SuccessContinuation<com.otaliastudios.cameraview.CameraOptions, java.lang.Void> {
        public AnonymousClass4() {
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        @androidx.annotation.NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.gms.tasks.Task<java.lang.Void> then(@androidx.annotation.Nullable com.otaliastudios.cameraview.CameraOptions cameraOptions) {
            if (cameraOptions == null) {
                throw new java.lang.RuntimeException("Null options!");
            }
            com.otaliastudios.cameraview.engine.CameraEngine.this.u.dispatchOnCameraOpened(cameraOptions);
            return com.google.android.gms.tasks.Tasks.forResult(null);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$5, reason: invalid class name */
    public class AnonymousClass5 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<com.otaliastudios.cameraview.CameraOptions>> {
        public AnonymousClass5() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<com.otaliastudios.cameraview.CameraOptions> call() {
            com.otaliastudios.cameraview.engine.CameraEngine cameraEngine = com.otaliastudios.cameraview.engine.CameraEngine.this;
            if (cameraEngine.collectCameraInfo(cameraEngine.getFacing())) {
                return com.otaliastudios.cameraview.engine.CameraEngine.this.onStartEngine();
            }
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartEngine:", "No camera available for facing", com.otaliastudios.cameraview.engine.CameraEngine.this.getFacing());
            throw new com.otaliastudios.cameraview.CameraException(6);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$6, reason: invalid class name */
    public class AnonymousClass6 implements com.google.android.gms.tasks.OnSuccessListener<java.lang.Void> {
        public AnonymousClass6() {
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(java.lang.Void r1) {
            com.otaliastudios.cameraview.engine.CameraEngine.this.u.dispatchOnCameraClosed();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$7, reason: invalid class name */
    public class AnonymousClass7 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public AnonymousClass7() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            return com.otaliastudios.cameraview.engine.CameraEngine.this.onStopEngine();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$8, reason: invalid class name */
    public class AnonymousClass8 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public AnonymousClass8() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            return (com.otaliastudios.cameraview.engine.CameraEngine.this.getPreview() == null || !com.otaliastudios.cameraview.engine.CameraEngine.this.getPreview().hasSurface()) ? com.google.android.gms.tasks.Tasks.forCanceled() : com.otaliastudios.cameraview.engine.CameraEngine.this.onStartBind();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$9, reason: invalid class name */
    public class AnonymousClass9 implements java.util.concurrent.Callable<com.google.android.gms.tasks.Task<java.lang.Void>> {
        public AnonymousClass9() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.google.android.gms.tasks.Task<java.lang.Void> call() {
            return com.otaliastudios.cameraview.engine.CameraEngine.this.onStopBind();
        }
    }

    public interface Callback {
        void dispatchError(com.otaliastudios.cameraview.CameraException cameraException);

        void dispatchFrame(@androidx.annotation.NonNull com.otaliastudios.cameraview.frame.Frame frame);

        void dispatchOnCameraClosed();

        void dispatchOnCameraOpened(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraOptions cameraOptions);

        void dispatchOnExposureCorrectionChanged(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr);

        void dispatchOnFocusEnd(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, boolean z, @androidx.annotation.NonNull android.graphics.PointF pointF);

        void dispatchOnFocusStart(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull android.graphics.PointF pointF);

        void dispatchOnPictureTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub);

        void dispatchOnVideoRecordingEnd();

        void dispatchOnVideoRecordingStart();

        void dispatchOnVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub);

        void dispatchOnZoomChanged(float f, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr);

        @androidx.annotation.NonNull
        android.content.Context getContext();

        void onCameraPreviewStreamSizeChanged();

        void onShutter(boolean z);
    }

    public class CrashExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
        public CrashExceptionHandler() {
        }

        public /* synthetic */ CrashExceptionHandler(com.otaliastudios.cameraview.engine.CameraEngine cameraEngine, com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread thread, @androidx.annotation.NonNull java.lang.Throwable th) {
            com.otaliastudios.cameraview.engine.CameraEngine.this.e(th, true);
        }
    }

    public static class NoOpExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
        public NoOpExceptionHandler() {
        }

        public /* synthetic */ NoOpExceptionHandler(com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@androidx.annotation.NonNull java.lang.Thread thread, @androidx.annotation.NonNull java.lang.Throwable th) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    public CameraEngine(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine.Callback callback) {
        this.u = callback;
        f(false);
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract boolean collectCameraInfo(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing);

    public final void d(boolean z, int i) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = LOG;
        cameraLogger.i("DESTROY:", "state:", getState(), "thread:", java.lang.Thread.currentThread(), "depth:", java.lang.Integer.valueOf(i), "unrecoverably:", java.lang.Boolean.valueOf(z));
        if (z) {
            this.n.getThread().setUncaughtExceptionHandler(new com.otaliastudios.cameraview.engine.CameraEngine.NoOpExceptionHandler(null));
        }
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        stop(true).addOnCompleteListener(this.n.getExecutor(), new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass3(countDownLatch));
        try {
            if (!countDownLatch.await(6L, java.util.concurrent.TimeUnit.SECONDS)) {
                cameraLogger.e("DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", java.lang.Thread.currentThread(), "Handler thread:", this.n.getThread());
                int i2 = i + 1;
                if (i2 < 2) {
                    f(true);
                    cameraLogger.e("DESTROY: Trying again on thread:", this.n.getThread());
                    d(z, i2);
                } else {
                    cameraLogger.w("DESTROY: Giving up because DESTROY_RETRIES was reached.");
                }
            }
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public void destroy(boolean z) {
        d(z, 0);
    }

    public final void e(@androidx.annotation.NonNull java.lang.Throwable th, boolean z) {
        if (z) {
            LOG.e("EXCEPTION:", "Handler thread is gone. Replacing.");
            f(false);
        }
        LOG.e("EXCEPTION:", "Scheduling on the crash handler...");
        this.t.post(new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass2(th));
    }

    public final void f(boolean z) {
        com.otaliastudios.cameraview.internal.WorkerHandler workerHandler = this.n;
        if (workerHandler != null) {
            workerHandler.destroy();
        }
        com.otaliastudios.cameraview.internal.WorkerHandler workerHandler2 = com.otaliastudios.cameraview.internal.WorkerHandler.get("CameraViewEngine");
        this.n = workerHandler2;
        workerHandler2.getThread().setUncaughtExceptionHandler(new com.otaliastudios.cameraview.engine.CameraEngine.CrashExceptionHandler(this, null));
        if (z) {
            this.v.reset();
        }
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> g() {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, true, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass8());
    }

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.engine.offset.Angles getAngles();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.Audio getAudio();

    public abstract int getAudioBitRate();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.AudioCodec getAudioCodec();

    public abstract long getAutoFocusResetDelay();

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.CameraEngine.Callback getCallback() {
        return this.u;
    }

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.CameraOptions getCameraOptions();

    public abstract float getExposureCorrectionValue();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.Facing getFacing();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.Flash getFlash();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.frame.FrameManager getFrameManager();

    public abstract int getFrameProcessingFormat();

    public abstract int getFrameProcessingMaxHeight();

    public abstract int getFrameProcessingMaxWidth();

    public abstract int getFrameProcessingPoolSize();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.Hdr getHdr();

    @androidx.annotation.Nullable
    public abstract android.location.Location getLocation();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.Mode getMode();

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator getOrchestrator() {
        return this.v;
    }

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.overlay.Overlay getOverlay();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.PictureFormat getPictureFormat();

    public abstract boolean getPictureMetering();

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.size.Size getPictureSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference);

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.size.SizeSelector getPictureSizeSelector();

    public abstract boolean getPictureSnapshotMetering();

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.preview.CameraPreview getPreview();

    public abstract float getPreviewFrameRate();

    public abstract boolean getPreviewFrameRateExact();

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.size.Size getPreviewStreamSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference);

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.size.SizeSelector getPreviewStreamSizeSelector();

    public abstract int getSnapshotMaxHeight();

    public abstract int getSnapshotMaxWidth();

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.orchestrator.CameraState getState() {
        return this.v.getCurrentState();
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.orchestrator.CameraState getTargetState() {
        return this.v.getTargetState();
    }

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.size.Size getUncroppedSnapshotSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference);

    public abstract int getVideoBitRate();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.VideoCodec getVideoCodec();

    public abstract int getVideoMaxDuration();

    public abstract long getVideoMaxSize();

    @androidx.annotation.Nullable
    public abstract com.otaliastudios.cameraview.size.Size getVideoSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference);

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.size.SizeSelector getVideoSizeSelector();

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.controls.WhiteBalance getWhiteBalance();

    public abstract float getZoomValue();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> h() {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.OFF, com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, true, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass5()).onSuccessTask(new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass4());
    }

    public abstract boolean hasFrameProcessors();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> i() {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, true, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass10());
    }

    public final boolean isChangingState() {
        return this.v.hasPendingStateChange();
    }

    public abstract boolean isTakingPicture();

    public abstract boolean isTakingVideo();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> j(boolean z) {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, !z, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass9());
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> k(boolean z) {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, com.otaliastudios.cameraview.engine.orchestrator.CameraState.OFF, !z, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass7()).addOnSuccessListener(new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass6());
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.google.android.gms.tasks.Task<java.lang.Void> l(boolean z) {
        return this.v.scheduleStateChange(com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, !z, new com.otaliastudios.cameraview.engine.CameraEngine.AnonymousClass11());
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<java.lang.Void> onStartBind();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<com.otaliastudios.cameraview.CameraOptions> onStartEngine();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<java.lang.Void> onStartPreview();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<java.lang.Void> onStopBind();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<java.lang.Void> onStopEngine();

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract com.google.android.gms.tasks.Task<java.lang.Void> onStopPreview();

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceAvailable() {
        LOG.i("onSurfaceAvailable:", "Size is", getPreview().getSurfaceSize());
        g();
        i();
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceDestroyed() {
        LOG.i("onSurfaceDestroyed");
        l(false);
        j(false);
    }

    public void restart() {
        LOG.i("RESTART:", "scheduled. State:", getState());
        stop(false);
        start();
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> restartBind() {
        LOG.i("RESTART BIND:", "scheduled. State:", getState());
        l(false);
        j(false);
        g();
        return i();
    }

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> restartPreview() {
        LOG.i("RESTART PREVIEW:", "scheduled. State:", getState());
        l(false);
        return i();
    }

    public abstract void setAudio(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Audio audio);

    public abstract void setAudioBitRate(int i);

    public abstract void setAudioCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.AudioCodec audioCodec);

    public abstract void setAutoFocusResetDelay(long j);

    public abstract void setExposureCorrection(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z);

    public abstract void setFacing(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing);

    public abstract void setFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash);

    public abstract void setFrameProcessingFormat(int i);

    public abstract void setFrameProcessingMaxHeight(int i);

    public abstract void setFrameProcessingMaxWidth(int i);

    public abstract void setFrameProcessingPoolSize(int i);

    public abstract void setHasFrameProcessors(boolean z);

    public abstract void setHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr);

    public abstract void setLocation(@androidx.annotation.Nullable android.location.Location location);

    public abstract void setMode(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Mode mode);

    public abstract void setOverlay(@androidx.annotation.Nullable com.otaliastudios.cameraview.overlay.Overlay overlay);

    public abstract void setPictureFormat(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.PictureFormat pictureFormat);

    public abstract void setPictureMetering(boolean z);

    public abstract void setPictureSizeSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector);

    public abstract void setPictureSnapshotMetering(boolean z);

    public abstract void setPlaySounds(boolean z);

    public abstract void setPreview(@androidx.annotation.NonNull com.otaliastudios.cameraview.preview.CameraPreview cameraPreview);

    public abstract void setPreviewFrameRate(float f);

    public abstract void setPreviewFrameRateExact(boolean z);

    public abstract void setPreviewStreamSizeSelector(@androidx.annotation.Nullable com.otaliastudios.cameraview.size.SizeSelector sizeSelector);

    public abstract void setSnapshotMaxHeight(int i);

    public abstract void setSnapshotMaxWidth(int i);

    public abstract void setVideoBitRate(int i);

    public abstract void setVideoCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.VideoCodec videoCodec);

    public abstract void setVideoMaxDuration(int i);

    public abstract void setVideoMaxSize(long j);

    public abstract void setVideoSizeSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector);

    public abstract void setWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance);

    public abstract void setZoom(float f, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z);

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> start() {
        LOG.i("START:", "scheduled. State:", getState());
        com.google.android.gms.tasks.Task<java.lang.Void> h = h();
        g();
        i();
        return h;
    }

    public abstract void startAutoFocus(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions, @androidx.annotation.NonNull android.graphics.PointF pointF);

    @androidx.annotation.NonNull
    public com.google.android.gms.tasks.Task<java.lang.Void> stop(boolean z) {
        LOG.i("STOP:", "scheduled. State:", getState());
        l(z);
        j(z);
        return k(z);
    }

    public abstract void stopVideo();

    public abstract void takePicture(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub);

    public abstract void takePictureSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub);

    public abstract void takeVideo(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor);

    public abstract void takeVideoSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull java.io.File file);
}

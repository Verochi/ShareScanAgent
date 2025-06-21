package com.otaliastudios.cameraview.engine;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes19.dex */
public class Camera2Engine extends com.otaliastudios.cameraview.engine.CameraBaseEngine implements android.media.ImageReader.OnImageAvailableListener, com.otaliastudios.cameraview.engine.action.ActionHolder {
    public final android.hardware.camera2.CameraManager Y;
    public java.lang.String Z;
    public android.hardware.camera2.CameraDevice a0;
    public android.hardware.camera2.CameraCharacteristics b0;
    public android.hardware.camera2.CameraCaptureSession c0;
    public android.hardware.camera2.CaptureRequest.Builder d0;
    public android.hardware.camera2.TotalCaptureResult e0;
    public final com.otaliastudios.cameraview.engine.mappers.Camera2Mapper f0;
    public android.media.ImageReader g0;
    public android.view.Surface h0;
    public android.view.Surface i0;
    public com.otaliastudios.cameraview.VideoResult.Stub j0;
    public android.media.ImageReader k0;
    public final boolean l0;
    public final java.util.List<com.otaliastudios.cameraview.engine.action.Action> m0;
    public com.otaliastudios.cameraview.engine.meter.MeterAction n0;
    public final android.hardware.camera2.CameraCaptureSession.CaptureCallback o0;

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$1, reason: invalid class name */
    public class AnonymousClass1 extends android.hardware.camera2.CameraCaptureSession.CaptureCallback {
        public AnonymousClass1() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.e0 = totalCaptureResult;
            java.util.Iterator it = com.otaliastudios.cameraview.engine.Camera2Engine.this.m0.iterator();
            while (it.hasNext()) {
                ((com.otaliastudios.cameraview.engine.action.Action) it.next()).onCaptureCompleted(com.otaliastudios.cameraview.engine.Camera2Engine.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.CaptureResult captureResult) {
            java.util.Iterator it = com.otaliastudios.cameraview.engine.Camera2Engine.this.m0.iterator();
            while (it.hasNext()) {
                ((com.otaliastudios.cameraview.engine.action.Action) it.next()).onCaptureProgressed(com.otaliastudios.cameraview.engine.Camera2Engine.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, long j, long j2) {
            java.util.Iterator it = com.otaliastudios.cameraview.engine.Camera2Engine.this.m0.iterator();
            while (it.hasNext()) {
                ((com.otaliastudios.cameraview.engine.action.Action) it.next()).onCaptureStarted(com.otaliastudios.cameraview.engine.Camera2Engine.this, captureRequest);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.V();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Flash n;
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Flash t;

        public AnonymousClass11(com.otaliastudios.cameraview.controls.Flash flash, com.otaliastudios.cameraview.controls.Flash flash2) {
            this.n = flash;
            this.t = flash2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            boolean applyFlash = camera2Engine.applyFlash(camera2Engine.d0, this.n);
            if (!(com.otaliastudios.cameraview.engine.Camera2Engine.this.getState() == com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW)) {
                if (applyFlash) {
                    com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
                    return;
                }
                return;
            }
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine2 = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            camera2Engine2.mFlash = com.otaliastudios.cameraview.controls.Flash.OFF;
            camera2Engine2.applyFlash(camera2Engine2.d0, this.n);
            try {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.c0.capture(com.otaliastudios.cameraview.engine.Camera2Engine.this.d0.build(), null, null);
                com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine3 = com.otaliastudios.cameraview.engine.Camera2Engine.this;
                camera2Engine3.mFlash = this.t;
                camera2Engine3.applyFlash(camera2Engine3.d0, this.n);
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
            } catch (android.hardware.camera2.CameraAccessException e) {
                throw com.otaliastudios.cameraview.engine.Camera2Engine.this.Q(e);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        public final /* synthetic */ android.location.Location n;

        public AnonymousClass12(android.location.Location location) {
            this.n = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyLocation(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.WhiteBalance n;

        public AnonymousClass13(com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
            this.n = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyWhiteBalance(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Hdr n;

        public AnonymousClass14(com.otaliastudios.cameraview.controls.Hdr hdr) {
            this.n = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyHdr(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        public final /* synthetic */ float n;
        public final /* synthetic */ boolean t;
        public final /* synthetic */ float u;
        public final /* synthetic */ android.graphics.PointF[] v;

        public AnonymousClass15(float f, boolean z, float f2, android.graphics.PointF[] pointFArr) {
            this.n = f;
            this.t = z;
            this.u = f2;
            this.v = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyZoom(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
                if (this.t) {
                    com.otaliastudios.cameraview.engine.Camera2Engine.this.getCallback().dispatchOnZoomChanged(this.u, this.v);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$16, reason: invalid class name */
    public class AnonymousClass16 implements java.lang.Runnable {
        public final /* synthetic */ float n;
        public final /* synthetic */ boolean t;
        public final /* synthetic */ float u;
        public final /* synthetic */ float[] v;
        public final /* synthetic */ android.graphics.PointF[] w;

        public AnonymousClass16(float f, boolean z, float f2, float[] fArr, android.graphics.PointF[] pointFArr) {
            this.n = f;
            this.t = z;
            this.u = f2;
            this.v = fArr;
            this.w = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyExposureCorrection(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
                if (this.t) {
                    com.otaliastudios.cameraview.engine.Camera2Engine.this.getCallback().dispatchOnExposureCorrectionChanged(this.u, this.v, this.w);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        public final /* synthetic */ float n;

        public AnonymousClass17(float f) {
            this.n = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            if (camera2Engine.applyPreviewFrameRate(camera2Engine.d0, this.n)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.applyRepeatingRequestBuilder();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$18, reason: invalid class name */
    public class AnonymousClass18 implements java.util.Comparator<android.util.Range<java.lang.Integer>> {
        public AnonymousClass18() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(android.util.Range<java.lang.Integer> range, android.util.Range<java.lang.Integer> range2) {
            return (range.getUpper().intValue() - range.getLower().intValue()) - (range2.getUpper().intValue() - range2.getLower().intValue());
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$19, reason: invalid class name */
    public class AnonymousClass19 implements java.util.Comparator<android.util.Range<java.lang.Integer>> {
        public AnonymousClass19() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(android.util.Range<java.lang.Integer> range, android.util.Range<java.lang.Integer> range2) {
            return (range2.getUpper().intValue() - range2.getLower().intValue()) - (range.getUpper().intValue() - range.getLower().intValue());
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$2, reason: invalid class name */
    public class AnonymousClass2 extends android.hardware.camera2.CameraDevice.StateCallback {
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource a;

        public AnonymousClass2(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice cameraDevice) {
            com.otaliastudios.cameraview.CameraException cameraException = new com.otaliastudios.cameraview.CameraException(3);
            if (this.a.getTask().isComplete()) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
            this.a.trySetException(cameraException);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice cameraDevice, int i) {
            if (this.a.getTask().isComplete()) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("CameraDevice.StateCallback reported an error:", java.lang.Integer.valueOf(i));
                throw new com.otaliastudios.cameraview.CameraException(3);
            }
            this.a.trySetException(com.otaliastudios.cameraview.engine.Camera2Engine.this.P(i));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@androidx.annotation.NonNull android.hardware.camera2.CameraDevice cameraDevice) {
            int i;
            com.otaliastudios.cameraview.engine.Camera2Engine.this.a0 = cameraDevice;
            try {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onStartEngine:", "Opened camera device.");
                com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
                camera2Engine.b0 = camera2Engine.Y.getCameraCharacteristics(com.otaliastudios.cameraview.engine.Camera2Engine.this.Z);
                boolean flip = com.otaliastudios.cameraview.engine.Camera2Engine.this.getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
                int i2 = com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass25.a[com.otaliastudios.cameraview.engine.Camera2Engine.this.mPictureFormat.ordinal()];
                if (i2 == 1) {
                    i = 256;
                } else {
                    if (i2 != 2) {
                        throw new java.lang.IllegalArgumentException("Unknown format:" + com.otaliastudios.cameraview.engine.Camera2Engine.this.mPictureFormat);
                    }
                    i = 32;
                }
                com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine2 = com.otaliastudios.cameraview.engine.Camera2Engine.this;
                camera2Engine2.mCameraOptions = new com.otaliastudios.cameraview.engine.options.Camera2Options(camera2Engine2.Y, com.otaliastudios.cameraview.engine.Camera2Engine.this.Z, flip, i);
                com.otaliastudios.cameraview.engine.Camera2Engine.this.S(1);
                this.a.trySetResult(com.otaliastudios.cameraview.engine.Camera2Engine.this.mCameraOptions);
            } catch (android.hardware.camera2.CameraAccessException e) {
                this.a.trySetException(com.otaliastudios.cameraview.engine.Camera2Engine.this.Q(e));
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        public AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.restart();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$21, reason: invalid class name */
    public class AnonymousClass21 implements java.lang.Runnable {
        public final /* synthetic */ boolean n;

        public AnonymousClass21(boolean z) {
            this.n = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.orchestrator.CameraState state = com.otaliastudios.cameraview.engine.Camera2Engine.this.getState();
            com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState = com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND;
            if (state.isAtLeast(cameraState) && com.otaliastudios.cameraview.engine.Camera2Engine.this.isChangingState()) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.setHasFrameProcessors(this.n);
                return;
            }
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            camera2Engine.mHasFrameProcessors = this.n;
            if (camera2Engine.getState().isAtLeast(cameraState)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.restartBind();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$22, reason: invalid class name */
    public class AnonymousClass22 implements java.lang.Runnable {
        public final /* synthetic */ int n;

        public AnonymousClass22(int i) {
            this.n = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.orchestrator.CameraState state = com.otaliastudios.cameraview.engine.Camera2Engine.this.getState();
            com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState = com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND;
            if (state.isAtLeast(cameraState) && com.otaliastudios.cameraview.engine.Camera2Engine.this.isChangingState()) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.setFrameProcessingFormat(this.n);
                return;
            }
            com.otaliastudios.cameraview.engine.Camera2Engine camera2Engine = com.otaliastudios.cameraview.engine.Camera2Engine.this;
            int i = this.n;
            if (i <= 0) {
                i = 35;
            }
            camera2Engine.mFrameProcessingFormat = i;
            if (camera2Engine.getState().isAtLeast(cameraState)) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.restartBind();
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$23, reason: invalid class name */
    public class AnonymousClass23 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.gesture.Gesture n;
        public final /* synthetic */ android.graphics.PointF t;
        public final /* synthetic */ com.otaliastudios.cameraview.metering.MeteringRegions u;

        /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$23$1, reason: invalid class name */
        public class AnonymousClass1 extends com.otaliastudios.cameraview.engine.action.CompletionCallback {
            public final /* synthetic */ com.otaliastudios.cameraview.engine.meter.MeterAction a;

            /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$23$1$1, reason: invalid class name and collision with other inner class name */
            public class RunnableC04291 implements java.lang.Runnable {
                public RunnableC04291() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.otaliastudios.cameraview.engine.Camera2Engine.this.a0();
                }
            }

            public AnonymousClass1(com.otaliastudios.cameraview.engine.meter.MeterAction meterAction) {
                this.a = meterAction;
            }

            @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
            public void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.getCallback().dispatchOnFocusEnd(com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass23.this.n, this.a.isSuccessful(), com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass23.this.t);
                com.otaliastudios.cameraview.engine.Camera2Engine.this.getOrchestrator().remove("reset metering");
                if (com.otaliastudios.cameraview.engine.Camera2Engine.this.shouldResetAutoFocus()) {
                    com.otaliastudios.cameraview.engine.Camera2Engine.this.getOrchestrator().scheduleStatefulDelayed("reset metering", com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, com.otaliastudios.cameraview.engine.Camera2Engine.this.getAutoFocusResetDelay(), new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass23.AnonymousClass1.RunnableC04291());
                }
            }
        }

        public AnonymousClass23(com.otaliastudios.cameraview.gesture.Gesture gesture, android.graphics.PointF pointF, com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions) {
            this.n = gesture;
            this.t = pointF;
            this.u = meteringRegions;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.engine.Camera2Engine.this.mCameraOptions.isAutoFocusSupported()) {
                com.otaliastudios.cameraview.engine.Camera2Engine.this.getCallback().dispatchOnFocusStart(this.n, this.t);
                com.otaliastudios.cameraview.engine.meter.MeterAction R = com.otaliastudios.cameraview.engine.Camera2Engine.this.R(this.u);
                com.otaliastudios.cameraview.engine.action.BaseAction timeout = com.otaliastudios.cameraview.engine.action.Actions.timeout(5000L, R);
                timeout.start(com.otaliastudios.cameraview.engine.Camera2Engine.this);
                timeout.addCallback(new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass23.AnonymousClass1(R));
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$24, reason: invalid class name */
    public class AnonymousClass24 extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public AnonymousClass24() {
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public void onStart(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder) {
            super.onStart(actionHolder);
            com.otaliastudios.cameraview.engine.Camera2Engine.this.applyDefaultFocus(actionHolder.getBuilder(this));
            android.hardware.camera2.CaptureRequest.Builder builder = actionHolder.getBuilder(this);
            android.hardware.camera2.CaptureRequest.Key key = android.hardware.camera2.CaptureRequest.CONTROL_AE_LOCK;
            java.lang.Boolean bool = java.lang.Boolean.FALSE;
            builder.set(key, bool);
            actionHolder.getBuilder(this).set(android.hardware.camera2.CaptureRequest.CONTROL_AWB_LOCK, bool);
            actionHolder.applyBuilder(this);
            setState(Integer.MAX_VALUE);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$25, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass25 {
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

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.concurrent.Callable<java.lang.Void> {
        public final /* synthetic */ java.lang.Object n;

        public AnonymousClass3(java.lang.Object obj) {
            this.n = obj;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() {
            ((android.view.SurfaceHolder) this.n).setFixedSize(com.otaliastudios.cameraview.engine.Camera2Engine.this.mPreviewStreamSize.getWidth(), com.otaliastudios.cameraview.engine.Camera2Engine.this.mPreviewStreamSize.getHeight());
            return null;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$4, reason: invalid class name */
    public class AnonymousClass4 extends android.hardware.camera2.CameraCaptureSession.StateCallback {
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource a;

        public AnonymousClass4(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            throw new java.lang.RuntimeException(com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onConfigureFailed! Session", cameraCaptureSession));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.c0 = cameraCaptureSession;
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onStartBind:", "Completed");
            this.a.trySetResult(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@androidx.annotation.NonNull android.hardware.camera2.CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.VideoResult.Stub n;

        public AnonymousClass5(com.otaliastudios.cameraview.VideoResult.Stub stub) {
            this.n = stub;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.T(this.n);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$6, reason: invalid class name */
    public class AnonymousClass6 extends com.otaliastudios.cameraview.engine.action.BaseAction {
        public final /* synthetic */ com.google.android.gms.tasks.TaskCompletionSource e;

        public AnonymousClass6(com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource) {
            this.e = taskCompletionSource;
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public void onCaptureCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.ActionHolder actionHolder, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest captureRequest, @androidx.annotation.NonNull android.hardware.camera2.TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
            setState(Integer.MAX_VALUE);
            this.e.trySetResult(null);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$7, reason: invalid class name */
    public class AnonymousClass7 extends com.otaliastudios.cameraview.engine.action.CompletionCallback {
        public final /* synthetic */ com.otaliastudios.cameraview.PictureResult.Stub a;

        public AnonymousClass7(com.otaliastudios.cameraview.PictureResult.Stub stub) {
            this.a = stub;
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.setPictureSnapshotMetering(false);
            com.otaliastudios.cameraview.engine.Camera2Engine.this.takePictureSnapshot(this.a);
            com.otaliastudios.cameraview.engine.Camera2Engine.this.setPictureSnapshotMetering(true);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$8, reason: invalid class name */
    public class AnonymousClass8 extends com.otaliastudios.cameraview.engine.action.CompletionCallback {
        public final /* synthetic */ com.otaliastudios.cameraview.PictureResult.Stub a;

        public AnonymousClass8(com.otaliastudios.cameraview.PictureResult.Stub stub) {
            this.a = stub;
        }

        @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
        public void onActionCompleted(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.setPictureMetering(false);
            com.otaliastudios.cameraview.engine.Camera2Engine.this.takePicture(this.a);
            com.otaliastudios.cameraview.engine.Camera2Engine.this.setPictureMetering(true);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera2Engine$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera2Engine.this.a0();
        }
    }

    public Camera2Engine(com.otaliastudios.cameraview.engine.CameraEngine.Callback callback) {
        super(callback);
        this.f0 = com.otaliastudios.cameraview.engine.mappers.Camera2Mapper.get();
        this.l0 = false;
        this.m0 = new java.util.concurrent.CopyOnWriteArrayList();
        this.o0 = new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass1();
        this.Y = (android.hardware.camera2.CameraManager) getCallback().getContext().getSystemService(com.sensorsdata.sf.ui.view.UIProperty.action_type_camera);
        new com.otaliastudios.cameraview.engine.action.LogAction().start(this);
    }

    public final void M(@androidx.annotation.NonNull android.view.Surface... surfaceArr) {
        this.d0.addTarget(this.i0);
        android.view.Surface surface = this.h0;
        if (surface != null) {
            this.d0.addTarget(surface);
        }
        for (android.view.Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new java.lang.IllegalArgumentException("Should not add a null surface.");
            }
            this.d0.addTarget(surface2);
        }
    }

    public final void N(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.Nullable android.hardware.camera2.CaptureRequest.Builder builder2) {
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_MODE, 1);
        applyDefaultFocus(builder);
        applyFlash(builder, com.otaliastudios.cameraview.controls.Flash.OFF);
        applyLocation(builder, null);
        applyWhiteBalance(builder, com.otaliastudios.cameraview.controls.WhiteBalance.AUTO);
        applyHdr(builder, com.otaliastudios.cameraview.controls.Hdr.OFF);
        applyZoom(builder, 0.0f);
        applyExposureCorrection(builder, 0.0f);
        applyPreviewFrameRate(builder, 0.0f);
        if (builder2 != null) {
            android.hardware.camera2.CaptureRequest.Key key = android.hardware.camera2.CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, builder2.get(key));
            android.hardware.camera2.CaptureRequest.Key key2 = android.hardware.camera2.CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, builder2.get(key2));
            android.hardware.camera2.CaptureRequest.Key key3 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, builder2.get(key3));
            android.hardware.camera2.CaptureRequest.Key key4 = android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, builder2.get(key4));
        }
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public final void O(boolean z, int i) {
        if ((getState() != com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW || isChangingState()) && z) {
            return;
        }
        try {
            this.c0.setRepeatingRequest(this.d0.build(), this.o0, null);
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw new com.otaliastudios.cameraview.CameraException(e, i);
        } catch (java.lang.IllegalStateException e2) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("applyRepeatingRequestBuilder: session is invalid!", e2, "checkStarted:", java.lang.Boolean.valueOf(z), "currentThread:", java.lang.Thread.currentThread().getName(), "state:", getState(), "targetState:", getTargetState());
            throw new com.otaliastudios.cameraview.CameraException(3);
        }
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.CameraException P(int i) {
        int i2 = 1;
        if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            i2 = 0;
        }
        return new com.otaliastudios.cameraview.CameraException(i2);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.CameraException Q(@androidx.annotation.NonNull android.hardware.camera2.CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i = 1;
        if (reason != 1) {
            if (reason == 2 || reason == 3) {
                i = 3;
            } else if (reason != 4 && reason != 5) {
                i = 0;
            }
        }
        return new com.otaliastudios.cameraview.CameraException(cameraAccessException, i);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.meter.MeterAction R(@androidx.annotation.Nullable com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions) {
        com.otaliastudios.cameraview.engine.meter.MeterAction meterAction = this.n0;
        if (meterAction != null) {
            meterAction.abort(this);
        }
        applyFocusForMetering(this.d0);
        com.otaliastudios.cameraview.engine.meter.MeterAction meterAction2 = new com.otaliastudios.cameraview.engine.meter.MeterAction(this, meteringRegions, meteringRegions == null);
        this.n0 = meterAction2;
        return meterAction2;
    }

    @androidx.annotation.NonNull
    public final android.hardware.camera2.CaptureRequest.Builder S(int i) throws android.hardware.camera2.CameraAccessException {
        android.hardware.camera2.CaptureRequest.Builder builder = this.d0;
        android.hardware.camera2.CaptureRequest.Builder createCaptureRequest = this.a0.createCaptureRequest(i);
        this.d0 = createCaptureRequest;
        createCaptureRequest.setTag(java.lang.Integer.valueOf(i));
        N(this.d0, builder);
        return this.d0;
    }

    public final void T(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        com.otaliastudios.cameraview.video.VideoRecorder videoRecorder = this.mVideoRecorder;
        if (!(videoRecorder instanceof com.otaliastudios.cameraview.video.Full2VideoRecorder)) {
            throw new java.lang.IllegalStateException("doTakeVideo called, but video recorder is not a Full2VideoRecorder! " + this.mVideoRecorder);
        }
        com.otaliastudios.cameraview.video.Full2VideoRecorder full2VideoRecorder = (com.otaliastudios.cameraview.video.Full2VideoRecorder) videoRecorder;
        try {
            S(3);
            M(full2VideoRecorder.getInputSurface());
            O(true, 3);
            this.mVideoRecorder.start(stub);
        } catch (android.hardware.camera2.CameraAccessException e) {
            onVideoResult(null, e);
            throw Q(e);
        } catch (com.otaliastudios.cameraview.CameraException e2) {
            onVideoResult(null, e2);
            throw e2;
        }
    }

    @androidx.annotation.NonNull
    public final android.graphics.Rect U(float f, float f2) {
        android.graphics.Rect rect = (android.graphics.Rect) W(android.hardware.camera2.CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new android.graphics.Rect());
        int width = rect.width() - ((int) (rect.width() / f2));
        int height = rect.height() - ((int) (rect.height() / f2));
        float f3 = f - 1.0f;
        float f4 = f2 - 1.0f;
        int i = (int) (((width * f3) / f4) / 2.0f);
        int i2 = (int) (((height * f3) / f4) / 2.0f);
        return new android.graphics.Rect(i, i2, rect.width() - i, rect.height() - i2);
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public final void V() {
        if (((java.lang.Integer) this.d0.build().getTag()).intValue() != 1) {
            try {
                S(1);
                M(new android.view.Surface[0]);
                applyRepeatingRequestBuilder();
            } catch (android.hardware.camera2.CameraAccessException e) {
                throw Q(e);
            }
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.VisibleForTesting
    public <T> T W(@androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics.Key<T> key, @androidx.annotation.NonNull T t) {
        return (T) X(this.b0, key, t);
    }

    @androidx.annotation.NonNull
    public final <T> T X(@androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics cameraCharacteristics, @androidx.annotation.NonNull android.hardware.camera2.CameraCharacteristics.Key<T> key, @androidx.annotation.NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    public final void Y() {
        this.d0.removeTarget(this.i0);
        android.view.Surface surface = this.h0;
        if (surface != null) {
            this.d0.removeTarget(surface);
        }
    }

    public final void Z(android.util.Range<java.lang.Integer>[] rangeArr) {
        if (!getPreviewFrameRateExact() || this.mPreviewFrameRate == 0.0f) {
            java.util.Arrays.sort(rangeArr, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass19());
        } else {
            java.util.Arrays.sort(rangeArr, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass18());
        }
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public final void a0() {
        com.otaliastudios.cameraview.engine.action.Actions.sequence(new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass24(), new com.otaliastudios.cameraview.engine.meter.MeterResetAction()).start(this);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void addAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        if (this.m0.contains(action)) {
            return;
        }
        this.m0.add(action);
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @com.otaliastudios.cameraview.engine.EngineThread
    public void applyBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        applyRepeatingRequestBuilder();
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void applyBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action, @androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder) throws android.hardware.camera2.CameraAccessException {
        if (getState() != com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW || isChangingState()) {
            return;
        }
        this.c0.capture(builder.build(), this.o0, null);
    }

    public void applyDefaultFocus(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder) {
        int[] iArr = (int[]) W(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : iArr) {
            arrayList.add(java.lang.Integer.valueOf(i));
        }
        if (getMode() == com.otaliastudios.cameraview.controls.Mode.VIDEO && arrayList.contains(3)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 3);
            return;
        }
        if (arrayList.contains(4)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        if (arrayList.contains(1)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(android.hardware.camera2.CaptureRequest.LENS_FOCUS_DISTANCE, java.lang.Float.valueOf(0.0f));
        }
    }

    public boolean applyExposureCorrection(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, float f) {
        if (!this.mCameraOptions.isExposureCorrectionSupported()) {
            this.mExposureCorrectionValue = f;
            return false;
        }
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, java.lang.Integer.valueOf(java.lang.Math.round(this.mExposureCorrectionValue * ((android.util.Rational) W(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new android.util.Rational(1, 1))).floatValue())));
        return true;
    }

    public boolean applyFlash(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        if (this.mCameraOptions.supports(this.mFlash)) {
            int[] iArr = (int[]) W(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i : iArr) {
                arrayList.add(java.lang.Integer.valueOf(i));
            }
            for (android.util.Pair<java.lang.Integer, java.lang.Integer> pair : this.f0.mapFlash(this.mFlash)) {
                if (arrayList.contains(pair.first)) {
                    com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
                    cameraLogger.i("applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    cameraLogger.i("applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE, pair.first);
                    builder.set(android.hardware.camera2.CaptureRequest.FLASH_MODE, pair.second);
                    return true;
                }
            }
        }
        this.mFlash = flash;
        return false;
    }

    public void applyFocusForMetering(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder) {
        int[] iArr = (int[]) W(android.hardware.camera2.CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : iArr) {
            arrayList.add(java.lang.Integer.valueOf(i));
        }
        if (arrayList.contains(1)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 1);
            return;
        }
        if (getMode() == com.otaliastudios.cameraview.controls.Mode.VIDEO && arrayList.contains(3)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AF_MODE, 4);
        }
    }

    public boolean applyHdr(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        if (!this.mCameraOptions.supports(this.mHdr)) {
            this.mHdr = hdr;
            return false;
        }
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_SCENE_MODE, java.lang.Integer.valueOf(this.f0.mapHdr(this.mHdr)));
        return true;
    }

    public boolean applyLocation(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.Nullable android.location.Location location) {
        android.location.Location location2 = this.mLocation;
        if (location2 == null) {
            return true;
        }
        builder.set(android.hardware.camera2.CaptureRequest.JPEG_GPS_LOCATION, location2);
        return true;
    }

    public boolean applyPreviewFrameRate(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, float f) {
        android.util.Range<java.lang.Integer>[] rangeArr = (android.util.Range[]) W(android.hardware.camera2.CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new android.util.Range[0]);
        Z(rangeArr);
        float f2 = this.mPreviewFrameRate;
        if (f2 == 0.0f) {
            for (android.util.Range<java.lang.Integer> range : rangeArr) {
                if (range.contains((android.util.Range<java.lang.Integer>) 30) || range.contains((android.util.Range<java.lang.Integer>) 24)) {
                    builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float min = java.lang.Math.min(f2, this.mCameraOptions.getPreviewFrameRateMaxValue());
            this.mPreviewFrameRate = min;
            this.mPreviewFrameRate = java.lang.Math.max(min, this.mCameraOptions.getPreviewFrameRateMinValue());
            for (android.util.Range<java.lang.Integer> range2 : rangeArr) {
                if (range2.contains((android.util.Range<java.lang.Integer>) java.lang.Integer.valueOf(java.lang.Math.round(this.mPreviewFrameRate)))) {
                    builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.mPreviewFrameRate = f;
        return false;
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public void applyRepeatingRequestBuilder() {
        O(true, 3);
    }

    public boolean applyWhiteBalance(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        if (!this.mCameraOptions.supports(this.mWhiteBalance)) {
            this.mWhiteBalance = whiteBalance;
            return false;
        }
        builder.set(android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE, java.lang.Integer.valueOf(this.f0.mapWhiteBalance(this.mWhiteBalance)));
        return true;
    }

    public boolean applyZoom(@androidx.annotation.NonNull android.hardware.camera2.CaptureRequest.Builder builder, float f) {
        if (!this.mCameraOptions.isZoomSupported()) {
            this.mZoomValue = f;
            return false;
        }
        float floatValue = ((java.lang.Float) W(android.hardware.camera2.CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, java.lang.Float.valueOf(1.0f))).floatValue();
        builder.set(android.hardware.camera2.CaptureRequest.SCALER_CROP_REGION, U((this.mZoomValue * (floatValue - 1.0f)) + 1.0f, floatValue));
        return true;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public final boolean collectCameraInfo(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        android.hardware.camera2.CameraCharacteristics cameraCharacteristics;
        int mapFacing = this.f0.mapFacing(facing);
        try {
            java.lang.String[] cameraIdList = this.Y.getCameraIdList();
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("collectCameraInfo", "Facing:", facing, "Internal:", java.lang.Integer.valueOf(mapFacing), "Cameras:", java.lang.Integer.valueOf(cameraIdList.length));
            for (java.lang.String str : cameraIdList) {
                try {
                    cameraCharacteristics = this.Y.getCameraCharacteristics(str);
                } catch (android.hardware.camera2.CameraAccessException unused) {
                }
                if (mapFacing == ((java.lang.Integer) X(cameraCharacteristics, android.hardware.camera2.CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                    this.Z = str;
                    getAngles().setSensorOffset(facing, ((java.lang.Integer) X(cameraCharacteristics, android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                    return true;
                }
                continue;
            }
            return false;
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw Q(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @androidx.annotation.NonNull
    public android.hardware.camera2.CaptureRequest.Builder getBuilder(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        return this.d0;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @androidx.annotation.NonNull
    public android.hardware.camera2.CameraCharacteristics getCharacteristics(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        return this.b0;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public java.util.List<com.otaliastudios.cameraview.size.Size> getFrameProcessingAvailableSizes() {
        try {
            android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) this.Y.getCameraCharacteristics(this.Z).get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new java.lang.RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.mFrameProcessingFormat);
            java.util.ArrayList arrayList = new java.util.ArrayList(outputSizes.length);
            for (android.util.Size size : outputSizes) {
                com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            return arrayList;
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw Q(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    @androidx.annotation.Nullable
    public android.hardware.camera2.TotalCaptureResult getLastResult(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        return this.e0;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public java.util.List<com.otaliastudios.cameraview.size.Size> getPreviewStreamAvailableSizes() {
        try {
            android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) this.Y.getCameraCharacteristics(this.Z).get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new java.lang.RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            android.util.Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.mPreview.getOutputClass());
            java.util.ArrayList arrayList = new java.util.ArrayList(outputSizes.length);
            for (android.util.Size size : outputSizes) {
                com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            return arrayList;
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw Q(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.frame.FrameManager instantiateFrameManager(int i) {
        return new com.otaliastudios.cameraview.frame.ImageFrameManager(i);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onImageAvailable(android.media.ImageReader imageReader) {
        android.media.Image image;
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.v("onImageAvailable:", "trying to acquire Image.");
        try {
            image = imageReader.acquireLatestImage();
        } catch (java.lang.Exception unused) {
            image = null;
        }
        if (image == null) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (getState() != com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW || isChangingState()) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            image.close();
            return;
        }
        com.otaliastudios.cameraview.frame.Frame frame = getFrameManager().getFrame(image, java.lang.System.currentTimeMillis());
        if (frame == null) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.v("onImageAvailable:", "Image acquired, dispatching.");
            getCallback().dispatchFrame(frame);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public void onPictureResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc) {
        boolean z = this.mPictureRecorder instanceof com.otaliastudios.cameraview.picture.Full2PictureRecorder;
        super.onPictureResult(stub, exc);
        if ((z && getPictureMetering()) || (!z && getPictureSnapshotMetering())) {
            getOrchestrator().scheduleStateful("reset metering after picture", com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass9());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onPreviewStreamSizeChanged() {
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onPreviewStreamSizeChanged:", "Calling restartBind().");
        restartBind();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStartBind() {
        int i;
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onStartBind:", "Started");
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        this.mCaptureSize = computeCaptureSize();
        this.mPreviewStreamSize = computePreviewStreamSize();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.Class outputClass = this.mPreview.getOutputClass();
        java.lang.Object output = this.mPreview.getOutput();
        if (outputClass == android.view.SurfaceHolder.class) {
            try {
                com.google.android.gms.tasks.Tasks.await(com.google.android.gms.tasks.Tasks.call(new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass3(output)));
                this.i0 = ((android.view.SurfaceHolder) output).getSurface();
            } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException e) {
                throw new com.otaliastudios.cameraview.CameraException(e, 1);
            }
        } else {
            if (outputClass != android.graphics.SurfaceTexture.class) {
                throw new java.lang.RuntimeException("Unknown CameraPreview output class.");
            }
            android.graphics.SurfaceTexture surfaceTexture = (android.graphics.SurfaceTexture) output;
            surfaceTexture.setDefaultBufferSize(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
            this.i0 = new android.view.Surface(surfaceTexture);
        }
        arrayList.add(this.i0);
        if (getMode() == com.otaliastudios.cameraview.controls.Mode.VIDEO && this.j0 != null) {
            com.otaliastudios.cameraview.video.Full2VideoRecorder full2VideoRecorder = new com.otaliastudios.cameraview.video.Full2VideoRecorder(this, this.Z);
            try {
                arrayList.add(full2VideoRecorder.createInputSurface(this.j0));
                this.mVideoRecorder = full2VideoRecorder;
            } catch (com.otaliastudios.cameraview.video.Full2VideoRecorder.PrepareException e2) {
                throw new com.otaliastudios.cameraview.CameraException(e2, 1);
            }
        }
        if (getMode() == com.otaliastudios.cameraview.controls.Mode.PICTURE) {
            int i2 = com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass25.a[this.mPictureFormat.ordinal()];
            if (i2 == 1) {
                i = 256;
            } else {
                if (i2 != 2) {
                    throw new java.lang.IllegalArgumentException("Unknown format:" + this.mPictureFormat);
                }
                i = 32;
            }
            android.media.ImageReader newInstance = android.media.ImageReader.newInstance(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight(), i, 2);
            this.k0 = newInstance;
            arrayList.add(newInstance.getSurface());
        }
        if (hasFrameProcessors()) {
            com.otaliastudios.cameraview.size.Size computeFrameProcessingSize = computeFrameProcessingSize();
            this.mFrameProcessingSize = computeFrameProcessingSize;
            android.media.ImageReader newInstance2 = android.media.ImageReader.newInstance(computeFrameProcessingSize.getWidth(), this.mFrameProcessingSize.getHeight(), this.mFrameProcessingFormat, getFrameProcessingPoolSize() + 1);
            this.g0 = newInstance2;
            newInstance2.setOnImageAvailableListener(this, null);
            android.view.Surface surface = this.g0.getSurface();
            this.h0 = surface;
            arrayList.add(surface);
        } else {
            this.g0 = null;
            this.mFrameProcessingSize = null;
            this.h0 = null;
        }
        try {
            this.a0.createCaptureSession(arrayList, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass4(taskCompletionSource), null);
            return taskCompletionSource.getTask();
        } catch (android.hardware.camera2.CameraAccessException e3) {
            throw Q(e3);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    @android.annotation.SuppressLint({"MissingPermission"})
    public com.google.android.gms.tasks.Task<com.otaliastudios.cameraview.CameraOptions> onStartEngine() {
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        try {
            this.Y.openCamera(this.Z, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass2(taskCompletionSource), (android.os.Handler) null);
            return taskCompletionSource.getTask();
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw Q(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStartPreview() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        getCallback().onCameraPreviewStreamSizeChanged();
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.VIEW;
        com.otaliastudios.cameraview.size.Size previewStreamSize = getPreviewStreamSize(reference);
        if (previewStreamSize == null) {
            throw new java.lang.IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.mPreview.setStreamSize(previewStreamSize.getWidth(), previewStreamSize.getHeight());
        this.mPreview.setDrawRotation(getAngles().offset(com.otaliastudios.cameraview.engine.offset.Reference.BASE, reference, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE));
        if (hasFrameProcessors()) {
            getFrameManager().setUp(this.mFrameProcessingFormat, this.mFrameProcessingSize, getAngles());
        }
        cameraLogger.i("onStartPreview:", "Starting preview.");
        M(new android.view.Surface[0]);
        O(false, 2);
        cameraLogger.i("onStartPreview:", "Started preview.");
        com.otaliastudios.cameraview.VideoResult.Stub stub = this.j0;
        if (stub != null) {
            this.j0 = null;
            getOrchestrator().scheduleStateful("do take video", com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass5(stub));
        }
        com.google.android.gms.tasks.TaskCompletionSource taskCompletionSource = new com.google.android.gms.tasks.TaskCompletionSource();
        new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass6(taskCompletionSource).start(this);
        return taskCompletionSource.getTask();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStopBind() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onStopBind:", "About to clean up.");
        this.h0 = null;
        this.i0 = null;
        this.mPreviewStreamSize = null;
        this.mCaptureSize = null;
        this.mFrameProcessingSize = null;
        android.media.ImageReader imageReader = this.g0;
        if (imageReader != null) {
            imageReader.close();
            this.g0 = null;
        }
        android.media.ImageReader imageReader2 = this.k0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.k0 = null;
        }
        this.c0.close();
        this.c0 = null;
        cameraLogger.i("onStopBind:", "Returning.");
        return com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStopEngine() {
        try {
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
            cameraLogger.i("onStopEngine:", "Clean up.", "Releasing camera.");
            this.a0.close();
            cameraLogger.i("onStopEngine:", "Clean up.", "Released camera.");
        } catch (java.lang.Exception e) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
        }
        this.a0 = null;
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onStopEngine:", "Aborting actions.");
        java.util.Iterator<com.otaliastudios.cameraview.engine.action.Action> it = this.m0.iterator();
        while (it.hasNext()) {
            it.next().abort(this);
        }
        this.b0 = null;
        this.mCameraOptions = null;
        this.mVideoRecorder = null;
        this.d0 = null;
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("onStopEngine:", "Returning.");
        return com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStopPreview() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onStopPreview:", "Started.");
        com.otaliastudios.cameraview.video.VideoRecorder videoRecorder = this.mVideoRecorder;
        if (videoRecorder != null) {
            videoRecorder.stop(true);
            this.mVideoRecorder = null;
        }
        this.mPictureRecorder = null;
        if (hasFrameProcessors()) {
            getFrameManager().release();
        }
        Y();
        this.e0 = null;
        cameraLogger.i("onStopPreview:", "Returning.");
        return com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakePicture(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, boolean z) {
        if (z) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onTakePicture:", "doMetering is true. Delaying.");
            com.otaliastudios.cameraview.engine.action.BaseAction timeout = com.otaliastudios.cameraview.engine.action.Actions.timeout(2500L, R(null));
            timeout.addCallback(new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass8(stub));
            timeout.start(this);
            return;
        }
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onTakePicture:", "doMetering is false. Performing.");
        com.otaliastudios.cameraview.engine.offset.Angles angles = getAngles();
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
        com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR);
        stub.size = getPictureSize(reference2);
        try {
            android.hardware.camera2.CaptureRequest.Builder createCaptureRequest = this.a0.createCaptureRequest(2);
            N(createCaptureRequest, this.d0);
            com.otaliastudios.cameraview.picture.Full2PictureRecorder full2PictureRecorder = new com.otaliastudios.cameraview.picture.Full2PictureRecorder(stub, this, createCaptureRequest, this.k0);
            this.mPictureRecorder = full2PictureRecorder;
            full2PictureRecorder.take();
        } catch (android.hardware.camera2.CameraAccessException e) {
            throw Q(e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakePictureSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio, boolean z) {
        if (z) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onTakePictureSnapshot:", "doMetering is true. Delaying.");
            com.otaliastudios.cameraview.engine.action.BaseAction timeout = com.otaliastudios.cameraview.engine.action.Actions.timeout(2500L, R(null));
            timeout.addCallback(new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass7(stub));
            timeout.start(this);
            return;
        }
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.mPreview instanceof com.otaliastudios.cameraview.preview.RendererCameraPreview)) {
            throw new java.lang.RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.size = getUncroppedSnapshotSize(reference);
        stub.rotation = getAngles().offset(com.otaliastudios.cameraview.engine.offset.Reference.VIEW, reference, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE);
        com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder snapshot2PictureRecorder = new com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder(stub, this, (com.otaliastudios.cameraview.preview.RendererCameraPreview) this.mPreview, aspectRatio);
        this.mPictureRecorder = snapshot2PictureRecorder;
        snapshot2PictureRecorder.take();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakeVideo(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onTakeVideo", "called.");
        com.otaliastudios.cameraview.engine.offset.Angles angles = getAngles();
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
        com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR);
        stub.size = getAngles().flip(reference, reference2) ? this.mCaptureSize.flip() : this.mCaptureSize;
        cameraLogger.w("onTakeVideo", "calling restartBind.");
        this.j0 = stub;
        restartBind();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakeVideoSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio) {
        java.lang.Object obj = this.mPreview;
        if (!(obj instanceof com.otaliastudios.cameraview.preview.RendererCameraPreview)) {
            throw new java.lang.IllegalStateException("Video snapshots are only supported with GL_SURFACE.");
        }
        com.otaliastudios.cameraview.preview.RendererCameraPreview rendererCameraPreview = (com.otaliastudios.cameraview.preview.RendererCameraPreview) obj;
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        com.otaliastudios.cameraview.size.Size uncroppedSnapshotSize = getUncroppedSnapshotSize(reference);
        if (uncroppedSnapshotSize == null) {
            throw new java.lang.IllegalStateException("outputSize should not be null.");
        }
        android.graphics.Rect computeCrop = com.otaliastudios.cameraview.internal.CropHelper.computeCrop(uncroppedSnapshotSize, aspectRatio);
        stub.size = new com.otaliastudios.cameraview.size.Size(computeCrop.width(), computeCrop.height());
        stub.rotation = getAngles().offset(com.otaliastudios.cameraview.engine.offset.Reference.VIEW, reference, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE);
        stub.videoFrameRate = java.lang.Math.round(this.mPreviewFrameRate);
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onTakeVideoSnapshot", "rotation:", java.lang.Integer.valueOf(stub.rotation), "size:", stub.size);
        com.otaliastudios.cameraview.video.SnapshotVideoRecorder snapshotVideoRecorder = new com.otaliastudios.cameraview.video.SnapshotVideoRecorder(this, rendererCameraPreview, getOverlay());
        this.mVideoRecorder = snapshotVideoRecorder;
        snapshotVideoRecorder.start(stub);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoRecordingEnd() {
        super.onVideoRecordingEnd();
        if ((this.mVideoRecorder instanceof com.otaliastudios.cameraview.video.Full2VideoRecorder) && ((java.lang.Integer) W(android.hardware.camera2.CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2) {
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
            cameraLogger.w("Applying the Issue549 workaround.", java.lang.Thread.currentThread());
            V();
            cameraLogger.w("Applied the Issue549 workaround. Sleeping...");
            try {
                java.lang.Thread.sleep(600L);
            } catch (java.lang.InterruptedException unused) {
            }
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("Applied the Issue549 workaround. Slept!");
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc) {
        super.onVideoResult(stub, exc);
        getOrchestrator().scheduleStateful("restore preview template", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass10());
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionHolder
    public void removeAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.action.Action action) {
        this.m0.remove(action);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setExposureCorrection(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z) {
        float f2 = this.mExposureCorrectionValue;
        this.mExposureCorrectionValue = f;
        getOrchestrator().remove("exposure correction");
        this.R = getOrchestrator().scheduleStateful("exposure correction", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass16(f2, z, f, fArr, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        com.otaliastudios.cameraview.controls.Flash flash2 = this.mFlash;
        this.mFlash = flash;
        this.S = getOrchestrator().scheduleStateful("flash (" + flash + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass11(flash2, flash));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFrameProcessingFormat(int i) {
        if (this.mFrameProcessingFormat == 0) {
            this.mFrameProcessingFormat = 35;
        }
        getOrchestrator().schedule("frame processing format (" + i + ")", true, (java.lang.Runnable) new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass22(i));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHasFrameProcessors(boolean z) {
        getOrchestrator().schedule("has frame processors (" + z + ")", true, (java.lang.Runnable) new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass21(z));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        com.otaliastudios.cameraview.controls.Hdr hdr2 = this.mHdr;
        this.mHdr = hdr;
        this.U = getOrchestrator().scheduleStateful("hdr (" + hdr + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass14(hdr2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setLocation(@androidx.annotation.Nullable android.location.Location location) {
        android.location.Location location2 = this.mLocation;
        this.mLocation = location;
        this.V = getOrchestrator().scheduleStateful(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass12(location2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPictureFormat(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.PictureFormat pictureFormat) {
        if (pictureFormat != this.mPictureFormat) {
            this.mPictureFormat = pictureFormat;
            getOrchestrator().scheduleStateful("picture format (" + pictureFormat + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass20());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPlaySounds(boolean z) {
        this.mPlaySounds = z;
        this.W = com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPreviewFrameRate(float f) {
        float f2 = this.mPreviewFrameRate;
        this.mPreviewFrameRate = f;
        this.X = getOrchestrator().scheduleStateful("preview fps (" + f + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass17(f2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance2 = this.mWhiteBalance;
        this.mWhiteBalance = whiteBalance;
        this.T = getOrchestrator().scheduleStateful("white balance (" + whiteBalance + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass13(whiteBalance2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setZoom(float f, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z) {
        float f2 = this.mZoomValue;
        this.mZoomValue = f;
        getOrchestrator().remove("zoom");
        this.Q = getOrchestrator().scheduleStateful("zoom", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass15(f2, z, f, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void startAutoFocus(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        getOrchestrator().scheduleStateful("autofocus (" + gesture + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.PREVIEW, new com.otaliastudios.cameraview.engine.Camera2Engine.AnonymousClass23(gesture, pointF, meteringRegions));
    }
}

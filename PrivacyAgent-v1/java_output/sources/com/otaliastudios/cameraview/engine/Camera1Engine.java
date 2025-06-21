package com.otaliastudios.cameraview.engine;

/* loaded from: classes19.dex */
public class Camera1Engine extends com.otaliastudios.cameraview.engine.CameraBaseEngine implements android.hardware.Camera.PreviewCallback, android.hardware.Camera.ErrorCallback, com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback {
    public final com.otaliastudios.cameraview.engine.mappers.Camera1Mapper Y;
    public android.hardware.Camera Z;

    @androidx.annotation.VisibleForTesting
    public int a0;

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Flash n;

        public AnonymousClass1(com.otaliastudios.cameraview.controls.Flash flash) {
            this.n = flash;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.J(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$10, reason: invalid class name */
    public class AnonymousClass10 implements java.util.Comparator<int[]> {
        public AnonymousClass10() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return (iArr2[1] - iArr2[0]) - (iArr[1] - iArr[0]);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.metering.MeteringRegions n;
        public final /* synthetic */ com.otaliastudios.cameraview.gesture.Gesture t;
        public final /* synthetic */ android.graphics.PointF u;

        /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$11$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.engine.CameraEngine.Callback callback = com.otaliastudios.cameraview.engine.Camera1Engine.this.getCallback();
                com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11 anonymousClass11 = com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11.this;
                callback.dispatchOnFocusEnd(anonymousClass11.t, false, anonymousClass11.u);
            }
        }

        /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$11$2, reason: invalid class name */
        public class AnonymousClass2 implements android.hardware.Camera.AutoFocusCallback {

            /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$11$2$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                public AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.cancelAutoFocus();
                    android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.H(parameters);
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
                }
            }

            public AnonymousClass2() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, android.hardware.Camera camera) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.getOrchestrator().remove("focus end");
                com.otaliastudios.cameraview.engine.Camera1Engine.this.getOrchestrator().remove("focus reset");
                com.otaliastudios.cameraview.engine.CameraEngine.Callback callback = com.otaliastudios.cameraview.engine.Camera1Engine.this.getCallback();
                com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11 anonymousClass11 = com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11.this;
                callback.dispatchOnFocusEnd(anonymousClass11.t, z, anonymousClass11.u);
                if (com.otaliastudios.cameraview.engine.Camera1Engine.this.shouldResetAutoFocus()) {
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.getOrchestrator().scheduleStatefulDelayed("focus reset", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, com.otaliastudios.cameraview.engine.Camera1Engine.this.getAutoFocusResetDelay(), new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11.AnonymousClass2.AnonymousClass1());
                }
            }
        }

        public AnonymousClass11(com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions, com.otaliastudios.cameraview.gesture.Gesture gesture, android.graphics.PointF pointF) {
            this.n = meteringRegions;
            this.t = gesture;
            this.u = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.mCameraOptions.isAutoFocusSupported()) {
                com.otaliastudios.cameraview.engine.metering.Camera1MeteringTransform camera1MeteringTransform = new com.otaliastudios.cameraview.engine.metering.Camera1MeteringTransform(com.otaliastudios.cameraview.engine.Camera1Engine.this.getAngles(), com.otaliastudios.cameraview.engine.Camera1Engine.this.getPreview().getSurfaceSize());
                com.otaliastudios.cameraview.metering.MeteringRegions transform = this.n.transform(camera1MeteringTransform);
                android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(transform.get(maxNumFocusAreas, camera1MeteringTransform));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(transform.get(maxNumMeteringAreas, camera1MeteringTransform));
                }
                parameters.setFocusMode("auto");
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
                com.otaliastudios.cameraview.engine.Camera1Engine.this.getCallback().dispatchOnFocusStart(this.t, this.u);
                com.otaliastudios.cameraview.engine.Camera1Engine.this.getOrchestrator().remove("focus end");
                com.otaliastudios.cameraview.engine.Camera1Engine.this.getOrchestrator().scheduleDelayed("focus end", 2500L, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11.AnonymousClass1());
                try {
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.autoFocus(new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11.AnonymousClass2());
                } catch (java.lang.RuntimeException e) {
                    com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ android.location.Location n;

        public AnonymousClass2(android.location.Location location) {
            this.n = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.L(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.WhiteBalance n;

        public AnonymousClass3(com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
            this.n = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.O(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Hdr n;

        public AnonymousClass4(com.otaliastudios.cameraview.controls.Hdr hdr) {
            this.n = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.K(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ float n;
        public final /* synthetic */ boolean t;
        public final /* synthetic */ android.graphics.PointF[] u;

        public AnonymousClass5(float f, boolean z, android.graphics.PointF[] pointFArr) {
            this.n = f;
            this.t = z;
            this.u = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.P(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
                if (this.t) {
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.getCallback().dispatchOnZoomChanged(com.otaliastudios.cameraview.engine.Camera1Engine.this.mZoomValue, this.u);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ float n;
        public final /* synthetic */ boolean t;
        public final /* synthetic */ float[] u;
        public final /* synthetic */ android.graphics.PointF[] v;

        public AnonymousClass6(float f, boolean z, float[] fArr, android.graphics.PointF[] pointFArr) {
            this.n = f;
            this.t = z;
            this.u = fArr;
            this.v = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.I(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
                if (this.t) {
                    com.otaliastudios.cameraview.engine.Camera1Engine.this.getCallback().dispatchOnExposureCorrectionChanged(com.otaliastudios.cameraview.engine.Camera1Engine.this.mExposureCorrectionValue, this.u, this.v);
                }
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public final /* synthetic */ boolean n;

        public AnonymousClass7(boolean z) {
            this.n = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.Camera1Engine.this.M(this.n);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public final /* synthetic */ float n;

        public AnonymousClass8(float f) {
            this.n = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.hardware.Camera.Parameters parameters = com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.getParameters();
            if (com.otaliastudios.cameraview.engine.Camera1Engine.this.N(parameters, this.n)) {
                com.otaliastudios.cameraview.engine.Camera1Engine.this.Z.setParameters(parameters);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.Camera1Engine$9, reason: invalid class name */
    public class AnonymousClass9 implements java.util.Comparator<int[]> {
        public AnonymousClass9() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(int[] iArr, int[] iArr2) {
            return (iArr[1] - iArr[0]) - (iArr2[1] - iArr2[0]);
        }
    }

    public Camera1Engine(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine.Callback callback) {
        super(callback);
        this.Y = com.otaliastudios.cameraview.engine.mappers.Camera1Mapper.get();
    }

    public final void G(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters) {
        parameters.setRecordingHint(getMode() == com.otaliastudios.cameraview.controls.Mode.VIDEO);
        H(parameters);
        J(parameters, com.otaliastudios.cameraview.controls.Flash.OFF);
        L(parameters, null);
        O(parameters, com.otaliastudios.cameraview.controls.WhiteBalance.AUTO);
        K(parameters, com.otaliastudios.cameraview.controls.Hdr.OFF);
        P(parameters, 0.0f);
        I(parameters, 0.0f);
        M(this.mPlaySounds);
        N(parameters, 0.0f);
    }

    public final void H(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters) {
        java.util.List<java.lang.String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (getMode() == com.otaliastudios.cameraview.controls.Mode.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            return;
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    public final boolean I(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, float f) {
        if (!this.mCameraOptions.isExposureCorrectionSupported()) {
            this.mExposureCorrectionValue = f;
            return false;
        }
        float exposureCorrectionMaxValue = this.mCameraOptions.getExposureCorrectionMaxValue();
        float exposureCorrectionMinValue = this.mCameraOptions.getExposureCorrectionMinValue();
        float f2 = this.mExposureCorrectionValue;
        if (f2 < exposureCorrectionMinValue) {
            exposureCorrectionMaxValue = exposureCorrectionMinValue;
        } else if (f2 <= exposureCorrectionMaxValue) {
            exposureCorrectionMaxValue = f2;
        }
        this.mExposureCorrectionValue = exposureCorrectionMaxValue;
        parameters.setExposureCompensation((int) (exposureCorrectionMaxValue / parameters.getExposureCompensationStep()));
        return true;
    }

    public final boolean J(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        if (this.mCameraOptions.supports(this.mFlash)) {
            parameters.setFlashMode(this.Y.mapFlash(this.mFlash));
            return true;
        }
        this.mFlash = flash;
        return false;
    }

    public final boolean K(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        if (this.mCameraOptions.supports(this.mHdr)) {
            parameters.setSceneMode(this.Y.mapHdr(this.mHdr));
            return true;
        }
        this.mHdr = hdr;
        return false;
    }

    public final boolean L(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, @androidx.annotation.Nullable android.location.Location location) {
        android.location.Location location2 = this.mLocation;
        if (location2 == null) {
            return true;
        }
        parameters.setGpsLatitude(location2.getLatitude());
        parameters.setGpsLongitude(this.mLocation.getLongitude());
        parameters.setGpsAltitude(this.mLocation.getAltitude());
        parameters.setGpsTimestamp(this.mLocation.getTime());
        parameters.setGpsProcessingMethod(this.mLocation.getProvider());
        return true;
    }

    @android.annotation.TargetApi(17)
    public final boolean M(boolean z) {
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        android.hardware.Camera.getCameraInfo(this.a0, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.Z.enableShutterSound(this.mPlaySounds);
            } catch (java.lang.RuntimeException unused) {
                return false;
            }
        }
        if (this.mPlaySounds) {
            return true;
        }
        this.mPlaySounds = z;
        return false;
    }

    public final boolean N(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, float f) {
        java.util.List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Q(supportedPreviewFpsRange);
        float f2 = this.mPreviewFrameRate;
        if (f2 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i = iArr[0];
                float f3 = i / 1000.0f;
                int i2 = iArr[1];
                float f4 = i2 / 1000.0f;
                if ((f3 <= 30.0f && 30.0f <= f4) || (f3 <= 24.0f && 24.0f <= f4)) {
                    parameters.setPreviewFpsRange(i, i2);
                    return true;
                }
            }
        } else {
            float min = java.lang.Math.min(f2, this.mCameraOptions.getPreviewFrameRateMaxValue());
            this.mPreviewFrameRate = min;
            this.mPreviewFrameRate = java.lang.Math.max(min, this.mCameraOptions.getPreviewFrameRateMinValue());
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f5 = iArr2[0] / 1000.0f;
                float f6 = iArr2[1] / 1000.0f;
                float round = java.lang.Math.round(this.mPreviewFrameRate);
                if (f5 <= round && round <= f6) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.mPreviewFrameRate = f;
        return false;
    }

    public final boolean O(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, @androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        if (!this.mCameraOptions.supports(this.mWhiteBalance)) {
            this.mWhiteBalance = whiteBalance;
            return false;
        }
        parameters.setWhiteBalance(this.Y.mapWhiteBalance(this.mWhiteBalance));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    public final boolean P(@androidx.annotation.NonNull android.hardware.Camera.Parameters parameters, float f) {
        if (!this.mCameraOptions.isZoomSupported()) {
            this.mZoomValue = f;
            return false;
        }
        parameters.setZoom((int) (this.mZoomValue * parameters.getMaxZoom()));
        this.Z.setParameters(parameters);
        return true;
    }

    public final void Q(java.util.List<int[]> list) {
        if (!getPreviewFrameRateExact() || this.mPreviewFrameRate == 0.0f) {
            java.util.Collections.sort(list, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass10());
        } else {
            java.util.Collections.sort(list, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass9());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public boolean collectCameraInfo(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        int mapFacing = this.Y.mapFacing(facing);
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("collectCameraInfo", "Facing:", facing, "Internal:", java.lang.Integer.valueOf(mapFacing), "Cameras:", java.lang.Integer.valueOf(android.hardware.Camera.getNumberOfCameras()));
        android.hardware.Camera.CameraInfo cameraInfo = new android.hardware.Camera.CameraInfo();
        int numberOfCameras = android.hardware.Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            android.hardware.Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == mapFacing) {
                getAngles().setSensorOffset(facing, cameraInfo.orientation);
                this.a0 = i;
                return true;
            }
        }
        return false;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine, com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.frame.ByteBufferFrameManager getFrameManager() {
        return (com.otaliastudios.cameraview.frame.ByteBufferFrameManager) super.getFrameManager();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public java.util.List<com.otaliastudios.cameraview.size.Size> getFrameProcessingAvailableSizes() {
        return java.util.Collections.singletonList(this.mPreviewStreamSize);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public java.util.List<com.otaliastudios.cameraview.size.Size> getPreviewStreamAvailableSizes() {
        try {
            java.util.List<android.hardware.Camera.Size> supportedPreviewSizes = this.Z.getParameters().getSupportedPreviewSizes();
            java.util.ArrayList arrayList = new java.util.ArrayList(supportedPreviewSizes.size());
            for (android.hardware.Camera.Size size : supportedPreviewSizes) {
                com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(size.width, size.height);
                if (!arrayList.contains(size2)) {
                    arrayList.add(size2);
                }
            }
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (java.lang.Exception e) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new com.otaliastudios.cameraview.CameraException(e, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.frame.FrameManager instantiateFrameManager(int i) {
        return new com.otaliastudios.cameraview.frame.ByteBufferFrameManager(i, this);
    }

    @Override // com.otaliastudios.cameraview.frame.ByteBufferFrameManager.BufferCallback
    public void onBufferAvailable(@androidx.annotation.NonNull byte[] bArr) {
        com.otaliastudios.cameraview.engine.orchestrator.CameraState state = getState();
        com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState = com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE;
        if (state.isAtLeast(cameraState) && getTargetState().isAtLeast(cameraState)) {
            this.Z.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, android.hardware.Camera camera) {
        throw new com.otaliastudios.cameraview.CameraException(new java.lang.RuntimeException(com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("Internal Camera1 error.", java.lang.Integer.valueOf(i))), (i == 1 || i == 2 || i == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, android.hardware.Camera camera) {
        com.otaliastudios.cameraview.frame.Frame frame;
        if (bArr == null || (frame = getFrameManager().getFrame(bArr, java.lang.System.currentTimeMillis())) == null) {
            return;
        }
        getCallback().dispatchFrame(frame);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onPreviewStreamSizeChanged() {
        restartPreview();
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStartBind() {
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onStartBind:", "Started");
        try {
            if (this.mPreview.getOutputClass() == android.view.SurfaceHolder.class) {
                this.Z.setPreviewDisplay((android.view.SurfaceHolder) this.mPreview.getOutput());
            } else {
                if (this.mPreview.getOutputClass() != android.graphics.SurfaceTexture.class) {
                    throw new java.lang.RuntimeException("Unknown CameraPreview output class.");
                }
                this.Z.setPreviewTexture((android.graphics.SurfaceTexture) this.mPreview.getOutput());
            }
            this.mCaptureSize = computeCaptureSize();
            this.mPreviewStreamSize = computePreviewStreamSize();
            return com.google.android.gms.tasks.Tasks.forResult(null);
        } catch (java.io.IOException e) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartBind:", "Failed to bind.", e);
            throw new com.otaliastudios.cameraview.CameraException(e, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<com.otaliastudios.cameraview.CameraOptions> onStartEngine() {
        try {
            android.hardware.Camera open = android.hardware.Camera.open(this.a0);
            this.Z = open;
            if (open == null) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new com.otaliastudios.cameraview.CameraException(1);
            }
            open.setErrorCallback(this);
            com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
            cameraLogger.i("onStartEngine:", "Applying default parameters.");
            try {
                android.hardware.Camera.Parameters parameters = this.Z.getParameters();
                int i = this.a0;
                com.otaliastudios.cameraview.engine.offset.Angles angles = getAngles();
                com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
                com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.VIEW;
                this.mCameraOptions = new com.otaliastudios.cameraview.engine.options.Camera1Options(parameters, i, angles.flip(reference, reference2));
                G(parameters);
                this.Z.setParameters(parameters);
                try {
                    this.Z.setDisplayOrientation(getAngles().offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE));
                    cameraLogger.i("onStartEngine:", "Ended");
                    return com.google.android.gms.tasks.Tasks.forResult(this.mCameraOptions);
                } catch (java.lang.Exception unused) {
                    com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new com.otaliastudios.cameraview.CameraException(1);
                }
            } catch (java.lang.Exception e) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Problem with camera params");
                throw new com.otaliastudios.cameraview.CameraException(e, 1);
            }
        } catch (java.lang.Exception e2) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new com.otaliastudios.cameraview.CameraException(e2, 1);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStartPreview() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        getCallback().onCameraPreviewStreamSizeChanged();
        com.otaliastudios.cameraview.size.Size previewStreamSize = getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        if (previewStreamSize == null) {
            throw new java.lang.IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.mPreview.setStreamSize(previewStreamSize.getWidth(), previewStreamSize.getHeight());
        this.mPreview.setDrawRotation(0);
        try {
            android.hardware.Camera.Parameters parameters = this.Z.getParameters();
            parameters.setPreviewFormat(17);
            parameters.setPreviewSize(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
            com.otaliastudios.cameraview.controls.Mode mode = getMode();
            com.otaliastudios.cameraview.controls.Mode mode2 = com.otaliastudios.cameraview.controls.Mode.PICTURE;
            if (mode == mode2) {
                parameters.setPictureSize(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight());
            } else {
                com.otaliastudios.cameraview.size.Size computeCaptureSize = computeCaptureSize(mode2);
                parameters.setPictureSize(computeCaptureSize.getWidth(), computeCaptureSize.getHeight());
            }
            try {
                this.Z.setParameters(parameters);
                this.Z.setPreviewCallbackWithBuffer(null);
                this.Z.setPreviewCallbackWithBuffer(this);
                getFrameManager().setUp(17, this.mPreviewStreamSize, getAngles());
                cameraLogger.i("onStartPreview", "Starting preview with startPreview().");
                try {
                    this.Z.startPreview();
                    cameraLogger.i("onStartPreview", "Started preview.");
                    return com.google.android.gms.tasks.Tasks.forResult(null);
                } catch (java.lang.Exception e) {
                    com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartPreview", "Failed to start preview.", e);
                    throw new com.otaliastudios.cameraview.CameraException(e, 2);
                }
            } catch (java.lang.Exception e2) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new com.otaliastudios.cameraview.CameraException(e2, 2);
            }
        } catch (java.lang.Exception e3) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new com.otaliastudios.cameraview.CameraException(e3, 2);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStopBind() {
        this.mPreviewStreamSize = null;
        this.mCaptureSize = null;
        try {
            if (this.mPreview.getOutputClass() == android.view.SurfaceHolder.class) {
                this.Z.setPreviewDisplay(null);
            } else {
                if (this.mPreview.getOutputClass() != android.graphics.SurfaceTexture.class) {
                    throw new java.lang.RuntimeException("Unknown CameraPreview output class.");
                }
                this.Z.setPreviewTexture(null);
            }
        } catch (java.io.IOException e) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onStopBind", "Could not release surface", e);
        }
        return com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public com.google.android.gms.tasks.Task<java.lang.Void> onStopEngine() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onStopEngine:", "About to clean up.");
        getOrchestrator().remove("focus reset");
        getOrchestrator().remove("focus end");
        if (this.Z != null) {
            try {
                cameraLogger.i("onStopEngine:", "Clean up.", "Releasing camera.");
                this.Z.release();
                cameraLogger.i("onStopEngine:", "Clean up.", "Released camera.");
            } catch (java.lang.Exception e) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
            }
            this.Z = null;
            this.mCameraOptions = null;
        }
        this.mVideoRecorder = null;
        this.mCameraOptions = null;
        this.Z = null;
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("onStopEngine:", "Clean up.", "Returning.");
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
        getFrameManager().release();
        cameraLogger.i("onStopPreview:", "Releasing preview buffers.");
        this.Z.setPreviewCallbackWithBuffer(null);
        try {
            cameraLogger.i("onStopPreview:", "Stopping preview.");
            this.Z.stopPreview();
            cameraLogger.i("onStopPreview:", "Stopped preview.");
        } catch (java.lang.Exception e) {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("stopPreview", "Could not stop preview", e);
        }
        return com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakePicture(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, boolean z) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onTakePicture:", "executing.");
        com.otaliastudios.cameraview.engine.offset.Angles angles = getAngles();
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
        com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR);
        stub.size = getPictureSize(reference2);
        com.otaliastudios.cameraview.picture.Full1PictureRecorder full1PictureRecorder = new com.otaliastudios.cameraview.picture.Full1PictureRecorder(stub, this, this.Z);
        this.mPictureRecorder = full1PictureRecorder;
        full1PictureRecorder.take();
        cameraLogger.i("onTakePicture:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakePictureSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio, boolean z) {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("onTakePictureSnapshot:", "executing.");
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.size = getUncroppedSnapshotSize(reference);
        if (this.mPreview instanceof com.otaliastudios.cameraview.preview.RendererCameraPreview) {
            stub.rotation = getAngles().offset(com.otaliastudios.cameraview.engine.offset.Reference.VIEW, reference, com.otaliastudios.cameraview.engine.offset.Axis.ABSOLUTE);
            this.mPictureRecorder = new com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder(stub, this, (com.otaliastudios.cameraview.preview.RendererCameraPreview) this.mPreview, aspectRatio, getOverlay());
        } else {
            stub.rotation = getAngles().offset(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, reference, com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR);
            this.mPictureRecorder = new com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder(stub, this, this.Z, aspectRatio);
        }
        this.mPictureRecorder.take();
        cameraLogger.i("onTakePictureSnapshot:", "executed.");
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    public void onTakeVideo(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
        com.otaliastudios.cameraview.engine.offset.Angles angles = getAngles();
        com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.SENSOR;
        com.otaliastudios.cameraview.engine.offset.Reference reference2 = com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT;
        stub.rotation = angles.offset(reference, reference2, com.otaliastudios.cameraview.engine.offset.Axis.RELATIVE_TO_SENSOR);
        stub.size = getAngles().flip(reference, reference2) ? this.mCaptureSize.flip() : this.mCaptureSize;
        try {
            this.Z.unlock();
            com.otaliastudios.cameraview.video.Full1VideoRecorder full1VideoRecorder = new com.otaliastudios.cameraview.video.Full1VideoRecorder(this, this.Z, this.a0);
            this.mVideoRecorder = full1VideoRecorder;
            full1VideoRecorder.start(stub);
        } catch (java.lang.Exception e) {
            onVideoResult(null, e);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraBaseEngine
    @com.otaliastudios.cameraview.engine.EngineThread
    @android.annotation.SuppressLint({"NewApi"})
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
    public void onVideoResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc) {
        super.onVideoResult(stub, exc);
        if (stub == null) {
            this.Z.lock();
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setExposureCorrection(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z) {
        float f2 = this.mExposureCorrectionValue;
        this.mExposureCorrectionValue = f;
        getOrchestrator().remove("exposure correction");
        this.R = getOrchestrator().scheduleStateful("exposure correction", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass6(f2, z, fArr, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        com.otaliastudios.cameraview.controls.Flash flash2 = this.mFlash;
        this.mFlash = flash;
        this.S = getOrchestrator().scheduleStateful("flash (" + flash + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass1(flash2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setFrameProcessingFormat(int i) {
        this.mFrameProcessingFormat = 17;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHasFrameProcessors(boolean z) {
        this.mHasFrameProcessors = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        com.otaliastudios.cameraview.controls.Hdr hdr2 = this.mHdr;
        this.mHdr = hdr;
        this.U = getOrchestrator().scheduleStateful("hdr (" + hdr + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass4(hdr2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setLocation(@androidx.annotation.Nullable android.location.Location location) {
        android.location.Location location2 = this.mLocation;
        this.mLocation = location;
        this.V = getOrchestrator().scheduleStateful(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass2(location2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPictureFormat(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.PictureFormat pictureFormat) {
        if (pictureFormat == com.otaliastudios.cameraview.controls.PictureFormat.JPEG) {
            this.mPictureFormat = pictureFormat;
            return;
        }
        throw new java.lang.UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPlaySounds(boolean z) {
        boolean z2 = this.mPlaySounds;
        this.mPlaySounds = z;
        this.W = getOrchestrator().scheduleStateful("play sounds (" + z + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass7(z2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setPreviewFrameRate(float f) {
        this.mPreviewFrameRate = f;
        this.X = getOrchestrator().scheduleStateful("preview fps (" + f + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass8(f));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance2 = this.mWhiteBalance;
        this.mWhiteBalance = whiteBalance;
        this.T = getOrchestrator().scheduleStateful("white balance (" + whiteBalance + ")", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass3(whiteBalance2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void setZoom(float f, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr, boolean z) {
        float f2 = this.mZoomValue;
        this.mZoomValue = f;
        getOrchestrator().remove("zoom");
        this.Q = getOrchestrator().scheduleStateful("zoom", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass5(f2, z, pointFArr));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void startAutoFocus(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull com.otaliastudios.cameraview.metering.MeteringRegions meteringRegions, @androidx.annotation.NonNull android.graphics.PointF pointF) {
        getOrchestrator().scheduleStateful("auto focus", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.Camera1Engine.AnonymousClass11(meteringRegions, gesture, pointF));
    }
}

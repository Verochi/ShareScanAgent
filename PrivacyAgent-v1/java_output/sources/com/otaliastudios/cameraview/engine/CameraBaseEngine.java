package com.otaliastudios.cameraview.engine;

/* loaded from: classes19.dex */
public abstract class CameraBaseEngine extends com.otaliastudios.cameraview.engine.CameraEngine {
    public com.otaliastudios.cameraview.size.SizeSelector A;
    public com.otaliastudios.cameraview.size.SizeSelector B;
    public com.otaliastudios.cameraview.controls.Facing C;
    public com.otaliastudios.cameraview.controls.Mode D;
    public com.otaliastudios.cameraview.controls.Audio E;
    public long F;
    public int G;
    public int H;
    public int I;
    public long J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public com.otaliastudios.cameraview.overlay.Overlay P;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> Q;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> R;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> S;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> T;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> U;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> V;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> W;

    @androidx.annotation.VisibleForTesting(otherwise = 4)
    public com.google.android.gms.tasks.Task<java.lang.Void> X;
    protected com.otaliastudios.cameraview.controls.AudioCodec mAudioCodec;
    protected com.otaliastudios.cameraview.CameraOptions mCameraOptions;
    protected com.otaliastudios.cameraview.size.Size mCaptureSize;
    protected float mExposureCorrectionValue;
    protected com.otaliastudios.cameraview.controls.Flash mFlash;
    protected int mFrameProcessingFormat;
    protected com.otaliastudios.cameraview.size.Size mFrameProcessingSize;
    protected boolean mHasFrameProcessors;
    protected com.otaliastudios.cameraview.controls.Hdr mHdr;
    protected android.location.Location mLocation;
    protected com.otaliastudios.cameraview.controls.PictureFormat mPictureFormat;
    protected boolean mPictureMetering;
    protected com.otaliastudios.cameraview.picture.PictureRecorder mPictureRecorder;
    protected boolean mPictureSnapshotMetering;
    protected boolean mPlaySounds;
    protected com.otaliastudios.cameraview.preview.CameraPreview mPreview;
    protected float mPreviewFrameRate;
    protected com.otaliastudios.cameraview.size.Size mPreviewStreamSize;
    protected com.otaliastudios.cameraview.controls.VideoCodec mVideoCodec;
    protected com.otaliastudios.cameraview.video.VideoRecorder mVideoRecorder;
    protected com.otaliastudios.cameraview.controls.WhiteBalance mWhiteBalance;
    protected float mZoomValue;
    public boolean w;
    public com.otaliastudios.cameraview.frame.FrameManager x;
    public final com.otaliastudios.cameraview.engine.offset.Angles y;

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.size.SizeSelector z;

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Facing n;
        public final /* synthetic */ com.otaliastudios.cameraview.controls.Facing t;

        public AnonymousClass1(com.otaliastudios.cameraview.controls.Facing facing, com.otaliastudios.cameraview.controls.Facing facing2) {
            this.n = facing;
            this.t = facing2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.collectCameraInfo(this.n)) {
                com.otaliastudios.cameraview.engine.CameraBaseEngine.this.restart();
            } else {
                com.otaliastudios.cameraview.engine.CameraBaseEngine.this.C = this.t;
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraBaseEngine.this.restart();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.PictureResult.Stub n;
        public final /* synthetic */ boolean t;

        public AnonymousClass3(com.otaliastudios.cameraview.PictureResult.Stub stub, boolean z) {
            this.n = stub;
            this.t = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("takePicture:", "running. isTakingPicture:", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingPicture()));
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingPicture()) {
                return;
            }
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.D == com.otaliastudios.cameraview.controls.Mode.VIDEO) {
                throw new java.lang.IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
            com.otaliastudios.cameraview.PictureResult.Stub stub = this.n;
            stub.isSnapshot = false;
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            stub.location = cameraBaseEngine.mLocation;
            stub.facing = cameraBaseEngine.C;
            com.otaliastudios.cameraview.PictureResult.Stub stub2 = this.n;
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine2 = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            stub2.format = cameraBaseEngine2.mPictureFormat;
            cameraBaseEngine2.onTakePicture(stub2, this.t);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.PictureResult.Stub n;
        public final /* synthetic */ boolean t;

        public AnonymousClass4(com.otaliastudios.cameraview.PictureResult.Stub stub, boolean z) {
            this.n = stub;
            this.t = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("takePictureSnapshot:", "running. isTakingPicture:", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingPicture()));
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingPicture()) {
                return;
            }
            com.otaliastudios.cameraview.PictureResult.Stub stub = this.n;
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            stub.location = cameraBaseEngine.mLocation;
            stub.isSnapshot = true;
            stub.facing = cameraBaseEngine.C;
            this.n.format = com.otaliastudios.cameraview.controls.PictureFormat.JPEG;
            com.otaliastudios.cameraview.engine.CameraBaseEngine.this.onTakePictureSnapshot(this.n, com.otaliastudios.cameraview.size.AspectRatio.of(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.v(com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT)), this.t);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public final /* synthetic */ java.io.File n;
        public final /* synthetic */ com.otaliastudios.cameraview.VideoResult.Stub t;
        public final /* synthetic */ java.io.FileDescriptor u;

        public AnonymousClass5(java.io.File file, com.otaliastudios.cameraview.VideoResult.Stub stub, java.io.FileDescriptor fileDescriptor) {
            this.n = file;
            this.t = stub;
            this.u = fileDescriptor;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("takeVideo:", "running. isTakingVideo:", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingVideo()));
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingVideo()) {
                return;
            }
            if (com.otaliastudios.cameraview.engine.CameraBaseEngine.this.D == com.otaliastudios.cameraview.controls.Mode.PICTURE) {
                throw new java.lang.IllegalStateException("Can't record video while in PICTURE mode");
            }
            java.io.File file = this.n;
            if (file != null) {
                this.t.file = file;
            } else {
                java.io.FileDescriptor fileDescriptor = this.u;
                if (fileDescriptor == null) {
                    throw new java.lang.IllegalStateException("file and fileDescriptor are both null.");
                }
                this.t.fileDescriptor = fileDescriptor;
            }
            com.otaliastudios.cameraview.VideoResult.Stub stub = this.t;
            stub.isSnapshot = false;
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            stub.videoCodec = cameraBaseEngine.mVideoCodec;
            stub.audioCodec = cameraBaseEngine.mAudioCodec;
            stub.location = cameraBaseEngine.mLocation;
            stub.facing = cameraBaseEngine.C;
            this.t.audio = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.E;
            this.t.maxSize = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.F;
            this.t.maxDuration = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.G;
            this.t.videoBitRate = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.H;
            this.t.audioBitRate = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.I;
            com.otaliastudios.cameraview.engine.CameraBaseEngine.this.onTakeVideo(this.t);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public final /* synthetic */ com.otaliastudios.cameraview.VideoResult.Stub n;
        public final /* synthetic */ java.io.File t;

        public AnonymousClass6(com.otaliastudios.cameraview.VideoResult.Stub stub, java.io.File file) {
            this.n = stub;
            this.t = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("takeVideoSnapshot:", "running. isTakingVideo:", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingVideo()));
            com.otaliastudios.cameraview.VideoResult.Stub stub = this.n;
            stub.file = this.t;
            stub.isSnapshot = true;
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            stub.videoCodec = cameraBaseEngine.mVideoCodec;
            stub.audioCodec = cameraBaseEngine.mAudioCodec;
            stub.location = cameraBaseEngine.mLocation;
            stub.facing = cameraBaseEngine.C;
            this.n.videoBitRate = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.H;
            this.n.audioBitRate = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.I;
            this.n.audio = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.E;
            this.n.maxSize = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.F;
            this.n.maxDuration = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.G;
            com.otaliastudios.cameraview.engine.CameraBaseEngine.this.onTakeVideoSnapshot(this.n, com.otaliastudios.cameraview.size.AspectRatio.of(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.v(com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT)));
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("stopVideo", "running. isTakingVideo?", java.lang.Boolean.valueOf(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.isTakingVideo()));
            com.otaliastudios.cameraview.engine.CameraBaseEngine.this.onStopVideo();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraBaseEngine$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.size.Size computePreviewStreamSize = com.otaliastudios.cameraview.engine.CameraBaseEngine.this.computePreviewStreamSize();
            if (computePreviewStreamSize.equals(com.otaliastudios.cameraview.engine.CameraBaseEngine.this.mPreviewStreamSize)) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onSurfaceChanged:", "The computed preview size is identical. No op.");
                return;
            }
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onSurfaceChanged:", "Computed a new preview size. Calling onPreviewStreamSizeChanged().");
            com.otaliastudios.cameraview.engine.CameraBaseEngine cameraBaseEngine = com.otaliastudios.cameraview.engine.CameraBaseEngine.this;
            cameraBaseEngine.mPreviewStreamSize = computePreviewStreamSize;
            cameraBaseEngine.onPreviewStreamSizeChanged();
        }
    }

    public CameraBaseEngine(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine.Callback callback) {
        super(callback);
        this.y = new com.otaliastudios.cameraview.engine.offset.Angles();
        this.Q = com.google.android.gms.tasks.Tasks.forResult(null);
        this.R = com.google.android.gms.tasks.Tasks.forResult(null);
        this.S = com.google.android.gms.tasks.Tasks.forResult(null);
        this.T = com.google.android.gms.tasks.Tasks.forResult(null);
        this.U = com.google.android.gms.tasks.Tasks.forResult(null);
        this.V = com.google.android.gms.tasks.Tasks.forResult(null);
        this.W = com.google.android.gms.tasks.Tasks.forResult(null);
        this.X = com.google.android.gms.tasks.Tasks.forResult(null);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size computeCaptureSize() {
        return computeCaptureSize(this.D);
    }

    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.Size computeCaptureSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Mode mode) {
        com.otaliastudios.cameraview.size.SizeSelector sizeSelector;
        java.util.Collection<com.otaliastudios.cameraview.size.Size> supportedVideoSizes;
        boolean flip = getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        if (mode == com.otaliastudios.cameraview.controls.Mode.PICTURE) {
            sizeSelector = this.A;
            supportedVideoSizes = this.mCameraOptions.getSupportedPictureSizes();
        } else {
            sizeSelector = this.B;
            supportedVideoSizes = this.mCameraOptions.getSupportedVideoSizes();
        }
        com.otaliastudios.cameraview.size.SizeSelector or = com.otaliastudios.cameraview.size.SizeSelectors.or(sizeSelector, com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        java.util.List<com.otaliastudios.cameraview.size.Size> arrayList = new java.util.ArrayList<>(supportedVideoSizes);
        com.otaliastudios.cameraview.size.Size size = or.select(arrayList).get(0);
        if (!arrayList.contains(size)) {
            throw new java.lang.RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("computeCaptureSize:", "result:", size, "flip:", java.lang.Boolean.valueOf(flip), "mode:", mode);
        return flip ? size.flip() : size;
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.otaliastudios.cameraview.size.Size computeFrameProcessingSize() {
        java.util.List<com.otaliastudios.cameraview.size.Size> frameProcessingAvailableSizes = getFrameProcessingAvailableSizes();
        boolean flip = getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        java.util.List<com.otaliastudios.cameraview.size.Size> arrayList = new java.util.ArrayList<>(frameProcessingAvailableSizes.size());
        for (com.otaliastudios.cameraview.size.Size size : frameProcessingAvailableSizes) {
            if (flip) {
                size = size.flip();
            }
            arrayList.add(size);
        }
        com.otaliastudios.cameraview.size.AspectRatio of = com.otaliastudios.cameraview.size.AspectRatio.of(this.mPreviewStreamSize.getWidth(), this.mPreviewStreamSize.getHeight());
        if (flip) {
            of = of.flip();
        }
        int i = this.M;
        int i2 = this.N;
        if (i <= 0 || i == Integer.MAX_VALUE) {
            i = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        }
        if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
            i2 = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH;
        }
        com.otaliastudios.cameraview.size.Size size2 = new com.otaliastudios.cameraview.size.Size(i, i2);
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("computeFrameProcessingSize:", "targetRatio:", of, "targetMaxSize:", size2);
        com.otaliastudios.cameraview.size.SizeSelector aspectRatio = com.otaliastudios.cameraview.size.SizeSelectors.aspectRatio(of, 0.0f);
        com.otaliastudios.cameraview.size.SizeSelector and = com.otaliastudios.cameraview.size.SizeSelectors.and(com.otaliastudios.cameraview.size.SizeSelectors.maxHeight(size2.getHeight()), com.otaliastudios.cameraview.size.SizeSelectors.maxWidth(size2.getWidth()), com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        com.otaliastudios.cameraview.size.Size size3 = com.otaliastudios.cameraview.size.SizeSelectors.or(com.otaliastudios.cameraview.size.SizeSelectors.and(aspectRatio, and), and, com.otaliastudios.cameraview.size.SizeSelectors.smallest()).select(arrayList).get(0);
        if (!arrayList.contains(size3)) {
            throw new java.lang.RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (flip) {
            size3 = size3.flip();
        }
        cameraLogger.i("computeFrameProcessingSize:", "result:", size3, "flip:", java.lang.Boolean.valueOf(flip));
        return size3;
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public final com.otaliastudios.cameraview.size.Size computePreviewStreamSize() {
        java.util.List<com.otaliastudios.cameraview.size.Size> previewStreamAvailableSizes = getPreviewStreamAvailableSizes();
        boolean flip = getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        java.util.List<com.otaliastudios.cameraview.size.Size> arrayList = new java.util.ArrayList<>(previewStreamAvailableSizes.size());
        for (com.otaliastudios.cameraview.size.Size size : previewStreamAvailableSizes) {
            if (flip) {
                size = size.flip();
            }
            arrayList.add(size);
        }
        com.otaliastudios.cameraview.size.Size v = v(com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        if (v == null) {
            throw new java.lang.IllegalStateException("targetMinSize should not be null here.");
        }
        com.otaliastudios.cameraview.size.AspectRatio of = com.otaliastudios.cameraview.size.AspectRatio.of(this.mCaptureSize.getWidth(), this.mCaptureSize.getHeight());
        if (flip) {
            of = of.flip();
        }
        com.otaliastudios.cameraview.CameraLogger cameraLogger = com.otaliastudios.cameraview.engine.CameraEngine.LOG;
        cameraLogger.i("computePreviewStreamSize:", "targetRatio:", of, "targetMinSize:", v);
        com.otaliastudios.cameraview.size.SizeSelector and = com.otaliastudios.cameraview.size.SizeSelectors.and(com.otaliastudios.cameraview.size.SizeSelectors.aspectRatio(of, 0.0f), com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        com.otaliastudios.cameraview.size.SizeSelector and2 = com.otaliastudios.cameraview.size.SizeSelectors.and(com.otaliastudios.cameraview.size.SizeSelectors.minHeight(v.getHeight()), com.otaliastudios.cameraview.size.SizeSelectors.minWidth(v.getWidth()), com.otaliastudios.cameraview.size.SizeSelectors.smallest());
        com.otaliastudios.cameraview.size.SizeSelector or = com.otaliastudios.cameraview.size.SizeSelectors.or(com.otaliastudios.cameraview.size.SizeSelectors.and(and, and2), and2, and, com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        com.otaliastudios.cameraview.size.SizeSelector sizeSelector = this.z;
        if (sizeSelector != null) {
            or = com.otaliastudios.cameraview.size.SizeSelectors.or(sizeSelector, or);
        }
        com.otaliastudios.cameraview.size.Size size2 = or.select(arrayList).get(0);
        if (!arrayList.contains(size2)) {
            throw new java.lang.RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (flip) {
            size2 = size2.flip();
        }
        cameraLogger.i("computePreviewStreamSize:", "result:", size2, "flip:", java.lang.Boolean.valueOf(flip));
        return size2;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.engine.offset.Angles getAngles() {
        return this.y;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.Audio getAudio() {
        return this.E;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getAudioBitRate() {
        return this.I;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.AudioCodec getAudioCodec() {
        return this.mAudioCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long getAutoFocusResetDelay() {
        return this.J;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.CameraOptions getCameraOptions() {
        return this.mCameraOptions;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getExposureCorrectionValue() {
        return this.mExposureCorrectionValue;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.Facing getFacing() {
        return this.C;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.Flash getFlash() {
        return this.mFlash;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.frame.FrameManager getFrameManager() {
        if (this.x == null) {
            this.x = instantiateFrameManager(this.O);
        }
        return this.x;
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract java.util.List<com.otaliastudios.cameraview.size.Size> getFrameProcessingAvailableSizes();

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingFormat() {
        return this.mFrameProcessingFormat;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingMaxHeight() {
        return this.N;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingMaxWidth() {
        return this.M;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getFrameProcessingPoolSize() {
        return this.O;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.Hdr getHdr() {
        return this.mHdr;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final android.location.Location getLocation() {
        return this.mLocation;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.Mode getMode() {
        return this.D;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.overlay.Overlay getOverlay() {
        return this.P;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.PictureFormat getPictureFormat() {
        return this.mPictureFormat;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPictureMetering() {
        return this.mPictureMetering;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.Size getPictureSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference) {
        com.otaliastudios.cameraview.size.Size size = this.mCaptureSize;
        if (size == null || this.D == com.otaliastudios.cameraview.controls.Mode.VIDEO) {
            return null;
        }
        return getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.SizeSelector getPictureSizeSelector() {
        return this.A;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPictureSnapshotMetering() {
        return this.mPictureSnapshotMetering;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.preview.CameraPreview getPreview() {
        return this.mPreview;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getPreviewFrameRate() {
        return this.mPreviewFrameRate;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean getPreviewFrameRateExact() {
        return this.w;
    }

    @androidx.annotation.NonNull
    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract java.util.List<com.otaliastudios.cameraview.size.Size> getPreviewStreamAvailableSizes();

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.Size getPreviewStreamSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference) {
        com.otaliastudios.cameraview.size.Size size = this.mPreviewStreamSize;
        if (size == null) {
            return null;
        }
        return getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.SizeSelector getPreviewStreamSizeSelector() {
        return this.z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getSnapshotMaxHeight() {
        return this.L;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getSnapshotMaxWidth() {
        return this.K;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.Size getUncroppedSnapshotSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference) {
        com.otaliastudios.cameraview.size.Size previewStreamSize = getPreviewStreamSize(reference);
        if (previewStreamSize == null) {
            return null;
        }
        boolean flip = getAngles().flip(reference, com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        int i = flip ? this.L : this.K;
        int i2 = flip ? this.K : this.L;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        if (com.otaliastudios.cameraview.size.AspectRatio.of(i, i2).toFloat() >= com.otaliastudios.cameraview.size.AspectRatio.of(previewStreamSize).toFloat()) {
            return new com.otaliastudios.cameraview.size.Size((int) java.lang.Math.floor(r5 * r2), java.lang.Math.min(previewStreamSize.getHeight(), i2));
        }
        return new com.otaliastudios.cameraview.size.Size(java.lang.Math.min(previewStreamSize.getWidth(), i), (int) java.lang.Math.floor(r5 / r2));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getVideoBitRate() {
        return this.H;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.VideoCodec getVideoCodec() {
        return this.mVideoCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final int getVideoMaxDuration() {
        return this.G;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final long getVideoMaxSize() {
        return this.F;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.Size getVideoSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference) {
        com.otaliastudios.cameraview.size.Size size = this.mCaptureSize;
        if (size == null || this.D == com.otaliastudios.cameraview.controls.Mode.PICTURE) {
            return null;
        }
        return getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.SENSOR, reference) ? size.flip() : size;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.size.SizeSelector getVideoSizeSelector() {
        return this.B;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    @androidx.annotation.NonNull
    public final com.otaliastudios.cameraview.controls.WhiteBalance getWhiteBalance() {
        return this.mWhiteBalance;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final float getZoomValue() {
        return this.mZoomValue;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean hasFrameProcessors() {
        return this.mHasFrameProcessors;
    }

    @androidx.annotation.NonNull
    public abstract com.otaliastudios.cameraview.frame.FrameManager instantiateFrameManager(int i);

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean isTakingPicture() {
        return this.mPictureRecorder != null;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final boolean isTakingVideo() {
        com.otaliastudios.cameraview.video.VideoRecorder videoRecorder = this.mVideoRecorder;
        return videoRecorder != null && videoRecorder.isRecording();
    }

    public void onPictureResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc) {
        this.mPictureRecorder = null;
        if (stub != null) {
            getCallback().dispatchOnPictureTaken(stub);
        } else {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onPictureResult", "result is null: something went wrong.", exc);
            getCallback().dispatchError(new com.otaliastudios.cameraview.CameraException(exc, 4));
        }
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder.PictureResultListener
    public void onPictureShutter(boolean z) {
        getCallback().onShutter(!z);
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract void onPreviewStreamSizeChanged();

    @com.otaliastudios.cameraview.engine.EngineThread
    public void onStopVideo() {
        com.otaliastudios.cameraview.video.VideoRecorder videoRecorder = this.mVideoRecorder;
        if (videoRecorder != null) {
            videoRecorder.stop(false);
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void onSurfaceChanged() {
        com.otaliastudios.cameraview.engine.CameraEngine.LOG.i("onSurfaceChanged:", "Size is", v(com.otaliastudios.cameraview.engine.offset.Reference.VIEW));
        getOrchestrator().scheduleStateful("surface changed", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass8());
    }

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract void onTakePicture(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, boolean z);

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract void onTakePictureSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio, boolean z);

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract void onTakeVideo(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub);

    @com.otaliastudios.cameraview.engine.EngineThread
    public abstract void onTakeVideoSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull com.otaliastudios.cameraview.size.AspectRatio aspectRatio);

    public void onVideoRecordingEnd() {
        getCallback().dispatchOnVideoRecordingEnd();
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder.VideoResultListener
    public void onVideoRecordingStart() {
        getCallback().dispatchOnVideoRecordingStart();
    }

    @androidx.annotation.CallSuper
    public void onVideoResult(@androidx.annotation.Nullable com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.lang.Exception exc) {
        this.mVideoRecorder = null;
        if (stub != null) {
            getCallback().dispatchOnVideoTaken(stub);
        } else {
            com.otaliastudios.cameraview.engine.CameraEngine.LOG.e("onVideoResult", "result is null: something went wrong.", exc);
            getCallback().dispatchError(new com.otaliastudios.cameraview.CameraException(exc, 5));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudio(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Audio audio) {
        if (this.E != audio) {
            if (isTakingVideo()) {
                com.otaliastudios.cameraview.engine.CameraEngine.LOG.w("Audio setting was changed while recording. Changes will take place starting from next video");
            }
            this.E = audio;
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudioBitRate(int i) {
        this.I = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAudioCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.AudioCodec audioCodec) {
        this.mAudioCodec = audioCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setAutoFocusResetDelay(long j) {
        this.J = j;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFacing(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        com.otaliastudios.cameraview.controls.Facing facing2 = this.C;
        if (facing != facing2) {
            this.C = facing;
            getOrchestrator().scheduleStateful("facing", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass1(facing, facing2));
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingMaxHeight(int i) {
        this.N = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingMaxWidth(int i) {
        this.M = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setFrameProcessingPoolSize(int i) {
        this.O = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setMode(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Mode mode) {
        if (mode != this.D) {
            this.D = mode;
            getOrchestrator().scheduleStateful("mode", com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass2());
        }
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setOverlay(@androidx.annotation.Nullable com.otaliastudios.cameraview.overlay.Overlay overlay) {
        this.P = overlay;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureMetering(boolean z) {
        this.mPictureMetering = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureSizeSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.A = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPictureSnapshotMetering(boolean z) {
        this.mPictureSnapshotMetering = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreview(@androidx.annotation.NonNull com.otaliastudios.cameraview.preview.CameraPreview cameraPreview) {
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview2 = this.mPreview;
        if (cameraPreview2 != null) {
            cameraPreview2.setSurfaceCallback(null);
        }
        this.mPreview = cameraPreview;
        cameraPreview.setSurfaceCallback(this);
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreviewFrameRateExact(boolean z) {
        this.w = z;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setPreviewStreamSizeSelector(@androidx.annotation.Nullable com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.z = sizeSelector;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setSnapshotMaxHeight(int i) {
        this.L = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setSnapshotMaxWidth(int i) {
        this.K = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoBitRate(int i) {
        this.H = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.VideoCodec videoCodec) {
        this.mVideoCodec = videoCodec;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoMaxDuration(int i) {
        this.G = i;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoMaxSize(long j) {
        this.F = j;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void setVideoSizeSelector(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.B = sizeSelector;
    }

    public final boolean shouldResetAutoFocus() {
        long j = this.J;
        return j > 0 && j != Long.MAX_VALUE;
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void stopVideo() {
        getOrchestrator().schedule("stop video", true, (java.lang.Runnable) new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass7());
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void takePicture(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub) {
        getOrchestrator().scheduleStateful("take picture", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass3(stub, this.mPictureMetering));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public void takePictureSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub) {
        getOrchestrator().scheduleStateful("take picture snapshot", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass4(stub, this.mPictureSnapshotMetering));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void takeVideo(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor) {
        getOrchestrator().scheduleStateful("take video", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass5(file, stub, fileDescriptor));
    }

    @Override // com.otaliastudios.cameraview.engine.CameraEngine
    public final void takeVideoSnapshot(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub, @androidx.annotation.NonNull java.io.File file) {
        getOrchestrator().scheduleStateful("take video snapshot", com.otaliastudios.cameraview.engine.orchestrator.CameraState.BIND, new com.otaliastudios.cameraview.engine.CameraBaseEngine.AnonymousClass6(stub, file));
    }

    @androidx.annotation.Nullable
    public final com.otaliastudios.cameraview.size.Size v(@androidx.annotation.NonNull com.otaliastudios.cameraview.engine.offset.Reference reference) {
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview = this.mPreview;
        if (cameraPreview == null) {
            return null;
        }
        return getAngles().flip(com.otaliastudios.cameraview.engine.offset.Reference.VIEW, reference) ? cameraPreview.getSurfaceSize().flip() : cameraPreview.getSurfaceSize();
    }
}

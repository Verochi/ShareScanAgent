package com.otaliastudios.cameraview;

/* loaded from: classes19.dex */
public class CameraView extends android.widget.FrameLayout implements androidx.lifecycle.LifecycleObserver {
    public static final int PERMISSION_REQUEST_CODE = 16;
    public static final com.otaliastudios.cameraview.CameraLogger V = com.otaliastudios.cameraview.CameraLogger.create(com.otaliastudios.cameraview.CameraView.class.getSimpleName());
    public android.os.Handler A;
    public java.util.concurrent.Executor B;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.CameraView.CameraCallbacks C;
    public com.otaliastudios.cameraview.preview.CameraPreview D;
    public com.otaliastudios.cameraview.internal.OrientationHelper E;
    public com.otaliastudios.cameraview.engine.CameraEngine F;
    public com.otaliastudios.cameraview.size.Size G;
    public android.media.MediaActionSound H;
    public com.otaliastudios.cameraview.markers.AutoFocusMarker I;

    @androidx.annotation.VisibleForTesting
    public java.util.List<com.otaliastudios.cameraview.CameraListener> J;

    @androidx.annotation.VisibleForTesting
    public java.util.List<com.otaliastudios.cameraview.frame.FrameProcessor> K;
    public androidx.lifecycle.Lifecycle L;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.gesture.PinchGestureFinder M;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.gesture.TapGestureFinder N;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.gesture.ScrollGestureFinder O;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.internal.GridLinesLayout P;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.markers.MarkerLayout Q;
    public boolean R;
    public boolean S;
    public boolean T;

    @androidx.annotation.VisibleForTesting
    public com.otaliastudios.cameraview.overlay.OverlayLayout U;
    public boolean n;
    public boolean t;
    public boolean u;
    public java.util.HashMap<com.otaliastudios.cameraview.gesture.Gesture, com.otaliastudios.cameraview.gesture.GestureAction> v;
    public com.otaliastudios.cameraview.controls.Preview w;
    public com.otaliastudios.cameraview.controls.Engine x;
    public com.otaliastudios.cameraview.filter.Filter y;
    public int z;

    /* renamed from: com.otaliastudios.cameraview.CameraView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.CameraView cameraView = com.otaliastudios.cameraview.CameraView.this;
            cameraView.R = cameraView.getKeepScreenOn();
            if (com.otaliastudios.cameraview.CameraView.this.R) {
                return;
            }
            com.otaliastudios.cameraview.CameraView.this.setKeepScreenOn(true);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.CameraView cameraView = com.otaliastudios.cameraview.CameraView.this;
            cameraView.R = cameraView.getKeepScreenOn();
            if (com.otaliastudios.cameraview.CameraView.this.R) {
                return;
            }
            com.otaliastudios.cameraview.CameraView.this.setKeepScreenOn(true);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.otaliastudios.cameraview.CameraListener {
        public final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraException cameraException) {
            super.onCameraError(cameraException);
            if (cameraException.getReason() == 5) {
                com.otaliastudios.cameraview.CameraView.this.setVideoMaxDuration(this.a);
                com.otaliastudios.cameraview.CameraView.this.removeCameraListener(this);
            }
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult videoResult) {
            com.otaliastudios.cameraview.CameraView.this.setVideoMaxDuration(this.a);
            com.otaliastudios.cameraview.CameraView.this.removeCameraListener(this);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.otaliastudios.cameraview.CameraListener {
        public final /* synthetic */ int a;

        public AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraException cameraException) {
            super.onCameraError(cameraException);
            if (cameraException.getReason() == 5) {
                com.otaliastudios.cameraview.CameraView.this.setVideoMaxDuration(this.a);
                com.otaliastudios.cameraview.CameraView.this.removeCameraListener(this);
            }
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult videoResult) {
            com.otaliastudios.cameraview.CameraView.this.setVideoMaxDuration(this.a);
            com.otaliastudios.cameraview.CameraView.this.removeCameraListener(this);
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.otaliastudios.cameraview.CameraView.this.getKeepScreenOn() != com.otaliastudios.cameraview.CameraView.this.R) {
                com.otaliastudios.cameraview.CameraView cameraView = com.otaliastudios.cameraview.CameraView.this;
                cameraView.setKeepScreenOn(cameraView.R);
            }
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$6, reason: invalid class name */
    public class AnonymousClass6 implements java.util.concurrent.ThreadFactory {
        public final java.util.concurrent.atomic.AtomicInteger n = new java.util.concurrent.atomic.AtomicInteger(1);

        public AnonymousClass6() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(@androidx.annotation.NonNull java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "FrameExecutor #" + this.n.getAndIncrement());
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[com.otaliastudios.cameraview.controls.Facing.values().length];
            d = iArr;
            try {
                iArr[com.otaliastudios.cameraview.controls.Facing.BACK.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                d[com.otaliastudios.cameraview.controls.Facing.FRONT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.otaliastudios.cameraview.gesture.GestureAction.values().length];
            c = iArr2;
            try {
                iArr2[com.otaliastudios.cameraview.gesture.GestureAction.TAKE_PICTURE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                c[com.otaliastudios.cameraview.gesture.GestureAction.AUTO_FOCUS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                c[com.otaliastudios.cameraview.gesture.GestureAction.ZOOM.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                c[com.otaliastudios.cameraview.gesture.GestureAction.EXPOSURE_CORRECTION.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                c[com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_1.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                c[com.otaliastudios.cameraview.gesture.GestureAction.FILTER_CONTROL_2.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[com.otaliastudios.cameraview.gesture.Gesture.values().length];
            b = iArr3;
            try {
                iArr3[com.otaliastudios.cameraview.gesture.Gesture.PINCH.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                b[com.otaliastudios.cameraview.gesture.Gesture.TAP.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                b[com.otaliastudios.cameraview.gesture.Gesture.LONG_TAP.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                b[com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                b[com.otaliastudios.cameraview.gesture.Gesture.SCROLL_VERTICAL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            int[] iArr4 = new int[com.otaliastudios.cameraview.controls.Preview.values().length];
            a = iArr4;
            try {
                iArr4[com.otaliastudios.cameraview.controls.Preview.SURFACE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Preview.TEXTURE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                a[com.otaliastudios.cameraview.controls.Preview.GL_SURFACE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
        }
    }

    @androidx.annotation.VisibleForTesting
    public class CameraCallbacks implements com.otaliastudios.cameraview.engine.CameraEngine.Callback, com.otaliastudios.cameraview.internal.OrientationHelper.Callback, com.otaliastudios.cameraview.gesture.GestureFinder.Controller {
        public final java.lang.String a;
        public final com.otaliastudios.cameraview.CameraLogger b;

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ com.otaliastudios.cameraview.CameraOptions n;

            public AnonymousClass1(com.otaliastudios.cameraview.CameraOptions cameraOptions) {
                this.n = cameraOptions;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onCameraOpened(this.n);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$10, reason: invalid class name */
        public class AnonymousClass10 implements java.lang.Runnable {
            public final /* synthetic */ float n;
            public final /* synthetic */ float[] t;
            public final /* synthetic */ android.graphics.PointF[] u;

            public AnonymousClass10(float f, float[] fArr, android.graphics.PointF[] pointFArr) {
                this.n = f;
                this.t = fArr;
                this.u = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onExposureCorrectionChanged(this.n, this.t, this.u);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$11, reason: invalid class name */
        public class AnonymousClass11 implements java.lang.Runnable {
            public final /* synthetic */ com.otaliastudios.cameraview.frame.Frame n;

            public AnonymousClass11(com.otaliastudios.cameraview.frame.Frame frame) {
                this.n = frame;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.CameraView.CameraCallbacks.this.b.v("dispatchFrame: executing. Passing", java.lang.Long.valueOf(this.n.getTime()), "to processors.");
                java.util.Iterator<com.otaliastudios.cameraview.frame.FrameProcessor> it = com.otaliastudios.cameraview.CameraView.this.K.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().process(this.n);
                    } catch (java.lang.Exception e) {
                        com.otaliastudios.cameraview.CameraView.CameraCallbacks.this.b.w("Frame processor crashed:", e);
                    }
                }
                this.n.release();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$12, reason: invalid class name */
        public class AnonymousClass12 implements java.lang.Runnable {
            public final /* synthetic */ com.otaliastudios.cameraview.CameraException n;

            public AnonymousClass12(com.otaliastudios.cameraview.CameraException cameraException) {
                this.n = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onCameraError(this.n);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$13, reason: invalid class name */
        public class AnonymousClass13 implements java.lang.Runnable {
            public AnonymousClass13() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onVideoRecordingStart();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$14, reason: invalid class name */
        public class AnonymousClass14 implements java.lang.Runnable {
            public AnonymousClass14() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onVideoRecordingEnd();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onCameraClosed();
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            public AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.CameraView.this.requestLayout();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            public final /* synthetic */ com.otaliastudios.cameraview.PictureResult.Stub n;

            public AnonymousClass4(com.otaliastudios.cameraview.PictureResult.Stub stub) {
                this.n = stub;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.PictureResult pictureResult = new com.otaliastudios.cameraview.PictureResult(this.n);
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onPictureTaken(pictureResult);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            public final /* synthetic */ com.otaliastudios.cameraview.VideoResult.Stub n;

            public AnonymousClass5(com.otaliastudios.cameraview.VideoResult.Stub stub) {
                this.n = stub;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.VideoResult videoResult = new com.otaliastudios.cameraview.VideoResult(this.n);
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onVideoTaken(videoResult);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            public final /* synthetic */ android.graphics.PointF n;
            public final /* synthetic */ com.otaliastudios.cameraview.gesture.Gesture t;

            public AnonymousClass6(android.graphics.PointF pointF, com.otaliastudios.cameraview.gesture.Gesture gesture) {
                this.n = pointF;
                this.t = gesture;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.otaliastudios.cameraview.CameraView.this.Q.onEvent(1, new android.graphics.PointF[]{this.n});
                if (com.otaliastudios.cameraview.CameraView.this.I != null) {
                    com.otaliastudios.cameraview.CameraView.this.I.onAutoFocusStart(this.t != null ? com.otaliastudios.cameraview.markers.AutoFocusTrigger.GESTURE : com.otaliastudios.cameraview.markers.AutoFocusTrigger.METHOD, this.n);
                }
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onAutoFocusStart(this.n);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            public final /* synthetic */ boolean n;
            public final /* synthetic */ com.otaliastudios.cameraview.gesture.Gesture t;
            public final /* synthetic */ android.graphics.PointF u;

            public AnonymousClass7(boolean z, com.otaliastudios.cameraview.gesture.Gesture gesture, android.graphics.PointF pointF) {
                this.n = z;
                this.t = gesture;
                this.u = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.n && com.otaliastudios.cameraview.CameraView.this.n) {
                    com.otaliastudios.cameraview.CameraView.this.t(1);
                }
                if (com.otaliastudios.cameraview.CameraView.this.I != null) {
                    com.otaliastudios.cameraview.CameraView.this.I.onAutoFocusEnd(this.t != null ? com.otaliastudios.cameraview.markers.AutoFocusTrigger.GESTURE : com.otaliastudios.cameraview.markers.AutoFocusTrigger.METHOD, this.n, this.u);
                }
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onAutoFocusEnd(this.n, this.u);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$8, reason: invalid class name */
        public class AnonymousClass8 implements java.lang.Runnable {
            public final /* synthetic */ int n;

            public AnonymousClass8(int i) {
                this.n = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onOrientationChanged(this.n);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$CameraCallbacks$9, reason: invalid class name */
        public class AnonymousClass9 implements java.lang.Runnable {
            public final /* synthetic */ float n;
            public final /* synthetic */ android.graphics.PointF[] t;

            public AnonymousClass9(float f, android.graphics.PointF[] pointFArr) {
                this.n = f;
                this.t = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<com.otaliastudios.cameraview.CameraListener> it = com.otaliastudios.cameraview.CameraView.this.J.iterator();
                while (it.hasNext()) {
                    it.next().onZoomChanged(this.n, new float[]{0.0f, 1.0f}, this.t);
                }
            }
        }

        public CameraCallbacks() {
            java.lang.String simpleName = com.otaliastudios.cameraview.CameraView.CameraCallbacks.class.getSimpleName();
            this.a = simpleName;
            this.b = com.otaliastudios.cameraview.CameraLogger.create(simpleName);
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchError(com.otaliastudios.cameraview.CameraException cameraException) {
            this.b.i("dispatchError", cameraException);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass12(cameraException));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchFrame(@androidx.annotation.NonNull com.otaliastudios.cameraview.frame.Frame frame) {
            this.b.v("dispatchFrame:", java.lang.Long.valueOf(frame.getTime()), "processors:", java.lang.Integer.valueOf(com.otaliastudios.cameraview.CameraView.this.K.size()));
            if (com.otaliastudios.cameraview.CameraView.this.K.isEmpty()) {
                frame.release();
            } else {
                com.otaliastudios.cameraview.CameraView.this.B.execute(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass11(frame));
            }
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnCameraClosed() {
            this.b.i("dispatchOnCameraClosed");
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass2());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnCameraOpened(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraOptions cameraOptions) {
            this.b.i("dispatchOnCameraOpened", cameraOptions);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass1(cameraOptions));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnExposureCorrectionChanged(float f, @androidx.annotation.NonNull float[] fArr, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr) {
            this.b.i("dispatchOnExposureCorrectionChanged", java.lang.Float.valueOf(f));
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass10(f, fArr, pointFArr));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnFocusEnd(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, boolean z, @androidx.annotation.NonNull android.graphics.PointF pointF) {
            this.b.i("dispatchOnFocusEnd", gesture, java.lang.Boolean.valueOf(z), pointF);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass7(z, gesture, pointF));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnFocusStart(@androidx.annotation.Nullable com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull android.graphics.PointF pointF) {
            this.b.i("dispatchOnFocusStart", gesture, pointF);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass6(pointF, gesture));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnPictureTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult.Stub stub) {
            this.b.i("dispatchOnPictureTaken", stub);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass4(stub));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoRecordingEnd() {
            this.b.i("dispatchOnVideoRecordingEnd");
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass14());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoRecordingStart() {
            this.b.i("dispatchOnVideoRecordingStart");
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass13());
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult.Stub stub) {
            this.b.i("dispatchOnVideoTaken", stub);
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass5(stub));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void dispatchOnZoomChanged(float f, @androidx.annotation.Nullable android.graphics.PointF[] pointFArr) {
            this.b.i("dispatchOnZoomChanged", java.lang.Float.valueOf(f));
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass9(f, pointFArr));
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback, com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        @androidx.annotation.NonNull
        public android.content.Context getContext() {
            return com.otaliastudios.cameraview.CameraView.this.getContext();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public int getHeight() {
            return com.otaliastudios.cameraview.CameraView.this.getHeight();
        }

        @Override // com.otaliastudios.cameraview.gesture.GestureFinder.Controller
        public int getWidth() {
            return com.otaliastudios.cameraview.CameraView.this.getWidth();
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void onCameraPreviewStreamSizeChanged() {
            com.otaliastudios.cameraview.size.Size previewStreamSize = com.otaliastudios.cameraview.CameraView.this.F.getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
            if (previewStreamSize == null) {
                throw new java.lang.RuntimeException("Preview stream size should not be null here.");
            }
            if (previewStreamSize.equals(com.otaliastudios.cameraview.CameraView.this.G)) {
                this.b.i("onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", previewStreamSize);
            } else {
                this.b.i("onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", previewStreamSize);
                com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass3());
            }
        }

        @Override // com.otaliastudios.cameraview.internal.OrientationHelper.Callback
        public void onDeviceOrientationChanged(int i) {
            this.b.i("onDeviceOrientationChanged", java.lang.Integer.valueOf(i));
            int lastDisplayOffset = com.otaliastudios.cameraview.CameraView.this.E.getLastDisplayOffset();
            if (com.otaliastudios.cameraview.CameraView.this.t) {
                com.otaliastudios.cameraview.CameraView.this.F.getAngles().setDeviceOrientation(i);
            } else {
                com.otaliastudios.cameraview.CameraView.this.F.getAngles().setDeviceOrientation((360 - lastDisplayOffset) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE);
            }
            com.otaliastudios.cameraview.CameraView.this.A.post(new com.otaliastudios.cameraview.CameraView.CameraCallbacks.AnonymousClass8((i + lastDisplayOffset) % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE));
        }

        @Override // com.otaliastudios.cameraview.internal.OrientationHelper.Callback
        public void onDisplayOffsetChanged(int i, boolean z) {
            this.b.i("onDisplayOffsetChanged", java.lang.Integer.valueOf(i), "recreate:", java.lang.Boolean.valueOf(z));
            if (!com.otaliastudios.cameraview.CameraView.this.isOpened() || z) {
                return;
            }
            this.b.w("onDisplayOffsetChanged", "restarting the camera.");
            com.otaliastudios.cameraview.CameraView.this.close();
            com.otaliastudios.cameraview.CameraView.this.open();
        }

        @Override // com.otaliastudios.cameraview.engine.CameraEngine.Callback
        public void onShutter(boolean z) {
            if (z && com.otaliastudios.cameraview.CameraView.this.n) {
                com.otaliastudios.cameraview.CameraView.this.t(0);
            }
        }
    }

    public CameraView(@androidx.annotation.NonNull android.content.Context context) {
        super(context, null);
        this.v = new java.util.HashMap<>(4);
        this.J = new java.util.concurrent.CopyOnWriteArrayList();
        this.K = new java.util.concurrent.CopyOnWriteArrayList();
        p(context, null);
    }

    public CameraView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.v = new java.util.HashMap<>(4);
        this.J = new java.util.concurrent.CopyOnWriteArrayList();
        this.K = new java.util.concurrent.CopyOnWriteArrayList();
        p(context, attributeSet);
    }

    @android.annotation.TargetApi(23)
    private void requestPermissions(boolean z, boolean z2) {
        android.app.Activity activity = null;
        for (android.content.Context context = getContext(); context instanceof android.content.ContextWrapper; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof android.app.Activity) {
                activity = (android.app.Activity) context;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (z) {
            arrayList.add("android.permission.CAMERA");
        }
        if (z2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (activity != null) {
            activity.requestPermissions((java.lang.String[]) arrayList.toArray(new java.lang.String[0]), 16);
        }
    }

    public void addCameraListener(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraListener cameraListener) {
        this.J.add(cameraListener);
    }

    public void addFrameProcessor(@androidx.annotation.Nullable com.otaliastudios.cameraview.frame.FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.K.add(frameProcessor);
            if (this.K.size() == 1) {
                this.F.setHasFrameProcessors(true);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.T || !this.U.isOverlay(layoutParams)) {
            super.addView(view, i, layoutParams);
        } else {
            this.U.addView(view, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkPermissions(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Audio audio) {
        int checkSelfPermission;
        boolean z;
        int checkSelfPermission2;
        l(audio);
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return true;
        }
        android.content.Context context = getContext();
        boolean z2 = audio == com.otaliastudios.cameraview.controls.Audio.ON || audio == com.otaliastudios.cameraview.controls.Audio.MONO || audio == com.otaliastudios.cameraview.controls.Audio.STEREO;
        checkSelfPermission = context.checkSelfPermission("android.permission.CAMERA");
        boolean z3 = checkSelfPermission != 0;
        if (z2) {
            checkSelfPermission2 = context.checkSelfPermission("android.permission.RECORD_AUDIO");
            if (checkSelfPermission2 != 0) {
                z = true;
                if (z3 && !z) {
                    return true;
                }
                if (this.u) {
                    requestPermissions(z3, z);
                }
                return false;
            }
        }
        z = false;
        if (z3) {
        }
        if (this.u) {
        }
        return false;
    }

    public void clearCameraListeners() {
        this.J.clear();
    }

    public void clearFrameProcessors() {
        boolean z = this.K.size() > 0;
        this.K.clear();
        if (z) {
            this.F.setHasFrameProcessors(false);
        }
    }

    public void clearGesture(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.Gesture gesture) {
        mapGesture(gesture, com.otaliastudios.cameraview.gesture.GestureAction.NONE);
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.T) {
            return;
        }
        this.E.disable();
        this.F.stop(false);
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview = this.D;
        if (cameraPreview != null) {
            cameraPreview.onPause();
        }
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.T) {
            return;
        }
        clearCameraListeners();
        clearFrameProcessors();
        this.F.destroy(true);
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview = this.D;
        if (cameraPreview != null) {
            cameraPreview.onDestroy();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public android.widget.FrameLayout.LayoutParams generateLayoutParams(android.util.AttributeSet attributeSet) {
        return (this.T || !this.U.isOverlay(attributeSet)) ? super.generateLayoutParams(attributeSet) : this.U.generateLayoutParams(attributeSet);
    }

    @androidx.annotation.NonNull
    public <T extends com.otaliastudios.cameraview.controls.Control> T get(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        if (cls == com.otaliastudios.cameraview.controls.Audio.class) {
            return getAudio();
        }
        if (cls == com.otaliastudios.cameraview.controls.Facing.class) {
            return getFacing();
        }
        if (cls == com.otaliastudios.cameraview.controls.Flash.class) {
            return getFlash();
        }
        if (cls == com.otaliastudios.cameraview.controls.Grid.class) {
            return getGrid();
        }
        if (cls == com.otaliastudios.cameraview.controls.Hdr.class) {
            return getHdr();
        }
        if (cls == com.otaliastudios.cameraview.controls.Mode.class) {
            return getMode();
        }
        if (cls == com.otaliastudios.cameraview.controls.WhiteBalance.class) {
            return getWhiteBalance();
        }
        if (cls == com.otaliastudios.cameraview.controls.VideoCodec.class) {
            return getVideoCodec();
        }
        if (cls == com.otaliastudios.cameraview.controls.AudioCodec.class) {
            return getAudioCodec();
        }
        if (cls == com.otaliastudios.cameraview.controls.Preview.class) {
            return getPreview();
        }
        if (cls == com.otaliastudios.cameraview.controls.Engine.class) {
            return getEngine();
        }
        if (cls == com.otaliastudios.cameraview.controls.PictureFormat.class) {
            return getPictureFormat();
        }
        throw new java.lang.IllegalArgumentException("Unknown control class: " + cls);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Audio getAudio() {
        return this.F.getAudio();
    }

    public int getAudioBitRate() {
        return this.F.getAudioBitRate();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.AudioCodec getAudioCodec() {
        return this.F.getAudioCodec();
    }

    public long getAutoFocusResetDelay() {
        return this.F.getAutoFocusResetDelay();
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.CameraOptions getCameraOptions() {
        return this.F.getCameraOptions();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Engine getEngine() {
        return this.x;
    }

    public float getExposureCorrection() {
        return this.F.getExposureCorrectionValue();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Facing getFacing() {
        return this.F.getFacing();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.filter.Filter getFilter() {
        java.lang.Object obj = this.D;
        if (obj == null) {
            return this.y;
        }
        if (obj instanceof com.otaliastudios.cameraview.preview.FilterCameraPreview) {
            return ((com.otaliastudios.cameraview.preview.FilterCameraPreview) obj).getCurrentFilter();
        }
        throw new java.lang.RuntimeException("Filters are only supported by the GL_SURFACE preview. Current:" + this.w);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Flash getFlash() {
        return this.F.getFlash();
    }

    public int getFrameProcessingExecutors() {
        return this.z;
    }

    public int getFrameProcessingFormat() {
        return this.F.getFrameProcessingFormat();
    }

    public int getFrameProcessingMaxHeight() {
        return this.F.getFrameProcessingMaxHeight();
    }

    public int getFrameProcessingMaxWidth() {
        return this.F.getFrameProcessingMaxWidth();
    }

    public int getFrameProcessingPoolSize() {
        return this.F.getFrameProcessingPoolSize();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.gesture.GestureAction getGestureAction(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.Gesture gesture) {
        return this.v.get(gesture);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Grid getGrid() {
        return this.P.getGridMode();
    }

    public int getGridColor() {
        return this.P.getGridColor();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Hdr getHdr() {
        return this.F.getHdr();
    }

    @androidx.annotation.Nullable
    public android.location.Location getLocation() {
        return this.F.getLocation();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Mode getMode() {
        return this.F.getMode();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.PictureFormat getPictureFormat() {
        return this.F.getPictureFormat();
    }

    public boolean getPictureMetering() {
        return this.F.getPictureMetering();
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.size.Size getPictureSize() {
        return this.F.getPictureSize(com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.F.getPictureSnapshotMetering();
    }

    public boolean getPlaySounds() {
        return this.n;
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.Preview getPreview() {
        return this.w;
    }

    public float getPreviewFrameRate() {
        return this.F.getPreviewFrameRate();
    }

    public boolean getPreviewFrameRateExact() {
        return this.F.getPreviewFrameRateExact();
    }

    public int getSnapshotMaxHeight() {
        return this.F.getSnapshotMaxHeight();
    }

    public int getSnapshotMaxWidth() {
        return this.F.getSnapshotMaxWidth();
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.size.Size getSnapshotSize() {
        com.otaliastudios.cameraview.size.Size size = null;
        if (getWidth() != 0 && getHeight() != 0) {
            com.otaliastudios.cameraview.engine.CameraEngine cameraEngine = this.F;
            com.otaliastudios.cameraview.engine.offset.Reference reference = com.otaliastudios.cameraview.engine.offset.Reference.VIEW;
            com.otaliastudios.cameraview.size.Size uncroppedSnapshotSize = cameraEngine.getUncroppedSnapshotSize(reference);
            if (uncroppedSnapshotSize == null) {
                return null;
            }
            android.graphics.Rect computeCrop = com.otaliastudios.cameraview.internal.CropHelper.computeCrop(uncroppedSnapshotSize, com.otaliastudios.cameraview.size.AspectRatio.of(getWidth(), getHeight()));
            size = new com.otaliastudios.cameraview.size.Size(computeCrop.width(), computeCrop.height());
            if (this.F.getAngles().flip(reference, com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT)) {
                return size.flip();
            }
        }
        return size;
    }

    public boolean getUseDeviceOrientation() {
        return this.t;
    }

    public int getVideoBitRate() {
        return this.F.getVideoBitRate();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.VideoCodec getVideoCodec() {
        return this.F.getVideoCodec();
    }

    public int getVideoMaxDuration() {
        return this.F.getVideoMaxDuration();
    }

    public long getVideoMaxSize() {
        return this.F.getVideoMaxSize();
    }

    @androidx.annotation.Nullable
    public com.otaliastudios.cameraview.size.Size getVideoSize() {
        return this.F.getVideoSize(com.otaliastudios.cameraview.engine.offset.Reference.OUTPUT);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.controls.WhiteBalance getWhiteBalance() {
        return this.F.getWhiteBalance();
    }

    public float getZoom() {
        return this.F.getZoomValue();
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.engine.CameraEngine instantiateCameraEngine(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Engine engine, @androidx.annotation.NonNull com.otaliastudios.cameraview.engine.CameraEngine.Callback callback) {
        if (this.S && engine == com.otaliastudios.cameraview.controls.Engine.CAMERA2) {
            return new com.otaliastudios.cameraview.engine.Camera2Engine(callback);
        }
        this.x = com.otaliastudios.cameraview.controls.Engine.CAMERA1;
        return new com.otaliastudios.cameraview.engine.Camera1Engine(callback);
    }

    @androidx.annotation.NonNull
    public com.otaliastudios.cameraview.preview.CameraPreview instantiatePreview(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Preview preview, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        int i = com.otaliastudios.cameraview.CameraView.AnonymousClass7.a[preview.ordinal()];
        if (i == 1) {
            return new com.otaliastudios.cameraview.preview.SurfaceCameraPreview(context, viewGroup);
        }
        if (i == 2 && isHardwareAccelerated()) {
            return new com.otaliastudios.cameraview.preview.TextureCameraPreview(context, viewGroup);
        }
        this.w = com.otaliastudios.cameraview.controls.Preview.GL_SURFACE;
        return new com.otaliastudios.cameraview.preview.GlCameraPreview(context, viewGroup);
    }

    public boolean isOpened() {
        com.otaliastudios.cameraview.engine.orchestrator.CameraState state = this.F.getState();
        com.otaliastudios.cameraview.engine.orchestrator.CameraState cameraState = com.otaliastudios.cameraview.engine.orchestrator.CameraState.ENGINE;
        return state.isAtLeast(cameraState) && this.F.getTargetState().isAtLeast(cameraState);
    }

    public boolean isTakingPicture() {
        return this.F.isTakingPicture();
    }

    public boolean isTakingVideo() {
        return this.F.isTakingVideo();
    }

    public final void l(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Audio audio) {
        if (audio == com.otaliastudios.cameraview.controls.Audio.ON || audio == com.otaliastudios.cameraview.controls.Audio.MONO || audio == com.otaliastudios.cameraview.controls.Audio.STEREO) {
            try {
                for (java.lang.String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        return;
                    }
                }
                throw new java.lang.IllegalStateException(V.e("Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
        }
    }

    public final void m() {
        androidx.lifecycle.Lifecycle lifecycle = this.L;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
            this.L = null;
        }
    }

    public boolean mapGesture(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.Gesture gesture, @androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureAction gestureAction) {
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction2 = com.otaliastudios.cameraview.gesture.GestureAction.NONE;
        if (!gesture.isAssignableTo(gestureAction)) {
            mapGesture(gesture, gestureAction2);
            return false;
        }
        this.v.put(gesture, gestureAction);
        int i = com.otaliastudios.cameraview.CameraView.AnonymousClass7.b[gesture.ordinal()];
        if (i == 1) {
            this.M.setActive(this.v.get(com.otaliastudios.cameraview.gesture.Gesture.PINCH) != gestureAction2);
        } else if (i == 2 || i == 3) {
            this.N.setActive((this.v.get(com.otaliastudios.cameraview.gesture.Gesture.TAP) == gestureAction2 && this.v.get(com.otaliastudios.cameraview.gesture.Gesture.LONG_TAP) == gestureAction2) ? false : true);
        } else if (i == 4 || i == 5) {
            this.O.setActive((this.v.get(com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL) == gestureAction2 && this.v.get(com.otaliastudios.cameraview.gesture.Gesture.SCROLL_VERTICAL) == gestureAction2) ? false : true);
        }
        return true;
    }

    public final void n() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = V;
        cameraLogger.w("doInstantiateEngine:", "instantiating. engine:", this.x);
        com.otaliastudios.cameraview.engine.CameraEngine instantiateCameraEngine = instantiateCameraEngine(this.x, this.C);
        this.F = instantiateCameraEngine;
        cameraLogger.w("doInstantiateEngine:", "instantiated. engine:", instantiateCameraEngine.getClass().getSimpleName());
        this.F.setOverlay(this.U);
    }

    @androidx.annotation.VisibleForTesting
    public void o() {
        com.otaliastudios.cameraview.CameraLogger cameraLogger = V;
        cameraLogger.w("doInstantiateEngine:", "instantiating. preview:", this.w);
        com.otaliastudios.cameraview.preview.CameraPreview instantiatePreview = instantiatePreview(this.w, getContext(), this);
        this.D = instantiatePreview;
        cameraLogger.w("doInstantiateEngine:", "instantiated. preview:", instantiatePreview.getClass().getSimpleName());
        this.F.setPreview(this.D);
        com.otaliastudios.cameraview.filter.Filter filter = this.y;
        if (filter != null) {
            setFilter(filter);
            this.y = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.T && this.D == null) {
            o();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.G = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.T) {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i), 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i2), 1073741824));
            return;
        }
        com.otaliastudios.cameraview.size.Size previewStreamSize = this.F.getPreviewStreamSize(com.otaliastudios.cameraview.engine.offset.Reference.VIEW);
        this.G = previewStreamSize;
        if (previewStreamSize == null) {
            V.w("onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        float width = this.G.getWidth();
        float height = this.G.getHeight();
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.D.supportsCropping()) {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        } else {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        }
        com.otaliastudios.cameraview.CameraLogger cameraLogger = V;
        cameraLogger.i("onMeasure:", "requested dimensions are (" + size + "[" + r(mode) + "]x" + size2 + "[" + r(mode2) + "])");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        sb.append(width);
        sb.append("x");
        sb.append(height);
        sb.append(")");
        cameraLogger.i("onMeasure:", "previewSize is", sb.toString());
        if (mode == 1073741824 && mode2 == 1073741824) {
            cameraLogger.i("onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            cameraLogger.i("onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + width + "x" + height + ")");
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec((int) width, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec((int) height, 1073741824));
            return;
        }
        float f = height / width;
        if (mode == 0 || mode2 == 0) {
            if (mode == 0) {
                size = java.lang.Math.round(size2 / f);
            } else {
                size2 = java.lang.Math.round(size * f);
            }
            cameraLogger.i("onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + "x" + size2 + ")");
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(size, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = java.lang.Math.min(java.lang.Math.round(size2 / f), size);
            } else {
                size2 = java.lang.Math.min(java.lang.Math.round(size * f), size2);
            }
            cameraLogger.i("onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(size, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        float f2 = size2;
        float f3 = size;
        if (f2 / f3 >= f) {
            size2 = java.lang.Math.round(f3 * f);
        } else {
            size = java.lang.Math.round(f2 / f);
        }
        cameraLogger.i("onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(size, 1073741824), android.view.View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!isOpened()) {
            return true;
        }
        com.otaliastudios.cameraview.CameraOptions cameraOptions = this.F.getCameraOptions();
        if (cameraOptions == null) {
            throw new java.lang.IllegalStateException("Options should not be null here.");
        }
        if (this.M.onTouchEvent(motionEvent)) {
            V.i("onTouchEvent", "pinch!");
            s(this.M, cameraOptions);
        } else if (this.O.onTouchEvent(motionEvent)) {
            V.i("onTouchEvent", "scroll!");
            s(this.O, cameraOptions);
        } else if (this.N.onTouchEvent(motionEvent)) {
            V.i("onTouchEvent", "tap!");
            s(this.N, cameraOptions);
        }
        return true;
    }

    @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.T) {
            return;
        }
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview = this.D;
        if (cameraPreview != null) {
            cameraPreview.onResume();
        }
        if (checkPermissions(getAudio())) {
            this.E.enable();
            this.F.getAngles().setDisplayOffset(this.E.getLastDisplayOffset());
            this.F.start();
        }
    }

    public final void p(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        boolean isInEditMode = isInEditMode();
        this.T = isInEditMode;
        if (isInEditMode) {
            return;
        }
        setWillNotDraw(false);
        android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.otaliastudios.cameraview.R.styleable.CameraView, 0, 0);
        com.otaliastudios.cameraview.controls.ControlParser controlParser = new com.otaliastudios.cameraview.controls.ControlParser(context, obtainStyledAttributes);
        boolean z = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPlaySounds, true);
        boolean z2 = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraUseDeviceOrientation, true);
        this.S = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraExperimental, false);
        this.u = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraRequestPermissions, true);
        this.w = controlParser.getPreview();
        this.x = controlParser.getEngine();
        int color = obtainStyledAttributes.getColor(com.otaliastudios.cameraview.R.styleable.CameraView_cameraGridColor, com.otaliastudios.cameraview.internal.GridLinesLayout.DEFAULT_COLOR);
        long j = (long) obtainStyledAttributes.getFloat(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoMaxSize, 0.0f);
        int integer = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoMaxDuration, 0);
        int integer2 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraVideoBitRate, 0);
        int integer3 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraAudioBitRate, 0);
        float f = obtainStyledAttributes.getFloat(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z3 = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPreviewFrameRateExact, false);
        long integer4 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraAutoFocusResetDelay, 3000);
        boolean z4 = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureMetering, true);
        boolean z5 = obtainStyledAttributes.getBoolean(com.otaliastudios.cameraview.R.styleable.CameraView_cameraPictureSnapshotMetering, false);
        int integer5 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraSnapshotMaxWidth, 0);
        int integer6 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraSnapshotMaxHeight, 0);
        int integer7 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer8 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer9 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFrameProcessingFormat, 0);
        int integer10 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer11 = obtainStyledAttributes.getInteger(com.otaliastudios.cameraview.R.styleable.CameraView_cameraFrameProcessingExecutors, 1);
        com.otaliastudios.cameraview.size.SizeSelectorParser sizeSelectorParser = new com.otaliastudios.cameraview.size.SizeSelectorParser(obtainStyledAttributes);
        com.otaliastudios.cameraview.gesture.GestureParser gestureParser = new com.otaliastudios.cameraview.gesture.GestureParser(obtainStyledAttributes);
        com.otaliastudios.cameraview.markers.MarkerParser markerParser = new com.otaliastudios.cameraview.markers.MarkerParser(obtainStyledAttributes);
        com.otaliastudios.cameraview.filter.FilterParser filterParser = new com.otaliastudios.cameraview.filter.FilterParser(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        this.C = new com.otaliastudios.cameraview.CameraView.CameraCallbacks();
        this.A = new android.os.Handler(android.os.Looper.getMainLooper());
        this.M = new com.otaliastudios.cameraview.gesture.PinchGestureFinder(this.C);
        this.N = new com.otaliastudios.cameraview.gesture.TapGestureFinder(this.C);
        this.O = new com.otaliastudios.cameraview.gesture.ScrollGestureFinder(this.C);
        this.P = new com.otaliastudios.cameraview.internal.GridLinesLayout(context);
        this.U = new com.otaliastudios.cameraview.overlay.OverlayLayout(context);
        this.Q = new com.otaliastudios.cameraview.markers.MarkerLayout(context);
        addView(this.P);
        addView(this.Q);
        addView(this.U);
        n();
        setPlaySounds(z);
        setUseDeviceOrientation(z2);
        setGrid(controlParser.getGrid());
        setGridColor(color);
        setFacing(controlParser.getFacing());
        setFlash(controlParser.getFlash());
        setMode(controlParser.getMode());
        setWhiteBalance(controlParser.getWhiteBalance());
        setHdr(controlParser.getHdr());
        setAudio(controlParser.getAudio());
        setAudioBitRate(integer3);
        setAudioCodec(controlParser.getAudioCodec());
        setPictureSize(sizeSelectorParser.getPictureSizeSelector());
        setPictureMetering(z4);
        setPictureSnapshotMetering(z5);
        setPictureFormat(controlParser.getPictureFormat());
        setVideoSize(sizeSelectorParser.getVideoSizeSelector());
        setVideoCodec(controlParser.getVideoCodec());
        setVideoMaxSize(j);
        setVideoMaxDuration(integer);
        setVideoBitRate(integer2);
        setAutoFocusResetDelay(integer4);
        setPreviewFrameRateExact(z3);
        setPreviewFrameRate(f);
        setSnapshotMaxWidth(integer5);
        setSnapshotMaxHeight(integer6);
        setFrameProcessingMaxWidth(integer7);
        setFrameProcessingMaxHeight(integer8);
        setFrameProcessingFormat(integer9);
        setFrameProcessingPoolSize(integer10);
        setFrameProcessingExecutors(integer11);
        mapGesture(com.otaliastudios.cameraview.gesture.Gesture.TAP, gestureParser.getTapAction());
        mapGesture(com.otaliastudios.cameraview.gesture.Gesture.LONG_TAP, gestureParser.getLongTapAction());
        mapGesture(com.otaliastudios.cameraview.gesture.Gesture.PINCH, gestureParser.getPinchAction());
        mapGesture(com.otaliastudios.cameraview.gesture.Gesture.SCROLL_HORIZONTAL, gestureParser.getHorizontalScrollAction());
        mapGesture(com.otaliastudios.cameraview.gesture.Gesture.SCROLL_VERTICAL, gestureParser.getVerticalScrollAction());
        setAutoFocusMarker(markerParser.getAutoFocusMarker());
        setFilter(filterParser.getFilter());
        this.E = new com.otaliastudios.cameraview.internal.OrientationHelper(context, this.C);
    }

    public final boolean q() {
        return this.F.getState() == com.otaliastudios.cameraview.engine.orchestrator.CameraState.OFF && !this.F.isChangingState();
    }

    public final java.lang.String r(int i) {
        if (i == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    public void removeCameraListener(@androidx.annotation.NonNull com.otaliastudios.cameraview.CameraListener cameraListener) {
        this.J.remove(cameraListener);
    }

    public void removeFrameProcessor(@androidx.annotation.Nullable com.otaliastudios.cameraview.frame.FrameProcessor frameProcessor) {
        if (frameProcessor != null) {
            this.K.remove(frameProcessor);
            if (this.K.size() == 0) {
                this.F.setHasFrameProcessors(false);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(android.view.View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.T || layoutParams == null || !this.U.isOverlay(layoutParams)) {
            super.removeView(view);
        } else {
            this.U.removeView(view);
        }
    }

    public final void s(@androidx.annotation.NonNull com.otaliastudios.cameraview.gesture.GestureFinder gestureFinder, @androidx.annotation.NonNull com.otaliastudios.cameraview.CameraOptions cameraOptions) {
        com.otaliastudios.cameraview.gesture.Gesture gesture = gestureFinder.getGesture();
        com.otaliastudios.cameraview.gesture.GestureAction gestureAction = this.v.get(gesture);
        android.graphics.PointF[] points = gestureFinder.getPoints();
        switch (com.otaliastudios.cameraview.CameraView.AnonymousClass7.c[gestureAction.ordinal()]) {
            case 1:
                takePicture();
                break;
            case 2:
                this.F.startAutoFocus(gesture, com.otaliastudios.cameraview.metering.MeteringRegions.fromPoint(new com.otaliastudios.cameraview.size.Size(getWidth(), getHeight()), points[0]), points[0]);
                break;
            case 3:
                float zoomValue = this.F.getZoomValue();
                float computeValue = gestureFinder.computeValue(zoomValue, 0.0f, 1.0f);
                if (computeValue != zoomValue) {
                    this.F.setZoom(computeValue, points, true);
                    break;
                }
                break;
            case 4:
                float exposureCorrectionValue = this.F.getExposureCorrectionValue();
                float exposureCorrectionMinValue = cameraOptions.getExposureCorrectionMinValue();
                float exposureCorrectionMaxValue = cameraOptions.getExposureCorrectionMaxValue();
                float computeValue2 = gestureFinder.computeValue(exposureCorrectionValue, exposureCorrectionMinValue, exposureCorrectionMaxValue);
                if (computeValue2 != exposureCorrectionValue) {
                    this.F.setExposureCorrection(computeValue2, new float[]{exposureCorrectionMinValue, exposureCorrectionMaxValue}, points, true);
                    break;
                }
                break;
            case 5:
                if (getFilter() instanceof com.otaliastudios.cameraview.filter.OneParameterFilter) {
                    com.otaliastudios.cameraview.filter.OneParameterFilter oneParameterFilter = (com.otaliastudios.cameraview.filter.OneParameterFilter) getFilter();
                    float parameter1 = oneParameterFilter.getParameter1();
                    float computeValue3 = gestureFinder.computeValue(parameter1, 0.0f, 1.0f);
                    if (computeValue3 != parameter1) {
                        oneParameterFilter.setParameter1(computeValue3);
                        break;
                    }
                }
                break;
            case 6:
                if (getFilter() instanceof com.otaliastudios.cameraview.filter.TwoParameterFilter) {
                    com.otaliastudios.cameraview.filter.TwoParameterFilter twoParameterFilter = (com.otaliastudios.cameraview.filter.TwoParameterFilter) getFilter();
                    float parameter2 = twoParameterFilter.getParameter2();
                    float computeValue4 = gestureFinder.computeValue(parameter2, 0.0f, 1.0f);
                    if (computeValue4 != parameter2) {
                        twoParameterFilter.setParameter2(computeValue4);
                        break;
                    }
                }
                break;
        }
    }

    public void set(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Control control) {
        if (control instanceof com.otaliastudios.cameraview.controls.Audio) {
            setAudio((com.otaliastudios.cameraview.controls.Audio) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Facing) {
            setFacing((com.otaliastudios.cameraview.controls.Facing) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Flash) {
            setFlash((com.otaliastudios.cameraview.controls.Flash) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Grid) {
            setGrid((com.otaliastudios.cameraview.controls.Grid) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Hdr) {
            setHdr((com.otaliastudios.cameraview.controls.Hdr) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Mode) {
            setMode((com.otaliastudios.cameraview.controls.Mode) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.WhiteBalance) {
            setWhiteBalance((com.otaliastudios.cameraview.controls.WhiteBalance) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.VideoCodec) {
            setVideoCodec((com.otaliastudios.cameraview.controls.VideoCodec) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.AudioCodec) {
            setAudioCodec((com.otaliastudios.cameraview.controls.AudioCodec) control);
            return;
        }
        if (control instanceof com.otaliastudios.cameraview.controls.Preview) {
            setPreview((com.otaliastudios.cameraview.controls.Preview) control);
        } else if (control instanceof com.otaliastudios.cameraview.controls.Engine) {
            setEngine((com.otaliastudios.cameraview.controls.Engine) control);
        } else if (control instanceof com.otaliastudios.cameraview.controls.PictureFormat) {
            setPictureFormat((com.otaliastudios.cameraview.controls.PictureFormat) control);
        }
    }

    public void setAudio(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Audio audio) {
        if (audio == getAudio() || q()) {
            this.F.setAudio(audio);
        } else if (checkPermissions(audio)) {
            this.F.setAudio(audio);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i) {
        this.F.setAudioBitRate(i);
    }

    public void setAudioCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.AudioCodec audioCodec) {
        this.F.setAudioCodec(audioCodec);
    }

    public void setAutoFocusMarker(@androidx.annotation.Nullable com.otaliastudios.cameraview.markers.AutoFocusMarker autoFocusMarker) {
        this.I = autoFocusMarker;
        this.Q.onMarker(1, autoFocusMarker);
    }

    public void setAutoFocusResetDelay(long j) {
        this.F.setAutoFocusResetDelay(j);
    }

    public void setEngine(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Engine engine) {
        if (q()) {
            this.x = engine;
            com.otaliastudios.cameraview.engine.CameraEngine cameraEngine = this.F;
            n();
            com.otaliastudios.cameraview.preview.CameraPreview cameraPreview = this.D;
            if (cameraPreview != null) {
                this.F.setPreview(cameraPreview);
            }
            setFacing(cameraEngine.getFacing());
            setFlash(cameraEngine.getFlash());
            setMode(cameraEngine.getMode());
            setWhiteBalance(cameraEngine.getWhiteBalance());
            setHdr(cameraEngine.getHdr());
            setAudio(cameraEngine.getAudio());
            setAudioBitRate(cameraEngine.getAudioBitRate());
            setAudioCodec(cameraEngine.getAudioCodec());
            setPictureSize(cameraEngine.getPictureSizeSelector());
            setPictureFormat(cameraEngine.getPictureFormat());
            setVideoSize(cameraEngine.getVideoSizeSelector());
            setVideoCodec(cameraEngine.getVideoCodec());
            setVideoMaxSize(cameraEngine.getVideoMaxSize());
            setVideoMaxDuration(cameraEngine.getVideoMaxDuration());
            setVideoBitRate(cameraEngine.getVideoBitRate());
            setAutoFocusResetDelay(cameraEngine.getAutoFocusResetDelay());
            setPreviewFrameRate(cameraEngine.getPreviewFrameRate());
            setPreviewFrameRateExact(cameraEngine.getPreviewFrameRateExact());
            setSnapshotMaxWidth(cameraEngine.getSnapshotMaxWidth());
            setSnapshotMaxHeight(cameraEngine.getSnapshotMaxHeight());
            setFrameProcessingMaxWidth(cameraEngine.getFrameProcessingMaxWidth());
            setFrameProcessingMaxHeight(cameraEngine.getFrameProcessingMaxHeight());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.getFrameProcessingPoolSize());
            this.F.setHasFrameProcessors(!this.K.isEmpty());
        }
    }

    public void setExperimental(boolean z) {
        this.S = z;
    }

    public void setExposureCorrection(float f) {
        com.otaliastudios.cameraview.CameraOptions cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float exposureCorrectionMinValue = cameraOptions.getExposureCorrectionMinValue();
            float exposureCorrectionMaxValue = cameraOptions.getExposureCorrectionMaxValue();
            if (f < exposureCorrectionMinValue) {
                f = exposureCorrectionMinValue;
            }
            if (f > exposureCorrectionMaxValue) {
                f = exposureCorrectionMaxValue;
            }
            this.F.setExposureCorrection(f, new float[]{exposureCorrectionMinValue, exposureCorrectionMaxValue}, null, false);
        }
    }

    public void setFacing(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Facing facing) {
        this.F.setFacing(facing);
    }

    public void setFilter(@androidx.annotation.NonNull com.otaliastudios.cameraview.filter.Filter filter) {
        java.lang.Object obj = this.D;
        if (obj == null) {
            this.y = filter;
            return;
        }
        boolean z = obj instanceof com.otaliastudios.cameraview.preview.FilterCameraPreview;
        if ((filter instanceof com.otaliastudios.cameraview.filter.NoFilter) || z) {
            if (z) {
                ((com.otaliastudios.cameraview.preview.FilterCameraPreview) obj).setFilter(filter);
            }
        } else {
            throw new java.lang.RuntimeException("Filters are only supported by the GL_SURFACE preview. Current preview:" + this.w);
        }
    }

    public void setFlash(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Flash flash) {
        this.F.setFlash(flash);
    }

    public void setFrameProcessingExecutors(int i) {
        if (i < 1) {
            throw new java.lang.IllegalArgumentException("Need at least 1 executor, got " + i);
        }
        this.z = i;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, i, 4L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingQueue(), new com.otaliastudios.cameraview.CameraView.AnonymousClass6());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.B = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i) {
        this.F.setFrameProcessingFormat(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.F.setFrameProcessingMaxHeight(i);
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.F.setFrameProcessingMaxWidth(i);
    }

    public void setFrameProcessingPoolSize(int i) {
        this.F.setFrameProcessingPoolSize(i);
    }

    public void setGrid(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Grid grid) {
        this.P.setGridMode(grid);
    }

    public void setGridColor(@androidx.annotation.ColorInt int i) {
        this.P.setGridColor(i);
    }

    public void setHdr(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Hdr hdr) {
        this.F.setHdr(hdr);
    }

    public void setLifecycleOwner(@androidx.annotation.Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            m();
            return;
        }
        m();
        androidx.lifecycle.Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        this.L = lifecycle;
        lifecycle.addObserver(this);
    }

    public void setLocation(double d, double d2) {
        android.location.Location location = new android.location.Location("Unknown");
        location.setTime(java.lang.System.currentTimeMillis());
        location.setAltitude(0.0d);
        location.setLatitude(d);
        location.setLongitude(d2);
        this.F.setLocation(location);
    }

    public void setLocation(@androidx.annotation.Nullable android.location.Location location) {
        this.F.setLocation(location);
    }

    public void setMode(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Mode mode) {
        this.F.setMode(mode);
    }

    public void setPictureFormat(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.PictureFormat pictureFormat) {
        this.F.setPictureFormat(pictureFormat);
    }

    public void setPictureMetering(boolean z) {
        this.F.setPictureMetering(z);
    }

    public void setPictureSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.F.setPictureSizeSelector(sizeSelector);
    }

    public void setPictureSnapshotMetering(boolean z) {
        this.F.setPictureSnapshotMetering(z);
    }

    public void setPlaySounds(boolean z) {
        this.n = z;
        this.F.setPlaySounds(z);
    }

    public void setPreview(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.Preview preview) {
        com.otaliastudios.cameraview.preview.CameraPreview cameraPreview;
        if (preview != this.w) {
            this.w = preview;
            if ((getWindowToken() != null) || (cameraPreview = this.D) == null) {
                return;
            }
            cameraPreview.onDestroy();
            this.D = null;
        }
    }

    public void setPreviewFrameRate(float f) {
        this.F.setPreviewFrameRate(f);
    }

    public void setPreviewFrameRateExact(boolean z) {
        this.F.setPreviewFrameRateExact(z);
    }

    public void setPreviewStreamSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.F.setPreviewStreamSizeSelector(sizeSelector);
    }

    public void setRequestPermissions(boolean z) {
        this.u = z;
    }

    public void setSnapshotMaxHeight(int i) {
        this.F.setSnapshotMaxHeight(i);
    }

    public void setSnapshotMaxWidth(int i) {
        this.F.setSnapshotMaxWidth(i);
    }

    public void setUseDeviceOrientation(boolean z) {
        this.t = z;
    }

    public void setVideoBitRate(int i) {
        this.F.setVideoBitRate(i);
    }

    public void setVideoCodec(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.VideoCodec videoCodec) {
        this.F.setVideoCodec(videoCodec);
    }

    public void setVideoMaxDuration(int i) {
        this.F.setVideoMaxDuration(i);
    }

    public void setVideoMaxSize(long j) {
        this.F.setVideoMaxSize(j);
    }

    public void setVideoSize(@androidx.annotation.NonNull com.otaliastudios.cameraview.size.SizeSelector sizeSelector) {
        this.F.setVideoSizeSelector(sizeSelector);
    }

    public void setWhiteBalance(@androidx.annotation.NonNull com.otaliastudios.cameraview.controls.WhiteBalance whiteBalance) {
        this.F.setWhiteBalance(whiteBalance);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.F.setZoom(f, null, false);
    }

    public void startAutoFocus(float f, float f2) {
        if (f < 0.0f || f > getWidth()) {
            throw new java.lang.IllegalArgumentException("x should be >= 0 and <= getWidth()");
        }
        if (f2 < 0.0f || f2 > getHeight()) {
            throw new java.lang.IllegalArgumentException("y should be >= 0 and <= getHeight()");
        }
        com.otaliastudios.cameraview.size.Size size = new com.otaliastudios.cameraview.size.Size(getWidth(), getHeight());
        android.graphics.PointF pointF = new android.graphics.PointF(f, f2);
        this.F.startAutoFocus(null, com.otaliastudios.cameraview.metering.MeteringRegions.fromPoint(size, pointF), pointF);
    }

    public void startAutoFocus(@androidx.annotation.NonNull android.graphics.RectF rectF) {
        if (new android.graphics.RectF(0.0f, 0.0f, getWidth(), getHeight()).contains(rectF)) {
            this.F.startAutoFocus(null, com.otaliastudios.cameraview.metering.MeteringRegions.fromArea(new com.otaliastudios.cameraview.size.Size(getWidth(), getHeight()), rectF), new android.graphics.PointF(rectF.centerX(), rectF.centerY()));
        } else {
            throw new java.lang.IllegalArgumentException("Region is out of view bounds! " + rectF);
        }
    }

    public void stopVideo() {
        this.F.stopVideo();
        this.A.post(new com.otaliastudios.cameraview.CameraView.AnonymousClass5());
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final void t(int i) {
        if (this.n) {
            if (this.H == null) {
                this.H = new android.media.MediaActionSound();
            }
            this.H.play(i);
        }
    }

    public void takePicture() {
        this.F.takePicture(new com.otaliastudios.cameraview.PictureResult.Stub());
    }

    public void takePictureSnapshot() {
        this.F.takePictureSnapshot(new com.otaliastudios.cameraview.PictureResult.Stub());
    }

    public void takeVideo(@androidx.annotation.NonNull java.io.File file) {
        u(file, null);
    }

    public void takeVideo(@androidx.annotation.NonNull java.io.File file, int i) {
        v(file, null, i);
    }

    public void takeVideo(@androidx.annotation.NonNull java.io.FileDescriptor fileDescriptor) {
        u(null, fileDescriptor);
    }

    public void takeVideo(@androidx.annotation.NonNull java.io.FileDescriptor fileDescriptor, int i) {
        v(null, fileDescriptor, i);
    }

    public void takeVideoSnapshot(@androidx.annotation.NonNull java.io.File file) {
        this.F.takeVideoSnapshot(new com.otaliastudios.cameraview.VideoResult.Stub(), file);
        this.A.post(new com.otaliastudios.cameraview.CameraView.AnonymousClass2());
    }

    public void takeVideoSnapshot(@androidx.annotation.NonNull java.io.File file, int i) {
        addCameraListener(new com.otaliastudios.cameraview.CameraView.AnonymousClass4(getVideoMaxDuration()));
        setVideoMaxDuration(i);
        takeVideoSnapshot(file);
    }

    public com.otaliastudios.cameraview.controls.Facing toggleFacing() {
        int i = com.otaliastudios.cameraview.CameraView.AnonymousClass7.d[this.F.getFacing().ordinal()];
        if (i == 1) {
            setFacing(com.otaliastudios.cameraview.controls.Facing.FRONT);
        } else if (i == 2) {
            setFacing(com.otaliastudios.cameraview.controls.Facing.BACK);
        }
        return this.F.getFacing();
    }

    public final void u(@androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor) {
        com.otaliastudios.cameraview.VideoResult.Stub stub = new com.otaliastudios.cameraview.VideoResult.Stub();
        if (file != null) {
            this.F.takeVideo(stub, file, null);
        } else {
            if (fileDescriptor == null) {
                throw new java.lang.IllegalStateException("file and fileDescriptor are both null.");
            }
            this.F.takeVideo(stub, null, fileDescriptor);
        }
        this.A.post(new com.otaliastudios.cameraview.CameraView.AnonymousClass1());
    }

    public final void v(@androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.io.FileDescriptor fileDescriptor, int i) {
        addCameraListener(new com.otaliastudios.cameraview.CameraView.AnonymousClass3(getVideoMaxDuration()));
        setVideoMaxDuration(i);
        u(file, fileDescriptor);
    }
}

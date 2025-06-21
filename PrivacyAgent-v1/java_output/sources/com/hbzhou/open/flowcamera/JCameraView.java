package com.hbzhou.open.flowcamera;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes22.dex */
public class JCameraView extends android.widget.FrameLayout implements com.hbzhou.open.flowcamera.CameraInterface.CameraOpenOverCallback, android.view.SurfaceHolder.Callback, com.hbzhou.open.flowcamera.view.CameraView {
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final int MEDIA_QUALITY_DESPAIR = 200000;
    public static final int MEDIA_QUALITY_FUNNY = 400000;
    public static final int MEDIA_QUALITY_HIGH = 2000000;
    public static final int MEDIA_QUALITY_LOW = 1200000;
    public static final int MEDIA_QUALITY_MIDDLE = 1600000;
    public static final int MEDIA_QUALITY_POOR = 800000;
    public static final int MEDIA_QUALITY_SORRY = 80000;
    public static final int TYPE_DEFAULT = 4;
    public static final int TYPE_PICTURE = 1;
    public static final int TYPE_SHORT = 3;
    public static final int TYPE_VIDEO = 2;
    public android.widget.ImageView A;
    public android.widget.ImageView B;
    public com.hbzhou.open.flowcamera.CaptureLayout C;
    public com.hbzhou.open.flowcamera.FoucsView D;
    public android.media.MediaPlayer E;
    public int F;
    public float G;
    public android.graphics.Bitmap H;
    public android.graphics.Bitmap I;
    public java.lang.String J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public boolean R;
    public float S;
    public com.hbzhou.open.flowcamera.listener.ErrorListener T;
    public com.hbzhou.open.flowcamera.state.CameraMachine n;
    public int t;
    public com.hbzhou.open.flowcamera.listener.JCameraListener u;
    public com.hbzhou.open.flowcamera.listener.ClickListener v;
    public com.hbzhou.open.flowcamera.listener.ClickListener w;
    public android.content.Context x;
    public android.widget.VideoView y;
    public android.widget.ImageView z;

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.hbzhou.open.flowcamera.JCameraView.this.t++;
            if (com.hbzhou.open.flowcamera.JCameraView.this.t > 35) {
                com.hbzhou.open.flowcamera.JCameraView.this.t = 33;
            }
            com.hbzhou.open.flowcamera.JCameraView.this.s();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.hbzhou.open.flowcamera.JCameraView.this.n.swtich(com.hbzhou.open.flowcamera.JCameraView.this.y.getHolder(), com.hbzhou.open.flowcamera.JCameraView.this.G);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.hbzhou.open.flowcamera.CaptureListener {

        /* renamed from: com.hbzhou.open.flowcamera.JCameraView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ long n;

            public AnonymousClass1(long j) {
                this.n = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.hbzhou.open.flowcamera.JCameraView.this.n.stopRecord(true, this.n);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordEnd(long j) {
            com.hbzhou.open.flowcamera.JCameraView.this.n.stopRecord(false, j);
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordError() {
            if (com.hbzhou.open.flowcamera.JCameraView.this.T != null) {
                com.hbzhou.open.flowcamera.JCameraView.this.T.AudioPermissionError();
            }
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordShort(long j) {
            com.hbzhou.open.flowcamera.JCameraView.this.C.setTextWithAnimation("录制时间过短");
            com.hbzhou.open.flowcamera.JCameraView.this.A.setVisibility(0);
            com.hbzhou.open.flowcamera.JCameraView.this.B.setVisibility(0);
            com.hbzhou.open.flowcamera.JCameraView.this.postDelayed(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass3.AnonymousClass1(j), 1500 - j);
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordStart() {
            com.hbzhou.open.flowcamera.JCameraView.this.A.setVisibility(4);
            com.hbzhou.open.flowcamera.JCameraView.this.B.setVisibility(4);
            com.hbzhou.open.flowcamera.JCameraView.this.n.record(com.hbzhou.open.flowcamera.JCameraView.this.y.getHolder().getSurface(), com.hbzhou.open.flowcamera.JCameraView.this.G);
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordZoom(float f) {
            com.hbzhou.open.flowcamera.util.LogUtil.i("recordZoom");
            com.hbzhou.open.flowcamera.JCameraView.this.n.zoom(f, 144);
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void takePictures() {
            com.hbzhou.open.flowcamera.JCameraView.this.A.setVisibility(4);
            com.hbzhou.open.flowcamera.JCameraView.this.B.setVisibility(4);
            com.hbzhou.open.flowcamera.JCameraView.this.n.capture();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.hbzhou.open.flowcamera.listener.TypeListener {
        public AnonymousClass4() {
        }

        @Override // com.hbzhou.open.flowcamera.listener.TypeListener
        public void cancel() {
            com.hbzhou.open.flowcamera.JCameraView.this.n.cancle(com.hbzhou.open.flowcamera.JCameraView.this.y.getHolder(), com.hbzhou.open.flowcamera.JCameraView.this.G);
        }

        @Override // com.hbzhou.open.flowcamera.listener.TypeListener
        public void confirm() {
            com.hbzhou.open.flowcamera.JCameraView.this.n.confirm();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$5, reason: invalid class name */
    public class AnonymousClass5 implements com.hbzhou.open.flowcamera.listener.ClickListener {
        public AnonymousClass5() {
        }

        @Override // com.hbzhou.open.flowcamera.listener.ClickListener
        public void onClick() {
            if (com.hbzhou.open.flowcamera.JCameraView.this.v != null) {
                com.hbzhou.open.flowcamera.JCameraView.this.v.onClick();
            }
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$6, reason: invalid class name */
    public class AnonymousClass6 implements com.hbzhou.open.flowcamera.listener.ClickListener {
        public AnonymousClass6() {
        }

        @Override // com.hbzhou.open.flowcamera.listener.ClickListener
        public void onClick() {
            if (com.hbzhou.open.flowcamera.JCameraView.this.w != null) {
                com.hbzhou.open.flowcamera.JCameraView.this.w.onClick();
            }
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$7, reason: invalid class name */
    public class AnonymousClass7 extends java.lang.Thread {
        public AnonymousClass7() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.hbzhou.open.flowcamera.CameraInterface.getInstance().j(com.hbzhou.open.flowcamera.JCameraView.this);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$8, reason: invalid class name */
    public class AnonymousClass8 implements com.hbzhou.open.flowcamera.CameraInterface.FocusCallback {
        public AnonymousClass8() {
        }

        @Override // com.hbzhou.open.flowcamera.CameraInterface.FocusCallback
        public void focusSuccess() {
            com.hbzhou.open.flowcamera.JCameraView.this.D.setVisibility(4);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.JCameraView$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;

        /* renamed from: com.hbzhou.open.flowcamera.JCameraView$9$1, reason: invalid class name */
        public class AnonymousClass1 implements android.media.MediaPlayer.OnVideoSizeChangedListener {
            public AnonymousClass1() {
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                com.hbzhou.open.flowcamera.JCameraView.this.u(r1.E.getVideoWidth(), com.hbzhou.open.flowcamera.JCameraView.this.E.getVideoHeight());
            }
        }

        /* renamed from: com.hbzhou.open.flowcamera.JCameraView$9$2, reason: invalid class name */
        public class AnonymousClass2 implements android.media.MediaPlayer.OnPreparedListener {
            public AnonymousClass2() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) {
                com.hbzhou.open.flowcamera.JCameraView.this.E.start();
            }
        }

        public AnonymousClass9(java.lang.String str) {
            this.n = str;
        }

        @Override // java.lang.Runnable
        @androidx.annotation.RequiresApi(api = 16)
        @android.annotation.SuppressLint({"NewApi"})
        public void run() {
            try {
                if (com.hbzhou.open.flowcamera.JCameraView.this.E == null) {
                    com.hbzhou.open.flowcamera.JCameraView.this.E = new android.media.MediaPlayer();
                } else {
                    com.hbzhou.open.flowcamera.JCameraView.this.E.reset();
                }
                com.hbzhou.open.flowcamera.JCameraView.this.E.setDataSource(this.n);
                com.hbzhou.open.flowcamera.JCameraView.this.E.setSurface(com.hbzhou.open.flowcamera.JCameraView.this.y.getHolder().getSurface());
                com.hbzhou.open.flowcamera.JCameraView.this.E.setVideoScalingMode(1);
                com.hbzhou.open.flowcamera.JCameraView.this.E.setAudioStreamType(3);
                com.hbzhou.open.flowcamera.JCameraView.this.E.setOnVideoSizeChangedListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass9.AnonymousClass1());
                com.hbzhou.open.flowcamera.JCameraView.this.E.setOnPreparedListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass9.AnonymousClass2());
                com.hbzhou.open.flowcamera.JCameraView.this.E.setLooping(true);
                com.hbzhou.open.flowcamera.JCameraView.this.E.prepare();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JCameraView(android.content.Context context) {
        this(context, null);
    }

    public JCameraView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JCameraView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = 35;
        this.G = 0.0f;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.S = 0.0f;
        this.x = context;
        android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.moji.camera.R.styleable.JCameraView, i, 0);
        this.K = obtainStyledAttributes.getDimensionPixelSize(com.moji.camera.R.styleable.JCameraView_iconSize, (int) android.util.TypedValue.applyDimension(2, 35.0f, getResources().getDisplayMetrics()));
        this.L = obtainStyledAttributes.getDimensionPixelSize(com.moji.camera.R.styleable.JCameraView_iconMargin, (int) android.util.TypedValue.applyDimension(2, 15.0f, getResources().getDisplayMetrics()));
        this.M = obtainStyledAttributes.getResourceId(com.moji.camera.R.styleable.JCameraView_iconSrc, com.moji.camera.R.drawable.ic_camera_change);
        this.N = obtainStyledAttributes.getResourceId(com.moji.camera.R.styleable.JCameraView_iconLeft, 0);
        this.O = obtainStyledAttributes.getResourceId(com.moji.camera.R.styleable.JCameraView_iconRight, 0);
        this.P = obtainStyledAttributes.getInteger(com.moji.camera.R.styleable.JCameraView_duration_max, 10000);
        obtainStyledAttributes.recycle();
        q();
        r();
    }

    @Override // com.hbzhou.open.flowcamera.CameraInterface.CameraOpenOverCallback
    public void cameraHasOpened() {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().doStartPreview(this.y.getHolder(), this.G);
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void confirmState(int i) {
        if (i == 1) {
            this.z.setVisibility(4);
            com.hbzhou.open.flowcamera.listener.JCameraListener jCameraListener = this.u;
            if (jCameraListener != null) {
                jCameraListener.captureSuccess(this.H);
            }
        } else if (i == 2) {
            stopVideo();
            this.y.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            this.n.start(this.y.getHolder(), this.G);
            com.hbzhou.open.flowcamera.listener.JCameraListener jCameraListener2 = this.u;
            if (jCameraListener2 != null) {
                jCameraListener2.recordSuccess(this.J, this.I);
            }
        }
        this.C.resetCaptureLayout();
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public boolean handlerFoucs(float f, float f2) {
        if (f2 > this.C.getTop()) {
            return false;
        }
        this.D.setVisibility(0);
        if (f < this.D.getWidth() / 2) {
            f = this.D.getWidth() / 2;
        }
        if (f > this.F - (this.D.getWidth() / 2)) {
            f = this.F - (this.D.getWidth() / 2);
        }
        if (f2 < this.D.getWidth() / 2) {
            f2 = this.D.getWidth() / 2;
        }
        if (f2 > this.C.getTop() - (this.D.getWidth() / 2)) {
            f2 = this.C.getTop() - (this.D.getWidth() / 2);
        }
        this.D.setX(f - (r0.getWidth() / 2));
        this.D.setY(f2 - (r4.getHeight() / 2));
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.D, "scaleX", 1.0f, 0.6f);
        android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.D, "scaleY", 1.0f, 0.6f);
        android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(this.D, "alpha", 1.0f, 0.4f, 1.0f, 0.4f, 1.0f, 0.4f, 1.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).before(ofFloat3);
        animatorSet.setDuration(400L);
        animatorSet.start();
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float measuredWidth = this.y.getMeasuredWidth();
        float measuredHeight = this.y.getMeasuredHeight();
        if (this.G == 0.0f) {
            this.G = measuredHeight / measuredWidth;
        }
    }

    public void onPause() {
        com.hbzhou.open.flowcamera.util.LogUtil.i("JCameraView onPause");
        stopVideo();
        resetState(1);
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().l(false);
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().s(this.x);
    }

    public void onResume() {
        com.hbzhou.open.flowcamera.util.LogUtil.i("JCameraView onResume");
        resetState(4);
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().n(this.x);
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().setSwitchView(this.A, this.B);
        this.n.start(this.y.getHolder(), this.G);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getPointerCount() == 1) {
                t(motionEvent.getX(), motionEvent.getY());
            }
            motionEvent.getPointerCount();
        } else if (action == 1) {
            this.R = true;
        } else if (action == 2) {
            if (motionEvent.getPointerCount() == 1) {
                this.R = true;
            }
            if (motionEvent.getPointerCount() == 2) {
                float x = motionEvent.getX(0);
                float y = motionEvent.getY(0);
                float sqrt = (float) java.lang.Math.sqrt(java.lang.Math.pow(x - motionEvent.getX(1), 2.0d) + java.lang.Math.pow(y - motionEvent.getY(1), 2.0d));
                if (this.R) {
                    this.S = sqrt;
                    this.R = false;
                }
                float f = this.S;
                if (((int) (sqrt - f)) / this.Q != 0) {
                    this.R = true;
                    this.n.zoom(sqrt - f, 145);
                }
            }
        }
        return true;
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void playVideo(android.graphics.Bitmap bitmap, java.lang.String str) {
        this.J = str;
        this.I = bitmap;
        new java.lang.Thread(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass9(str)).start();
    }

    public final void q() {
        int screenWidth = com.hbzhou.open.flowcamera.util.ScreenUtils.getScreenWidth(this.x);
        this.F = screenWidth;
        this.Q = (int) (screenWidth / 16.0f);
        com.hbzhou.open.flowcamera.util.LogUtil.i("zoom = " + this.Q);
        this.n = new com.hbzhou.open.flowcamera.state.CameraMachine(getContext(), this, this);
    }

    public final void r() {
        setWillNotDraw(false);
        android.view.View inflate = android.view.LayoutInflater.from(this.x).inflate(com.moji.camera.R.layout.camera_view, this);
        this.y = (android.widget.VideoView) inflate.findViewById(com.moji.camera.R.id.video_preview);
        this.z = (android.widget.ImageView) inflate.findViewById(com.moji.camera.R.id.image_photo);
        android.widget.ImageView imageView = (android.widget.ImageView) inflate.findViewById(com.moji.camera.R.id.image_switch);
        this.A = imageView;
        imageView.setImageResource(this.M);
        this.B = (android.widget.ImageView) inflate.findViewById(com.moji.camera.R.id.image_flash);
        s();
        this.B.setOnClickListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass1());
        com.hbzhou.open.flowcamera.CaptureLayout captureLayout = (com.hbzhou.open.flowcamera.CaptureLayout) inflate.findViewById(com.moji.camera.R.id.capture_layout);
        this.C = captureLayout;
        captureLayout.setDuration(this.P);
        this.C.setIconSrc(this.N, this.O);
        this.D = (com.hbzhou.open.flowcamera.FoucsView) inflate.findViewById(com.moji.camera.R.id.fouce_view);
        this.y.getHolder().addCallback(this);
        this.A.setOnClickListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass2());
        this.C.setCaptureLisenter(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass3());
        this.C.setTypeLisenter(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass4());
        this.C.setLeftClickListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass5());
        this.C.setRightClickListener(new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass6());
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void resetState(int i) {
        if (i == 1) {
            this.z.setVisibility(4);
        } else if (i == 2) {
            stopVideo();
            com.hbzhou.open.flowcamera.util.FileUtil.deleteFile(this.J);
            this.y.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            this.n.start(this.y.getHolder(), this.G);
        } else if (i == 4) {
            this.y.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
        this.A.setVisibility(0);
        this.B.setVisibility(0);
        this.C.resetCaptureLayout();
    }

    public final void s() {
        switch (this.t) {
            case 33:
                this.B.setImageResource(com.moji.camera.R.drawable.ic_camera_flash_auto);
                this.n.flash("auto");
                break;
            case 34:
                this.B.setImageResource(com.moji.camera.R.drawable.ic_camera_flash_open);
                this.n.flash(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON);
                break;
            case 35:
                this.B.setImageResource(com.moji.camera.R.drawable.ic_camera_flash_close);
                this.n.flash(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                break;
        }
    }

    public void setErrorLisenter(com.hbzhou.open.flowcamera.listener.ErrorListener errorListener) {
        this.T = errorListener;
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().p(errorListener);
    }

    public void setFeatures(int i) {
        this.C.setButtonFeatures(i);
    }

    public void setJCameraLisenter(com.hbzhou.open.flowcamera.listener.JCameraListener jCameraListener) {
        this.u = jCameraListener;
    }

    public void setLeftClickListener(com.hbzhou.open.flowcamera.listener.ClickListener clickListener) {
        this.v = clickListener;
    }

    public void setMediaQuality(int i) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().q(i);
    }

    public void setRightClickListener(com.hbzhou.open.flowcamera.listener.ClickListener clickListener) {
        this.w = clickListener;
    }

    public void setSaveVideoPath(java.lang.String str) {
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().r(str);
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void setTip(java.lang.String str) {
        this.C.setTip(str);
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void showPicture(android.graphics.Bitmap bitmap, boolean z) {
        if (z) {
            this.z.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        } else {
            this.z.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        }
        this.H = bitmap;
        this.z.setImageBitmap(bitmap);
        this.z.setVisibility(0);
        this.C.startAlphaAnimation();
        this.C.startTypeBtnAnimator();
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void startPreviewCallback() {
        com.hbzhou.open.flowcamera.util.LogUtil.i("startPreviewCallback");
        handlerFoucs(this.D.getWidth() / 2, this.D.getHeight() / 2);
    }

    @Override // com.hbzhou.open.flowcamera.view.CameraView
    public void stopVideo() {
        android.media.MediaPlayer mediaPlayer = this.E;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.E.stop();
        this.E.release();
        this.E = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("JCameraView SurfaceCreated");
        new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass7().start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        com.hbzhou.open.flowcamera.util.LogUtil.i("JCameraView SurfaceDestroyed");
        com.hbzhou.open.flowcamera.CameraInterface.getInstance().i();
    }

    public final void t(float f, float f2) {
        this.n.foucs(f, f2, new com.hbzhou.open.flowcamera.JCameraView.AnonymousClass8());
    }

    public final void u(float f, float f2) {
        if (f > f2) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, (int) ((f2 / f) * getWidth()));
            layoutParams.gravity = 17;
            this.y.setLayoutParams(layoutParams);
        }
    }
}

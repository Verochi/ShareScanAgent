package com.hbzhou.open.flowcamera;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes22.dex */
public class CustomCameraView extends android.widget.FrameLayout {
    public static final java.lang.String B = com.moji.tool.FilePathUtil.getRootMojiPath() + java.io.File.separator + "camera_x_temp";
    public static final int BUTTON_STATE_BOTH = 259;
    public static final int BUTTON_STATE_ONLY_CAPTURE = 257;
    public static final int BUTTON_STATE_ONLY_RECORDER = 258;
    public static final java.lang.String TAG = "CustomCameraView";
    public boolean A;
    public android.content.Context n;
    public com.otaliastudios.cameraview.CameraView t;
    public android.widget.ImageView u;
    public com.hbzhou.open.flowcamera.listener.FlowCameraListener v;
    public java.io.File w;
    public java.io.File x;
    public android.widget.VideoView y;
    public boolean z;

    /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$1, reason: invalid class name */
    public class AnonymousClass1 extends com.otaliastudios.cameraview.CameraListener {

        /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$1$1, reason: invalid class name and collision with other inner class name */
        public class C03561 implements com.otaliastudios.cameraview.FileCallback {
            public C03561() {
            }

            @Override // com.otaliastudios.cameraview.FileCallback
            public void onFileReady(@androidx.annotation.Nullable java.io.File file) {
                if (file == null || !file.exists()) {
                    android.widget.Toast.makeText(com.hbzhou.open.flowcamera.CustomCameraView.this.n, "文件不存在!", 1).show();
                    return;
                }
                com.hbzhou.open.flowcamera.CustomCameraView.this.x = file;
                com.bumptech.glide.Glide.with(com.hbzhou.open.flowcamera.CustomCameraView.this.n).load(file).into(com.hbzhou.open.flowcamera.CustomCameraView.this.u);
                com.hbzhou.open.flowcamera.CustomCameraView.this.u.setVisibility(0);
                if (com.hbzhou.open.flowcamera.CustomCameraView.this.v != null) {
                    com.hbzhou.open.flowcamera.CustomCameraView.this.v.captureSuccess(file);
                }
            }
        }

        /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$1$2, reason: invalid class name */
        public class AnonymousClass2 implements android.media.MediaPlayer.OnPreparedListener {
            public AnonymousClass2() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.start();
                if (com.hbzhou.open.flowcamera.CustomCameraView.this.v != null) {
                    com.hbzhou.open.flowcamera.CustomCameraView.this.v.recordSuccess(com.hbzhou.open.flowcamera.CustomCameraView.this.w, mediaPlayer.getDuration());
                }
            }
        }

        /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$1$3, reason: invalid class name */
        public class AnonymousClass3 implements android.media.MediaPlayer.OnCompletionListener {
            public AnonymousClass3() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(android.media.MediaPlayer mediaPlayer) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.resume();
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onCameraError(com.otaliastudios.cameraview.CameraException cameraException) {
            if (cameraException == null) {
                com.moji.tool.log.MJLogger.e(com.hbzhou.open.flowcamera.CustomCameraView.TAG, "onCameraError exception is null");
                return;
            }
            if (com.hbzhou.open.flowcamera.CustomCameraView.this.v != null && cameraException.getMessage() != null) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.v.onError(0, cameraException.getMessage(), null);
            }
            com.moji.tool.log.MJLogger.e(com.hbzhou.open.flowcamera.CustomCameraView.TAG, cameraException);
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onPictureTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.PictureResult pictureResult) {
            super.onPictureTaken(pictureResult);
            com.hbzhou.open.flowcamera.CustomCameraView customCameraView = com.hbzhou.open.flowcamera.CustomCameraView.this;
            pictureResult.toFile(customCameraView.initTakePicPath(customCameraView.n), new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass1.C03561());
        }

        @Override // com.otaliastudios.cameraview.CameraListener
        public void onVideoTaken(@androidx.annotation.NonNull com.otaliastudios.cameraview.VideoResult videoResult) {
            super.onVideoTaken(videoResult);
            com.hbzhou.open.flowcamera.CustomCameraView.this.w = videoResult.getFile();
            if (com.hbzhou.open.flowcamera.CustomCameraView.this.w.exists() && com.hbzhou.open.flowcamera.CustomCameraView.this.z) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.setVideoPath(com.hbzhou.open.flowcamera.CustomCameraView.this.w.getAbsolutePath());
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.setVisibility(0);
                com.hbzhou.open.flowcamera.CustomCameraView.this.t.setVisibility(8);
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.setOnPreparedListener(new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass1.AnonymousClass2());
                com.hbzhou.open.flowcamera.CustomCameraView.this.y.setOnCompletionListener(new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass1.AnonymousClass3());
            }
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.lifecycle.LifecycleEventObserver {
        public AnonymousClass2() {
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            com.hbzhou.open.flowcamera.util.LogUtil.i("event---", event.toString());
            if (event == androidx.lifecycle.Lifecycle.Event.ON_RESUME) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.t.open();
            } else if (event == androidx.lifecycle.Lifecycle.Event.ON_PAUSE) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.t.close();
            } else if (event == androidx.lifecycle.Lifecycle.Event.ON_DESTROY) {
                com.hbzhou.open.flowcamera.CustomCameraView.this.t.destroy();
            }
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CustomCameraView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.otaliastudios.cameraview.CameraView cameraView = com.hbzhou.open.flowcamera.CustomCameraView.this.t;
            com.hbzhou.open.flowcamera.CustomCameraView customCameraView = com.hbzhou.open.flowcamera.CustomCameraView.this;
            cameraView.takeVideoSnapshot(customCameraView.initStartRecordingPath(customCameraView.n));
        }
    }

    public CustomCameraView(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public CustomCameraView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomCameraView(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = context;
        initView();
    }

    private java.io.File getCacheFile() {
        java.io.File file = new java.io.File(B);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void addFrameProcessor(com.otaliastudios.cameraview.frame.FrameProcessor frameProcessor) {
        this.t.addFrameProcessor(frameProcessor);
    }

    public com.otaliastudios.cameraview.controls.Facing getFacing() {
        return this.t.getFacing();
    }

    public com.otaliastudios.cameraview.controls.Mode getMode() {
        return this.t.getMode();
    }

    public java.io.File initStartRecordingPath(android.content.Context context) {
        return new java.io.File(getCacheFile(), java.lang.System.currentTimeMillis() + ".mp4");
    }

    public java.io.File initTakePicPath(android.content.Context context) {
        return new java.io.File(getCacheFile(), java.lang.System.currentTimeMillis() + ".jpg");
    }

    public void initView() {
        setWillNotDraw(false);
        android.view.View inflate = android.view.LayoutInflater.from(this.n).inflate(com.moji.camera.R.layout.custom_camera_view, this);
        this.t = (com.otaliastudios.cameraview.CameraView) inflate.findViewById(com.moji.camera.R.id.video_preview);
        this.u = (android.widget.ImageView) inflate.findViewById(com.moji.camera.R.id.image_photo);
        this.t.setHdr(com.otaliastudios.cameraview.controls.Hdr.ON);
        this.t.setAudio(com.otaliastudios.cameraview.controls.Audio.OFF);
        this.t.setPlaySounds(false);
        this.t.mapGesture(com.otaliastudios.cameraview.gesture.Gesture.TAP, com.otaliastudios.cameraview.gesture.GestureAction.AUTO_FOCUS);
        android.widget.VideoView videoView = (android.widget.VideoView) inflate.findViewById(com.moji.camera.R.id.videoView);
        this.y = videoView;
        videoView.setZOrderMediaOverlay(true);
        this.t.setSnapshotMaxHeight(2560);
        this.t.setSnapshotMaxWidth(1440);
        this.t.setFrameProcessingMaxHeight(2560);
        this.t.setFrameProcessingMaxWidth(1440);
        com.otaliastudios.cameraview.size.SizeSelector and = com.otaliastudios.cameraview.size.SizeSelectors.and(com.otaliastudios.cameraview.size.SizeSelectors.minWidth(1440), com.otaliastudios.cameraview.size.SizeSelectors.minHeight(2560));
        com.otaliastudios.cameraview.size.SizeSelector aspectRatio = com.otaliastudios.cameraview.size.SizeSelectors.aspectRatio(com.otaliastudios.cameraview.size.AspectRatio.of(9, 16), 0.0f);
        com.otaliastudios.cameraview.size.SizeSelector or = com.otaliastudios.cameraview.size.SizeSelectors.or(com.otaliastudios.cameraview.size.SizeSelectors.and(aspectRatio, and), aspectRatio, com.otaliastudios.cameraview.size.SizeSelectors.biggest());
        this.t.setPreviewStreamSize(or);
        this.t.setVideoSize(or);
        this.t.setPictureSize(or);
        this.t.addCameraListener(new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass1());
        this.t.setEngine(com.otaliastudios.cameraview.controls.Engine.CAMERA2);
    }

    public boolean isVideo() {
        return this.A;
    }

    public void onDestroy() {
        this.t.destroy();
    }

    public void removeFrameProcessor(com.otaliastudios.cameraview.frame.FrameProcessor frameProcessor) {
        this.t.removeFrameProcessor(frameProcessor);
    }

    public void setBindToLifecycle(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        this.t.setLifecycleOwner(lifecycleOwner);
        lifecycleOwner.getLifecycle().addObserver(new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass2());
    }

    public void setFlowCameraListener(com.hbzhou.open.flowcamera.listener.FlowCameraListener flowCameraListener) {
        this.v = flowCameraListener;
    }

    public void setPlaySounds(boolean z) {
        this.t.setPlaySounds(z);
    }

    public void startRecordVideo() {
        if (this.t.isTakingVideo()) {
            this.t.stopVideo();
        }
        this.A = true;
        this.t.postDelayed(new com.hbzhou.open.flowcamera.CustomCameraView.AnonymousClass3(), 100L);
    }

    public void stopPreView() {
        if (!isVideo()) {
            this.u.setVisibility(4);
            this.t.setVisibility(0);
        } else {
            this.y.stopPlayback();
            this.t.setVisibility(0);
            this.y.setVisibility(8);
        }
    }

    public void stopRecordVideo(boolean z) {
        this.z = z;
        this.t.stopVideo();
    }

    public void takePictureSnapshot() {
        this.A = false;
        this.t.takePictureSnapshot();
    }

    public void toggleFacing() {
        this.t.toggleFacing();
    }
}

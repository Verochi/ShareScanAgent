package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class DisplayViewHelper {
    private static final java.lang.String TAG = "AliDisplayView_" + com.aliyun.player.nativeclass.DisplayViewHelper.class.getSimpleName();
    private com.aliyun.player.videoview.AliDisplayView mAliView;
    private com.aliyun.player.videoview.a.a mDisPlayView = null;
    private android.view.View mClearScreenView = null;
    private int oldWith = -1;
    private int oldHeight = -1;
    private boolean surfaceValid = false;
    private java.util.List<com.aliyun.player.videoview.a.a> mOldDisplayViews = new java.util.ArrayList();
    private int mBackgroundColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private int mVideoWidth = 0;
    private int mVideoHeight = 0;
    private int mVideoRotate = 0;
    private com.aliyun.player.IPlayer.ScaleMode mScaleMode = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
    private com.aliyun.player.IPlayer.MirrorMode mMirrorMode = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
    private com.aliyun.player.IPlayer.RotateMode mRotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
    private boolean mDirectRender = false;
    private com.aliyun.player.videoview.a.a.h mListener = null;
    private boolean mReuseSurface = true;

    /* renamed from: com.aliyun.player.nativeclass.DisplayViewHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int measuredWidth = com.aliyun.player.nativeclass.DisplayViewHelper.this.mAliView.getMeasuredWidth();
            int measuredHeight = com.aliyun.player.nativeclass.DisplayViewHelper.this.mAliView.getMeasuredHeight();
            if (measuredWidth == com.aliyun.player.nativeclass.DisplayViewHelper.this.oldWith && measuredHeight == com.aliyun.player.nativeclass.DisplayViewHelper.this.oldHeight) {
                return;
            }
            com.aliyun.player.nativeclass.DisplayViewHelper.this.oldWith = measuredWidth;
            com.aliyun.player.nativeclass.DisplayViewHelper.this.oldHeight = measuredHeight;
            if (com.aliyun.player.nativeclass.DisplayViewHelper.this.mDisPlayView != null) {
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mDisPlayView.d();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.DisplayViewHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.player.videoview.a.a.h {
        final /* synthetic */ com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener val$mOutOnViewStatusListener;

        public AnonymousClass2(com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener) {
            this.val$mOutOnViewStatusListener = onViewStatusListener;
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceCreated(android.view.Surface surface) {
            com.aliyun.player.nativeclass.DisplayViewHelper.this.surfaceValid = true;
            if (com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener != null) {
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener.onSurfaceCreated(surface);
            }
            com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener = this.val$mOutOnViewStatusListener;
            if (onViewStatusListener != null) {
                onViewStatusListener.onSurfaceCreated();
            }
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceDestroy() {
            com.aliyun.player.nativeclass.DisplayViewHelper.this.surfaceValid = false;
            if (com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener != null) {
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener.onSurfaceDestroy();
            }
            com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener = this.val$mOutOnViewStatusListener;
            if (onViewStatusListener != null) {
                onViewStatusListener.onSurfaceDestroy();
            }
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceSizeChanged() {
            if (com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener != null) {
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mListener.onSurfaceSizeChanged();
            }
            com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener = this.val$mOutOnViewStatusListener;
            if (onViewStatusListener != null) {
                onViewStatusListener.onSurfaceSizeChanged();
            }
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onViewCreated(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType) {
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.DisplayViewHelper$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.nativeclass.DisplayViewHelper.this.mClearScreenView.setVisibility(0);
            for (com.aliyun.player.videoview.a.a aVar : com.aliyun.player.nativeclass.DisplayViewHelper.this.mOldDisplayViews) {
                if (aVar != null) {
                    aVar.b();
                }
            }
            com.aliyun.player.nativeclass.DisplayViewHelper.this.mOldDisplayViews.clear();
            if (com.aliyun.player.nativeclass.DisplayViewHelper.this.mDisPlayView != null) {
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mDisPlayView.b();
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mDisPlayView = null;
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.DisplayViewHelper$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ boolean val$hasVideo;

        public AnonymousClass4(boolean z) {
            this.val$hasVideo = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$hasVideo) {
                for (com.aliyun.player.videoview.a.a aVar : com.aliyun.player.nativeclass.DisplayViewHelper.this.mOldDisplayViews) {
                    if (aVar != null) {
                        aVar.b();
                    }
                }
                com.aliyun.player.nativeclass.DisplayViewHelper.this.mOldDisplayViews.clear();
            }
            com.aliyun.player.nativeclass.DisplayViewHelper.this.mClearScreenView.setVisibility(4);
        }
    }

    public DisplayViewHelper(com.aliyun.player.videoview.AliDisplayView aliDisplayView) {
        this.mAliView = aliDisplayView;
        init();
    }

    private void init() {
        this.mClearScreenView = new android.view.View(this.mAliView.getContext());
        this.mAliView.addView(this.mClearScreenView, new android.widget.FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(android.graphics.Color.parseColor("#FF000000"));
        this.mAliView.getViewTreeObserver().addOnGlobalLayoutListener(new com.aliyun.player.nativeclass.DisplayViewHelper.AnonymousClass1());
    }

    private void runOnUiThread(java.lang.Runnable runnable) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mClearScreenView.post(runnable);
        }
    }

    public void clearScreen() {
        com.cicada.player.utils.Logger.i(TAG, "clearScreen ");
        runOnUiThread(new com.aliyun.player.nativeclass.DisplayViewHelper.AnonymousClass3());
    }

    public synchronized void createDisplayView(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType, boolean z) {
        com.aliyun.player.videoview.a.a bVar;
        com.aliyun.player.videoview.AliDisplayView.DisplayViewType preferDisplayViewType = this.mAliView.getPreferDisplayViewType();
        if (displayViewType == null || displayViewType == com.aliyun.player.videoview.AliDisplayView.DisplayViewType.Either) {
            displayViewType = preferDisplayViewType;
        }
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (displayViewType == com.aliyun.player.videoview.AliDisplayView.DisplayViewType.TextureView) {
            bVar = new com.aliyun.player.videoview.a.c(this.mAliView);
            this.mDisPlayView = bVar;
        } else {
            bVar = new com.aliyun.player.videoview.a.b(this.mAliView);
            this.mDisPlayView = bVar;
        }
        bVar.c();
        com.aliyun.player.videoview.a.a.h hVar = this.mListener;
        if (hVar != null) {
            hVar.onViewCreated(displayViewType);
        }
        com.aliyun.player.videoview.AliDisplayView.OnViewStatusListener onViewStatusListener = this.mAliView.getOnViewStatusListener();
        if (onViewStatusListener != null) {
            onViewStatusListener.onViewCreated(displayViewType);
        }
        com.aliyun.player.videoview.a.a aVar2 = this.mDisPlayView;
        if (aVar2 != null) {
            aVar2.a(new com.aliyun.player.nativeclass.DisplayViewHelper.AnonymousClass2(onViewStatusListener));
            this.mDisPlayView.b(this.mReuseSurface);
            setRenderFlagChanged(z);
            this.mDisPlayView.a(this.mVideoWidth, this.mVideoHeight, this.mVideoRotate);
            this.mDisPlayView.b(this.mMirrorMode);
            this.mDisPlayView.b(this.mRotateMode);
            this.mDisPlayView.a(this.mScaleMode);
            this.mDisPlayView.a();
            if (aVar != null) {
                aVar.a((com.aliyun.player.videoview.a.a.h) null);
                this.mOldDisplayViews.add(aVar);
            }
        }
    }

    public void firstFrameRender(boolean z) {
        com.cicada.player.utils.Logger.i(TAG, "firstFrameRender , hasVideo = " + z);
        runOnUiThread(new com.aliyun.player.nativeclass.DisplayViewHelper.AnonymousClass4(z));
    }

    public boolean needUpdateView(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType) {
        return true;
    }

    public void setBackgroundColor(int i) {
        com.cicada.player.utils.Logger.i(TAG, "setBackgroundColor " + i);
        this.mBackgroundColor = i;
        android.view.View view = this.mClearScreenView;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        this.mAliView.setBackgroundColor(i);
    }

    public void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        com.cicada.player.utils.Logger.i(TAG, "setMirrorMode " + mirrorMode);
        this.mMirrorMode = mirrorMode;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(mirrorMode);
        }
    }

    public void setOnViewStatusListener(com.aliyun.player.videoview.a.a.h hVar) {
        this.mListener = hVar;
    }

    public void setRenderFlagChanged(boolean z) {
        com.cicada.player.utils.Logger.i(TAG, "setRenderFlagChanged = " + z);
        this.mDirectRender = z;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        com.cicada.player.utils.Logger.i(TAG, "setRotateMode " + rotateMode);
        this.mRotateMode = rotateMode;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(rotateMode);
        }
    }

    public void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        com.cicada.player.utils.Logger.i(TAG, "setScaleMode " + scaleMode);
        this.mScaleMode = scaleMode;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(scaleMode);
        }
    }

    public void setSurfaceReuse(boolean z) {
        this.mReuseSurface = z;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void setVideoSize(int i, int i2, int i3) {
        com.cicada.player.utils.Logger.i(TAG, "setVideoSize " + i + " , " + i2);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mVideoRotate = i3;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar != null) {
            aVar.a(i, i2, i3);
        }
    }

    public android.graphics.Bitmap snapshot() {
        android.graphics.Bitmap f;
        com.aliyun.player.videoview.a.a aVar = this.mDisPlayView;
        if (aVar == null || (f = aVar.f()) == null) {
            return null;
        }
        this.mAliView.buildDrawingCache();
        android.graphics.Bitmap drawingCache = this.mAliView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(drawingCache.getWidth(), drawingCache.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        canvas.drawBitmap(drawingCache, 0.0f, 0.0f, new android.graphics.Paint());
        drawingCache.recycle();
        canvas.drawBitmap(f, (drawingCache.getWidth() - f.getWidth()) / 2.0f, (drawingCache.getHeight() - f.getHeight()) / 2.0f, new android.graphics.Paint());
        f.recycle();
        if (this.mClearScreenView.getVisibility() == 0) {
            this.mClearScreenView.buildDrawingCache();
            android.graphics.Bitmap drawingCache2 = this.mClearScreenView.getDrawingCache();
            if (drawingCache2 != null) {
                canvas.drawBitmap(drawingCache2, 0.0f, 0.0f, new android.graphics.Paint());
                drawingCache2.recycle();
            }
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}

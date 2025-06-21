package com.aliyun.svideosdk.editor.pplayer;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AnimPlayerView implements android.view.TextureView.SurfaceTextureListener {
    private static final java.lang.String TAG = "AnimPlayerView";
    private boolean _isMirror;
    private com.aliyun.svideosdk.editor.pplayer.c clock;
    private long end;
    private boolean isPreview;
    private java.util.List<com.aliyun.svideosdk.editor.pplayer.a> mAnimBlocks = new java.util.ArrayList();
    private java.util.List<com.aliyun.svideosdk.editor.pplayer.AnimPlayerView.a> mAnimFrames = new java.util.ArrayList();
    private com.aliyun.svideosdk.editor.pplayer.b mAnimationPlayer;
    private long mDuration;
    private android.view.Surface mSurface;
    private android.view.TextureView mTextureView;
    private java.lang.String path;
    private long start;

    public class a {
        public long a;
        public int b;

        public a(com.aliyun.svideosdk.editor.pplayer.AnimPlayerView animPlayerView, long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    public AnimPlayerView(android.view.TextureView textureView) {
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(this);
        this.mTextureView.setOpaque(false);
    }

    private void initAnimation() {
        if (android.text.TextUtils.isEmpty(this.path) || this.mSurface == null) {
            return;
        }
        this.mAnimationPlayer = new com.aliyun.svideosdk.editor.pplayer.b(this.mSurface, this.path);
        java.util.Iterator<com.aliyun.svideosdk.editor.pplayer.a> it = this.mAnimBlocks.iterator();
        while (it.hasNext()) {
            this.mAnimationPlayer.a(it.next());
        }
        for (com.aliyun.svideosdk.editor.pplayer.AnimPlayerView.a aVar : this.mAnimFrames) {
            this.mAnimationPlayer.a(aVar.a, aVar.b);
        }
        this.mAnimationPlayer.b(this.mDuration);
        this.mAnimationPlayer.a(this.start, this.end);
        this.mAnimationPlayer.a(this.isPreview);
        this.mAnimationPlayer.a(this.clock);
        this.mAnimationPlayer.f();
    }

    public void addFrameList(long j, int i) {
        this.mAnimFrames.add(new com.aliyun.svideosdk.editor.pplayer.AnimPlayerView.a(this, j, i));
    }

    public java.lang.String getAnimationPath() {
        return this.path;
    }

    public long getCurrentPosition() {
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar == null) {
            return 0L;
        }
        return bVar.d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurface = new android.view.Surface(this.mTextureView.getSurfaceTexture());
        initAnimation();
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        if (this._isMirror) {
            matrix.setScale(-1.0f, 1.0f, i / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
        release();
        this.mSurface.release();
        this.mSurface = null;
        this.mAnimationPlayer = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        if (this._isMirror) {
            matrix.setScale(-1.0f, 1.0f, i / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void release() {
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void setAnimationBlocks(java.util.List<com.aliyun.svideosdk.editor.pplayer.a> list) {
        this.mAnimBlocks.addAll(list);
    }

    public void setAnimationPath(java.lang.String str) {
        this.path = str;
        initAnimation();
    }

    public void setDefaltDuration(long j) {
        this.mDuration = j;
    }

    public void setExternalClock(com.aliyun.svideosdk.editor.pplayer.c cVar) {
        this.clock = cVar;
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }

    public void setMirror(boolean z) {
        this._isMirror = z;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        if (z) {
            matrix.setScale(-1.0f, 1.0f, this.mTextureView.getWidth() / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    public void setPlayTime(long j, long j2) {
        this.start = j;
        this.end = j2;
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(j, j2);
        }
    }

    public void setPreview(boolean z) {
        this.isPreview = z;
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void start() {
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.f();
        } else {
            initAnimation();
        }
    }

    public void stop() {
        com.aliyun.svideosdk.editor.pplayer.b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.g();
        }
    }
}

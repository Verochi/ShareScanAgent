package com.aliyun.player.videoview.a;

/* loaded from: classes.dex */
public class c extends com.aliyun.player.videoview.a.a {
    private static final java.lang.String l = "AliDisplayView_" + com.aliyun.player.videoview.a.c.class.getSimpleName();
    private android.view.TextureView m;
    private android.graphics.SurfaceTexture n;
    private android.view.Surface o;
    private boolean p;

    public class a implements android.view.TextureView.SurfaceTextureListener {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x006d  */
        @Override // android.view.TextureView.SurfaceTextureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSurfaceTextureAvailable(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.aliyun.player.videoview.a.c cVar;
            android.view.Surface surface;
            com.aliyun.player.videoview.a.a.h hVar;
            if (com.aliyun.player.videoview.a.c.this.n == null) {
                com.aliyun.player.videoview.a.c.this.n = surfaceTexture;
                cVar = com.aliyun.player.videoview.a.c.this;
                surface = new android.view.Surface(surfaceTexture);
            } else {
                if (com.aliyun.player.videoview.a.c.this.p) {
                    com.aliyun.player.videoview.a.c.this.m.setSurfaceTexture(com.aliyun.player.videoview.a.c.this.n);
                    com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.c.l, com.aliyun.player.videoview.a.c.this.m + " onSurfaceTextureAvailable  " + surfaceTexture);
                    com.aliyun.player.videoview.a.c cVar2 = com.aliyun.player.videoview.a.c.this;
                    hVar = cVar2.c;
                    if (hVar == null) {
                        hVar.onSurfaceCreated(cVar2.o);
                        return;
                    }
                    return;
                }
                com.aliyun.player.videoview.a.c.this.o.release();
                com.aliyun.player.videoview.a.c.this.n = surfaceTexture;
                cVar = com.aliyun.player.videoview.a.c.this;
                surface = new android.view.Surface(surfaceTexture);
            }
            cVar.o = surface;
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.c.l, com.aliyun.player.videoview.a.c.this.m + " onSurfaceTextureAvailable  " + surfaceTexture);
            com.aliyun.player.videoview.a.c cVar22 = com.aliyun.player.videoview.a.c.this;
            hVar = cVar22.c;
            if (hVar == null) {
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(android.graphics.SurfaceTexture surfaceTexture) {
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.c.l, com.aliyun.player.videoview.a.c.this.m + " onSurfaceTextureDestroyed  ");
            com.aliyun.player.videoview.a.a.h hVar = com.aliyun.player.videoview.a.c.this.c;
            if (hVar == null) {
                return false;
            }
            hVar.onSurfaceDestroy();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(android.graphics.SurfaceTexture surfaceTexture, int i, int i2) {
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.c.l, com.aliyun.player.videoview.a.c.this.m + " onSurfaceTextureSizeChanged  ");
            com.aliyun.player.videoview.a.a.h hVar = com.aliyun.player.videoview.a.c.this.c;
            if (hVar != null) {
                hVar.onSurfaceSizeChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(android.graphics.SurfaceTexture surfaceTexture) {
        }
    }

    public c(android.view.ViewGroup viewGroup) {
        super(viewGroup);
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
    }

    private android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.preRotate(this.m.getRotation());
        matrix.preScale(this.m.getScaleX(), this.m.getScaleY());
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override // com.aliyun.player.videoview.a.a
    public android.view.View a(android.content.Context context) {
        android.view.TextureView textureView = new android.view.TextureView(context);
        this.m = textureView;
        textureView.setSurfaceTextureListener(new com.aliyun.player.videoview.a.c.a());
        return this.m;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        if (mirrorMode == com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_HORIZONTAL) {
            this.m.setScaleX(-1.0f);
            this.m.setScaleY(1.0f);
            return true;
        }
        if (mirrorMode == com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_VERTICAL) {
            this.m.setScaleY(-1.0f);
        } else {
            this.m.setScaleY(1.0f);
        }
        this.m.setScaleX(1.0f);
        return true;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        android.view.TextureView textureView;
        float f;
        if (rotateMode == com.aliyun.player.IPlayer.RotateMode.ROTATE_90) {
            textureView = this.m;
            f = 90.0f;
        } else if (rotateMode == com.aliyun.player.IPlayer.RotateMode.ROTATE_180) {
            textureView = this.m;
            f = 180.0f;
        } else if (rotateMode == com.aliyun.player.IPlayer.RotateMode.ROTATE_270) {
            textureView = this.m;
            f = 270.0f;
        } else {
            textureView = this.m;
            f = 0.0f;
        }
        textureView.setRotation(f);
        return true;
    }

    @Override // com.aliyun.player.videoview.a.a
    public void b(boolean z) {
        this.p = z;
    }

    @Override // com.aliyun.player.videoview.a.a
    public android.graphics.Bitmap e() {
        android.graphics.Bitmap bitmap = this.m.getBitmap();
        android.graphics.Bitmap a2 = a(bitmap);
        bitmap.recycle();
        return a2;
    }
}

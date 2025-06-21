package com.aliyun.player.videoview.a;

/* loaded from: classes.dex */
public class b extends com.aliyun.player.videoview.a.a {
    private static final java.lang.String l = "AliDisplayView_" + com.aliyun.player.videoview.a.b.class.getSimpleName();
    private android.view.SurfaceView m;

    public class a implements android.view.SurfaceHolder.Callback2 {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.b.l, "surfaceChanged ");
            com.aliyun.player.videoview.a.a.h hVar = com.aliyun.player.videoview.a.b.this.c;
            if (hVar != null) {
                hVar.onSurfaceSizeChanged();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
            android.view.Surface surface = surfaceHolder.getSurface();
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.b.l, "onSurfaceCreated  " + surface);
            com.aliyun.player.videoview.a.a.h hVar = com.aliyun.player.videoview.a.b.this.c;
            if (hVar != null) {
                hVar.onSurfaceCreated(surface);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.b.l, "surfaceDestroyed ");
            com.aliyun.player.videoview.a.a.h hVar = com.aliyun.player.videoview.a.b.this.c;
            if (hVar != null) {
                hVar.onSurfaceDestroy();
            }
        }

        @Override // android.view.SurfaceHolder.Callback2
        public void surfaceRedrawNeeded(android.view.SurfaceHolder surfaceHolder) {
            com.cicada.player.utils.Logger.i(com.aliyun.player.videoview.a.b.l, "surfaceRedrawNeeded ");
        }
    }

    public b(android.view.ViewGroup viewGroup) {
        super(viewGroup);
        this.m = null;
    }

    @Override // com.aliyun.player.videoview.a.a
    public android.view.View a(android.content.Context context) {
        android.view.SurfaceView surfaceView = new android.view.SurfaceView(context);
        this.m = surfaceView;
        surfaceView.getHolder().addCallback(new com.aliyun.player.videoview.a.b.a());
        return this.m;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        return false;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        return false;
    }

    @Override // com.aliyun.player.videoview.a.a
    public void b(boolean z) {
    }

    @Override // com.aliyun.player.videoview.a.a
    public android.graphics.Bitmap e() {
        return null;
    }
}

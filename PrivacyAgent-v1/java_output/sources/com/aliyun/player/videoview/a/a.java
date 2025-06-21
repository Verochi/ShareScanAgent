package com.aliyun.player.videoview.a;

/* loaded from: classes.dex */
public abstract class a {
    private static final java.lang.String a = "AliDisplayView_" + com.aliyun.player.videoview.a.a.class.getSimpleName();
    private final android.view.ViewGroup b;
    protected com.aliyun.player.videoview.a.a.h c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private com.aliyun.player.IPlayer.ScaleMode g = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
    private com.aliyun.player.IPlayer.MirrorMode h = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
    private com.aliyun.player.IPlayer.RotateMode i = com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
    private boolean j = false;
    private android.view.View k = null;

    /* renamed from: com.aliyun.player.videoview.a.a$a, reason: collision with other inner class name */
    public class RunnableC0053a implements java.lang.Runnable {
        public RunnableC0053a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.g();
        }
    }

    public class b implements java.lang.Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.g();
        }
    }

    public class c implements java.lang.Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.g();
        }
    }

    public class d implements java.lang.Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.g();
        }
    }

    public class e implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.IPlayer.MirrorMode a;

        public e(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
            this.a = mirrorMode;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.a(this.a);
        }
    }

    public class f implements java.lang.Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.videoview.a.a.this.k.getParent() == com.aliyun.player.videoview.a.a.this.b) {
                com.aliyun.player.videoview.a.a.this.b.removeView(com.aliyun.player.videoview.a.a.this.k);
            }
        }
    }

    public class g implements java.lang.Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.videoview.a.a.this.b.addView(com.aliyun.player.videoview.a.a.this.k, 0);
            com.aliyun.player.videoview.a.a aVar = com.aliyun.player.videoview.a.a.this;
            aVar.c(aVar.h);
            com.aliyun.player.videoview.a.a aVar2 = com.aliyun.player.videoview.a.a.this;
            aVar2.b(aVar2.g);
            com.aliyun.player.videoview.a.a aVar3 = com.aliyun.player.videoview.a.a.this;
            aVar3.c(aVar3.i);
            com.aliyun.player.videoview.a.a.this.g();
        }
    }

    public interface h {
        void onSurfaceCreated(android.view.Surface surface);

        void onSurfaceDestroy();

        void onSurfaceSizeChanged();

        void onViewCreated(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType);
    }

    public a(android.view.ViewGroup viewGroup) {
        this.b = viewGroup;
        com.cicada.player.utils.Logger.v(a, this + " new IDisplayView()");
    }

    private void a(java.lang.Runnable runnable) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        if (scaleMode != null) {
            this.g = scaleMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        if (mirrorMode != null) {
            this.h = mirrorMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        if (rotateMode != null) {
            this.i = rotateMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007e, code lost:
    
        if (r4 < r7) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        r3 = (int) (((r1 * 1.0f) * r6) / r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        if (r4 > r7) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g() {
        java.lang.String str;
        int i;
        int i2;
        java.lang.String str2 = a;
        com.cicada.player.utils.Logger.v(str2, "updateViewParams  ");
        if (!this.j) {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            if (this.k.getParent() == this.b) {
                this.k.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        if (this.e == 0 || this.d == 0) {
            str = "updateViewParams ，unknow videoheight and width ";
        } else {
            int measuredWidth = this.b.getMeasuredWidth();
            int measuredHeight = this.b.getMeasuredHeight();
            if (measuredWidth != 0 && measuredHeight != 0) {
                if (a(this.i)) {
                    int value = (int) (this.f + this.i.getValue());
                    if (value == 90 || value == 270) {
                        measuredWidth = this.b.getMeasuredHeight();
                        measuredHeight = this.b.getMeasuredWidth();
                    }
                }
                com.aliyun.player.IPlayer.ScaleMode scaleMode = this.g;
                if (scaleMode != com.aliyun.player.IPlayer.ScaleMode.SCALE_TO_FILL) {
                    if (scaleMode == com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FILL) {
                        i = this.d;
                        int i3 = i * measuredHeight;
                        i2 = this.e;
                        int i4 = measuredWidth * i2;
                        if (i3 <= i4) {
                        }
                        measuredWidth = (int) (((measuredHeight * 1.0f) * i) / i2);
                    } else {
                        i = this.d;
                        int i5 = i * measuredHeight;
                        i2 = this.e;
                        int i6 = measuredWidth * i2;
                        if (i5 >= i6) {
                        }
                        measuredWidth = (int) (((measuredHeight * 1.0f) * i) / i2);
                    }
                }
                android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutParams2.width = measuredWidth;
                layoutParams2.height = measuredHeight;
                layoutParams2.gravity = 17;
                if (this.k.getParent() == this.b) {
                    this.k.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            str = "updateViewParams ，unknow parent height and width ";
        }
        com.cicada.player.utils.Logger.w(str2, str);
    }

    public abstract android.view.View a(android.content.Context context);

    public void a() {
        com.cicada.player.utils.Logger.v(a, " attachView");
        a(new com.aliyun.player.videoview.a.a.g());
    }

    public void a(int i, int i2, int i3) {
        com.cicada.player.utils.Logger.v(a, "setVideoSize  " + i + " ， " + i2 + " ， " + i3);
        this.d = i;
        this.e = i2;
        this.f = i3;
        a(new com.aliyun.player.videoview.a.a.c());
    }

    public void a(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        com.cicada.player.utils.Logger.v(a, "setScaleMode  " + scaleMode);
        b(scaleMode);
        a(new com.aliyun.player.videoview.a.a.d());
    }

    public void a(com.aliyun.player.videoview.a.a.h hVar) {
        com.cicada.player.utils.Logger.v(a, this + " setOnViewStatusListener " + hVar);
        this.c = hVar;
    }

    public void a(boolean z) {
        com.cicada.player.utils.Logger.v(a, "setRenderFlag  " + z);
        this.j = z;
        a(new com.aliyun.player.videoview.a.a.b());
    }

    public abstract boolean a(com.aliyun.player.IPlayer.MirrorMode mirrorMode);

    public abstract boolean a(com.aliyun.player.IPlayer.RotateMode rotateMode);

    public void b() {
        com.cicada.player.utils.Logger.v(a, " detachView");
        a(new com.aliyun.player.videoview.a.a.f());
    }

    public void b(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        com.cicada.player.utils.Logger.v(a, "setMirrorMode  " + mirrorMode);
        c(mirrorMode);
        this.k.post(new com.aliyun.player.videoview.a.a.e(mirrorMode));
    }

    public void b(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        com.cicada.player.utils.Logger.v(a, "setRotateMode  " + rotateMode);
        c(rotateMode);
        g();
    }

    public abstract void b(boolean z);

    public void c() {
        this.k = a(this.b.getContext());
    }

    public void d() {
        com.cicada.player.utils.Logger.v(a, "parentSizeChanged  ");
        a(new com.aliyun.player.videoview.a.a.RunnableC0053a());
    }

    public abstract android.graphics.Bitmap e();

    public android.graphics.Bitmap f() {
        return e();
    }
}

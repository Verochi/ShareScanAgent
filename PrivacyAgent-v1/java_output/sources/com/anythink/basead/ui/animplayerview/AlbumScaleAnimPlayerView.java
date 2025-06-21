package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public class AlbumScaleAnimPlayerView extends com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView {
    private java.util.List<android.graphics.Bitmap> A;
    private android.graphics.Paint B;
    private com.anythink.basead.ui.animplayerview.c y;
    private boolean z;

    /* renamed from: com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, com.anythink.basead.c.f.O));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.e)) {
                if (com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y == null) {
                    com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView(com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.getContext().getApplicationContext());
                    com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y.setBitmapResources(com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.A);
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView albumScaleAnimPlayerView = com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this;
                    albumScaleAnimPlayerView.addView((android.view.View) albumScaleAnimPlayerView.y, layoutParams);
                    com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y.addMainView(bitmap, new com.anythink.basead.ui.WrapRoundImageView[0]);
                }
                if (com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.z) {
                    com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.d(com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this);
                    if (com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y != null) {
                        com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.this.y.start();
                    }
                }
            }
        }
    }

    public AlbumScaleAnimPlayerView(android.content.Context context) {
        this(context, null);
    }

    public AlbumScaleAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static /* synthetic */ boolean d(com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView albumScaleAnimPlayerView) {
        albumScaleAnimPlayerView.z = false;
        return false;
    }

    private void j() {
        android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{android.graphics.Color.parseColor("#DF4B32"), android.graphics.Color.parseColor("#800915")}, new float[]{0.0f, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.B = paint;
        paint.setShader(linearGradient);
    }

    private void k() {
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.AnonymousClass1());
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        com.anythink.basead.ui.animplayerview.c cVar = this.y;
        if (cVar != null) {
            cVar.start();
        } else {
            this.z = true;
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(android.content.Context context) {
        android.graphics.LinearGradient linearGradient = new android.graphics.LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), new int[]{android.graphics.Color.parseColor("#DF4B32"), android.graphics.Color.parseColor("#800915")}, new float[]{0.0f, 1.0f}, android.graphics.Shader.TileMode.CLAMP);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.B = paint;
        paint.setShader(linearGradient);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView.AnonymousClass1());
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        com.anythink.basead.ui.animplayerview.c cVar = this.y;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        com.anythink.basead.ui.animplayerview.c cVar = this.y;
        if (cVar != null) {
            cVar.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        com.anythink.basead.ui.animplayerview.c cVar = this.y;
        if (cVar != null) {
            cVar.release();
            this.y = null;
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final int e() {
        return 4000;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView, com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        this.A = list;
        super.init(lVar, mVar, z, list);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.B != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.B);
        }
    }
}

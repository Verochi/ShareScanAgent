package com.anythink.basead.ui.animplayerview.scale;

/* loaded from: classes12.dex */
public class AlbumScaleAnimatorView extends android.widget.FrameLayout implements com.anythink.basead.ui.animplayerview.c {
    private java.util.List<android.graphics.Bitmap> a;
    private com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView b;
    private com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView c;
    private com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView d;
    private com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView e;
    private boolean f;

    /* renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.a(com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this);
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.c.start();
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.d.setStartDelay(200L);
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.d.start();
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.b.setStartDelay(300L);
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.b.start();
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.e.setMainViewScale(com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.b.getMainViewScale());
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.e.setStartDelay(300L);
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.this.e.start();
        }
    }

    public AlbumScaleAnimatorView(android.content.Context context) {
        this(context, null);
    }

    public AlbumScaleAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = false;
    }

    private int a(int i) {
        return com.anythink.core.common.o.i.a(getContext(), i);
    }

    private android.view.ViewGroup.LayoutParams a(boolean z) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(z ? a(90) : a(42), z ? a(42) : a(90));
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void a(android.graphics.Bitmap bitmap) {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView(getContext());
        this.b = albumScaleMainView;
        boolean c = com.anythink.core.common.o.i.c(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(c ? a(90) : a(42), c ? a(42) : a(90));
        layoutParams.gravity = 17;
        albumScaleMainView.setLayoutParams(layoutParams);
        addView(this.b);
        this.b.initView(bitmap, true);
    }

    private boolean a() {
        return com.anythink.core.common.o.i.c(getContext());
    }

    public static /* synthetic */ boolean a(com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView albumScaleAnimatorView) {
        albumScaleAnimatorView.f = true;
        return true;
    }

    private void b() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView01 albumScaleItemView01 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView01(getContext());
        albumScaleItemView01.setBitmapResources(this.a);
        albumScaleItemView01.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        addView(albumScaleItemView01, layoutParams);
        this.c = albumScaleItemView01;
    }

    private void c() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView02 albumScaleItemView02 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView02(getContext());
        albumScaleItemView02.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        albumScaleItemView02.setBitmapResources(this.a);
        addView(albumScaleItemView02, layoutParams);
        this.d = albumScaleItemView02;
    }

    private void d() {
        android.view.ViewGroup.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView03 albumScaleItemView03 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView03(getContext());
        albumScaleItemView03.setBitmapResources(this.a);
        albumScaleItemView03.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        addView(albumScaleItemView03, layoutParams);
        this.e = albumScaleItemView03;
    }

    @Override // com.anythink.basead.ui.animplayerview.c
    public void addMainView(android.graphics.Bitmap bitmap, com.anythink.basead.ui.WrapRoundImageView... wrapRoundImageViewArr) {
        if (bitmap == null) {
            return;
        }
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView(getContext());
        this.b = albumScaleMainView;
        boolean c = com.anythink.core.common.o.i.c(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(c ? a(90) : a(42), c ? a(42) : a(90));
        layoutParams.gravity = 17;
        albumScaleMainView.setLayoutParams(layoutParams);
        addView(this.b);
        this.b.initView(bitmap, true);
        android.view.ViewGroup.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView03 albumScaleItemView03 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView03(getContext());
        albumScaleItemView03.setBitmapResources(this.a);
        albumScaleItemView03.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        addView(albumScaleItemView03, layoutParams2);
        this.e = albumScaleItemView03;
        android.view.ViewGroup.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView02 albumScaleItemView02 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView02(getContext());
        albumScaleItemView02.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        albumScaleItemView02.setBitmapResources(this.a);
        addView(albumScaleItemView02, layoutParams3);
        this.d = albumScaleItemView02;
        android.view.ViewGroup.LayoutParams layoutParams4 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView01 albumScaleItemView01 = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleItemView01(getContext());
        albumScaleItemView01.setBitmapResources(this.a);
        albumScaleItemView01.setOrientation(com.anythink.core.common.o.i.c(getContext()));
        addView(albumScaleItemView01, layoutParams4);
        this.c = albumScaleItemView01;
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.pause();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView = this.c;
        if (baseAlbumScaleItemView != null) {
            baseAlbumScaleItemView.pause();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView2 = this.d;
        if (baseAlbumScaleItemView2 != null) {
            baseAlbumScaleItemView2.pause();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView3 = this.e;
        if (baseAlbumScaleItemView3 != null) {
            baseAlbumScaleItemView3.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.c
    public void release() {
        java.util.List<android.graphics.Bitmap> list = this.a;
        if (list != null) {
            for (android.graphics.Bitmap bitmap : list) {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.a.clear();
        }
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.release();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView = this.c;
        if (baseAlbumScaleItemView != null) {
            baseAlbumScaleItemView.release();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView2 = this.d;
        if (baseAlbumScaleItemView2 != null) {
            baseAlbumScaleItemView2.release();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView3 = this.e;
        if (baseAlbumScaleItemView3 != null) {
            baseAlbumScaleItemView3.release();
        }
        removeAllViews();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.resume();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView = this.c;
        if (baseAlbumScaleItemView != null) {
            baseAlbumScaleItemView.resume();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView2 = this.d;
        if (baseAlbumScaleItemView2 != null) {
            baseAlbumScaleItemView2.resume();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView3 = this.e;
        if (baseAlbumScaleItemView3 != null) {
            baseAlbumScaleItemView3.resume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
        this.a = list;
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void start() {
        if (this.b == null || this.c == null || this.d == null || this.e == null) {
            return;
        }
        if (this.f) {
            resume();
        } else {
            post(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleAnimatorView.AnonymousClass1());
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = this.b;
        if (albumScaleMainView != null) {
            albumScaleMainView.stop();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView = this.c;
        if (baseAlbumScaleItemView != null) {
            baseAlbumScaleItemView.stop();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView2 = this.d;
        if (baseAlbumScaleItemView2 != null) {
            baseAlbumScaleItemView2.stop();
        }
        com.anythink.basead.ui.animplayerview.scale.BaseAlbumScaleItemView baseAlbumScaleItemView3 = this.e;
        if (baseAlbumScaleItemView3 != null) {
            baseAlbumScaleItemView3.stop();
        }
        this.f = false;
    }
}

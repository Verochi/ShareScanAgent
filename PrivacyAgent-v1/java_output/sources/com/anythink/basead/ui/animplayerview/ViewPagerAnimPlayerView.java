package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public class ViewPagerAnimPlayerView extends com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView {
    private boolean A;
    private com.anythink.core.common.res.image.RecycleImageView y;
    private com.anythink.basead.ui.animplayerview.c z;

    /* renamed from: com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.basead.ui.WrapRoundImageView a;
        final /* synthetic */ com.anythink.basead.ui.WrapRoundImageView b;

        /* renamed from: com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView$1$1, reason: invalid class name and collision with other inner class name */
        public class C01481 implements com.anythink.core.common.o.c.a {
            public C01481() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.y.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass1(com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView, com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView2) {
            this.a = wrapRoundImageView;
            this.b = wrapRoundImageView2;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, com.anythink.basead.c.f.O));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.e)) {
                if (com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.y != null && bitmap != null) {
                    com.anythink.core.common.o.c.a(com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.getContext(), bitmap, new com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.AnonymousClass1.C01481());
                }
                if (com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z == null) {
                    com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z = new com.anythink.basead.ui.animplayerview.viewpager.VpMainImgAnimatorView(com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.getContext().getApplicationContext());
                    android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(13);
                    ((android.view.View) com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z).setLayoutParams(layoutParams);
                    com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView viewPagerAnimPlayerView = com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this;
                    viewPagerAnimPlayerView.addView((android.view.View) viewPagerAnimPlayerView.z);
                    com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z.addMainView(bitmap, this.a, this.b);
                }
                if (com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.A) {
                    com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.d(com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this);
                    if (com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z != null) {
                        com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.this.z.start();
                    }
                }
            }
        }
    }

    public ViewPagerAnimPlayerView(android.content.Context context) {
        this(context, null);
    }

    public ViewPagerAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public static /* synthetic */ boolean d(com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView viewPagerAnimPlayerView) {
        viewPagerAnimPlayerView.A = false;
        return false;
    }

    private void j() {
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = new com.anythink.basead.ui.WrapRoundImageView(getContext().getApplicationContext());
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView2 = new com.anythink.basead.ui.WrapRoundImageView(getContext().getApplicationContext());
        wrapRoundImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView2.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.AnonymousClass1(wrapRoundImageView, wrapRoundImageView2));
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        com.anythink.basead.ui.animplayerview.c cVar = this.z;
        if (cVar != null) {
            cVar.start();
        } else {
            this.A = true;
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(android.content.Context context) {
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(context);
        this.y = recycleImageView;
        recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        addView(this.y, -1, -1);
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = new com.anythink.basead.ui.WrapRoundImageView(getContext().getApplicationContext());
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView2 = new com.anythink.basead.ui.WrapRoundImageView(getContext().getApplicationContext());
        wrapRoundImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView2.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView.AnonymousClass1(wrapRoundImageView, wrapRoundImageView2));
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        com.anythink.basead.ui.animplayerview.c cVar = this.z;
        if (cVar != null) {
            cVar.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        com.anythink.basead.ui.animplayerview.c cVar = this.z;
        if (cVar != null) {
            cVar.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        com.anythink.basead.ui.animplayerview.c cVar = this.z;
        if (cVar != null) {
            cVar.release();
            this.z = null;
        }
    }
}

package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public abstract class BaseMainAnimPlayerView extends com.anythink.basead.ui.animplayerview.BaseAnimPlayerView {

    /* renamed from: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.basead.ui.WrapRoundImageView a;

        /* renamed from: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01471 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            public RunnableC01471(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.AnonymousClass1.this.a.setBitmapAndResize(this.a, com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this.getWidth(), com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this.getHeight());
            }
        }

        /* renamed from: com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView$1$2, reason: invalid class name */
        public class AnonymousClass2 implements com.anythink.core.common.o.c.a {
            public AnonymousClass2() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this.f.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass1(com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView) {
            this.a = wrapRoundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.l, com.anythink.basead.c.f.O));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this.e)) {
                com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = this.a;
                if (wrapRoundImageView != null) {
                    wrapRoundImageView.post(new com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.AnonymousClass1.RunnableC01471(bitmap));
                }
                com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView baseMainAnimPlayerView = com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.this;
                if (baseMainAnimPlayerView.f == null || bitmap == null) {
                    return;
                }
                com.anythink.core.common.o.c.a(baseMainAnimPlayerView.getContext(), bitmap, new com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.AnonymousClass1.AnonymousClass2());
            }
        }
    }

    public BaseMainAnimPlayerView(android.content.Context context) {
        this(context, null);
    }

    public BaseMainAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMainAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView) {
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.AnonymousClass1(wrapRoundImageView));
    }

    public void a(android.content.Context context) {
        com.anythink.core.common.res.image.RecycleImageView recycleImageView = new com.anythink.core.common.res.image.RecycleImageView(context);
        this.f = recycleImageView;
        recycleImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        addView(this.f, -1, -1);
        this.g = new com.anythink.basead.ui.WrapRoundImageView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.g.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        addView(this.g, layoutParams);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, new com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView.AnonymousClass1(this.g));
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        super.init(lVar, mVar, z, list);
        a(getContext().getApplicationContext());
    }
}

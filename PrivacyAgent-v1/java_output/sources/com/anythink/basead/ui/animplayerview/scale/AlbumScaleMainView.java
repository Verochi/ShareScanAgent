package com.anythink.basead.ui.animplayerview.scale;

/* loaded from: classes12.dex */
public class AlbumScaleMainView extends android.widget.FrameLayout implements android.os.Handler.Callback, com.anythink.basead.ui.animplayerview.b {
    public static final int MAIN_VIEW_INIT_HEIGHT = 42;
    public static final int MAIN_VIEW_INIT_WIDTH = 90;
    private final int a;
    private final int b;
    private com.anythink.core.common.ui.component.RoundImageView c;
    private com.anythink.basead.ui.WrapRoundImageView d;
    private com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView e;
    private android.animation.AnimatorSet f;
    private android.animation.AnimatorSet g;
    private android.os.Handler h;
    private long i;

    /* renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.o.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.o.c.a
        public final void a() {
        }

        @Override // com.anythink.core.common.o.c.a
        public final void a(android.graphics.Bitmap bitmap) {
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.c.setImageBitmap(bitmap);
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap a;

        public AnonymousClass2(android.graphics.Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.d.setBitmapAndResize(this.a, com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.getWidth(), com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.getHeight());
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.basead.ui.animplayerview.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.basead.ui.animplayerview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.h.sendEmptyMessageDelayed(100, 500L);
        }
    }

    /* renamed from: com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.basead.ui.animplayerview.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.animplayerview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            if (com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.h != null) {
                com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.this.h.sendEmptyMessageDelayed(100, 500L);
            }
        }
    }

    public AlbumScaleMainView(android.content.Context context) {
        this(context, null);
    }

    public AlbumScaleMainView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlbumScaleMainView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 100;
        this.b = 500;
        this.c = new com.anythink.core.common.ui.component.RoundImageView(context);
        this.d = new com.anythink.basead.ui.WrapRoundImageView(context);
        this.c.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        this.d.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        android.view.ViewGroup.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(this.c, layoutParams);
        addView(this.d, layoutParams2);
        this.h = new android.os.Handler(android.os.Looper.getMainLooper(), this);
    }

    private void a() {
        float mainViewScale = getMainViewScale();
        if (mainViewScale == 1.0f) {
            return;
        }
        if (this.f == null) {
            this.f = new android.animation.AnimatorSet();
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, "scaleX", 1.0f, mainViewScale);
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this, "scaleY", 1.0f, mainViewScale);
            long j = this.i;
            if (j > 0) {
                this.f.setStartDelay(j);
            }
            this.f.playTogether(ofFloat, ofFloat2);
            this.f.setDuration(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
            this.f.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
            this.f.addListener(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass3());
        }
        this.f.start();
    }

    private void b() {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = this.e;
        if (albumScaleMainView == null) {
            return;
        }
        if (albumScaleMainView.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (this.g == null) {
            this.g = new android.animation.AnimatorSet();
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.3f);
            android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.3f);
            android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(this.e, "alpha", 0.4f, 0.0f);
            this.g.setDuration(500L);
            this.g.setInterpolator(new android.view.animation.LinearInterpolator());
            this.g.playTogether(ofFloat, ofFloat2, ofFloat3);
            this.g.addListener(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass4());
        }
        android.animation.AnimatorSet animatorSet = this.g;
        if (animatorSet == null || animatorSet.isStarted()) {
            return;
        }
        this.g.start();
    }

    public float getMainViewScale() {
        if (getLayoutParams() == null) {
            return 1.0f;
        }
        return java.lang.Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels) / java.lang.Math.min(r0.width, r0.height);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView;
        if (message.what == 100 && (albumScaleMainView = this.e) != null) {
            if (albumScaleMainView.getVisibility() != 0) {
                this.e.setVisibility(0);
            }
            if (this.g == null) {
                this.g = new android.animation.AnimatorSet();
                android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.e, "scaleX", 1.0f, 1.3f);
                android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.e, "scaleY", 1.0f, 1.3f);
                android.animation.ObjectAnimator ofFloat3 = android.animation.ObjectAnimator.ofFloat(this.e, "alpha", 0.4f, 0.0f);
                this.g.setDuration(500L);
                this.g.setInterpolator(new android.view.animation.LinearInterpolator());
                this.g.playTogether(ofFloat, ofFloat2, ofFloat3);
                this.g.addListener(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass4());
            }
            android.animation.AnimatorSet animatorSet = this.g;
            if (animatorSet != null && !animatorSet.isStarted()) {
                this.g.start();
            }
        }
        return false;
    }

    public void initView(android.graphics.Bitmap bitmap, boolean z) {
        com.anythink.core.common.o.c.a(getContext(), bitmap, new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass1());
        this.d.post(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass2(bitmap));
        if (z) {
            com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView albumScaleMainView = new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView(getContext());
            this.e = albumScaleMainView;
            albumScaleMainView.initView(bitmap, false);
            this.e.setVisibility(4);
            addView(this.e, new android.widget.FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        android.animation.AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.pause();
        }
    }

    public void release() {
        stop();
        removeAllViews();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        android.animation.AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.resume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
    }

    public void setStartDelay(long j) {
        this.i = j;
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void start() {
        float mainViewScale = getMainViewScale();
        if (mainViewScale != 1.0f) {
            if (this.f == null) {
                this.f = new android.animation.AnimatorSet();
                android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this, "scaleX", 1.0f, mainViewScale);
                android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this, "scaleY", 1.0f, mainViewScale);
                long j = this.i;
                if (j > 0) {
                    this.f.setStartDelay(j);
                }
                this.f.playTogether(ofFloat, ofFloat2);
                this.f.setDuration(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
                this.f.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
                this.f.addListener(new com.anythink.basead.ui.animplayerview.scale.AlbumScaleMainView.AnonymousClass3());
            }
            this.f.start();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        android.animation.AnimatorSet animatorSet = this.f;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.f.cancel();
            this.f = null;
        }
        android.animation.AnimatorSet animatorSet2 = this.g;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
            this.g.cancel();
            this.g = null;
        }
        android.os.Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}

package com.anythink.basead.ui.guidetoclickv2;

/* loaded from: classes12.dex */
public class PicVerifyG2CV2View extends com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View {
    com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView c;
    com.anythink.basead.ui.guidetoclickv2.picverify.TextSeekbar d;
    java.lang.String e;
    android.animation.ValueAnimator f;
    android.animation.ValueAnimator g;
    int h;
    private boolean i;
    private boolean j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a
        public final void a() {
            com.anythink.basead.ui.b.b.a aVar = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.b;
            if (aVar != null) {
                aVar.a(11, 16);
            }
        }

        @Override // com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a
        public final void b() {
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ int a;

        /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ((android.widget.RelativeLayout.LayoutParams) com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.d.getLayoutParams()).setMargins(0, (com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.getMeasuredHeight() / 2) + (com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass2.this.a / 2), 0, 0);
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.d.setVisibility(0);
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this);
            }
        }

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.e)) {
                android.util.DisplayMetrics displayMetrics = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.getContext().getResources().getDisplayMetrics();
                int[] a = com.anythink.core.common.o.w.a(displayMetrics.widthPixels, displayMetrics.heightPixels, bitmap.getWidth() / bitmap.getHeight());
                int i = this.a * 2;
                if (bitmap.getWidth() < i || bitmap.getHeight() < i) {
                    com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b bVar = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.a;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                int a2 = com.anythink.core.common.o.i.a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.getContext(), 180.0f);
                if (a[0] < a2 || a[1] < a2) {
                    com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View.b bVar2 = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.a;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                android.view.ViewGroup.LayoutParams layoutParams = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a[0];
                    layoutParams.height = a[1];
                    com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.setLayoutParams(layoutParams);
                }
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.setImageBitmap(bitmap);
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.post(new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass2.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$3, reason: invalid class name */
    public class AnonymousClass3 implements android.widget.SeekBar.OnSeekBarChangeListener {
        public AnonymousClass3() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            if (!z) {
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.move(i);
                if (i == 100) {
                    com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.loose();
                    return;
                }
                return;
            }
            if (com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.j) {
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.j = false;
                if (i > 30) {
                    com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.i = false;
                } else {
                    com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.i = true;
                }
            }
            if (!com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.i) {
                seekBar.setProgress(0);
            } else if (i > 30) {
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this, i);
            } else {
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.move(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(android.widget.SeekBar seekBar) {
            com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.j = true;
            com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.d(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            if (com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.i) {
                com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.c.loose();
            }
            com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(seekBar);
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$4, reason: invalid class name */
    public class AnonymousClass4 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this.d.setProgress(((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View$5, reason: invalid class name */
    public class AnonymousClass5 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass5() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(@androidx.annotation.NonNull android.animation.ValueAnimator valueAnimator) {
            int intValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
            com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View = com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.this;
            if (picVerifyG2CV2View.h != intValue) {
                picVerifyG2CV2View.h = intValue;
                picVerifyG2CV2View.d.setProgress(intValue);
            }
        }
    }

    public PicVerifyG2CV2View(android.content.Context context) {
        super(context);
        this.k = 30;
        this.l = 15;
        this.m = 500;
        this.n = 300;
        this.h = -1;
    }

    private android.graphics.drawable.BitmapDrawable a(android.content.Context context, int i, int i2, int i3) {
        return new android.graphics.drawable.BitmapDrawable(getResources(), android.graphics.Bitmap.createScaledBitmap(android.graphics.BitmapFactory.decodeResource(context.getResources(), i), i2, i3, false));
    }

    private void a(int i) {
        this.d.setClickable(false);
        this.d.setEnabled(false);
        this.d.getProgressDrawable().setAlpha(255);
        if (this.g == null) {
            android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(i, 100);
            this.g = ofInt;
            ofInt.addUpdateListener(new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass5());
            this.g.setDuration(300L);
            this.g.start();
        }
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View) {
        if (picVerifyG2CV2View.f == null) {
            android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(0, 15);
            picVerifyG2CV2View.f = ofInt;
            ofInt.addUpdateListener(picVerifyG2CV2View.new AnonymousClass4());
            picVerifyG2CV2View.f.setRepeatMode(2);
            picVerifyG2CV2View.f.setRepeatCount(-1);
            picVerifyG2CV2View.f.setDuration(500L);
        }
        if (picVerifyG2CV2View.f.isStarted() || picVerifyG2CV2View.g != null) {
            return;
        }
        picVerifyG2CV2View.f.start();
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View, int i) {
        picVerifyG2CV2View.d.setClickable(false);
        picVerifyG2CV2View.d.setEnabled(false);
        picVerifyG2CV2View.d.getProgressDrawable().setAlpha(255);
        if (picVerifyG2CV2View.g == null) {
            android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(i, 100);
            picVerifyG2CV2View.g = ofInt;
            ofInt.addUpdateListener(picVerifyG2CV2View.new AnonymousClass5());
            picVerifyG2CV2View.g.setDuration(300L);
            picVerifyG2CV2View.g.start();
        }
    }

    private void c() {
        this.d.setProgress(0);
    }

    private void d() {
        if (this.f == null) {
            android.animation.ValueAnimator ofInt = android.animation.ValueAnimator.ofInt(0, 15);
            this.f = ofInt;
            ofInt.addUpdateListener(new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass4());
            this.f.setRepeatMode(2);
            this.f.setRepeatCount(-1);
            this.f.setDuration(500L);
        }
        if (this.f.isStarted() || this.g != null) {
            return;
        }
        this.f.start();
    }

    public static /* synthetic */ void d(com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View picVerifyG2CV2View) {
        android.animation.ValueAnimator valueAnimator = picVerifyG2CV2View.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void e() {
        android.animation.ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void a(int i, int i2) {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_v2_pic_vertify", "layout"), this);
        this.c = (com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_picvertify", "id"));
        this.d = (com.anythink.basead.ui.guidetoclickv2.picverify.TextSeekbar) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_picvertify_seekbar", "id"));
        int a = com.anythink.core.common.o.i.a(getContext(), 48.0f);
        this.c.setBlockSize(a);
        this.c.callback(new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass1());
        if (!android.text.TextUtils.isEmpty(this.e)) {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.e), new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass2(a));
        }
        this.d.setProgressDrawable(getResources().getDrawable(com.anythink.core.common.o.i.a(getContext(), "myoffer_g2c_seek_bar_bg", com.anythink.expressad.foundation.h.i.c)));
        com.anythink.basead.ui.guidetoclickv2.picverify.TextSeekbar textSeekbar = this.d;
        android.content.Context context = getContext();
        int a2 = com.anythink.core.common.o.i.a(getContext(), "myoffer_seek_bar_icon", com.anythink.expressad.foundation.h.i.c);
        textSeekbar.setThumb(new android.graphics.drawable.BitmapDrawable(getResources(), android.graphics.Bitmap.createScaledBitmap(android.graphics.BitmapFactory.decodeResource(context.getResources(), a2), com.anythink.core.common.o.i.a(getContext(), 60.0f), com.anythink.core.common.o.i.a(getContext(), 24.0f), false)));
        this.d.setThumbOffset(0);
        this.d.setOnSeekBarChangeListener(new com.anythink.basead.ui.guidetoclickv2.PicVerifyG2CV2View.AnonymousClass3());
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public boolean canStartNextAnim() {
        return this.g == null;
    }

    public void loadImage(java.lang.String str) {
        this.e = str;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    public void release() {
        super.release();
        android.animation.ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        android.animation.ValueAnimator valueAnimator2 = this.g;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }
}

package com.hbzhou.open.flowcamera;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes22.dex */
public class CaptureLayout extends android.widget.FrameLayout {
    public com.hbzhou.open.flowcamera.ReturnButton A;
    public android.widget.ImageView B;
    public android.widget.ImageView C;
    public android.widget.TextView D;
    public java.lang.String E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public com.hbzhou.open.flowcamera.CaptureListener n;
    public com.hbzhou.open.flowcamera.listener.TypeListener t;
    public com.hbzhou.open.flowcamera.listener.ReturnListener u;
    public com.hbzhou.open.flowcamera.listener.ClickListener v;
    public com.hbzhou.open.flowcamera.listener.ClickListener w;
    public com.hbzhou.open.flowcamera.CaptureButton x;
    public com.hbzhou.open.flowcamera.TypeButton y;
    public com.hbzhou.open.flowcamera.TypeButton z;

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$1, reason: invalid class name */
    public class AnonymousClass1 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.hbzhou.open.flowcamera.CaptureLayout.this.z.setClickable(true);
            com.hbzhou.open.flowcamera.CaptureLayout.this.y.setClickable(true);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$2, reason: invalid class name */
    public class AnonymousClass2 implements com.hbzhou.open.flowcamera.CaptureListener {
        public AnonymousClass2() {
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordEnd(long j) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.recordEnd(j);
            }
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordError() {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.recordError();
            }
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordShort(long j) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.recordShort(j);
            }
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordStart() {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.recordStart();
            }
            com.hbzhou.open.flowcamera.CaptureLayout.this.startAlphaAnimation();
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void recordZoom(float f) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.recordZoom(f);
            }
        }

        @Override // com.hbzhou.open.flowcamera.CaptureListener
        public void takePictures() {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.n != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.n.takePictures();
            }
            com.hbzhou.open.flowcamera.CaptureLayout.this.startAlphaAnimation();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.t != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.t.cancel();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.t != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.t.confirm();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.v != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.v.onClick();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.v != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.v.onClick();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            if (com.hbzhou.open.flowcamera.CaptureLayout.this.w != null) {
                com.hbzhou.open.flowcamera.CaptureLayout.this.w.onClick();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureLayout$8, reason: invalid class name */
    public class AnonymousClass8 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass8() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.hbzhou.open.flowcamera.CaptureLayout captureLayout = com.hbzhou.open.flowcamera.CaptureLayout.this;
            captureLayout.k(captureLayout.x.getButtonState());
            com.hbzhou.open.flowcamera.CaptureLayout.this.D.setAlpha(1.0f);
        }
    }

    public CaptureLayout(android.content.Context context) {
        this(context, null);
    }

    public CaptureLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.I = 0;
        this.J = 0;
        this.K = true;
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (getResources().getConfiguration().orientation == 1) {
            this.F = displayMetrics.widthPixels;
        } else {
            this.F = displayMetrics.widthPixels / 2;
        }
        int i2 = (int) (this.F / 4.5f);
        this.H = i2;
        this.G = i2 + ((i2 / 5) * 2) + 100;
        j();
        initEvent();
    }

    public void initEvent() {
        this.C.setVisibility(8);
        this.z.setVisibility(8);
        this.y.setVisibility(8);
    }

    public final void j() {
        setWillNotDraw(false);
        this.x = new com.hbzhou.open.flowcamera.CaptureButton(getContext(), this.H);
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.x.setLayoutParams(layoutParams);
        this.x.setCaptureLisenter(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass2());
        this.z = new com.hbzhou.open.flowcamera.TypeButton(getContext(), 1, this.H);
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 16;
        layoutParams2.setMargins((this.F / 4) - (this.H / 2), 0, 0, 0);
        this.z.setLayoutParams(layoutParams2);
        this.z.setOnClickListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass3());
        this.y = new com.hbzhou.open.flowcamera.TypeButton(getContext(), 2, this.H);
        android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 21;
        layoutParams3.setMargins(0, 0, (this.F / 4) - (this.H / 2), 0);
        this.y.setLayoutParams(layoutParams3);
        this.y.setOnClickListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass4());
        this.A = new com.hbzhou.open.flowcamera.ReturnButton(getContext(), (int) (this.H / 2.5f));
        android.widget.FrameLayout.LayoutParams layoutParams4 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.setMargins(this.F / 6, 0, 0, 0);
        this.A.setLayoutParams(layoutParams4);
        this.A.setOnClickListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass5());
        this.B = new android.widget.ImageView(getContext());
        int i = this.H;
        android.widget.FrameLayout.LayoutParams layoutParams5 = new android.widget.FrameLayout.LayoutParams((int) (i / 2.5f), (int) (i / 2.5f));
        layoutParams5.gravity = 16;
        layoutParams5.setMargins(this.F / 6, 0, 0, 0);
        this.B.setLayoutParams(layoutParams5);
        this.B.setOnClickListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass6());
        this.C = new android.widget.ImageView(getContext());
        int i2 = this.H;
        android.widget.FrameLayout.LayoutParams layoutParams6 = new android.widget.FrameLayout.LayoutParams((int) (i2 / 2.5f), (int) (i2 / 2.5f));
        layoutParams6.gravity = 21;
        layoutParams6.setMargins(0, 0, this.F / 6, 0);
        this.C.setLayoutParams(layoutParams6);
        this.C.setOnClickListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass7());
        this.D = new android.widget.TextView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams7 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutParams7.gravity = 1;
        layoutParams7.setMargins(0, 0, 0, 0);
        k(this.x.getButtonState());
        this.D.setTextColor(-1);
        this.D.setGravity(17);
        this.D.setLayoutParams(layoutParams7);
        addView(this.x);
        addView(this.z);
        addView(this.y);
        addView(this.A);
        addView(this.B);
        addView(this.C);
        addView(this.D);
    }

    public final void k(int i) {
        switch (i) {
            case 257:
                this.E = "单击拍照";
                this.D.setText("单击拍照");
                break;
            case 258:
                this.E = "长按摄像";
                this.D.setText("长按摄像");
                break;
            case 259:
                this.E = "单击拍照，长按摄像";
                this.D.setText("单击拍照，长按摄像");
                break;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.F, this.G);
    }

    public void resetCaptureLayout() {
        this.x.resetState();
        this.z.setVisibility(8);
        this.y.setVisibility(8);
        this.x.setVisibility(0);
        k(this.x.getButtonState());
        this.D.setVisibility(0);
        if (this.I != 0) {
            this.B.setVisibility(0);
        } else {
            this.A.setVisibility(0);
        }
        if (this.J != 0) {
            this.C.setVisibility(0);
        }
    }

    public void setButtonFeatures(int i) {
        this.x.setButtonFeatures(i);
        k(i);
    }

    public void setCaptureLisenter(com.hbzhou.open.flowcamera.CaptureListener captureListener) {
        this.n = captureListener;
    }

    public void setDuration(int i) {
        this.x.setDuration(i);
    }

    public void setIconSrc(int i, int i2) {
        this.I = i;
        this.J = i2;
        if (i != 0) {
            this.B.setImageResource(i);
            this.B.setVisibility(0);
            this.A.setVisibility(8);
        } else {
            this.B.setVisibility(8);
            this.A.setVisibility(0);
        }
        if (this.J == 0) {
            this.C.setVisibility(8);
        } else {
            this.C.setImageResource(i2);
            this.C.setVisibility(0);
        }
    }

    public void setLeftClickListener(com.hbzhou.open.flowcamera.listener.ClickListener clickListener) {
        this.v = clickListener;
    }

    public void setReturnLisenter(com.hbzhou.open.flowcamera.listener.ReturnListener returnListener) {
        this.u = returnListener;
    }

    public void setRightClickListener(com.hbzhou.open.flowcamera.listener.ClickListener clickListener) {
        this.w = clickListener;
    }

    public void setTextWithAnimation(java.lang.String str) {
        this.D.setText(str);
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.D, "alpha", 0.0f, 1.0f, 1.0f, 0.0f);
        ofFloat.addListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass8());
        ofFloat.setDuration(2500L);
        ofFloat.start();
    }

    public void setTip(java.lang.String str) {
        this.E = str;
        this.D.setText(str);
    }

    public void setTypeLisenter(com.hbzhou.open.flowcamera.listener.TypeListener typeListener) {
        this.t = typeListener;
    }

    public void startAlphaAnimation() {
        this.D.setVisibility(4);
    }

    public void startTypeBtnAnimator() {
        if (this.I != 0) {
            this.B.setVisibility(8);
        } else {
            this.A.setVisibility(8);
        }
        if (this.J != 0) {
            this.C.setVisibility(8);
        }
        this.x.setVisibility(8);
        this.z.setVisibility(0);
        this.y.setVisibility(0);
        this.z.setClickable(false);
        this.y.setClickable(false);
        android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.z, "translationX", this.F / 4, 0.0f);
        android.animation.ObjectAnimator ofFloat2 = android.animation.ObjectAnimator.ofFloat(this.y, "translationX", (-this.F) / 4, 0.0f);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.addListener(new com.hbzhou.open.flowcamera.CaptureLayout.AnonymousClass1());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }
}

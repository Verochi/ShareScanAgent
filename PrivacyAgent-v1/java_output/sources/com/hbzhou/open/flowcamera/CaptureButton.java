package com.hbzhou.open.flowcamera;

/* loaded from: classes22.dex */
public class CaptureButton extends android.view.View {
    public static final int STATE_BAN = 5;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LONG_PRESS = 3;
    public static final int STATE_PRESS = 2;
    public static final int STATE_RECORDERING = 4;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public float I;
    public int J;
    public int K;
    public int L;
    public android.graphics.RectF M;
    public com.hbzhou.open.flowcamera.CaptureButton.LongPressRunnable N;
    public com.hbzhou.open.flowcamera.CaptureListener O;
    public com.hbzhou.open.flowcamera.CaptureButton.RecordCountDownTimer P;
    public int n;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public android.graphics.Paint y;
    public float z;

    /* renamed from: com.hbzhou.open.flowcamera.CaptureButton$1, reason: invalid class name */
    public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.hbzhou.open.flowcamera.CaptureButton.this.G = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.hbzhou.open.flowcamera.CaptureButton.this.invalidate();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureButton$2, reason: invalid class name */
    public class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
            super.onAnimationStart(animator);
            if (com.hbzhou.open.flowcamera.CaptureButton.this.O != null) {
                com.hbzhou.open.flowcamera.CaptureButton.this.O.takePictures();
            }
            com.hbzhou.open.flowcamera.CaptureButton.this.n = 5;
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureButton$3, reason: invalid class name */
    public class AnonymousClass3 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.hbzhou.open.flowcamera.CaptureButton.this.F = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.hbzhou.open.flowcamera.CaptureButton.this.invalidate();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureButton$4, reason: invalid class name */
    public class AnonymousClass4 implements android.animation.ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass4() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
            com.hbzhou.open.flowcamera.CaptureButton.this.G = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
            com.hbzhou.open.flowcamera.CaptureButton.this.invalidate();
        }
    }

    /* renamed from: com.hbzhou.open.flowcamera.CaptureButton$5, reason: invalid class name */
    public class AnonymousClass5 extends android.animation.AnimatorListenerAdapter {
        public AnonymousClass5() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            if (com.hbzhou.open.flowcamera.CaptureButton.this.n != 3) {
                com.hbzhou.open.flowcamera.CaptureButton.this.n = 1;
                return;
            }
            if (com.hbzhou.open.flowcamera.CaptureButton.this.O != null) {
                com.hbzhou.open.flowcamera.CaptureButton.this.O.recordStart();
            }
            com.hbzhou.open.flowcamera.CaptureButton.this.n = 4;
            com.hbzhou.open.flowcamera.CaptureButton.this.P.start();
        }
    }

    public class LongPressRunnable implements java.lang.Runnable {
        public LongPressRunnable() {
        }

        public /* synthetic */ LongPressRunnable(com.hbzhou.open.flowcamera.CaptureButton captureButton, defpackage.lk lkVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.hbzhou.open.flowcamera.CaptureButton.this.n = 3;
            com.hbzhou.open.flowcamera.CaptureButton captureButton = com.hbzhou.open.flowcamera.CaptureButton.this;
            captureButton.p(captureButton.F, com.hbzhou.open.flowcamera.CaptureButton.this.F + com.hbzhou.open.flowcamera.CaptureButton.this.A, com.hbzhou.open.flowcamera.CaptureButton.this.G, com.hbzhou.open.flowcamera.CaptureButton.this.G - com.hbzhou.open.flowcamera.CaptureButton.this.B);
        }
    }

    public class RecordCountDownTimer extends android.os.CountDownTimer {
        public RecordCountDownTimer(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.hbzhou.open.flowcamera.CaptureButton.this.recordEnd();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.hbzhou.open.flowcamera.CaptureButton.this.q(j);
        }
    }

    public CaptureButton(android.content.Context context) {
        super(context);
        this.u = -300503530;
        this.v = -287515428;
        this.w = -1;
    }

    public CaptureButton(android.content.Context context, int i) {
        super(context);
        this.u = -300503530;
        this.v = -287515428;
        this.w = -1;
        this.H = i;
        float f = i / 2.0f;
        this.E = f;
        this.F = f;
        this.G = f * 0.75f;
        this.z = i / 15;
        int i2 = i / 8;
        this.A = i2;
        this.B = i2;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.y = paint;
        paint.setAntiAlias(true);
        this.I = 0.0f;
        this.N = new com.hbzhou.open.flowcamera.CaptureButton.LongPressRunnable(this, null);
        this.n = 1;
        this.t = 257;
        com.hbzhou.open.flowcamera.util.LogUtil.i("CaptureButtom start");
        this.J = 10000;
        com.hbzhou.open.flowcamera.util.LogUtil.i("CaptureButtom end");
        this.K = 1500;
        int i3 = this.H;
        int i4 = this.A;
        this.C = ((i4 * 2) + i3) / 2;
        this.D = (i3 + (i4 * 2)) / 2;
        float f2 = this.C;
        float f3 = this.E;
        int i5 = this.A;
        float f4 = this.z;
        float f5 = this.D;
        this.M = new android.graphics.RectF(f2 - ((i5 + f3) - (f4 / 2.0f)), f5 - ((i5 + f3) - (f4 / 2.0f)), f2 + ((i5 + f3) - (f4 / 2.0f)), f5 + ((f3 + i5) - (f4 / 2.0f)));
        this.P = new com.hbzhou.open.flowcamera.CaptureButton.RecordCountDownTimer(this.J, r15 / com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE);
    }

    public int getButtonState() {
        return this.t;
    }

    public boolean isIdle() {
        return this.n == 1;
    }

    public final void m() {
        int i;
        removeCallbacks(this.N);
        int i2 = this.n;
        if (i2 != 2) {
            if (i2 == 3 || i2 == 4) {
                this.P.cancel();
                recordEnd();
            }
        } else if (this.O == null || !((i = this.t) == 257 || i == 259)) {
            this.n = 1;
        } else {
            o(this.G);
        }
        this.n = 1;
    }

    public final void n() {
        this.n = 5;
        this.I = 0.0f;
        invalidate();
        float f = this.F;
        float f2 = this.E;
        p(f, f2, this.G, 0.75f * f2);
    }

    public final void o(float f) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(f, 0.75f * f, f);
        ofFloat.addUpdateListener(new com.hbzhou.open.flowcamera.CaptureButton.AnonymousClass1());
        ofFloat.addListener(new com.hbzhou.open.flowcamera.CaptureButton.AnonymousClass2());
        ofFloat.setDuration(50L);
        ofFloat.start();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.y.setStyle(android.graphics.Paint.Style.FILL);
        this.y.setColor(this.v);
        canvas.drawCircle(this.C, this.D, this.F, this.y);
        this.y.setColor(this.w);
        canvas.drawCircle(this.C, this.D, this.G, this.y);
        if (this.n == 4) {
            this.y.setColor(this.u);
            this.y.setStyle(android.graphics.Paint.Style.STROKE);
            this.y.setStrokeWidth(this.z);
            canvas.drawArc(this.M, -90.0f, this.I, false, this.y);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.H;
        int i4 = this.A;
        setMeasuredDimension((i4 * 2) + i3, i3 + (i4 * 2));
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.hbzhou.open.flowcamera.CaptureListener captureListener;
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            com.hbzhou.open.flowcamera.util.LogUtil.i("state = " + this.n);
            if (motionEvent.getPointerCount() <= 1 && this.n == 1) {
                this.x = motionEvent.getY();
                this.n = 2;
                int i2 = this.t;
                if (i2 == 258 || i2 == 259) {
                    postDelayed(this.N, 500L);
                }
            }
        } else if (action == 1) {
            m();
        } else if (action == 2 && (captureListener = this.O) != null && this.n == 4 && ((i = this.t) == 258 || i == 259)) {
            captureListener.recordZoom(this.x - motionEvent.getY());
        }
        return true;
    }

    public final void p(float f, float f2, float f3, float f4) {
        android.animation.ValueAnimator ofFloat = android.animation.ValueAnimator.ofFloat(f, f2);
        android.animation.ValueAnimator ofFloat2 = android.animation.ValueAnimator.ofFloat(f3, f4);
        ofFloat.addUpdateListener(new com.hbzhou.open.flowcamera.CaptureButton.AnonymousClass3());
        ofFloat2.addUpdateListener(new com.hbzhou.open.flowcamera.CaptureButton.AnonymousClass4());
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.addListener(new com.hbzhou.open.flowcamera.CaptureButton.AnonymousClass5());
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    public final void q(long j) {
        int i = this.J;
        this.L = (int) (i - j);
        this.I = 360.0f - ((j / i) * 360.0f);
        invalidate();
    }

    public void recordEnd() {
        com.hbzhou.open.flowcamera.CaptureListener captureListener = this.O;
        if (captureListener != null) {
            int i = this.L;
            if (i < this.K) {
                captureListener.recordShort(i);
            } else {
                captureListener.recordEnd(i);
            }
        }
        n();
    }

    public void resetState() {
        this.n = 1;
    }

    public void setButtonFeatures(int i) {
        this.t = i;
    }

    public void setCaptureLisenter(com.hbzhou.open.flowcamera.CaptureListener captureListener) {
        this.O = captureListener;
    }

    public void setDuration(int i) {
        this.J = i;
        this.P = new com.hbzhou.open.flowcamera.CaptureButton.RecordCountDownTimer(i, i / com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE);
    }

    public void setMinDuration(int i) {
        this.K = i;
    }
}

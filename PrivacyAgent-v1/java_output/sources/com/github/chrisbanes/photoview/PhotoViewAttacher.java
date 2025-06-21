package com.github.chrisbanes.photoview;

/* loaded from: classes22.dex */
public class PhotoViewAttacher implements android.view.View.OnTouchListener, android.view.View.OnLayoutChangeListener {
    public static float X = 3.0f;
    public static float Y = 1.75f;
    public static float Z = 1.0f;
    public static int a0 = 200;
    public static int b0 = 1;
    public android.view.GestureDetector A;
    public com.github.chrisbanes.photoview.CustomGestureDetector B;
    public com.github.chrisbanes.photoview.OnMatrixChangedListener H;
    public com.github.chrisbanes.photoview.OnPhotoTapListener I;
    public com.github.chrisbanes.photoview.OnOutsidePhotoTapListener J;
    public com.github.chrisbanes.photoview.OnViewTapListener K;
    public android.view.View.OnClickListener L;
    public android.view.View.OnLongClickListener M;
    public com.github.chrisbanes.photoview.OnScaleChangedListener N;
    public com.github.chrisbanes.photoview.OnSingleFlingListener O;
    public com.github.chrisbanes.photoview.OnViewDragListener P;
    public com.github.chrisbanes.photoview.PhotoViewAttacher.FlingRunnable Q;
    public float T;
    public android.widget.ImageView z;
    public android.view.animation.Interpolator n = new android.view.animation.AccelerateDecelerateInterpolator();
    public int t = a0;
    public float u = Z;
    public float v = Y;
    public float w = X;
    public boolean x = true;
    public boolean y = false;
    public final android.graphics.Matrix C = new android.graphics.Matrix();
    public final android.graphics.Matrix D = new android.graphics.Matrix();
    public final android.graphics.Matrix E = new android.graphics.Matrix();
    public final android.graphics.RectF F = new android.graphics.RectF();
    public final float[] G = new float[9];
    public int R = 2;
    public int S = 2;
    public boolean U = true;
    public android.widget.ImageView.ScaleType V = android.widget.ImageView.ScaleType.FIT_CENTER;
    public com.github.chrisbanes.photoview.OnGestureListener W = new com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass1();

    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$1, reason: invalid class name */
    public class AnonymousClass1 implements com.github.chrisbanes.photoview.OnGestureListener {
        public AnonymousClass1() {
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void a(float f, float f2, float f3, float f4) {
            com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
            photoViewAttacher.Q = photoViewAttacher.new FlingRunnable(photoViewAttacher.z.getContext());
            com.github.chrisbanes.photoview.PhotoViewAttacher.FlingRunnable flingRunnable = com.github.chrisbanes.photoview.PhotoViewAttacher.this.Q;
            com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher2 = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
            int G = photoViewAttacher2.G(photoViewAttacher2.z);
            com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher3 = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
            flingRunnable.b(G, photoViewAttacher3.F(photoViewAttacher3.z), (int) f3, (int) f4);
            com.github.chrisbanes.photoview.PhotoViewAttacher.this.z.post(com.github.chrisbanes.photoview.PhotoViewAttacher.this.Q);
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void b(float f, float f2, float f3) {
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.getScale() < com.github.chrisbanes.photoview.PhotoViewAttacher.this.w || f < 1.0f) {
                if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.N != null) {
                    com.github.chrisbanes.photoview.PhotoViewAttacher.this.N.onScaleChange(f, f2, f3);
                }
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.E.postScale(f, f, f2, f3);
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.B();
            }
        }

        @Override // com.github.chrisbanes.photoview.OnGestureListener
        public void onDrag(float f, float f2) {
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.B.e()) {
                return;
            }
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.P != null) {
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.P.onDrag(f, f2);
            }
            com.github.chrisbanes.photoview.PhotoViewAttacher.this.E.postTranslate(f, f2);
            com.github.chrisbanes.photoview.PhotoViewAttacher.this.B();
            android.view.ViewParent parent = com.github.chrisbanes.photoview.PhotoViewAttacher.this.z.getParent();
            if (!com.github.chrisbanes.photoview.PhotoViewAttacher.this.x || com.github.chrisbanes.photoview.PhotoViewAttacher.this.B.e() || com.github.chrisbanes.photoview.PhotoViewAttacher.this.y) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((com.github.chrisbanes.photoview.PhotoViewAttacher.this.R == 2 || ((com.github.chrisbanes.photoview.PhotoViewAttacher.this.R == 0 && f >= 1.0f) || ((com.github.chrisbanes.photoview.PhotoViewAttacher.this.R == 1 && f <= -1.0f) || ((com.github.chrisbanes.photoview.PhotoViewAttacher.this.S == 0 && f2 >= 1.0f) || (com.github.chrisbanes.photoview.PhotoViewAttacher.this.S == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$2, reason: invalid class name */
    public class AnonymousClass2 extends android.view.GestureDetector.SimpleOnGestureListener {
        public AnonymousClass2() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.O == null || com.github.chrisbanes.photoview.PhotoViewAttacher.this.getScale() > com.github.chrisbanes.photoview.PhotoViewAttacher.Z || motionEvent.getPointerCount() > com.github.chrisbanes.photoview.PhotoViewAttacher.b0 || motionEvent2.getPointerCount() > com.github.chrisbanes.photoview.PhotoViewAttacher.b0) {
                return false;
            }
            return com.github.chrisbanes.photoview.PhotoViewAttacher.this.O.onFling(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.M != null) {
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.M.onLongClick(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z);
            }
        }
    }

    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.GestureDetector.OnDoubleTapListener {
        public AnonymousClass3() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            try {
                float scale = com.github.chrisbanes.photoview.PhotoViewAttacher.this.getScale();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (scale < com.github.chrisbanes.photoview.PhotoViewAttacher.this.getMediumScale()) {
                    com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
                    photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), x, y, true);
                } else if (scale < com.github.chrisbanes.photoview.PhotoViewAttacher.this.getMediumScale() || scale >= com.github.chrisbanes.photoview.PhotoViewAttacher.this.getMaximumScale()) {
                    com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher2 = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
                    photoViewAttacher2.setScale(photoViewAttacher2.getMinimumScale(), x, y, true);
                } else {
                    com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher3 = com.github.chrisbanes.photoview.PhotoViewAttacher.this;
                    photoViewAttacher3.setScale(photoViewAttacher3.getMaximumScale(), x, y, true);
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(android.view.MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(android.view.MotionEvent motionEvent) {
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.L != null) {
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.L.onClick(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z);
            }
            android.graphics.RectF displayRect = com.github.chrisbanes.photoview.PhotoViewAttacher.this.getDisplayRect();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.K != null) {
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.K.onViewTap(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z, x, y);
            }
            if (displayRect == null) {
                return false;
            }
            if (!displayRect.contains(x, y)) {
                if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.J == null) {
                    return false;
                }
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.J.onOutsidePhotoTap(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z);
                return false;
            }
            float width = (x - displayRect.left) / displayRect.width();
            float height = (y - displayRect.top) / displayRect.height();
            if (com.github.chrisbanes.photoview.PhotoViewAttacher.this.I == null) {
                return true;
            }
            com.github.chrisbanes.photoview.PhotoViewAttacher.this.I.onPhotoTap(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z, width, height);
            return true;
        }
    }

    /* renamed from: com.github.chrisbanes.photoview.PhotoViewAttacher$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public class AnimatedZoomRunnable implements java.lang.Runnable {
        public final float n;
        public final float t;
        public final long u = java.lang.System.currentTimeMillis();
        public final float v;
        public final float w;

        public AnimatedZoomRunnable(float f, float f2, float f3, float f4) {
            this.n = f3;
            this.t = f4;
            this.v = f;
            this.w = f2;
        }

        public final float a() {
            return com.github.chrisbanes.photoview.PhotoViewAttacher.this.n.getInterpolation(java.lang.Math.min(1.0f, ((java.lang.System.currentTimeMillis() - this.u) * 1.0f) / com.github.chrisbanes.photoview.PhotoViewAttacher.this.t));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a = a();
            float f = this.v;
            com.github.chrisbanes.photoview.PhotoViewAttacher.this.W.b((f + ((this.w - f) * a)) / com.github.chrisbanes.photoview.PhotoViewAttacher.this.getScale(), this.n, this.t);
            if (a < 1.0f) {
                com.github.chrisbanes.photoview.Compat.a(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z, this);
            }
        }
    }

    public class FlingRunnable implements java.lang.Runnable {
        public final android.widget.OverScroller n;
        public int t;
        public int u;

        public FlingRunnable(android.content.Context context) {
            this.n = new android.widget.OverScroller(context);
        }

        public void a() {
            this.n.forceFinished(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            android.graphics.RectF displayRect = com.github.chrisbanes.photoview.PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = java.lang.Math.round(-displayRect.left);
            float f = i;
            if (f < displayRect.width()) {
                i6 = java.lang.Math.round(displayRect.width() - f);
                i5 = 0;
            } else {
                i5 = round;
                i6 = i5;
            }
            int round2 = java.lang.Math.round(-displayRect.top);
            float f2 = i2;
            if (f2 < displayRect.height()) {
                i8 = java.lang.Math.round(displayRect.height() - f2);
                i7 = 0;
            } else {
                i7 = round2;
                i8 = i7;
            }
            this.t = round;
            this.u = round2;
            if (round == i6 && round2 == i8) {
                return;
            }
            this.n.fling(round, round2, i3, i4, i5, i6, i7, i8, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.n.isFinished() && this.n.computeScrollOffset()) {
                int currX = this.n.getCurrX();
                int currY = this.n.getCurrY();
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.E.postTranslate(this.t - currX, this.u - currY);
                com.github.chrisbanes.photoview.PhotoViewAttacher.this.B();
                this.t = currX;
                this.u = currY;
                com.github.chrisbanes.photoview.Compat.a(com.github.chrisbanes.photoview.PhotoViewAttacher.this.z, this);
            }
        }
    }

    public PhotoViewAttacher(android.widget.ImageView imageView) {
        this.z = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.T = 0.0f;
        this.B = new com.github.chrisbanes.photoview.CustomGestureDetector(imageView.getContext(), this.W);
        android.view.GestureDetector gestureDetector = new android.view.GestureDetector(imageView.getContext(), new com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass2());
        this.A = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass3());
    }

    public final void A() {
        com.github.chrisbanes.photoview.PhotoViewAttacher.FlingRunnable flingRunnable = this.Q;
        if (flingRunnable != null) {
            flingRunnable.a();
            this.Q = null;
        }
    }

    public final void B() {
        if (C()) {
            J(E());
        }
    }

    public final boolean C() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        android.graphics.RectF D = D(E());
        if (D == null) {
            return false;
        }
        float height = D.height();
        float width = D.width();
        float F = F(this.z);
        float f6 = 0.0f;
        if (height <= F) {
            int i = com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass4.a[this.V.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f4 = (F - height) / 2.0f;
                    f5 = D.top;
                } else {
                    f4 = F - height;
                    f5 = D.top;
                }
                f = f4 - f5;
            } else {
                f = -D.top;
            }
            this.S = 2;
        } else {
            float f7 = D.top;
            if (f7 > 0.0f) {
                this.S = 0;
                f = -f7;
            } else {
                float f8 = D.bottom;
                if (f8 < F) {
                    this.S = 1;
                    f = F - f8;
                } else {
                    this.S = -1;
                    f = 0.0f;
                }
            }
        }
        float G = G(this.z);
        if (width <= G) {
            int i2 = com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass4.a[this.V.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f2 = (G - width) / 2.0f;
                    f3 = D.left;
                } else {
                    f2 = G - width;
                    f3 = D.left;
                }
                f6 = f2 - f3;
            } else {
                f6 = -D.left;
            }
            this.R = 2;
        } else {
            float f9 = D.left;
            if (f9 > 0.0f) {
                this.R = 0;
                f6 = -f9;
            } else {
                float f10 = D.right;
                if (f10 < G) {
                    f6 = G - f10;
                    this.R = 1;
                } else {
                    this.R = -1;
                }
            }
        }
        this.E.postTranslate(f6, f);
        return true;
    }

    public final android.graphics.RectF D(android.graphics.Matrix matrix) {
        if (this.z.getDrawable() == null) {
            return null;
        }
        this.F.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.F);
        return this.F;
    }

    public final android.graphics.Matrix E() {
        this.D.set(this.C);
        this.D.postConcat(this.E);
        return this.D;
    }

    public final int F(android.widget.ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int G(android.widget.ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final float H(android.graphics.Matrix matrix, int i) {
        matrix.getValues(this.G);
        return this.G[i];
    }

    public final void I() {
        this.E.reset();
        setRotationBy(this.T);
        J(E());
        C();
    }

    public final void J(android.graphics.Matrix matrix) {
        android.graphics.RectF D;
        this.z.setImageMatrix(matrix);
        if (this.H == null || (D = D(matrix)) == null) {
            return;
        }
        this.H.onMatrixChanged(D);
    }

    public final void K(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float G = G(this.z);
        float F = F(this.z);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.C.reset();
        float f = intrinsicWidth;
        float f2 = G / f;
        float f3 = intrinsicHeight;
        float f4 = F / f3;
        android.widget.ImageView.ScaleType scaleType = this.V;
        if (scaleType == android.widget.ImageView.ScaleType.CENTER) {
            this.C.postTranslate((G - f) / 2.0f, (F - f3) / 2.0f);
        } else if (scaleType == android.widget.ImageView.ScaleType.CENTER_CROP) {
            float max = java.lang.Math.max(f2, f4);
            this.C.postScale(max, max);
            this.C.postTranslate((G - (f * max)) / 2.0f, (F - (f3 * max)) / 2.0f);
        } else if (scaleType == android.widget.ImageView.ScaleType.CENTER_INSIDE) {
            float min = java.lang.Math.min(1.0f, java.lang.Math.min(f2, f4));
            this.C.postScale(min, min);
            this.C.postTranslate((G - (f * min)) / 2.0f, (F - (f3 * min)) / 2.0f);
        } else {
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, f, f3);
            android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, G, F);
            if (((int) this.T) % 180 != 0) {
                rectF = new android.graphics.RectF(0.0f, 0.0f, f3, f);
            }
            int i = com.github.chrisbanes.photoview.PhotoViewAttacher.AnonymousClass4.a[this.V.ordinal()];
            if (i == 1) {
                this.C.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.C.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.C.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.C.setRectToRect(rectF, rectF2, android.graphics.Matrix.ScaleToFit.FILL);
            }
        }
        I();
    }

    public void getDisplayMatrix(android.graphics.Matrix matrix) {
        matrix.set(E());
    }

    public android.graphics.RectF getDisplayRect() {
        C();
        return D(E());
    }

    public android.graphics.Matrix getImageMatrix() {
        return this.D;
    }

    public float getMaximumScale() {
        return this.w;
    }

    public float getMediumScale() {
        return this.v;
    }

    public float getMinimumScale() {
        return this.u;
    }

    public float getScale() {
        return (float) java.lang.Math.sqrt(((float) java.lang.Math.pow(H(this.E, 0), 2.0d)) + ((float) java.lang.Math.pow(H(this.E, 3), 2.0d)));
    }

    public android.widget.ImageView.ScaleType getScaleType() {
        return this.V;
    }

    public void getSuppMatrix(android.graphics.Matrix matrix) {
        matrix.set(this.E);
    }

    @java.lang.Deprecated
    public boolean isZoomEnabled() {
        return this.U;
    }

    public boolean isZoomable() {
        return this.U;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        K(this.z.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        boolean z;
        com.github.chrisbanes.photoview.CustomGestureDetector customGestureDetector;
        boolean z2;
        android.view.GestureDetector gestureDetector;
        android.graphics.RectF displayRect;
        boolean z3 = false;
        if (!this.U || !com.github.chrisbanes.photoview.Util.c((android.widget.ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            android.view.ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            A();
        } else if (action == 1 || action == 3) {
            if (getScale() < this.u) {
                android.graphics.RectF displayRect2 = getDisplayRect();
                if (displayRect2 != null) {
                    view.post(new com.github.chrisbanes.photoview.PhotoViewAttacher.AnimatedZoomRunnable(getScale(), this.u, displayRect2.centerX(), displayRect2.centerY()));
                    z = true;
                }
            } else if (getScale() > this.w && (displayRect = getDisplayRect()) != null) {
                view.post(new com.github.chrisbanes.photoview.PhotoViewAttacher.AnimatedZoomRunnable(getScale(), this.w, displayRect.centerX(), displayRect.centerY()));
                z = true;
            }
            customGestureDetector = this.B;
            if (customGestureDetector == null) {
                boolean e = customGestureDetector.e();
                boolean d = this.B.d();
                boolean f = this.B.f(motionEvent);
                boolean z4 = (e || this.B.e()) ? false : true;
                boolean z5 = (d || this.B.d()) ? false : true;
                if (z4 && z5) {
                    z3 = true;
                }
                this.y = z3;
                z2 = f;
            } else {
                z2 = z;
            }
            gestureDetector = this.A;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        z = false;
        customGestureDetector = this.B;
        if (customGestureDetector == null) {
        }
        gestureDetector = this.A;
        return gestureDetector == null ? z2 : z2;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.x = z;
    }

    public void setBaseRotation(float f) {
        this.T = f % 360.0f;
        update();
        setRotationBy(this.T);
        B();
    }

    public boolean setDisplayMatrix(android.graphics.Matrix matrix) {
        if (matrix == null) {
            throw new java.lang.IllegalArgumentException("Matrix cannot be null");
        }
        if (this.z.getDrawable() == null) {
            return false;
        }
        this.E.set(matrix);
        B();
        return true;
    }

    public void setMaximumScale(float f) {
        com.github.chrisbanes.photoview.Util.a(this.u, this.v, f);
        this.w = f;
    }

    public void setMediumScale(float f) {
        com.github.chrisbanes.photoview.Util.a(this.u, f, this.w);
        this.v = f;
    }

    public void setMinimumScale(float f) {
        com.github.chrisbanes.photoview.Util.a(f, this.v, this.w);
        this.u = f;
    }

    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.A.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.M = onLongClickListener;
    }

    public void setOnMatrixChangeListener(com.github.chrisbanes.photoview.OnMatrixChangedListener onMatrixChangedListener) {
        this.H = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(com.github.chrisbanes.photoview.OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.J = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(com.github.chrisbanes.photoview.OnPhotoTapListener onPhotoTapListener) {
        this.I = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(com.github.chrisbanes.photoview.OnScaleChangedListener onScaleChangedListener) {
        this.N = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(com.github.chrisbanes.photoview.OnSingleFlingListener onSingleFlingListener) {
        this.O = onSingleFlingListener;
    }

    public void setOnViewDragListener(com.github.chrisbanes.photoview.OnViewDragListener onViewDragListener) {
        this.P = onViewDragListener;
    }

    public void setOnViewTapListener(com.github.chrisbanes.photoview.OnViewTapListener onViewTapListener) {
        this.K = onViewTapListener;
    }

    public void setRotationBy(float f) {
        this.E.postRotate(f % 360.0f);
        B();
    }

    public void setRotationTo(float f) {
        this.E.setRotate(f % 360.0f);
        B();
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        if (f < this.u || f > this.w) {
            throw new java.lang.IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.z.post(new com.github.chrisbanes.photoview.PhotoViewAttacher.AnimatedZoomRunnable(getScale(), f, f2, f3));
        } else {
            this.E.setScale(f, f, f2, f3);
            B();
        }
    }

    public void setScale(float f, boolean z) {
        setScale(f, this.z.getRight() / 2, this.z.getBottom() / 2, z);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        com.github.chrisbanes.photoview.Util.a(f, f2, f3);
        this.u = f;
        this.v = f2;
        this.w = f3;
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        if (!com.github.chrisbanes.photoview.Util.d(scaleType) || scaleType == this.V) {
            return;
        }
        this.V = scaleType;
        update();
    }

    public void setZoomInterpolator(android.view.animation.Interpolator interpolator) {
        this.n = interpolator;
    }

    public void setZoomTransitionDuration(int i) {
        this.t = i;
    }

    public void setZoomable(boolean z) {
        this.U = z;
        update();
    }

    public void update() {
        if (this.U) {
            K(this.z.getDrawable());
        } else {
            I();
        }
    }
}

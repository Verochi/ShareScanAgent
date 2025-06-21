package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class dt extends android.widget.ScrollView {
    public static final java.lang.String a = "dt";
    int b;
    private android.content.Context c;
    private android.widget.LinearLayout d;
    private int e;
    private java.util.List<java.lang.String> f;
    private int g;
    private int h;
    private android.graphics.Bitmap i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private java.lang.Runnable p;
    private int q;
    private com.amap.api.mapcore.util.dt.a r;

    /* renamed from: com.amap.api.mapcore.util.dt$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.amap.api.mapcore.util.dt$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01201 implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            public RunnableC01201(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.dt dtVar = com.amap.api.mapcore.util.dt.this;
                dtVar.smoothScrollTo(0, (dtVar.o - this.a) + com.amap.api.mapcore.util.dt.this.e);
                com.amap.api.mapcore.util.dt dtVar2 = com.amap.api.mapcore.util.dt.this;
                dtVar2.b = this.b + dtVar2.m + 1;
                com.amap.api.mapcore.util.dt.this.f();
            }
        }

        /* renamed from: com.amap.api.mapcore.util.dt$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            public AnonymousClass2(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.amap.api.mapcore.util.dt dtVar = com.amap.api.mapcore.util.dt.this;
                dtVar.smoothScrollTo(0, dtVar.o - this.a);
                com.amap.api.mapcore.util.dt dtVar2 = com.amap.api.mapcore.util.dt.this;
                dtVar2.b = this.b + dtVar2.m;
                com.amap.api.mapcore.util.dt.this.f();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.amap.api.mapcore.util.dt.this.o - com.amap.api.mapcore.util.dt.this.getScrollY() != 0) {
                com.amap.api.mapcore.util.dt dtVar = com.amap.api.mapcore.util.dt.this;
                dtVar.o = dtVar.getScrollY();
                com.amap.api.mapcore.util.dt dtVar2 = com.amap.api.mapcore.util.dt.this;
                dtVar2.postDelayed(dtVar2.p, com.amap.api.mapcore.util.dt.this.q);
                return;
            }
            if (com.amap.api.mapcore.util.dt.this.e == 0) {
                return;
            }
            int i = com.amap.api.mapcore.util.dt.this.o % com.amap.api.mapcore.util.dt.this.e;
            int i2 = com.amap.api.mapcore.util.dt.this.o / com.amap.api.mapcore.util.dt.this.e;
            if (i == 0) {
                com.amap.api.mapcore.util.dt dtVar3 = com.amap.api.mapcore.util.dt.this;
                dtVar3.b = i2 + dtVar3.m;
                com.amap.api.mapcore.util.dt.this.f();
            } else if (i > com.amap.api.mapcore.util.dt.this.e / 2) {
                com.amap.api.mapcore.util.dt.this.post(new com.amap.api.mapcore.util.dt.AnonymousClass1.RunnableC01201(i, i2));
            } else {
                com.amap.api.mapcore.util.dt.this.post(new com.amap.api.mapcore.util.dt.AnonymousClass1.AnonymousClass2(i, i2));
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.dt$2, reason: invalid class name */
    public class AnonymousClass2 extends android.graphics.drawable.Drawable {
        public AnonymousClass2() {
        }

        private void a(android.graphics.Canvas canvas) {
            canvas.drawColor(com.amap.api.mapcore.util.dt.this.j);
        }

        private void b(android.graphics.Canvas canvas) {
            android.graphics.Paint paint = new android.graphics.Paint();
            android.graphics.Rect rect = new android.graphics.Rect();
            android.graphics.Rect rect2 = new android.graphics.Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = com.amap.api.mapcore.util.dt.this.i.getWidth() + 0;
            rect.bottom = com.amap.api.mapcore.util.dt.this.i.getHeight() + 0;
            rect2.left = 0;
            rect2.top = com.amap.api.mapcore.util.dt.this.e()[0];
            rect2.right = com.amap.api.mapcore.util.dt.this.h + 0;
            rect2.bottom = com.amap.api.mapcore.util.dt.this.e()[1];
            canvas.drawBitmap(com.amap.api.mapcore.util.dt.this.i, rect, rect2, paint);
        }

        private void c(android.graphics.Canvas canvas) {
            android.graphics.Paint paint = new android.graphics.Paint();
            android.graphics.Rect clipBounds = canvas.getClipBounds();
            paint.setColor(com.amap.api.mapcore.util.dt.this.k);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setStrokeWidth(com.amap.api.mapcore.util.dt.this.l);
            canvas.drawRect(clipBounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(android.graphics.Canvas canvas) {
            try {
                a(canvas);
                b(canvas);
                c(canvas);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }
    }

    /* renamed from: com.amap.api.mapcore.util.dt$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.mapcore.util.dt dtVar = com.amap.api.mapcore.util.dt.this;
            dtVar.smoothScrollTo(0, this.a * dtVar.e);
        }
    }

    public interface a {
        void a(int i);
    }

    public dt(android.content.Context context) {
        super(context);
        this.e = 0;
        this.g = -1;
        this.i = null;
        this.j = android.graphics.Color.parseColor("#eeffffff");
        this.k = android.graphics.Color.parseColor("#44383838");
        this.l = 4;
        this.m = 1;
        this.b = 1;
        this.q = 50;
        a(context);
    }

    private static int a(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(android.view.View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    private void a(int i) {
        int i2 = this.e;
        if (i2 == 0) {
            return;
        }
        int i3 = this.m;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.d.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            android.widget.TextView textView = (android.widget.TextView) this.d.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(android.graphics.Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(android.graphics.Color.parseColor("#bbbbbb"));
            }
        }
    }

    private void a(android.content.Context context) {
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                java.io.InputStream open = com.amap.api.mapcore.util.df.a(context).open("map_indoor_select.png");
                this.i = android.graphics.BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (java.lang.Throwable unused) {
        }
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.d);
        this.p = new com.amap.api.mapcore.util.dt.AnonymousClass1();
    }

    private android.widget.TextView b(java.lang.String str) {
        android.widget.TextView textView = new android.widget.TextView(this.c);
        textView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a2 = a(this.c, 8.0f);
        int a3 = a(this.c, 6.0f);
        textView.setPadding(a2, a3, a2, a3);
        if (this.e == 0) {
            this.e = a(textView);
            this.d.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, this.e * this.n));
            setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, this.e * this.n));
        }
        return textView;
    }

    private static void b(android.view.View view) {
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void c() {
        this.o = getScrollY();
        postDelayed(this.p, this.q);
    }

    private void d() {
        java.util.List<java.lang.String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        this.d.removeAllViews();
        this.n = (this.m * 2) + 1;
        for (int size = this.f.size() - 1; size >= 0; size--) {
            this.d.addView(b(this.f.get(size)));
        }
        a(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] e() {
        int i = this.e;
        int i2 = this.m;
        return new int[]{i * i2, i * (i2 + 1)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.amap.api.mapcore.util.dt.a aVar = this.r;
        if (aVar != null) {
            try {
                aVar.a(g());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private int g() {
        java.util.List<java.lang.String> list = this.f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return java.lang.Math.min(this.f.size() - (this.m * 2), java.lang.Math.max(0, ((this.f.size() - 1) - this.b) - this.m));
    }

    public final void a() {
        android.graphics.Bitmap bitmap = this.i;
        if (bitmap != null && !bitmap.isRecycled()) {
            com.amap.api.mapcore.util.dl.a(this.i);
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public final void a(com.amap.api.mapcore.util.dt.a aVar) {
        this.r = aVar;
    }

    public final void a(java.lang.String str) {
        java.util.List<java.lang.String> list = this.f;
        if (list == null || list.size() == 0) {
            return;
        }
        int indexOf = this.f.indexOf(str);
        int size = this.f.size();
        int i = ((size - r1) - 1) - indexOf;
        this.b = this.m + i;
        post(new com.amap.api.mapcore.util.dt.AnonymousClass3(i));
    }

    public final void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public final void a(java.lang.String[] strArr) {
        if (this.f == null) {
            this.f = new java.util.ArrayList();
        }
        this.f.clear();
        for (java.lang.String str : strArr) {
            this.f.add(str);
        }
        for (int i = 0; i < this.m; i++) {
            this.f.add(0, "");
            this.f.add("");
        }
        d();
    }

    public final boolean b() {
        return getVisibility() == 0;
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a(i2);
        if (i2 > i4) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.h = i;
        try {
            setBackgroundDrawable(null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.j = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (this.h == 0) {
            try {
                android.view.WindowManager windowManager = (android.view.WindowManager) this.c.getSystemService("window");
                if (windowManager != null) {
                    this.h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new com.amap.api.mapcore.util.dt.AnonymousClass2());
    }
}

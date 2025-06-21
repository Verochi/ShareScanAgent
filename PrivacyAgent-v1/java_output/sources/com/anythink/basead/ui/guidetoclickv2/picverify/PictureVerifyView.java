package com.anythink.basead.ui.guidetoclickv2.picverify;

/* loaded from: classes12.dex */
public class PictureVerifyView extends com.anythink.core.common.ui.component.RoundImageView {
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final int f = 4;
    private static final int g = 5;
    private static final int h = 6;
    private static final int i = 20;
    private float A;
    private float B;
    private float C;
    private int j;
    private com.anythink.basead.ui.guidetoclickv2.picverify.c k;
    private com.anythink.basead.ui.guidetoclickv2.picverify.c l;
    private android.graphics.Bitmap m;
    private android.graphics.Path n;
    private android.graphics.Paint o;
    private android.graphics.Paint p;
    private android.graphics.Paint q;
    private long r;

    /* renamed from: s, reason: collision with root package name */
    private long f154s;
    private int t;
    private boolean u;
    private com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a v;
    private com.anythink.basead.ui.guidetoclickv2.picverify.a w;
    private int x;
    private int y;
    private float z;

    public interface a {
        void a();

        void b();
    }

    public PictureVerifyView(android.content.Context context) {
        this(context, null);
    }

    public PictureVerifyView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PictureVerifyView(android.content.Context context, android.util.AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 4;
        this.t = 50;
        this.u = true;
        this.y = -1;
        com.anythink.basead.ui.guidetoclickv2.picverify.b bVar = new com.anythink.basead.ui.guidetoclickv2.picverify.b(context);
        this.w = bVar;
        this.p = bVar.a();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.q = paint;
        paint.setColor(android.graphics.Color.parseColor("#B5B5B5"));
        this.q.setStrokeWidth(com.anythink.core.common.o.i.a(getContext(), 1.0f));
        this.q.setStyle(android.graphics.Paint.Style.STROKE);
        this.o = this.w.b();
    }

    private android.graphics.Bitmap a(android.graphics.Bitmap bitmap) {
        com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.k;
        int i2 = cVar.a;
        int i3 = cVar.b;
        int i4 = this.t;
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap, i2, i3, i4, i4);
        bitmap.recycle();
        return createBitmap;
    }

    private void a() {
        android.graphics.Bitmap bitmap;
        if (getDrawable() == null || getWidth() <= 0 || getHeight() < 0) {
            return;
        }
        if (this.k == null) {
            this.k = this.w.a(getWidth(), getHeight(), this.t);
            this.l = this.w.b(getWidth(), getHeight(), this.t);
        }
        if (this.n == null) {
            android.graphics.Path a2 = this.w.a(this.t);
            this.n = a2;
            com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.k;
            a2.offset(cVar.a, cVar.b);
        }
        if (this.m == null) {
            if (getDrawable() != null) {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
                getDrawable().setBounds(0, 0, getWidth(), getHeight());
                canvas.clipPath(this.n);
                getDrawable().draw(canvas);
                this.w.a(getContext(), canvas, this.n);
                com.anythink.basead.ui.guidetoclickv2.picverify.c cVar2 = this.k;
                int i2 = cVar2.a;
                int i3 = cVar2.b;
                int i4 = this.t;
                bitmap = android.graphics.Bitmap.createBitmap(createBitmap, i2, i3, i4, i4);
                createBitmap.recycle();
            } else {
                bitmap = null;
            }
            this.m = bitmap;
        }
    }

    private void a(float f2, float f3) {
        this.j = 1;
        com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.l;
        int i2 = this.t;
        cVar.a = (int) (f2 - (i2 / 2.0f));
        cVar.b = (int) (f3 - (i2 / 2.0f));
        this.r = java.lang.System.currentTimeMillis();
        postInvalidate();
    }

    private void a(com.anythink.basead.ui.guidetoclickv2.picverify.a aVar) {
        this.w = aVar;
    }

    private void a(boolean z) {
        this.u = z;
    }

    private void b() {
        this.j = 4;
        this.m = null;
        this.k = null;
        this.n = null;
        postInvalidate();
    }

    private void b(float f2, float f3) {
        this.j = 2;
        com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.l;
        cVar.a = (int) (cVar.a + f2);
        cVar.b = (int) (cVar.b + f3);
        postInvalidate();
    }

    private void c() {
        this.j = 6;
        postInvalidate();
    }

    private void d() {
        this.j = 5;
        postInvalidate();
    }

    private android.graphics.Bitmap e() {
        if (getDrawable() == null) {
            return null;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        getDrawable().setBounds(0, 0, getWidth(), getHeight());
        canvas.clipPath(this.n);
        getDrawable().draw(canvas);
        this.w.a(getContext(), canvas, this.n);
        com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.k;
        int i2 = cVar.a;
        int i3 = cVar.b;
        int i4 = this.t;
        android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(createBitmap, i2, i3, i4, i4);
        createBitmap.recycle();
        return createBitmap2;
    }

    private void f() {
        if (java.lang.Math.abs(this.l.a - this.k.a) >= 20 || java.lang.Math.abs(this.l.b - this.k.b) >= 20) {
            this.j = 6;
            postInvalidate();
            return;
        }
        this.j = 5;
        postInvalidate();
        com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void callback(com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a aVar) {
        this.v = aVar;
    }

    public void down(int i2) {
        this.r = java.lang.System.currentTimeMillis();
        this.j = 1;
        com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.l;
        int width = getWidth() - this.t;
        cVar.a = (int) (((i2 / 100.0f) * (width - (r2 * 2))) + this.l.c);
        postInvalidate();
    }

    public void loose() {
        this.j = 3;
        this.f154s = java.lang.System.currentTimeMillis();
        if (java.lang.Math.abs(this.l.a - this.k.a) >= 20 || java.lang.Math.abs(this.l.b - this.k.b) >= 20) {
            this.j = 6;
            postInvalidate();
        } else {
            this.j = 5;
            postInvalidate();
            com.anythink.basead.ui.guidetoclickv2.picverify.PictureVerifyView.a aVar = this.v;
            if (aVar != null) {
                aVar.a();
            }
        }
        postInvalidate();
    }

    public void move(int i2) {
        if (this.y != i2) {
            this.y = i2;
            this.j = 2;
            com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.l;
            int width = getWidth() - this.t;
            cVar.a = (int) (((i2 / 100.0f) * (width - (r2 * 2))) + this.l.c);
            postInvalidate();
        }
    }

    @Override // com.anythink.core.common.ui.component.RoundImageView, com.anythink.core.common.res.image.RecycleImageView, android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmap;
        if (getDrawable() != null && getWidth() > 0 && getHeight() >= 0) {
            if (this.k == null) {
                this.k = this.w.a(getWidth(), getHeight(), this.t);
                this.l = this.w.b(getWidth(), getHeight(), this.t);
            }
            if (this.n == null) {
                android.graphics.Path a2 = this.w.a(this.t);
                this.n = a2;
                com.anythink.basead.ui.guidetoclickv2.picverify.c cVar = this.k;
                a2.offset(cVar.a, cVar.b);
            }
            if (this.m == null) {
                if (getDrawable() != null) {
                    android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(getWidth(), getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                    android.graphics.Canvas canvas2 = new android.graphics.Canvas(createBitmap);
                    getDrawable().setBounds(0, 0, getWidth(), getHeight());
                    canvas2.clipPath(this.n);
                    getDrawable().draw(canvas2);
                    this.w.a(getContext(), canvas2, this.n);
                    com.anythink.basead.ui.guidetoclickv2.picverify.c cVar2 = this.k;
                    int i2 = cVar2.a;
                    int i3 = cVar2.b;
                    int i4 = this.t;
                    bitmap = android.graphics.Bitmap.createBitmap(createBitmap, i2, i3, i4, i4);
                    createBitmap.recycle();
                } else {
                    bitmap = null;
                }
                this.m = bitmap;
            }
        }
        if (getDrawable() == null) {
            return;
        }
        if (this.j != 5) {
            canvas.drawPath(this.n, this.p);
            com.anythink.basead.ui.guidetoclickv2.picverify.c cVar3 = this.k;
            int i5 = cVar3.a;
            int i6 = cVar3.b;
            int i7 = this.t;
            canvas.drawRect(i5, i6, i5 + i7, i6 + i7, this.q);
        }
        int i8 = this.j;
        if (i8 == 2 || i8 == 4 || i8 == 1 || i8 == 6) {
            android.graphics.Bitmap bitmap2 = this.m;
            com.anythink.basead.ui.guidetoclickv2.picverify.c cVar4 = this.l;
            canvas.drawBitmap(bitmap2, cVar4.a, cVar4.b, this.o);
        }
    }

    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.n = null;
        this.l = null;
        this.k = null;
        this.m.recycle();
        this.m = null;
        setImageBitmap(bitmap);
    }

    public void setBlockSize(int i2) {
        this.t = i2;
        this.n = null;
        this.l = null;
        this.k = null;
        this.m = null;
        postInvalidate();
    }
}

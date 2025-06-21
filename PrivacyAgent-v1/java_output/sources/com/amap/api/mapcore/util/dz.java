package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dz extends android.view.View {
    private android.graphics.Bitmap a;
    private android.graphics.Bitmap b;
    private android.graphics.Bitmap c;
    private android.graphics.Bitmap d;
    private android.graphics.Bitmap e;
    private android.graphics.Bitmap f;
    private android.graphics.Bitmap g;
    private android.graphics.Paint h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f124s;
    private android.content.Context t;
    private boolean u;
    private float v;
    private float w;
    private boolean x;
    private boolean y;

    /* renamed from: com.amap.api.mapcore.util.dz$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        public AnonymousClass1() {
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.dz.this.a(com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
            com.amap.api.mapcore.util.dz.this.a(com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
            if ("".equals(com.amap.api.mapcore.util.db.a(com.amap.api.mapcore.util.dz.this.t, "amap_web_logo", "md5_day", ""))) {
                if (com.amap.api.mapcore.util.dz.this.c == null || com.amap.api.mapcore.util.dz.this.d == null) {
                    com.amap.api.mapcore.util.db.a(com.amap.api.mapcore.util.dz.this.t, "amap_web_logo", "md5_day", (java.lang.Object) "0b718b5f291b09d2b62be725dfb977b3");
                    com.amap.api.mapcore.util.db.a(com.amap.api.mapcore.util.dz.this.t, "amap_web_logo", "md5_night", (java.lang.Object) "4b1405462a5c910de0e0723ffd96c018");
                    return;
                }
                com.amap.api.mapcore.util.db.a(com.amap.api.mapcore.util.dz.this.t, "amap_web_logo", "md5_day", (java.lang.Object) com.amap.api.mapcore.util.fd.a(com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME));
                java.lang.String a = com.amap.api.mapcore.util.fd.a(com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
                if (!"".equals(a)) {
                    com.amap.api.mapcore.util.db.a(com.amap.api.mapcore.util.dz.this.t, "amap_web_logo", "md5_night", (java.lang.Object) a);
                }
                com.amap.api.mapcore.util.dz.this.d(true);
            }
        }
    }

    public dz(android.content.Context context) {
        super(context);
        java.io.InputStream inputStream;
        java.io.InputStream open;
        this.h = new android.graphics.Paint();
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 10;
        this.n = 0;
        this.o = 0;
        this.p = 10;
        this.q = 8;
        this.r = false;
        this.f124s = false;
        this.u = true;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = true;
        this.y = false;
        java.io.InputStream inputStream2 = null;
        try {
            this.t = context.getApplicationContext();
            open = com.amap.api.mapcore.util.df.a(context).open("ap.data");
        } catch (java.lang.Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(open);
            this.f = decodeStream;
            this.a = com.amap.api.mapcore.util.dl.a(decodeStream, com.amap.api.mapcore.util.l.a);
            open.close();
            inputStream2 = com.amap.api.mapcore.util.df.a(context).open("ap1.data");
            android.graphics.Bitmap decodeStream2 = android.graphics.BitmapFactory.decodeStream(inputStream2);
            this.g = decodeStream2;
            this.b = com.amap.api.mapcore.util.dl.a(decodeStream2, com.amap.api.mapcore.util.l.a);
            inputStream2.close();
            this.k = this.b.getWidth();
            this.j = this.b.getHeight();
            this.h.setAntiAlias(true);
            this.h.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            this.h.setStyle(android.graphics.Paint.Style.STROKE);
            com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = context.getFilesDir() + "/icon_web_day.data";
            com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = context.getFilesDir() + "/icon_web_night.data";
            com.amap.api.mapcore.util.dj.a().a(new com.amap.api.mapcore.util.dz.AnonymousClass1());
            try {
                open.close();
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            try {
                inputStream2.close();
            } catch (java.lang.Throwable th3) {
                th3.printStackTrace();
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStream = inputStream2;
            inputStream2 = open;
            try {
                com.amap.api.mapcore.util.gd.c(th, "WaterMarkerView", "create");
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (java.lang.Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.lang.Throwable th6) {
                        th6.printStackTrace();
                    }
                }
            } finally {
            }
        }
    }

    private android.graphics.Bitmap e() {
        android.graphics.Bitmap bitmap;
        android.graphics.Bitmap bitmap2;
        android.graphics.Bitmap bitmap3;
        return (!this.y || (bitmap3 = this.e) == null) ? this.i ? (!this.f124s || (bitmap2 = this.d) == null) ? this.b : bitmap2 : (!this.f124s || (bitmap = this.c) == null) ? this.a : bitmap : bitmap3;
    }

    private void f() {
        int i = this.o;
        if (i == 0) {
            h();
        } else if (i == 2) {
            g();
        }
        this.m = this.p;
        int height = (getHeight() - this.q) - this.j;
        this.n = height;
        if (this.m < 0) {
            this.m = 0;
        }
        if (height < 0) {
            this.n = 0;
        }
    }

    private void g() {
        if (this.x) {
            this.p = (int) (getWidth() * this.v);
        } else {
            this.p = (int) ((getWidth() * this.v) - this.k);
        }
        this.q = (int) (getHeight() * this.w);
    }

    private void h() {
        int i = this.l;
        if (i == 1) {
            this.p = (getWidth() - this.k) / 2;
        } else if (i == 2) {
            this.p = (getWidth() - this.k) - 10;
        } else {
            this.p = 10;
        }
        this.q = 8;
    }

    public final void a() {
        try {
            android.graphics.Bitmap bitmap = this.a;
            if (bitmap != null) {
                com.amap.api.mapcore.util.dl.a(bitmap);
                this.a = null;
            }
            android.graphics.Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap2);
                this.b = null;
            }
            this.a = null;
            this.b = null;
            android.graphics.Bitmap bitmap3 = this.f;
            if (bitmap3 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap3);
                this.f = null;
            }
            android.graphics.Bitmap bitmap4 = this.g;
            if (bitmap4 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap4);
                this.g = null;
            }
            android.graphics.Bitmap bitmap5 = this.c;
            if (bitmap5 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap5);
            }
            this.c = null;
            android.graphics.Bitmap bitmap6 = this.d;
            if (bitmap6 != null) {
                com.amap.api.mapcore.util.dl.a(bitmap6);
            }
            this.d = null;
            android.graphics.Bitmap bitmap7 = this.e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.h = null;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        this.o = 0;
        this.l = i;
        c();
    }

    public final void a(int i, float f) {
        if (this.u) {
            this.o = 2;
            float max = java.lang.Math.max(0.0f, java.lang.Math.min(f, 1.0f));
            if (i == 0) {
                this.v = max;
                this.x = true;
            } else if (i == 1) {
                this.v = 1.0f - max;
                this.x = false;
            } else if (i == 2) {
                this.w = 1.0f - max;
            }
            c();
        }
    }

    public final void a(java.lang.String str, int i) {
        try {
            if (this.u && new java.io.File(str).exists()) {
                if (i == 0) {
                    android.graphics.Bitmap bitmap = this.c;
                    android.graphics.Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str);
                    this.f = decodeFile;
                    this.c = com.amap.api.mapcore.util.dl.a(decodeFile, com.amap.api.mapcore.util.l.a);
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    com.amap.api.mapcore.util.dl.a(bitmap);
                    return;
                }
                if (i == 1) {
                    android.graphics.Bitmap bitmap2 = this.d;
                    android.graphics.Bitmap decodeFile2 = android.graphics.BitmapFactory.decodeFile(str);
                    this.f = decodeFile2;
                    this.d = com.amap.api.mapcore.util.dl.a(decodeFile2, com.amap.api.mapcore.util.l.a);
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    com.amap.api.mapcore.util.dl.a(bitmap2);
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (this.u) {
            try {
                this.i = z;
                if (z) {
                    this.h.setColor(-1);
                } else {
                    this.h.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final android.graphics.Point b() {
        return new android.graphics.Point(this.m, this.n - 2);
    }

    public final void b(int i) {
        this.o = 1;
        this.q = i;
        c();
    }

    public final void b(boolean z) {
        if (this.u) {
            this.y = z;
            if (!z) {
                this.k = this.a.getWidth();
                this.j = this.a.getHeight();
                return;
            }
            android.graphics.Bitmap bitmap = this.e;
            if (bitmap != null) {
                this.k = bitmap.getWidth();
                this.j = this.e.getHeight();
            }
        }
    }

    public final void c() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        f();
        postInvalidate();
    }

    public final void c(int i) {
        this.o = 1;
        this.p = i;
        c();
    }

    public final void c(boolean z) {
        this.u = z;
    }

    public final float d(int i) {
        float f;
        if (!this.u) {
            return 0.0f;
        }
        if (i == 0) {
            return this.v;
        }
        if (i == 1) {
            f = this.v;
        } else {
            if (i != 2) {
                return 0.0f;
            }
            f = this.w;
        }
        return 1.0f - f;
    }

    public final void d(boolean z) {
        if (this.u && this.f124s != z) {
            this.f124s = z;
            if (!z) {
                this.k = this.a.getWidth();
                this.j = this.a.getHeight();
                return;
            }
            if (this.i) {
                android.graphics.Bitmap bitmap = this.d;
                if (bitmap != null) {
                    this.k = bitmap.getWidth();
                    this.j = this.d.getHeight();
                    return;
                }
                return;
            }
            android.graphics.Bitmap bitmap2 = this.c;
            if (bitmap2 != null) {
                this.k = bitmap2.getWidth();
                this.j = this.c.getHeight();
            }
        }
    }

    public final boolean d() {
        return this.i;
    }

    @Override // android.view.View
    public final void onDraw(android.graphics.Canvas canvas) {
        try {
            if (!this.u || getWidth() == 0 || getHeight() == 0 || this.b == null) {
                return;
            }
            if (!this.r) {
                f();
                this.r = true;
            }
            canvas.drawBitmap(e(), this.m, this.n, this.h);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}

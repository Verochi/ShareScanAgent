package com.anythink.expressad.video.dynview.g;

/* loaded from: classes12.dex */
public final class a extends android.graphics.drawable.ShapeDrawable {
    private int a;
    private float b;
    private float c;
    private int d;
    private int e;
    private android.graphics.Bitmap f;
    private android.graphics.Bitmap g;
    private boolean h;
    private android.graphics.Paint i;

    /* renamed from: com.anythink.expressad.video.dynview.g.a$a, reason: collision with other inner class name */
    public static class C0228a implements com.anythink.expressad.video.dynview.g.a.b {
        private android.graphics.drawable.shapes.RectShape a;
        private android.graphics.Bitmap b;
        private android.graphics.Bitmap c;
        private boolean d;
        private int e;
        private int f;
        private int g;
        private float h;
        private float i;

        private C0228a() {
            this.f = 100;
            this.g = 10;
            this.a = new android.graphics.drawable.shapes.RectShape();
        }

        public /* synthetic */ C0228a(byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b a() {
            this.d = true;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b a(float f) {
            this.h = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b a(int i) {
            this.e = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b a(android.graphics.Bitmap bitmap) {
            this.b = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b b(float f) {
            this.i = f;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b b(int i) {
            this.f = i;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b b(android.graphics.Bitmap bitmap) {
            this.c = bitmap;
            return this;
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a b() {
            return new com.anythink.expressad.video.dynview.g.a(this, (byte) 0);
        }

        @Override // com.anythink.expressad.video.dynview.g.a.b
        public final com.anythink.expressad.video.dynview.g.a.b c(int i) {
            this.g = i;
            return this;
        }
    }

    public interface b {
        com.anythink.expressad.video.dynview.g.a.b a();

        com.anythink.expressad.video.dynview.g.a.b a(float f);

        com.anythink.expressad.video.dynview.g.a.b a(int i);

        com.anythink.expressad.video.dynview.g.a.b a(android.graphics.Bitmap bitmap);

        com.anythink.expressad.video.dynview.g.a.b b(float f);

        com.anythink.expressad.video.dynview.g.a.b b(int i);

        com.anythink.expressad.video.dynview.g.a.b b(android.graphics.Bitmap bitmap);

        com.anythink.expressad.video.dynview.g.a b();

        com.anythink.expressad.video.dynview.g.a.b c(int i);
    }

    private a(com.anythink.expressad.video.dynview.g.a.C0228a c0228a) {
        super(c0228a.a);
        this.h = false;
        this.f = c0228a.b;
        this.g = c0228a.c;
        this.h = c0228a.d;
        this.a = c0228a.e;
        this.d = c0228a.f;
        this.e = c0228a.g;
        this.b = c0228a.h;
        this.c = c0228a.i;
        android.graphics.Paint paint = new android.graphics.Paint();
        this.i = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.i.setAntiAlias(true);
    }

    public /* synthetic */ a(com.anythink.expressad.video.dynview.g.a.C0228a c0228a, byte b2) {
        this(c0228a);
    }

    public static com.anythink.expressad.video.dynview.g.a.C0228a a() {
        return new com.anythink.expressad.video.dynview.g.a.C0228a((byte) 0);
    }

    private void a(android.graphics.Canvas canvas) {
        float f = this.c / 2.0f;
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, (this.d + f) - this.e);
        path.lineTo(this.b, (f - this.d) - this.e);
        path.lineTo(this.b, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            android.graphics.Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        android.graphics.Path path2 = new android.graphics.Path();
        path2.moveTo(0.0f, this.d + f + this.e);
        path2.lineTo(0.0f, this.c);
        path2.lineTo(this.b, this.c);
        path2.lineTo(this.b, (f - this.d) + this.e);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        android.graphics.Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a(android.graphics.Canvas canvas, android.graphics.Path path) {
        this.i.setColor(android.graphics.Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.i);
    }

    private void a(android.graphics.Canvas canvas, android.graphics.Path path, android.graphics.Bitmap bitmap) {
        android.graphics.Shader.TileMode tileMode = android.graphics.Shader.TileMode.CLAMP;
        this.i.setShader(new android.graphics.BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawPath(path, this.i);
    }

    private void b(android.graphics.Canvas canvas) {
        float f = this.b / 2.0f;
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(0.0f, this.c);
        path.lineTo((f - this.d) - this.e, this.c);
        path.lineTo((this.d + f) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } else {
            android.graphics.Bitmap bitmap = this.f;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    a(canvas, path, this.f);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        android.graphics.Path path2 = new android.graphics.Path();
        path2.moveTo(this.d + f + this.e, 0.0f);
        path2.lineTo(this.b, 0.0f);
        path2.lineTo(this.b, this.c);
        path2.lineTo((f - this.d) + this.e, this.c);
        if (this.h) {
            try {
                a(canvas, path2);
                return;
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        android.graphics.Bitmap bitmap2 = this.g;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        try {
            a(canvas, path2, this.g);
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(android.graphics.Canvas canvas) {
        super.draw(canvas);
        if (this.a == 1) {
            float f = this.c / 2.0f;
            android.graphics.Path path = new android.graphics.Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (this.d + f) - this.e);
            path.lineTo(this.b, (f - this.d) - this.e);
            path.lineTo(this.b, 0.0f);
            if (this.h) {
                try {
                    a(canvas, path);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } else {
                android.graphics.Bitmap bitmap = this.f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            android.graphics.Path path2 = new android.graphics.Path();
            path2.moveTo(0.0f, this.d + f + this.e);
            path2.lineTo(0.0f, this.c);
            path2.lineTo(this.b, this.c);
            path2.lineTo(this.b, (f - this.d) + this.e);
            if (this.h) {
                try {
                    a(canvas, path2);
                    return;
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            android.graphics.Bitmap bitmap2 = this.g;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                return;
            }
            try {
                a(canvas, path2, this.g);
                return;
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        float f2 = this.b / 2.0f;
        android.graphics.Path path3 = new android.graphics.Path();
        path3.moveTo(0.0f, 0.0f);
        path3.lineTo(0.0f, this.c);
        path3.lineTo((f2 - this.d) - this.e, this.c);
        path3.lineTo((this.d + f2) - this.e, 0.0f);
        if (this.h) {
            try {
                a(canvas, path3);
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
        } else {
            android.graphics.Bitmap bitmap3 = this.f;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                try {
                    a(canvas, path3, this.f);
                } catch (java.lang.Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        android.graphics.Path path4 = new android.graphics.Path();
        path4.moveTo(this.d + f2 + this.e, 0.0f);
        path4.lineTo(this.b, 0.0f);
        path4.lineTo(this.b, this.c);
        path4.lineTo((f2 - this.d) + this.e, this.c);
        if (this.h) {
            try {
                a(canvas, path4);
                return;
            } catch (java.lang.Exception e7) {
                e7.printStackTrace();
                return;
            }
        }
        android.graphics.Bitmap bitmap4 = this.g;
        if (bitmap4 == null || bitmap4.isRecycled()) {
            return;
        }
        try {
            a(canvas, path4, this.g);
        } catch (java.lang.Exception e8) {
            e8.printStackTrace();
        }
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }
}

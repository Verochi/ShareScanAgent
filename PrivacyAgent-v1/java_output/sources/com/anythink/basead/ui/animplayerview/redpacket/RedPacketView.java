package com.anythink.basead.ui.animplayerview.redpacket;

/* loaded from: classes12.dex */
public class RedPacketView extends android.view.View {
    public static final java.lang.String TAG = "RedPacketView";
    private static final double a = 0.15d;
    private static final double b = 0.2d;
    private static final int c = 400;
    private final android.graphics.Matrix d;
    private final java.util.List<com.anythink.basead.ui.animplayerview.redpacket.a> e;
    private final java.util.Map<java.lang.Integer, java.lang.Float> f;
    private java.util.List<java.lang.Integer> g;
    private android.graphics.Paint h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private android.graphics.Bitmap n;
    private boolean o;

    public RedPacketView(android.content.Context context) {
        this(context, null);
    }

    public RedPacketView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new android.graphics.Matrix();
        this.e = new java.util.ArrayList();
        this.f = new java.util.HashMap();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.h = paint;
        paint.setFilterBitmap(true);
        this.h.setDither(true);
        this.h.setAntiAlias(true);
        setLayerType(2, null);
    }

    private static int a(int i) {
        int i2 = i % 4;
        return i2 == 0 ? (i / 4) * 9 : i2 == 1 ? ((i / 4) * 9) + 2 : i2 == 2 ? ((i / 4) * 9) + 4 : i2 == 3 ? ((i / 4) * 9) + 8 : i2;
    }

    private void a() {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.h = paint;
        paint.setFilterBitmap(true);
        this.h.setDither(true);
        this.h.setAntiAlias(true);
        setLayerType(2, null);
    }

    private void a(android.graphics.Bitmap bitmap) {
        int height = (int) (this.m / (((this.l * b) * bitmap.getHeight()) / bitmap.getWidth()));
        this.k = height;
        this.j = 3;
        this.i = ((height * 3) * 4) / 9;
    }

    private void a(android.graphics.Canvas canvas) {
        com.anythink.basead.ui.animplayerview.redpacket.a next;
        android.graphics.Bitmap c2;
        java.util.Iterator<com.anythink.basead.ui.animplayerview.redpacket.a> it = this.e.iterator();
        while (it.hasNext() && (c2 = (next = it.next()).c()) != null) {
            this.d.setTranslate((-next.b()) >> 1, (-next.a()) >> 1);
            this.d.postRotate(next.e());
            this.d.postTranslate((next.b() >> 1) + next.a, (next.a() >> 1) + next.b);
            canvas.drawBitmap(c2, this.d, this.h);
        }
    }

    private void a(com.anythink.basead.ui.animplayerview.redpacket.a aVar, int i) {
        java.lang.Float f;
        if (aVar.b() <= 0 || aVar.a() <= 0) {
            return;
        }
        int i2 = i % 4;
        if (i2 == 0) {
            i2 = (i / 4) * 9;
        } else if (i2 == 1) {
            i2 = ((i / 4) * 9) + 2;
        } else if (i2 == 2) {
            i2 = ((i / 4) * 9) + 4;
        } else if (i2 == 3) {
            i2 = ((i / 4) * 9) + 8;
        }
        int i3 = this.j;
        int i4 = i2 / i3;
        int i5 = i2 % i3;
        int i6 = this.l / i3;
        int i7 = this.m / this.k;
        int b2 = aVar.b();
        int a2 = aVar.a();
        aVar.a = (i5 * i6) + ((i6 - b2) >> 1);
        int nextInt = new java.util.Random().nextInt(21) - 10;
        int i8 = a2 / 3;
        int nextInt2 = new java.util.Random().nextInt(i8) + i8;
        if (i4 > 0 && (f = this.f.get(java.lang.Integer.valueOf(i2 - this.j))) != null) {
            float floatValue = f.floatValue() + nextInt2 + nextInt;
            aVar.b = floatValue;
            if ((this.m - floatValue) - b() < a2) {
                if (this.g == null) {
                    this.g = new java.util.ArrayList();
                }
                this.g.add(java.lang.Integer.valueOf(i));
            }
        }
        if (aVar.b == 0.0f) {
            aVar.b = (i4 * i7) + nextInt2 + nextInt;
        }
        float f2 = a2;
        if (aVar.b + f2 > this.m) {
            aVar.b = (r3 - a2) - b();
        }
        if (aVar.b < 0.0f) {
            aVar.b = a2 >> 1;
        }
        this.f.put(java.lang.Integer.valueOf(i2), java.lang.Float.valueOf(aVar.b + f2));
    }

    private int b() {
        return com.anythink.core.common.o.i.a(getContext(), 5.0f);
    }

    private com.anythink.basead.ui.animplayerview.redpacket.a b(android.graphics.Bitmap bitmap) {
        return new com.anythink.basead.ui.animplayerview.redpacket.a(getContext(), bitmap, this.l);
    }

    public void initRedPacketList(android.graphics.Bitmap bitmap) {
        java.lang.Float f;
        this.n = bitmap;
        if (this.o) {
            return;
        }
        this.o = true;
        if (bitmap == null) {
            try {
                this.n = android.graphics.BitmapFactory.decodeResource(getResources(), com.anythink.core.common.o.i.a(getContext(), "myoffer_icon_red_packet", com.anythink.expressad.foundation.h.i.c));
            } catch (java.lang.Exception e) {
                new java.lang.StringBuilder("initRedPacketList failed: ").append(e.getMessage());
            }
        }
        if (this.n == null) {
            return;
        }
        int height = (int) (this.m / (((this.l * b) * r12.getHeight()) / r12.getWidth()));
        this.k = height;
        this.j = 3;
        int i = ((height * 3) * 4) / 9;
        this.i = i;
        if (i <= 0 || height <= 0) {
            return;
        }
        this.e.clear();
        for (int i2 = 0; i2 < this.i; i2++) {
            com.anythink.basead.ui.animplayerview.redpacket.a aVar = new com.anythink.basead.ui.animplayerview.redpacket.a(getContext(), this.n, this.l);
            if (aVar.b() > 0 && aVar.a() > 0) {
                int i3 = i2 % 4;
                if (i3 == 0) {
                    i3 = (i2 / 4) * 9;
                } else if (i3 == 1) {
                    i3 = ((i2 / 4) * 9) + 2;
                } else if (i3 == 2) {
                    i3 = ((i2 / 4) * 9) + 4;
                } else if (i3 == 3) {
                    i3 = ((i2 / 4) * 9) + 8;
                }
                int i4 = this.j;
                int i5 = i3 / i4;
                int i6 = i3 % i4;
                int i7 = this.l / i4;
                int i8 = this.m / this.k;
                int b2 = aVar.b();
                int a2 = aVar.a();
                aVar.a = (i6 * i7) + ((i7 - b2) >> 1);
                int nextInt = new java.util.Random().nextInt(21) - 10;
                int nextInt2 = new java.util.Random().nextInt(a2 / 3) + (a2 / 3);
                if (i5 > 0 && (f = this.f.get(java.lang.Integer.valueOf(i3 - this.j))) != null) {
                    float floatValue = f.floatValue() + nextInt2 + nextInt;
                    aVar.b = floatValue;
                    if ((this.m - floatValue) - b() < a2) {
                        if (this.g == null) {
                            this.g = new java.util.ArrayList();
                        }
                        this.g.add(java.lang.Integer.valueOf(i2));
                    }
                }
                if (aVar.b == 0.0f) {
                    aVar.b = (i5 * i8) + nextInt2 + nextInt;
                }
                float f2 = a2;
                if (aVar.b + f2 > this.m) {
                    aVar.b = (r6 - a2) - b();
                }
                if (aVar.b < 0.0f) {
                    aVar.b = a2 >> 1;
                }
                this.f.put(java.lang.Integer.valueOf(i3), java.lang.Float.valueOf(aVar.b + f2));
            }
            this.e.add(aVar);
        }
        java.util.List<java.lang.Integer> list = this.g;
        if (list != null && list.size() > 0) {
            java.util.Iterator<java.lang.Integer> it = this.g.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                if (intValue >= 0 && intValue < this.e.size()) {
                    com.anythink.basead.ui.animplayerview.redpacket.a aVar2 = this.e.get(intValue);
                    if (aVar2 != null) {
                        aVar2.d();
                    }
                    this.e.remove(intValue);
                }
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        com.anythink.basead.ui.animplayerview.redpacket.a next;
        android.graphics.Bitmap c2;
        super.onDraw(canvas);
        java.util.Iterator<com.anythink.basead.ui.animplayerview.redpacket.a> it = this.e.iterator();
        while (it.hasNext() && (c2 = (next = it.next()).c()) != null) {
            this.d.setTranslate((-next.b()) >> 1, (-next.a()) >> 1);
            this.d.postRotate(next.e());
            this.d.postTranslate((next.b() >> 1) + next.a, (next.a() >> 1) + next.b);
            canvas.drawBitmap(c2, this.d, this.h);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.l = getMeasuredWidth();
        this.m = getMeasuredHeight();
    }

    public void release() {
        this.o = false;
        try {
            android.graphics.Bitmap bitmap = this.n;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.n.recycle();
            }
            java.util.Iterator<com.anythink.basead.ui.animplayerview.redpacket.a> it = this.e.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.e.clear();
            java.util.Map<java.lang.Integer, java.lang.Float> map = this.f;
            if (map != null) {
                map.clear();
            }
            java.util.List<java.lang.Integer> list = this.g;
            if (list != null) {
                list.clear();
            }
        } catch (java.lang.Exception e) {
            new java.lang.StringBuilder("release failed: ").append(e.getMessage());
        }
    }
}

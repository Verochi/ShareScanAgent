package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class af {
    private final android.content.Context a;
    private final com.amap.api.mapcore.util.af.a b;
    private boolean c;
    private android.view.MotionEvent d;
    private android.view.MotionEvent e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private long q;
    private final float r;

    /* renamed from: s, reason: collision with root package name */
    private float f119s;
    private float t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z = 0;
    private int A = 0;

    public interface a {
        boolean a(com.amap.api.mapcore.util.af afVar);

        boolean b(com.amap.api.mapcore.util.af afVar);

        void c(com.amap.api.mapcore.util.af afVar);
    }

    public af(android.content.Context context, com.amap.api.mapcore.util.af.a aVar) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.a = context;
        this.b = aVar;
        this.r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float a(android.view.MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    private int a(android.view.MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != findPointerIndex) {
                float f = this.r;
                float f2 = this.f119s;
                float f3 = this.t;
                float a2 = a(motionEvent, i3);
                float b = b(motionEvent, i3);
                if (a2 >= f && b >= f && a2 <= f2 && b <= f3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static float b(android.view.MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void b(android.view.MotionEvent motionEvent) {
        android.view.MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = android.view.MotionEvent.obtain(motionEvent);
        this.l = -1.0f;
        this.m = -1.0f;
        this.n = -1.0f;
        android.view.MotionEvent motionEvent3 = this.d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.x);
        if (findPointerIndex < 0 || findPointerIndex2 < 0 || findPointerIndex3 < 0 || findPointerIndex4 < 0) {
            this.v = true;
            if (this.c) {
                this.b.c(this);
                return;
            }
            return;
        }
        float x = motionEvent3.getX(findPointerIndex);
        float y = motionEvent3.getY(findPointerIndex);
        float x2 = motionEvent3.getX(findPointerIndex2);
        float y2 = motionEvent3.getY(findPointerIndex2);
        float x3 = motionEvent.getX(findPointerIndex3);
        float y3 = motionEvent.getY(findPointerIndex3);
        float x4 = motionEvent.getX(findPointerIndex4) - x3;
        float y4 = motionEvent.getY(findPointerIndex4) - y3;
        this.h = x2 - x;
        this.i = y2 - y;
        this.j = x4;
        this.k = y4;
        this.f = x3 + (x4 * 0.5f);
        this.g = y3 + (y4 * 0.5f);
        this.q = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.o = motionEvent.getPressure(findPointerIndex3) + motionEvent.getPressure(findPointerIndex4);
        this.p = motionEvent3.getPressure(findPointerIndex) + motionEvent3.getPressure(findPointerIndex2);
    }

    private void j() {
        android.view.MotionEvent motionEvent = this.d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.d = null;
        }
        android.view.MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.u = false;
        this.c = false;
        this.w = -1;
        this.x = -1;
        this.v = false;
    }

    private float k() {
        if (this.l == -1.0f) {
            float f = this.j;
            float f2 = this.k;
            this.l = (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
        }
        return this.l;
    }

    private float l() {
        if (this.m == -1.0f) {
            float f = this.h;
            float f2 = this.i;
            this.m = (float) java.lang.Math.sqrt((f * f) + (f2 * f2));
        }
        return this.m;
    }

    public final android.view.MotionEvent a() {
        return this.e;
    }

    public final void a(int i, int i2) {
        this.z = i;
        this.A = i2;
    }

    public final boolean a(android.view.MotionEvent motionEvent) {
        int a2;
        int a3;
        int i;
        int a4;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            j();
        }
        boolean z = false;
        if (this.v) {
            return false;
        }
        if (this.c) {
            if (action == 1) {
                j();
            } else if (action == 2) {
                b(motionEvent);
                if (this.o / this.p > 0.67f && this.b.a(this)) {
                    this.d.recycle();
                    this.d = android.view.MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.b.c(this);
                j();
            } else if (action == 5) {
                this.b.c(this);
                int i2 = this.w;
                int i3 = this.x;
                j();
                this.d = android.view.MotionEvent.obtain(motionEvent);
                if (!this.y) {
                    i2 = i3;
                }
                this.w = i2;
                this.x = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.y = false;
                int findPointerIndex = motionEvent.findPointerIndex(this.w);
                if (findPointerIndex < 0 || this.w == this.x) {
                    int i4 = this.w;
                    int i5 = this.x;
                    this.w = motionEvent.getPointerId(a(motionEvent, i4 != i5 ? i5 : -1, findPointerIndex));
                }
                b(motionEvent);
                this.c = this.b.b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i6 = this.w;
                    if (pointerId == i6) {
                        int a5 = a(motionEvent, this.x, actionIndex);
                        if (a5 >= 0) {
                            this.b.c(this);
                            this.w = motionEvent.getPointerId(a5);
                            this.y = true;
                            this.d = android.view.MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                            this.c = this.b.b(this);
                            this.d.recycle();
                            this.d = android.view.MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        }
                        z = true;
                        this.d.recycle();
                        this.d = android.view.MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    } else {
                        if (pointerId == this.x) {
                            int a6 = a(motionEvent, i6, actionIndex);
                            if (a6 >= 0) {
                                this.b.c(this);
                                this.x = motionEvent.getPointerId(a6);
                                this.y = false;
                                this.d = android.view.MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                this.c = this.b.b(this);
                            }
                            z = true;
                        }
                        this.d.recycle();
                        this.d = android.view.MotionEvent.obtain(motionEvent);
                        b(motionEvent);
                    }
                } else {
                    z = true;
                }
                if (z) {
                    b(motionEvent);
                    int i7 = this.w;
                    if (pointerId == i7) {
                        i7 = this.x;
                    }
                    int findPointerIndex2 = motionEvent.findPointerIndex(i7);
                    this.f = motionEvent.getX(findPointerIndex2);
                    this.g = motionEvent.getY(findPointerIndex2);
                    this.b.c(this);
                    j();
                    this.w = i7;
                    this.y = true;
                }
            }
        } else if (action == 0) {
            this.w = motionEvent.getPointerId(0);
            this.y = true;
        } else if (action == 1) {
            j();
        } else if (action != 2) {
            if (action == 5) {
                int i8 = this.z;
                if (i8 == 0 || (i = this.A) == 0) {
                    float f = this.a.getResources().getDisplayMetrics().widthPixels;
                    float f2 = this.r;
                    this.f119s = f - f2;
                    this.t = r0.heightPixels - f2;
                } else {
                    float f3 = this.r;
                    this.f119s = i8 - f3;
                    this.t = i - f3;
                }
                android.view.MotionEvent motionEvent2 = this.d;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.d = android.view.MotionEvent.obtain(motionEvent);
                this.q = 0L;
                int actionIndex2 = motionEvent.getActionIndex();
                int findPointerIndex3 = motionEvent.findPointerIndex(this.w);
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                this.x = pointerId2;
                if (findPointerIndex3 < 0 || findPointerIndex3 == actionIndex2) {
                    findPointerIndex3 = a(motionEvent, findPointerIndex3 != actionIndex2 ? pointerId2 : -1, findPointerIndex3);
                    this.w = motionEvent.getPointerId(findPointerIndex3);
                }
                this.y = false;
                b(motionEvent);
                float f4 = this.r;
                float f5 = this.f119s;
                float f6 = this.t;
                float a7 = a(motionEvent, findPointerIndex3);
                float b = b(motionEvent, findPointerIndex3);
                float a8 = a(motionEvent, actionIndex2);
                float b2 = b(motionEvent, actionIndex2);
                boolean z2 = a7 < f4 || b < f4 || a7 > f5 || b > f6;
                boolean z3 = a8 < f4 || b2 < f4 || a8 > f5 || b2 > f6;
                if (z2 && z3) {
                    this.f = -1.0f;
                    this.g = -1.0f;
                    this.u = true;
                } else if (z2) {
                    this.f = motionEvent.getX(actionIndex2);
                    this.g = motionEvent.getY(actionIndex2);
                    this.u = true;
                } else if (z3) {
                    this.f = motionEvent.getX(findPointerIndex3);
                    this.g = motionEvent.getY(findPointerIndex3);
                    this.u = true;
                } else {
                    this.u = false;
                    this.c = this.b.b(this);
                }
            } else if (action == 6 && this.u) {
                int pointerCount2 = motionEvent.getPointerCount();
                int actionIndex3 = motionEvent.getActionIndex();
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                if (pointerCount2 > 2) {
                    int i9 = this.w;
                    if (pointerId3 == i9) {
                        int a9 = a(motionEvent, this.x, actionIndex3);
                        if (a9 >= 0) {
                            this.w = motionEvent.getPointerId(a9);
                        }
                    } else if (pointerId3 == this.x && (a4 = a(motionEvent, i9, actionIndex3)) >= 0) {
                        this.x = motionEvent.getPointerId(a4);
                    }
                } else {
                    int i10 = this.w;
                    if (pointerId3 == i10) {
                        i10 = this.x;
                    }
                    int findPointerIndex4 = motionEvent.findPointerIndex(i10);
                    if (findPointerIndex4 < 0) {
                        this.v = true;
                        if (this.c) {
                            this.b.c(this);
                        }
                        return false;
                    }
                    this.w = motionEvent.getPointerId(findPointerIndex4);
                    this.y = true;
                    this.x = -1;
                    this.f = motionEvent.getX(findPointerIndex4);
                    this.g = motionEvent.getY(findPointerIndex4);
                }
            }
        } else if (this.u) {
            float f7 = this.r;
            float f8 = this.f119s;
            float f9 = this.t;
            int findPointerIndex5 = motionEvent.findPointerIndex(this.w);
            int findPointerIndex6 = motionEvent.findPointerIndex(this.x);
            float a10 = a(motionEvent, findPointerIndex5);
            float b3 = b(motionEvent, findPointerIndex5);
            float a11 = a(motionEvent, findPointerIndex6);
            float b4 = b(motionEvent, findPointerIndex6);
            boolean z4 = a10 < f7 || b3 < f7 || a10 > f8 || b3 > f9;
            boolean z5 = a11 < f7 || b4 < f7 || a11 > f8 || b4 > f9;
            if (z4 && (a3 = a(motionEvent, this.x, findPointerIndex5)) >= 0) {
                this.w = motionEvent.getPointerId(a3);
                a(motionEvent, a3);
                b(motionEvent, a3);
                findPointerIndex5 = a3;
                z4 = false;
            }
            if (z5 && (a2 = a(motionEvent, this.w, findPointerIndex6)) >= 0) {
                this.x = motionEvent.getPointerId(a2);
                a(motionEvent, a2);
                b(motionEvent, a2);
                findPointerIndex6 = a2;
                z5 = false;
            }
            if (z4 && z5) {
                this.f = -1.0f;
                this.g = -1.0f;
            } else if (z4) {
                this.f = motionEvent.getX(findPointerIndex6);
                this.g = motionEvent.getY(findPointerIndex6);
            } else if (z5) {
                this.f = motionEvent.getX(findPointerIndex5);
                this.g = motionEvent.getY(findPointerIndex5);
            } else {
                this.u = false;
                this.c = this.b.b(this);
            }
        }
        return true;
    }

    public final float b() {
        return this.f;
    }

    public final float c() {
        return this.g;
    }

    public final float d() {
        return this.j;
    }

    public final float e() {
        return this.k;
    }

    public final float f() {
        return this.h;
    }

    public final float g() {
        return this.i;
    }

    public final float h() {
        if (this.n == -1.0f) {
            this.n = k() / l();
        }
        return this.n;
    }

    public final long i() {
        return this.q;
    }
}

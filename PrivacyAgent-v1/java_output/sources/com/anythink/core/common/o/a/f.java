package com.anythink.core.common.o.a;

/* loaded from: classes12.dex */
public class f {
    private static java.lang.String c = "f";
    final int a;
    final android.view.ViewTreeObserver.OnPreDrawListener b;
    private int d;
    private final java.util.ArrayList<android.view.View> e;
    private long f;
    private final java.util.Map<android.view.View, com.anythink.core.common.o.a.f.a> g;
    private final com.anythink.core.common.o.a.f.b h;
    private com.anythink.core.common.o.a.f.d i;
    private final com.anythink.core.common.o.a.f.c j;
    private final android.os.Handler k;
    private boolean l;

    /* renamed from: com.anythink.core.common.o.a.f$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            com.anythink.core.common.o.a.f.this.c();
            return true;
        }
    }

    public static class a {
        int a;
        int b;
        long c;
        android.view.View d;
        java.lang.Integer e;
    }

    public static class b {
        private final android.graphics.Rect a = new android.graphics.Rect();

        private static boolean a(long j, int i) {
            return android.os.SystemClock.uptimeMillis() - j >= ((long) i);
        }

        public final boolean a(android.view.View view, android.view.View view2, int i, java.lang.Integer num) {
            if (view2 != null && view != null) {
                try {
                    if (view.getParent() == null || view2.getWindowVisibility() != 0 || !view2.isShown() || !view2.getGlobalVisibleRect(this.a)) {
                        return false;
                    }
                    long height = this.a.height() * this.a.width();
                    long height2 = view2.getHeight() * view2.getWidth();
                    if (height2 <= 0) {
                        return false;
                    }
                    return (num == null || num.intValue() <= 0) ? height * 100 >= ((long) i) * height2 : height >= ((long) num.intValue());
                } catch (java.lang.Throwable th) {
                    java.lang.String unused = com.anythink.core.common.o.a.f.c;
                    new java.lang.StringBuilder("checkVisibilityPercent error: ").append(th.getMessage());
                    th.printStackTrace();
                }
            }
            return false;
        }
    }

    public class c implements java.lang.Runnable {
        private final java.util.ArrayList<android.view.View> c = new java.util.ArrayList<>();
        private final java.util.ArrayList<android.view.View> b = new java.util.ArrayList<>();

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (java.util.Map.Entry entry : com.anythink.core.common.o.a.f.this.g.entrySet()) {
                android.view.View view = (android.view.View) entry.getKey();
                int i = ((com.anythink.core.common.o.a.f.a) entry.getValue()).a;
                int i2 = ((com.anythink.core.common.o.a.f.a) entry.getValue()).b;
                java.lang.Integer num = ((com.anythink.core.common.o.a.f.a) entry.getValue()).e;
                android.view.View view2 = ((com.anythink.core.common.o.a.f.a) entry.getValue()).d;
                if (com.anythink.core.common.o.a.f.this.h.a(view2, view, i, num)) {
                    this.b.add(view);
                    try {
                        view.getViewTreeObserver().removeOnPreDrawListener(com.anythink.core.common.o.a.f.this.b);
                    } catch (java.lang.Throwable unused) {
                    }
                } else if (!com.anythink.core.common.o.a.f.this.h.a(view2, view, i2, null)) {
                    this.c.add(view);
                }
            }
            if (com.anythink.core.common.o.a.f.this.i != null) {
                com.anythink.core.common.o.a.f.this.i.a(this.b);
            }
            this.b.clear();
            this.c.clear();
            com.anythink.core.common.o.a.f.d(com.anythink.core.common.o.a.f.this);
        }
    }

    public interface d {
        void a(java.util.List<android.view.View> list);
    }

    public f() {
        this(new java.util.WeakHashMap(10), new com.anythink.core.common.o.a.f.b(), new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public f(int i) {
        this(new java.util.WeakHashMap(10), new com.anythink.core.common.o.a.f.b(), new android.os.Handler(android.os.Looper.getMainLooper()));
        this.d = i;
    }

    private f(java.util.Map<android.view.View, com.anythink.core.common.o.a.f.a> map, com.anythink.core.common.o.a.f.b bVar, android.os.Handler handler) {
        this.d = 100;
        this.a = 50;
        this.f = 0L;
        this.g = map;
        this.h = bVar;
        this.k = handler;
        this.j = new com.anythink.core.common.o.a.f.c();
        this.e = new java.util.ArrayList<>(50);
        this.b = new com.anythink.core.common.o.a.f.AnonymousClass1();
    }

    private void a(long j) {
        for (java.util.Map.Entry<android.view.View, com.anythink.core.common.o.a.f.a> entry : this.g.entrySet()) {
            if (entry.getValue().c < j) {
                this.e.add(entry.getKey());
            }
        }
        java.util.Iterator<android.view.View> it = this.e.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.e.clear();
    }

    private void a(android.view.View view, int i, java.lang.Integer num) {
        a(view, view, i, i, num);
    }

    private void a(android.view.View view, android.view.View view2, int i, java.lang.Integer num) {
        a(view, view2, i, i, num);
    }

    private static boolean a(android.content.Context context, android.view.View view) {
        android.view.View rootView;
        android.view.View view2 = null;
        android.view.View findViewById = !(context instanceof android.app.Activity) ? null : ((android.app.Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        if (view != null && (rootView = view.getRootView()) != null && (view2 = rootView.findViewById(android.R.id.content)) == null) {
            view2 = rootView;
        }
        if (findViewById == null) {
            findViewById = view2;
        }
        return findViewById != null && findViewById.getViewTreeObserver().isAlive();
    }

    public static /* synthetic */ boolean d(com.anythink.core.common.o.a.f fVar) {
        fVar.l = false;
        return false;
    }

    public final void a() {
        this.g.clear();
        this.k.removeMessages(0);
        this.l = false;
    }

    public final void a(android.view.View view) {
        this.g.remove(view);
    }

    public final void a(android.view.View view, android.view.View view2, int i, int i2, java.lang.Integer num) {
        try {
            if (a(view2.getContext(), view2)) {
                com.anythink.core.common.o.a.f.a aVar = this.g.get(view2);
                if (aVar == null) {
                    aVar = new com.anythink.core.common.o.a.f.a();
                    this.g.put(view2, aVar);
                    c();
                }
                int min = java.lang.Math.min(i2, i);
                aVar.d = view;
                aVar.a = i;
                aVar.b = min;
                aVar.c = this.f;
                aVar.e = num;
                view2.getViewTreeObserver().addOnPreDrawListener(this.b);
                long j = this.f + 1;
                this.f = j;
                if (j % 50 == 0) {
                    a(j - 50);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.anythink.core.common.o.a.f.d dVar) {
        this.i = dVar;
    }

    public final void b() {
        a();
        this.i = null;
    }

    public final void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.postDelayed(this.j, this.d);
    }
}

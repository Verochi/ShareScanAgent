package com.anythink.network.baidu.impression;

/* loaded from: classes12.dex */
final class b {
    static final int a = 50;
    private static int d = 1000;
    final android.view.ViewTreeObserver.OnPreDrawListener b;
    java.lang.ref.WeakReference<android.view.ViewTreeObserver> c;
    private final java.util.ArrayList<android.view.View> e;
    private long f;
    private final java.util.Map<android.view.View, com.anythink.network.baidu.impression.b.a> g;
    private final com.anythink.network.baidu.impression.b.C0236b h;
    private com.anythink.network.baidu.impression.b.d i;
    private final com.anythink.network.baidu.impression.b.c j;
    private final android.os.Handler k;
    private boolean l;

    /* renamed from: com.anythink.network.baidu.impression.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnPreDrawListener {
        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            com.anythink.network.baidu.impression.b.this.c();
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

    /* renamed from: com.anythink.network.baidu.impression.b$b, reason: collision with other inner class name */
    public static class C0236b {
        private final android.graphics.Rect a = new android.graphics.Rect();

        private static boolean a(long j, int i) {
            return android.os.SystemClock.uptimeMillis() - j >= ((long) i);
        }

        public final boolean a(android.view.View view, android.view.View view2, int i, java.lang.Integer num) {
            if (view2 == null || view2.getVisibility() != 0 || view.getParent() == null || view2.getWindowVisibility() != 0 || !view2.getGlobalVisibleRect(this.a)) {
                return false;
            }
            long height = this.a.height() * this.a.width();
            long height2 = view2.getHeight() * view2.getWidth();
            if (height2 <= 0) {
                return false;
            }
            return (num == null || num.intValue() <= 0) ? height * 100 >= ((long) i) * height2 : height >= ((long) num.intValue());
        }
    }

    public class c implements java.lang.Runnable {
        private final java.util.ArrayList<android.view.View> c = new java.util.ArrayList<>();
        private final java.util.ArrayList<android.view.View> b = new java.util.ArrayList<>();

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.network.baidu.impression.b.a(com.anythink.network.baidu.impression.b.this);
            for (java.util.Map.Entry entry : com.anythink.network.baidu.impression.b.this.g.entrySet()) {
                android.view.View view = (android.view.View) entry.getKey();
                int i = ((com.anythink.network.baidu.impression.b.a) entry.getValue()).a;
                int i2 = ((com.anythink.network.baidu.impression.b.a) entry.getValue()).b;
                java.lang.Integer num = ((com.anythink.network.baidu.impression.b.a) entry.getValue()).e;
                android.view.View view2 = ((com.anythink.network.baidu.impression.b.a) entry.getValue()).d;
                if (com.anythink.network.baidu.impression.b.this.h.a(view2, view, i, num)) {
                    this.b.add(view);
                } else if (!com.anythink.network.baidu.impression.b.this.h.a(view2, view, i2, null)) {
                    this.c.add(view);
                }
            }
            if (com.anythink.network.baidu.impression.b.this.i != null) {
                com.anythink.network.baidu.impression.b.this.i.onVisibilityChanged(this.b, this.c);
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public interface d {
        void onVisibilityChanged(java.util.List<android.view.View> list, java.util.List<android.view.View> list2);
    }

    public b(android.content.Context context) {
        this(context, new java.util.WeakHashMap(10), new com.anythink.network.baidu.impression.b.C0236b(), new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public b(android.content.Context context, int i) {
        this(context, new java.util.WeakHashMap(10), new com.anythink.network.baidu.impression.b.C0236b(), new android.os.Handler(android.os.Looper.getMainLooper()));
        d = i;
    }

    private b(android.content.Context context, java.util.Map<android.view.View, com.anythink.network.baidu.impression.b.a> map, com.anythink.network.baidu.impression.b.C0236b c0236b, android.os.Handler handler) {
        this.f = 0L;
        this.g = map;
        this.h = c0236b;
        this.k = handler;
        this.j = new com.anythink.network.baidu.impression.b.c();
        this.e = new java.util.ArrayList<>(50);
        this.b = new com.anythink.network.baidu.impression.b.AnonymousClass1();
        this.c = new java.lang.ref.WeakReference<>(null);
        a(context, null);
    }

    private void a(long j) {
        for (java.util.Map.Entry<android.view.View, com.anythink.network.baidu.impression.b.a> entry : this.g.entrySet()) {
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

    private void a(android.content.Context context, android.view.View view) {
        android.view.View topmostView;
        android.view.ViewTreeObserver viewTreeObserver = this.c.get();
        if ((viewTreeObserver == null || !viewTreeObserver.isAlive()) && (topmostView = com.anythink.network.baidu.impression.BDViews.getTopmostView(context, view)) != null) {
            android.view.ViewTreeObserver viewTreeObserver2 = topmostView.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                this.c = new java.lang.ref.WeakReference<>(viewTreeObserver2);
                viewTreeObserver2.addOnPreDrawListener(this.b);
            }
        }
    }

    private void a(android.view.View view, int i, java.lang.Integer num) {
        a(view, view, i, i, num);
    }

    private void a(android.view.View view, android.view.View view2, int i, java.lang.Integer num) {
        a(view, view2, i, i, num);
    }

    public static /* synthetic */ boolean a(com.anythink.network.baidu.impression.b bVar) {
        bVar.l = false;
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
            a(view2.getContext(), view2);
            com.anythink.network.baidu.impression.b.a aVar = this.g.get(view2);
            if (aVar == null) {
                aVar = new com.anythink.network.baidu.impression.b.a();
                this.g.put(view2, aVar);
                c();
            }
            int min = java.lang.Math.min(i2, i);
            aVar.d = view;
            aVar.a = i;
            aVar.b = min;
            long j = this.f;
            aVar.c = j;
            aVar.e = num;
            long j2 = j + 1;
            this.f = j2;
            if (j2 % 50 == 0) {
                a(j2 - 50);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.anythink.network.baidu.impression.b.d dVar) {
        this.i = dVar;
    }

    public final void b() {
        a();
        android.view.ViewTreeObserver viewTreeObserver = this.c.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.b);
        }
        this.c.clear();
        this.i = null;
    }

    public final void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.k.postDelayed(this.j, d);
    }
}

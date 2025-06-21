package com.anythink.network.baidu.impression;

/* loaded from: classes12.dex */
public class BDImpressionTracker {
    private static final int a = 100;
    private final com.anythink.network.baidu.impression.b b;
    private final java.util.Map<android.view.View, com.anythink.network.baidu.impression.BDImpressionInterface> c;
    private final java.util.Map<android.view.View, com.anythink.network.baidu.impression.a<com.anythink.network.baidu.impression.BDImpressionInterface>> d;
    private final android.os.Handler e;
    private final com.anythink.network.baidu.impression.BDImpressionTracker.a f;
    private final com.anythink.network.baidu.impression.b.C0236b g;
    private com.anythink.network.baidu.impression.b.d h;

    /* renamed from: com.anythink.network.baidu.impression.BDImpressionTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.network.baidu.impression.b.d {
        public AnonymousClass1() {
        }

        @Override // com.anythink.network.baidu.impression.b.d
        public final void onVisibilityChanged(java.util.List<android.view.View> list, java.util.List<android.view.View> list2) {
            for (android.view.View view : list) {
                com.anythink.network.baidu.impression.BDImpressionInterface bDImpressionInterface = (com.anythink.network.baidu.impression.BDImpressionInterface) com.anythink.network.baidu.impression.BDImpressionTracker.this.c.get(view);
                if (bDImpressionInterface == null) {
                    com.anythink.network.baidu.impression.BDImpressionTracker.this.removeView(view);
                } else {
                    com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) com.anythink.network.baidu.impression.BDImpressionTracker.this.d.get(view);
                    if (aVar == null || !bDImpressionInterface.equals(aVar.a)) {
                        com.anythink.network.baidu.impression.BDImpressionTracker.this.d.put(view, new com.anythink.network.baidu.impression.a(bDImpressionInterface));
                    }
                }
            }
            java.util.Iterator<android.view.View> it = list2.iterator();
            while (it.hasNext()) {
                com.anythink.network.baidu.impression.BDImpressionTracker.this.d.remove(it.next());
            }
            com.anythink.network.baidu.impression.BDImpressionTracker.this.a();
        }
    }

    public class a implements java.lang.Runnable {
        private final java.util.ArrayList<android.view.View> b = new java.util.ArrayList<>();

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            for (java.util.Map.Entry entry : com.anythink.network.baidu.impression.BDImpressionTracker.this.d.entrySet()) {
                android.view.View view = (android.view.View) entry.getKey();
                com.anythink.network.baidu.impression.a aVar = (com.anythink.network.baidu.impression.a) entry.getValue();
                com.anythink.network.baidu.impression.b.C0236b unused = com.anythink.network.baidu.impression.BDImpressionTracker.this.g;
                if (android.os.SystemClock.uptimeMillis() - aVar.b >= ((long) ((com.anythink.network.baidu.impression.BDImpressionInterface) aVar.a).getImpressionMinTimeViewed())) {
                    ((com.anythink.network.baidu.impression.BDImpressionInterface) aVar.a).recordImpression(view);
                    ((com.anythink.network.baidu.impression.BDImpressionInterface) aVar.a).setImpressionRecorded();
                    this.b.add(view);
                }
            }
            java.util.Iterator<android.view.View> it = this.b.iterator();
            while (it.hasNext()) {
                com.anythink.network.baidu.impression.BDImpressionTracker.this.removeView(it.next());
            }
            this.b.clear();
            if (com.anythink.network.baidu.impression.BDImpressionTracker.this.d.isEmpty()) {
                return;
            }
            com.anythink.network.baidu.impression.BDImpressionTracker.this.a();
        }
    }

    public BDImpressionTracker(android.content.Context context) {
        this(new java.util.WeakHashMap(), new java.util.WeakHashMap(), new com.anythink.network.baidu.impression.b.C0236b(), new com.anythink.network.baidu.impression.b(context), new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    public BDImpressionTracker(android.content.Context context, int i) {
        this(new java.util.WeakHashMap(), new java.util.WeakHashMap(), new com.anythink.network.baidu.impression.b.C0236b(), new com.anythink.network.baidu.impression.b(context, i), new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    private BDImpressionTracker(java.util.Map<android.view.View, com.anythink.network.baidu.impression.BDImpressionInterface> map, java.util.Map<android.view.View, com.anythink.network.baidu.impression.a<com.anythink.network.baidu.impression.BDImpressionInterface>> map2, com.anythink.network.baidu.impression.b.C0236b c0236b, com.anythink.network.baidu.impression.b bVar, android.os.Handler handler) {
        this.c = map;
        this.d = map2;
        this.g = c0236b;
        this.b = bVar;
        com.anythink.network.baidu.impression.BDImpressionTracker.AnonymousClass1 anonymousClass1 = new com.anythink.network.baidu.impression.BDImpressionTracker.AnonymousClass1();
        this.h = anonymousClass1;
        bVar.a(anonymousClass1);
        this.e = handler;
        this.f = new com.anythink.network.baidu.impression.BDImpressionTracker.a();
    }

    private void a(android.view.View view) {
        this.d.remove(view);
    }

    @java.lang.Deprecated
    private com.anythink.network.baidu.impression.b.d b() {
        return this.h;
    }

    public final void a() {
        if (this.e.hasMessages(0)) {
            return;
        }
        this.e.postDelayed(this.f, 100L);
    }

    public void addView(android.view.View view, com.anythink.network.baidu.impression.BDImpressionInterface bDImpressionInterface) {
        if (this.c.get(view) == bDImpressionInterface) {
            return;
        }
        removeView(view);
        if (bDImpressionInterface.isImpressionRecorded()) {
            return;
        }
        this.c.put(view, bDImpressionInterface);
        com.anythink.network.baidu.impression.b bVar = this.b;
        int impressionMinPercentageViewed = bDImpressionInterface.getImpressionMinPercentageViewed();
        bVar.a(view, view, impressionMinPercentageViewed, impressionMinPercentageViewed, bDImpressionInterface.getImpressionMinVisiblePx());
    }

    public void clear() {
        this.c.clear();
        this.d.clear();
        this.b.a();
        this.e.removeMessages(0);
    }

    public void destroy() {
        clear();
        this.b.b();
        this.h = null;
    }

    public void removeView(android.view.View view) {
        this.c.remove(view);
        this.d.remove(view);
        this.b.a(view);
    }
}

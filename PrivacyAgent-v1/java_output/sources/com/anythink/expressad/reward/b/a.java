package com.anythink.expressad.reward.b;

/* loaded from: classes12.dex */
public class a implements com.anythink.core.common.a.h {
    private static final int A = 9;
    private static final int E = 16;
    private static final int F = 18;
    private static final int G = 17;
    private static final int H = 1001001;
    private static final int I = 1001002;
    public static final int a = 1;
    public static java.lang.String b = null;
    private static final java.lang.String i = "RewardVideoController";
    private static final int j = 8;
    private static final int z = 8;
    private int B;
    private int C;
    private int D;
    private boolean N;
    private java.util.Queue<java.lang.Integer> V;
    private java.lang.String W;
    private java.util.List<com.anythink.expressad.foundation.d.c> af;
    private java.util.List<com.anythink.expressad.foundation.d.c> ag;
    private android.content.Context k;
    private int l;
    private com.anythink.expressad.reward.a.d m;
    private com.anythink.expressad.videocommon.e.d n;
    private com.anythink.expressad.videocommon.e.a o;
    private volatile com.anythink.expressad.videocommon.d.a p;
    private volatile com.anythink.expressad.reward.b.a.c q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f256s;
    private volatile java.lang.String t;
    private java.lang.String u;
    private java.lang.String v;
    private static java.util.Map<java.lang.String, java.lang.Integer> T = new java.util.HashMap();
    public static java.util.Map<java.lang.String, com.anythink.expressad.reward.b.a.d> c = new java.util.HashMap();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> U = new java.util.concurrent.ConcurrentHashMap<>();
    private int w = 0;
    private int y = 2;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private boolean O = false;
    private java.util.ArrayList<java.lang.Integer> P = new java.util.ArrayList<>(7);
    private boolean Q = false;
    private volatile boolean R = false;
    private final java.lang.Object S = new java.lang.Object();
    private com.anythink.expressad.foundation.c.c X = null;
    private volatile boolean Y = true;
    private volatile boolean Z = false;
    private volatile boolean aa = false;
    private volatile boolean ab = false;
    private volatile boolean ac = false;
    private volatile boolean ad = false;
    private volatile boolean ae = false;
    volatile boolean d = false;
    volatile boolean e = false;
    volatile boolean f = false;
    volatile boolean g = false;
    volatile boolean h = false;
    private android.os.Handler x = new com.anythink.expressad.reward.b.a.AnonymousClass1(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.reward.b.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 8) {
                if (com.anythink.expressad.reward.b.a.this.af == null || com.anythink.expressad.reward.b.a.this.af.size() <= 0) {
                    return;
                }
                boolean z = (com.anythink.expressad.reward.b.a.this.ag == null || com.anythink.expressad.reward.b.a.this.ag.size() <= 0) ? false : !android.text.TextUtils.isEmpty(((com.anythink.expressad.foundation.d.c) com.anythink.expressad.reward.b.a.this.ag.get(0)).ar());
                int ap = ((com.anythink.expressad.foundation.d.c) com.anythink.expressad.reward.b.a.this.af.get(0)).ap();
                if (com.anythink.expressad.reward.b.a.this.m != null && com.anythink.expressad.reward.b.a.this.m.a(com.anythink.expressad.reward.b.a.this.af, z, ap)) {
                    if (com.anythink.expressad.reward.b.a.this.q == null || !com.anythink.expressad.reward.b.a.this.N) {
                        return;
                    }
                    com.anythink.expressad.reward.b.a.c.a(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
                    return;
                }
                if (com.anythink.expressad.reward.b.a.this.q == null || !com.anythink.expressad.reward.b.a.this.N) {
                    return;
                }
                com.anythink.expressad.videocommon.a.c(com.anythink.expressad.reward.b.a.this.f256s);
                com.anythink.expressad.videocommon.a.b();
                com.anythink.expressad.reward.b.a.c.a(com.anythink.expressad.reward.b.a.this.q, "load timeout");
                return;
            }
            if (i == 9) {
                if (com.anythink.expressad.reward.b.a.this.p == null || !com.anythink.expressad.reward.b.a.this.N) {
                    return;
                }
                android.os.Bundle data = message.getData();
                if (data != null && data.containsKey(com.anythink.expressad.a.y)) {
                    android.text.TextUtils.isEmpty(data.getString(com.anythink.expressad.a.y));
                }
                try {
                    if (com.anythink.expressad.reward.b.a.this.K) {
                        com.anythink.expressad.reward.b.a.b();
                    }
                    com.anythink.expressad.reward.b.a.this.p.b();
                    return;
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            if (i != com.anythink.expressad.reward.b.a.I) {
                switch (i) {
                    case 16:
                    case 18:
                        if (com.anythink.expressad.reward.b.a.this.p != null && com.anythink.expressad.reward.b.a.this.N) {
                            java.lang.Object obj = message.obj;
                            java.lang.String obj2 = obj instanceof java.lang.String ? obj.toString() : "";
                            com.anythink.expressad.videocommon.a.c(com.anythink.expressad.reward.b.a.this.f256s);
                            com.anythink.expressad.videocommon.a.b();
                            try {
                                if (com.anythink.expressad.reward.b.a.this.K) {
                                    com.anythink.expressad.reward.b.a.b();
                                }
                                com.anythink.expressad.reward.b.a.this.p.a(obj2);
                                break;
                            } catch (java.lang.Exception e2) {
                                if (com.anythink.expressad.a.a) {
                                    e2.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        break;
                    case 17:
                        if (com.anythink.expressad.reward.b.a.this.p != null && com.anythink.expressad.reward.b.a.this.N) {
                            android.os.Bundle data2 = message.getData();
                            if (data2 != null && data2.containsKey(com.anythink.expressad.a.y)) {
                                android.text.TextUtils.isEmpty(data2.getString(com.anythink.expressad.a.y));
                            }
                            try {
                                if (com.anythink.expressad.reward.b.a.this.K) {
                                    com.anythink.expressad.reward.b.a.b();
                                }
                                com.anythink.expressad.videocommon.d.a unused = com.anythink.expressad.reward.b.a.this.p;
                                break;
                            } catch (java.lang.Exception e3) {
                                if (com.anythink.expressad.a.a) {
                                    e3.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        break;
                }
                return;
            }
            if (com.anythink.expressad.reward.b.a.this.n != null) {
                com.anythink.expressad.reward.b.a.this.n.S();
            }
            if (com.anythink.expressad.reward.b.a.this.m == null) {
                com.anythink.expressad.reward.b.a.c unused2 = com.anythink.expressad.reward.b.a.this.q;
                return;
            }
            if (com.anythink.expressad.reward.b.a.this.m.c()) {
                if (com.anythink.expressad.reward.b.a.this.q != null) {
                    try {
                        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f = com.anythink.expressad.reward.b.a.this.m.f();
                        if (f != null) {
                            f.size();
                        }
                    } catch (java.lang.Throwable th) {
                        th.getMessage();
                    }
                    com.anythink.expressad.reward.b.a.c.b(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
                    return;
                }
                return;
            }
            if (!com.anythink.expressad.reward.b.a.this.m.f(false)) {
                if (!com.anythink.expressad.reward.b.a.this.m.f(true)) {
                    com.anythink.expressad.reward.b.a.c unused3 = com.anythink.expressad.reward.b.a.this.q;
                    return;
                }
                if (!com.anythink.expressad.reward.b.a.this.m.c()) {
                    com.anythink.expressad.reward.b.a.c unused4 = com.anythink.expressad.reward.b.a.this.q;
                    com.anythink.expressad.reward.b.a.this.m.e(true);
                    return;
                } else {
                    if (com.anythink.expressad.reward.b.a.this.q != null) {
                        com.anythink.expressad.reward.b.a.this.m.d(true);
                        try {
                            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f2 = com.anythink.expressad.reward.b.a.this.m.f();
                            if (f2 != null) {
                                f2.size();
                            }
                        } catch (java.lang.Throwable th2) {
                            th2.getMessage();
                        }
                        com.anythink.expressad.reward.b.a.c.b(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
                        return;
                    }
                    return;
                }
            }
            if (com.anythink.expressad.reward.b.a.this.m.c()) {
                if (com.anythink.expressad.reward.b.a.this.q != null) {
                    com.anythink.expressad.reward.b.a.this.m.d(false);
                    try {
                        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f3 = com.anythink.expressad.reward.b.a.this.m.f();
                        if (f3 != null) {
                            f3.size();
                        }
                    } catch (java.lang.Throwable th3) {
                        th3.getMessage();
                    }
                    com.anythink.expressad.reward.b.a.c.b(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
                    return;
                }
                return;
            }
            com.anythink.expressad.reward.b.a.this.m.e(false);
            if (!com.anythink.expressad.reward.b.a.this.m.f(true)) {
                com.anythink.expressad.reward.b.a.c unused5 = com.anythink.expressad.reward.b.a.this.q;
                return;
            }
            if (!com.anythink.expressad.reward.b.a.this.m.c()) {
                com.anythink.expressad.reward.b.a.c unused6 = com.anythink.expressad.reward.b.a.this.q;
                com.anythink.expressad.reward.b.a.this.m.e(true);
            } else if (com.anythink.expressad.reward.b.a.this.q != null) {
                com.anythink.expressad.reward.b.a.this.m.d(true);
                try {
                    java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f4 = com.anythink.expressad.reward.b.a.this.m.f();
                    if (f4 != null) {
                        f4.size();
                    }
                } catch (java.lang.Throwable th4) {
                    th4.getMessage();
                }
                com.anythink.expressad.reward.b.a.c.b(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.b.a$a, reason: collision with other inner class name */
    public class RunnableC0221a implements java.lang.Runnable {
        private com.anythink.expressad.reward.a.a b;
        private int c = 1;
        private boolean d = true;

        public RunnableC0221a(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.reward.b.a.this.b("v3 is timeout");
        }
    }

    public class b implements com.anythink.expressad.reward.a.b {
        private com.anythink.expressad.reward.a.a b;
        private boolean c = true;
        private java.lang.Runnable d;

        public b(com.anythink.expressad.reward.a.a aVar) {
            this.b = aVar;
        }

        private java.lang.Runnable c() {
            return this.d;
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a() {
            if (this.d != null) {
                com.anythink.expressad.reward.b.a.this.x.removeCallbacks(this.d);
            }
            if (com.anythink.expressad.reward.b.a.this.q != null) {
                com.anythink.expressad.reward.b.a.c.a(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
            }
        }

        public final void a(java.lang.Runnable runnable) {
            this.d = runnable;
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void a(java.lang.String str) {
            if (this.d != null) {
                com.anythink.expressad.reward.b.a.this.x.removeCallbacks(this.d);
            }
            com.anythink.expressad.reward.a.a aVar = this.b;
            if (aVar != null) {
                aVar.a(null);
                this.b = null;
            }
            if (com.anythink.expressad.reward.b.a.this.q != null) {
                com.anythink.expressad.reward.b.a.c.a(com.anythink.expressad.reward.b.a.this.q, str);
            }
        }

        @Override // com.anythink.expressad.reward.a.b
        public final void b() {
            if (this.d != null) {
                com.anythink.expressad.reward.b.a.this.x.removeCallbacks(this.d);
            }
            if (com.anythink.expressad.reward.b.a.this.q != null) {
                com.anythink.expressad.reward.b.a.c.c(com.anythink.expressad.reward.b.a.this.q, com.anythink.expressad.reward.b.a.this.t, com.anythink.expressad.reward.b.a.this.f256s);
            }
        }
    }

    public final class c {
        private static final java.lang.String b = "RewardVideoController_Listener";
        private static final int d = 0;
        private static final int e = 1;
        private static final int f = 2;
        private static final int g = 3;
        private java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> c;
        private volatile java.util.concurrent.atomic.AtomicInteger h;
        private android.os.Handler i;
        private java.lang.String j;
        private java.util.List<com.anythink.expressad.foundation.d.c> k;
        private boolean l;

        private c(com.anythink.expressad.videocommon.d.a aVar, android.os.Handler handler, java.lang.String str) {
            this.c = new java.lang.ref.WeakReference<>(aVar);
            this.h = new java.util.concurrent.atomic.AtomicInteger(0);
            this.i = handler;
            this.j = str;
        }

        public /* synthetic */ c(com.anythink.expressad.reward.b.a aVar, com.anythink.expressad.videocommon.d.a aVar2, android.os.Handler handler, java.lang.String str, byte b2) {
            this(aVar2, handler, str);
        }

        private int a() {
            return this.h.get();
        }

        public static /* synthetic */ int a(com.anythink.expressad.reward.b.a.c cVar) {
            return cVar.h.get();
        }

        private void a(int i) {
            this.h.set(i);
        }

        private void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.videocommon.d.a aVar;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.a(cVar);
        }

        public static /* synthetic */ void a(com.anythink.expressad.reward.b.a.c cVar, java.lang.String str) {
            android.os.Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            cVar.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ac;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                com.anythink.expressad.reward.b.a.s(com.anythink.expressad.reward.b.a.this);
                if (!com.anythink.expressad.reward.b.a.this.ae || str.contains("resource load timeout")) {
                    com.anythink.expressad.reward.b.a.u(com.anythink.expressad.reward.b.a.this);
                }
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    cVar.h.set(2);
                }
                if (!com.anythink.expressad.reward.b.a.this.ac || !com.anythink.expressad.reward.b.a.this.ad || com.anythink.expressad.reward.b.a.this.ab) {
                    cVar.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ac;
                    return;
                }
                cVar.h.set(2);
                cVar.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ac;
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                cVar.i.sendMessage(obtain);
            }
        }

        public static /* synthetic */ void a(com.anythink.expressad.reward.b.a.c cVar, java.lang.String str, java.lang.String str2) {
            android.os.Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            cVar.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ab;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                cVar.h.set(2);
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    cVar.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ab;
                    return;
                }
                cVar.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ab;
                com.anythink.expressad.reward.b.a.q(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                cVar.i.sendMessage(obtain);
            }
        }

        private void a(java.lang.String str) {
            android.os.Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ac;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                com.anythink.expressad.reward.b.a.s(com.anythink.expressad.reward.b.a.this);
                if (!com.anythink.expressad.reward.b.a.this.ae || str.contains("resource load timeout")) {
                    com.anythink.expressad.reward.b.a.u(com.anythink.expressad.reward.b.a.this);
                }
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    this.h.set(2);
                }
                if (!com.anythink.expressad.reward.b.a.this.ac || !com.anythink.expressad.reward.b.a.this.ad || com.anythink.expressad.reward.b.a.this.ab) {
                    this.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ac;
                    return;
                }
                this.h.set(2);
                this.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ac;
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                this.i.sendMessage(obtain);
            }
        }

        private void a(java.lang.String str, java.lang.String str2) {
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.aa;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                if (com.anythink.expressad.reward.b.a.this.aa) {
                    this.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.aa;
                    return;
                }
                this.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.aa;
                com.anythink.expressad.reward.b.a.o(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                this.i.sendMessage(obtain);
            }
        }

        private void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
            this.k = list;
        }

        private void a(boolean z) {
            this.l = z;
        }

        private void a(boolean z, java.lang.String str, float f2) {
            com.anythink.expressad.videocommon.d.a aVar;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            if (com.anythink.expressad.reward.b.a.this.K) {
                com.anythink.expressad.reward.b.a.b();
                com.anythink.expressad.reward.b.a.this.a();
            }
            aVar.a(z, str, f2);
        }

        private void b() {
            com.anythink.expressad.videocommon.d.a aVar;
            com.anythink.expressad.reward.b.a.l(com.anythink.expressad.reward.b.a.this);
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.c();
        }

        public static /* synthetic */ void b(com.anythink.expressad.reward.b.a.c cVar) {
            cVar.h.set(1);
        }

        public static /* synthetic */ void b(com.anythink.expressad.reward.b.a.c cVar, java.lang.String str) {
            cVar.h.set(2);
            if (cVar.i != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                cVar.i.sendMessage(obtain);
            }
        }

        public static /* synthetic */ void b(com.anythink.expressad.reward.b.a.c cVar, java.lang.String str, java.lang.String str2) {
            android.os.Handler handler = cVar.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            cVar.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ab;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                if (cVar.h.get() == 1) {
                    cVar.h.set(3);
                }
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    cVar.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ab;
                    return;
                }
                cVar.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ab;
                com.anythink.expressad.reward.b.a.q(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                cVar.i.sendMessage(obtain);
                if (com.anythink.expressad.reward.b.a.this.ac) {
                    cVar.h.set(2);
                }
            }
        }

        private void b(java.lang.String str) {
            this.h.set(2);
            if (this.i != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                this.i.sendMessage(obtain);
            }
        }

        private void b(java.lang.String str, java.lang.String str2) {
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.aa;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null || this.i == null) {
                return;
            }
            if (com.anythink.expressad.reward.b.a.this.aa) {
                this.h.get();
                boolean unused2 = com.anythink.expressad.reward.b.a.this.aa;
                return;
            }
            this.h.get();
            boolean unused3 = com.anythink.expressad.reward.b.a.this.aa;
            com.anythink.expressad.reward.b.a.o(com.anythink.expressad.reward.b.a.this);
            android.os.Message obtain = android.os.Message.obtain();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.anythink.expressad.a.y, str);
            bundle.putString("unit_id", str2);
            obtain.setData(bundle);
            obtain.obj = str2;
            obtain.what = 17;
            this.i.sendMessage(obtain);
        }

        private void c() {
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference != null) {
                weakReference.get();
            }
        }

        public static /* synthetic */ void c(com.anythink.expressad.reward.b.a.c cVar, java.lang.String str, java.lang.String str2) {
            cVar.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.aa;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = cVar.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((cVar.h.get() == 1 || cVar.h.get() == 3) && cVar.i != null) {
                if (com.anythink.expressad.reward.b.a.this.aa) {
                    cVar.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.aa;
                    return;
                }
                cVar.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.aa;
                com.anythink.expressad.reward.b.a.o(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 17;
                cVar.i.sendMessage(obtain);
            }
        }

        private void c(java.lang.String str) {
            if (this.i != null) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 18;
                this.i.sendMessage(obtain);
            }
        }

        private void c(java.lang.String str, java.lang.String str2) {
            android.os.Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ab;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                this.h.set(2);
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    this.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ab;
                    return;
                }
                this.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ab;
                com.anythink.expressad.reward.b.a.q(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.i.sendMessage(obtain);
            }
        }

        private void d() {
            com.anythink.expressad.videocommon.d.a aVar;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.d();
        }

        private void d(java.lang.String str) {
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ad;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                com.anythink.expressad.reward.b.a.u(com.anythink.expressad.reward.b.a.this);
                if (str.contains("resource load timeout")) {
                    com.anythink.expressad.reward.b.a.s(com.anythink.expressad.reward.b.a.this);
                }
                if (!com.anythink.expressad.reward.b.a.this.ad || !com.anythink.expressad.reward.b.a.this.ac || com.anythink.expressad.reward.b.a.this.ab) {
                    this.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ad;
                    return;
                }
                this.h.set(2);
                this.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ad;
                android.os.Message obtain = android.os.Message.obtain();
                obtain.obj = str;
                obtain.what = 16;
                this.i.sendMessage(obtain);
            }
        }

        private void d(java.lang.String str, java.lang.String str2) {
            android.os.Handler handler = this.i;
            if (handler != null) {
                handler.removeMessages(com.anythink.expressad.reward.b.a.I);
            }
            this.h.get();
            boolean unused = com.anythink.expressad.reward.b.a.this.ab;
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            if ((this.h.get() == 1 || this.h.get() == 3) && this.i != null) {
                if (this.h.get() == 1) {
                    this.h.set(3);
                }
                if (com.anythink.expressad.reward.b.a.this.ab) {
                    this.h.get();
                    boolean unused2 = com.anythink.expressad.reward.b.a.this.ab;
                    return;
                }
                this.h.get();
                boolean unused3 = com.anythink.expressad.reward.b.a.this.ab;
                com.anythink.expressad.reward.b.a.q(com.anythink.expressad.reward.b.a.this);
                android.os.Message obtain = android.os.Message.obtain();
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("unit_id", str2);
                obtain.setData(bundle);
                obtain.obj = str2;
                obtain.what = 9;
                this.i.sendMessage(obtain);
                if (com.anythink.expressad.reward.b.a.this.ac) {
                    this.h.set(2);
                }
            }
        }

        private void e(java.lang.String str) {
            com.anythink.expressad.videocommon.d.a aVar;
            com.anythink.expressad.reward.b.a.l(com.anythink.expressad.reward.b.a.this);
            java.lang.ref.WeakReference<com.anythink.expressad.videocommon.d.a> weakReference = this.c;
            if (weakReference == null || (aVar = weakReference.get()) == null) {
                return;
            }
            aVar.b(str);
        }
    }

    public final class d implements com.anythink.expressad.video.bt.module.b.h {
        private com.anythink.expressad.reward.b.a b;
        private int c;
        private android.os.Handler d;
        private int e;

        public /* synthetic */ d(com.anythink.expressad.reward.b.a aVar, com.anythink.expressad.reward.b.a aVar2, android.os.Handler handler) {
            this(aVar2, handler, (byte) 0);
        }

        private d(com.anythink.expressad.reward.b.a aVar, android.os.Handler handler, byte b) {
            this.e = 0;
            this.b = aVar;
            this.c = 1;
            this.d = handler;
        }

        private void d() {
            com.anythink.expressad.reward.b.a.this.P.clear();
            this.b = null;
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a() {
            com.anythink.expressad.reward.b.a.l(com.anythink.expressad.reward.b.a.this);
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar != null) {
                    aVar.Q = true;
                    if (this.b.m != null) {
                        this.b.m.n = "";
                    }
                    if (this.b.p != null) {
                        if (com.anythink.expressad.reward.b.a.this.K) {
                            com.anythink.expressad.reward.b.a.b();
                        }
                        this.b.p.c();
                        this.e = 2;
                    }
                }
            } catch (java.lang.Throwable th) {
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar == null || aVar.p == null) {
                    return;
                }
                try {
                    if (com.anythink.expressad.reward.b.a.this.K) {
                        com.anythink.expressad.reward.b.a.b();
                    }
                    this.b.p.a(cVar);
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(java.lang.String str) {
            com.anythink.expressad.reward.b.a.l(com.anythink.expressad.reward.b.a.this);
            try {
                if (this.b != null) {
                    if (com.anythink.expressad.reward.b.a.this.K) {
                        com.anythink.expressad.reward.b.a.b();
                    }
                    this.b.Q = false;
                    if (this.b.p != null) {
                        try {
                            if (com.anythink.expressad.reward.b.a.this.af != null) {
                                com.anythink.expressad.reward.b.a.this.af.size();
                            }
                        } catch (java.lang.Exception unused) {
                        }
                        try {
                            this.b.p.b(str);
                        } catch (java.lang.Exception e) {
                            if (com.anythink.expressad.a.a) {
                                e.printStackTrace();
                            }
                        }
                        this.e = 4;
                    }
                }
            } catch (java.lang.Exception e2) {
                this.e = 0;
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z, int i) {
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar == null || aVar.p == null) {
                    return;
                }
                this.b.Q = false;
                try {
                    com.anythink.expressad.videocommon.d.a unused = this.b.p;
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar == null || aVar.p == null) {
                    return;
                }
                if (cVar == null) {
                    cVar = com.anythink.expressad.videocommon.c.c.b(this.b.v);
                }
                if (com.anythink.expressad.reward.b.a.this.K) {
                    com.anythink.expressad.reward.b.a.b();
                    com.anythink.expressad.reward.b.a.this.a();
                }
                this.b.p.a(z, cVar.a(), cVar.b());
                this.e = 7;
                this.b.Q = false;
                com.anythink.expressad.reward.b.a.this.P.clear();
                this.b = null;
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void b() {
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar == null || aVar.p == null) {
                    return;
                }
                try {
                    this.b.p.d();
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
                this.e = 5;
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.anythink.expressad.video.bt.module.b.h
        public final void c() {
            try {
                com.anythink.expressad.reward.b.a aVar = this.b;
                if (aVar == null || aVar.p == null) {
                    return;
                }
                try {
                    com.anythink.expressad.videocommon.d.a unused = this.b.p;
                    com.anythink.expressad.foundation.f.b.a().b("_2", 2);
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
                this.e = 6;
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static int a(java.lang.String str) {
        java.util.Map<java.lang.String, java.lang.Integer> map;
        java.lang.Integer num;
        try {
            if (!com.anythink.expressad.foundation.h.w.b(str) || (map = T) == null || !map.containsKey(str) || (num = T.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static java.util.List<com.anythink.expressad.foundation.d.c> a(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0 && !android.text.TextUtils.isEmpty(str)) {
            for (com.anythink.expressad.foundation.d.c cVar : list) {
                if (cVar != null && str.equals(cVar.B())) {
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    private void a(int i2, int i3, int i4) {
        this.B = i2;
        this.C = i3;
        if (i3 == com.anythink.expressad.foundation.g.a.cu) {
            this.D = i4 < 0 ? 5 : i4;
        }
        if (i3 == com.anythink.expressad.foundation.g.a.ct) {
            this.D = i4 < 0 ? 80 : i4;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i2 == com.anythink.expressad.foundation.g.a.cr ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i3 == com.anythink.expressad.foundation.g.a.ct ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i4);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.b.e(this.f256s, jSONObject.toString());
        } catch (java.lang.Exception unused) {
        }
    }

    private void a(android.app.Activity activity, java.lang.String str, com.anythink.core.common.f.m mVar) {
        java.util.Map<java.lang.String, java.lang.Integer> i2;
        try {
            com.anythink.expressad.videocommon.e.a aVar = this.o;
            int intValue = (aVar == null || (i2 = aVar.i()) == null || !i2.containsKey("1")) ? 0 : i2.get("1").intValue();
            if (com.anythink.expressad.foundation.h.v.b(this.k, this.t + "_1", 0) != null) {
                this.l = ((java.lang.Integer) com.anythink.expressad.foundation.h.v.b(this.k, this.t + "_1", 0)).intValue();
            }
            if (this.m == null) {
                i();
            }
            com.anythink.expressad.reward.a.d dVar = this.m;
            if (dVar != null && dVar.c()) {
                if (this.l >= intValue && intValue > 0) {
                    this.R = false;
                    return;
                }
                com.anythink.expressad.reward.b.a.d dVar2 = new com.anythink.expressad.reward.b.a.d(this, this, this.x);
                c.put(this.f256s, dVar2);
                this.m.a(activity, dVar2, str, this.r, this.y, this.u, mVar);
                return;
            }
            this.R = false;
            if (this.p != null) {
                try {
                    this.p.b("can't show because load is failed");
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.getLocalizedMessage();
            }
            if (this.p != null) {
                try {
                    this.p.b("show exception");
                } catch (java.lang.Exception unused) {
                    if (com.anythink.expressad.a.a) {
                        e2.printStackTrace();
                    }
                }
            }
            this.R = false;
        }
    }

    public static void a(java.lang.String str, int i2) {
        try {
            if (T == null || !com.anythink.expressad.foundation.h.w.b(str)) {
                return;
            }
            T.put(str, java.lang.Integer.valueOf(i2));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (!android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.foundation.h.v.a(this.k, "Anythink_ConfirmTitle" + this.f256s, str.trim());
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            com.anythink.expressad.foundation.h.v.a(this.k, "Anythink_ConfirmContent" + this.f256s, str2.trim());
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            com.anythink.expressad.foundation.h.v.a(this.k, "Anythink_CancelText" + this.f256s, str4.trim());
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        com.anythink.expressad.foundation.h.v.a(this.k, "Anythink_ConfirmText" + this.f256s, str3.trim());
    }

    private static void a(boolean z2, boolean z3) {
        try {
            java.util.Map<java.lang.String, com.anythink.expressad.reward.b.a.d> map = c;
            if (map != null) {
                map.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU);
                } else {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.a();
            com.anythink.expressad.videocommon.a.b();
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(boolean z2, boolean z3, java.lang.String str) {
        try {
            java.util.Map<java.lang.String, com.anythink.expressad.reward.b.a.d> map = c;
            if (map != null) {
                map.clear();
            }
            if (z2) {
                if (z3) {
                    com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU);
                } else {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU);
                }
            } else if (z3) {
                com.anythink.expressad.videocommon.a.a(94);
            } else {
                com.anythink.expressad.videocommon.a.b(94);
            }
            com.anythink.expressad.videocommon.a.c(str);
            com.anythink.expressad.videocommon.a.b();
        } catch (java.lang.Throwable unused) {
        }
    }

    private com.anythink.expressad.videocommon.c.b b(int i2) {
        com.anythink.expressad.videocommon.e.d dVar = this.n;
        com.anythink.expressad.videocommon.c.b bVar = null;
        if (dVar != null) {
            int size = dVar.I().size();
            for (int i3 = 0; i3 < size; i3++) {
                if (this.n.I().get(i3).a() == i2) {
                    bVar = this.n.I().get(i3);
                }
            }
        }
        return bVar;
    }

    public static /* synthetic */ void b() {
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        try {
            c(dVar);
        } catch (java.lang.Exception e) {
            try {
                b("load mv api error:" + e.getMessage());
            } catch (java.lang.Exception e2) {
                b(com.anythink.expressad.foundation.g.b.b.b);
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        if (this.q != null) {
            this.ad = true;
            com.anythink.expressad.reward.b.a.c.a(this.q, str);
        }
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        U.put(str, str2);
    }

    private void b(boolean z2) {
        this.K = z2;
    }

    private static void c() {
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        try {
            com.anythink.expressad.reward.a.d dVar2 = this.m;
            if (dVar2 == null || !this.f256s.equals(dVar2.e())) {
                com.anythink.expressad.reward.a.d dVar3 = new com.anythink.expressad.reward.a.d(this.k, this.t, this.f256s);
                this.m = dVar3;
                dVar3.a(this.J);
                this.m.b(this.K);
            }
            if (this.J) {
                this.m.a(this.B, this.C, this.D);
            }
            this.m.a(this.y);
            this.m.a(this.n);
            com.anythink.expressad.reward.b.a.RunnableC0221a runnableC0221a = new com.anythink.expressad.reward.b.a.RunnableC0221a(this.m);
            com.anythink.expressad.reward.b.a.b bVar = new com.anythink.expressad.reward.b.a.b(this.m);
            bVar.a(runnableC0221a);
            this.m.a(bVar);
            this.m.a(dVar);
        } catch (java.lang.Exception e) {
            b(e.getMessage());
        }
    }

    private void c(boolean z2) {
        this.O = z2;
    }

    private java.lang.String d() {
        com.anythink.expressad.reward.a.d dVar = this.m;
        return dVar != null ? dVar.c(this.Q) : "";
    }

    private static void e() {
        com.anythink.expressad.foundation.h.m.a();
    }

    private void f() {
        try {
            java.util.List<com.anythink.expressad.videocommon.c.b> I2 = this.n.I();
            if (I2 == null || I2.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < I2.size(); i2++) {
                com.anythink.expressad.videocommon.c.b bVar = I2.get(i2);
                com.anythink.expressad.foundation.h.v.a(this.k, this.t + "_" + bVar.a(), 0);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private boolean g() {
        int i2;
        try {
            java.util.List<com.anythink.expressad.videocommon.c.b> I2 = this.n.I();
            if (this.o == null) {
                this.o = com.anythink.expressad.videocommon.e.c.a().b();
            }
            java.util.Map<java.lang.String, java.lang.Integer> i3 = this.o.i();
            if (I2 == null || I2.size() <= 0) {
                return true;
            }
            for (int i4 = 0; i4 < I2.size(); i4++) {
                com.anythink.expressad.videocommon.c.b bVar = I2.get(i4);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(bVar.a());
                if (i3.containsKey(sb.toString())) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append(bVar.a());
                    i2 = i3.get(sb2.toString()).intValue();
                } else {
                    i2 = 0;
                }
                java.lang.Object b2 = com.anythink.expressad.foundation.h.v.b(this.k, this.t + "_" + bVar.a(), 0);
                if ((b2 != null ? ((java.lang.Integer) b2).intValue() : 0) < i2) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            e.getMessage();
            return true;
        }
    }

    private boolean h() {
        if (this.m == null) {
            i();
        }
        com.anythink.expressad.reward.a.d dVar = this.m;
        if (dVar != null) {
            return dVar.c();
        }
        return false;
    }

    private void i() {
        com.anythink.expressad.reward.a.d dVar = new com.anythink.expressad.reward.a.d(this.k, this.t, this.f256s);
        this.m = dVar;
        dVar.a(this.J);
        this.m.b(this.K);
        if (this.J) {
            this.m.a(this.B, this.C, this.D);
        }
        this.m.a(this.n);
    }

    private boolean j() {
        try {
            if (this.X != null) {
                return false;
            }
            this.X = com.anythink.expressad.foundation.c.c.a(com.anythink.core.common.b.o.a().f());
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean l(com.anythink.expressad.reward.b.a aVar) {
        aVar.R = false;
        return false;
    }

    public static /* synthetic */ boolean o(com.anythink.expressad.reward.b.a aVar) {
        aVar.aa = true;
        return true;
    }

    public static /* synthetic */ boolean q(com.anythink.expressad.reward.b.a aVar) {
        aVar.ab = true;
        return true;
    }

    public static /* synthetic */ boolean s(com.anythink.expressad.reward.b.a aVar) {
        aVar.ac = true;
        return true;
    }

    public static /* synthetic */ boolean u(com.anythink.expressad.reward.b.a aVar) {
        aVar.ad = true;
        return true;
    }

    public final void a() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap;
        if (!this.Q || (concurrentHashMap = U) == null || concurrentHashMap.containsKey(d())) {
            return;
        }
        U.remove(d());
    }

    public final void a(int i2) {
        this.y = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.core.common.f.m mVar) {
        java.util.Map<java.lang.String, java.lang.Integer> i2;
        try {
            this.v = str;
            this.r = str2;
            this.u = str3;
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
            }
            if (this.p != null) {
            }
            this.R = false;
        }
        synchronized (this.S) {
            if (this.R) {
                if (this.p != null) {
                    try {
                        this.p.b(com.anythink.expressad.foundation.g.b.b.g);
                    } catch (java.lang.Exception e2) {
                        if (com.anythink.expressad.a.a) {
                            e2.printStackTrace();
                        }
                    }
                }
                return;
            }
            this.R = true;
            if (this.q != null && this.q.h.get() == 1) {
                if (this.p != null) {
                    try {
                        this.p.b(com.anythink.expressad.foundation.g.b.b.c);
                    } catch (java.lang.Exception e3) {
                        if (com.anythink.expressad.a.a) {
                            e3.printStackTrace();
                        }
                    }
                }
                this.R = false;
                return;
            }
            android.content.Context context = this.k;
            if (context == null) {
                if (this.p != null) {
                    try {
                        this.p.b(com.anythink.expressad.foundation.g.b.b.a);
                    } catch (java.lang.Exception e4) {
                        if (com.anythink.expressad.a.a) {
                            e4.printStackTrace();
                        }
                    }
                }
                this.R = false;
                return;
            }
            if (this.J && !com.anythink.expressad.foundation.h.t.b(context)) {
                if (this.p != null) {
                    try {
                        this.p.b(com.anythink.expressad.foundation.g.b.b.d);
                    } catch (java.lang.Exception e5) {
                        if (com.anythink.expressad.a.a) {
                            e5.printStackTrace();
                        }
                    }
                }
                this.R = false;
                return;
            }
            j();
            try {
                java.lang.String format = new java.text.SimpleDateFormat("dd").format(new java.util.Date());
                java.lang.String str4 = (java.lang.String) com.anythink.expressad.foundation.h.v.b(this.k, com.anythink.expressad.foundation.g.a.bK, "0");
                if (!android.text.TextUtils.isEmpty(str4) && !android.text.TextUtils.isEmpty(format) && !str4.equals(format)) {
                    com.anythink.expressad.foundation.h.v.a(this.k, com.anythink.expressad.foundation.g.a.bK, format);
                    com.anythink.expressad.foundation.h.v.a(this.k, this.t + "_1", 0);
                }
            } catch (java.lang.Exception unused) {
            }
            try {
                com.anythink.expressad.videocommon.e.a aVar = this.o;
                int intValue = (aVar == null || (i2 = aVar.i()) == null || !i2.containsKey("1")) ? 0 : i2.get("1").intValue();
                if (com.anythink.expressad.foundation.h.v.b(this.k, this.t + "_1", 0) != null) {
                    this.l = ((java.lang.Integer) com.anythink.expressad.foundation.h.v.b(this.k, this.t + "_1", 0)).intValue();
                }
                if (this.m == null) {
                    i();
                }
                com.anythink.expressad.reward.a.d dVar = this.m;
                if (dVar != null && dVar.c()) {
                    if (this.l >= intValue && intValue > 0) {
                        this.R = false;
                        return;
                    }
                    com.anythink.expressad.reward.b.a.d dVar2 = new com.anythink.expressad.reward.b.a.d(this, this, this.x);
                    c.put(this.f256s, dVar2);
                    this.m.a(activity, dVar2, str, this.r, this.y, this.u, mVar);
                    return;
                }
                this.R = false;
                if (this.p != null) {
                    try {
                        this.p.b("can't show because load is failed");
                        return;
                    } catch (java.lang.Exception e6) {
                        if (com.anythink.expressad.a.a) {
                            e6.printStackTrace();
                            return;
                        }
                        return;
                    }
                }
                return;
            } catch (java.lang.Exception e7) {
                if (com.anythink.expressad.a.a) {
                    e7.getLocalizedMessage();
                }
                if (this.p != null) {
                    try {
                        this.p.b("show exception");
                    } catch (java.lang.Exception unused2) {
                        if (com.anythink.expressad.a.a) {
                            e7.printStackTrace();
                        }
                    }
                }
                this.R = false;
                return;
            }
            if (com.anythink.expressad.a.a) {
                e.getLocalizedMessage();
            }
            if (this.p != null) {
                try {
                    this.p.b("show exception");
                } catch (java.lang.Exception unused3) {
                    if (com.anythink.expressad.a.a) {
                        e.printStackTrace();
                    }
                }
            }
            this.R = false;
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar == null) {
            com.anythink.expressad.reward.b.a.c.b(this.q, com.anythink.expressad.foundation.g.b.b.f);
            return;
        }
        if (this.q == null || com.anythink.expressad.reward.b.a.c.a(this.q) != 3) {
            this.Y = true;
            com.anythink.expressad.reward.b.a.c.b(this.q);
        } else {
            this.Y = false;
        }
        this.N = true;
        this.x.removeMessages(H);
        this.ab = false;
        this.aa = false;
        this.ac = false;
        this.ad = false;
        com.anythink.expressad.reward.a.c.a();
        try {
            this.n = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.f256s, this.J);
            if (!android.text.TextUtils.isEmpty(this.t)) {
                this.n.b(this.t);
            }
            int S = this.n.S() * 1000;
            if (this.x != null) {
                this.x.sendEmptyMessageDelayed(I, S);
            }
            this.V = this.n.Q();
            try {
                if (g()) {
                    f();
                }
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            }
            try {
                c(dVar);
            } catch (java.lang.Exception e2) {
                try {
                    b("load mv api error:" + e2.getMessage());
                } catch (java.lang.Exception e3) {
                    b(com.anythink.expressad.foundation.g.b.b.b);
                    if (com.anythink.expressad.a.a) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Exception e4) {
            if (this.q != null) {
                com.anythink.expressad.reward.b.a.c.a(this.q, "load exception");
            }
            if (com.anythink.expressad.a.a) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(com.anythink.expressad.videocommon.d.a aVar) {
        this.p = aVar;
        this.q = new com.anythink.expressad.reward.b.a.c(this, aVar, this.x, this.f256s, (byte) 0);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        try {
            this.k = com.anythink.core.common.b.o.a().f();
            this.f256s = str2;
            this.t = str;
            this.o = com.anythink.expressad.videocommon.e.c.a().b();
            com.anythink.expressad.foundation.h.m.b();
            com.anythink.expressad.videocommon.b.m.a().b();
            com.anythink.expressad.videocommon.b.j.a().b();
            com.anythink.expressad.videocommon.e.c.a().a(this.f256s, this.J);
            if (this.X == null) {
                this.X = com.anythink.expressad.foundation.c.c.a(com.anythink.core.common.b.o.a().f());
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void a(boolean z2) {
        this.J = z2;
    }

    @Override // com.anythink.core.common.a.h
    public boolean isReady() {
        try {
            j();
            if (this.K) {
                return false;
            }
            if (this.m == null) {
                i();
            }
            com.anythink.expressad.reward.a.d dVar = this.m;
            if (dVar != null) {
                return dVar.c();
            }
            return false;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}

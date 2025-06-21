package com.anythink.expressad.reward.a;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.reward.a.a {
    private static final int L = 8;
    private static final int M = 9;
    private static final int N = 16;
    private static final int O = 17;
    private static final int P = 5000;
    private static final int Q = 30000;
    public static final java.lang.String a = "APP ALREADY INSTALLED";
    public static final java.lang.String b = "Offer list is empty";
    public static final java.lang.String d = "1";
    public static final java.lang.String e = "1";
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 6;
    public static final int l = 7;
    private static final java.lang.String u = "RewardMVVideoAdapter";
    private int A;
    private int B;
    private boolean C;
    private java.lang.String D;
    private java.lang.String E;
    private com.anythink.expressad.video.bt.module.b.h F;
    private volatile com.anythink.expressad.reward.a.b G;
    private java.lang.Runnable H;
    private com.anythink.expressad.videocommon.e.d I;
    private boolean T;
    private boolean U;
    private int W;
    private int X;
    private int Y;
    private com.anythink.expressad.foundation.d.d Z;
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> aa;
    private java.util.List<com.anythink.expressad.foundation.d.c> ag;
    private java.util.List<com.anythink.expressad.foundation.d.c> ah;
    private android.content.Context v;
    private java.lang.String w;
    private java.lang.String x;
    private int y;
    private int z;
    private boolean J = false;
    private boolean K = false;
    public java.lang.Object c = new java.lang.Object();
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> R = new java.util.concurrent.CopyOnWriteArrayList<>();
    private int S = 2;
    private java.lang.String V = "";
    private boolean ab = false;
    public java.lang.String m = "";
    public java.lang.String n = "";
    private long ac = 0;
    private android.os.Handler ad = new com.anythink.expressad.reward.a.d.AnonymousClass1(android.os.Looper.getMainLooper());
    boolean o = false;
    private long ae = 0;
    volatile boolean p = false;
    volatile boolean q = false;
    volatile boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    volatile boolean f255s = false;
    volatile boolean t = false;
    private java.lang.String af = "";

    /* renamed from: com.anythink.expressad.reward.a.d$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x01d9  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void handleMessage(android.os.Message message) {
            boolean z;
            try {
                try {
                    int i = message.what;
                    if (i == 8) {
                        if (com.anythink.expressad.reward.a.d.this.G == null || ((com.anythink.expressad.foundation.d.c) message.obj) == null || android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w)) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.c();
                    }
                    if (i == 9 || i == 16) {
                        try {
                            java.lang.Object[] objArr = (java.lang.Object[]) message.obj;
                            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) objArr[0];
                            java.lang.String str = (java.lang.String) objArr[2];
                            com.anythink.expressad.videocommon.e.d dVar = (com.anythink.expressad.videocommon.e.d) objArr[3];
                            java.lang.String str2 = (java.lang.String) objArr[4];
                            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = objArr.length == 7 ? (com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) objArr[6] : null;
                            if (cVar != null) {
                                if (com.anythink.expressad.reward.a.d.this.R != null) {
                                    com.anythink.expressad.reward.a.d dVar2 = com.anythink.expressad.reward.a.d.this;
                                    com.anythink.expressad.reward.a.d.a(dVar2, windVaneWebView, str2, cVar, dVar2.R, "", str, dVar);
                                    return;
                                } else {
                                    if (com.anythink.expressad.reward.a.d.this.ah != null) {
                                        com.anythink.expressad.reward.a.d dVar3 = com.anythink.expressad.reward.a.d.this;
                                        com.anythink.expressad.reward.a.d.a(dVar3, windVaneWebView, str2, cVar, dVar3.ah, "", str, dVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        } catch (java.lang.Exception e) {
                            e.getLocalizedMessage();
                            if (com.anythink.expressad.a.a) {
                                e.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                    if (i == 17) {
                        try {
                            java.lang.Object[] objArr2 = (java.lang.Object[]) message.obj;
                            com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) objArr2[0];
                            java.lang.String str3 = (java.lang.String) objArr2[1];
                            java.lang.String str4 = (java.lang.String) objArr2[2];
                            com.anythink.expressad.videocommon.e.d dVar4 = (com.anythink.expressad.videocommon.e.d) objArr2[3];
                            java.lang.String str5 = (java.lang.String) objArr2[4];
                            if (cVar2 == null || android.text.TextUtils.isEmpty(str3)) {
                                return;
                            }
                            com.anythink.expressad.reward.a.d.a(com.anythink.expressad.reward.a.d.this, str5, cVar2, str3, str4, dVar4);
                            return;
                        } catch (java.lang.Exception e2) {
                            e2.getLocalizedMessage();
                            if (com.anythink.expressad.a.a) {
                                e2.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                    switch (i) {
                        case 1:
                            java.lang.String unused = com.anythink.expressad.reward.a.d.this.D;
                            java.lang.String unused2 = com.anythink.expressad.reward.a.d.this.E;
                            break;
                        case 2:
                            java.lang.String unused3 = com.anythink.expressad.reward.a.d.this.D;
                            java.lang.String unused4 = com.anythink.expressad.reward.a.d.this.E;
                            break;
                        case 3:
                            if (com.anythink.expressad.reward.a.d.this.G != null) {
                                com.anythink.expressad.reward.a.d.this.G.b();
                            }
                            sendEmptyMessageDelayed(5, com.anythink.expressad.foundation.g.a.cq);
                            break;
                        case 4:
                            if (com.anythink.expressad.reward.a.d.this.G != null) {
                                java.lang.String unused5 = com.anythink.expressad.reward.a.d.this.w;
                                java.util.List unused6 = com.anythink.expressad.reward.a.d.this.ag;
                                boolean unused7 = com.anythink.expressad.reward.a.d.this.U;
                                if (com.anythink.expressad.reward.a.d.this.ag != null && com.anythink.expressad.reward.a.d.this.ag.size() > 0) {
                                    com.anythink.expressad.reward.a.d.this.ag.get(0);
                                }
                                try {
                                    java.lang.Object obj = message.obj;
                                    if (obj != null) {
                                        java.lang.String str6 = (java.lang.String) obj;
                                        if (!android.text.TextUtils.isEmpty(str6)) {
                                            if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                                com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                            }
                                            removeMessages(6);
                                            boolean z2 = com.anythink.expressad.reward.a.d.this.t;
                                            if (!com.anythink.expressad.reward.a.d.this.t) {
                                                com.anythink.expressad.reward.a.d.this.t = true;
                                                com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3507 errorMessage: data load failed, errorMsg is ".concat(java.lang.String.valueOf(str6)));
                                                break;
                                            }
                                        } else {
                                            if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                                com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                            }
                                            removeMessages(6);
                                            if (!com.anythink.expressad.reward.a.d.this.t) {
                                                com.anythink.expressad.reward.a.d.this.t = true;
                                                com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3507 errorMessage: data load failed, errorMsg null");
                                                break;
                                            }
                                        }
                                    } else {
                                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                        }
                                        removeMessages(6);
                                        if (!com.anythink.expressad.reward.a.d.this.t) {
                                            com.anythink.expressad.reward.a.d.this.t = true;
                                            com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3506 errorMessage: data load failed");
                                            break;
                                        }
                                    }
                                } catch (java.lang.Exception e3) {
                                    if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                        com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                    }
                                    removeMessages(6);
                                    java.lang.String unused8 = com.anythink.expressad.reward.a.d.this.w;
                                    java.util.List unused9 = com.anythink.expressad.reward.a.d.this.ag;
                                    boolean unused10 = com.anythink.expressad.reward.a.d.this.U;
                                    if (com.anythink.expressad.reward.a.d.this.t) {
                                        return;
                                    }
                                    com.anythink.expressad.reward.a.d.this.t = true;
                                    com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3508 errorMessage: data load failed, exception is " + e3.getMessage());
                                    return;
                                }
                            }
                            break;
                        case 5:
                            if (com.anythink.expressad.reward.a.d.this.G != null) {
                                if (com.anythink.expressad.reward.a.d.this.ag != null && com.anythink.expressad.reward.a.d.this.ag.size() > 0) {
                                    com.anythink.expressad.foundation.d.c cVar3 = (com.anythink.expressad.foundation.d.c) com.anythink.expressad.reward.a.d.this.ag.get(0);
                                    boolean z3 = !android.text.TextUtils.isEmpty(cVar3.ar());
                                    int ap = cVar3.ap();
                                    com.anythink.expressad.reward.a.d dVar5 = com.anythink.expressad.reward.a.d.this;
                                    if (dVar5.b(dVar5.aa, z3, ap)) {
                                        java.lang.String str7 = com.anythink.expressad.reward.a.d.this.w;
                                        java.util.List unused11 = com.anythink.expressad.reward.a.d.this.ag;
                                        java.util.List list = com.anythink.expressad.reward.a.d.this.ah;
                                        boolean unused12 = com.anythink.expressad.reward.a.d.this.U;
                                        com.anythink.expressad.reward.a.d.a(str7, list);
                                        sendEmptyMessage(6);
                                        removeMessages(5);
                                        if (!com.anythink.expressad.reward.a.d.this.f255s) {
                                            com.anythink.expressad.reward.a.d.this.f255s = true;
                                            android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                                            com.anythink.expressad.reward.a.d.this.G.a();
                                            break;
                                        }
                                    }
                                }
                                java.lang.String unused13 = com.anythink.expressad.reward.a.d.this.w;
                                java.util.List unused14 = com.anythink.expressad.reward.a.d.this.ag;
                                boolean unused15 = com.anythink.expressad.reward.a.d.this.U;
                                if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(6);
                                }
                                if (!com.anythink.expressad.reward.a.d.this.t) {
                                    com.anythink.expressad.reward.a.d.this.t = true;
                                    if (com.anythink.expressad.reward.a.d.this.ag != null && com.anythink.expressad.reward.a.d.this.ag.size() > 0) {
                                        com.anythink.expressad.reward.a.d.this.ag.get(0);
                                    }
                                    com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3401 errorMessage: resource load timeout");
                                    if (com.anythink.expressad.reward.a.d.this.aa != null && com.anythink.expressad.reward.a.d.this.aa.size() > 0) {
                                        java.util.Iterator it = com.anythink.expressad.reward.a.d.this.aa.iterator();
                                        boolean z4 = false;
                                        while (it.hasNext()) {
                                            com.anythink.expressad.foundation.d.c cVar4 = (com.anythink.expressad.foundation.d.c) it.next();
                                            if (cVar4 != null) {
                                                if (!android.text.TextUtils.isEmpty(cVar4.S()) && !com.anythink.expressad.videocommon.b.l.a().a(cVar4.S())) {
                                                    z = true;
                                                    if (cVar4 != null && !android.text.TextUtils.isEmpty(cVar4.I()) && !com.anythink.expressad.videocommon.b.l.a().b(cVar4.I())) {
                                                        z = true;
                                                    }
                                                    if (cVar4 != null && !android.text.TextUtils.isEmpty(cVar4.ar())) {
                                                        if (com.anythink.expressad.videocommon.b.l.a().b(cVar4.ar())) {
                                                            z = true;
                                                        } else if (!z4 && !z) {
                                                            if (com.anythink.expressad.videocommon.a.a(com.anythink.expressad.reward.a.d.this.w + "_" + cVar4.Z() + "_" + cVar4.ar()) == null) {
                                                                z4 = true;
                                                            }
                                                        }
                                                    }
                                                    if (cVar4 != null && cVar4.M() != null && !android.text.TextUtils.isEmpty(cVar4.M().e()) && !cVar4.M().e().contains(com.anythink.expressad.foundation.d.c.d) && com.anythink.expressad.videocommon.b.l.a().b(cVar4.M().e()) && android.text.TextUtils.isEmpty(cVar4.ar()) && !z) {
                                                        com.anythink.expressad.videocommon.a.a(cVar4.w(), cVar4);
                                                    }
                                                }
                                            }
                                            z = false;
                                            if (cVar4 != null) {
                                                z = true;
                                            }
                                            if (cVar4 != null) {
                                                if (com.anythink.expressad.videocommon.b.l.a().b(cVar4.ar())) {
                                                }
                                            }
                                            if (cVar4 != null) {
                                                com.anythink.expressad.videocommon.a.a(cVar4.w(), cVar4);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        case 6:
                            java.lang.String str8 = com.anythink.expressad.reward.a.d.this.w;
                            java.util.List unused16 = com.anythink.expressad.reward.a.d.this.ag;
                            java.util.List list2 = com.anythink.expressad.reward.a.d.this.ah;
                            boolean unused17 = com.anythink.expressad.reward.a.d.this.U;
                            com.anythink.expressad.reward.a.d.a(str8, list2);
                            if (com.anythink.expressad.reward.a.d.this.G != null) {
                                removeMessages(6);
                                if (com.anythink.expressad.reward.a.d.this.ad != null) {
                                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                                }
                                if (com.anythink.expressad.reward.a.d.this.G != null && !com.anythink.expressad.reward.a.d.this.f255s) {
                                    com.anythink.expressad.reward.a.d.this.f255s = true;
                                    android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                                    com.anythink.expressad.reward.a.d.this.G.a();
                                    break;
                                }
                            }
                            break;
                    }
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.reward.a.c.InterfaceC0216c {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.anythink.expressad.foundation.d.c b;
        final /* synthetic */ int c;

        /* renamed from: com.anythink.expressad.reward.a.d$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.foundation.d.c a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ java.lang.String c;
            final /* synthetic */ java.lang.String d;
            final /* synthetic */ java.util.concurrent.CopyOnWriteArrayList e;

            /* renamed from: com.anythink.expressad.reward.a.d$2$1$1, reason: invalid class name and collision with other inner class name */
            public class C02171 implements com.anythink.expressad.reward.a.c.j {
                public C02171() {
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a() {
                    com.anythink.expressad.reward.a.d dVar = com.anythink.expressad.reward.a.d.this;
                    java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = dVar.aa;
                    com.anythink.expressad.reward.a.d.AnonymousClass2 anonymousClass2 = com.anythink.expressad.reward.a.d.AnonymousClass2.this;
                    if (!dVar.a(copyOnWriteArrayList, anonymousClass2.a, anonymousClass2.c)) {
                        java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.t = true;
                        android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                        com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3502 errorMessage: temp preload success but isReady false");
                        return;
                    }
                    java.lang.String str = com.anythink.expressad.reward.a.d.this.w;
                    java.util.List list = com.anythink.expressad.reward.a.d.this.ah;
                    boolean unused3 = com.anythink.expressad.reward.a.d.this.U;
                    com.anythink.expressad.reward.a.d.a(str, list);
                    if (com.anythink.expressad.reward.a.d.this.ad != null) {
                        com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                    }
                    if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.f255s) {
                        return;
                    }
                    com.anythink.expressad.reward.a.d.this.f255s = true;
                    android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                    com.anythink.expressad.reward.a.d.this.G.a();
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a(java.lang.String str) {
                    if (com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB() == null || com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB().size() <= 0 || !com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB().contains(1)) {
                        java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.t = true;
                        android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                        com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3301 errorMessage: temp preload failed: ".concat(java.lang.String.valueOf(str)));
                    }
                }
            }

            public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList) {
                this.a = cVar;
                this.b = str;
                this.c = str2;
                this.d = str3;
                this.e = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.reward.a.c cVar = com.anythink.expressad.reward.a.c.m.a;
                boolean z = com.anythink.expressad.reward.a.d.this.ab;
                android.os.Handler handler = com.anythink.expressad.reward.a.d.this.ad;
                boolean z2 = com.anythink.expressad.reward.a.d.this.T;
                boolean z3 = com.anythink.expressad.reward.a.d.this.U;
                java.lang.String e = this.a.M().e();
                int i = com.anythink.expressad.reward.a.d.this.S;
                com.anythink.expressad.reward.a.d.AnonymousClass2 anonymousClass2 = com.anythink.expressad.reward.a.d.AnonymousClass2.this;
                com.anythink.expressad.foundation.d.c cVar2 = anonymousClass2.b;
                java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = com.anythink.expressad.reward.a.d.this.aa;
                java.lang.String c = com.anythink.expressad.videocommon.b.i.a().c(this.a.M().e());
                java.lang.String str = this.b;
                java.lang.String str2 = this.c;
                java.lang.String str3 = this.d;
                this.a.aa();
                cVar.a(z, handler, z2, z3, (com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) null, e, i, cVar2, copyOnWriteArrayList, c, str, str2, str3, com.anythink.expressad.reward.a.d.this.I, new com.anythink.expressad.reward.a.d.AnonymousClass2.AnonymousClass1.C02171());
            }
        }

        /* renamed from: com.anythink.expressad.reward.a.d$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC02182 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ java.util.concurrent.CopyOnWriteArrayList c;

            /* renamed from: com.anythink.expressad.reward.a.d$2$2$1, reason: invalid class name */
            public class AnonymousClass1 implements com.anythink.expressad.reward.a.c.j {
                public AnonymousClass1() {
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a() {
                    com.anythink.expressad.reward.a.d dVar = com.anythink.expressad.reward.a.d.this;
                    java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = dVar.aa;
                    com.anythink.expressad.reward.a.d.AnonymousClass2 anonymousClass2 = com.anythink.expressad.reward.a.d.AnonymousClass2.this;
                    if (!dVar.a(copyOnWriteArrayList, anonymousClass2.a, anonymousClass2.c)) {
                        java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.t = true;
                        android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                        com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                        return;
                    }
                    java.lang.String str = com.anythink.expressad.reward.a.d.this.w;
                    java.util.List list = com.anythink.expressad.reward.a.d.this.ah;
                    boolean unused3 = com.anythink.expressad.reward.a.d.this.U;
                    com.anythink.expressad.reward.a.d.a(str, list);
                    if (com.anythink.expressad.reward.a.d.this.ad != null) {
                        com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                    }
                    if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.f255s) {
                        return;
                    }
                    com.anythink.expressad.reward.a.d.this.f255s = true;
                    android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                    com.anythink.expressad.reward.a.d.this.G.a();
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a(java.lang.String str) {
                    if (com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB() == null || com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB().size() <= 0 || !com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aB().contains(3)) {
                        java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.t = true;
                        com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(java.lang.String.valueOf(str)));
                    }
                }
            }

            public RunnableC02182(java.lang.String str, java.lang.String str2, java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList) {
                this.a = str;
                this.b = str2;
                this.c = copyOnWriteArrayList;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.reward.a.c cVar = com.anythink.expressad.reward.a.c.m.a;
                boolean z = com.anythink.expressad.reward.a.d.this.ab;
                android.os.Handler handler = com.anythink.expressad.reward.a.d.this.ad;
                boolean z2 = com.anythink.expressad.reward.a.d.this.T;
                boolean z3 = com.anythink.expressad.reward.a.d.this.U;
                java.lang.String str = this.a;
                com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.aa();
                java.lang.String str2 = com.anythink.expressad.reward.a.d.this.x;
                java.lang.String str3 = this.b;
                java.lang.String ar = com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.ar();
                int i = com.anythink.expressad.reward.a.d.this.S;
                com.anythink.expressad.reward.a.d.AnonymousClass2 anonymousClass2 = com.anythink.expressad.reward.a.d.AnonymousClass2.this;
                cVar.a(z, handler, z2, z3, str, str2, str3, ar, i, anonymousClass2.b, com.anythink.expressad.reward.a.d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(com.anythink.expressad.reward.a.d.AnonymousClass2.this.b.ar()), this.b, com.anythink.expressad.reward.a.d.this.I, new com.anythink.expressad.reward.a.d.AnonymousClass2.RunnableC02182.AnonymousClass1());
            }
        }

        /* renamed from: com.anythink.expressad.reward.a.d$2$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            public AnonymousClass3(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                if (com.anythink.expressad.reward.a.d.this.ad != null) {
                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                }
                if (com.anythink.expressad.reward.a.d.this.t || com.anythink.expressad.reward.a.d.this.G == null) {
                    return;
                }
                com.anythink.expressad.reward.a.d.this.t = true;
                android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3201 errorMessage: campaign resource download failed");
            }
        }

        public AnonymousClass2(boolean z, com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = z;
            this.b = cVar;
            this.c = i;
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0216c
        public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            copyOnWriteArrayList.size();
            com.anythink.expressad.reward.a.d.this.p = true;
            copyOnWriteArrayList.size();
            if (this.a) {
                if (!com.anythink.expressad.reward.a.d.this.q || com.anythink.expressad.reward.a.d.this.r || com.anythink.expressad.reward.a.d.this.ad == null) {
                    boolean z = com.anythink.expressad.reward.a.d.this.q;
                    boolean z2 = com.anythink.expressad.reward.a.d.this.r;
                    return;
                }
                synchronized (com.anythink.expressad.reward.a.d.this.c) {
                    if (com.anythink.expressad.reward.a.d.this.r) {
                        return;
                    }
                    com.anythink.expressad.reward.a.d.this.r = true;
                    com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass2.RunnableC02182(str3, str2, copyOnWriteArrayList));
                    return;
                }
            }
            java.util.Iterator<com.anythink.expressad.foundation.d.c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.anythink.expressad.foundation.d.c next = it.next();
                if (next == null || next.M() == null || android.text.TextUtils.isEmpty(next.M().e()) || next.M().e().contains(com.anythink.expressad.foundation.d.c.d) || com.anythink.expressad.reward.a.d.this.ad == null) {
                    com.anythink.expressad.reward.a.d dVar = com.anythink.expressad.reward.a.d.this;
                    if (dVar.a(dVar.aa, this.a, this.c)) {
                        copyOnWriteArrayList.get(0).Z();
                        java.lang.String str4 = com.anythink.expressad.reward.a.d.this.w;
                        java.util.List list = com.anythink.expressad.reward.a.d.this.ah;
                        boolean unused = com.anythink.expressad.reward.a.d.this.U;
                        com.anythink.expressad.reward.a.d.a(str4, list);
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G != null && !com.anythink.expressad.reward.a.d.this.f255s) {
                            com.anythink.expressad.reward.a.d.this.f255s = true;
                            android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                            com.anythink.expressad.reward.a.d.this.G.a();
                        }
                    } else {
                        copyOnWriteArrayList.get(0).Z();
                        java.util.List unused2 = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused3 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G != null && !com.anythink.expressad.reward.a.d.this.t) {
                            com.anythink.expressad.reward.a.d.this.t = true;
                            if (!android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w) && next != null && !android.text.TextUtils.isEmpty(next.aa())) {
                                next.aa();
                            }
                            com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3503 errorMessage: have no temp but isReady false");
                        }
                    }
                } else {
                    com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass2.AnonymousClass1(next, str, str2, str3, copyOnWriteArrayList));
                }
            }
        }

        @Override // com.anythink.expressad.reward.a.c.InterfaceC0216c
        public final void a(java.lang.String str, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            copyOnWriteArrayList.size();
            com.anythink.expressad.reward.a.d.this.p = false;
            copyOnWriteArrayList.size();
            if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.ad == null) {
                return;
            }
            com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass2.AnonymousClass3(str));
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.reward.a.c.i {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.anythink.expressad.foundation.d.c b;
        final /* synthetic */ int c;

        /* renamed from: com.anythink.expressad.reward.a.d$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            public AnonymousClass1(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                if (com.anythink.expressad.reward.a.d.this.ad != null) {
                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                }
                if (com.anythink.expressad.reward.a.d.this.t || com.anythink.expressad.reward.a.d.this.G == null) {
                    return;
                }
                com.anythink.expressad.reward.a.d.this.t = true;
                com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3202 errorMessage: temp resource download failed");
            }
        }

        /* renamed from: com.anythink.expressad.reward.a.d$3$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;

            public AnonymousClass2(java.lang.String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                if (com.anythink.expressad.reward.a.d.this.ad != null) {
                    com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                }
                if (com.anythink.expressad.reward.a.d.this.t || com.anythink.expressad.reward.a.d.this.G == null) {
                    return;
                }
                com.anythink.expressad.reward.a.d.this.t = true;
                com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            }
        }

        public AnonymousClass3(boolean z, com.anythink.expressad.foundation.d.c cVar, int i) {
            this.a = z;
            this.b = cVar;
            this.c = i;
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(java.lang.String str) {
            if (!this.a && com.anythink.expressad.reward.a.d.this.G != null && com.anythink.expressad.reward.a.d.this.ad != null) {
                if (this.b.aB() == null || this.b.aB().size() <= 0 || !this.b.aB().contains(1)) {
                    com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass3.AnonymousClass1(str));
                    return;
                }
                return;
            }
            if (this.c == 1) {
                if (this.b.aB() != null && this.b.aB().size() > 0) {
                    if (this.b.aB().contains(3)) {
                        return;
                    }
                    if (this.b.ar().equals(this.b.I()) && this.b.aB().contains(2)) {
                        return;
                    }
                }
                if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.ad == null) {
                    return;
                }
                com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass3.AnonymousClass2(str));
            }
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.reward.a.c.i {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;

        /* renamed from: com.anythink.expressad.reward.a.d$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;
            final /* synthetic */ java.lang.String c;

            /* renamed from: com.anythink.expressad.reward.a.d$4$1$1, reason: invalid class name and collision with other inner class name */
            public class C02191 implements com.anythink.expressad.reward.a.c.j {
                public C02191() {
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a() {
                    com.anythink.expressad.reward.a.d dVar = com.anythink.expressad.reward.a.d.this;
                    java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = dVar.aa;
                    com.anythink.expressad.reward.a.d.AnonymousClass4 anonymousClass4 = com.anythink.expressad.reward.a.d.AnonymousClass4.this;
                    if (!dVar.a(copyOnWriteArrayList, anonymousClass4.b, anonymousClass4.c)) {
                        java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                        boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                        if (com.anythink.expressad.reward.a.d.this.ad != null) {
                            com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                        }
                        if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                            return;
                        }
                        com.anythink.expressad.reward.a.d.this.t = true;
                        com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                        return;
                    }
                    java.lang.String str = com.anythink.expressad.reward.a.d.this.w;
                    java.util.List unused3 = com.anythink.expressad.reward.a.d.this.ag;
                    java.util.List list = com.anythink.expressad.reward.a.d.this.ah;
                    boolean unused4 = com.anythink.expressad.reward.a.d.this.U;
                    com.anythink.expressad.reward.a.d.a(str, list);
                    if (com.anythink.expressad.reward.a.d.this.ad != null) {
                        com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                    }
                    if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.f255s) {
                        return;
                    }
                    com.anythink.expressad.reward.a.d.this.f255s = true;
                    android.text.TextUtils.isEmpty(com.anythink.expressad.reward.a.d.this.w);
                    com.anythink.expressad.reward.a.d.this.G.a();
                }

                @Override // com.anythink.expressad.reward.a.c.j
                public final void a(java.lang.String str) {
                    java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
                    boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
                    if (com.anythink.expressad.reward.a.d.this.ad != null) {
                        com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
                    }
                    if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                        return;
                    }
                    com.anythink.expressad.reward.a.d.this.t = true;
                    com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3303 errorMessage: tpl temp preload failed: ".concat(java.lang.String.valueOf(str)));
                }
            }

            public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3) {
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.reward.a.c cVar = com.anythink.expressad.reward.a.c.m.a;
                boolean z = com.anythink.expressad.reward.a.d.this.ab;
                android.os.Handler handler = com.anythink.expressad.reward.a.d.this.ad;
                boolean z2 = com.anythink.expressad.reward.a.d.this.T;
                boolean z3 = com.anythink.expressad.reward.a.d.this.U;
                java.lang.String str = this.a;
                com.anythink.expressad.reward.a.d.AnonymousClass4.this.a.aa();
                java.lang.String str2 = this.b;
                java.lang.String str3 = this.c;
                java.lang.String ar = com.anythink.expressad.reward.a.d.AnonymousClass4.this.a.ar();
                int i = com.anythink.expressad.reward.a.d.this.S;
                com.anythink.expressad.reward.a.d.AnonymousClass4 anonymousClass4 = com.anythink.expressad.reward.a.d.AnonymousClass4.this;
                cVar.a(z, handler, z2, z3, str, str2, str3, ar, i, anonymousClass4.a, com.anythink.expressad.reward.a.d.this.aa, com.anythink.expressad.videocommon.b.i.a().c(com.anythink.expressad.reward.a.d.AnonymousClass4.this.a.ar()), this.c, com.anythink.expressad.reward.a.d.this.I, new com.anythink.expressad.reward.a.d.AnonymousClass4.AnonymousClass1.C02191());
            }
        }

        public AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, boolean z, int i) {
            this.a = cVar;
            this.b = z;
            this.c = i;
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(java.lang.String str) {
            if (com.anythink.expressad.reward.a.d.this.ag.get(0) != null) {
                com.anythink.expressad.reward.a.d.this.ag.size();
            }
            if (this.a.aB() != null && this.a.aB().size() > 0) {
                if (this.a.aB().contains(3)) {
                    return;
                }
                if (this.a.ar().equals(this.a.I()) && this.a.aB().contains(2)) {
                    return;
                }
            }
            com.anythink.expressad.reward.a.d.this.q = false;
            java.util.List unused = com.anythink.expressad.reward.a.d.this.ag;
            boolean unused2 = com.anythink.expressad.reward.a.d.this.U;
            if (com.anythink.expressad.reward.a.d.this.ad != null) {
                com.anythink.expressad.reward.a.d.this.ad.removeMessages(5);
            }
            if (com.anythink.expressad.reward.a.d.this.G == null || com.anythink.expressad.reward.a.d.this.t) {
                return;
            }
            com.anythink.expressad.reward.a.d.this.t = true;
            com.anythink.expressad.reward.a.d.this.G.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
        }

        @Override // com.anythink.expressad.reward.a.c.i
        public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            com.anythink.expressad.reward.a.d.this.q = true;
            if (!com.anythink.expressad.reward.a.d.this.p || com.anythink.expressad.reward.a.d.this.r || com.anythink.expressad.reward.a.d.this.ad == null) {
                boolean z = com.anythink.expressad.reward.a.d.this.p;
                boolean z2 = com.anythink.expressad.reward.a.d.this.r;
                return;
            }
            synchronized (com.anythink.expressad.reward.a.d.this.c) {
                if (com.anythink.expressad.reward.a.d.this.r) {
                    return;
                }
                com.anythink.expressad.reward.a.d.this.r = true;
                com.anythink.expressad.reward.a.d.this.ad.post(new com.anythink.expressad.reward.a.d.AnonymousClass4.AnonymousClass1(str3, str, str2));
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.d a;

        public AnonymousClass5(com.anythink.expressad.foundation.d.d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
            com.anythink.expressad.foundation.d.d dVar = this.a;
            if (dVar == null || (arrayList = dVar.J) == null || arrayList.size() <= 0) {
                return;
            }
            com.anythink.expressad.reward.a.d.a(com.anythink.expressad.reward.a.d.this, this.a.J);
        }
    }

    public static class a extends com.anythink.expressad.atsignalcommon.a.a {
        private com.anythink.expressad.reward.a.d b;
        private java.lang.String c;
        private java.lang.String d;
        private com.anythink.expressad.videocommon.a.C0231a e;
        private com.anythink.expressad.foundation.d.c f;
        private boolean g;
        private boolean h;
        private com.anythink.expressad.reward.a.d.g i;
        private android.os.Handler j;

        public a(java.lang.String str, java.lang.String str2, com.anythink.expressad.videocommon.a.C0231a c0231a, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.reward.a.d.g gVar, android.os.Handler handler) {
            this.c = str;
            this.d = str2;
            this.e = c0231a;
            if (dVar != null) {
                this.b = dVar;
            }
            this.f = cVar;
            this.i = gVar;
            this.j = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final java.lang.String a(java.lang.String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(java.lang.String str, int i, int i2) {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (this.g) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.g = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            try {
                com.anythink.expressad.reward.a.d dVar = this.b;
                if (dVar != null) {
                    synchronized (dVar) {
                        com.anythink.expressad.reward.a.d.a(this.b, str, str2);
                        this.b = null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            android.os.Handler handler;
            if (this.h) {
                return;
            }
            com.anythink.expressad.reward.a.d.g gVar = this.i;
            if (gVar != null && (handler = this.j) != null) {
                handler.removeCallbacks(gVar);
            }
            com.anythink.expressad.videocommon.b.l.a().c(this.c, true);
            com.anythink.expressad.videocommon.a.C0231a c0231a = this.e;
            if (c0231a != null) {
                c0231a.a(true);
            }
            this.h = true;
        }
    }

    public static final class b implements com.anythink.expressad.videocommon.d.b {
        private com.anythink.expressad.reward.a.d a;
        private com.anythink.expressad.foundation.d.c b;

        public b(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.foundation.d.c cVar) {
            this.a = dVar;
            this.b = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str) {
            try {
                com.anythink.expressad.videocommon.b.l.a().a(str, true);
                com.anythink.expressad.reward.a.d dVar = this.a;
                if (dVar != null) {
                    synchronized (dVar) {
                        com.anythink.expressad.reward.a.d dVar2 = this.a;
                        if (dVar2 != null && dVar2.c() && this.a.ad != null) {
                            android.os.Message obtain = android.os.Message.obtain();
                            obtain.what = 6;
                            obtain.obj = this.b;
                            this.a.ad.sendMessage(obtain);
                            this.a.ad.removeMessages(5);
                            this.a = null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str, java.lang.String str2) {
            try {
                com.anythink.expressad.reward.a.d dVar = this.a;
                if (dVar != null) {
                    synchronized (dVar) {
                        com.anythink.expressad.reward.a.d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public static final class c implements com.anythink.expressad.foundation.g.d.c {
        private com.anythink.expressad.reward.a.d a;
        private com.anythink.expressad.foundation.d.c b;
        private java.lang.String c;

        public c(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            this.a = dVar;
            this.b = cVar;
            this.c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.d$d, reason: collision with other inner class name */
    public static class C0220d implements com.anythink.expressad.videocommon.b.i.b {
        private com.anythink.expressad.foundation.d.c a;
        private java.lang.String b;
        private com.anythink.expressad.videocommon.e.d c;
        private com.anythink.expressad.reward.a.d d;

        public C0220d(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, com.anythink.expressad.videocommon.e.d dVar2) {
            this.a = cVar;
            this.b = str;
            this.c = dVar2;
            this.d = dVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            com.anythink.expressad.reward.a.d dVar = this.d;
            if (dVar != null) {
                dVar.a(this.a, str, this.b, this.c);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.reward.a.d dVar = this.d;
            if (dVar != null) {
                com.anythink.expressad.reward.a.d.a(dVar, "TemplateUrl source download failed", str);
            }
        }
    }

    public static final class e implements com.anythink.expressad.foundation.g.d.c {
        private com.anythink.expressad.reward.a.d a;
        private com.anythink.expressad.foundation.d.c b;
        private java.lang.String c;

        public e(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            this.a = dVar;
            this.b = cVar;
            this.c = str;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            try {
                com.anythink.expressad.videocommon.b.l.a();
                com.anythink.expressad.videocommon.b.l.c(str);
                com.anythink.expressad.reward.a.d dVar = this.a;
                if (dVar != null) {
                    synchronized (dVar) {
                        if (this.a.c() && this.a.ad != null) {
                            android.os.Message obtain = android.os.Message.obtain();
                            obtain.what = 6;
                            obtain.obj = this.b;
                            this.a.ad.sendMessage(obtain);
                            this.a.ad.removeMessages(5);
                            this.a = null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            try {
                com.anythink.expressad.reward.a.d dVar = this.a;
                if (dVar != null) {
                    synchronized (dVar) {
                        com.anythink.expressad.reward.a.d.a(this.a, str, str2);
                        this.a = null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public static final class f implements com.anythink.expressad.videocommon.b.i.b {
        private com.anythink.expressad.reward.a.d a;
        private com.anythink.expressad.foundation.d.c b;
        private long c = java.lang.System.currentTimeMillis();
        private java.lang.String d;
        private boolean e;

        public f(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, boolean z) {
            this.e = true;
            this.d = str;
            this.a = dVar;
            this.b = cVar;
            this.e = z;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            try {
                if (this.a.ad != null) {
                    this.b.aZ();
                    this.a.ad.removeMessages(5);
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = 8;
                    obtain.obj = this.b;
                    this.a.ad.sendMessage(obtain);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            try {
                this.b.aZ();
                com.anythink.expressad.reward.a.d dVar = this.a;
                if (dVar != null) {
                    com.anythink.expressad.reward.a.d.a(dVar, "H5 code resource download failed ", str);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public class g implements java.lang.Runnable {
        private java.lang.String b;
        private com.anythink.expressad.foundation.d.c c;
        private java.lang.String d;
        private java.lang.String e;
        private com.anythink.expressad.videocommon.e.d f;
        private int g;
        private com.anythink.expressad.reward.a.d h;

        public g(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar, int i, com.anythink.expressad.reward.a.d dVar2) {
            this.b = str;
            this.c = cVar;
            this.d = str2;
            this.e = str3;
            this.f = dVar;
            this.g = i;
            this.h = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
                c0231a.a(windVaneWebView);
                com.anythink.expressad.video.bt.a.c.a();
                java.lang.String b = com.anythink.expressad.video.bt.a.c.b();
                c0231a.a(b);
                com.anythink.expressad.video.signal.a.j jVar = (com.anythink.expressad.reward.a.d.this.Z.J == null || com.anythink.expressad.reward.a.d.this.Z.J.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.c) : new com.anythink.expressad.video.signal.a.j(null, this.c, com.anythink.expressad.reward.a.d.this.Z.J);
                jVar.a(this.g);
                jVar.a(this.e);
                jVar.c(b);
                jVar.a(this.f);
                jVar.b(com.anythink.expressad.reward.a.d.this.ab);
                windVaneWebView.setWebViewListener(new com.anythink.expressad.reward.a.d.a(this.d, this.b, c0231a, this.c, this.h, null, null));
                windVaneWebView.setObject(jVar);
                java.lang.String str = this.d;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str);
                windVaneWebView.loadUrl(str);
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public class h implements java.lang.Runnable {
        private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView b;
        private java.lang.String c;
        private com.anythink.expressad.foundation.d.c d;
        private java.util.List<com.anythink.expressad.foundation.d.c> e;
        private java.lang.String f;
        private java.lang.String g;
        private com.anythink.expressad.videocommon.e.d h;
        private int i;
        private com.anythink.expressad.reward.a.d j;

        public h(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.util.List<com.anythink.expressad.foundation.d.c> list, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar, int i, com.anythink.expressad.reward.a.d dVar2) {
            this.b = windVaneWebView;
            this.c = str;
            this.d = cVar;
            this.e = list;
            this.f = str2;
            this.g = str3;
            this.h = dVar;
            this.i = i;
            this.j = dVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
                c0231a.a(windVaneWebView);
                java.util.List<com.anythink.expressad.foundation.d.c> list = this.e;
                com.anythink.expressad.video.signal.a.j jVar = (list == null || list.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, this.d) : new com.anythink.expressad.video.signal.a.j(null, this.d, this.e);
                jVar.a(this.i);
                jVar.a(this.g);
                jVar.a(this.h);
                jVar.b(com.anythink.expressad.reward.a.d.this.ab);
                windVaneWebView.setWebViewListener(new com.anythink.expressad.reward.a.d.j(this.b, this.f, this.c, c0231a, this.d, this.j, null, null));
                windVaneWebView.setObject(jVar);
                java.lang.String str = this.f;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str);
                windVaneWebView.loadUrl(str);
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public static final class i implements com.anythink.expressad.videocommon.b.i.d {
        public static final int a = 497;
        public static final int b = 859;
        public static final int c = 313;
        public static final int d = 502;
        private com.anythink.expressad.foundation.d.c e;
        private com.anythink.expressad.reward.a.d f;
        private long g = java.lang.System.currentTimeMillis();
        private java.lang.String h;
        private int i;
        private com.anythink.expressad.videocommon.e.d j;
        private boolean k;

        public i(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.reward.a.d dVar, java.lang.String str, int i, com.anythink.expressad.videocommon.e.d dVar2, boolean z) {
            this.i = 0;
            this.k = true;
            this.h = str;
            this.e = cVar;
            this.i = i;
            this.j = dVar2;
            this.f = dVar;
            this.k = z;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            android.content.Context context;
            try {
                com.anythink.expressad.videocommon.b.l.a().b(str, true);
                long currentTimeMillis = java.lang.System.currentTimeMillis() - this.g;
                int i = this.i;
                if (i == 497) {
                    if (this.k) {
                        com.anythink.expressad.foundation.d.r rVar = new com.anythink.expressad.foundation.d.r(com.anythink.expressad.foundation.d.r.k, 14, java.lang.String.valueOf(currentTimeMillis), str, this.e.aZ(), this.h, "", "1");
                        rVar.d(this.e.Z());
                        rVar.e(this.e.aa());
                        rVar.g(this.e.aZ());
                        rVar.b(this.e.f());
                        if (this.e.w() == 287) {
                            rVar.a("3");
                        } else if (this.e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (i == 859) {
                    com.anythink.expressad.foundation.d.r rVar2 = new com.anythink.expressad.foundation.d.r();
                    rVar2.h(com.anythink.expressad.foundation.d.r.m);
                    if (this.f != null) {
                        if (android.text.TextUtils.isEmpty(this.e.ar())) {
                            this.f.a(this.e, str, this.h, this.j);
                        }
                        android.content.Context context2 = this.f.v;
                        if (context2 != null) {
                            context2.getApplicationContext();
                            rVar2.c(com.anythink.expressad.foundation.h.k.a());
                        }
                    }
                    rVar2.d(1);
                    com.anythink.expressad.foundation.d.c cVar = this.e;
                    if (cVar != null) {
                        rVar2.g(cVar.aZ());
                        rVar2.d(this.e.Z());
                        rVar2.e(this.e.aa());
                    }
                    rVar2.b(str);
                    rVar2.i("");
                    rVar2.f(this.h);
                } else if (i == 502) {
                    com.anythink.expressad.foundation.d.r rVar3 = new com.anythink.expressad.foundation.d.r();
                    rVar3.h(com.anythink.expressad.foundation.d.r.m);
                    com.anythink.expressad.reward.a.d dVar = this.f;
                    if (dVar != null && (context = dVar.v) != null) {
                        context.getApplicationContext();
                        rVar3.c(com.anythink.expressad.foundation.h.k.a());
                    }
                    rVar3.d(1);
                    com.anythink.expressad.foundation.d.c cVar2 = this.e;
                    if (cVar2 != null) {
                        rVar3.g(cVar2.aZ());
                        rVar3.d(this.e.Z());
                        rVar3.e(this.e.aa());
                    }
                    rVar3.b(str);
                    rVar3.i("");
                    rVar3.f(this.h);
                } else if (i == 313) {
                    return;
                }
                com.anythink.expressad.reward.a.d dVar2 = this.f;
                if (dVar2 != null) {
                    synchronized (dVar2) {
                        if (this.f.c() && this.f.ad != null) {
                            this.f.ad.sendEmptyMessage(6);
                            this.f.ad.removeMessages(5);
                            this.f = null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            android.content.Context context;
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis() - this.g;
                int i = this.i;
                if (i == 497) {
                    if (this.k) {
                        com.anythink.expressad.foundation.d.r rVar = new com.anythink.expressad.foundation.d.r(com.anythink.expressad.foundation.d.r.k, 3, java.lang.String.valueOf(currentTimeMillis), str2, this.e.aZ(), this.h, "zip download failed", "1");
                        rVar.d(this.e.Z());
                        rVar.e(this.e.aa());
                        rVar.g(this.e.aZ());
                        rVar.b(this.e.f());
                        if (this.e.w() == 287) {
                            rVar.a("3");
                        } else if (this.e.w() == 94) {
                            rVar.a("1");
                        }
                    }
                } else if (i == 859) {
                    com.anythink.expressad.foundation.d.r rVar2 = new com.anythink.expressad.foundation.d.r();
                    rVar2.h(com.anythink.expressad.foundation.d.r.m);
                    com.anythink.expressad.reward.a.d dVar = this.f;
                    if (dVar != null && (context = dVar.v) != null) {
                        context.getApplicationContext();
                        rVar2.c(com.anythink.expressad.foundation.h.k.a());
                    }
                    rVar2.d(3);
                    com.anythink.expressad.foundation.d.c cVar = this.e;
                    if (cVar != null) {
                        rVar2.g(cVar.aZ());
                        rVar2.d(this.e.Z());
                        rVar2.e(this.e.aa());
                    }
                    rVar2.b(str2);
                    rVar2.i(str);
                    rVar2.f(this.h);
                } else if (i == 313) {
                    return;
                }
                com.anythink.expressad.reward.a.d dVar2 = this.f;
                if (dVar2 != null) {
                    com.anythink.expressad.reward.a.d.a(dVar2, str, str2);
                }
            } catch (java.lang.Exception e) {
                try {
                    com.anythink.expressad.reward.a.d dVar3 = this.f;
                    if (dVar3 != null) {
                        dVar3.b("clear error info failed");
                    }
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
                e.getMessage();
            }
            if (this.f != null) {
                this.f = null;
            }
        }
    }

    public static class j extends com.anythink.expressad.atsignalcommon.a.b {
        public static final int a = 0;
        public static final int b = 1;
        private com.anythink.expressad.reward.a.d c;
        private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView e;
        private java.lang.String f;
        private java.lang.String g;
        private com.anythink.expressad.videocommon.a.C0231a h;
        private com.anythink.expressad.foundation.d.c i;
        private boolean j;
        private boolean k;
        private com.anythink.expressad.reward.a.d.h l;
        private android.os.Handler m;

        public j(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, java.lang.String str2, com.anythink.expressad.videocommon.a.C0231a c0231a, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.reward.a.d.h hVar, android.os.Handler handler) {
            this.e = windVaneWebView;
            this.f = str;
            this.g = str2;
            this.h = c0231a;
            if (dVar != null) {
                this.c = dVar;
            }
            this.i = cVar;
            this.l = hVar;
            this.m = handler;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (this.j) {
                return;
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.j = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            try {
                com.anythink.expressad.reward.a.d dVar = this.c;
                if (dVar != null) {
                    synchronized (dVar) {
                        com.anythink.expressad.reward.a.d.a(this.c, str, str2);
                        this.c = null;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            android.os.Handler handler;
            if (this.k) {
                return;
            }
            com.anythink.expressad.reward.a.d.h hVar = this.l;
            if (hVar != null && (handler = this.m) != null) {
                handler.removeCallbacks(hVar);
            }
            java.lang.String str = this.g + "_" + this.f;
            com.anythink.expressad.videocommon.a.C0231a c0231a = this.h;
            if (c0231a != null) {
                c0231a.a(true);
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("type", 1);
                jSONObject.put("id", str);
                jSONObject.put("unitid", this.g);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            com.anythink.expressad.videocommon.b.l.a().c(this.f, true);
            com.anythink.expressad.reward.a.d dVar = this.c;
            if (dVar == null || !dVar.T) {
                if (this.i.A()) {
                    com.anythink.expressad.videocommon.a.a(94, this.i.aa(), this.h);
                }
            } else if (this.i.A()) {
                com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.i.aa(), this.h);
            }
            try {
                com.anythink.expressad.reward.a.d dVar2 = this.c;
                if (dVar2 != null) {
                    synchronized (dVar2) {
                        com.anythink.expressad.reward.a.d dVar3 = this.c;
                        if (dVar3 != null && dVar3.c() && this.c.ad != null) {
                            android.os.Message obtain = android.os.Message.obtain();
                            obtain.what = 6;
                            obtain.obj = this.i;
                            this.c.ad.sendMessage(obtain);
                            this.c.ad.removeMessages(5);
                            this.c = null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            this.k = true;
        }
    }

    public d(android.content.Context context, java.lang.String str, java.lang.String str2) {
        try {
            this.v = context.getApplicationContext();
            this.w = str2;
            this.x = str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.util.List<com.anythink.expressad.foundation.d.c> list, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            c0231a.a(windVaneWebView2);
            com.anythink.expressad.video.signal.a.j jVar = (list == null || list.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            jVar.a(this.S);
            jVar.a(str3);
            jVar.a(dVar);
            jVar.b(this.ab);
            com.anythink.expressad.reward.a.d.h hVar = new com.anythink.expressad.reward.a.d.h(windVaneWebView, str3, cVar, list, str2, str3, dVar, this.S, this);
            windVaneWebView2.setWebViewListener(new com.anythink.expressad.reward.a.d.j(windVaneWebView, str, str3, c0231a, cVar, this, hVar, this.ad));
            windVaneWebView2.setObject(jVar);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str2);
            windVaneWebView2.loadUrl(str2);
            this.ad.postDelayed(hVar, 5000L);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.lang.String c2 = com.anythink.expressad.videocommon.b.i.a().c(str);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 16;
            obtain.obj = new java.lang.Object[]{cVar, c2, str2, dVar, str};
            android.os.Handler handler = this.ad;
            if (handler != null) {
                handler.sendMessage(obtain);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.reward.a.d dVar, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.util.List list, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            c0231a.a(windVaneWebView2);
            com.anythink.expressad.video.signal.a.j jVar = (list == null || list.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, list);
            jVar.a(dVar.S);
            jVar.a(str3);
            jVar.a(dVar2);
            jVar.b(dVar.ab);
            com.anythink.expressad.reward.a.d.h hVar = dVar.new h(windVaneWebView, str3, cVar, list, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView2.setWebViewListener(new com.anythink.expressad.reward.a.d.j(windVaneWebView, str, str3, c0231a, cVar, dVar, hVar, dVar.ad));
            windVaneWebView2.setObject(jVar);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str2);
            windVaneWebView2.loadUrl(str2);
            dVar.ad.postDelayed(hVar, 5000L);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.reward.a.d dVar, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar2) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            c0231a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            java.lang.String b2 = com.anythink.expressad.video.bt.a.c.b();
            c0231a.a(b2);
            com.anythink.expressad.foundation.d.d dVar3 = dVar.Z;
            com.anythink.expressad.video.signal.a.j jVar = (dVar3 == null || (arrayList = dVar3.J) == null || arrayList.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, dVar.Z.J);
            jVar.a(dVar.S);
            jVar.a(str3);
            jVar.c(b2);
            jVar.a(dVar2);
            jVar.b(dVar.ab);
            com.anythink.expressad.reward.a.d.g gVar = dVar.new g(str3, cVar, str2, str3, dVar2, dVar.S, dVar);
            windVaneWebView.setWebViewListener(new com.anythink.expressad.reward.a.d.a(str, str3, c0231a, cVar, dVar, gVar, dVar.ad));
            windVaneWebView.setObject(jVar);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str2);
            windVaneWebView.loadUrl(str2);
            dVar.ad.postDelayed(gVar, 5000L);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.reward.a.d dVar, java.lang.String str, java.lang.String str2) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList;
        java.util.List<java.lang.String> list;
        try {
            if (dVar.R == null || android.text.TextUtils.isEmpty(str2)) {
                if (dVar.G != null) {
                    android.os.Handler handler = dVar.ad;
                    if (handler != null) {
                        handler.removeMessages(5);
                    }
                    dVar.b(str);
                    dVar.G.a(str);
                    return;
                }
                return;
            }
            java.util.Iterator<com.anythink.expressad.foundation.d.c> it = dVar.R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.foundation.d.c next = it.next();
                if (next != null) {
                    java.lang.String S = next.S();
                    if (!android.text.TextUtils.isEmpty(S) && str2.equals(S)) {
                        dVar.R.remove(next);
                        break;
                    }
                    java.lang.String I = next.I();
                    if (!android.text.TextUtils.isEmpty(I) && str2.equals(I)) {
                        dVar.R.remove(next);
                        break;
                    }
                    com.anythink.expressad.foundation.d.c.C0208c M2 = next.M();
                    if (M2 != null) {
                        java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f2 = M2.f();
                        if (f2 != null) {
                            java.util.Iterator<com.anythink.expressad.foundation.d.c.C0208c.a> it2 = f2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                com.anythink.expressad.foundation.d.c.C0208c.a next2 = it2.next();
                                if (next2 != null && (list = next2.b) != null && list.contains(str2)) {
                                    dVar.R.remove(next);
                                    break;
                                }
                            }
                        }
                        java.lang.String e2 = M2.e();
                        if (!android.text.TextUtils.isEmpty(e2) && str2.equals(e2)) {
                            dVar.R.remove(next);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (dVar.G == null || (copyOnWriteArrayList = dVar.R) == null || copyOnWriteArrayList.size() != 0) {
                return;
            }
            android.os.Handler handler2 = dVar.ad;
            if (handler2 != null) {
                handler2.removeMessages(5);
            }
            dVar.b(str);
            dVar.G.a(str);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            try {
                if (dVar.G != null) {
                    android.os.Handler handler3 = dVar.ad;
                    if (handler3 != null) {
                        handler3.removeMessages(5);
                    }
                    dVar.b(str);
                }
            } catch (java.lang.Throwable th2) {
                th2.getMessage();
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.reward.a.d dVar, java.util.List list) {
        if (dVar.v == null || list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) list.get(i2);
            if (cVar != null) {
                com.anythink.expressad.foundation.h.t.a(dVar.v, cVar.ba());
            }
        }
    }

    private void a(java.lang.Runnable runnable) {
        this.H = runnable;
    }

    private void a(java.lang.String str) {
        this.V = str;
    }

    private void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            c0231a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            java.lang.String b2 = com.anythink.expressad.video.bt.a.c.b();
            c0231a.a(b2);
            com.anythink.expressad.foundation.d.d dVar2 = this.Z;
            com.anythink.expressad.video.signal.a.j jVar = (dVar2 == null || (arrayList = dVar2.J) == null || arrayList.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, this.Z.J);
            jVar.a(this.S);
            jVar.a(str3);
            jVar.c(b2);
            jVar.a(dVar);
            jVar.b(this.ab);
            com.anythink.expressad.reward.a.d.g gVar = new com.anythink.expressad.reward.a.d.g(str3, cVar, str2, str3, dVar, this.S, this);
            windVaneWebView.setWebViewListener(new com.anythink.expressad.reward.a.d.a(str, str3, c0231a, cVar, this, gVar, this.ad));
            windVaneWebView.setObject(jVar);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str2);
            windVaneWebView.loadUrl(str2);
            this.ad.postDelayed(gVar, 5000L);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList;
        java.util.List<java.lang.String> list;
        try {
            if (this.R == null || android.text.TextUtils.isEmpty(str2)) {
                if (this.G != null) {
                    android.os.Handler handler = this.ad;
                    if (handler != null) {
                        handler.removeMessages(5);
                    }
                    b(str);
                    this.G.a(str);
                    return;
                }
                return;
            }
            java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.anythink.expressad.foundation.d.c next = it.next();
                if (next != null) {
                    java.lang.String S = next.S();
                    if (!android.text.TextUtils.isEmpty(S) && str2.equals(S)) {
                        this.R.remove(next);
                        break;
                    }
                    java.lang.String I = next.I();
                    if (!android.text.TextUtils.isEmpty(I) && str2.equals(I)) {
                        this.R.remove(next);
                        break;
                    }
                    com.anythink.expressad.foundation.d.c.C0208c M2 = next.M();
                    if (M2 != null) {
                        java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f2 = M2.f();
                        if (f2 != null) {
                            java.util.Iterator<com.anythink.expressad.foundation.d.c.C0208c.a> it2 = f2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                com.anythink.expressad.foundation.d.c.C0208c.a next2 = it2.next();
                                if (next2 != null && (list = next2.b) != null && list.contains(str2)) {
                                    this.R.remove(next);
                                    break;
                                }
                            }
                        }
                        java.lang.String e2 = M2.e();
                        if (!android.text.TextUtils.isEmpty(e2) && str2.equals(e2)) {
                            this.R.remove(next);
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (this.G == null || (copyOnWriteArrayList = this.R) == null || copyOnWriteArrayList.size() != 0) {
                return;
            }
            android.os.Handler handler2 = this.ad;
            if (handler2 != null) {
                handler2.removeMessages(5);
            }
            b(str);
            this.G.a(str);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            try {
                if (this.G != null) {
                    android.os.Handler handler3 = this.ad;
                    if (handler3 != null) {
                        handler3.removeMessages(5);
                    }
                    b(str);
                }
            } catch (java.lang.Throwable th2) {
                th2.getMessage();
            }
        }
    }

    public static /* synthetic */ void a(java.lang.String str, java.util.List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        list.size();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) it.next();
            if (cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + "_" + cVar.aZ() + "_" + cVar.Z() + "_" + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    private void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (this.v == null || list == null || list.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.anythink.expressad.foundation.d.c cVar = list.get(i2);
            if (cVar != null) {
                com.anythink.expressad.foundation.h.t.a(this.v, cVar.ba());
            }
        }
    }

    private void a(java.util.List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar) {
        if (list != null) {
            try {
                java.util.Iterator<com.anythink.expressad.foundation.d.c> it = list.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.foundation.d.c next = it.next();
                    boolean z = true;
                    boolean z2 = next != null;
                    if (next.M() == null) {
                        z = false;
                    }
                    if ((z & z2) && !android.text.TextUtils.isEmpty(next.M().e())) {
                        a(next, next.M().e(), this.w, dVar);
                    }
                    if (!android.text.TextUtils.isEmpty(next.ar())) {
                        a(next, next.ar(), this.w, dVar);
                    }
                }
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        try {
            if (com.anythink.expressad.videocommon.a.a.a() == null) {
                return true;
            }
            com.anythink.expressad.videocommon.a.a.a();
            return com.anythink.expressad.videocommon.a.a.a(cVar);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private static boolean a(java.util.List<com.anythink.expressad.foundation.d.c> list, java.lang.String str, boolean z, int i2) {
        if (list != null && list.size() > 0) {
            com.anythink.expressad.foundation.d.c cVar = list.get(0);
            if (com.anythink.expressad.videocommon.b.e.a().b(str, false, list.size(), z, i2, list)) {
                if (!z) {
                    if (cVar != null && cVar.j()) {
                        return true;
                    }
                    if ((cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) && cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                        if (com.anythink.expressad.videocommon.b.l.a().d(str + "_" + cVar.Z() + "_" + cVar.M().e())) {
                        }
                    }
                    return true;
                }
                if (cVar.j()) {
                    return true;
                }
                if (cVar.aB() != null && cVar.aB().size() > 0) {
                    if (cVar.aB().contains(3)) {
                        return true;
                    }
                    if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                        return true;
                    }
                }
                if (com.anythink.expressad.videocommon.b.l.a().d(str + "_" + cVar.Z() + "_" + cVar.ar())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, com.anythink.expressad.videocommon.e.d dVar) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.lang.Object[] objArr = new java.lang.Object[5];
            if (!str.contains("zip") || this.ad == null) {
                return;
            }
            java.lang.String c2 = com.anythink.expressad.videocommon.b.i.a().c(str);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 17;
            objArr[0] = cVar;
            objArr[1] = c2;
            objArr[2] = str2;
            objArr[3] = dVar;
            objArr[4] = str;
            obtain.obj = objArr;
            this.ad.sendMessage(obtain);
        } catch (java.lang.Exception unused) {
        }
    }

    private void b(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        try {
            this.Z = dVar;
            this.Z.f();
            com.anythink.expressad.foundation.d.d dVar2 = this.Z;
            if (dVar2 != null && (arrayList = dVar2.J) != null) {
                arrayList.size();
            }
            c(this.Z);
            this.m = this.Z.f();
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.ag;
            if (list != null) {
                list.clear();
            }
            this.p = false;
            this.q = false;
            synchronized (this.c) {
                if (this.r) {
                    this.r = false;
                }
                this.t = false;
                this.f255s = false;
                b("exception after load success");
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        if (this.ad != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                this.ad.sendEmptyMessage(4);
                return;
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 4;
            obtain.obj = str;
            if (str.contains("exception")) {
                this.ad.sendMessageAtFrontOfQueue(obtain);
            } else {
                this.ad.sendMessage(obtain);
            }
        }
    }

    private static void b(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        list.size();
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                com.anythink.expressad.videocommon.a.b(str + "_" + cVar.aZ() + "_" + cVar.Z() + "_" + cVar.M().e());
                com.anythink.expressad.videocommon.a.b(cVar.w(), cVar);
            }
        }
    }

    private void b(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                if (!android.text.TextUtils.isEmpty(cVar.P())) {
                    com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
                }
                if (cVar.M() != null) {
                    com.anythink.expressad.foundation.d.c.C0208c M2 = cVar.M();
                    if (!android.text.TextUtils.isEmpty(M2.d())) {
                        if (M2.d().contains(".zip")) {
                            com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 313, this.I, false));
                        } else {
                            com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (com.anythink.expressad.videocommon.b.i.a) null);
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(M2.e()) && !M2.e().contains(com.anythink.expressad.foundation.d.c.d)) {
                        if (M2.e().contains(".zip")) {
                            com.anythink.expressad.videocommon.b.i.a().b(M2.e(), (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 859, this.I, false));
                        } else {
                            com.anythink.expressad.videocommon.b.i.a().b(M2.e(), new com.anythink.expressad.reward.a.d.C0220d(this, cVar, this.w, this.I));
                        }
                    }
                }
            }
        }
    }

    private boolean b(com.anythink.expressad.foundation.d.c cVar) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
            while (it.hasNext()) {
                if (it.next().aZ().equals(cVar.aZ())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(java.util.List<com.anythink.expressad.foundation.d.c> list, boolean z, int i2) {
        if (list != null && list.size() > 0) {
            com.anythink.expressad.foundation.d.c cVar = list.get(0);
            if (com.anythink.expressad.videocommon.b.e.a().b(this.w, this.U, list.size(), z, i2, list)) {
                if (!z) {
                    if (cVar != null && cVar.j()) {
                        return true;
                    }
                    if ((cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) && cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                        if (com.anythink.expressad.videocommon.b.l.a().d(this.w + "_" + cVar.Z() + "_" + cVar.M().e())) {
                        }
                    }
                    return true;
                }
                if (cVar.j()) {
                    return true;
                }
                if (cVar.aB() != null && cVar.aB().size() > 0) {
                    if (cVar.aB().contains(3)) {
                        return true;
                    }
                    if (cVar.ar().equals(cVar.I()) && cVar.aB().contains(2)) {
                        return true;
                    }
                }
                if (com.anythink.expressad.videocommon.b.l.a().d(this.w + "_" + cVar.Z() + "_" + cVar.ar())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(cVar.P())) {
            com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
        }
        if (cVar.M() != null) {
            com.anythink.expressad.foundation.d.c.C0208c M2 = cVar.M();
            if (!android.text.TextUtils.isEmpty(M2.d())) {
                if (M2.d().contains(".zip")) {
                    com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 313, this.I, false));
                } else {
                    com.anythink.expressad.videocommon.b.i.a().b(M2.d(), (com.anythink.expressad.videocommon.b.i.a) null);
                }
            }
            if (android.text.TextUtils.isEmpty(M2.e()) || M2.e().contains(com.anythink.expressad.foundation.d.c.d)) {
                return;
            }
            if (M2.e().contains(".zip")) {
                com.anythink.expressad.videocommon.b.i.a().b(M2.e(), (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 859, this.I, false));
            } else {
                com.anythink.expressad.videocommon.b.i.a().b(M2.e(), new com.anythink.expressad.reward.a.d.C0220d(this, cVar, this.w, this.I));
            }
        }
    }

    private void c(com.anythink.expressad.foundation.d.d dVar) {
        this.Z = dVar;
        dVar.J.size();
        this.aa = d(dVar);
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.reward.a.d.AnonymousClass5(dVar));
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            if (android.text.TextUtils.isEmpty(this.af)) {
                this.af = b;
            }
            b(this.af);
            return;
        }
        this.aa.size();
        android.os.Handler handler = this.ad;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
        java.lang.String c2 = dVar.c();
        if (com.anythink.expressad.foundation.h.w.b(c2)) {
            com.anythink.expressad.reward.b.a.b = c2;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
        if (copyOnWriteArrayList2 != null) {
            try {
                if (copyOnWriteArrayList2.size() > 0) {
                    this.y += copyOnWriteArrayList2.size();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        com.anythink.expressad.videocommon.e.d dVar2 = this.I;
        if (dVar2 == null || this.y > dVar2.D()) {
            this.y = 0;
        }
        if (com.anythink.expressad.foundation.h.w.b(this.w)) {
            com.anythink.expressad.reward.b.a.a(this.w, this.y);
        }
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList3 = this.aa;
        if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
            this.aa.size();
        }
        com.anythink.expressad.foundation.d.c cVar = this.aa.get(0);
        boolean z = !android.text.TextUtils.isEmpty(cVar.ar());
        int ap = cVar.ap();
        this.p = false;
        this.q = false;
        synchronized (this.c) {
            if (this.r) {
                this.r = false;
            }
        }
        this.t = false;
        this.f255s = false;
        com.anythink.expressad.reward.a.c.m.a.a(this.v, z, ap, this.U, this.T ? com.anythink.expressad.foundation.g.a.aU : 94, this.x, this.w, cVar.Z(), this.aa, new com.anythink.expressad.reward.a.d.AnonymousClass2(z, cVar, ap), new com.anythink.expressad.reward.a.d.AnonymousClass3(z, cVar, ap));
        if (z) {
            com.anythink.expressad.reward.a.c.m.a.a(this.v, cVar, this.x, this.w, cVar.Z(), new com.anythink.expressad.reward.a.d.AnonymousClass4(cVar, z, ap));
        }
    }

    private static void c(java.lang.String str) {
        if (com.anythink.expressad.foundation.h.w.b(str)) {
            com.anythink.expressad.reward.b.a.b = str;
        }
    }

    private void c(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            java.lang.String I = cVar.I();
            if (!android.text.TextUtils.isEmpty(I) && !cVar.H()) {
                if (I.contains(".zip") && I.contains(com.anythink.expressad.videocommon.b.m.b)) {
                    com.anythink.expressad.videocommon.b.i.a().b(I, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 497, this.I, android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(I))));
                } else {
                    com.anythink.expressad.videocommon.b.i.a().b(I, new com.anythink.expressad.reward.a.d.f(this, cVar, this.w, android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(I))));
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x014a, code lost:
    
        if (com.anythink.expressad.foundation.h.w.a(r3.S()) != false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> d(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        boolean z;
        java.io.File file;
        java.io.File file2;
        java.io.FileOutputStream fileOutputStream;
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList<>();
        try {
            com.anythink.expressad.videocommon.e.d dVar2 = this.I;
            if (dVar2 != null) {
                dVar2.A();
            }
            if (dVar != null && (arrayList = dVar.J) != null && arrayList.size() > 0) {
                java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList2 = dVar.J;
                this.ag = arrayList2;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList3 = dVar.J;
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        com.anythink.expressad.foundation.d.c cVar = arrayList3.get(i2);
                        cVar.l(this.w);
                        arrayList3.set(i2, cVar);
                    }
                }
                for (int i3 = 0; i3 < arrayList2.size() && i3 < Integer.MAX_VALUE; i3++) {
                    com.anythink.expressad.foundation.d.c cVar2 = arrayList2.get(i3);
                    if (cVar2.H()) {
                        if (!android.text.TextUtils.isEmpty(cVar2.G().trim())) {
                            if (cVar2.w() != 287 && cVar2.w() != 94) {
                                cVar2.w();
                            }
                            java.io.FileOutputStream fileOutputStream2 = null;
                            try {
                                try {
                                    java.lang.String b2 = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                                    java.lang.String a2 = com.anythink.expressad.foundation.h.p.a(cVar2.G());
                                    if (android.text.TextUtils.isEmpty(a2)) {
                                        a2 = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                                    }
                                    file2 = new java.io.File(b2, a2.concat(".html"));
                                    fileOutputStream = new java.io.FileOutputStream(file2);
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                }
                            } catch (java.lang.Exception e2) {
                                e = e2;
                            }
                            try {
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("<script>");
                                com.anythink.expressad.d.b.a.a();
                                sb.append(com.anythink.expressad.d.b.a.b());
                                sb.append("</script>");
                                sb.append(cVar2.G());
                                fileOutputStream.write(sb.toString().getBytes());
                                fileOutputStream.flush();
                                cVar2.j(file2.getAbsolutePath());
                                fileOutputStream.close();
                            } catch (java.lang.Exception e3) {
                                e = e3;
                                fileOutputStream2 = fileOutputStream;
                                e.printStackTrace();
                                cVar2.j("");
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                file = new java.io.File(cVar2.G());
                                if (file.exists()) {
                                }
                                b("mraid resource write fail");
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                throw th;
                            }
                            file = new java.io.File(cVar2.G());
                            if (file.exists() || !file.isFile() || !file.canRead()) {
                                b("mraid resource write fail");
                            }
                        }
                    }
                    if (cVar2.O() != 99) {
                        if (e(cVar2)) {
                            z = (com.anythink.expressad.foundation.h.w.a(cVar2.I()) && android.text.TextUtils.isEmpty(cVar2.G())) ? false : true;
                        }
                        if (z) {
                            if (com.anythink.expressad.foundation.h.t.a(cVar2)) {
                                cVar2.i(com.anythink.expressad.foundation.h.t.a(this.v, cVar2.ba()) ? 1 : 2);
                            }
                            if (cVar2.ae() != 1 && com.anythink.expressad.foundation.h.t.a(this.v, cVar2.ba())) {
                                if (com.anythink.expressad.foundation.h.t.a(cVar2)) {
                                    copyOnWriteArrayList.add(cVar2);
                                } else {
                                    this.af = a;
                                }
                            }
                            copyOnWriteArrayList.add(cVar2);
                        } else {
                            this.af = "No video campaign";
                        }
                    }
                }
                copyOnWriteArrayList.size();
            }
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null || android.text.TextUtils.isEmpty(cVar.ar())) {
            return;
        }
        java.lang.String ar = cVar.ar();
        com.anythink.expressad.videocommon.b.i.a().b(ar, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.d.i(cVar, this, this.w, 502, this.I, android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(ar))));
    }

    private void d(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (!android.text.TextUtils.isEmpty(cVar.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.bd(), new com.anythink.expressad.reward.a.d.c(this, cVar, this.w));
            }
            if (!android.text.TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(cVar.be(), new com.anythink.expressad.reward.a.d.c(this, cVar, this.w));
            }
        }
    }

    private void e(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.core.common.o.b.b.a().a(new com.anythink.expressad.reward.a.d.AnonymousClass5(dVar));
    }

    private void e(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f2;
        java.util.List<java.lang.String> list2;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (com.anythink.expressad.foundation.d.c cVar : list) {
                        if (cVar.M() != null && cVar.M().f() != null && (f2 = cVar.M().f()) != null) {
                            for (com.anythink.expressad.foundation.d.c.C0208c.a aVar : f2) {
                                if (aVar != null && (list2 = aVar.b) != null) {
                                    for (java.lang.String str : list2) {
                                        if (com.anythink.expressad.foundation.h.w.b(str)) {
                                            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(str, new com.anythink.expressad.reward.a.d.e(this, cVar, this.w));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static boolean e(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        try {
            return cVar.J() == 2;
        } catch (java.lang.Throwable th) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private void f(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    list.size();
                    this.R.clear();
                    this.R.addAll(list);
                    com.anythink.expressad.videocommon.b.l.a().a(list);
                    if (com.anythink.expressad.videocommon.b.e.a() != null) {
                        com.anythink.expressad.videocommon.b.e.a().a(this.w, list, 94, new com.anythink.expressad.reward.a.d.b(this, list.get(0)));
                        com.anythink.expressad.videocommon.b.e.a().d(this.w);
                    }
                }
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
    }

    private void g() {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        this.R.clear();
    }

    private void g(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.y += list.size();
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.anythink.expressad.videocommon.e.d dVar = this.I;
        if (dVar == null || this.y > dVar.D()) {
            this.y = 0;
        }
        if (com.anythink.expressad.foundation.h.w.b(this.w)) {
            com.anythink.expressad.reward.b.a.a(this.w, this.y);
        }
    }

    private int h() {
        return this.S;
    }

    private void h(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.ah = list;
    }

    private static void i() {
    }

    private static void j() {
    }

    private void k() {
        android.os.Handler handler = this.ad;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    private static void o() {
    }

    private static void p() {
    }

    private int q() {
        try {
            int a2 = com.anythink.expressad.foundation.h.w.b(this.w) ? com.anythink.expressad.reward.b.a.a(this.w) : 0;
            com.anythink.expressad.videocommon.e.d dVar = this.I;
            if (dVar == null) {
                return 0;
            }
            if (a2 > dVar.D()) {
                return 0;
            }
            return a2;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void r() {
        try {
            if (com.anythink.expressad.foundation.h.w.b(this.w)) {
                com.anythink.expressad.reward.b.a.a(this.w, 0);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private static java.lang.String s() {
        try {
            return com.anythink.expressad.foundation.h.w.b(com.anythink.expressad.reward.b.a.b) ? com.anythink.expressad.reward.b.a.b : "";
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static java.lang.String t() {
        return "";
    }

    private static void u() {
        try {
            java.util.Map<java.lang.String, java.lang.Long> map = com.anythink.expressad.foundation.g.a.f.h;
            if (map == null || map.size() <= 0) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.h.clear();
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    private static void v() {
    }

    private static /* synthetic */ void w() {
    }

    private static /* synthetic */ void x() {
    }

    public final void a(int i2) {
        this.S = i2;
    }

    public final void a(int i2, int i3, int i4) {
        this.W = i2;
        this.X = i3;
        this.Y = i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.content.Context] */
    public final void a(android.app.Activity activity, com.anythink.expressad.video.bt.module.b.h hVar, java.lang.String str, java.lang.String str2, int i2, java.lang.String str3, com.anythink.core.common.f.m mVar) {
        try {
            this.F = hVar;
            if (this.v != null && !com.anythink.expressad.foundation.h.w.a(this.w)) {
                ?? r4 = this.v;
                if (activity == null || activity.isFinishing()) {
                    activity = r4;
                }
                android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.anythink.expressad.reward.player.ATRewardVideoActivity.class);
                if (!(activity instanceof android.app.Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.a, this.w);
                intent.putExtra(com.anythink.expressad.a.y, this.x);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.c, str);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.d, i2);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.e, this.T);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.f, this.U);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.l, str3);
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.m, mVar);
                java.util.List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(this.w);
                boolean z = false;
                a2.get(0).Z();
                if (a2.size() > 0) {
                    a2.size();
                    com.anythink.expressad.foundation.d.c cVar = a2.get(0);
                    if (cVar != null) {
                        this.n = cVar.Z();
                    }
                    if (cVar != null && !android.text.TextUtils.isEmpty(cVar.ar())) {
                        z = true;
                    }
                } else {
                    com.anythink.expressad.video.bt.module.b.h hVar2 = this.F;
                    if (hVar2 != null) {
                        hVar2.a("load failed");
                        return;
                    }
                }
                intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.g, z);
                if (this.T) {
                    intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.i, this.W);
                    intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.j, this.X);
                    intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.k, this.Y);
                }
                if (!android.text.TextUtils.isEmpty(str2)) {
                    intent.putExtra(com.anythink.expressad.reward.player.ATRewardVideoActivity.b, str2);
                }
                com.anythink.expressad.reward.a.e.a.a.a(this.x, this.w, this.I);
                activity.startActivity(intent);
                return;
            }
            com.anythink.expressad.video.bt.module.b.h hVar3 = this.F;
            if (hVar3 != null) {
                hVar3.a("context or unitid is null");
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.anythink.expressad.video.bt.module.b.h hVar4 = this.F;
            if (hVar4 != null) {
                hVar4.a("show failed, exception is " + e2.getMessage());
            }
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        this.z = 1;
        this.B = 8;
        this.C = true;
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.ag;
        if (list != null) {
            list.clear();
        }
        this.p = false;
        this.q = false;
        synchronized (this.c) {
            if (this.r) {
                this.r = false;
            }
        }
        this.t = false;
        this.f255s = false;
        if (this.v == null) {
            b("Context is null");
            return;
        }
        if (com.anythink.expressad.foundation.h.w.a(this.w)) {
            b("UnitId is null");
            return;
        }
        if (this.I == null) {
            b("RewardUnitSetting is null");
            return;
        }
        try {
            java.util.Map<java.lang.String, java.lang.Long> map = com.anythink.expressad.foundation.g.a.f.h;
            if (map != null && map.size() > 0) {
                com.anythink.expressad.foundation.g.a.f.h.clear();
            }
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
        try {
            this.Z = dVar;
            this.Z.f();
            com.anythink.expressad.foundation.d.d dVar2 = this.Z;
            if (dVar2 != null && (arrayList = dVar2.J) != null) {
                arrayList.size();
            }
            c(this.Z);
            this.m = this.Z.f();
        } catch (java.lang.Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.printStackTrace();
            }
            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = this.aa;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
            java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.ag;
            if (list2 != null) {
                list2.clear();
            }
            this.p = false;
            this.q = false;
            synchronized (this.c) {
                if (this.r) {
                    this.r = false;
                }
                this.t = false;
                this.f255s = false;
                b("exception after load success");
                r();
            }
        }
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void a(com.anythink.expressad.reward.a.b bVar) {
        this.G = bVar;
    }

    public final void a(com.anythink.expressad.videocommon.e.d dVar) {
        try {
            this.I = dVar;
            if (dVar == null || dVar.V() * 1000 == com.anythink.expressad.foundation.g.a.cq) {
                return;
            }
            com.anythink.expressad.foundation.g.a.cq = this.I.V() * 1000;
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public final void a(boolean z) {
        this.T = z;
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean a() {
        return false;
    }

    public final boolean a(java.util.List<com.anythink.expressad.foundation.d.c> list, boolean z, int i2) {
        return b(list, z, i2);
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void b() {
    }

    public final void b(boolean z) {
        this.U = z;
    }

    public final java.lang.String c(boolean z) {
        java.util.List<com.anythink.expressad.foundation.d.c> a2;
        com.anythink.expressad.foundation.d.c cVar;
        if (!z) {
            return this.m;
        }
        if (android.text.TextUtils.isEmpty(this.n) && (a2 = com.anythink.expressad.videocommon.b.e.a().a(this.w)) != null && a2.size() > 0 && (cVar = a2.get(0)) != null) {
            this.n = cVar.Z();
        }
        return this.n;
    }

    @Override // com.anythink.expressad.reward.a.a
    public final boolean c() {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return false;
        }
        return b(this.aa, !android.text.TextUtils.isEmpty(r0.ar()), this.aa.get(0).ap());
    }

    @Override // com.anythink.expressad.reward.a.a
    public final void d() {
    }

    public final void d(boolean z) {
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList;
        if (z || (copyOnWriteArrayList = this.aa) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.anythink.expressad.videocommon.a.a.a();
    }

    public final java.lang.String e() {
        return this.w;
    }

    public final void e(boolean z) {
        if (z) {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(0);
                    if (cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                        com.anythink.expressad.videocommon.b.l.a().c(this.w + "_" + cVar.Z() + "_" + cVar.M().e(), false);
                    }
                }
            }
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (next != null) {
                next.l(0);
                if (next.M() != null && !android.text.TextUtils.isEmpty(next.M().e())) {
                    com.anythink.expressad.videocommon.b.l.a().c(this.w + "_" + next.Z() + "_" + next.M().e(), false);
                }
            }
        }
    }

    public final java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> f() {
        return this.aa;
    }

    public final boolean f(boolean z) {
        if (z) {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.ah;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (com.anythink.expressad.foundation.d.c cVar : this.ah) {
                if (cVar != null) {
                    cVar.l(1);
                    if (cVar.M() != null && !android.text.TextUtils.isEmpty(cVar.M().e())) {
                        com.anythink.expressad.videocommon.b.l.a().c(this.w + "_" + cVar.Z() + "_" + cVar.M().e(), true);
                    }
                }
            }
            return true;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.aa;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.aa.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (next != null) {
                next.l(1);
                if (next.M() != null && !android.text.TextUtils.isEmpty(next.M().e())) {
                    com.anythink.expressad.videocommon.b.l.a().c(this.w + "_" + next.Z() + "_" + next.M().e(), true);
                }
            }
        }
        return true;
    }
}

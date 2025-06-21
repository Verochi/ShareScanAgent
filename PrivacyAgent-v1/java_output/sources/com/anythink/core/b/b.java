package com.anythink.core.b;

/* loaded from: classes12.dex */
public class b extends com.anythink.core.common.o.a implements com.anythink.core.common.i.b {
    public static final java.lang.String a = "b";
    java.util.Map<java.lang.String, com.anythink.core.common.f.h> b = new java.util.concurrent.ConcurrentHashMap(3);
    com.anythink.core.common.m.b c = new com.anythink.core.b.b.AnonymousClass1();
    private java.lang.String d;
    private com.anythink.core.common.i.a e;
    private java.lang.String f;
    private long g;
    private boolean h;
    private com.anythink.core.common.f.a i;
    private java.util.Map<java.lang.Integer, com.anythink.core.b.d> j;
    private long k;

    /* renamed from: com.anythink.core.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {

        /* renamed from: com.anythink.core.b.b$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01591 implements java.lang.Runnable {
            public RunnableC01591() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.b.b.this.c();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass1.RunnableC01591());
        }
    }

    /* renamed from: com.anythink.core.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.b.d a;
        final /* synthetic */ java.lang.Integer b;

        /* renamed from: com.anythink.core.b.b$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.b.b.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.core.b.b.a
            public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
                com.anythink.core.b.b.a(com.anythink.core.b.b.this, auVar, aTBaseAdAdapter);
            }

            @Override // com.anythink.core.b.b.a
            public final void a(java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2) {
                com.anythink.core.b.b.AnonymousClass2 anonymousClass2 = com.anythink.core.b.b.AnonymousClass2.this;
                com.anythink.core.b.b.this.b(anonymousClass2.b, list, list2);
            }
        }

        public AnonymousClass2(com.anythink.core.b.d dVar, java.lang.Integer num) {
            this.a = dVar;
            this.b = num;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.b.d dVar = this.a;
            if (dVar != null) {
                dVar.a(com.anythink.core.b.b.this.h);
                this.a.a(new com.anythink.core.b.b.AnonymousClass2.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.anythink.core.b.b$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.Comparator<com.anythink.core.common.f.au> {
        public AnonymousClass3() {
        }

        private static int a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.au auVar2) {
            double a = com.anythink.core.common.o.h.a(auVar);
            double a2 = com.anythink.core.common.o.h.a(auVar2);
            if (a > a2) {
                return -1;
            }
            return a == a2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.au auVar2) {
            double a = com.anythink.core.common.o.h.a(auVar);
            double a2 = com.anythink.core.common.o.h.a(auVar2);
            if (a > a2) {
                return -1;
            }
            return a == a2 ? 0 : 1;
        }
    }

    /* renamed from: com.anythink.core.b.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.h a;
        final /* synthetic */ com.anythink.core.common.f.au b;

        public AnonymousClass4(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
            this.a = hVar;
            this.b = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.b.b.this.i.c.e != null) {
                if (this.a != null) {
                    com.anythink.core.b.b.this.i.c.e.a(this.a, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adSourceBidError, "", this.b.A()));
                }
                com.anythink.core.b.b.this.b.remove(this.b.u());
            }
        }
    }

    /* renamed from: com.anythink.core.b.b$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.h a;
        final /* synthetic */ com.anythink.core.common.f.au b;

        public AnonymousClass5(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
            this.a = hVar;
            this.b = auVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.b.b.this.i.c.e != null) {
                com.anythink.core.common.f.h hVar = this.a;
                if (hVar != null) {
                    com.anythink.core.common.o.u.a(hVar, this.b, 0, false);
                    com.anythink.core.b.b.this.i.c.e.b(this.a);
                }
                com.anythink.core.b.b.this.b.remove(this.b.u());
            }
        }
    }

    public b(com.anythink.core.common.f.a aVar) {
        this.i = aVar;
        this.d = aVar.e;
        this.f = aVar.d;
        this.g = aVar.g;
        java.util.List<com.anythink.core.common.f.au> list = aVar.j;
        int size = list.size();
        java.util.List<com.anythink.core.common.f.au> a2 = aVar.y.a();
        if (a2.size() > 0) {
            this.i.z = a2.size() + size;
        } else {
            this.i.z = size;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = null;
        java.util.ArrayList arrayList4 = null;
        java.util.ArrayList arrayList5 = null;
        for (int i = 0; i < size; i++) {
            com.anythink.core.common.f.au auVar = list.get(i);
            if (auVar.m() == 1 || auVar.m() == 3) {
                arrayList.add(auVar);
            } else if (auVar.m() == 2) {
                arrayList3 = arrayList3 == null ? new java.util.ArrayList(size) : arrayList3;
                arrayList3.add(auVar);
            } else if (auVar.m() == 5) {
                arrayList4 = arrayList4 == null ? new java.util.ArrayList(size) : arrayList4;
                arrayList4.add(auVar);
            } else if (auVar.m() == 6) {
                arrayList5 = arrayList5 == null ? new java.util.ArrayList(size) : arrayList5;
                arrayList5.add(auVar);
            } else if (auVar.m() == 7) {
                arrayList2.add(auVar);
            }
        }
        this.j = new java.util.HashMap(5);
        if (arrayList.size() > 0 || arrayList2.size() > 0) {
            this.j.put(1, new com.anythink.core.b.c(aVar.a(arrayList, arrayList2), list));
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            this.j.put(2, new com.anythink.core.b.a(aVar.a(arrayList3)));
        }
        if (arrayList4 != null && arrayList4.size() > 0) {
            this.j.put(5, new com.anythink.core.b.h(aVar.b(arrayList4)));
        }
        if (arrayList5 == null || arrayList5.size() <= 0) {
            return;
        }
        this.j.put(6, new com.anythink.core.b.g(aVar.c(arrayList5)));
    }

    public static /* synthetic */ void a(com.anythink.core.b.b bVar, com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (auVar.m() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            com.anythink.core.common.f.a aVar = bVar.i;
            if (aVar.c.e != null) {
                com.anythink.core.common.f.h S = aVar.f167s.S();
                com.anythink.core.common.o.u.a(S, auVar, 0, false);
                S.g(aTBaseAdAdapter.getInternalNetworkPlacementId());
                bVar.b.put(auVar.u(), S);
                S.f(0.0d);
                S.c(0.0d);
                S.d(0.0d);
                bVar.i.c.e.a(S);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.h hVar = this.b.get(auVar.u());
        if (hVar != null) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass4(hVar, auVar));
        }
    }

    private void a(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (auVar.m() == 7 || aTBaseAdAdapter == null) {
            return;
        }
        try {
            com.anythink.core.common.f.a aVar = this.i;
            if (aVar.c.e != null) {
                com.anythink.core.common.f.h S = aVar.f167s.S();
                com.anythink.core.common.o.u.a(S, auVar, 0, false);
                S.g(aTBaseAdAdapter.getInternalNetworkPlacementId());
                this.b.put(auVar.u(), S);
                S.f(0.0d);
                S.c(0.0d);
                S.d(0.0d);
                this.i.c.e.a(S);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private synchronized void a(java.lang.Integer num, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2) {
        boolean z;
        com.anythink.core.b.d dVar = this.j.get(num);
        if (dVar != null && dVar.c()) {
            this.j.remove(num);
        }
        if (this.j.size() == 0) {
            a();
            com.anythink.core.common.m.d.a().b(this.c);
            z = true;
        } else {
            z = false;
        }
        int size = list != null ? list.size() : 0;
        int size2 = list2 != null ? list2.size() : 0;
        if (size > 0 || size2 > 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    com.anythink.core.common.f.au auVar = list.get(i);
                    a(this.d, auVar, true);
                    arrayList.add(auVar);
                    arrayList3.add(auVar);
                    com.anythink.core.common.f.h hVar = this.b.get(auVar.u());
                    if (hVar != null) {
                        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass5(hVar, auVar));
                    }
                }
                list.clear();
            }
            if (size2 > 0) {
                for (int i2 = 0; i2 < size2; i2++) {
                    com.anythink.core.common.f.au auVar2 = list2.get(i2);
                    if (auVar2 == null) {
                        try {
                            com.anythink.core.common.n.c.a("Bid Fail AdSource Object is null, currentSize:" + list2.size() + "\n" + com.anythink.core.common.o.i.a(new java.lang.Throwable().getStackTrace()), "Bidding inner error", com.anythink.core.common.b.o.a().q());
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                    a(this.d, auVar2, false);
                    if (com.anythink.core.common.o.h.a(auVar2) <= 0.0d || android.text.TextUtils.isEmpty(auVar2.z())) {
                        arrayList2.add(auVar2);
                    } else {
                        arrayList.add(auVar2);
                    }
                    arrayList3.add(auVar2);
                    com.anythink.core.common.f.h hVar2 = this.b.get(auVar2.u());
                    if (hVar2 != null) {
                        com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass4(hVar2, auVar2));
                    }
                }
                list2.clear();
            }
            if (arrayList.size() > 1) {
                java.util.Collections.sort(arrayList, new com.anythink.core.b.b.AnonymousClass3());
            }
            com.anythink.core.common.f.h S = this.i.f167s.S();
            long j = this.k;
            com.anythink.core.common.f.a aVar = this.i;
            com.anythink.core.b.d.b.a(S, arrayList3, j, aVar.t, aVar.f);
            com.anythink.core.common.i.a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(this.f, arrayList, arrayList2, z);
            }
            if (z) {
                this.e = null;
            }
        }
    }

    private void a(java.lang.String str, com.anythink.core.common.f.au auVar, boolean z) {
        int i;
        if (auVar.n() == 2) {
            com.anythink.core.common.f.av a2 = com.anythink.core.common.a.a().a(str, auVar);
            com.anythink.core.common.f.q M = auVar.M();
            com.anythink.core.common.f.b bVar = null;
            if (a2 != null) {
                com.anythink.core.common.f.f a3 = a2.a((com.anythink.core.common.f.q) null);
                bVar = a3.b();
                i = a3.d();
            } else {
                i = 0;
            }
            if (bVar != null) {
                auVar.am();
            }
            auVar.toString();
            if (bVar == null || i < auVar.am()) {
                return;
            }
            try {
                double a4 = com.anythink.core.common.o.h.a(auVar);
                double a5 = com.anythink.core.common.o.h.a(bVar.d().getUnitGroupInfo());
                if (a4 > a5) {
                    auVar.a(auVar, 2, auVar.p(), 1);
                    return;
                }
                try {
                    com.anythink.core.common.f.au unitGroupInfo = bVar.d().getUnitGroupInfo();
                    java.lang.String str2 = unitGroupInfo.M() != null ? unitGroupInfo.M().token : "";
                    if (M != null && !android.text.TextUtils.equals(M.token, str2)) {
                        com.anythink.core.b.d.b.a(M, new com.anythink.core.common.f.y(2, auVar, this.i.f167s, a5), true);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                auVar.a(bVar.d().getUnitGroupInfo(), 1, auVar.p(), z ? 1 : 0);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private boolean a(java.lang.Integer num) {
        com.anythink.core.b.d dVar = this.j.get(num);
        if (dVar != null && dVar.c()) {
            this.j.remove(num);
        }
        if (this.j.size() != 0) {
            return false;
        }
        a();
        com.anythink.core.common.m.d.a().b(this.c);
        return true;
    }

    private void b(com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.f.h hVar = this.b.get(auVar.u());
        if (hVar != null) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass5(hVar, auVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(java.lang.Integer num, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2) {
        a(num, list, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        try {
            com.anythink.core.common.i.a aVar = this.e;
            if (aVar != null) {
                aVar.a(this.f);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void d() {
        long j = this.i.i;
        if (j <= 0) {
            j = 2000;
        }
        com.anythink.core.common.m.d.a().a(this.c, j, false);
    }

    @Override // com.anythink.core.common.i.b
    public final void a(com.anythink.core.common.i.a aVar) {
        this.e = aVar;
        super.a(this.g);
        long j = this.i.i;
        if (j <= 0) {
            j = 2000;
        }
        com.anythink.core.common.m.d.a().a(this.c, j, false);
        this.k = java.lang.System.currentTimeMillis();
        for (java.util.Map.Entry entry : new java.util.HashMap(this.j).entrySet()) {
            java.lang.Integer num = (java.lang.Integer) entry.getKey();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.b.AnonymousClass2((com.anythink.core.b.d) entry.getValue(), num));
        }
    }

    @Override // com.anythink.core.common.i.b
    public final void a(boolean z) {
        this.h = z;
    }

    @Override // com.anythink.core.common.o.a
    public final synchronized void b() {
        java.util.Iterator it = new java.util.HashMap(this.j).entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.b.d dVar = (com.anythink.core.b.d) ((java.util.Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.a();
            }
        }
    }
}

package com.anythink.expressad.videocommon.b;

/* loaded from: classes12.dex */
public class e {
    private static final java.lang.String a = "DownLoadManager";
    private static com.anythink.expressad.videocommon.b.e b;
    private java.util.concurrent.ThreadPoolExecutor c;
    private boolean d = false;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> e = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>>> f;
    private java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.d.c>> g;
    private java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.videocommon.b.c>> h;

    private e() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(5, 15, 15L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(), new java.util.concurrent.ThreadPoolExecutor.DiscardPolicy());
        this.c = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static com.anythink.expressad.videocommon.b.e a() {
        if (b == null) {
            synchronized (com.anythink.expressad.videocommon.b.e.class) {
                if (b == null) {
                    b = new com.anythink.expressad.videocommon.b.e();
                }
            }
        }
        return b;
    }

    private com.anythink.expressad.videocommon.b.n a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar, int i, com.anythink.expressad.videocommon.d.b bVar) {
        if (android.text.TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (!this.e.containsKey(str)) {
            com.anythink.expressad.videocommon.b.n nVar = new com.anythink.expressad.videocommon.b.n(cVar, this.c, str, i);
            if (bVar != null) {
                nVar.a(bVar);
            }
            this.e.put(str, nVar);
            return nVar;
        }
        com.anythink.expressad.videocommon.b.n nVar2 = this.e.get(str);
        if (i == 94 || i == 287) {
            nVar2.a(cVar.Z(), bVar);
        } else {
            nVar2.a(bVar);
        }
        nVar2.a(cVar);
        return nVar2;
    }

    private static void a(com.anythink.expressad.videocommon.b.n nVar, java.lang.String str) {
        try {
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), str);
            if (a2 == null) {
                return;
            }
            if (a2.F() == 2) {
                nVar.c();
            } else {
                nVar.a();
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), str);
                if (c == null) {
                    c = com.anythink.expressad.d.c.d(str);
                }
                if (c.m() == 2) {
                    nVar.c();
                } else {
                    nVar.a();
                }
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
    }

    private com.anythink.expressad.videocommon.b.c b(int i, java.lang.String str, boolean z) {
        com.anythink.expressad.videocommon.b.n c = c(str);
        if (c != null) {
            return c.b(i, z);
        }
        return null;
    }

    private void b(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.videocommon.b.n c = c(str);
        if (c != null) {
            try {
                c.b(str2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void d() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                com.anythink.expressad.videocommon.b.n value = it.next().getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    private java.util.List<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>> e(java.lang.String str) {
        java.util.Map<java.lang.String, java.util.List<java.util.Map<java.lang.String, com.anythink.expressad.videocommon.b.c>>> map = this.f;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    private void f(java.lang.String str) {
        com.anythink.expressad.videocommon.b.n c = c(str);
        if (c != null) {
            c.d();
        }
    }

    public final com.anythink.expressad.videocommon.b.c a(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.videocommon.b.n c = c(str);
        if (c != null) {
            return c.a(str2);
        }
        return null;
    }

    public final com.anythink.expressad.videocommon.b.n a(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list, int i, com.anythink.expressad.videocommon.d.b bVar) {
        if (android.text.TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return null;
        }
        if (!this.e.containsKey(str)) {
            com.anythink.expressad.videocommon.b.n nVar = new com.anythink.expressad.videocommon.b.n(list, this.c, str, i);
            if (bVar != null) {
                nVar.a(bVar);
            }
            this.e.put(str, nVar);
            return nVar;
        }
        com.anythink.expressad.videocommon.b.n nVar2 = this.e.get(str);
        if (i == 94 || i == 287) {
            nVar2.a(list.get(0).Z(), bVar);
        } else {
            nVar2.a(bVar);
        }
        nVar2.a(list);
        return nVar2;
    }

    public final java.util.List<com.anythink.expressad.foundation.d.c> a(java.lang.String str) {
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.foundation.d.c>> map = this.g;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.g.get(str);
    }

    public final void a(boolean z) {
        if (!z) {
            this.d = false;
        } else if (this.d) {
            return;
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
        }
    }

    public final boolean a(int i, java.lang.String str, boolean z) {
        try {
            com.anythink.expressad.videocommon.b.n c = c(str);
            if (c != null) {
                return c.a(i, z) != null;
            }
            return false;
        } catch (java.lang.Exception e) {
            if (!com.anythink.expressad.a.a) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final boolean a(java.lang.String str, boolean z, int i, boolean z2, int i2, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        return b(str, z, i, z2, i2, list);
    }

    public final java.util.List<com.anythink.expressad.videocommon.b.c> b(java.lang.String str) {
        java.util.Map<java.lang.String, java.util.List<com.anythink.expressad.videocommon.b.c>> map = this.h;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.h.get(str);
    }

    public final void b() {
        this.d = false;
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.n>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                com.anythink.expressad.videocommon.b.n value = it.next().getValue();
                if (value != null) {
                    value.c();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x0172, code lost:
    
        if (r11.size() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0177, code lost:
    
        r11 = r8.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0179, code lost:
    
        if (r11 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x017b, code lost:
    
        r8.f = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x018e, code lost:
    
        r11 = r8.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0190, code lost:
    
        if (r11 != null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0192, code lost:
    
        r8.h = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01a5, code lost:
    
        r11 = r8.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a7, code lost:
    
        if (r11 != null) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01a9, code lost:
    
        r8.g = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01bc, code lost:
    
        if (r10 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01c2, code lost:
    
        if (r10.size() <= 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c4, code lost:
    
        r11 = new java.util.ArrayList();
        r12 = new java.util.ArrayList();
        r13 = new java.util.ArrayList();
        r10 = r10.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01db, code lost:
    
        if (r10.hasNext() == false) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01dd, code lost:
    
        r14 = r10.next();
        r1 = new java.util.concurrent.ConcurrentHashMap();
        r2 = r14.n();
        r1.put(r2.aZ() + r2.S() + r2.B(), r14);
        r11.add(r1);
        r12.add(r2);
        r13.add(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0217, code lost:
    
        r8.f.put(r9, r11);
        r8.g.put(r9, r12);
        r8.h.put(r9, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01b5, code lost:
    
        if (r11.containsKey(r9) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01b7, code lost:
    
        r8.g.remove(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x019e, code lost:
    
        if (r11.containsKey(r9) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01a0, code lost:
    
        r8.h.remove(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0187, code lost:
    
        if (r11.containsKey(r9) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0189, code lost:
    
        r8.f.remove(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0110, code lost:
    
        if (r13.size() >= r11) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(java.lang.String str, boolean z, int i, boolean z2, int i2, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        com.anythink.expressad.videocommon.b.n c;
        com.anythink.expressad.foundation.d.c cVar;
        boolean z3 = false;
        if (list != null) {
            try {
                if (list.size() != 0 && (c = c(str)) != null) {
                    java.util.List<com.anythink.expressad.videocommon.b.c> a2 = c.a(z, list);
                    if (a2 != null && a2.size() != 0) {
                        if (z2) {
                            boolean z4 = list.size() > 0 && (cVar = list.get(0)) != null && cVar.aB() != null && cVar.aB().size() > 0 && cVar.aB().contains(0);
                            try {
                                if (i2 == 0) {
                                    java.util.ArrayList arrayList = new java.util.ArrayList();
                                    for (com.anythink.expressad.videocommon.b.c cVar2 : a2) {
                                        for (com.anythink.expressad.foundation.d.c cVar3 : list) {
                                            if (cVar2 != null && cVar2.n() != null && cVar3 != null && cVar3.aZ().equals(cVar2.n().aZ()) && cVar3.Z().equals(cVar2.n().Z())) {
                                                arrayList.add(cVar2);
                                            }
                                        }
                                    }
                                    z3 = arrayList.size() > 0 ? true : z4;
                                } else {
                                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                                    for (com.anythink.expressad.videocommon.b.c cVar4 : a2) {
                                        for (com.anythink.expressad.foundation.d.c cVar5 : list) {
                                            if (cVar4 != null && cVar4.n() != null && cVar5 != null && cVar5.aZ().equals(cVar4.n().aZ()) && cVar5.Z().equals(cVar4.n().Z())) {
                                                arrayList2.add(cVar4);
                                            }
                                        }
                                    }
                                }
                            } catch (java.lang.Exception e) {
                                e = e;
                                z3 = z4;
                                if (com.anythink.expressad.a.a) {
                                    e.printStackTrace();
                                }
                                return z3;
                            }
                        } else {
                            java.util.ArrayList arrayList3 = new java.util.ArrayList();
                            for (com.anythink.expressad.videocommon.b.c cVar6 : a2) {
                                for (com.anythink.expressad.foundation.d.c cVar7 : list) {
                                    if (cVar6 != null && cVar6.n() != null && cVar7 != null && cVar7.aZ().equals(cVar6.n().aZ()) && cVar7.Z().equals(cVar6.n().Z())) {
                                        arrayList3.add(cVar6);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        }
        return z3;
    }

    public final com.anythink.expressad.videocommon.b.n c(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> concurrentHashMap = this.e;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public final void c() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.videocommon.b.n> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.b.n> entry : concurrentHashMap.entrySet()) {
                com.anythink.expressad.videocommon.b.n value = entry.getValue();
                java.lang.String key = entry.getKey();
                try {
                    com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), key);
                    if (a2 != null) {
                        if (a2.F() == 2) {
                            value.c();
                        } else {
                            value.a();
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.getMessage();
                    try {
                        if (!android.text.TextUtils.isEmpty(key)) {
                            com.anythink.expressad.d.b.a();
                            com.anythink.expressad.d.c c = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), key);
                            if (c == null) {
                                c = com.anythink.expressad.d.c.d(key);
                            }
                            if (c.m() == 2) {
                                value.c();
                            } else {
                                value.a();
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        e2.getMessage();
                    }
                }
            }
        }
    }

    public final void d(java.lang.String str) {
        com.anythink.expressad.videocommon.b.n c = c(str);
        if (c != null) {
            c.a();
        }
    }
}

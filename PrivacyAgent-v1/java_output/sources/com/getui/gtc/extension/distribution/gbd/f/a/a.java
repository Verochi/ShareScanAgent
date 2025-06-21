package com.getui.gtc.extension.distribution.gbd.f.a;

/* loaded from: classes22.dex */
public final class a {
    private static com.getui.gtc.extension.distribution.gbd.f.a.a A = null;
    private static final java.lang.Object C = new java.lang.Object();
    public static final java.lang.String a = "id";
    public static final java.lang.String b = "key";
    public static final java.lang.String c = "value";
    public static final java.lang.String d = "t";
    public static final java.lang.String e = "num";
    public static final java.lang.String f = "type";
    public static final java.lang.String g = "status";
    private static final java.lang.String i = "GBD_RALDataManager";
    private static final int j = 106;
    private static final int k = 111;
    private static final int l = 114;
    private static final int m = 119;
    private static final int n = 124;
    private static final int o = 127;
    private static final int p = 128;
    private static final int q = 131;
    private static final int r = 132;

    /* renamed from: s, reason: collision with root package name */
    private static final int f326s = 134;
    private static final int t = 303;
    private static final int u = 143;
    private static final int v = 252;
    private static final int w = 254;
    private static final int x = 116;
    private static final int y = 117;
    private static final int z = 151;
    private java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> B = new java.util.ArrayList();
    public boolean h = false;
    private java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.p> D = new com.getui.gtc.extension.distribution.gbd.f.a.a.AnonymousClass1();
    private java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.p> E = new com.getui.gtc.extension.distribution.gbd.f.a.a.AnonymousClass2();
    private com.getui.gtc.extension.distribution.gbd.g.c F = new com.getui.gtc.extension.distribution.gbd.f.a.a.AnonymousClass3();
    private com.getui.gtc.extension.distribution.gbd.g.c G = new com.getui.gtc.extension.distribution.gbd.f.a.a.AnonymousClass4();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.p> {
        public AnonymousClass1() {
        }

        private static int a(com.getui.gtc.extension.distribution.gbd.c.p pVar, com.getui.gtc.extension.distribution.gbd.c.p pVar2) {
            int i = pVar.e;
            int i2 = pVar2.e;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? -1 : 1;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.getui.gtc.extension.distribution.gbd.c.p pVar, com.getui.gtc.extension.distribution.gbd.c.p pVar2) {
            int i = pVar.e;
            int i2 = pVar2.e;
            if (i == i2) {
                return 0;
            }
            return i > i2 ? -1 : 1;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.getui.gtc.extension.distribution.gbd.c.p> {
        public AnonymousClass2() {
        }

        private static int a(com.getui.gtc.extension.distribution.gbd.c.p pVar, com.getui.gtc.extension.distribution.gbd.c.p pVar2) {
            long j = pVar.d;
            long j2 = pVar2.d;
            if (j == j2) {
                return 0;
            }
            return j < j2 ? -1 : 1;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(com.getui.gtc.extension.distribution.gbd.c.p pVar, com.getui.gtc.extension.distribution.gbd.c.p pVar2) {
            long j = pVar.d;
            long j2 = pVar2.d;
            if (j == j2) {
                return 0;
            }
            return j < j2 ? -1 : 1;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass3() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj instanceof com.getui.gtc.extension.distribution.gbd.c.b) {
                    com.getui.gtc.extension.distribution.gbd.c.b bVar = (com.getui.gtc.extension.distribution.gbd.c.b) obj;
                    boolean z = bVar.b;
                    java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list = bVar.a;
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    if (z) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.f.a.a.i, "instant bir report s.");
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.c.p pVar = list.get(0);
                    com.getui.gtc.extension.distribution.gbd.f.a.a.this.b(pVar.c, pVar.b);
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.f.a.a.i, "instant bir report f, insert ral.");
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.f.a.a$4, reason: invalid class name */
    public class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass4() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            if (obj instanceof com.getui.gtc.extension.distribution.gbd.c.b) {
                com.getui.gtc.extension.distribution.gbd.c.b bVar = (com.getui.gtc.extension.distribution.gbd.c.b) obj;
                com.getui.gtc.extension.distribution.gbd.f.a.a.a(com.getui.gtc.extension.distribution.gbd.f.a.a.this, bVar.a, bVar.b);
            }
        }
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.f.a.a a() {
        com.getui.gtc.extension.distribution.gbd.f.a.a aVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.f.a.a.class) {
            if (A == null) {
                A = new com.getui.gtc.extension.distribution.gbd.f.a.a();
            }
            aVar = A;
        }
        return aVar;
    }

    private static java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> a(java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i3 = 0;
        for (com.getui.gtc.extension.distribution.gbd.c.p pVar : list) {
            if (i3 < 10 && pVar.b == i2) {
                arrayList.add(pVar);
                i3++;
            }
        }
        return arrayList;
    }

    private void a(int i2, java.lang.StringBuilder sb, java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        try {
            com.getui.gtc.extension.distribution.gbd.g.a.g gVar = new com.getui.gtc.extension.distribution.gbd.g.a.g(sb.toString().getBytes("UTF-8"), i2, list);
            gVar.m = this.G;
            if (com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(gVar))) {
                return;
            }
            this.h = false;
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport requestService false");
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            this.h = false;
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport requestService isReporting=false " + e2.toString());
        }
    }

    public static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.f.a.a aVar, java.util.List list, boolean z2) {
        try {
            if (list == null) {
                aVar.h = false;
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult Exception");
                return;
            }
            int i2 = ((com.getui.gtc.extension.distribution.gbd.c.p) list.get(0)).b;
            if (z2) {
                int size = list.size();
                aVar.a((java.util.List<com.getui.gtc.extension.distribution.gbd.c.p>) list);
                if (size < 10 && i2 == 106) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 106 report over");
                    aVar.a(111);
                    return;
                }
                if (size < 10 && i2 == 111) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 111 report over");
                    aVar.a(114);
                    return;
                }
                if (size < 10 && i2 == 114) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 114 report over");
                    aVar.a(119);
                    return;
                }
                if (size < 10 && i2 == 119) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 119 report over");
                    aVar.a(124);
                    return;
                }
                if (size < 10 && i2 == 124) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 124 report over");
                    aVar.a(127);
                    return;
                }
                if (size < 10 && i2 == 127) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 127 report over");
                    aVar.a(128);
                    return;
                }
                if (size < 10 && i2 == 128) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 128 report over");
                    aVar.a(131);
                    return;
                }
                if (size < 10 && i2 == 131) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 131 report over");
                    aVar.a(132);
                    return;
                }
                if (size < 10 && i2 == 132) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 132 report over");
                    aVar.a(134);
                    return;
                }
                if (size < 10 && i2 == 134) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 134 report over");
                    aVar.a(303);
                    return;
                }
                if (size < 10 && i2 == 303) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 303 report over");
                    aVar.a(116);
                    return;
                }
                if (size < 10 && i2 == 116) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 116 report over");
                    aVar.a(117);
                    return;
                }
                if (size < 10 && i2 == 117) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 117 report over");
                    aVar.a(151);
                    return;
                }
                if (size < 10 && i2 == 151) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 151 report over");
                    aVar.a(252);
                    return;
                }
                if (size < 10 && i2 == 252) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 252 report over");
                    aVar.a(254);
                    return;
                }
                if (size < 10 && i2 == 254) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 254 report over");
                    aVar.a(143);
                    return;
                } else if (size >= 10 || i2 != 143) {
                    aVar.a(i2);
                    return;
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 143 report over");
                    aVar.h = false;
                    return;
                }
            }
            try {
                if (!list.isEmpty()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(list);
                    java.util.Iterator it = list.iterator();
                    while (it.hasNext()) {
                        com.getui.gtc.extension.distribution.gbd.c.p pVar = (com.getui.gtc.extension.distribution.gbd.c.p) it.next();
                        int i3 = pVar.e + 1;
                        pVar.e = i3;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(i, " id = " + pVar.a + "  num = " + i3);
                        if (i3 >= com.getui.gtc.extension.distribution.gbd.d.d.cf) {
                            arrayList.add(pVar);
                            arrayList2.remove(pVar);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        c(arrayList2);
                    }
                    if (arrayList.size() > 0) {
                        aVar.a(arrayList);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            if (i2 == 106) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 106 report failed");
                aVar.a(111);
                return;
            }
            if (i2 == 111) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 111 report failed");
                aVar.a(114);
                return;
            }
            if (i2 == 114) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 114 report failed");
                aVar.a(119);
                return;
            }
            if (i2 == 119) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 119 report failed");
                aVar.a(124);
                return;
            }
            if (i2 == 124) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 124 report failed");
                aVar.a(127);
                return;
            }
            if (i2 == 127) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 127 report failed");
                aVar.a(128);
                return;
            }
            if (i2 == 128) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 128 report failed");
                aVar.a(131);
                return;
            }
            if (i2 == 131) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 131 report failed");
                aVar.a(132);
                return;
            }
            if (i2 == 132) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 132 report failed");
                aVar.a(134);
                return;
            }
            if (i2 == 134) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 134 report failed");
                aVar.a(303);
                return;
            }
            if (i2 == 303) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 303 report failed");
                aVar.a(116);
                return;
            }
            if (i2 == 116) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 116 report failed");
                aVar.a(117);
                return;
            }
            if (i2 == 117) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 117 report failed");
                aVar.a(151);
                return;
            }
            if (i2 == 151) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 151 report failed");
                aVar.a(252);
                return;
            }
            if (i2 == 252) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 252 report failed");
                aVar.a(254);
            } else if (i2 == 254) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 254 report failed");
                aVar.a(143);
            } else if (i2 == 143) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 143 report failed");
                aVar.h = false;
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
        }
    }

    private void a(java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (C) {
            if (list != null) {
                if (!list.isEmpty()) {
                    int size = list.size();
                    java.lang.String[] strArr = new java.lang.String[size];
                    int i2 = 0;
                    for (com.getui.gtc.extension.distribution.gbd.c.p pVar : list) {
                        int i3 = pVar.a;
                        strArr[i2] = java.lang.String.valueOf(i3);
                        this.B.remove(pVar);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(i, "removeRALData id = ".concat(java.lang.String.valueOf(i3)));
                        i2++;
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.a;
                    java.lang.String[] strArr2 = {"id"};
                    android.database.sqlite.SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                    aVar.a = writableDatabase;
                    writableDatabase.beginTransaction();
                    try {
                        try {
                            if (size == 1) {
                                aVar.a.delete("ral", strArr2[0] + " = ?", strArr);
                            } else {
                                aVar.a.execSQL("delete from ral where " + com.getui.gtc.extension.distribution.gbd.f.a.a(strArr2, strArr, size));
                            }
                            aVar.a.setTransactionSuccessful();
                            sQLiteDatabase = aVar.a;
                        } catch (java.lang.Throwable th) {
                            aVar.a.endTransaction();
                            throw th;
                        }
                    } catch (java.lang.Throwable unused) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper=================".concat("ral"), "Delete Error!");
                        sQLiteDatabase = aVar.a;
                    }
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    private void a(java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list, boolean z2) {
        try {
            if (list == null) {
                this.h = false;
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult Exception");
                return;
            }
            int i2 = list.get(0).b;
            if (z2) {
                int size = list.size();
                a(list);
                if (size < 10 && i2 == 106) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 106 report over");
                    a(111);
                    return;
                }
                if (size < 10 && i2 == 111) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 111 report over");
                    a(114);
                    return;
                }
                if (size < 10 && i2 == 114) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 114 report over");
                    a(119);
                    return;
                }
                if (size < 10 && i2 == 119) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 119 report over");
                    a(124);
                    return;
                }
                if (size < 10 && i2 == 124) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 124 report over");
                    a(127);
                    return;
                }
                if (size < 10 && i2 == 127) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 127 report over");
                    a(128);
                    return;
                }
                if (size < 10 && i2 == 128) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 128 report over");
                    a(131);
                    return;
                }
                if (size < 10 && i2 == 131) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 131 report over");
                    a(132);
                    return;
                }
                if (size < 10 && i2 == 132) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 132 report over");
                    a(134);
                    return;
                }
                if (size < 10 && i2 == 134) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 134 report over");
                    a(303);
                    return;
                }
                if (size < 10 && i2 == 303) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 303 report over");
                    a(116);
                    return;
                }
                if (size < 10 && i2 == 116) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 116 report over");
                    a(117);
                    return;
                }
                if (size < 10 && i2 == 117) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 117 report over");
                    a(151);
                    return;
                }
                if (size < 10 && i2 == 151) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 151 report over");
                    a(252);
                    return;
                }
                if (size < 10 && i2 == 252) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 252 report over");
                    a(254);
                    return;
                }
                if (size < 10 && i2 == 254) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 254 report over");
                    a(143);
                    return;
                } else if (size >= 10 || i2 != 143) {
                    a(i2);
                    return;
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 143 report over");
                    this.h = false;
                    return;
                }
            }
            try {
                if (!list.isEmpty()) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(list);
                    for (com.getui.gtc.extension.distribution.gbd.c.p pVar : list) {
                        int i3 = pVar.e + 1;
                        pVar.e = i3;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(i, " id = " + pVar.a + "  num = " + i3);
                        if (i3 >= com.getui.gtc.extension.distribution.gbd.d.d.cf) {
                            arrayList.add(pVar);
                            arrayList2.remove(pVar);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        c(arrayList2);
                    }
                    if (arrayList.size() > 0) {
                        a(arrayList);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            if (i2 == 106) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 106 report failed");
                a(111);
                return;
            }
            if (i2 == 111) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 111 report failed");
                a(114);
                return;
            }
            if (i2 == 114) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 114 report failed");
                a(119);
                return;
            }
            if (i2 == 119) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 119 report failed");
                a(124);
                return;
            }
            if (i2 == 124) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 124 report failed");
                a(127);
                return;
            }
            if (i2 == 127) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 127 report failed");
                a(128);
                return;
            }
            if (i2 == 128) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 128 report failed");
                a(131);
                return;
            }
            if (i2 == 131) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 131 report failed");
                a(132);
                return;
            }
            if (i2 == 132) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 132 report failed");
                a(134);
                return;
            }
            if (i2 == 134) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 134 report failed");
                a(303);
                return;
            }
            if (i2 == 303) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 303 report failed");
                a(116);
                return;
            }
            if (i2 == 116) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 116 report failed");
                a(117);
                return;
            }
            if (i2 == 117) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 117 report failed");
                a(151);
                return;
            }
            if (i2 == 151) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 151 report failed");
                a(252);
                return;
            }
            if (i2 == 252) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 252 report failed");
                a(254);
            } else if (i2 == 254) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 254 report failed");
                a(143);
            } else if (i2 == 143) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "getReportResult type 143 report failed");
                this.h = false;
            }
        } catch (java.lang.Exception e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
        }
    }

    private void b(java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.ArrayList arrayList2 = new java.util.ArrayList(list);
                for (com.getui.gtc.extension.distribution.gbd.c.p pVar : list) {
                    int i2 = pVar.e + 1;
                    pVar.e = i2;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, " id = " + pVar.a + "  num = " + i2);
                    if (i2 >= com.getui.gtc.extension.distribution.gbd.d.d.cf) {
                        arrayList.add(pVar);
                        arrayList2.remove(pVar);
                    }
                }
                if (arrayList2.size() > 0) {
                    c(arrayList2);
                }
                if (arrayList.size() > 0) {
                    a(arrayList);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    private static void c(java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (C) {
            if (list.isEmpty()) {
                return;
            }
            int size = list.size();
            java.lang.String[] strArr = new java.lang.String[size];
            int[] iArr = new int[list.size()];
            int i2 = 0;
            for (com.getui.gtc.extension.distribution.gbd.c.p pVar : list) {
                int i3 = pVar.a;
                strArr[i2] = java.lang.String.valueOf(i3);
                iArr[i2] = pVar.e;
                i2++;
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "update ral id = ".concat(java.lang.String.valueOf(i3)));
            }
            for (int i4 = 0; i4 < size; i4++) {
                java.lang.String str = strArr[i4];
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("num", java.lang.Integer.valueOf(iArr[i4]));
                com.getui.gtc.extension.distribution.gbd.f.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.a;
                java.lang.String[] strArr2 = {"id"};
                java.lang.String[] strArr3 = {str};
                android.database.sqlite.SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.a = writableDatabase;
                writableDatabase.beginTransaction();
                try {
                    try {
                        aVar.a.update("ral", contentValues, strArr2[0] + "='" + strArr3[0] + "'", null);
                        aVar.a.setTransactionSuccessful();
                        sQLiteDatabase = aVar.a;
                    } catch (java.lang.Throwable th) {
                        aVar.a.endTransaction();
                        throw th;
                    }
                } catch (java.lang.Throwable unused) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper", "=================ralQuery Error!");
                    sQLiteDatabase = aVar.a;
                }
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void d() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(i, "init doReport isReporting = " + this.h);
        c();
        if (!com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "ral r no network.");
        } else {
            if (this.h) {
                return;
            }
            this.h = true;
            a(106);
        }
    }

    public final void a(int i2) {
        java.lang.String str;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> a2 = a(this.B, i2);
            if (!a2.isEmpty()) {
                for (int i3 = 0; i3 < a2.size(); i3++) {
                    com.getui.gtc.extension.distribution.gbd.c.p pVar = a2.get(i3);
                    if (i3 < a2.size() - 1) {
                        sb.append(pVar.c);
                        str = "\n";
                    } else {
                        str = pVar.c;
                    }
                    sb.append(str);
                    arrayList.add(pVar);
                }
                try {
                    com.getui.gtc.extension.distribution.gbd.g.a.g gVar = new com.getui.gtc.extension.distribution.gbd.g.a.g(sb.toString().getBytes("UTF-8"), i2, arrayList);
                    gVar.m = this.G;
                    if (com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(gVar))) {
                        return;
                    }
                    this.h = false;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport requestService false");
                    return;
                } catch (java.lang.Exception e2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                    this.h = false;
                    com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport requestService isReporting=false " + e2.toString());
                    return;
                }
            }
            if (i2 == 106) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 106 report over");
                a(111);
                return;
            }
            if (i2 == 111) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 111 report over");
                a(114);
                return;
            }
            if (i2 == 114) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 114 report over");
                a(119);
                return;
            }
            if (i2 == 119) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 119 report over");
                a(124);
                return;
            }
            if (i2 == 124) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 124 report over");
                a(127);
                return;
            }
            if (i2 == 127) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 127 report over");
                a(128);
                return;
            }
            if (i2 == 128) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 128 report over");
                a(131);
                return;
            }
            if (i2 == 131) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 131 report over");
                a(132);
                return;
            }
            if (i2 == 132) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 132 report over");
                a(134);
                return;
            }
            if (i2 == 134) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 134 report over");
                a(303);
                return;
            }
            if (i2 == 303) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 303 report over");
                a(116);
                return;
            }
            if (i2 == 116) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 116 report over");
                a(117);
                return;
            }
            if (i2 == 117) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 117 report over");
                a(151);
                return;
            }
            if (i2 == 151) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 151 report over");
                a(252);
                return;
            }
            if (i2 == 252) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 252 report over");
                a(254);
            } else if (i2 == 254) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 254 report over");
                a(143);
            } else if (i2 == 143) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport type 143 report over");
                this.h = false;
            }
        } catch (java.lang.Exception e3) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e3);
        }
    }

    public final void a(java.lang.String str, int i2) {
        try {
            if (!com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "ral instant r no network.");
                b(str, i2);
                return;
            }
            com.getui.gtc.extension.distribution.gbd.c.p pVar = new com.getui.gtc.extension.distribution.gbd.c.p();
            pVar.b = i2;
            pVar.c = str;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(pVar);
            com.getui.gtc.extension.distribution.gbd.g.a.g gVar = new com.getui.gtc.extension.distribution.gbd.g.a.g(str.getBytes("UTF-8"), i2, arrayList);
            gVar.m = this.F;
            try {
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(gVar));
            } catch (java.lang.Throwable unused) {
                b(str, i2);
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "instant bir requestService false.");
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "doReport requestService isReporting=false " + th.toString());
        }
    }

    public final void b() {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = com.getui.gtc.extension.distribution.gbd.d.h.a.a("select id, key, value, t, num from ral order by id");
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        int i2 = cursor.getInt(0);
                        int i3 = cursor.getInt(1);
                        byte[] b2 = com.getui.gtc.extension.distribution.gbd.n.ad.b(cursor.getBlob(2));
                        long j2 = cursor.getLong(3);
                        int i4 = cursor.getInt(4);
                        com.getui.gtc.extension.distribution.gbd.c.p pVar = new com.getui.gtc.extension.distribution.gbd.c.p();
                        pVar.a = i2;
                        pVar.b = i3;
                        pVar.c = new java.lang.String(b2);
                        pVar.d = j2;
                        pVar.e = i4;
                        this.B.add(pVar);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(i, "read list add ".concat(java.lang.String.valueOf(j2)));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (java.lang.Exception e2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
                if (cursor != null) {
                    cursor.close();
                }
            }
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e6, code lost:
    
        if (r4 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(java.lang.String str, int i2) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(i, "local save type = ".concat(java.lang.String.valueOf(i2)));
        synchronized (C) {
            if (this.B.size() >= com.getui.gtc.extension.distribution.gbd.d.d.bl) {
                java.util.Collections.sort(this.B, this.D);
                java.util.List<com.getui.gtc.extension.distribution.gbd.c.p> arrayList = new java.util.ArrayList<>();
                arrayList.add(this.B.get(0));
                a(arrayList);
                com.getui.gtc.extension.distribution.gbd.n.j.a(i, "saveRALData size > ral_size = " + com.getui.gtc.extension.distribution.gbd.d.d.bl + " remove id = " + this.B.get(0).a);
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("key", java.lang.Integer.valueOf(i2));
            contentValues.put("value", com.getui.gtc.extension.distribution.gbd.n.ad.a(str.getBytes()));
            contentValues.put("t", java.lang.Long.valueOf(currentTimeMillis));
            contentValues.put("num", (java.lang.Integer) 0);
            if (com.getui.gtc.extension.distribution.gbd.d.h.a.a("ral", contentValues) != -1) {
                android.database.Cursor cursor = null;
                try {
                    cursor = com.getui.gtc.extension.distribution.gbd.d.h.a.a("select last_insert_rowid() from ral");
                    if (cursor != null && cursor.moveToFirst()) {
                        int i3 = cursor.getInt(0);
                        com.getui.gtc.extension.distribution.gbd.c.p pVar = new com.getui.gtc.extension.distribution.gbd.c.p();
                        pVar.a = i3;
                        pVar.b = i2;
                        pVar.c = str;
                        pVar.d = currentTimeMillis;
                        pVar.e = 0;
                        this.B.add(pVar);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(i, "saveRALData instert db success id = ".concat(java.lang.String.valueOf(i3)));
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                        com.getui.gtc.extension.distribution.gbd.n.j.b(i, th.getMessage());
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(i, "saveRALData instert db failed");
            }
        }
    }

    public final void c() {
        java.util.ArrayList arrayList;
        int size;
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        synchronized (C) {
            try {
                arrayList = new java.util.ArrayList(this.B);
                size = arrayList.size() - com.getui.gtc.extension.distribution.gbd.d.d.bl;
                com.getui.gtc.extension.distribution.gbd.n.j.b(i, "list size = " + arrayList.size() + ", max = " + com.getui.gtc.extension.distribution.gbd.d.d.bl);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            if (size > 0 && com.getui.gtc.extension.distribution.gbd.d.d.bl >= 0) {
                java.util.Collections.sort(arrayList, this.E);
                long j2 = ((com.getui.gtc.extension.distribution.gbd.c.p) arrayList.get(size - 1)).d;
                for (int i2 = 0; i2 < size; i2++) {
                    com.getui.gtc.extension.distribution.gbd.c.p pVar = (com.getui.gtc.extension.distribution.gbd.c.p) arrayList.get(i2);
                    int i3 = pVar.a;
                    this.B.remove(pVar);
                    com.getui.gtc.extension.distribution.gbd.n.j.a(i, "removeRALData id = ".concat(java.lang.String.valueOf(i3)));
                }
                com.getui.gtc.extension.distribution.gbd.f.a aVar = com.getui.gtc.extension.distribution.gbd.d.h.a;
                java.lang.String[] strArr = {"t"};
                java.lang.String[] strArr2 = {java.lang.String.valueOf(j2)};
                android.database.sqlite.SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                aVar.a = writableDatabase;
                writableDatabase.beginTransaction();
                try {
                    try {
                        aVar.a.delete("ral", strArr[0] + " <= ?", strArr2);
                        aVar.a.setTransactionSuccessful();
                        sQLiteDatabase = aVar.a;
                    } catch (java.lang.Throwable th2) {
                        aVar.a.endTransaction();
                        throw th2;
                    }
                } catch (java.lang.Throwable unused) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper=================".concat("ral"), "Delete Error!");
                    sQLiteDatabase = aVar.a;
                }
                sQLiteDatabase.endTransaction();
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(i, "ral list less than the max.");
        }
    }
}

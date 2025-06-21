package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class a implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.a, com.umeng.commonsdk.statistics.proto.a.e>, java.io.Serializable, java.lang.Cloneable {
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.a.e, com.umeng.analytics.pro.co> e;
    private static final long f = 9132678615281394583L;
    private static final com.umeng.analytics.pro.dg g = new com.umeng.analytics.pro.dg("IdJournal");
    private static final com.umeng.analytics.pro.cw h = new com.umeng.analytics.pro.cw("domain", (byte) 11, 1);
    private static final com.umeng.analytics.pro.cw i = new com.umeng.analytics.pro.cw("old_id", (byte) 11, 2);
    private static final com.umeng.analytics.pro.cw j = new com.umeng.analytics.pro.cw("new_id", (byte) 11, 3);
    private static final com.umeng.analytics.pro.cw k = new com.umeng.analytics.pro.cw("ts", (byte) 10, 4);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> l;
    private static final int m = 0;
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public long d;
    private byte n;
    private com.umeng.commonsdk.statistics.proto.a.e[] o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    public static class C0523a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.a> {
        private C0523a() {
        }

        public /* synthetic */ C0523a(com.umeng.commonsdk.statistics.proto.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.a aVar) throws com.umeng.analytics.pro.ci {
            dbVar.j();
            while (true) {
                com.umeng.analytics.pro.cw l = dbVar.l();
                byte b = l.b;
                if (b == 0) {
                    break;
                }
                short s2 = l.c;
                if (s2 != 1) {
                    if (s2 != 2) {
                        if (s2 != 3) {
                            if (s2 != 4) {
                                com.umeng.analytics.pro.de.a(dbVar, b);
                            } else if (b == 10) {
                                aVar.d = dbVar.x();
                                aVar.d(true);
                            } else {
                                com.umeng.analytics.pro.de.a(dbVar, b);
                            }
                        } else if (b == 11) {
                            aVar.c = dbVar.z();
                            aVar.c(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 11) {
                        aVar.b = dbVar.z();
                        aVar.b(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 11) {
                    aVar.a = dbVar.z();
                    aVar.a(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
            dbVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new com.umeng.analytics.pro.dc("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.a aVar) throws com.umeng.analytics.pro.ci {
            aVar.n();
            dbVar.a(com.umeng.commonsdk.statistics.proto.a.g);
            if (aVar.a != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.a.h);
                dbVar.a(aVar.a);
                dbVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.a.i);
                dbVar.a(aVar.b);
                dbVar.c();
            }
            if (aVar.c != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.a.j);
                dbVar.a(aVar.c);
                dbVar.c();
            }
            dbVar.a(com.umeng.commonsdk.statistics.proto.a.k);
            dbVar.a(aVar.d);
            dbVar.c();
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.commonsdk.statistics.proto.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.a.C0523a b() {
            return new com.umeng.commonsdk.statistics.proto.a.C0523a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.a> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.commonsdk.statistics.proto.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.a aVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(aVar.a);
            dhVar.a(aVar.c);
            dhVar.a(aVar.d);
            java.util.BitSet bitSet = new java.util.BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            dhVar.a(bitSet, 1);
            if (aVar.g()) {
                dhVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.a aVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            aVar.a = dhVar.z();
            aVar.a(true);
            aVar.c = dhVar.z();
            aVar.c(true);
            aVar.d = dhVar.x();
            aVar.d(true);
            if (dhVar.b(1).get(0)) {
                aVar.b = dhVar.z();
                aVar.b(true);
            }
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.commonsdk.statistics.proto.a.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.a.c b() {
            return new com.umeng.commonsdk.statistics.proto.a.c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.a.e> e = new java.util.HashMap();
        private final short f;
        private final java.lang.String g;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.a.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.a.e eVar = (com.umeng.commonsdk.statistics.proto.a.e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.f = s2;
            this.g = str;
        }

        public static com.umeng.commonsdk.statistics.proto.a.e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        public static com.umeng.commonsdk.statistics.proto.a.e a(java.lang.String str) {
            return e.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.a.e b(int i) {
            com.umeng.commonsdk.statistics.proto.a.e a = a(i);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.cj
        public short a() {
            return this.f;
        }

        @Override // com.umeng.analytics.pro.cj
        public java.lang.String b() {
            return this.g;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        l = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.a.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.a.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.a.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.a.e.DOMAIN, (com.umeng.commonsdk.statistics.proto.a.e) new com.umeng.analytics.pro.co("domain", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.a.e.OLD_ID, (com.umeng.commonsdk.statistics.proto.a.e) new com.umeng.analytics.pro.co("old_id", (byte) 2, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.a.e.NEW_ID, (com.umeng.commonsdk.statistics.proto.a.e) new com.umeng.analytics.pro.co("new_id", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.a.e.TS, (com.umeng.commonsdk.statistics.proto.a.e) new com.umeng.analytics.pro.co("ts", (byte) 1, new com.umeng.analytics.pro.cp((byte) 10)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.a.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        e = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.a.class, unmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new com.umeng.commonsdk.statistics.proto.a.e[]{com.umeng.commonsdk.statistics.proto.a.e.OLD_ID};
    }

    public a(com.umeng.commonsdk.statistics.proto.a aVar) {
        this.n = (byte) 0;
        this.o = new com.umeng.commonsdk.statistics.proto.a.e[]{com.umeng.commonsdk.statistics.proto.a.e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    public a(java.lang.String str, java.lang.String str2, long j2) {
        this();
        this.a = str;
        this.c = str2;
        this.d = j2;
        d(true);
    }

    private void a(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectInputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    private void a(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        try {
            write(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectOutputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.a.e fieldForId(int i2) {
        return com.umeng.commonsdk.statistics.proto.a.e.a(i2);
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.a deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.a(this);
    }

    public com.umeng.commonsdk.statistics.proto.a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.a a(java.lang.String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public com.umeng.commonsdk.statistics.proto.a b(java.lang.String str) {
        this.b = str;
        return this;
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public com.umeng.commonsdk.statistics.proto.a c(java.lang.String str) {
        this.c = str;
        return this;
    }

    public void c() {
        this.a = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    @Override // com.umeng.analytics.pro.cc
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
    }

    public void d(boolean z) {
        this.n = com.umeng.analytics.pro.bz.a(this.n, 0, z);
    }

    public boolean d() {
        return this.a != null;
    }

    public java.lang.String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public java.lang.String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = com.umeng.analytics.pro.bz.b(this.n, 0);
    }

    public boolean m() {
        return com.umeng.analytics.pro.bz.a(this.n, 0);
    }

    public void n() throws com.umeng.analytics.pro.ci {
        if (this.a == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        l.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("IdJournal(");
        sb.append("domain:");
        java.lang.String str = this.a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            java.lang.String str2 = this.b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        java.lang.String str3 = this.c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        l.get(dbVar.D()).b().a(dbVar, this);
    }
}

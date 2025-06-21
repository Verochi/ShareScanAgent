package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class b implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.b, com.umeng.commonsdk.statistics.proto.b.e>, java.io.Serializable, java.lang.Cloneable {
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.b.e, com.umeng.analytics.pro.co> d;
    private static final long e = -6496538196005191531L;
    private static final com.umeng.analytics.pro.dg f = new com.umeng.analytics.pro.dg("IdSnapshot");
    private static final com.umeng.analytics.pro.cw g = new com.umeng.analytics.pro.cw("identity", (byte) 11, 1);
    private static final com.umeng.analytics.pro.cw h = new com.umeng.analytics.pro.cw("ts", (byte) 10, 2);
    private static final com.umeng.analytics.pro.cw i = new com.umeng.analytics.pro.cw("version", (byte) 8, 3);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> j;
    private static final int k = 0;
    private static final int l = 1;
    public java.lang.String a;
    public long b;
    public int c;
    private byte m;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.b> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.commonsdk.statistics.proto.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.b bVar) throws com.umeng.analytics.pro.ci {
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
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        } else if (b == 8) {
                            bVar.c = dbVar.w();
                            bVar.c(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = dbVar.x();
                        bVar.b(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = dbVar.z();
                    bVar.a(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
            dbVar.k();
            if (!bVar.g()) {
                throw new com.umeng.analytics.pro.dc("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new com.umeng.analytics.pro.dc("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.b bVar) throws com.umeng.analytics.pro.ci {
            bVar.k();
            dbVar.a(com.umeng.commonsdk.statistics.proto.b.f);
            if (bVar.a != null) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.b.g);
                dbVar.a(bVar.a);
                dbVar.c();
            }
            dbVar.a(com.umeng.commonsdk.statistics.proto.b.h);
            dbVar.a(bVar.b);
            dbVar.c();
            dbVar.a(com.umeng.commonsdk.statistics.proto.b.i);
            dbVar.a(bVar.c);
            dbVar.c();
            dbVar.d();
            dbVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    public static class C0524b implements com.umeng.analytics.pro.dk {
        private C0524b() {
        }

        public /* synthetic */ C0524b(com.umeng.commonsdk.statistics.proto.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.b.a b() {
            return new com.umeng.commonsdk.statistics.proto.b.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.b> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.commonsdk.statistics.proto.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.b bVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(bVar.a);
            dhVar.a(bVar.b);
            dhVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.b bVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            bVar.a = dhVar.z();
            bVar.a(true);
            bVar.b = dhVar.x();
            bVar.b(true);
            bVar.c = dhVar.w();
            bVar.c(true);
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.commonsdk.statistics.proto.b.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.b.c b() {
            return new com.umeng.commonsdk.statistics.proto.b.c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.b.e> d = new java.util.HashMap();
        private final short e;
        private final java.lang.String f;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.b.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.b.e eVar = (com.umeng.commonsdk.statistics.proto.b.e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.e = s2;
            this.f = str;
        }

        public static com.umeng.commonsdk.statistics.proto.b.e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
        }

        public static com.umeng.commonsdk.statistics.proto.b.e a(java.lang.String str) {
            return d.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.b.e b(int i) {
            com.umeng.commonsdk.statistics.proto.b.e a = a(i);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.cj
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.cj
        public java.lang.String b() {
            return this.f;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        j = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.b.C0524b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.b.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.b.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.b.e.IDENTITY, (com.umeng.commonsdk.statistics.proto.b.e) new com.umeng.analytics.pro.co("identity", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.b.e.TS, (com.umeng.commonsdk.statistics.proto.b.e) new com.umeng.analytics.pro.co("ts", (byte) 1, new com.umeng.analytics.pro.cp((byte) 10)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.b.e.VERSION, (com.umeng.commonsdk.statistics.proto.b.e) new com.umeng.analytics.pro.co("version", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.b.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.b.class, unmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public b(java.lang.String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    private void a(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            this.m = (byte) 0;
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
    public com.umeng.commonsdk.statistics.proto.b deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.b(this);
    }

    public com.umeng.commonsdk.statistics.proto.b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public com.umeng.commonsdk.statistics.proto.b a(java.lang.String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.umeng.commonsdk.statistics.proto.b.e fieldForId(int i2) {
        return com.umeng.commonsdk.statistics.proto.b.e.a(i2);
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.m = com.umeng.analytics.pro.bz.a(this.m, 0, z);
    }

    public void c() {
        this.a = null;
    }

    public void c(boolean z) {
        this.m = com.umeng.analytics.pro.bz.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.cc
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = com.umeng.analytics.pro.bz.b(this.m, 0);
    }

    public boolean g() {
        return com.umeng.analytics.pro.bz.a(this.m, 0);
    }

    public int h() {
        return this.c;
    }

    public void i() {
        this.m = com.umeng.analytics.pro.bz.b(this.m, 1);
    }

    public boolean j() {
        return com.umeng.analytics.pro.bz.a(this.m, 1);
    }

    public void k() throws com.umeng.analytics.pro.ci {
        if (this.a != null) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().b(dbVar, this);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("IdSnapshot(");
        sb.append("identity:");
        java.lang.String str = this.a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        j.get(dbVar.D()).b().a(dbVar, this);
    }
}

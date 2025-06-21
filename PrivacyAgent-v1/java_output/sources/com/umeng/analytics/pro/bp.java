package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bp implements com.umeng.analytics.pro.cc<com.umeng.analytics.pro.bp, com.umeng.analytics.pro.bp.e>, java.io.Serializable, java.lang.Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final java.util.Map<com.umeng.analytics.pro.bp.e, com.umeng.analytics.pro.co> k;
    private static final long l = 420342210744516016L;
    private static final com.umeng.analytics.pro.dg m = new com.umeng.analytics.pro.dg("UMEnvelope");
    private static final com.umeng.analytics.pro.cw n = new com.umeng.analytics.pro.cw("version", (byte) 11, 1);
    private static final com.umeng.analytics.pro.cw o = new com.umeng.analytics.pro.cw("address", (byte) 11, 2);
    private static final com.umeng.analytics.pro.cw p = new com.umeng.analytics.pro.cw("signature", (byte) 11, 3);
    private static final com.umeng.analytics.pro.cw q = new com.umeng.analytics.pro.cw("serial_num", (byte) 8, 4);
    private static final com.umeng.analytics.pro.cw r = new com.umeng.analytics.pro.cw("ts_secs", (byte) 8, 5);

    /* renamed from: s, reason: collision with root package name */
    private static final com.umeng.analytics.pro.cw f446s = new com.umeng.analytics.pro.cw("length", (byte) 8, 6);
    private static final com.umeng.analytics.pro.cw t = new com.umeng.analytics.pro.cw("entity", (byte) 11, 7);
    private static final com.umeng.analytics.pro.cw u = new com.umeng.analytics.pro.cw("guid", (byte) 11, 8);
    private static final com.umeng.analytics.pro.cw v = new com.umeng.analytics.pro.cw("checksum", (byte) 11, 9);
    private static final com.umeng.analytics.pro.cw w = new com.umeng.analytics.pro.cw("codex", (byte) 8, 10);
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private com.umeng.analytics.pro.bp.e[] D;
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public int d;
    public int e;
    public int f;
    public java.nio.ByteBuffer g;
    public java.lang.String h;
    public java.lang.String i;
    public int j;

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.analytics.pro.bp> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.analytics.pro.bp.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.bp bpVar) throws com.umeng.analytics.pro.ci {
            dbVar.j();
            while (true) {
                com.umeng.analytics.pro.cw l = dbVar.l();
                byte b = l.b;
                if (b == 0) {
                    dbVar.k();
                    if (!bpVar.m()) {
                        throw new com.umeng.analytics.pro.dc("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!bpVar.p()) {
                        throw new com.umeng.analytics.pro.dc("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (bpVar.s()) {
                        bpVar.G();
                        return;
                    }
                    throw new com.umeng.analytics.pro.dc("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (l.c) {
                    case 1:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.a = dbVar.z();
                            bpVar.a(true);
                            break;
                        }
                    case 2:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.b = dbVar.z();
                            bpVar.b(true);
                            break;
                        }
                    case 3:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.c = dbVar.z();
                            bpVar.c(true);
                            break;
                        }
                    case 4:
                        if (b != 8) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.d = dbVar.w();
                            bpVar.d(true);
                            break;
                        }
                    case 5:
                        if (b != 8) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.e = dbVar.w();
                            bpVar.e(true);
                            break;
                        }
                    case 6:
                        if (b != 8) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.f = dbVar.w();
                            bpVar.f(true);
                            break;
                        }
                    case 7:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.g = dbVar.A();
                            bpVar.g(true);
                            break;
                        }
                    case 8:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.h = dbVar.z();
                            bpVar.h(true);
                            break;
                        }
                    case 9:
                        if (b != 11) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.i = dbVar.z();
                            bpVar.i(true);
                            break;
                        }
                    case 10:
                        if (b != 8) {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                            break;
                        } else {
                            bpVar.j = dbVar.w();
                            bpVar.j(true);
                            break;
                        }
                    default:
                        com.umeng.analytics.pro.de.a(dbVar, b);
                        break;
                }
                dbVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.bp bpVar) throws com.umeng.analytics.pro.ci {
            bpVar.G();
            dbVar.a(com.umeng.analytics.pro.bp.m);
            if (bpVar.a != null) {
                dbVar.a(com.umeng.analytics.pro.bp.n);
                dbVar.a(bpVar.a);
                dbVar.c();
            }
            if (bpVar.b != null) {
                dbVar.a(com.umeng.analytics.pro.bp.o);
                dbVar.a(bpVar.b);
                dbVar.c();
            }
            if (bpVar.c != null) {
                dbVar.a(com.umeng.analytics.pro.bp.p);
                dbVar.a(bpVar.c);
                dbVar.c();
            }
            dbVar.a(com.umeng.analytics.pro.bp.q);
            dbVar.a(bpVar.d);
            dbVar.c();
            dbVar.a(com.umeng.analytics.pro.bp.r);
            dbVar.a(bpVar.e);
            dbVar.c();
            dbVar.a(com.umeng.analytics.pro.bp.f446s);
            dbVar.a(bpVar.f);
            dbVar.c();
            if (bpVar.g != null) {
                dbVar.a(com.umeng.analytics.pro.bp.t);
                dbVar.a(bpVar.g);
                dbVar.c();
            }
            if (bpVar.h != null) {
                dbVar.a(com.umeng.analytics.pro.bp.u);
                dbVar.a(bpVar.h);
                dbVar.c();
            }
            if (bpVar.i != null) {
                dbVar.a(com.umeng.analytics.pro.bp.v);
                dbVar.a(bpVar.i);
                dbVar.c();
            }
            if (bpVar.F()) {
                dbVar.a(com.umeng.analytics.pro.bp.w);
                dbVar.a(bpVar.j);
                dbVar.c();
            }
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.analytics.pro.bp.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.analytics.pro.bp.a b() {
            return new com.umeng.analytics.pro.bp.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.analytics.pro.bp> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.analytics.pro.bp.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.bp bpVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(bpVar.a);
            dhVar.a(bpVar.b);
            dhVar.a(bpVar.c);
            dhVar.a(bpVar.d);
            dhVar.a(bpVar.e);
            dhVar.a(bpVar.f);
            dhVar.a(bpVar.g);
            dhVar.a(bpVar.h);
            dhVar.a(bpVar.i);
            java.util.BitSet bitSet = new java.util.BitSet();
            if (bpVar.F()) {
                bitSet.set(0);
            }
            dhVar.a(bitSet, 1);
            if (bpVar.F()) {
                dhVar.a(bpVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.analytics.pro.bp bpVar) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            bpVar.a = dhVar.z();
            bpVar.a(true);
            bpVar.b = dhVar.z();
            bpVar.b(true);
            bpVar.c = dhVar.z();
            bpVar.c(true);
            bpVar.d = dhVar.w();
            bpVar.d(true);
            bpVar.e = dhVar.w();
            bpVar.e(true);
            bpVar.f = dhVar.w();
            bpVar.f(true);
            bpVar.g = dhVar.A();
            bpVar.g(true);
            bpVar.h = dhVar.z();
            bpVar.h(true);
            bpVar.i = dhVar.z();
            bpVar.i(true);
            if (dhVar.b(1).get(0)) {
                bpVar.j = dhVar.w();
                bpVar.j(true);
            }
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.analytics.pro.bp.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.analytics.pro.bp.c b() {
            return new com.umeng.analytics.pro.bp.c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final java.util.Map<java.lang.String, com.umeng.analytics.pro.bp.e> k = new java.util.HashMap();
        private final short l;
        private final java.lang.String m;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.analytics.pro.bp.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.analytics.pro.bp.e eVar = (com.umeng.analytics.pro.bp.e) it.next();
                k.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.l = s2;
            this.m = str;
        }

        public static com.umeng.analytics.pro.bp.e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
        }

        public static com.umeng.analytics.pro.bp.e a(java.lang.String str) {
            return k.get(str);
        }

        public static com.umeng.analytics.pro.bp.e b(int i) {
            com.umeng.analytics.pro.bp.e a = a(i);
            if (a != null) {
                return a;
            }
            throw new java.lang.IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.cj
        public short a() {
            return this.l;
        }

        @Override // com.umeng.analytics.pro.cj
        public java.lang.String b() {
            return this.m;
        }
    }

    static {
        java.util.HashMap hashMap = new java.util.HashMap();
        x = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.analytics.pro.bp.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.analytics.pro.bp.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.analytics.pro.bp.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.VERSION, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("version", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.ADDRESS, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("address", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.SIGNATURE, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("signature", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.SERIAL_NUM, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("serial_num", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.TS_SECS, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("ts_secs", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.LENGTH, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("length", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.ENTITY, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("entity", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11, true)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.GUID, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("guid", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.CHECKSUM, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("checksum", (byte) 1, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.analytics.pro.bp.e.CODEX, (com.umeng.analytics.pro.bp.e) new com.umeng.analytics.pro.co("codex", (byte) 2, new com.umeng.analytics.pro.cp((byte) 8)));
        java.util.Map<com.umeng.analytics.pro.bp.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        k = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.analytics.pro.bp.class, unmodifiableMap);
    }

    public bp() {
        this.C = (byte) 0;
        this.D = new com.umeng.analytics.pro.bp.e[]{com.umeng.analytics.pro.bp.e.CODEX};
    }

    public bp(com.umeng.analytics.pro.bp bpVar) {
        this.C = (byte) 0;
        this.D = new com.umeng.analytics.pro.bp.e[]{com.umeng.analytics.pro.bp.e.CODEX};
        this.C = bpVar.C;
        if (bpVar.d()) {
            this.a = bpVar.a;
        }
        if (bpVar.g()) {
            this.b = bpVar.b;
        }
        if (bpVar.j()) {
            this.c = bpVar.c;
        }
        this.d = bpVar.d;
        this.e = bpVar.e;
        this.f = bpVar.f;
        if (bpVar.w()) {
            this.g = com.umeng.analytics.pro.cd.d(bpVar.g);
        }
        if (bpVar.z()) {
            this.h = bpVar.h;
        }
        if (bpVar.C()) {
            this.i = bpVar.i;
        }
        this.j = bpVar.j;
    }

    public bp(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, int i2, int i3, java.nio.ByteBuffer byteBuffer, java.lang.String str4, java.lang.String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    private void a(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            this.C = (byte) 0;
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

    public java.lang.String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = com.umeng.analytics.pro.bz.b(this.C, 3);
    }

    public boolean F() {
        return com.umeng.analytics.pro.bz.a(this.C, 3);
    }

    public void G() throws com.umeng.analytics.pro.ci {
        if (this.a == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new com.umeng.analytics.pro.dc("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i != null) {
            return;
        }
        throw new com.umeng.analytics.pro.dc("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.umeng.analytics.pro.bp deepCopy() {
        return new com.umeng.analytics.pro.bp(this);
    }

    public com.umeng.analytics.pro.bp a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public com.umeng.analytics.pro.bp a(java.lang.String str) {
        this.a = str;
        return this;
    }

    public com.umeng.analytics.pro.bp a(java.nio.ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    public com.umeng.analytics.pro.bp a(byte[] bArr) {
        a(bArr == null ? null : java.nio.ByteBuffer.wrap(bArr));
        return this;
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public com.umeng.analytics.pro.bp b(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public com.umeng.analytics.pro.bp b(java.lang.String str) {
        this.b = str;
        return this;
    }

    public java.lang.String b() {
        return this.a;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public com.umeng.analytics.pro.bp c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public com.umeng.analytics.pro.bp c(java.lang.String str) {
        this.c = str;
        return this;
    }

    public void c() {
        this.a = null;
    }

    public void c(boolean z2) {
        if (z2) {
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
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public com.umeng.analytics.pro.bp d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    public com.umeng.analytics.pro.bp d(java.lang.String str) {
        this.h = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = com.umeng.analytics.pro.bz.a(this.C, 0, z2);
    }

    public boolean d() {
        return this.a != null;
    }

    @Override // com.umeng.analytics.pro.cc
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public com.umeng.analytics.pro.bp.e fieldForId(int i) {
        return com.umeng.analytics.pro.bp.e.a(i);
    }

    public com.umeng.analytics.pro.bp e(java.lang.String str) {
        this.i = str;
        return this;
    }

    public java.lang.String e() {
        return this.b;
    }

    public void e(boolean z2) {
        this.C = com.umeng.analytics.pro.bz.a(this.C, 1, z2);
    }

    public void f() {
        this.b = null;
    }

    public void f(boolean z2) {
        this.C = com.umeng.analytics.pro.bz.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public java.lang.String h() {
        return this.c;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public void i() {
        this.c = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public void j(boolean z2) {
        this.C = com.umeng.analytics.pro.bz.a(this.C, 3, z2);
    }

    public boolean j() {
        return this.c != null;
    }

    public int k() {
        return this.d;
    }

    public void l() {
        this.C = com.umeng.analytics.pro.bz.b(this.C, 0);
    }

    public boolean m() {
        return com.umeng.analytics.pro.bz.a(this.C, 0);
    }

    public int n() {
        return this.e;
    }

    public void o() {
        this.C = com.umeng.analytics.pro.bz.b(this.C, 1);
    }

    public boolean p() {
        return com.umeng.analytics.pro.bz.a(this.C, 1);
    }

    public int q() {
        return this.f;
    }

    public void r() {
        this.C = com.umeng.analytics.pro.bz.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        x.get(dbVar.D()).b().b(dbVar, this);
    }

    public boolean s() {
        return com.umeng.analytics.pro.bz.a(this.C, 2);
    }

    public byte[] t() {
        a(com.umeng.analytics.pro.cd.c(this.g));
        java.nio.ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("UMEnvelope(");
        sb.append("version:");
        java.lang.String str = this.a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        java.lang.String str2 = this.b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        java.lang.String str3 = this.c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        java.nio.ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            com.umeng.analytics.pro.cd.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        java.lang.String str4 = this.h;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        java.lang.String str5 = this.i;
        if (str5 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public java.nio.ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        x.get(dbVar.D()).b().a(dbVar, this);
    }

    public java.lang.String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }
}

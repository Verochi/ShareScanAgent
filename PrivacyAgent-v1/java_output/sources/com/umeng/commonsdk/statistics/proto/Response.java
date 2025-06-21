package com.umeng.commonsdk.statistics.proto;

/* loaded from: classes19.dex */
public class Response implements com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.Response, com.umeng.commonsdk.statistics.proto.Response.e>, java.io.Serializable, java.lang.Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final java.util.Map<com.umeng.commonsdk.statistics.proto.Response.e, com.umeng.analytics.pro.co> metaDataMap;
    private static final java.util.Map<java.lang.Class<? extends com.umeng.analytics.pro.dj>, com.umeng.analytics.pro.dk> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public java.lang.String msg;
    private com.umeng.commonsdk.statistics.proto.Response.e[] optionals;
    public int resp_code;
    private static final com.umeng.analytics.pro.dg STRUCT_DESC = new com.umeng.analytics.pro.dg("Response");
    private static final com.umeng.analytics.pro.cw RESP_CODE_FIELD_DESC = new com.umeng.analytics.pro.cw("resp_code", (byte) 8, 1);
    private static final com.umeng.analytics.pro.cw MSG_FIELD_DESC = new com.umeng.analytics.pro.cw("msg", (byte) 11, 2);
    private static final com.umeng.analytics.pro.cw IMPRINT_FIELD_DESC = new com.umeng.analytics.pro.cw(com.umeng.analytics.pro.bo.X, (byte) 12, 3);

    public static class a extends com.umeng.analytics.pro.dl<com.umeng.commonsdk.statistics.proto.Response> {
        private a() {
        }

        public /* synthetic */ a(com.umeng.commonsdk.statistics.proto.Response.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.Response response) throws com.umeng.analytics.pro.ci {
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
                        } else if (b == 12) {
                            com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                            response.imprint = dVar;
                            dVar.read(dbVar);
                            response.setImprintIsSet(true);
                        } else {
                            com.umeng.analytics.pro.de.a(dbVar, b);
                        }
                    } else if (b == 11) {
                        response.msg = dbVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        com.umeng.analytics.pro.de.a(dbVar, b);
                    }
                } else if (b == 8) {
                    response.resp_code = dbVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    com.umeng.analytics.pro.de.a(dbVar, b);
                }
                dbVar.m();
            }
            dbVar.k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new com.umeng.analytics.pro.dc("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.dj
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.Response response) throws com.umeng.analytics.pro.ci {
            response.validate();
            dbVar.a(com.umeng.commonsdk.statistics.proto.Response.STRUCT_DESC);
            dbVar.a(com.umeng.commonsdk.statistics.proto.Response.RESP_CODE_FIELD_DESC);
            dbVar.a(response.resp_code);
            dbVar.c();
            if (response.msg != null && response.isSetMsg()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.Response.MSG_FIELD_DESC);
                dbVar.a(response.msg);
                dbVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                dbVar.a(com.umeng.commonsdk.statistics.proto.Response.IMPRINT_FIELD_DESC);
                response.imprint.write(dbVar);
                dbVar.c();
            }
            dbVar.d();
            dbVar.b();
        }
    }

    public static class b implements com.umeng.analytics.pro.dk {
        private b() {
        }

        public /* synthetic */ b(com.umeng.commonsdk.statistics.proto.Response.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.Response.a b() {
            return new com.umeng.commonsdk.statistics.proto.Response.a(null);
        }
    }

    public static class c extends com.umeng.analytics.pro.dm<com.umeng.commonsdk.statistics.proto.Response> {
        private c() {
        }

        public /* synthetic */ c(com.umeng.commonsdk.statistics.proto.Response.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dj
        public void a(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.Response response) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            dhVar.a(response.resp_code);
            java.util.BitSet bitSet = new java.util.BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            dhVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                dhVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(dhVar);
            }
        }

        @Override // com.umeng.analytics.pro.dj
        public void b(com.umeng.analytics.pro.db dbVar, com.umeng.commonsdk.statistics.proto.Response response) throws com.umeng.analytics.pro.ci {
            com.umeng.analytics.pro.dh dhVar = (com.umeng.analytics.pro.dh) dbVar;
            response.resp_code = dhVar.w();
            response.setResp_codeIsSet(true);
            java.util.BitSet b = dhVar.b(2);
            if (b.get(0)) {
                response.msg = dhVar.z();
                response.setMsgIsSet(true);
            }
            if (b.get(1)) {
                com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint = dVar;
                dVar.read(dhVar);
                response.setImprintIsSet(true);
            }
        }
    }

    public static class d implements com.umeng.analytics.pro.dk {
        private d() {
        }

        public /* synthetic */ d(com.umeng.commonsdk.statistics.proto.Response.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.dk
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.umeng.commonsdk.statistics.proto.Response.c b() {
            return new com.umeng.commonsdk.statistics.proto.Response.c(null);
        }
    }

    public enum e implements com.umeng.analytics.pro.cj {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, com.umeng.analytics.pro.bo.X);

        private static final java.util.Map<java.lang.String, com.umeng.commonsdk.statistics.proto.Response.e> d = new java.util.HashMap();
        private final short e;
        private final java.lang.String f;

        static {
            java.util.Iterator it = java.util.EnumSet.allOf(com.umeng.commonsdk.statistics.proto.Response.e.class).iterator();
            while (it.hasNext()) {
                com.umeng.commonsdk.statistics.proto.Response.e eVar = (com.umeng.commonsdk.statistics.proto.Response.e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s2, java.lang.String str) {
            this.e = s2;
            this.f = str;
        }

        public static com.umeng.commonsdk.statistics.proto.Response.e a(int i) {
            if (i == 1) {
                return RESP_CODE;
            }
            if (i == 2) {
                return MSG;
            }
            if (i != 3) {
                return null;
            }
            return IMPRINT;
        }

        public static com.umeng.commonsdk.statistics.proto.Response.e a(java.lang.String str) {
            return d.get(str);
        }

        public static com.umeng.commonsdk.statistics.proto.Response.e b(int i) {
            com.umeng.commonsdk.statistics.proto.Response.e a = a(i);
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
        schemes = hashMap;
        hashMap.put(com.umeng.analytics.pro.dl.class, new com.umeng.commonsdk.statistics.proto.Response.b(null));
        hashMap.put(com.umeng.analytics.pro.dm.class, new com.umeng.commonsdk.statistics.proto.Response.d(null));
        java.util.EnumMap enumMap = new java.util.EnumMap(com.umeng.commonsdk.statistics.proto.Response.e.class);
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.Response.e.RESP_CODE, (com.umeng.commonsdk.statistics.proto.Response.e) new com.umeng.analytics.pro.co("resp_code", (byte) 1, new com.umeng.analytics.pro.cp((byte) 8)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.Response.e.MSG, (com.umeng.commonsdk.statistics.proto.Response.e) new com.umeng.analytics.pro.co("msg", (byte) 2, new com.umeng.analytics.pro.cp((byte) 11)));
        enumMap.put((java.util.EnumMap) com.umeng.commonsdk.statistics.proto.Response.e.IMPRINT, (com.umeng.commonsdk.statistics.proto.Response.e) new com.umeng.analytics.pro.co(com.umeng.analytics.pro.bo.X, (byte) 2, new com.umeng.analytics.pro.ct((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        java.util.Map<com.umeng.commonsdk.statistics.proto.Response.e, com.umeng.analytics.pro.co> unmodifiableMap = java.util.Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        com.umeng.analytics.pro.co.a(com.umeng.commonsdk.statistics.proto.Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new com.umeng.commonsdk.statistics.proto.Response.e[]{com.umeng.commonsdk.statistics.proto.Response.e.MSG, com.umeng.commonsdk.statistics.proto.Response.e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(com.umeng.commonsdk.statistics.proto.Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new com.umeng.commonsdk.statistics.proto.Response.e[]{com.umeng.commonsdk.statistics.proto.Response.e.MSG, com.umeng.commonsdk.statistics.proto.Response.e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectInputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        try {
            write(new com.umeng.analytics.pro.cv(new com.umeng.analytics.pro.dn(objectOutputStream)));
        } catch (com.umeng.analytics.pro.ci e2) {
            throw new java.io.IOException(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.cc
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.cc
    public com.umeng.analytics.pro.cc<com.umeng.commonsdk.statistics.proto.Response, com.umeng.commonsdk.statistics.proto.Response.e> deepCopy() {
        return new com.umeng.commonsdk.statistics.proto.Response(this);
    }

    @Override // com.umeng.analytics.pro.cc
    public com.umeng.commonsdk.statistics.proto.Response.e fieldForId(int i) {
        return com.umeng.commonsdk.statistics.proto.Response.e.a(i);
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public java.lang.String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return com.umeng.analytics.pro.bz.a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.cc
    public void read(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        schemes.get(dbVar.D()).b().b(dbVar, this);
    }

    public com.umeng.commonsdk.statistics.proto.Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public com.umeng.commonsdk.statistics.proto.Response setMsg(java.lang.String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public com.umeng.commonsdk.statistics.proto.Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = com.umeng.analytics.pro.bz.a(this.__isset_bitfield, 0, z);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            java.lang.String str = this.msg;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = com.umeng.analytics.pro.bz.b(this.__isset_bitfield, 0);
    }

    public void validate() throws com.umeng.analytics.pro.ci {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.umeng.analytics.pro.cc
    public void write(com.umeng.analytics.pro.db dbVar) throws com.umeng.analytics.pro.ci {
        schemes.get(dbVar.D()).b().a(dbVar, this);
    }
}

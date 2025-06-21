package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class al extends com.amap.api.maps.offlinemap.OfflineMapCity implements com.amap.api.mapcore.util.au, com.amap.api.mapcore.util.bl {
    public static final android.os.Parcelable.Creator<com.amap.api.mapcore.util.al> CREATOR = new com.amap.api.mapcore.util.al.AnonymousClass2();
    public final com.amap.api.mapcore.util.bp a;
    public final com.amap.api.mapcore.util.bp b;
    public final com.amap.api.mapcore.util.bp c;
    public final com.amap.api.mapcore.util.bp d;
    public final com.amap.api.mapcore.util.bp e;
    public final com.amap.api.mapcore.util.bp f;
    public final com.amap.api.mapcore.util.bp g;
    public final com.amap.api.mapcore.util.bp h;
    public final com.amap.api.mapcore.util.bp i;
    public final com.amap.api.mapcore.util.bp j;
    public final com.amap.api.mapcore.util.bp k;
    com.amap.api.mapcore.util.bp l;
    android.content.Context m;
    boolean n;
    private java.lang.String o;
    private java.lang.String p;
    private long q;

    /* renamed from: com.amap.api.mapcore.util.al$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.mapcore.util.bd.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.io.File b;

        public AnonymousClass1(java.lang.String str, java.io.File file) {
            this.a = str;
            this.b = file;
        }

        @Override // com.amap.api.mapcore.util.bd.a
        public final void a() {
            try {
                if (new java.io.File(this.a).delete()) {
                    com.amap.api.mapcore.util.bj.b(this.b);
                    com.amap.api.mapcore.util.al.this.setCompleteCode(100);
                    com.amap.api.mapcore.util.al.this.l.g();
                }
            } catch (java.lang.Exception unused) {
                com.amap.api.mapcore.util.al alVar = com.amap.api.mapcore.util.al.this;
                alVar.l.a(alVar.k.b());
            }
        }

        @Override // com.amap.api.mapcore.util.bd.a
        public final void a(float f) {
            int i = (int) ((f * 0.39d) + 60.0d);
            if (i - com.amap.api.mapcore.util.al.this.getcompleteCode() <= 0 || java.lang.System.currentTimeMillis() - com.amap.api.mapcore.util.al.this.q <= 1000) {
                return;
            }
            com.amap.api.mapcore.util.al.this.setCompleteCode(i);
            com.amap.api.mapcore.util.al.this.q = java.lang.System.currentTimeMillis();
        }

        @Override // com.amap.api.mapcore.util.bd.a
        public final void b() {
            com.amap.api.mapcore.util.al alVar = com.amap.api.mapcore.util.al.this;
            alVar.l.a(alVar.k.b());
        }
    }

    /* renamed from: com.amap.api.mapcore.util.al$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.os.Parcelable.Creator<com.amap.api.mapcore.util.al> {
        private static com.amap.api.mapcore.util.al a(android.os.Parcel parcel) {
            return new com.amap.api.mapcore.util.al(parcel);
        }

        private static com.amap.api.mapcore.util.al[] a(int i) {
            return new com.amap.api.mapcore.util.al[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.mapcore.util.al createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.mapcore.util.al[] newArray(int i) {
            return a(i);
        }
    }

    /* renamed from: com.amap.api.mapcore.util.al$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.mapcore.util.bm.a.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.mapcore.util.bm.a.amap_exception.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.mapcore.util.bm.a.file_io_exception.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.mapcore.util.bm.a.network_exception.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    private al(android.content.Context context, int i) {
        this.a = new com.amap.api.mapcore.util.br(this);
        this.b = new com.amap.api.mapcore.util.by(this);
        this.c = new com.amap.api.mapcore.util.bu(this);
        this.d = new com.amap.api.mapcore.util.bw(this);
        this.e = new com.amap.api.mapcore.util.bx(this);
        this.f = new com.amap.api.mapcore.util.bq(this);
        this.g = new com.amap.api.mapcore.util.bv(this);
        this.h = new com.amap.api.mapcore.util.bs(-1, this);
        this.i = new com.amap.api.mapcore.util.bs(101, this);
        this.j = new com.amap.api.mapcore.util.bs(102, this);
        this.k = new com.amap.api.mapcore.util.bs(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.m = context;
        a(i);
    }

    public al(android.content.Context context, com.amap.api.maps.offlinemap.OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    public al(android.os.Parcel parcel) {
        super(parcel);
        this.a = new com.amap.api.mapcore.util.br(this);
        this.b = new com.amap.api.mapcore.util.by(this);
        this.c = new com.amap.api.mapcore.util.bu(this);
        this.d = new com.amap.api.mapcore.util.bw(this);
        this.e = new com.amap.api.mapcore.util.bx(this);
        this.f = new com.amap.api.mapcore.util.bq(this);
        this.g = new com.amap.api.mapcore.util.bv(this);
        this.h = new com.amap.api.mapcore.util.bs(-1, this);
        this.i = new com.amap.api.mapcore.util.bs(101, this);
        this.j = new com.amap.api.mapcore.util.bs(102, this);
        this.k = new com.amap.api.mapcore.util.bs(103, this);
        this.o = null;
        this.p = "";
        this.n = false;
        this.q = 0L;
        this.p = parcel.readString();
    }

    private java.lang.String A() {
        if (android.text.TextUtils.isEmpty(this.o)) {
            return null;
        }
        java.lang.String str = this.o;
        return str.substring(0, str.lastIndexOf("."));
    }

    private java.lang.String B() {
        if (android.text.TextUtils.isEmpty(this.o)) {
            return null;
        }
        java.lang.String A = A();
        return A.substring(0, A.lastIndexOf(46));
    }

    private boolean C() {
        com.amap.api.mapcore.util.bj.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    private void a(java.io.File file, java.io.File file2, java.lang.String str) {
        new com.amap.api.mapcore.util.bd().a(file, file2, -1L, com.amap.api.mapcore.util.bj.a(file), new com.amap.api.mapcore.util.al.AnonymousClass1(str, file));
    }

    private void z() {
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.m);
        if (a != null) {
            a.a(this);
        }
    }

    public final java.lang.String a() {
        return this.p;
    }

    public final void a(int i) {
        if (i == -1) {
            this.l = this.h;
        } else if (i == 0) {
            this.l = this.c;
        } else if (i == 1) {
            this.l = this.e;
        } else if (i == 2) {
            this.l = this.b;
        } else if (i == 3) {
            this.l = this.d;
        } else if (i == 4) {
            this.l = this.f;
        } else if (i == 6) {
            this.l = this.a;
        } else if (i != 7) {
            switch (i) {
                case 101:
                    this.l = this.i;
                    break;
                case 102:
                    this.l = this.j;
                    break;
                case 103:
                    this.l = this.k;
                    break;
                default:
                    if (i < 0) {
                        this.l = this.h;
                        break;
                    }
                    break;
            }
        } else {
            this.l = this.g;
        }
        setState(i);
    }

    @Override // com.amap.api.mapcore.util.be
    public final void a(long j) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.q > 500) {
            int i = (int) j;
            if (i > getcompleteCode()) {
                setCompleteCode(i);
                d();
            }
            this.q = currentTimeMillis;
        }
    }

    @Override // com.amap.api.mapcore.util.bm
    public final void a(long j, long j2) {
        int i = (int) ((j2 * 100) / j);
        if (i != getcompleteCode()) {
            setCompleteCode(i);
            d();
        }
    }

    @Override // com.amap.api.mapcore.util.bm
    public final void a(com.amap.api.mapcore.util.bm.a aVar) {
        int i = com.amap.api.mapcore.util.al.AnonymousClass3.a[aVar.ordinal()];
        int b = i != 1 ? i != 2 ? i != 3 ? 6 : this.i.b() : this.k.b() : this.j.b();
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.a(b);
        }
    }

    public final void a(com.amap.api.mapcore.util.bp bpVar) {
        this.l = bpVar;
        setState(bpVar.b());
    }

    public final void a(java.lang.String str) {
        this.p = str;
    }

    public final com.amap.api.mapcore.util.bp b(int i) {
        switch (i) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }

    @Override // com.amap.api.mapcore.util.au
    public final java.lang.String b() {
        return getUrl();
    }

    @Override // com.amap.api.mapcore.util.be
    public final void b(java.lang.String str) {
        this.l.equals(this.e);
        this.p = str;
        java.lang.String A = A();
        java.lang.String B = B();
        if (android.text.TextUtils.isEmpty(A) || android.text.TextUtils.isEmpty(B)) {
            q();
            return;
        }
        java.io.File file = new java.io.File(B + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        java.io.File file2 = new java.io.File(com.amap.api.mapcore.util.dl.a(this.m) + java.io.File.separator + "map/");
        java.io.File file3 = new java.io.File(com.amap.api.mapcore.util.dl.a(this.m));
        if (file3.exists() || file3.mkdir()) {
            if (file2.exists() || file2.mkdir()) {
                a(file, file2, A);
            }
        }
    }

    public final com.amap.api.mapcore.util.bp c() {
        return this.l;
    }

    public final void d() {
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.m);
        if (a != null) {
            a.c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.m);
        if (a != null) {
            a.e(this);
            d();
        }
    }

    public final void f() {
        c().b();
        if (this.l.equals(this.d)) {
            this.l.d();
            return;
        }
        if (this.l.equals(this.c)) {
            this.l.e();
            return;
        }
        if (this.l.equals(this.g) || this.l.equals(this.h)) {
            z();
            this.n = true;
        } else if (this.l.equals(this.j) || this.l.equals(this.i) || this.l.a(this.k)) {
            this.l.c();
        } else {
            c().h();
        }
    }

    public final void g() {
        this.l.e();
    }

    public final void h() {
        this.l.a(this.k.b());
    }

    public final void i() {
        this.l.a();
        if (this.n) {
            this.l.h();
        }
        this.n = false;
    }

    public final void j() {
        this.l.equals(this.f);
        this.l.f();
    }

    public final void k() {
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.m);
        if (a != null) {
            a.b(this);
        }
    }

    public final void l() {
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(this.m);
        if (a != null) {
            a.d(this);
        }
    }

    @Override // com.amap.api.mapcore.util.bm
    public final void m() {
        this.q = 0L;
        this.l.equals(this.b);
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.bm
    public final void n() {
        this.l.equals(this.c);
        this.l.g();
    }

    @Override // com.amap.api.mapcore.util.bm
    public final void o() {
        e();
    }

    @Override // com.amap.api.mapcore.util.be
    public final void p() {
        this.q = 0L;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.c();
    }

    @Override // com.amap.api.mapcore.util.be
    public final void q() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    @Override // com.amap.api.mapcore.util.be
    public final void r() {
        e();
    }

    public final void s() {
        java.lang.String str = com.amap.api.mapcore.util.am.a;
        java.lang.String b = com.amap.api.mapcore.util.bj.b(getUrl());
        if (b != null) {
            this.o = str + b + ".zip.tmp";
            return;
        }
        this.o = str + getPinyin() + ".zip.tmp";
    }

    public final com.amap.api.mapcore.util.aw t() {
        setState(this.l.b());
        com.amap.api.mapcore.util.aw awVar = new com.amap.api.mapcore.util.aw(this, this.m);
        awVar.a(a());
        a();
        return awVar;
    }

    @Override // com.amap.api.mapcore.util.bl
    public final boolean u() {
        return C();
    }

    @Override // com.amap.api.mapcore.util.bl
    public final java.lang.String v() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String b = com.amap.api.mapcore.util.bj.b(getUrl());
        if (b != null) {
            stringBuffer.append(b);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.mapcore.util.bl
    public final java.lang.String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.p);
    }

    @Override // com.amap.api.mapcore.util.bf
    public final java.lang.String x() {
        return A();
    }

    @Override // com.amap.api.mapcore.util.bf
    public final java.lang.String y() {
        return B();
    }
}

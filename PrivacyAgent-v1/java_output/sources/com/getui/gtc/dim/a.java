package com.getui.gtc.dim;

/* loaded from: classes22.dex */
public final class a {
    private final com.getui.gtc.dim.b.c a;
    private final com.getui.gtc.dim.b.d b;
    private final com.getui.gtc.dim.b.g c;
    private final java.util.Map<java.lang.String, java.lang.Object> d;
    private final java.util.Map<java.lang.String, java.util.List<java.lang.String>> e;
    private final java.util.Map<java.lang.String, java.lang.Boolean> f;
    private final java.util.Map<java.lang.String, java.lang.Boolean> g;

    /* renamed from: com.getui.gtc.dim.a$a, reason: collision with other inner class name */
    public static class C0298a {
        private static final com.getui.gtc.dim.a a = new com.getui.gtc.dim.a((byte) 0);
    }

    private a() {
        this.d = new java.util.concurrent.ConcurrentHashMap();
        java.util.HashMap hashMap = new java.util.HashMap();
        this.e = hashMap;
        this.f = new java.util.HashMap();
        this.g = new java.util.HashMap();
        this.a = com.getui.gtc.dim.b.c.a();
        this.b = com.getui.gtc.dim.b.d.a.a;
        this.c = com.getui.gtc.dim.b.g.d();
        hashMap.put(com.getui.gtc.extension.distribution.gbd.f.e.b.N, java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.f.e.b.O, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L));
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    private void a(java.lang.String str, int i) {
        this.f.put(str, java.lang.Boolean.valueOf(i != 0));
        com.getui.gtc.dim.e.b.a("dim use expired enable set: " + str + " : " + i);
    }

    private boolean a(java.lang.String str) {
        java.lang.Boolean bool = this.f.get(str);
        if (bool == null) {
            bool = this.f.get("dim-2-2-0-1");
        }
        boolean b = b(str);
        boolean booleanValue = bool != null ? bool.booleanValue() : b;
        com.getui.gtc.dim.e.b.a("dim use expired enable check for " + str + ", dycValue = " + bool + ", localValue = " + b + ", use " + booleanValue);
        return booleanValue;
    }

    private void b(java.lang.String str, int i) {
        this.g.put(str, java.lang.Boolean.valueOf(i != 0));
        com.getui.gtc.dim.e.b.a("dim skip cache enable set: " + str + " : " + i);
    }

    private static boolean b(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "dim-2-1-1-1":
            case "dim-2-1-1-3":
            case "dim-2-1-1-4":
            case "dim-2-1-2-1":
            case "dim-2-1-2-3":
            case "dim-2-1-2-4":
            case "dim-2-1-3-1":
            case "dim-2-1-3-2":
            case "dim-2-1-4-1":
            case "dim-2-1-5-1":
            case "dim-2-1-6-1":
            case "dim-2-1-6-3":
            case "dim-2-1-6-4":
            case "dim-2-1-7-1":
            case "dim-2-1-8-1":
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0276, code lost:
    
        if (r1.equals("b2FpZF9ob25vcg==") == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x036c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.util.List<java.lang.String> c(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        char c = 2;
        java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
        encodeToString.hashCode();
        switch (encodeToString.hashCode()) {
            case -2095750756:
                if (encodeToString.equals("Y2VsbF9pbmZvX25ldw==")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -2048226647:
                if (encodeToString.equals("bmV0d29yaw==")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1779042063:
                break;
            case -1767879989:
                if (encodeToString.equals("bWFudWZhY3R1cmVy")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1762514687:
                if (encodeToString.equals("b2FpZA==")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1659575288:
                if (encodeToString.equals("d2lmaV9pbmZvX2d0")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1559644363:
                if (encodeToString.equals("Z2V0dWlfZGV2aWNlX2lk")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1464199328:
                if (encodeToString.equals("aWNjaWRfbWFpbg==")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1400038172:
                if (encodeToString.equals("bWFjX3dsYW4w")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1337142239:
                if (encodeToString.equals("aW1laQ==")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1337139108:
                if (encodeToString.equals("aW1laTE=")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1337138984:
                if (encodeToString.equals("aW1laTI=")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1324212945:
                if (encodeToString.equals("aW1zaQ==")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1324209814:
                if (encodeToString.equals("aW1zaTE=")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1324209690:
                if (encodeToString.equals("aW1zaTI=")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1218674678:
                if (encodeToString.equals("YWR2ZXJ0aXNpbmdfaWQ=")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1217318981:
                if (encodeToString.equals("d2lmaV9zY2FuX2xpc3Q=")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case -1033769178:
                if (encodeToString.equals("c2VyaWFsX251bWJlcg==")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -997367387:
                if (encodeToString.equals("bG9jYXRpb25fZ3Bz")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -814408606:
                if (encodeToString.equals("d2lmaV9pbmZv")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -811004243:
                if (encodeToString.equals("d2lmaV9tYWM=")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case -508737516:
                if (encodeToString.equals("aWNjaWQ=")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case -508737457:
                if (encodeToString.equals("aWNjaWQx")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case -508737456:
                if (encodeToString.equals("aWNjaWQy")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -367876355:
                if (encodeToString.equals("bG9jYXRpb25fbmV0d29yaw==")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -17088614:
                if (encodeToString.equals("aXB2NA==")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -17052096:
                if (encodeToString.equals("aXB2Ng==")) {
                    c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                    break;
                }
                c = 65535;
                break;
            case 2976371:
                if (encodeToString.equals("aXA=")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 3001790:
                if (encodeToString.equals("c3lz")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 3005401:
                if (encodeToString.equals("bWFj")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case 3055941:
                if (encodeToString.equals("cm9t")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 79802473:
                if (encodeToString.equals("YXBwX2xpc3RfYnlfbG9jYWxfZGlycw==")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 142694456:
                if (encodeToString.equals("YXBwX2xpc3RfYnlfY29tcGxleF9wb2xpY3k=")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 193136789:
                if (encodeToString.equals("Y2VsbA==")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 261839736:
                if (encodeToString.equals("Y2VsbF9pbmZv")) {
                    c = kotlin.text.Typography.quote;
                    break;
                }
                c = 65535;
                break;
            case 308427546:
                if (encodeToString.equals("Y2Fycmllcg==")) {
                    c = '#';
                    break;
                }
                c = 65535;
                break;
            case 372428747:
                if (encodeToString.equals("bG9jYXRpb25fZ3BzX2d0")) {
                    c = kotlin.text.Typography.dollar;
                    break;
                }
                c = 65535;
                break;
            case 633576810:
                if (encodeToString.equals("bW9kZWw=")) {
                    c = '%';
                    break;
                }
                c = 65535;
                break;
            case 1148798111:
                if (encodeToString.equals("bWFjX2FsbA==")) {
                    c = kotlin.text.Typography.amp;
                    break;
                }
                c = 65535;
                break;
            case 1196833449:
                if (encodeToString.equals("bG9jYXRpb25fbmV0d29ya19ndA==")) {
                    c = '\'';
                    break;
                }
                c = 65535;
                break;
            case 1321129970:
                if (encodeToString.equals("YXBwX2xpc3RfYnlfcXVlcnlfaW50ZW50")) {
                    c = '(';
                    break;
                }
                c = 65535;
                break;
            case 1396586978:
                if (encodeToString.equals("YXBwX2xpc3RfYnlfcG1fbGlzdA==")) {
                    c = ')';
                    break;
                }
                c = 65535;
                break;
            case 1444607276:
                if (encodeToString.equals("YXBwX2xpc3RfYnlfaW5zdGFsbGVkX3BhY2thZ2U=")) {
                    c = '*';
                    break;
                }
                c = 65535;
                break;
            case 1550084458:
                if (encodeToString.equals("YnJhbmQ=")) {
                    c = '+';
                    break;
                }
                c = 65535;
                break;
            case 1550874440:
                if (encodeToString.equals("aW1laV9tYWlu")) {
                    c = ',';
                    break;
                }
                c = 65535;
                break;
            case 1846142911:
                if (encodeToString.equals("YW5kcm9pZF9pZA==")) {
                    c = '-';
                    break;
                }
                c = 65535;
                break;
            case 2016315734:
                if (encodeToString.equals("aW1zaV9tYWlu")) {
                    c = '.';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.J;
        switch (c) {
            case 0:
                arrayList.add(str2);
                break;
            case 1:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.x;
                arrayList.add(str2);
                break;
            case 2:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.l;
                arrayList.add(str2);
                break;
            case 3:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.u;
                arrayList.add(str2);
                break;
            case 4:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.k;
                arrayList.add(str2);
                break;
            case 5:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.H;
                arrayList.add(str2);
                break;
            case 6:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.P;
                arrayList.add(str2);
                break;
            case 7:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.m);
                break;
            case '\b':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.h);
                break;
            case '\t':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.b);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.c);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.d);
                break;
            case '\n':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.c;
                arrayList.add(str2);
                break;
            case 11:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.d);
                break;
            case '\f':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.e);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.f);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.g);
                break;
            case '\r':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.f);
                break;
            case 14:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.g);
                break;
            case 15:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.q;
                arrayList.add(str2);
                break;
            case 16:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.F;
                arrayList.add(str2);
                break;
            case 17:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.j;
                arrayList.add(str2);
                break;
            case 18:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.A;
                arrayList.add(str2);
                break;
            case 19:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.E;
                arrayList.add(str2);
                break;
            case 20:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.G;
                arrayList.add(str2);
                break;
            case 21:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.m);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.n);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.o);
                break;
            case 22:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.n);
                break;
            case 23:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.o);
                break;
            case 24:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.B;
                arrayList.add(str2);
                break;
            case 25:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
                break;
            case 26:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.z);
                break;
            case 27:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.y);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.z);
                break;
            case 28:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.v;
                arrayList.add(str2);
                break;
            case 29:
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.h);
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.i);
                break;
            case 30:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.t;
                arrayList.add(str2);
                break;
            case 31:
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.M;
                arrayList.add(str2);
                break;
            case ' ':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.N;
                arrayList.add(str2);
                break;
            case '!':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.I);
                arrayList.add(str2);
                break;
            case '\"':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.I);
                break;
            case '#':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.w;
                arrayList.add(str2);
                break;
            case '$':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.C;
                arrayList.add(str2);
                break;
            case '%':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.f330s;
                arrayList.add(str2);
                break;
            case '&':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.i);
                break;
            case '\'':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.D;
                arrayList.add(str2);
                break;
            case '(':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.K;
                arrayList.add(str2);
                break;
            case ')':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.O;
                arrayList.add(str2);
                break;
            case '*':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.L;
                arrayList.add(str2);
                break;
            case '+':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.r;
                arrayList.add(str2);
                break;
            case ',':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.b);
                break;
            case '-':
                str2 = com.getui.gtc.extension.distribution.gbd.f.e.b.p;
                arrayList.add(str2);
                break;
            case '.':
                arrayList.add(com.getui.gtc.extension.distribution.gbd.f.e.b.e);
                break;
        }
    }

    private void c(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        this.e.put(str, arrayList);
        for (java.lang.String str3 : str2.split(",")) {
            arrayList.add(str3.trim().toLowerCase());
        }
        com.getui.gtc.dim.e.b.a("dim complex policy set: " + str + " : " + str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e1 A[Catch: all -> 0x02bf, TryCatch #1 {, blocks: (B:35:0x0094, B:37:0x009b, B:39:0x00a5, B:41:0x00b1, B:42:0x00b7, B:47:0x00e1, B:49:0x0108, B:53:0x0117, B:55:0x011f, B:57:0x0125, B:59:0x012d, B:60:0x0111, B:61:0x0153, B:64:0x015f, B:65:0x016b, B:66:0x018c, B:67:0x018e, B:69:0x0190, B:71:0x0198, B:73:0x01a0, B:74:0x01bb, B:76:0x01bd, B:78:0x01c3, B:80:0x01cb, B:81:0x01ef, B:83:0x01f1, B:85:0x0218, B:88:0x0220, B:90:0x0228, B:91:0x024f, B:94:0x0253, B:96:0x025b, B:97:0x0282, B:99:0x0284, B:101:0x028e, B:102:0x02bb, B:103:0x02bd), top: B:34:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0190 A[Catch: all -> 0x02bf, TryCatch #1 {, blocks: (B:35:0x0094, B:37:0x009b, B:39:0x00a5, B:41:0x00b1, B:42:0x00b7, B:47:0x00e1, B:49:0x0108, B:53:0x0117, B:55:0x011f, B:57:0x0125, B:59:0x012d, B:60:0x0111, B:61:0x0153, B:64:0x015f, B:65:0x016b, B:66:0x018c, B:67:0x018e, B:69:0x0190, B:71:0x0198, B:73:0x01a0, B:74:0x01bb, B:76:0x01bd, B:78:0x01c3, B:80:0x01cb, B:81:0x01ef, B:83:0x01f1, B:85:0x0218, B:88:0x0220, B:90:0x0228, B:91:0x024f, B:94:0x0253, B:96:0x025b, B:97:0x0282, B:99:0x0284, B:101:0x028e, B:102:0x02bb, B:103:0x02bd), top: B:34:0x0094 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object a(com.getui.gtc.dim.DimRequest dimRequest, boolean z) {
        boolean z2;
        if (dimRequest == null || android.text.TextUtils.isEmpty(dimRequest.getKey())) {
            return null;
        }
        com.getui.gtc.dim.e.b.a(dimRequest.toString());
        java.lang.String key = dimRequest.getKey();
        boolean z3 = false;
        if (z && this.e.containsKey(key)) {
            java.util.List<java.lang.String> list = this.e.get(dimRequest.getKey());
            if (list == null || list.size() <= 0) {
                com.getui.gtc.dim.e.b.b("dim not found subKeys for " + dimRequest.getKey());
            } else {
                for (java.lang.String str : list) {
                    com.getui.gtc.dim.DimRequest build = new com.getui.gtc.dim.DimRequest.Builder(dimRequest).build();
                    build.setKey(str);
                    java.lang.Object a = a(build, false);
                    if (com.getui.gtc.dim.e.c.a(a)) {
                        return a;
                    }
                }
            }
            return null;
        }
        synchronized (this.d) {
            if (this.d.get(key) == null) {
                this.d.put(key, new java.lang.Object());
            }
        }
        synchronized (this.d.get(key)) {
            if (dimRequest.isSkipCache()) {
                java.lang.Boolean bool = this.g.get(key);
                if (bool == null) {
                    bool = this.g.get("dim-2-2-0-1");
                }
                boolean booleanValue = bool != null ? bool.booleanValue() : false;
                com.getui.gtc.dim.e.b.a("dim skip cache enable check for " + key + ", dycValue = " + bool + ", localValue = false, use " + booleanValue);
                if (booleanValue) {
                    z2 = true;
                    if (!z2) {
                        com.getui.gtc.dim.b.e a2 = this.c.a(dimRequest);
                        com.getui.gtc.dim.e.b.a(key + " skip cache call dim from " + a2.a);
                        if (!com.getui.gtc.dim.e.c.a(a2.b)) {
                            com.getui.gtc.dim.b.h a3 = this.a.a(key);
                            if (a3 == null) {
                                a3 = com.getui.gtc.dim.b.d.a(key);
                            }
                            if (a3 != null && com.getui.gtc.dim.e.c.a(a3.a) && (a(key) || !this.b.a(a3, key))) {
                                this.a.a(key, a3.a, -1L);
                                com.getui.gtc.dim.b.d.a(key, a3.a);
                                com.getui.gtc.dim.e.b.a(key + " update dim ram and storage result = " + a3.a);
                                z3 = true;
                            }
                        }
                        java.lang.String str2 = a2.a;
                        if (!"none".equals(str2)) {
                            if (!z3) {
                                this.a.a(key, a2.b, -1L);
                                com.getui.gtc.dim.b.d.a(key, a2.b);
                            }
                            com.getui.gtc.dim.e.b.a(key + " use dim " + str2 + " result = " + a2.b);
                        }
                        return a2.b;
                    }
                    com.getui.gtc.dim.b.h a4 = this.a.a(key);
                    if (a4 != null && !this.b.a(a4, key)) {
                        com.getui.gtc.dim.e.b.a(key + " use dim ram result = " + a4.a);
                        return a4.a;
                    }
                    com.getui.gtc.dim.b.h a5 = com.getui.gtc.dim.b.d.a(key);
                    if (a5 != null && !this.b.a(a5, key)) {
                        this.a.a(key, a5.a, a5.b);
                        com.getui.gtc.dim.e.b.a(key + " use dim storage result = " + a5.a);
                        return a5.a;
                    }
                    com.getui.gtc.dim.b.e a6 = this.c.a(dimRequest);
                    com.getui.gtc.dim.e.b.a(key + " call dim from " + a6.a);
                    if (!com.getui.gtc.dim.e.c.a(a6.b) && a(key)) {
                        if (a4 != null && com.getui.gtc.dim.e.c.a(a4.a)) {
                            this.a.a(key, a4.a, -1L);
                            com.getui.gtc.dim.b.d.a(key, a4.a);
                            com.getui.gtc.dim.e.b.a(key + " use dim ram result for reserve = " + a4.a);
                            return a4.a;
                        }
                        if (a5 != null && com.getui.gtc.dim.e.c.a(a5.a)) {
                            this.a.a(key, a5.a, -1L);
                            com.getui.gtc.dim.b.d.a(key, a5.a);
                            com.getui.gtc.dim.e.b.a(key + " use dim storage result for reserve = " + a5.a);
                            return a5.a;
                        }
                    }
                    java.lang.String str3 = a6.a;
                    if (!"none".equals(str3)) {
                        this.a.a(key, a6.b, -1L);
                        com.getui.gtc.dim.b.d.a(key, a6.b);
                        com.getui.gtc.dim.e.b.a(key + " use dim " + str3 + " result = " + a6.b);
                    }
                    return a6.b;
                }
            }
            z2 = false;
            if (!z2) {
            }
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        char c;
        try {
            char c2 = 0;
            char c3 = 1;
            switch (str.hashCode()) {
                case 1673842650:
                    if (str.equals("dim-2-2-1-1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1673843611:
                    if (str.equals("dim-2-2-2-1")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1673844572:
                    if (str.equals("dim-2-2-3-1")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1673845533:
                    if (str.equals("dim-2-2-4-1")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c == 1) {
                    this.c.f(str2);
                    return;
                } else if (c == 2) {
                    this.c.a(com.getui.gtc.dim.Caller.valueOf(str2));
                    return;
                } else {
                    if (c != 3) {
                        return;
                    }
                    com.getui.gtc.dim.b.b.a().a(java.lang.Long.parseLong(str2));
                    return;
                }
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                this.c.c(str2);
                try {
                    java.lang.String optString = jSONObject.optString("sdk.gtc.dim.pm.use_uid.policy");
                    if (!android.text.TextUtils.isEmpty(optString) && !"none".equals(optString)) {
                        for (java.lang.String str3 : optString.split(",")) {
                            if (str3.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split = str3.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                int parseInt = java.lang.Integer.parseInt(split[1]);
                                if ("*".equals(split[0])) {
                                    this.c.a("dim-2-2-0-1", parseInt);
                                } else {
                                    this.c.a(split[0], parseInt);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.dim.e.b.a(th);
                }
                try {
                    java.lang.String optString2 = jSONObject.optString("sdk.gtc.dim.storage.valid.time");
                    if (!android.text.TextUtils.isEmpty(optString2)) {
                        java.lang.String[] split2 = optString2.split(",");
                        int length = split2.length;
                        int i = 0;
                        while (i < length) {
                            java.lang.String str4 = split2[i];
                            if (str4.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split3 = str4.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c4 = c(split3[c2]);
                                long parseLong = java.lang.Long.parseLong(split3[c3]) * 1000;
                                java.util.Iterator<java.lang.String> it = c4.iterator();
                                while (it.hasNext()) {
                                    this.b.a(it.next(), parseLong);
                                }
                            } else {
                                this.b.a("dim-2-2-0-1", java.lang.Long.parseLong(str4) * 1000);
                            }
                            i++;
                            c2 = 0;
                            c3 = 1;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    com.getui.gtc.dim.e.b.a(th2);
                }
                try {
                    java.lang.String optString3 = jSONObject.optString("sdk.gtc.dim.rom.map.extension");
                    if (!android.text.TextUtils.isEmpty(optString3) && !optString3.equals("none")) {
                        for (java.lang.String str5 : optString3.toLowerCase().split(",")) {
                            java.lang.String[] split4 = str5.trim().split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            if (split4.length >= 2) {
                                com.getui.gtc.dim.c.a.a.put(split4[0].trim(), split4[1].trim());
                                com.getui.gtc.dim.e.b.a("dim sys rom map set: " + split4[0].trim() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + split4[1].trim());
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    com.getui.gtc.dim.e.b.a(th3);
                }
                try {
                    java.lang.String optString4 = jSONObject.optString("sdk.gtc.dim.sys.call.black.version");
                    if (!android.text.TextUtils.isEmpty(optString4) && !"none".equals(optString4)) {
                        for (java.lang.String str6 : optString4.split(",")) {
                            if (str6.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split5 = str6.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                if ("*".equals(split5[0])) {
                                    this.c.e("dim-2-2-0-1", split5[1]);
                                } else {
                                    java.util.Iterator<java.lang.String> it2 = c(split5[0]).iterator();
                                    while (it2.hasNext()) {
                                        this.c.e(it2.next(), split5[1]);
                                    }
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    com.getui.gtc.dim.e.b.a(th4);
                }
                try {
                    java.lang.String optString5 = jSONObject.optString("sdk.gtc.dim.sys.call.black.model");
                    if (!android.text.TextUtils.isEmpty(optString5) && !"none".equals(optString5)) {
                        for (java.lang.String str7 : optString5.split(",")) {
                            if (str7.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split6 = str7.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.Iterator<java.lang.String> it3 = c(split6[0]).iterator();
                                while (it3.hasNext()) {
                                    this.c.g(it3.next(), split6[1]);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th5) {
                    com.getui.gtc.dim.e.b.a(th5);
                }
                try {
                    java.lang.String optString6 = jSONObject.optString("sdk.gtc.dim.sys.call.black.rom");
                    if (!android.text.TextUtils.isEmpty(optString6) && !"none".equals(optString6)) {
                        java.lang.String[] split7 = optString6.split(",");
                        int length2 = split7.length;
                        int i2 = 0;
                        while (i2 < length2) {
                            java.lang.String str8 = split7[i2];
                            if (str8.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split8 = str8.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c5 = c(split8[0]);
                                for (int i3 = 1; i3 < split8.length; i3++) {
                                    java.util.Iterator<java.lang.String> it4 = c5.iterator();
                                    while (it4.hasNext()) {
                                        java.lang.String[] strArr = split7;
                                        int i4 = length2;
                                        this.c.f(it4.next(), split8[i3]);
                                        split7 = strArr;
                                        length2 = i4;
                                    }
                                }
                            }
                            i2++;
                            split7 = split7;
                            length2 = length2;
                        }
                    }
                } catch (java.lang.Throwable th6) {
                    com.getui.gtc.dim.e.b.a(th6);
                }
                try {
                    java.lang.String optString7 = jSONObject.optString("sdk.gtc.dim.sys.call.enable");
                    if (!android.text.TextUtils.isEmpty(optString7)) {
                        for (java.lang.String str9 : optString7.split(",")) {
                            if (str9.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split9 = str9.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c6 = c(split9[0]);
                                int parseInt2 = java.lang.Integer.parseInt(split9[1]);
                                java.util.Iterator<java.lang.String> it5 = c6.iterator();
                                while (it5.hasNext()) {
                                    this.c.b(it5.next(), parseInt2);
                                }
                            } else {
                                this.c.b("dim-2-2-0-1", java.lang.Integer.parseInt(str9));
                            }
                        }
                    }
                } catch (java.lang.Throwable th7) {
                    com.getui.gtc.dim.e.b.a(th7);
                }
                try {
                    java.lang.String optString8 = jSONObject.optString("sdk.gtc.dim.sys.hw.oaid.enable");
                    if (!android.text.TextUtils.isEmpty(optString8) && !"none".equals(optString8)) {
                        this.c.c(java.lang.Integer.parseInt(optString8));
                    }
                } catch (java.lang.Throwable th8) {
                    com.getui.gtc.dim.e.b.a(th8);
                }
                try {
                    java.lang.String optString9 = jSONObject.optString("sdk.gtc.dim.halfclosed.policy");
                    if (!android.text.TextUtils.isEmpty(optString9) && !"none".equals(optString9)) {
                        com.getui.gtc.dim.b.b.a().a(optString9);
                    }
                } catch (java.lang.Throwable th9) {
                    com.getui.gtc.dim.e.b.a(th9);
                }
                try {
                    java.lang.String optString10 = jSONObject.optString("sdk.gtc.dim.halfclosed.enable");
                    if (!android.text.TextUtils.isEmpty(optString10) && !"none".equals(optString10)) {
                        for (com.getui.gtc.dim.b.b.a aVar : com.getui.gtc.dim.b.b.d(optString10)) {
                            if ("all".equals(aVar.a)) {
                                com.getui.gtc.dim.b.b.a().a("dim-2-2-0-1", aVar);
                            } else {
                                java.util.Iterator<java.lang.String> it6 = c(aVar.a).iterator();
                                while (it6.hasNext()) {
                                    com.getui.gtc.dim.b.b.a().a(it6.next(), aVar);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th10) {
                    com.getui.gtc.dim.e.b.a(th10);
                }
                try {
                    java.lang.String optString11 = jSONObject.optString("sdk.gtc.dim.sys.call.policy");
                    if (!android.text.TextUtils.isEmpty(optString11)) {
                        for (java.lang.String str10 : optString11.split(",")) {
                            if (str10.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split10 = str10.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c7 = c(split10[0]);
                                int parseInt3 = java.lang.Integer.parseInt(split10[1]);
                                java.util.Iterator<java.lang.String> it7 = c7.iterator();
                                while (it7.hasNext()) {
                                    this.c.c(it7.next(), parseInt3);
                                }
                            } else {
                                this.c.c("dim-2-2-0-1", java.lang.Integer.parseInt(str10));
                            }
                        }
                    }
                } catch (java.lang.Throwable th11) {
                    com.getui.gtc.dim.e.b.a(th11);
                }
                try {
                    java.lang.String optString12 = jSONObject.optString("sdk.gtc.dim.use.expired.enable");
                    if (!android.text.TextUtils.isEmpty(optString12)) {
                        for (java.lang.String str11 : optString12.split(",")) {
                            if (str11.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split11 = str11.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c8 = c(split11[0]);
                                int parseInt4 = java.lang.Integer.parseInt(split11[1]);
                                java.util.Iterator<java.lang.String> it8 = c8.iterator();
                                while (it8.hasNext()) {
                                    a(it8.next(), parseInt4);
                                }
                            } else {
                                a("dim-2-2-0-1", java.lang.Integer.parseInt(str11));
                            }
                        }
                    }
                } catch (java.lang.Throwable th12) {
                    com.getui.gtc.dim.e.b.a(th12);
                }
                try {
                    java.lang.String optString13 = jSONObject.optString("sdk.gtc.dim.skip.cache.enable");
                    if (!android.text.TextUtils.isEmpty(optString13)) {
                        for (java.lang.String str12 : optString13.split(",")) {
                            if (str12.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split12 = str12.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.List<java.lang.String> c9 = c(split12[0]);
                                int parseInt5 = java.lang.Integer.parseInt(split12[1]);
                                java.util.Iterator<java.lang.String> it9 = c9.iterator();
                                while (it9.hasNext()) {
                                    b(it9.next(), parseInt5);
                                }
                            } else {
                                b("dim-2-2-0-1", java.lang.Integer.parseInt(str12));
                            }
                        }
                    }
                } catch (java.lang.Throwable th13) {
                    com.getui.gtc.dim.e.b.a(th13);
                }
                try {
                    java.lang.String optString14 = jSONObject.optString("sdk.gtc.dim.sys.call.disallow");
                    if (!android.text.TextUtils.isEmpty(optString14) && !"*".equals(optString14)) {
                        for (java.lang.String str13 : optString14.split(",")) {
                            if (str13.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split13 = str13.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.Iterator<java.lang.String> it10 = c(split13[0]).iterator();
                                while (it10.hasNext()) {
                                    this.c.c(it10.next(), split13[1]);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th14) {
                    com.getui.gtc.dim.e.b.a(th14);
                }
                try {
                    java.lang.String optString15 = jSONObject.optString("sdk.gtc.dim.sys.trace.enable");
                    if (!android.text.TextUtils.isEmpty(optString15) && !"none".equals(optString15)) {
                        this.c.b(java.lang.Integer.parseInt(optString15));
                    }
                } catch (java.lang.Throwable th15) {
                    com.getui.gtc.dim.e.b.a(th15);
                }
                try {
                    java.lang.String optString16 = jSONObject.optString("sdk.gtc.dim.sys.trace.order");
                    if (!android.text.TextUtils.isEmpty(optString16)) {
                        for (java.lang.String str14 : optString16.split(",")) {
                            if (str14.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                java.lang.String[] split14 = str14.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                java.util.Iterator<java.lang.String> it11 = c(split14[0]).iterator();
                                while (it11.hasNext()) {
                                    this.c.d(it11.next(), split14[1]);
                                }
                            } else {
                                this.c.d("dim-2-2-0-1", str14);
                            }
                        }
                    }
                } catch (java.lang.Throwable th16) {
                    com.getui.gtc.dim.e.b.a(th16);
                }
                try {
                    java.lang.String optString17 = jSONObject.optString("sdk.gtc.dim.busi.enable");
                    if (!android.text.TextUtils.isEmpty(optString17) && !"none".equals(optString17)) {
                        this.c.a(java.lang.Integer.parseInt(optString17));
                    }
                } catch (java.lang.Throwable th17) {
                    com.getui.gtc.dim.e.b.a(th17);
                }
                try {
                    java.lang.String optString18 = jSONObject.optString("sdk.gtc.dim.al.tech_policy");
                    if (!android.text.TextUtils.isEmpty(optString18)) {
                        for (java.lang.String str15 : optString18.split(",")) {
                            java.lang.String[] split15 = str15.trim().split("#");
                            if (split15.length >= 2) {
                                com.getui.gtc.dim.c.a.b.put(split15[0].trim().toLowerCase(), split15[1].trim());
                                com.getui.gtc.dim.e.b.a("dim sys permission map set: " + split15[0].trim() + "#" + split15[1].trim());
                            }
                        }
                    }
                } catch (java.lang.Throwable th18) {
                    com.getui.gtc.dim.e.b.a(th18);
                }
                try {
                    java.lang.String optString19 = jSONObject.optString("sdk.gtc.dim.complex.policy");
                    if (android.text.TextUtils.isEmpty(optString19) || optString19.equals("none")) {
                        return;
                    }
                    for (java.lang.String str16 : optString19.split(",")) {
                        java.lang.String[] split16 = str16.split("#");
                        java.util.List<java.lang.String> c10 = c(split16[0]);
                        java.lang.String[] split17 = split16[1].split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (java.lang.String str17 : split17) {
                            java.util.Iterator<java.lang.String> it12 = c(str17).iterator();
                            while (it12.hasNext()) {
                                sb.append(it12.next());
                                sb.append(",");
                            }
                        }
                        java.util.Iterator<java.lang.String> it13 = c10.iterator();
                        while (it13.hasNext()) {
                            c(it13.next(), sb.toString());
                        }
                    }
                } catch (java.lang.Throwable th19) {
                    com.getui.gtc.dim.e.b.a(th19);
                }
            } catch (java.lang.Throwable th20) {
                com.getui.gtc.dim.e.b.a(th20);
            }
        } catch (java.lang.Throwable th21) {
            com.getui.gtc.dim.e.b.b(th21);
        }
    }

    public final boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        char c;
        try {
            switch (str.hashCode()) {
                case 378146557:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.f329s)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 378146558:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.t)) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 378147518:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.u)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 378147519:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.v)) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 378148479:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.w)) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 378149440:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.x)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 378149441:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.y)) {
                        c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        break;
                    }
                    c = 65535;
                    break;
                case 378150401:
                    if (str.equals("dim-2-3-14-1")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 378150402:
                    if (str.equals("dim-2-3-14-2")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 378151362:
                    if (str.equals("dim-2-3-15-1")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 378151363:
                    if (str.equals("dim-2-3-15-2")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 378152323:
                    if (str.equals("dim-2-3-16-1")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 378152324:
                    if (str.equals("dim-2-3-16-2")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674766171:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.a)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674766172:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.b)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674767132:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.c)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674767133:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.d)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674768093:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.e)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674768094:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.f)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674769054:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.g)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674769055:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.h)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770015:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.i)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770016:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.j)) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770976:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.k)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770977:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.l)) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674771937:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.m)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674771938:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.n)) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674772898:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.o)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674772899:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.p)) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674773859:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.q)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1674773860:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.r)) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
            case 14:
                return this.c.a(str, com.getui.gtc.dim.Caller.valueOf(str2), java.lang.Boolean.parseBoolean(str3));
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
                com.getui.gtc.dim.b.d dVar = this.b;
                com.getui.gtc.dim.Caller valueOf = com.getui.gtc.dim.Caller.valueOf(str2);
                long parseLong = java.lang.Long.parseLong(str3);
                com.getui.gtc.dim.e.b.a("dim storage caller interval set: " + str + " : " + valueOf + " : " + parseLong);
                com.getui.gtc.dim.b.a a = com.getui.gtc.dim.b.a.a(str);
                if (a == null || parseLong < a.c || parseLong > a.d) {
                    return false;
                }
                dVar.a.put(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + valueOf.name(), java.lang.Long.valueOf(parseLong));
                com.getui.gtc.dim.b.d.a(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + valueOf.name(), java.lang.Long.valueOf(parseLong));
                return true;
            case 30:
                return this.c.b(str, com.getui.gtc.dim.Caller.valueOf(str2), java.lang.Boolean.parseBoolean(str3));
            default:
                return false;
        }
    }

    public final java.io.Serializable b(java.lang.String str, java.lang.String str2) {
        char c;
        try {
            switch (str.hashCode()) {
                case 378146557:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.f329s)) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 378146558:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.t)) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case 378147518:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.u)) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 378147519:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.v)) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case 378148479:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.w)) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case 378149440:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.x)) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case 378149441:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.y)) {
                        c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                        break;
                    }
                    c = 65535;
                    break;
                case 378150401:
                    if (str.equals("dim-2-3-14-1")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 378150402:
                    if (str.equals("dim-2-3-14-2")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case 378151362:
                    if (str.equals("dim-2-3-15-1")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 378151363:
                    if (str.equals("dim-2-3-15-2")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 378152323:
                    if (str.equals("dim-2-3-16-1")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 378152324:
                    if (str.equals("dim-2-3-16-2")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674766171:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.a)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674766172:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.b)) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674767132:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.c)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674767133:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.d)) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674768093:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.e)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674768094:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.f)) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674769054:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.g)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674769055:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.h)) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770015:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.i)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770016:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.j)) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770976:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.k)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674770977:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.l)) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674771937:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.m)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674771938:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.n)) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674772898:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.o)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674772899:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.p)) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                case 1674773859:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.q)) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 1674773860:
                    if (str.equals(com.getui.gtc.extension.distribution.gbd.f.e.a.r)) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                    return this.c.b(str, str2);
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    return this.b.a(str, str2);
                case 30:
                    return java.lang.Boolean.valueOf(this.c.a(str, str2));
                default:
                    return null;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.dim.e.b.b(th);
            return null;
        }
    }
}

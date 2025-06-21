package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ew {
    private static volatile boolean C = false;
    public static int a = -1;
    public static java.lang.String b = "";
    public static android.content.Context c = null;
    private static java.lang.String k = "6";
    private static java.lang.String l = "4";
    private static java.lang.String m = "9";
    private static java.lang.String n = "8";
    private static volatile boolean o = true;
    private static java.util.Vector<com.amap.api.mapcore.util.ew.d> p = new java.util.Vector<>();
    private static java.util.Map<java.lang.String, java.lang.Integer> q = new java.util.HashMap();
    private static java.lang.String r = null;

    /* renamed from: s, reason: collision with root package name */
    private static long f128s = 0;
    public static volatile boolean d = false;
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> t = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> u = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.ew.c> v = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static boolean w = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    private static int x = 3;
    public static boolean h = true;
    public static boolean i = false;
    private static int y = 3;
    public static boolean j = false;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> z = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> A = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.ArrayList<com.amap.api.mapcore.util.hf.a> B = new java.util.ArrayList<>();
    private static java.util.Queue<com.amap.api.mapcore.util.hf.c> D = new java.util.LinkedList();

    /* renamed from: com.amap.api.mapcore.util.ew$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.ew.c cVar = (com.amap.api.mapcore.util.ew.c) com.amap.api.mapcore.util.ew.v.get(this.a);
            if (cVar == null) {
                return;
            }
            com.amap.api.mapcore.util.ew.a(com.amap.api.mapcore.util.ew.c, cVar.a, cVar.b, this.b, this.c, this.d);
        }
    }

    public static class a {

        @java.lang.Deprecated
        public org.json.JSONObject a;

        @java.lang.Deprecated
        public org.json.JSONObject b;
        public java.lang.String c;
        public int d = -1;
        public long e = 0;
        public org.json.JSONObject f;
        public com.amap.api.mapcore.util.ew.a.C0122a g;
        public com.amap.api.mapcore.util.ew.a.b h;
        private boolean i;

        /* renamed from: com.amap.api.mapcore.util.ew$a$a, reason: collision with other inner class name */
        public static class C0122a {
            public boolean a;
            public boolean b;
            public org.json.JSONObject c;
        }

        public static class b {
            public boolean a;
        }
    }

    public static class b extends com.amap.api.mapcore.util.hc {
        private java.lang.String h;
        private java.util.Map<java.lang.String, java.lang.String> i;
        private java.lang.String j;
        private java.lang.String k;
        private java.lang.String l;

        public b(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            super(context, fhVar);
            this.h = str;
            this.i = map;
            this.j = str2;
            this.k = str3;
            this.l = str4;
            setHttpProtocol(com.amap.api.mapcore.util.hi.c.HTTPS);
            setDegradeAbility(com.amap.api.mapcore.util.hi.a.FIX);
        }

        private static java.lang.String a(java.lang.String str, java.lang.String str2) {
            try {
                return !android.text.TextUtils.isEmpty(str2) ? android.net.Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (java.lang.Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.mapcore.util.hc
        public final byte[] c() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.hc
        public final byte[] d() {
            java.lang.String r = com.amap.api.mapcore.util.ez.r(((com.amap.api.mapcore.util.hc) this).a);
            if (!android.text.TextUtils.isEmpty(r)) {
                r = com.amap.api.mapcore.util.fd.b(new java.lang.StringBuilder(r).reverse().toString());
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("authkey", android.text.TextUtils.isEmpty(this.h) ? "" : this.h);
            hashMap.put("plattype", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            hashMap.put("product", ((com.amap.api.mapcore.util.hc) this).b.a());
            hashMap.put("version", ((com.amap.api.mapcore.util.hc) this).b.b());
            hashMap.put("output", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.os.Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", r);
            hashMap.put("manufacture", android.os.Build.MANUFACTURER);
            java.util.Map<java.lang.String, java.lang.String> map = this.i;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.i);
            }
            hashMap.put("abitype", com.amap.api.mapcore.util.fi.a(((com.amap.api.mapcore.util.hc) this).a));
            hashMap.put("ext", ((com.amap.api.mapcore.util.hc) this).b.e());
            return com.amap.api.mapcore.util.fi.a(com.amap.api.mapcore.util.fi.a(hashMap));
        }

        @Override // com.amap.api.mapcore.util.hc
        public final java.lang.String e() {
            return "3.0";
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getIPDNSName() {
            return !android.text.TextUtils.isEmpty(this.l) ? this.l : super.getIPDNSName();
        }

        @Override // com.amap.api.mapcore.util.fc, com.amap.api.mapcore.util.hi
        public final java.lang.String getIPV6URL() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.k);
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.util.Map<java.lang.String, java.lang.String> getRequestHead() {
            if (android.text.TextUtils.isEmpty(this.l)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.alipay.sdk.m.l.c.f, this.l);
            return hashMap;
        }

        @Override // com.amap.api.mapcore.util.hi
        public final java.lang.String getURL() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.j);
        }
    }

    public static class c {
        com.amap.api.mapcore.util.fh a;
        java.lang.String b;

        private c() {
        }
    }

    public static class d {
        private java.lang.String a;
        private java.lang.String b;
        private java.util.concurrent.atomic.AtomicInteger c;

        public d(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new java.util.concurrent.atomic.AtomicInteger(i);
        }

        public static com.amap.api.mapcore.util.ew.d b(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.amap.api.mapcore.util.ew.d(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        public final int a() {
            java.util.concurrent.atomic.AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void a(java.lang.String str) {
            this.b = str;
        }

        public final java.lang.String b() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("a", this.a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }
    }

    public static class e {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    public static com.amap.api.mapcore.util.ew.a a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return a(context, fhVar, str, null, str2, str3, str4);
    }

    public static com.amap.api.mapcore.util.ew.a a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        return b(context, fhVar, str, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x01cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.amap.api.mapcore.util.ew.a a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        com.amap.api.mapcore.util.ew.a aVar;
        java.lang.String str10;
        java.lang.String str11;
        java.lang.String str12;
        com.amap.api.mapcore.util.hj hjVar;
        byte[] bArr;
        java.lang.String str13;
        java.lang.String str14;
        boolean isEmpty;
        java.lang.StringBuilder sb;
        java.util.List<java.lang.String> list;
        com.amap.api.mapcore.util.ew.a aVar2 = new com.amap.api.mapcore.util.ew.a();
        aVar2.f = new org.json.JSONObject();
        if (context != null) {
            c = context.getApplicationContext();
        }
        d();
        java.lang.String str15 = null;
        try {
            a(fhVar);
            new com.amap.api.mapcore.util.hb();
            isEmpty = android.text.TextUtils.isEmpty(str);
            if (isEmpty) {
                str12 = str;
            } else {
                try {
                    sb = new java.lang.StringBuilder();
                    str5 = str;
                } catch (com.amap.api.mapcore.util.eu e2) {
                    e = e2;
                    str5 = str;
                } catch (java.lang.Throwable unused) {
                    str5 = str;
                }
                try {
                    sb.append(str5);
                    sb.append(";15K;16H;17I;17S;183");
                    str12 = sb.toString();
                } catch (com.amap.api.mapcore.util.eu e3) {
                    e = e3;
                    str6 = "infocode";
                    str7 = "info";
                    str8 = "result";
                    str9 = "ver";
                    aVar = aVar2;
                    str10 = "at";
                    str11 = "lc";
                    try {
                        throw e;
                    } catch (com.amap.api.mapcore.util.eu e4) {
                        e = e4;
                        str12 = str5;
                        hjVar = null;
                        bArr = null;
                        aVar.c = e.a();
                        a(context, fhVar, e.a());
                        com.amap.api.mapcore.util.gd.a(fhVar, "/v3/iasdkauth", e);
                        java.lang.String str16 = str12;
                        if (bArr == null) {
                        }
                    } catch (javax.crypto.IllegalBlockSizeException e5) {
                        e = e5;
                        str12 = str5;
                        hjVar = null;
                        bArr = null;
                        a(context, fhVar, e);
                        java.lang.String str162 = str12;
                        if (bArr == null) {
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        str12 = str5;
                        hjVar = null;
                        bArr = null;
                        com.amap.api.mapcore.util.gd.c(th, str10, str11);
                        a(context, fhVar, th);
                        java.lang.String str1622 = str12;
                        if (bArr == null) {
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                    str12 = str5;
                    str6 = "infocode";
                    str7 = "info";
                    str8 = "result";
                    str9 = "ver";
                    aVar = aVar2;
                    str10 = "at";
                    str11 = "lc";
                    try {
                        throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                    } catch (com.amap.api.mapcore.util.eu e6) {
                        e = e6;
                        hjVar = null;
                        bArr = null;
                        aVar.c = e.a();
                        a(context, fhVar, e.a());
                        com.amap.api.mapcore.util.gd.a(fhVar, "/v3/iasdkauth", e);
                        java.lang.String str16222 = str12;
                        if (bArr == null) {
                        }
                    } catch (javax.crypto.IllegalBlockSizeException e7) {
                        e = e7;
                        hjVar = null;
                        bArr = null;
                        a(context, fhVar, e);
                        java.lang.String str162222 = str12;
                        if (bArr == null) {
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        hjVar = null;
                        bArr = null;
                        com.amap.api.mapcore.util.gd.c(th, str10, str11);
                        a(context, fhVar, th);
                        java.lang.String str1622222 = str12;
                        if (bArr == null) {
                        }
                    }
                }
            }
            try {
                d(context);
                str8 = "result";
                aVar = aVar2;
                str9 = "ver";
                str10 = "at";
                str6 = "infocode";
                str11 = "lc";
                str7 = "info";
                try {
                    hjVar = com.amap.api.mapcore.util.hb.b(new com.amap.api.mapcore.util.ew.b(context, fhVar, str12, map, str2, str3, str4));
                } catch (com.amap.api.mapcore.util.eu e8) {
                    e = e8;
                    str5 = str12;
                    throw e;
                } catch (java.lang.Throwable unused3) {
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (com.amap.api.mapcore.util.eu e9) {
                e = e9;
                str6 = "infocode";
                str7 = "info";
                str8 = "result";
                str9 = "ver";
                aVar = aVar2;
                str10 = "at";
                str11 = "lc";
            } catch (java.lang.Throwable unused4) {
                str6 = "infocode";
                str7 = "info";
                str8 = "result";
                str9 = "ver";
                aVar = aVar2;
                str10 = "at";
                str11 = "lc";
                throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
            }
        } catch (com.amap.api.mapcore.util.eu e10) {
            e = e10;
            str5 = str;
            str6 = "infocode";
            str7 = "info";
            str8 = "result";
            str9 = "ver";
            aVar = aVar2;
            str10 = "at";
            str11 = "lc";
        } catch (javax.crypto.IllegalBlockSizeException e11) {
            e = e11;
            str5 = str;
            str6 = "infocode";
            str7 = "info";
            str8 = "result";
            str9 = "ver";
            aVar = aVar2;
            str10 = "at";
            str11 = "lc";
        } catch (java.lang.Throwable th3) {
            th = th3;
            str5 = str;
            str6 = "infocode";
            str7 = "info";
            str8 = "result";
            str9 = "ver";
            aVar = aVar2;
            str10 = "at";
            str11 = "lc";
        }
        if (isEmpty) {
            return aVar;
        }
        if (hjVar != null) {
            try {
                bArr = hjVar.a;
                try {
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> map2 = hjVar.b;
                    if (map2 != null && map2.containsKey("lct") && (list = map2.get("lct")) != null && list.size() > 0) {
                        java.lang.String str17 = list.get(0);
                        if (!android.text.TextUtils.isEmpty(str17)) {
                            long longValue = java.lang.Long.valueOf(str17).longValue();
                            aVar.e = longValue;
                            if (fhVar != null && longValue != 0) {
                                java.lang.String a2 = fhVar.a();
                                if (!android.text.TextUtils.isEmpty(a2)) {
                                    b(a2, aVar.e);
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    try {
                        com.amap.api.mapcore.util.gd.c(th4, str10, "lct");
                    } catch (com.amap.api.mapcore.util.eu e12) {
                        e = e12;
                        aVar.c = e.a();
                        a(context, fhVar, e.a());
                        com.amap.api.mapcore.util.gd.a(fhVar, "/v3/iasdkauth", e);
                        java.lang.String str16222222 = str12;
                        if (bArr == null) {
                        }
                    } catch (javax.crypto.IllegalBlockSizeException e13) {
                        e = e13;
                        a(context, fhVar, e);
                        java.lang.String str162222222 = str12;
                        if (bArr == null) {
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        com.amap.api.mapcore.util.gd.c(th, str10, str11);
                        a(context, fhVar, th);
                        java.lang.String str1622222222 = str12;
                        if (bArr == null) {
                        }
                    }
                }
            } catch (com.amap.api.mapcore.util.eu e14) {
                e = e14;
                bArr = null;
                aVar.c = e.a();
                a(context, fhVar, e.a());
                com.amap.api.mapcore.util.gd.a(fhVar, "/v3/iasdkauth", e);
                java.lang.String str16222222222 = str12;
                if (bArr == null) {
                }
            } catch (javax.crypto.IllegalBlockSizeException e15) {
                e = e15;
                bArr = null;
                a(context, fhVar, e);
                java.lang.String str162222222222 = str12;
                if (bArr == null) {
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
                bArr = null;
                com.amap.api.mapcore.util.gd.c(th, str10, str11);
                a(context, fhVar, th);
                java.lang.String str1622222222222 = str12;
                if (bArr == null) {
                }
            }
        } else {
            bArr = null;
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
        java.lang.System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, com.amap.api.mapcore.util.fi.c("EQUVT"));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.amap.api.mapcore.util.fi.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.amap.api.mapcore.util.fi.c()));
        str15 = com.amap.api.mapcore.util.fi.a(cipher.doFinal(bArr3));
        java.lang.String str16222222222222 = str12;
        if (bArr == null) {
            return aVar;
        }
        if (android.text.TextUtils.isEmpty(str15)) {
            str15 = com.amap.api.mapcore.util.fi.a(bArr);
        }
        java.lang.String str18 = str15;
        if (android.text.TextUtils.isEmpty(str18)) {
            a(context, fhVar, "result is null");
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str18);
            if (jSONObject.has("status")) {
                int i2 = jSONObject.getInt("status");
                if (i2 == 1) {
                    a = 1;
                } else if (i2 == 0) {
                    if (hjVar != null) {
                        str13 = hjVar.c;
                        str14 = hjVar.d;
                    } else {
                        str13 = "authcsid";
                        str14 = "authgsid";
                    }
                    com.amap.api.mapcore.util.fi.a(context, str13, str14, jSONObject);
                    a = 0;
                    java.lang.String str19 = str7;
                    if (jSONObject.has(str19)) {
                        b = jSONObject.getString(str19);
                    }
                    java.lang.String str20 = str6;
                    com.amap.api.mapcore.util.gd.a(fhVar, "/v3/iasdkauth", b, str14, str13, jSONObject.has(str20) ? jSONObject.getString(str20) : "");
                    if (a == 0) {
                        aVar.c = b;
                        return aVar;
                    }
                }
                java.lang.String str21 = str9;
                try {
                    if (jSONObject.has(str21)) {
                        aVar.d = jSONObject.getInt(str21);
                    }
                } catch (java.lang.Throwable th7) {
                    com.amap.api.mapcore.util.ga.a(th7, str10, str11);
                }
                java.lang.String str22 = str8;
                if (com.amap.api.mapcore.util.fi.a(jSONObject, str22)) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(str22);
                    a(context, fhVar, str16222222222222, aVar, jSONObject2);
                    try {
                        org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                        boolean a3 = a(jSONObject3.optString("isTargetAble"), false);
                        if (a(jSONObject3.optString("able"), false)) {
                            com.amap.api.mapcore.util.fb.a().a(context, a3);
                        } else {
                            com.amap.api.mapcore.util.fb.a();
                            com.amap.api.mapcore.util.fb.b(context);
                        }
                    } catch (java.lang.Throwable unused5) {
                    }
                }
            }
        } catch (java.lang.Throwable th8) {
            com.amap.api.mapcore.util.ga.a(th8, str10, str11);
        }
        return aVar;
    }

    private static synchronized com.amap.api.mapcore.util.ew.d a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.amap.api.mapcore.util.ew.d dVar;
        synchronized (com.amap.api.mapcore.util.ew.class) {
            if (!android.text.TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < p.size(); i2++) {
                    dVar = p.get(i2);
                    if (dVar != null && str.equals(dVar.a)) {
                        break;
                    }
                }
            }
            dVar = null;
            if (dVar != null) {
                return dVar;
            }
            if (context == null) {
                return null;
            }
            com.amap.api.mapcore.util.ew.d b2 = com.amap.api.mapcore.util.ew.d.b(com.amap.api.mapcore.util.gq.b(context, str2, str, ""));
            java.lang.String a2 = com.amap.api.mapcore.util.fi.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new com.amap.api.mapcore.util.ew.d(str, a2, 0);
            }
            if (!a2.equals(b2.b)) {
                b2.a(a2);
                b2.c.set(0);
            }
            p.add(b2);
            return b2;
        }
    }

    public static void a(android.content.Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    private static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", fhVar.a());
        hashMap.put("amap_sdk_version", fhVar.c());
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "core", "2.0", "O001");
            hqVar.a(jSONObject);
            com.amap.api.mapcore.util.hr.a(hqVar, context);
        } catch (com.amap.api.mapcore.util.eu unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, com.amap.api.mapcore.util.ew.a aVar, org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject2;
        boolean a2;
        android.content.Context context2;
        org.json.JSONObject jSONObject3;
        java.lang.String[] strArr;
        com.amap.api.mapcore.util.ew.a.C0122a c0122a = new com.amap.api.mapcore.util.ew.a.C0122a();
        c0122a.a = false;
        c0122a.b = false;
        aVar.g = c0122a;
        try {
            java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
            if (split != null && split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    java.lang.String str5 = split[i2];
                    if (jSONObject.has(str5)) {
                        strArr = split;
                        aVar.f.putOpt(str5, jSONObject.get(str5));
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "at", "co");
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "16H")) {
            try {
                aVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (java.lang.Throwable th2) {
                com.amap.api.mapcore.util.ga.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "11K")) {
            try {
                org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("11K");
                c0122a.a = a(jSONObject4.getString("able"), false);
                if (jSONObject4.has(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    c0122a.c = jSONObject4.getJSONObject(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
            } catch (java.lang.Throwable th3) {
                com.amap.api.mapcore.util.ga.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "145")) {
            try {
                aVar.a = jSONObject.getJSONObject("145");
            } catch (java.lang.Throwable th4) {
                com.amap.api.mapcore.util.ga.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "14D")) {
            try {
                aVar.b = jSONObject.getJSONObject("14D");
            } catch (java.lang.Throwable th5) {
                com.amap.api.mapcore.util.ga.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "151")) {
            try {
                org.json.JSONObject jSONObject5 = jSONObject.getJSONObject("151");
                com.amap.api.mapcore.util.ew.a.b bVar = new com.amap.api.mapcore.util.ew.a.b();
                if (jSONObject5 != null) {
                    bVar.a = a(jSONObject5.optString("able"), false);
                }
                aVar.h = bVar;
            } catch (java.lang.Throwable th6) {
                com.amap.api.mapcore.util.ga.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "17S")) {
            try {
                jSONObject2 = jSONObject.getJSONObject("17S");
                if (jSONObject2 != null && (a2 = a(jSONObject2.optString("able"), false)) != o) {
                    o = a2;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a3 = com.amap.api.mapcore.util.gq.a(context, "open_common");
                        com.amap.api.mapcore.util.gq.a(a3, "a2", a2);
                        com.amap.api.mapcore.util.gq.a(a3);
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                str2 = "ustv";
            }
            if (jSONObject2 != null) {
                boolean a4 = a(jSONObject2.optString("static_enable"), true);
                boolean a5 = a(jSONObject2.optString("static_ip_direct_enable"), false);
                int optInt = jSONObject2.optInt("static_timeout", 5) * 1000;
                int optInt2 = jSONObject2.optInt("static_retry", 3);
                str2 = "ustv";
                try {
                    boolean a6 = a(jSONObject2.optString("bgp_enable"), true);
                    str3 = "ust";
                    try {
                        boolean a7 = a(jSONObject2.optString("bgp_ip_direct_enable"), false);
                        str4 = "umv";
                        try {
                            int optInt3 = jSONObject2.optInt("bgp_retry", 3);
                            boolean a8 = a(jSONObject2.optString("perf_data_upload_enable"), false);
                            if (a4 != f || a5 != g || optInt != e || optInt2 != x || a6 != h || a7 != i || optInt3 != y || a8 != j) {
                                f = a4;
                                g = a5;
                                e = optInt;
                                x = optInt2;
                                h = a6;
                                i = a7;
                                y = optInt3;
                                j = a8;
                                if (context != null) {
                                    android.content.SharedPreferences.Editor a9 = com.amap.api.mapcore.util.gq.a(context, "open_common");
                                    com.amap.api.mapcore.util.gq.a(a9, "a13", a4);
                                    com.amap.api.mapcore.util.gq.a(a9, "a6", a6);
                                    com.amap.api.mapcore.util.gq.a(a9, "a7", a5);
                                    com.amap.api.mapcore.util.gq.a(a9, "a8", optInt);
                                    com.amap.api.mapcore.util.gq.a(a9, "a9", optInt2);
                                    com.amap.api.mapcore.util.gq.a(a9, "a10", a7);
                                    com.amap.api.mapcore.util.gq.a(a9, "a11", optInt3);
                                    com.amap.api.mapcore.util.gq.a(a9, "a12", a8);
                                    com.amap.api.mapcore.util.gq.a(a9);
                                }
                            }
                            com.amap.api.mapcore.util.hf.b();
                            com.amap.api.mapcore.util.hf.b();
                            com.amap.api.mapcore.util.hf.b();
                            com.amap.api.mapcore.util.hf.b();
                            com.amap.api.mapcore.util.hf.b();
                        } catch (java.lang.Throwable th8) {
                            th = th8;
                            com.amap.api.mapcore.util.ga.a(th, "AuthConfigManager", "load 17S");
                            if (com.amap.api.mapcore.util.fi.a(jSONObject, "15K")) {
                            }
                            context2 = context;
                            if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
                            }
                            if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
                            }
                        }
                    } catch (java.lang.Throwable th9) {
                        th = th9;
                        str4 = "umv";
                        com.amap.api.mapcore.util.ga.a(th, "AuthConfigManager", "load 17S");
                        if (com.amap.api.mapcore.util.fi.a(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
                        }
                        if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
                        }
                    }
                } catch (java.lang.Throwable th10) {
                    th = th10;
                    str3 = "ust";
                    str4 = "umv";
                    com.amap.api.mapcore.util.ga.a(th, "AuthConfigManager", "load 17S");
                    if (com.amap.api.mapcore.util.fi.a(jSONObject, "15K")) {
                    }
                    context2 = context;
                    if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
                    }
                    if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
                    }
                }
                if (com.amap.api.mapcore.util.fi.a(jSONObject, "15K")) {
                    try {
                        jSONObject3 = jSONObject.getJSONObject("15K");
                    } catch (java.lang.Throwable th11) {
                        context2 = context;
                        com.amap.api.mapcore.util.ga.a(th11, "AuthConfigManager", "load 15K");
                    }
                    if (jSONObject3 != null) {
                        boolean a10 = a(jSONObject3.optString("ucf"), com.amap.api.mapcore.util.ew.e.a);
                        boolean a11 = a(jSONObject3.optString("fsv2"), com.amap.api.mapcore.util.ew.e.b);
                        boolean a12 = a(jSONObject3.optString("usc"), com.amap.api.mapcore.util.ew.e.c);
                        java.lang.String str6 = str4;
                        int optInt4 = jSONObject3.optInt(str6, com.amap.api.mapcore.util.ew.e.d);
                        java.lang.String str7 = str3;
                        boolean a13 = a(jSONObject3.optString(str7), com.amap.api.mapcore.util.ew.e.e);
                        java.lang.String str8 = str2;
                        int optInt5 = jSONObject3.optInt(str8, com.amap.api.mapcore.util.ew.e.f);
                        if (a10 != com.amap.api.mapcore.util.ew.e.a || a11 != com.amap.api.mapcore.util.ew.e.b || a12 != com.amap.api.mapcore.util.ew.e.c || optInt4 != com.amap.api.mapcore.util.ew.e.d || a13 != com.amap.api.mapcore.util.ew.e.e || optInt5 != com.amap.api.mapcore.util.ew.e.d) {
                            com.amap.api.mapcore.util.ew.e.a = a10;
                            com.amap.api.mapcore.util.ew.e.b = a11;
                            com.amap.api.mapcore.util.ew.e.c = a12;
                            com.amap.api.mapcore.util.ew.e.d = optInt4;
                            com.amap.api.mapcore.util.ew.e.e = a13;
                            com.amap.api.mapcore.util.ew.e.f = optInt5;
                            context2 = context;
                            try {
                                android.content.SharedPreferences.Editor a14 = com.amap.api.mapcore.util.gq.a(context2, "open_common");
                                com.amap.api.mapcore.util.gq.a(a14, "ucf", com.amap.api.mapcore.util.ew.e.a);
                                com.amap.api.mapcore.util.gq.a(a14, "fsv2", com.amap.api.mapcore.util.ew.e.b);
                                com.amap.api.mapcore.util.gq.a(a14, "usc", com.amap.api.mapcore.util.ew.e.c);
                                com.amap.api.mapcore.util.gq.a(a14, str6, com.amap.api.mapcore.util.ew.e.d);
                                com.amap.api.mapcore.util.gq.a(a14, str7, com.amap.api.mapcore.util.ew.e.e);
                                com.amap.api.mapcore.util.gq.a(a14, str8, com.amap.api.mapcore.util.ew.e.f);
                                com.amap.api.mapcore.util.gq.a(a14);
                            } catch (java.lang.Throwable unused) {
                            }
                            if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
                                try {
                                    com.amap.api.mapcore.util.he.a(fhVar, jSONObject.getJSONObject("183"));
                                } catch (java.lang.Throwable th12) {
                                    com.amap.api.mapcore.util.ga.a(th12, "AuthConfigManager", "load 183");
                                }
                            }
                            if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
                                return;
                            }
                            try {
                                org.json.JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                boolean a15 = a(jSONObject6.optString("na"), false);
                                boolean a16 = a(jSONObject6.optString(com.anythink.expressad.d.a.b.w), false);
                                com.amap.api.mapcore.util.fx.d = a15;
                                com.amap.api.mapcore.util.fx.e = a16;
                                android.content.SharedPreferences.Editor a17 = com.amap.api.mapcore.util.gq.a(context2, "open_common");
                                com.amap.api.mapcore.util.gq.a(a17, "a4", a15);
                                com.amap.api.mapcore.util.gq.a(a17, "a5", a16);
                                com.amap.api.mapcore.util.gq.a(a17);
                                return;
                            } catch (java.lang.Throwable th13) {
                                com.amap.api.mapcore.util.ga.a(th13, "AuthConfigManager", "load 17I");
                                return;
                            }
                        }
                    }
                }
                context2 = context;
                if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
                }
                if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
                }
            }
        }
        str2 = "ustv";
        str3 = "ust";
        str4 = "umv";
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "15K")) {
        }
        context2 = context;
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "183")) {
        }
        if (com.amap.api.mapcore.util.fi.a(jSONObject, "17I")) {
        }
    }

    private static void a(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.Throwable th) {
        a(context, fhVar, th.getMessage());
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.amap.api.mapcore.util.ev.a(context, str);
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.amap.api.mapcore.util.ew.d dVar) {
        if (dVar == null || android.text.TextUtils.isEmpty(dVar.a)) {
            return;
        }
        java.lang.String b2 = dVar.b();
        if (android.text.TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        android.content.SharedPreferences.Editor a2 = com.amap.api.mapcore.util.gq.a(context, str2);
        a2.putString(str, b2);
        com.amap.api.mapcore.util.gq.a(a2);
    }

    private static void a(com.amap.api.mapcore.util.fh fhVar) {
        if (fhVar != null) {
            try {
                if (android.text.TextUtils.isEmpty(fhVar.a())) {
                    return;
                }
                java.lang.String c2 = fhVar.c();
                if (android.text.TextUtils.isEmpty(c2)) {
                    c2 = fhVar.b();
                }
                if (android.text.TextUtils.isEmpty(c2)) {
                    return;
                }
                com.amap.api.mapcore.util.fx.a(fhVar.a(), c2);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(com.amap.api.mapcore.util.hf.c cVar) {
        if (cVar == null || c == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("serverip", cVar.c);
        hashMap.put("hostname", cVar.e);
        hashMap.put("path", cVar.d);
        hashMap.put("csid", cVar.a);
        hashMap.put("degrade", java.lang.String.valueOf(cVar.b.a()));
        hashMap.put("errorcode", java.lang.String.valueOf(cVar.m));
        hashMap.put("errorsubcode", java.lang.String.valueOf(cVar.n));
        hashMap.put("connecttime", java.lang.String.valueOf(cVar.h));
        hashMap.put("writetime", java.lang.String.valueOf(cVar.i));
        hashMap.put("readtime", java.lang.String.valueOf(cVar.j));
        hashMap.put("datasize", java.lang.String.valueOf(cVar.l));
        hashMap.put("totaltime", java.lang.String.valueOf(cVar.f));
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        "--埋点--".concat(java.lang.String.valueOf(jSONObject));
        com.amap.api.mapcore.util.hf.b();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(c, "core", "2.0", "O008");
            hqVar.a(jSONObject);
            com.amap.api.mapcore.util.hr.a(hqVar, c);
        } catch (com.amap.api.mapcore.util.eu unused) {
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        com.amap.api.mapcore.util.ew.d a2 = a(c, str, str2);
        java.lang.String a3 = com.amap.api.mapcore.util.fi.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.b)) {
            a2.a(a3);
            a2.c.set(0);
        }
        a2.c.incrementAndGet();
        a(c, str, str2, a2);
    }

    public static synchronized void a(java.lang.String str, boolean z2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (u == null) {
                    u = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                u.put(str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                if (v == null) {
                    return;
                }
                if (v.containsKey(str)) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z2) {
                        com.amap.api.mapcore.util.he.a(true, str);
                    }
                    com.amap.api.mapcore.util.ii.a().a(new com.amap.api.mapcore.util.ew.AnonymousClass1(str, str2, str3, str4));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "at", "lca");
            }
        }
    }

    public static void a(java.lang.String str, boolean z2, boolean z3, boolean z4) {
        if (android.text.TextUtils.isEmpty(str) || c == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", java.lang.String.valueOf(z2));
        hashMap.put("ant", com.amap.api.mapcore.util.ez.n(c) == 0 ? "0" : "1");
        if (z4) {
            hashMap.put("type", z2 ? m : n);
        } else {
            hashMap.put("type", z2 ? k : l);
        }
        hashMap.put("status", z3 ? "0" : "1");
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(c, "core", "2.0", "O002");
            hqVar.a(jSONObject);
            com.amap.api.mapcore.util.hr.a(hqVar, c);
        } catch (com.amap.api.mapcore.util.eu unused) {
        }
    }

    public static void a(boolean z2, com.amap.api.mapcore.util.hf.a aVar) {
        if (!C || aVar == null) {
            return;
        }
        synchronized (B) {
            if (z2) {
                java.util.Iterator<com.amap.api.mapcore.util.hf.a> it = B.iterator();
                while (it.hasNext()) {
                    com.amap.api.mapcore.util.hf.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                            com.amap.api.mapcore.util.hf.b();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                            com.amap.api.mapcore.util.hf.b();
                        }
                    }
                }
            }
            C = false;
            java.util.Iterator<com.amap.api.mapcore.util.hf.a> it2 = B.iterator();
            com.amap.api.mapcore.util.hf.b();
            while (it2.hasNext()) {
                com.amap.api.mapcore.util.hf.a next2 = it2.next();
                java.lang.String str = next2.e;
                java.util.Objects.toString(next2.j);
                com.amap.api.mapcore.util.hf.b();
            }
            com.amap.api.mapcore.util.hf.b();
        }
    }

    public static void a(boolean z2, java.lang.String str) {
        try {
            "--markHostNameFailed---hostname=".concat(java.lang.String.valueOf(str));
            com.amap.api.mapcore.util.hf.b();
            if (f || z2) {
                if ((i || !z2) && !android.text.TextUtils.isEmpty(str)) {
                    if (z2) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, java.lang.Boolean.TRUE);
                        a(b(str, "a15"), "open_common");
                        return;
                    }
                    if (z.get(str) != null) {
                        return;
                    }
                    z.put(str, java.lang.Boolean.TRUE);
                    a(b(str, "a14"), "open_common");
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean a() {
        com.amap.api.mapcore.util.ew.d a2;
        if (c != null) {
            h();
            if (!b()) {
                return false;
            }
            if (i()) {
                return true;
            }
        }
        return o && (a2 = a(c, "IPV6_CONFIG_NAME", "open_common")) != null && a2.a() < 5;
    }

    public static synchronized boolean a(java.lang.String str) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "at", "cslct");
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (v == null) {
                return false;
            }
            if (u == null) {
                u = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            if (v.containsKey(str) && !u.containsKey(str)) {
                u.put(str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean a(java.lang.String str, long j2) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            boolean z2 = false;
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (j2 > c(str)) {
                if (android.os.SystemClock.elapsedRealtime() - ((u == null || !u.containsKey(str)) ? 0L : u.get(str).longValue()) > 30000) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public static boolean a(java.lang.String str, boolean z2) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return z2;
            }
            java.lang.String[] split = java.net.URLDecoder.decode(str).split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (java.lang.Throwable unused) {
            return z2;
        }
    }

    private static boolean a(java.net.InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    private static com.amap.api.mapcore.util.ew.a b(android.content.Context context, com.amap.api.mapcore.util.fh fhVar, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        return a(context, fhVar, str, map, null, null, null);
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return str2 + "_" + com.amap.api.mapcore.util.fd.a(str.getBytes());
    }

    private static void b(android.content.Context context) {
        if (context == null) {
            return;
        }
        o = com.amap.api.mapcore.util.gq.a(context, "open_common", "a2", true);
    }

    public static void b(com.amap.api.mapcore.util.hf.c cVar) {
        synchronized (B) {
            boolean z2 = false;
            for (int i2 = 0; i2 < B.size(); i2++) {
                com.amap.api.mapcore.util.hf.a aVar = B.get(i2);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e)) {
                    int i3 = cVar.m;
                    int i4 = aVar.f;
                    if (i3 == i4) {
                        z2 = true;
                        if (i4 == 1) {
                            aVar.i = ((aVar.j.get() * aVar.i) + cVar.f) / (aVar.j.get() + 1);
                        }
                        aVar.j.getAndIncrement();
                    }
                }
            }
            if (!z2) {
                B.add(new com.amap.api.mapcore.util.hf.a(cVar));
            }
            com.amap.api.mapcore.util.hf.b();
        }
    }

    public static synchronized void b(java.lang.String str) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            if (u == null) {
                return;
            }
            if (u.containsKey(str)) {
                u.remove(str);
            }
        }
    }

    private static synchronized void b(java.lang.String str, long j2) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            try {
                if (v != null && v.containsKey(str)) {
                    if (t == null) {
                        t = new java.util.concurrent.ConcurrentHashMap<>(8);
                    }
                    t.put(str, java.lang.Long.valueOf(j2));
                    android.content.Context context = c;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a2 = com.amap.api.mapcore.util.gq.a(context, "open_common");
                        com.amap.api.mapcore.util.gq.a(a2, str, j2);
                        com.amap.api.mapcore.util.gq.a(a2);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "at", "ucut");
            }
        }
    }

    public static synchronized void b(java.lang.String str, boolean z2) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            a(str, z2, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        }
    }

    public static boolean b() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String q2 = com.amap.api.mapcore.util.ez.q(context);
        return (android.text.TextUtils.isEmpty(q2) || (num = q.get(q2.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static synchronized long c(java.lang.String str) {
        synchronized (com.amap.api.mapcore.util.ew.class) {
            try {
                if (t == null) {
                    t = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str).longValue();
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "at", "glcut");
            }
            return 0L;
        }
    }

    public static void c() {
        try {
            com.amap.api.mapcore.util.ew.d a2 = a(c, "IPV6_CONFIG_NAME", "open_common");
            java.lang.String a3 = com.amap.api.mapcore.util.fi.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.b)) {
                a2.a(a3);
                a2.c.set(0);
            }
            a2.c.incrementAndGet();
            a(c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void c(android.content.Context context) {
        if (context == null) {
            return;
        }
        f = com.amap.api.mapcore.util.gq.a(context, "open_common", "a13", true);
        h = com.amap.api.mapcore.util.gq.a(context, "open_common", "a6", true);
        g = com.amap.api.mapcore.util.gq.a(context, "open_common", "a7", false);
        e = com.amap.api.mapcore.util.gq.a(context, "open_common", "a8", 5000);
        x = com.amap.api.mapcore.util.gq.a(context, "open_common", "a9", 3);
        i = com.amap.api.mapcore.util.gq.a(context, "open_common", "a10", false);
        y = com.amap.api.mapcore.util.gq.a(context, "open_common", "a11", 3);
        j = com.amap.api.mapcore.util.gq.a(context, "open_common", "a12", false);
    }

    public static void c(com.amap.api.mapcore.util.hf.c cVar) {
        if (cVar != null && j) {
            synchronized (D) {
                D.offer(cVar);
                com.amap.api.mapcore.util.hf.b();
            }
        }
    }

    public static void d() {
        if (d) {
            return;
        }
        try {
            android.content.Context context = c;
            if (context == null) {
                return;
            }
            d = true;
            com.amap.api.mapcore.util.fb.a().a(context);
            b(context);
            c(context);
            com.amap.api.mapcore.util.ew.e.a = com.amap.api.mapcore.util.gq.a(context, "open_common", "ucf", com.amap.api.mapcore.util.ew.e.a);
            com.amap.api.mapcore.util.ew.e.b = com.amap.api.mapcore.util.gq.a(context, "open_common", "fsv2", com.amap.api.mapcore.util.ew.e.b);
            com.amap.api.mapcore.util.ew.e.c = com.amap.api.mapcore.util.gq.a(context, "open_common", "usc", com.amap.api.mapcore.util.ew.e.c);
            com.amap.api.mapcore.util.ew.e.d = com.amap.api.mapcore.util.gq.a(context, "open_common", "umv", com.amap.api.mapcore.util.ew.e.d);
            com.amap.api.mapcore.util.ew.e.e = com.amap.api.mapcore.util.gq.a(context, "open_common", "ust", com.amap.api.mapcore.util.ew.e.e);
            com.amap.api.mapcore.util.ew.e.f = com.amap.api.mapcore.util.gq.a(context, "open_common", "ustv", com.amap.api.mapcore.util.ew.e.f);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void d(android.content.Context context) {
        try {
            if (w) {
                return;
            }
            com.amap.api.mapcore.util.fx.d = com.amap.api.mapcore.util.gq.a(context, "open_common", "a4", true);
            com.amap.api.mapcore.util.fx.e = com.amap.api.mapcore.util.gq.a(context, "open_common", "a5", true);
            w = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean d(java.lang.String str) {
        com.amap.api.mapcore.util.ew.d a2;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f) {
                return false;
            }
            if (!(z.get(str) == null)) {
                return false;
            }
            android.content.Context context = c;
            if (context == null || (a2 = a(context, b(str, "a14"), "open_common")) == null) {
                return true;
            }
            return a2.a() < x;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static com.amap.api.mapcore.util.hf.a e() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            java.util.Collections.sort(B);
            if (B.size() <= 0) {
                return null;
            }
            com.amap.api.mapcore.util.hf.a clone = B.get(0).clone();
            C = true;
            return clone;
        }
    }

    public static boolean e(java.lang.String str) {
        com.amap.api.mapcore.util.ew.d a2;
        if (android.text.TextUtils.isEmpty(str) || !i) {
            return false;
        }
        if (!(A.get(str) == null)) {
            return false;
        }
        android.content.Context context = c;
        if (context == null || (a2 = a(context, b(str, "a15"), "open_common")) == null) {
            return true;
        }
        return a2.a() < y;
    }

    public static com.amap.api.mapcore.util.hf.c f() {
        synchronized (D) {
            com.amap.api.mapcore.util.hf.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    private static void h() {
        try {
            android.content.Context context = c;
            if (context != null) {
                java.lang.String q2 = com.amap.api.mapcore.util.ez.q(context);
                if (!android.text.TextUtils.isEmpty(r) && !android.text.TextUtils.isEmpty(q2) && r.equals(q2) && java.lang.System.currentTimeMillis() - f128s < 60000) {
                    return;
                }
                if (!android.text.TextUtils.isEmpty(q2)) {
                    r = q2;
                }
            } else if (java.lang.System.currentTimeMillis() - f128s < 10000) {
                return;
            }
            f128s = java.lang.System.currentTimeMillis();
            q.clear();
            java.util.Iterator it = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                java.net.NetworkInterface networkInterface = (java.net.NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    java.lang.String displayName = networkInterface.getDisplayName();
                    java.util.Iterator<java.net.InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        java.net.InetAddress address = it2.next().getAddress();
                        if (address instanceof java.net.Inet6Address) {
                            if (!a((java.net.Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof java.net.Inet4Address) {
                            java.net.Inet4Address inet4Address = (java.net.Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(com.amap.api.mapcore.util.fi.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", java.lang.Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", java.lang.Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "at", "ipstack");
        }
    }

    private static boolean i() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String q2 = com.amap.api.mapcore.util.ez.q(context);
        return (android.text.TextUtils.isEmpty(q2) || (num = q.get(q2.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }
}

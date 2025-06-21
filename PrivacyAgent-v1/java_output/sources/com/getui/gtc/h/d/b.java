package com.getui.gtc.h.d;

/* loaded from: classes22.dex */
public final class b {
    private final java.util.concurrent.atomic.AtomicBoolean a;

    /* renamed from: com.getui.gtc.h.d.b$1, reason: invalid class name */
    public class AnonymousClass1 extends com.getui.gtc.f.e {
        public AnonymousClass1() {
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.lang.String str) {
        }

        @Override // com.getui.gtc.f.e
        public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
            com.getui.gtc.api.OnDycEnableChangedListener[] onDycEnableChangedListenerArr;
            java.lang.String str;
            java.lang.Boolean bool;
            char c;
            com.getui.gtc.dim.AllowSysCall allowSysCall;
            com.getui.gtc.h.d.b.this.a(map2);
            com.getui.gtc.f.b a = com.getui.gtc.f.b.a();
            if (map2 != null) {
                if (a.b.compareAndSet(false, true)) {
                    try {
                        synchronized (a.b) {
                            onDycEnableChangedListenerArr = (com.getui.gtc.api.OnDycEnableChangedListener[]) a.a.toArray(new com.getui.gtc.api.OnDycEnableChangedListener[0]);
                            a.a.clear();
                        }
                        com.getui.gtc.h.c.a.a("dycEnable changed start check");
                        java.util.HashMap hashMap = new java.util.HashMap();
                        java.lang.String[] strArr = {com.getui.gtc.extension.distribution.gbd.f.e.b.b, com.getui.gtc.extension.distribution.gbd.f.e.b.c, com.getui.gtc.extension.distribution.gbd.f.e.b.d, com.getui.gtc.extension.distribution.gbd.f.e.b.e, com.getui.gtc.extension.distribution.gbd.f.e.b.f, com.getui.gtc.extension.distribution.gbd.f.e.b.g, com.getui.gtc.extension.distribution.gbd.f.e.b.h, com.getui.gtc.extension.distribution.gbd.f.e.b.i, com.getui.gtc.extension.distribution.gbd.f.e.b.j, com.getui.gtc.extension.distribution.gbd.f.e.b.k, com.getui.gtc.extension.distribution.gbd.f.e.b.l, com.getui.gtc.extension.distribution.gbd.f.e.b.m, com.getui.gtc.extension.distribution.gbd.f.e.b.n, com.getui.gtc.extension.distribution.gbd.f.e.b.o, com.getui.gtc.extension.distribution.gbd.f.e.b.p, com.getui.gtc.extension.distribution.gbd.f.e.b.q, com.getui.gtc.extension.distribution.gbd.f.e.b.r, com.getui.gtc.extension.distribution.gbd.f.e.b.f330s, com.getui.gtc.extension.distribution.gbd.f.e.b.t, com.getui.gtc.extension.distribution.gbd.f.e.b.u, com.getui.gtc.extension.distribution.gbd.f.e.b.v, com.getui.gtc.extension.distribution.gbd.f.e.b.w, com.getui.gtc.extension.distribution.gbd.f.e.b.x, com.getui.gtc.extension.distribution.gbd.f.e.b.y, com.getui.gtc.extension.distribution.gbd.f.e.b.z, com.getui.gtc.extension.distribution.gbd.f.e.b.A, com.getui.gtc.extension.distribution.gbd.f.e.b.B, com.getui.gtc.extension.distribution.gbd.f.e.b.C, com.getui.gtc.extension.distribution.gbd.f.e.b.D, com.getui.gtc.extension.distribution.gbd.f.e.b.E, com.getui.gtc.extension.distribution.gbd.f.e.b.F, com.getui.gtc.extension.distribution.gbd.f.e.b.G, com.getui.gtc.extension.distribution.gbd.f.e.b.H, com.getui.gtc.extension.distribution.gbd.f.e.b.I, com.getui.gtc.extension.distribution.gbd.f.e.b.J, com.getui.gtc.extension.distribution.gbd.f.e.b.K, com.getui.gtc.extension.distribution.gbd.f.e.b.L, com.getui.gtc.extension.distribution.gbd.f.e.b.M, com.getui.gtc.extension.distribution.gbd.f.e.b.O};
                        for (int i = 0; i < 39; i++) {
                            java.lang.String str2 = strArr[i];
                            switch (str2.hashCode()) {
                                case 320892099:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.w)) {
                                        c = 30;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894021:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.y)) {
                                        c = 28;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894022:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.z)) {
                                        c = 29;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894982:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.A)) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894983:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.B)) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894984:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.C)) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320894985:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.D)) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895943:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.E)) {
                                        c = '\b';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895944:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.F)) {
                                        c = '\n';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895945:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.G)) {
                                        c = '\t';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320895946:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.H)) {
                                        c = 11;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320896904:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.I)) {
                                        c = '\f';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320896905:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.J)) {
                                        c = '\r';
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320919007:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.K)) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320919008:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.L)) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320919009:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.M)) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 320919011:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.O)) {
                                        c = 3;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672919129:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.b)) {
                                        c = 14;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672919131:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.c)) {
                                        c = 15;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672919132:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.d)) {
                                        c = 16;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672920090:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.e)) {
                                        c = 17;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672920092:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.f)) {
                                        c = 18;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672920093:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.g)) {
                                        c = 19;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672921051:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.h)) {
                                        c = 25;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672921052:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.i)) {
                                        c = com.alibaba.fastjson.parser.JSONLexer.EOI;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672922012:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.j)) {
                                        c = 23;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672923934:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.m)) {
                                        c = 20;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672923936:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.n)) {
                                        c = 21;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672923937:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.o)) {
                                        c = 22;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672924895:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.p)) {
                                        c = 27;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1672925856:
                                    if (str2.equals(com.getui.gtc.extension.distribution.gbd.f.e.b.q)) {
                                        c = 24;
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
                                case 30:
                                    allowSysCall = com.getui.gtc.dim.AllowSysCall.NOT_ALLOW;
                                    break;
                                default:
                                    allowSysCall = com.getui.gtc.dim.AllowSysCall.ALL_ALLOW;
                                    break;
                            }
                            hashMap.put(str2, java.lang.Boolean.valueOf(allowSysCall != com.getui.gtc.dim.AllowSysCall.NOT_ALLOW));
                        }
                        java.util.HashMap hashMap2 = new java.util.HashMap(hashMap);
                        if (map == null) {
                            com.getui.gtc.h.c.a.a("dycEnable this new user");
                        } else {
                            java.util.Map<java.lang.String, java.lang.Boolean> b = com.getui.gtc.f.b.b(map);
                            java.lang.Boolean bool2 = b.get("dim-2-2-0-1");
                            for (int i2 = 0; i2 < 39; i2++) {
                                java.lang.String str3 = strArr[i2];
                                java.lang.Boolean bool3 = b.get(str3);
                                if (bool3 != null) {
                                    hashMap2.put(str3, bool3);
                                } else if (bool2 != null) {
                                    hashMap2.put(str3, bool2);
                                }
                            }
                        }
                        java.util.HashMap hashMap3 = new java.util.HashMap(hashMap);
                        java.util.Map<java.lang.String, java.lang.Boolean> b2 = com.getui.gtc.f.b.b(map2);
                        java.lang.Boolean bool4 = b2.get("dim-2-2-0-1");
                        for (int i3 = 0; i3 < 39; i3++) {
                            java.lang.String str4 = strArr[i3];
                            java.lang.Boolean bool5 = b2.get(str4);
                            if (bool5 != null) {
                                hashMap3.put(str4, bool5);
                            } else if (bool4 != null) {
                                hashMap3.put(str4, bool4);
                            }
                        }
                        java.util.HashMap hashMap4 = new java.util.HashMap();
                        for (int i4 = 0; i4 < 39; i4++) {
                            java.lang.String str5 = strArr[i4];
                            java.lang.Boolean bool6 = (java.lang.Boolean) hashMap2.get(str5);
                            java.lang.Boolean bool7 = (java.lang.Boolean) hashMap3.get(str5);
                            if (bool6 != null && bool7 != null && !bool6.equals(bool7)) {
                                hashMap4.put(str5, bool7);
                            }
                        }
                        java.lang.String a2 = com.getui.gtc.f.b.a(hashMap2);
                        java.lang.String a3 = com.getui.gtc.f.b.a(hashMap3);
                        if (!a2.equals(a3)) {
                            if (a3.contains("1")) {
                                str = com.getui.gtc.extension.distribution.gbd.f.e.b.N;
                                bool = java.lang.Boolean.TRUE;
                            } else {
                                str = com.getui.gtc.extension.distribution.gbd.f.e.b.N;
                                bool = java.lang.Boolean.FALSE;
                            }
                            hashMap4.put(str, bool);
                        }
                        if (hashMap4.isEmpty()) {
                            com.getui.gtc.h.c.a.a("dycEnable not changed");
                        } else {
                            com.getui.gtc.h.c.a.a("dycEnable changed listener size: " + onDycEnableChangedListenerArr.length + ", result: " + hashMap4);
                            for (com.getui.gtc.api.OnDycEnableChangedListener onDycEnableChangedListener : onDycEnableChangedListenerArr) {
                                onDycEnableChangedListener.onDycEnableChanged(hashMap4);
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.h.c.a.c(th);
                    }
                } else {
                    com.getui.gtc.h.c.a.a("dycEnable listener only once");
                }
            }
            com.getui.gtc.h.c.b.a(map2);
        }
    }

    /* renamed from: com.getui.gtc.h.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map a;

        public AnonymousClass2(java.util.Map map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.h.c.b.a((java.util.Map<java.lang.String, java.lang.String>) this.a);
        }
    }

    /* renamed from: com.getui.gtc.h.d.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.a.a.c {
        public AnonymousClass3() {
        }

        @Override // com.getui.gtc.a.a.c
        public final void a(java.lang.Object obj) throws java.lang.Throwable {
            java.util.Map map;
            java.util.List<java.lang.String> list;
            if (obj instanceof java.util.HashMap) {
                java.util.HashMap hashMap = (java.util.HashMap) obj;
                if (hashMap.size() <= 0 || (map = (java.util.Map) hashMap.get("header")) == null || map.size() <= 0 || (list = (java.util.List) map.get("Date")) == null) {
                    return;
                }
                for (java.lang.String str : list) {
                    if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) && str.contains("GMT")) {
                        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", java.util.Locale.ENGLISH);
                        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
                        java.util.Date parse = simpleDateFormat.parse(str);
                        long time = parse.getTime();
                        long currentTimeMillis = java.lang.System.currentTimeMillis();
                        if (currentTimeMillis != time) {
                            long j = time - currentTimeMillis;
                            com.getui.gtc.h.c.a.a("serverDate:" + parse + ", localTimeByServerTimeDiff:" + j);
                            com.getui.gtc.dim.DimManager.getInstance().set("dim-2-2-4-1", "dim-2-2-4-1", java.lang.String.valueOf(j));
                        }
                    }
                }
            }
        }
    }

    public static class a extends com.getui.gtc.a.a.d {
        public a(com.getui.gtc.a.a.c cVar) {
            this.e = cVar;
        }

        @Override // com.getui.gtc.a.a.d
        public final void a() {
            com.getui.gtc.a.a.c cVar = this.e;
            if (cVar != null) {
                try {
                    cVar.a(null);
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.c(th);
                }
            }
        }

        @Override // com.getui.gtc.a.a.d
        public final void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, byte[] bArr) {
            try {
                if (this.e != null) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("header", map);
                    hashMap.put("data", new java.lang.String(bArr, "utf-8"));
                    this.e.a(hashMap);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.h.c.a.c(th);
            }
        }

        @Override // com.getui.gtc.a.a.d
        public final void b() {
            com.getui.gtc.a.a.c cVar = this.e;
            if (cVar != null) {
                try {
                    cVar.a(null);
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.c(th);
                }
            }
        }
    }

    /* renamed from: com.getui.gtc.h.d.b$b, reason: collision with other inner class name */
    public static class C0330b {
        private static final com.getui.gtc.h.d.b a = new com.getui.gtc.h.d.b((byte) 0);
    }

    private b() {
        this.a = new java.util.concurrent.atomic.AtomicBoolean(false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.b, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.c, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.d, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.e, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.f, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.g, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.h, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.i, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.j, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.k, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.m, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.n, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.o, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.p, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.q, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.r, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.f330s, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.t, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.u, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.v, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.w, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.x, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.y, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.z, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.A, true);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.B, true);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.E, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.F, true);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.G, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.I, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.J, true);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.K, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.L, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.M, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.O, false);
        a(com.getui.gtc.extension.distribution.gbd.f.e.b.P, false);
        java.util.Map<java.lang.String, java.lang.String> a2 = com.getui.gtc.f.c.a(new com.getui.gtc.h.d.b.AnonymousClass1());
        a(a2);
        com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.h.d.b.AnonymousClass2(a2));
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    private void a() {
        if (this.a.getAndSet(true) || a(com.getui.gtc.base.GtcProvider.context())) {
            return;
        }
        com.getui.gtc.h.d.b.a aVar = new com.getui.gtc.h.d.b.a(new com.getui.gtc.h.d.b.AnonymousClass3());
        aVar.a = "https://sdk-open-phone.getui.com/";
        com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.a.a.a(aVar));
    }

    private static void a(java.lang.String str, boolean z) {
        if (z) {
            com.getui.gtc.dim.DimManager.getInstance().set("dim-2-2-2-1", "dim-2-2-2-1", str);
        }
    }

    private static boolean a(android.content.Context context) {
        return com.getui.gtc.base.util.CommonUtil.isAppForeground() && android.provider.Settings.System.getInt(context.getContentResolver(), "auto_time", 1) == 1;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            com.getui.gtc.dim.DimManager.getInstance().set("dim-2-2-1-1", "dim-2-2-1-1", new org.json.JSONObject(map).toString());
            java.lang.String str = map.get("sdk.gtc.dim.halfclosed.enable");
            if (android.text.TextUtils.isEmpty(str) || "none".equals(str)) {
                return;
            }
            a();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
        }
    }
}

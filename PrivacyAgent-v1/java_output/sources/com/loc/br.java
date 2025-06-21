package com.loc;

/* loaded from: classes23.dex */
public final class br {
    public static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.br.c> a = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static volatile java.util.List<java.lang.String> b = java.util.Collections.synchronizedList(new java.util.ArrayList(8));
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.br.b> c = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static java.util.Random d = new java.util.Random();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> e = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static java.util.List<com.loc.cb> f = java.util.Collections.synchronizedList(new java.util.ArrayList(16));

    public static class a {
        java.lang.String a;
        int b;
        double c;

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b {
        com.loc.bv a;
        long b;

        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c {
        java.util.Map<java.lang.String, java.util.List<com.loc.br.a>> a;
        java.util.Map<java.lang.String, java.lang.String> b;

        private c() {
            this.a = new java.util.HashMap(8);
            this.b = new java.util.HashMap(8);
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        public final boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.loc.br.c.class == obj.getClass()) {
                com.loc.br.c cVar = (com.loc.br.c) obj;
                if (this.a.equals(cVar.a) && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            java.util.Map<java.lang.String, java.util.List<com.loc.br.a>> map = this.a;
            int hashCode = map != null ? map.hashCode() : 0;
            java.util.Map<java.lang.String, java.lang.String> map2 = this.b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }
    }

    public static synchronized java.lang.String a(java.lang.String str, java.lang.String str2) throws com.loc.l {
        synchronized (com.loc.br.class) {
            try {
                try {
                    java.lang.System.currentTimeMillis();
                    if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str)) {
                        android.content.Context context = com.loc.n.c;
                        try {
                            if (b == null) {
                                b = java.util.Collections.synchronizedList(new java.util.ArrayList(8));
                            }
                            if (context != null && !b.contains(str2)) {
                                b.add(str2);
                                java.lang.String a2 = com.loc.be.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                if (!android.text.TextUtils.isEmpty(a2)) {
                                    a(str2, new org.json.JSONObject(a2));
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.loc.at.a(th, "hlUtil", "llhl");
                        }
                        if (a != null && a.size() > 0) {
                            if (!a.containsKey(str2)) {
                                return str;
                            }
                            com.loc.br.c cVar = a.get(str2);
                            if (cVar == null) {
                                return str;
                            }
                            if (a(str, cVar, str2)) {
                                throw new com.loc.l("服务QPS超限");
                            }
                            return b(str, cVar, str2);
                        }
                        return str;
                    }
                    return str;
                } finally {
                }
            } catch (com.loc.l e2) {
                throw e2;
            } catch (java.lang.Throwable th2) {
                com.loc.at.a(th2, "hlUtil", "pcr");
                return str;
            }
        }
    }

    public static void a() {
        try {
            android.content.Context context = com.loc.n.c;
            if (context == null) {
                return;
            }
            com.loc.cc.a(b(), context);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(com.loc.br.c cVar, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONArray optJSONArray = jSONObject.optJSONArray("block");
            if (optJSONArray == null) {
                return;
            }
            java.util.HashMap hashMap = new java.util.HashMap(8);
            for (int i = 0; i < optJSONArray.length(); i++) {
                org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    java.lang.String optString = optJSONObject.optString("api");
                    if (!android.text.TextUtils.isEmpty(optString)) {
                        if (!optString.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                            optString = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR.concat(optString);
                        }
                        if (optString.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                            optString = optString.substring(0, optString.length() - 1);
                        }
                        org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray("periods");
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            org.json.JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                com.loc.br.a aVar = new com.loc.br.a((byte) 0);
                                aVar.a = optJSONObject2.optString("begin");
                                aVar.b = optJSONObject2.optInt("duration");
                                aVar.c = optJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            cVar.a = hashMap;
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "hlUtil", "pbr");
        }
    }

    public static synchronized void a(com.loc.x xVar, org.json.JSONObject jSONObject) {
        synchronized (com.loc.br.class) {
            if (xVar == null) {
                return;
            }
            try {
                java.lang.String a2 = xVar.a();
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                if (jSONObject == null) {
                    a(a2);
                }
                if (!com.loc.n.a(jSONObject.optString("able", null), false)) {
                    a(a2);
                } else {
                    com.loc.be.a(com.loc.n.c, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                    a(a2, jSONObject);
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "hlUtil", "par");
            }
        }
    }

    private static synchronized void a(java.lang.String str) {
        synchronized (com.loc.br.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                android.content.SharedPreferences.Editor a2 = com.loc.be.a(com.loc.n.c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                com.loc.be.a(a2, str);
                com.loc.be.a(a2);
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "hlUtil", com.anythink.core.common.h.c.R);
            }
        }
    }

    private static void a(java.lang.String str, com.loc.br.c cVar) {
        try {
            if (a == null) {
                a = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            a.put(str, cVar);
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            android.content.Context context = com.loc.n.c;
            if (context != null && !android.text.TextUtils.isEmpty(str)) {
                if (e == null) {
                    e = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                synchronized (e) {
                    if (e.containsKey(str2)) {
                        return;
                    }
                    e.put(str2, str3);
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put("timestamp", java.lang.System.currentTimeMillis());
                    jSONObject.put("type", com.loc.ah.j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", com.loc.ah.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    java.lang.String jSONObject2 = jSONObject.toString();
                    if (android.text.TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    com.loc.cb cbVar = new com.loc.cb(context, "core", "2.0", "O005");
                    cbVar.a(jSONObject2);
                    com.loc.cc.a(cbVar, context);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.loc.br.c cVar = new com.loc.br.c((byte) 0);
            a(cVar, jSONObject);
            b(cVar, jSONObject);
            if (cVar.b == null && cVar.a == null) {
                a(str);
            } else {
                a(str, cVar);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.net.URL url, com.loc.bv bvVar) {
        java.util.List<java.lang.String> list;
        try {
            if (c == null) {
                c = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = bvVar.b;
            if (map != null && map.containsKey("nb") && (list = bvVar.b.get("nb")) != null && list.size() > 0) {
                java.lang.String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = java.lang.Integer.parseInt(split[0]);
                long parseInt2 = java.lang.Integer.parseInt(split[1]);
                com.loc.br.b bVar = new com.loc.br.b((byte) 0);
                bVar.a = bvVar;
                if (parseInt2 <= 0) {
                    parseInt2 = 30;
                }
                bVar.b = android.os.SystemClock.elapsedRealtime() + (parseInt2 * 1000);
                if (parseInt == 1) {
                    c.put("app", bVar);
                } else {
                    if (parseInt != 2 || url == null) {
                        return;
                    }
                    c.put(url.getPath(), bVar);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(boolean z, java.lang.String str) {
        try {
            android.content.Context context = com.loc.n.c;
            if (context != null && !android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                jSONObject.put("type", z ? com.loc.ah.g : com.loc.ah.f);
                jSONObject.put("name", str);
                jSONObject.put("version", com.loc.ah.a(str));
                java.lang.String jSONObject2 = jSONObject.toString();
                com.loc.cb cbVar = new com.loc.cb(context, "core", "2.0", "O005");
                cbVar.a(jSONObject2);
                com.loc.cc.a(cbVar, context);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(boolean z, java.lang.String str, java.lang.String str2, int i) {
        java.lang.String str3;
        java.lang.Integer num;
        try {
            android.content.Context context = com.loc.n.c;
            if (context != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("timestamp", java.lang.System.currentTimeMillis());
                java.lang.String a2 = com.loc.ah.a(str);
                if (z) {
                    str3 = "type";
                    num = com.loc.ah.i;
                } else {
                    str3 = "type";
                    num = com.loc.ah.h;
                }
                jSONObject.put(str3, num);
                jSONObject.put("name", str);
                jSONObject.put("version", a2);
                jSONObject.put("uri", android.net.Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                java.lang.String jSONObject2 = jSONObject.toString();
                if (android.text.TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                com.loc.cb cbVar = new com.loc.cb(context, "core", "2.0", "O005");
                cbVar.a(jSONObject2);
                if (f == null) {
                    f = java.util.Collections.synchronizedList(new java.util.ArrayList(16));
                }
                synchronized (f) {
                    f.add(cbVar);
                    if (f.size() >= 15) {
                        a();
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(com.loc.br.a aVar) {
        if (aVar == null || aVar.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (!android.text.TextUtils.isEmpty(aVar.a) && aVar.b > 0) {
            long timeInMillis = currentTimeMillis - com.loc.y.a(aVar.a, org.apache.tools.ant.util.DateUtils.ISO8601_TIME_PATTERN).getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.b * 1000) {
                if (aVar.c == 0.0d) {
                    return true;
                }
                if (d == null) {
                    d = new java.util.Random();
                }
                d.setSeed(java.util.UUID.randomUUID().hashCode() + currentTimeMillis);
                if (d.nextDouble() > aVar.c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(java.lang.String str, com.loc.br.c cVar, java.lang.String str2) {
        java.util.Map<java.lang.String, java.util.List<com.loc.br.a>> map;
        try {
            map = cVar.a;
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, java.util.List<com.loc.br.a>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    if (a(it.next().getValue())) {
                        a(false, str2, str, 1);
                        return true;
                    }
                }
            } else {
                java.lang.String path = android.net.Uri.parse(str).getPath();
                if (map.containsKey(path) && a(map.get(path))) {
                    a(false, str2, str, 2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean a(java.util.List<com.loc.br.a> list) {
        if (list != null && list.size() > 0) {
            java.util.Iterator<com.loc.br.a> it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static com.loc.bv b(java.lang.String str, java.lang.String str2) {
        android.net.Uri parse;
        java.lang.String str3 = "app";
        if (c == null) {
            return null;
        }
        if (!c.containsKey("app")) {
            if (!android.text.TextUtils.isEmpty(str) && (parse = android.net.Uri.parse(str)) != null) {
                str3 = parse.getPath();
                if (c.containsKey(str3)) {
                    com.loc.br.b bVar = c.get(str3);
                    if (android.os.SystemClock.elapsedRealtime() <= bVar.b) {
                        com.loc.bv bvVar = bVar.a;
                        if (bvVar != null) {
                            bvVar.e = false;
                        }
                        a(true, str2, str, 2);
                        return bvVar;
                    }
                }
            }
            return null;
        }
        com.loc.br.b bVar2 = c.get("app");
        if (android.os.SystemClock.elapsedRealtime() <= bVar2.b) {
            com.loc.bv bvVar2 = bVar2.a;
            if (bvVar2 != null) {
                bvVar2.e = false;
            }
            a(true, str2, str, 1);
            return bvVar2;
        }
        c.remove(str3);
        return null;
    }

    private static java.lang.String b(java.lang.String str, com.loc.br.c cVar, java.lang.String str2) {
        try {
            java.util.Map<java.lang.String, java.lang.String> map = cVar.b;
            if (map != null && map.size() > 0) {
                android.net.Uri parse = android.net.Uri.parse(str);
                java.lang.String authority = parse.getAuthority();
                if (!map.containsKey(authority)) {
                    return str;
                }
                java.lang.String str3 = map.get(authority);
                str = parse.buildUpon().authority(str3).toString();
                a(str2, authority, str3);
                return str;
            }
            return str;
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "hlUtil", "pdr");
            return str;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x0028
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static java.util.List<com.loc.cb> b() {
        /*
            r0 = 0
            java.util.List<com.loc.cb> r1 = com.loc.br.f     // Catch: java.lang.Throwable -> L2a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.loc.cb> r2 = com.loc.br.f     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L20
            if (r2 <= 0) goto L1e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.util.List<com.loc.cb> r0 = com.loc.br.f     // Catch: java.lang.Throwable -> L28
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L28
            java.util.List<com.loc.cb> r0 = com.loc.br.f     // Catch: java.lang.Throwable -> L28
            r0.clear()     // Catch: java.lang.Throwable -> L28
            r0 = r2
        L1e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L20
            goto L2a
        L20:
            r2 = move-exception
            r3 = r2
            r2 = r0
            r0 = r3
        L24:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L28
            throw r0     // Catch: java.lang.Throwable -> L26
        L26:
            r0 = r2
            goto L2a
        L28:
            r0 = move-exception
            goto L24
        L2a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.br.b():java.util.List");
    }

    private static void b(com.loc.br.c cVar, org.json.JSONObject jSONObject) {
        org.json.JSONArray names;
        try {
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("domainMap");
            if (optJSONObject == null || (names = optJSONObject.names()) == null) {
                return;
            }
            java.util.HashMap hashMap = new java.util.HashMap(8);
            int length = names.length();
            for (int i = 0; i < length; i++) {
                java.lang.String optString = names.optString(i);
                hashMap.put(optString, optJSONObject.optString(optString));
            }
            cVar.b = hashMap;
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "hlUtil", "pdr");
        }
    }
}

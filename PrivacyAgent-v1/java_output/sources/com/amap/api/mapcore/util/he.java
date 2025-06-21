package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class he {
    public static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.he.c> a = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static volatile java.util.List<java.lang.String> b = java.util.Collections.synchronizedList(new java.util.ArrayList(8));
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.mapcore.util.he.b> c = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static java.util.Random d = new java.util.Random();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> e = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static java.util.List<com.amap.api.mapcore.util.hq> f = java.util.Collections.synchronizedList(new java.util.ArrayList(16));

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
        com.amap.api.mapcore.util.hj a;
        long b;

        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c {
        java.util.Map<java.lang.String, java.util.List<com.amap.api.mapcore.util.he.a>> a;
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
            if (obj != null && com.amap.api.mapcore.util.he.c.class == obj.getClass()) {
                com.amap.api.mapcore.util.he.c cVar = (com.amap.api.mapcore.util.he.c) obj;
                if (this.a.equals(cVar.a) && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            java.util.Map<java.lang.String, java.util.List<com.amap.api.mapcore.util.he.a>> map = this.a;
            int hashCode = map != null ? map.hashCode() : 0;
            java.util.Map<java.lang.String, java.lang.String> map2 = this.b;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }
    }

    public static synchronized java.lang.String a(java.lang.String str, java.lang.String str2) throws com.amap.api.mapcore.util.eu {
        synchronized (com.amap.api.mapcore.util.he.class) {
            try {
                try {
                    java.lang.System.currentTimeMillis();
                    if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str)) {
                        android.content.Context context = com.amap.api.mapcore.util.ew.c;
                        try {
                            if (b == null) {
                                b = java.util.Collections.synchronizedList(new java.util.ArrayList(8));
                            }
                            if (context != null && !b.contains(str2)) {
                                b.add(str2);
                                java.lang.String a2 = com.amap.api.mapcore.util.gq.a(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                                if (!android.text.TextUtils.isEmpty(a2)) {
                                    a(str2, new org.json.JSONObject(a2));
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "llhl");
                        }
                        if (a != null && a.size() > 0) {
                            if (!a.containsKey(str2)) {
                                return str;
                            }
                            com.amap.api.mapcore.util.he.c cVar = a.get(str2);
                            if (cVar == null) {
                                return str;
                            }
                            if (a(str, cVar, str2)) {
                                throw new com.amap.api.mapcore.util.eu("服务QPS超限");
                            }
                            return b(str, cVar, str2);
                        }
                        return str;
                    }
                    return str;
                } finally {
                }
            } catch (com.amap.api.mapcore.util.eu e2) {
                throw e2;
            } catch (java.lang.Throwable th2) {
                com.amap.api.mapcore.util.ga.a(th2, "hlUtil", "pcr");
                return str;
            }
        }
    }

    public static void a() {
        try {
            android.content.Context context = com.amap.api.mapcore.util.ew.c;
            if (context == null) {
                return;
            }
            com.amap.api.mapcore.util.hr.a(b(), context);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized void a(com.amap.api.mapcore.util.fh fhVar, org.json.JSONObject jSONObject) {
        synchronized (com.amap.api.mapcore.util.he.class) {
            if (fhVar == null) {
                return;
            }
            try {
                java.lang.String a2 = fhVar.a();
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                if (jSONObject == null) {
                    a(a2);
                }
                if (!com.amap.api.mapcore.util.ew.a(jSONObject.optString("able", null), false)) {
                    a(a2);
                } else {
                    com.amap.api.mapcore.util.gq.a(com.amap.api.mapcore.util.ew.c, "Yb3Blbl9odHRwX2NvbnRyb2w", a2, jSONObject.toString());
                    a(a2, jSONObject);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "hlUtil", "par");
            }
        }
    }

    private static void a(com.amap.api.mapcore.util.he.c cVar, org.json.JSONObject jSONObject) {
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
                                com.amap.api.mapcore.util.he.a aVar = new com.amap.api.mapcore.util.he.a((byte) 0);
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
            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "pbr");
        }
    }

    private static synchronized void a(java.lang.String str) {
        synchronized (com.amap.api.mapcore.util.he.class) {
            try {
                if (a.containsKey(str)) {
                    a.remove(str);
                }
                android.content.SharedPreferences.Editor a2 = com.amap.api.mapcore.util.gq.a(com.amap.api.mapcore.util.ew.c, "Yb3Blbl9odHRwX2NvbnRyb2w");
                com.amap.api.mapcore.util.gq.a(a2, str);
                com.amap.api.mapcore.util.gq.a(a2);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "hlUtil", com.anythink.core.common.h.c.R);
            }
        }
    }

    private static void a(java.lang.String str, com.amap.api.mapcore.util.he.c cVar) {
        try {
            if (a == null) {
                a = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            a.put(str, cVar);
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "ucr");
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
            android.content.Context context = com.amap.api.mapcore.util.ew.c;
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
                    jSONObject.put("type", com.amap.api.mapcore.util.fx.j);
                    jSONObject.put("name", str);
                    jSONObject.put("version", com.amap.api.mapcore.util.fx.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    java.lang.String jSONObject2 = jSONObject.toString();
                    if (android.text.TextUtils.isEmpty(jSONObject2)) {
                        return;
                    }
                    com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "core", "2.0", "O005");
                    hqVar.a(jSONObject2);
                    com.amap.api.mapcore.util.hr.a(hqVar, context);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            com.amap.api.mapcore.util.he.c cVar = new com.amap.api.mapcore.util.he.c((byte) 0);
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

    public static void a(java.net.URL url, com.amap.api.mapcore.util.hj hjVar) {
        java.util.List<java.lang.String> list;
        try {
            if (c == null) {
                c = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = hjVar.b;
            if (map != null && map.containsKey("nb") && (list = hjVar.b.get("nb")) != null && list.size() > 0) {
                java.lang.String[] split = list.get(0).split("#");
                if (split.length < 2) {
                    return;
                }
                int parseInt = java.lang.Integer.parseInt(split[0]);
                long parseInt2 = java.lang.Integer.parseInt(split[1]);
                com.amap.api.mapcore.util.he.b bVar = new com.amap.api.mapcore.util.he.b((byte) 0);
                bVar.a = hjVar;
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
            android.content.Context context = com.amap.api.mapcore.util.ew.c;
            if (context != null && !android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("timestamp", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", com.amap.api.mapcore.util.fx.g);
                } else {
                    jSONObject.put("type", com.amap.api.mapcore.util.fx.f);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", com.amap.api.mapcore.util.fx.a(str));
                java.lang.String jSONObject2 = jSONObject.toString();
                com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "core", "2.0", "O005");
                hqVar.a(jSONObject2);
                com.amap.api.mapcore.util.hr.a(hqVar, context);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(boolean z, java.lang.String str, java.lang.String str2, int i) {
        try {
            android.content.Context context = com.amap.api.mapcore.util.ew.c;
            if (context != null && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("timestamp", java.lang.System.currentTimeMillis());
                java.lang.String a2 = com.amap.api.mapcore.util.fx.a(str);
                if (z) {
                    jSONObject.put("type", com.amap.api.mapcore.util.fx.i);
                } else {
                    jSONObject.put("type", com.amap.api.mapcore.util.fx.h);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", a2);
                jSONObject.put("uri", android.net.Uri.parse(str2).getPath());
                jSONObject.put("blockLevel", i);
                java.lang.String jSONObject2 = jSONObject.toString();
                if (android.text.TextUtils.isEmpty(jSONObject2)) {
                    return;
                }
                com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "core", "2.0", "O005");
                hqVar.a(jSONObject2);
                if (f == null) {
                    f = java.util.Collections.synchronizedList(new java.util.ArrayList(16));
                }
                synchronized (f) {
                    f.add(hqVar);
                    if (f.size() >= 15) {
                        a();
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(com.amap.api.mapcore.util.he.a aVar) {
        if (aVar == null || aVar.c == 1.0d) {
            return false;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (!android.text.TextUtils.isEmpty(aVar.a) && aVar.b > 0) {
            long timeInMillis = currentTimeMillis - com.amap.api.mapcore.util.fi.a(aVar.a, org.apache.tools.ant.util.DateUtils.ISO8601_TIME_PATTERN).getTimeInMillis();
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

    private static boolean a(java.lang.String str, com.amap.api.mapcore.util.he.c cVar, java.lang.String str2) {
        java.util.Map<java.lang.String, java.util.List<com.amap.api.mapcore.util.he.a>> map;
        try {
            map = cVar.a;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "inb");
        }
        if (map != null && map.size() > 0) {
            if (map.containsKey("*")) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, java.util.List<com.amap.api.mapcore.util.he.a>>> it = map.entrySet().iterator();
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

    private static boolean a(java.util.List<com.amap.api.mapcore.util.he.a> list) {
        if (list != null && list.size() > 0) {
            java.util.Iterator<com.amap.api.mapcore.util.he.a> it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static com.amap.api.mapcore.util.hj b(java.lang.String str, java.lang.String str2) {
        android.net.Uri parse;
        if (c == null) {
            return null;
        }
        if (c.containsKey("app")) {
            com.amap.api.mapcore.util.he.b bVar = c.get("app");
            if (android.os.SystemClock.elapsedRealtime() <= bVar.b) {
                com.amap.api.mapcore.util.hj hjVar = bVar.a;
                if (hjVar != null) {
                    hjVar.e = false;
                }
                a(true, str2, str, 1);
                return hjVar;
            }
            c.remove("app");
        } else if (!android.text.TextUtils.isEmpty(str) && (parse = android.net.Uri.parse(str)) != null) {
            java.lang.String path = parse.getPath();
            if (c.containsKey(path)) {
                com.amap.api.mapcore.util.he.b bVar2 = c.get(path);
                if (android.os.SystemClock.elapsedRealtime() <= bVar2.b) {
                    com.amap.api.mapcore.util.hj hjVar2 = bVar2.a;
                    if (hjVar2 != null) {
                        hjVar2.e = false;
                    }
                    a(true, str2, str, 2);
                    return hjVar2;
                }
                c.remove(path);
            }
        }
        return null;
    }

    private static java.lang.String b(java.lang.String str, com.amap.api.mapcore.util.he.c cVar, java.lang.String str2) {
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
            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "pdr");
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
    private static java.util.List<com.amap.api.mapcore.util.hq> b() {
        /*
            r0 = 0
            java.util.List<com.amap.api.mapcore.util.hq> r1 = com.amap.api.mapcore.util.he.f     // Catch: java.lang.Throwable -> L2a
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.amap.api.mapcore.util.hq> r2 = com.amap.api.mapcore.util.he.f     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L1e
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L20
            if (r2 <= 0) goto L1e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.util.List<com.amap.api.mapcore.util.hq> r0 = com.amap.api.mapcore.util.he.f     // Catch: java.lang.Throwable -> L28
            r2.addAll(r0)     // Catch: java.lang.Throwable -> L28
            java.util.List<com.amap.api.mapcore.util.hq> r0 = com.amap.api.mapcore.util.he.f     // Catch: java.lang.Throwable -> L28
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.he.b():java.util.List");
    }

    private static void b(com.amap.api.mapcore.util.he.c cVar, org.json.JSONObject jSONObject) {
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
            com.amap.api.mapcore.util.ga.a(th, "hlUtil", "pdr");
        }
    }
}

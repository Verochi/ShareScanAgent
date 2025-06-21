package com.getui.gtc.server;

/* loaded from: classes22.dex */
public class ServerManager {
    private static final long SERVERS_REFRESH_PERIOD = 86400000;
    private static java.util.Map<java.lang.String, java.util.List<java.lang.String>> availableServerMap;
    private static java.util.Map<java.lang.String, java.util.List<java.lang.String>> configServerMap;
    private static java.util.Map<java.lang.String, java.lang.String> runningServerMap;
    private static final java.util.Map<java.lang.String, java.util.List<java.lang.String>> buildInServerMap = new java.util.concurrent.ConcurrentHashMap();
    private static final java.util.Map<java.lang.String, java.util.List<java.lang.String>> unavailableServerMap = new java.util.concurrent.ConcurrentHashMap();

    /* renamed from: com.getui.gtc.server.ServerManager$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {

        /* renamed from: com.getui.gtc.server.ServerManager$1$1, reason: invalid class name and collision with other inner class name */
        public class C03311 extends com.getui.gtc.f.e {

            /* renamed from: com.getui.gtc.server.ServerManager$1$1$1, reason: invalid class name and collision with other inner class name */
            public class C03321 implements com.getui.gtc.g.e.a {
                final /* synthetic */ java.lang.String a;

                public C03321(java.lang.String str) {
                    this.a = str;
                }

                @Override // com.getui.gtc.g.e.a
                public final void a(java.lang.String str) {
                    com.getui.gtc.e.c cVar;
                    com.getui.gtc.e.c cVar2;
                    com.getui.gtc.e.c cVar3;
                    cVar = com.getui.gtc.e.c.a.a;
                    cVar.a.a(this.a);
                    cVar2 = com.getui.gtc.e.c.a.a;
                    cVar2.a.b(str);
                    cVar3 = com.getui.gtc.e.c.a.a;
                    cVar3.a.c(str);
                    com.getui.gtc.server.ServerManager.parseServerProperties(str, com.getui.gtc.server.ServerManager.getConfigServerMap());
                    com.getui.gtc.server.ServerManager.parseServerProperties(str, com.getui.gtc.server.ServerManager.getAvailableServerMap());
                }
            }

            public C03311() {
            }

            @Override // com.getui.gtc.f.e
            public final void a(java.lang.String str) {
            }

            @Override // com.getui.gtc.f.e
            public final void a(java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.lang.String> map2) {
                com.getui.gtc.e.c cVar;
                if (map2 == null || map2.size() <= 0) {
                    return;
                }
                java.lang.String str = map2.get("sdk.gtc.hosts.url");
                if (map != null && map.size() > 0) {
                    java.lang.String str2 = map.get("sdk.gtc.hosts.url");
                    if (android.text.TextUtils.isEmpty(str) || str.equalsIgnoreCase(str2)) {
                        return;
                    }
                }
                cVar = com.getui.gtc.e.c.a.a;
                java.lang.String str3 = cVar.a.f;
                if (android.text.TextUtils.isEmpty(str) || str.equalsIgnoreCase(str3)) {
                    return;
                }
                com.getui.gtc.g.e.a(str, map2.get("sdk.gtc.hosts.key"), new com.getui.gtc.server.ServerManager.AnonymousClass1.C03311.C03321(str));
            }
        }

        /* renamed from: com.getui.gtc.server.ServerManager$1$2, reason: invalid class name */
        public class AnonymousClass2 implements com.getui.gtc.g.e.a {
            final /* synthetic */ java.lang.String a;

            public AnonymousClass2(java.lang.String str) {
                this.a = str;
            }

            @Override // com.getui.gtc.g.e.a
            public final void a(java.lang.String str) {
                com.getui.gtc.e.c cVar;
                com.getui.gtc.e.c cVar2;
                com.getui.gtc.e.c cVar3;
                cVar = com.getui.gtc.e.c.a.a;
                cVar.a.a(this.a);
                cVar2 = com.getui.gtc.e.c.a.a;
                cVar2.a.b(str);
                cVar3 = com.getui.gtc.e.c.a.a;
                cVar3.a.c(str);
                com.getui.gtc.server.ServerManager.parseServerProperties(str, com.getui.gtc.server.ServerManager.getConfigServerMap());
                com.getui.gtc.server.ServerManager.parseServerProperties(str, com.getui.gtc.server.ServerManager.getAvailableServerMap());
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.e.c cVar;
            com.getui.gtc.e.c cVar2;
            com.getui.gtc.e.c cVar3;
            synchronized (com.getui.gtc.server.ServerManager.class) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                cVar = com.getui.gtc.e.c.a.a;
                if (currentTimeMillis - cVar.a.j > 86400000) {
                    cVar3 = com.getui.gtc.e.c.a.a;
                    com.getui.gtc.e.d dVar = cVar3.a;
                    if (dVar.a(14, currentTimeMillis)) {
                        dVar.j = currentTimeMillis;
                    }
                    com.getui.gtc.server.ServerManager.getAvailableServerMap().clear();
                    com.getui.gtc.server.ServerManager.getAvailableServerMap().putAll(com.getui.gtc.server.ServerManager.getConfigServerMap());
                    com.getui.gtc.server.ServerManager.saveAvailableConfigServers();
                }
                java.util.Map<java.lang.String, java.lang.String> a = com.getui.gtc.f.c.a(new com.getui.gtc.server.ServerManager.AnonymousClass1.C03311());
                if (a != null && a.size() > 0) {
                    java.lang.String str = a.get("sdk.gtc.hosts.url");
                    cVar2 = com.getui.gtc.e.c.a.a;
                    java.lang.String str2 = cVar2.a.f;
                    if (!android.text.TextUtils.isEmpty(str) && !str.equalsIgnoreCase(str2)) {
                        com.getui.gtc.g.e.a(str, a.get("sdk.gtc.hosts.key"), new com.getui.gtc.server.ServerManager.AnonymousClass1.AnonymousClass2(str));
                    }
                }
            }
        }
    }

    public static synchronized void addBuildInServerMap(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        synchronized (com.getui.gtc.server.ServerManager.class) {
            buildInServerMap.putAll(map);
        }
    }

    public static synchronized void confirmServer(java.lang.String str, java.lang.String str2) {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        synchronized (com.getui.gtc.server.ServerManager.class) {
            java.util.List<java.lang.String> list = unavailableServerMap.get(str);
            if (list != null) {
                list.remove(str2);
            }
            cVar = com.getui.gtc.e.c.a.a;
            java.lang.String str3 = cVar.a.i;
            try {
                java.util.Properties properties = new java.util.Properties();
                if (!android.text.TextUtils.isEmpty(str3)) {
                    properties.load(new java.io.StringReader(str3));
                }
                properties.put(str, str2);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (java.util.Map.Entry entry : properties.entrySet()) {
                    java.lang.String str4 = (java.lang.String) entry.getKey();
                    java.lang.String str5 = (java.lang.String) entry.getValue();
                    sb.append(str4);
                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    sb.append(str5);
                    sb.append("\n");
                }
                cVar2 = com.getui.gtc.e.c.a.a;
                com.getui.gtc.e.d dVar = cVar2.a;
                java.lang.String sb2 = sb.toString();
                try {
                    if (dVar.a(13, android.util.Base64.encodeToString(com.getui.gtc.base.crypt.SecureCryptTools.getInstance().encrypt(sb2.getBytes()), 0))) {
                        dVar.i = sb2;
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.h.c.a.c(th);
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.h.c.a.b(th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> getAvailableServerMap() {
        com.getui.gtc.e.c cVar;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = availableServerMap;
        if (map != null) {
            return map;
        }
        availableServerMap = new java.util.HashMap();
        cVar = com.getui.gtc.e.c.a.a;
        parseServerProperties(cVar.a.h, availableServerMap);
        return availableServerMap;
    }

    public static synchronized java.util.List<java.lang.String> getBuildInServers(java.lang.String str) {
        java.util.List<java.lang.String> list;
        synchronized (com.getui.gtc.server.ServerManager.class) {
            list = buildInServerMap.get(str);
        }
        return list;
    }

    public static synchronized java.util.List<java.lang.String> getConfigServerMap(java.lang.String str) {
        java.util.List<java.lang.String> list;
        synchronized (com.getui.gtc.server.ServerManager.class) {
            list = getConfigServerMap().get(str);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> getConfigServerMap() {
        com.getui.gtc.e.c cVar;
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = configServerMap;
        if (map != null) {
            return map;
        }
        configServerMap = new java.util.HashMap();
        cVar = com.getui.gtc.e.c.a.a;
        parseServerProperties(cVar.a.g, configServerMap);
        return configServerMap;
    }

    private static java.util.Map<java.lang.String, java.lang.String> getRunningServerMap() {
        com.getui.gtc.e.c cVar;
        java.util.Map<java.lang.String, java.lang.String> map = runningServerMap;
        if (map != null) {
            return map;
        }
        runningServerMap = new java.util.HashMap();
        try {
            cVar = com.getui.gtc.e.c.a.a;
            java.lang.String str = cVar.a.i;
            if (!android.text.TextUtils.isEmpty(str)) {
                java.util.Properties properties = new java.util.Properties();
                properties.load(new java.io.StringReader(str));
                for (java.util.Map.Entry entry : properties.entrySet()) {
                    runningServerMap.put((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
        }
        return runningServerMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        getRunningServerMap().put(r5, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.lang.String getServer(java.lang.String str) {
        java.util.List<java.lang.String> list;
        synchronized (com.getui.gtc.server.ServerManager.class) {
            java.lang.String str2 = getRunningServerMap().get(str);
            if (android.text.TextUtils.isEmpty(str2) && (list = buildInServerMap.get(str)) != null && list.size() > 0) {
                str2 = list.get(0);
            }
            java.util.List<java.lang.String> list2 = getAvailableServerMap().get(str);
            if (list2 != null && list2.size() > 0 && !list2.contains(str2)) {
                java.lang.String str3 = list2.get(0);
                getRunningServerMap().put(str, str3);
                return str3;
            }
            return str2;
        }
    }

    @java.lang.Deprecated
    public static void initServerMap(android.content.Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseServerProperties(java.lang.String str, java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        if (map == null) {
            return;
        }
        map.clear();
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.util.Properties properties = new java.util.Properties();
            properties.load(new java.io.StringReader(str));
            for (java.util.Map.Entry entry : properties.entrySet()) {
                java.lang.String str2 = (java.lang.String) entry.getKey();
                java.lang.String str3 = (java.lang.String) entry.getValue();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                map.put(str2, arrayList);
                org.json.JSONObject jSONObject = new org.json.JSONObject(str3);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                java.util.HashMap hashMap = new java.util.HashMap();
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray(next);
                    arrayList2.add(next);
                    java.util.ArrayList arrayList3 = new java.util.ArrayList();
                    hashMap.put(next, arrayList3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        java.lang.String str4 = (java.lang.String) jSONArray.opt(i);
                        if (!android.text.TextUtils.isEmpty(str4) && !arrayList3.contains(str4)) {
                            arrayList3.add(str4);
                        }
                    }
                }
                java.util.Collections.sort(arrayList2);
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((java.util.Collection) hashMap.get((java.lang.String) it.next()));
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.h.c.a.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveAvailableConfigServers() {
        com.getui.gtc.e.c cVar;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : availableServerMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                jSONObject.put("1", jSONArray);
                java.util.Iterator<java.lang.String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                sb.append(jSONObject.toString());
            } catch (org.json.JSONException e) {
                com.getui.gtc.h.c.a.b(e);
            }
            sb.append("\n");
        }
        cVar = com.getui.gtc.e.c.a.a;
        cVar.a.c(sb.toString());
    }

    public static synchronized boolean switchServer(java.lang.String str, java.lang.String str2) {
        synchronized (com.getui.gtc.server.ServerManager.class) {
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = unavailableServerMap;
            java.util.List<java.lang.String> list = map.get(str);
            if (list == null) {
                list = new java.util.ArrayList<>();
                map.put(str, list);
            }
            if (!list.contains(str2)) {
                list.add(str2);
            }
            java.util.List<java.lang.String> list2 = getAvailableServerMap().get(str);
            if (list2 != null) {
                list2.remove(str2);
                saveAvailableConfigServers();
            }
            if (!android.text.TextUtils.equals(str2, getRunningServerMap().get(str))) {
                return true;
            }
            if (list2 != null && list2.size() > 0) {
                getRunningServerMap().put(str, list2.get(0));
                return true;
            }
            java.util.List<java.lang.String> list3 = buildInServerMap.get(str);
            if (list3 != null && list3.size() > 0) {
                for (java.lang.String str3 : list3) {
                    if (!list.contains(str3) && !android.text.TextUtils.equals(str3, str2)) {
                        getRunningServerMap().put(str, str3);
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    public static synchronized void updateConfigServerMap() {
        synchronized (com.getui.gtc.server.ServerManager.class) {
            com.getui.gtc.base.util.ScheduleQueue.getInstance().addSchedule(new com.getui.gtc.server.ServerManager.AnonymousClass1());
        }
    }
}

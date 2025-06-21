package com.xiaomi.push;

/* loaded from: classes19.dex */
public class bv {
    protected static android.content.Context c;
    private static com.xiaomi.push.bv l;
    private static com.xiaomi.push.bv.a m;
    private static java.lang.String n;
    private static java.lang.String o;
    protected final java.util.Map<java.lang.String, com.xiaomi.push.bs> a;
    protected com.xiaomi.push.bv.b d;
    java.lang.String e;
    private com.xiaomi.push.bu g;
    private java.lang.String h;
    private long i;
    private final long j;
    private long k;
    protected static final java.util.Map<java.lang.String, com.xiaomi.push.br> b = new java.util.HashMap();
    protected static boolean f = false;

    public interface a {
        com.xiaomi.push.bv a(android.content.Context context, com.xiaomi.push.bv.b bVar, java.lang.String str);
    }

    public interface b {
        java.lang.String a(java.lang.String str);
    }

    private bv(android.content.Context context, com.xiaomi.push.bu buVar, com.xiaomi.push.bv.b bVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.a = new java.util.HashMap();
        this.h = "0";
        this.i = 0L;
        this.j = 15L;
        this.k = 0L;
        this.e = "isp_prov_city_country_ip";
        this.d = bVar;
        this.g = new com.xiaomi.push.bw(this);
        this.h = str;
        n = str2 == null ? context.getPackageName() : str2;
        o = str3 == null ? k() : str3;
    }

    public bv(android.content.Context context, com.xiaomi.push.bv.b bVar, java.lang.String str) {
        this(context, null, bVar, str, null, null);
    }

    public static synchronized com.xiaomi.push.bv a() {
        com.xiaomi.push.bv bvVar;
        synchronized (com.xiaomi.push.bv.class) {
            bvVar = l;
            if (bvVar == null) {
                throw new java.lang.IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return bvVar;
    }

    private java.util.ArrayList<com.xiaomi.push.br> a(java.util.ArrayList<java.lang.String> arrayList) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2;
        java.lang.String next;
        synchronized (this.a) {
            java.util.Iterator<com.xiaomi.push.bs> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            loop1: while (true) {
                for (boolean z = false; !z; z = true) {
                    java.util.Iterator<java.lang.String> it2 = this.a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.a.get(next).b.isEmpty()) {
                            break;
                        }
                    }
                }
                this.a.remove(next);
            }
        }
        synchronized (this.a) {
            i();
            for (java.lang.String str : this.a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        java.util.Map<java.lang.String, com.xiaomi.push.br> map = b;
        synchronized (map) {
            for (java.lang.Object obj : map.values().toArray()) {
                com.xiaomi.push.br brVar = (com.xiaomi.push.br) obj;
                if (!brVar.a()) {
                    b.remove(brVar.c);
                }
            }
        }
        if (!arrayList.contains(g())) {
            arrayList.add(g());
        }
        java.util.ArrayList<com.xiaomi.push.br> arrayList2 = new java.util.ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            java.lang.String str2 = com.xiaomi.push.ai.d(c) ? com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI : "wap";
            java.lang.String a2 = a(arrayList, str2, this.h, true);
            if (!android.text.TextUtils.isEmpty(a2)) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(a2);
                com.xiaomi.channel.commonutils.logger.b.b(a2);
                if (com.baidu.mobads.sdk.internal.bz.k.equalsIgnoreCase(jSONObject3.getString(androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH))) {
                    org.json.JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    java.lang.String string = jSONObject4.getString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_PROVINCE);
                    java.lang.String string2 = jSONObject4.getString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY);
                    java.lang.String string3 = jSONObject4.getString("isp");
                    java.lang.String string4 = jSONObject4.getString("ip");
                    java.lang.String string5 = jSONObject4.getString("country");
                    org.json.JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        java.lang.String str3 = arrayList.get(i2);
                        org.json.JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("no bucket found for ".concat(java.lang.String.valueOf(str3)));
                            jSONObject = jSONObject5;
                        } else {
                            com.xiaomi.push.br brVar2 = new com.xiaomi.push.br(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                java.lang.String string6 = optJSONArray.getString(i3);
                                if (android.text.TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    brVar2.a(new com.xiaomi.push.cb(string6, optJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, brVar2);
                            brVar2.h = string5;
                            brVar2.d = string;
                            brVar2.f = string3;
                            brVar2.g = string4;
                            brVar2.e = string2;
                            if (jSONObject4.has("stat-percent")) {
                                brVar2.j = jSONObject4.getDouble("stat-percent");
                            }
                            if (jSONObject4.has("stat-domain")) {
                                brVar2.k = jSONObject4.getString("stat-domain");
                            }
                            if (jSONObject4.has(com.huawei.hms.push.constant.RemoteMessageConst.TTL)) {
                                brVar2.a(jSONObject4.getInt(com.huawei.hms.push.constant.RemoteMessageConst.TTL) * 1000);
                            }
                            this.e = brVar2.c();
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    org.json.JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        java.util.Iterator<java.lang.String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            java.lang.String next2 = keys.next();
                            org.json.JSONArray optJSONArray2 = optJSONObject.optJSONArray(next2);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.a("no bucket found for ".concat(java.lang.String.valueOf(next2)));
                            } else {
                                com.xiaomi.push.br brVar3 = new com.xiaomi.push.br(next2);
                                brVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    java.lang.String string7 = optJSONArray2.getString(i4);
                                    if (!android.text.TextUtils.isEmpty(string7)) {
                                        brVar3.a(new com.xiaomi.push.cb(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                java.util.Map<java.lang.String, com.xiaomi.push.br> map2 = b;
                                synchronized (map2) {
                                    map2.put(next2, brVar3);
                                }
                            }
                        }
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            com.xiaomi.push.br brVar4 = arrayList2.get(i5);
            if (brVar4 != null) {
                a(arrayList.get(i5), brVar4);
            }
        }
        f();
        return arrayList2;
    }

    public static synchronized void a(android.content.Context context, com.xiaomi.push.bv.b bVar, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.xiaomi.push.bv.class) {
            android.content.Context applicationContext = context.getApplicationContext();
            c = applicationContext;
            if (applicationContext == null) {
                c = context;
            }
            if (l == null) {
                com.xiaomi.push.bv.a aVar = m;
                if (aVar == null) {
                    l = new com.xiaomi.push.bv(context, null, bVar, str, str2, str3);
                    return;
                }
                l = aVar.a(context, bVar, str);
            }
        }
    }

    public static synchronized void a(com.xiaomi.push.bv.a aVar) {
        synchronized (com.xiaomi.push.bv.class) {
            m = aVar;
            l = null;
        }
    }

    private void a(java.lang.String str, com.xiaomi.push.br brVar) {
        if (android.text.TextUtils.isEmpty(str) || brVar == null) {
            throw new java.lang.IllegalArgumentException("the argument is invalid " + str + ", " + brVar);
        }
        synchronized (this.a) {
            i();
            if (this.a.containsKey(str)) {
                this.a.get(str).a(brVar);
            } else {
                com.xiaomi.push.bs bsVar = new com.xiaomi.push.bs(str);
                bsVar.a(brVar);
                this.a.put(str, bsVar);
            }
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        java.util.Map<java.lang.String, com.xiaomi.push.br> map = b;
        com.xiaomi.push.br brVar = map.get(str);
        synchronized (map) {
            if (brVar == null) {
                com.xiaomi.push.br brVar2 = new com.xiaomi.push.br(str);
                brVar2.a(604800000L);
                brVar2.b(str2);
                map.put(str, brVar2);
            } else {
                brVar.b(str2);
            }
        }
    }

    public static java.lang.String b() {
        android.net.NetworkInfo activeNetworkInfo;
        android.content.Context context = c;
        if (context == null) {
            return "unknown";
        }
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName();
        } catch (java.lang.Throwable unused) {
            return "unknown";
        }
    }

    public static com.xiaomi.push.br c(java.lang.String str) {
        com.xiaomi.push.br brVar;
        java.util.Map<java.lang.String, com.xiaomi.push.br> map = b;
        synchronized (map) {
            brVar = map.get(str);
        }
        return brVar;
    }

    private com.xiaomi.push.br d(java.lang.String str) {
        com.xiaomi.push.bs bsVar;
        com.xiaomi.push.br a2;
        synchronized (this.a) {
            i();
            bsVar = this.a.get(str);
        }
        if (bsVar == null || (a2 = bsVar.a()) == null) {
            return null;
        }
        return a2;
    }

    private com.xiaomi.push.br e(java.lang.String str) {
        if (java.lang.System.currentTimeMillis() - this.k <= this.i * 60 * 1000) {
            return null;
        }
        this.k = java.lang.System.currentTimeMillis();
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        arrayList.add(str);
        com.xiaomi.push.br brVar = a(arrayList).get(0);
        if (brVar != null) {
            this.i = 0L;
            return brVar;
        }
        long j = this.i;
        if (j >= 15) {
            return null;
        }
        this.i = j + 1;
        return null;
    }

    private static java.lang.String f(java.lang.String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new java.lang.String(bytes);
        } catch (java.io.UnsupportedEncodingException unused) {
            return str;
        }
    }

    private static java.lang.String g() {
        java.lang.String a2 = com.xiaomi.push.service.d.a(c).a();
        return (android.text.TextUtils.isEmpty(a2) || com.xiaomi.push.service.a.a.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    private static java.lang.String h() {
        java.io.BufferedReader bufferedReader;
        java.io.File file;
        try {
            file = new java.io.File(c.getFilesDir(), j());
        } catch (java.lang.Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            com.xiaomi.push.c.a((java.io.Closeable) null);
            return null;
        }
        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file)));
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            try {
                com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                return null;
            } finally {
                com.xiaomi.push.c.a(bufferedReader);
            }
        }
    }

    private boolean i() {
        synchronized (this.a) {
            if (f) {
                return true;
            }
            f = true;
            this.a.clear();
            try {
                java.lang.String h = h();
                if (!android.text.TextUtils.isEmpty(h)) {
                    synchronized (this.a) {
                        this.a.clear();
                        org.json.JSONObject jSONObject = new org.json.JSONObject(h);
                        if (jSONObject.optInt("ver") != 2) {
                            throw new org.json.JSONException("Bad version");
                        }
                        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                com.xiaomi.push.bs a2 = new com.xiaomi.push.bs().a(optJSONArray.getJSONObject(i));
                                this.a.put(a2.a, a2);
                            }
                        }
                        org.json.JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                org.json.JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                java.lang.String optString = jSONObject2.optString(com.alipay.sdk.m.l.c.f);
                                if (!android.text.TextUtils.isEmpty(optString)) {
                                    try {
                                        com.xiaomi.push.br a3 = new com.xiaomi.push.br(optString).a(jSONObject2);
                                        b.put(a3.c, a3);
                                        com.xiaomi.channel.commonutils.logger.b.a("load local reserved host for " + a3.c);
                                    } catch (org.json.JSONException unused) {
                                        com.xiaomi.channel.commonutils.logger.b.a("parse reserved host fail.");
                                    }
                                }
                            }
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (java.lang.Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    private static java.lang.String j() {
        if ("com.xiaomi.xmsf".equals(n)) {
            return n;
        }
        return n + ":pushservice";
    }

    private static java.lang.String k() {
        try {
            android.content.pm.PackageInfo packageInfo = c.getPackageManager().getPackageInfo(c.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (java.lang.Exception unused) {
            return "0";
        }
    }

    private org.json.JSONObject l() {
        org.json.JSONObject jSONObject;
        synchronized (this.a) {
            jSONObject = new org.json.JSONObject();
            jSONObject.put("ver", 2);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            java.util.Iterator<com.xiaomi.push.bs> it = this.a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().c());
            }
            jSONObject.put("data", jSONArray);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            java.util.Iterator<com.xiaomi.push.br> it2 = b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().d());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    public final com.xiaomi.push.br a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("the url is empty");
        }
        return a(new java.net.URL(str).getHost(), true);
    }

    public final com.xiaomi.push.br a(java.lang.String str, boolean z) {
        com.xiaomi.push.br e;
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("the host is empty");
        }
        com.xiaomi.push.br d = d(str);
        return (d == null || !d.a()) ? (z && com.xiaomi.push.ai.a(c) && (e = e(str)) != null) ? e : new com.xiaomi.push.bx(this, str, d) : d;
    }

    public java.lang.String a(java.util.ArrayList<java.lang.String> arrayList, java.lang.String str, java.lang.String str2, boolean z) {
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList<>();
        java.util.ArrayList<com.xiaomi.push.ah> arrayList3 = new java.util.ArrayList();
        arrayList3.add(new com.xiaomi.push.af("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new com.xiaomi.push.af("conpt", f(com.xiaomi.push.ai.i(c))));
        }
        if (z) {
            arrayList3.add(new com.xiaomi.push.af("reserved", "1"));
        }
        arrayList3.add(new com.xiaomi.push.af("uuid", str2));
        arrayList3.add(new com.xiaomi.push.af(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, com.xiaomi.push.ao.a(arrayList, ",")));
        arrayList3.add(new com.xiaomi.push.af("countrycode", com.xiaomi.push.service.d.a(c).b()));
        java.lang.String g = g();
        com.xiaomi.push.br d = d(g);
        java.lang.String format = java.lang.String.format(java.util.Locale.US, "https://%1$s/gslb/?ver=4.0", g);
        if (d == null) {
            arrayList2.add(format);
            java.util.Map<java.lang.String, com.xiaomi.push.br> map = b;
            synchronized (map) {
                com.xiaomi.push.br brVar = map.get(g);
                if (brVar != null) {
                    java.util.Iterator<java.lang.String> it = brVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(java.lang.String.format(java.util.Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = d.a(format);
        }
        java.util.Iterator<java.lang.String> it2 = arrayList2.iterator();
        java.io.IOException e = null;
        while (it2.hasNext()) {
            android.net.Uri.Builder buildUpon = android.net.Uri.parse(it2.next()).buildUpon();
            for (com.xiaomi.push.ah ahVar : arrayList3) {
                buildUpon.appendQueryParameter(ahVar.a(), ahVar.b());
            }
            try {
                com.xiaomi.push.bv.b bVar = this.d;
                return bVar == null ? com.xiaomi.push.ai.a(c, new java.net.URL(buildUpon.toString())) : bVar.a(buildUpon.toString());
            } catch (java.io.IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.a("network exception: " + e.getMessage());
        throw e;
    }

    public final com.xiaomi.push.br b(java.lang.String str) {
        return a(str, true);
    }

    public final void c() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public final java.lang.String d() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        synchronized (this.a) {
            for (java.util.Map.Entry<java.lang.String, com.xiaomi.push.bs> entry : this.a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public final void e() {
        java.util.ArrayList<java.lang.String> arrayList;
        synchronized (this.a) {
            i();
            arrayList = new java.util.ArrayList<>(this.a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                com.xiaomi.push.bs bsVar = this.a.get(arrayList.get(size));
                if (bsVar != null && bsVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        java.util.ArrayList<com.xiaomi.push.br> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a(arrayList.get(i), a2.get(i));
            }
        }
    }

    public final void f() {
        synchronized (this.a) {
            try {
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(c.openFileOutput(j(), 0)));
                java.lang.String jSONObject = l().toString();
                if (!android.text.TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("persist bucket failure: " + e.getMessage());
            }
        }
    }
}

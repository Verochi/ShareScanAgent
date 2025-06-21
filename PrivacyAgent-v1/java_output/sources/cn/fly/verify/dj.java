package cn.fly.verify;

/* loaded from: classes.dex */
public class dj {
    private static cn.fly.verify.dj d;
    private java.util.ArrayList<java.lang.String> g;
    private volatile java.util.HashMap<java.lang.String, java.lang.Long> h;
    private java.util.concurrent.locks.ReentrantReadWriteLock i;
    private java.util.concurrent.locks.ReentrantReadWriteLock j;
    private static final java.util.concurrent.CountDownLatch c = new java.util.concurrent.CountDownLatch(1);
    public static java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();
    private static final java.util.ArrayList<java.lang.String> b = new java.util.ArrayList<>(java.util.Arrays.asList("cfgc.zztfly.com"));
    private volatile java.util.concurrent.CountDownLatch k = c;
    private volatile java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>>> e = cn.fly.verify.bl.a().p();
    private volatile java.util.HashMap<java.lang.String, java.lang.String> f = cn.fly.verify.bl.a().q();

    /* renamed from: cn.fly.verify.dj$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cn.fly.verify.dj djVar = cn.fly.verify.dj.this;
            djVar.a(djVar.k, 0);
        }
    }

    static {
        a.put("gcfg", "cfgc.zztfly.com");
        a.put("gclg", "upc.zztfly.com");
        a.put("el", "errc.zztfly.com");
        a.put("dg", "devc.zztfly.com");
        a.put("dtc", "fdl.zztfly.com");
    }

    private dj() {
        java.util.ArrayList<java.lang.String> r = cn.fly.verify.bl.a().r();
        this.g = r;
        if (r == null || r.isEmpty()) {
            this.g = b;
        }
        this.h = cn.fly.verify.bl.a().s();
        this.i = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.j = new java.util.concurrent.locks.ReentrantReadWriteLock();
    }

    public static cn.fly.verify.dj a() {
        if (d == null) {
            synchronized (cn.fly.verify.dj.class) {
                if (d == null) {
                    d = new cn.fly.verify.dj();
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.concurrent.CountDownLatch countDownLatch, int i) {
        java.lang.Object obj;
        try {
            java.util.ArrayList<java.lang.String> arrayList = this.g;
            if (arrayList == null || i >= arrayList.size()) {
                cn.fly.verify.ed.a().b("DM No pdm");
            } else {
                java.lang.String a2 = cn.fly.verify.dw.a(this.g.get(i) + "/dm");
                java.util.HashMap<java.lang.String, java.lang.Object> hashMap = new java.util.HashMap<>();
                hashMap.put(cn.fly.verify.bj.a("006ekkVemUg el"), cn.fly.verify.dv.a());
                cn.fly.verify.fc.a aVar = new cn.fly.verify.fc.a();
                aVar.b = 3000;
                aVar.a = 5000;
                java.lang.String a3 = new cn.fly.verify.fc().a(a2, hashMap, (java.util.HashMap<java.lang.String, java.lang.String>) null, aVar);
                cn.fly.verify.ed.a().a("DM resp: " + a3, new java.lang.Object[0]);
                java.util.HashMap a4 = cn.fly.verify.fm.a(a3);
                if (a4 == null || a4.isEmpty() || (obj = a4.get(cn.fly.verify.bj.a("004dVfeedUg"))) == null || ((java.lang.Integer) obj).intValue() != 200) {
                    a(countDownLatch, i + 1);
                } else {
                    java.util.HashMap hashMap2 = (java.util.HashMap) a4.get(cn.fly.verify.bj.a("004 edWeje"));
                    if (hashMap2 != null && !hashMap2.isEmpty()) {
                        try {
                            java.util.HashMap hashMap3 = (java.util.HashMap) hashMap2.get(cn.fly.verify.bj.a("004>ed-eje"));
                            if (hashMap3 != null && !hashMap3.isEmpty()) {
                                java.util.HashMap hashMap4 = new java.util.HashMap();
                                for (java.util.Map.Entry entry : hashMap3.entrySet()) {
                                    java.lang.String str = (java.lang.String) entry.getKey();
                                    java.util.HashMap hashMap5 = (java.util.HashMap) entry.getValue();
                                    java.util.HashMap hashMap6 = new java.util.HashMap();
                                    if (hashMap5 != null && !hashMap5.isEmpty()) {
                                        for (java.util.Map.Entry entry2 : hashMap5.entrySet()) {
                                            java.lang.String str2 = (java.lang.String) entry2.getKey();
                                            java.util.ArrayList arrayList2 = (java.util.ArrayList) entry2.getValue();
                                            java.util.ArrayList arrayList3 = new java.util.ArrayList();
                                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                                java.util.Iterator it = arrayList2.iterator();
                                                while (it.hasNext()) {
                                                    java.lang.String str3 = (java.lang.String) it.next();
                                                    if (b(str3)) {
                                                        arrayList3.add(str3);
                                                    }
                                                }
                                            }
                                            if (!arrayList3.isEmpty()) {
                                                hashMap6.put(str2, arrayList3);
                                            }
                                        }
                                    }
                                    if (!hashMap6.isEmpty()) {
                                        hashMap4.put(str, hashMap6);
                                    }
                                }
                                if (hashMap4.isEmpty()) {
                                    cn.fly.verify.ed.a().a("DM busi no avai dm", new java.lang.Object[0]);
                                } else {
                                    try {
                                        cn.fly.verify.ed.a().a("DM busi w 2 cac: " + hashMap4, new java.lang.Object[0]);
                                        if (this.i.writeLock().tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                                            this.e.clear();
                                            this.e.putAll(hashMap4);
                                            cn.fly.verify.bl.a().b(this.e);
                                        }
                                        try {
                                            this.i.writeLock().unlock();
                                        } catch (java.lang.Throwable th) {
                                            cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        try {
                                            cn.fly.verify.ed.a().a(th2, "DM " + th2.getMessage(), new java.lang.Object[0]);
                                            try {
                                                this.i.writeLock().unlock();
                                            } catch (java.lang.Throwable th3) {
                                                cn.fly.verify.ed.a().a(th3, "DM " + th3.getMessage(), new java.lang.Object[0]);
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            java.util.ArrayList arrayList4 = (java.util.ArrayList) hashMap2.get("p");
                            if (arrayList4 != null && !arrayList4.isEmpty()) {
                                java.util.ArrayList arrayList5 = new java.util.ArrayList();
                                java.util.Iterator it2 = arrayList4.iterator();
                                while (it2.hasNext()) {
                                    java.lang.String str4 = (java.lang.String) it2.next();
                                    if (b(str4)) {
                                        arrayList5.add(str4);
                                    }
                                }
                                if (arrayList5.isEmpty()) {
                                    cn.fly.verify.ed.a().a("DM prx no avai dm", new java.lang.Object[0]);
                                } else {
                                    cn.fly.verify.ed.a().a("DM prx w 2 cac: " + arrayList5, new java.lang.Object[0]);
                                    this.g.clear();
                                    this.g.addAll(arrayList5);
                                    cn.fly.verify.bl.a().a(this.g);
                                }
                            }
                        } catch (java.lang.Throwable th4) {
                            cn.fly.verify.ed.a().a(th4, "DM " + th4.getMessage(), new java.lang.Object[0]);
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th5) {
            try {
                cn.fly.verify.ed.a().a(th5, "DM " + th5.getMessage(), new java.lang.Object[0]);
                a(countDownLatch, i + 1);
                if (countDownLatch.getCount() <= 0) {
                }
            } finally {
                if (countDownLatch.getCount() > 0) {
                }
            }
        }
    }

    private boolean a(java.lang.String str, java.lang.String str2) {
        java.lang.Long l;
        boolean z = true;
        try {
            if (this.j.readLock().tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                java.lang.String str3 = str + "_" + str2;
                if (this.h != null && this.h.containsKey(str3) && (l = this.h.get(str3)) != null) {
                    if (java.lang.System.currentTimeMillis() - l.longValue() < 1800000) {
                        z = false;
                    }
                }
            }
            try {
                this.j.readLock().unlock();
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th2) {
            try {
                cn.fly.verify.ed.a().a(th2, "DM " + th2.getMessage(), new java.lang.Object[0]);
                try {
                    this.j.readLock().unlock();
                } catch (java.lang.Throwable th3) {
                    cn.fly.verify.ed.a().a(th3, "DM " + th3.getMessage(), new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th4) {
                try {
                    this.j.readLock().unlock();
                } catch (java.lang.Throwable th5) {
                    cn.fly.verify.ed.a().a(th5, "DM " + th5.getMessage(), new java.lang.Object[0]);
                }
                throw th4;
            }
        }
        cn.fly.verify.ed.a().a("DM ck dur: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ", pass: " + z, new java.lang.Object[0]);
        return z;
    }

    private boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        boolean b2 = b(str3);
        if (b2) {
            try {
                if (this.j.writeLock().tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                    this.h.put(str + "_" + str2, java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    cn.fly.verify.bl.a().d(this.h);
                }
                try {
                    this.j.writeLock().unlock();
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th2) {
                try {
                    cn.fly.verify.ed.a().a(th2, "DM " + th2.getMessage(), new java.lang.Object[0]);
                    try {
                        this.j.writeLock().unlock();
                    } catch (java.lang.Throwable th3) {
                        cn.fly.verify.ed.a().a(th3, "DM " + th3.getMessage(), new java.lang.Object[0]);
                    }
                } catch (java.lang.Throwable th4) {
                    try {
                        this.j.writeLock().unlock();
                    } catch (java.lang.Throwable th5) {
                        cn.fly.verify.ed.a().a(th5, "DM " + th5.getMessage(), new java.lang.Object[0]);
                    }
                    throw th4;
                }
            }
        }
        return b2;
    }

    private boolean b(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                java.net.InetAddress[] allByName = java.net.InetAddress.getAllByName(str);
                if (allByName != null) {
                    for (java.net.InetAddress inetAddress : allByName) {
                        if (!c(inetAddress.getHostAddress())) {
                            cn.fly.verify.ed.a().a("DM ck ht: " + str + ", fai", new java.lang.Object[0]);
                            return false;
                        }
                    }
                }
                cn.fly.verify.ed.a().a("DM ck ht: " + str + ", suc", new java.lang.Object[0]);
                return true;
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
            }
        }
        cn.fly.verify.ed.a().a("DM ck ht: " + str + ", fai_emp|exp", new java.lang.Object[0]);
        return false;
    }

    private static boolean c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals("127.0.0.1") || str.startsWith("10.") || str.startsWith("192.168")) {
            return false;
        }
        if (str.startsWith("172.")) {
            java.lang.String[] split = str.split("\\.");
            if (split.length > 1) {
                try {
                    int parseInt = java.lang.Integer.parseInt(split[1]);
                    return parseInt < 16 || parseInt > 31;
                } catch (java.lang.Throwable th) {
                    cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
                }
            }
        }
        return true;
    }

    public java.lang.String a(java.lang.String str) {
        return cn.fly.verify.dw.a(a().a("FCOMMON", str, a.get(str), false));
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        java.util.HashMap<java.lang.String, java.util.ArrayList<java.lang.String>> hashMap;
        java.util.ArrayList<java.lang.String> arrayList;
        cn.fly.verify.ed.a().a("DM get: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + z, new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            cn.fly.verify.ed.a().a("DM Params 'sName' or 'aName' is null", new java.lang.Object[0]);
            return str3;
        }
        boolean z2 = this.k.getCount() == 0;
        try {
            if (this.i.readLock().tryLock(3000L, java.util.concurrent.TimeUnit.MILLISECONDS) && this.e != null && this.e.containsKey(str) && (hashMap = this.e.get(str)) != null && hashMap.containsKey(str2) && (arrayList = hashMap.get(str2)) != null && !arrayList.isEmpty()) {
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    if (!z || !a(str, str2)) {
                        if (this.f.containsKey(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2)) {
                            java.lang.String str4 = this.f.get(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
                            cn.fly.verify.ed.a().a("DM rtn [cac|chk_abt]: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str4, new java.lang.Object[0]);
                            try {
                                this.i.readLock().unlock();
                            } catch (java.lang.Throwable th) {
                                cn.fly.verify.ed.a().a(th, "DM " + th.getMessage(), new java.lang.Object[0]);
                            }
                            return str4;
                        }
                        if (!android.text.TextUtils.isEmpty(next)) {
                            cn.fly.verify.ed.a().a("DM rtn [cac]: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + next, new java.lang.Object[0]);
                            try {
                                this.i.readLock().unlock();
                            } catch (java.lang.Throwable th2) {
                                cn.fly.verify.ed.a().a(th2, "DM " + th2.getMessage(), new java.lang.Object[0]);
                            }
                            return next;
                        }
                    } else if (a(str, str2, next)) {
                        cn.fly.verify.ed.a().a("DM rtn [cac|chk]: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + next, new java.lang.Object[0]);
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = this.f;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(str);
                        sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        sb.append(str2);
                        hashMap2.put(sb.toString(), next);
                        cn.fly.verify.bl.a().c(this.f);
                        try {
                            this.i.readLock().unlock();
                        } catch (java.lang.Throwable th3) {
                            cn.fly.verify.ed.a().a(th3, "DM " + th3.getMessage(), new java.lang.Object[0]);
                        }
                        return next;
                    }
                }
            }
            try {
                this.i.readLock().unlock();
            } catch (java.lang.Throwable th4) {
                cn.fly.verify.ed.a().a(th4, "DM " + th4.getMessage(), new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th5) {
            try {
                cn.fly.verify.ed.a().a(th5, "DM " + th5.getMessage(), new java.lang.Object[0]);
                try {
                    this.i.readLock().unlock();
                } catch (java.lang.Throwable th6) {
                    cn.fly.verify.ed.a().a(th6, "DM " + th6.getMessage(), new java.lang.Object[0]);
                }
            } catch (java.lang.Throwable th7) {
                try {
                    this.i.readLock().unlock();
                } catch (java.lang.Throwable th8) {
                    cn.fly.verify.ed.a().a(th8, "DM " + th8.getMessage(), new java.lang.Object[0]);
                }
                throw th7;
            }
        }
        try {
            this.f.remove(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
            cn.fly.verify.bl.a().c(this.f);
            if (!z || !a(str, str2)) {
                if (!this.f.containsKey(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2)) {
                    cn.fly.verify.ed.a().a("DM rtn [def]" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str3, new java.lang.Object[0]);
                    return str3;
                }
                java.lang.String str5 = this.f.get(str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
                cn.fly.verify.ed.a().a("DM rtn [def|chk_abt]: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str5, new java.lang.Object[0]);
                return str5;
            }
            if (a(str, str2, str3)) {
                cn.fly.verify.ed.a().a("DM rtn [def|chk_true]: " + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str3, new java.lang.Object[0]);
                java.util.HashMap<java.lang.String, java.lang.String> hashMap3 = this.f;
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(str);
                sb2.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(str2);
                hashMap3.put(sb2.toString(), str3);
                cn.fly.verify.bl.a().c(this.f);
                return str3;
            }
            if (z2) {
                cn.fly.verify.ed.a().a("DM rtn [def|chk_false]" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str3, new java.lang.Object[0]);
                return str3;
            }
            if (this.k.await(5000L, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                cn.fly.verify.ed.a().a("DM awt next", new java.lang.Object[0]);
                return a(str, str2, str3, z);
            }
            cn.fly.verify.ed.a().a("DM rtn [def|awt_to]" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str3, new java.lang.Object[0]);
            return str3;
        } catch (java.lang.Throwable th9) {
            cn.fly.verify.ed.a().a(th9, "DM " + th9.getMessage(), new java.lang.Object[0]);
            cn.fly.verify.ed.a().a("DM rtn [def|exp]" + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + ": " + str3, new java.lang.Object[0]);
            return str3;
        }
    }

    public void b() {
        if (this.k != c && this.k.getCount() != 0) {
            cn.fly.verify.ed.a().a("DM obt abort", new java.lang.Object[0]);
            return;
        }
        cn.fly.verify.ed.a().a("DM obt start", new java.lang.Object[0]);
        this.k = new java.util.concurrent.CountDownLatch(1);
        cn.fly.verify.ea.c.execute(new cn.fly.verify.dj.AnonymousClass1());
    }
}

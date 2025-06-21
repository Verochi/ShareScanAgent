package cn.fly.verify;

/* loaded from: classes.dex */
public class dk {
    private static cn.fly.verify.dk b = new cn.fly.verify.dk();
    private volatile boolean c = false;
    private volatile long d = 0;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> e = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> f = new java.util.concurrent.ConcurrentHashMap<>();
    public final java.util.concurrent.atomic.AtomicBoolean a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: cn.fly.verify.dk$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        final /* synthetic */ int a;
        final /* synthetic */ boolean[] b;

        public AnonymousClass1(int i, boolean[] zArr) {
            this.a = i;
            this.b = zArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.util.concurrent.ConcurrentHashMap concurrentHashMap;
            java.lang.String b;
            int i;
            int i2 = this.a;
            if (i2 == 0) {
                this.b[0] = bVar.t();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("002Kcf^b");
                i = this.b[0];
            } else if (i2 == 1) {
                this.b[0] = bVar.s();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("002'cfcb");
                i = this.b[0];
            } else if (i2 == 2) {
                this.b[0] = bVar.u();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("002Zcc*i");
                i = this.b[0];
            } else if (i2 == 3) {
                this.b[0] = bVar.D();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("0025ee2i");
                i = this.b[0];
            } else if (i2 == 4) {
                this.b[0] = bVar.a();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("002Vci(h");
                i = this.b[0];
            } else {
                if (i2 != 5) {
                    return;
                }
                this.b[0] = bVar.q();
                concurrentHashMap = cn.fly.verify.dk.this.e;
                b = cn.fly.verify.ds.b("002)dbYi");
                i = this.b[0];
            }
            concurrentHashMap.put(b, java.lang.Integer.valueOf(i));
        }
    }

    /* renamed from: cn.fly.verify.dk$2, reason: invalid class name */
    public class AnonymousClass2 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.concurrent.LinkedBlockingQueue a;

        public AnonymousClass2(java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue) {
            this.a = linkedBlockingQueue;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.lang.String d = bVar.d();
            if (!android.text.TextUtils.isEmpty(d) && !android.text.TextUtils.equals("-1", d)) {
                this.a.offer(java.lang.Boolean.valueOf(!d.startsWith("460")));
            }
            this.a.offer(java.lang.Boolean.valueOf(!cn.fly.verify.dk.this.a(cn.fly.verify.ax.g())));
        }
    }

    /* renamed from: cn.fly.verify.dk$3, reason: invalid class name */
    public class AnonymousClass3 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.List a;
        final /* synthetic */ java.util.concurrent.LinkedBlockingQueue b;

        public AnonymousClass3(java.util.List list, java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue) {
            this.a = list;
            this.b = linkedBlockingQueue;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            for (int i = 0; i < this.a.size(); i++) {
                java.util.List<android.content.pm.ResolveInfo> f = bVar.f(i);
                if (f != null && f.size() > 0) {
                    this.b.offer(java.lang.Boolean.TRUE);
                }
            }
            this.b.offer(java.lang.Boolean.FALSE);
        }
    }

    /* renamed from: cn.fly.verify.dk$4, reason: invalid class name */
    public class AnonymousClass4 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.List a;
        final /* synthetic */ java.util.ArrayList b;
        final /* synthetic */ boolean[] c;

        public AnonymousClass4(java.util.List list, java.util.ArrayList arrayList, boolean[] zArr) {
            this.a = list;
            this.b = arrayList;
            this.c = zArr;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            for (int i = 0; i < this.a.size(); i++) {
                boolean e = bVar.e(i);
                this.b.add(java.lang.Boolean.valueOf(e));
                boolean[] zArr = this.c;
                boolean z = e | zArr[0];
                zArr[0] = z;
                if (z) {
                    return;
                }
            }
        }
    }

    private dk() {
    }

    public static cn.fly.verify.dk a() {
        return b;
    }

    private boolean a(int i) {
        boolean[] zArr = {true};
        cn.fly.verify.fh.c a = cn.fly.verify.fh.a(cn.fly.verify.ax.g());
        if (i == 0) {
            a.t();
        } else if (i == 1) {
            a.s();
        } else if (i == 2) {
            a.u();
        } else if (i == 3) {
            a.E();
        } else if (i == 4) {
            a.a();
        } else if (i == 5) {
            a.q();
        }
        a.a(new cn.fly.verify.dk.AnonymousClass1(i, zArr));
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(android.content.Context context) {
        java.util.Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().startsWith(com.anythink.expressad.video.dynview.a.a.Q) && android.text.TextUtils.equals(locale.getCountry(), "CN");
    }

    private boolean a(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            char[] charArray = str.toCharArray();
            java.util.HashMap hashMap = new java.util.HashMap();
            boolean z = false;
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                if (c == '1') {
                    z |= a(i);
                } else if (c != '0') {
                    java.util.List list = (java.util.List) hashMap.get(java.lang.Character.valueOf(c));
                    if (list == null) {
                        list = new java.util.ArrayList();
                    }
                    list.add(java.lang.Integer.valueOf(i));
                    hashMap.put(java.lang.Character.valueOf(charArray[i]), list);
                }
            }
            java.util.Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                java.util.Iterator it2 = ((java.util.List) ((java.util.Map.Entry) it.next()).getValue()).iterator();
                boolean z2 = true;
                while (it2.hasNext()) {
                    z2 &= a(((java.lang.Integer) it2.next()).intValue());
                }
                z |= z2;
            }
            return z;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().c(th);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
    
        if (cn.fly.verify.eh.a(cn.fly.verify.ax.g()).d().aw() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (d() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        java.lang.String str2 = "a";
        boolean z = true;
        if (android.text.TextUtils.equals(str, "a")) {
            if (((java.lang.Integer) cn.fly.verify.fq.a(hashMap.get("a"), 0)).intValue() == 1) {
            }
            z = false;
        } else {
            if (android.text.TextUtils.equals(str, "p")) {
                java.util.List<java.lang.String> list = (java.util.List) cn.fly.verify.fq.a(hashMap.get("p"), (java.lang.Object) null);
                java.util.ArrayList<java.lang.Boolean> arrayList = new java.util.ArrayList<>();
                boolean b2 = b(arrayList, list);
                this.f.put("p", arrayList);
                return b2;
            }
            if (android.text.TextUtils.equals(str, "fp")) {
                java.util.List<java.lang.String> list2 = (java.util.List) cn.fly.verify.fq.a(hashMap.get("fp"), (java.lang.Object) null);
                java.util.ArrayList<java.lang.Boolean> arrayList2 = new java.util.ArrayList<>();
                boolean b3 = b(arrayList2, list2);
                this.f.put("fp", arrayList2);
                return b3;
            }
            if (android.text.TextUtils.equals(str, "s")) {
                boolean a = a(new java.util.ArrayList<>(), (java.util.List<java.lang.String>) cn.fly.verify.fq.a(hashMap.get("s"), (java.lang.Object) null));
                this.f.put("s", java.lang.Boolean.valueOf(a));
                return a;
            }
            if (android.text.TextUtils.equals(str, com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_SIZE)) {
                boolean a2 = a(new java.util.ArrayList<>(), (java.util.List<java.lang.String>) cn.fly.verify.fq.a(hashMap.get(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_SIZE), (java.lang.Object) null));
                this.f.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_SIZE, java.lang.Boolean.valueOf(a2));
                return a2;
            }
            str2 = "d";
            if (!android.text.TextUtils.equals(str, "d")) {
                if (!android.text.TextUtils.equals(str, "bl")) {
                    return false;
                }
                boolean b4 = b((java.lang.String) cn.fly.verify.fq.a(hashMap.get("bl"), ""));
                this.f.put("bl", java.lang.Boolean.valueOf(b4));
                return b4;
            }
            if (((java.lang.Integer) cn.fly.verify.fq.a(hashMap.get("d"), 0)).intValue() == 1) {
            }
            z = false;
        }
        this.f.put(str2, java.lang.Boolean.valueOf(z));
        return z;
    }

    private boolean a(java.util.ArrayList<java.lang.Boolean> arrayList, java.util.List<java.lang.String> list) {
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        if (list != null && list.size() > 0) {
            cn.fly.verify.fh.c a = cn.fly.verify.fh.a(cn.fly.verify.ax.g());
            for (int i = 0; i < list.size(); i++) {
                a.a(new android.content.Intent(list.get(i)), 0);
            }
            a.a(new cn.fly.verify.dk.AnonymousClass3(list, linkedBlockingQueue));
        }
        try {
            java.lang.Boolean bool = (java.lang.Boolean) linkedBlockingQueue.poll(150L, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private boolean b(java.lang.String str) {
        java.lang.String d = cn.fly.verify.dw.d();
        if (android.text.TextUtils.isEmpty(d) || d.length() < str.length()) {
            return false;
        }
        java.lang.String[] split = d.split("");
        char[] charArray = str.toCharArray();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        boolean z = false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '1') {
                z |= android.text.TextUtils.equals(split[i], "1");
            } else if (c == '2') {
                arrayList.add(java.lang.Integer.valueOf(i));
            }
        }
        if (arrayList.size() <= 0) {
            return z;
        }
        java.util.Iterator it = arrayList.iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            z2 &= android.text.TextUtils.equals(split[((java.lang.Integer) it.next()).intValue()], "1");
        }
        return z | z2;
    }

    private boolean b(java.util.ArrayList<java.lang.Boolean> arrayList, java.util.List<java.lang.String> list) {
        cn.fly.verify.fh.c a = cn.fly.verify.fh.a(cn.fly.verify.ax.g());
        if (list == null || list.size() == 0) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            a.a(it.next());
        }
        boolean[] zArr = {false};
        a.a(new cn.fly.verify.dk.AnonymousClass4(list, arrayList, zArr));
        return zArr[0];
    }

    private synchronized boolean b(boolean z) {
        long longValue;
        java.lang.Object a;
        try {
            if (z) {
                java.util.HashMap a2 = cn.fly.verify.fm.a(cn.fly.verify.bl.a().e());
                if (a2.isEmpty()) {
                    a2 = cn.fly.verify.fm.a(cn.fly.verify.bl.a().d());
                }
                longValue = ((java.lang.Long) cn.fly.verify.fq.a(a2.get(cn.fly.verify.ds.b("004ebe1db")), 5L)).longValue() * 1000;
                a = cn.fly.verify.fq.a(a2.get(cn.fly.verify.ds.b("002bRcb")), cn.fly.verify.ds.b("0067gdgdgegegege"));
            } else {
                longValue = ((java.lang.Long) cn.fly.verify.bo.a(cn.fly.verify.ds.b("004ebe;db"), 5L)).longValue() * 1000;
                a = cn.fly.verify.bo.a(cn.fly.verify.ds.b("002b:cb"), cn.fly.verify.ds.b("0065gdgdgegegege"));
            }
            java.lang.String str = (java.lang.String) a;
            if (this.d != 0 && java.lang.System.currentTimeMillis() - this.d <= longValue) {
                return this.c;
            }
            boolean a3 = a(str);
            if (this.d == 0 || a3 != this.c) {
                c(a3);
            }
            this.d = java.lang.System.currentTimeMillis();
            this.c = a3;
            return a3;
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().c(th);
            return true;
        }
    }

    private void c(boolean z) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(cn.fly.verify.ds.b("005bfecGci"), java.lang.Integer.valueOf(!z ? 1 : 0));
        hashMap.put(cn.fly.verify.ds.b("002_cfYb"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002_cfYb")), 0));
        hashMap.put(cn.fly.verify.ds.b("002Mcfcb"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002Mcfcb")), 0));
        hashMap.put(cn.fly.verify.ds.b("002YccBi"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002YccBi")), 0));
        hashMap.put(cn.fly.verify.ds.b("002Uee%i"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002Uee%i")), 0));
        hashMap.put(cn.fly.verify.ds.b("002Tci?h"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002Tci?h")), 0));
        hashMap.put(cn.fly.verify.ds.b("002Ndb;i"), cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("002Ndb;i")), 0));
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.HashMap<java.lang.String, java.lang.Object> hashMap2 = new java.util.HashMap<>();
        hashMap2.put(cn.fly.verify.ds.b("004h8cjBie"), "ECMT");
        hashMap2.put(cn.fly.verify.ds.b("0041cb)chc"), hashMap);
        hashMap2.put(cn.fly.verify.ds.b("008Qcb$cheh0chce=e"), java.lang.Long.valueOf(currentTimeMillis));
        cn.fly.verify.cd.a().a(currentTimeMillis, hashMap2);
    }

    private boolean d() {
        java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue = new java.util.concurrent.LinkedBlockingQueue();
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).d().a(new cn.fly.verify.dk.AnonymousClass2(linkedBlockingQueue));
        try {
            java.lang.Boolean bool = (java.lang.Boolean) linkedBlockingQueue.poll(120L, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public void a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, java.util.HashMap<java.lang.String, java.lang.Object> hashMap2, java.util.HashMap<java.lang.String, java.lang.Object> hashMap3) {
        try {
            java.lang.Object obj = this.e.get(cn.fly.verify.ds.b("006e:cecgciPe<eg"));
            java.lang.Boolean bool = java.lang.Boolean.FALSE;
            boolean booleanValue = ((java.lang.Boolean) cn.fly.verify.fq.a(obj, bool)).booleanValue();
            boolean booleanValue2 = ((java.lang.Boolean) cn.fly.verify.fq.a(this.e.get(cn.fly.verify.ds.b("006Zdd+i:cgciZe+eg")), bool)).booleanValue();
            java.util.HashMap hashMap4 = new java.util.HashMap(4);
            hashMap4.put(cn.fly.verify.ds.b("003Mci'eIeg"), java.lang.Boolean.valueOf(booleanValue));
            hashMap4.put(cn.fly.verify.ds.b("003)cichcb"), cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.ds.b("003)cichcb")), (java.lang.Object) null));
            if (booleanValue || hashMap2 == null) {
                hashMap4.put(cn.fly.verify.ds.b("003Fegchcb"), cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.ds.b("003Fegchcb")), (java.lang.Object) null));
            } else {
                hashMap4.put(cn.fly.verify.ds.b("003'egchcb"), cn.fly.verify.fq.a(hashMap2.get(cn.fly.verify.ds.b("003'egchcb")), (java.lang.Object) null));
            }
            this.e.put(cn.fly.verify.ds.b("006e cecgci[e eg"), cn.fly.verify.fm.a(hashMap4));
            if (booleanValue) {
                java.util.HashMap hashMap5 = new java.util.HashMap(4);
                hashMap5.put(cn.fly.verify.ds.b("003Wci[e>eg"), java.lang.Boolean.valueOf(booleanValue2));
                hashMap5.put(cn.fly.verify.ds.b("003Ocichcb"), cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.ds.b("003Ocichcb")), (java.lang.Object) null));
                if (booleanValue2 || hashMap3 == null) {
                    hashMap5.put(cn.fly.verify.ds.b("003]egchcb"), cn.fly.verify.fq.a(hashMap.get(cn.fly.verify.ds.b("003]egchcb")), (java.lang.Object) null));
                } else {
                    hashMap5.put(cn.fly.verify.ds.b("0032egchcb"), cn.fly.verify.fq.a(hashMap3.get(cn.fly.verify.ds.b("0032egchcb")), (java.lang.Object) null));
                }
                hashMap5.putAll(this.f);
                this.e.put(cn.fly.verify.ds.b("006 dd*iNcgciLeZeg"), cn.fly.verify.fm.a(hashMap5));
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    public boolean a(java.util.HashMap<java.lang.String, java.lang.Object> hashMap) {
        try {
            java.util.List<java.lang.String> list = (java.util.List) cn.fly.verify.fq.a(hashMap.get("j"), (java.lang.Object) null);
            if (list != null && list.size() > 0) {
                boolean z = false;
                for (java.lang.String str : list) {
                    if (str.contains(",")) {
                        boolean z2 = true;
                        for (java.lang.String str2 : str.split(",")) {
                            z2 &= a(str2, hashMap);
                        }
                        z |= z2;
                    } else {
                        z |= a(str, hashMap);
                    }
                }
                this.e.put(cn.fly.verify.ds.b("0068dd]i0cgciUeXeg"), java.lang.Boolean.valueOf(z ? false : true));
                return !z;
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().c(th);
        }
        return true;
    }

    public synchronized boolean a(boolean z) {
        return !b(z);
    }

    public boolean b() {
        return a(false);
    }

    public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> c() {
        return this.e;
    }
}

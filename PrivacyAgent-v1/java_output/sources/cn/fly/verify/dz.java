package cn.fly.verify;

/* loaded from: classes.dex */
public class dz {
    private static volatile cn.fly.verify.dz e;
    private java.util.HashMap<java.lang.String, java.lang.Integer> f;
    private volatile java.lang.String a = null;
    private volatile java.lang.String b = null;
    private volatile java.lang.String c = null;
    private volatile java.lang.String d = null;
    private final byte[] g = new byte[0];
    private final byte[] h = new byte[0];

    /* renamed from: cn.fly.verify.dz$1, reason: invalid class name */
    public class AnonymousClass1 implements cn.fly.verify.fh.a {
        public AnonymousClass1() {
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            java.lang.String z = bVar.z();
            java.util.List<java.lang.String> asList = java.util.Arrays.asList("00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000");
            cn.fly.verify.ay.d i = cn.fly.verify.bl.a().i();
            if (i != null && i.d() != null) {
                asList = i.d();
            }
            if (android.text.TextUtils.isEmpty(z) || asList.contains(z)) {
                return;
            }
            cn.fly.verify.dz.this.d = z;
        }
    }

    /* renamed from: cn.fly.verify.dz$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<java.util.Map.Entry<java.lang.String, java.lang.Integer>> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.util.Map.Entry<java.lang.String, java.lang.Integer> entry, java.util.Map.Entry<java.lang.String, java.lang.Integer> entry2) {
            return entry2.getValue().compareTo(entry.getValue());
        }
    }

    /* renamed from: cn.fly.verify.dz$3, reason: invalid class name */
    public class AnonymousClass3 extends cn.fly.verify.fy {
        final /* synthetic */ java.lang.String[] a;
        final /* synthetic */ java.util.concurrent.CountDownLatch b;

        public AnonymousClass3(java.lang.String[] strArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = strArr;
            this.b = countDownLatch;
        }

        @Override // cn.fly.verify.fy
        public void a() {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String a = cn.fly.verify.dn.a("061eOcahdbbffdeff5d1cdghfh0da1dbbb$eHffdf@ad@cdbafjdbbgccbgdcghffhdghfbdbZgRcccaNaMcafgdcDaJdcdbcbdfccfgbafcfdfc.aVfffdfdghgh)aZfdde");
            java.util.UUID uuid = new java.util.UUID(-1301668207276963122L, -6645017420763422227L);
            android.media.MediaDrm mediaDrm = null;
            try {
                try {
                    android.media.MediaDrm mediaDrm2 = new android.media.MediaDrm(uuid);
                    try {
                        cn.fly.verify.em.a(cn.fly.verify.ax.g()).a(mediaDrm2.getClass(), mediaDrm2, cn.fly.verify.dn.a("012cbg0bgbb,d<bfdf]dgObe1h"), new java.lang.Class[]{java.lang.Object.class, byte[].class, java.lang.String.class}, new java.lang.Object[]{new java.lang.ref.WeakReference(mediaDrm2), cn.fly.verify.dz.this.a(uuid), a});
                        byte[] propertyByteArray = mediaDrm2.getPropertyByteArray(cn.fly.verify.dn.a("014.baGdTbbbg5adAce,c3bgbcbe?dDcgba"));
                        this.a[0] = cn.fly.verify.fi.a(propertyByteArray, 0, propertyByteArray.length);
                        cn.fly.verify.ed.a().a("rddd wv c " + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.Object[0]);
                        this.b.countDown();
                        if (android.os.Build.VERSION.SDK_INT >= 28) {
                            mediaDrm2.close();
                        } else {
                            mediaDrm2.release();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        mediaDrm = mediaDrm2;
                        try {
                            cn.fly.verify.ed.a().a(th);
                            this.b.countDown();
                            if (android.os.Build.VERSION.SDK_INT >= 28) {
                                if (mediaDrm != null) {
                                    mediaDrm.close();
                                }
                            } else if (mediaDrm != null) {
                                mediaDrm.release();
                            }
                        } catch (java.lang.Throwable th2) {
                            try {
                                this.b.countDown();
                                if (android.os.Build.VERSION.SDK_INT >= 28) {
                                    if (mediaDrm != null) {
                                        mediaDrm.close();
                                    }
                                } else if (mediaDrm != null) {
                                    mediaDrm.release();
                                }
                            } catch (java.lang.Throwable th3) {
                                cn.fly.verify.ed.a().a(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (java.lang.Throwable th4) {
                    cn.fly.verify.ed.a().a(th4);
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
            }
        }
    }

    /* renamed from: cn.fly.verify.dz$4, reason: invalid class name */
    public class AnonymousClass4 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.List a;
        final /* synthetic */ java.lang.StringBuilder b;
        final /* synthetic */ java.lang.String[] c;
        final /* synthetic */ java.util.concurrent.CountDownLatch d;

        public AnonymousClass4(java.util.List list, java.lang.StringBuilder sb, java.lang.String[] strArr, java.util.concurrent.CountDownLatch countDownLatch) {
            this.a = list;
            this.b = sb;
            this.c = strArr;
            this.d = countDownLatch;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            int i = 0;
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                try {
                    android.content.pm.ApplicationInfo h = bVar.h(i2);
                    if (h != null) {
                        this.b.append((java.lang.String) this.a.get(i2));
                        this.b.append(cn.fly.verify.et.a(h, (java.lang.String) this.a.get(i2)));
                        i++;
                    }
                } finally {
                    this.d.countDown();
                }
            }
            if (i > 0) {
                java.lang.StringBuilder sb = this.b;
                java.lang.String str = android.os.Build.BRAND;
                java.util.Locale locale = java.util.Locale.ROOT;
                sb.append(str.toUpperCase(locale));
                sb.append(android.os.Build.MODEL.toUpperCase(locale));
                sb.append(android.os.Build.MANUFACTURER.toUpperCase(locale));
                this.b.append(i);
                this.c[0] = cn.fly.verify.fi.b(this.b.toString());
                cn.fly.verify.bl.a().a("key_pddt", this.c[0]);
                cn.fly.verify.bl.a().a("key_lgpdt", java.lang.System.currentTimeMillis());
            }
        }
    }

    /* renamed from: cn.fly.verify.dz$5, reason: invalid class name */
    public class AnonymousClass5 implements cn.fly.verify.fh.a {
        final /* synthetic */ java.util.List a;

        public AnonymousClass5(java.util.List list) {
            this.a = list;
        }

        @Override // cn.fly.verify.fh.a
        public void a(cn.fly.verify.fh.b bVar) {
            if (bVar.j() == null || bVar.j().isEmpty()) {
                return;
            }
            java.util.Iterator<java.util.HashMap<java.lang.String, java.lang.String>> it = bVar.j().iterator();
            while (it.hasNext()) {
                java.lang.String str = it.next().get(cn.fly.verify.dn.a("003h_bjcc"));
                if (str != null && !str.contains("com.google.android") && !str.contains("com.miui.packageinstaller")) {
                    this.a.add(str);
                }
            }
            java.util.Collections.sort(this.a);
        }
    }

    private dz() {
    }

    public static cn.fly.verify.dz a() {
        if (e == null) {
            synchronized (cn.fly.verify.dz.class) {
                if (e == null) {
                    e = new cn.fly.verify.dz();
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(java.util.UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            int i2 = (7 - i) * 8;
            bArr[i] = (byte) (mostSignificantBits >>> i2);
            bArr[i + 8] = (byte) (leastSignificantBits >>> i2);
        }
        return bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x00af, LOOP:0: B:14:0x0053->B:16:0x0056, LOOP_END, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:7:0x001a, B:9:0x0021, B:11:0x0030, B:12:0x0035, B:13:0x003e, B:16:0x0056, B:18:0x005e, B:19:0x0067, B:21:0x006d, B:23:0x007f, B:25:0x0099, B:31:0x0039, B:32:0x0015), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[Catch: all -> 0x00af, LOOP:1: B:19:0x0067->B:21:0x006d, LOOP_END, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:7:0x001a, B:9:0x0021, B:11:0x0030, B:12:0x0035, B:13:0x003e, B:16:0x0056, B:18:0x005e, B:19:0x0067, B:21:0x006d, B:23:0x007f, B:25:0x0099, B:31:0x0039, B:32:0x0015), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #0 {all -> 0x00af, blocks: (B:4:0x0008, B:7:0x001a, B:9:0x0021, B:11:0x0030, B:12:0x0035, B:13:0x003e, B:16:0x0056, B:18:0x005e, B:19:0x0067, B:21:0x006d, B:23:0x007f, B:25:0x0099, B:31:0x0039, B:32:0x0015), top: B:3:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(java.lang.String str) {
        int size;
        int min;
        int i;
        int valueOf;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.util.HashMap hashMap = (java.util.HashMap) cn.fly.verify.bl.a().a("key_drds");
            if (hashMap == null) {
                hashMap = new java.util.HashMap();
            }
            if (hashMap.containsKey(str)) {
                int intValue = ((java.lang.Integer) hashMap.get(str)).intValue();
                valueOf = intValue < 100000 ? java.lang.Integer.valueOf(intValue + 1) : 1;
                java.util.ArrayList<java.util.Map.Entry> arrayList = new java.util.ArrayList(hashMap.entrySet());
                java.util.Collections.sort(arrayList, new cn.fly.verify.dz.AnonymousClass2());
                for (size = arrayList.size(); size > 7; size--) {
                    arrayList.remove(size - 1);
                }
                java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                for (java.util.Map.Entry entry : arrayList) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                cn.fly.verify.bl.a().a("key_drds", linkedHashMap);
                this.f = new java.util.LinkedHashMap();
                min = java.lang.Math.min(3, arrayList.size());
                for (i = 0; i < min; i++) {
                    java.util.Map.Entry entry2 = (java.util.Map.Entry) arrayList.get(i);
                    this.f.put(entry2.getKey(), entry2.getValue());
                }
            }
            hashMap.put(str, valueOf);
            java.util.ArrayList<java.util.Map.Entry> arrayList2 = new java.util.ArrayList(hashMap.entrySet());
            java.util.Collections.sort(arrayList2, new cn.fly.verify.dz.AnonymousClass2());
            while (size > 7) {
            }
            java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
            while (r2.hasNext()) {
            }
            cn.fly.verify.bl.a().a("key_drds", linkedHashMap2);
            this.f = new java.util.LinkedHashMap();
            min = java.lang.Math.min(3, arrayList2.size());
            while (i < min) {
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private java.lang.String c(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
        java.lang.String k = cn.fly.verify.fh.d.k();
        java.lang.String j = cn.fly.verify.fh.d.j();
        if (!android.text.TextUtils.isEmpty(k)) {
            sb.append(k.trim().toUpperCase());
        }
        if (!android.text.TextUtils.isEmpty(j)) {
            sb.append(j.trim().toUpperCase());
        }
        return cn.fly.verify.fi.b(sb.toString());
    }

    private java.lang.String j() {
        java.lang.StringBuilder sb;
        java.lang.String uuid;
        if (!android.text.TextUtils.isEmpty(h())) {
            sb = new java.lang.StringBuilder();
            sb.append(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
            uuid = h();
        } else if (!android.text.TextUtils.isEmpty(g())) {
            sb = new java.lang.StringBuilder();
            sb.append(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE);
            uuid = g();
        } else if (android.text.TextUtils.isEmpty(l())) {
            sb = new java.lang.StringBuilder();
            sb.append(androidx.room.RoomMasterTable.DEFAULT_ID);
            uuid = java.util.UUID.randomUUID().toString();
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("32");
            uuid = this.d;
        }
        sb.append(c(uuid));
        return sb.toString();
    }

    private java.lang.String k() {
        java.lang.StringBuilder sb;
        java.lang.String uuid;
        if (android.text.TextUtils.isEmpty(h())) {
            sb = new java.lang.StringBuilder();
            sb.append(androidx.room.RoomMasterTable.DEFAULT_ID);
            uuid = java.util.UUID.randomUUID().toString();
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR);
            uuid = h();
        }
        sb.append(c(uuid));
        return sb.toString();
    }

    private java.lang.String l() {
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).A().a(new cn.fly.verify.dz.AnonymousClass1());
        return this.d;
    }

    private java.lang.String m() throws java.lang.Throwable {
        java.lang.String[] strArr = {null};
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        cn.fly.verify.ea.c.execute(new cn.fly.verify.dz.AnonymousClass3(strArr, countDownLatch));
        countDownLatch.await(3L, java.util.concurrent.TimeUnit.SECONDS);
        return strArr[0];
    }

    private java.lang.String n() {
        long j;
        java.lang.String[] strArr = new java.lang.String[1];
        if (cn.fly.verify.bo.a(cn.fly.verify.dn.a("003bee"))) {
            try {
                java.lang.String b = cn.fly.verify.bl.a().b("key_pddt", (java.lang.String) null);
                strArr[0] = b;
                if (!android.text.TextUtils.isEmpty(b)) {
                    long b2 = cn.fly.verify.bl.a().b("key_lgpdt", 0L);
                    try {
                        j = java.lang.Long.parseLong(java.lang.String.valueOf(cn.fly.verify.bo.a(cn.fly.verify.dn.a("0062dfbidfcc3bh"), 604800))) * 1000;
                    } catch (java.lang.Throwable unused) {
                        j = 604800000;
                    }
                    if (java.lang.System.currentTimeMillis() - b2 < j) {
                        cn.fly.verify.ed.a().a("rddd che p useable", new java.lang.Object[0]);
                        return strArr[0];
                    }
                }
                if ((cn.fly.verify.dn.a("004Vbbbgbbcb").equalsIgnoreCase(cn.fly.verify.fh.d.k()) && android.os.Build.VERSION.SDK_INT <= 25) || (cn.fly.verify.dn.a("006f+be^b2ddTd^bg").equalsIgnoreCase(cn.fly.verify.fh.d.k()) && android.os.Build.VERSION.SDK_INT <= 22)) {
                    return null;
                }
                java.util.List<java.lang.String> o = o();
                if (!o.isEmpty()) {
                    java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    cn.fly.verify.fh.c a = cn.fly.verify.fh.a(cn.fly.verify.ax.g());
                    java.util.Iterator<java.lang.String> it = o.iterator();
                    while (it.hasNext()) {
                        a.b(it.next(), 1);
                    }
                    a.a(new cn.fly.verify.dz.AnonymousClass4(o, sb, strArr, countDownLatch));
                    try {
                        countDownLatch.await(1000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                    } catch (java.lang.Throwable unused2) {
                    }
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
        return strArr[0];
    }

    private java.util.List<java.lang.String> o() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        cn.fly.verify.fh.a(cn.fly.verify.ax.g()).j().a(new cn.fly.verify.dz.AnonymousClass5(arrayList));
        return arrayList;
    }

    public void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.equals(str, this.b)) {
            return;
        }
        cn.fly.verify.ed.a().a("rddd saveRD pre is " + this.b + " cur is " + str, new java.lang.Object[0]);
        cn.fly.verify.bl.a().a("key_rdt2", str);
    }

    public java.lang.String b() {
        return "2";
    }

    public java.lang.String c() {
        if (android.text.TextUtils.isEmpty(this.b)) {
            java.lang.String b = cn.fly.verify.bl.a().b("key_rdt2", (java.lang.String) null);
            if (!android.text.TextUtils.isEmpty(b)) {
                this.b = b;
            }
        }
        return this.b;
    }

    public boolean d() {
        if (!android.text.TextUtils.isEmpty(this.b)) {
            return false;
        }
        synchronized (this) {
            if (!android.text.TextUtils.isEmpty(this.b)) {
                return false;
            }
            return android.text.TextUtils.isEmpty(cn.fly.verify.bl.a().b("key_rdt2", (java.lang.String) null));
        }
    }

    public synchronized java.lang.String e() {
        java.lang.String c;
        c = c();
        if (android.text.TextUtils.isEmpty(c)) {
            c = j();
            this.b = c;
            if (!android.text.TextUtils.isEmpty(c)) {
                cn.fly.verify.bl.a().a("key_rdt2", c);
            }
        }
        return c;
    }

    public java.lang.String f() {
        java.lang.String c = c();
        if (android.text.TextUtils.isEmpty(c)) {
            c = k();
            this.b = c;
            if (!android.text.TextUtils.isEmpty(c)) {
                cn.fly.verify.bl.a().a("key_rdt2", c);
            }
        }
        return c;
    }

    public java.lang.String g() {
        if (android.text.TextUtils.isEmpty(this.c)) {
            synchronized (this.h) {
                if (android.text.TextUtils.isEmpty(this.c)) {
                    this.c = n();
                }
            }
        }
        return this.c;
    }

    public java.lang.String h() {
        if (android.text.TextUtils.isEmpty(this.a)) {
            synchronized (this.g) {
                if (android.text.TextUtils.isEmpty(this.a)) {
                    try {
                        this.a = m();
                        b(this.a);
                    } catch (java.lang.Throwable th) {
                        cn.fly.verify.ed.a().a(th);
                    }
                }
            }
        }
        return this.a;
    }

    public java.util.HashMap<java.lang.String, java.lang.Integer> i() {
        return this.f;
    }
}

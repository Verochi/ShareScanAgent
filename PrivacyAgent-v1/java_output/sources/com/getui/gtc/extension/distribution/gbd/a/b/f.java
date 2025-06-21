package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class f implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String h = "GBD_SLMA";
    private static final int i = 137;
    private static com.getui.gtc.extension.distribution.gbd.a.b.f j = null;
    private static final int k = 0;
    private static final int l = -10;
    private static final int m = -11;
    android.content.Context a;
    java.net.DatagramSocket b;
    java.lang.String c;
    java.util.concurrent.ThreadPoolExecutor d;
    java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.j> e;
    volatile boolean f = false;
    private int n = 0;
    private int o = 1;
    byte[] g = l();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "start ott discover.");
                if (com.getui.gtc.extension.distribution.gbd.d.h.z == null) {
                    com.getui.gtc.extension.distribution.gbd.d.h.z = new java.util.concurrent.ConcurrentHashMap<>();
                }
                com.getui.gtc.extension.distribution.gbd.d.h.z.clear();
                com.getui.gtc.extension.distribution.gbd.m.b.b bVar = new com.getui.gtc.extension.distribution.gbd.m.b.b();
                bVar.a();
                com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "wait 5s before shutting down ott.");
                java.lang.Thread.sleep(5000L);
                com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "up Map size = " + com.getui.gtc.extension.distribution.gbd.d.h.z.size());
                if (com.getui.gtc.extension.distribution.gbd.d.d.aJ) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "ott enable http request.");
                    com.getui.gtc.extension.distribution.gbd.m.h.a.a(com.getui.gtc.extension.distribution.gbd.d.h.z);
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "ott disable http request.");
                }
                java.lang.Thread.sleep(2000L);
                com.getui.gtc.extension.distribution.gbd.n.j.b("Up_M", "Attempt to stop ott discover.");
                bVar.b();
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "ott task exception = " + th.toString());
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.f$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.net.InetAddress> {
        public AnonymousClass2() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.net.InetAddress a2(java.lang.String str) {
            try {
                return java.net.InetAddress.getByName(str);
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return null;
            }
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.net.InetAddress a(java.lang.String str) {
            return a2(str);
        }
    }

    public class a implements java.lang.Runnable {
        private a() {
        }

        public /* synthetic */ a(com.getui.gtc.extension.distribution.gbd.a.b.f fVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.getui.gtc.extension.distribution.gbd.a.b.f.this.d != null) {
                    do {
                        java.lang.Thread.sleep(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
                        com.getui.gtc.extension.distribution.gbd.a.b.f fVar = com.getui.gtc.extension.distribution.gbd.a.b.f.this;
                        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> concurrentHashMap = com.getui.gtc.extension.distribution.gbd.d.h.z;
                        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                            for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.h.z.keySet()) {
                                if (android.text.TextUtils.isEmpty(str) && fVar.d != null) {
                                    fVar.a(str);
                                }
                            }
                            java.lang.Thread.sleep(5000L);
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "no ott device in lan network.");
                        java.lang.Thread.sleep(5000L);
                    } while (com.getui.gtc.extension.distribution.gbd.a.b.f.this.d.getCompletedTaskCount() < com.getui.gtc.extension.distribution.gbd.a.b.f.this.d.getTaskCount() - 3);
                    com.getui.gtc.extension.distribution.gbd.a.b.f.this.f = false;
                    java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> p = com.getui.gtc.extension.distribution.gbd.n.l.p();
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "no p.");
                    com.getui.gtc.extension.distribution.gbd.a.b.f fVar2 = com.getui.gtc.extension.distribution.gbd.a.b.f.this;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    java.util.HashMap hashMap = new java.util.HashMap();
                    java.util.HashSet hashSet = new java.util.HashSet();
                    if (p != null && !p.isEmpty()) {
                        for (com.getui.gtc.extension.distribution.gbd.c.h hVar : p) {
                            java.lang.String str2 = hVar.a;
                            java.lang.String str3 = hVar.b;
                            hashMap.put(str2, str3);
                            if (com.getui.gtc.extension.distribution.gbd.n.l.d(hVar.c)) {
                                if (!hashSet.contains(str3)) {
                                    hashSet.add(str3);
                                    sb.append(str3);
                                    sb.append(",");
                                }
                                sb2.append(str2);
                                sb2.append("#");
                                sb2.append(str3);
                                sb2.append(",");
                            } else {
                                sb3.append(str2);
                                sb3.append("#");
                                sb3.append(str3);
                                sb3.append(",");
                            }
                        }
                        if (sb.toString().endsWith(",")) {
                            sb = sb.deleteCharAt(sb.length() - 1);
                        }
                        if (sb2.toString().endsWith(",")) {
                            sb2 = sb2.deleteCharAt(sb2.length() - 1);
                        }
                        if (sb3.toString().endsWith(",")) {
                            sb3 = sb3.deleteCharAt(sb3.length() - 1);
                        }
                    }
                    java.lang.String g = fVar2.g();
                    java.lang.String a = fVar2.a(hashMap);
                    java.lang.String sb4 = sb.toString();
                    java.lang.String sb5 = sb2.toString();
                    java.lang.String sb6 = sb3.toString();
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "onlineML = ".concat(java.lang.String.valueOf(sb4)));
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "onlineIpML = ".concat(java.lang.String.valueOf(sb5)));
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "offlineIpML = ".concat(java.lang.String.valueOf(sb6)));
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "netBiosList = ".concat(java.lang.String.valueOf(g)));
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "ottDeviceList = ".concat(java.lang.String.valueOf(a)));
                    java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "package data, 127");
                    com.getui.gtc.extension.distribution.gbd.c.t b = com.getui.gtc.extension.distribution.gbd.n.o.b(fVar2.a);
                    java.lang.String str4 = b.c;
                    if (!android.text.TextUtils.isEmpty(str4)) {
                        str4 = str4.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
                    }
                    java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                    sb7.append(format);
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
                    sb7.append("|");
                    sb7.append(b.b);
                    sb7.append("#");
                    sb7.append(b.a);
                    sb7.append("|");
                    sb7.append(str4);
                    sb7.append("|");
                    sb7.append(sb4);
                    sb7.append("|");
                    sb7.append(sb5);
                    sb7.append("|");
                    sb7.append(sb6);
                    sb7.append("|");
                    sb7.append(b.d);
                    sb7.append("|");
                    sb7.append(fVar2.c);
                    sb7.append("|");
                    sb7.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
                    sb7.append("|");
                    sb7.append(g);
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.n.l.b("127"));
                    sb7.append("|");
                    sb7.append(fVar2.h());
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
                    sb7.append("|");
                    sb7.append(a);
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.c(com.getui.gtc.extension.distribution.gbd.d.c.d));
                    sb7.append("|");
                    sb7.append(com.getui.gtc.extension.distribution.gbd.b.a.b.a.c);
                    if (com.getui.gtc.extension.distribution.gbd.n.l.d(127)) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "instant r 127");
                        com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(sb7.toString(), 127);
                    } else {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "not instant r 127");
                        com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb7.toString(), 127);
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "save type = 127 content = " + sb7.toString());
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.b.f.h, "save type = 127");
                }
                com.getui.gtc.extension.distribution.gbd.a.b.f.this.f = false;
                java.net.DatagramSocket datagramSocket = com.getui.gtc.extension.distribution.gbd.a.b.f.this.b;
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                        com.getui.gtc.extension.distribution.gbd.a.b.f.this.b = null;
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                    com.getui.gtc.extension.distribution.gbd.a.b.f.this.f = false;
                    java.net.DatagramSocket datagramSocket2 = com.getui.gtc.extension.distribution.gbd.a.b.f.this.b;
                    if (datagramSocket2 != null) {
                        try {
                            datagramSocket2.close();
                            com.getui.gtc.extension.distribution.gbd.a.b.f.this.b = null;
                        } catch (java.lang.Throwable th3) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public class b implements java.lang.Runnable {
        public b() {
            com.getui.gtc.extension.distribution.gbd.a.b.f.this.f = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.getui.gtc.extension.distribution.gbd.c.j jVar;
            while (com.getui.gtc.extension.distribution.gbd.a.b.f.this.f) {
                try {
                    com.getui.gtc.extension.distribution.gbd.a.b.f fVar = com.getui.gtc.extension.distribution.gbd.a.b.f.this;
                    java.net.InetAddress a = com.getui.gtc.extension.distribution.gbd.a.b.f.a(fVar, fVar.c);
                    if (a != null) {
                        java.net.DatagramPacket datagramPacket = new java.net.DatagramPacket(new byte[com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING], com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, a, 137);
                        com.getui.gtc.extension.distribution.gbd.a.b.f.this.b.receive(datagramPacket);
                        byte[] data = datagramPacket.getData();
                        java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(datagramPacket.getAddress());
                        if (!android.text.TextUtils.isEmpty(a2)) {
                            if (com.getui.gtc.extension.distribution.gbd.a.b.f.this.e.containsKey(a2)) {
                                jVar = com.getui.gtc.extension.distribution.gbd.a.b.f.this.e.get(a2);
                            } else {
                                jVar = new com.getui.gtc.extension.distribution.gbd.c.j();
                                com.getui.gtc.extension.distribution.gbd.a.b.f.this.e.put(a2, jVar);
                            }
                            jVar.c = a2;
                            jVar.b = new java.lang.String(data, 57, 15);
                            jVar.a = com.getui.gtc.extension.distribution.gbd.n.l.a(data);
                            com.getui.gtc.extension.distribution.gbd.a.b.f.this.e.put(a2, jVar);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
        }
    }

    public class c implements java.lang.Runnable {
        java.lang.String a;

        public c(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.net.InetAddress a = com.getui.gtc.extension.distribution.gbd.a.b.f.a(com.getui.gtc.extension.distribution.gbd.a.b.f.this, this.a);
                if (a != null) {
                    byte[] bArr = com.getui.gtc.extension.distribution.gbd.a.b.f.this.g;
                    com.getui.gtc.extension.distribution.gbd.a.b.f.this.b.send(new java.net.DatagramPacket(bArr, bArr.length, a, 137));
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    private f(android.content.Context context) {
        try {
            this.a = context;
            this.e = java.util.Collections.synchronizedMap(new java.util.HashMap());
            if (this.d == null) {
                java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(3, 5, 4L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.LinkedBlockingDeque(com.getui.gtc.extension.distribution.gbd.d.d.bB));
                this.d = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public static /* synthetic */ java.net.InetAddress a(com.getui.gtc.extension.distribution.gbd.a.b.f fVar, java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (java.net.InetAddress) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.n, str, fVar.new AnonymousClass2());
    }

    private static /* synthetic */ void a(com.getui.gtc.extension.distribution.gbd.a.b.f fVar, java.util.List list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashSet hashSet = new java.util.HashSet();
        if (list != null && !list.isEmpty()) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                com.getui.gtc.extension.distribution.gbd.c.h hVar = (com.getui.gtc.extension.distribution.gbd.c.h) it.next();
                java.lang.String str = hVar.a;
                java.lang.String str2 = hVar.b;
                hashMap.put(str, str2);
                if (com.getui.gtc.extension.distribution.gbd.n.l.d(hVar.c)) {
                    if (!hashSet.contains(str2)) {
                        hashSet.add(str2);
                        sb.append(str2);
                        sb.append(",");
                    }
                    sb2.append(str);
                    sb2.append("#");
                    sb2.append(str2);
                    sb2.append(",");
                } else {
                    sb3.append(str);
                    sb3.append("#");
                    sb3.append(str2);
                    sb3.append(",");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            if (sb2.toString().endsWith(",")) {
                sb2 = sb2.deleteCharAt(sb2.length() - 1);
            }
            if (sb3.toString().endsWith(",")) {
                sb3 = sb3.deleteCharAt(sb3.length() - 1);
            }
        }
        java.lang.String g = fVar.g();
        java.lang.String a2 = fVar.a(hashMap);
        java.lang.String sb4 = sb.toString();
        java.lang.String sb5 = sb2.toString();
        java.lang.String sb6 = sb3.toString();
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineML = ".concat(java.lang.String.valueOf(sb4)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineIpML = ".concat(java.lang.String.valueOf(sb5)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "offlineIpML = ".concat(java.lang.String.valueOf(sb6)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "netBiosList = ".concat(java.lang.String.valueOf(g)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "ottDeviceList = ".concat(java.lang.String.valueOf(a2)));
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "package data, 127");
        com.getui.gtc.extension.distribution.gbd.c.t b2 = com.getui.gtc.extension.distribution.gbd.n.o.b(fVar.a);
        java.lang.String str3 = b2.c;
        if (!android.text.TextUtils.isEmpty(str3)) {
            str3 = str3.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
        }
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(format);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb7.append("|");
        sb7.append(b2.b);
        sb7.append("#");
        sb7.append(b2.a);
        sb7.append("|");
        sb7.append(str3);
        sb7.append("|");
        sb7.append(sb4);
        sb7.append("|");
        sb7.append(sb5);
        sb7.append("|");
        sb7.append(sb6);
        sb7.append("|");
        sb7.append(b2.d);
        sb7.append("|");
        sb7.append(fVar.c);
        sb7.append("|");
        sb7.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb7.append("|");
        sb7.append(g);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.l.b("127"));
        sb7.append("|");
        sb7.append(fVar.h());
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
        sb7.append("|");
        sb7.append(a2);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.c(com.getui.gtc.extension.distribution.gbd.d.c.d));
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.b.a.b.a.c);
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(127)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(sb7.toString(), 127);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "not instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb7.toString(), 127);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(h, "save type = 127 content = " + sb7.toString());
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "save type = 127");
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineML = ".concat(java.lang.String.valueOf(str)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineIpML = ".concat(java.lang.String.valueOf(str2)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "offlineIpML = ".concat(java.lang.String.valueOf(str3)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "netBiosList = ".concat(java.lang.String.valueOf(str4)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "ottDeviceList = ".concat(java.lang.String.valueOf(str5)));
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "package data, 127");
        com.getui.gtc.extension.distribution.gbd.c.t b2 = com.getui.gtc.extension.distribution.gbd.n.o.b(this.a);
        java.lang.String str6 = b2.c;
        if (!android.text.TextUtils.isEmpty(str6)) {
            str6 = str6.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(format);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        sb.append(b2.b);
        sb.append("#");
        sb.append(b2.a);
        sb.append("|");
        sb.append(str6);
        sb.append("|");
        sb.append(str);
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        sb.append("|");
        sb.append(b2.d);
        sb.append("|");
        sb.append(this.c);
        sb.append("|");
        sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb.append("|");
        sb.append(str4);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b("127"));
        sb.append("|");
        sb.append(h());
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
        sb.append("|");
        sb.append(str5);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.o.c(com.getui.gtc.extension.distribution.gbd.d.c.d));
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.b.a.b.a.c);
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(127)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(sb.toString(), 127);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "not instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb.toString(), 127);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(h, "save type = 127 content = " + sb.toString());
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "save type = 127");
    }

    private void a(java.util.List<com.getui.gtc.extension.distribution.gbd.c.h> list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.HashSet hashSet = new java.util.HashSet();
        if (list != null && !list.isEmpty()) {
            for (com.getui.gtc.extension.distribution.gbd.c.h hVar : list) {
                java.lang.String str = hVar.a;
                java.lang.String str2 = hVar.b;
                hashMap.put(str, str2);
                if (com.getui.gtc.extension.distribution.gbd.n.l.d(hVar.c)) {
                    if (!hashSet.contains(str2)) {
                        hashSet.add(str2);
                        sb.append(str2);
                        sb.append(",");
                    }
                    sb2.append(str);
                    sb2.append("#");
                    sb2.append(str2);
                    sb2.append(",");
                } else {
                    sb3.append(str);
                    sb3.append("#");
                    sb3.append(str2);
                    sb3.append(",");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            if (sb2.toString().endsWith(",")) {
                sb2 = sb2.deleteCharAt(sb2.length() - 1);
            }
            if (sb3.toString().endsWith(",")) {
                sb3 = sb3.deleteCharAt(sb3.length() - 1);
            }
        }
        java.lang.String g = g();
        java.lang.String a2 = a(hashMap);
        java.lang.String sb4 = sb.toString();
        java.lang.String sb5 = sb2.toString();
        java.lang.String sb6 = sb3.toString();
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineML = ".concat(java.lang.String.valueOf(sb4)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "onlineIpML = ".concat(java.lang.String.valueOf(sb5)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "offlineIpML = ".concat(java.lang.String.valueOf(sb6)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "netBiosList = ".concat(java.lang.String.valueOf(g)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "ottDeviceList = ".concat(java.lang.String.valueOf(a2)));
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "package data, 127");
        com.getui.gtc.extension.distribution.gbd.c.t b2 = com.getui.gtc.extension.distribution.gbd.n.o.b(this.a);
        java.lang.String str3 = b2.c;
        if (!android.text.TextUtils.isEmpty(str3)) {
            str3 = str3.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
        }
        java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
        sb7.append(format);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb7.append("|");
        sb7.append(b2.b);
        sb7.append("#");
        sb7.append(b2.a);
        sb7.append("|");
        sb7.append(str3);
        sb7.append("|");
        sb7.append(sb4);
        sb7.append("|");
        sb7.append(sb5);
        sb7.append("|");
        sb7.append(sb6);
        sb7.append("|");
        sb7.append(b2.d);
        sb7.append("|");
        sb7.append(this.c);
        sb7.append("|");
        sb7.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb7.append("|");
        sb7.append(g);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.l.b("127"));
        sb7.append("|");
        sb7.append(h());
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.d());
        sb7.append("|");
        sb7.append(a2);
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.n.o.c(com.getui.gtc.extension.distribution.gbd.d.c.d));
        sb7.append("|");
        sb7.append(com.getui.gtc.extension.distribution.gbd.b.a.b.a.c);
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(127)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(sb7.toString(), 127);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "not instant r 127");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(sb7.toString(), 127);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(h, "save type = 127 content = " + sb7.toString());
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "save type = 127");
    }

    private java.net.InetAddress b(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (java.net.InetAddress) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.n, str, new com.getui.gtc.extension.distribution.gbd.a.b.f.AnonymousClass2());
    }

    private void c(java.lang.String str) {
        int i2;
        com.getui.gtc.extension.distribution.gbd.c.t a2 = com.getui.gtc.extension.distribution.gbd.n.o.a(this.a);
        java.lang.String str2 = a2.d;
        java.lang.String str3 = a2.e;
        int i3 = a2.f;
        if (android.text.TextUtils.isEmpty(str3) || "0.0.0.0".equalsIgnoreCase(str3)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "sI from dhcp empty, use origin lI instead.");
        } else {
            str = str3;
        }
        if (android.text.TextUtils.isEmpty(str2) || "0.0.0.0".equalsIgnoreCase(str2)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "gateIp from dhcp empty.");
            str2 = str;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "gI=" + str2 + ", sIv4=" + str + ", netMask=" + i3);
        if (android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "sI && gI empty, return.");
            i2 = -10;
        } else {
            if ((str.startsWith("192.168.") || str.startsWith("172.") || str.startsWith("10.")) && i3 >= 0) {
                try {
                    java.lang.Integer.parseInt(str.split("\\.")[2]);
                    int parseInt = java.lang.Integer.parseInt(str2.split("\\.")[2]);
                    int min = java.lang.Math.min(i3 < 24 ? 1 << (24 - i3) : 1, java.lang.Math.max(com.getui.gtc.extension.distribution.gbd.b.a.b.a.a / 256, 1));
                    if (str.startsWith("192.168.")) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "C lan.");
                        for (int i4 = 0; i4 < min; i4++) {
                            int i5 = parseInt + i4;
                            for (int i6 = 1; i6 < 255; i6++) {
                                a("192.168." + i5 + "." + i6);
                            }
                        }
                        return;
                    }
                    if ((str.startsWith("172.") || str.startsWith("10.")) && com.getui.gtc.extension.distribution.gbd.d.d.bC) {
                        java.lang.String[] split = str.split("\\.");
                        if (split.length == 4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "AB lan.");
                            java.lang.String str4 = split[0] + "." + split[1] + "." + split[2] + ".";
                            for (int i7 = 1; i7 < 255; i7++) {
                                a(str4 + i7);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    return;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "not ABC lan or netMask error, return.");
            i2 = -11;
        }
        this.n = i2;
    }

    private static java.lang.String d(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? "" : str.replace(",", "");
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.a.b.f f() {
        com.getui.gtc.extension.distribution.gbd.a.b.f fVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.a.b.f.class) {
            if (j == null) {
                j = new com.getui.gtc.extension.distribution.gbd.a.b.f(com.getui.gtc.extension.distribution.gbd.d.c.d);
            }
            fVar = j;
        }
        return fVar;
    }

    private static /* synthetic */ void g(com.getui.gtc.extension.distribution.gbd.a.b.f fVar) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> concurrentHashMap = com.getui.gtc.extension.distribution.gbd.d.h.z;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "no ott device in lan network.");
            return;
        }
        for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.h.z.keySet()) {
            if (android.text.TextUtils.isEmpty(str) && fVar.d != null) {
                fVar.a(str);
            }
        }
    }

    private static /* synthetic */ java.net.DatagramSocket h(com.getui.gtc.extension.distribution.gbd.a.b.f fVar) {
        fVar.b = null;
        return null;
    }

    private static boolean i() {
        return com.getui.gtc.extension.distribution.gbd.f.g.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.a.u, com.getui.gtc.extension.distribution.gbd.f.e.a.v, 0L, "ip", "27-ip");
    }

    private void j() {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> concurrentHashMap = com.getui.gtc.extension.distribution.gbd.d.h.z;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "no ott device in lan network.");
            return;
        }
        for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.h.z.keySet()) {
            if (android.text.TextUtils.isEmpty(str) && this.d != null) {
                a(str);
            }
        }
    }

    private java.util.ArrayList<com.getui.gtc.extension.distribution.gbd.c.i> k() {
        java.util.ArrayList<com.getui.gtc.extension.distribution.gbd.c.i> arrayList = new java.util.ArrayList<>();
        if (android.text.TextUtils.isEmpty(this.c)) {
            return arrayList;
        }
        int o = com.getui.gtc.extension.distribution.gbd.n.l.o();
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "local lan mask = ".concat(java.lang.String.valueOf(o)));
        long a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.n.l.h(this.c), o);
        long b2 = com.getui.gtc.extension.distribution.gbd.n.l.b(com.getui.gtc.extension.distribution.gbd.n.l.h(this.c), o);
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "start " + a2 + ", end " + b2);
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "cn = ".concat(java.lang.String.valueOf(((int) (b2 - a2)) + 1)));
        long h2 = com.getui.gtc.extension.distribution.gbd.n.l.h(this.c);
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "lan m p count = " + com.getui.gtc.extension.distribution.gbd.d.d.bB);
        if (com.getui.gtc.extension.distribution.gbd.d.d.bB > 254) {
            long c2 = com.getui.gtc.extension.distribution.gbd.n.l.c(h2, 1);
            long c3 = com.getui.gtc.extension.distribution.gbd.n.l.c(a2, 0);
            long c4 = com.getui.gtc.extension.distribution.gbd.n.l.c(b2, 0);
            com.getui.gtc.extension.distribution.gbd.c.i iVar = new com.getui.gtc.extension.distribution.gbd.c.i();
            iVar.a = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, c2, c3);
            iVar.b = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, c2, c4);
            arrayList.add(iVar);
            java.util.ArrayList<java.lang.Long> t = com.getui.gtc.extension.distribution.gbd.n.l.t();
            if (t != null && t.size() > 0) {
                t.remove(java.lang.Long.valueOf(c2));
                long j2 = com.getui.gtc.extension.distribution.gbd.d.d.bB - 254;
                for (int i2 = 0; i2 < t.size(); i2++) {
                    com.getui.gtc.extension.distribution.gbd.c.i iVar2 = new com.getui.gtc.extension.distribution.gbd.c.i();
                    if (j2 >= 254) {
                        iVar2.a = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, t.get(i2).longValue(), c3);
                        iVar2.b = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, t.get(i2).longValue(), c4);
                        arrayList.add(iVar2);
                        j2 -= 254;
                    } else if (j2 > 0) {
                        iVar2.a = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, t.get(i2).longValue(), c3);
                        iVar2.b = com.getui.gtc.extension.distribution.gbd.n.l.a(h2, t.get(i2).longValue(), j2);
                        arrayList.add(iVar2);
                        j2 = 0;
                    }
                }
            }
        } else {
            com.getui.gtc.extension.distribution.gbd.c.i iVar3 = new com.getui.gtc.extension.distribution.gbd.c.i();
            iVar3.a = a2;
            iVar3.b = a2 + com.getui.gtc.extension.distribution.gbd.d.d.bB;
            arrayList.add(iVar3);
        }
        return arrayList;
    }

    private static byte[] l() {
        byte[] bArr = new byte[50];
        bArr[0] = 126;
        bArr[1] = 40;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 1;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 32;
        bArr[13] = 67;
        bArr[14] = org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK;
        for (int i2 = 15; i2 < 45; i2++) {
            bArr[i2] = 65;
        }
        bArr[45] = 0;
        bArr[46] = 0;
        bArr[47] = 33;
        bArr[48] = 0;
        bArr[49] = 1;
        return bArr;
    }

    public final java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>> concurrentHashMap = com.getui.gtc.extension.distribution.gbd.d.h.z;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "no ott device in lan network.");
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.h.z.keySet()) {
            if (!android.text.TextUtils.isEmpty(str) && !str.equalsIgnoreCase(this.c)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(h, "ott id: ".concat(str));
                java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> concurrentHashMap2 = com.getui.gtc.extension.distribution.gbd.d.h.z.get(str);
                java.lang.String str2 = concurrentHashMap2.get("friendlyname");
                java.lang.String str3 = concurrentHashMap2.get("manufacturer");
                java.lang.String str4 = concurrentHashMap2.get("modeldescription");
                java.lang.String str5 = concurrentHashMap2.get("modelname");
                java.lang.String str6 = concurrentHashMap2.get("server");
                java.lang.String str7 = concurrentHashMap2.get("user-agent");
                java.lang.String str8 = concurrentHashMap2.get("udn");
                sb.append(d(str));
                sb.append("#");
                sb.append(d(map.get(str)));
                sb.append("#");
                sb.append(d(str7));
                sb.append("#");
                sb.append(d(str6));
                sb.append("#");
                sb.append(d(str2));
                sb.append("#");
                sb.append(d(str3));
                sb.append("#");
                sb.append(d(str4));
                sb.append("#");
                sb.append(d(str5));
                sb.append("#");
                sb.append(d(str8));
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "ott device list = " + sb.toString());
        return sb.toString();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "dosample");
            this.n = 0;
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(127)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(h, "type 127 in type black list, return.");
                return;
            }
            java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.j> map = this.e;
            if (map != null) {
                map.clear();
            }
            this.f = false;
            boolean E = com.getui.gtc.extension.distribution.gbd.n.l.E();
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "doSample checkSafeStatus = ".concat(java.lang.String.valueOf(E)));
            if (!E) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(h, "failed, watchout as = " + com.getui.gtc.extension.distribution.gbd.d.d.aB);
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.n.l.g(this.a)) {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                if (com.getui.gtc.extension.distribution.gbd.f.a.b.d()) {
                    this.c = com.getui.gtc.extension.distribution.gbd.n.o.b();
                    if (this.b == null) {
                        this.b = (java.net.DatagramSocket) java.lang.Class.forName("java.net.DatagramSocket").newInstance();
                    }
                    this.d.execute(new com.getui.gtc.extension.distribution.gbd.a.b.f.b());
                    if (com.getui.gtc.extension.distribution.gbd.d.d.aH) {
                        this.d.execute(new com.getui.gtc.extension.distribution.gbd.a.b.f.AnonymousClass1());
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 29) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "new arp method.");
                        c(this.c);
                    } else {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "old arp method.");
                        java.util.ArrayList<com.getui.gtc.extension.distribution.gbd.c.i> k2 = k();
                        if (k2.isEmpty()) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "local ip range error.");
                        } else {
                            java.util.Iterator<com.getui.gtc.extension.distribution.gbd.c.i> it = k2.iterator();
                            while (it.hasNext()) {
                                com.getui.gtc.extension.distribution.gbd.c.i next = it.next();
                                for (long j2 = next.a; j2 <= next.b; j2++) {
                                    a(com.getui.gtc.extension.distribution.gbd.n.l.a(j2));
                                }
                            }
                        }
                    }
                    this.d.execute(new com.getui.gtc.extension.distribution.gbd.a.b.f.a(this, (byte) 0));
                    return;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "wifi = false or port failed");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public final synchronized void a(int i2) {
        if (!com.getui.gtc.extension.distribution.gbd.d.d.bz) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "type27 disable.");
            return;
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.l.a(127)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(h, "type27 not collect background.");
            return;
        }
        if (i2 == 1) {
            long currentTimeMillis = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.j;
            if (currentTimeMillis < com.getui.gtc.extension.distribution.gbd.d.d.r * 1000) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(h, "timer event interval = " + currentTimeMillis + ", less than default time.");
                return;
            }
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(h, "type27 collect, mode = ".concat(i2 == 1 ? "timer" : "event"));
        this.o = i2;
        a();
    }

    public final void a(java.lang.String str) {
        if (i()) {
            this.d.execute(new com.getui.gtc.extension.distribution.gbd.a.b.f.c(str));
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 127;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }

    public final java.lang.String g() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Map<java.lang.String, com.getui.gtc.extension.distribution.gbd.c.j> map = this.e;
        if (map == null || map.isEmpty()) {
            return "";
        }
        for (java.lang.String str : this.e.keySet()) {
            sb.append(str);
            sb.append("#");
            sb.append(android.text.TextUtils.isEmpty(this.e.get(str).a) ? "" : this.e.get(str).a);
            sb.append("#");
            sb.append(android.text.TextUtils.isEmpty(this.e.get(str).b.trim()) ? "" : this.e.get(str).b.trim());
            sb.append(",");
        }
        if (sb.toString().endsWith(",")) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().replace("\n", "");
    }

    public final java.lang.String h() {
        try {
            return com.getui.gtc.extension.distribution.gbd.n.l.w() + "," + android.os.Build.MODEL + "," + com.getui.gtc.extension.distribution.gbd.n.l.z() + "," + android.os.Build.VERSION.SDK_INT + "," + this.a.getApplicationInfo().targetSdkVersion + "," + com.getui.gtc.extension.distribution.gbd.n.l.q() + "," + com.getui.gtc.extension.distribution.gbd.n.l.r() + "," + this.n + "," + this.o;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }
}

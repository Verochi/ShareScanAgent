package com.getui.gtc.extension.distribution.gbd.a.b;

/* loaded from: classes22.dex */
public final class g {
    private static java.lang.String d = "GBD_WA";
    com.getui.gtc.extension.distribution.gbd.a.b.c a;
    private java.util.Comparator<java.lang.Long> f;
    private com.getui.gtc.extension.distribution.gbd.n.z<java.lang.Long> g;
    private android.content.Context i;
    private long j = 0;
    protected com.getui.gtc.extension.distribution.gbd.a.b.c.b b = com.getui.gtc.extension.distribution.gbd.a.b.c.b.SCAN_END;
    protected int c = com.getui.gtc.extension.distribution.gbd.a.b.c.b;
    private java.util.List<android.net.wifi.ScanResult> h = new java.util.ArrayList();
    private java.util.Comparator<android.net.wifi.ScanResult> e = new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass1();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<android.net.wifi.ScanResult> {
        public AnonymousClass1() {
        }

        private static int a(android.net.wifi.ScanResult scanResult, android.net.wifi.ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(android.net.wifi.ScanResult scanResult, android.net.wifi.ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.g$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<java.lang.Long> {
        public AnonymousClass2() {
        }

        private static int a(java.lang.Long l, java.lang.Long l2) {
            if (l.longValue() == l2.longValue()) {
                return 0;
            }
            return l.longValue() > l2.longValue() ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.lang.Long l, java.lang.Long l2) {
            java.lang.Long l3 = l;
            java.lang.Long l4 = l2;
            if (l3.longValue() == l4.longValue()) {
                return 0;
            }
            return l3.longValue() > l4.longValue() ? 1 : -1;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.b.g$3, reason: invalid class name */
    public class AnonymousClass3 extends com.getui.gtc.extension.distribution.gbd.f.f {
        public AnonymousClass3() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.f
        public final void a(com.getui.gtc.dim.DimRequest.Builder builder) {
            builder.ramCacheValidTime(0L).storageCacheValidTime(0L);
        }
    }

    public g(android.content.Context context) {
        this.i = context;
        com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass2 anonymousClass2 = new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass2();
        this.f = anonymousClass2;
        this.g = new com.getui.gtc.extension.distribution.gbd.n.z<>(anonymousClass2);
        if (com.getui.gtc.extension.distribution.gbd.d.h.C.isEmpty()) {
            return;
        }
        java.util.Collections.sort(com.getui.gtc.extension.distribution.gbd.d.h.C, this.f);
    }

    private void a() {
        this.h = new java.util.ArrayList();
        this.e = new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass1();
        com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass2 anonymousClass2 = new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass2();
        this.f = anonymousClass2;
        this.g = new com.getui.gtc.extension.distribution.gbd.n.z<>(anonymousClass2);
    }

    private void a(int i, int i2) {
        try {
            this.c = i;
            this.h.clear();
            this.a.a(this.h, i, i2);
        } catch (java.lang.Exception e) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    private void a(com.getui.gtc.extension.distribution.gbd.a.b.c cVar) {
        this.a = cVar;
    }

    private void a(java.lang.Object obj, int i) {
        java.util.List<java.lang.Long> a;
        int i2;
        this.b = com.getui.gtc.extension.distribution.gbd.a.b.c.b.SCAN_END;
        if (obj == null && i == 5) {
            return;
        }
        if (obj == null && i == -1) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifiSRsCallBack scan exception");
            i2 = com.getui.gtc.extension.distribution.gbd.a.b.c.j;
        } else {
            if (obj != null || i != 11) {
                try {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    if (obj != null) {
                        java.util.List list = (java.util.List) obj;
                        if (list.size() != 0) {
                            java.util.Collections.sort(list, this.e);
                            int i3 = 0;
                            int i4 = 0;
                            while (true) {
                                if (i3 >= list.size()) {
                                    break;
                                }
                                android.net.wifi.ScanResult scanResult = (android.net.wifi.ScanResult) list.get(i3);
                                java.lang.String str = scanResult.BSSID;
                                if (str != null) {
                                    java.lang.String replaceAll = str.replaceAll(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "");
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, "mac = ".concat(java.lang.String.valueOf(replaceAll)));
                                    long parseLong = java.lang.Long.parseLong(replaceAll, 16);
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, "bssid = ".concat(java.lang.String.valueOf(parseLong)));
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, "level = " + scanResult.level);
                                    if (parseLong != 0 && scanResult.level > com.getui.gtc.extension.distribution.gbd.d.d.aS && !arrayList.contains(java.lang.Long.valueOf(parseLong))) {
                                        if (i4 >= com.getui.gtc.extension.distribution.gbd.d.d.aU) {
                                            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "list size > " + com.getui.gtc.extension.distribution.gbd.d.d.aU);
                                            break;
                                        }
                                        arrayList.add(java.lang.Long.valueOf(parseLong));
                                        this.h.add(scanResult);
                                        i4++;
                                    }
                                }
                                i3++;
                            }
                            if (!arrayList.isEmpty()) {
                                java.util.Collections.sort(arrayList, this.f);
                                if (!com.getui.gtc.extension.distribution.gbd.d.h.C.isEmpty() && (a = this.g.a(arrayList, com.getui.gtc.extension.distribution.gbd.d.h.C)) != null && !a.isEmpty()) {
                                    int size = (int) (((arrayList.size() - a.size()) / arrayList.size()) * 100.0d);
                                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifi changePercent = " + size + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + com.getui.gtc.extension.distribution.gbd.d.d.aV);
                                    if (size < com.getui.gtc.extension.distribution.gbd.d.d.aV && i == 11) {
                                        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifi changePercent < service not report");
                                        a(com.getui.gtc.extension.distribution.gbd.a.b.c.h, i);
                                        return;
                                    }
                                }
                            } else if (i == 11) {
                                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifi filterList size = 0 not report");
                                a(com.getui.gtc.extension.distribution.gbd.a.b.c.i, i);
                                return;
                            }
                        } else if (i == 11) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifiSRsCallBack dynamic scan size = 0 not report");
                            a(com.getui.gtc.extension.distribution.gbd.a.b.c.g, i);
                            return;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a(arrayList);
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(d, "wifi filterList success, start handlerWifiData");
                    this.a.a(this.h, com.getui.gtc.extension.distribution.gbd.a.b.c.b, i);
                    return;
                } catch (java.lang.Exception e) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                    return;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "wifiSRsCallBack sR is null.");
            i2 = com.getui.gtc.extension.distribution.gbd.a.b.c.f;
        }
        a(i2, i);
    }

    private void b() {
        if (com.getui.gtc.extension.distribution.gbd.d.h.C.isEmpty()) {
            return;
        }
        java.util.Collections.sort(com.getui.gtc.extension.distribution.gbd.d.h.C, this.f);
    }

    private void b(int i) {
        if (!com.getui.gtc.extension.distribution.gbd.d.h.i) {
            if (i != 12) {
                a((java.lang.Object) null, 5);
                return;
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "no wifi permission do report");
                a((java.lang.Object) null, i);
                return;
            }
        }
        if (com.getui.gtc.extension.distribution.gbd.d.h.q == 0) {
            com.getui.gtc.extension.distribution.gbd.d.h.q = java.lang.System.currentTimeMillis();
        }
        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.q > com.getui.gtc.extension.distribution.gbd.d.d.aT * 1000) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "timeout, type is ".concat(java.lang.String.valueOf(i)));
            if (i != 12) {
                a((java.lang.Object) null, 5);
                return;
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "timeout report");
                a((java.lang.Object) null, i);
                return;
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.h.q = 0L;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "scan wifi list start");
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.util.List list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(com.getui.gtc.extension.distribution.gbd.d.d.aj, com.getui.gtc.extension.distribution.gbd.f.e.b.F, new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass3());
            java.lang.String str = d;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("scan wifi list end, ");
            sb.append(list == null ? 0 : list.size());
            com.getui.gtc.extension.distribution.gbd.n.j.b(str, sb.toString());
            a(list, i);
        } catch (java.lang.Exception e) {
            a((java.lang.Object) null, -1);
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }

    private boolean c() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28 && !com.getui.gtc.extension.distribution.gbd.n.l.k()) {
            return false;
        }
        if (i < 26 || com.getui.gtc.extension.distribution.gbd.n.l.d()) {
            return true;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.j < 1800000) {
            return false;
        }
        this.j = currentTimeMillis;
        return true;
    }

    private java.util.List<android.net.wifi.ScanResult> d() {
        return this.h;
    }

    private int e() {
        return this.c;
    }

    public final void a(int i) {
        this.h.clear();
        this.b = com.getui.gtc.extension.distribution.gbd.a.b.c.b.SCAN_START;
        this.c = com.getui.gtc.extension.distribution.gbd.a.b.c.b;
        if (!com.getui.gtc.extension.distribution.gbd.d.h.i) {
            if (i != 12) {
                a((java.lang.Object) null, 5);
                return;
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "no wifi permission do report");
                a((java.lang.Object) null, i);
                return;
            }
        }
        if (com.getui.gtc.extension.distribution.gbd.d.h.q == 0) {
            com.getui.gtc.extension.distribution.gbd.d.h.q = java.lang.System.currentTimeMillis();
        }
        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.q > com.getui.gtc.extension.distribution.gbd.d.d.aT * 1000) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "timeout, type is ".concat(java.lang.String.valueOf(i)));
            if (i != 12) {
                a((java.lang.Object) null, 5);
                return;
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "timeout report");
                a((java.lang.Object) null, i);
                return;
            }
        }
        com.getui.gtc.extension.distribution.gbd.d.h.q = 0L;
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(d, "scan wifi list start");
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.util.List list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.b(com.getui.gtc.extension.distribution.gbd.d.d.aj, com.getui.gtc.extension.distribution.gbd.f.e.b.F, new com.getui.gtc.extension.distribution.gbd.a.b.g.AnonymousClass3());
            java.lang.String str = d;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("scan wifi list end, ");
            sb.append(list == null ? 0 : list.size());
            com.getui.gtc.extension.distribution.gbd.n.j.b(str, sb.toString());
            a(list, i);
        } catch (java.lang.Exception e) {
            a((java.lang.Object) null, -1);
            com.getui.gtc.extension.distribution.gbd.n.j.a(e);
        }
    }
}

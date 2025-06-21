package com.loc;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes23.dex */
public final class et {
    static int A = -1;
    private static boolean K;
    boolean F;
    private android.os.Handler N;
    private com.loc.ff O;
    private java.lang.String P;
    private com.loc.eu R;
    public static java.lang.String[] D = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    public static java.lang.String E = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;
    android.content.Context a = null;
    android.net.ConnectivityManager b = null;
    com.loc.fj c = null;
    com.loc.fd d = null;
    com.loc.fl e = null;
    com.loc.fs f = null;
    java.util.ArrayList<com.loc.ei> g = new java.util.ArrayList<>();
    com.loc.et.a h = null;
    com.amap.api.location.AMapLocationClientOption i = new com.amap.api.location.AMapLocationClientOption();
    com.loc.ey j = null;
    long k = 0;
    private int I = 0;
    com.loc.ft l = null;
    boolean m = false;
    private java.lang.String J = null;
    com.loc.fq n = null;
    java.lang.StringBuilder o = new java.lang.StringBuilder();
    boolean p = true;
    boolean q = true;
    com.amap.api.location.AMapLocationClientOption.GeoLanguage r = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: s, reason: collision with root package name */
    boolean f404s = true;
    boolean t = false;
    private java.lang.String L = null;
    java.lang.StringBuilder u = null;
    boolean v = false;
    public boolean w = false;
    int x = 12;
    private boolean M = true;
    com.loc.fa y = null;
    boolean z = false;
    com.loc.ex B = null;
    java.lang.String C = null;
    android.content.IntentFilter G = null;
    android.location.LocationManager H = null;

    /* renamed from: com.loc.et$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.amap.api.location.AMapLocationClientOption.GeoLanguage.values().length];
            a = iArr;
            try {
                iArr[com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.amap.api.location.AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public class a extends android.content.BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.loc.fj fjVar;
            com.loc.fj fjVar2;
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (context == null || intent == null) {
                return;
            }
            try {
                java.lang.String action = intent.getAction();
                if (android.text.TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    com.loc.fj fjVar3 = com.loc.et.this.c;
                    if (fjVar3 != null) {
                        fjVar3.j();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (fjVar2 = com.loc.et.this.c) == null) {
                            return;
                        }
                        fjVar2.i();
                        return;
                    } catch (java.lang.Throwable unused) {
                        return;
                    }
                }
                if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    com.loc.fj fjVar4 = com.loc.et.this.c;
                    if (fjVar4 != null) {
                        fjVar4.k();
                        return;
                    }
                    return;
                }
                if (!action.equals("android.net.wifi.STATE_CHANGE") || (fjVar = com.loc.et.this.c) == null) {
                    return;
                }
                fjVar.h();
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "Aps", "onReceive");
            }
        }
    }

    public et(boolean z) {
        this.F = z;
    }

    private static com.loc.ey a(int i, java.lang.String str) {
        com.loc.ey eyVar = new com.loc.ey("");
        eyVar.setErrorCode(i);
        eyVar.setLocationDetail(str);
        if (i == 15) {
            com.loc.gb.a((java.lang.String) null, 2151);
        }
        return eyVar;
    }

    private com.loc.ey a(com.loc.ey eyVar, com.loc.bv bvVar, com.loc.es esVar) {
        if (bvVar != null) {
            try {
                byte[] bArr = bvVar.a;
                if (bArr != null && bArr.length != 0) {
                    com.loc.fs fsVar = new com.loc.fs();
                    java.lang.String str = new java.lang.String(bvVar.a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        com.loc.ey a2 = fsVar.a(str, this.a, bvVar, esVar);
                        a2.h(this.u.toString());
                        return a2;
                    }
                    if (!str.contains("</body></html>")) {
                        return null;
                    }
                    eyVar.setErrorCode(5);
                    com.loc.fj fjVar = this.c;
                    if (fjVar == null || !fjVar.a(this.b)) {
                        esVar.f("#0502");
                        this.o.append("请求可能被劫持了#0502");
                        com.loc.gb.a((java.lang.String) null, 2052);
                    } else {
                        esVar.f("#0501");
                        this.o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                        com.loc.gb.a((java.lang.String) null, 2051);
                    }
                    eyVar.setLocationDetail(this.o.toString());
                    return eyVar;
                }
            } catch (java.lang.Throwable th) {
                eyVar.setErrorCode(4);
                com.loc.fv.a(th, "Aps", "checkResponseEntity");
                esVar.f("#0403");
                this.o.append("check response exception ex is" + th.getMessage() + "#0403");
                eyVar.setLocationDetail(this.o.toString());
                return eyVar;
            }
        }
        eyVar.setErrorCode(4);
        this.o.append("网络异常,请求异常#0403");
        esVar.f("#0403");
        eyVar.h(this.u.toString());
        eyVar.setLocationDetail(this.o.toString());
        if (bvVar != null) {
            com.loc.gb.a(bvVar.d, 2041);
        }
        return eyVar;
    }

    private java.lang.StringBuilder a(java.lang.StringBuilder sb) {
        if (sb == null) {
            sb = new java.lang.StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        com.loc.fd fdVar = this.d;
        if (fdVar != null && this.c != null) {
            sb.append(fdVar.m());
            sb.append(this.c.p());
        }
        return sb;
    }

    private boolean a(long j) {
        if (!this.M) {
            this.M = true;
            return false;
        }
        if (com.loc.gd.b() - j < 800) {
            if ((com.loc.gd.a(this.j) ? com.loc.gd.a() - this.j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0106 A[Catch: all -> 0x01fa, TRY_LEAVE, TryCatch #1 {all -> 0x01fa, blocks: (B:12:0x0052, B:14:0x007b, B:17:0x0086, B:19:0x008e, B:22:0x0096, B:23:0x0098, B:25:0x009e, B:26:0x00a8, B:29:0x00b1, B:31:0x00c4, B:33:0x00c8, B:34:0x00d2, B:37:0x00e8, B:39:0x00ee, B:41:0x00f2, B:42:0x0102, B:44:0x0106, B:74:0x00f9, B:75:0x00ff), top: B:11:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.loc.ey b(boolean z, com.loc.es esVar) {
        java.lang.StringBuilder sb;
        java.lang.StringBuilder sb2;
        java.lang.String str;
        com.loc.eu euVar;
        java.lang.String str2;
        com.loc.ey a2;
        try {
            if (android.text.TextUtils.isEmpty(this.P)) {
                this.P = com.loc.y.b(com.loc.p.a(this.a) + "," + com.loc.p.f(this.a));
            }
            java.lang.StringBuilder sb3 = this.o;
            sb3.append("#id:");
            sb3.append(this.P);
        } catch (java.lang.Throwable unused) {
        }
        com.loc.ey eyVar = new com.loc.ey("");
        try {
            byte[] n = n();
            long b = com.loc.gd.b();
            this.k = b;
            esVar.a(b);
            try {
                com.loc.fv.c(this.a);
                com.loc.fr a3 = this.n.a(this.a, n, com.loc.fv.a(), com.loc.fv.b(), z);
                a3.b();
                java.lang.String c = a3.c();
                com.loc.n.a(this.a);
                boolean z2 = !android.text.TextUtils.isEmpty(c) && c.contains("dualstack");
                int i = com.loc.fo.a;
                if (com.loc.n.a() && com.loc.n.c() && z2) {
                    i = com.loc.fo.b;
                }
                java.lang.String a4 = com.loc.n.b() ? null : com.loc.fo.a(this.a).a(a3, i);
                esVar.a(i == com.loc.fo.b ? "v6" : "v4");
                com.loc.bv a5 = this.n.a(a3);
                long b2 = com.loc.gd.b();
                if (!android.text.TextUtils.isEmpty(a4)) {
                    if (a5.f) {
                        com.loc.fo.a(this.a).a(false, i);
                        com.loc.fo.a(this.a).a(i);
                    } else {
                        com.loc.fo.a(this.a).a(true, i);
                    }
                }
                if (a5 != null && !android.text.TextUtils.isEmpty(a4)) {
                    if (!a5.f) {
                        esVar.b(a4);
                        esVar.c(com.alipay.sdk.m.f0.c.p);
                        euVar = this.R;
                        if (euVar != null) {
                            euVar.d();
                        }
                        esVar.b(b2);
                        if (a5 == null) {
                            if (!android.text.TextUtils.isEmpty(a5.c)) {
                                this.o.append("#csid:" + a5.c);
                            }
                            str2 = a5.d;
                            eyVar.h(this.u.toString());
                        } else {
                            str2 = "";
                        }
                        a2 = a(eyVar, a5, esVar);
                        if (a2 == null) {
                            return a2;
                        }
                        byte[] b3 = com.loc.fk.b(a5.a);
                        if (b3 == null) {
                            eyVar.setErrorCode(5);
                            esVar.f("#0503");
                            this.o.append("解密数据失败#0503");
                            eyVar.setLocationDetail(this.o.toString());
                            com.loc.gb.a(str2, 2053);
                            return eyVar;
                        }
                        com.loc.ey a6 = this.f.a(eyVar, b3, esVar);
                        if (com.loc.gd.a(a6)) {
                            c(a6);
                            a6.setOffset(this.q);
                            a6.a(this.p);
                            a6.f(java.lang.String.valueOf(this.r));
                            a6.e("new");
                            a6.setLocationDetail(this.o.toString());
                            this.C = a6.a();
                            return a6;
                        }
                        java.lang.String b4 = a6.b();
                        this.J = b4;
                        com.loc.gb.a(str2, !android.text.TextUtils.isEmpty(b4) ? 2062 : 2061);
                        a6.setErrorCode(6);
                        esVar.f("#0601");
                        java.lang.StringBuilder sb4 = this.o;
                        java.lang.StringBuilder sb5 = new java.lang.StringBuilder("location faile retype:");
                        sb5.append(a6.d());
                        sb5.append(" rdesc:");
                        sb5.append(android.text.TextUtils.isEmpty(this.J) ? "" : this.J);
                        sb5.append("#0601");
                        sb4.append(sb5.toString());
                        a6.h(this.u.toString());
                        a6.setLocationDetail(this.o.toString());
                        return a6;
                    }
                    esVar.b(a4);
                    esVar.c("FAIL");
                }
                esVar.d(com.alipay.sdk.m.f0.c.p);
                euVar = this.R;
                if (euVar != null) {
                }
                esVar.b(b2);
                if (a5 == null) {
                }
                a2 = a(eyVar, a5, esVar);
                if (a2 == null) {
                }
            } catch (java.lang.Throwable th) {
                com.loc.gd.b();
                esVar.d("FAIL");
                com.loc.fo.a(this.a).a(false, com.loc.fo.a);
                com.loc.fv.a(th, "Aps", "getApsLoc req");
                com.loc.gb.a("/mobile/binary", th);
                if (com.loc.gd.d(this.a)) {
                    if (th instanceof com.loc.l) {
                        com.loc.l lVar = th;
                        if (lVar.a().contains("网络异常状态码")) {
                            esVar.f("#0404");
                            java.lang.StringBuilder sb6 = this.o;
                            sb6.append("网络异常，状态码错误#0404");
                            sb6.append(lVar.f());
                            com.loc.ey a7 = a(4, this.o.toString());
                            a7.h(this.u.toString());
                            return a7;
                        }
                        if (lVar.f() == 23 || java.lang.Math.abs((com.loc.gd.b() - this.k) - this.i.getHttpTimeOut()) < 500) {
                            esVar.f("#0402");
                            sb2 = this.o;
                            str = "网络异常，连接超时#0402";
                        } else {
                            sb = new java.lang.StringBuilder("#0403,");
                        }
                    } else {
                        sb = new java.lang.StringBuilder("#0403,");
                    }
                    sb.append(th.getMessage());
                    esVar.f(sb.toString());
                    this.o.append("网络异常,请求异常#0403");
                    com.loc.ey a72 = a(4, this.o.toString());
                    a72.h(this.u.toString());
                    return a72;
                }
                esVar.f("#0401");
                sb2 = this.o;
                str = "网络异常，未连接到网络，请连接网络#0401";
                sb2.append(str);
                com.loc.ey a722 = a(4, this.o.toString());
                a722.h(this.u.toString());
                return a722;
            }
        } catch (java.lang.Throwable th2) {
            esVar.f("#0301");
            this.o.append("get parames error:" + th2.getMessage() + "#0301");
            com.loc.gb.a((java.lang.String) null, 2031);
            com.loc.ey a8 = a(3, this.o.toString());
            a8.h(this.u.toString());
            return a8;
        }
    }

    private void b(android.content.Context context) {
        try {
            if (context.checkCallingOrSelfPermission(com.loc.y.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.m = true;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0257, code lost:
    
        if (r6 == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0290, code lost:
    
        if (r6 == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01c6, code lost:
    
        if (com.loc.gd.f(r16.a) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01dd, code lost:
    
        r1 = r16.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d8, code lost:
    
        r16.o.append("或后台运行没有后台定位权限");
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d6, code lost:
    
        if (com.loc.gd.f(r16.a) == false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String c(com.loc.es esVar) {
        java.lang.String str;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        java.lang.StringBuilder sb2;
        java.lang.String str3;
        java.lang.StringBuilder sb3;
        java.lang.StringBuilder sb4;
        java.lang.String str4;
        com.loc.fd fdVar = this.d;
        java.lang.String str5 = "";
        if (fdVar == null || this.c == null) {
            return "";
        }
        int h = fdVar.h();
        com.loc.fc e = this.d.e();
        com.loc.fc f = this.d.f();
        java.util.ArrayList<com.loc.ei> arrayList = this.g;
        boolean z = arrayList == null || arrayList.isEmpty();
        if (e == null && f == null && z) {
            if (this.b == null) {
                this.b = (android.net.ConnectivityManager) com.loc.gd.a(this.a, "connectivity");
            }
            if (com.loc.gd.c() >= 31) {
                if (com.loc.gd.a(this.a) && !this.c.m()) {
                    this.x = 18;
                    this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    com.loc.gb.a((java.lang.String) null, 2132);
                    esVar.f("#1802");
                    return "";
                }
            } else if (com.loc.gd.a(this.a) && !this.c.l()) {
                this.x = 18;
                this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                com.loc.gb.a((java.lang.String) null, 2132);
                esVar.f("#1801");
                return "";
            }
            if (com.loc.gd.c() >= 28) {
                if (this.H == null) {
                    this.H = (android.location.LocationManager) this.a.getApplicationContext().getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
                }
                if (!((java.lang.Boolean) com.loc.fz.a(this.H, "isLocationEnabled", new java.lang.Object[0])).booleanValue()) {
                    this.x = 12;
                    this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    esVar.f("#1206");
                    com.loc.gb.a((java.lang.String) null, 2121);
                    return "";
                }
            }
            if (!com.loc.gd.e(this.a)) {
                this.x = 12;
                this.o.append("定位权限被禁用,请授予应用定位权限#1201");
                esVar.f("#1201");
                com.loc.gb.a((java.lang.String) null, 2121);
                return "";
            }
            if (com.loc.gd.c() >= 24 && com.loc.gd.c() < 28 && android.provider.Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) == 0) {
                this.x = 12;
                esVar.f("#1206");
                this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                com.loc.gb.a((java.lang.String) null, 2121);
                return "";
            }
            java.lang.String k = this.d.k();
            java.lang.String d = this.c.d();
            if (this.c.a(this.b) && d != null) {
                this.x = 12;
                esVar.f("#1202");
                this.o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                com.loc.gb.a((java.lang.String) null, 2121);
                return "";
            }
            if (k != null) {
                this.x = 12;
                if (this.c.l()) {
                    esVar.f("#1205");
                    sb4 = this.o;
                    str4 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
                } else {
                    esVar.f("#1204");
                    sb4 = this.o;
                    str4 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
                }
                sb4.append(str4);
                com.loc.gb.a((java.lang.String) null, 2121);
                return "";
            }
            if (!this.c.l() && !this.d.n()) {
                this.x = 19;
                esVar.f("#1901");
                this.o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                com.loc.gb.a((java.lang.String) null, 2133);
                return "";
            }
            if (this.c.l()) {
                str3 = "#1302";
                esVar.f("#1302");
                if (this.c.c() != null) {
                    this.o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                } else {
                    this.o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                }
            } else {
                esVar.f("#1301");
                sb3 = this.o;
                str3 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
            }
            sb3.append(str3);
            this.x = 13;
            com.loc.gb.a((java.lang.String) null, 2131);
            return "";
        }
        boolean a2 = com.loc.fj.a(this.c.n());
        str = "cgi";
        if (h != 0) {
            if (h != 1) {
                if (h != 2) {
                    this.x = 11;
                    com.loc.gb.a((java.lang.String) null, 2111);
                    esVar.f("#1101");
                    this.o.append("get cgi failure#1101");
                } else if (e != null) {
                    sb2 = new java.lang.StringBuilder();
                    sb2.append(e.a);
                    sb2.append("#");
                    sb2.append(e.b);
                    sb2.append("#");
                    sb2.append(e.h);
                    sb2.append("#");
                    sb2.append(e.i);
                    sb2.append("#");
                    sb2.append(e.j);
                    sb2.append("#");
                    sb2.append("network");
                    sb2.append("#");
                    if (this.g.isEmpty()) {
                    }
                    str = "cgiwifi";
                    sb2.append(str);
                }
            } else if (e != null) {
                sb2 = new java.lang.StringBuilder();
                sb2.append(e.a);
                sb2.append("#");
                sb2.append(e.b);
                sb2.append("#");
                sb2.append(e.c);
                sb2.append("#");
                sb2.append(e.d);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                if (this.g.isEmpty()) {
                }
                str = "cgiwifi";
                sb2.append(str);
            }
            if (android.text.TextUtils.isEmpty(str5)) {
                return str5;
            }
            if (!str5.startsWith("#")) {
                str5 = "#" + str5;
            }
            return com.loc.gd.e() + str5;
        }
        boolean z2 = !this.g.isEmpty() || a2;
        boolean z3 = f != null;
        if (!z3) {
            if (a2 && this.g.isEmpty()) {
                this.x = 2;
                esVar.f("#0201");
                this.o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                com.loc.gb.a((java.lang.String) null, 2021);
                return "";
            }
            if (this.g.size() == 1) {
                this.x = 2;
                if (!a2) {
                    esVar.f("#0202");
                    this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                    com.loc.gb.a((java.lang.String) null, com.autonavi.base.amap.mapcore.tools.GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
                    return "";
                }
                if (this.g.get(0).h) {
                    esVar.f("#0202");
                    this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                    com.loc.gb.a((java.lang.String) null, 2021);
                    return "";
                }
            }
        }
        java.lang.String format = java.lang.String.format(java.util.Locale.US, "#%s#", "network");
        if (z3) {
            sb2 = new java.lang.StringBuilder();
            sb2.append(f.b());
            str = (!this.g.isEmpty() || a2) ? "cgiwifi" : "cgi";
            sb2.append("network");
            sb2.append("#");
            sb2.append(str);
        } else if (z2) {
            sb2 = new java.lang.StringBuilder();
            sb2.append(format);
            sb2.append(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
        } else {
            this.x = 2;
            if (this.c.l()) {
                esVar.f("#0204");
                sb = this.o;
                str2 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
            } else {
                esVar.f("#0203");
                sb = this.o;
                str2 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
            }
            sb.append(str2);
            com.loc.gb.a((java.lang.String) null, com.autonavi.base.amap.mapcore.tools.GLMapStaticValue.MAP_PARAMETERNAME_CLEAR_INDOORBUILDING_LAST);
            if (android.text.TextUtils.isEmpty(str5)) {
            }
        }
        str5 = sb2.toString();
        if (android.text.TextUtils.isEmpty(str5)) {
        }
    }

    private static void c(com.loc.ey eyVar) {
        if (eyVar.getErrorCode() == 0 && eyVar.getLocationType() == 0) {
            if ("-5".equals(eyVar.d()) || "1".equals(eyVar.d()) || "2".equals(eyVar.d()) || com.tencent.connect.common.Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(eyVar.d()) || com.tencent.connect.common.Constants.VIA_REPORT_TYPE_CHAT_AIO.equals(eyVar.d()) || "-1".equals(eyVar.d())) {
                eyVar.setLocationType(5);
            } else {
                eyVar.setLocationType(6);
            }
        }
    }

    private void d(com.loc.ey eyVar) {
        if (eyVar != null) {
            this.j = eyVar;
        }
    }

    private void i() {
        if (this.n != null) {
            try {
                if (this.i == null) {
                    this.i = new com.amap.api.location.AMapLocationClientOption();
                }
                this.n.a(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private int j() {
        int i;
        if (this.i.getGeoLanguage() == null || (i = com.loc.et.AnonymousClass1.a[this.i.getGeoLanguage().ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private void k() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.amap.api.location.AMapLocationClientOption.GeoLanguage geoLanguage = com.amap.api.location.AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z5 = true;
        try {
            geoLanguage = this.i.getGeoLanguage();
            z = this.i.isNeedAddress();
            try {
                z3 = this.i.isOffset();
                try {
                    z4 = this.i.isLocationCacheEnable();
                } catch (java.lang.Throwable unused) {
                    z5 = z3;
                    z2 = true;
                    boolean z6 = z2;
                    z3 = z5;
                    z4 = z6;
                    this.q = z3;
                    this.p = z;
                    this.f404s = z4;
                    this.r = geoLanguage;
                }
            } catch (java.lang.Throwable unused2) {
            }
        } catch (java.lang.Throwable unused3) {
            z = true;
        }
        try {
            this.t = this.i.isOnceLocationLatest();
            this.z = this.i.isSensorEnable();
            if (z3 != this.q || z != this.p || z4 != this.f404s || geoLanguage != this.r) {
                s();
            }
        } catch (java.lang.Throwable unused4) {
            z2 = z4;
            z5 = z3;
            boolean z62 = z2;
            z3 = z5;
            z4 = z62;
            this.q = z3;
            this.p = z;
            this.f404s = z4;
            this.r = geoLanguage;
        }
        this.q = z3;
        this.p = z;
        this.f404s = z4;
        this.r = geoLanguage;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void l() {
        com.loc.fd fdVar;
        com.loc.fj fjVar;
        com.loc.et.a aVar;
        try {
            android.content.Context context = this.a;
            if (context != null && (aVar = this.h) != null) {
                context.unregisterReceiver(aVar);
            }
        } finally {
            try {
                fdVar = this.d;
                if (fdVar != null) {
                }
                fjVar = this.c;
                if (fjVar == null) {
                }
            } finally {
            }
        }
        fdVar = this.d;
        if (fdVar != null) {
            fdVar.a(this.F);
        }
        fjVar = this.c;
        if (fjVar == null) {
            fjVar.c(this.F);
        }
    }

    private void m() {
        try {
            if (this.h == null) {
                this.h = new com.loc.et.a();
            }
            if (this.G == null) {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
                this.G.addAction("android.net.wifi.STATE_CHANGE");
            }
            this.a.registerReceiver(this.h, this.G);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] n() throws java.lang.Throwable {
        if (this.l == null) {
            this.l = new com.loc.ft();
        }
        if (this.i == null) {
            this.i = new com.amap.api.location.AMapLocationClientOption();
        }
        if (this.d != null && this.c != null) {
            this.l.a(this.a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.C, this.O);
        }
        return this.l.a();
    }

    private boolean o() {
        return this.k == 0 || com.loc.gd.b() - this.k > com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    }

    private void p() {
        com.loc.fj fjVar = this.c;
        if (fjVar == null) {
            return;
        }
        fjVar.a(this.m);
    }

    private boolean q() {
        com.loc.fj fjVar = this.c;
        if (fjVar != null) {
            this.g = fjVar.e();
        }
        java.util.ArrayList<com.loc.ei> arrayList = this.g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void r() {
        if (this.L != null) {
            this.L = null;
        }
        java.lang.StringBuilder sb = this.u;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void s() {
        try {
            com.loc.fl flVar = this.e;
            if (flVar != null) {
                flVar.a();
            }
            d(null);
            this.M = false;
            com.loc.ex exVar = this.B;
            if (exVar != null) {
                exVar.a();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Aps", "cleanCache");
        }
    }

    public final com.loc.ey a(double d, double d2) {
        try {
            java.lang.String a2 = this.n.a(this.a, d, d2);
            if (!a2.contains("\"status\":\"1\"")) {
                return null;
            }
            com.loc.ey a3 = this.f.a(a2);
            a3.setLatitude(d);
            a3.setLongitude(d2);
            return a3;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:53|(1:101)(1:57)|58|(1:60)(2:88|(2:90|(1:92))(11:93|(1:97)|98|(1:100)|62|63|(2:66|(1:68)(2:69|(1:71)(2:72|(1:74)(1:75))))|76|(3:78|(1:84)(1:82)|83)|85|86))|61|62|63|(2:66|(0)(0))|76|(0)|85|86) */
    /* JADX WARN: Can't wrap try/catch for region: R(14:20|(2:22|(1:24)(1:25))|26|27|28|(8:33|34|(1:36)|38|39|(1:41)|43|(2:45|46)(2:47|(12:53|(1:101)(1:57)|58|(1:60)(2:88|(2:90|(1:92))(11:93|(1:97)|98|(1:100)|62|63|(2:66|(1:68)(2:69|(1:71)(2:72|(1:74)(1:75))))|76|(3:78|(1:84)(1:82)|83)|85|86))|61|62|63|(2:66|(0)(0))|76|(0)|85|86)(2:51|52)))|104|34|(0)|38|39|(0)|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00a3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00a4, code lost:
    
        com.loc.fv.a(r0, "Aps", "getLocation getCgiListParam");
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:28:0x006d, B:30:0x0075, B:34:0x0081, B:36:0x0085), top: B:27:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009b A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #1 {all -> 0x00a3, blocks: (B:39:0x0097, B:41:0x009b), top: B:38:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0177 A[Catch: all -> 0x0194, TryCatch #2 {all -> 0x0194, blocks: (B:63:0x0167, B:66:0x016d, B:68:0x0177, B:71:0x0181, B:74:0x018b, B:75:0x0190), top: B:62:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.loc.ey a(com.loc.es esVar) throws java.lang.Throwable {
        java.lang.String c;
        com.loc.fj fjVar;
        float f;
        com.loc.fa faVar;
        long b;
        com.loc.fj fjVar2;
        com.loc.fd fdVar;
        boolean z;
        com.loc.fj fjVar3;
        d();
        esVar.e("conitue");
        if (this.a == null) {
            esVar.f("#0101");
            this.o.append("context is null#0101");
            return a(1, this.o.toString());
        }
        int i = this.I + 1;
        this.I = i;
        if (i == 1) {
            p();
        }
        if (a(this.k) && com.loc.gd.a(this.j)) {
            if (this.f404s && com.loc.fu.a(this.j.getTime())) {
                this.j.setLocationType(2);
            }
            return this.j;
        }
        com.loc.fa faVar2 = this.y;
        if (faVar2 != null) {
            if (this.z) {
                faVar2.a();
            } else {
                faVar2.b();
            }
        }
        try {
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Aps", "getLocation getScanResultsParam");
        }
        if (!this.i.isOnceLocationLatest() && this.i.isOnceLocation()) {
            z = false;
            fjVar3 = this.c;
            if (fjVar3 != null) {
                fjVar3.b(z);
                this.g = this.c.e();
            }
            fdVar = this.d;
            if (fdVar != null) {
                fdVar.a(false, q());
            }
            c = c(esVar);
            this.L = c;
            if (!android.text.TextUtils.isEmpty(c)) {
                return a(this.x, this.o.toString());
            }
            this.u = a(this.u);
            com.loc.fj fjVar4 = this.c;
            if (fjVar4 != null && fjVar4.o()) {
                com.loc.ey a2 = a(15, "networkLocation has been mocked!#1502");
                esVar.f("#1502");
                a2.setMock(true);
                a2.setTrustedLevel(4);
                return a2;
            }
            boolean o = o();
            com.loc.fd fdVar2 = this.d;
            com.loc.ey eyVar = null;
            com.loc.ey a3 = (fdVar2 == null || (fjVar2 = this.c) == null) ? null : this.e.a(fdVar2, o, this.j, fjVar2, this.u, this.L, this.a, false);
            if (com.loc.gd.a(a3)) {
                a3.setTrustedLevel(2);
            } else {
                a3 = b(true, esVar);
                if (!com.loc.gd.a(a3)) {
                    com.loc.fd fdVar3 = this.d;
                    if (fdVar3 != null && (fjVar = this.c) != null) {
                        eyVar = this.e.a(fdVar3, false, this.j, fjVar, this.u, this.L, this.a, true);
                    }
                    if (com.loc.gd.a(eyVar)) {
                        esVar.f("#0001");
                        eyVar.setTrustedLevel(2);
                        d(eyVar);
                        a3 = eyVar;
                    }
                    if (this.c != null && a3 != null) {
                        b = com.loc.fj.b();
                        if (b > 15) {
                            a3.setTrustedLevel(1);
                        } else if (b <= 120) {
                            a3.setTrustedLevel(2);
                        } else if (b <= 600) {
                            a3.setTrustedLevel(3);
                        } else {
                            a3.setTrustedLevel(4);
                        }
                    }
                    this.e.a(this.L, this.u, a3, this.a, true);
                    com.loc.gd.a(a3);
                    java.lang.StringBuilder sb = this.u;
                    sb.delete(0, sb.length());
                    if (a3 != null) {
                        if (!this.z || (faVar = this.y) == null) {
                            a3.setAltitude(0.0d);
                            f = 0.0f;
                            a3.setBearing(0.0f);
                        } else {
                            a3.setAltitude(faVar.c());
                            a3.setBearing(this.y.d());
                            f = (float) this.y.e();
                        }
                        a3.setSpeed(f);
                    }
                    d(a3);
                    return this.j;
                }
                a3.e("new");
                this.e.a(this.u.toString());
                com.loc.fd fdVar4 = this.d;
                if (fdVar4 != null) {
                    this.e.a(fdVar4.e());
                }
            }
            d(a3);
            if (this.c != null) {
                b = com.loc.fj.b();
                if (b > 15) {
                }
            }
            this.e.a(this.L, this.u, a3, this.a, true);
            com.loc.gd.a(a3);
            java.lang.StringBuilder sb2 = this.u;
            sb2.delete(0, sb2.length());
            if (a3 != null) {
            }
            d(a3);
            return this.j;
        }
        z = true;
        fjVar3 = this.c;
        if (fjVar3 != null) {
        }
        fdVar = this.d;
        if (fdVar != null) {
        }
        c = c(esVar);
        this.L = c;
        if (!android.text.TextUtils.isEmpty(c)) {
        }
    }

    public final com.loc.ey a(com.loc.ey eyVar) {
        this.B.a(this.f404s);
        return this.B.a(eyVar);
    }

    public final com.loc.ey a(boolean z, com.loc.es esVar) {
        esVar.e(z ? "statics" : "first");
        if (this.a == null) {
            esVar.f("#0101");
            this.o.append("context is null#0101");
            com.loc.gb.a((java.lang.String) null, 2011);
            return a(1, this.o.toString());
        }
        com.loc.fj fjVar = this.c;
        if (fjVar != null && fjVar.o()) {
            esVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (android.text.TextUtils.isEmpty(this.L)) {
            return a(this.x, this.o.toString());
        }
        com.loc.ey b = b(z, esVar);
        if (com.loc.gd.a(b) && !Q) {
            this.e.a(this.u.toString());
            com.loc.fd fdVar = this.d;
            if (fdVar != null) {
                this.e.a(fdVar.e());
            }
            d(b);
        }
        Q = true;
        return b;
    }

    public final void a() {
        com.loc.fd fdVar = this.d;
        if (fdVar != null) {
            fdVar.b();
        }
    }

    public final void a(android.content.Context context) {
        try {
            if (this.a != null) {
                return;
            }
            this.B = new com.loc.ex();
            android.content.Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            com.loc.gd.b(applicationContext);
            if (this.c == null) {
                this.c = new com.loc.fj(this.a, (android.net.wifi.WifiManager) com.loc.gd.a(this.a, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI), this.N);
            }
            if (this.d == null) {
                this.d = new com.loc.fd(this.a, this.N);
            }
            this.O = new com.loc.ff(context, this.N);
            if (this.e == null) {
                this.e = new com.loc.fl();
            }
            if (this.f == null) {
                this.f = new com.loc.fs();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.loc.fv.a(th, "Aps", "initBase");
        }
    }

    public final void a(android.os.Handler handler) {
        this.N = handler;
    }

    public final void a(com.amap.api.location.AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            com.loc.fe feVar = new com.loc.fe();
            feVar.a = aMapLocation.getLocationType();
            feVar.d = aMapLocation.getTime();
            feVar.e = (int) aMapLocation.getAccuracy();
            feVar.b = aMapLocation.getLatitude();
            feVar.c = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.O.a(feVar);
            }
            if (aMapLocation.getLocationType() == 12) {
                this.O.b(feVar);
            }
        }
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new com.amap.api.location.AMapLocationClientOption();
        }
        com.loc.fj fjVar = this.c;
        if (fjVar != null) {
            this.i.isWifiActiveScan();
            fjVar.a(this.i.isWifiScan(), this.i.isMockEnable(), com.amap.api.location.AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        com.loc.fl flVar = this.e;
        if (flVar != null) {
            flVar.a(this.i);
        }
        com.loc.fs fsVar = this.f;
        if (fsVar != null) {
            fsVar.a(this.i);
        }
        com.loc.fd fdVar = this.d;
        if (fdVar != null) {
            fdVar.c(this.i.isNoLocReqCgiEnable());
        }
        k();
    }

    public final void a(com.loc.ey eyVar, int i) {
        if (eyVar != null && eyVar.getErrorCode() == 0) {
            com.loc.fe feVar = new com.loc.fe();
            feVar.d = eyVar.getTime();
            feVar.e = (int) eyVar.getAccuracy();
            feVar.b = eyVar.getLatitude();
            feVar.c = eyVar.getLongitude();
            feVar.a = i;
            feVar.g = java.lang.Integer.parseInt(eyVar.d());
            feVar.h = eyVar.l();
            this.O.c(feVar);
        }
    }

    public final void a(boolean z) {
        com.loc.fd fdVar = this.d;
        if (fdVar != null) {
            fdVar.b(z);
        }
    }

    public final com.loc.ey b(boolean z) {
        int i;
        java.lang.String sb;
        com.loc.fj fjVar = this.c;
        if (fjVar != null && fjVar.o()) {
            i = 15;
            sb = "networkLocation has been mocked!#1502";
        } else {
            if (!android.text.TextUtils.isEmpty(this.L)) {
                com.loc.ey a2 = this.e.a(this.a, this.L, this.u, true, z);
                if (com.loc.gd.a(a2)) {
                    d(a2);
                }
                return a2;
            }
            i = this.x;
            sb = this.o.toString();
        }
        return a(i, sb);
    }

    public final void b() {
        this.n = com.loc.fq.a(this.a);
        i();
        if (this.b == null) {
            this.b = (android.net.ConnectivityManager) com.loc.gd.a(this.a, "connectivity");
        }
        if (this.l == null) {
            this.l = new com.loc.ft();
        }
    }

    public final void b(com.loc.es esVar) {
        try {
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Aps", "initFirstLocateParam");
        }
        if (this.v) {
            return;
        }
        r();
        if (this.t) {
            m();
        }
        com.loc.fj fjVar = this.c;
        if (fjVar != null) {
            fjVar.b(this.t);
            this.g = this.c.e();
        }
        com.loc.fd fdVar = this.d;
        if (fdVar != null) {
            fdVar.a(true, q());
        }
        java.lang.String c = c(esVar);
        this.L = c;
        if (!android.text.TextUtils.isEmpty(c)) {
            this.u = a(this.u);
        }
        this.v = true;
    }

    public final void b(com.loc.ey eyVar) {
        if (com.loc.gd.a(eyVar)) {
            this.e.a(this.L, this.u, eyVar, this.a, true);
        }
    }

    public final void c() {
        if (this.y == null) {
            this.y = new com.loc.fa(this.a);
        }
        m();
        com.loc.fj fjVar = this.c;
        if (fjVar != null) {
            fjVar.b(false);
            this.g = this.c.e();
        }
        com.loc.fd fdVar = this.d;
        if (fdVar != null) {
            fdVar.a(false, q());
        }
        this.e.a(this.a);
        b(this.a);
        this.w = true;
    }

    public final void d() {
        if (this.o.length() > 0) {
            java.lang.StringBuilder sb = this.o;
            sb.delete(0, sb.length());
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public final void e() {
        this.C = null;
        this.v = false;
        this.w = false;
        com.loc.fl flVar = this.e;
        if (flVar != null) {
            flVar.b(this.a);
        }
        com.loc.ex exVar = this.B;
        if (exVar != null) {
            exVar.a();
        }
        if (this.f != null) {
            this.f = null;
        }
        com.loc.ff ffVar = this.O;
        if (ffVar != null) {
            ffVar.a(this.F);
        }
        l();
        java.util.ArrayList<com.loc.ei> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.loc.fa faVar = this.y;
        if (faVar != null) {
            faVar.f();
        }
        this.j = null;
        this.a = null;
        this.u = null;
        this.H = null;
    }

    public final void f() {
        com.loc.eu euVar = this.R;
        if (euVar != null) {
            euVar.d();
        }
    }

    public final void g() {
        com.loc.fj fjVar;
        try {
            if (this.a == null) {
                return;
            }
            if (this.R == null) {
                this.R = new com.loc.eu(this.a);
            }
            com.loc.fd fdVar = this.d;
            if (fdVar == null || (fjVar = this.c) == null) {
                return;
            }
            this.R.a(fdVar, fjVar, this.N);
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "as", "stc");
        }
    }

    public final void h() {
        com.loc.eu euVar = this.R;
        if (euVar != null) {
            euVar.a();
        }
    }
}

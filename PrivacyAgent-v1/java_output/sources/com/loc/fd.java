package com.loc;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes23.dex */
public final class fd {
    android.telephony.TelephonyManager b;
    android.telephony.SignalStrength d;
    private android.content.Context h;
    private com.loc.fb m;

    @android.annotation.SuppressLint({"NewApi"})
    private android.telephony.TelephonyManager.CellInfoCallback q;
    private com.loc.eu x;
    private boolean i = false;
    private boolean j = false;
    java.util.ArrayList<com.loc.fc> a = new java.util.ArrayList<>();
    private java.lang.String k = null;
    private java.util.ArrayList<com.loc.fc> l = new java.util.ArrayList<>();
    private long n = 0;
    android.telephony.PhoneStateListener c = null;
    private boolean o = false;
    private java.lang.Object p = new java.lang.Object();
    private boolean r = false;
    boolean e = false;
    java.lang.StringBuilder f = null;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f407s = null;
    private java.lang.String t = null;
    java.lang.String g = null;
    private volatile boolean u = true;
    private volatile boolean v = true;
    private volatile boolean w = false;

    @android.annotation.SuppressLint({"NewApi"})
    public class a extends android.telephony.TelephonyManager.CellInfoCallback {
        public a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(java.util.List<android.telephony.CellInfo> list) {
            try {
                com.loc.fx.a();
                java.lang.StringBuilder sb = new java.lang.StringBuilder("noLocReqCgiEnable:");
                sb.append(com.loc.fd.this.v);
                sb.append(" isStartLocation:");
                sb.append(com.loc.fd.this.u);
                com.loc.fx.a();
                if ((com.loc.fd.this.v || com.loc.fd.this.u) && com.loc.gd.b() - com.loc.fd.this.n >= 500) {
                    com.loc.fd.d(com.loc.fd.this);
                    com.loc.fd.this.a(com.loc.fd.this.v());
                    com.loc.fd.this.a(list);
                    com.loc.fd.this.n = com.loc.gd.b();
                }
            } catch (java.lang.SecurityException e) {
                com.loc.fd.this.g = e.getMessage();
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "Cgi", "cellInfo");
            }
        }
    }

    public class b extends android.telephony.PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(java.util.List<android.telephony.CellInfo> list) {
            try {
                com.loc.fx.a();
                java.lang.StringBuilder sb = new java.lang.StringBuilder("noLocReqCgiEnable:");
                sb.append(com.loc.fd.this.v);
                sb.append(" isStartLocation:");
                sb.append(com.loc.fd.this.u);
                com.loc.fx.a();
                if (com.loc.fd.this.v || com.loc.fd.this.u) {
                    if (com.loc.fd.this.x != null) {
                        com.loc.fd.this.x.c();
                    }
                    if (com.loc.gd.b() - com.loc.fd.this.n < 500) {
                        return;
                    }
                    com.loc.fd.this.a(com.loc.fd.this.v());
                    com.loc.fd.this.a(list);
                    com.loc.fd.this.n = com.loc.gd.b();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(android.telephony.CellLocation cellLocation) {
            com.loc.fx.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("noLocReqCgiEnable:");
            sb.append(com.loc.fd.this.v);
            sb.append(" isStartLocation:");
            sb.append(com.loc.fd.this.u);
            com.loc.fx.a();
            if ((com.loc.fd.this.v || com.loc.fd.this.u) && com.loc.gd.b() - com.loc.fd.this.n >= 500) {
                try {
                    com.loc.fd.this.a(cellLocation);
                    com.loc.fd.this.a(com.loc.fd.this.w());
                    com.loc.fd.this.n = com.loc.gd.b();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int i) {
            super.onDataConnectionStateChanged(i);
            com.loc.fx.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(android.telephony.ServiceState serviceState) {
            try {
                com.loc.fx.a();
                java.lang.StringBuilder sb = new java.lang.StringBuilder("noLocReqCgiEnable:");
                sb.append(com.loc.fd.this.v);
                sb.append(" isStartLocation:");
                sb.append(com.loc.fd.this.u);
                com.loc.fx.a();
                if (com.loc.fd.this.v || com.loc.fd.this.u) {
                    int state = serviceState.getState();
                    if (state == 0) {
                        com.loc.fd.this.a(false, false);
                    } else {
                        if (state != 1) {
                            return;
                        }
                        com.loc.fd.this.j();
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            com.loc.fx.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) {
            com.loc.fx.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("noLocReqCgiEnable:");
            sb.append(com.loc.fd.this.v);
            sb.append(" isStartLocation:");
            sb.append(com.loc.fd.this.u);
            com.loc.fx.a();
            if (signalStrength == null) {
                return;
            }
            com.loc.fd fdVar = com.loc.fd.this;
            fdVar.d = signalStrength;
            if (fdVar.v || com.loc.fd.this.u) {
                try {
                    if (com.loc.fd.this.x != null) {
                        com.loc.fd.this.x.c();
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    public fd(android.content.Context context, android.os.Handler handler) {
        this.b = null;
        this.m = null;
        com.loc.fx.a();
        this.h = context;
        if (this.b == null) {
            this.b = (android.telephony.TelephonyManager) com.loc.gd.a(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        }
        o();
        com.loc.fb fbVar = new com.loc.fb(context, "cellAge", handler);
        this.m = fbVar;
        fbVar.a();
    }

    private static com.loc.fc a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        com.loc.fc fcVar = new com.loc.fc(i, z);
        fcVar.a = i2;
        fcVar.b = i3;
        fcVar.c = i4;
        fcVar.d = i5;
        fcVar.k = i6;
        return fcVar;
    }

    private com.loc.fc a(android.telephony.CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            android.telephony.CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                android.telephony.CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                java.lang.String[] a2 = com.loc.gd.a(this.b);
                try {
                    i = java.lang.Integer.parseInt(a2[0]);
                } catch (java.lang.Throwable unused) {
                    i = 0;
                }
                try {
                    i3 = java.lang.Integer.parseInt(a2[1]);
                    i2 = i;
                } catch (java.lang.Throwable unused2) {
                    i2 = i;
                    i3 = 0;
                    com.loc.fc a3 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    a3.h = cellIdentity2.getSystemId();
                    a3.i = cellIdentity2.getNetworkId();
                    a3.j = cellIdentity2.getBasestationId();
                    a3.f = cellIdentity2.getLatitude();
                    a3.g = cellIdentity2.getLongitude();
                    a3.f406s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    return a3;
                }
                com.loc.fc a32 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a32.h = cellIdentity2.getSystemId();
                a32.i = cellIdentity2.getNetworkId();
                a32.j = cellIdentity2.getBasestationId();
                a32.f = cellIdentity2.getLatitude();
                a32.g = cellIdentity2.getLongitude();
                a32.f406s = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                return a32;
            }
        }
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static com.loc.fc a(android.telephony.CellInfoGsm cellInfoGsm, boolean z) {
        int bsic;
        int arfcn;
        int timingAdvance;
        if (cellInfoGsm == null || cellInfoGsm.getCellIdentity() == null) {
            return null;
        }
        android.telephony.CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        com.loc.fc a2 = a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
        bsic = cellInfoGsm.getCellIdentity().getBsic();
        a2.o = bsic;
        arfcn = cellInfoGsm.getCellIdentity().getArfcn();
        a2.p = arfcn;
        timingAdvance = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
        a2.q = timingAdvance;
        a2.f406s = cellInfoGsm.getCellSignalStrength().getDbm();
        return a2;
    }

    private static com.loc.fc a(android.telephony.CellInfoLte cellInfoLte, boolean z) {
        int earfcn;
        if (cellInfoLte == null || cellInfoLte.getCellIdentity() == null) {
            return null;
        }
        android.telephony.CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        com.loc.fc a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPci();
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            earfcn = cellIdentity.getEarfcn();
            a2.p = earfcn;
        }
        a2.q = cellInfoLte.getCellSignalStrength().getTimingAdvance();
        a2.f406s = cellInfoLte.getCellSignalStrength().getDbm();
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.loc.fc a(android.telephony.CellInfoNr cellInfoNr, boolean z) {
        android.telephony.CellIdentity cellIdentity;
        android.telephony.CellIdentity cellIdentity2;
        int tac;
        long nci;
        int i;
        int i2;
        int i3;
        android.telephony.CellSignalStrength cellSignalStrength;
        int ssRsrp;
        int tac2;
        int pci;
        int nrarfcn;
        android.telephony.CellSignalStrength cellSignalStrength2;
        java.lang.String mccString;
        java.lang.String mncString;
        if (cellInfoNr == null) {
            return null;
        }
        cellIdentity = cellInfoNr.getCellIdentity();
        if (cellIdentity == null) {
            return null;
        }
        cellIdentity2 = cellInfoNr.getCellIdentity();
        android.telephony.CellIdentityNr cellIdentityNr = (android.telephony.CellIdentityNr) cellIdentity2;
        tac = cellIdentityNr.getTac();
        if (tac == Integer.MAX_VALUE && "HUAWEI".equals(android.os.Build.MANUFACTURER)) {
            try {
                tac = com.loc.fz.b(cellIdentityNr, "getHwTac", new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        nci = cellIdentityNr.getNci();
        try {
            mccString = cellIdentityNr.getMccString();
            i = java.lang.Integer.parseInt(mccString);
            try {
                mncString = cellIdentityNr.getMncString();
                i2 = i;
                i3 = java.lang.Integer.parseInt(mncString);
            } catch (java.lang.Throwable th2) {
                th = th2;
                th.printStackTrace();
                i2 = i;
                i3 = 0;
                cellSignalStrength = cellInfoNr.getCellSignalStrength();
                ssRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrength).getSsRsrp();
                tac2 = cellIdentityNr.getTac();
                com.loc.fc a2 = a(5, z, i2, i3, tac2, 0, ssRsrp);
                a2.e = nci;
                if (tac <= 16777215) {
                }
                pci = cellIdentityNr.getPci();
                a2.o = pci;
                nrarfcn = cellIdentityNr.getNrarfcn();
                a2.p = nrarfcn;
                cellSignalStrength2 = cellInfoNr.getCellSignalStrength();
                a2.f406s = cellSignalStrength2.getDbm();
                return a2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            i = 0;
        }
        cellSignalStrength = cellInfoNr.getCellSignalStrength();
        ssRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrength).getSsRsrp();
        tac2 = cellIdentityNr.getTac();
        com.loc.fc a22 = a(5, z, i2, i3, tac2, 0, ssRsrp);
        a22.e = nci;
        if (tac <= 16777215) {
            a22.c = 65535;
        } else if (tac > 65535) {
            a22.c = 65535;
            a22.q = tac;
        } else {
            a22.c = tac;
        }
        pci = cellIdentityNr.getPci();
        a22.o = pci;
        nrarfcn = cellIdentityNr.getNrarfcn();
        a22.p = nrarfcn;
        cellSignalStrength2 = cellInfoNr.getCellSignalStrength();
        a22.f406s = cellSignalStrength2.getDbm();
        return a22;
    }

    private static com.loc.fc a(android.telephony.CellInfoWcdma cellInfoWcdma, boolean z) {
        int uarfcn;
        if (cellInfoWcdma == null || cellInfoWcdma.getCellIdentity() == null) {
            return null;
        }
        android.telephony.CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        com.loc.fc a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        a2.o = cellIdentity.getPsc();
        uarfcn = cellInfoWcdma.getCellIdentity().getUarfcn();
        a2.p = uarfcn;
        a2.f406s = cellInfoWcdma.getCellSignalStrength().getDbm();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(android.telephony.CellLocation cellLocation) {
        java.lang.String[] a2 = com.loc.gd.a(this.b);
        this.a.clear();
        if (cellLocation instanceof android.telephony.gsm.GsmCellLocation) {
            android.telephony.gsm.GsmCellLocation gsmCellLocation = (android.telephony.gsm.GsmCellLocation) cellLocation;
            com.loc.fc fcVar = new com.loc.fc(1, true);
            fcVar.a = com.loc.gd.e(a2[0]);
            fcVar.b = com.loc.gd.e(a2[1]);
            fcVar.c = gsmCellLocation.getLac();
            fcVar.d = gsmCellLocation.getCid();
            android.telephony.SignalStrength signalStrength = this.d;
            if (signalStrength != null) {
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                fcVar.f406s = gsmSignalStrength == 99 ? Integer.MAX_VALUE : b(gsmSignalStrength);
            }
            fcVar.r = false;
            this.m.a((com.loc.fb) fcVar);
            this.a.add(fcVar);
            return;
        }
        if (cellLocation instanceof android.telephony.cdma.CdmaCellLocation) {
            android.telephony.cdma.CdmaCellLocation cdmaCellLocation = (android.telephony.cdma.CdmaCellLocation) cellLocation;
            com.loc.fc fcVar2 = new com.loc.fc(2, true);
            fcVar2.a = java.lang.Integer.parseInt(a2[0]);
            fcVar2.b = java.lang.Integer.parseInt(a2[1]);
            fcVar2.f = cdmaCellLocation.getBaseStationLatitude();
            fcVar2.g = cdmaCellLocation.getBaseStationLongitude();
            fcVar2.h = cdmaCellLocation.getSystemId();
            fcVar2.i = cdmaCellLocation.getNetworkId();
            fcVar2.j = cdmaCellLocation.getBaseStationId();
            android.telephony.SignalStrength signalStrength2 = this.d;
            if (signalStrength2 != null) {
                fcVar2.f406s = signalStrength2.getCdmaDbm();
            }
            fcVar2.r = false;
            this.m.a((com.loc.fb) fcVar2);
            this.a.add(fcVar2);
        }
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static int b(int i) {
        return (i * 2) - 113;
    }

    @android.annotation.SuppressLint({"NewApi"})
    private void b(boolean z, boolean z2) {
        if (!this.e && this.b != null && android.os.Build.VERSION.SDK_INT >= 29 && this.h.getApplicationInfo().targetSdkVersion >= 29) {
            if (this.q == null) {
                this.q = new com.loc.fd.a();
            }
            try {
                this.b.requestCellInfoUpdate(com.loc.ct.a().b(), this.q);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "Cgi", "refreshCgi");
            }
            if (z2 || z) {
                for (int i = 0; !this.r && i < 20; i++) {
                    try {
                        java.lang.Thread.sleep(5L);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
        this.j = false;
        android.telephony.TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            java.lang.String networkOperator = telephonyManager.getNetworkOperator();
            this.k = networkOperator;
            if (!android.text.TextUtils.isEmpty(networkOperator)) {
                this.j = true;
            }
        }
        this.n = com.loc.gd.b();
    }

    public static /* synthetic */ boolean d(com.loc.fd fdVar) {
        fdVar.r = true;
        return true;
    }

    private void o() {
        if (this.b == null) {
            return;
        }
        p();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: Exception -> 0x0075, TryCatch #0 {Exception -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x0019, B:10:0x0021, B:11:0x0027, B:14:0x0031, B:17:0x003f, B:22:0x004c, B:23:0x004e, B:26:0x0058, B:29:0x005e, B:30:0x0069, B:32:0x006d, B:40:0x0064, B:41:0x0023), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #0 {Exception -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x0019, B:10:0x0021, B:11:0x0027, B:14:0x0031, B:17:0x003f, B:22:0x004c, B:23:0x004e, B:26:0x0058, B:29:0x005e, B:30:0x0069, B:32:0x006d, B:40:0x0064, B:41:0x0023), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0064 A[Catch: Exception -> 0x0075, TryCatch #0 {Exception -> 0x0075, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x000b, B:8:0x0019, B:10:0x0021, B:11:0x0027, B:14:0x0031, B:17:0x003f, B:22:0x004c, B:23:0x004e, B:26:0x0058, B:29:0x005e, B:30:0x0069, B:32:0x006d, B:40:0x0064, B:41:0x0023), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p() {
        android.telephony.PhoneStateListener phoneStateListener;
        int checkSelfPermission;
        int checkSelfPermission2;
        int checkSelfPermission3;
        try {
            if (this.c == null) {
                this.c = new com.loc.fd.b();
            }
            int i = android.os.Build.VERSION.SDK_INT;
            java.lang.String str = "hasFineLocPerm";
            int i2 = 336;
            if (i >= 31) {
                checkSelfPermission3 = this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
                if (checkSelfPermission3 != 0) {
                    this.t = "hasNoFineLocPerm";
                    com.loc.fx.b();
                    i2 = 320;
                    if (i < 31) {
                        checkSelfPermission = this.h.checkSelfPermission(com.anythink.china.common.d.a);
                        boolean z = checkSelfPermission == 0;
                        checkSelfPermission2 = this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
                        boolean z2 = checkSelfPermission2 == 0;
                        if (z && z2) {
                            i2 |= 1024;
                        }
                        com.loc.fx.b();
                        this.f407s = z ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                        if (!z2) {
                            str = "hasNoFineLocPerm";
                        }
                        this.t = str;
                        com.loc.fx.b();
                    } else {
                        com.loc.fx.b();
                        i2 |= 1024;
                    }
                    phoneStateListener = this.c;
                    if (phoneStateListener == null) {
                        this.b.listen(phoneStateListener, i2);
                        this.w = true;
                        return;
                    }
                    return;
                }
                this.t = "hasFineLocPerm";
            }
            com.loc.fx.b();
            if (i < 31) {
            }
            phoneStateListener = this.c;
            if (phoneStateListener == null) {
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private int q() {
        com.loc.fc e = e();
        if (e != null) {
            return e.l;
        }
        return 0;
    }

    private android.telephony.CellLocation r() {
        android.telephony.TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            try {
                android.telephony.CellLocation cellLocation = telephonyManager.getCellLocation();
                com.loc.fx.a();
                this.g = null;
                return cellLocation;
            } catch (java.lang.SecurityException e) {
                this.g = e.getMessage();
            } catch (java.lang.Throwable th) {
                this.g = null;
                com.loc.fv.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private java.util.List<android.telephony.CellInfo> s() {
        android.telephony.TelephonyManager telephonyManager = this.b;
        if (telephonyManager == null) {
            return null;
        }
        java.util.List<android.telephony.CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
        com.loc.fx.a();
        return allCellInfo;
    }

    private boolean t() {
        return !this.e && com.loc.gd.b() - this.n >= 45000;
    }

    private void u() {
        android.telephony.PhoneStateListener phoneStateListener;
        android.telephony.TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null && (phoneStateListener = this.c) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
                this.w = false;
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "CgiManager", "destroy");
            }
        }
        this.c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.telephony.CellLocation v() {
        if (this.b == null) {
            return null;
        }
        return r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"NewApi"})
    public java.util.List<android.telephony.CellInfo> w() {
        java.util.List<android.telephony.CellInfo> list;
        try {
            if (com.loc.gd.c() < 18 || this.b == null) {
                return null;
            }
            try {
                list = s();
                try {
                    this.g = null;
                } catch (java.lang.SecurityException e) {
                    e = e;
                    this.g = e.getMessage();
                    return list;
                }
            } catch (java.lang.SecurityException e2) {
                e = e2;
                list = null;
            }
            return list;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Cgi", "getNewCells");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.util.List<com.loc.eb> a() {
        com.loc.ec ecVar;
        int earfcn;
        int uarfcn;
        int arfcn;
        int bsic;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<android.telephony.CellInfo> s2 = s();
        if (s2 != null) {
            for (android.telephony.CellInfo cellInfo : s2) {
                if (cellInfo instanceof android.telephony.CellInfoCdma) {
                    android.telephony.CellInfoCdma cellInfoCdma = (android.telephony.CellInfoCdma) cellInfo;
                    android.telephony.CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    com.loc.ec ecVar2 = new com.loc.ec(cellInfo.isRegistered(), true);
                    ecVar2.m = cellIdentity.getLatitude();
                    ecVar2.n = cellIdentity.getLongitude();
                    ecVar2.j = cellIdentity.getSystemId();
                    ecVar2.k = cellIdentity.getNetworkId();
                    ecVar2.l = cellIdentity.getBasestationId();
                    ecVar2.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    ecVar2.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    ecVar = ecVar2;
                } else if (cellInfo instanceof android.telephony.CellInfoGsm) {
                    android.telephony.CellInfoGsm cellInfoGsm = (android.telephony.CellInfoGsm) cellInfo;
                    android.telephony.CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    com.loc.ed edVar = new com.loc.ed(cellInfo.isRegistered(), true);
                    edVar.a = java.lang.String.valueOf(cellIdentity2.getMcc());
                    edVar.b = java.lang.String.valueOf(cellIdentity2.getMnc());
                    edVar.j = cellIdentity2.getLac();
                    edVar.k = cellIdentity2.getCid();
                    edVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    edVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        arfcn = cellIdentity2.getArfcn();
                        edVar.m = arfcn;
                        bsic = cellIdentity2.getBsic();
                        edVar.n = bsic;
                    }
                    arrayList.add(edVar);
                } else if (cellInfo instanceof android.telephony.CellInfoLte) {
                    android.telephony.CellInfoLte cellInfoLte = (android.telephony.CellInfoLte) cellInfo;
                    android.telephony.CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    com.loc.ee eeVar = new com.loc.ee(cellInfo.isRegistered());
                    eeVar.a = java.lang.String.valueOf(cellIdentity3.getMcc());
                    eeVar.b = java.lang.String.valueOf(cellIdentity3.getMnc());
                    eeVar.l = cellIdentity3.getPci();
                    eeVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    eeVar.k = cellIdentity3.getCi();
                    eeVar.j = cellIdentity3.getTac();
                    eeVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    eeVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    ecVar = eeVar;
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        earfcn = cellIdentity3.getEarfcn();
                        eeVar.m = earfcn;
                        ecVar = eeVar;
                    }
                } else {
                    int i = android.os.Build.VERSION.SDK_INT;
                    if (cellInfo instanceof android.telephony.CellInfoWcdma) {
                        android.telephony.CellInfoWcdma cellInfoWcdma = (android.telephony.CellInfoWcdma) cellInfo;
                        android.telephony.CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        com.loc.ef efVar = new com.loc.ef(cellInfo.isRegistered(), true);
                        efVar.a = java.lang.String.valueOf(cellIdentity4.getMcc());
                        efVar.b = java.lang.String.valueOf(cellIdentity4.getMnc());
                        efVar.j = cellIdentity4.getLac();
                        efVar.k = cellIdentity4.getCid();
                        efVar.l = cellIdentity4.getPsc();
                        efVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        efVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            uarfcn = cellIdentity4.getUarfcn();
                            efVar.m = uarfcn;
                        }
                        arrayList.add(efVar);
                    }
                }
                arrayList.add(ecVar);
            }
        }
        return arrayList;
    }

    public final void a(com.loc.eu euVar) {
        this.x = euVar;
    }

    public final synchronized void a(java.util.List<android.telephony.CellInfo> list) {
        java.util.ArrayList<com.loc.fc> arrayList = this.l;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                android.telephony.CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    boolean isRegistered = cellInfo.isRegistered();
                    com.loc.fc a2 = cellInfo instanceof android.telephony.CellInfoCdma ? a((android.telephony.CellInfoCdma) cellInfo, isRegistered) : cellInfo instanceof android.telephony.CellInfoGsm ? a((android.telephony.CellInfoGsm) cellInfo, isRegistered) : cellInfo instanceof android.telephony.CellInfoWcdma ? a((android.telephony.CellInfoWcdma) cellInfo, isRegistered) : cellInfo instanceof android.telephony.CellInfoLte ? a((android.telephony.CellInfoLte) cellInfo, isRegistered) : (android.os.Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof android.telephony.CellInfoNr)) ? null : a((android.telephony.CellInfoNr) cellInfo, isRegistered);
                    if (a2 != null) {
                        this.m.a((com.loc.fb) a2);
                        a2.m = (short) java.lang.Math.min(65535L, this.m.e((com.loc.fb) a2));
                        a2.r = true;
                        this.l.add(a2);
                    }
                }
            }
            this.i = false;
            java.util.ArrayList<com.loc.fc> arrayList2 = this.l;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.i = true;
            }
        }
    }

    public final void a(boolean z) {
        this.m.a(z);
        this.n = 0L;
        synchronized (this.p) {
            this.o = true;
        }
        u();
        this.d = null;
        this.b = null;
    }

    public final void a(boolean z, boolean z2) {
        try {
            this.e = com.loc.gd.a(this.h);
            if (t()) {
                b(z, z2);
                a(v());
                a(w());
            }
            if (this.e) {
                j();
            }
        } catch (java.lang.SecurityException e) {
            this.g = e.getMessage();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "CgiManager", com.alipay.sdk.m.x.d.w);
        }
    }

    public final void b() {
        int checkSelfPermission;
        int checkSelfPermission2;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 31) {
                checkSelfPermission = this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION");
                java.lang.String str = checkSelfPermission == 0 ? "hasFineLocPerm" : "hasNoFineLocPerm";
                checkSelfPermission2 = this.h.checkSelfPermission(com.anythink.china.common.d.a);
                java.lang.String str2 = checkSelfPermission2 == 0 ? "hasReadPhoneStatePerm" : "hasNoReadPhoneStatePerm";
                boolean z = true;
                boolean z2 = (android.text.TextUtils.isEmpty(this.t) || this.t.equals(str)) ? false : true;
                if (android.text.TextUtils.isEmpty(this.f407s) || this.f407s.equals(str2)) {
                    z = z2;
                }
                if (z) {
                    com.loc.fx.b();
                    p();
                }
            }
        } catch (java.lang.Throwable unused) {
            com.loc.fx.b();
        }
    }

    public final void b(boolean z) {
        this.u = z;
        if (this.v) {
            return;
        }
        if (z && !this.w) {
            p();
        } else {
            if (z || !this.w) {
                return;
            }
            u();
        }
    }

    public final synchronized java.util.ArrayList<com.loc.fc> c() {
        java.util.ArrayList<com.loc.fc> arrayList;
        arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<com.loc.fc> arrayList2 = this.a;
        if (arrayList2 != null) {
            java.util.Iterator<com.loc.fc> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final void c(boolean z) {
        this.v = z;
    }

    public final synchronized java.util.ArrayList<com.loc.fc> d() {
        java.util.ArrayList<com.loc.fc> arrayList;
        arrayList = new java.util.ArrayList<>();
        java.util.ArrayList<com.loc.fc> arrayList2 = this.l;
        if (arrayList2 != null) {
            java.util.Iterator<com.loc.fc> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().clone());
            }
        }
        return arrayList;
    }

    public final synchronized com.loc.fc e() {
        if (this.e) {
            return null;
        }
        java.util.ArrayList<com.loc.fc> arrayList = this.a;
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList.get(0).clone();
    }

    public final synchronized com.loc.fc f() {
        if (this.e) {
            return null;
        }
        java.util.ArrayList<com.loc.fc> arrayList = this.l;
        if (arrayList.size() <= 0) {
            return null;
        }
        java.util.Iterator<com.loc.fc> it = arrayList.iterator();
        while (it.hasNext()) {
            com.loc.fc next = it.next();
            if (next.n) {
                return next.clone();
            }
        }
        return arrayList.get(0).clone();
    }

    public final int g() {
        return q() | (this.i ? 4 : 0) | (this.j ? 8 : 0);
    }

    public final int h() {
        return q() & 3;
    }

    public final android.telephony.TelephonyManager i() {
        return this.b;
    }

    public final synchronized void j() {
        this.g = null;
        this.a.clear();
        this.l.clear();
        this.i = false;
        this.j = false;
    }

    public final java.lang.String k() {
        return this.g;
    }

    public final java.lang.String l() {
        return this.k;
    }

    public final synchronized java.lang.String m() {
        if (this.e) {
            j();
        }
        java.lang.StringBuilder sb = this.f;
        if (sb == null) {
            this.f = new java.lang.StringBuilder();
        } else {
            sb.delete(0, sb.length());
        }
        if (h() == 1) {
            for (int i = 1; i < this.a.size(); i++) {
                java.lang.StringBuilder sb2 = this.f;
                sb2.append("#");
                sb2.append(this.a.get(i).b);
                java.lang.StringBuilder sb3 = this.f;
                sb3.append("|");
                sb3.append(this.a.get(i).c);
                java.lang.StringBuilder sb4 = this.f;
                sb4.append("|");
                sb4.append(this.a.get(i).d);
            }
        }
        for (int i2 = 1; i2 < this.l.size(); i2++) {
            com.loc.fc fcVar = this.l.get(i2);
            int i3 = fcVar.l;
            if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
                if (i3 == 2) {
                    java.lang.StringBuilder sb5 = this.f;
                    sb5.append("#");
                    sb5.append(fcVar.l);
                    java.lang.StringBuilder sb6 = this.f;
                    sb6.append("|");
                    sb6.append(fcVar.a);
                    java.lang.StringBuilder sb7 = this.f;
                    sb7.append("|");
                    sb7.append(fcVar.h);
                    java.lang.StringBuilder sb8 = this.f;
                    sb8.append("|");
                    sb8.append(fcVar.i);
                    java.lang.StringBuilder sb9 = this.f;
                    sb9.append("|");
                    sb9.append(fcVar.j);
                }
            }
            java.lang.StringBuilder sb10 = this.f;
            sb10.append("#");
            sb10.append(fcVar.l);
            java.lang.StringBuilder sb11 = this.f;
            sb11.append("|");
            sb11.append(fcVar.a);
            java.lang.StringBuilder sb12 = this.f;
            sb12.append("|");
            sb12.append(fcVar.b);
            java.lang.StringBuilder sb13 = this.f;
            sb13.append("|");
            sb13.append(fcVar.c);
            java.lang.StringBuilder sb14 = this.f;
            sb14.append("|");
            sb14.append(fcVar.a());
        }
        if (this.f.length() > 0) {
            this.f.deleteCharAt(0);
        }
        return this.f.toString();
    }

    public final boolean n() {
        try {
            android.telephony.TelephonyManager telephonyManager = this.b;
            if (telephonyManager != null) {
                if (!android.text.TextUtils.isEmpty(telephonyManager.getSimOperator())) {
                    return true;
                }
                if (!android.text.TextUtils.isEmpty(this.b.getSimCountryIso())) {
                    return true;
                }
            }
        } catch (java.lang.Throwable unused) {
        }
        try {
            int a2 = com.loc.gd.a(com.loc.gd.c(this.h));
            return a2 == 0 || a2 == 4 || a2 == 2 || a2 == 5 || a2 == 3;
        } catch (java.lang.Throwable unused2) {
            return false;
        }
    }
}

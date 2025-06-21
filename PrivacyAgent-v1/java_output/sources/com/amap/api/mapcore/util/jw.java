package com.amap.api.mapcore.util;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes12.dex */
public final class jw {
    private static int r;
    private static boolean v;
    android.telephony.TelephonyManager d;
    android.telephony.CellLocation f;
    private android.content.Context l;
    private com.amap.api.mapcore.util.ju p;
    private java.lang.Object q;

    @android.annotation.SuppressLint({"NewApi"})
    private android.telephony.TelephonyManager.CellInfoCallback t;
    private com.amap.api.mapcore.util.jt w;
    int a = 0;
    java.util.ArrayList<com.amap.api.mapcore.util.jv> b = new java.util.ArrayList<>();
    java.util.ArrayList<com.amap.api.mapcore.util.jn> c = new java.util.ArrayList<>();
    private java.lang.String m = null;
    private java.util.ArrayList<com.amap.api.mapcore.util.jv> n = new java.util.ArrayList<>();
    private int o = -113;
    long e = 0;

    /* renamed from: s, reason: collision with root package name */
    private long f137s = 0;
    boolean g = false;
    android.telephony.PhoneStateListener h = null;
    private boolean u = false;
    java.lang.String i = null;
    boolean j = false;
    java.lang.StringBuilder k = null;
    private boolean x = false;
    private java.lang.Object y = new java.lang.Object();

    /* renamed from: com.amap.api.mapcore.util.jw$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.amap.api.mapcore.util.jw.this.y) {
                if (!com.amap.api.mapcore.util.jw.this.x) {
                    com.amap.api.mapcore.util.jw.this.l();
                }
            }
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public class a extends android.telephony.TelephonyManager.CellInfoCallback {
        public a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(java.util.List<android.telephony.CellInfo> list) {
            try {
                com.amap.api.mapcore.util.jw.d(com.amap.api.mapcore.util.jw.this);
                android.telephony.CellLocation a = com.amap.api.mapcore.util.jw.this.a(list);
                if (a != null) {
                    com.amap.api.mapcore.util.jw jwVar = com.amap.api.mapcore.util.jw.this;
                    jwVar.f = a;
                    jwVar.g = true;
                    jwVar.s();
                    com.amap.api.mapcore.util.jw.this.f137s = com.amap.api.mapcore.util.ix.b();
                }
                com.amap.api.mapcore.util.jw.this.q();
            } catch (java.lang.SecurityException e) {
                com.amap.api.mapcore.util.jw.this.i = e.getMessage();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "Cgi", "cellInfo");
            }
        }
    }

    public class b extends android.telephony.PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(java.util.List<android.telephony.CellInfo> list) {
            try {
                if (com.amap.api.mapcore.util.jw.this.w != null) {
                    com.amap.api.mapcore.util.jw.this.w.a();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(android.telephony.CellLocation cellLocation) {
            try {
                if (com.amap.api.mapcore.util.jw.this.a(cellLocation)) {
                    com.amap.api.mapcore.util.jw jwVar = com.amap.api.mapcore.util.jw.this;
                    jwVar.f = cellLocation;
                    jwVar.g = true;
                    jwVar.s();
                    com.amap.api.mapcore.util.jw.this.f137s = com.amap.api.mapcore.util.ix.b();
                    com.amap.api.mapcore.util.jw.this.q();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(android.telephony.ServiceState serviceState) {
            try {
                int state = serviceState.getState();
                if (state == 0) {
                    com.amap.api.mapcore.util.jw.this.b();
                } else {
                    if (state != 1) {
                        return;
                    }
                    com.amap.api.mapcore.util.jw.this.i();
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int i) {
            try {
                int i2 = com.amap.api.mapcore.util.jw.this.a;
                com.amap.api.mapcore.util.jw.this.b((i2 == 1 || i2 == 2) ? com.amap.api.mapcore.util.ix.a(i) : -113);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) {
            if (signalStrength == null) {
                return;
            }
            try {
                int i = com.amap.api.mapcore.util.jw.this.a;
                com.amap.api.mapcore.util.jw.this.b(i != 1 ? i != 2 ? -113 : signalStrength.getCdmaDbm() : com.amap.api.mapcore.util.ix.a(signalStrength.getGsmSignalStrength()));
                if (com.amap.api.mapcore.util.jw.this.w != null) {
                    com.amap.api.mapcore.util.jw.this.w.a();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public jw(android.content.Context context) {
        this.d = null;
        this.p = null;
        this.l = context;
        this.d = (android.telephony.TelephonyManager) com.amap.api.mapcore.util.ix.a(context, com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        k();
        this.p = new com.amap.api.mapcore.util.ju();
    }

    private android.telephony.CellLocation a(java.lang.Object obj, java.lang.String str, java.lang.Object... objArr) {
        android.telephony.CellLocation cellLocation;
        if (obj == null) {
            return null;
        }
        try {
            java.lang.Object a2 = com.amap.api.mapcore.util.iv.a(obj, str, objArr);
            cellLocation = a2 != null ? (android.telephony.CellLocation) a2 : null;
        } catch (java.lang.Throwable unused) {
        }
        if (b(cellLocation)) {
            return cellLocation;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"NewApi"})
    public synchronized android.telephony.CellLocation a(java.util.List<android.telephony.CellInfo> list) {
        android.telephony.gsm.GsmCellLocation gsmCellLocation;
        android.telephony.gsm.GsmCellLocation gsmCellLocation2;
        android.telephony.gsm.GsmCellLocation gsmCellLocation3 = null;
        if (list != null) {
            if (!list.isEmpty()) {
                com.amap.api.mapcore.util.jv jvVar = null;
                for (int i = 0; i < list.size(); i++) {
                    android.telephony.CellInfo cellInfo = list.get(i);
                    if (cellInfo != null) {
                        try {
                            jvVar = a(cellInfo);
                            if (jvVar != null) {
                                break;
                            }
                        } catch (java.lang.Throwable unused) {
                            continue;
                        }
                    }
                }
                if (jvVar != null) {
                    try {
                        if (jvVar.l == 2) {
                            android.telephony.cdma.CdmaCellLocation cdmaCellLocation = new android.telephony.cdma.CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(jvVar.j, jvVar.f, jvVar.g, jvVar.h, jvVar.i);
                                gsmCellLocation = cdmaCellLocation;
                            } catch (java.lang.Throwable unused2) {
                                gsmCellLocation = cdmaCellLocation;
                            }
                        } else {
                            gsmCellLocation2 = new android.telephony.gsm.GsmCellLocation();
                            try {
                                gsmCellLocation2.setLacAndCid(jvVar.c, jvVar.d);
                            } catch (java.lang.Throwable unused3) {
                                gsmCellLocation3 = gsmCellLocation2;
                                gsmCellLocation = null;
                            }
                        }
                    } catch (java.lang.Throwable unused4) {
                        gsmCellLocation = gsmCellLocation3;
                    }
                    android.telephony.gsm.GsmCellLocation gsmCellLocation4 = gsmCellLocation3;
                    gsmCellLocation3 = gsmCellLocation;
                    gsmCellLocation2 = gsmCellLocation4;
                } else {
                    gsmCellLocation2 = null;
                }
                return gsmCellLocation3 == null ? gsmCellLocation2 : gsmCellLocation3;
            }
        }
        return null;
    }

    private static com.amap.api.mapcore.util.jv a(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        com.amap.api.mapcore.util.jv jvVar = new com.amap.api.mapcore.util.jv(i, z);
        jvVar.a = i2;
        jvVar.b = i3;
        jvVar.c = i4;
        jvVar.d = i5;
        jvVar.k = i6;
        return jvVar;
    }

    private com.amap.api.mapcore.util.jv a(android.telephony.CellInfo cellInfo) {
        boolean isRegistered = cellInfo.isRegistered();
        if (cellInfo instanceof android.telephony.CellInfoCdma) {
            return a((android.telephony.CellInfoCdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof android.telephony.CellInfoGsm) {
            return a((android.telephony.CellInfoGsm) cellInfo, isRegistered);
        }
        if (cellInfo instanceof android.telephony.CellInfoWcdma) {
            return a((android.telephony.CellInfoWcdma) cellInfo, isRegistered);
        }
        if (cellInfo instanceof android.telephony.CellInfoLte) {
            return a((android.telephony.CellInfoLte) cellInfo, isRegistered);
        }
        if (android.os.Build.VERSION.SDK_INT < 29 || !(cellInfo instanceof android.telephony.CellInfoNr)) {
            return null;
        }
        return a((android.telephony.CellInfoNr) cellInfo, isRegistered);
    }

    private com.amap.api.mapcore.util.jv a(android.telephony.CellInfoCdma cellInfoCdma, boolean z) {
        int i;
        int i2;
        int i3;
        if (cellInfoCdma != null && cellInfoCdma.getCellIdentity() != null) {
            android.telephony.CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
            if (cellIdentity.getSystemId() > 0 && cellIdentity.getNetworkId() >= 0 && cellIdentity.getBasestationId() >= 0) {
                android.telephony.CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                java.lang.String[] a2 = com.amap.api.mapcore.util.ix.a(this.d);
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
                    com.amap.api.mapcore.util.jv a3 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                    a3.h = cellIdentity2.getSystemId();
                    a3.i = cellIdentity2.getNetworkId();
                    a3.j = cellIdentity2.getBasestationId();
                    a3.f = cellIdentity2.getLatitude();
                    a3.g = cellIdentity2.getLongitude();
                    return a3;
                }
                com.amap.api.mapcore.util.jv a32 = a(2, z, i2, i3, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                a32.h = cellIdentity2.getSystemId();
                a32.i = cellIdentity2.getNetworkId();
                a32.j = cellIdentity2.getBasestationId();
                a32.f = cellIdentity2.getLatitude();
                a32.g = cellIdentity2.getLongitude();
                return a32;
            }
        }
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    private static com.amap.api.mapcore.util.jv a(android.telephony.CellInfoGsm cellInfoGsm, boolean z) {
        int bsic;
        int arfcn;
        int timingAdvance;
        if (cellInfoGsm != null && cellInfoGsm.getCellIdentity() != null) {
            android.telephony.CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                com.amap.api.mapcore.util.jv a2 = a(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
                bsic = cellInfoGsm.getCellIdentity().getBsic();
                a2.p = bsic;
                arfcn = cellInfoGsm.getCellIdentity().getArfcn();
                a2.q = arfcn;
                timingAdvance = cellInfoGsm.getCellSignalStrength().getTimingAdvance();
                a2.r = timingAdvance;
                return a2;
            }
        }
        return null;
    }

    private static com.amap.api.mapcore.util.jv a(android.telephony.CellInfoLte cellInfoLte, boolean z) {
        int earfcn;
        if (cellInfoLte != null && cellInfoLte.getCellIdentity() != null) {
            android.telephony.CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
            if (c(cellIdentity.getTac()) && d(cellIdentity.getCi())) {
                com.amap.api.mapcore.util.jv a2 = a(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
                a2.p = cellIdentity.getPci();
                earfcn = cellIdentity.getEarfcn();
                a2.q = earfcn;
                a2.r = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                return a2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.amap.api.mapcore.util.jv a(android.telephony.CellInfoNr cellInfoNr, boolean z) {
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
                tac = com.amap.api.mapcore.util.iv.b(cellIdentityNr, "getHwTac", new java.lang.Object[0]);
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
                com.amap.api.mapcore.util.jv a2 = a(5, z, i2, i3, tac2, 0, ssRsrp);
                a2.e = nci;
                if (tac <= 16777215) {
                }
                pci = cellIdentityNr.getPci();
                a2.p = pci;
                nrarfcn = cellIdentityNr.getNrarfcn();
                a2.q = nrarfcn;
                return a2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            i = 0;
        }
        cellSignalStrength = cellInfoNr.getCellSignalStrength();
        ssRsrp = ((android.telephony.CellSignalStrengthNr) cellSignalStrength).getSsRsrp();
        tac2 = cellIdentityNr.getTac();
        com.amap.api.mapcore.util.jv a22 = a(5, z, i2, i3, tac2, 0, ssRsrp);
        a22.e = nci;
        if (tac <= 16777215) {
            a22.c = 65535;
        } else if (tac > 65535) {
            a22.c = 65535;
            a22.r = tac;
        } else {
            a22.c = tac;
        }
        pci = cellIdentityNr.getPci();
        a22.p = pci;
        nrarfcn = cellIdentityNr.getNrarfcn();
        a22.q = nrarfcn;
        return a22;
    }

    private static com.amap.api.mapcore.util.jv a(android.telephony.CellInfoWcdma cellInfoWcdma, boolean z) {
        int uarfcn;
        if (cellInfoWcdma != null && cellInfoWcdma.getCellIdentity() != null) {
            android.telephony.CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
            if (c(cellIdentity.getLac()) && d(cellIdentity.getCid())) {
                com.amap.api.mapcore.util.jv a2 = a(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
                a2.p = cellIdentity.getPsc();
                uarfcn = cellInfoWcdma.getCellIdentity().getUarfcn();
                a2.q = uarfcn;
                return a2;
            }
        }
        return null;
    }

    private com.amap.api.mapcore.util.jv a(android.telephony.CellLocation cellLocation, java.lang.String[] strArr) {
        android.telephony.gsm.GsmCellLocation gsmCellLocation = (android.telephony.gsm.GsmCellLocation) cellLocation;
        com.amap.api.mapcore.util.jv jvVar = new com.amap.api.mapcore.util.jv(1, true);
        jvVar.a = com.amap.api.mapcore.util.ix.d(strArr[0]);
        jvVar.b = com.amap.api.mapcore.util.ix.d(strArr[1]);
        jvVar.c = gsmCellLocation.getLac();
        jvVar.d = gsmCellLocation.getCid();
        jvVar.k = this.o;
        return jvVar;
    }

    private static com.amap.api.mapcore.util.jv a(android.telephony.NeighboringCellInfo neighboringCellInfo, java.lang.String[] strArr) {
        try {
            com.amap.api.mapcore.util.jv jvVar = new com.amap.api.mapcore.util.jv(1, false);
            jvVar.a = java.lang.Integer.parseInt(strArr[0]);
            jvVar.b = java.lang.Integer.parseInt(strArr[1]);
            jvVar.c = com.amap.api.mapcore.util.iv.b(neighboringCellInfo, "getLac", new java.lang.Object[0]);
            jvVar.d = neighboringCellInfo.getCid();
            jvVar.k = com.amap.api.mapcore.util.ix.a(neighboringCellInfo.getRssi());
            return jvVar;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    public static boolean a(int i) {
        return i > 0 && i <= 15;
    }

    private static boolean a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i) {
        java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList;
        if (i == -113) {
            this.o = -113;
            return;
        }
        this.o = i;
        int i2 = this.a;
        if ((i2 == 1 || i2 == 2) && (arrayList = this.b) != null && !arrayList.isEmpty()) {
            try {
                this.b.get(0).k = this.o;
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private synchronized void b(android.telephony.CellLocation cellLocation, java.lang.String[] strArr) {
        com.amap.api.mapcore.util.jv a2;
        if (cellLocation != null) {
            if (this.d != null) {
                this.b.clear();
                if (b(cellLocation)) {
                    this.a = 1;
                    this.b.add(a(cellLocation, strArr));
                    if (android.os.Build.VERSION.SDK_INT <= 28) {
                        java.util.List<android.telephony.NeighboringCellInfo> list = (java.util.List) com.amap.api.mapcore.util.iv.a(this.d, "getNeighboringCellInfo", new java.lang.Object[0]);
                        if (list != null && !list.isEmpty()) {
                            for (android.telephony.NeighboringCellInfo neighboringCellInfo : list) {
                                if (neighboringCellInfo != null && a(neighboringCellInfo.getLac(), neighboringCellInfo.getCid()) && (a2 = a(neighboringCellInfo, strArr)) != null && !this.b.contains(a2)) {
                                    this.b.add(a2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean b(android.telephony.CellLocation cellLocation) {
        boolean a2 = a(cellLocation);
        if (!a2) {
            this.a = 0;
        }
        return a2;
    }

    private int c(android.telephony.CellLocation cellLocation) {
        if (this.j || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof android.telephony.gsm.GsmCellLocation) {
            return 1;
        }
        try {
            java.lang.Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(android.telephony.CellLocation cellLocation, java.lang.String[] strArr) {
        boolean z;
        android.telephony.gsm.GsmCellLocation gsmCellLocation;
        if (cellLocation == null) {
            return;
        }
        this.b.clear();
        try {
            boolean z2 = true;
            if (this.q != null) {
                try {
                    java.lang.reflect.Field declaredField = cellLocation.getClass().getDeclaredField("mGsmCellLoc");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    gsmCellLocation = (android.telephony.gsm.GsmCellLocation) declaredField.get(cellLocation);
                } catch (java.lang.Throwable unused) {
                }
                if (gsmCellLocation != null && b(gsmCellLocation)) {
                    b(gsmCellLocation, strArr);
                    z = true;
                    if (z) {
                        return;
                    }
                }
                z = false;
                if (z) {
                }
            }
            if (b(cellLocation)) {
                this.a = 2;
                com.amap.api.mapcore.util.jv jvVar = new com.amap.api.mapcore.util.jv(2, true);
                jvVar.a = java.lang.Integer.parseInt(strArr[0]);
                jvVar.b = java.lang.Integer.parseInt(strArr[1]);
                jvVar.h = com.amap.api.mapcore.util.iv.b(cellLocation, "getSystemId", new java.lang.Object[0]);
                jvVar.i = com.amap.api.mapcore.util.iv.b(cellLocation, "getNetworkId", new java.lang.Object[0]);
                jvVar.j = com.amap.api.mapcore.util.iv.b(cellLocation, "getBaseStationId", new java.lang.Object[0]);
                jvVar.k = this.o;
                jvVar.f = com.amap.api.mapcore.util.iv.b(cellLocation, "getBaseStationLatitude", new java.lang.Object[0]);
                int b2 = com.amap.api.mapcore.util.iv.b(cellLocation, "getBaseStationLongitude", new java.lang.Object[0]);
                jvVar.g = b2;
                int i = jvVar.f;
                if (i != b2 || i <= 0) {
                    z2 = false;
                }
                if (i < 0 || b2 < 0 || i == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE || z2) {
                    jvVar.f = 0;
                    jvVar.g = 0;
                }
                if (this.b.contains(jvVar)) {
                    return;
                }
                this.b.add(jvVar);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "CgiManager", "hdlCdmaLocChange");
        }
    }

    private static boolean c(int i) {
        return (i == -1 || i == 0 || i > 65535) ? false : true;
    }

    private static boolean d(int i) {
        return (i == -1 || i == 0 || i == 65535 || i >= 268435455) ? false : true;
    }

    public static /* synthetic */ boolean d(com.amap.api.mapcore.util.jw jwVar) {
        jwVar.u = true;
        return true;
    }

    private void k() {
        java.lang.Object a2;
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            return;
        }
        try {
            this.a = c(telephonyManager.getCellLocation());
        } catch (java.lang.SecurityException e) {
            this.i = e.getMessage();
        } catch (java.lang.Throwable th) {
            this.i = null;
            com.amap.api.mapcore.util.it.a(th, "CgiManager", "CgiManager");
            this.a = 0;
        }
        try {
            int i = r;
            if (i != 1) {
                a2 = com.amap.api.mapcore.util.ix.a(i != 2 ? this.l : this.l, "phone2");
            } else {
                a2 = com.amap.api.mapcore.util.ix.a(this.l, "phone_msim");
            }
            this.q = a2;
        } catch (java.lang.Throwable unused) {
        }
        com.amap.api.mapcore.util.gd.d().submit(new com.amap.api.mapcore.util.jw.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int i;
        this.h = new com.amap.api.mapcore.util.jw.b();
        try {
            i = com.amap.api.mapcore.util.iv.b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (java.lang.Throwable unused) {
            i = 0;
        }
        if (i == 0) {
            try {
                this.d.listen(this.h, 16);
            } catch (java.lang.Throwable unused2) {
            }
        } else {
            try {
                this.d.listen(this.h, i | 16);
            } catch (java.lang.Throwable unused3) {
            }
        }
    }

    private android.telephony.CellLocation m() {
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            try {
                android.telephony.CellLocation cellLocation = telephonyManager.getCellLocation();
                this.i = null;
                if (b(cellLocation)) {
                    this.f = cellLocation;
                    return cellLocation;
                }
            } catch (java.lang.SecurityException e) {
                this.i = e.getMessage();
            } catch (java.lang.Throwable th) {
                this.i = null;
                com.amap.api.mapcore.util.it.a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    private boolean n() {
        return !this.j && com.amap.api.mapcore.util.ix.b() - this.e >= 10000;
    }

    private void o() {
        i();
    }

    private synchronized void p() {
        int f = f();
        if (f != 1) {
            if (f == 2 && this.b.isEmpty()) {
                this.a = 0;
            }
        } else if (this.b.isEmpty()) {
            this.a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList = this.n;
        if (arrayList != null && arrayList.size() > 0) {
            this.a |= 4;
        }
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            java.lang.String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (android.text.TextUtils.isEmpty(networkOperator)) {
                return;
            }
            this.a |= 8;
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    private synchronized void r() {
        if (!this.j && this.d != null) {
            if (android.os.Build.VERSION.SDK_INT >= 29 && this.l.getApplicationInfo().targetSdkVersion >= 29) {
                if (this.t == null) {
                    this.t = new com.amap.api.mapcore.util.jw.a();
                }
                this.d.requestCellInfoUpdate(com.amap.api.mapcore.util.gd.d(), this.t);
            }
            android.telephony.CellLocation t = t();
            if (!b(t)) {
                t = u();
            }
            if (b(t)) {
                this.f = t;
                this.f137s = com.amap.api.mapcore.util.ix.b();
            } else if (com.amap.api.mapcore.util.ix.b() - this.f137s > 60000) {
                this.f = null;
                this.b.clear();
                this.n.clear();
            }
        }
        this.g = true;
        if (b(this.f)) {
            s();
        }
        try {
            if (com.amap.api.mapcore.util.ix.c() >= 18) {
                w();
            }
        } catch (java.lang.Throwable unused) {
        }
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null) {
            java.lang.String networkOperator = telephonyManager.getNetworkOperator();
            this.m = networkOperator;
            if (!android.text.TextUtils.isEmpty(networkOperator)) {
                this.a |= 8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s() {
        java.lang.String[] a2 = com.amap.api.mapcore.util.ix.a(this.d);
        int c = c(this.f);
        if (c == 1) {
            b(this.f, a2);
        } else {
            if (c == 2) {
                c(this.f, a2);
            }
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    private android.telephony.CellLocation t() {
        android.telephony.TelephonyManager telephonyManager = this.d;
        android.telephony.CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        if (com.amap.api.mapcore.util.ix.c() >= 18) {
            try {
                cellLocation = a(telephonyManager.getAllCellInfo());
            } catch (java.lang.SecurityException e) {
                this.i = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        android.telephony.CellLocation m = m();
        if (b(m)) {
            return m;
        }
        android.telephony.CellLocation a2 = a(telephonyManager, "getCellLocationExt", 1);
        return a2 != null ? a2 : a(telephonyManager, "getCellLocationGemini", 1);
    }

    private android.telephony.CellLocation u() {
        if (!v) {
            v = true;
        }
        java.lang.Object obj = this.q;
        android.telephony.CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            java.lang.Class<?> v2 = v();
            if (v2.isInstance(obj)) {
                java.lang.Object cast = v2.cast(obj);
                android.telephony.CellLocation a2 = a(cast, "getCellLocation", new java.lang.Object[0]);
                if (a2 != null) {
                    return a2;
                }
                android.telephony.CellLocation a3 = a(cast, "getCellLocation", 1);
                if (a3 != null) {
                    return a3;
                }
                android.telephony.CellLocation a4 = a(cast, "getCellLocationGemini", 1);
                if (a4 != null) {
                    return a4;
                }
                cellLocation = a(cast, "getAllCellInfo", 1);
                if (cellLocation != null) {
                    return cellLocation;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "CgiManager", "getSim2Cgi");
        }
        return cellLocation;
    }

    private static java.lang.Class<?> v() {
        java.lang.ClassLoader systemClassLoader = java.lang.ClassLoader.getSystemClassLoader();
        int i = r;
        try {
            return systemClassLoader.loadClass(i != 0 ? i != 1 ? i != 2 ? null : "android.telephony.TelephonyManager2" : "android.telephony.MSimTelephonyManager" : "android.telephony.TelephonyManager");
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void w() {
        java.lang.SecurityException e;
        java.util.List<android.telephony.CellInfo> list;
        int size;
        int i;
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager == null) {
            return;
        }
        java.util.ArrayList<com.amap.api.mapcore.util.jv> arrayList = this.n;
        com.amap.api.mapcore.util.ju juVar = this.p;
        try {
            list = telephonyManager.getAllCellInfo();
            try {
                this.i = null;
            } catch (java.lang.SecurityException e2) {
                e = e2;
                this.i = e.getMessage();
                if (list != null) {
                    if (arrayList != null) {
                    }
                    while (i < size) {
                    }
                }
                if (arrayList != null) {
                    return;
                } else {
                    return;
                }
            }
        } catch (java.lang.SecurityException e3) {
            e = e3;
            list = null;
        }
        if (list != null && (size = list.size()) != 0) {
            if (arrayList != null) {
                arrayList.clear();
            }
            for (i = 0; i < size; i++) {
                android.telephony.CellInfo cellInfo = list.get(i);
                if (cellInfo != null) {
                    try {
                        com.amap.api.mapcore.util.jv a2 = a(cellInfo);
                        if (a2 != null) {
                            a2.m = (short) java.lang.Math.min(65535L, juVar.a(a2));
                            arrayList.add(a2);
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
        if (arrayList != null || arrayList.size() <= 0) {
            return;
        }
        this.a |= 4;
        juVar.a(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final java.util.List<com.amap.api.mapcore.util.jn> a() {
        com.amap.api.mapcore.util.jo joVar;
        int earfcn;
        int uarfcn;
        int arfcn;
        int bsic;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<android.telephony.CellInfo> allCellInfo = this.d.getAllCellInfo();
        if (allCellInfo != null) {
            for (android.telephony.CellInfo cellInfo : allCellInfo) {
                if (cellInfo instanceof android.telephony.CellInfoCdma) {
                    android.telephony.CellInfoCdma cellInfoCdma = (android.telephony.CellInfoCdma) cellInfo;
                    android.telephony.CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                    com.amap.api.mapcore.util.jo joVar2 = new com.amap.api.mapcore.util.jo(cellInfo.isRegistered(), true);
                    joVar2.m = cellIdentity.getLatitude();
                    joVar2.n = cellIdentity.getLongitude();
                    joVar2.j = cellIdentity.getSystemId();
                    joVar2.k = cellIdentity.getNetworkId();
                    joVar2.l = cellIdentity.getBasestationId();
                    joVar2.d = cellInfoCdma.getCellSignalStrength().getAsuLevel();
                    joVar2.c = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                    joVar = joVar2;
                } else if (cellInfo instanceof android.telephony.CellInfoGsm) {
                    android.telephony.CellInfoGsm cellInfoGsm = (android.telephony.CellInfoGsm) cellInfo;
                    android.telephony.CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                    com.amap.api.mapcore.util.jp jpVar = new com.amap.api.mapcore.util.jp(cellInfo.isRegistered(), true);
                    jpVar.a = java.lang.String.valueOf(cellIdentity2.getMcc());
                    jpVar.b = java.lang.String.valueOf(cellIdentity2.getMnc());
                    jpVar.j = cellIdentity2.getLac();
                    jpVar.k = cellIdentity2.getCid();
                    jpVar.c = cellInfoGsm.getCellSignalStrength().getDbm();
                    jpVar.d = cellInfoGsm.getCellSignalStrength().getAsuLevel();
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        arfcn = cellIdentity2.getArfcn();
                        jpVar.m = arfcn;
                        bsic = cellIdentity2.getBsic();
                        jpVar.n = bsic;
                    }
                    arrayList.add(jpVar);
                } else if (cellInfo instanceof android.telephony.CellInfoLte) {
                    android.telephony.CellInfoLte cellInfoLte = (android.telephony.CellInfoLte) cellInfo;
                    android.telephony.CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                    com.amap.api.mapcore.util.jq jqVar = new com.amap.api.mapcore.util.jq(cellInfo.isRegistered());
                    jqVar.a = java.lang.String.valueOf(cellIdentity3.getMcc());
                    jqVar.b = java.lang.String.valueOf(cellIdentity3.getMnc());
                    jqVar.l = cellIdentity3.getPci();
                    jqVar.d = cellInfoLte.getCellSignalStrength().getAsuLevel();
                    jqVar.k = cellIdentity3.getCi();
                    jqVar.j = cellIdentity3.getTac();
                    jqVar.n = cellInfoLte.getCellSignalStrength().getTimingAdvance();
                    jqVar.c = cellInfoLte.getCellSignalStrength().getDbm();
                    joVar = jqVar;
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        earfcn = cellIdentity3.getEarfcn();
                        jqVar.m = earfcn;
                        joVar = jqVar;
                    }
                } else {
                    int i = android.os.Build.VERSION.SDK_INT;
                    if (cellInfo instanceof android.telephony.CellInfoWcdma) {
                        android.telephony.CellInfoWcdma cellInfoWcdma = (android.telephony.CellInfoWcdma) cellInfo;
                        android.telephony.CellIdentityWcdma cellIdentity4 = cellInfoWcdma.getCellIdentity();
                        com.amap.api.mapcore.util.jr jrVar = new com.amap.api.mapcore.util.jr(cellInfo.isRegistered(), true);
                        jrVar.a = java.lang.String.valueOf(cellIdentity4.getMcc());
                        jrVar.b = java.lang.String.valueOf(cellIdentity4.getMnc());
                        jrVar.j = cellIdentity4.getLac();
                        jrVar.k = cellIdentity4.getCid();
                        jrVar.l = cellIdentity4.getPsc();
                        jrVar.d = cellInfoWcdma.getCellSignalStrength().getAsuLevel();
                        jrVar.c = cellInfoWcdma.getCellSignalStrength().getDbm();
                        if (i >= 24) {
                            uarfcn = cellIdentity4.getUarfcn();
                            jrVar.m = uarfcn;
                        }
                        arrayList.add(jrVar);
                    }
                }
                arrayList.add(joVar);
            }
        }
        return arrayList;
    }

    public final boolean a(android.telephony.CellLocation cellLocation) {
        java.lang.String str;
        boolean z = false;
        if (cellLocation == null) {
            return false;
        }
        int c = c(cellLocation);
        if (c == 1) {
            try {
                android.telephony.gsm.GsmCellLocation gsmCellLocation = (android.telephony.gsm.GsmCellLocation) cellLocation;
                return a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
            } catch (java.lang.Throwable th) {
                th = th;
                str = "cgiUseful Cgi.I_GSM_T";
            }
        } else {
            if (c != 2) {
                return true;
            }
            try {
                if (com.amap.api.mapcore.util.iv.b(cellLocation, "getSystemId", new java.lang.Object[0]) > 0 && com.amap.api.mapcore.util.iv.b(cellLocation, "getNetworkId", new java.lang.Object[0]) >= 0) {
                    if (com.amap.api.mapcore.util.iv.b(cellLocation, "getBaseStationId", new java.lang.Object[0]) >= 0) {
                        z = true;
                    }
                }
                return z;
            } catch (java.lang.Throwable th2) {
                th = th2;
                str = "cgiUseful Cgi.I_CDMA_T";
            }
        }
        com.amap.api.mapcore.util.it.a(th, "CgiManager", str);
        return true;
    }

    public final synchronized void b() {
        try {
            this.j = com.amap.api.mapcore.util.ix.a(this.l);
            if (n() || this.b.isEmpty()) {
                r();
                this.e = com.amap.api.mapcore.util.ix.b();
            }
            if (this.j) {
                o();
            } else {
                p();
            }
            q();
        } catch (java.lang.SecurityException e) {
            this.i = e.getMessage();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.it.a(th, "CgiManager", com.alipay.sdk.m.x.d.w);
        }
    }

    public final synchronized java.util.ArrayList<com.amap.api.mapcore.util.jv> c() {
        return this.b;
    }

    public final java.util.ArrayList<com.amap.api.mapcore.util.jv> d() {
        return this.n;
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.a & 3;
    }

    public final android.telephony.TelephonyManager g() {
        return this.d;
    }

    public final void h() {
        android.telephony.PhoneStateListener phoneStateListener;
        this.p.a();
        this.f137s = 0L;
        synchronized (this.y) {
            this.x = true;
        }
        android.telephony.TelephonyManager telephonyManager = this.d;
        if (telephonyManager != null && (phoneStateListener = this.h) != null) {
            try {
                telephonyManager.listen(phoneStateListener, 0);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.it.a(th, "CgiManager", "destroy");
            }
        }
        this.h = null;
        this.o = -113;
        this.d = null;
        this.q = null;
    }

    public final synchronized void i() {
        this.i = null;
        this.f = null;
        this.a = 0;
        this.b.clear();
        this.n.clear();
    }

    public final java.lang.String j() {
        return this.m;
    }
}

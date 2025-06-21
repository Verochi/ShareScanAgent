package com.loc;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes23.dex */
public final class a {
    private static boolean A;
    android.content.Context b;
    com.loc.gb a = null;
    android.app.PendingIntent c = null;
    java.lang.String d = null;
    com.amap.api.fence.GeoFenceListener e = null;
    private java.lang.Object z = new java.lang.Object();
    volatile int f = 1;
    java.util.ArrayList<com.amap.api.fence.GeoFence> g = new java.util.ArrayList<>();
    com.loc.a.c h = null;
    java.lang.Object i = new java.lang.Object();
    java.lang.Object j = new java.lang.Object();
    com.loc.a.HandlerC0417a k = null;
    com.loc.a.b l = null;
    volatile boolean m = false;
    volatile boolean n = false;
    volatile boolean o = false;
    com.loc.b p = null;
    com.loc.c q = null;
    com.amap.api.location.AMapLocationClient r = null;

    /* renamed from: s, reason: collision with root package name */
    volatile com.amap.api.location.AMapLocation f397s = null;
    long t = 0;
    com.amap.api.location.AMapLocationClientOption u = null;
    int v = 0;
    com.amap.api.location.AMapLocationListener w = new com.loc.a.AnonymousClass1();
    final int x = 3;
    volatile boolean y = false;

    /* renamed from: com.loc.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.location.AMapLocationListener {
        public AnonymousClass1() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(com.amap.api.location.AMapLocation aMapLocation) {
            boolean z;
            int i;
            try {
                if (!com.loc.a.this.y && com.loc.a.this.o) {
                    com.loc.a.this.f397s = aMapLocation;
                    if (aMapLocation != null) {
                        i = aMapLocation.getErrorCode();
                        if (aMapLocation.getErrorCode() == 0) {
                            com.loc.a.this.t = com.loc.gd.b();
                            com.loc.a.this.a(5, (android.os.Bundle) null, 0L);
                            z = true;
                        } else {
                            com.loc.a.a("定位失败", aMapLocation.getErrorCode(), aMapLocation.getErrorInfo(), "locationDetail:" + aMapLocation.getLocationDetail());
                            z = false;
                        }
                    } else {
                        z = false;
                        i = 8;
                    }
                    if (z) {
                        com.loc.a aVar = com.loc.a.this;
                        aVar.v = 0;
                        aVar.a(6, (android.os.Bundle) null, 0L);
                        return;
                    }
                    android.os.Bundle bundle = new android.os.Bundle();
                    if (!com.loc.a.this.m) {
                        com.loc.a.this.b(7);
                        bundle.putLong(com.umeng.analytics.pro.bo.ba, 2000L);
                        com.loc.a.this.a(8, bundle, 2000L);
                    }
                    com.loc.a aVar2 = com.loc.a.this;
                    int i2 = aVar2.v + 1;
                    aVar2.v = i2;
                    if (i2 >= 3) {
                        bundle.putInt(com.amap.api.fence.GeoFence.BUNDLE_KEY_LOCERRORCODE, i);
                        com.loc.a.this.a(1002, bundle);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.loc.a$a, reason: collision with other inner class name */
    public class HandlerC0417a extends android.os.Handler {
        public HandlerC0417a(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            try {
                switch (message.what) {
                    case 0:
                        com.loc.a.this.b(message.getData());
                        break;
                    case 1:
                        com.loc.a.this.c(message.getData());
                        break;
                    case 2:
                        com.loc.a.this.e(message.getData());
                        break;
                    case 3:
                        com.loc.a.this.d(message.getData());
                        break;
                    case 4:
                        com.loc.a.this.f(message.getData());
                        break;
                    case 5:
                        com.loc.a.this.e();
                        break;
                    case 6:
                        com.loc.a aVar = com.loc.a.this;
                        aVar.a(aVar.f397s);
                        break;
                    case 7:
                        com.loc.a.this.d();
                        break;
                    case 8:
                        com.loc.a.this.j(message.getData());
                        break;
                    case 9:
                        com.loc.a.this.a(message.getData());
                        break;
                    case 10:
                        com.loc.a.this.c();
                        break;
                    case 11:
                        com.loc.a.this.h(message.getData());
                        break;
                    case 12:
                        com.loc.a.this.g(message.getData());
                        break;
                    case 13:
                        com.loc.a.this.g();
                        break;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static class b extends android.os.HandlerThread {
        public b(java.lang.String str) {
            super(str);
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public class c extends android.os.Handler {
        public c() {
        }

        public c(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            try {
                android.os.Bundle data = message.getData();
                switch (message.what) {
                    case 1000:
                        com.loc.a.this.i(data);
                        return;
                    case 1001:
                        try {
                            com.loc.a.this.b((com.amap.api.fence.GeoFence) data.getParcelable("geoFence"));
                            return;
                        } catch (java.lang.Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    case 1002:
                        try {
                            com.loc.a.this.c(data.getInt(com.amap.api.fence.GeoFence.BUNDLE_KEY_LOCERRORCODE));
                            return;
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                            return;
                        }
                    default:
                        return;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public a(android.content.Context context) {
        this.b = null;
        try {
            this.b = context.getApplicationContext();
            j();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManger", "<init>");
        }
    }

    private static float a(com.amap.api.location.AMapLocation aMapLocation, java.util.List<com.amap.api.fence.GeoFence> list) {
        float f = Float.MAX_VALUE;
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0 && list != null && !list.isEmpty()) {
            com.amap.api.location.DPoint dPoint = new com.amap.api.location.DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude());
            for (com.amap.api.fence.GeoFence geoFence : list) {
                if (geoFence.isAble()) {
                    float a = com.loc.gd.a(dPoint, geoFence.getCenter());
                    if (a > geoFence.getMinDis2Center() && a < geoFence.getMaxDis2Center()) {
                        return 0.0f;
                    }
                    if (a > geoFence.getMaxDis2Center()) {
                        f = java.lang.Math.min(f, a - geoFence.getMaxDis2Center());
                    }
                    if (a < geoFence.getMinDis2Center()) {
                        f = java.lang.Math.min(f, geoFence.getMinDis2Center() - a);
                    }
                }
            }
        }
        return f;
    }

    public static float a(com.amap.api.location.DPoint dPoint, java.util.List<com.amap.api.location.DPoint> list) {
        float f = Float.MAX_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            java.util.Iterator<com.amap.api.location.DPoint> it = list.iterator();
            while (it.hasNext()) {
                f = java.lang.Math.min(f, com.loc.gd.a(dPoint, it.next()));
            }
        }
        return f;
    }

    private int a(java.util.List<com.amap.api.fence.GeoFence> list) {
        try {
            if (this.g == null) {
                this.g = new java.util.ArrayList<>();
            }
            java.util.Iterator<com.amap.api.fence.GeoFence> it = list.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            return 0;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addGeoFenceList");
            a("添加围栏失败", 8, th.getMessage(), new java.lang.String[0]);
            return 8;
        }
    }

    private static android.os.Bundle a(com.amap.api.fence.GeoFence geoFence, java.lang.String str, java.lang.String str2, int i, int i2) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_FENCEID, str);
        bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str2);
        bundle.putInt("event", i);
        bundle.putInt(com.amap.api.fence.GeoFence.BUNDLE_KEY_LOCERRORCODE, i2);
        bundle.putParcelable(com.amap.api.fence.GeoFence.BUNDLE_KEY_FENCE, geoFence);
        return bundle;
    }

    private com.amap.api.fence.GeoFence a(android.os.Bundle bundle, boolean z) {
        com.amap.api.fence.GeoFence geoFence = new com.amap.api.fence.GeoFence();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.amap.api.location.DPoint dPoint = new com.amap.api.location.DPoint();
        if (z) {
            geoFence.setType(1);
            arrayList = bundle.getParcelableArrayList("pointList");
            if (arrayList != null) {
                dPoint = b(arrayList);
            }
            geoFence.setMaxDis2Center(b(dPoint, arrayList));
            geoFence.setMinDis2Center(a(dPoint, arrayList));
        } else {
            geoFence.setType(0);
            dPoint = (com.amap.api.location.DPoint) bundle.getParcelable("centerPoint");
            if (dPoint != null) {
                arrayList.add(dPoint);
            }
            float f = bundle.getFloat("fenceRadius", 1000.0f);
            float f2 = f > 0.0f ? f : 1000.0f;
            geoFence.setRadius(f2);
            geoFence.setMinDis2Center(f2);
            geoFence.setMaxDis2Center(f2);
        }
        geoFence.setActivatesAction(this.f);
        geoFence.setCustomId(bundle.getString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID));
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        arrayList2.add(arrayList);
        geoFence.setPointList(arrayList2);
        geoFence.setCenter(dPoint);
        geoFence.setPendingIntentAction(this.d);
        geoFence.setExpiration(-1L);
        geoFence.setPendingIntent(this.c);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.loc.c.a());
        geoFence.setFenceId(sb.toString());
        com.loc.gb gbVar = this.a;
        if (gbVar != null) {
            gbVar.a(this.b, 2);
        }
        return geoFence;
    }

    public static void a(java.lang.String str, int i, java.lang.String str2, java.lang.String... strArr) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("===========================================\n");
        stringBuffer.append("              " + str + "                ");
        stringBuffer.append("\n");
        stringBuffer.append("-------------------------------------------\n");
        stringBuffer.append("errorCode:".concat(java.lang.String.valueOf(i)));
        stringBuffer.append("\n");
        stringBuffer.append("错误信息:".concat(java.lang.String.valueOf(str2)));
        stringBuffer.append("\n");
        if (strArr.length > 0) {
            for (java.lang.String str3 : strArr) {
                stringBuffer.append(str3);
                stringBuffer.append("\n");
            }
        }
        stringBuffer.append("===========================================\n");
    }

    private static boolean a(int i, java.lang.String str, java.lang.String str2, com.amap.api.location.DPoint dPoint) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        if (i != 1) {
            if (i == 2) {
                if (dPoint == null) {
                    return false;
                }
                if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d || dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
                    a("添加围栏失败", 0, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new java.lang.String[0]);
                    return false;
                }
            }
        } else if (android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r4.getStatus() == 3) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(com.amap.api.fence.GeoFence geoFence, int i) {
        boolean z = true;
        boolean z2 = false;
        if ((i & 1) == 1) {
            try {
                if (geoFence.getStatus() == 1) {
                    z2 = true;
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "Utils", "remindStatus");
                return z2;
            }
        }
        if ((i & 2) == 2 && geoFence.getStatus() == 2) {
            z2 = true;
        }
        if ((i & 4) == 4) {
        }
        z = z2;
        return z;
    }

    private static boolean a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.fence.GeoFence geoFence) {
        boolean z = false;
        try {
            if (com.loc.gd.a(aMapLocation) && geoFence != null && geoFence.getPointList() != null && !geoFence.getPointList().isEmpty()) {
                int type = geoFence.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type != 2) {
                            if (type != 3) {
                            }
                        }
                    }
                    java.util.Iterator<java.util.List<com.amap.api.location.DPoint>> it = geoFence.getPointList().iterator();
                    while (it.hasNext()) {
                        if (b(aMapLocation, it.next())) {
                            z = true;
                        }
                    }
                }
                if (a(aMapLocation, geoFence.getCenter(), geoFence.getRadius())) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "Utils", "isInGeoFence");
        }
        return z;
    }

    private static boolean a(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.location.DPoint dPoint, float f) {
        return com.loc.gd.a(new double[]{dPoint.getLatitude(), dPoint.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()}) <= f;
    }

    public static float b(com.amap.api.location.DPoint dPoint, java.util.List<com.amap.api.location.DPoint> list) {
        float f = Float.MIN_VALUE;
        if (dPoint != null && list != null && !list.isEmpty()) {
            java.util.Iterator<com.amap.api.location.DPoint> it = list.iterator();
            while (it.hasNext()) {
                f = java.lang.Math.max(f, com.loc.gd.a(dPoint, it.next()));
            }
        }
        return f;
    }

    private static com.amap.api.location.DPoint b(java.util.List<com.amap.api.location.DPoint> list) {
        com.amap.api.location.DPoint dPoint = new com.amap.api.location.DPoint();
        if (list == null) {
            return dPoint;
        }
        try {
            double d = 0.0d;
            double d2 = 0.0d;
            for (com.amap.api.location.DPoint dPoint2 : list) {
                d += dPoint2.getLatitude();
                d2 += dPoint2.getLongitude();
            }
            return new com.amap.api.location.DPoint(com.loc.gd.b(d / list.size()), com.loc.gd.b(d2 / list.size()));
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceUtil", "getPolygonCenter");
            return dPoint;
        }
    }

    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0135: MOVE (r2 I:??[OBJECT, ARRAY]) = (r23 I:??[OBJECT, ARRAY]), block:B:61:0x0135 */
    private void b(int i, android.os.Bundle bundle) {
        java.lang.String str;
        int i2;
        java.lang.String str2;
        int i3;
        java.lang.String str3;
        int i4;
        int i5;
        java.lang.String a;
        android.os.Bundle bundle2 = new android.os.Bundle();
        try {
            java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
            if (bundle == null || bundle.isEmpty()) {
                str2 = "errorCode";
                i3 = 1;
            } else {
                java.util.List<com.amap.api.fence.GeoFence> arrayList2 = new java.util.ArrayList<>();
                java.lang.String string = bundle.getString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID);
                java.lang.String string2 = bundle.getString("keyWords");
                java.lang.String string3 = bundle.getString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY);
                java.lang.String string4 = bundle.getString("poiType");
                com.amap.api.location.DPoint dPoint = (com.amap.api.location.DPoint) bundle.getParcelable("centerPoint");
                int i6 = bundle.getInt("searchSize", 10);
                float f = bundle.getFloat("aroundRadius", 3000.0f);
                if (a(i, string2, string4, dPoint)) {
                    android.os.Bundle bundle3 = new android.os.Bundle();
                    bundle3.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, string);
                    bundle3.putString("pendingIntentAction", this.d);
                    bundle3.putLong("expiration", -1L);
                    bundle3.putInt("activatesAction", this.f);
                    try {
                        if (i == 1) {
                            str2 = "errorCode";
                            i4 = 3;
                            i5 = 2;
                            bundle3.putFloat("fenceRadius", 1000.0f);
                            a = this.p.a(this.b, "http://restsdk.amap.com/v3/place/text?", string2, string4, string3, java.lang.String.valueOf(i6));
                        } else if (i != 2) {
                            a = i != 3 ? null : this.p.a(this.b, "http://restsdk.amap.com/v3/config/district?", string2);
                            str2 = "errorCode";
                            i4 = 3;
                            i5 = 2;
                        } else {
                            double b2 = com.loc.gd.b(dPoint.getLatitude());
                            double b3 = com.loc.gd.b(dPoint.getLongitude());
                            int intValue = java.lang.Float.valueOf(f).intValue();
                            bundle3.putFloat("fenceRadius", 200.0f);
                            str2 = "errorCode";
                            i5 = 2;
                            a = this.p.a(this.b, "http://restsdk.amap.com/v3/place/around?", string2, string4, java.lang.String.valueOf(i6), java.lang.String.valueOf(b2), java.lang.String.valueOf(b3), java.lang.String.valueOf(intValue));
                            i4 = 3;
                        }
                        if (a != null) {
                            int a2 = 1 == i ? com.loc.c.a(a, arrayList2, bundle3) : 0;
                            if (i5 == i) {
                                a2 = com.loc.c.b(a, arrayList2, bundle3);
                            }
                            if (i4 == i) {
                                a2 = this.q.c(a, arrayList2, bundle3);
                            }
                            if (a2 != 10000) {
                                i2 = d(a2);
                            } else if (arrayList2.isEmpty()) {
                                i2 = 16;
                            } else {
                                i2 = a(arrayList2);
                                if (i2 == 0) {
                                    try {
                                        arrayList.addAll(arrayList2);
                                    } catch (java.lang.Throwable th) {
                                        th = th;
                                        str = str2;
                                        try {
                                            com.loc.fv.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                                            bundle2.putInt(str, 8);
                                            a(1000, bundle2);
                                            return;
                                        } catch (java.lang.Throwable th2) {
                                            bundle2.putInt(str, i2);
                                            a(1000, bundle2);
                                            throw th2;
                                        }
                                    }
                                }
                            }
                        } else {
                            i2 = 4;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        str = str3;
                        i2 = 0;
                        com.loc.fv.a(th, "GeoFenceManager", "doAddGeoFenceNearby");
                        bundle2.putInt(str, 8);
                        a(1000, bundle2);
                        return;
                    }
                } else {
                    str2 = "errorCode";
                    i2 = 1;
                }
                bundle2.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, string);
                bundle2.putParcelableArrayList("resultList", arrayList);
                i3 = i2;
            }
            bundle2.putInt(str2, i3);
            a(1000, bundle2);
        } catch (java.lang.Throwable th4) {
            th = th4;
            str = "errorCode";
        }
    }

    private static boolean b(com.amap.api.location.AMapLocation aMapLocation, com.amap.api.fence.GeoFence geoFence) {
        boolean z = false;
        try {
            if (a(aMapLocation, geoFence)) {
                if (geoFence.getEnterTime() == -1) {
                    if (geoFence.getStatus() != 1) {
                        geoFence.setEnterTime(com.loc.gd.b());
                        geoFence.setStatus(1);
                        return true;
                    }
                } else if (geoFence.getStatus() != 3 && com.loc.gd.b() - geoFence.getEnterTime() > 600000) {
                    geoFence.setStatus(3);
                    return true;
                }
            } else if (geoFence.getStatus() != 2) {
                try {
                    geoFence.setStatus(2);
                    geoFence.setEnterTime(-1L);
                    z = true;
                } catch (java.lang.Throwable th) {
                    th = th;
                    z = true;
                    com.loc.fv.a(th, "Utils", "isFenceStatusChanged");
                    return z;
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        return z;
    }

    private static boolean b(com.amap.api.location.AMapLocation aMapLocation, java.util.List<com.amap.api.location.DPoint> list) {
        if (list.size() < 3) {
            return false;
        }
        return com.loc.fv.a(new com.amap.api.location.DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), list);
    }

    private int c(com.amap.api.fence.GeoFence geoFence) {
        try {
            if (this.g == null) {
                this.g = new java.util.ArrayList<>();
            }
            if (this.g.contains(geoFence)) {
                return 17;
            }
            this.g.add(geoFence);
            return 0;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addGeoFence2List");
            a("添加围栏失败", 8, th.getMessage(), new java.lang.String[0]);
            return 8;
        }
    }

    private static int d(int i) {
        if (i != 1 && i != 7 && i != 4 && i != 5 && i != 16 && i != 17) {
            switch (i) {
                case 10000:
                    i = 0;
                    break;
                case 10001:
                case 10002:
                case 10007:
                case 10008:
                case 10009:
                case 10012:
                case 10013:
                    i = 7;
                    break;
                case 10003:
                case 10004:
                case 10005:
                case 10006:
                case 10010:
                case 10011:
                case com.igexin.sdk.PushConsts.ACTION_NOTIFICATION_ENABLE /* 10014 */:
                case com.igexin.sdk.PushConsts.ACTION_POPUP_SHOW /* 10015 */:
                case com.igexin.sdk.PushConsts.ACTION_POPUP_CLICKED /* 10016 */:
                case 10017:
                    i = 4;
                    break;
                default:
                    switch (i) {
                        case 20000:
                        case 20001:
                        case 20002:
                            i = 1;
                            break;
                        case 20003:
                        default:
                            i = 8;
                            break;
                    }
            }
        }
        if (i != 0) {
            a("添加围栏失败", i, "searchErrCode is ".concat(java.lang.String.valueOf(i)), new java.lang.String[0]);
        }
        return i;
    }

    private void d(com.amap.api.fence.GeoFence geoFence) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("geoFence", geoFence);
        a(1001, bundle);
    }

    private void j() {
        if (!this.o) {
            this.o = true;
        }
        if (this.n) {
            return;
        }
        try {
            this.h = android.os.Looper.myLooper() == null ? new com.loc.a.c(this.b.getMainLooper()) : new com.loc.a.c();
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManger", "init 1");
        }
        try {
            com.loc.a.b bVar = new com.loc.a.b("fenceActionThread");
            this.l = bVar;
            bVar.setPriority(5);
            this.l.start();
            this.k = new com.loc.a.HandlerC0417a(this.l.getLooper());
        } catch (java.lang.Throwable th2) {
            com.loc.fv.a(th2, "GeoFenceManger", "init 2");
        }
        try {
            this.p = new com.loc.b(this.b);
            this.q = new com.loc.c();
            this.u = new com.amap.api.location.AMapLocationClientOption();
            com.amap.api.location.AMapLocationClient aMapLocationClient = new com.amap.api.location.AMapLocationClient(this.b);
            this.r = aMapLocationClient;
            aMapLocationClient.setLocationListener(this.w);
            if (this.a == null) {
                this.a = new com.loc.gb();
            }
        } catch (java.lang.Throwable th3) {
            com.loc.fv.a(th3, "GeoFenceManger", "initBase");
        }
        this.n = true;
        try {
            java.lang.String str = this.d;
            if (str != null && this.c == null) {
                a(str);
            }
        } catch (java.lang.Throwable th4) {
            com.loc.fv.a(th4, "GeoFenceManger", "init 4");
        }
        if (A) {
            return;
        }
        A = true;
        com.loc.gb.a(this.b, "O020", (org.json.JSONObject) null);
    }

    private boolean k() {
        java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
        if (arrayList == null || arrayList.isEmpty()) {
            return true;
        }
        java.util.Iterator<com.amap.api.fence.GeoFence> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().isAble()) {
                return false;
            }
        }
        return true;
    }

    private void l() {
        try {
            synchronized (this.j) {
                com.loc.a.c cVar = this.h;
                if (cVar != null) {
                    cVar.removeCallbacksAndMessages(null);
                }
                this.h = null;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "destroyResultHandler");
        }
    }

    private void m() {
        try {
            synchronized (this.i) {
                com.loc.a.HandlerC0417a handlerC0417a = this.k;
                if (handlerC0417a != null) {
                    handlerC0417a.removeCallbacksAndMessages(null);
                }
                this.k = null;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "destroyActionHandler");
        }
    }

    private void n() {
        if (this.y || this.k == null) {
            return;
        }
        if (p()) {
            a(6, (android.os.Bundle) null, 0L);
            a(5, (android.os.Bundle) null, 0L);
        } else {
            b(7);
            a(7, (android.os.Bundle) null, 0L);
        }
    }

    private void o() {
        try {
            if (this.m) {
                b(8);
            }
            com.amap.api.location.AMapLocationClient aMapLocationClient = this.r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.m = false;
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean p() {
        return this.f397s != null && com.loc.gd.a(this.f397s) && com.loc.gd.b() - this.t < 10000;
    }

    public final android.app.PendingIntent a(java.lang.String str) {
        synchronized (this.z) {
            try {
                android.content.Intent intent = new android.content.Intent(str);
                intent.setPackage(com.loc.m.c(this.b));
                if (android.os.Build.VERSION.SDK_INT < 31 || this.b.getApplicationInfo().targetSdkVersion < 31) {
                    android.content.Context context = this.b;
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context, 0, intent, 0);
                    android.app.PendingIntent broadcast = android.app.PendingIntent.getBroadcast(context, 0, intent, 0);
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast, context, 0, intent, 0);
                    this.c = broadcast;
                } else {
                    android.content.Context context2 = this.b;
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookIntentGetBroadcast(context2, 0, intent, com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA);
                    android.app.PendingIntent broadcast2 = android.app.PendingIntent.getBroadcast(context2, 0, intent, com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA);
                    com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.hookPendingIntentGetBroadcast(broadcast2, context2, 0, intent, com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.BACK_CLEAR_DATA);
                    this.c = broadcast2;
                }
                this.d = str;
                java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    java.util.Iterator<com.amap.api.fence.GeoFence> it = this.g.iterator();
                    while (it.hasNext()) {
                        com.amap.api.fence.GeoFence next = it.next();
                        next.setPendingIntent(this.c);
                        next.setPendingIntentAction(this.d);
                    }
                }
            } finally {
                return this.c;
            }
        }
        return this.c;
    }

    public final void a() {
        try {
            this.o = false;
            a(10, (android.os.Bundle) null, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "removeGeoFence");
        }
    }

    public final void a(int i) {
        try {
            j();
            if (i > 7 || i <= 0) {
                i = 1;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("activatesAction", i);
            a(9, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "setActivateAction");
        }
    }

    public final void a(int i, android.os.Bundle bundle) {
        try {
            synchronized (this.j) {
                com.loc.a.c cVar = this.h;
                if (cVar != null) {
                    android.os.Message obtainMessage = cVar.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.h.sendMessage(obtainMessage);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "sendResultHandlerMessage");
        }
    }

    public final void a(int i, android.os.Bundle bundle, long j) {
        try {
            synchronized (this.i) {
                com.loc.a.HandlerC0417a handlerC0417a = this.k;
                if (handlerC0417a != null) {
                    android.os.Message obtainMessage = handlerC0417a.obtainMessage();
                    obtainMessage.what = i;
                    obtainMessage.setData(bundle);
                    this.k.sendMessageDelayed(obtainMessage, j);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "sendActionHandlerMessage");
        }
    }

    public final void a(android.os.Bundle bundle) {
        int i = 1;
        if (bundle != null) {
            try {
                i = bundle.getInt("activatesAction", 1);
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "GeoFenceManager", "doSetActivatesAction");
                return;
            }
        }
        if (this.f != i) {
            java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
            if (arrayList != null && !arrayList.isEmpty()) {
                java.util.Iterator<com.amap.api.fence.GeoFence> it = this.g.iterator();
                while (it.hasNext()) {
                    com.amap.api.fence.GeoFence next = it.next();
                    next.setStatus(0);
                    next.setEnterTime(-1L);
                }
            }
            n();
        }
        this.f = i;
    }

    public final void a(com.amap.api.fence.GeoFenceListener geoFenceListener) {
        try {
            this.e = geoFenceListener;
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.amap.api.location.AMapLocation aMapLocation) {
        java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList;
        try {
            if (this.y || (arrayList = this.g) == null || arrayList.isEmpty() || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
                return;
            }
            java.util.Iterator<com.amap.api.fence.GeoFence> it = this.g.iterator();
            while (it.hasNext()) {
                com.amap.api.fence.GeoFence next = it.next();
                if (next.isAble() && b(aMapLocation, next) && a(next, this.f)) {
                    next.setCurrentLocation(aMapLocation);
                    d(next);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doCheckFence");
        }
    }

    public final void a(com.amap.api.location.AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.u = aMapLocationClientOption.m14clone();
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.amap.api.location.DPoint dPoint, float f, java.lang.String str) {
        try {
            j();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("fenceRadius", f);
            bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(0, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addRoundGeoFence");
        }
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        try {
            j();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("keyWords", str);
            bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str2);
            a(4, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addDistricetGeoFence");
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, com.amap.api.location.DPoint dPoint, float f, int i, java.lang.String str3) {
        try {
            j();
            if (f <= 0.0f || f > 50000.0f) {
                f = 3000.0f;
            }
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putParcelable("centerPoint", dPoint);
            bundle.putFloat("aroundRadius", f);
            bundle.putInt("searchSize", i);
            bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str3);
            a(3, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addNearbyGeoFence");
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.String str4) {
        try {
            j();
            if (i <= 0) {
                i = 10;
            }
            if (i > 25) {
                i = 25;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("keyWords", str);
            bundle.putString("poiType", str2);
            bundle.putString(com.amap.api.services.district.DistrictSearchQuery.KEYWORDS_CITY, str3);
            bundle.putInt("searchSize", i);
            bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str4);
            a(2, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addKeywordGeoFence");
        }
    }

    public final void a(java.lang.String str, boolean z) {
        try {
            j();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("fid", str);
            bundle.putBoolean("ab", z);
            a(12, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "setGeoFenceAble");
        }
    }

    public final void a(java.util.List<com.amap.api.location.DPoint> list, java.lang.String str) {
        try {
            j();
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelableArrayList("pointList", new java.util.ArrayList<>(list));
            bundle.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1, bundle, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "addPolygonGeoFence");
        }
    }

    public final boolean a(com.amap.api.fence.GeoFence geoFence) {
        try {
            java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.g.contains(geoFence)) {
                    return false;
                }
                if (this.g.size() == 1) {
                    this.o = false;
                }
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putParcelable("fc", geoFence);
                a(11, bundle, 0L);
                return true;
            }
            this.o = false;
            a(10, (android.os.Bundle) null, 0L);
            return true;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "removeGeoFence(GeoFence)");
            return false;
        }
    }

    public final java.util.List<com.amap.api.fence.GeoFence> b() {
        try {
            if (this.g == null) {
                this.g = new java.util.ArrayList<>();
            }
            return (java.util.ArrayList) this.g.clone();
        } catch (java.lang.Throwable unused) {
            return new java.util.ArrayList();
        }
    }

    public final void b(int i) {
        try {
            synchronized (this.i) {
                com.loc.a.HandlerC0417a handlerC0417a = this.k;
                if (handlerC0417a != null) {
                    handlerC0417a.removeMessages(i);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "removeActionHandlerMessage");
        }
    }

    public final void b(android.os.Bundle bundle) {
        java.lang.String str;
        try {
            java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
            java.lang.String str2 = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                com.amap.api.location.DPoint dPoint = (com.amap.api.location.DPoint) bundle.getParcelable("centerPoint");
                str = bundle.getString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID);
                if (dPoint != null) {
                    if (dPoint.getLatitude() <= 90.0d && dPoint.getLatitude() >= -90.0d && dPoint.getLongitude() <= 180.0d && dPoint.getLongitude() >= -180.0d) {
                        com.amap.api.fence.GeoFence a = a(bundle, false);
                        i = c(a);
                        if (i == 0) {
                            arrayList.add(a);
                        }
                        android.os.Bundle bundle2 = new android.os.Bundle();
                        bundle2.putInt("errorCode", i);
                        bundle2.putParcelableArrayList("resultList", arrayList);
                        bundle2.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
                        a(1000, bundle2);
                    }
                    a("添加围栏失败", 1, "经纬度错误，传入的纬度：" + dPoint.getLatitude() + "传入的经度:" + dPoint.getLongitude(), new java.lang.String[0]);
                    android.os.Bundle bundle22 = new android.os.Bundle();
                    bundle22.putInt("errorCode", i);
                    bundle22.putParcelableArrayList("resultList", arrayList);
                    bundle22.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
                    a(1000, bundle22);
                }
                str2 = str;
            }
            str = str2;
            android.os.Bundle bundle222 = new android.os.Bundle();
            bundle222.putInt("errorCode", i);
            bundle222.putParcelableArrayList("resultList", arrayList);
            bundle222.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
            a(1000, bundle222);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doAddGeoFenceRound");
        }
    }

    public final void b(com.amap.api.fence.GeoFence geoFence) {
        android.app.PendingIntent pendingIntent;
        android.content.Context context;
        try {
            synchronized (this.z) {
                if (this.b != null) {
                    if (this.c == null && geoFence.getPendingIntent() == null) {
                        return;
                    }
                    android.content.Intent intent = new android.content.Intent();
                    intent.putExtras(a(geoFence, geoFence.getFenceId(), geoFence.getCustomId(), geoFence.getStatus(), 0));
                    java.lang.String str = this.d;
                    if (str != null) {
                        intent.setAction(str);
                    }
                    intent.setPackage(com.loc.m.c(this.b));
                    if (geoFence.getPendingIntent() != null) {
                        pendingIntent = geoFence.getPendingIntent();
                        context = this.b;
                    } else {
                        pendingIntent = this.c;
                        context = this.b;
                    }
                    pendingIntent.send(context, 0, intent);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "resultTriggerGeoFence");
        }
    }

    public final void c() {
        if (this.n) {
            java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
            if (arrayList != null) {
                arrayList.clear();
                this.g = null;
            }
            if (this.o) {
                return;
            }
            m();
            com.amap.api.location.AMapLocationClient aMapLocationClient = this.r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
                this.r.onDestroy();
            }
            this.r = null;
            com.loc.a.b bVar = this.l;
            if (bVar != null) {
                bVar.quitSafely();
            }
            this.l = null;
            this.p = null;
            synchronized (this.z) {
                android.app.PendingIntent pendingIntent = this.c;
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                this.c = null;
            }
            l();
            com.loc.gb gbVar = this.a;
            if (gbVar != null) {
                gbVar.b(this.b);
            }
            this.m = false;
            this.n = false;
        }
    }

    public final void c(int i) {
        try {
            if (this.b != null) {
                synchronized (this.z) {
                    if (this.c == null) {
                        return;
                    }
                    android.content.Intent intent = new android.content.Intent();
                    intent.putExtras(a((com.amap.api.fence.GeoFence) null, (java.lang.String) null, (java.lang.String) null, 4, i));
                    this.c.send(this.b, 0, intent);
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "resultRemindLocationError");
        }
    }

    public final void c(android.os.Bundle bundle) {
        com.amap.api.fence.GeoFence a;
        try {
            java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
            java.lang.String str = "";
            int i = 1;
            if (bundle != null && !bundle.isEmpty()) {
                java.util.ArrayList parcelableArrayList = bundle.getParcelableArrayList("pointList");
                java.lang.String string = bundle.getString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID);
                if (parcelableArrayList != null && parcelableArrayList.size() > 2 && (i = c((a = a(bundle, true)))) == 0) {
                    arrayList.add(a);
                }
                str = string;
            }
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID, str);
            bundle2.putInt("errorCode", i);
            bundle2.putParcelableArrayList("resultList", arrayList);
            a(1000, bundle2);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doAddGeoFencePolygon");
        }
    }

    public final void d() {
        try {
            if (this.r != null) {
                o();
                this.u.setLocationCacheEnable(true);
                this.u.setNeedAddress(false);
                this.u.setOnceLocation(true);
                this.r.setLocationOption(this.u);
                this.r.startLocation();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doStartOnceLocation");
        }
    }

    public final void d(android.os.Bundle bundle) {
        b(2, bundle);
    }

    public final void e() {
        try {
            if (!this.y && com.loc.gd.a(this.f397s)) {
                float a = a(this.f397s, this.g);
                if (a == Float.MAX_VALUE) {
                    return;
                }
                if (a < 1000.0f) {
                    b(7);
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putLong(com.umeng.analytics.pro.bo.ba, 2000L);
                    a(8, bundle, 500L);
                    return;
                }
                if (a < 5000.0f) {
                    o();
                    b(7);
                    a(7, (android.os.Bundle) null, 10000L);
                } else {
                    o();
                    b(7);
                    a(7, (android.os.Bundle) null, (long) (((a - 4000.0f) / 100.0f) * 1000.0f));
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doCheckLocationPolicy");
        }
    }

    public final void e(android.os.Bundle bundle) {
        b(1, bundle);
    }

    public final void f() {
        try {
            j();
            this.y = true;
            a(13, (android.os.Bundle) null, 0L);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "pauseGeoFence");
        }
    }

    public final void f(android.os.Bundle bundle) {
        b(3, bundle);
    }

    public final void g() {
        try {
            b(7);
            b(8);
            com.amap.api.location.AMapLocationClient aMapLocationClient = this.r;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            this.m = false;
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doPauseGeoFence");
        }
    }

    public final void g(android.os.Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                java.lang.String string = bundle.getString("fid");
                if (android.text.TextUtils.isEmpty(string)) {
                    return;
                }
                boolean z = bundle.getBoolean("ab", true);
                java.util.ArrayList<com.amap.api.fence.GeoFence> arrayList = this.g;
                if (arrayList != null && !arrayList.isEmpty()) {
                    java.util.Iterator<com.amap.api.fence.GeoFence> it = this.g.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.amap.api.fence.GeoFence next = it.next();
                        if (next.getFenceId().equals(string)) {
                            next.setAble(z);
                            break;
                        }
                    }
                }
                if (z) {
                    n();
                } else if (k()) {
                    g();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "GeoFenceManager", "doSetGeoFenceAble");
            }
        }
    }

    public final void h() {
        try {
            j();
            if (this.y) {
                this.y = false;
                n();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "resumeGeoFence");
        }
    }

    public final void h(android.os.Bundle bundle) {
        try {
            if (this.g != null) {
                com.amap.api.fence.GeoFence geoFence = (com.amap.api.fence.GeoFence) bundle.getParcelable("fc");
                if (this.g.contains(geoFence)) {
                    this.g.remove(geoFence);
                }
                if (this.g.size() <= 0) {
                    c();
                } else {
                    n();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void i(android.os.Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                int i = bundle.getInt("errorCode");
                java.util.ArrayList parcelableArrayList = bundle.getParcelableArrayList("resultList");
                if (parcelableArrayList == null) {
                    parcelableArrayList = new java.util.ArrayList();
                }
                java.lang.String string = bundle.getString(com.amap.api.fence.GeoFence.BUNDLE_KEY_CUSTOMID);
                if (string == null) {
                    string = "";
                }
                com.amap.api.fence.GeoFenceListener geoFenceListener = this.e;
                if (geoFenceListener != null) {
                    geoFenceListener.onGeoFenceCreateFinished((java.util.ArrayList) parcelableArrayList.clone(), i, string);
                }
                if (i == 0) {
                    n();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "GeoFenceManager", "resultAddGeoFenceFinished");
            }
        }
    }

    public final boolean i() {
        return this.y;
    }

    public final void j(android.os.Bundle bundle) {
        try {
            if (this.r != null) {
                long j = 2000;
                if (bundle != null && !bundle.isEmpty()) {
                    j = bundle.getLong(com.umeng.analytics.pro.bo.ba, 2000L);
                }
                this.u.setOnceLocation(false);
                this.u.setInterval(j);
                this.u.setLocationCacheEnable(true);
                this.u.setNeedAddress(false);
                this.r.setLocationOption(this.u);
                if (this.m) {
                    return;
                }
                this.r.stopLocation();
                this.r.startLocation();
                this.m = true;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "GeoFenceManager", "doStartContinueLocation");
        }
    }
}

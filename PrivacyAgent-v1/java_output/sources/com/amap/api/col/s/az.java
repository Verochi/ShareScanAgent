package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class az implements com.amap.api.services.interfaces.IGeocodeSearch {
    public android.content.Context a;
    public com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener b;
    public android.os.Handler c;

    /* renamed from: com.amap.api.col.s.az$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.geocoder.RegeocodeQuery n;

        public AnonymousClass1(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
            this.n = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 2;
                    obtainMessage.what = 201;
                    com.amap.api.col.s.s.i iVar = new com.amap.api.col.s.s.i();
                    iVar.b = com.amap.api.col.s.az.this.b;
                    obtainMessage.obj = iVar;
                    iVar.a = new com.amap.api.services.geocoder.RegeocodeResult(this.n, com.amap.api.col.s.az.this.getFromLocation(this.n));
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.az.this.c.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.az$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.geocoder.GeocodeQuery n;

        public AnonymousClass2(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) {
            this.n = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.what = 200;
                    obtainMessage.arg1 = 2;
                    obtainMessage.arg2 = 1000;
                    com.amap.api.col.s.s.e eVar = new com.amap.api.col.s.s.e();
                    eVar.b = com.amap.api.col.s.az.this.b;
                    obtainMessage.obj = eVar;
                    eVar.a = new com.amap.api.services.geocoder.GeocodeResult(this.n, com.amap.api.col.s.az.this.getFromLocationName(this.n));
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.az.this.c.sendMessage(obtainMessage);
            }
        }
    }

    public az(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.c = com.amap.api.col.s.s.a();
    }

    public static boolean b(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
        return (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final com.amap.api.services.geocoder.RegeocodeAddress getFromLocation(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (b(regeocodeQuery)) {
                return new com.amap.api.col.s.ah(this.a, regeocodeQuery).b();
            }
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "GeocodeSearch", "getFromLocationAsyn");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationAsyn(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.az.AnonymousClass1(regeocodeQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final java.util.List<com.amap.api.services.geocoder.GeocodeAddress> getFromLocationName(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (geocodeQuery != null) {
                return new com.amap.api.col.s.n(this.a, geocodeQuery).b();
            }
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "GeocodeSearch", "getFromLocationName");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void getFromLocationNameAsyn(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.az.AnonymousClass2(geocodeQuery));
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public final void setOnGeocodeSearchListener(com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.b = onGeocodeSearchListener;
    }
}

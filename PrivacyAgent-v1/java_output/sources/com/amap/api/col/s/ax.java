package com.amap.api.col.s;

/* loaded from: classes12.dex */
public class ax implements com.amap.api.services.interfaces.IDistanceSearch {
    public static final java.lang.String d = "ax";
    public android.content.Context a;
    public android.os.Handler b;
    public com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener c;

    /* renamed from: com.amap.api.col.s.ax$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.route.DistanceSearch.DistanceQuery n;

        public AnonymousClass1(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
            this.n = distanceQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.what = 400;
            obtainMessage.arg1 = 16;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.route.DistanceResult distanceResult = null;
            try {
                try {
                    distanceResult = com.amap.api.col.s.ax.this.calculateRouteDistance(this.n);
                    bundle.putInt("errorCode", 1000);
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                }
            } finally {
                obtainMessage.obj = com.amap.api.col.s.ax.this.c;
                bundle.putParcelable("result", distanceResult);
                obtainMessage.setData(bundle);
                com.amap.api.col.s.ax.this.b.sendMessage(obtainMessage);
            }
        }
    }

    public ax(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.b = com.amap.api.col.s.s.a();
    }

    public static boolean b(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
        return distanceQuery.getDestination() == null || distanceQuery.getOrigins() == null || distanceQuery.getOrigins().size() <= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public com.amap.api.services.route.DistanceResult calculateRouteDistance(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (distanceQuery == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (b(distanceQuery)) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.route.DistanceSearch.DistanceQuery m33clone = distanceQuery.m33clone();
            com.amap.api.services.route.DistanceResult b = new com.amap.api.col.s.j(this.a, m33clone).b();
            if (b != null) {
                b.setDistanceQuery(m33clone);
            }
            return b;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, d, "calculateWalkRoute");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void calculateRouteDistanceAsyn(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) {
        com.amap.api.col.s.an.a().a(new com.amap.api.col.s.ax.AnonymousClass1(distanceQuery));
    }

    @Override // com.amap.api.services.interfaces.IDistanceSearch
    public void setDistanceSearchListener(com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener onDistanceSearchListener) {
        this.c = onDistanceSearchListener;
    }
}

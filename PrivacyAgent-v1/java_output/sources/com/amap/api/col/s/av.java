package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class av implements com.amap.api.services.interfaces.IBusStationSearch {
    public android.content.Context a;
    public com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener b;
    public com.amap.api.services.busline.BusStationQuery c;
    public com.amap.api.services.busline.BusStationQuery d;
    public java.util.ArrayList<com.amap.api.services.busline.BusStationResult> e = new java.util.ArrayList<>();
    public int f;
    public android.os.Handler g;

    /* renamed from: com.amap.api.col.s.av$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 7;
                    com.amap.api.col.s.s.b bVar = new com.amap.api.col.s.s.b();
                    bVar.b = com.amap.api.col.s.av.this.b;
                    obtainMessage.obj = bVar;
                    com.amap.api.services.busline.BusStationResult searchBusStation = com.amap.api.col.s.av.this.searchBusStation();
                    obtainMessage.what = 1000;
                    bVar.a = searchBusStation;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.av.this.g.sendMessage(obtainMessage);
            }
        }
    }

    public av(android.content.Context context, com.amap.api.services.busline.BusStationQuery busStationQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.c = busStationQuery;
        this.g = com.amap.api.col.s.s.a();
    }

    public final void b(com.amap.api.services.busline.BusStationResult busStationResult) {
        int i;
        this.e = new java.util.ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.f;
            if (i2 > i) {
                break;
            }
            this.e.add(null);
            i2++;
        }
        if (i > 0) {
            this.e.set(this.c.getPageNumber(), busStationResult);
        }
    }

    public final boolean c() {
        com.amap.api.services.busline.BusStationQuery busStationQuery = this.c;
        return (busStationQuery == null || com.amap.api.col.s.i.a(busStationQuery.getQueryString())) ? false : true;
    }

    public final boolean d(int i) {
        return i <= this.f && i >= 0;
    }

    public final com.amap.api.services.busline.BusStationResult f(int i) {
        if (d(i)) {
            return this.e.get(i);
        }
        throw new java.lang.IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final com.amap.api.services.busline.BusStationQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final com.amap.api.services.busline.BusStationResult searchBusStation() throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (!c()) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.m27clone();
                this.f = 0;
                java.util.ArrayList<com.amap.api.services.busline.BusStationResult> arrayList = this.e;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f == 0) {
                com.amap.api.services.busline.BusStationResult busStationResult = (com.amap.api.services.busline.BusStationResult) new com.amap.api.col.s.d(this.a, this.c).b();
                this.f = busStationResult.getPageCount();
                b(busStationResult);
                return busStationResult;
            }
            com.amap.api.services.busline.BusStationResult f = f(this.c.getPageNumber());
            if (f != null) {
                return f;
            }
            com.amap.api.services.busline.BusStationResult busStationResult2 = (com.amap.api.services.busline.BusStationResult) new com.amap.api.col.s.d(this.a, this.c).b();
            this.e.set(this.c.getPageNumber(), busStationResult2);
            return busStationResult2;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "BusStationSearch", "searchBusStation");
            throw new com.amap.api.services.core.AMapException(e.getErrorMessage());
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void searchBusStationAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.av.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setOnBusStationSearchListener(com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public final void setQuery(com.amap.api.services.busline.BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.c)) {
            return;
        }
        this.c = busStationQuery;
    }
}

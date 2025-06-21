package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class au implements com.amap.api.services.interfaces.IBusLineSearch {
    public android.content.Context a;
    public com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener b;
    public com.amap.api.services.busline.BusLineQuery c;
    public com.amap.api.services.busline.BusLineQuery d;
    public int e;
    public java.util.ArrayList<com.amap.api.services.busline.BusLineResult> f = new java.util.ArrayList<>();
    public android.os.Handler g;

    /* renamed from: com.amap.api.col.s.au$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 3;
                    obtainMessage.what = 1000;
                    com.amap.api.col.s.s.a aVar = new com.amap.api.col.s.s.a();
                    obtainMessage.obj = aVar;
                    aVar.b = com.amap.api.col.s.au.this.b;
                    aVar.a = com.amap.api.col.s.au.this.searchBusLine();
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.au.this.g.sendMessage(obtainMessage);
            }
        }
    }

    public au(android.content.Context context, com.amap.api.services.busline.BusLineQuery busLineQuery) throws com.amap.api.services.core.AMapException {
        this.g = null;
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.c = busLineQuery;
        if (busLineQuery != null) {
            this.d = busLineQuery.m26clone();
        }
        this.g = com.amap.api.col.s.s.a();
    }

    public final void b(com.amap.api.services.busline.BusLineResult busLineResult) {
        int i;
        this.f = new java.util.ArrayList<>();
        int i2 = 0;
        while (true) {
            i = this.e;
            if (i2 >= i) {
                break;
            }
            this.f.add(null);
            i2++;
        }
        if (i < 0 || !d(this.c.getPageNumber())) {
            return;
        }
        this.f.set(this.c.getPageNumber(), busLineResult);
    }

    public final boolean c() {
        com.amap.api.services.busline.BusLineQuery busLineQuery = this.c;
        return (busLineQuery == null || com.amap.api.col.s.i.a(busLineQuery.getQueryString())) ? false : true;
    }

    public final boolean d(int i) {
        return i < this.e && i >= 0;
    }

    public final com.amap.api.services.busline.BusLineResult f(int i) {
        if (d(i)) {
            return this.f.get(i);
        }
        throw new java.lang.IllegalArgumentException("page out of range");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final com.amap.api.services.busline.BusLineQuery getQuery() {
        return this.c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final com.amap.api.services.busline.BusLineResult searchBusLine() throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.a);
            if (this.d == null || !c()) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.c.weakEquals(this.d)) {
                this.d = this.c.m26clone();
                this.e = 0;
                java.util.ArrayList<com.amap.api.services.busline.BusLineResult> arrayList = this.f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.e == 0) {
                com.amap.api.services.busline.BusLineResult busLineResult = (com.amap.api.services.busline.BusLineResult) new com.amap.api.col.s.d(this.a, this.c.m26clone()).b();
                b(busLineResult);
                return busLineResult;
            }
            com.amap.api.services.busline.BusLineResult f = f(this.c.getPageNumber());
            if (f != null) {
                return f;
            }
            com.amap.api.services.busline.BusLineResult busLineResult2 = (com.amap.api.services.busline.BusLineResult) new com.amap.api.col.s.d(this.a, this.c).b();
            this.f.set(this.c.getPageNumber(), busLineResult2);
            return busLineResult2;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "BusLineSearch", "searchBusLine");
            throw new com.amap.api.services.core.AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void searchBusLineAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.au.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setOnBusLineSearchListener(com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public final void setQuery(com.amap.api.services.busline.BusLineQuery busLineQuery) {
        if (this.c.weakEquals(busLineQuery)) {
            return;
        }
        this.c = busLineQuery;
        this.d = busLineQuery.m26clone();
    }
}

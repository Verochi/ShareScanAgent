package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bd implements com.amap.api.services.interfaces.IRoutePOISearch {
    public com.amap.api.services.routepoisearch.RoutePOISearchQuery a;
    public android.content.Context b;
    public com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener c;
    public android.os.Handler d;

    /* renamed from: com.amap.api.col.s.bd$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.col.s.s.j jVar;
            android.os.Message obtainMessage = com.amap.api.col.s.bd.this.d.obtainMessage();
            obtainMessage.arg1 = 14;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.routepoisearch.RoutePOISearchResult routePOISearchResult = null;
            try {
                try {
                    routePOISearchResult = com.amap.api.col.s.bd.this.searchRoutePOI();
                    bundle.putInt("errorCode", 1000);
                    jVar = new com.amap.api.col.s.s.j();
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    jVar = new com.amap.api.col.s.s.j();
                }
                jVar.b = com.amap.api.col.s.bd.this.c;
                jVar.a = routePOISearchResult;
                obtainMessage.obj = jVar;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bd.this.d.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.s.j jVar2 = new com.amap.api.col.s.s.j();
                jVar2.b = com.amap.api.col.s.bd.this.c;
                jVar2.a = routePOISearchResult;
                obtainMessage.obj = jVar2;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bd.this.d.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public bd(android.content.Context context, com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) throws com.amap.api.services.core.AMapException {
        this.d = null;
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.b = context;
        this.a = routePOISearchQuery;
        this.d = com.amap.api.col.s.s.a();
    }

    public final boolean b() {
        com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery = this.a;
        if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null) {
            return false;
        }
        return (this.a.getFrom() == null && this.a.getTo() == null && this.a.getPolylines() == null) ? false : true;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final com.amap.api.services.routepoisearch.RoutePOISearchQuery getQuery() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final com.amap.api.services.routepoisearch.RoutePOISearchResult searchRoutePOI() throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.b);
            if (!b()) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            return new com.amap.api.col.s.aj(this.b, this.a.m41clone()).b();
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "RoutePOISearchCore", "searchRoutePOI");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void searchRoutePOIAsyn() {
        com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bd.AnonymousClass1());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setQuery(com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery) {
        this.a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public final void setRoutePOISearchListener(com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.c = onRoutePOISearchListener;
    }
}

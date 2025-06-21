package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bc implements com.amap.api.services.interfaces.IPoiSearch {
    public static java.util.HashMap<java.lang.Integer, com.amap.api.services.poisearch.PoiResult> j;
    public com.amap.api.services.poisearch.PoiSearch.SearchBound a;
    public com.amap.api.services.poisearch.PoiSearch.Query b;
    public android.content.Context c;
    public com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener d;
    public java.lang.String e = "zh-CN";
    public com.amap.api.services.poisearch.PoiSearch.Query f;
    public com.amap.api.services.poisearch.PoiSearch.SearchBound g;
    public int h;
    public android.os.Handler i;

    /* renamed from: com.amap.api.col.s.bc$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.col.s.s.h hVar;
            android.os.Message obtainMessage = com.amap.api.col.s.bc.this.i.obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 600;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.poisearch.PoiResult poiResult = null;
            try {
                try {
                    poiResult = com.amap.api.col.s.bc.this.searchPOI();
                    bundle.putInt("errorCode", 1000);
                    hVar = new com.amap.api.col.s.s.h();
                } catch (com.amap.api.services.core.AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                    hVar = new com.amap.api.col.s.s.h();
                }
                hVar.b = com.amap.api.col.s.bc.this.d;
                hVar.a = poiResult;
                obtainMessage.obj = hVar;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bc.this.i.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.s.h hVar2 = new com.amap.api.col.s.s.h();
                hVar2.b = com.amap.api.col.s.bc.this.d;
                hVar2.a = poiResult;
                obtainMessage.obj = hVar2;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bc.this.i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    /* renamed from: com.amap.api.col.s.bc$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;

        public AnonymousClass2(java.lang.String str) {
            this.n = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.col.s.s.g gVar;
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            obtainMessage.arg1 = 6;
            obtainMessage.what = 602;
            android.os.Bundle bundle = new android.os.Bundle();
            com.amap.api.services.core.PoiItem poiItem = null;
            try {
                try {
                    poiItem = com.amap.api.col.s.bc.this.searchPOIId(this.n);
                    bundle.putInt("errorCode", 1000);
                    gVar = new com.amap.api.col.s.s.g();
                } catch (com.amap.api.services.core.AMapException e) {
                    com.amap.api.col.s.i.a(e, "PoiSearch", "searchPOIIdAsyn");
                    bundle.putInt("errorCode", e.getErrorCode());
                    gVar = new com.amap.api.col.s.s.g();
                }
                gVar.b = com.amap.api.col.s.bc.this.d;
                gVar.a = poiItem;
                obtainMessage.obj = gVar;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bc.this.i.sendMessage(obtainMessage);
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.s.g gVar2 = new com.amap.api.col.s.s.g();
                gVar2.b = com.amap.api.col.s.bc.this.d;
                gVar2.a = poiItem;
                obtainMessage.obj = gVar2;
                obtainMessage.setData(bundle);
                com.amap.api.col.s.bc.this.i.sendMessage(obtainMessage);
                throw th;
            }
        }
    }

    public bc(android.content.Context context, com.amap.api.services.poisearch.PoiSearch.Query query) throws com.amap.api.services.core.AMapException {
        this.i = null;
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.c = context.getApplicationContext();
        setQuery(query);
        this.i = com.amap.api.col.s.s.a();
    }

    public final com.amap.api.services.poisearch.PoiResult b(int i) {
        if (g(i)) {
            return j.get(java.lang.Integer.valueOf(i));
        }
        throw new java.lang.IllegalArgumentException("page out of range");
    }

    public final void c(com.amap.api.services.poisearch.PoiResult poiResult) {
        int i;
        j = new java.util.HashMap<>();
        com.amap.api.services.poisearch.PoiSearch.Query query = this.b;
        if (query == null || poiResult == null || (i = this.h) <= 0 || i <= query.getPageNum()) {
            return;
        }
        j.put(java.lang.Integer.valueOf(this.b.getPageNum()), poiResult);
    }

    public final boolean d() {
        com.amap.api.services.poisearch.PoiSearch.Query query = this.b;
        if (query == null) {
            return false;
        }
        return (com.amap.api.col.s.i.a(query.getQueryString()) && com.amap.api.col.s.i.a(this.b.getCategory())) ? false : true;
    }

    public final boolean f() {
        com.amap.api.services.poisearch.PoiSearch.SearchBound bound = getBound();
        return bound != null && bound.getShape().equals("Bound");
    }

    public final boolean g(int i) {
        return i <= this.h && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final com.amap.api.services.poisearch.PoiSearch.SearchBound getBound() {
        return this.a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final java.lang.String getLanguage() {
        return this.e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final com.amap.api.services.poisearch.PoiSearch.Query getQuery() {
        return this.b;
    }

    public final boolean h() {
        com.amap.api.services.poisearch.PoiSearch.SearchBound bound = getBound();
        if (bound == null) {
            return true;
        }
        if (bound.getShape().equals("Bound")) {
            return bound.getCenter() != null;
        }
        if (!bound.getShape().equals("Polygon")) {
            if (!bound.getShape().equals("Rectangle")) {
                return true;
            }
            com.amap.api.services.core.LatLonPoint lowerLeft = bound.getLowerLeft();
            com.amap.api.services.core.LatLonPoint upperRight = bound.getUpperRight();
            return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
        }
        java.util.List<com.amap.api.services.core.LatLonPoint> polyGonList = bound.getPolyGonList();
        if (polyGonList == null || polyGonList.size() == 0) {
            return false;
        }
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final com.amap.api.services.poisearch.PoiResult searchPOI() throws com.amap.api.services.core.AMapException {
        try {
            com.amap.api.col.s.q.a(this.c);
            if (!f() && !d()) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!h()) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            com.amap.api.services.poisearch.PoiSearch.Query query = this.b;
            if (query == null) {
                throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query.queryEquals(this.f) && this.a == null) || (!this.b.queryEquals(this.f) && !this.a.equals(this.g))) {
                this.h = 0;
                this.f = this.b.m31clone();
                com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound = this.a;
                if (searchBound != null) {
                    this.g = searchBound.m32clone();
                }
                java.util.HashMap<java.lang.Integer, com.amap.api.services.poisearch.PoiResult> hashMap = j;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound2 = this.a;
            com.amap.api.services.poisearch.PoiSearch.SearchBound m32clone = searchBound2 != null ? searchBound2.m32clone() : null;
            com.amap.api.col.s.ag.a().a(this.b.getQueryString());
            this.b.setPageNum(com.amap.api.col.s.ag.a().k(this.b.getPageNum()));
            this.b.setPageSize(com.amap.api.col.s.ag.a().l(this.b.getPageSize()));
            if (this.h == 0) {
                com.amap.api.services.poisearch.PoiResult b = new com.amap.api.col.s.y(this.c, new com.amap.api.col.s.ab(this.b.m31clone(), m32clone)).b();
                c(b);
                return b;
            }
            com.amap.api.services.poisearch.PoiResult b2 = b(this.b.getPageNum());
            if (b2 != null) {
                return b2;
            }
            com.amap.api.services.poisearch.PoiResult b3 = new com.amap.api.col.s.y(this.c, new com.amap.api.col.s.ab(this.b.m31clone(), m32clone)).b();
            j.put(java.lang.Integer.valueOf(this.b.getPageNum()), b3);
            return b3;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "PoiSearch", "searchPOI");
            throw new com.amap.api.services.core.AMapException(e.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bc.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final com.amap.api.services.core.PoiItem searchPOIId(java.lang.String str) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.q.a(this.c);
        com.amap.api.services.poisearch.PoiSearch.Query query = this.b;
        return new com.amap.api.col.s.x(this.c, str, query != null ? query.m31clone() : null).b();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void searchPOIIdAsyn(java.lang.String str) {
        com.amap.api.col.s.an.a().a(new com.amap.api.col.s.bc.AnonymousClass2(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setBound(com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound) {
        this.a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setLanguage(java.lang.String str) {
        if ("en".equals(str)) {
            this.e = "en";
        } else {
            this.e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setOnPoiSearchListener(com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public final void setQuery(com.amap.api.services.poisearch.PoiSearch.Query query) {
        this.b = query;
    }
}

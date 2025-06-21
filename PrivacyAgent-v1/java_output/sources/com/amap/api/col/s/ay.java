package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class ay implements com.amap.api.services.interfaces.IDistrictSearch {
    public static java.util.HashMap<java.lang.Integer, com.amap.api.services.district.DistrictResult> g;
    public android.content.Context a;
    public com.amap.api.services.district.DistrictSearchQuery b;
    public com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener c;
    public com.amap.api.services.district.DistrictSearchQuery d;
    public int e;
    public android.os.Handler f;

    /* renamed from: com.amap.api.col.s.ay$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            com.amap.api.services.district.DistrictResult districtResult = new com.amap.api.services.district.DistrictResult();
            districtResult.setQuery(com.amap.api.col.s.ay.this.b);
            try {
                try {
                    districtResult = com.amap.api.col.s.ay.this.searchDistrict();
                    if (districtResult != null) {
                        districtResult.setAMapException(new com.amap.api.services.core.AMapException());
                    }
                } finally {
                    obtainMessage.arg1 = 4;
                    obtainMessage.obj = com.amap.api.col.s.ay.this.c;
                    android.os.Bundle bundle = new android.os.Bundle();
                    bundle.putParcelable("result", districtResult);
                    obtainMessage.setData(bundle);
                    if (com.amap.api.col.s.ay.this.f != null) {
                        com.amap.api.col.s.ay.this.f.sendMessage(obtainMessage);
                    }
                }
            } catch (com.amap.api.services.core.AMapException e) {
                districtResult.setAMapException(e);
                obtainMessage.arg1 = 4;
                obtainMessage.obj = com.amap.api.col.s.ay.this.c;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putParcelable("result", districtResult);
                obtainMessage.setData(bundle2);
                if (com.amap.api.col.s.ay.this.f != null) {
                    com.amap.api.col.s.ay.this.f.sendMessage(obtainMessage);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.i.a(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                obtainMessage.arg1 = 4;
                obtainMessage.obj = com.amap.api.col.s.ay.this.c;
                android.os.Bundle bundle3 = new android.os.Bundle();
                bundle3.putParcelable("result", districtResult);
                obtainMessage.setData(bundle3);
                if (com.amap.api.col.s.ay.this.f != null) {
                    com.amap.api.col.s.ay.this.f.sendMessage(obtainMessage);
                }
            }
        }
    }

    public ay(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.f = com.amap.api.col.s.s.a();
    }

    public final com.amap.api.services.district.DistrictResult a(int i) throws com.amap.api.services.core.AMapException {
        if (f(i)) {
            return g.get(java.lang.Integer.valueOf(i));
        }
        throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
    }

    public final void c(com.amap.api.services.district.DistrictResult districtResult) {
        int i;
        g = new java.util.HashMap<>();
        com.amap.api.services.district.DistrictSearchQuery districtSearchQuery = this.b;
        if (districtSearchQuery == null || districtResult == null || (i = this.e) <= 0 || i <= districtSearchQuery.getPageNum()) {
            return;
        }
        g.put(java.lang.Integer.valueOf(this.b.getPageNum()), districtResult);
    }

    public final boolean d() {
        return this.b != null;
    }

    public final boolean f(int i) {
        return i < this.e && i >= 0;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final com.amap.api.services.district.DistrictSearchQuery getQuery() {
        return this.b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final com.amap.api.services.district.DistrictResult searchDistrict() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.district.DistrictResult a;
        int i;
        try {
            com.amap.api.services.district.DistrictResult districtResult = new com.amap.api.services.district.DistrictResult();
            com.amap.api.col.s.q.a(this.a);
            if (!d()) {
                this.b = new com.amap.api.services.district.DistrictSearchQuery();
            }
            districtResult.setQuery(this.b.m30clone());
            if (!this.b.weakEquals(this.d)) {
                this.e = 0;
                this.d = this.b.m30clone();
                java.util.HashMap<java.lang.Integer, com.amap.api.services.district.DistrictResult> hashMap = g;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            if (this.e == 0) {
                a = new com.amap.api.col.s.k(this.a, this.b.m30clone()).b();
                if (a == null) {
                    return a;
                }
                this.e = a.getPageCount();
                c(a);
            } else {
                a = a(this.b.getPageNum());
                if (a == null) {
                    a = new com.amap.api.col.s.k(this.a, this.b.m30clone()).b();
                    com.amap.api.services.district.DistrictSearchQuery districtSearchQuery = this.b;
                    if (districtSearchQuery != null && a != null && (i = this.e) > 0 && i > districtSearchQuery.getPageNum()) {
                        g.put(java.lang.Integer.valueOf(this.b.getPageNum()), a);
                    }
                }
            }
            return a;
        } catch (com.amap.api.services.core.AMapException e) {
            com.amap.api.col.s.i.a(e, "DistrictSearch", "searchDistrict");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAnsy() {
        searchDistrictAsyn();
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void searchDistrictAsyn() {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.ay.AnonymousClass1());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setOnDistrictSearchListener(com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public final void setQuery(com.amap.api.services.district.DistrictSearchQuery districtSearchQuery) {
        this.b = districtSearchQuery;
    }
}

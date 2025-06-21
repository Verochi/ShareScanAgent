package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class aw implements com.amap.api.services.interfaces.ICloudSearch {
    public android.content.Context a;
    public com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener b;
    public com.amap.api.services.cloud.CloudSearch.Query c;
    public int d;
    public java.util.HashMap<java.lang.Integer, com.amap.api.services.cloud.CloudResult> e;
    public android.os.Handler f;

    /* renamed from: com.amap.api.col.s.aw$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ com.amap.api.services.cloud.CloudSearch.Query n;

        public AnonymousClass1(com.amap.api.services.cloud.CloudSearch.Query query) {
            this.n = query;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 700;
                    com.amap.api.col.s.s.d dVar = new com.amap.api.col.s.s.d();
                    dVar.b = com.amap.api.col.s.aw.this.b;
                    obtainMessage.obj = dVar;
                    dVar.a = com.amap.api.col.s.aw.this.e(this.n);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.aw.this.f.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.amap.api.col.s.aw$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.String n;
        public final /* synthetic */ java.lang.String t;

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.n = str;
            this.t = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Message obtainMessage = com.amap.api.col.s.s.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_BUFFERING_START;
                    com.amap.api.col.s.s.c cVar = new com.amap.api.col.s.s.c();
                    cVar.b = com.amap.api.col.s.aw.this.b;
                    obtainMessage.obj = cVar;
                    cVar.a = com.amap.api.col.s.aw.this.b(this.n, this.t);
                    obtainMessage.arg2 = 1000;
                } catch (com.amap.api.services.core.AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                com.amap.api.col.s.aw.this.f.sendMessage(obtainMessage);
            }
        }
    }

    public aw(android.content.Context context) throws com.amap.api.services.core.AMapException {
        com.amap.api.col.s.bs a = com.amap.api.col.s.br.a(context, com.amap.api.col.s.h.a(false));
        if (a.a != com.amap.api.col.s.br.c.SuccessCode) {
            java.lang.String str = a.b;
            throw new com.amap.api.services.core.AMapException(str, 1, str, a.a.a());
        }
        this.a = context.getApplicationContext();
        this.f = com.amap.api.col.s.s.a();
    }

    public static boolean j(com.amap.api.services.cloud.CloudSearch.Query query) {
        if (query == null || com.amap.api.col.s.i.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            com.amap.api.services.core.LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            com.amap.api.services.core.LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        java.util.List<com.amap.api.services.core.LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    public final com.amap.api.services.cloud.CloudItemDetail b(java.lang.String str, java.lang.String str2) throws com.amap.api.services.core.AMapException {
        if (str == null || str.trim().equals("")) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        if (str2 == null || str2.trim().equals("")) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        try {
            return new com.amap.api.col.s.f(this.a, new com.amap.api.col.s.aa(str, str2)).b();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.i.a(th, "CloudSearch", "searchCloudDetail");
            if (th instanceof com.amap.api.services.core.AMapException) {
                throw th;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.services.cloud.CloudResult c(int i) {
        if (i(i)) {
            return this.e.get(java.lang.Integer.valueOf(i));
        }
        throw new java.lang.IllegalArgumentException("page out of range");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final com.amap.api.services.cloud.CloudResult e(com.amap.api.services.cloud.CloudSearch.Query query) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.cloud.CloudResult cloudResult = null;
        try {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        if (!j(query)) {
            throw new com.amap.api.services.core.AMapException("无效的参数 - IllegalArgumentException");
        }
        if (!query.queryEquals(this.c)) {
            this.d = 0;
            this.c = query.m28clone();
            java.util.HashMap<java.lang.Integer, com.amap.api.services.cloud.CloudResult> hashMap = this.e;
            if (hashMap != null) {
                hashMap.clear();
            }
        }
        ?? r1 = this.d;
        try {
        } catch (java.lang.Throwable th2) {
            th = th2;
            cloudResult = r1;
            com.amap.api.col.s.i.a(th, "CloudSearch", "searchCloud");
            if (th instanceof com.amap.api.services.core.AMapException) {
                throw th;
            }
            th.printStackTrace();
            return cloudResult;
        }
        if (r1 != 0) {
            cloudResult = c(query.getPageNum());
            if (cloudResult == null) {
                com.amap.api.services.cloud.CloudResult b = new com.amap.api.col.s.g(this.a, query).b();
                this.e.put(java.lang.Integer.valueOf(query.getPageNum()), b);
                r1 = b;
            }
            return cloudResult;
        }
        com.amap.api.services.cloud.CloudResult b2 = new com.amap.api.col.s.g(this.a, query).b();
        g(b2, query);
        r1 = b2;
        return r1;
    }

    public final void g(com.amap.api.services.cloud.CloudResult cloudResult, com.amap.api.services.cloud.CloudSearch.Query query) {
        java.util.HashMap<java.lang.Integer, com.amap.api.services.cloud.CloudResult> hashMap = new java.util.HashMap<>();
        this.e = hashMap;
        if (this.d > 0) {
            hashMap.put(java.lang.Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    public final boolean i(int i) {
        return i <= this.d && i > 0;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(com.amap.api.services.cloud.CloudSearch.Query query) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.aw.AnonymousClass1(query));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(java.lang.String str, java.lang.String str2) {
        try {
            com.amap.api.col.s.an.a().a(new com.amap.api.col.s.aw.AnonymousClass2(str, str2));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }
}

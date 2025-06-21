package com.amap.api.maps.offlinemap;

/* loaded from: classes12.dex */
public final class OfflineMapManager {
    com.amap.api.mapcore.util.aq a;
    com.amap.api.mapcore.util.am b;
    private android.content.Context c;
    private com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener d;
    private com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener e;
    private android.os.Handler f;
    private android.os.Handler g;

    /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$1, reason: invalid class name */
    public class AnonymousClass1 implements com.amap.api.mapcore.util.am.a {

        /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01261 implements java.lang.Runnable {
            final /* synthetic */ com.amap.api.mapcore.util.al a;

            public RunnableC01261(com.amap.api.mapcore.util.al alVar) {
                this.a = alVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.amap.api.maps.offlinemap.OfflineMapManager.this.d.onDownload(this.a.c().b(), this.a.getcompleteCode(), this.a.getCity());
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.amap.api.mapcore.util.al a;

            public AnonymousClass2(com.amap.api.mapcore.util.al alVar) {
                this.a = alVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (!this.a.c().equals(this.a.g) && !this.a.c().equals(this.a.a)) {
                        com.amap.api.maps.offlinemap.OfflineMapManager.this.d.onCheckUpdate(false, this.a.getCity());
                        return;
                    }
                    com.amap.api.maps.offlinemap.OfflineMapManager.this.d.onCheckUpdate(true, this.a.getCity());
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$1$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.amap.api.mapcore.util.al a;

            public AnonymousClass3(com.amap.api.mapcore.util.al alVar) {
                this.a = alVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (this.a.c().equals(this.a.a)) {
                        com.amap.api.maps.offlinemap.OfflineMapManager.this.d.onRemove(true, this.a.getCity(), "");
                    } else {
                        com.amap.api.maps.offlinemap.OfflineMapManager.this.d.onRemove(false, this.a.getCity(), "");
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$1$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.amap.api.maps.offlinemap.OfflineMapManager.this.e.onVerifyComplete();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.amap.api.mapcore.util.am.a
        public final void a() {
            if (com.amap.api.maps.offlinemap.OfflineMapManager.this.e != null) {
                com.amap.api.maps.offlinemap.OfflineMapManager.this.f.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass4());
            }
        }

        @Override // com.amap.api.mapcore.util.am.a
        public final void a(com.amap.api.mapcore.util.al alVar) {
            if (com.amap.api.maps.offlinemap.OfflineMapManager.this.d == null || alVar == null) {
                return;
            }
            com.amap.api.maps.offlinemap.OfflineMapManager.this.f.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.RunnableC01261(alVar));
        }

        @Override // com.amap.api.mapcore.util.am.a
        public final void b(com.amap.api.mapcore.util.al alVar) {
            if (com.amap.api.maps.offlinemap.OfflineMapManager.this.d == null || alVar == null) {
                return;
            }
            com.amap.api.maps.offlinemap.OfflineMapManager.this.f.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass2(alVar));
        }

        @Override // com.amap.api.mapcore.util.am.a
        public final void c(com.amap.api.mapcore.util.al alVar) {
            if (com.amap.api.maps.offlinemap.OfflineMapManager.this.d == null || alVar == null) {
                return;
            }
            com.amap.api.maps.offlinemap.OfflineMapManager.this.f.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1.AnonymousClass3(alVar));
        }
    }

    /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.amap.api.maps.offlinemap.OfflineMapManager.this.b.e(this.a);
            } catch (com.amap.api.maps.AMapException e) {
                com.amap.api.mapcore.util.gd.c(e, "OfflineMapManager", "downloadByProvinceName");
            }
        }
    }

    /* renamed from: com.amap.api.maps.offlinemap.OfflineMapManager$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.amap.api.maps.offlinemap.OfflineMapManager.this.b.c(this.a);
        }
    }

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, java.lang.String str);

        void onDownload(int i, int i2, java.lang.String str);

        void onRemove(boolean z, java.lang.String str, java.lang.String str2);
    }

    public OfflineMapManager(android.content.Context context, com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener offlineMapDownloadListener) throws java.lang.Exception {
        com.amap.api.mapcore.util.ff a = com.amap.api.mapcore.util.fe.a(context, com.amap.api.mapcore.util.dl.a());
        if (a.a != com.amap.api.mapcore.util.fe.c.SuccessCode) {
            throw new java.lang.Exception(a.b);
        }
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new android.os.Handler(this.c.getMainLooper());
        this.g = new android.os.Handler(this.c.getMainLooper());
        a(context);
        com.amap.api.mapcore.util.fb.a().a(this.c);
    }

    public OfflineMapManager(android.content.Context context, com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener offlineMapDownloadListener, com.amap.api.maps.AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        this.f = new android.os.Handler(this.c.getMainLooper());
        this.g = new android.os.Handler(this.c.getMainLooper());
        try {
            a(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws com.amap.api.maps.AMapException {
        if (!com.amap.api.mapcore.util.dl.d(this.c)) {
            throw new com.amap.api.maps.AMapException(com.amap.api.maps.AMapException.ERROR_CONNECTION);
        }
    }

    private void a(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        com.amap.api.mapcore.util.am.b = false;
        com.amap.api.mapcore.util.am a = com.amap.api.mapcore.util.am.a(applicationContext);
        this.b = a;
        a.a(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass1());
        try {
            this.b.a();
            this.a = this.b.f;
            com.amap.api.mapcore.util.di.b(context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(java.lang.String str) throws com.amap.api.maps.AMapException {
        this.b.a(str);
    }

    private void b() {
        this.d = null;
    }

    public final void destroy() {
        try {
            com.amap.api.mapcore.util.am amVar = this.b;
            if (amVar != null) {
                amVar.f();
            }
            b();
            android.os.Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
            android.os.Handler handler2 = this.g;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(java.lang.String str) throws com.amap.api.maps.AMapException {
        try {
            this.b.f(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(java.lang.String str) throws com.amap.api.maps.AMapException {
        try {
            this.b.e(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(java.lang.String str) throws com.amap.api.maps.AMapException {
        try {
            a();
            com.amap.api.maps.offlinemap.OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new com.amap.api.maps.AMapException("无效的参数 - IllegalArgumentException");
            }
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                this.g.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass2(it.next().getCity()));
            }
        } catch (java.lang.Throwable th) {
            if (th instanceof com.amap.api.maps.AMapException) {
                throw th;
            }
            com.amap.api.mapcore.util.gd.c(th, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.c();
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.d();
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> getDownloadingCityList() {
        return this.a.e();
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.f();
    }

    public final com.amap.api.maps.offlinemap.OfflineMapCity getItemByCityCode(java.lang.String str) {
        return this.a.a(str);
    }

    public final com.amap.api.maps.offlinemap.OfflineMapCity getItemByCityName(java.lang.String str) {
        return this.a.b(str);
    }

    public final com.amap.api.maps.offlinemap.OfflineMapProvince getItemByProvinceName(java.lang.String str) {
        return this.a.c(str);
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapCity> getOfflineMapCityList() {
        return this.a.b();
    }

    public final java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.a();
    }

    public final void pause() {
        this.b.e();
    }

    public final void pauseByName(java.lang.String str) {
        this.b.d(str);
    }

    public final void remove(java.lang.String str) {
        try {
            if (this.b.b(str)) {
                this.b.c(str);
                return;
            }
            com.amap.api.maps.offlinemap.OfflineMapProvince c = this.a.c(str);
            if (c != null && c.getCityList() != null) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it = c.getCityList().iterator();
                while (it.hasNext()) {
                    this.g.post(new com.amap.api.maps.offlinemap.OfflineMapManager.AnonymousClass3(it.next().getCity()));
                }
                return;
            }
            com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener offlineMapDownloadListener = this.d;
            if (offlineMapDownloadListener != null) {
                offlineMapDownloadListener.onRemove(false, str, "没有该城市");
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void restart() {
    }

    public final void setOnOfflineLoadedListener(com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }

    public final void stop() {
        this.b.d();
    }

    public final void updateOfflineCityByCode(java.lang.String str) throws com.amap.api.maps.AMapException {
        com.amap.api.maps.offlinemap.OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new com.amap.api.maps.AMapException("无效的参数 - IllegalArgumentException");
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(java.lang.String str) throws com.amap.api.maps.AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(java.lang.String str) throws com.amap.api.maps.AMapException {
        a(str);
    }
}

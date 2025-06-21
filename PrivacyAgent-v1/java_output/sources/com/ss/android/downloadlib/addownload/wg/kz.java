package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class kz {
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.download.api.download.DownloadEventConfig> t;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.download.api.download.DownloadController> v;
    private volatile boolean vw;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.download.api.download.DownloadModel> wg;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> yl;

    /* renamed from: com.ss.android.downloadlib.addownload.wg.kz$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.downloadlib.addownload.wg.kz.this.vw) {
                return;
            }
            synchronized (com.ss.android.downloadlib.addownload.wg.kz.class) {
                if (!com.ss.android.downloadlib.addownload.wg.kz.this.vw) {
                    com.ss.android.downloadlib.addownload.wg.kz.this.yl.putAll(com.ss.android.downloadlib.addownload.wg.x.vw().wg());
                    com.ss.android.downloadlib.addownload.wg.kz.this.vw = true;
                }
            }
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.addownload.wg.kz vw = new com.ss.android.downloadlib.addownload.wg.kz(null);
    }

    private kz() {
        this.vw = false;
        this.wg = new java.util.concurrent.ConcurrentHashMap<>();
        this.t = new java.util.concurrent.ConcurrentHashMap<>();
        this.v = new java.util.concurrent.ConcurrentHashMap<>();
        this.yl = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public /* synthetic */ kz(com.ss.android.downloadlib.addownload.wg.kz.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.addownload.wg.kz vw() {
        return com.ss.android.downloadlib.addownload.wg.kz.vw.vw;
    }

    public void kz(long j) {
        this.wg.remove(java.lang.Long.valueOf(j));
        this.t.remove(java.lang.Long.valueOf(j));
        this.v.remove(java.lang.Long.valueOf(j));
    }

    public com.ss.android.download.api.download.DownloadController t(long j) {
        return this.v.get(java.lang.Long.valueOf(j));
    }

    public java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> t() {
        return this.yl;
    }

    public com.ss.android.downloadad.api.vw.wg v(long j) {
        return this.yl.get(java.lang.Long.valueOf(j));
    }

    public com.ss.android.download.api.download.DownloadModel vw(long j) {
        return this.wg.get(java.lang.Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.vw.wg vw(int i) {
        for (com.ss.android.downloadad.api.vw.wg wgVar : this.yl.values()) {
            if (wgVar != null && wgVar.tq() == i) {
                return wgVar;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.vw.wg vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        for (com.ss.android.downloadad.api.vw.wg wgVar : this.yl.values()) {
            if (wgVar != null && wgVar.tq() == downloadInfo.getId()) {
                return wgVar;
            }
        }
        if (!android.text.TextUtils.isEmpty(downloadInfo.getExtra())) {
            try {
                long vw2 = com.ss.android.downloadlib.bt.vl.vw(new org.json.JSONObject(downloadInfo.getExtra()), "extra");
                if (vw2 != 0) {
                    for (com.ss.android.downloadad.api.vw.wg wgVar2 : this.yl.values()) {
                        if (wgVar2 != null && wgVar2.wg() == vw2) {
                            return wgVar2;
                        }
                    }
                    com.ss.android.downloadlib.yl.t.vw().vw("getNativeModelByInfo");
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        for (com.ss.android.downloadad.api.vw.wg wgVar3 : this.yl.values()) {
            if (wgVar3 != null && android.text.TextUtils.equals(wgVar3.vw(), downloadInfo.getUrl())) {
                return wgVar3;
            }
        }
        return null;
    }

    public com.ss.android.downloadad.api.vw.wg vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.vw.wg wgVar : this.yl.values()) {
            if (wgVar != null && str.equals(wgVar.yl())) {
                return wgVar;
            }
        }
        return null;
    }

    @androidx.annotation.NonNull
    public java.util.Map<java.lang.Long, com.ss.android.downloadad.api.vw.wg> vw(java.lang.String str, java.lang.String str2) {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            for (com.ss.android.downloadad.api.vw.wg wgVar : this.yl.values()) {
                if (wgVar != null && android.text.TextUtils.equals(wgVar.vw(), str)) {
                    wgVar.wg(str2);
                    hashMap.put(java.lang.Long.valueOf(wgVar.wg()), wgVar);
                }
            }
        }
        return hashMap;
    }

    public void vw(long j, com.ss.android.download.api.download.DownloadController downloadController) {
        if (downloadController != null) {
            this.v.put(java.lang.Long.valueOf(j), downloadController);
        }
    }

    public void vw(long j, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
        if (downloadEventConfig != null) {
            this.t.put(java.lang.Long.valueOf(j), downloadEventConfig);
        }
    }

    public void vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel != null) {
            this.wg.put(java.lang.Long.valueOf(downloadModel.getId()), downloadModel);
            if (downloadModel.getDeepLink() != null) {
                downloadModel.getDeepLink().setId(downloadModel.getId());
                downloadModel.getDeepLink().setPackageName(downloadModel.getPackageName());
            }
        }
    }

    public synchronized void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        if (wgVar == null) {
            return;
        }
        this.yl.put(java.lang.Long.valueOf(wgVar.wg()), wgVar);
        com.ss.android.downloadlib.addownload.wg.x.vw().vw(wgVar);
    }

    public synchronized void vw(java.util.List<java.lang.Long> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.Long> it = list.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            arrayList.add(java.lang.String.valueOf(longValue));
            this.yl.remove(java.lang.Long.valueOf(longValue));
        }
        com.ss.android.downloadlib.addownload.wg.x.vw().vw((java.util.List<java.lang.String>) arrayList);
    }

    public com.ss.android.download.api.download.DownloadEventConfig wg(long j) {
        return this.t.get(java.lang.Long.valueOf(j));
    }

    public com.ss.android.downloadad.api.vw.wg wg(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.downloadad.api.vw.wg wgVar : this.yl.values()) {
            if (wgVar != null && str.equals(wgVar.vw())) {
                return wgVar;
            }
        }
        return null;
    }

    public void wg() {
        com.ss.android.downloadlib.v.vw().vw((java.lang.Runnable) new com.ss.android.downloadlib.addownload.wg.kz.AnonymousClass1(), true);
    }

    public void wg(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        for (com.ss.android.download.api.download.DownloadModel downloadModel : this.wg.values()) {
            if ((downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) && android.text.TextUtils.equals(downloadModel.getDownloadUrl(), str)) {
                ((com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel).setPackageName(str2);
            }
        }
    }

    @androidx.annotation.NonNull
    public com.ss.android.downloadlib.addownload.wg.yl yl(long j) {
        com.ss.android.downloadlib.addownload.wg.yl ylVar = new com.ss.android.downloadlib.addownload.wg.yl();
        ylVar.vw = j;
        ylVar.wg = vw(j);
        com.ss.android.download.api.download.DownloadEventConfig wg = wg(j);
        ylVar.t = wg;
        if (wg == null) {
            ylVar.t = new com.ss.android.download.api.download.t();
        }
        com.ss.android.download.api.download.DownloadController t = t(j);
        ylVar.v = t;
        if (t == null) {
            ylVar.v = new com.ss.android.download.api.download.wg();
        }
        return ylVar;
    }
}

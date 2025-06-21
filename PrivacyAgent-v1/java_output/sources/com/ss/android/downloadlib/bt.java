package com.ss.android.downloadlib;

/* loaded from: classes19.dex */
public class bt {
    private static volatile com.ss.android.downloadlib.bt vw;
    private long kz;
    private final java.util.List<com.ss.android.downloadlib.addownload.bt> t = new java.util.concurrent.CopyOnWriteArrayList();
    private final java.util.Map<java.lang.String, com.ss.android.downloadlib.addownload.bt> v = new java.util.concurrent.ConcurrentHashMap();
    private final java.util.concurrent.CopyOnWriteArrayList<java.lang.Object> yl = new java.util.concurrent.CopyOnWriteArrayList<>();
    private final android.os.Handler wg = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.bt$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.download.api.download.DownloadEventConfig t;
        final /* synthetic */ com.ss.android.download.api.download.DownloadModel vw;
        final /* synthetic */ com.ss.android.download.api.download.DownloadController wg;

        public AnonymousClass1(com.ss.android.download.api.download.DownloadModel downloadModel, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
            this.vw = downloadModel;
            this.wg = downloadController;
            this.t = downloadEventConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = com.ss.android.downloadlib.bt.this.yl.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.vw.vw) {
                    ((com.ss.android.download.api.download.vw.vw) next).vw(this.vw, this.wg, this.t);
                } else if (next instanceof java.lang.ref.SoftReference) {
                    java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.vw.vw) {
                        ((com.ss.android.download.api.download.vw.vw) softReference.get()).vw(this.vw, this.wg, this.t);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String t;
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ com.ss.android.socialbase.downloader.exception.BaseException wg;

        public AnonymousClass2(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, java.lang.String str) {
            this.vw = downloadInfo;
            this.wg = baseException;
            this.t = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = com.ss.android.downloadlib.bt.this.yl.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.vw.vw) {
                    ((com.ss.android.download.api.download.vw.vw) next).vw(this.vw, this.wg, this.t);
                } else if (next instanceof java.lang.ref.SoftReference) {
                    java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.vw.vw) {
                        ((com.ss.android.download.api.download.vw.vw) softReference.get()).vw(this.vw, this.wg, this.t);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ java.lang.String wg;

        public AnonymousClass3(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
            this.vw = downloadInfo;
            this.wg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = com.ss.android.downloadlib.bt.this.yl.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.vw.vw) {
                    ((com.ss.android.download.api.download.vw.vw) next).vw(this.vw, this.wg);
                } else if (next instanceof java.lang.ref.SoftReference) {
                    java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.vw.vw) {
                        ((com.ss.android.download.api.download.vw.vw) softReference.get()).vw(this.vw, this.wg);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;
        final /* synthetic */ java.lang.String wg;

        public AnonymousClass4(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
            this.vw = downloadInfo;
            this.wg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = com.ss.android.downloadlib.bt.this.yl.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.vw.vw) {
                    ((com.ss.android.download.api.download.vw.vw) next).wg(this.vw, this.wg);
                } else if (next instanceof java.lang.ref.SoftReference) {
                    java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.vw.vw) {
                        ((com.ss.android.download.api.download.vw.vw) softReference.get()).wg(this.vw, this.wg);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo vw;

        public AnonymousClass5(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            this.vw = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.Iterator it = com.ss.android.downloadlib.bt.this.yl.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.vw.vw) {
                    ((com.ss.android.download.api.download.vw.vw) next).vw(this.vw);
                } else if (next instanceof java.lang.ref.SoftReference) {
                    java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.vw.vw) {
                        ((com.ss.android.download.api.download.vw.vw) softReference.get()).vw(this.vw);
                    }
                }
            }
        }
    }

    private bt() {
    }

    private void t() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - this.kz < 300000) {
            return;
        }
        this.kz = currentTimeMillis;
        if (this.t.isEmpty()) {
            return;
        }
        v();
    }

    private void t(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.yl ylVar = new com.ss.android.downloadlib.addownload.yl();
        ylVar.wg(context).wg(i, downloadStatusChangeListener).wg(downloadModel).vw();
        this.v.put(downloadModel.getDownloadUrl(), ylVar);
    }

    private void v() {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.ss.android.downloadlib.addownload.bt btVar : this.t) {
            if (!btVar.wg() && currentTimeMillis - btVar.v() > 300000) {
                btVar.o();
                arrayList.add(btVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.t.removeAll(arrayList);
    }

    public static com.ss.android.downloadlib.bt vw() {
        if (vw == null) {
            synchronized (com.ss.android.downloadlib.bt.class) {
                if (vw == null) {
                    vw = new com.ss.android.downloadlib.bt();
                }
            }
        }
        return vw;
    }

    private synchronized void vw(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel, java.lang.String str) {
        if (this.t.size() <= 0) {
            wg(context, i, downloadStatusChangeListener, downloadModel, str);
            return;
        }
        com.ss.android.downloadlib.addownload.bt remove = this.t.remove(0);
        remove.wg(context).wg(i, downloadStatusChangeListener).wg(downloadModel).vw(str).vw();
        this.v.put(str, remove);
        com.ss.android.downloadlib.addownload.kz.vw().vw(str, downloadModel.getDownloadUrl());
    }

    private synchronized void wg(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel) {
        if (this.t.size() <= 0) {
            t(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.ss.android.downloadlib.addownload.bt remove = this.t.remove(0);
        remove.wg(context).wg(i, downloadStatusChangeListener).wg(downloadModel).vw();
        this.v.put(downloadModel.getDownloadUrl(), remove);
    }

    private void wg(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel, java.lang.String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.yl ylVar = new com.ss.android.downloadlib.addownload.yl();
        ylVar.wg(context).wg(i, downloadStatusChangeListener).wg(downloadModel).vw(str).vw();
        this.v.put(str, ylVar);
        com.ss.android.downloadlib.addownload.kz.vw().vw(str, downloadModel.getDownloadUrl());
    }

    public com.ss.android.downloadlib.addownload.yl vw(java.lang.String str) {
        java.util.Map<java.lang.String, com.ss.android.downloadlib.addownload.bt> map = this.v;
        if (map != null && map.size() != 0 && !android.text.TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.bt btVar = com.ss.android.downloadlib.addownload.z.x().optInt("filter_download_url_key", 0) == 1 ? this.v.get(com.ss.android.downloadlib.addownload.kz.vw().vw(str)) : this.v.get(str);
            if (btVar instanceof com.ss.android.downloadlib.addownload.yl) {
                return (com.ss.android.downloadlib.addownload.yl) btVar;
            }
        }
        return null;
    }

    public void vw(android.content.Context context, int i, com.ss.android.download.api.download.DownloadStatusChangeListener downloadStatusChangeListener, com.ss.android.download.api.download.DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.bt btVar;
        if (downloadModel == null || android.text.TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = com.ss.android.downloadlib.addownload.z.x().optInt("filter_download_url_key", 0) == 1;
        java.lang.String vw2 = com.ss.android.downloadlib.addownload.kz.vw().vw(downloadModel.getDownloadUrl());
        if (!z || android.text.TextUtils.isEmpty(vw2)) {
            btVar = this.v.get(downloadModel.getDownloadUrl());
        } else {
            btVar = this.v.get(vw2);
            if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
                com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel = (com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel;
                if (android.text.TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(vw2);
                }
            }
        }
        if (btVar != null) {
            btVar.wg(context).wg(i, downloadStatusChangeListener).wg(downloadModel).vw();
            return;
        }
        if (this.t.isEmpty()) {
            if (z) {
                if (!android.text.TextUtils.isEmpty(vw2)) {
                    wg(context, i, downloadStatusChangeListener, downloadModel, vw2);
                    return;
                }
                java.lang.String vw3 = com.ss.android.downloadlib.addownload.kz.vw().vw(downloadModel);
                if (!android.text.TextUtils.isEmpty(vw3)) {
                    wg(context, i, downloadStatusChangeListener, downloadModel, vw3);
                    if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
                        com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel2 = (com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel;
                        if (android.text.TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                            adDownloadModel2.setTaskKey(vw3);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            t(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (!z) {
            wg(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (!android.text.TextUtils.isEmpty(vw2)) {
            vw(context, i, downloadStatusChangeListener, downloadModel, vw2);
            return;
        }
        java.lang.String vw4 = com.ss.android.downloadlib.addownload.kz.vw().vw(downloadModel);
        if (android.text.TextUtils.isEmpty(vw4)) {
            wg(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        vw(context, i, downloadStatusChangeListener, downloadModel, vw4);
        if (downloadModel instanceof com.ss.android.downloadad.api.download.AdDownloadModel) {
            com.ss.android.downloadad.api.download.AdDownloadModel adDownloadModel3 = (com.ss.android.downloadad.api.download.AdDownloadModel) downloadModel;
            if (android.text.TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                adDownloadModel3.setTaskKey(vw4);
            }
        }
    }

    public void vw(com.ss.android.download.api.download.DownloadModel downloadModel, @androidx.annotation.Nullable com.ss.android.download.api.download.DownloadController downloadController, @androidx.annotation.Nullable com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig) {
        this.wg.post(new com.ss.android.downloadlib.bt.AnonymousClass1(downloadModel, downloadController, downloadEventConfig));
    }

    public void vw(com.ss.android.download.api.download.vw.vw vwVar) {
        if (vwVar != null) {
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.yl.add(new java.lang.ref.SoftReference(vwVar));
            } else {
                this.yl.add(vwVar);
            }
        }
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        this.wg.post(new com.ss.android.downloadlib.bt.AnonymousClass5(downloadInfo));
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, java.lang.String str) {
        this.wg.post(new com.ss.android.downloadlib.bt.AnonymousClass2(downloadInfo, baseException, str));
    }

    public void vw(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
        this.wg.post(new com.ss.android.downloadlib.bt.AnonymousClass3(downloadInfo, str));
    }

    public void vw(java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = com.ss.android.downloadlib.addownload.z.x().optInt("filter_download_url_key", 0) == 1;
        java.lang.String vw2 = com.ss.android.downloadlib.addownload.kz.vw().vw(str);
        com.ss.android.downloadlib.addownload.bt btVar = (!z || android.text.TextUtils.isEmpty(vw2)) ? this.v.get(str) : this.v.get(vw2);
        if (btVar != null) {
            if (btVar.vw(i)) {
                this.t.add(btVar);
                if (!z || android.text.TextUtils.isEmpty(vw2)) {
                    this.v.remove(str);
                } else {
                    this.v.remove(vw2);
                    com.ss.android.downloadlib.addownload.kz.vw().wg(vw2);
                }
            }
            t();
        }
    }

    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController) {
        vw(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        vw(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void vw(java.lang.String str, long j, int i, com.ss.android.download.api.download.DownloadEventConfig downloadEventConfig, com.ss.android.download.api.download.DownloadController downloadController, com.ss.android.download.api.config.OnItemClickListener onItemClickListener, com.ss.android.download.api.config.IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = com.ss.android.downloadlib.addownload.z.x().optInt("filter_download_url_key", 0) == 1;
        java.lang.String vw2 = com.ss.android.downloadlib.addownload.kz.vw().vw(str);
        com.ss.android.downloadlib.addownload.bt btVar = (!z || android.text.TextUtils.isEmpty(vw2)) ? this.v.get(str) : this.v.get(vw2);
        if (btVar != null) {
            btVar.vw(j).wg(downloadEventConfig).wg(downloadController).vw(onItemClickListener).vw(iDownloadButtonClickListener).wg(i);
        }
    }

    public void vw(java.lang.String str, boolean z) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = com.ss.android.downloadlib.addownload.z.x().optInt("filter_download_url_key", 0) == 1;
        java.lang.String vw2 = com.ss.android.downloadlib.addownload.kz.vw().vw(str);
        com.ss.android.downloadlib.addownload.bt btVar = (!z2 || android.text.TextUtils.isEmpty(vw2)) ? this.v.get(str) : this.v.get(vw2);
        if (btVar != null) {
            btVar.vw(z);
        }
    }

    public android.os.Handler wg() {
        return this.wg;
    }

    public void wg(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) {
        this.wg.post(new com.ss.android.downloadlib.bt.AnonymousClass4(downloadInfo, str));
    }
}

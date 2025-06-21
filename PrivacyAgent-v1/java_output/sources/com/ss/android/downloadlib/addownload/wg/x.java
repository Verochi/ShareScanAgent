package com.ss.android.downloadlib.addownload.wg;

/* loaded from: classes19.dex */
public class x {

    /* renamed from: com.ss.android.downloadlib.addownload.wg.x$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.Collection vw;

        public AnonymousClass1(java.util.Collection collection) {
            this.vw = collection;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.SharedPreferences.Editor edit = com.ss.android.downloadlib.addownload.wg.x.this.t().edit();
            for (com.ss.android.downloadad.api.vw.wg wgVar : this.vw) {
                if (wgVar != null && wgVar.wg() != 0) {
                    edit.putString(java.lang.String.valueOf(wgVar.wg()), wgVar.wu().toString());
                }
            }
            edit.apply();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.wg.x$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.util.List vw;

        public AnonymousClass2(java.util.List list) {
            this.vw = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.content.SharedPreferences.Editor edit = com.ss.android.downloadlib.addownload.wg.x.this.t().edit();
            java.util.Iterator it = this.vw.iterator();
            while (it.hasNext()) {
                edit.remove((java.lang.String) it.next());
            }
            edit.apply();
        }
    }

    public static class vw {
        private static com.ss.android.downloadlib.addownload.wg.x vw = new com.ss.android.downloadlib.addownload.wg.x(null);
    }

    private x() {
    }

    public /* synthetic */ x(com.ss.android.downloadlib.addownload.wg.x.AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.SharedPreferences t() {
        return com.ss.android.downloadlib.addownload.z.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    public static com.ss.android.downloadlib.addownload.wg.x vw() {
        return com.ss.android.downloadlib.addownload.wg.x.vw.vw;
    }

    public void vw(com.ss.android.downloadad.api.vw.wg wgVar) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(wgVar);
        vw((java.util.Collection<com.ss.android.downloadad.api.vw.wg>) arrayList);
    }

    public synchronized void vw(java.util.Collection<com.ss.android.downloadad.api.vw.wg> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.v.vw().vw((java.lang.Runnable) new com.ss.android.downloadlib.addownload.wg.x.AnonymousClass1(collection), true);
            }
        }
    }

    public void vw(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.v.vw().vw((java.lang.Runnable) new com.ss.android.downloadlib.addownload.wg.x.AnonymousClass2(list), true);
    }

    @androidx.annotation.NonNull
    public java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> wg() {
        java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.ss.android.downloadad.api.vw.wg> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
        java.util.Map<java.lang.String, ?> all = t().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = java.lang.Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.vw.wg wg = com.ss.android.downloadad.api.vw.wg.wg(new org.json.JSONObject(java.lang.String.valueOf(entry.getValue())));
                    if (longValue > 0 && wg != null) {
                        concurrentHashMap.put(java.lang.Long.valueOf(longValue), wg);
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }
}

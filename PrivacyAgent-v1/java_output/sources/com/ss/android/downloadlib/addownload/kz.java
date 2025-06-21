package com.ss.android.downloadlib.addownload;

/* loaded from: classes19.dex */
public class kz {
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> vw;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> wg;

    public static class vw {
        private static com.ss.android.downloadlib.addownload.kz vw = new com.ss.android.downloadlib.addownload.kz(null);
    }

    private kz() {
        this.vw = new java.util.concurrent.ConcurrentHashMap<>();
        this.wg = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public /* synthetic */ kz(com.ss.android.downloadlib.addownload.kz.AnonymousClass1 anonymousClass1) {
        this();
    }

    private java.lang.String t(java.lang.String str) {
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            java.lang.String scheme = parse.getScheme();
            java.lang.String lastPathSegment = parse.getLastPathSegment();
            if (!android.text.TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(com.anythink.china.common.a.a.g)) {
                return null;
            }
            this.vw.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.ss.android.downloadlib.addownload.kz vw() {
        return com.ss.android.downloadlib.addownload.kz.vw.vw;
    }

    public java.lang.String vw(com.ss.android.download.api.download.DownloadModel downloadModel) {
        java.lang.String t = t(downloadModel.getDownloadUrl());
        if (t == null || android.text.TextUtils.isEmpty(t)) {
            return null;
        }
        java.lang.String md5Hex = com.ss.android.socialbase.downloader.utils.DownloadUtils.md5Hex(t + downloadModel.getPackageName());
        this.wg.put(downloadModel.getDownloadUrl(), md5Hex);
        return md5Hex;
    }

    public java.lang.String vw(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || this.wg.isEmpty() || !this.wg.containsKey(str)) {
            return null;
        }
        java.lang.String t = t(str);
        if (this.vw.containsValue(t)) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.vw.entrySet()) {
                if (android.text.TextUtils.equals(entry.getValue(), t)) {
                    java.lang.String str2 = this.wg.get(entry.getKey());
                    this.wg.put(str, str2);
                    if (!this.vw.containsKey(str)) {
                        this.vw.put(str, t);
                    }
                    return str2;
                }
            }
        }
        return this.wg.get(str);
    }

    public void vw(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || this.wg.containsKey(str2)) {
            return;
        }
        this.wg.put(str2, str);
    }

    public void wg(java.lang.String str) {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = this.wg.entrySet().iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<java.lang.String, java.lang.String> next = it.next();
            if (android.text.TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.vw.remove(next.getKey());
            }
        }
    }
}

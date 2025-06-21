package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class v extends com.ss.android.socialbase.downloader.utils.LruCache<java.lang.Long, android.graphics.Bitmap> {
    private final java.util.Map<java.lang.Long, java.lang.ref.SoftReference<com.ss.android.downloadlib.addownload.compliance.v.vw>> vw;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.v$1, reason: invalid class name */
    public class AnonymousClass1 implements com.ss.android.downloadlib.bt.t.vw<java.lang.Object, java.lang.Object> {
        final /* synthetic */ long vw;

        public AnonymousClass1(long j) {
            this.vw = j;
        }

        @Override // com.ss.android.downloadlib.bt.t.vw
        public java.lang.Object vw(java.lang.Object obj) {
            java.lang.ref.SoftReference softReference = (java.lang.ref.SoftReference) com.ss.android.downloadlib.addownload.compliance.v.this.vw.remove(java.lang.Long.valueOf(this.vw));
            if (softReference == null || softReference.get() == null) {
                return null;
            }
            ((com.ss.android.downloadlib.addownload.compliance.v.vw) softReference.get()).vw(com.ss.android.downloadlib.addownload.compliance.v.this.get(java.lang.Long.valueOf(this.vw)));
            return null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.v$2, reason: invalid class name */
    public class AnonymousClass2 implements com.ss.android.downloadlib.bt.t.vw<java.lang.Object, java.lang.Object> {
        final /* synthetic */ long t;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ long wg;

        public AnonymousClass2(java.lang.String str, long j, long j2) {
            this.vw = str;
            this.wg = j;
            this.t = j2;
        }

        @Override // com.ss.android.downloadlib.bt.t.vw
        public java.lang.Object vw(java.lang.Object obj) {
            java.io.BufferedInputStream bufferedInputStream;
            java.lang.Throwable th;
            com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection;
            try {
                downloadWithConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection(true, 0, this.vw, null);
            } catch (java.lang.Exception e) {
                e = e;
                bufferedInputStream = null;
            } catch (java.lang.Throwable th2) {
                bufferedInputStream = null;
                th = th2;
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedInputStream);
                throw th;
            }
            if (downloadWithConnection == null) {
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(null);
                return null;
            }
            bufferedInputStream = new java.io.BufferedInputStream(downloadWithConnection.getInputStream());
            try {
                try {
                    bufferedInputStream.mark(bufferedInputStream.available());
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    android.graphics.BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    int i = options.outWidth;
                    int i2 = options.outHeight;
                    int vw = com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), 60.0f);
                    options.inSampleSize = com.ss.android.downloadlib.addownload.compliance.v.wg(vw, vw, options);
                    options.inJustDecodeBounds = false;
                    bufferedInputStream.reset();
                    android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(bufferedInputStream, null, options);
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                        jSONObject.putOpt("bm_original_w", java.lang.Integer.valueOf(i));
                        jSONObject.putOpt("bm_original_h", java.lang.Integer.valueOf(i2));
                        jSONObject.putOpt("bm_bytes", java.lang.Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                    com.ss.android.downloadlib.v.vw.vw().vw("ttd_pref_monitor", jSONObject, this.wg);
                    com.ss.android.downloadlib.addownload.compliance.v.this.put(java.lang.Long.valueOf(this.t), decodeStream);
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedInputStream);
                } catch (java.lang.Exception e3) {
                    e = e3;
                    com.ss.android.downloadlib.yl.t.vw().vw(e, "BitmapCache loadBitmap");
                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedInputStream);
                    return null;
                }
                return null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(bufferedInputStream);
                throw th;
            }
        }
    }

    public interface vw {
        void vw(android.graphics.Bitmap bitmap);
    }

    public static class wg {
        private static com.ss.android.downloadlib.addownload.compliance.v vw = new com.ss.android.downloadlib.addownload.compliance.v(null);
    }

    private v() {
        super(8, 8);
        this.vw = new java.util.HashMap();
    }

    public /* synthetic */ v(com.ss.android.downloadlib.addownload.compliance.v.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.ss.android.downloadlib.addownload.compliance.v vw() {
        return com.ss.android.downloadlib.addownload.compliance.v.wg.vw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int wg(int i, int i2, android.graphics.BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return java.lang.Math.min(java.lang.Math.round(i3 / i), java.lang.Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public void vw(long j, long j2, java.lang.String str) {
        if (get(java.lang.Long.valueOf(j)) == null) {
            if (android.text.TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.addownload.compliance.bt.vw(12, j2);
                return;
            } else {
                com.ss.android.downloadlib.bt.t.vw(new com.ss.android.downloadlib.addownload.compliance.v.AnonymousClass2(str, j2, j), (java.lang.Object) null).vw(new com.ss.android.downloadlib.addownload.compliance.v.AnonymousClass1(j)).vw();
                return;
            }
        }
        java.lang.ref.SoftReference<com.ss.android.downloadlib.addownload.compliance.v.vw> remove = this.vw.remove(java.lang.Long.valueOf(j));
        if (remove == null || remove.get() == null) {
            return;
        }
        remove.get().vw(get(java.lang.Long.valueOf(j)));
    }

    public void vw(long j, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.compliance.v.vw vwVar) {
        if (get(java.lang.Long.valueOf(j)) != null) {
            vwVar.vw(get(java.lang.Long.valueOf(j)));
        } else {
            this.vw.put(java.lang.Long.valueOf(j), new java.lang.ref.SoftReference<>(vwVar));
        }
    }
}

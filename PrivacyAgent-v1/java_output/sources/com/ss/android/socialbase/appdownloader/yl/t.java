package com.ss.android.socialbase.appdownloader.yl;

/* loaded from: classes19.dex */
public class t {
    private static int vw = 8;
    private static volatile com.ss.android.socialbase.appdownloader.yl.t wg;
    private com.ss.android.socialbase.appdownloader.yl.t.vw<java.lang.Integer, android.graphics.Bitmap> t;

    /* renamed from: com.ss.android.socialbase.appdownloader.yl.t$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ int wg;

        public AnonymousClass1(java.lang.String str, int i) {
            this.vw = str;
            this.wg = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.io.ByteArrayOutputStream byteArrayOutputStream;
            java.io.ByteArrayInputStream byteArrayInputStream;
            java.io.Closeable closeable;
            java.lang.Throwable th;
            java.io.InputStream inputStream;
            java.io.ByteArrayInputStream byteArrayInputStream2;
            java.lang.Exception e;
            try {
                try {
                    com.ss.android.socialbase.downloader.network.IDownloadHttpConnection downloadWithConnection = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.downloadWithConnection(true, 0, this.vw, null);
                    if (downloadWithConnection == null) {
                        com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(null, null, null, null);
                        return;
                    }
                    inputStream = downloadWithConnection.getInputStream();
                    try {
                        byteArrayOutputStream = com.ss.android.socialbase.appdownloader.yl.t.wg(inputStream);
                        try {
                            byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                byteArrayInputStream2 = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    android.graphics.BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int vw = com.ss.android.socialbase.appdownloader.t.vw(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext(), 44.0f);
                                    options.inSampleSize = com.ss.android.socialbase.appdownloader.yl.t.vw(vw, vw, options);
                                    options.inJustDecodeBounds = false;
                                    com.ss.android.socialbase.appdownloader.yl.t.this.t.put(java.lang.Integer.valueOf(this.wg), android.graphics.BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(inputStream, byteArrayOutputStream, byteArrayInputStream, byteArrayInputStream2);
                                }
                            } catch (java.lang.Exception e3) {
                                byteArrayInputStream2 = null;
                                e = e3;
                            } catch (java.lang.Throwable th2) {
                                closeable = null;
                                th = th2;
                                com.ss.android.socialbase.downloader.utils.DownloadUtils.safeClose(inputStream, byteArrayOutputStream, byteArrayInputStream, closeable);
                                throw th;
                            }
                        } catch (java.lang.Exception e4) {
                            byteArrayInputStream2 = null;
                            e = e4;
                            byteArrayInputStream = null;
                        } catch (java.lang.Throwable th3) {
                            closeable = null;
                            th = th3;
                            byteArrayInputStream = null;
                        }
                    } catch (java.lang.Exception e5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        e = e5;
                        byteArrayOutputStream = null;
                    } catch (java.lang.Throwable th4) {
                        byteArrayInputStream = null;
                        closeable = null;
                        th = th4;
                        byteArrayOutputStream = null;
                    }
                } catch (java.lang.Throwable th5) {
                    th = th5;
                }
            } catch (java.lang.Exception e6) {
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                byteArrayInputStream2 = null;
                e = e6;
                inputStream = null;
            } catch (java.lang.Throwable th6) {
                byteArrayOutputStream = null;
                byteArrayInputStream = null;
                closeable = null;
                th = th6;
                inputStream = null;
            }
        }
    }

    public static class vw<K, T> extends java.util.LinkedHashMap<K, T> {
        final int vw;

        public vw(int i, int i2) {
            super(i2, 0.75f, true);
            this.vw = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(java.util.Map.Entry<K, T> entry) {
            return size() > this.vw;
        }
    }

    private t() {
        this.t = null;
        int i = vw;
        this.t = new com.ss.android.socialbase.appdownloader.yl.t.vw<>(i, i / 2);
    }

    public static int vw(int i, int i2, android.graphics.BitmapFactory.Options options) {
        int i3 = options.outWidth;
        if (i3 > i || options.outHeight > i2) {
            return java.lang.Math.min(java.lang.Math.round(i3 / i), java.lang.Math.round(options.outHeight / i2));
        }
        return 1;
    }

    public static com.ss.android.socialbase.appdownloader.yl.t vw() {
        if (wg == null) {
            synchronized (com.ss.android.socialbase.appdownloader.yl.t.class) {
                if (wg == null) {
                    wg = new com.ss.android.socialbase.appdownloader.yl.t();
                }
            }
        }
        return wg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.ByteArrayOutputStream wg(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public android.graphics.Bitmap vw(int i) {
        return this.t.get(java.lang.Integer.valueOf(i));
    }

    public void vw(int i, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || vw(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getIOThreadExecutor().submit(new com.ss.android.socialbase.appdownloader.yl.t.AnonymousClass1(str, i));
    }
}

package com.sensorsdata.sf.ui.utils;

/* loaded from: classes19.dex */
public class ImageLoader {
    private static final java.lang.String TAG = "ImageLoader";
    private static com.sensorsdata.sf.ui.utils.ImageLoader instance;
    private java.util.concurrent.ExecutorService executorService;
    private android.util.LruCache<java.lang.String, android.graphics.Bitmap> mBitmapCache;
    private java.util.Map<java.lang.String, java.lang.String> mBitmapTypes = new java.util.HashMap();
    private com.sensorsdata.sf.ui.utils.DiskLruCache mDiskLruCache;

    /* renamed from: com.sensorsdata.sf.ui.utils.ImageLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.ref.WeakReference val$listenerWeakReference;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(java.lang.String str, java.lang.ref.WeakReference weakReference) {
            this.val$url = str;
            this.val$listenerWeakReference = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.ImageLoader.TAG, "load bitmap from disk cache async");
            android.graphics.Bitmap loadBitmapFromDisk = com.sensorsdata.sf.ui.utils.ImageLoader.this.loadBitmapFromDisk(this.val$url);
            if (loadBitmapFromDisk == null) {
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.ImageLoader.TAG, "load bitmap from network async,url is" + this.val$url);
                loadBitmapFromDisk = com.sensorsdata.sf.ui.utils.ImageLoader.this.requestNetworkLoadBitmap(this.val$url);
            }
            com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener imageLoadListener = (com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener) this.val$listenerWeakReference.get();
            if (imageLoadListener != null) {
                if (loadBitmapFromDisk == null) {
                    imageLoadListener.onFailed("图片请求失败");
                    return;
                }
                imageLoadListener.onSuccess(loadBitmapFromDisk);
                com.sensorsdata.sf.ui.utils.ImageLoader.this.saveBitmapInCache(this.val$url, loadBitmapFromDisk);
                com.sensorsdata.sf.core.utils.SFLog.d(com.sensorsdata.sf.ui.utils.ImageLoader.TAG, "Request Bitmap Success");
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.utils.ImageLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass2(java.lang.String str) {
            this.val$url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap requestNetworkLoadBitmap = com.sensorsdata.sf.ui.utils.ImageLoader.this.requestNetworkLoadBitmap(this.val$url);
            if (requestNetworkLoadBitmap != null) {
                com.sensorsdata.sf.ui.utils.ImageLoader.this.saveBitmapInCache(this.val$url, requestNetworkLoadBitmap);
            }
        }
    }

    /* renamed from: com.sensorsdata.sf.ui.utils.ImageLoader$3, reason: invalid class name */
    public class AnonymousClass3 extends android.util.LruCache<java.lang.String, android.graphics.Bitmap> {
        public AnonymousClass3(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public int sizeOf(java.lang.String str, android.graphics.Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    public interface ImageLoadListener {
        void onFailed(java.lang.String str);

        void onSuccess(android.graphics.Bitmap bitmap);
    }

    public class LoaderTask implements java.util.concurrent.Callable<android.graphics.Bitmap> {
        private java.lang.String httpUrl;

        public LoaderTask(java.lang.String str) {
            this.httpUrl = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public android.graphics.Bitmap call() {
            return com.sensorsdata.sf.ui.utils.ImageLoader.this.requestNetworkLoadBitmap(this.httpUrl);
        }
    }

    private ImageLoader() {
        if (instance == null) {
            try {
                initBitmapCache();
                initBitmapDiskCache(com.sensorsdata.sf.core.SFContextManger.getInstance().getContext());
                this.executorService = java.util.concurrent.Executors.newSingleThreadExecutor();
            } catch (java.lang.Exception e) {
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            }
        }
    }

    private java.lang.String bytesToHexString(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static synchronized com.sensorsdata.sf.ui.utils.ImageLoader getInstance() {
        com.sensorsdata.sf.ui.utils.ImageLoader imageLoader;
        synchronized (com.sensorsdata.sf.ui.utils.ImageLoader.class) {
            if (instance == null) {
                instance = new com.sensorsdata.sf.ui.utils.ImageLoader();
            }
            imageLoader = instance;
        }
        return imageLoader;
    }

    private void initBitmapCache() {
        try {
            this.mBitmapCache = new com.sensorsdata.sf.ui.utils.ImageLoader.AnonymousClass3((int) (java.lang.Runtime.getRuntime().maxMemory() / 8));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void initBitmapDiskCache(android.content.Context context) {
        try {
            java.io.File file = new java.io.File(context.getCacheDir().getPath() + java.io.File.separator + TAG);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.mDiskLruCache = com.sensorsdata.sf.ui.utils.DiskLruCache.open(file, 1, 1, 10485760L);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0042: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:30:0x0042 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.graphics.Bitmap loadBitmapFromDisk(java.lang.String str) {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2;
        java.io.InputStream inputStream3 = null;
        try {
            try {
                if (this.mDiskLruCache != null) {
                    com.sensorsdata.sf.ui.utils.DiskLruCache.Snapshot snapshot = this.mDiskLruCache.get(hashKeyForDisk(str));
                    if (snapshot != null) {
                        inputStream = snapshot.getInputStream(0);
                        try {
                            byte[] readStream = readStream(inputStream);
                            upDateBitmapType(str, readStream);
                            android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(readStream, 0, readStream.length);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.io.IOException e) {
                                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                                }
                            }
                            return decodeByteArray;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.io.IOException e3) {
                                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e3);
                                }
                            }
                            return null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream3 = inputStream2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (java.io.IOException e4) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e4);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (inputStream3 != null) {
            }
            throw th;
        }
        return null;
    }

    private android.graphics.Bitmap loadBitmapFromNetwork(java.lang.String str) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) this.executorService.submit(new com.sensorsdata.sf.ui.utils.ImageLoader.LoaderTask(str)).get();
        if (bitmap != null) {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "loadBitmapFromNetwork「 " + str + "」loadBitmap from network succeed.");
            saveBitmapInCache(str, bitmap);
        } else {
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "loadBitmapFromNetwork「 " + str + "」loadBitmap from network failed.");
        }
        return bitmap;
    }

    private void loadBitmapFromNetworkAsync(java.lang.String str) {
        try {
            this.executorService.execute(new com.sensorsdata.sf.ui.utils.ImageLoader.AnonymousClass2(str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private static byte[] readStream(java.io.InputStream inputStream) throws java.lang.Exception {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.graphics.Bitmap requestNetworkLoadBitmap(java.lang.String str) {
        java.io.InputStream inputStream;
        java.net.HttpURLConnection httpURLConnection;
        int responseCode;
        java.net.HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        } catch (java.lang.Exception e) {
            e = e;
            httpURLConnection = null;
            inputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
            inputStream = null;
            if (httpURLConnection2 != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
        try {
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            responseCode = httpURLConnection.getResponseCode();
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "HttpUrl = " + str + " ,Code = " + responseCode);
        } catch (java.lang.Exception e2) {
            e = e2;
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream = null;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
        if (responseCode != 200) {
            httpURLConnection.disconnect();
            return null;
        }
        inputStream = httpURLConnection.getInputStream();
        try {
            try {
                byte[] readStream = readStream(inputStream);
                saveStreamDiskLruCache(str, readStream);
                upDateBitmapType(str, readStream);
                android.graphics.Bitmap decodeByteArray = android.graphics.BitmapFactory.decodeByteArray(readStream, 0, readStream.length);
                httpURLConnection.disconnect();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e3) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e3);
                    }
                }
                return decodeByteArray;
            } catch (java.lang.Exception e4) {
                e = e4;
                com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e5) {
                        com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e5);
                    }
                }
                return null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException e6) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e6);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveBitmapInCache(java.lang.String str, android.graphics.Bitmap bitmap) {
        android.util.LruCache<java.lang.String, android.graphics.Bitmap> lruCache = this.mBitmapCache;
        if (lruCache != null) {
            lruCache.put(str, bitmap);
        }
    }

    private void saveStreamDiskLruCache(java.lang.String str, byte[] bArr) {
        try {
            com.sensorsdata.sf.ui.utils.DiskLruCache.Editor edit = this.mDiskLruCache.edit(hashKeyForDisk(str));
            if (edit != null) {
                java.io.OutputStream newOutputStream = edit.newOutputStream(0);
                try {
                    newOutputStream.write(bArr, 0, bArr.length);
                    newOutputStream.flush();
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(newOutputStream);
                    edit.commit();
                } catch (java.lang.Throwable th) {
                    com.sensorsdata.sf.ui.utils.IoUtils.closeQuietly(newOutputStream);
                    edit.commit();
                    throw th;
                }
            }
            this.mDiskLruCache.flush();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private void upDateBitmapType(java.lang.String str, byte[] bArr) {
        if (this.mBitmapTypes == null) {
            this.mBitmapTypes = new java.util.HashMap();
        }
        if (this.mBitmapTypes.containsKey(str)) {
            return;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        java.lang.String str2 = options.outMimeType;
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        com.sensorsdata.sf.core.utils.SFLog.d(TAG, str + ", type = " + str2);
        this.mBitmapTypes.put(str, str2);
    }

    public java.lang.String getImageType(java.lang.String str) {
        return this.mBitmapTypes.get(str);
    }

    public java.lang.String hashKeyForDisk(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return bytesToHexString(messageDigest.digest());
        } catch (java.security.NoSuchAlgorithmException unused) {
            return java.lang.String.valueOf(str.hashCode());
        }
    }

    public android.graphics.Bitmap loadBitmap(java.lang.String str) {
        android.graphics.Bitmap bitmap;
        try {
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> lruCache = this.mBitmapCache;
            if (lruCache != null && (bitmap = lruCache.get(str)) != null) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "「 " + str + "」loadBitmap from cache succeed.");
                return bitmap;
            }
            android.graphics.Bitmap loadBitmapFromDisk = loadBitmapFromDisk(str);
            if (loadBitmapFromDisk == null) {
                return loadBitmapFromNetwork(str);
            }
            com.sensorsdata.sf.core.utils.SFLog.d(TAG, "「 " + str + "」loadBitmap from disk succeed.");
            saveBitmapInCache(str, loadBitmapFromDisk);
            return loadBitmapFromDisk;
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public void loadBitmapAsync(java.lang.String str, com.sensorsdata.sf.ui.utils.ImageLoader.ImageLoadListener imageLoadListener) {
        if (imageLoadListener == null) {
            return;
        }
        try {
            this.executorService.execute(new com.sensorsdata.sf.ui.utils.ImageLoader.AnonymousClass1(str, new java.lang.ref.WeakReference(imageLoadListener)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    public android.graphics.Bitmap loadBitmapFromMemory(java.lang.String str) {
        android.util.LruCache<java.lang.String, android.graphics.Bitmap> lruCache = this.mBitmapCache;
        if (lruCache == null) {
            return null;
        }
        return lruCache.get(str);
    }

    public void preLoadBitmap(java.lang.String str) {
        try {
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> lruCache = this.mBitmapCache;
            if (lruCache != null && lruCache.get(str) != null) {
                com.sensorsdata.sf.core.utils.SFLog.d(TAG, "preLoadBitmap「 " + str + "」loadBitmap from cache succeed.");
                return;
            }
            if (this.mDiskLruCache != null) {
                if (this.mDiskLruCache.get(hashKeyForDisk(str)) != null) {
                    com.sensorsdata.sf.core.utils.SFLog.d(TAG, "preLoadBitmap「 " + str + "」loadBitmap from disk succeed.");
                    return;
                }
            }
            loadBitmapFromNetworkAsync(str);
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }
}

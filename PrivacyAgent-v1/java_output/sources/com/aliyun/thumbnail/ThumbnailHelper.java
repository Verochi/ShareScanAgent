package com.aliyun.thumbnail;

/* loaded from: classes12.dex */
public class ThumbnailHelper {
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int MSG_KEY_BITMAP_FAIL = 2;
    private static final int MSG_KEY_BITMAP_SUCCESS = 3;
    private static final int MSG_KEY_PREPARE_FAIL = 0;
    private static final int MSG_KEY_PREPARE_SUCCESS = 1;
    private static final java.lang.String TAG = "ThumbnailHelper";
    private android.graphics.BitmapFactory.Options mBitmapOptions;
    private android.graphics.BitmapRegionDecoder mBitmapRegionDecoder;
    private android.graphics.Rect mRect;
    private com.aliyun.thumbnail.ThumbnailInfo[] mThumbnailInfoArray;
    private java.lang.String mUrl;
    private final java.lang.Object lock = new java.lang.Object();
    private java.lang.String mLastPath = "";
    private java.util.Map<java.lang.String, byte[]> mUrlDataMap = new java.util.HashMap();
    private volatile boolean hasPrepared = false;
    private com.aliyun.thumbnail.ThumbnailHelper.OnPrepareListener mOnPrepareListener = null;
    private com.aliyun.thumbnail.ThumbnailHelper.OnThumbnailGetListener mOnThumbnailGetListener = null;
    private com.aliyun.thumbnail.ThumbnailHelper.ResultHandler mResultHandler = new com.aliyun.thumbnail.ThumbnailHelper.ResultHandler(this);

    /* renamed from: com.aliyun.thumbnail.ThumbnailHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.thumbnail.ThumbnailHelper.ByteHttp byteHttp = new com.aliyun.thumbnail.ThumbnailHelper.ByteHttp(com.aliyun.thumbnail.ThumbnailHelper.this, null);
            byteHttp.doGet(com.aliyun.thumbnail.ThumbnailHelper.this.mUrl);
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("([a-zA-Z]+://[^/]+).*[/]").matcher(com.aliyun.thumbnail.ThumbnailHelper.this.mUrl);
            if (matcher.find() && byteHttp.bytes != null) {
                java.lang.Object[] thumbnailInfos = com.aliyun.thumbnail.ThumbnailHelper.this.getThumbnailInfos(matcher.group(0), new java.lang.String(byteHttp.bytes));
                if (thumbnailInfos == null) {
                    com.aliyun.thumbnail.ThumbnailHelper.this.mThumbnailInfoArray = null;
                } else {
                    com.aliyun.thumbnail.ThumbnailHelper.this.mThumbnailInfoArray = (com.aliyun.thumbnail.ThumbnailInfo[]) thumbnailInfos;
                }
            }
            if (com.aliyun.thumbnail.ThumbnailHelper.this.mThumbnailInfoArray != null) {
                com.aliyun.thumbnail.ThumbnailHelper.this.sendPrepareSuccessMsg();
            } else {
                com.aliyun.thumbnail.ThumbnailHelper.this.sendPrepareFailMsg();
            }
        }
    }

    /* renamed from: com.aliyun.thumbnail.ThumbnailHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener {
        final /* synthetic */ com.aliyun.thumbnail.ThumbnailInfo val$info;
        final /* synthetic */ long val$positionMs;

        public AnonymousClass2(com.aliyun.thumbnail.ThumbnailInfo thumbnailInfo, long j) {
            this.val$info = thumbnailInfo;
            this.val$positionMs = j;
        }

        @Override // com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener
        public void onFail() {
            com.aliyun.thumbnail.ThumbnailHelper.this.sendRequestBitmapFailMsg("can not get thumbnail at position:" + this.val$positionMs, this.val$positionMs);
        }

        @Override // com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener
        public void onSuccess(byte[] bArr) {
            android.graphics.Bitmap bitmap = com.aliyun.thumbnail.ThumbnailHelper.this.getBitmap(this.val$info, bArr);
            if (bitmap != null) {
                com.aliyun.thumbnail.ThumbnailHelper.this.sendRequestBitmapSuccMsg(this.val$info, this.val$positionMs, bitmap);
                return;
            }
            com.aliyun.thumbnail.ThumbnailHelper.this.sendRequestBitmapFailMsg("can not get thumbnail at position:" + this.val$positionMs, this.val$positionMs);
        }
    }

    /* renamed from: com.aliyun.thumbnail.ThumbnailHelper$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$imgUrl;
        final /* synthetic */ com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener val$l;

        public AnonymousClass3(java.lang.String str, com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener onImgDataResultListener) {
            this.val$imgUrl = str;
            this.val$l = onImgDataResultListener;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
        
            if (r2 != null) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
        
            r2.close();
            r2 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00af, code lost:
        
            r2.printStackTrace();
            r2 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
        
            if (r2 == null) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.io.IOException, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ac -> B:35:0x006e). Please report as a decompilation issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            java.io.InputStream inputStream;
            byte[] bArr;
            java.io.InputStream inputStream2;
            synchronized (com.aliyun.thumbnail.ThumbnailHelper.this.lock) {
                inputStream = null;
                inputStream = null;
                inputStream = null;
                bArr = com.aliyun.thumbnail.ThumbnailHelper.this.mUrlDataMap.containsKey(this.val$imgUrl) ? (byte[]) com.aliyun.thumbnail.ThumbnailHelper.this.mUrlDataMap.get(this.val$imgUrl) : null;
            }
            if (bArr != null) {
                this.val$l.onSuccess(bArr);
                return;
            }
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            java.net.URLConnection urlConnection = com.aliyun.thumbnail.ThumbnailHelper.this.getUrlConnection(this.val$imgUrl);
            if (urlConnection == null) {
                com.cicada.player.utils.Logger.e(com.aliyun.thumbnail.ThumbnailHelper.TAG, "can not open url" + this.val$imgUrl);
            } else {
                try {
                    try {
                        int responseCode = com.aliyun.thumbnail.ThumbnailHelper.this.getResponseCode(urlConnection);
                        if (responseCode == 200) {
                            java.io.InputStream inputStream3 = urlConnection.getInputStream();
                            bArr = com.aliyun.thumbnail.ThumbnailHelper.readStream(inputStream3, atomicBoolean);
                            inputStream2 = inputStream3;
                            inputStream = inputStream3;
                        } else {
                            com.cicada.player.utils.Logger.e(com.aliyun.thumbnail.ThumbnailHelper.TAG, "open url responseCode = " + responseCode);
                        }
                    } catch (java.io.IOException e) {
                        com.cicada.player.utils.Logger.e(com.aliyun.thumbnail.ThumbnailHelper.TAG, "open url exception = " + e.getMessage());
                        inputStream2 = inputStream;
                    }
                } catch (java.lang.Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (bArr == null || atomicBoolean.get()) {
                this.val$l.onFail();
                return;
            }
            synchronized (com.aliyun.thumbnail.ThumbnailHelper.this.lock) {
                com.aliyun.thumbnail.ThumbnailHelper.this.mUrlDataMap.put(this.val$imgUrl, bArr);
            }
            this.val$l.onSuccess(bArr);
        }
    }

    public class ByteHttp extends com.aliyun.utils.a {
        byte[] bytes;
        int len;

        private ByteHttp() {
            this.bytes = null;
            this.len = 0;
        }

        public /* synthetic */ ByteHttp(com.aliyun.thumbnail.ThumbnailHelper thumbnailHelper, com.aliyun.thumbnail.ThumbnailHelper.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.aliyun.utils.a
        public void handleErrorInputStream(java.io.InputStream inputStream) {
        }

        @Override // com.aliyun.utils.a
        public void handleOKInputStream(java.io.InputStream inputStream) {
            java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            byte[] readStream = com.aliyun.thumbnail.ThumbnailHelper.readStream(inputStream, atomicBoolean);
            this.bytes = readStream;
            if (readStream == null && atomicBoolean.get()) {
                return;
            }
            this.len = this.bytes.length;
        }
    }

    public interface OnImgDataResultListener {
        void onFail();

        void onSuccess(byte[] bArr);
    }

    public interface OnPrepareListener {
        void onPrepareFail();

        void onPrepareSuccess();
    }

    public interface OnThumbnailGetListener {
        void onThumbnailGetFail(long j, java.lang.String str);

        void onThumbnailGetSuccess(long j, com.aliyun.thumbnail.ThumbnailBitmapInfo thumbnailBitmapInfo);
    }

    public static class ResultHandler extends android.os.Handler {
        private java.lang.ref.WeakReference<com.aliyun.thumbnail.ThumbnailHelper> thumbnailHelperWeakReference;

        public ResultHandler(com.aliyun.thumbnail.ThumbnailHelper thumbnailHelper) {
            super(android.os.Looper.getMainLooper());
            this.thumbnailHelperWeakReference = new java.lang.ref.WeakReference<>(thumbnailHelper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.aliyun.thumbnail.ThumbnailHelper thumbnailHelper = this.thumbnailHelperWeakReference.get();
            if (thumbnailHelper != null) {
                thumbnailHelper.handleMessage(message);
            }
            super.handleMessage(message);
        }
    }

    static {
        com.aliyun.utils.f.f();
    }

    public ThumbnailHelper(java.lang.String str) {
        this.mUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.graphics.Bitmap getBitmap(com.aliyun.thumbnail.ThumbnailInfo thumbnailInfo, byte[] bArr) {
        try {
            if (this.mBitmapRegionDecoder == null || !this.mLastPath.equals(thumbnailInfo.mPath)) {
                java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
                this.mLastPath = thumbnailInfo.mPath;
                this.mBitmapRegionDecoder = android.graphics.BitmapRegionDecoder.newInstance((java.io.InputStream) byteArrayInputStream, true);
            }
            if (this.mBitmapOptions == null) {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                this.mBitmapOptions = options;
                options.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            }
            if (this.mRect == null) {
                this.mRect = new android.graphics.Rect();
            }
            android.graphics.Rect rect = this.mRect;
            int i = thumbnailInfo.mLeft;
            rect.left = i;
            int i2 = thumbnailInfo.mTop;
            rect.top = i2;
            rect.right = i + thumbnailInfo.mWidth;
            rect.bottom = i2 + thumbnailInfo.mHeight;
            return this.mBitmapRegionDecoder.decodeRegion(rect, this.mBitmapOptions);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.cicada.player.utils.Logger.d(TAG, "获取缩略图异常。。" + e.getMessage());
            return null;
        }
    }

    private java.net.URLConnection getHttpUrlConnection(java.lang.String str) {
        java.net.URLConnection uRLConnection = null;
        try {
            java.net.URLConnection openConnection = new java.net.URL(str).openConnection();
            try {
                if (!(openConnection instanceof java.net.HttpURLConnection)) {
                    return null;
                }
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) openConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                return openConnection;
            } catch (java.lang.Exception unused) {
                uRLConnection = openConnection;
                return uRLConnection;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    private java.net.URLConnection getHttpsUrlConnection(java.lang.String str) {
        java.net.URLConnection uRLConnection = null;
        try {
            java.net.URLConnection openConnection = new java.net.URL(str).openConnection();
            try {
                if (!(openConnection instanceof javax.net.ssl.HttpsURLConnection)) {
                    return null;
                }
                javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) openConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(5000);
                return openConnection;
            } catch (java.lang.Exception unused) {
                uRLConnection = openConnection;
                return uRLConnection;
            }
        } catch (java.lang.Exception unused2) {
        }
    }

    private com.aliyun.thumbnail.ThumbnailInfo getInfoByPosition(long j) {
        java.lang.String str = TAG;
        com.cicada.player.utils.Logger.d(str, "getInfoByPosition position = " + j);
        com.aliyun.thumbnail.ThumbnailInfo[] thumbnailInfoArr = this.mThumbnailInfoArray;
        com.aliyun.thumbnail.ThumbnailInfo thumbnailInfo = null;
        if (thumbnailInfoArr == null) {
            com.cicada.player.utils.Logger.e(str, "mThumbnailInfoArray == null");
            return null;
        }
        int length = thumbnailInfoArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            com.aliyun.thumbnail.ThumbnailInfo thumbnailInfo2 = this.mThumbnailInfoArray[i];
            if (thumbnailInfo2.mStart <= j && thumbnailInfo2.mUntil >= j) {
                thumbnailInfo = thumbnailInfo2;
                break;
            }
            i++;
        }
        com.cicada.player.utils.Logger.d(TAG, "mThumbnailInfoArray targetInfo = " + thumbnailInfo);
        return thumbnailInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getResponseCode(java.net.URLConnection uRLConnection) throws java.io.IOException {
        java.net.HttpURLConnection httpURLConnection;
        if (uRLConnection instanceof javax.net.ssl.HttpsURLConnection) {
            httpURLConnection = (javax.net.ssl.HttpsURLConnection) uRLConnection;
        } else {
            if (!(uRLConnection instanceof java.net.HttpURLConnection)) {
                return 0;
            }
            httpURLConnection = (java.net.HttpURLConnection) uRLConnection;
        }
        return httpURLConnection.getResponseCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native java.lang.Object[] getThumbnailInfos(java.lang.String str, java.lang.String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public java.net.URLConnection getUrlConnection(java.lang.String str) {
        if (str.startsWith("https://")) {
            return getHttpsUrlConnection(str);
        }
        if (str.startsWith("http://")) {
            return getHttpUrlConnection(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(android.os.Message message) {
        int i = message.what;
        if (i == 1) {
            com.aliyun.thumbnail.ThumbnailHelper.OnPrepareListener onPrepareListener = this.mOnPrepareListener;
            if (onPrepareListener != null) {
                onPrepareListener.onPrepareSuccess();
                return;
            }
            return;
        }
        if (i == 0) {
            com.aliyun.thumbnail.ThumbnailHelper.OnPrepareListener onPrepareListener2 = this.mOnPrepareListener;
            if (onPrepareListener2 != null) {
                onPrepareListener2.onPrepareFail();
                return;
            }
            return;
        }
        if (i == 2) {
            if (this.mOnThumbnailGetListener != null) {
                this.mOnThumbnailGetListener.onThumbnailGetFail(message.getData().getLong("pos"), (java.lang.String) message.obj);
            }
        } else {
            if (i != 3 || this.mOnThumbnailGetListener == null) {
                return;
            }
            long j = message.getData().getLong("pos");
            long j2 = message.getData().getLong(com.anythink.expressad.foundation.d.c.bT);
            long j3 = message.getData().getLong("until");
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) message.obj;
            com.aliyun.thumbnail.ThumbnailBitmapInfo thumbnailBitmapInfo = new com.aliyun.thumbnail.ThumbnailBitmapInfo();
            thumbnailBitmapInfo.setPositionRange(new long[]{j2, j3});
            thumbnailBitmapInfo.setThumbnailBitmap(bitmap);
            this.mOnThumbnailGetListener.onThumbnailGetSuccess(j, thumbnailBitmapInfo);
        }
    }

    public static void loadClass() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] readStream(java.io.InputStream inputStream, java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (java.io.IOException e) {
                    atomicBoolean.set(true);
                    e.printStackTrace();
                }
                try {
                    break;
                } catch (java.io.IOException e2) {
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e22) {
                    e22.printStackTrace();
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void requestImgData(java.lang.String str, com.aliyun.thumbnail.ThumbnailHelper.OnImgDataResultListener onImgDataResultListener) {
        com.aliyun.utils.g.a.submit(new com.aliyun.thumbnail.ThumbnailHelper.AnonymousClass3(str, onImgDataResultListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPrepareFailMsg() {
        android.os.Message obtainMessage = this.mResultHandler.obtainMessage();
        obtainMessage.what = 0;
        this.mResultHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPrepareSuccessMsg() {
        android.os.Message obtainMessage = this.mResultHandler.obtainMessage();
        obtainMessage.what = 1;
        this.mResultHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequestBitmapFailMsg(java.lang.String str, long j) {
        android.os.Message obtainMessage = this.mResultHandler.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = str;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("pos", j);
        obtainMessage.setData(bundle);
        this.mResultHandler.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRequestBitmapSuccMsg(com.aliyun.thumbnail.ThumbnailInfo thumbnailInfo, long j, android.graphics.Bitmap bitmap) {
        android.os.Message obtainMessage = this.mResultHandler.obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = bitmap;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putLong("pos", j);
        bundle.putLong(com.anythink.expressad.foundation.d.c.bT, thumbnailInfo.mStart);
        bundle.putLong("until", thumbnailInfo.mUntil);
        obtainMessage.setData(bundle);
        this.mResultHandler.sendMessage(obtainMessage);
    }

    public void prepare() {
        synchronized (this.lock) {
            if (this.hasPrepared) {
                com.cicada.player.utils.Logger.e(TAG, "prepare again?");
            } else {
                this.hasPrepared = true;
                com.aliyun.utils.g.a.submit(new com.aliyun.thumbnail.ThumbnailHelper.AnonymousClass1());
            }
        }
    }

    public void requestBitmapAtPosition(long j) {
        com.aliyun.thumbnail.ThumbnailInfo infoByPosition = getInfoByPosition(j);
        if (infoByPosition != null) {
            requestImgData(infoByPosition.mPath, new com.aliyun.thumbnail.ThumbnailHelper.AnonymousClass2(infoByPosition, j));
            return;
        }
        sendRequestBitmapFailMsg("no match thumbnail at position:" + j, j);
    }

    public void setOnPrepareListener(com.aliyun.thumbnail.ThumbnailHelper.OnPrepareListener onPrepareListener) {
        this.mOnPrepareListener = onPrepareListener;
    }

    public void setOnThumbnailGetListener(com.aliyun.thumbnail.ThumbnailHelper.OnThumbnailGetListener onThumbnailGetListener) {
        this.mOnThumbnailGetListener = onThumbnailGetListener;
    }
}

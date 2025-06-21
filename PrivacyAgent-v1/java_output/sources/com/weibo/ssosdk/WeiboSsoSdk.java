package com.weibo.ssosdk;

/* loaded from: classes19.dex */
public class WeiboSsoSdk {
    private static final java.lang.String AID_FILE_NAME = "weibo_sso_sdk_aid";
    private static final java.lang.String INIT_FILE_NAME = "weibo_sso_sdk_init";
    private static final java.lang.String LOGIN_URL = "https://login.sina.com.cn/visitor/signin";
    private static final int SDK_ACT_UPLOAD = 2;
    private static final int SDK_ACT_VISITORLOGIN = 1;
    public static final java.lang.String SDK_VERSION_CODE = "1.0";
    private static final java.lang.String TAG = "WeiboSsoSdk";
    private static final int VERSION = 1;
    private static com.weibo.ssosdk.WeiboSsoSdkConfig config;
    private static com.weibo.ssosdk.WeiboSsoSdk sInstance;
    private int mCallCount;
    private com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo mVisitorLoginInfo;
    private volatile java.util.concurrent.locks.ReentrantLock mTaskLock = new java.util.concurrent.locks.ReentrantLock(true);
    private boolean isFirstUpload = true;

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    java.lang.Thread.sleep(86400000L);
                    com.weibo.ssosdk.WeiboSsoSdk.getInstance().updateInfo((com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo == null || android.text.TextUtils.isEmpty(com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) ? com.weibo.ssosdk.WeiboSsoSdk.this.loadAidFromCache() : com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid(), 2);
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.Thread.sleep(60000L);
                if (com.weibo.ssosdk.WeiboSsoSdk.this.isFirstUpload) {
                    com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo((com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo == null || android.text.TextUtils.isEmpty(com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) ? com.weibo.ssosdk.WeiboSsoSdk.this.loadAidFromCache() : com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid(), 2);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo((com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo == null || android.text.TextUtils.isEmpty(com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) ? com.weibo.ssosdk.WeiboSsoSdk.this.loadAidFromCache() : com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid(), 2);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo("", 1);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.weibo.ssosdk.VisitorLoginListener val$listener;

        public AnonymousClass5(com.weibo.ssosdk.VisitorLoginListener visitorLoginListener) {
            this.val$listener = visitorLoginListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo("", 1);
            } catch (java.lang.Exception unused) {
            }
            if (com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo = new com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo();
            }
            this.val$listener.handler(com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo);
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo("", 1);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.weibo.ssosdk.WeiboSsoSdk$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.weibo.ssosdk.AidListener val$listener;

        public AnonymousClass7(com.weibo.ssosdk.AidListener aidListener) {
            this.val$listener = aidListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.weibo.ssosdk.WeiboSsoSdk.this.updateInfo("", 1);
            } catch (java.lang.Exception unused) {
            }
            if (com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo = new com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo();
            }
            this.val$listener.handler(com.weibo.ssosdk.WeiboSsoSdk.this.mVisitorLoginInfo.getAid());
        }
    }

    public static final class VisitorLoginInfo {
        private java.lang.String mAid = "";
        private java.lang.String mSubCookie = "";

        public static com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo parseJson(java.lang.String str) {
            com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = new com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.lang.String optString = jSONObject.optString("retcode", "");
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (optString.equals("20000000") && jSONObject2 != null) {
                    visitorLoginInfo.mAid = jSONObject2.optString("aid", "");
                    visitorLoginInfo.mSubCookie = jSONObject2.optString("sub", "");
                    return visitorLoginInfo;
                }
                throw new java.lang.Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
            } catch (java.lang.Exception e) {
                throw e;
            }
        }

        public final com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo cloneAidInfo() {
            com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = new com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo();
            visitorLoginInfo.mAid = this.mAid;
            visitorLoginInfo.mSubCookie = this.mSubCookie;
            return visitorLoginInfo;
        }

        public final java.lang.String getAid() {
            return this.mAid;
        }

        public final java.lang.String getVisitorSub() {
            return this.mSubCookie;
        }
    }

    static {
        java.lang.System.loadLibrary("wind");
    }

    private WeiboSsoSdk() {
        com.weibo.ssosdk.WeiboSsoSdkConfig weiboSsoSdkConfig = config;
        if (weiboSsoSdkConfig == null || !weiboSsoSdkConfig.verify()) {
            throw new java.lang.Exception("config error");
        }
        this.mCallCount = 0;
        new java.lang.Thread(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass1()).start();
        new java.lang.Thread(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass2()).start();
    }

    private static void LogD(java.lang.String str) {
    }

    private static void LogE(java.lang.String str) {
    }

    private synchronized void cacheAidInfo(java.lang.String str) {
        java.io.FileOutputStream fileOutputStream;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new java.io.FileOutputStream(getAidInfoFile(1));
        } catch (java.lang.Exception unused) {
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (java.io.IOException unused2) {
            }
        } catch (java.lang.Exception unused3) {
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException unused4) {
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    private java.lang.String do_post(java.lang.String str) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(LOGIN_URL).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            java.io.InputStream inputStream = httpURLConnection.getInputStream();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new java.lang.String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private java.io.File getAidInfoFile(int i) {
        return new java.io.File(config.getApplicationContext().getFilesDir(), AID_FILE_NAME + i);
    }

    private java.io.File getInitFile() {
        return new java.io.File(config.getApplicationContext().getFilesDir(), INIT_FILE_NAME);
    }

    public static synchronized com.weibo.ssosdk.WeiboSsoSdk getInstance() {
        com.weibo.ssosdk.WeiboSsoSdk weiboSsoSdk;
        synchronized (com.weibo.ssosdk.WeiboSsoSdk.class) {
            if (sInstance == null) {
                sInstance = new com.weibo.ssosdk.WeiboSsoSdk();
            }
            weiboSsoSdk = sInstance;
        }
        return weiboSsoSdk;
    }

    public static synchronized boolean initConfig(com.weibo.ssosdk.WeiboSsoSdkConfig weiboSsoSdkConfig) {
        synchronized (com.weibo.ssosdk.WeiboSsoSdk.class) {
            if (weiboSsoSdkConfig == null) {
                return false;
            }
            if (!weiboSsoSdkConfig.verify()) {
                return false;
            }
            if (config != null) {
                return false;
            }
            com.weibo.ssosdk.WeiboSsoSdkConfig weiboSsoSdkConfig2 = (com.weibo.ssosdk.WeiboSsoSdkConfig) weiboSsoSdkConfig.clone();
            config = weiboSsoSdkConfig2;
            com.weibo.ssosdk.MfpBuilder.init(weiboSsoSdkConfig2.getApplicationContext());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String loadAidFromCache() {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(getAidInfoFile(1));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                java.lang.String str = new java.lang.String(bArr);
                try {
                    fileInputStream2.close();
                } catch (java.io.IOException unused) {
                }
                return str;
            } catch (java.lang.Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return "";
                }
                try {
                    fileInputStream.close();
                    return "";
                } catch (java.io.IOException unused3) {
                    return "";
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private java.lang.String loadInitFile() {
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        try {
            fileInputStream = new java.io.FileInputStream(getInitFile());
        } catch (java.lang.Exception unused) {
            fileInputStream = null;
        } catch (java.lang.Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            java.lang.String str = new java.lang.String(bArr);
            try {
                fileInputStream.close();
            } catch (java.io.IOException unused2) {
            }
            return str;
        } catch (java.lang.Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (java.io.IOException unused4) {
                }
            }
            return null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (java.io.IOException unused5) {
                }
            }
            throw th;
        }
    }

    private native java.lang.String riseWind(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, int i, int i2);

    private synchronized void saveInitFile(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(getInitFile());
            try {
                fileOutputStream2.write(str.getBytes());
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException unused) {
                }
            } catch (java.lang.Exception unused2) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused5) {
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInfo(java.lang.String str, int i) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(config.getAppKey(false))) {
            return;
        }
        if (!this.mTaskLock.tryLock()) {
            this.mTaskLock.lock();
            this.mTaskLock.unlock();
            return;
        }
        this.isFirstUpload = false;
        java.lang.String mfp = com.weibo.ssosdk.MfpBuilder.getMfp(config.getApplicationContext());
        try {
            str2 = java.net.URLEncoder.encode(str, "utf-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            str2 = "";
        }
        java.lang.String do_post = do_post(riseWind(config.getAppKey(true), config.getApplicationContext().getPackageName(), str2, mfp, config.getFrom(true), config.getOldWm(true), config.getWm(true), config.getSub(true), config.getSmid(true), config.getExtraString(true), i, this.mCallCount));
        this.mCallCount++;
        if (do_post == null) {
            this.mTaskLock.unlock();
            throw new java.lang.Exception("network error.");
        }
        try {
            com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo parseJson = com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo.parseJson(do_post);
            if (parseJson != null && !android.text.TextUtils.isEmpty(parseJson.getAid())) {
                cacheAidInfo(parseJson.getAid());
            }
            if (i == 1) {
                this.mVisitorLoginInfo = parseJson;
            }
            this.mTaskLock.unlock();
        } catch (java.lang.Exception e) {
            this.mTaskLock.unlock();
            throw e;
        }
    }

    public java.lang.String getAid() {
        java.lang.String loadAidFromCache = loadAidFromCache();
        if (!android.text.TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || android.text.TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            java.lang.Thread thread = new java.lang.Thread(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass6());
            thread.start();
            thread.join();
            com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || android.text.TextUtils.isEmpty(visitorLoginInfo2.getAid())) {
                throw new java.lang.Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo.getAid();
    }

    public void getAid(com.weibo.ssosdk.AidListener aidListener) {
        java.lang.String loadAidFromCache = loadAidFromCache();
        if (!android.text.TextUtils.isEmpty(loadAidFromCache)) {
            aidListener.handler(loadAidFromCache);
        }
        com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || android.text.TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass7(aidListener));
        } else {
            aidListener.handler(this.mVisitorLoginInfo.getAid());
        }
    }

    public void updateSub(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        config.setSub(str);
        java.lang.String visitorSub = this.mVisitorLoginInfo.getVisitorSub();
        if (android.text.TextUtils.isEmpty(visitorSub) || !visitorSub.equals(str)) {
            new java.lang.Thread(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass3()).start();
        }
    }

    public com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLogin() {
        com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || android.text.TextUtils.isEmpty(visitorLoginInfo.getAid()) || android.text.TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            java.lang.Thread thread = new java.lang.Thread(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass4());
            thread.start();
            thread.join();
            com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || android.text.TextUtils.isEmpty(visitorLoginInfo2.getAid()) || android.text.TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
                throw new java.lang.Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo;
    }

    public void visitorLogin(com.weibo.ssosdk.VisitorLoginListener visitorLoginListener) {
        com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || android.text.TextUtils.isEmpty(visitorLoginInfo.getAid()) || android.text.TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            java.util.concurrent.Executors.newSingleThreadExecutor().execute(new com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass5(visitorLoginListener));
        } else {
            visitorLoginListener.handler(this.mVisitorLoginInfo);
        }
    }
}

package com.aliyun.svideosdk.license;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class LicenseManager implements com.aliyun.svideosdk.license.ILicenseNativeInitCallback {
    private static final java.lang.String TAG = "LicenseManager";
    private static com.aliyun.svideosdk.license.LicenseManager _singleton;
    private long mCertExpireTime;
    private long mCertSignTime;
    private int mErrorCode;
    private java.lang.String mErrorMessage;
    private long mExpireTime;
    private com.aliyun.svideosdk.license.ILicenseNativeInitCallback mInitCallback;
    private java.lang.String mLicenseFeatures;

    /* renamed from: com.aliyun.svideosdk.license.LicenseManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$errorCode;
        final /* synthetic */ java.lang.String val$errorMsg;

        public AnonymousClass1(int i, java.lang.String str) {
            this.val$errorCode = i;
            this.val$errorMsg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideosdk.license.LicenseManager.this.mInitCallback == null) {
                return;
            }
            com.aliyun.svideosdk.license.LicenseManager.this.mInitCallback.onError(this.val$errorCode, this.val$errorMsg);
            com.aliyun.svideosdk.license.LicenseManager.this.removeCallback();
        }
    }

    /* renamed from: com.aliyun.svideosdk.license.LicenseManager$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.svideosdk.license.LicenseManager.this.mInitCallback == null) {
                return;
            }
            com.aliyun.svideosdk.license.LicenseManager.this.mInitCallback.onSuccess(com.aliyun.svideosdk.license.LicenseManager.this.mLicenseFeatures, com.aliyun.svideosdk.license.LicenseManager.this.mCertSignTime, com.aliyun.svideosdk.license.LicenseManager.this.mCertExpireTime, com.aliyun.svideosdk.license.LicenseManager.this.mExpireTime);
            com.aliyun.svideosdk.license.LicenseManager.this.removeCallback();
        }
    }

    public interface Feature {
        public static final int CROP_COMPOSE = 4;
        public static final int EDITOR_CAPTION = 5;
        public static final int EDITOR_MV = 1;
        public static final int EDITOR_PHOTOALBUM = 3;
        public static final int EDITOR_STICKER = 2;
        public static final int VIDEO_STITCHING = 6;
    }

    public static com.aliyun.svideosdk.license.LicenseManager getInstance() {
        if (_singleton == null) {
            synchronized (com.aliyun.svideosdk.license.LicenseManager.class) {
                if (_singleton == null) {
                    _singleton = new com.aliyun.svideosdk.license.LicenseManager();
                }
            }
        }
        return _singleton;
    }

    public long getCertExpireTime() {
        return this.mCertExpireTime;
    }

    public long getCertSignTime() {
        return this.mCertSignTime;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public java.lang.String getErrorMessage() {
        return this.mErrorMessage;
    }

    public long getExpireTime() {
        return this.mExpireTime;
    }

    public java.lang.String getLicenseFeatures() {
        return this.mLicenseFeatures;
    }

    @Override // com.aliyun.svideosdk.license.ILicenseNativeInitCallback
    public void onError(int i, java.lang.String str) {
        this.mErrorCode = i;
        this.mErrorMessage = str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("license check fail : errorCode ");
        sb.append(i);
        sb.append(",errorMsg : ");
        sb.append(str);
        if (this.mInitCallback != null) {
            com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.license.LicenseManager.AnonymousClass1(i, str));
        }
    }

    @Override // com.aliyun.svideosdk.license.ILicenseNativeInitCallback
    public void onSuccess(java.lang.String str, long j, long j2, long j3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("license check success : feaature ");
        sb.append(str);
        sb.append(",certSignTime : ");
        sb.append(j);
        sb.append(",certExpireTime:");
        sb.append(j2);
        this.mErrorCode = 0;
        this.mErrorMessage = "";
        this.mLicenseFeatures = str;
        this.mCertSignTime = j;
        this.mCertExpireTime = j2;
        this.mExpireTime = j3;
        if (this.mInitCallback != null) {
            com.aliyun.common.utils.ThreadUtils.runOnUiThread(new com.aliyun.svideosdk.license.LicenseManager.AnonymousClass2());
        }
    }

    public void removeCallback() {
        this.mInitCallback = null;
    }

    public com.aliyun.svideosdk.license.LicenseManager setCallback(com.aliyun.svideosdk.license.ILicenseNativeInitCallback iLicenseNativeInitCallback) {
        this.mInitCallback = iLicenseNativeInitCallback;
        return this;
    }
}

package androidx.core.hardware.fingerprint;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class FingerprintManagerCompat {
    private final android.content.Context mContext;

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends android.hardware.fingerprint.FingerprintManager.AuthenticationCallback {
        final /* synthetic */ androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback val$callback;

        public AnonymousClass1(androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback) {
            this.val$callback = authenticationCallback;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, java.lang.CharSequence charSequence) {
            this.val$callback.onAuthenticationError(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.val$callback.onAuthenticationFailed();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, java.lang.CharSequence charSequence) {
            this.val$callback.onAuthenticationHelp(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult authenticationResult) {
            android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject;
            androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback = this.val$callback;
            cryptoObject = authenticationResult.getCryptoObject();
            authenticationCallback.onAuthenticationSucceeded(new androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult(androidx.core.hardware.fingerprint.FingerprintManagerCompat.unwrapCryptoObject(cryptoObject)));
        }
    }

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, java.lang.CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, java.lang.CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationResult authenticationResult) {
        }
    }

    public static final class AuthenticationResult {
        private final androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject mCryptoObject;

        public AuthenticationResult(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    public static class CryptoObject {
        private final javax.crypto.Cipher mCipher;
        private final javax.crypto.Mac mMac;
        private final java.security.Signature mSignature;

        public CryptoObject(@androidx.annotation.NonNull java.security.Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(@androidx.annotation.NonNull javax.crypto.Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(@androidx.annotation.NonNull javax.crypto.Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        @androidx.annotation.Nullable
        public javax.crypto.Cipher getCipher() {
            return this.mCipher;
        }

        @androidx.annotation.Nullable
        public javax.crypto.Mac getMac() {
            return this.mMac;
        }

        @androidx.annotation.Nullable
        public java.security.Signature getSignature() {
            return this.mSignature;
        }
    }

    private FingerprintManagerCompat(android.content.Context context) {
        this.mContext = context;
    }

    @androidx.annotation.NonNull
    public static androidx.core.hardware.fingerprint.FingerprintManagerCompat from(@androidx.annotation.NonNull android.content.Context context) {
        return new androidx.core.hardware.fingerprint.FingerprintManagerCompat(context);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(23)
    private static android.hardware.fingerprint.FingerprintManager getFingerprintManagerOrNull(@androidx.annotation.NonNull android.content.Context context) {
        java.lang.Object systemService;
        java.lang.Object systemService2;
        int i = android.os.Build.VERSION.SDK_INT;
        if (i == 23) {
            systemService2 = context.getSystemService((java.lang.Class<java.lang.Object>) android.hardware.fingerprint.FingerprintManager.class);
            return (android.hardware.fingerprint.FingerprintManager) systemService2;
        }
        if (i <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        systemService = context.getSystemService((java.lang.Class<java.lang.Object>) android.hardware.fingerprint.FingerprintManager.class);
        return (android.hardware.fingerprint.FingerprintManager) systemService;
    }

    @androidx.annotation.RequiresApi(23)
    public static androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject unwrapCryptoObject(android.hardware.fingerprint.FingerprintManager.CryptoObject cryptoObject) {
        javax.crypto.Cipher cipher;
        java.security.Signature signature;
        javax.crypto.Mac mac;
        javax.crypto.Mac mac2;
        java.security.Signature signature2;
        javax.crypto.Cipher cipher2;
        if (cryptoObject == null) {
            return null;
        }
        cipher = cryptoObject.getCipher();
        if (cipher != null) {
            cipher2 = cryptoObject.getCipher();
            return new androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(cipher2);
        }
        signature = cryptoObject.getSignature();
        if (signature != null) {
            signature2 = cryptoObject.getSignature();
            return new androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(signature2);
        }
        mac = cryptoObject.getMac();
        if (mac == null) {
            return null;
        }
        mac2 = cryptoObject.getMac();
        return new androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject(mac2);
    }

    @androidx.annotation.RequiresApi(23)
    private static android.hardware.fingerprint.FingerprintManager.AuthenticationCallback wrapCallback(androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback) {
        return new androidx.core.hardware.fingerprint.FingerprintManagerCompat.AnonymousClass1(authenticationCallback);
    }

    @androidx.annotation.RequiresApi(23)
    private static android.hardware.fingerprint.FingerprintManager.CryptoObject wrapCryptoObject(androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new android.hardware.fingerprint.FingerprintManager.CryptoObject(cryptoObject.getMac());
        }
        return null;
    }

    @androidx.annotation.RequiresPermission("android.permission.USE_FINGERPRINT")
    public void authenticate(@androidx.annotation.Nullable androidx.core.hardware.fingerprint.FingerprintManagerCompat.CryptoObject cryptoObject, int i, @androidx.annotation.Nullable androidx.core.os.CancellationSignal cancellationSignal, @androidx.annotation.NonNull androidx.core.hardware.fingerprint.FingerprintManagerCompat.AuthenticationCallback authenticationCallback, @androidx.annotation.Nullable android.os.Handler handler) {
        android.hardware.fingerprint.FingerprintManager fingerprintManagerOrNull;
        if (android.os.Build.VERSION.SDK_INT < 23 || (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) == null) {
            return;
        }
        fingerprintManagerOrNull.authenticate(wrapCryptoObject(cryptoObject), cancellationSignal != null ? (android.os.CancellationSignal) cancellationSignal.getCancellationSignalObject() : null, i, wrapCallback(authenticationCallback), handler);
    }

    @androidx.annotation.RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean hasEnrolledFingerprints() {
        android.hardware.fingerprint.FingerprintManager fingerprintManagerOrNull;
        boolean hasEnrolledFingerprints;
        if (android.os.Build.VERSION.SDK_INT < 23 || (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) == null) {
            return false;
        }
        hasEnrolledFingerprints = fingerprintManagerOrNull.hasEnrolledFingerprints();
        return hasEnrolledFingerprints;
    }

    @androidx.annotation.RequiresPermission("android.permission.USE_FINGERPRINT")
    public boolean isHardwareDetected() {
        android.hardware.fingerprint.FingerprintManager fingerprintManagerOrNull;
        boolean isHardwareDetected;
        if (android.os.Build.VERSION.SDK_INT < 23 || (fingerprintManagerOrNull = getFingerprintManagerOrNull(this.mContext)) == null) {
            return false;
        }
        isHardwareDetected = fingerprintManagerOrNull.isHardwareDetected();
        return isHardwareDetected;
    }
}

package androidx.core.content.pm;

/* loaded from: classes.dex */
public final class PackageInfoCompat {

    @androidx.annotation.RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @androidx.annotation.Nullable
        public static android.content.pm.Signature[] getApkContentsSigners(@androidx.annotation.NonNull android.content.pm.SigningInfo signingInfo) {
            android.content.pm.Signature[] apkContentsSigners;
            apkContentsSigners = signingInfo.getApkContentsSigners();
            return apkContentsSigners;
        }

        @androidx.annotation.Nullable
        public static android.content.pm.Signature[] getSigningCertificateHistory(@androidx.annotation.NonNull android.content.pm.SigningInfo signingInfo) {
            android.content.pm.Signature[] signingCertificateHistory;
            signingCertificateHistory = signingInfo.getSigningCertificateHistory();
            return signingCertificateHistory;
        }

        public static boolean hasMultipleSigners(@androidx.annotation.NonNull android.content.pm.SigningInfo signingInfo) {
            boolean hasMultipleSigners;
            hasMultipleSigners = signingInfo.hasMultipleSigners();
            return hasMultipleSigners;
        }

        public static boolean hasSigningCertificate(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull byte[] bArr, int i) {
            boolean hasSigningCertificate;
            hasSigningCertificate = packageManager.hasSigningCertificate(str, bArr, i);
            return hasSigningCertificate;
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(@androidx.annotation.NonNull byte[][] bArr, @androidx.annotation.NonNull byte[] bArr2) {
        for (byte[] bArr3 : bArr) {
            if (java.util.Arrays.equals(bArr2, bArr3)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] bArr) {
        try {
            return java.security.MessageDigest.getInstance("SHA256").digest(bArr);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException("Device doesn't support SHA256 cert checking", e);
        }
    }

    public static long getLongVersionCode(@androidx.annotation.NonNull android.content.pm.PackageInfo packageInfo) {
        long longVersionCode;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return packageInfo.versionCode;
        }
        longVersionCode = packageInfo.getLongVersionCode();
        return longVersionCode;
    }

    @androidx.annotation.NonNull
    public static java.util.List<android.content.pm.Signature> getSignatures(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager, @androidx.annotation.NonNull java.lang.String str) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.Signature[] signatureArr;
        android.content.pm.SigningInfo signingInfo;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
            signatureArr = androidx.core.content.pm.PackageInfoCompat.Api28Impl.hasMultipleSigners(signingInfo) ? androidx.core.content.pm.PackageInfoCompat.Api28Impl.getApkContentsSigners(signingInfo) : androidx.core.content.pm.PackageInfoCompat.Api28Impl.getSigningCertificateHistory(signingInfo);
        } else {
            signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        }
        return signatureArr == null ? java.util.Collections.emptyList() : java.util.Arrays.asList(signatureArr);
    }

    public static boolean hasSignatures(@androidx.annotation.NonNull android.content.pm.PackageManager packageManager, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull @androidx.annotation.Size(min = 1) java.util.Map<byte[], java.lang.Integer> map, boolean z) throws android.content.pm.PackageManager.NameNotFoundException {
        byte[][] bArr;
        if (map.isEmpty()) {
            return false;
        }
        java.util.Set<byte[]> keySet = map.keySet();
        for (byte[] bArr2 : keySet) {
            if (bArr2 == null) {
                throw new java.lang.IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
            java.lang.Integer num = map.get(bArr2);
            if (num == null) {
                throw new java.lang.IllegalArgumentException("Type must be specified for cert when verifying " + str);
            }
            int intValue = num.intValue();
            if (intValue != 0 && intValue != 1) {
                throw new java.lang.IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
            }
        }
        java.util.List<android.content.pm.Signature> signatures = getSignatures(packageManager, str);
        if (!z && android.os.Build.VERSION.SDK_INT >= 28) {
            for (byte[] bArr3 : keySet) {
                if (!androidx.core.content.pm.PackageInfoCompat.Api28Impl.hasSigningCertificate(packageManager, str, bArr3, map.get(bArr3).intValue())) {
                    return false;
                }
            }
            return true;
        }
        if (signatures.size() != 0 && map.size() <= signatures.size() && (!z || map.size() == signatures.size())) {
            if (map.containsValue(1)) {
                bArr = new byte[signatures.size()][];
                for (int i = 0; i < signatures.size(); i++) {
                    bArr[i] = computeSHA256Digest(signatures.get(i).toByteArray());
                }
            } else {
                bArr = null;
            }
            java.util.Iterator<byte[]> it = keySet.iterator();
            if (it.hasNext()) {
                byte[] next = it.next();
                java.lang.Integer num2 = map.get(next);
                int intValue2 = num2.intValue();
                if (intValue2 != 0) {
                    if (intValue2 != 1) {
                        throw new java.lang.IllegalArgumentException("Unsupported certificate type " + num2);
                    }
                    if (!byteArrayContains(bArr, next)) {
                        return false;
                    }
                } else if (!signatures.contains(new android.content.pm.Signature(next))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}

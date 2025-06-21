package com.huawei.secure.android.common.sign;

/* loaded from: classes22.dex */
public class HiPkgSignManager {
    public static android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "Exception : " + e.getMessage(), true);
            return null;
        }
    }

    public static java.lang.String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            if ((b & 255) < 16) {
                stringBuffer.append("0" + java.lang.Integer.toHexString(bArr[i] & 255));
            } else {
                stringBuffer.append(java.lang.Integer.toHexString(b & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(java.util.Locale.ENGLISH);
    }

    public static java.util.List<java.lang.String> c(android.content.pm.Signature[] signatureArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (signatureArr != null && signatureArr.length != 0) {
            for (android.content.pm.Signature signature : signatureArr) {
                arrayList.add(d(signature.toByteArray()));
            }
        }
        return arrayList;
    }

    public static java.lang.String d(byte[] bArr) {
        try {
            return b(java.security.MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (java.security.NoSuchAlgorithmException e) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    public static boolean doCheckArchiveApk(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.pm.PackageInfo a;
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || context == null || android.text.TextUtils.isEmpty(str3) || (a = a(context, str2)) == null) {
            return false;
        }
        return str.equalsIgnoreCase(d(a.signatures[0].toByteArray())) && str3.equals(a.packageName);
    }

    public static boolean doCheckInstalled(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equalsIgnoreCase(getInstalledAppHash(context, str2));
    }

    public static boolean doCheckInstalledV2V3(android.content.Context context, java.util.List<java.lang.String> list, java.lang.String str) {
        java.util.List<java.lang.String> installedAppHashV2V3;
        if (android.text.TextUtils.isEmpty(str) || list == null || context == null || (installedAppHashV2V3 = getInstalledAppHashV2V3(context, str)) == null) {
            return false;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toUpperCase(java.util.Locale.ENGLISH));
        }
        java.util.Iterator<java.lang.String> it2 = installedAppHashV2V3.iterator();
        while (it2.hasNext()) {
            if (!arrayList.contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getInstalledAPPSignature(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageInfo packageInfo;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "packageName is null or context is null");
            return new byte[0];
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "PackageManager.NameNotFoundException : " + e.getMessage(), true);
        } catch (java.lang.Exception e2) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "Exception : " + e2.getMessage(), true);
        }
        return new byte[0];
    }

    public static java.lang.String getInstalledAppHash(android.content.Context context, java.lang.String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        return (installedAPPSignature == null || installedAPPSignature.length <= 0) ? "" : d(installedAPPSignature);
    }

    public static java.util.List<java.lang.String> getInstalledAppHashV2V3(android.content.Context context, java.lang.String str) {
        android.content.pm.PackageManager packageManager;
        android.content.pm.Signature[] signatureArr;
        android.content.pm.SigningInfo signingInfo;
        android.content.pm.SigningInfo signingInfo2;
        boolean hasMultipleSigners;
        android.content.pm.SigningInfo signingInfo3;
        android.content.pm.Signature[] signingCertificateHistory;
        android.content.pm.SigningInfo signingInfo4;
        android.content.pm.Signature[] apkContentsSigners;
        try {
            packageManager = context.getPackageManager();
        } catch (java.lang.Throwable unused) {
        }
        if (android.os.Build.VERSION.SDK_INT < 28) {
            android.content.pm.PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length != 0 && signatureArr[0] != null) {
                return c(signatureArr);
            }
            return null;
        }
        android.content.pm.PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 134217728);
        if (packageInfo2 != null) {
            signingInfo = packageInfo2.signingInfo;
            if (signingInfo != null) {
                signingInfo2 = packageInfo2.signingInfo;
                hasMultipleSigners = signingInfo2.hasMultipleSigners();
                if (hasMultipleSigners) {
                    signingInfo4 = packageInfo2.signingInfo;
                    apkContentsSigners = signingInfo4.getApkContentsSigners();
                    return c(apkContentsSigners);
                }
                signingInfo3 = packageInfo2.signingInfo;
                signingCertificateHistory = signingInfo3.getSigningCertificateHistory();
                return c(signingCertificateHistory);
            }
        }
        return null;
    }

    public static java.lang.String getUnInstalledAPPPackageName(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "archiveFilePath is null or context is null");
            return "";
        }
        android.content.pm.PackageInfo a = a(context, str);
        return a != null ? a.packageName : "";
    }

    public static byte[] getUnInstalledAPPSignature(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "archiveFilePath is null or context is null");
            return new byte[0];
        }
        android.content.pm.PackageInfo a = a(context, str);
        if (a != null) {
            android.content.pm.Signature signature = a.signatures[0];
            if (signature != null) {
                return signature.toByteArray();
            }
        } else {
            com.huawei.secure.android.common.util.LogsUtil.e("HiPkgSignManager", "PackageInfo is null ");
        }
        return new byte[0];
    }

    public static java.lang.String getUnInstalledAppHash(android.content.Context context, java.lang.String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        return (unInstalledAPPSignature == null || unInstalledAPPSignature.length <= 0) ? "" : d(unInstalledAPPSignature);
    }
}

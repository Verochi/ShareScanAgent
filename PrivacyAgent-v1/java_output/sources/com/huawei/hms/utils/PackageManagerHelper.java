package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class PackageManagerHelper {
    public final android.content.pm.PackageManager a;

    public enum PackageStates {
        ENABLED,
        DISABLED,
        NOT_INSTALLED,
        SPOOF
    }

    public PackageManagerHelper(android.content.Context context) {
        this.a = context.getPackageManager();
    }

    public final byte[] a(java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0) {
                return signatureArr[0].toByteArray();
            }
        } catch (android.util.AndroidException e) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
        } catch (java.lang.RuntimeException e2) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.", e2);
        }
        com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    public java.lang.String getApplicationName(java.lang.String str) {
        try {
            return this.a.getApplicationLabel(this.a.getApplicationInfo(str, 128)).toString();
        } catch (android.util.AndroidException unused) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "Failed to get application name for " + str);
            return null;
        }
    }

    public long getPackageFirstInstallTime(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (android.util.AndroidException | java.lang.RuntimeException unused) {
            return 0L;
        }
    }

    public java.lang.String getPackageSignature(java.lang.String str) {
        byte[] a = a(str);
        if (a == null || a.length == 0) {
            return null;
        }
        return com.huawei.hms.utils.HEX.encodeHexString(com.huawei.hms.utils.SHA256.digest(a), true);
    }

    public com.huawei.hms.utils.PackageManagerHelper.PackageStates getPackageStates(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED;
        }
        try {
            return this.a.getApplicationInfo(str, 128).enabled ? com.huawei.hms.utils.PackageManagerHelper.PackageStates.ENABLED : com.huawei.hms.utils.PackageManagerHelper.PackageStates.DISABLED;
        } catch (android.util.AndroidException unused) {
            return com.huawei.hms.utils.PackageManagerHelper.PackageStates.NOT_INSTALLED;
        }
    }

    public int getPackageVersionCode(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (android.util.AndroidException e) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed " + e);
            return 0;
        } catch (java.lang.RuntimeException e2) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "get PackageVersionCode failed", e2);
            return 0;
        }
    }

    public java.lang.String getPackageVersionName(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                java.lang.String str2 = packageInfo.versionName;
                if (str2 != null) {
                    return str2;
                }
            }
            return "";
        } catch (android.util.AndroidException unused) {
            return "";
        } catch (java.lang.RuntimeException e) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "get getPackageVersionName failed", e);
            return "";
        }
    }

    public boolean hasProvider(java.lang.String str, java.lang.String str2) {
        android.content.pm.ProviderInfo[] providerInfoArr;
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (android.content.pm.ProviderInfo providerInfo : providerInfoArr) {
                    if (str2.equals(providerInfo.authority)) {
                        return true;
                    }
                }
            }
        } catch (android.util.AndroidException | java.lang.RuntimeException unused) {
        }
        return false;
    }

    public boolean isPackageFreshInstall(java.lang.String str) {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageInfo(str, 128);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
            }
            return false;
        } catch (android.util.AndroidException | java.lang.RuntimeException unused) {
            return false;
        }
    }

    public boolean verifyPackageArchive(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.pm.PackageInfo packageArchiveInfo = this.a.getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null || packageArchiveInfo.signatures.length <= 0 || !str2.equals(packageArchiveInfo.packageName)) {
            return false;
        }
        java.io.InputStream inputStream = null;
        try {
            try {
                inputStream = com.huawei.hms.utils.IOUtils.toInputStream(packageArchiveInfo.signatures[0].toByteArray());
                return str3.equalsIgnoreCase(com.huawei.hms.utils.HEX.encodeHexString(com.huawei.hms.utils.SHA256.digest(java.security.cert.CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
            } finally {
                com.huawei.hms.utils.IOUtils.closeQuietly((java.io.InputStream) null);
            }
        } catch (java.io.IOException | java.security.cert.CertificateException e) {
            com.huawei.hms.support.log.HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            return false;
        }
    }
}

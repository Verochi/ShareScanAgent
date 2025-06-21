package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class LibraryVersion {
    public static final com.google.android.gms.common.internal.GmsLogger b = new com.google.android.gms.common.internal.GmsLogger("LibraryVersion", "");
    public static com.google.android.gms.common.internal.LibraryVersion c = new com.google.android.gms.common.internal.LibraryVersion();
    public java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> a = new java.util.concurrent.ConcurrentHashMap<>();

    @com.google.android.gms.common.util.VisibleForTesting
    public LibraryVersion() {
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public static com.google.android.gms.common.internal.LibraryVersion getInstance() {
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b7  */
    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String getVersion(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        java.lang.String str2;
        java.io.InputStream resourceAsStream;
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(str, "Please provide a valid libraryName");
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        java.util.Properties properties = new java.util.Properties();
        java.io.InputStream inputStream = null;
        java.lang.String str3 = null;
        java.io.InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = com.google.android.gms.common.internal.LibraryVersion.class.getResourceAsStream(java.lang.String.format("/%s.properties", str));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
            str2 = null;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str3 = properties.getProperty("version", null);
                com.google.android.gms.common.internal.GmsLogger gmsLogger = b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 12 + java.lang.String.valueOf(str3).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str3);
                gmsLogger.v("LibraryVersion", sb.toString());
            } else {
                com.google.android.gms.common.internal.GmsLogger gmsLogger2 = b;
                java.lang.String valueOf = java.lang.String.valueOf(str);
                gmsLogger2.w("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new java.lang.String("Failed to get app version for libraryName: "));
            }
            if (resourceAsStream != null) {
                com.google.android.gms.common.util.IOUtils.closeQuietly(resourceAsStream);
            }
        } catch (java.io.IOException e2) {
            e = e2;
            str2 = null;
            inputStream = resourceAsStream;
            com.google.android.gms.common.internal.GmsLogger gmsLogger3 = b;
            java.lang.String valueOf2 = java.lang.String.valueOf(str);
            gmsLogger3.e("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new java.lang.String("Failed to get app version for libraryName: "), e);
            if (inputStream != null) {
                com.google.android.gms.common.util.IOUtils.closeQuietly(inputStream);
            }
            str3 = str2;
            if (str3 == null) {
            }
            this.a.put(str, str3);
            return str3;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inputStream2 = resourceAsStream;
            if (inputStream2 != null) {
                com.google.android.gms.common.util.IOUtils.closeQuietly(inputStream2);
            }
            throw th;
        }
        if (str3 == null) {
            b.d("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            str3 = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        this.a.put(str, str3);
        return str3;
    }
}

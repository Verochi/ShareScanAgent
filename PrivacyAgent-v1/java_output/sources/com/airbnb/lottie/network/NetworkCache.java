package com.airbnb.lottie.network;

/* loaded from: classes.dex */
public class NetworkCache {

    @androidx.annotation.NonNull
    public final com.airbnb.lottie.network.LottieNetworkCacheProvider a;

    public NetworkCache(@androidx.annotation.NonNull com.airbnb.lottie.network.LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.a = lottieNetworkCacheProvider;
    }

    public static java.lang.String b(java.lang.String str, com.airbnb.lottie.network.FileExtension fileExtension, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    public android.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> a(java.lang.String str) {
        try {
            java.io.File c = c(str);
            if (c == null) {
                return null;
            }
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(c);
            com.airbnb.lottie.network.FileExtension fileExtension = c.getAbsolutePath().endsWith(".zip") ? com.airbnb.lottie.network.FileExtension.ZIP : com.airbnb.lottie.network.FileExtension.JSON;
            com.airbnb.lottie.utils.Logger.debug("Cache hit for " + str + " at " + c.getAbsolutePath());
            return new android.util.Pair<>(fileExtension, fileInputStream);
        } catch (java.io.FileNotFoundException unused) {
            return null;
        }
    }

    @androidx.annotation.Nullable
    public final java.io.File c(java.lang.String str) throws java.io.FileNotFoundException {
        java.io.File file = new java.io.File(d(), b(str, com.airbnb.lottie.network.FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        java.io.File file2 = new java.io.File(d(), b(str, com.airbnb.lottie.network.FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public void clear() {
        java.io.File d = d();
        if (d.exists()) {
            java.io.File[] listFiles = d.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (java.io.File file : d.listFiles()) {
                    file.delete();
                }
            }
            d.delete();
        }
    }

    public final java.io.File d() {
        java.io.File cacheDir = this.a.getCacheDir();
        if (cacheDir.isFile()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    public void e(java.lang.String str, com.airbnb.lottie.network.FileExtension fileExtension) {
        java.io.File file = new java.io.File(d(), b(str, fileExtension, true));
        java.io.File file2 = new java.io.File(file.getAbsolutePath().replace(com.anythink.china.common.a.a.e, ""));
        boolean renameTo = file.renameTo(file2);
        com.airbnb.lottie.utils.Logger.debug("Copying temp file to real file (" + file2 + ")");
        if (renameTo) {
            return;
        }
        com.airbnb.lottie.utils.Logger.warning("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public java.io.File f(java.lang.String str, java.io.InputStream inputStream, com.airbnb.lottie.network.FileExtension fileExtension) throws java.io.IOException {
        java.io.File file = new java.io.File(d(), b(str, fileExtension, true));
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}

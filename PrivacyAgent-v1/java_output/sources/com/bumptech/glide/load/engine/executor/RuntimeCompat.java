package com.bumptech.glide.load.engine.executor;

/* loaded from: classes.dex */
final class RuntimeCompat {
    private static final java.lang.String CPU_LOCATION = "/sys/devices/system/cpu/";
    private static final java.lang.String CPU_NAME_REGEX = "cpu[0-9]+";
    private static final java.lang.String TAG = "GlideRuntimeCompat";

    /* renamed from: com.bumptech.glide.load.engine.executor.RuntimeCompat$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FilenameFilter {
        final /* synthetic */ java.util.regex.Pattern val$cpuNamePattern;

        public AnonymousClass1(java.util.regex.Pattern pattern) {
            this.val$cpuNamePattern = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(java.io.File file, java.lang.String str) {
            return this.val$cpuNamePattern.matcher(str).matches();
        }
    }

    private RuntimeCompat() {
    }

    public static int availableProcessors() {
        return java.lang.Runtime.getRuntime().availableProcessors();
    }

    private static int getCoreCountPre17() {
        java.io.File[] fileArr;
        android.os.StrictMode.ThreadPolicy allowThreadDiskReads = android.os.StrictMode.allowThreadDiskReads();
        try {
            try {
                fileArr = new java.io.File(CPU_LOCATION).listFiles(new com.bumptech.glide.load.engine.executor.RuntimeCompat.AnonymousClass1(java.util.regex.Pattern.compile(CPU_NAME_REGEX)));
            } finally {
                android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (java.lang.Throwable unused) {
            android.util.Log.isLoggable(TAG, 6);
            android.os.StrictMode.setThreadPolicy(allowThreadDiskReads);
            fileArr = null;
        }
        return java.lang.Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}

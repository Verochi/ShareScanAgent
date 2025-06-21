package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class Constants {

    public static class SDCardConstants {
        public static final java.lang.String COMPOSE_SUFFIX = "-compose.mp4";
        public static final java.lang.String CROP_SUFFIX = "-crop.mp4";
        private static final java.lang.String TAG = "SDCardConstants";
        public static final java.lang.String TRANSCODE_SUFFIX = ".mp4_transcode";

        /* renamed from: com.aliyun.svideo.base.Constants$SDCardConstants$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.io.File val$cacheDir;

            public AnonymousClass1(java.io.File file) {
                this.val$cacheDir = file;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean deleteFile = com.aliyun.svideo.base.Constants.SDCardConstants.deleteFile(this.val$cacheDir);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("delete cache file ");
                sb.append(deleteFile);
            }
        }

        public static void clearCacheDir(android.content.Context context) {
            com.aliyun.svideo.common.utils.ThreadUtils.runOnSubThread(new com.aliyun.svideo.base.Constants.SDCardConstants.AnonymousClass1(new java.io.File(context.getExternalCacheDir(), "svideo")));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean deleteFile(java.io.File file) {
            if (file == null || !file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                java.io.File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return true;
                }
                for (java.io.File file2 : listFiles) {
                    deleteFile(file2);
                }
            }
            return file.delete();
        }

        public static java.lang.String getCacheDir(android.content.Context context) {
            java.io.File file = new java.io.File(context.getExternalCacheDir(), "svideo");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.exists() ? file.getPath() : "";
        }

        public static java.lang.String getDir(android.content.Context context) {
            java.lang.String sb;
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(context.getExternalFilesDir(""));
                java.lang.String str = java.io.File.separator;
                sb2.append(str);
                sb2.append("Media");
                sb2.append(str);
                sb = sb2.toString();
            } else {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(android.os.Environment.getExternalStorageDirectory());
                java.lang.String str2 = java.io.File.separator;
                sb3.append(str2);
                sb3.append("DCIM");
                sb3.append(str2);
                sb3.append("Camera");
                sb3.append(str2);
                sb = sb3.toString();
            }
            java.io.File file = new java.io.File(sb);
            if (!file.exists()) {
                file.mkdirs();
            }
            return sb;
        }
    }
}

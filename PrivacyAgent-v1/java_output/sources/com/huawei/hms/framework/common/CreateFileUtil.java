package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class CreateFileUtil {
    private static final java.lang.String EXTERNAL_FILE_NAME = "com.huawei.libcore.io.ExternalStorageFile";
    private static final java.lang.String EXTERNAL_INPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileInputStream";
    private static final java.lang.String EXTERNAL_OUTPUTSTREAM_NAME = "com.huawei.libcore.io.ExternalStorageFileOutputStream";
    private static final java.lang.String RANDOM_ACCESS_FILE_NAME = "com.huawei.libcore.io.ExternalStorageRandomAccessFile";
    private static final java.lang.String TAG = "CreateFileUtil";

    public static void deleteSecure(java.io.File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        com.huawei.hms.framework.common.Logger.w(TAG, "deleteSecure exception");
    }

    public static void deleteSecure(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        deleteSecure(newFile(str));
    }

    public static java.lang.String getCacheDirPath(android.content.Context context) {
        return context == null ? "" : com.huawei.hms.framework.common.ContextCompat.getProtectedStorageContext(context).getCacheDir().getPath();
    }

    public static java.lang.String getCanonicalPath(java.lang.String str) {
        try {
            return newFile(str).getCanonicalPath();
        } catch (java.io.IOException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the canonicalPath has IOException", e);
            return str;
        } catch (java.lang.SecurityException e2) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the canonicalPath has securityException", e2);
            return str;
        } catch (java.lang.Exception e3) {
            com.huawei.hms.framework.common.Logger.w(TAG, "the canonicalPath has other Exception", e3);
            return str;
        }
    }

    @java.lang.Deprecated
    public static boolean isPVersion() {
        return com.huawei.hms.framework.common.EmuiUtil.isUpPVersion();
    }

    public static java.io.File newFile(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return (com.huawei.hms.framework.common.EmuiUtil.isUpPVersion() && com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(EXTERNAL_FILE_NAME)) ? new com.huawei.libcore.io.ExternalStorageFile(str) : new java.io.File(str);
    }

    public static java.io.FileInputStream newFileInputStream(java.lang.String str) throws java.io.FileNotFoundException {
        if (str != null) {
            return (com.huawei.hms.framework.common.EmuiUtil.isUpPVersion() && com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(EXTERNAL_INPUTSTREAM_NAME)) ? new com.huawei.libcore.io.ExternalStorageFileInputStream(str) : new java.io.FileInputStream(str);
        }
        com.huawei.hms.framework.common.Logger.w(TAG, "newFileInputStream  file is null");
        throw new java.io.FileNotFoundException("file is null");
    }

    public static java.io.FileOutputStream newFileOutputStream(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return (com.huawei.hms.framework.common.EmuiUtil.isUpPVersion() && com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(EXTERNAL_OUTPUTSTREAM_NAME)) ? new com.huawei.libcore.io.ExternalStorageFileOutputStream(file) : new java.io.FileOutputStream(file);
        }
        com.huawei.hms.framework.common.Logger.e(TAG, "newFileOutputStream  file is null");
        throw new java.io.FileNotFoundException("file is null");
    }

    public static java.io.RandomAccessFile newRandomAccessFile(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        if (str != null) {
            return (com.huawei.hms.framework.common.EmuiUtil.isUpPVersion() && com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(RANDOM_ACCESS_FILE_NAME)) ? new com.huawei.libcore.io.ExternalStorageRandomAccessFile(str, str2) : new java.io.RandomAccessFile(str, str2);
        }
        com.huawei.hms.framework.common.Logger.w(TAG, "newFileOutputStream  file is null");
        throw new java.io.FileNotFoundException("file is null");
    }
}

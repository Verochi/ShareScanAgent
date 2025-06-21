package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadUtils {
    public static final java.lang.String ACCEPT_RANGES = "Accept-Ranges";
    public static final java.lang.String CACHE_CONTROL = "Cache-Control";
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final java.lang.String CONTENT_DISPOSITION = "Content-Disposition";
    public static final java.lang.String CONTENT_LENGTH = "Content-Length";
    public static final java.lang.String CONTENT_RANGE = "Content-Range";
    public static final java.lang.String CONTENT_TYPE = "Content-Type";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static final java.lang.String ETAG = "Etag";
    private static final java.lang.String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final java.lang.String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    public static final java.lang.String IF_MODIFIED_SINCE = "if-modified-since";
    public static final java.lang.String LAST_MODIFIED = "last-modified";
    public static final java.lang.String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final java.lang.String TAG = "DownloadUtils";
    public static final java.lang.String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final java.lang.String VALUE_CHUNKED = "chunked";
    public static final java.lang.String X_CACHE = "X-Cache";
    private static android.net.ConnectivityManager connectivityManager;
    private static java.lang.Boolean sIsDownloaderProcess;
    private static java.lang.Boolean sIsMainProcess;
    private static final java.util.regex.Pattern CONTENT_RANGE_RIGHT_VALUE = java.util.regex.Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static java.lang.String sCurProcessName = null;
    private static volatile android.util.SparseArray<java.lang.Boolean> saveTempFileStatusMap = new android.util.SparseArray<>();
    private static volatile android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback>> saveTempFileListeners = new android.util.SparseArray<>();
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.BOTTOM, 'c', 'd', 'e', 'f'};
    private static java.util.regex.Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = null;
    private static java.util.regex.Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = null;

    public static java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> add0_0RangeHeader(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity"));
        arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader("Range", "bytes=0-0"));
        return arrayList;
    }

    public static java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> addRangeHeader(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, java.lang.String str, long j, long j2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
                if (httpHeader != null) {
                    arrayList.add(httpHeader);
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity"));
        java.lang.String format = j2 <= 0 ? java.lang.String.format("bytes=%s-", java.lang.String.valueOf(j)) : java.lang.String.format("bytes=%s-%s", java.lang.String.valueOf(j), java.lang.String.valueOf(j2));
        arrayList.add(new com.ss.android.socialbase.downloader.model.HttpHeader("Range", format));
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, " range CurrentOffset:" + j + " EndOffset:" + j2 + ", range = " + format);
        return arrayList;
    }

    public static java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> addRangeHeader(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, java.lang.String str, com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        return addRangeHeader(list, str, downloadChunk.getCurOffset(), downloadChunk.getEndOffset());
    }

    public static void addTTNetProtectTimeout(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        long ttnetProtectTimeout = downloadInfo.getTtnetProtectTimeout();
        if (ttnetProtectTimeout > 300) {
            list.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, java.lang.String.valueOf(ttnetProtectTimeout)));
        }
    }

    public static void addThrottleNetSpeed(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        long throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
        if (throttleNetSpeed > 0) {
            list.add(new com.ss.android.socialbase.downloader.model.HttpHeader(com.ss.android.socialbase.downloader.constants.DownloadConstants.EXTRA_THROTTLE_NET_SPEED, java.lang.String.valueOf(throttleNetSpeed)));
        }
    }

    public static double byteToMb(long j) {
        return j / 1048576.0d;
    }

    public static boolean cacheExpired(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        boolean z = false;
        if (downloadInfo.isDeleteCacheIfCheckFailed() || !android.text.TextUtils.isEmpty(downloadInfo.getLastModified())) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "dcache::curt=" + java.lang.System.currentTimeMillis() + " expired=" + downloadInfo.getCacheExpiredTime());
            if (java.lang.System.currentTimeMillis() > downloadInfo.getCacheExpiredTime()) {
                z = true;
            }
        } else {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "dcache::last modify is emtpy, so just return cache");
        }
        com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "cacheExpired::dcache::name=" + downloadInfo.getName() + " expired=" + z);
        return z;
    }

    public static boolean canAcceptPartial(int i, java.lang.String str) {
        if (com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(16777216)) {
            return i == 206 || i == 1;
        }
        if (i >= 400) {
            return false;
        }
        return i == 206 || i == 1 || "bytes".equals(str);
    }

    public static boolean canChunkDowngradeRetry(com.ss.android.socialbase.downloader.exception.BaseException baseException, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (baseException == null) {
            return false;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1000 || errorCode == 1032 || errorCode == 1033 || errorCode == 1034 || errorCode == 1008 || errorCode == 1026 || errorCode == 1027 || errorCode == 1044 || errorCode == 1020) {
            return true;
        }
        return (errorCode == 1049 || errorCode == 1055 || errorCode == 1006 || downloadInfo == null || downloadInfo.getCurBytes() >= 8388608) ? false : true;
    }

    public static int checkMd5Status(java.io.File file, java.lang.String str) {
        return com.ss.android.vw.t.vw(str, file);
    }

    public static int checkMd5Status(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return com.ss.android.vw.t.vw(str3, new java.io.File(str, str2));
    }

    public static boolean checkMd5Valid(java.io.File file, java.lang.String str) {
        return isMd5Valid(com.ss.android.vw.t.vw(str, file));
    }

    public static boolean checkMd5Valid(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return isMd5Valid(checkMd5Status(str, str2, str3));
    }

    public static boolean checkPermission(android.content.Context context, java.lang.String str) {
        return (context == null || android.text.TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static void clearAntiHijackDir(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.setting.DownloadSetting obtain;
        org.json.JSONObject optJSONObject;
        if (downloadInfo == null || (optJSONObject = (obtain = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId())).optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return;
        }
        java.lang.String optString = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC);
        if (!android.text.TextUtils.isEmpty(optString)) {
            deleteFile(downloadInfo.getSavePath(), optString);
        }
        java.lang.String title = downloadInfo.getTitle();
        if (android.text.TextUtils.isEmpty(title)) {
            title = downloadInfo.getName();
        }
        java.lang.String redirectSavePath = getRedirectSavePath(title, obtain);
        java.lang.String savePath = downloadInfo.getSavePath();
        if (android.text.TextUtils.isEmpty(redirectSavePath) || android.text.TextUtils.isEmpty(savePath)) {
            return;
        }
        java.io.File file = new java.io.File(redirectSavePath);
        for (java.io.File file2 = new java.io.File(savePath); file != null && file2 != null && file2.isDirectory() && android.text.TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            deleteDirIfEmpty(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static com.ss.android.socialbase.downloader.constants.ListenerType convertListenerType(int i) {
        com.ss.android.socialbase.downloader.constants.ListenerType listenerType = com.ss.android.socialbase.downloader.constants.ListenerType.MAIN;
        com.ss.android.socialbase.downloader.constants.ListenerType listenerType2 = com.ss.android.socialbase.downloader.constants.ListenerType.SUB;
        if (i != listenerType2.ordinal()) {
            listenerType2 = com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION;
            if (i != listenerType2.ordinal()) {
                return listenerType;
            }
        }
        return listenerType2;
    }

    public static boolean copyFile(java.io.File file, java.io.File file2) throws com.ss.android.socialbase.downloader.exception.BaseException {
        return copyFile(file, file2, true);
    }

    public static boolean copyFile(java.io.File file, java.io.File file2, boolean z) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    java.io.File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TARGET_DIR_MKDIR_FAILED, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("copyFile: srcFile:");
                    sb.append(file.getPath());
                    sb.append(" destFile:");
                    sb.append(file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new java.io.IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    doCopyFile(file, file2, z);
                    return true;
                }
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                throw e;
            } catch (java.lang.Throwable th) {
                parseException(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static void copyFileFromExistFileWithSameName(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (downloadInfo == null || android.text.TextUtils.isEmpty(str) || str.equals(downloadInfo.getName())) {
            return;
        }
        java.io.File file = new java.io.File(downloadInfo.getSavePath(), str);
        java.io.File file2 = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
        java.lang.StringBuilder sb = new java.lang.StringBuilder("copyFileFromExistFileWithSameName: existFile:");
        sb.append(file.getPath());
        sb.append(" targetFile:");
        sb.append(file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1001, "targetPath file exists but read-only");
        }
        if (!copyFile(file, file2)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1001, java.lang.String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", downloadInfo.getSavePath(), str, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
    }

    public static long cost(long j) {
        return java.lang.System.currentTimeMillis() - j;
    }

    public static com.ss.android.socialbase.downloader.model.RandomAccessOutputStream createOutputStream(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2, int i) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1021, new java.io.IOException("path must be not empty"));
        }
        java.io.File file = new java.io.File(str, str2);
        boolean z = false;
        if (file.exists() && file.isDirectory()) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_FILE_IS_DIRECTORY, new java.io.IOException(java.lang.String.format("path is :%s, path is directory:%B:", str, java.lang.Boolean.valueOf(file.isDirectory()))));
        }
        if (!file.exists()) {
            try {
                java.io.File file2 = new java.io.File(str);
                if (!file2.exists() || !file2.isDirectory()) {
                    if (file2.exists()) {
                        file2.delete();
                        if (file2.mkdirs() || file2.exists()) {
                            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:" + str);
                        }
                        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SAVE_PATH_NOT_DIRECTORY, "download savePath is not directory:path=" + str);
                    }
                    if (!file2.mkdirs() && !file2.exists()) {
                        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.OPT_MKDIR_FAILED, 0) != 1) {
                            throw new com.ss.android.socialbase.downloader.exception.BaseException(1030, "download savePath directory can not created:" + str);
                        }
                        int i2 = 0;
                        while (!z) {
                            int i3 = i2 + 1;
                            if (i2 >= 3) {
                                break;
                            }
                            try {
                                java.lang.Thread.sleep(10L);
                                z = file2.mkdirs();
                                i2 = i3;
                            } catch (java.lang.InterruptedException unused) {
                            }
                        }
                        if (!z) {
                            if (getAvailableSpaceBytes(downloadInfo.getSavePath()) < 16384) {
                                throw new com.ss.android.socialbase.downloader.exception.BaseException(1006, "download savePath directory can not created:" + str);
                            }
                            throw new com.ss.android.socialbase.downloader.exception.BaseException(1030, "download savePath directory can not created:" + str);
                        }
                    }
                }
                file.createNewFile();
            } catch (java.io.IOException e) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_FILE_CREATE_FAILED, e);
            }
        }
        return new com.ss.android.socialbase.downloader.model.RandomAccessOutputStream(file, i);
    }

    public static void deleteAllDownloadFiles(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        deleteAllDownloadFiles(downloadInfo, true);
    }

    public static void deleteAllDownloadFiles(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (z) {
            try {
                deleteFile(downloadInfo.getSavePath(), downloadInfo.getName());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        deleteFile(downloadInfo.getTempPath(), downloadInfo.getTempName());
        if (downloadInfo.isSavePathRedirected()) {
            clearAntiHijackDir(downloadInfo);
        }
        if (z) {
            java.lang.String md5Hex = md5Hex(downloadInfo.getUrl());
            if (android.text.TextUtils.isEmpty(md5Hex) || android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) || !downloadInfo.getSavePath().contains(md5Hex)) {
                return;
            }
            deleteDirIfEmpty(downloadInfo.getSavePath());
        }
    }

    private static boolean deleteDirIfEmpty(java.lang.String str) {
        new java.lang.StringBuilder("deleteDirIfEmpty on thread: ").append(java.lang.Thread.currentThread());
        if (!android.text.TextUtils.isEmpty(str)) {
            java.io.File file = new java.io.File(str);
            return file.isDirectory() && file.delete();
        }
        return false;
    }

    public static void deleteFile(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.io.File file = new java.io.File(str, str2);
        if (file.exists()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("deleteFile: ");
            sb.append(str);
            sb.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            sb.append(str2);
            file.delete();
        }
    }

    @android.annotation.TargetApi(19)
    private static void doCopyFile(java.io.File file, java.io.File file2, boolean z) throws java.io.IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new java.io.IOException("Destination '" + file2 + "' exists but is a directory");
        }
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            java.nio.channels.FileChannel channel = fileInputStream.getChannel();
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    java.nio.channels.FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j = 0;
                        while (j < size) {
                            long j2 = size - j;
                            long transferFrom = channel2.transferFrom(channel, j, j2 > FILE_COPY_BUFFER_SIZE ? 31457280L : j2);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new java.io.IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private static void ensureDirExists(java.io.File file) {
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void ensureDirExists(java.lang.String str) {
        if (str == null) {
            return;
        }
        ensureDirExists(new java.io.File(str));
    }

    public static java.lang.String generateDistinctDirectory(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String md5Hex = md5Hex(str2);
        return (android.text.TextUtils.isEmpty(md5Hex) || str.contains(md5Hex)) ? str : new java.io.File(str, md5Hex).getAbsolutePath();
    }

    public static long getAvailableSpaceBytes(java.lang.String str) throws com.ss.android.socialbase.downloader.exception.BaseException {
        try {
            return new android.os.StatFs(str).getAvailableBytes();
        } catch (java.lang.IllegalArgumentException e) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, e);
        } catch (java.lang.Throwable th) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_GET_AVAILABLE_SPACE, th);
        }
    }

    public static boolean getBoolean(java.lang.Object obj, boolean z) {
        try {
            return ((java.lang.Boolean) obj).booleanValue();
        } catch (java.lang.ClassCastException unused) {
            return z;
        }
    }

    public static android.net.ConnectivityManager getConnectivityManager(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager2 = connectivityManager;
        if (connectivityManager2 != null) {
            return connectivityManager2;
        }
        android.net.ConnectivityManager connectivityManager3 = (android.net.ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager = connectivityManager3;
        return connectivityManager3;
    }

    public static long getContentLength(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        java.lang.String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Length");
        if (android.text.TextUtils.isEmpty(respHeadFieldIgnoreCase) && com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(1)) {
            return parseContentLengthFromContentRange(iDownloadHeadHttpConnection);
        }
        try {
            return java.lang.Long.parseLong(respHeadFieldIgnoreCase);
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }

    public static long getCurByte(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0L;
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        int chunkCount = downloadInfo.getChunkCount();
        boolean z = chunkCount > 1;
        if (!downloadInfo.isBreakpointAvailable()) {
            return 0L;
        }
        if (!z) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk == null || chunkCount != downloadChunk.size()) {
            return 0L;
        }
        return getTotalOffset(downloadChunk);
    }

    public static java.lang.String getCurProcessName(android.content.Context context) {
        java.lang.String str = sCurProcessName;
        if (!android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.lang.String curProcessNameByApplication = getCurProcessNameByApplication();
        sCurProcessName = curProcessNameByApplication;
        if (!android.text.TextUtils.isEmpty(curProcessNameByApplication)) {
            return sCurProcessName;
        }
        java.lang.String curProcessNameByActivityThread = getCurProcessNameByActivityThread();
        sCurProcessName = curProcessNameByActivityThread;
        if (!android.text.TextUtils.isEmpty(curProcessNameByActivityThread)) {
            return sCurProcessName;
        }
        java.lang.String curProcessNameByActivityManager = getCurProcessNameByActivityManager(context);
        sCurProcessName = curProcessNameByActivityManager;
        if (!android.text.TextUtils.isEmpty(curProcessNameByActivityManager)) {
            return sCurProcessName;
        }
        java.lang.String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
    }

    private static java.lang.String getCurProcessNameByActivityManager(android.content.Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = android.os.Process.myPid();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                            com.ss.android.socialbase.downloader.logger.Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static java.lang.String getCurProcessNameByActivityThread() {
        java.lang.String str;
        java.lang.Throwable th;
        java.lang.Object invoke;
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.app.ActivityThread", false, android.app.Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            invoke = declaredMethod.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Throwable th2) {
            str = null;
            th = th2;
        }
        if (!(invoke instanceof java.lang.String)) {
            return null;
        }
        str = (java.lang.String) invoke;
        try {
            if (!android.text.TextUtils.isEmpty(str) && com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d("Process", "processName = ".concat(java.lang.String.valueOf(str)));
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            th.printStackTrace();
            return str;
        }
        return str;
    }

    private static java.lang.String getCurProcessNameByApplication() {
        java.lang.String processName;
        if (android.os.Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = android.app.Application.getProcessName();
            if (!android.text.TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d("Process", "processName = ".concat(java.lang.String.valueOf(processName)));
            }
            return processName;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static java.lang.String getCurProcessNameFromProc() {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/" + android.os.Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (java.lang.Throwable unused) {
            bufferedReader = null;
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                com.ss.android.socialbase.downloader.logger.Logger.d("Process", "get processName = " + sb.toString());
            }
            java.lang.String sb2 = sb.toString();
            safeClose(bufferedReader);
            return sb2;
        } catch (java.lang.Throwable unused2) {
            safeClose(bufferedReader);
            return null;
        }
    }

    public static java.io.File getDatabaseFile(android.content.Context context, boolean z, java.lang.String str) {
        java.lang.String str2 = "";
        try {
            str2 = android.os.Environment.getExternalStorageState();
        } catch (java.lang.IncompatibleClassChangeError | java.lang.NullPointerException unused) {
        }
        java.io.File externalDBFile = (z && "mounted".equals(str2) && hasExternalStoragePermission(context)) ? getExternalDBFile(str) : null;
        if (externalDBFile == null) {
            externalDBFile = context.getDatabasePath(str);
        }
        if (externalDBFile != null) {
            return externalDBFile;
        }
        return new java.io.File("/data/data/" + context.getPackageName() + "/database/", str);
    }

    public static java.lang.String getDownloadPath() {
        return getValidDownloadPath(com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getGlobalSaveDir(), true);
    }

    public static java.lang.String getDownloadTempPath() {
        return getValidDownloadPath(com.ss.android.socialbase.downloader.downloader.Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()).getGlobalSaveTempDir(), false);
    }

    public static java.lang.String getEncodedStr(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(java.lang.String.format("\\u%04x", java.lang.Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static java.lang.String getErrorMsgWithTagPrefix(java.lang.Throwable th, java.lang.String str) {
        if (str == null) {
            return getThrowableMsg(th);
        }
        return str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + getThrowableMsg(th);
    }

    private static java.io.File getExternalDBFile(java.lang.String str) {
        java.io.File file = null;
        if (!isSdcardAvailable() || !isSdcardWritable()) {
            return null;
        }
        try {
            java.io.File externalFilesDir = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getExternalFilesDir("database" + java.io.File.separator + str);
            if (externalFilesDir == null) {
                return null;
            }
            try {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.createNewFile();
                }
                if (!com.ss.android.socialbase.downloader.logger.Logger.debug()) {
                    return externalFilesDir;
                }
                com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "download db path:" + externalFilesDir.getAbsolutePath());
                return externalFilesDir;
            } catch (java.lang.Exception e) {
                e = e;
                file = externalFilesDir;
                e.printStackTrace();
                return file;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    public static java.io.File getExternalDownloadPath() {
        java.lang.String str;
        try {
            str = android.os.Environment.getExternalStorageState();
        } catch (java.lang.Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static java.lang.String getFileNameFromConnection(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, java.lang.String str) {
        java.lang.String parseContentDisposition = parseContentDisposition(iDownloadHeadHttpConnection.getResponseHeaderField("Content-Disposition"));
        return android.text.TextUtils.isEmpty(parseContentDisposition) ? md5Hex(str) : parseContentDisposition;
    }

    private static long getFirstChunkCurOffset(java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j = -1;
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk : list) {
            if (downloadChunk != null && (downloadChunk.getCurrentOffset() <= downloadChunk.getEndOffset() || downloadChunk.getEndOffset() == 0)) {
                if (j == -1 || j > downloadChunk.getCurrentOffset()) {
                    j = downloadChunk.getCurrentOffset();
                }
            }
        }
        return j;
    }

    public static long getFirstOffset(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return -1L;
        }
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache().getDownloadChunk(downloadInfo.getId());
        if (downloadInfo.getChunkCount() == 1) {
            return downloadInfo.getCurBytes();
        }
        if (downloadChunk != null && downloadChunk.size() > 1) {
            long firstChunkCurOffset = getFirstChunkCurOffset(downloadChunk);
            if (firstChunkCurOffset >= 0) {
                return firstChunkCurOffset;
            }
        }
        return 0L;
    }

    public static java.lang.String getFixLengthString(java.lang.String str, int i) {
        return i == 0 ? "" : (android.text.TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(0, i);
    }

    public static int getInt(java.lang.Object obj, int i) {
        try {
            return ((java.lang.Integer) obj).intValue();
        } catch (java.lang.ClassCastException unused) {
            return i;
        }
    }

    public static java.lang.String getLoggerTag(java.lang.String str) {
        return com.ss.android.socialbase.downloader.logger.Logger.downloaderTag(str);
    }

    public static long getMaxBytesOverMobile() {
        return tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_LEFT;
    }

    public static java.lang.String getMd5StatusMsg(int i) {
        java.lang.String str = "ttmd5 check code = " + i + ", ";
        if (i == 99) {
            return str + "unknown error";
        }
        switch (i) {
            case 0:
                return str + "md5 match";
            case 1:
                return str + "md5 not match";
            case 2:
                return str + "md5 empty";
            case 3:
                return str + "ttmd5 version not support";
            case 4:
                return str + "ttmd5 tag parser error";
            case 5:
                return str + "file not exist";
            case 6:
                return str + "get file md5 error";
            default:
                return str;
        }
    }

    public static java.lang.String getRedirectSavePath(java.lang.String str, com.ss.android.socialbase.downloader.setting.DownloadSetting downloadSetting) {
        org.json.JSONObject optJSONObject;
        java.lang.String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        java.lang.String optString = optJSONObject.optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!android.text.TextUtils.isEmpty(optString) && optString.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            optString = optString.substring(1);
        }
        if (android.text.TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (optString.contains("%s")) {
            try {
                format = java.lang.String.format(optString, str);
            } catch (java.lang.Throwable unused) {
            }
        } else {
            format = optString + str;
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static java.lang.String getRespHeadFieldIgnoreCase(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection, java.lang.String str) {
        if (iDownloadHeadHttpConnection == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.lang.String responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str);
        if (!com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE, true)) {
            return responseHeaderField;
        }
        if (android.text.TextUtils.isEmpty(responseHeaderField)) {
            responseHeaderField = iDownloadHeadHttpConnection.getResponseHeaderField(str.toLowerCase());
        }
        return android.text.TextUtils.isEmpty(responseHeaderField) ? iDownloadHeadHttpConnection.getResponseHeaderField(str.toUpperCase()) : responseHeaderField;
    }

    public static java.lang.String getString(java.lang.Object obj, java.lang.String str) {
        try {
            return (java.lang.String) obj;
        } catch (java.lang.ClassCastException unused) {
            return str;
        }
    }

    public static java.lang.String getTargetFilePath(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        return java.lang.String.format("%s%s%s", str, java.io.File.separator, str2);
    }

    public static java.lang.String getTempFileName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return java.lang.String.format("%s.tp", str);
    }

    public static java.lang.String getTempFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if ((android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) || android.text.TextUtils.isEmpty(str3)) {
            return null;
        }
        java.lang.String targetFilePath = !android.text.TextUtils.isEmpty(str2) ? getTargetFilePath(str2, str3) : getTargetFilePath(str, str3);
        if (android.text.TextUtils.isEmpty(targetFilePath)) {
            return null;
        }
        return java.lang.String.format("%s.tp", targetFilePath);
    }

    public static java.lang.String getTempFileSavePath(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) && android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        return !android.text.TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static java.lang.String getThrowableMsg(java.lang.Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            return "throwable getMsg error";
        }
    }

    public static long getTotalOffset(java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().getDownloadChunkBytes();
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
    
        if (r1 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        r3 = r0.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (isValidDirectory(r3) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        return r3.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        if (r3 > 29) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static java.lang.String getValidDownloadPath(java.io.File file, boolean z) {
        boolean isExternalStorageLegacy;
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        if (isValidDirectory(file)) {
            return file.getAbsolutePath();
        }
        int i = appContext.getApplicationInfo().targetSdkVersion;
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            if (i == 29) {
                isExternalStorageLegacy = android.os.Environment.isExternalStorageLegacy();
            }
        }
        if (z) {
            java.io.File externalDownloadPath = getExternalDownloadPath();
            if (isValidDirectory(externalDownloadPath)) {
                return externalDownloadPath.getAbsolutePath();
            }
        }
        java.io.File externalFilesDir = appContext.getExternalFilesDir(android.os.Environment.DIRECTORY_DOWNLOADS);
        if (isValidDirectory(externalFilesDir)) {
            return externalFilesDir.getAbsolutePath();
        }
        return appContext.getFilesDir().getAbsolutePath();
    }

    private static void handleTempSaveCallback(int i, boolean z, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        synchronized (saveTempFileStatusMap) {
            java.util.List<com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback : list) {
                    if (iTempFileSaveCompleteCallback != null) {
                        if (z) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        } else {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                    }
                }
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "handleTempSaveCallback id:".concat(java.lang.String.valueOf(i)));
            saveTempFileStatusMap.remove(i);
        }
    }

    public static boolean hasDownloadCacheHeader(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.HttpHeader httpHeader : list) {
            if (httpHeader != null && !android.text.TextUtils.isEmpty(httpHeader.getName()) && !android.text.TextUtils.isEmpty(httpHeader.getValue()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getName()) && HEADER_TAG_DOWNLOAD_CACHE.equals(httpHeader.getValue())) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasExternalStoragePermission(android.content.Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static java.lang.String hexToString(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            try {
                bArr[i] = (byte) (java.lang.Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return new java.lang.String(bArr, "utf-8");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static boolean isChunkedTask(long j) {
        return j == -1;
    }

    public static boolean isChunkedTask(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode.isSwitchEnable(8) ? VALUE_CHUNKED.equals(iDownloadHeadHttpConnection.getResponseHeaderField("Transfer-Encoding")) || getContentLength(iDownloadHeadHttpConnection) == -1 : getContentLength(iDownloadHeadHttpConnection) == -1;
    }

    public static boolean isConnectionException(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        return !android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Exception in connect");
    }

    public static boolean isDownloadSuccessAndFileNotExist(int i, java.lang.String str, java.lang.String str2) {
        return i == -3 && !isFileExist(str, str2);
    }

    public static boolean isDownloaderProcess() {
        java.lang.Boolean bool = sIsDownloaderProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        java.lang.String curProcessName = getCurProcessName(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
        if (curProcessName != null) {
            if (curProcessName.equals(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName() + ":downloader")) {
                sIsDownloaderProcess = java.lang.Boolean.TRUE;
                return sIsDownloaderProcess.booleanValue();
            }
        }
        sIsDownloaderProcess = java.lang.Boolean.FALSE;
        return sIsDownloaderProcess.booleanValue();
    }

    public static boolean isFileDownloaded(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return isFileDownloaded(downloadInfo, downloadInfo.isForce(), downloadInfo.getMd5());
    }

    public static boolean isFileDownloaded(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, boolean z, java.lang.String str) {
        if (!z && !android.text.TextUtils.isEmpty(downloadInfo.getSavePath()) && !android.text.TextUtils.isEmpty(downloadInfo.getName())) {
            try {
                if (new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName()).exists()) {
                    if (checkMd5Valid(downloadInfo.getSavePath(), downloadInfo.getName(), str)) {
                        return true;
                    }
                }
            } catch (java.lang.OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileDownloaded(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z) {
        if (!z && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                if (new java.io.File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, str3)) {
                        return true;
                    }
                }
            } catch (java.lang.OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileDownloaded(java.lang.String str, java.lang.String str2, boolean z) {
        if (!z && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            try {
                if (new java.io.File(str, str2).exists()) {
                    if (checkMd5Valid(str, str2, null)) {
                        return true;
                    }
                }
            } catch (java.lang.OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isFileExist(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return false;
        }
        return new java.io.File(str, str2).exists();
    }

    public static boolean isForbiddenException(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.DownloadHttpException) || (((com.ss.android.socialbase.downloader.exception.DownloadHttpException) th).getHttpStatusCode() != 403 && (android.text.TextUtils.isEmpty(throwableMsg) || !throwableMsg.contains("403")))) {
            return !android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Forbidden");
        }
        return true;
    }

    public static boolean isHeaderEqual(java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list, java.util.List<com.ss.android.socialbase.downloader.model.HttpHeader> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new java.util.HashSet(list).equals(new java.util.HashSet(list2));
    }

    public static boolean isHttpDataDirtyError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        return baseException != null && baseException.getErrorCode() == 1051;
    }

    public static boolean isHttpsError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (baseException == null) {
            return false;
        }
        if (baseException.getErrorCode() != 1011) {
            return baseException.getCause() != null && (baseException.getCause() instanceof javax.net.ssl.SSLHandshakeException);
        }
        return true;
    }

    public static boolean isInsufficientSpaceError(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof com.ss.android.socialbase.downloader.exception.BaseException) {
            com.ss.android.socialbase.downloader.exception.BaseException baseException = (com.ss.android.socialbase.downloader.exception.BaseException) th;
            int errorCode = baseException.getErrorCode();
            if (errorCode == 1006) {
                return true;
            }
            if (errorCode == 1023 || errorCode == 1039 || errorCode == 1040 || errorCode == 1054 || errorCode == 1064) {
                java.lang.String message = baseException.getMessage();
                return !android.text.TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof java.io.IOException) {
            java.lang.String throwableMsg = getThrowableMsg(th);
            if (!android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMainProcess() {
        java.lang.Boolean bool = sIsMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        java.lang.String curProcessName = getCurProcessName(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf((curProcessName == null || !curProcessName.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) && curProcessName != null && curProcessName.equals(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext().getPackageName()));
        sIsMainProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isMainThread() {
        return android.os.Looper.getMainLooper() == android.os.Looper.myLooper();
    }

    public static boolean isMd5Valid(int i) {
        return i == 0 || i == 2;
    }

    public static boolean isNetNotAvailableException(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        return !android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("network not available");
    }

    public static boolean isNetworkConnected(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        try {
            android.net.ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 == null || (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isNetworkError(java.lang.Throwable th) {
        if (!(th instanceof com.ss.android.socialbase.downloader.exception.BaseException)) {
            return false;
        }
        int errorCode = ((com.ss.android.socialbase.downloader.exception.BaseException) th).getErrorCode();
        return errorCode == 1055 || errorCode == 1023 || errorCode == 1041 || errorCode == 1022 || errorCode == 1048 || errorCode == 1056 || errorCode == 1057 || errorCode == 1058 || errorCode == 1059 || errorCode == 1060 || errorCode == 1061 || errorCode == 1067 || errorCode == 1049 || errorCode == 1047 || errorCode == 1051 || errorCode == 1004 || errorCode == 1011 || errorCode == 1002 || errorCode == 1013;
    }

    public static boolean isNoWifiAndInNet() {
        android.content.Context appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext();
        return (appContext == null || isWifi(appContext) || !isNetworkConnected(appContext)) ? false : true;
    }

    public static boolean isProcessNameSame(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        java.lang.String curProcessName = getCurProcessName(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
        return curProcessName != null && curProcessName.equals(str);
    }

    public static boolean isResponseCode304Error(java.lang.Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getTTNetHandler().isResponseCode304Error(th);
    }

    public static boolean isResponseCode412Error(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        return !android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Precondition Failed");
    }

    public static boolean isResponseCode416Error(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        return !android.text.TextUtils.isEmpty(throwableMsg) && throwableMsg.contains("Requested Range Not Satisfiable");
    }

    public static boolean isResponseCodeError(com.ss.android.socialbase.downloader.exception.BaseException baseException) {
        if (!(baseException instanceof com.ss.android.socialbase.downloader.exception.DownloadHttpException)) {
            return false;
        }
        com.ss.android.socialbase.downloader.exception.DownloadHttpException downloadHttpException = (com.ss.android.socialbase.downloader.exception.DownloadHttpException) baseException;
        return downloadHttpException.getHttpStatusCode() == 412 || downloadHttpException.getHttpStatusCode() == 416;
    }

    public static boolean isResponseCodeError(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        return !android.text.TextUtils.isEmpty(throwableMsg) && (throwableMsg.contains("Requested Range Not Satisfiable") || throwableMsg.contains("Precondition Failed"));
    }

    public static boolean isResponseCodeValid(int i) {
        return i == 206 || i == 200;
    }

    public static boolean isResponseDataFromBegin(int i) {
        return i == 200 || i == 201 || i == 0;
    }

    public static boolean isSavePathSecurity(java.lang.String str) {
        android.content.Context appContext;
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.SAVE_PATH_SECURITY) > 0 && (appContext = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext()) != null && !android.text.TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + appContext.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSdcardAvailable() {
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    private static boolean isSdcardWritable() {
        try {
            return "mounted".equals(android.os.Environment.getExternalStorageState());
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isTimeOutException(java.lang.Throwable th) {
        if (th == null) {
            return false;
        }
        java.lang.String throwableMsg = getThrowableMsg(th);
        if (th instanceof java.net.SocketTimeoutException) {
            return true;
        }
        return !android.text.TextUtils.isEmpty(throwableMsg) && (throwableMsg.contains("time out") || throwableMsg.contains("Time-out"));
    }

    public static boolean isValidDirectory(java.io.File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean isWaitWifiAndInNet(com.ss.android.socialbase.downloader.exception.BaseException baseException, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.isOnlyWifi() && isNetworkConnected(com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getAppContext());
    }

    public static boolean isWifi(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        try {
            android.net.ConnectivityManager connectivityManager2 = getConnectivityManager(context);
            if (connectivityManager2 != null && (activeNetworkInfo = connectivityManager2.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static java.lang.String md5Hex(java.lang.String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return toHexString(messageDigest.digest());
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    public static boolean moveFile(java.io.File file, java.io.File file2) throws com.ss.android.socialbase.downloader.exception.BaseException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("moveFile1: src:");
        sb.append(file.getPath());
        sb.append(" dest:");
        sb.append(file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = copyFile(file, file2);
            try {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("moveFile2: src:");
                sb2.append(file.getPath());
                sb2.append(" dest:");
                sb2.append(file2.getPath());
                file.delete();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return renameTo;
    }

    public static boolean needNotifyDownloaderProcess() {
        return !isDownloaderProcess() && com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.isDownloadInMultiProcess() && com.ss.android.socialbase.downloader.impls.DownloadProxy.get(true).isServiceAlive();
    }

    private static java.lang.String parseContentDisposition(java.lang.String str) {
        java.util.regex.Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (CONTENT_DISPOSITION_QUOTED_PATTERN == null) {
                CONTENT_DISPOSITION_QUOTED_PATTERN = java.util.regex.Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
        } catch (java.lang.Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (CONTENT_DISPOSITION_NON_QUOTED_PATTERN == null) {
            CONTENT_DISPOSITION_NON_QUOTED_PATTERN = java.util.regex.Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        java.util.regex.Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long parseContentLengthFromContentRange(com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection iDownloadHeadHttpConnection) {
        if (iDownloadHeadHttpConnection == null) {
            return -1L;
        }
        java.lang.String respHeadFieldIgnoreCase = getRespHeadFieldIgnoreCase(iDownloadHeadHttpConnection, "Content-Range");
        if (android.text.TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            return -1L;
        }
        try {
            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(respHeadFieldIgnoreCase);
            if (matcher.find()) {
                return (java.lang.Long.parseLong(matcher.group(2)) - java.lang.Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (java.lang.Exception e) {
            com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "parse content-length from content-range failed ".concat(java.lang.String.valueOf(e)));
        }
        return -1L;
    }

    public static long parseContentRangeOfInstanceLength(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split.length >= 2) {
            try {
                return java.lang.Long.parseLong(split[1]);
            } catch (java.lang.NumberFormatException unused) {
                com.ss.android.socialbase.downloader.logger.Logger.w(TAG, "parse instance length failed with ".concat(str));
            }
        }
        return -1L;
    }

    public static void parseException(java.lang.Throwable th, java.lang.String str) throws com.ss.android.socialbase.downloader.exception.BaseException {
        java.lang.String str2 = !android.text.TextUtils.isEmpty(str) ? str : "";
        if (th instanceof com.ss.android.socialbase.downloader.exception.BaseException) {
            com.ss.android.socialbase.downloader.exception.BaseException baseException = (com.ss.android.socialbase.downloader.exception.BaseException) th;
            baseException.setErrorMsg(str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + baseException.getErrorMessage());
            throw baseException;
        }
        if (th instanceof javax.net.ssl.SSLHandshakeException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1011, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isTimeOutException(th)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TIME_OUT, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode412Error(th)) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1004, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_URL_CODE, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isResponseCode416Error(th)) {
            throw new com.ss.android.socialbase.downloader.exception.DownloadHttpException(1004, 416, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isForbiddenException(th)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_DOWNLOAD_FORBIDDEN, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isNetNotAvailableException(th)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_NOT_AVAILABLE, getErrorMsgWithTagPrefix(th, str2));
        }
        if (isConnectionException(th)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, getErrorMsgWithTagPrefix(th, str2));
        }
        if (!(th instanceof java.io.IOException)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1000, getErrorMsgWithTagPrefix(th, str2));
        }
        parseTTNetException(th, str);
        parseIOException((java.io.IOException) th, str);
    }

    public static java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> parseHostChunkList(java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        android.util.SparseArray sparseArray2 = new android.util.SparseArray();
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                if (downloadChunk.isHostChunk()) {
                    sparseArray.put(downloadChunk.getChunkIndex(), downloadChunk);
                    java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list2 = (java.util.List) sparseArray2.get(downloadChunk.getChunkIndex());
                    if (list2 != null) {
                        java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().setHostChunk(downloadChunk);
                        }
                        downloadChunk.setSubChunkList(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 = (com.ss.android.socialbase.downloader.model.DownloadChunk) sparseArray.get(downloadChunk.getHostChunkIndex());
                    if (downloadChunk2 != null) {
                        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> subChunkList = downloadChunk2.getSubChunkList();
                        if (subChunkList == null) {
                            subChunkList = new java.util.ArrayList<>();
                            downloadChunk2.setSubChunkList(subChunkList);
                        }
                        downloadChunk.setHostChunk(downloadChunk2);
                        subChunkList.add(downloadChunk);
                    } else {
                        java.util.List list3 = (java.util.List) sparseArray2.get(downloadChunk.getHostChunkIndex());
                        if (list3 == null) {
                            list3 = new java.util.ArrayList();
                            sparseArray2.put(downloadChunk.getHostChunkIndex(), list3);
                        }
                        list3.add(downloadChunk);
                    }
                }
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static void parseIOException(java.io.IOException iOException, java.lang.String str) throws com.ss.android.socialbase.downloader.exception.BaseException {
        if (str == null) {
            str = "";
        }
        java.lang.String errorMsgWithTagPrefix = getErrorMsgWithTagPrefix(iOException, str);
        if (iOException instanceof java.net.ConnectException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NETWORK_CONNECTION_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.UnknownHostException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_UNKNOWN_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.NoRouteToHostException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_NO_ROUTE_TO_HOST, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.UnknownServiceException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_UNKNOWN_SERVICE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.PortUnreachableException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_PORT_UNREACHABLE, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.SocketTimeoutException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TIME_OUT, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.SocketException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_SOCKET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.HttpRetryException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_HTTP_RETRY, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.ProtocolException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_PROTOCOL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.net.MalformedURLException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_MALFORMED_URL, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.io.FileNotFoundException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_FILE_NOT_FOUND, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.io.InterruptedIOException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_INTERRUPTED_IO, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.io.UnsupportedEncodingException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_UNSUPPORTED_ENCODING, errorMsgWithTagPrefix);
        }
        if (iOException instanceof java.io.EOFException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_EOF, errorMsgWithTagPrefix);
        }
        if (iOException instanceof okhttp3.internal.http2.StreamResetException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_STREAM_RESET, errorMsgWithTagPrefix);
        }
        if (iOException instanceof javax.net.ssl.SSLException) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1011, errorMsgWithTagPrefix);
        }
        if (!isInsufficientSpaceError(iOException)) {
            throw new com.ss.android.socialbase.downloader.exception.BaseException(1023, errorMsgWithTagPrefix);
        }
        throw new com.ss.android.socialbase.downloader.exception.BaseException(1006, errorMsgWithTagPrefix);
    }

    private static void parseTTNetException(java.lang.Throwable th, java.lang.String str) throws com.ss.android.socialbase.downloader.exception.DownloadTTNetException {
        com.ss.android.socialbase.downloader.exception.DownloadTTNetException translateTTNetException = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getTTNetHandler().translateTTNetException(th, null);
        if (translateTTNetException == null) {
            translateTTNetException = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getTTNetHandler().translateTTNetException(th.getCause(), null);
        }
        if (translateTTNetException == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.DownloadTTNetException(translateTTNetException.getErrorCode(), getErrorMsgWithTagPrefix(translateTTNetException, str)).setRequestLog(translateTTNetException.getRequestLog());
    }

    public static long parserMaxAge(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 0L;
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("max-age=([0-9]+)").matcher(str);
        if (!matcher.find()) {
            return 0L;
        }
        try {
            return java.lang.Long.parseLong(matcher.group(1));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static void safeClose(android.database.Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (android.database.Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void safeClose(java.io.Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (java.io.Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveFileAsTargetName(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend, com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback iTempFileSaveCompleteCallback) {
        boolean z;
        com.ss.android.socialbase.downloader.exception.BaseException baseException;
        boolean z2;
        java.lang.String str = TAG;
        com.ss.android.socialbase.downloader.logger.Logger.d(str, "saveFileAsTargetName targetName is " + downloadInfo.getTargetFilePath());
        try {
        } catch (java.lang.Throwable th) {
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "saveFileAsTargetName throwable " + th.getMessage());
            if (iTempFileSaveCompleteCallback == null) {
            }
        }
        synchronized (saveTempFileStatusMap) {
            java.lang.Boolean bool = saveTempFileStatusMap.get(downloadInfo.getId());
            java.lang.Boolean bool2 = java.lang.Boolean.TRUE;
            if (bool == bool2) {
                com.ss.android.socialbase.downloader.logger.Logger.d(str, "has another same task is saving temp file");
                if (iTempFileSaveCompleteCallback != null) {
                    java.util.List<com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback> list = saveTempFileListeners.get(downloadInfo.getId());
                    if (list == null) {
                        list = new java.util.ArrayList<>();
                        saveTempFileListeners.put(downloadInfo.getId(), list);
                    }
                    list.add(iTempFileSaveCompleteCallback);
                }
                return;
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(str, "saveTempFileStatusMap put id:" + downloadInfo.getId());
            saveTempFileStatusMap.put(downloadInfo.getId(), bool2);
            java.io.File file = new java.io.File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            java.io.File file2 = new java.io.File(downloadInfo.getSavePath(), downloadInfo.getName());
            boolean isSavePathSecurity = isSavePathSecurity(downloadInfo.getSavePath());
            if (file2.exists()) {
                com.ss.android.socialbase.downloader.logger.Logger.d(str, "targetFile exist");
                int checkMd5Status = checkMd5Status(file2, downloadInfo.getMd5());
                if (!isMd5Valid(checkMd5Status)) {
                    if (file.exists()) {
                        z = true;
                    } else {
                        com.ss.android.socialbase.downloader.exception.BaseException baseException2 = new com.ss.android.socialbase.downloader.exception.BaseException(1005, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName(), getMd5StatusMsg(checkMd5Status)));
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onFailed(baseException2);
                        }
                        handleTempSaveCallback(downloadInfo.getId(), false, baseException2);
                        z = false;
                    }
                    if (isSavePathSecurity && !file2.delete()) {
                        if (z) {
                            com.ss.android.socialbase.downloader.exception.BaseException baseException3 = new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TARGET_FILE_DELETE_FAILED, "delete targetPath file existed with md5 check invalid status:" + getMd5StatusMsg(checkMd5Status));
                            if (iTempFileSaveCompleteCallback != null) {
                                iTempFileSaveCompleteCallback.onFailed(baseException3);
                            }
                            handleTempSaveCallback(downloadInfo.getId(), false, baseException3);
                        } else if (iDownloadMonitorDepend != null) {
                            com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.monitorSendWithTaskMonitor(iDownloadMonitorDepend, downloadInfo, new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), downloadInfo.getStatus());
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        int optInt = com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.DOWNLOAD_FINISH_CHECK_TTMD5, 2);
                        if (optInt > 0) {
                            int checkMd5Status2 = checkMd5Status(file, downloadInfo.getMd5());
                            downloadInfo.setTTMd5CheckStatus(checkMd5Status2);
                            if (optInt >= 2 && !isMd5Valid(checkMd5Status2)) {
                                com.ss.android.socialbase.downloader.exception.BaseException baseException4 = new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_MD5_INVALID, getMd5StatusMsg(checkMd5Status2));
                                if (iTempFileSaveCompleteCallback != null) {
                                    iTempFileSaveCompleteCallback.onFailed(baseException4);
                                }
                                handleTempSaveCallback(downloadInfo.getId(), false, baseException4);
                                deleteAllDownloadFiles(downloadInfo, isSavePathSecurity);
                                return;
                            }
                        }
                        z2 = !moveFile(file, file2);
                        baseException = null;
                    } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtain(downloadInfo.getId()).optBugFix(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.BugFix.FIX_FILE_RENAME_FAILED)) {
                            baseException = e;
                            z2 = true;
                        } else {
                            baseException = e;
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onSuccess();
                        }
                        handleTempSaveCallback(downloadInfo.getId(), true, null);
                        return;
                    } else {
                        if (baseException == null) {
                            baseException = new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                        }
                        if (iTempFileSaveCompleteCallback != null) {
                            iTempFileSaveCompleteCallback.onFailed(baseException);
                        }
                        handleTempSaveCallback(downloadInfo.getId(), false, baseException);
                        return;
                    }
                }
                com.ss.android.socialbase.downloader.logger.Logger.d(str, "tempFile not exist , targetFile exists and md5 check valid");
                downloadInfo.setTTMd5CheckStatus(checkMd5Status);
                if (iTempFileSaveCompleteCallback != null) {
                    iTempFileSaveCompleteCallback.onSuccess();
                }
                handleTempSaveCallback(downloadInfo.getId(), true, null);
                z = false;
                if (z) {
                }
            } else if (file.exists()) {
                z = true;
                if (z) {
                }
            } else {
                com.ss.android.socialbase.downloader.exception.BaseException baseException5 = new com.ss.android.socialbase.downloader.exception.BaseException(1005, java.lang.String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", downloadInfo.getTempPath(), downloadInfo.getTempName(), downloadInfo.getSavePath(), downloadInfo.getName()));
                if (iTempFileSaveCompleteCallback != null) {
                    iTempFileSaveCompleteCallback.onFailed(baseException5);
                }
                handleTempSaveCallback(downloadInfo.getId(), false, baseException5);
                z = false;
                if (z) {
                }
            }
            com.ss.android.socialbase.downloader.logger.Logger.d(TAG, "saveFileAsTargetName throwable " + th.getMessage());
            if (iTempFileSaveCompleteCallback == null) {
                iTempFileSaveCompleteCallback.onFailed(new com.ss.android.socialbase.downloader.exception.BaseException(com.ss.android.socialbase.downloader.constants.DownloadErrorCode.ERROR_TEMP_TO_TARGET_FAILED, getErrorMsgWithTagPrefix(th, "saveFileAsTargetName")));
            }
        }
    }

    public static <K> void sparseArrayPutAll(android.util.SparseArray<K> sparseArray, java.util.Map<java.lang.Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (java.lang.Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static <K> java.util.HashMap<java.lang.Integer, K> sparseArrayToHashMap(android.util.SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        java.util.HashMap<java.lang.Integer, K> hashMap = new java.util.HashMap<>();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArray.keyAt(i);
            hashMap.put(java.lang.Integer.valueOf(keyAt), sparseArray.valueAt(i));
        }
        return hashMap;
    }

    public static java.lang.String toHexString(byte[] bArr) {
        if (bArr != null) {
            return toHexString(bArr, 0, bArr.length);
        }
        throw new java.lang.NullPointerException("bytes is null");
    }

    public static java.lang.String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new java.lang.NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & 255;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new java.lang.String(cArr, 0, i3);
    }
}

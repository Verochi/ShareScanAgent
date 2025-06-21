package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadUtils {
    public static int a = 65536;
    public static long b = 2000;
    public static java.lang.String c;
    public static java.lang.Boolean d;
    public static java.lang.Boolean e;
    public static final java.util.regex.Pattern f = java.util.regex.Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");
    public static final java.util.regex.Pattern g = java.util.regex.Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static java.lang.String a(java.lang.String str) {
        if (str != null && !str.isEmpty()) {
            try {
                java.lang.String path = new java.net.URL(str).getPath();
                java.lang.String substring = path.substring(path.lastIndexOf(47) + 1);
                if (substring.isEmpty()) {
                    return null;
                }
                return substring;
            } catch (java.net.MalformedURLException unused) {
            }
        }
        return null;
    }

    public static java.lang.String b(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        return fileDownloadConnection.getResponseHeaderField("Content-Range");
    }

    public static boolean c(android.content.Context context) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        android.os.PowerManager powerManager;
        android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (android.os.PowerManager) context.getSystemService("power")) == null || !powerManager.isInteractive()) {
            return false;
        }
        java.lang.String packageName = context.getApplicationContext().getPackageName();
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPermission(java.lang.String str) {
        return com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().checkCallingOrSelfPermission(str) == 0;
    }

    public static long convertContentLengthString(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.NumberFormatException unused) {
            return -1L;
        }
    }

    public static java.lang.String[] convertHeaderString(java.lang.String str) {
        java.lang.String[] split = str.split("\n");
        java.lang.String[] strArr = new java.lang.String[split.length * 2];
        for (int i = 0; i < split.length; i++) {
            java.lang.String[] split2 = split[i].split(": ");
            int i2 = i * 2;
            strArr[i2] = split2[0];
            strArr[i2 + 1] = split2[1];
        }
        return strArr;
    }

    public static com.liulishuo.filedownloader.stream.FileDownloadOutputStream createOutputStream(java.lang.String str) throws java.io.IOException {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.RuntimeException("found invalid internal destination path, empty");
        }
        if (!isFilenameValid(str)) {
            throw new java.lang.RuntimeException(formatString("found invalid internal destination filename %s", str));
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isDirectory()) {
            throw new java.lang.RuntimeException(formatString("found invalid internal destination path[%s], & path is directory[%B]", str, java.lang.Boolean.valueOf(file.isDirectory())));
        }
        if (file.exists() || file.createNewFile()) {
            return com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().createOutputStream(file);
        }
        throw new java.io.IOException(formatString("create new file error  %s", file.getAbsolutePath()));
    }

    public static java.lang.String defaultUserAgent() {
        return formatString("FileDownloader/%s", com.liulishuo.filedownloader.BuildConfig.VERSION_NAME);
    }

    public static void deleteTargetFile(java.lang.String str) {
        if (str != null) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void deleteTaskFiles(java.lang.String str, java.lang.String str2) {
        deleteTempFile(str2);
        deleteTargetFile(str);
    }

    public static void deleteTempFile(java.lang.String str) {
        if (str != null) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static long findContentLength(int i, com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        long convertContentLengthString = convertContentLengthString(fileDownloadConnection.getResponseHeaderField("Content-Length"));
        java.lang.String responseHeaderField = fileDownloadConnection.getResponseHeaderField("Transfer-Encoding");
        if (convertContentLengthString >= 0) {
            return convertContentLengthString;
        }
        if (!(responseHeaderField != null && responseHeaderField.equals(com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED))) {
            if (!com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().httpLenient) {
                throw new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", java.lang.Integer.valueOf(i));
            }
        }
        return -1L;
    }

    public static long findContentLengthFromContentRange(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        long parseContentLengthFromContentRange = parseContentLengthFromContentRange(b(fileDownloadConnection));
        if (parseContentLengthFromContentRange < 0) {
            return -1L;
        }
        return parseContentLengthFromContentRange;
    }

    public static java.lang.String findEtag(int i, com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        if (fileDownloadConnection == null) {
            throw new java.lang.RuntimeException("connection is null when findEtag");
        }
        java.lang.String responseHeaderField = fileDownloadConnection.getResponseHeaderField(com.ss.android.socialbase.downloader.utils.DownloadUtils.ETAG);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "etag find %s for task(%d)", responseHeaderField, java.lang.Integer.valueOf(i));
        }
        return responseHeaderField;
    }

    public static java.lang.String findFilename(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection, java.lang.String str) throws com.liulishuo.filedownloader.exception.FileDownloadSecurityException {
        java.lang.String parseContentDisposition = parseContentDisposition(fileDownloadConnection.getResponseHeaderField("Content-Disposition"));
        if (android.text.TextUtils.isEmpty(parseContentDisposition)) {
            parseContentDisposition = a(str);
        }
        if (android.text.TextUtils.isEmpty(parseContentDisposition)) {
            return generateFileName(str);
        }
        if (parseContentDisposition.contains("../")) {
            throw new com.liulishuo.filedownloader.exception.FileDownloadSecurityException(formatString("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", parseContentDisposition));
        }
        return parseContentDisposition;
    }

    public static long findInstanceLengthForTrial(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        long findInstanceLengthFromContentRange = findInstanceLengthFromContentRange(fileDownloadConnection);
        if (findInstanceLengthFromContentRange < 0) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "don't get instance length fromContent-Range header", new java.lang.Object[0]);
            findInstanceLengthFromContentRange = -1;
        }
        if (findInstanceLengthFromContentRange == 0 && com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().trialConnectionHeadMethod) {
            return -1L;
        }
        return findInstanceLengthFromContentRange;
    }

    public static long findInstanceLengthFromContentRange(com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        return parseContentRangeFoInstanceLength(b(fileDownloadConnection));
    }

    public static java.lang.String formatString(java.lang.String str, java.lang.Object... objArr) {
        return java.lang.String.format(java.util.Locale.ENGLISH, str, objArr);
    }

    public static java.lang.String generateFileName(java.lang.String str) {
        return md5(str);
    }

    public static java.lang.String generateFilePath(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            throw new java.lang.IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return formatString("%s%s%s", str, java.io.File.separator, str2);
        }
        throw new java.lang.IllegalStateException("can't generate real path, the directory is null");
    }

    public static int generateId(java.lang.String str, java.lang.String str2) {
        return com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getIdGeneratorInstance().generateId(str, str2, false);
    }

    public static int generateId(java.lang.String str, java.lang.String str2, boolean z) {
        return com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getIdGeneratorInstance().generateId(str, str2, z);
    }

    public static java.io.File getConvertedMarkedFile(android.content.Context context) {
        return new java.io.File(context.getFilesDir().getAbsolutePath() + java.io.File.separator + com.liulishuo.filedownloader.database.SqliteDatabaseImpl.TABLE_NAME, ".old_file_converted");
    }

    public static java.lang.String getDefaultSaveFilePath(java.lang.String str) {
        return generateFilePath(getDefaultSaveRootPath(), generateFileName(str));
    }

    public static java.lang.String getDefaultSaveRootPath() {
        if (android.text.TextUtils.isEmpty(c)) {
            return com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getExternalCacheDir() != null && android.os.Environment.getExternalStorageState().equals("mounted") && (android.os.Environment.getExternalStorageDirectory().getFreeSpace() > 0L ? 1 : (android.os.Environment.getExternalStorageDirectory().getFreeSpace() == 0L ? 0 : -1)) > 0 ? com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getExternalCacheDir().getAbsolutePath() : com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getCacheDir().getAbsolutePath();
        }
        return c;
    }

    public static long getFreeSpaceBytes(java.lang.String str) {
        return new android.os.StatFs(str).getAvailableBytes();
    }

    public static int getMinProgressStep() {
        return a;
    }

    public static long getMinProgressTime() {
        return b;
    }

    public static java.lang.String getParent(java.lang.String str) {
        int length = str.length();
        int i = (java.io.File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(java.io.File.separatorChar);
        int i2 = (lastIndexOf != -1 || i <= 0) ? lastIndexOf : 2;
        if (i2 == -1) {
            return null;
        }
        char charAt = str.charAt(length - 1);
        char c2 = java.io.File.separatorChar;
        if (charAt == c2) {
            return null;
        }
        return (str.indexOf(c2) == i2 && str.charAt(i) == java.io.File.separatorChar) ? str.substring(0, i2 + 1) : str.substring(0, i2);
    }

    public static java.lang.String getStack() {
        return getStack(true);
    }

    public static java.lang.String getStack(boolean z) {
        return getStack(new java.lang.Throwable().getStackTrace(), z);
    }

    public static java.lang.String getStack(java.lang.StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length < 4) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            if (stackTraceElementArr[i].getClassName().contains(com.liulishuo.filedownloader.BuildConfig.APPLICATION_ID)) {
                sb.append("[");
                sb.append(stackTraceElementArr[i].getClassName().substring(28));
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                sb.append(stackTraceElementArr[i].getMethodName());
                if (z) {
                    sb.append("(");
                    sb.append(stackTraceElementArr[i].getLineNumber());
                    sb.append(")]");
                } else {
                    sb.append("]");
                }
            }
        }
        return sb.toString();
    }

    public static java.lang.String getTargetFilePath(java.lang.String str, boolean z, java.lang.String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return generateFilePath(str, str2);
    }

    public static java.lang.String getTempPath(java.lang.String str) {
        return formatString("%s.temp", str);
    }

    public static java.lang.String getThreadPoolName(java.lang.String str) {
        return "FileDownloader-" + str;
    }

    public static boolean isAcceptRange(int i, com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) {
        if (i == 206 || i == 1) {
            return true;
        }
        return "bytes".equals(fileDownloadConnection.getResponseHeaderField("Accept-Ranges"));
    }

    public static boolean isBreakpointAvailable(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        return isBreakpointAvailable(i, fileDownloadModel, null);
    }

    public static boolean isBreakpointAvailable(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, java.lang.Boolean bool) {
        if (fileDownloadModel == null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d model == null", java.lang.Integer.valueOf(i));
            }
            return false;
        }
        if (fileDownloadModel.getTempFilePath() != null) {
            return isBreakpointAvailable(i, fileDownloadModel, fileDownloadModel.getTempFilePath(), bool);
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d temp path == null", java.lang.Integer.valueOf(i));
        }
        return false;
    }

    public static boolean isBreakpointAvailable(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, java.lang.String str, java.lang.Boolean bool) {
        if (str != null) {
            java.io.File file = new java.io.File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long soFar = fileDownloadModel.getSoFar();
                if (fileDownloadModel.getConnectionCount() > 1 || soFar != 0) {
                    long total = fileDownloadModel.getTotal();
                    if (length < soFar || (total != -1 && (length > total || soFar >= total))) {
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(length), java.lang.Long.valueOf(soFar), java.lang.Long.valueOf(total));
                        }
                    } else {
                        if (bool == null || bool.booleanValue() || total != length) {
                            return true;
                        }
                        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", java.lang.Integer.valueOf(i));
                        }
                    }
                } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d the downloaded-record is zero.", java.lang.Integer.valueOf(i));
                }
            } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d file not suit, exists[%B], directory[%B]", java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(exists), java.lang.Boolean.valueOf(isDirectory));
            }
        } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "can't continue %d path = null", java.lang.Integer.valueOf(i));
        }
        return false;
    }

    public static boolean isDownloaderProcess(android.content.Context context) {
        boolean z;
        java.lang.Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().processNonSeparate) {
            int myPid = android.os.Process.myPid();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        android.app.ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            z = next.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new java.lang.Object[0]);
                    return false;
                }
            } else {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "fail to get the activity manager!", new java.lang.Object[0]);
                return false;
            }
        } else {
            z = true;
        }
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf(z);
        d = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isFilenameConverted(android.content.Context context) {
        if (e == null) {
            e = java.lang.Boolean.valueOf(getConvertedMarkedFile(context).exists());
        }
        return e.booleanValue();
    }

    public static boolean isFilenameValid(java.lang.String str) {
        return true;
    }

    public static boolean isNeedSync(long j, long j2) {
        return j > ((long) getMinProgressStep()) && j2 > getMinProgressTime();
    }

    public static boolean isNetworkNotOnWifiType() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "failed to get connectivity manager!", new java.lang.Object[0]);
            return true;
        }
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static void markConverted(android.content.Context context) {
        java.io.File convertedMarkedFile = getConvertedMarkedFile(context);
        try {
            convertedMarkedFile.getParentFile().mkdirs();
            convertedMarkedFile.createNewFile();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
    }

    public static java.lang.String md5(java.lang.String str) {
        try {
            byte[] digest = java.security.MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            java.lang.StringBuilder sb = new java.lang.StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(java.lang.Integer.toHexString(i));
            }
            return sb.toString();
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new java.lang.RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (java.security.NoSuchAlgorithmException e3) {
            throw new java.lang.RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public static boolean needMakeServiceForeground(android.content.Context context) {
        return android.os.Build.VERSION.SDK_INT >= 26 && !c(context);
    }

    public static java.lang.String parseContentDisposition(java.lang.String str) {
        java.util.regex.Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            matcher = f.matcher(str);
        } catch (java.io.UnsupportedEncodingException | java.lang.IllegalStateException unused) {
        }
        if (matcher.find()) {
            return java.net.URLDecoder.decode(matcher.group(2), matcher.group(1));
        }
        java.util.regex.Matcher matcher2 = g.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long parseContentLengthFromContentRange(java.lang.String str) {
        if (str != null && str.length() != 0) {
            try {
                java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (java.lang.Long.parseLong(matcher.group(2)) - java.lang.Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (java.lang.Exception e2) {
                com.liulishuo.filedownloader.util.FileDownloadLog.e(com.liulishuo.filedownloader.util.FileDownloadUtils.class, e2, "parse content length from content range error", new java.lang.Object[0]);
            }
        }
        return -1L;
    }

    public static long parseContentRangeFoInstanceLength(java.lang.String str) {
        if (str == null) {
            return -1L;
        }
        java.lang.String[] split = str.split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split.length >= 2) {
            try {
                return java.lang.Long.parseLong(split[1]);
            } catch (java.lang.NumberFormatException unused) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.FileDownloadUtils.class, "parse instance length failed with %s", str);
            }
        }
        return -1L;
    }

    public static void setDefaultSaveRootPath(java.lang.String str) {
        c = str;
    }

    public static void setMinProgressStep(int i) throws java.lang.IllegalAccessException {
        if (!isDownloaderProcess(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext())) {
            throw new java.lang.IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        a = i;
    }

    public static void setMinProgressTime(long j) throws java.lang.IllegalAccessException {
        if (!isDownloaderProcess(com.liulishuo.filedownloader.util.FileDownloadHelper.getAppContext())) {
            throw new java.lang.IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        b = j;
    }
}

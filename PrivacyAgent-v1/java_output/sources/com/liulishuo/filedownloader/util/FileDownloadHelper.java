package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class FileDownloadHelper {

    @android.annotation.SuppressLint({"StaticFieldLeak"})
    public static android.content.Context a;

    public interface ConnectionCountAdapter {
        int determineConnectionCount(int i, java.lang.String str, java.lang.String str2, long j);
    }

    public interface ConnectionCreator {
        com.liulishuo.filedownloader.connection.FileDownloadConnection create(java.lang.String str) throws java.io.IOException;
    }

    public interface DatabaseCustomMaker {
        com.liulishuo.filedownloader.database.FileDownloadDatabase customMake();
    }

    public interface IdGenerator {
        int generateId(java.lang.String str, java.lang.String str2, boolean z);

        int transOldId(int i, java.lang.String str, java.lang.String str2, boolean z);
    }

    public interface OutputStreamCreator {
        com.liulishuo.filedownloader.stream.FileDownloadOutputStream create(java.io.File file) throws java.io.IOException;

        boolean supportSeek();
    }

    public static android.content.Context getAppContext() {
        return a;
    }

    public static void holdContext(android.content.Context context) {
        a = context;
    }

    public static boolean inspectAndInflowConflictPath(int i, long j, java.lang.String str, java.lang.String str2, com.liulishuo.filedownloader.IThreadPoolMonitor iThreadPoolMonitor) {
        int findRunningTaskIdBySameTempPath;
        if (str2 == null || str == null || (findRunningTaskIdBySameTempPath = iThreadPoolMonitor.findRunningTaskIdBySameTempPath(str, i)) == 0) {
            return false;
        }
        com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().inflow(com.liulishuo.filedownloader.message.MessageSnapshotTaker.catchException(i, j, new com.liulishuo.filedownloader.exception.PathConflictException(findRunningTaskIdBySameTempPath, str, str2)));
        return true;
    }

    public static boolean inspectAndInflowDownloaded(int i, java.lang.String str, boolean z, boolean z2) {
        if (!z && str != null) {
            java.io.File file = new java.io.File(str);
            if (file.exists()) {
                com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().inflow(com.liulishuo.filedownloader.message.MessageSnapshotTaker.catchCanReusedOldFile(i, file, z2));
                return true;
            }
        }
        return false;
    }

    public static boolean inspectAndInflowDownloading(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, com.liulishuo.filedownloader.IThreadPoolMonitor iThreadPoolMonitor, boolean z) {
        if (!iThreadPoolMonitor.isDownloading(fileDownloadModel)) {
            return false;
        }
        com.liulishuo.filedownloader.message.MessageSnapshotFlow.getImpl().inflow(com.liulishuo.filedownloader.message.MessageSnapshotTaker.catchWarn(i, fileDownloadModel.getSoFar(), fileDownloadModel.getTotal(), z));
        return true;
    }
}

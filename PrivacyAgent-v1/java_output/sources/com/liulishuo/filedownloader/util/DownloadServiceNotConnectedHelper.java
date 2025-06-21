package com.liulishuo.filedownloader.util;

/* loaded from: classes23.dex */
public class DownloadServiceNotConnectedHelper {
    public static void a(java.lang.String str, java.lang.Object... objArr) {
        com.liulishuo.filedownloader.util.FileDownloadLog.w(com.liulishuo.filedownloader.util.DownloadServiceNotConnectedHelper.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your code invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    public static boolean clearAllTaskData() {
        a("request clear all tasks data in the database", new java.lang.Object[0]);
        return false;
    }

    public static boolean clearTaskData(int i) {
        a("request clear the task[%d] data in the database", java.lang.Integer.valueOf(i));
        return false;
    }

    public static long getSofar(int i) {
        a("request get the downloaded so far byte for the task[%d] in the download service", java.lang.Integer.valueOf(i));
        return 0L;
    }

    public static byte getStatus(int i) {
        a("request get the status for the task[%d] in the download service", java.lang.Integer.valueOf(i));
        return (byte) 0;
    }

    public static long getTotal(int i) {
        a("request get the total byte for the task[%d] in the download service", java.lang.Integer.valueOf(i));
        return 0L;
    }

    public static boolean isDownloading(java.lang.String str, java.lang.String str2) {
        a("request check the task([%s], [%s]) is downloading in the download service", str, str2);
        return false;
    }

    public static boolean isIdle() {
        a("request check the download service is idle", new java.lang.Object[0]);
        return true;
    }

    public static boolean pause(int i) {
        a("request pause the task[%d] in the download service", java.lang.Integer.valueOf(i));
        return false;
    }

    public static void pauseAllTasks() {
        a("request pause all tasks in the download service", new java.lang.Object[0]);
    }

    public static boolean setMaxNetworkThreadCount(int i) {
        a("request set the max network thread count[%d] in the download service", java.lang.Integer.valueOf(i));
        return false;
    }

    public static boolean start(java.lang.String str, java.lang.String str2, boolean z) {
        a("request start the task([%s], [%s], [%B]) in the download service", str, str2, java.lang.Boolean.valueOf(z));
        return false;
    }

    public static void startForeground(int i, android.app.Notification notification) {
        a("request set the download service as the foreground service([%d],[%s]),", java.lang.Integer.valueOf(i), notification);
    }

    public static void stopForeground(boolean z) {
        a("request cancel the foreground status[%B] for the download service", java.lang.Boolean.valueOf(z));
    }
}

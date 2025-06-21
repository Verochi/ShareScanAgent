package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadEventPool extends com.liulishuo.filedownloader.event.DownloadEventPoolImpl {

    public static class HolderClass {
        public static final com.liulishuo.filedownloader.FileDownloadEventPool a = new com.liulishuo.filedownloader.FileDownloadEventPool(null);
    }

    public FileDownloadEventPool() {
    }

    public /* synthetic */ FileDownloadEventPool(com.liulishuo.filedownloader.FileDownloadEventPool.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.liulishuo.filedownloader.FileDownloadEventPool getImpl() {
        return com.liulishuo.filedownloader.FileDownloadEventPool.HolderClass.a;
    }
}

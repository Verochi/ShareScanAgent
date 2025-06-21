package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class IPCUtils {
    private static android.os.Handler mMainThreadHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.ss.android.socialbase.downloader.model.DownloadAidlTask.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadTask val$downloadTask;

        public AnonymousClass1(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
            this.val$downloadTask = downloadTask;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator getChunkStrategy() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertCntCalculatorToAidl(this.val$downloadTask.getChunkStrategy());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend getDepend() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDependToAidl(this.val$downloadTask.getDepend());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDiskSpaceHandlerToAidl(this.val$downloadTask.getDiskSpaceHandler());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadCompleteHandlerToAidl(this.val$downloadTask.getDownloadCompleteHandlerByIndex(i));
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws android.os.RemoteException {
            return this.val$downloadTask.getDownloadCompleteHandlers().size();
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo() throws android.os.RemoteException {
            return this.val$downloadTask.getDownloadInfo();
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerToAidl(this.val$downloadTask.getDownloadListenerByIndex(com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i), i2), i != com.ss.android.socialbase.downloader.constants.ListenerType.SUB.ordinal());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadListenerSize(int i) throws android.os.RemoteException {
            return this.val$downloadTask.getDownloadListenerSize(com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i));
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertDownloadNotificationEventListenerToAidl(this.val$downloadTask.getNotificationEventListener());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider getFileProvider() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertFileProviderToAidl(this.val$downloadTask.getFileUriProvider());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler getForbiddenHandler() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertForbiddenHandlerToAidl(this.val$downloadTask.getForbiddenHandler());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor getInterceptor() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertInterceptorToAidl(this.val$downloadTask.getInterceptor());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend getMonitorDepend() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertMonitorDependToAidl(this.val$downloadTask.getMonitorDepend());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback getNotificationClickCallback() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertNotificationClickCallbackToAidl(this.val$downloadTask.getNotificationClickCallback());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertRetryDelayTimeCalculatorToAidl(this.val$downloadTask.getRetryDelayTimeCalculator());
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public com.ss.android.socialbase.downloader.depend.IDownloadAidlListener getSingleDownloadListener(int i) throws android.os.RemoteException {
            return com.ss.android.socialbase.downloader.utils.IPCUtils.convertListenerToAidl(this.val$downloadTask.getSingleDownloadListener(com.ss.android.socialbase.downloader.utils.DownloadUtils.convertListenerType(i)), i != com.ss.android.socialbase.downloader.constants.ListenerType.SUB.ordinal());
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$10, reason: invalid class name */
    public static class AnonymousClass10 implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback val$diskSpaceAidlCallback;

        public AnonymousClass10(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) {
            this.val$diskSpaceAidlCallback = iDownloadDiskSpaceAidlCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback
        public void onDiskCleaned() {
            try {
                this.val$diskSpaceAidlCallback.onDiskCleaned();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$11, reason: invalid class name */
    public static class AnonymousClass11 extends com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadDepend val$depend;

        public AnonymousClass11(com.ss.android.socialbase.downloader.depend.IDownloadDepend iDownloadDepend) {
            this.val$depend = iDownloadDepend;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend
        public void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) throws android.os.RemoteException {
            this.val$depend.monitorLogSend(downloadInfo, baseException, i);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$12, reason: invalid class name */
    public static class AnonymousClass12 extends com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend val$depend;

        public AnonymousClass12(com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend) {
            this.val$depend = iDownloadMonitorDepend;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public int[] getAdditionalMonitorStatus() throws android.os.RemoteException {
            com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend = this.val$depend;
            if (iDownloadMonitorDepend instanceof com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend) {
                return ((com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend) iDownloadMonitorDepend).getAdditionalMonitorStatus();
            }
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public java.lang.String getEventPage() throws android.os.RemoteException {
            return this.val$depend.getEventPage();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend
        public void monitorLogSend(java.lang.String str) throws android.os.RemoteException {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            try {
                this.val$depend.monitorLogSend(new org.json.JSONObject(str));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$13, reason: invalid class name */
    public static class AnonymousClass13 extends com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator val$cntCalculator;

        public AnonymousClass13(com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator) {
            this.val$cntCalculator = iChunkCntCalculator;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
        public int calculateChunkCount(long j) throws android.os.RemoteException {
            return this.val$cntCalculator.calculateChunkCount(j);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$14, reason: invalid class name */
    public static class AnonymousClass14 extends com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadInterceptor val$interceptor;

        public AnonymousClass14(com.ss.android.socialbase.downloader.depend.IDownloadInterceptor iDownloadInterceptor) {
            this.val$interceptor = iDownloadInterceptor;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor
        public boolean intercept() throws android.os.RemoteException {
            return this.val$interceptor.intercepte();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$15, reason: invalid class name */
    public static class AnonymousClass15 implements com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener val$aidlNotificationEventListener;

        public AnonymousClass15(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) {
            this.val$aidlNotificationEventListener = iDownloadNotificationEventAidlListener;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public java.lang.String getNotifyProcessName() {
            try {
                return this.val$aidlNotificationEventListener.getNotifyProcessName();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public boolean interceptAfterNotificationSuccess(boolean z) {
            try {
                return this.val$aidlNotificationEventListener.interceptAfterNotificationSuccess(z);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
        public void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) {
            try {
                this.val$aidlNotificationEventListener.onNotificationEvent(i, downloadInfo, str, str2);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$16, reason: invalid class name */
    public static class AnonymousClass16 implements com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler val$aidlHandler;

        public AnonymousClass16(com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler iDownloadCompleteAidlHandler) {
            this.val$aidlHandler = iDownloadCompleteAidlHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws com.ss.android.socialbase.downloader.exception.BaseException {
            try {
                this.val$aidlHandler.handle(downloadInfo);
            } catch (android.os.RemoteException e) {
                throw new com.ss.android.socialbase.downloader.exception.BaseException(1008, e);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
        public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                return this.val$aidlHandler.needHandle(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$17, reason: invalid class name */
    public static class AnonymousClass17 extends com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler val$handler;

        public AnonymousClass17(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
            this.val$handler = iDownloadCompleteHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public void handle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            try {
                this.val$handler.handle(downloadInfo);
            } catch (com.ss.android.socialbase.downloader.exception.BaseException e) {
                throw new java.lang.IllegalArgumentException(e);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler
        public boolean needHandle(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return this.val$handler.needHandle(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$18, reason: invalid class name */
    public static class AnonymousClass18 implements com.ss.android.socialbase.downloader.depend.INotificationClickCallback {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback val$notificationClickAidlCallback;

        public AnonymousClass18(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback iNotificationClickAidlCallback) {
            this.val$notificationClickAidlCallback = iNotificationClickAidlCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                return this.val$notificationClickAidlCallback.onClickWhenInstalled(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                return this.val$notificationClickAidlCallback.onClickWhenSuccess(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
        public boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                return this.val$notificationClickAidlCallback.onClickWhenUnSuccess(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$19, reason: invalid class name */
    public static class AnonymousClass19 implements com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator val$aidlCntCalculator;

        public AnonymousClass19(com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator iChunkCntAidlCalculator) {
            this.val$aidlCntCalculator = iChunkCntAidlCalculator;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator
        public int calculateChunkCount(long j) {
            try {
                return this.val$aidlCntCalculator.calculateChunkCount(j);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.ss.android.socialbase.downloader.depend.IDownloadAidlListener.Stub {
        final /* synthetic */ boolean val$isInMainThread;
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadListener val$listener;

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass1(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onPrepare(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$10, reason: invalid class name */
        public class AnonymousClass10 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.exception.BaseException val$e;
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass10(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
                this.val$entity = downloadInfo;
                this.val$e = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onRetry(this.val$entity, this.val$e);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$11, reason: invalid class name */
        public class AnonymousClass11 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.exception.BaseException val$e;
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass11(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
                this.val$entity = downloadInfo;
                this.val$e = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onRetryDelay(this.val$entity, this.val$e);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$12, reason: invalid class name */
        public class AnonymousClass12 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass12(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((com.ss.android.socialbase.downloader.depend.IDownloadExtListener) com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener).onWaitingDownloadCompleteHandler(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$2, reason: invalid class name and collision with other inner class name */
        public class RunnableC04882 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public RunnableC04882(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onStart(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass3(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onProgress(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass4(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onPause(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass5(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onSuccessed(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.exception.BaseException val$e;
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass6(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
                this.val$entity = downloadInfo;
                this.val$e = baseException;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onFailed(this.val$entity, this.val$e);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass7(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onCanceled(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$8, reason: invalid class name */
        public class AnonymousClass8 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass8(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onFirstStart(this.val$entity);
            }
        }

        /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$2$9, reason: invalid class name */
        public class AnonymousClass9 implements java.lang.Runnable {
            final /* synthetic */ com.ss.android.socialbase.downloader.model.DownloadInfo val$entity;

            public AnonymousClass9(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
                this.val$entity = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.this.val$listener.onFirstSuccess(this.val$entity);
            }
        }

        public AnonymousClass2(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, boolean z) {
            this.val$listener = iDownloadListener;
            this.val$isInMainThread = z;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public int getOriginHashCode() throws android.os.RemoteException {
            return this.val$listener.hashCode();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass7(downloadInfo));
            } else {
                this.val$listener.onCanceled(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass6(downloadInfo, baseException));
            } else {
                this.val$listener.onFailed(downloadInfo, baseException);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass8(downloadInfo));
            } else {
                this.val$listener.onFirstStart(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass9(downloadInfo));
            } else {
                this.val$listener.onFirstSuccess(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass4(downloadInfo));
            } else {
                this.val$listener.onPause(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass1(downloadInfo));
            } else {
                this.val$listener.onPrepare(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass3(downloadInfo));
            } else {
                this.val$listener.onProgress(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass10(downloadInfo, baseException));
            } else {
                this.val$listener.onRetry(downloadInfo, baseException);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass11(downloadInfo, baseException));
            } else {
                this.val$listener.onRetryDelay(downloadInfo, baseException);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.RunnableC04882(downloadInfo));
            } else {
                this.val$listener.onStart(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            if (this.val$isInMainThread) {
                com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass5(downloadInfo));
            } else {
                this.val$listener.onSuccessed(downloadInfo);
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlListener
        public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener = this.val$listener;
            if (iDownloadListener instanceof com.ss.android.socialbase.downloader.depend.IDownloadExtListener) {
                if (this.val$isInMainThread) {
                    com.ss.android.socialbase.downloader.utils.IPCUtils.mMainThreadHandler.post(new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2.AnonymousClass12(downloadInfo));
                } else {
                    ((com.ss.android.socialbase.downloader.depend.IDownloadExtListener) iDownloadListener).onWaitingDownloadCompleteHandler(downloadInfo);
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$20, reason: invalid class name */
    public static class AnonymousClass20 implements com.ss.android.socialbase.downloader.depend.IDownloadDepend {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend val$aidlDepend;

        public AnonymousClass20(com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend iDownloadAidlDepend) {
            this.val$aidlDepend = iDownloadAidlDepend;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
        public void monitorLogSend(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException, int i) {
            if (downloadInfo == null) {
                return;
            }
            try {
                this.val$aidlDepend.monitorLogSend(downloadInfo, baseException, i);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$21, reason: invalid class name */
    public static class AnonymousClass21 extends com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend val$aidlMonitorDepend;

        public AnonymousClass21(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend iDownloadAidlMonitorDepend) {
            this.val$aidlMonitorDepend = iDownloadAidlMonitorDepend;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend
        public int[] getAdditionalMonitorStatus() {
            try {
                return this.val$aidlMonitorDepend.getAdditionalMonitorStatus();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public java.lang.String getEventPage() {
            try {
                return this.val$aidlMonitorDepend.getEventPage();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return "";
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend
        public void monitorLogSend(org.json.JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            try {
                this.val$aidlMonitorDepend.monitorLogSend(jSONObject.toString());
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$22, reason: invalid class name */
    public static class AnonymousClass22 implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler val$forbiddenAidlHandler;

        public AnonymousClass22(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler iDownloadForbiddenAidlHandler) {
            this.val$forbiddenAidlHandler = iDownloadForbiddenAidlHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler
        public boolean onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback iDownloadForbiddenCallback) {
            try {
                return this.val$forbiddenAidlHandler.onForbidden(com.ss.android.socialbase.downloader.utils.IPCUtils.convertForbiddenCallbackToAidl(iDownloadForbiddenCallback));
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$23, reason: invalid class name */
    public static class AnonymousClass23 extends com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback val$forbiddenCallback;

        public AnonymousClass23(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback iDownloadForbiddenCallback) {
            this.val$forbiddenCallback = iDownloadForbiddenCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public boolean hasCallback() {
            return this.val$forbiddenCallback.hasCallback();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback
        public void onCallback(java.util.List<java.lang.String> list) {
            this.val$forbiddenCallback.onCallback(list);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$24, reason: invalid class name */
    public static class AnonymousClass24 extends com.ss.android.socialbase.downloader.depend.ProcessAidlCallback.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.ProcessCallback val$callback;

        public AnonymousClass24(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback) {
            this.val$callback = processCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessAidlCallback
        public void callback(int i, int i2) {
            this.val$callback.callback(i, i2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$25, reason: invalid class name */
    public static class AnonymousClass25 implements com.ss.android.socialbase.downloader.depend.ProcessCallback {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.ProcessAidlCallback val$aidlCallback;

        public AnonymousClass25(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) {
            this.val$aidlCallback = processAidlCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.ProcessCallback
        public void callback(int i, int i2) {
            try {
                this.val$aidlCallback.callback(i, i2);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$26, reason: invalid class name */
    public static class AnonymousClass26 implements com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler val$diskSpaceAidlHandler;

        public AnonymousClass26(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler iDownloadDiskSpaceAidlHandler) {
            this.val$diskSpaceAidlHandler = iDownloadDiskSpaceAidlHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
        public boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
            try {
                return this.val$diskSpaceAidlHandler.cleanUpDisk(j, j2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertDiskSpaceCallbackToAidl(iDownloadDiskSpaceCallback));
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$27, reason: invalid class name */
    public static class AnonymousClass27 extends com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback val$diskSpaceCallback;

        public AnonymousClass27(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
            this.val$diskSpaceCallback = iDownloadDiskSpaceCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback
        public void onDiskCleaned() throws android.os.RemoteException {
            this.val$diskSpaceCallback.onDiskCleaned();
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$28, reason: invalid class name */
    public static class AnonymousClass28 implements com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator val$retryDelayTimeAidlCalculator;

        public AnonymousClass28(com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator iRetryDelayTimeAidlCalculator) {
            this.val$retryDelayTimeAidlCalculator = iRetryDelayTimeAidlCalculator;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
        public long calculateRetryDelayTime(int i, int i2) {
            try {
                return this.val$retryDelayTimeAidlCalculator.calculateRetryDelayTime(i, i2);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return 0L;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$29, reason: invalid class name */
    public static class AnonymousClass29 implements com.ss.android.socialbase.downloader.depend.IDownloadInterceptor {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor val$aidlInterceptor;

        public AnonymousClass29(com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor iDownloadAidlInterceptor) {
            this.val$aidlInterceptor = iDownloadAidlInterceptor;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
        public boolean intercepte() {
            try {
                return this.val$aidlInterceptor.intercept();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$3, reason: invalid class name */
    public static class AnonymousClass3 extends com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener val$notificationEventListener;

        public AnonymousClass3(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
            this.val$notificationEventListener = iDownloadNotificationEventListener;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public java.lang.String getNotifyProcessName() throws android.os.RemoteException {
            return this.val$notificationEventListener.getNotifyProcessName();
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public boolean interceptAfterNotificationSuccess(boolean z) throws android.os.RemoteException {
            return this.val$notificationEventListener.interceptAfterNotificationSuccess(z);
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener
        public void onNotificationEvent(int i, com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            this.val$notificationEventListener.onNotificationEvent(i, downloadInfo, str, str2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$30, reason: invalid class name */
    public static class AnonymousClass30 implements com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider val$aidlFileProvider;

        public AnonymousClass30(com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider iDownloadAidlFileProvider) {
            this.val$aidlFileProvider = iDownloadAidlFileProvider;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
        public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) {
            try {
                return this.val$aidlFileProvider.getUriForFile(str, str2);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$31, reason: invalid class name */
    public static class AnonymousClass31 implements com.ss.android.socialbase.downloader.depend.IDownloadExtListener {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadAidlListener val$listener;

        public AnonymousClass31(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener) {
            this.val$listener = iDownloadAidlListener;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onCanceled(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
            try {
                this.val$listener.onFailed(downloadInfo, baseException);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFirstStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onFirstStart(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onFirstSuccess(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onPause(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onPrepare(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onProgress(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onRetry(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
            try {
                this.val$listener.onRetry(downloadInfo, baseException);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onRetryDelay(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.exception.BaseException baseException) {
            try {
                this.val$listener.onRetryDelay(downloadInfo, baseException);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onStart(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onSuccessed(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            try {
                this.val$listener.onWaitingDownloadCompleteHandler(downloadInfo);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$4, reason: invalid class name */
    public static class AnonymousClass4 extends com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.INotificationClickCallback val$notificationClickCallback;

        public AnonymousClass4(com.ss.android.socialbase.downloader.depend.INotificationClickCallback iNotificationClickCallback) {
            this.val$notificationClickCallback = iNotificationClickCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenInstalled(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return this.val$notificationClickCallback.onClickWhenInstalled(downloadInfo);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return this.val$notificationClickCallback.onClickWhenSuccess(downloadInfo);
        }

        @Override // com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback
        public boolean onClickWhenUnSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) throws android.os.RemoteException {
            return this.val$notificationClickCallback.onClickWhenUnSuccess(downloadInfo);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$5, reason: invalid class name */
    public static class AnonymousClass5 extends com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator val$retryDelayTimeCalculator;

        public AnonymousClass5(com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
            this.val$retryDelayTimeCalculator = iRetryDelayTimeCalculator;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator
        public long calculateRetryDelayTime(int i, int i2) throws android.os.RemoteException {
            return this.val$retryDelayTimeCalculator.calculateRetryDelayTime(i, i2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$6, reason: invalid class name */
    public static class AnonymousClass6 extends com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler val$forbiddenHandler;

        public AnonymousClass6(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler iDownloadForbiddenHandler) {
            this.val$forbiddenHandler = iDownloadForbiddenHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler
        public boolean onForbidden(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) throws android.os.RemoteException {
            return this.val$forbiddenHandler.onForbidden(com.ss.android.socialbase.downloader.utils.IPCUtils.convertForbiddenCallbackFromAidl(iDownloadForbiddenAidlCallback));
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$7, reason: invalid class name */
    public static class AnonymousClass7 extends com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider val$fileUriProvider;

        public AnonymousClass7(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
            this.val$fileUriProvider = iDownloadFileUriProvider;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider
        public android.net.Uri getUriForFile(java.lang.String str, java.lang.String str2) throws android.os.RemoteException {
            return this.val$fileUriProvider.getUriForFile(str, str2);
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$8, reason: invalid class name */
    public static class AnonymousClass8 implements com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback val$forbiddenAidlCallback;

        public AnonymousClass8(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) {
            this.val$forbiddenAidlCallback = iDownloadForbiddenAidlCallback;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public boolean hasCallback() {
            try {
                return this.val$forbiddenAidlCallback.hasCallback();
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback
        public void onCallback(java.util.List<java.lang.String> list) {
            try {
                this.val$forbiddenAidlCallback.onCallback(list);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.utils.IPCUtils$9, reason: invalid class name */
    public static class AnonymousClass9 extends com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler.Stub {
        final /* synthetic */ com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler val$diskSpaceHandler;

        public AnonymousClass9(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
            this.val$diskSpaceHandler = iDownloadDiskSpaceHandler;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler
        public boolean cleanUpDisk(long j, long j2, com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) throws android.os.RemoteException {
            return this.val$diskSpaceHandler.cleanUpDisk(j, j2, com.ss.android.socialbase.downloader.utils.IPCUtils.convertDiskSpaceCallbackFromAidl(iDownloadDiskSpaceAidlCallback));
        }
    }

    public static com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator convertCntCalculatorFromAidl(com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator iChunkCntAidlCalculator) {
        if (iChunkCntAidlCalculator == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass19(iChunkCntAidlCalculator);
    }

    public static com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator convertCntCalculatorToAidl(com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator iChunkCntCalculator) {
        if (iChunkCntCalculator == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass13(iChunkCntCalculator);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend convertDependToAidl(com.ss.android.socialbase.downloader.depend.IDownloadDepend iDownloadDepend) {
        if (iDownloadDepend == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass11(iDownloadDepend);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback convertDiskSpaceCallbackFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback iDownloadDiskSpaceAidlCallback) {
        if (iDownloadDiskSpaceAidlCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass10(iDownloadDiskSpaceAidlCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlCallback convertDiskSpaceCallbackToAidl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) {
        if (iDownloadDiskSpaceCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass27(iDownloadDiskSpaceCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler convertDiskSpaceHandlerFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler iDownloadDiskSpaceAidlHandler) {
        if (iDownloadDiskSpaceAidlHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass26(iDownloadDiskSpaceAidlHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler convertDiskSpaceHandlerToAidl(com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        if (iDownloadDiskSpaceHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass9(iDownloadDiskSpaceHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler convertDownloadCompleteHandlerFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler iDownloadCompleteAidlHandler) {
        if (iDownloadCompleteAidlHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass16(iDownloadCompleteAidlHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler convertDownloadCompleteHandlerToAidl(com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler iDownloadCompleteHandler) {
        if (iDownloadCompleteHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass17(iDownloadCompleteHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadDepend convertDownloadDependFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend iDownloadAidlDepend) {
        if (iDownloadAidlDepend == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass20(iDownloadAidlDepend);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend convertDownloadMonitorDependFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend iDownloadAidlMonitorDepend) {
        if (iDownloadAidlMonitorDepend == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass21(iDownloadAidlMonitorDepend);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener convertDownloadNotificationEventListenerFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener iDownloadNotificationEventAidlListener) {
        if (iDownloadNotificationEventAidlListener == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass15(iDownloadNotificationEventAidlListener);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener convertDownloadNotificationEventListenerToAidl(com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        if (iDownloadNotificationEventListener == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass3(iDownloadNotificationEventListener);
    }

    public static com.ss.android.socialbase.downloader.model.DownloadTask convertDownloadTaskFromAidl(com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) {
        if (downloadAidlTask == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.model.DownloadTask downloadTask = new com.ss.android.socialbase.downloader.model.DownloadTask(downloadAidlTask.getDownloadInfo());
            downloadTask.chunkStategy(convertCntCalculatorFromAidl(downloadAidlTask.getChunkStrategy())).notificationEventListener(convertDownloadNotificationEventListenerFromAidl(downloadAidlTask.getDownloadNotificationEventListener())).interceptor(convertInterceptorFromAidl(downloadAidlTask.getInterceptor())).depend(convertDownloadDependFromAidl(downloadAidlTask.getDepend())).monitorDepend(convertDownloadMonitorDependFromAidl(downloadAidlTask.getMonitorDepend())).forbiddenHandler(convertForbiddenHandlerFromAidl(downloadAidlTask.getForbiddenHandler())).diskSpaceHandler(convertDiskSpaceHandlerFromAidl(downloadAidlTask.getDiskSpaceHandler())).fileUriProvider(convertFileProviderFromAidl(downloadAidlTask.getFileProvider())).notificationClickCallback(convertNotificationClickCallbackFromAidl(downloadAidlTask.getNotificationClickCallback())).retryDelayTimeCalculator(convertRetryDelayTimeCalculatorFromAidl(downloadAidlTask.getRetryDelayTimeCalculator()));
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType = com.ss.android.socialbase.downloader.constants.ListenerType.MAIN;
            com.ss.android.socialbase.downloader.depend.IDownloadAidlListener singleDownloadListener = downloadAidlTask.getSingleDownloadListener(listenerType.ordinal());
            if (singleDownloadListener != null) {
                downloadTask.mainThreadListenerWithHashCode(singleDownloadListener.hashCode(), convertListenerFromAidl(singleDownloadListener));
            }
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType2 = com.ss.android.socialbase.downloader.constants.ListenerType.SUB;
            com.ss.android.socialbase.downloader.depend.IDownloadAidlListener singleDownloadListener2 = downloadAidlTask.getSingleDownloadListener(listenerType2.ordinal());
            if (singleDownloadListener2 != null) {
                downloadTask.subThreadListenerWithHashCode(singleDownloadListener2.hashCode(), convertListenerFromAidl(singleDownloadListener2));
            }
            com.ss.android.socialbase.downloader.constants.ListenerType listenerType3 = com.ss.android.socialbase.downloader.constants.ListenerType.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.IDownloadAidlListener singleDownloadListener3 = downloadAidlTask.getSingleDownloadListener(listenerType3.ordinal());
            if (singleDownloadListener3 != null) {
                downloadTask.notificationListenerWithHashCode(singleDownloadListener3.hashCode(), convertListenerFromAidl(singleDownloadListener3));
            }
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType);
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType2);
            setDownloadListeners(downloadTask, downloadAidlTask, listenerType3);
            setCompletedHandlers(downloadTask, downloadAidlTask);
            return downloadTask;
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.ss.android.socialbase.downloader.model.DownloadAidlTask convertDownloadTaskToAidl(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass1(downloadTask);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider convertFileProviderFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider iDownloadAidlFileProvider) {
        if (iDownloadAidlFileProvider == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass30(iDownloadAidlFileProvider);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider convertFileProviderToAidl(com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass7(iDownloadFileUriProvider);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback convertForbiddenCallbackFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback iDownloadForbiddenAidlCallback) {
        if (iDownloadForbiddenAidlCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass8(iDownloadForbiddenAidlCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlCallback convertForbiddenCallbackToAidl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenCallback iDownloadForbiddenCallback) {
        if (iDownloadForbiddenCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass23(iDownloadForbiddenCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler convertForbiddenHandlerFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler iDownloadForbiddenAidlHandler) {
        if (iDownloadForbiddenAidlHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass22(iDownloadForbiddenAidlHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler convertForbiddenHandlerToAidl(com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler iDownloadForbiddenHandler) {
        if (iDownloadForbiddenHandler == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass6(iDownloadForbiddenHandler);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadInterceptor convertInterceptorFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor iDownloadAidlInterceptor) {
        if (iDownloadAidlInterceptor == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass29(iDownloadAidlInterceptor);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor convertInterceptorToAidl(com.ss.android.socialbase.downloader.depend.IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass14(iDownloadInterceptor);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadListener convertListenerFromAidl(com.ss.android.socialbase.downloader.depend.IDownloadAidlListener iDownloadAidlListener) {
        if (iDownloadAidlListener == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass31(iDownloadAidlListener);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadAidlListener convertListenerToAidl(com.ss.android.socialbase.downloader.depend.IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass2(iDownloadListener, z);
    }

    public static com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend convertMonitorDependToAidl(com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend iDownloadMonitorDepend) {
        if (iDownloadMonitorDepend == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass12(iDownloadMonitorDepend);
    }

    public static com.ss.android.socialbase.downloader.depend.INotificationClickCallback convertNotificationClickCallbackFromAidl(com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback iNotificationClickAidlCallback) {
        if (iNotificationClickAidlCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass18(iNotificationClickAidlCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback convertNotificationClickCallbackToAidl(com.ss.android.socialbase.downloader.depend.INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass4(iNotificationClickCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.ProcessCallback convertProcessAidlCallbackFromAidl(com.ss.android.socialbase.downloader.depend.ProcessAidlCallback processAidlCallback) {
        if (processAidlCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass25(processAidlCallback);
    }

    public static com.ss.android.socialbase.downloader.depend.ProcessAidlCallback convertProcessCallbackToAidl(com.ss.android.socialbase.downloader.depend.ProcessCallback processCallback) {
        if (processCallback == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass24(processCallback);
    }

    public static com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator convertRetryDelayTimeCalculatorFromAidl(com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator iRetryDelayTimeAidlCalculator) {
        if (iRetryDelayTimeAidlCalculator == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass28(iRetryDelayTimeAidlCalculator);
    }

    public static com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator convertRetryDelayTimeCalculatorToAidl(com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        if (iRetryDelayTimeCalculator == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.utils.IPCUtils.AnonymousClass5(iRetryDelayTimeCalculator);
    }

    private static void setCompletedHandlers(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask) throws android.os.RemoteException {
        for (int i = 0; i < downloadAidlTask.getDownloadCompleteHandlerSize(); i++) {
            com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = downloadAidlTask.getDownloadCompleteAidlHandlerByIndex(i);
            if (downloadCompleteAidlHandlerByIndex != null) {
                downloadTask.addDownloadCompleteHandler(convertDownloadCompleteHandlerFromAidl(downloadCompleteAidlHandlerByIndex));
            }
        }
    }

    private static void setDownloadListeners(com.ss.android.socialbase.downloader.model.DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.DownloadAidlTask downloadAidlTask, com.ss.android.socialbase.downloader.constants.ListenerType listenerType) throws android.os.RemoteException {
        android.util.SparseArray<com.ss.android.socialbase.downloader.depend.IDownloadListener> sparseArray = new android.util.SparseArray<>();
        for (int i = 0; i < downloadAidlTask.getDownloadListenerSize(listenerType.ordinal()); i++) {
            com.ss.android.socialbase.downloader.depend.IDownloadAidlListener downloadListenerByIndex = downloadAidlTask.getDownloadListenerByIndex(listenerType.ordinal(), i);
            if (downloadListenerByIndex != null) {
                sparseArray.put(downloadListenerByIndex.getOriginHashCode(), convertListenerFromAidl(downloadListenerByIndex));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, listenerType);
    }
}

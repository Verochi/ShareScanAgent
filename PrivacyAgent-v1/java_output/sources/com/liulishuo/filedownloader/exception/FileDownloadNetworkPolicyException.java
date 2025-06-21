package com.liulishuo.filedownloader.exception;

/* loaded from: classes23.dex */
public class FileDownloadNetworkPolicyException extends com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}

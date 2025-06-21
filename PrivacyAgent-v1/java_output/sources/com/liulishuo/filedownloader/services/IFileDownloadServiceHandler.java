package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
interface IFileDownloadServiceHandler {
    android.os.IBinder onBind(android.content.Intent intent);

    void onStartCommand(android.content.Intent intent, int i, int i2);
}

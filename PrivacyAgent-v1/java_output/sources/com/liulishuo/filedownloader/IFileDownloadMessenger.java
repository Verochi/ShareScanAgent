package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
interface IFileDownloadMessenger {
    void a(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void b(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void c(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void d(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void e(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask, com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback lifeCycleCallback);

    boolean f();

    void g();

    void h();

    boolean i();

    void j(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void k(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void l(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    boolean m();

    void n(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);

    void o(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);
}

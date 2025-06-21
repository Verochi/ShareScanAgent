package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class FileDownloadQueueSet {
    public com.liulishuo.filedownloader.FileDownloadListener a;
    public boolean b;
    public java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> c;
    public java.lang.Integer d;
    public java.lang.Boolean e;
    public java.lang.Boolean f;
    public java.lang.Boolean g;
    public java.lang.Integer h;
    public java.lang.Integer i;
    public java.lang.Object j;
    public java.lang.String k;
    public com.liulishuo.filedownloader.BaseDownloadTask[] l;

    public FileDownloadQueueSet(com.liulishuo.filedownloader.FileDownloadListener fileDownloadListener) {
        if (fileDownloadListener == null) {
            throw new java.lang.IllegalArgumentException("create FileDownloadQueueSet must with valid target!");
        }
        this.a = fileDownloadListener;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet addTaskFinishListener(com.liulishuo.filedownloader.BaseDownloadTask.FinishListener finishListener) {
        if (this.c == null) {
            this.c = new java.util.ArrayList();
        }
        this.c.add(finishListener);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet disableCallbackProgressTimes() {
        return setCallbackProgressTimes(0);
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet downloadSequentially(java.util.List<com.liulishuo.filedownloader.BaseDownloadTask> list) {
        this.b = true;
        com.liulishuo.filedownloader.BaseDownloadTask[] baseDownloadTaskArr = new com.liulishuo.filedownloader.BaseDownloadTask[list.size()];
        this.l = baseDownloadTaskArr;
        list.toArray(baseDownloadTaskArr);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet downloadSequentially(com.liulishuo.filedownloader.BaseDownloadTask... baseDownloadTaskArr) {
        this.b = true;
        this.l = baseDownloadTaskArr;
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet downloadTogether(java.util.List<com.liulishuo.filedownloader.BaseDownloadTask> list) {
        this.b = false;
        com.liulishuo.filedownloader.BaseDownloadTask[] baseDownloadTaskArr = new com.liulishuo.filedownloader.BaseDownloadTask[list.size()];
        this.l = baseDownloadTaskArr;
        list.toArray(baseDownloadTaskArr);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet downloadTogether(com.liulishuo.filedownloader.BaseDownloadTask... baseDownloadTaskArr) {
        this.b = false;
        this.l = baseDownloadTaskArr;
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet ignoreEachTaskInternalProgress() {
        setCallbackProgressTimes(-1);
        return this;
    }

    public void reuseAndStart() {
        for (com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask : this.l) {
            baseDownloadTask.reuse();
        }
        start();
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setAutoRetryTimes(int i) {
        this.d = java.lang.Integer.valueOf(i);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setCallbackProgressMinInterval(int i) {
        this.i = java.lang.Integer.valueOf(i);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setCallbackProgressTimes(int i) {
        this.h = java.lang.Integer.valueOf(i);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setDirectory(java.lang.String str) {
        this.k = str;
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setForceReDownload(boolean z) {
        this.f = java.lang.Boolean.valueOf(z);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setSyncCallback(boolean z) {
        this.e = java.lang.Boolean.valueOf(z);
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setTag(java.lang.Object obj) {
        this.j = obj;
        return this;
    }

    public com.liulishuo.filedownloader.FileDownloadQueueSet setWifiRequired(boolean z) {
        this.g = java.lang.Boolean.valueOf(z);
        return this;
    }

    public void start() {
        for (com.liulishuo.filedownloader.BaseDownloadTask baseDownloadTask : this.l) {
            baseDownloadTask.setListener(this.a);
            java.lang.Integer num = this.d;
            if (num != null) {
                baseDownloadTask.setAutoRetryTimes(num.intValue());
            }
            java.lang.Boolean bool = this.e;
            if (bool != null) {
                baseDownloadTask.setSyncCallback(bool.booleanValue());
            }
            java.lang.Boolean bool2 = this.f;
            if (bool2 != null) {
                baseDownloadTask.setForceReDownload(bool2.booleanValue());
            }
            java.lang.Integer num2 = this.h;
            if (num2 != null) {
                baseDownloadTask.setCallbackProgressTimes(num2.intValue());
            }
            java.lang.Integer num3 = this.i;
            if (num3 != null) {
                baseDownloadTask.setCallbackProgressMinInterval(num3.intValue());
            }
            java.lang.Object obj = this.j;
            if (obj != null) {
                baseDownloadTask.setTag(obj);
            }
            java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> list = this.c;
            if (list != null) {
                java.util.Iterator<com.liulishuo.filedownloader.BaseDownloadTask.FinishListener> it = list.iterator();
                while (it.hasNext()) {
                    baseDownloadTask.addFinishListener(it.next());
                }
            }
            java.lang.String str = this.k;
            if (str != null) {
                baseDownloadTask.setPath(str, true);
            }
            java.lang.Boolean bool3 = this.g;
            if (bool3 != null) {
                baseDownloadTask.setWifiRequired(bool3.booleanValue());
            }
            baseDownloadTask.asInQueueTask().enqueue();
        }
        com.liulishuo.filedownloader.FileDownloader.getImpl().start(this.a, this.b);
    }
}

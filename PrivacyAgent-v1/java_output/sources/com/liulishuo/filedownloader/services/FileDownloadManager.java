package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
class FileDownloadManager implements com.liulishuo.filedownloader.IThreadPoolMonitor {
    public final com.liulishuo.filedownloader.database.FileDownloadDatabase a;
    public final com.liulishuo.filedownloader.services.FileDownloadThreadPool b;

    public FileDownloadManager() {
        com.liulishuo.filedownloader.download.CustomComponentHolder impl = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl();
        this.a = impl.getDatabaseInstance();
        this.b = new com.liulishuo.filedownloader.services.FileDownloadThreadPool(impl.getMaxNetworkThreadCount());
    }

    public void a() {
        this.a.clear();
    }

    public boolean b(int i) {
        if (i == 0) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "The task[%d] id is invalid, can't clear it.", java.lang.Integer.valueOf(i));
            return false;
        }
        if (f(i)) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "The task[%d] is downloading, can't clear it.", java.lang.Integer.valueOf(i));
            return false;
        }
        this.a.remove(i);
        this.a.removeConnections(i);
        return true;
    }

    public long c(int i) {
        com.liulishuo.filedownloader.model.FileDownloadModel find = this.a.find(i);
        if (find == null) {
            return 0L;
        }
        int connectionCount = find.getConnectionCount();
        if (connectionCount <= 1) {
            return find.getSoFar();
        }
        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel = this.a.findConnectionModel(i);
        if (findConnectionModel == null || findConnectionModel.size() != connectionCount) {
            return 0L;
        }
        return com.liulishuo.filedownloader.model.ConnectionModel.getTotalOffset(findConnectionModel);
    }

    public byte d(int i) {
        com.liulishuo.filedownloader.model.FileDownloadModel find = this.a.find(i);
        if (find == null) {
            return (byte) 0;
        }
        return find.getStatus();
    }

    public long e(int i) {
        com.liulishuo.filedownloader.model.FileDownloadModel find = this.a.find(i);
        if (find == null) {
            return 0L;
        }
        return find.getTotal();
    }

    public boolean f(int i) {
        return isDownloading(this.a.find(i));
    }

    @Override // com.liulishuo.filedownloader.IThreadPoolMonitor
    public int findRunningTaskIdBySameTempPath(java.lang.String str, int i) {
        return this.b.e(str, i);
    }

    public boolean g(java.lang.String str, java.lang.String str2) {
        return f(com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, str2));
    }

    public boolean h() {
        return this.b.b() <= 0;
    }

    public boolean i(int i) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "request pause the task %d", java.lang.Integer.valueOf(i));
        }
        com.liulishuo.filedownloader.model.FileDownloadModel find = this.a.find(i);
        if (find == null) {
            return false;
        }
        find.setStatus((byte) -2);
        this.b.a(i);
        return true;
    }

    @Override // com.liulishuo.filedownloader.IThreadPoolMonitor
    public boolean isDownloading(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean g = this.b.g(fileDownloadModel.getId());
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isOver(fileDownloadModel.getStatus())) {
            if (!g) {
                return false;
            }
        } else if (!g) {
            com.liulishuo.filedownloader.util.FileDownloadLog.e(this, "%d status is[%s](not finish) & but not in the pool", java.lang.Integer.valueOf(fileDownloadModel.getId()), java.lang.Byte.valueOf(fileDownloadModel.getStatus()));
            return false;
        }
        return true;
    }

    public void j() {
        java.util.List<java.lang.Integer> f = this.b.f();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "pause all tasks %d", java.lang.Integer.valueOf(f.size()));
        }
        java.util.Iterator<java.lang.Integer> it = f.iterator();
        while (it.hasNext()) {
            i(it.next().intValue());
        }
    }

    public synchronized boolean k(int i) {
        return this.b.h(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0184 A[Catch: all -> 0x01cf, TryCatch #0 {, blocks: (B:4:0x0009, B:6:0x0010, B:7:0x0022, B:10:0x0034, B:12:0x0044, B:14:0x004e, B:16:0x0052, B:17:0x0065, B:19:0x0072, B:21:0x0078, B:23:0x007c, B:28:0x008d, B:29:0x0096, B:31:0x009f, B:33:0x00a3, B:38:0x00b6, B:40:0x00bf, B:41:0x00c8, B:43:0x00d7, B:45:0x00db, B:47:0x00ec, B:51:0x00fa, B:53:0x0101, B:55:0x0108, B:57:0x010e, B:59:0x0115, B:61:0x011b, B:63:0x0121, B:65:0x013b, B:66:0x013f, B:68:0x0145, B:72:0x0184, B:73:0x0189, B:76:0x0154, B:78:0x015e, B:80:0x0164, B:81:0x016a, B:82:0x00c4, B:84:0x0092), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void l(java.lang.String str, java.lang.String str2, boolean z, int i, int i2, int i3, boolean z2, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, boolean z3) {
        com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel;
        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list;
        boolean z4 = false;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, java.lang.Boolean.valueOf(z));
        }
        com.liulishuo.filedownloader.PauseAllMarker.clearMarker();
        int generateId = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, str2, z);
        com.liulishuo.filedownloader.model.FileDownloadModel find = this.a.find(generateId);
        if (z || find != null) {
            fileDownloadModel = find;
            list = null;
        } else {
            int generateId2 = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(str, com.liulishuo.filedownloader.util.FileDownloadUtils.getParent(str2), true);
            com.liulishuo.filedownloader.model.FileDownloadModel find2 = this.a.find(generateId2);
            if (find2 == null || !str2.equals(find2.getTargetFilePath())) {
                list = null;
            } else {
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "task[%d] find model by dirCaseId[%d]", java.lang.Integer.valueOf(generateId), java.lang.Integer.valueOf(generateId2));
                }
                list = this.a.findConnectionModel(generateId2);
            }
            fileDownloadModel = find2;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowDownloading(generateId, fileDownloadModel, this, true)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "has already started download %d", java.lang.Integer.valueOf(generateId));
            }
            return;
        }
        java.lang.String targetFilePath = fileDownloadModel != null ? fileDownloadModel.getTargetFilePath() : com.liulishuo.filedownloader.util.FileDownloadUtils.getTargetFilePath(str2, z, null);
        if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowDownloaded(generateId, targetFilePath, z2, true)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "has already completed downloading %d", java.lang.Integer.valueOf(generateId));
            }
            return;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowConflictPath(generateId, fileDownloadModel != null ? fileDownloadModel.getSoFar() : 0L, fileDownloadModel != null ? fileDownloadModel.getTempFilePath() : com.liulishuo.filedownloader.util.FileDownloadUtils.getTempPath(targetFilePath), targetFilePath, this)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "there is an another task with the same target-file-path %d %s", java.lang.Integer.valueOf(generateId), targetFilePath);
            }
            if (fileDownloadModel != null) {
                this.a.remove(generateId);
                this.a.removeConnections(generateId);
            }
            return;
        }
        if (fileDownloadModel == null || !(fileDownloadModel.getStatus() == -2 || fileDownloadModel.getStatus() == -1 || fileDownloadModel.getStatus() == 1 || fileDownloadModel.getStatus() == 6 || fileDownloadModel.getStatus() == 2)) {
            if (fileDownloadModel == null) {
                fileDownloadModel = new com.liulishuo.filedownloader.model.FileDownloadModel();
            }
            fileDownloadModel.setUrl(str);
            fileDownloadModel.setPath(str2, z);
            fileDownloadModel.setId(generateId);
            fileDownloadModel.setSoFar(0L);
            fileDownloadModel.setTotal(0L);
            fileDownloadModel.setStatus((byte) 1);
            fileDownloadModel.setConnectionCount(1);
        } else {
            if (fileDownloadModel.getId() == generateId) {
                if (!android.text.TextUtils.equals(str, fileDownloadModel.getUrl())) {
                    fileDownloadModel.setUrl(str);
                }
                if (z4) {
                    this.a.update(fileDownloadModel);
                }
                this.b.c(new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder().setModel(fileDownloadModel).setHeader(fileDownloadHeader).setThreadPoolMonitor(this).setMinIntervalMillis(java.lang.Integer.valueOf(i2)).setCallbackProgressMaxCount(java.lang.Integer.valueOf(i)).setForceReDownload(java.lang.Boolean.valueOf(z2)).setWifiRequired(java.lang.Boolean.valueOf(z3)).setMaxRetryTimes(java.lang.Integer.valueOf(i3)).build());
            }
            this.a.remove(fileDownloadModel.getId());
            this.a.removeConnections(fileDownloadModel.getId());
            fileDownloadModel.setId(generateId);
            fileDownloadModel.setPath(str2, z);
            if (list != null) {
                for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : list) {
                    connectionModel.setId(generateId);
                    this.a.insertConnectionModel(connectionModel);
                }
            }
        }
        z4 = true;
        if (z4) {
        }
        this.b.c(new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder().setModel(fileDownloadModel).setHeader(fileDownloadHeader).setThreadPoolMonitor(this).setMinIntervalMillis(java.lang.Integer.valueOf(i2)).setCallbackProgressMaxCount(java.lang.Integer.valueOf(i)).setForceReDownload(java.lang.Boolean.valueOf(z2)).setWifiRequired(java.lang.Boolean.valueOf(z3)).setMaxRetryTimes(java.lang.Integer.valueOf(i3)).build());
    }
}

package com.liulishuo.filedownloader.download;

/* loaded from: classes23.dex */
public class DownloadLaunchRunnable implements java.lang.Runnable, com.liulishuo.filedownloader.download.ProcessCallback {
    public static final java.util.concurrent.ThreadPoolExecutor T = com.liulishuo.filedownloader.util.FileDownloadExecutors.newFixedThreadPool("ConnectionBlock");
    public boolean A;
    public int B;
    public boolean C;
    public final boolean D;
    public final java.util.ArrayList<com.liulishuo.filedownloader.download.DownloadRunnable> E;
    public com.liulishuo.filedownloader.download.DownloadRunnable F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public final java.util.concurrent.atomic.AtomicBoolean K;
    public volatile boolean L;
    public volatile boolean M;
    public volatile java.lang.Exception N;
    public java.lang.String O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public final com.liulishuo.filedownloader.download.DownloadStatusCallback n;
    public final int t;
    public final com.liulishuo.filedownloader.model.FileDownloadModel u;
    public final com.liulishuo.filedownloader.model.FileDownloadHeader v;
    public final boolean w;
    public final boolean x;
    public final com.liulishuo.filedownloader.database.FileDownloadDatabase y;
    public final com.liulishuo.filedownloader.IThreadPoolMonitor z;

    public static class Builder {
        public com.liulishuo.filedownloader.model.FileDownloadModel a;
        public com.liulishuo.filedownloader.model.FileDownloadHeader b;
        public com.liulishuo.filedownloader.IThreadPoolMonitor c;
        public java.lang.Integer d;
        public java.lang.Integer e;
        public java.lang.Boolean f;
        public java.lang.Boolean g;
        public java.lang.Integer h;

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable build() {
            if (this.a == null || this.c == null || this.d == null || this.e == null || this.f == null || this.g == null || this.h == null) {
                throw new java.lang.IllegalArgumentException();
            }
            return new com.liulishuo.filedownloader.download.DownloadLaunchRunnable(this.a, this.b, this.c, this.d.intValue(), this.e.intValue(), this.f.booleanValue(), this.g.booleanValue(), this.h.intValue(), null);
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setCallbackProgressMaxCount(java.lang.Integer num) {
            this.e = num;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setForceReDownload(java.lang.Boolean bool) {
            this.f = bool;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setHeader(com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader) {
            this.b = fileDownloadHeader;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setMaxRetryTimes(java.lang.Integer num) {
            this.h = num;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setMinIntervalMillis(java.lang.Integer num) {
            this.d = num;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setModel(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
            this.a = fileDownloadModel;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setThreadPoolMonitor(com.liulishuo.filedownloader.IThreadPoolMonitor iThreadPoolMonitor) {
            this.c = iThreadPoolMonitor;
            return this;
        }

        public com.liulishuo.filedownloader.download.DownloadLaunchRunnable.Builder setWifiRequired(java.lang.Boolean bool) {
            this.g = bool;
            return this;
        }
    }

    public class DiscardSafely extends java.lang.Throwable {
        public DiscardSafely() {
        }
    }

    public class RetryDirectly extends java.lang.Throwable {
        public RetryDirectly() {
        }
    }

    public DownloadLaunchRunnable(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, com.liulishuo.filedownloader.IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3) {
        this.t = 5;
        this.C = false;
        this.E = new java.util.ArrayList<>(5);
        this.P = 0L;
        this.Q = 0L;
        this.R = 0L;
        this.S = 0L;
        this.K = new java.util.concurrent.atomic.AtomicBoolean(true);
        this.L = false;
        this.A = false;
        this.u = fileDownloadModel;
        this.v = fileDownloadHeader;
        this.w = z;
        this.x = z2;
        this.y = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().getDatabaseInstance();
        this.D = com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().isSupportSeek();
        this.z = iThreadPoolMonitor;
        this.B = i3;
        this.n = new com.liulishuo.filedownloader.download.DownloadStatusCallback(fileDownloadModel, i3, i, i2);
    }

    public /* synthetic */ DownloadLaunchRunnable(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel, com.liulishuo.filedownloader.model.FileDownloadHeader fileDownloadHeader, com.liulishuo.filedownloader.IThreadPoolMonitor iThreadPoolMonitor, int i, int i2, boolean z, boolean z2, int i3, com.liulishuo.filedownloader.download.DownloadLaunchRunnable.AnonymousClass1 anonymousClass1) {
        this(fileDownloadModel, fileDownloadHeader, iThreadPoolMonitor, i, i2, z, z2, i3);
    }

    public final int a(long j) {
        if (h()) {
            return this.H ? this.u.getConnectionCount() : com.liulishuo.filedownloader.download.CustomComponentHolder.getImpl().determineConnectionCount(this.u.getId(), this.u.getUrl(), this.u.getPath(), j);
        }
        return 1;
    }

    public final void b() throws com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly, com.liulishuo.filedownloader.download.DownloadLaunchRunnable.DiscardSafely {
        int id = this.u.getId();
        if (this.u.isPathAsDirectory()) {
            java.lang.String targetFilePath = this.u.getTargetFilePath();
            int generateId = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(this.u.getUrl(), targetFilePath);
            if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowDownloaded(id, targetFilePath, this.w, false)) {
                this.y.remove(id);
                this.y.removeConnections(id);
                throw new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.DiscardSafely();
            }
            com.liulishuo.filedownloader.model.FileDownloadModel find = this.y.find(generateId);
            if (find != null) {
                if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowDownloading(id, find, this.z, false)) {
                    this.y.remove(id);
                    this.y.removeConnections(id);
                    throw new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.DiscardSafely();
                }
                java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel = this.y.findConnectionModel(generateId);
                this.y.remove(generateId);
                this.y.removeConnections(generateId);
                com.liulishuo.filedownloader.util.FileDownloadUtils.deleteTargetFile(this.u.getTargetFilePath());
                if (com.liulishuo.filedownloader.util.FileDownloadUtils.isBreakpointAvailable(generateId, find)) {
                    this.u.setSoFar(find.getSoFar());
                    this.u.setTotal(find.getTotal());
                    this.u.setETag(find.getETag());
                    this.u.setConnectionCount(find.getConnectionCount());
                    this.y.update(this.u);
                    if (findConnectionModel != null) {
                        for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : findConnectionModel) {
                            connectionModel.setId(id);
                            this.y.insertConnectionModel(connectionModel);
                        }
                    }
                    throw new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly();
                }
            }
            if (com.liulishuo.filedownloader.util.FileDownloadHelper.inspectAndInflowConflictPath(id, this.u.getSoFar(), this.u.getTempFilePath(), targetFilePath, this.z)) {
                this.y.remove(id);
                this.y.removeConnections(id);
                throw new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.DiscardSafely();
            }
        }
    }

    public final void c() throws com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException {
        if (this.x && !com.liulishuo.filedownloader.util.FileDownloadUtils.checkPermission("android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", java.lang.Integer.valueOf(this.u.getId()), "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.x && com.liulishuo.filedownloader.util.FileDownloadUtils.isNetworkNotOnWifiType()) {
            throw new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException();
        }
    }

    public final void d(java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list, long j) throws java.lang.InterruptedException {
        int id = this.u.getId();
        java.lang.String eTag = this.u.getETag();
        java.lang.String str = this.O;
        if (str == null) {
            str = this.u.getUrl();
        }
        java.lang.String tempFilePath = this.u.getTempFilePath();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", java.lang.Integer.valueOf(list.size()), java.lang.Integer.valueOf(id), java.lang.Long.valueOf(j));
        }
        boolean z = this.H;
        long j2 = 0;
        long j3 = 0;
        for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : list) {
            long currentOffset = connectionModel.getEndOffset() == -1 ? j - connectionModel.getCurrentOffset() : (connectionModel.getEndOffset() - connectionModel.getCurrentOffset()) + 1;
            j3 += connectionModel.getCurrentOffset() - connectionModel.getStartOffset();
            if (currentOffset != j2) {
                com.liulishuo.filedownloader.download.DownloadRunnable build = new com.liulishuo.filedownloader.download.DownloadRunnable.Builder().setId(id).setConnectionIndex(java.lang.Integer.valueOf(connectionModel.getIndex())).setCallback(this).setUrl(str).setEtag(z ? eTag : null).setHeader(this.v).setWifiRequired(this.x).setConnectionModel(com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildConnectionProfile(connectionModel.getStartOffset(), connectionModel.getCurrentOffset(), connectionModel.getEndOffset(), currentOffset)).setPath(tempFilePath).build();
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "enable multiple connection: %s", connectionModel);
                }
                if (build == null) {
                    throw new java.lang.IllegalArgumentException("the download runnable must not be null!");
                }
                this.E.add(build);
            } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "pass connection[%d-%d], because it has been completed", java.lang.Integer.valueOf(connectionModel.getId()), java.lang.Integer.valueOf(connectionModel.getIndex()));
            }
            j2 = 0;
        }
        if (j3 != this.u.getSoFar()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "correct the sofar[%d] from connection table[%d]", java.lang.Long.valueOf(this.u.getSoFar()), java.lang.Long.valueOf(j3));
            this.u.setSoFar(j3);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.E.size());
        java.util.Iterator<com.liulishuo.filedownloader.download.DownloadRunnable> it = this.E.iterator();
        while (it.hasNext()) {
            com.liulishuo.filedownloader.download.DownloadRunnable next = it.next();
            if (this.L) {
                next.pause();
            } else {
                arrayList.add(java.util.concurrent.Executors.callable(next));
            }
        }
        if (this.L) {
            this.u.setStatus((byte) -2);
            return;
        }
        java.util.List<java.util.concurrent.Future> invokeAll = T.invokeAll(arrayList);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            for (java.util.concurrent.Future future : invokeAll) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "finish sub-task for [%d] %B %B", java.lang.Integer.valueOf(id), java.lang.Boolean.valueOf(future.isDone()), java.lang.Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    public final void e(long j, java.lang.String str) throws java.io.IOException, java.lang.IllegalAccessException {
        com.liulishuo.filedownloader.stream.FileDownloadOutputStream fileDownloadOutputStream = null;
        if (j != -1) {
            try {
                fileDownloadOutputStream = com.liulishuo.filedownloader.util.FileDownloadUtils.createOutputStream(this.u.getTempFilePath());
                long length = new java.io.File(str).length();
                long j2 = j - length;
                long freeSpaceBytes = com.liulishuo.filedownloader.util.FileDownloadUtils.getFreeSpaceBytes(str);
                if (freeSpaceBytes < j2) {
                    throw new com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException(freeSpaceBytes, j2, length);
                }
                if (!com.liulishuo.filedownloader.util.FileDownloadProperties.getImpl().fileNonPreAllocation) {
                    fileDownloadOutputStream.setLength(j);
                }
            } finally {
                if (0 != 0) {
                    fileDownloadOutputStream.close();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, com.liulishuo.filedownloader.download.ConnectTask connectTask, com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection) throws java.io.IOException, com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly, java.lang.IllegalArgumentException, com.liulishuo.filedownloader.exception.FileDownloadSecurityException {
        boolean z;
        int id = this.u.getId();
        int responseCode = fileDownloadConnection.getResponseCode();
        this.I = com.liulishuo.filedownloader.util.FileDownloadUtils.isAcceptRange(responseCode, fileDownloadConnection);
        boolean z2 = responseCode == 200 || responseCode == 201 || responseCode == 0;
        long findInstanceLengthForTrial = com.liulishuo.filedownloader.util.FileDownloadUtils.findInstanceLengthForTrial(fileDownloadConnection);
        java.lang.String eTag = this.u.getETag();
        java.lang.String findEtag = com.liulishuo.filedownloader.util.FileDownloadUtils.findEtag(id, fileDownloadConnection);
        if (responseCode != 412 && ((eTag == null || eTag.equals(findEtag) || (!z2 && !this.I)) && (responseCode != 201 || !connectTask.f()))) {
            if (responseCode == 416) {
                if (this.I && findInstanceLengthForTrial >= 0) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "get 416 but the Content-Range is returned, no need to retry", new java.lang.Object[0]);
                } else if (this.u.getSoFar() > 0) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "get 416, precondition failed and just retry", new java.lang.Object[0]);
                } else if (!this.C) {
                    this.C = true;
                    com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "get 416, precondition failed and need to retry with discarding range", new java.lang.Object[0]);
                }
            }
            z = false;
            if (z) {
                this.O = connectTask.e();
                if (!this.I && !z2) {
                    throw new com.liulishuo.filedownloader.exception.FileDownloadHttpException(responseCode, map, fileDownloadConnection.getResponseHeaderFields());
                }
                java.lang.String findFilename = this.u.isPathAsDirectory() ? com.liulishuo.filedownloader.util.FileDownloadUtils.findFilename(fileDownloadConnection, this.u.getUrl()) : null;
                this.J = findInstanceLengthForTrial == -1;
                this.n.m(this.H && this.I, findInstanceLengthForTrial, findEtag, findFilename);
                return;
            }
            if (this.H) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d", java.lang.Integer.valueOf(id), eTag, findEtag, java.lang.Integer.valueOf(responseCode));
            }
            this.y.removeConnections(this.u.getId());
            com.liulishuo.filedownloader.util.FileDownloadUtils.deleteTaskFiles(this.u.getTargetFilePath(), this.u.getTempFilePath());
            this.H = false;
            if (eTag != null && eTag.equals(findEtag)) {
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", eTag, findEtag, java.lang.Integer.valueOf(responseCode), java.lang.Integer.valueOf(id));
                findEtag = null;
            }
            this.u.setSoFar(0L);
            this.u.setTotal(0L);
            this.u.setETag(findEtag);
            this.u.resetConnectionCount();
            this.y.updateOldEtagOverdue(id, this.u.getETag(), this.u.getSoFar(), this.u.getTotal(), this.u.getConnectionCount());
            throw new com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly();
        }
        z = true;
        if (z) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list) {
        long soFar;
        boolean z;
        int connectionCount = this.u.getConnectionCount();
        java.lang.String tempFilePath = this.u.getTempFilePath();
        java.lang.String targetFilePath = this.u.getTargetFilePath();
        boolean z2 = connectionCount > 1;
        if (!this.C && ((!z2 || this.D) && com.liulishuo.filedownloader.util.FileDownloadUtils.isBreakpointAvailable(this.u.getId(), this.u))) {
            if (!this.D) {
                soFar = new java.io.File(tempFilePath).length();
            } else if (!z2) {
                soFar = this.u.getSoFar();
            } else if (connectionCount == list.size()) {
                soFar = com.liulishuo.filedownloader.model.ConnectionModel.getTotalOffset(list);
            }
            this.u.setSoFar(soFar);
            z = soFar > 0;
            this.H = z;
            if (z) {
                this.y.removeConnections(this.u.getId());
                com.liulishuo.filedownloader.util.FileDownloadUtils.deleteTaskFiles(targetFilePath, tempFilePath);
                return;
            }
            return;
        }
        soFar = 0;
        this.u.setSoFar(soFar);
        if (soFar > 0) {
        }
        this.H = z;
        if (z) {
        }
    }

    public int getId() {
        return this.u.getId();
    }

    public java.lang.String getTempFilePath() {
        return this.u.getTempFilePath();
    }

    public final boolean h() {
        return (!this.H || this.u.getConnectionCount() > 1) && this.I && this.D && !this.J;
    }

    public final void i(long j, int i) throws java.lang.InterruptedException {
        long j2 = j / i;
        int id = this.u.getId();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long j3 = 0;
        int i2 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? -1L : (j3 + j2) - 1;
            com.liulishuo.filedownloader.model.ConnectionModel connectionModel = new com.liulishuo.filedownloader.model.ConnectionModel();
            connectionModel.setId(id);
            connectionModel.setIndex(i2);
            connectionModel.setStartOffset(j3);
            connectionModel.setCurrentOffset(j3);
            connectionModel.setEndOffset(j4);
            arrayList.add(connectionModel);
            this.y.insertConnectionModel(connectionModel);
            j3 += j2;
            i2++;
        }
        this.u.setConnectionCount(i);
        this.y.updateConnectionCount(id, i);
        d(arrayList, j);
    }

    public boolean isAlive() {
        return this.K.get() || this.n.isAlive();
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public boolean isRetry(java.lang.Exception exc) {
        if (exc instanceof com.liulishuo.filedownloader.exception.FileDownloadHttpException) {
            int code = ((com.liulishuo.filedownloader.exception.FileDownloadHttpException) exc).getCode();
            if (this.G && code == 416 && !this.A) {
                com.liulishuo.filedownloader.util.FileDownloadUtils.deleteTaskFiles(this.u.getTargetFilePath(), this.u.getTempFilePath());
                this.A = true;
                return true;
            }
        }
        return this.B > 0 && !(exc instanceof com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException);
    }

    public final void j(int i, java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list) throws java.lang.InterruptedException {
        if (i <= 1 || list.size() != i) {
            throw new java.lang.IllegalArgumentException();
        }
        d(list, this.u.getTotal());
    }

    public final void k(long j) throws java.io.IOException, java.lang.IllegalAccessException {
        com.liulishuo.filedownloader.download.ConnectionProfile buildToEndConnectionProfile;
        if (this.I) {
            buildToEndConnectionProfile = com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildToEndConnectionProfile(this.u.getSoFar(), this.u.getSoFar(), j - this.u.getSoFar());
        } else {
            this.u.setSoFar(0L);
            buildToEndConnectionProfile = com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildBeginToEndConnectionProfile(j);
        }
        this.F = new com.liulishuo.filedownloader.download.DownloadRunnable.Builder().setId(this.u.getId()).setConnectionIndex(-1).setCallback(this).setUrl(this.u.getUrl()).setEtag(this.u.getETag()).setHeader(this.v).setWifiRequired(this.x).setConnectionModel(buildToEndConnectionProfile).setPath(this.u.getTempFilePath()).build();
        this.u.setConnectionCount(1);
        this.y.updateConnectionCount(this.u.getId(), 1);
        if (!this.L) {
            this.F.run();
        } else {
            this.u.setStatus((byte) -2);
            this.F.pause();
        }
    }

    public final void l() throws java.io.IOException, com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly, java.lang.IllegalAccessException, com.liulishuo.filedownloader.exception.FileDownloadSecurityException {
        com.liulishuo.filedownloader.connection.FileDownloadConnection fileDownloadConnection = null;
        try {
            com.liulishuo.filedownloader.download.ConnectTask a = new com.liulishuo.filedownloader.download.ConnectTask.Builder().c(this.u.getId()).f(this.u.getUrl()).d(this.u.getETag()).e(this.v).b(this.C ? com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildTrialConnectionProfileNoRange() : com.liulishuo.filedownloader.download.ConnectionProfile.ConnectionProfileBuild.buildTrialConnectionProfile()).a();
            fileDownloadConnection = a.c();
            f(a.getRequestHeader(), a, fileDownloadConnection);
        } finally {
            if (fileDownloadConnection != null) {
                fileDownloadConnection.ending();
            }
        }
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public void onCompleted(com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable, long j, long j2) {
        if (this.L) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the completed callback", java.lang.Integer.valueOf(this.u.getId()));
                return;
            }
            return;
        }
        int i = downloadRunnable.z;
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the connection has been completed(%d): [%d, %d)  %d", java.lang.Integer.valueOf(i), java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(this.u.getTotal()));
        }
        if (!this.G) {
            synchronized (this.E) {
                this.E.remove(downloadRunnable);
            }
        } else {
            if (j == 0 || j2 == this.u.getTotal()) {
                return;
            }
            com.liulishuo.filedownloader.util.FileDownloadLog.e(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(this.u.getTotal()), java.lang.Integer.valueOf(this.u.getId()));
        }
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public void onError(java.lang.Exception exc) {
        this.M = true;
        this.N = exc;
        if (this.L) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the error callback", java.lang.Integer.valueOf(this.u.getId()));
            }
        } else {
            java.util.Iterator it = ((java.util.ArrayList) this.E.clone()).iterator();
            while (it.hasNext()) {
                com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable = (com.liulishuo.filedownloader.download.DownloadRunnable) it.next();
                if (downloadRunnable != null) {
                    downloadRunnable.discard();
                }
            }
        }
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public void onProgress(long j) {
        if (this.L) {
            return;
        }
        this.n.q(j);
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public void onRetry(java.lang.Exception exc) {
        if (this.L) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "the task[%d] has already been paused, so pass the retry callback", java.lang.Integer.valueOf(this.u.getId()));
            }
        } else {
            int i = this.B;
            int i2 = i - 1;
            this.B = i2;
            if (i < 0) {
                com.liulishuo.filedownloader.util.FileDownloadLog.e(this, "valid retry times is less than 0(%d) for download task(%d)", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.u.getId()));
            }
            this.n.r(exc, this.B);
        }
    }

    public void pause() {
        this.L = true;
        com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable = this.F;
        if (downloadRunnable != null) {
            downloadRunnable.pause();
        }
        java.util.Iterator it = ((java.util.ArrayList) this.E.clone()).iterator();
        while (it.hasNext()) {
            com.liulishuo.filedownloader.download.DownloadRunnable downloadRunnable2 = (com.liulishuo.filedownloader.download.DownloadRunnable) it.next();
            if (downloadRunnable2 != null) {
                downloadRunnable2.pause();
            }
        }
    }

    public void pending() {
        g(this.y.findConnectionModel(this.u.getId()));
        this.n.onPending();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01c1 A[Catch: all -> 0x01f6, TryCatch #11 {all -> 0x01f6, blocks: (B:3:0x0003, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:25:0x0030, B:26:0x008d, B:28:0x0091, B:30:0x0096, B:116:0x009a, B:118:0x009e, B:33:0x00c6, B:35:0x00e2, B:44:0x0100, B:56:0x0136, B:58:0x013a, B:69:0x015f, B:71:0x0163, B:85:0x0167, B:87:0x0170, B:88:0x0174, B:90:0x0178, B:91:0x018b, B:100:0x018c, B:104:0x01bb, B:106:0x01c1, B:109:0x01c6), top: B:2:0x0003, inners: #15, #12, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d8  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel;
        try {
            android.os.Process.setThreadPriority(10);
            if (this.u.getStatus() != 1) {
                if (this.u.getStatus() != -2) {
                    onError(new java.lang.RuntimeException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("Task[%d] can't start the download runnable, because its status is %d not %d", java.lang.Integer.valueOf(this.u.getId()), java.lang.Byte.valueOf(this.u.getStatus()), (byte) 1)));
                } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(this.u.getId()));
                }
                this.n.b();
                if (!this.L) {
                    if (!this.M) {
                        try {
                            this.n.l();
                        } catch (java.io.IOException e) {
                            e = e;
                            this.n.n(e);
                            this.K.set(false);
                        }
                        this.K.set(false);
                    }
                    this.n.n(this.N);
                    this.K.set(false);
                }
                this.n.p();
                this.K.set(false);
            }
            if (!this.L) {
                this.n.s();
            }
            while (!this.L) {
                try {
                    c();
                    l();
                    b();
                    findConnectionModel = this.y.findConnectionModel(this.u.getId());
                    g(findConnectionModel);
                } catch (com.liulishuo.filedownloader.download.DownloadLaunchRunnable.DiscardSafely unused) {
                    this.n.b();
                    if (!this.L) {
                        if (!this.M) {
                            try {
                                this.n.l();
                            } catch (java.io.IOException e2) {
                                e = e2;
                                this.n.n(e);
                                this.K.set(false);
                            }
                        }
                    }
                } catch (com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly unused2) {
                    this.u.setStatus((byte) 5);
                } catch (com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException e3) {
                    e = e3;
                    if (isRetry(e)) {
                        onError(e);
                        this.n.b();
                        if (!this.L) {
                        }
                        this.K.set(false);
                        return;
                    }
                    onRetry(e);
                } catch (com.liulishuo.filedownloader.exception.FileDownloadSecurityException e4) {
                    e = e4;
                    if (isRetry(e)) {
                    }
                } catch (java.io.IOException e5) {
                    e = e5;
                    if (isRetry(e)) {
                    }
                } catch (java.lang.IllegalAccessException e6) {
                    e = e6;
                    if (isRetry(e)) {
                    }
                } catch (java.lang.IllegalArgumentException e7) {
                    e = e7;
                    if (isRetry(e)) {
                    }
                } catch (java.lang.InterruptedException e8) {
                    e = e8;
                    if (isRetry(e)) {
                    }
                }
                if (this.L) {
                    this.u.setStatus((byte) -2);
                    this.n.b();
                    if (!this.L) {
                        if (!this.M) {
                            try {
                                this.n.l();
                            } catch (java.io.IOException e9) {
                                e = e9;
                                this.n.n(e);
                                this.K.set(false);
                            }
                            this.K.set(false);
                        }
                        this.n.n(this.N);
                        this.K.set(false);
                    }
                    this.n.p();
                    this.K.set(false);
                }
                long total = this.u.getTotal();
                e(total, this.u.getTempFilePath());
                int a = a(total);
                if (a <= 0) {
                    throw new java.lang.IllegalAccessException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("invalid connection count %d, the connection count must be larger than 0", java.lang.Integer.valueOf(a)));
                }
                if (total == 0) {
                    this.n.b();
                    if (!this.L) {
                        if (!this.M) {
                            try {
                                this.n.l();
                            } catch (java.io.IOException e10) {
                                e = e10;
                                this.n.n(e);
                                this.K.set(false);
                            }
                            this.K.set(false);
                        }
                        this.n.n(this.N);
                        this.K.set(false);
                    }
                    this.n.p();
                    this.K.set(false);
                }
                if (this.L) {
                    this.u.setStatus((byte) -2);
                    this.n.b();
                    if (!this.L) {
                        if (!this.M) {
                            try {
                                this.n.l();
                            } catch (java.io.IOException e11) {
                                e = e11;
                                this.n.n(e);
                                this.K.set(false);
                            }
                            this.K.set(false);
                        }
                        this.n.n(this.N);
                        this.K.set(false);
                    }
                    this.n.p();
                    this.K.set(false);
                }
                boolean z = a == 1;
                this.G = z;
                if (z) {
                    k(total);
                } else {
                    this.n.o();
                    if (this.H) {
                        j(a, findConnectionModel);
                    } else {
                        i(total, a);
                    }
                }
                this.n.b();
                if (!this.L) {
                    this.n.p();
                } else if (this.M) {
                    this.n.n(this.N);
                } else {
                    try {
                        this.n.l();
                    } catch (java.io.IOException e12) {
                        this.n.n(e12);
                    }
                }
                this.K.set(false);
                return;
            }
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(this.u.getId()));
            }
            this.n.b();
            if (!this.L) {
                if (!this.M) {
                    try {
                        this.n.l();
                    } catch (java.io.IOException e13) {
                        e = e13;
                        this.n.n(e);
                        this.K.set(false);
                    }
                    this.K.set(false);
                }
                this.n.n(this.N);
                this.K.set(false);
            }
            this.n.p();
            this.K.set(false);
        } catch (java.lang.Throwable th) {
            this.n.b();
            if (this.L) {
                this.n.p();
            } else if (this.M) {
                this.n.n(this.N);
            } else {
                try {
                    this.n.l();
                } catch (java.io.IOException e14) {
                    this.n.n(e14);
                }
            }
            this.K.set(false);
            throw th;
        }
    }

    @Override // com.liulishuo.filedownloader.download.ProcessCallback
    public void syncProgressFromCache() {
        this.y.updateProgress(this.u.getId(), this.u.getSoFar());
    }
}

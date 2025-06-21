package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
class FileDownloadMessenger implements com.liulishuo.filedownloader.IFileDownloadMessenger {
    public com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask a;
    public com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback b;
    public java.util.Queue<com.liulishuo.filedownloader.message.MessageSnapshot> c;
    public boolean d = false;

    public FileDownloadMessenger(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask, com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback lifeCycleCallback) {
        p(iRunningTask, lifeCycleCallback);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void a(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify pending %s", this.a);
        }
        this.b.onIng();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void b(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify started %s", this.a);
        }
        this.b.onIng();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void c(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify paused %s", this.a);
        }
        this.b.onOver();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void d(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        com.liulishuo.filedownloader.BaseDownloadTask origin = this.a.getOrigin();
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify progress %s %d %d", origin, java.lang.Long.valueOf(origin.getLargeFileSoFarBytes()), java.lang.Long.valueOf(origin.getLargeFileTotalBytes()));
        }
        if (origin.getCallbackProgressTimes() > 0) {
            this.b.onIng();
            s(messageSnapshot);
        } else if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify progress but client not request notify %s", this.a);
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void e(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask, com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback lifeCycleCallback) {
        if (this.a != null) {
            throw new java.lang.IllegalStateException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("the messenger is working, can't re-appointment for %s", iRunningTask));
        }
        p(iRunningTask, lifeCycleCallback);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public boolean f() {
        return this.c.peek().getStatus() == 4;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void g() {
        this.d = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void h() {
        if (this.d) {
            return;
        }
        com.liulishuo.filedownloader.message.MessageSnapshot poll = this.c.poll();
        byte status = poll.getStatus();
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = this.a;
        if (iRunningTask == null) {
            throw new java.lang.IllegalArgumentException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("can't handover the message, no master to receive this message(status[%d]) size[%d]", java.lang.Integer.valueOf(status), java.lang.Integer.valueOf(this.c.size())));
        }
        com.liulishuo.filedownloader.BaseDownloadTask origin = iRunningTask.getOrigin();
        com.liulishuo.filedownloader.FileDownloadListener listener = origin.getListener();
        com.liulishuo.filedownloader.ITaskHunter.IMessageHandler messageHandler = iRunningTask.getMessageHandler();
        q(status);
        if (listener == null || listener.isInvalid()) {
            return;
        }
        if (status == 4) {
            try {
                listener.blockComplete(origin);
                r(((com.liulishuo.filedownloader.message.BlockCompleteMessage) poll).transmitToCompleted());
                return;
            } catch (java.lang.Throwable th) {
                j(messageHandler.prepareErrorMessage(th));
                return;
            }
        }
        com.liulishuo.filedownloader.FileDownloadLargeFileListener fileDownloadLargeFileListener = listener instanceof com.liulishuo.filedownloader.FileDownloadLargeFileListener ? (com.liulishuo.filedownloader.FileDownloadLargeFileListener) listener : null;
        if (status == -4) {
            listener.warn(origin);
            return;
        }
        if (status == -3) {
            listener.completed(origin);
            return;
        }
        if (status == -2) {
            if (fileDownloadLargeFileListener != null) {
                fileDownloadLargeFileListener.paused(origin, poll.getLargeSofarBytes(), poll.getLargeTotalBytes());
                return;
            } else {
                listener.paused(origin, poll.getSmallSofarBytes(), poll.getSmallTotalBytes());
                return;
            }
        }
        if (status == -1) {
            listener.error(origin, poll.getThrowable());
            return;
        }
        if (status == 1) {
            if (fileDownloadLargeFileListener != null) {
                fileDownloadLargeFileListener.pending(origin, poll.getLargeSofarBytes(), poll.getLargeTotalBytes());
                return;
            } else {
                listener.pending(origin, poll.getSmallSofarBytes(), poll.getSmallTotalBytes());
                return;
            }
        }
        if (status == 2) {
            if (fileDownloadLargeFileListener != null) {
                fileDownloadLargeFileListener.connected(origin, poll.getEtag(), poll.isResuming(), origin.getLargeFileSoFarBytes(), poll.getLargeTotalBytes());
                return;
            } else {
                listener.connected(origin, poll.getEtag(), poll.isResuming(), origin.getSmallFileSoFarBytes(), poll.getSmallTotalBytes());
                return;
            }
        }
        if (status == 3) {
            if (fileDownloadLargeFileListener != null) {
                fileDownloadLargeFileListener.progress(origin, poll.getLargeSofarBytes(), origin.getLargeFileTotalBytes());
                return;
            } else {
                listener.progress(origin, poll.getSmallSofarBytes(), origin.getSmallFileTotalBytes());
                return;
            }
        }
        if (status != 5) {
            if (status != 6) {
                return;
            }
            listener.started(origin);
        } else if (fileDownloadLargeFileListener != null) {
            fileDownloadLargeFileListener.retry(origin, poll.getThrowable(), poll.getRetryingTimes(), poll.getLargeSofarBytes());
        } else {
            listener.retry(origin, poll.getThrowable(), poll.getRetryingTimes(), poll.getSmallSofarBytes());
        }
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public boolean i() {
        return this.a.getOrigin().isSyncCallback();
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void j(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = this.a;
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify error %s %s", iRunningTask, iRunningTask.getOrigin().getErrorCause());
        }
        this.b.onOver();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void k(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.BaseDownloadTask origin = this.a.getOrigin();
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify retry %s %d %d %s", this.a, java.lang.Integer.valueOf(origin.getAutoRetryTimes()), java.lang.Integer.valueOf(origin.getRetryingTimes()), origin.getErrorCause());
        }
        this.b.onIng();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void l(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify connected %s", this.a);
        }
        this.b.onIng();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public boolean m() {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify begin %s", this.a);
        }
        if (this.a == null) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "can't begin the task, the holder fo the messenger is nil, %d", java.lang.Integer.valueOf(this.c.size()));
            return false;
        }
        this.b.onBegin();
        return true;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void n(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify warn %s", this.a);
        }
        this.b.onOver();
        s(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadMessenger
    public void o(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify block completed %s %s", this.a, java.lang.Thread.currentThread().getName());
        }
        this.b.onIng();
        s(messageSnapshot);
    }

    public final void p(com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask, com.liulishuo.filedownloader.BaseDownloadTask.LifeCycleCallback lifeCycleCallback) {
        this.a = iRunningTask;
        this.b = lifeCycleCallback;
        this.c = new java.util.concurrent.LinkedBlockingQueue();
    }

    public final void q(int i) {
        if (com.liulishuo.filedownloader.model.FileDownloadStatus.isOver(i)) {
            if (!this.c.isEmpty()) {
                com.liulishuo.filedownloader.message.MessageSnapshot peek = this.c.peek();
                com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, java.lang.Integer.valueOf(peek.getId()), java.lang.Integer.valueOf(this.c.size()), java.lang.Byte.valueOf(peek.getStatus()));
            }
            this.a = null;
        }
    }

    public void r(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "notify completed %s", this.a);
        }
        this.b.onOver();
        s(messageSnapshot);
    }

    public final void s(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = this.a;
        if (iRunningTask == null) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", java.lang.Integer.valueOf(messageSnapshot.getId()), java.lang.Byte.valueOf(messageSnapshot.getStatus()));
            }
        } else {
            if (!this.d && iRunningTask.getOrigin().getListener() != null) {
                this.c.offer(messageSnapshot);
                com.liulishuo.filedownloader.FileDownloadMessageStation.getImpl().g(this);
                return;
            }
            if ((com.liulishuo.filedownloader.FileDownloadMonitor.isValid() || this.a.isContainFinishListener()) && messageSnapshot.getStatus() == 4) {
                this.b.onOver();
            }
            q(messageSnapshot.getStatus());
        }
    }

    public java.lang.String toString() {
        java.lang.Object[] objArr = new java.lang.Object[2];
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask = this.a;
        objArr[0] = java.lang.Integer.valueOf(iRunningTask == null ? -1 : iRunningTask.getOrigin().getId());
        objArr[1] = super.toString();
        return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("%d:%s", objArr);
    }
}

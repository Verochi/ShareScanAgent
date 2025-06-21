package com.liulishuo.filedownloader;

/* loaded from: classes23.dex */
public class MessageSnapshotGate implements com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver {
    public final boolean a(java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> list, com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        boolean updateKeepAhead;
        if (list.size() > 1 && messageSnapshot.getStatus() == -3) {
            for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask : list) {
                synchronized (iRunningTask.getPauseLock()) {
                    if (iRunningTask.getMessageHandler().updateMoreLikelyCompleted(messageSnapshot)) {
                        com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "updateMoreLikelyCompleted", new java.lang.Object[0]);
                        return true;
                    }
                }
            }
        }
        for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask2 : list) {
            synchronized (iRunningTask2.getPauseLock()) {
                if (iRunningTask2.getMessageHandler().updateKeepFlow(messageSnapshot)) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "updateKeepFlow", new java.lang.Object[0]);
                    return true;
                }
            }
        }
        if (-4 == messageSnapshot.getStatus()) {
            for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask3 : list) {
                synchronized (iRunningTask3.getPauseLock()) {
                    if (iRunningTask3.getMessageHandler().updateSameFilePathTaskRunning(messageSnapshot)) {
                        com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "updateSampleFilePathTaskRunning", new java.lang.Object[0]);
                        return true;
                    }
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask4 = list.get(0);
        synchronized (iRunningTask4.getPauseLock()) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "updateKeepAhead", new java.lang.Object[0]);
            updateKeepAhead = iRunningTask4.getMessageHandler().updateKeepAhead(messageSnapshot);
        }
        return updateKeepAhead;
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver
    public void receive(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        synchronized (java.lang.Integer.toString(messageSnapshot.getId()).intern()) {
            java.util.List<com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask> i = com.liulishuo.filedownloader.FileDownloadList.getImpl().i(messageSnapshot.getId());
            if (i.size() > 0) {
                com.liulishuo.filedownloader.BaseDownloadTask origin = i.get(0).getOrigin();
                if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                    com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "~~~callback %s old[%s] new[%s] %d", java.lang.Integer.valueOf(messageSnapshot.getId()), java.lang.Byte.valueOf(origin.getStatus()), java.lang.Byte.valueOf(messageSnapshot.getStatus()), java.lang.Integer.valueOf(i.size()));
                }
                if (!a(i, messageSnapshot)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.getStatus()) + " task-count:" + i.size());
                    for (com.liulishuo.filedownloader.BaseDownloadTask.IRunningTask iRunningTask : i) {
                        sb.append(" | ");
                        sb.append((int) iRunningTask.getOrigin().getStatus());
                    }
                    com.liulishuo.filedownloader.util.FileDownloadLog.i(this, sb.toString(), new java.lang.Object[0]);
                }
            } else {
                com.liulishuo.filedownloader.util.FileDownloadLog.i(this, "Receive the event %d, but there isn't any running task in the upper layer", java.lang.Byte.valueOf(messageSnapshot.getStatus()));
            }
        }
    }
}

package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public class MessageSnapshotThreadPool {
    public final java.util.List<com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor> a = new java.util.ArrayList();
    public final com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver b;

    public class FlowSingleExecutor {
        public final java.util.List<java.lang.Integer> a = new java.util.ArrayList();
        public final java.util.concurrent.Executor b;

        /* renamed from: com.liulishuo.filedownloader.message.MessageSnapshotThreadPool$FlowSingleExecutor$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public final /* synthetic */ com.liulishuo.filedownloader.message.MessageSnapshot n;

            public AnonymousClass1(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
                this.n = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.this.b.receive(this.n);
                com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor.this.a.remove(java.lang.Integer.valueOf(this.n.getId()));
            }
        }

        public FlowSingleExecutor(int i) {
            this.b = com.liulishuo.filedownloader.util.FileDownloadExecutors.newDefaultThreadPool(1, "Flow-" + i);
        }

        public void enqueue(int i) {
            this.a.add(java.lang.Integer.valueOf(i));
        }

        public void execute(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
            this.b.execute(new com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor.AnonymousClass1(messageSnapshot));
        }
    }

    public MessageSnapshotThreadPool(int i, com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver messageReceiver) {
        this.b = messageReceiver;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.add(new com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor(i2));
        }
    }

    public void execute(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor flowSingleExecutor = null;
        try {
            synchronized (this.a) {
                int id = messageSnapshot.getId();
                java.util.Iterator<com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor next = it.next();
                    if (next.a.contains(java.lang.Integer.valueOf(id))) {
                        flowSingleExecutor = next;
                        break;
                    }
                }
                if (flowSingleExecutor == null) {
                    java.util.Iterator<com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor> it2 = this.a.iterator();
                    int i = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        com.liulishuo.filedownloader.message.MessageSnapshotThreadPool.FlowSingleExecutor next2 = it2.next();
                        if (next2.a.size() <= 0) {
                            flowSingleExecutor = next2;
                            break;
                        } else if (i == 0 || next2.a.size() < i) {
                            i = next2.a.size();
                            flowSingleExecutor = next2;
                        }
                    }
                }
                flowSingleExecutor.enqueue(id);
            }
        } finally {
            flowSingleExecutor.execute(messageSnapshot);
        }
    }
}

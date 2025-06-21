package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public class MessageSnapshotFlow {
    public volatile com.liulishuo.filedownloader.message.MessageSnapshotThreadPool a;
    public volatile com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver b;

    public static final class HolderClass {
        public static final com.liulishuo.filedownloader.message.MessageSnapshotFlow a = new com.liulishuo.filedownloader.message.MessageSnapshotFlow();
    }

    public interface MessageReceiver {
        void receive(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot);
    }

    public static com.liulishuo.filedownloader.message.MessageSnapshotFlow getImpl() {
        return com.liulishuo.filedownloader.message.MessageSnapshotFlow.HolderClass.a;
    }

    public void inflow(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.liulishuo.filedownloader.message.IFlowDirectly) {
            if (this.b != null) {
                this.b.receive(messageSnapshot);
            }
        } else if (this.a != null) {
            this.a.execute(messageSnapshot);
        }
    }

    public void setReceiver(com.liulishuo.filedownloader.message.MessageSnapshotFlow.MessageReceiver messageReceiver) {
        this.b = messageReceiver;
        if (messageReceiver == null) {
            this.a = null;
        } else {
            this.a = new com.liulishuo.filedownloader.message.MessageSnapshotThreadPool(5, messageReceiver);
        }
    }
}

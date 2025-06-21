package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public interface BlockCompleteMessage {

    public static class BlockCompleteMessageImpl extends com.liulishuo.filedownloader.message.MessageSnapshot implements com.liulishuo.filedownloader.message.BlockCompleteMessage {
        private final com.liulishuo.filedownloader.message.MessageSnapshot mCompletedSnapshot;

        public BlockCompleteMessageImpl(com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.getStatus() != -3) {
                throw new java.lang.IllegalArgumentException(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("can't create the block complete message for id[%d], status[%d]", java.lang.Integer.valueOf(messageSnapshot.getId()), java.lang.Byte.valueOf(messageSnapshot.getStatus())));
            }
            this.mCompletedSnapshot = messageSnapshot;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 4;
        }

        @Override // com.liulishuo.filedownloader.message.BlockCompleteMessage
        public com.liulishuo.filedownloader.message.MessageSnapshot transmitToCompleted() {
            return this.mCompletedSnapshot;
        }
    }

    com.liulishuo.filedownloader.message.MessageSnapshot transmitToCompleted();
}

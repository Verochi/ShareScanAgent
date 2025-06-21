package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public abstract class MessageSnapshot implements com.liulishuo.filedownloader.message.IMessageSnapshot, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.liulishuo.filedownloader.message.MessageSnapshot> CREATOR = new com.liulishuo.filedownloader.message.MessageSnapshot.AnonymousClass1();
    private final int id;
    protected boolean isLargeFile;

    /* renamed from: com.liulishuo.filedownloader.message.MessageSnapshot$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.liulishuo.filedownloader.message.MessageSnapshot> {
        /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public com.liulishuo.filedownloader.message.MessageSnapshot createFromParcel(android.os.Parcel parcel) {
            com.liulishuo.filedownloader.message.MessageSnapshot warnMessageSnapshot;
            com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot;
            boolean z = parcel.readByte() == 1;
            byte readByte = parcel.readByte();
            if (readByte == -4) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.WarnMessageSnapshot(parcel);
            } else if (readByte == -3) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.CompletedSnapshot(parcel);
            } else if (readByte == -1) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot(parcel);
            } else if (readByte == 1) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot(parcel);
            } else if (readByte == 2) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ConnectedMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ConnectedMessageSnapshot(parcel);
            } else if (readByte == 3) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.ProgressMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.ProgressMessageSnapshot(parcel);
            } else if (readByte == 5) {
                warnMessageSnapshot = z ? new com.liulishuo.filedownloader.message.LargeMessageSnapshot.RetryMessageSnapshot(parcel) : new com.liulishuo.filedownloader.message.SmallMessageSnapshot.RetryMessageSnapshot(parcel);
            } else {
                if (readByte != 6) {
                    messageSnapshot = null;
                    if (messageSnapshot == null) {
                        messageSnapshot.isLargeFile = z;
                        return messageSnapshot;
                    }
                    throw new java.lang.IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
                }
                warnMessageSnapshot = new com.liulishuo.filedownloader.message.MessageSnapshot.StartedMessageSnapshot(parcel);
            }
            messageSnapshot = warnMessageSnapshot;
            if (messageSnapshot == null) {
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.message.MessageSnapshot[] newArray(int i) {
            return new com.liulishuo.filedownloader.message.MessageSnapshot[i];
        }
    }

    public interface IWarnMessageSnapshot {
        com.liulishuo.filedownloader.message.MessageSnapshot turnToPending();
    }

    public static class NoFieldException extends java.lang.IllegalStateException {
        public NoFieldException(java.lang.String str, com.liulishuo.filedownloader.message.MessageSnapshot messageSnapshot) {
            super(com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("There isn't a field for '%s' in this message %d %d %s", str, java.lang.Integer.valueOf(messageSnapshot.getId()), java.lang.Byte.valueOf(messageSnapshot.getStatus()), messageSnapshot.getClass().getName()));
        }
    }

    public static class StartedMessageSnapshot extends com.liulishuo.filedownloader.message.MessageSnapshot {
        public StartedMessageSnapshot(int i) {
            super(i);
        }

        public StartedMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 6;
        }
    }

    public MessageSnapshot(int i) {
        this.id = i;
    }

    public MessageSnapshot(android.os.Parcel parcel) {
        this.id = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public java.lang.String getEtag() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getEtag", this);
    }

    public java.lang.String getFileName() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getFileName", this);
    }

    public int getId() {
        return this.id;
    }

    public long getLargeSofarBytes() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getLargeSofarBytes", this);
    }

    public long getLargeTotalBytes() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getLargeTotalBytes", this);
    }

    public int getRetryingTimes() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getRetryingTimes", this);
    }

    public int getSmallSofarBytes() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getSmallSofarBytes", this);
    }

    public int getSmallTotalBytes() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getSmallTotalBytes", this);
    }

    public abstract /* synthetic */ byte getStatus();

    public java.lang.Throwable getThrowable() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("getThrowable", this);
    }

    public boolean isLargeFile() {
        return this.isLargeFile;
    }

    public boolean isResuming() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("isResuming", this);
    }

    public boolean isReusedDownloadedFile() {
        throw new com.liulishuo.filedownloader.message.MessageSnapshot.NoFieldException("isReusedDownloadedFile", this);
    }

    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.isLargeFile ? (byte) 1 : (byte) 0);
        parcel.writeByte(getStatus());
        parcel.writeInt(this.id);
    }
}

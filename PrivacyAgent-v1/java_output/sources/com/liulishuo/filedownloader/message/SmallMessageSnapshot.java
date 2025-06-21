package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public abstract class SmallMessageSnapshot extends com.liulishuo.filedownloader.message.MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot.CompletedSnapshot implements com.liulishuo.filedownloader.message.IFlowDirectly {
        public CompletedFlowDirectlySnapshot(int i, boolean z, int i2) {
            super(i, z, i2);
        }

        public CompletedFlowDirectlySnapshot(android.os.Parcel parcel) {
            super(parcel);
        }
    }

    public static class CompletedSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final int totalBytes;

        public CompletedSnapshot(int i, boolean z, int i2) {
            super(i);
            this.reusedDownloadedFile = z;
            this.totalBytes = i2;
        }

        public CompletedSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean isReusedDownloadedFile() {
            return this.reusedDownloadedFile;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.reusedDownloadedFile ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
        }
    }

    public static class ConnectedMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot {
        private final java.lang.String etag;
        private final java.lang.String fileName;
        private final boolean resuming;
        private final int totalBytes;

        public ConnectedMessageSnapshot(int i, boolean z, int i2, java.lang.String str, java.lang.String str2) {
            super(i);
            this.resuming = z;
            this.totalBytes = i2;
            this.etag = str;
            this.fileName = str2;
        }

        public ConnectedMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readInt();
            this.etag = parcel.readString();
            this.fileName = parcel.readString();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public java.lang.String getEtag() {
            return this.etag;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public java.lang.String getFileName() {
            return this.fileName;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 2;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public boolean isResuming() {
            return this.resuming;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.resuming ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }
    }

    public static class ErrorMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot {
        private final int sofarBytes;
        private final java.lang.Throwable throwable;

        public ErrorMessageSnapshot(int i, int i2, java.lang.Throwable th) {
            super(i);
            this.sofarBytes = i2;
            this.throwable = th;
        }

        public ErrorMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.throwable = (java.lang.Throwable) parcel.readSerializable();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public java.lang.Throwable getThrowable() {
            return this.throwable;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }
    }

    public static class PausedSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot {
        public PausedSnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot {
        private final int sofarBytes;
        private final int totalBytes;

        public PendingMessageSnapshot(int i, int i2, int i3) {
            super(i);
            this.sofarBytes = i2;
            this.totalBytes = i3;
        }

        public PendingMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
            this.totalBytes = parcel.readInt();
        }

        public PendingMessageSnapshot(com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.getId(), pendingMessageSnapshot.getSmallSofarBytes(), pendingMessageSnapshot.getSmallTotalBytes());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
            parcel.writeInt(this.totalBytes);
        }
    }

    public static class ProgressMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot {
        private final int sofarBytes;

        public ProgressMessageSnapshot(int i, int i2) {
            super(i);
            this.sofarBytes = i2;
        }

        public ProgressMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getSmallSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sofarBytes);
        }
    }

    public static class RetryMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i, int i2, java.lang.Throwable th, int i3) {
            super(i, i2, th);
            this.retryingTimes = i3;
        }

        public RetryMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getRetryingTimes() {
            return this.retryingTimes;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.retryingTimes);
        }
    }

    public static class WarnFlowDirectlySnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot.WarnMessageSnapshot implements com.liulishuo.filedownloader.message.IFlowDirectly {
        public WarnFlowDirectlySnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public WarnFlowDirectlySnapshot(android.os.Parcel parcel) {
            super(parcel);
        }
    }

    public static class WarnMessageSnapshot extends com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot implements com.liulishuo.filedownloader.message.MessageSnapshot.IWarnMessageSnapshot {
        public WarnMessageSnapshot(int i, int i2, int i3) {
            super(i, i2, i3);
        }

        public WarnMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
        }

        @Override // com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.SmallMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -4;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.IWarnMessageSnapshot
        public com.liulishuo.filedownloader.message.MessageSnapshot turnToPending() {
            return new com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot(this);
        }
    }

    public SmallMessageSnapshot(int i) {
        super(i);
        this.isLargeFile = false;
    }

    public SmallMessageSnapshot(android.os.Parcel parcel) {
        super(parcel);
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long getLargeSofarBytes() {
        return getSmallSofarBytes();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public long getLargeTotalBytes() {
        return getSmallTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public abstract /* synthetic */ byte getStatus();
}

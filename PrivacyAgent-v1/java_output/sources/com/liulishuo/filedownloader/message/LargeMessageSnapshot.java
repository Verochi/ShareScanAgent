package com.liulishuo.filedownloader.message;

/* loaded from: classes23.dex */
public abstract class LargeMessageSnapshot extends com.liulishuo.filedownloader.message.MessageSnapshot {

    public static class CompletedFlowDirectlySnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot implements com.liulishuo.filedownloader.message.IFlowDirectly {
        public CompletedFlowDirectlySnapshot(int i, boolean z, long j) {
            super(i, z, j);
        }

        public CompletedFlowDirectlySnapshot(android.os.Parcel parcel) {
            super(parcel);
        }
    }

    public static class CompletedSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot {
        private final boolean reusedDownloadedFile;
        private final long totalBytes;

        public CompletedSnapshot(int i, boolean z, long j) {
            super(i);
            this.reusedDownloadedFile = z;
            this.totalBytes = j;
        }

        public CompletedSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.reusedDownloadedFile = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long getLargeTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
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
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class ConnectedMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot {
        private final java.lang.String etag;
        private final java.lang.String fileName;
        private final boolean resuming;
        private final long totalBytes;

        public ConnectedMessageSnapshot(int i, boolean z, long j, java.lang.String str, java.lang.String str2) {
            super(i);
            this.resuming = z;
            this.totalBytes = j;
            this.etag = str;
            this.fileName = str2;
        }

        public ConnectedMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.resuming = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
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
        public long getLargeTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
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
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.etag);
            parcel.writeString(this.fileName);
        }
    }

    public static class ErrorMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot {
        private final long sofarBytes;
        private final java.lang.Throwable throwable;

        public ErrorMessageSnapshot(int i, long j, java.lang.Throwable th) {
            super(i);
            this.sofarBytes = j;
            this.throwable = th;
        }

        public ErrorMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.throwable = (java.lang.Throwable) parcel.readSerializable();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long getLargeSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
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
            parcel.writeLong(this.sofarBytes);
            parcel.writeSerializable(this.throwable);
        }
    }

    public static class PausedSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot {
        public PausedSnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -2;
        }
    }

    public static class PendingMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot {
        private final long sofarBytes;
        private final long totalBytes;

        public PendingMessageSnapshot(int i, long j, long j2) {
            super(i);
            this.sofarBytes = j;
            this.totalBytes = j2;
        }

        public PendingMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }

        public PendingMessageSnapshot(com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot pendingMessageSnapshot) {
            this(pendingMessageSnapshot.getId(), pendingMessageSnapshot.getLargeSofarBytes(), pendingMessageSnapshot.getLargeTotalBytes());
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long getLargeSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long getLargeTotalBytes() {
            return this.totalBytes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 1;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.sofarBytes);
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class ProgressMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot {
        private final long sofarBytes;

        public ProgressMessageSnapshot(int i, long j) {
            super(i);
            this.sofarBytes = j;
        }

        public ProgressMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.sofarBytes = parcel.readLong();
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public long getLargeSofarBytes() {
            return this.sofarBytes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 3;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.sofarBytes);
        }
    }

    public static class RetryMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot {
        private final int retryingTimes;

        public RetryMessageSnapshot(int i, long j, java.lang.Throwable th, int i2) {
            super(i, j, th);
            this.retryingTimes = i2;
        }

        public RetryMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
            this.retryingTimes = parcel.readInt();
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot
        public int getRetryingTimes() {
            return this.retryingTimes;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) 5;
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.retryingTimes);
        }
    }

    public static class WarnFlowDirectlySnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot implements com.liulishuo.filedownloader.message.IFlowDirectly {
        public WarnFlowDirectlySnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        public WarnFlowDirectlySnapshot(android.os.Parcel parcel) {
            super(parcel);
        }
    }

    public static class WarnMessageSnapshot extends com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot implements com.liulishuo.filedownloader.message.MessageSnapshot.IWarnMessageSnapshot {
        public WarnMessageSnapshot(int i, long j, long j2) {
            super(i, j, j2);
        }

        public WarnMessageSnapshot(android.os.Parcel parcel) {
            super(parcel);
        }

        @Override // com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot, com.liulishuo.filedownloader.message.LargeMessageSnapshot, com.liulishuo.filedownloader.message.MessageSnapshot
        public byte getStatus() {
            return (byte) -4;
        }

        @Override // com.liulishuo.filedownloader.message.MessageSnapshot.IWarnMessageSnapshot
        public com.liulishuo.filedownloader.message.MessageSnapshot turnToPending() {
            return new com.liulishuo.filedownloader.message.LargeMessageSnapshot.PendingMessageSnapshot(this);
        }
    }

    public LargeMessageSnapshot(int i) {
        super(i);
        this.isLargeFile = true;
    }

    public LargeMessageSnapshot(android.os.Parcel parcel) {
        super(parcel);
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int getSmallSofarBytes() {
        if (getLargeSofarBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) getLargeSofarBytes();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public int getSmallTotalBytes() {
        if (getLargeTotalBytes() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) getLargeTotalBytes();
    }

    @Override // com.liulishuo.filedownloader.message.MessageSnapshot
    public abstract /* synthetic */ byte getStatus();
}

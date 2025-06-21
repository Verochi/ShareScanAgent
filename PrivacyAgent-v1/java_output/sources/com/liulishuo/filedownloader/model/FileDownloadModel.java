package com.liulishuo.filedownloader.model;

/* loaded from: classes23.dex */
public class FileDownloadModel implements android.os.Parcelable {
    public static final java.lang.String CONNECTION_COUNT = "connectionCount";
    public static final android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadModel> CREATOR = new com.liulishuo.filedownloader.model.FileDownloadModel.AnonymousClass1();
    public static final int DEFAULT_CALLBACK_PROGRESS_TIMES = 100;
    public static final java.lang.String ERR_MSG = "errMsg";
    public static final java.lang.String ETAG = "etag";
    public static final java.lang.String FILENAME = "filename";
    public static final java.lang.String ID = "_id";
    public static final java.lang.String PATH = "path";
    public static final java.lang.String PATH_AS_DIRECTORY = "pathAsDirectory";
    public static final java.lang.String SOFAR = "sofar";
    public static final java.lang.String STATUS = "status";
    public static final java.lang.String TOTAL = "total";
    public static final int TOTAL_VALUE_IN_CHUNKED_RESOURCE = -1;
    public static final java.lang.String URL = "url";
    private int connectionCount;
    private java.lang.String eTag;
    private java.lang.String errMsg;
    private java.lang.String filename;
    private int id;
    private boolean isLargeFile;
    private java.lang.String path;
    private boolean pathAsDirectory;
    private final java.util.concurrent.atomic.AtomicLong soFar;
    private final java.util.concurrent.atomic.AtomicInteger status;
    private long total;
    private java.lang.String url;

    /* renamed from: com.liulishuo.filedownloader.model.FileDownloadModel$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadModel> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadModel createFromParcel(android.os.Parcel parcel) {
            return new com.liulishuo.filedownloader.model.FileDownloadModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadModel[] newArray(int i) {
            return new com.liulishuo.filedownloader.model.FileDownloadModel[i];
        }
    }

    public FileDownloadModel() {
        this.soFar = new java.util.concurrent.atomic.AtomicLong();
        this.status = new java.util.concurrent.atomic.AtomicInteger();
    }

    public FileDownloadModel(android.os.Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.pathAsDirectory = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.status = new java.util.concurrent.atomic.AtomicInteger(parcel.readByte());
        this.soFar = new java.util.concurrent.atomic.AtomicLong(parcel.readLong());
        this.total = parcel.readLong();
        this.errMsg = parcel.readString();
        this.eTag = parcel.readString();
        this.connectionCount = parcel.readInt();
        this.isLargeFile = parcel.readByte() != 0;
    }

    public void deleteTargetFile() {
        java.lang.String targetFilePath = getTargetFilePath();
        if (targetFilePath != null) {
            java.io.File file = new java.io.File(targetFilePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public void deleteTaskFiles() {
        deleteTempFile();
        deleteTargetFile();
    }

    public void deleteTempFile() {
        java.lang.String tempFilePath = getTempFilePath();
        if (tempFilePath != null) {
            java.io.File file = new java.io.File(tempFilePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectionCount() {
        return this.connectionCount;
    }

    public java.lang.String getETag() {
        return this.eTag;
    }

    public java.lang.String getErrMsg() {
        return this.errMsg;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public int getId() {
        return this.id;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public long getSoFar() {
        return this.soFar.get();
    }

    public byte getStatus() {
        return (byte) this.status.get();
    }

    public java.lang.String getTargetFilePath() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.getTargetFilePath(getPath(), isPathAsDirectory(), getFilename());
    }

    public java.lang.String getTempFilePath() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return com.liulishuo.filedownloader.util.FileDownloadUtils.getTempPath(getTargetFilePath());
    }

    public long getTotal() {
        return this.total;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void increaseSoFar(long j) {
        this.soFar.addAndGet(j);
    }

    public boolean isChunked() {
        return this.total == -1;
    }

    public boolean isLargeFile() {
        return this.isLargeFile;
    }

    public boolean isPathAsDirectory() {
        return this.pathAsDirectory;
    }

    public void resetConnectionCount() {
        this.connectionCount = 1;
    }

    public void setConnectionCount(int i) {
        this.connectionCount = i;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setErrMsg(java.lang.String str) {
        this.errMsg = str;
    }

    public void setFilename(java.lang.String str) {
        this.filename = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setPath(java.lang.String str, boolean z) {
        this.path = str;
        this.pathAsDirectory = z;
    }

    public void setSoFar(long j) {
        this.soFar.set(j);
    }

    public void setStatus(byte b) {
        this.status.set(b);
    }

    public void setTotal(long j) {
        this.isLargeFile = j > 2147483647L;
        this.total = j;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    public android.content.ContentValues toContentValues() {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_id", java.lang.Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", java.lang.Byte.valueOf(getStatus()));
        contentValues.put(SOFAR, java.lang.Long.valueOf(getSoFar()));
        contentValues.put(TOTAL, java.lang.Long.valueOf(getTotal()));
        contentValues.put(ERR_MSG, getErrMsg());
        contentValues.put(ETAG, getETag());
        contentValues.put(CONNECTION_COUNT, java.lang.Integer.valueOf(getConnectionCount()));
        contentValues.put(PATH_AS_DIRECTORY, java.lang.Boolean.valueOf(isPathAsDirectory()));
        if (isPathAsDirectory() && getFilename() != null) {
            contentValues.put(FILENAME, getFilename());
        }
        return contentValues;
    }

    public java.lang.String toString() {
        return com.liulishuo.filedownloader.util.FileDownloadUtils.formatString("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", java.lang.Integer.valueOf(this.id), this.url, this.path, java.lang.Integer.valueOf(this.status.get()), this.soFar, java.lang.Long.valueOf(this.total), this.eTag, super.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeByte(this.pathAsDirectory ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.status.get());
        parcel.writeLong(this.soFar.get());
        parcel.writeLong(this.total);
        parcel.writeString(this.errMsg);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.connectionCount);
        parcel.writeByte(this.isLargeFile ? (byte) 1 : (byte) 0);
    }
}

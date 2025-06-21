package com.liulishuo.filedownloader.model;

/* loaded from: classes23.dex */
public class FileDownloadTaskAtom implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadTaskAtom> CREATOR = new com.liulishuo.filedownloader.model.FileDownloadTaskAtom.AnonymousClass1();
    private int id;
    private java.lang.String path;
    private long totalBytes;
    private java.lang.String url;

    /* renamed from: com.liulishuo.filedownloader.model.FileDownloadTaskAtom$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadTaskAtom> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadTaskAtom createFromParcel(android.os.Parcel parcel) {
            return new com.liulishuo.filedownloader.model.FileDownloadTaskAtom(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadTaskAtom[] newArray(int i) {
            return new com.liulishuo.filedownloader.model.FileDownloadTaskAtom[i];
        }
    }

    public FileDownloadTaskAtom(android.os.Parcel parcel) {
        this.url = parcel.readString();
        this.path = parcel.readString();
        this.totalBytes = parcel.readLong();
    }

    public FileDownloadTaskAtom(java.lang.String str, java.lang.String str2, long j) {
        setUrl(str);
        setPath(str2);
        setTotalBytes(j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        int i = this.id;
        if (i != 0) {
            return i;
        }
        int generateId = com.liulishuo.filedownloader.util.FileDownloadUtils.generateId(getUrl(), getPath());
        this.id = generateId;
        return generateId;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeString(this.path);
        parcel.writeLong(this.totalBytes);
    }
}

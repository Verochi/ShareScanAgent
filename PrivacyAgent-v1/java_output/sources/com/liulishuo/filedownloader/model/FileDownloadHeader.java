package com.liulishuo.filedownloader.model;

/* loaded from: classes23.dex */
public class FileDownloadHeader implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadHeader> CREATOR = new com.liulishuo.filedownloader.model.FileDownloadHeader.AnonymousClass1();
    private java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> mHeaderMap;

    /* renamed from: com.liulishuo.filedownloader.model.FileDownloadHeader$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.liulishuo.filedownloader.model.FileDownloadHeader> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadHeader createFromParcel(android.os.Parcel parcel) {
            return new com.liulishuo.filedownloader.model.FileDownloadHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadHeader[] newArray(int i) {
            return new com.liulishuo.filedownloader.model.FileDownloadHeader[i];
        }
    }

    public FileDownloadHeader() {
    }

    public FileDownloadHeader(android.os.Parcel parcel) {
        this.mHeaderMap = parcel.readHashMap(java.lang.String.class.getClassLoader());
    }

    public void add(java.lang.String str) {
        java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        add(split[0].trim(), split[1].trim());
    }

    public void add(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (str.isEmpty()) {
            throw new java.lang.IllegalArgumentException("name is empty");
        }
        if (str2 == null) {
            throw new java.lang.NullPointerException("value == null");
        }
        if (this.mHeaderMap == null) {
            this.mHeaderMap = new java.util.HashMap<>();
        }
        java.util.List<java.lang.String> list = this.mHeaderMap.get(str);
        if (list == null) {
            list = new java.util.ArrayList<>();
            this.mHeaderMap.put(str, list);
        }
        if (list.contains(str2)) {
            return;
        }
        list.add(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> getHeaders() {
        return this.mHeaderMap;
    }

    public void removeAll(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> hashMap = this.mHeaderMap;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(str);
    }

    public java.lang.String toString() {
        return this.mHeaderMap.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeMap(this.mHeaderMap);
    }
}

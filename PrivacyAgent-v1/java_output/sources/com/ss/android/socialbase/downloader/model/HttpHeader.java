package com.ss.android.socialbase.downloader.model;

/* loaded from: classes19.dex */
public class HttpHeader implements android.os.Parcelable, java.lang.Comparable {
    public static final android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.HttpHeader> CREATOR = new com.ss.android.socialbase.downloader.model.HttpHeader.AnonymousClass1();
    private final java.lang.String name;
    private final java.lang.String value;

    /* renamed from: com.ss.android.socialbase.downloader.model.HttpHeader$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.model.HttpHeader> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.HttpHeader createFromParcel(android.os.Parcel parcel) {
            return new com.ss.android.socialbase.downloader.model.HttpHeader(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.model.HttpHeader[] newArray(int i) {
            return new com.ss.android.socialbase.downloader.model.HttpHeader[i];
        }
    }

    public HttpHeader(android.os.Parcel parcel) {
        this.name = parcel.readString();
        this.value = parcel.readString();
    }

    public HttpHeader(java.lang.String str, java.lang.String str2) {
        this.name = str;
        this.value = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(java.lang.Object obj) {
        if (!(obj instanceof com.ss.android.socialbase.downloader.model.HttpHeader)) {
            return 1;
        }
        com.ss.android.socialbase.downloader.model.HttpHeader httpHeader = (com.ss.android.socialbase.downloader.model.HttpHeader) obj;
        if (android.text.TextUtils.equals(this.name, httpHeader.getName())) {
            return 0;
        }
        java.lang.String str = this.name;
        if (str == null) {
            return -1;
        }
        int compareTo = str.compareTo(httpHeader.getName());
        if (compareTo > 0) {
            return 1;
        }
        return compareTo < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.ss.android.socialbase.downloader.model.HttpHeader httpHeader = (com.ss.android.socialbase.downloader.model.HttpHeader) obj;
            if (android.text.TextUtils.equals(this.name, httpHeader.name) && android.text.TextUtils.equals(this.value, httpHeader.value)) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public int hashCode() {
        java.lang.String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        java.lang.String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "HttpHeader{name='" + this.name + "', value='" + this.value + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }
}

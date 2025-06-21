package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class BaseException extends java.lang.Exception implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.exception.BaseException> CREATOR = new com.ss.android.socialbase.downloader.exception.BaseException.AnonymousClass1();
    private static final java.lang.String TAG = "[d-ex]:";
    private int errorCode;
    private java.lang.String errorMsg;
    private java.lang.String extraInfo;

    /* renamed from: com.ss.android.socialbase.downloader.exception.BaseException$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.ss.android.socialbase.downloader.exception.BaseException> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.exception.BaseException createFromParcel(android.os.Parcel parcel) {
            return new com.ss.android.socialbase.downloader.exception.BaseException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.ss.android.socialbase.downloader.exception.BaseException[] newArray(int i) {
            return new com.ss.android.socialbase.downloader.exception.BaseException[i];
        }
    }

    public BaseException() {
        this.extraInfo = "";
    }

    public BaseException(int i, java.lang.String str) {
        super(TAG.concat(java.lang.String.valueOf(str)));
        this.extraInfo = "";
        this.errorMsg = TAG.concat(java.lang.String.valueOf(str));
        this.errorCode = i;
    }

    public BaseException(int i, java.lang.String str, java.lang.Throwable th) {
        super(TAG.concat(java.lang.String.valueOf(str)), th);
        this.extraInfo = "";
        this.errorMsg = TAG.concat(java.lang.String.valueOf(str));
        this.errorCode = i;
    }

    public BaseException(int i, java.lang.Throwable th) {
        this(i, com.ss.android.socialbase.downloader.utils.DownloadUtils.getThrowableMsg(th));
    }

    public BaseException(android.os.Parcel parcel) {
        this.extraInfo = "";
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public java.lang.String getErrorMessage() {
        return this.errorMsg;
    }

    public java.lang.String getExtraInfo() {
        return this.extraInfo;
    }

    public void readFromParcel(android.os.Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
        this.extraInfo = parcel.readString();
    }

    public void setErrorMsg(java.lang.String str) {
        this.errorMsg = str;
    }

    public void setExtraInfo(java.lang.String str) {
        this.extraInfo = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
        parcel.writeString(this.extraInfo);
    }
}

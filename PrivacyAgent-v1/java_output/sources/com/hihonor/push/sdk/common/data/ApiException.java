package com.hihonor.push.sdk.common.data;

/* loaded from: classes22.dex */
public class ApiException extends java.lang.Exception implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.hihonor.push.sdk.common.data.ApiException> CREATOR = new com.hihonor.push.sdk.common.data.ApiException.AnonymousClass1();
    public int errorCode;
    public java.lang.String message;

    /* renamed from: com.hihonor.push.sdk.common.data.ApiException$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.hihonor.push.sdk.common.data.ApiException> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.sdk.common.data.ApiException createFromParcel(android.os.Parcel parcel) {
            return new com.hihonor.push.sdk.common.data.ApiException(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.hihonor.push.sdk.common.data.ApiException[] newArray(int i) {
            return new com.hihonor.push.sdk.common.data.ApiException[i];
        }
    }

    public ApiException(int i) {
        initData(i, null);
    }

    public ApiException(int i, java.lang.String str) {
        initData(i, str);
    }

    public ApiException(android.os.Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.message = parcel.readString();
    }

    private void initData(int i, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            this.errorCode = i;
            this.message = str;
        } else {
            com.hihonor.push.sdk.common.data.ErrorEnum fromCode = com.hihonor.push.sdk.common.data.ErrorEnum.fromCode(i);
            this.errorCode = fromCode.getErrorCode();
            this.message = fromCode.getMessage();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.message;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.message);
    }
}

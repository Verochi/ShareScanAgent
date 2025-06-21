package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class TextObject extends com.sina.weibo.sdk.api.MediaObject {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.TextObject> CREATOR = new com.sina.weibo.sdk.api.TextObject.AnonymousClass1();
    private static final long serialVersionUID = -5610314414793811821L;
    public java.lang.String text;

    /* renamed from: com.sina.weibo.sdk.api.TextObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.TextObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.TextObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.TextObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.TextObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.TextObject[i];
        }
    }

    public TextObject() {
    }

    public TextObject(android.os.Parcel parcel) {
        this.text = parcel.readString();
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.text);
    }
}

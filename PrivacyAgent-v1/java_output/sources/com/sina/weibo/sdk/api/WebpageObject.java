package com.sina.weibo.sdk.api;

/* loaded from: classes19.dex */
public class WebpageObject extends com.sina.weibo.sdk.api.MediaObject {
    public static final android.os.Parcelable.Creator<com.sina.weibo.sdk.api.WebpageObject> CREATOR = new com.sina.weibo.sdk.api.WebpageObject.AnonymousClass1();
    private static final long serialVersionUID = 7142128794153927442L;
    public java.lang.String defaultText;

    /* renamed from: com.sina.weibo.sdk.api.WebpageObject$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.sina.weibo.sdk.api.WebpageObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.WebpageObject createFromParcel(android.os.Parcel parcel) {
            return new com.sina.weibo.sdk.api.WebpageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final com.sina.weibo.sdk.api.WebpageObject[] newArray(int i) {
            return new com.sina.weibo.sdk.api.WebpageObject[i];
        }
    }

    public WebpageObject() {
    }

    public WebpageObject(android.os.Parcel parcel) {
        super(parcel);
    }

    @Override // com.sina.weibo.sdk.api.MediaObject, android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }
}

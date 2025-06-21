package com.huawei.hms.support.api.client;

/* loaded from: classes22.dex */
public final class Status extends com.huawei.hms.support.api.client.Result implements android.os.Parcelable {

    @com.huawei.hms.core.aidl.annotation.Packed
    private android.content.Intent intent;

    @com.huawei.hms.core.aidl.annotation.Packed
    private android.app.PendingIntent pendingIntent;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int statusCode;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String statusMessage;
    public static final com.huawei.hms.support.api.client.Status SUCCESS = new com.huawei.hms.support.api.client.Status(0);
    public static final com.huawei.hms.support.api.client.Status FAILURE = new com.huawei.hms.support.api.client.Status(1);

    @java.lang.Deprecated
    public static final com.huawei.hms.support.api.client.Status RESULT_CANCELED = new com.huawei.hms.support.api.client.Status(16);

    @java.lang.Deprecated
    public static final com.huawei.hms.support.api.client.Status RESULT_DEAD_CLIENT = new com.huawei.hms.support.api.client.Status(18);

    @java.lang.Deprecated
    public static final com.huawei.hms.support.api.client.Status RESULT_INTERNAL_ERROR = new com.huawei.hms.support.api.client.Status(8);

    @java.lang.Deprecated
    public static final com.huawei.hms.support.api.client.Status RESULT_INTERRUPTED = new com.huawei.hms.support.api.client.Status(14);

    @java.lang.Deprecated
    public static final com.huawei.hms.support.api.client.Status RESULT_TIMEOUT = new com.huawei.hms.support.api.client.Status(15);
    public static final com.huawei.hms.support.api.client.Status MessageNotFound = new com.huawei.hms.support.api.client.Status(404);
    public static final com.huawei.hms.support.api.client.Status CoreException = new com.huawei.hms.support.api.client.Status(500);
    public static final android.os.Parcelable.Creator<com.huawei.hms.support.api.client.Status> CREATOR = new com.huawei.hms.support.api.client.Status.a();

    public static class a implements android.os.Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.client.Status createFromParcel(android.os.Parcel parcel) {
            return new com.huawei.hms.support.api.client.Status(parcel.readInt(), parcel.readString(), android.app.PendingIntent.readPendingIntentOrNullFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.client.Status[] newArray(int i) {
            return new com.huawei.hms.support.api.client.Status[i];
        }
    }

    public Status(int i) {
        this(i, null);
    }

    public Status(int i, java.lang.String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    public Status(int i, java.lang.String str, android.app.PendingIntent pendingIntent) {
        this.statusCode = i;
        this.statusMessage = str;
        this.pendingIntent = pendingIntent;
    }

    public Status(int i, java.lang.String str, android.content.Intent intent) {
        this.statusCode = i;
        this.statusMessage = str;
        this.intent = intent;
    }

    private static boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.huawei.hms.support.api.client.Status)) {
            return false;
        }
        com.huawei.hms.support.api.client.Status status = (com.huawei.hms.support.api.client.Status) obj;
        return this.statusCode == status.statusCode && equal(this.statusMessage, status.statusMessage) && equal(this.pendingIntent, status.pendingIntent) && equal(this.intent, status.intent);
    }

    public java.lang.String getErrorString() {
        return getStatusMessage();
    }

    public android.app.PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public android.content.Intent getResolutionIntent() {
        return this.intent;
    }

    @Override // com.huawei.hms.support.api.client.Result
    public com.huawei.hms.support.api.client.Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public java.lang.String getStatusMessage() {
        return this.statusMessage;
    }

    public boolean hasResolution() {
        return (this.pendingIntent == null && this.intent == null) ? false : true;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.statusCode), this.statusMessage, this.pendingIntent, this.intent});
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isInterrupted() {
        return false;
    }

    public boolean isSuccess() {
        return this.statusCode <= 0;
    }

    public void setIntent(android.content.Intent intent) {
        this.intent = intent;
    }

    public void setPendingIntent(android.app.PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public void startResolutionForResult(android.app.Activity activity, int i) throws android.content.IntentSender.SendIntentException {
        if (hasResolution()) {
            android.app.PendingIntent pendingIntent = this.pendingIntent;
            if (pendingIntent != null) {
                activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
            } else {
                activity.startActivityForResult(this.intent, i);
            }
        }
    }

    public java.lang.String toString() {
        return "{statusCode: " + this.statusCode + ", statusMessage: " + this.statusMessage + ", pendingIntent: " + this.pendingIntent + ", intent: " + this.intent + ",}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.statusMessage);
        android.app.PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent != null) {
            pendingIntent.writeToParcel(parcel, i);
        }
        android.app.PendingIntent.writePendingIntentOrNullToParcel(this.pendingIntent, parcel);
        android.content.Intent intent = this.intent;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}

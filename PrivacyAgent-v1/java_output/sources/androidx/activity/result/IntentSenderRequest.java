package androidx.activity.result;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements android.os.Parcelable {

    @androidx.annotation.NonNull
    public static final android.os.Parcelable.Creator<androidx.activity.result.IntentSenderRequest> CREATOR = new androidx.activity.result.IntentSenderRequest.AnonymousClass1();

    @androidx.annotation.Nullable
    private final android.content.Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;

    @androidx.annotation.NonNull
    private final android.content.IntentSender mIntentSender;

    /* renamed from: androidx.activity.result.IntentSenderRequest$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.activity.result.IntentSenderRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.IntentSenderRequest createFromParcel(android.os.Parcel parcel) {
            return new androidx.activity.result.IntentSenderRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.IntentSenderRequest[] newArray(int i) {
            return new androidx.activity.result.IntentSenderRequest[i];
        }
    }

    public static final class Builder {
        private android.content.Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private android.content.IntentSender mIntentSender;

        public Builder(@androidx.annotation.NonNull android.app.PendingIntent pendingIntent) {
            this(pendingIntent.getIntentSender());
        }

        public Builder(@androidx.annotation.NonNull android.content.IntentSender intentSender) {
            this.mIntentSender = intentSender;
        }

        @androidx.annotation.NonNull
        public androidx.activity.result.IntentSenderRequest build() {
            return new androidx.activity.result.IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        @androidx.annotation.NonNull
        public androidx.activity.result.IntentSenderRequest.Builder setFillInIntent(@androidx.annotation.Nullable android.content.Intent intent) {
            this.mFillInIntent = intent;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.activity.result.IntentSenderRequest.Builder setFlags(int i, int i2) {
            this.mFlagsValues = i;
            this.mFlagsMask = i2;
            return this;
        }
    }

    public IntentSenderRequest(@androidx.annotation.NonNull android.content.IntentSender intentSender, @androidx.annotation.Nullable android.content.Intent intent, int i, int i2) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = i;
        this.mFlagsValues = i2;
    }

    public IntentSenderRequest(@androidx.annotation.NonNull android.os.Parcel parcel) {
        this.mIntentSender = (android.content.IntentSender) parcel.readParcelable(android.content.IntentSender.class.getClassLoader());
        this.mFillInIntent = (android.content.Intent) parcel.readParcelable(android.content.Intent.class.getClassLoader());
        this.mFlagsMask = parcel.readInt();
        this.mFlagsValues = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @androidx.annotation.Nullable
    public android.content.Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    @androidx.annotation.NonNull
    public android.content.IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.mIntentSender, i);
        parcel.writeParcelable(this.mFillInIntent, i);
        parcel.writeInt(this.mFlagsMask);
        parcel.writeInt(this.mFlagsValues);
    }
}

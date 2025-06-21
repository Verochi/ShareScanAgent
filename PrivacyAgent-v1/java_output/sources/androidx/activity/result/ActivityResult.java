package androidx.activity.result;

@android.annotation.SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements android.os.Parcelable {

    @androidx.annotation.NonNull
    public static final android.os.Parcelable.Creator<androidx.activity.result.ActivityResult> CREATOR = new androidx.activity.result.ActivityResult.AnonymousClass1();

    @androidx.annotation.Nullable
    private final android.content.Intent mData;
    private final int mResultCode;

    /* renamed from: androidx.activity.result.ActivityResult$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.activity.result.ActivityResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.ActivityResult createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return new androidx.activity.result.ActivityResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.activity.result.ActivityResult[] newArray(int i) {
            return new androidx.activity.result.ActivityResult[i];
        }
    }

    public ActivityResult(int i, @androidx.annotation.Nullable android.content.Intent intent) {
        this.mResultCode = i;
        this.mData = intent;
    }

    public ActivityResult(android.os.Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (android.content.Intent) android.content.Intent.CREATOR.createFromParcel(parcel);
    }

    @androidx.annotation.NonNull
    public static java.lang.String resultCodeToString(int i) {
        return i != -1 ? i != 0 ? java.lang.String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @androidx.annotation.Nullable
    public android.content.Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public java.lang.String toString() {
        return "ActivityResult{resultCode=" + resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mData == null ? 0 : 1);
        android.content.Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}

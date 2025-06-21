package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableLong extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableLong> CREATOR = new androidx.databinding.ObservableLong.AnonymousClass1();
    static final long serialVersionUID = 1;
    private long mValue;

    /* renamed from: androidx.databinding.ObservableLong$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableLong> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableLong createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableLong(parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableLong[] newArray(int i) {
            return new androidx.databinding.ObservableLong[i];
        }
    }

    public ObservableLong() {
    }

    public ObservableLong(long j) {
        this.mValue = j;
    }

    public ObservableLong(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long get() {
        return this.mValue;
    }

    public void set(long j) {
        if (j != this.mValue) {
            this.mValue = j;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.mValue);
    }
}

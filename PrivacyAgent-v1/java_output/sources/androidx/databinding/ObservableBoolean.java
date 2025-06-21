package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableBoolean extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableBoolean> CREATOR = new androidx.databinding.ObservableBoolean.AnonymousClass1();
    static final long serialVersionUID = 1;
    private boolean mValue;

    /* renamed from: androidx.databinding.ObservableBoolean$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableBoolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableBoolean createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableBoolean(parcel.readInt() == 1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableBoolean[] newArray(int i) {
            return new androidx.databinding.ObservableBoolean[i];
        }
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(boolean z) {
        this.mValue = z;
    }

    public ObservableBoolean(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean z) {
        if (z != this.mValue) {
            this.mValue = z;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }
}

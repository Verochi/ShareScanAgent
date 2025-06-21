package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableInt extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableInt> CREATOR = new androidx.databinding.ObservableInt.AnonymousClass1();
    static final long serialVersionUID = 1;
    private int mValue;

    /* renamed from: androidx.databinding.ObservableInt$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableInt> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableInt createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableInt(parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableInt[] newArray(int i) {
            return new androidx.databinding.ObservableInt[i];
        }
    }

    public ObservableInt() {
    }

    public ObservableInt(int i) {
        this.mValue = i;
    }

    public ObservableInt(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int i) {
        if (i != this.mValue) {
            this.mValue = i;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mValue);
    }
}

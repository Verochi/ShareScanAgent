package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableByte extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableByte> CREATOR = new androidx.databinding.ObservableByte.AnonymousClass1();
    static final long serialVersionUID = 1;
    private byte mValue;

    /* renamed from: androidx.databinding.ObservableByte$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableByte> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableByte createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableByte(parcel.readByte());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableByte[] newArray(int i) {
            return new androidx.databinding.ObservableByte[i];
        }
    }

    public ObservableByte() {
    }

    public ObservableByte(byte b) {
        this.mValue = b;
    }

    public ObservableByte(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte b) {
        if (b != this.mValue) {
            this.mValue = b;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByte(this.mValue);
    }
}

package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableShort extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableShort> CREATOR = new androidx.databinding.ObservableShort.AnonymousClass1();
    static final long serialVersionUID = 1;
    private short mValue;

    /* renamed from: androidx.databinding.ObservableShort$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableShort> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableShort createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableShort((short) parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableShort[] newArray(int i) {
            return new androidx.databinding.ObservableShort[i];
        }
    }

    public ObservableShort() {
    }

    public ObservableShort(short s2) {
        this.mValue = s2;
    }

    public ObservableShort(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public short get() {
        return this.mValue;
    }

    public void set(short s2) {
        if (s2 != this.mValue) {
            this.mValue = s2;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.mValue);
    }
}

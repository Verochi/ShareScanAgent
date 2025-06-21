package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableFloat extends androidx.databinding.BaseObservableField implements android.os.Parcelable, java.io.Serializable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableFloat> CREATOR = new androidx.databinding.ObservableFloat.AnonymousClass1();
    static final long serialVersionUID = 1;
    private float mValue;

    /* renamed from: androidx.databinding.ObservableFloat$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableFloat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableFloat createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableFloat(parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableFloat[] newArray(int i) {
            return new androidx.databinding.ObservableFloat[i];
        }
    }

    public ObservableFloat() {
    }

    public ObservableFloat(float f) {
        this.mValue = f;
    }

    public ObservableFloat(androidx.databinding.Observable... observableArr) {
        super(observableArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float get() {
        return this.mValue;
    }

    public void set(float f) {
        if (f != this.mValue) {
            this.mValue = f;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.mValue);
    }
}

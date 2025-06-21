package androidx.databinding;

/* loaded from: classes.dex */
public class ObservableParcelable<T extends android.os.Parcelable> extends androidx.databinding.ObservableField<T> implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.databinding.ObservableParcelable> CREATOR = new androidx.databinding.ObservableParcelable.AnonymousClass1();
    static final long serialVersionUID = 1;

    /* renamed from: androidx.databinding.ObservableParcelable$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.databinding.ObservableParcelable> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableParcelable createFromParcel(android.os.Parcel parcel) {
            return new androidx.databinding.ObservableParcelable(parcel.readParcelable(getClass().getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.databinding.ObservableParcelable[] newArray(int i) {
            return new androidx.databinding.ObservableParcelable[i];
        }
    }

    public ObservableParcelable() {
    }

    public ObservableParcelable(T t) {
        super(t);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable((android.os.Parcelable) get(), 0);
    }
}

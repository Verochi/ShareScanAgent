package androidx.customview.view;

/* loaded from: classes.dex */
public abstract class AbsSavedState implements android.os.Parcelable {
    private final android.os.Parcelable mSuperState;
    public static final androidx.customview.view.AbsSavedState EMPTY_STATE = new androidx.customview.view.AbsSavedState.AnonymousClass1();
    public static final android.os.Parcelable.Creator<androidx.customview.view.AbsSavedState> CREATOR = new androidx.customview.view.AbsSavedState.AnonymousClass2();

    /* renamed from: androidx.customview.view.AbsSavedState$1, reason: invalid class name */
    public static class AnonymousClass1 extends androidx.customview.view.AbsSavedState {
        public AnonymousClass1() {
            super((androidx.customview.view.AbsSavedState.AnonymousClass1) null);
        }
    }

    /* renamed from: androidx.customview.view.AbsSavedState$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.os.Parcelable.ClassLoaderCreator<androidx.customview.view.AbsSavedState> {
        @Override // android.os.Parcelable.Creator
        public androidx.customview.view.AbsSavedState createFromParcel(android.os.Parcel parcel) {
            return createFromParcel(parcel, (java.lang.ClassLoader) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public androidx.customview.view.AbsSavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return androidx.customview.view.AbsSavedState.EMPTY_STATE;
            }
            throw new java.lang.IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public androidx.customview.view.AbsSavedState[] newArray(int i) {
            return new androidx.customview.view.AbsSavedState[i];
        }
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    public AbsSavedState(@androidx.annotation.NonNull android.os.Parcel parcel) {
        this(parcel, null);
    }

    public AbsSavedState(@androidx.annotation.NonNull android.os.Parcel parcel, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
        android.os.Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.mSuperState = readParcelable == null ? EMPTY_STATE : readParcelable;
    }

    public AbsSavedState(@androidx.annotation.NonNull android.os.Parcelable parcelable) {
        if (parcelable == null) {
            throw new java.lang.IllegalArgumentException("superState must not be null");
        }
        this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
    }

    public /* synthetic */ AbsSavedState(androidx.customview.view.AbsSavedState.AnonymousClass1 anonymousClass1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @androidx.annotation.Nullable
    public final android.os.Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }
}

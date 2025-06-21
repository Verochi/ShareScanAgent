package com.google.android.material.stateful;

/* loaded from: classes22.dex */
public class ExtendableSavedState extends androidx.customview.view.AbsSavedState {
    public static final android.os.Parcelable.Creator<com.google.android.material.stateful.ExtendableSavedState> CREATOR = new com.google.android.material.stateful.ExtendableSavedState.AnonymousClass1();

    @androidx.annotation.NonNull
    public final androidx.collection.SimpleArrayMap<java.lang.String, android.os.Bundle> extendableStates;

    /* renamed from: com.google.android.material.stateful.ExtendableSavedState$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.stateful.ExtendableSavedState> {
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.Nullable
        public com.google.android.material.stateful.ExtendableSavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return new com.google.android.material.stateful.ExtendableSavedState(parcel, null, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        @androidx.annotation.NonNull
        public com.google.android.material.stateful.ExtendableSavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            return new com.google.android.material.stateful.ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.stateful.ExtendableSavedState[] newArray(int i) {
            return new com.google.android.material.stateful.ExtendableSavedState[i];
        }
    }

    private ExtendableSavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        java.lang.String[] strArr = new java.lang.String[readInt];
        parcel.readStringArray(strArr);
        android.os.Bundle[] bundleArr = new android.os.Bundle[readInt];
        parcel.readTypedArray(bundleArr, android.os.Bundle.CREATOR);
        this.extendableStates = new androidx.collection.SimpleArrayMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.extendableStates.put(strArr[i], bundleArr[i]);
        }
    }

    public /* synthetic */ ExtendableSavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader, com.google.android.material.stateful.ExtendableSavedState.AnonymousClass1 anonymousClass1) {
        this(parcel, classLoader);
    }

    public ExtendableSavedState(android.os.Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new androidx.collection.SimpleArrayMap<>();
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "ExtendableSavedState{" + java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)) + " states=" + this.extendableStates + com.alipay.sdk.m.u.i.d;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.extendableStates.size();
        parcel.writeInt(size);
        java.lang.String[] strArr = new java.lang.String[size];
        android.os.Bundle[] bundleArr = new android.os.Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.extendableStates.keyAt(i2);
            bundleArr[i2] = this.extendableStates.valueAt(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}

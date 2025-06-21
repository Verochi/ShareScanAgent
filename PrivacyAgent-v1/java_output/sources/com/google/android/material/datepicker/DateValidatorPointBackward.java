package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
public class DateValidatorPointBackward implements com.google.android.material.datepicker.CalendarConstraints.DateValidator {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointBackward> CREATOR = new com.google.android.material.datepicker.DateValidatorPointBackward.AnonymousClass1();
    private final long point;

    /* renamed from: com.google.android.material.datepicker.DateValidatorPointBackward$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.DateValidatorPointBackward> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.DateValidatorPointBackward createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return new com.google.android.material.datepicker.DateValidatorPointBackward(parcel.readLong(), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.DateValidatorPointBackward[] newArray(int i) {
            return new com.google.android.material.datepicker.DateValidatorPointBackward[i];
        }
    }

    private DateValidatorPointBackward(long j) {
        this.point = j;
    }

    public /* synthetic */ DateValidatorPointBackward(long j, com.google.android.material.datepicker.DateValidatorPointBackward.AnonymousClass1 anonymousClass1) {
        this(j);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.DateValidatorPointBackward before(long j) {
        return new com.google.android.material.datepicker.DateValidatorPointBackward(j);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.DateValidatorPointBackward now() {
        return before(com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof com.google.android.material.datepicker.DateValidatorPointBackward) && this.point == ((com.google.android.material.datepicker.DateValidatorPointBackward) obj).point;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Long.valueOf(this.point)});
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return j <= this.point;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeLong(this.point);
    }
}

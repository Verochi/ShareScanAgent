package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
public final class CalendarConstraints implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.CalendarConstraints> CREATOR = new com.google.android.material.datepicker.CalendarConstraints.AnonymousClass1();

    @androidx.annotation.NonNull
    private final com.google.android.material.datepicker.Month end;
    private final int monthSpan;

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.Month openAt;

    @androidx.annotation.NonNull
    private final com.google.android.material.datepicker.Month start;

    @androidx.annotation.NonNull
    private final com.google.android.material.datepicker.CalendarConstraints.DateValidator validator;
    private final int yearSpan;

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.CalendarConstraints> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return new com.google.android.material.datepicker.CalendarConstraints((com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), (com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), (com.google.android.material.datepicker.CalendarConstraints.DateValidator) parcel.readParcelable(com.google.android.material.datepicker.CalendarConstraints.DateValidator.class.getClassLoader()), (com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints[] newArray(int i) {
            return new com.google.android.material.datepicker.CalendarConstraints[i];
        }
    }

    public static final class Builder {
        private static final java.lang.String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        private long end;
        private java.lang.Long openAt;
        private long start;
        private com.google.android.material.datepicker.CalendarConstraints.DateValidator validator;
        static final long DEFAULT_START = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(com.google.android.material.datepicker.Month.create(1900, 0).timeInMillis);
        static final long DEFAULT_END = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(com.google.android.material.datepicker.Month.create(2100, 11).timeInMillis);

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = com.google.android.material.datepicker.DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        public Builder(@androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = com.google.android.material.datepicker.DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = java.lang.Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints build() {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            com.google.android.material.datepicker.Month create = com.google.android.material.datepicker.Month.create(this.start);
            com.google.android.material.datepicker.Month create2 = com.google.android.material.datepicker.Month.create(this.end);
            com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator = (com.google.android.material.datepicker.CalendarConstraints.DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY);
            java.lang.Long l = this.openAt;
            return new com.google.android.material.datepicker.CalendarConstraints(create, create2, dateValidator, l == null ? null : com.google.android.material.datepicker.Month.create(l.longValue()), null);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints.Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints.Builder setOpenAt(long j) {
            this.openAt = java.lang.Long.valueOf(j);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints.Builder setStart(long j) {
            this.start = j;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CalendarConstraints.Builder setValidator(@androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }
    }

    public interface DateValidator extends android.os.Parcelable {
        boolean isValid(long j);
    }

    private CalendarConstraints(@androidx.annotation.NonNull com.google.android.material.datepicker.Month month, @androidx.annotation.NonNull com.google.android.material.datepicker.Month month2, @androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator, @androidx.annotation.Nullable com.google.android.material.datepicker.Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new java.lang.IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new java.lang.IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    public /* synthetic */ CalendarConstraints(com.google.android.material.datepicker.Month month, com.google.android.material.datepicker.Month month2, com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator, com.google.android.material.datepicker.Month month3, com.google.android.material.datepicker.CalendarConstraints.AnonymousClass1 anonymousClass1) {
        this(month, month2, dateValidator, month3);
    }

    public com.google.android.material.datepicker.Month clamp(com.google.android.material.datepicker.Month month) {
        return month.compareTo(this.start) < 0 ? this.start : month.compareTo(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.datepicker.CalendarConstraints)) {
            return false;
        }
        com.google.android.material.datepicker.CalendarConstraints calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && androidx.core.util.ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public com.google.android.material.datepicker.CalendarConstraints.DateValidator getDateValidator() {
        return this.validator;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.Month getEnd() {
        return this.end;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.datepicker.Month getOpenAt() {
        return this.openAt;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.Month getStart() {
        return this.start;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public boolean isWithinBounds(long j) {
        if (this.start.getDay(1) <= j) {
            com.google.android.material.datepicker.Month month = this.end;
            if (j <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public void setOpenAt(@androidx.annotation.Nullable com.google.android.material.datepicker.Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}

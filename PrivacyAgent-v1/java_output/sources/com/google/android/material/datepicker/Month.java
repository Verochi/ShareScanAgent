package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
final class Month implements java.lang.Comparable<com.google.android.material.datepicker.Month>, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.Month> CREATOR = new com.google.android.material.datepicker.Month.AnonymousClass1();
    final int daysInMonth;
    final int daysInWeek;

    @androidx.annotation.NonNull
    private final java.util.Calendar firstOfMonth;

    @androidx.annotation.Nullable
    private java.lang.String longName;
    final int month;
    final long timeInMillis;
    final int year;

    /* renamed from: com.google.android.material.datepicker.Month$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.Month> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.Month createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return com.google.android.material.datepicker.Month.create(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.Month[] newArray(int i) {
            return new com.google.android.material.datepicker.Month[i];
        }
    }

    private Month(@androidx.annotation.NonNull java.util.Calendar calendar) {
        calendar.set(5, 1);
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = dayCopy.get(1);
        this.daysInWeek = dayCopy.getMaximum(7);
        this.daysInMonth = dayCopy.getActualMaximum(5);
        this.timeInMillis = dayCopy.getTimeInMillis();
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.Month create(int i, int i2) {
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.set(1, i);
        utcCalendar.set(2, i2);
        return new com.google.android.material.datepicker.Month(utcCalendar);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.Month create(long j) {
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        return new com.google.android.material.datepicker.Month(utcCalendar);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.Month current() {
        return new com.google.android.material.datepicker.Month(com.google.android.material.datepicker.UtcDates.getTodayCalendar());
    }

    @Override // java.lang.Comparable
    public int compareTo(@androidx.annotation.NonNull com.google.android.material.datepicker.Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    public int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.datepicker.Month)) {
            return false;
        }
        com.google.android.material.datepicker.Month month = (com.google.android.material.datepicker.Month) obj;
        return this.month == month.month && this.year == month.year;
    }

    public long getDay(int i) {
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i);
        return dayCopy.getTimeInMillis();
    }

    public int getDayOfMonth(long j) {
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.setTimeInMillis(j);
        return dayCopy.get(5);
    }

    @androidx.annotation.NonNull
    public java.lang.String getLongName(android.content.Context context) {
        if (this.longName == null) {
            this.longName = com.google.android.material.datepicker.DateStrings.getYearMonth(context, this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    public long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.month), java.lang.Integer.valueOf(this.year)});
    }

    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.Month monthsLater(int i) {
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i);
        return new com.google.android.material.datepicker.Month(dayCopy);
    }

    public int monthsUntil(@androidx.annotation.NonNull com.google.android.material.datepicker.Month month) {
        if (this.firstOfMonth instanceof java.util.GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new java.lang.IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }
}

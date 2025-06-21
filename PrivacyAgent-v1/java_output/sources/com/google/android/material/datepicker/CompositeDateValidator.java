package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
public final class CompositeDateValidator implements com.google.android.material.datepicker.CalendarConstraints.DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;

    @androidx.annotation.NonNull
    private final com.google.android.material.datepicker.CompositeDateValidator.Operator operator;

    @androidx.annotation.NonNull
    private final java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> validators;
    private static final com.google.android.material.datepicker.CompositeDateValidator.Operator ANY_OPERATOR = new com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass1();
    private static final com.google.android.material.datepicker.CompositeDateValidator.Operator ALL_OPERATOR = new com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass2();
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.CompositeDateValidator> CREATOR = new com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass3();

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.android.material.datepicker.CompositeDateValidator.Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 1;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list, long j) {
            for (com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.isValid(j)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.android.material.datepicker.CompositeDateValidator.Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 2;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list, long j) {
            for (com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.isValid(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.CompositeDateValidator> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CompositeDateValidator createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            java.util.ArrayList readArrayList = parcel.readArrayList(com.google.android.material.datepicker.CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            return new com.google.android.material.datepicker.CompositeDateValidator((java.util.List) androidx.core.util.Preconditions.checkNotNull(readArrayList), readInt == 2 ? com.google.android.material.datepicker.CompositeDateValidator.ALL_OPERATOR : readInt == 1 ? com.google.android.material.datepicker.CompositeDateValidator.ANY_OPERATOR : com.google.android.material.datepicker.CompositeDateValidator.ALL_OPERATOR, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.CompositeDateValidator[] newArray(int i) {
            return new com.google.android.material.datepicker.CompositeDateValidator[i];
        }
    }

    public interface Operator {
        int getId();

        boolean isValid(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list, long j);
    }

    private CompositeDateValidator(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list, com.google.android.material.datepicker.CompositeDateValidator.Operator operator) {
        this.validators = list;
        this.operator = operator;
    }

    public /* synthetic */ CompositeDateValidator(java.util.List list, com.google.android.material.datepicker.CompositeDateValidator.Operator operator, com.google.android.material.datepicker.CompositeDateValidator.AnonymousClass1 anonymousClass1) {
        this(list, operator);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.CalendarConstraints.DateValidator allOf(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list) {
        return new com.google.android.material.datepicker.CompositeDateValidator(list, ALL_OPERATOR);
    }

    @androidx.annotation.NonNull
    public static com.google.android.material.datepicker.CalendarConstraints.DateValidator anyOf(@androidx.annotation.NonNull java.util.List<com.google.android.material.datepicker.CalendarConstraints.DateValidator> list) {
        return new com.google.android.material.datepicker.CompositeDateValidator(list, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.datepicker.CompositeDateValidator)) {
            return false;
        }
        com.google.android.material.datepicker.CompositeDateValidator compositeDateValidator = (com.google.android.material.datepicker.CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return this.operator.isValid(this.validators, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }
}

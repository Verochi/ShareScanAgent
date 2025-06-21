package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
abstract class DateFormatTextWatcher extends com.google.android.material.internal.TextWatcherAdapter {
    private static final int VALIDATION_DELAY = 1000;
    private final com.google.android.material.datepicker.CalendarConstraints constraints;
    private final java.text.DateFormat dateFormat;
    private final java.lang.String outOfRange;
    private final java.lang.Runnable setErrorCallback;
    private java.lang.Runnable setRangeErrorCallback;

    @androidx.annotation.NonNull
    private final com.google.android.material.textfield.TextInputLayout textInputLayout;

    /* renamed from: com.google.android.material.datepicker.DateFormatTextWatcher$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$formatHint;

        public AnonymousClass1(java.lang.String str) {
            this.val$formatHint = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.textfield.TextInputLayout textInputLayout = com.google.android.material.datepicker.DateFormatTextWatcher.this.textInputLayout;
            java.text.DateFormat dateFormat = com.google.android.material.datepicker.DateFormatTextWatcher.this.dateFormat;
            android.content.Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(com.google.android.material.R.string.mtrl_picker_invalid_format) + "\n" + java.lang.String.format(context.getString(com.google.android.material.R.string.mtrl_picker_invalid_format_use), this.val$formatHint) + "\n" + java.lang.String.format(context.getString(com.google.android.material.R.string.mtrl_picker_invalid_format_example), dateFormat.format(new java.util.Date(com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis()))));
            com.google.android.material.datepicker.DateFormatTextWatcher.this.onInvalidDate();
        }
    }

    /* renamed from: com.google.android.material.datepicker.DateFormatTextWatcher$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ long val$milliseconds;

        public AnonymousClass2(long j) {
            this.val$milliseconds = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.datepicker.DateFormatTextWatcher.this.textInputLayout.setError(java.lang.String.format(com.google.android.material.datepicker.DateFormatTextWatcher.this.outOfRange, com.google.android.material.datepicker.DateStrings.getDateString(this.val$milliseconds)));
            com.google.android.material.datepicker.DateFormatTextWatcher.this.onInvalidDate();
        }
    }

    public DateFormatTextWatcher(java.lang.String str, java.text.DateFormat dateFormat, @androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(com.google.android.material.R.string.mtrl_picker_out_of_range);
        this.setErrorCallback = new com.google.android.material.datepicker.DateFormatTextWatcher.AnonymousClass1(str);
    }

    private java.lang.Runnable createRangeErrorCallback(long j) {
        return new com.google.android.material.datepicker.DateFormatTextWatcher.AnonymousClass2(j);
    }

    public void onInvalidDate() {
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@androidx.annotation.NonNull java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.textInputLayout.removeCallbacks(this.setErrorCallback);
        this.textInputLayout.removeCallbacks(this.setRangeErrorCallback);
        this.textInputLayout.setError(null);
        onValidDate(null);
        if (android.text.TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            java.util.Date parse = this.dateFormat.parse(charSequence.toString());
            this.textInputLayout.setError(null);
            long time = parse.getTime();
            if (this.constraints.getDateValidator().isValid(time) && this.constraints.isWithinBounds(time)) {
                onValidDate(java.lang.Long.valueOf(parse.getTime()));
                return;
            }
            java.lang.Runnable createRangeErrorCallback = createRangeErrorCallback(time);
            this.setRangeErrorCallback = createRangeErrorCallback;
            runValidation(this.textInputLayout, createRangeErrorCallback);
        } catch (java.text.ParseException unused) {
            runValidation(this.textInputLayout, this.setErrorCallback);
        }
    }

    public abstract void onValidDate(@androidx.annotation.Nullable java.lang.Long l);

    public void runValidation(android.view.View view, java.lang.Runnable runnable) {
        view.postDelayed(runnable, 1000L);
    }
}

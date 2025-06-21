package com.google.android.material.datepicker;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class SingleDateSelector implements com.google.android.material.datepicker.DateSelector<java.lang.Long> {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.SingleDateSelector> CREATOR = new com.google.android.material.datepicker.SingleDateSelector.AnonymousClass2();

    @androidx.annotation.Nullable
    private java.lang.Long selectedItem;

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.datepicker.DateFormatTextWatcher {
        final /* synthetic */ com.google.android.material.datepicker.OnSelectionChangedListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.text.DateFormat dateFormat, com.google.android.material.textfield.TextInputLayout textInputLayout, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, com.google.android.material.datepicker.OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$listener = onSelectionChangedListener;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onInvalidDate() {
            this.val$listener.onIncompleteSelectionChanged();
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onValidDate(@androidx.annotation.Nullable java.lang.Long l) {
            if (l == null) {
                com.google.android.material.datepicker.SingleDateSelector.this.clearSelection();
            } else {
                com.google.android.material.datepicker.SingleDateSelector.this.select(l.longValue());
            }
            this.val$listener.onSelectionChanged(com.google.android.material.datepicker.SingleDateSelector.this.getSelection());
        }
    }

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.SingleDateSelector> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.SingleDateSelector createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            com.google.android.material.datepicker.SingleDateSelector singleDateSelector = new com.google.android.material.datepicker.SingleDateSelector();
            singleDateSelector.selectedItem = (java.lang.Long) parcel.readValue(java.lang.Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.SingleDateSelector[] newArray(int i) {
            return new com.google.android.material.datepicker.SingleDateSelector[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(android.content.Context context) {
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.materialCalendarTheme, com.google.android.material.datepicker.MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return com.google.android.material.R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.util.Collection<java.lang.Long> getSelectedDays() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.util.Collection<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> getSelectedRanges() {
        return new java.util.ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.Nullable
    public java.lang.Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.lang.String getSelectionDisplayString(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        java.lang.Long l = this.selectedItem;
        if (l == null) {
            return resources.getString(com.google.android.material.R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(com.google.android.material.R.string.mtrl_picker_date_header_selected, com.google.android.material.datepicker.DateStrings.getYearMonthDay(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public android.view.View onCreateTextInputView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, @androidx.annotation.NonNull com.google.android.material.datepicker.OnSelectionChangedListener<java.lang.Long> onSelectionChangedListener) {
        android.view.View inflate = layoutInflater.inflate(com.google.android.material.R.layout.mtrl_picker_text_input_date, viewGroup, false);
        com.google.android.material.textfield.TextInputLayout textInputLayout = (com.google.android.material.textfield.TextInputLayout) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_text_input_date);
        android.widget.EditText editText = textInputLayout.getEditText();
        if (com.google.android.material.internal.ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        java.text.SimpleDateFormat textInputFormat = com.google.android.material.datepicker.UtcDates.getTextInputFormat();
        java.lang.String textInputHint = com.google.android.material.datepicker.UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        java.lang.Long l = this.selectedItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
        }
        editText.addTextChangedListener(new com.google.android.material.datepicker.SingleDateSelector.AnonymousClass1(textInputHint, textInputFormat, textInputLayout, calendarConstraints, onSelectionChangedListener));
        com.google.android.material.internal.ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        this.selectedItem = java.lang.Long.valueOf(j);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@androidx.annotation.Nullable java.lang.Long l) {
        this.selectedItem = l == null ? null : java.lang.Long.valueOf(com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }
}

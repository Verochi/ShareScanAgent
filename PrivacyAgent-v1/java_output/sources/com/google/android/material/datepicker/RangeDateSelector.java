package com.google.android.material.datepicker;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class RangeDateSelector implements com.google.android.material.datepicker.DateSelector<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.RangeDateSelector> CREATOR = new com.google.android.material.datepicker.RangeDateSelector.AnonymousClass3();
    private java.lang.String invalidRangeStartError;
    private final java.lang.String invalidRangeEndError = " ";

    @androidx.annotation.Nullable
    private java.lang.Long selectedStartItem = null;

    @androidx.annotation.Nullable
    private java.lang.Long selectedEndItem = null;

    @androidx.annotation.Nullable
    private java.lang.Long proposedTextStart = null;

    @androidx.annotation.Nullable
    private java.lang.Long proposedTextEnd = null;

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.android.material.datepicker.DateFormatTextWatcher {
        final /* synthetic */ com.google.android.material.textfield.TextInputLayout val$endTextInput;
        final /* synthetic */ com.google.android.material.datepicker.OnSelectionChangedListener val$listener;
        final /* synthetic */ com.google.android.material.textfield.TextInputLayout val$startTextInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.String str, java.text.DateFormat dateFormat, com.google.android.material.textfield.TextInputLayout textInputLayout, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, com.google.android.material.textfield.TextInputLayout textInputLayout2, com.google.android.material.textfield.TextInputLayout textInputLayout3, com.google.android.material.datepicker.OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$startTextInput = textInputLayout2;
            this.val$endTextInput = textInputLayout3;
            this.val$listener = onSelectionChangedListener;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onInvalidDate() {
            com.google.android.material.datepicker.RangeDateSelector.this.proposedTextStart = null;
            com.google.android.material.datepicker.RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onValidDate(@androidx.annotation.Nullable java.lang.Long l) {
            com.google.android.material.datepicker.RangeDateSelector.this.proposedTextStart = l;
            com.google.android.material.datepicker.RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.datepicker.DateFormatTextWatcher {
        final /* synthetic */ com.google.android.material.textfield.TextInputLayout val$endTextInput;
        final /* synthetic */ com.google.android.material.datepicker.OnSelectionChangedListener val$listener;
        final /* synthetic */ com.google.android.material.textfield.TextInputLayout val$startTextInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, java.text.DateFormat dateFormat, com.google.android.material.textfield.TextInputLayout textInputLayout, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, com.google.android.material.textfield.TextInputLayout textInputLayout2, com.google.android.material.textfield.TextInputLayout textInputLayout3, com.google.android.material.datepicker.OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$startTextInput = textInputLayout2;
            this.val$endTextInput = textInputLayout3;
            this.val$listener = onSelectionChangedListener;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onInvalidDate() {
            com.google.android.material.datepicker.RangeDateSelector.this.proposedTextEnd = null;
            com.google.android.material.datepicker.RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        public void onValidDate(@androidx.annotation.Nullable java.lang.Long l) {
            com.google.android.material.datepicker.RangeDateSelector.this.proposedTextEnd = l;
            com.google.android.material.datepicker.RangeDateSelector.this.updateIfValidTextProposal(this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.os.Parcelable.Creator<com.google.android.material.datepicker.RangeDateSelector> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.RangeDateSelector createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            com.google.android.material.datepicker.RangeDateSelector rangeDateSelector = new com.google.android.material.datepicker.RangeDateSelector();
            rangeDateSelector.selectedStartItem = (java.lang.Long) parcel.readValue(java.lang.Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (java.lang.Long) parcel.readValue(java.lang.Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.RangeDateSelector[] newArray(int i) {
            return new com.google.android.material.datepicker.RangeDateSelector[i];
        }
    }

    private void clearInvalidRange(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, @androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

    private void setInvalidRange(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, @androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIfValidTextProposal(@androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout, @androidx.annotation.NonNull com.google.android.material.textfield.TextInputLayout textInputLayout2, @androidx.annotation.NonNull com.google.android.material.datepicker.OnSelectionChangedListener<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> onSelectionChangedListener) {
        java.lang.Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (!isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, java.lang.Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? com.google.android.material.R.attr.materialCalendarTheme : com.google.android.material.R.attr.materialCalendarFullscreenTheme, com.google.android.material.datepicker.MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return com.google.android.material.R.string.mtrl_picker_range_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.util.Collection<java.lang.Long> getSelectedDays() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        java.lang.Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.util.Collection<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new androidx.core.util.Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public androidx.core.util.Pair<java.lang.Long, java.lang.Long> getSelection() {
        return new androidx.core.util.Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @androidx.annotation.NonNull
    public java.lang.String getSelectionDisplayString(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        java.lang.Long l = this.selectedStartItem;
        if (l == null && this.selectedEndItem == null) {
            return resources.getString(com.google.android.material.R.string.mtrl_picker_range_header_unselected);
        }
        java.lang.Long l2 = this.selectedEndItem;
        if (l2 == null) {
            return resources.getString(com.google.android.material.R.string.mtrl_picker_range_header_only_start_selected, com.google.android.material.datepicker.DateStrings.getDateString(l.longValue()));
        }
        if (l == null) {
            return resources.getString(com.google.android.material.R.string.mtrl_picker_range_header_only_end_selected, com.google.android.material.datepicker.DateStrings.getDateString(l2.longValue()));
        }
        androidx.core.util.Pair<java.lang.String, java.lang.String> dateRangeString = com.google.android.material.datepicker.DateStrings.getDateRangeString(l, l2);
        return resources.getString(com.google.android.material.R.string.mtrl_picker_range_header_selected, dateRangeString.first, dateRangeString.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        java.lang.Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public android.view.View onCreateTextInputView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle, com.google.android.material.datepicker.CalendarConstraints calendarConstraints, @androidx.annotation.NonNull com.google.android.material.datepicker.OnSelectionChangedListener<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> onSelectionChangedListener) {
        android.view.View inflate = layoutInflater.inflate(com.google.android.material.R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        com.google.android.material.textfield.TextInputLayout textInputLayout = (com.google.android.material.textfield.TextInputLayout) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_text_input_range_start);
        com.google.android.material.textfield.TextInputLayout textInputLayout2 = (com.google.android.material.textfield.TextInputLayout) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_text_input_range_end);
        android.widget.EditText editText = textInputLayout.getEditText();
        android.widget.EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(com.google.android.material.R.string.mtrl_picker_invalid_range);
        java.text.SimpleDateFormat textInputFormat = com.google.android.material.datepicker.UtcDates.getTextInputFormat();
        java.lang.Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        java.lang.Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(textInputFormat.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        java.lang.String textInputHint = com.google.android.material.datepicker.UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        textInputLayout2.setPlaceholderText(textInputHint);
        editText.addTextChangedListener(new com.google.android.material.datepicker.RangeDateSelector.AnonymousClass1(textInputHint, textInputFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        editText2.addTextChangedListener(new com.google.android.material.datepicker.RangeDateSelector.AnonymousClass2(textInputHint, textInputFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        com.google.android.material.internal.ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        java.lang.Long l = this.selectedStartItem;
        if (l == null) {
            this.selectedStartItem = java.lang.Long.valueOf(j);
        } else if (this.selectedEndItem == null && isValidRange(l.longValue(), j)) {
            this.selectedEndItem = java.lang.Long.valueOf(j);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = java.lang.Long.valueOf(j);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setSelection(@androidx.annotation.NonNull androidx.core.util.Pair<java.lang.Long, java.lang.Long> pair) {
        java.lang.Long l = pair.first;
        if (l != null && pair.second != null) {
            androidx.core.util.Preconditions.checkArgument(isValidRange(l.longValue(), pair.second.longValue()));
        }
        java.lang.Long l2 = pair.first;
        this.selectedStartItem = l2 == null ? null : java.lang.Long.valueOf(com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(l2.longValue()));
        java.lang.Long l3 = pair.second;
        this.selectedEndItem = l3 != null ? java.lang.Long.valueOf(com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(l3.longValue())) : null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}

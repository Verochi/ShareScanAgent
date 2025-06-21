package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
public final class MaterialDatePicker<S> extends androidx.fragment.app.DialogFragment {
    private static final java.lang.String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final java.lang.String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    public static final int INPUT_MODE_CALENDAR = 0;
    private static final java.lang.String INPUT_MODE_KEY = "INPUT_MODE_KEY";
    public static final int INPUT_MODE_TEXT = 1;
    private static final java.lang.String OVERRIDE_THEME_RES_ID = "OVERRIDE_THEME_RES_ID";
    private static final java.lang.String TITLE_TEXT_KEY = "TITLE_TEXT_KEY";
    private static final java.lang.String TITLE_TEXT_RES_ID_KEY = "TITLE_TEXT_RES_ID_KEY";

    @androidx.annotation.Nullable
    private com.google.android.material.shape.MaterialShapeDrawable background;
    private com.google.android.material.datepicker.MaterialCalendar<S> calendar;

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private android.widget.Button confirmButton;

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.DateSelector<S> dateSelector;
    private boolean fullscreen;
    private android.widget.TextView headerSelectionText;
    private com.google.android.material.internal.CheckableImageButton headerToggleButton;
    private int inputMode;

    @androidx.annotation.StyleRes
    private int overrideThemeResId;
    private com.google.android.material.datepicker.PickerFragment<S> pickerFragment;
    private java.lang.CharSequence titleText;

    @androidx.annotation.StringRes
    private int titleTextResId;
    static final java.lang.Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    static final java.lang.Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final java.lang.Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    private final java.util.LinkedHashSet<com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.view.View.OnClickListener> onNegativeButtonClickListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.content.DialogInterface.OnCancelListener> onCancelListeners = new java.util.LinkedHashSet<>();
    private final java.util.LinkedHashSet<android.content.DialogInterface.OnDismissListener> onDismissListeners = new java.util.LinkedHashSet<>();

    /* renamed from: com.google.android.material.datepicker.MaterialDatePicker$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            java.util.Iterator it = com.google.android.material.datepicker.MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
            while (it.hasNext()) {
                ((com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener) it.next()).onPositiveButtonClick(com.google.android.material.datepicker.MaterialDatePicker.this.getSelection());
            }
            com.google.android.material.datepicker.MaterialDatePicker.this.dismiss();
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialDatePicker$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            java.util.Iterator it = com.google.android.material.datepicker.MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
            while (it.hasNext()) {
                ((android.view.View.OnClickListener) it.next()).onClick(view);
            }
            com.google.android.material.datepicker.MaterialDatePicker.this.dismiss();
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialDatePicker$3, reason: invalid class name */
    public class AnonymousClass3 extends com.google.android.material.datepicker.OnSelectionChangedListener<S> {
        public AnonymousClass3() {
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onIncompleteSelectionChanged() {
            com.google.android.material.datepicker.MaterialDatePicker.this.confirmButton.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.OnSelectionChangedListener
        public void onSelectionChanged(S s2) {
            com.google.android.material.datepicker.MaterialDatePicker.this.updateHeader();
            com.google.android.material.datepicker.MaterialDatePicker.this.confirmButton.setEnabled(com.google.android.material.datepicker.MaterialDatePicker.this.dateSelector.isSelectionComplete());
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialDatePicker$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.datepicker.MaterialDatePicker.this.confirmButton.setEnabled(com.google.android.material.datepicker.MaterialDatePicker.this.dateSelector.isSelectionComplete());
            com.google.android.material.datepicker.MaterialDatePicker.this.headerToggleButton.toggle();
            com.google.android.material.datepicker.MaterialDatePicker materialDatePicker = com.google.android.material.datepicker.MaterialDatePicker.this;
            materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
            com.google.android.material.datepicker.MaterialDatePicker.this.startPickerFragment();
        }
    }

    public static final class Builder<S> {
        com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
        final com.google.android.material.datepicker.DateSelector<S> dateSelector;
        int overrideThemeResId = 0;
        int titleTextResId = 0;
        java.lang.CharSequence titleText = null;

        @androidx.annotation.Nullable
        S selection = null;
        int inputMode = 0;

        private Builder(com.google.android.material.datepicker.DateSelector<S> dateSelector) {
            this.dateSelector = dateSelector;
        }

        private com.google.android.material.datepicker.Month createDefaultOpenAt() {
            long j = this.calendarConstraints.getStart().timeInMillis;
            long j2 = this.calendarConstraints.getEnd().timeInMillis;
            if (!this.dateSelector.getSelectedDays().isEmpty()) {
                long longValue = this.dateSelector.getSelectedDays().iterator().next().longValue();
                if (longValue >= j && longValue <= j2) {
                    return com.google.android.material.datepicker.Month.create(longValue);
                }
            }
            long thisMonthInUtcMilliseconds = com.google.android.material.datepicker.MaterialDatePicker.thisMonthInUtcMilliseconds();
            if (j <= thisMonthInUtcMilliseconds && thisMonthInUtcMilliseconds <= j2) {
                j = thisMonthInUtcMilliseconds;
            }
            return com.google.android.material.datepicker.Month.create(j);
        }

        @androidx.annotation.NonNull
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static <S> com.google.android.material.datepicker.MaterialDatePicker.Builder<S> customDatePicker(@androidx.annotation.NonNull com.google.android.material.datepicker.DateSelector<S> dateSelector) {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(dateSelector);
        }

        @androidx.annotation.NonNull
        public static com.google.android.material.datepicker.MaterialDatePicker.Builder<java.lang.Long> datePicker() {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(new com.google.android.material.datepicker.SingleDateSelector());
        }

        @androidx.annotation.NonNull
        public static com.google.android.material.datepicker.MaterialDatePicker.Builder<androidx.core.util.Pair<java.lang.Long, java.lang.Long>> dateRangePicker() {
            return new com.google.android.material.datepicker.MaterialDatePicker.Builder<>(new com.google.android.material.datepicker.RangeDateSelector());
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker<S> build() {
            if (this.calendarConstraints == null) {
                this.calendarConstraints = new com.google.android.material.datepicker.CalendarConstraints.Builder().build();
            }
            if (this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }
            S s2 = this.selection;
            if (s2 != null) {
                this.dateSelector.setSelection(s2);
            }
            if (this.calendarConstraints.getOpenAt() == null) {
                this.calendarConstraints.setOpenAt(createDefaultOpenAt());
            }
            return com.google.android.material.datepicker.MaterialDatePicker.newInstance(this);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setCalendarConstraints(com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
            this.calendarConstraints = calendarConstraints;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setInputMode(int i) {
            this.inputMode = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setSelection(S s2) {
            this.selection = s2;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setTheme(@androidx.annotation.StyleRes int i) {
            this.overrideThemeResId = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setTitleText(@androidx.annotation.StringRes int i) {
            this.titleTextResId = i;
            this.titleText = null;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.datepicker.MaterialDatePicker.Builder<S> setTitleText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.titleText = charSequence;
            this.titleTextResId = 0;
            return this;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InputMode {
    }

    @androidx.annotation.NonNull
    private static android.graphics.drawable.Drawable createHeaderToggleDrawable(android.content.Context context) {
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, androidx.appcompat.content.res.AppCompatResources.getDrawable(context, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], androidx.appcompat.content.res.AppCompatResources.getDrawable(context, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int getDialogPickerHeight(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_days_of_week_height);
        int i = com.google.android.material.datepicker.MonthAdapter.MAXIMUM_WEEKS;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height) * i) + ((i - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int getPaddedPickerWidth(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int i = com.google.android.material.datepicker.Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int getThemeResId(android.content.Context context) {
        int i = this.overrideThemeResId;
        return i != 0 ? i : this.dateSelector.getDefaultThemeResId(context);
    }

    private void initHeaderToggle(android.content.Context context) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        this.headerToggleButton.setChecked(this.inputMode != 0);
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this.headerToggleButton, null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass4());
    }

    public static boolean isFullscreen(@androidx.annotation.NonNull android.content.Context context) {
        return readMaterialCalendarStyleBoolean(context, android.R.attr.windowFullscreen);
    }

    public static boolean isNestedScrollable(@androidx.annotation.NonNull android.content.Context context) {
        return readMaterialCalendarStyleBoolean(context, com.google.android.material.R.attr.nestedScrollable);
    }

    @androidx.annotation.NonNull
    public static <S> com.google.android.material.datepicker.MaterialDatePicker<S> newInstance(@androidx.annotation.NonNull com.google.android.material.datepicker.MaterialDatePicker.Builder<S> builder) {
        com.google.android.material.datepicker.MaterialDatePicker<S> materialDatePicker = new com.google.android.material.datepicker.MaterialDatePicker<>();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, builder.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.calendarConstraints);
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, builder.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, builder.titleText);
        bundle.putInt(INPUT_MODE_KEY, builder.inputMode);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    public static boolean readMaterialCalendarStyleBoolean(@androidx.annotation.NonNull android.content.Context context, int i) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.datepicker.MaterialCalendar.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPickerFragment() {
        int themeResId = getThemeResId(requireContext());
        this.calendar = com.google.android.material.datepicker.MaterialCalendar.newInstance(this.dateSelector, themeResId, this.calendarConstraints);
        this.pickerFragment = this.headerToggleButton.isChecked() ? com.google.android.material.datepicker.MaterialTextInputPicker.newInstance(this.dateSelector, themeResId, this.calendarConstraints) : this.calendar;
        updateHeader();
        androidx.fragment.app.FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.replace(com.google.android.material.R.id.mtrl_calendar_frame, this.pickerFragment);
        beginTransaction.commitNow();
        this.pickerFragment.addOnSelectionChangedListener(new com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass3());
    }

    public static long thisMonthInUtcMilliseconds() {
        return com.google.android.material.datepicker.Month.current().timeInMillis;
    }

    public static long todayInUtcMilliseconds() {
        return com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHeader() {
        java.lang.String headerText = getHeaderText();
        this.headerSelectionText.setContentDescription(java.lang.String.format(getString(com.google.android.material.R.string.mtrl_picker_announce_current_selection), headerText));
        this.headerSelectionText.setText(headerText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToggleContentDescription(@androidx.annotation.NonNull com.google.android.material.internal.CheckableImageButton checkableImageButton) {
        this.headerToggleButton.setContentDescription(this.headerToggleButton.isChecked() ? checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    public boolean addOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(android.view.View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener);
    }

    public void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public java.lang.String getHeaderText() {
        return this.dateSelector.getSelectionDisplayString(getContext());
    }

    @androidx.annotation.Nullable
    public final S getSelection() {
        return this.dateSelector.getSelection();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID);
        this.dateSelector = (com.google.android.material.datepicker.DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.titleTextResId = bundle.getInt(TITLE_TEXT_RES_ID_KEY);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_KEY);
        this.inputMode = bundle.getInt(INPUT_MODE_KEY);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public final android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.app.Dialog dialog = new android.app.Dialog(requireContext(), getThemeResId(requireContext()));
        android.content.Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int resolveOrThrow = com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.colorSurface, com.google.android.material.datepicker.MaterialDatePicker.class.getCanonicalName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context, null, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        this.background = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(context);
        this.background.setFillColor(android.content.res.ColorStateList.valueOf(resolveOrThrow));
        this.background.setElevation(androidx.core.view.ViewCompat.getElevation(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.NonNull
    public final android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.View inflate = layoutInflater.inflate(this.fullscreen ? com.google.android.material.R.layout.mtrl_picker_fullscreen : com.google.android.material.R.layout.mtrl_picker_dialog, viewGroup);
        android.content.Context context = inflate.getContext();
        if (this.fullscreen) {
            inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new android.widget.LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            android.view.View findViewById = inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane);
            android.view.View findViewById2 = inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new android.widget.LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
            findViewById2.setMinimumHeight(getDialogPickerHeight(requireContext()));
        }
        android.widget.TextView textView = (android.widget.TextView) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.headerSelectionText = textView;
        androidx.core.view.ViewCompat.setAccessibilityLiveRegion(textView, 1);
        this.headerToggleButton = (com.google.android.material.internal.CheckableImageButton) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        android.widget.TextView textView2 = (android.widget.TextView) inflate.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        java.lang.CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.titleTextResId);
        }
        initHeaderToggle(context);
        this.confirmButton = (android.widget.Button) inflate.findViewById(com.google.android.material.R.id.confirm_button);
        if (this.dateSelector.isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        this.confirmButton.setOnClickListener(new com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass1());
        android.widget.Button button = (android.widget.Button) inflate.findViewById(com.google.android.material.R.id.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        button.setOnClickListener(new com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass2());
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        com.google.android.material.datepicker.CalendarConstraints.Builder builder = new com.google.android.material.datepicker.CalendarConstraints.Builder(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() != null) {
            builder.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
        }
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, builder.build());
        bundle.putInt(TITLE_TEXT_RES_ID_KEY, this.titleTextResId);
        bundle.putCharSequence(TITLE_TEXT_KEY, this.titleText);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        android.view.Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
            android.graphics.Rect rect = new android.graphics.Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new android.graphics.drawable.InsetDrawable((android.graphics.drawable.Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public boolean removeOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(android.view.View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener);
    }
}

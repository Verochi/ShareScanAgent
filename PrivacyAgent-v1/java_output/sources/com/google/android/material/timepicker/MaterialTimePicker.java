package com.google.android.material.timepicker;

/* loaded from: classes22.dex */
public final class MaterialTimePicker extends androidx.fragment.app.DialogFragment {
    public static final int INPUT_MODE_CLOCK = 0;
    static final java.lang.String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final java.lang.String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final java.lang.String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final java.lang.String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final java.lang.String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";

    @androidx.annotation.Nullable
    private com.google.android.material.timepicker.TimePickerPresenter activePresenter;

    @androidx.annotation.DrawableRes
    private int clockIcon;

    @androidx.annotation.DrawableRes
    private int keyboardIcon;
    private com.google.android.material.button.MaterialButton modeButton;
    private android.view.ViewStub textInputStub;
    private com.google.android.material.timepicker.TimeModel time;

    @androidx.annotation.Nullable
    private com.google.android.material.timepicker.TimePickerClockPresenter timePickerClockPresenter;

    @androidx.annotation.Nullable
    private com.google.android.material.timepicker.TimePickerTextInputPresenter timePickerTextInputPresenter;
    private com.google.android.material.timepicker.TimePickerView timePickerView;
    private java.lang.String titleText;
    private final java.util.Set<android.view.View.OnClickListener> positiveButtonListeners = new java.util.LinkedHashSet();
    private final java.util.Set<android.view.View.OnClickListener> negativeButtonListeners = new java.util.LinkedHashSet();
    private final java.util.Set<android.content.DialogInterface.OnCancelListener> cancelListeners = new java.util.LinkedHashSet();
    private final java.util.Set<android.content.DialogInterface.OnDismissListener> dismissListeners = new java.util.LinkedHashSet();
    private int titleResId = 0;
    private int inputMode = 0;
    private int overrideThemeResId = 0;

    /* renamed from: com.google.android.material.timepicker.MaterialTimePicker$1, reason: invalid class name */
    public class AnonymousClass1 implements com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
        public void onDoubleTap() {
            com.google.android.material.timepicker.MaterialTimePicker.this.inputMode = 1;
            com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = com.google.android.material.timepicker.MaterialTimePicker.this;
            materialTimePicker.updateInputMode(materialTimePicker.modeButton);
            com.google.android.material.timepicker.MaterialTimePicker.this.timePickerTextInputPresenter.resetChecked();
        }
    }

    /* renamed from: com.google.android.material.timepicker.MaterialTimePicker$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            java.util.Iterator it = com.google.android.material.timepicker.MaterialTimePicker.this.positiveButtonListeners.iterator();
            while (it.hasNext()) {
                ((android.view.View.OnClickListener) it.next()).onClick(view);
            }
            com.google.android.material.timepicker.MaterialTimePicker.this.dismiss();
        }
    }

    /* renamed from: com.google.android.material.timepicker.MaterialTimePicker$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            java.util.Iterator it = com.google.android.material.timepicker.MaterialTimePicker.this.negativeButtonListeners.iterator();
            while (it.hasNext()) {
                ((android.view.View.OnClickListener) it.next()).onClick(view);
            }
            com.google.android.material.timepicker.MaterialTimePicker.this.dismiss();
        }
    }

    /* renamed from: com.google.android.material.timepicker.MaterialTimePicker$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = com.google.android.material.timepicker.MaterialTimePicker.this;
            materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
            com.google.android.material.timepicker.MaterialTimePicker materialTimePicker2 = com.google.android.material.timepicker.MaterialTimePicker.this;
            materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
        }
    }

    public static final class Builder {
        private int inputMode;
        private java.lang.CharSequence titleText;
        private com.google.android.material.timepicker.TimeModel time = new com.google.android.material.timepicker.TimeModel();
        private int titleTextResId = 0;
        private int overrideThemeResId = 0;

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker build() {
            return com.google.android.material.timepicker.MaterialTimePicker.newInstance(this);
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setHour(@androidx.annotation.IntRange(from = 0, to = 23) int i) {
            this.time.setHourOfDay(i);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setInputMode(int i) {
            this.inputMode = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setMinute(@androidx.annotation.IntRange(from = 0, to = 60) int i) {
            this.time.setMinute(i);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setTheme(@androidx.annotation.StyleRes int i) {
            this.overrideThemeResId = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setTimeFormat(int i) {
            com.google.android.material.timepicker.TimeModel timeModel = this.time;
            int i2 = timeModel.hour;
            int i3 = timeModel.minute;
            com.google.android.material.timepicker.TimeModel timeModel2 = new com.google.android.material.timepicker.TimeModel(i);
            this.time = timeModel2;
            timeModel2.setMinute(i3);
            this.time.setHourOfDay(i2);
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setTitleText(@androidx.annotation.StringRes int i) {
            this.titleTextResId = i;
            return this;
        }

        @androidx.annotation.NonNull
        public com.google.android.material.timepicker.MaterialTimePicker.Builder setTitleText(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }
    }

    private android.util.Pair<java.lang.Integer, java.lang.Integer> dataForMode(int i) {
        if (i == 0) {
            return new android.util.Pair<>(java.lang.Integer.valueOf(this.keyboardIcon), java.lang.Integer.valueOf(com.google.android.material.R.string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new android.util.Pair<>(java.lang.Integer.valueOf(this.clockIcon), java.lang.Integer.valueOf(com.google.android.material.R.string.material_timepicker_clock_mode_description));
        }
        throw new java.lang.IllegalArgumentException("no icon for mode: " + i);
    }

    private int getThemeResId() {
        int i = this.overrideThemeResId;
        if (i != 0) {
            return i;
        }
        android.util.TypedValue resolve = com.google.android.material.resources.MaterialAttributes.resolve(requireContext(), com.google.android.material.R.attr.materialTimePickerTheme);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private com.google.android.material.timepicker.TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int i) {
        if (i != 0) {
            if (this.timePickerTextInputPresenter == null) {
                this.timePickerTextInputPresenter = new com.google.android.material.timepicker.TimePickerTextInputPresenter((android.widget.LinearLayout) this.textInputStub.inflate(), this.time);
            }
            this.timePickerTextInputPresenter.clearCheck();
            return this.timePickerTextInputPresenter;
        }
        com.google.android.material.timepicker.TimePickerClockPresenter timePickerClockPresenter = this.timePickerClockPresenter;
        if (timePickerClockPresenter == null) {
            timePickerClockPresenter = new com.google.android.material.timepicker.TimePickerClockPresenter(this.timePickerView, this.time);
        }
        this.timePickerClockPresenter = timePickerClockPresenter;
        return timePickerClockPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @androidx.annotation.NonNull
    public static com.google.android.material.timepicker.MaterialTimePicker newInstance(@androidx.annotation.NonNull com.google.android.material.timepicker.MaterialTimePicker.Builder builder) {
        com.google.android.material.timepicker.MaterialTimePicker materialTimePicker = new com.google.android.material.timepicker.MaterialTimePicker();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, builder.time);
        bundle.putInt(INPUT_MODE_EXTRA, builder.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, builder.titleTextResId);
        bundle.putInt(OVERRIDE_THEME_RES_ID, builder.overrideThemeResId);
        if (builder.titleText != null) {
            bundle.putString(TITLE_TEXT_EXTRA, builder.titleText.toString());
        }
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void restoreState(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (bundle == null) {
            return;
        }
        com.google.android.material.timepicker.TimeModel timeModel = (com.google.android.material.timepicker.TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
        this.time = timeModel;
        if (timeModel == null) {
            this.time = new com.google.android.material.timepicker.TimeModel();
        }
        this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, 0);
        this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = bundle.getString(TITLE_TEXT_EXTRA);
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInputMode(com.google.android.material.button.MaterialButton materialButton) {
        com.google.android.material.timepicker.TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            timePickerPresenter.hide();
        }
        com.google.android.material.timepicker.TimePickerPresenter initializeOrRetrieveActivePresenterForMode = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter = initializeOrRetrieveActivePresenterForMode;
        initializeOrRetrieveActivePresenterForMode.show();
        this.activePresenter.invalidate();
        android.util.Pair<java.lang.Integer, java.lang.Integer> dataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((java.lang.Integer) dataForMode.first).intValue());
        materialButton.setContentDescription(getResources().getString(((java.lang.Integer) dataForMode.second).intValue()));
    }

    public boolean addOnCancelListener(@androidx.annotation.NonNull android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(@androidx.annotation.NonNull android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(@androidx.annotation.NonNull android.view.View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(@androidx.annotation.NonNull android.view.View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    @androidx.annotation.IntRange(from = 0, to = 23)
    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    @androidx.annotation.IntRange(from = 0, to = io.reactivex.internal.schedulers.IoScheduler.KEEP_ALIVE_TIME_DEFAULT)
    public int getMinute() {
        return this.time.minute;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.timepicker.TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnCancelListener> it = this.cancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    @androidx.annotation.NonNull
    public final android.app.Dialog onCreateDialog(@androidx.annotation.Nullable android.os.Bundle bundle) {
        android.app.Dialog dialog = new android.app.Dialog(requireContext(), getThemeResId());
        android.content.Context context = dialog.getContext();
        int resolveOrThrow = com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.colorSurface, com.google.android.material.timepicker.MaterialTimePicker.class.getCanonicalName());
        int i = com.google.android.material.R.attr.materialTimePickerStyle;
        int i2 = com.google.android.material.R.style.Widget_MaterialComponents_TimePicker;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context, null, i, i2);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, com.google.android.material.R.styleable.MaterialTimePicker, i, i2);
        this.clockIcon = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(resolveOrThrow));
        android.view.Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.NonNull
    public final android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) layoutInflater.inflate(com.google.android.material.R.layout.material_timepicker_dialog, viewGroup);
        com.google.android.material.timepicker.TimePickerView timePickerView = (com.google.android.material.timepicker.TimePickerView) viewGroup2.findViewById(com.google.android.material.R.id.material_timepicker_view);
        this.timePickerView = timePickerView;
        timePickerView.setOnDoubleTapListener(new com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass1());
        this.textInputStub = (android.view.ViewStub) viewGroup2.findViewById(com.google.android.material.R.id.material_textinput_timepicker);
        this.modeButton = (com.google.android.material.button.MaterialButton) viewGroup2.findViewById(com.google.android.material.R.id.material_timepicker_mode_button);
        android.widget.TextView textView = (android.widget.TextView) viewGroup2.findViewById(com.google.android.material.R.id.header_title);
        if (!android.text.TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        int i = this.titleResId;
        if (i != 0) {
            textView.setText(i);
        }
        updateInputMode(this.modeButton);
        ((android.widget.Button) viewGroup2.findViewById(com.google.android.material.R.id.material_timepicker_ok_button)).setOnClickListener(new com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass2());
        ((android.widget.Button) viewGroup2.findViewById(com.google.android.material.R.id.material_timepicker_cancel_button)).setOnClickListener(new com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass3());
        this.modeButton.setOnClickListener(new com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass4());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@androidx.annotation.NonNull android.content.DialogInterface dialogInterface) {
        java.util.Iterator<android.content.DialogInterface.OnDismissListener> it = this.dismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putString(TITLE_TEXT_EXTRA, this.titleText);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        this.timePickerView = null;
    }

    public boolean removeOnCancelListener(@androidx.annotation.NonNull android.content.DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(@androidx.annotation.NonNull android.content.DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(@androidx.annotation.NonNull android.view.View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(@androidx.annotation.NonNull android.view.View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }
}

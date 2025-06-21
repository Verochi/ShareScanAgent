package moji.com.mjweather.databinding;

/* loaded from: classes20.dex */
public final class CustomTimePickerDialogBinding implements androidx.viewbinding.ViewBinding {

    @androidx.annotation.NonNull
    public final android.widget.TimePicker n;

    @androidx.annotation.NonNull
    public final android.widget.TimePicker timePicker;

    public CustomTimePickerDialogBinding(@androidx.annotation.NonNull android.widget.TimePicker timePicker, @androidx.annotation.NonNull android.widget.TimePicker timePicker2) {
        this.n = timePicker;
        this.timePicker = timePicker2;
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.CustomTimePickerDialogBinding bind(@androidx.annotation.NonNull android.view.View view) {
        if (view == null) {
            throw new java.lang.NullPointerException("rootView");
        }
        android.widget.TimePicker timePicker = (android.widget.TimePicker) view;
        return new moji.com.mjweather.databinding.CustomTimePickerDialogBinding(timePicker, timePicker);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.CustomTimePickerDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @androidx.annotation.NonNull
    public static moji.com.mjweather.databinding.CustomTimePickerDialogBinding inflate(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, boolean z) {
        android.view.View inflate = layoutInflater.inflate(moji.com.mjweather.R.layout.custom_time_picker_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @androidx.annotation.NonNull
    public android.widget.TimePicker getRoot() {
        return this.n;
    }
}

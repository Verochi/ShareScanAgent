package androidx.databinding.adapters;

@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:year", type = android.widget.DatePicker.class), @androidx.databinding.InverseBindingMethod(attribute = "android:month", type = android.widget.DatePicker.class), @androidx.databinding.InverseBindingMethod(attribute = "android:day", method = "getDayOfMonth", type = android.widget.DatePicker.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DatePickerBindingAdapter {

    public static class DateChangedListener implements android.widget.DatePicker.OnDateChangedListener {
        androidx.databinding.InverseBindingListener mDayChanged;
        android.widget.DatePicker.OnDateChangedListener mListener;
        androidx.databinding.InverseBindingListener mMonthChanged;
        androidx.databinding.InverseBindingListener mYearChanged;

        private DateChangedListener() {
        }

        public /* synthetic */ DateChangedListener(androidx.databinding.adapters.DatePickerBindingAdapter.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public void onDateChanged(android.widget.DatePicker datePicker, int i, int i2, int i3) {
            android.widget.DatePicker.OnDateChangedListener onDateChangedListener = this.mListener;
            if (onDateChangedListener != null) {
                onDateChangedListener.onDateChanged(datePicker, i, i2, i3);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.mYearChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
            androidx.databinding.InverseBindingListener inverseBindingListener2 = this.mMonthChanged;
            if (inverseBindingListener2 != null) {
                inverseBindingListener2.onChange();
            }
            androidx.databinding.InverseBindingListener inverseBindingListener3 = this.mDayChanged;
            if (inverseBindingListener3 != null) {
                inverseBindingListener3.onChange();
            }
        }

        public void setListeners(android.widget.DatePicker.OnDateChangedListener onDateChangedListener, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.InverseBindingListener inverseBindingListener2, androidx.databinding.InverseBindingListener inverseBindingListener3) {
            this.mListener = onDateChangedListener;
            this.mYearChanged = inverseBindingListener;
            this.mMonthChanged = inverseBindingListener2;
            this.mDayChanged = inverseBindingListener3;
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:year", "android:month", "android:day", "android:onDateChanged", "android:yearAttrChanged", "android:monthAttrChanged", "android:dayAttrChanged"})
    public static void setListeners(android.widget.DatePicker datePicker, int i, int i2, int i3, android.widget.DatePicker.OnDateChangedListener onDateChangedListener, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.InverseBindingListener inverseBindingListener2, androidx.databinding.InverseBindingListener inverseBindingListener3) {
        if (i == 0) {
            i = datePicker.getYear();
        }
        if (i3 == 0) {
            i3 = datePicker.getDayOfMonth();
        }
        if (inverseBindingListener == null && inverseBindingListener2 == null && inverseBindingListener3 == null) {
            datePicker.init(i, i2, i3, onDateChangedListener);
            return;
        }
        int i4 = androidx.databinding.library.baseAdapters.R.id.onDateChanged;
        androidx.databinding.adapters.DatePickerBindingAdapter.DateChangedListener dateChangedListener = (androidx.databinding.adapters.DatePickerBindingAdapter.DateChangedListener) androidx.databinding.adapters.ListenerUtil.getListener(datePicker, i4);
        if (dateChangedListener == null) {
            dateChangedListener = new androidx.databinding.adapters.DatePickerBindingAdapter.DateChangedListener(null);
            androidx.databinding.adapters.ListenerUtil.trackListener(datePicker, dateChangedListener, i4);
        }
        dateChangedListener.setListeners(onDateChangedListener, inverseBindingListener, inverseBindingListener2, inverseBindingListener3);
        datePicker.init(i, i2, i3, dateChangedListener);
    }
}

package androidx.databinding.adapters;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class TimePickerBindingAdapter {

    /* renamed from: androidx.databinding.adapters.TimePickerBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.TimePicker.OnTimeChangedListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$hourChange;
        final /* synthetic */ android.widget.TimePicker.OnTimeChangedListener val$listener;
        final /* synthetic */ androidx.databinding.InverseBindingListener val$minuteChange;

        public AnonymousClass1(android.widget.TimePicker.OnTimeChangedListener onTimeChangedListener, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.InverseBindingListener inverseBindingListener2) {
            this.val$listener = onTimeChangedListener;
            this.val$hourChange = inverseBindingListener;
            this.val$minuteChange = inverseBindingListener2;
        }

        @Override // android.widget.TimePicker.OnTimeChangedListener
        public void onTimeChanged(android.widget.TimePicker timePicker, int i, int i2) {
            android.widget.TimePicker.OnTimeChangedListener onTimeChangedListener = this.val$listener;
            if (onTimeChangedListener != null) {
                onTimeChangedListener.onTimeChanged(timePicker, i, i2);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.val$hourChange;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
            androidx.databinding.InverseBindingListener inverseBindingListener2 = this.val$minuteChange;
            if (inverseBindingListener2 != null) {
                inverseBindingListener2.onChange();
            }
        }
    }

    @androidx.databinding.InverseBindingAdapter(attribute = "android:hour")
    public static int getHour(android.widget.TimePicker timePicker) {
        int hour;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            hour = timePicker.getHour();
            return hour;
        }
        java.lang.Integer currentHour = timePicker.getCurrentHour();
        if (currentHour == null) {
            return 0;
        }
        return currentHour.intValue();
    }

    @androidx.databinding.InverseBindingAdapter(attribute = "android:minute")
    public static int getMinute(android.widget.TimePicker timePicker) {
        int minute;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            minute = timePicker.getMinute();
            return minute;
        }
        java.lang.Integer currentMinute = timePicker.getCurrentMinute();
        if (currentMinute == null) {
            return 0;
        }
        return currentMinute.intValue();
    }

    @androidx.databinding.BindingAdapter({"android:hour"})
    public static void setHour(android.widget.TimePicker timePicker, int i) {
        int hour;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            if (timePicker.getCurrentHour().intValue() != i) {
                timePicker.setCurrentHour(java.lang.Integer.valueOf(i));
            }
        } else {
            hour = timePicker.getHour();
            if (hour != i) {
                timePicker.setHour(i);
            }
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onTimeChanged", "android:hourAttrChanged", "android:minuteAttrChanged"})
    public static void setListeners(android.widget.TimePicker timePicker, android.widget.TimePicker.OnTimeChangedListener onTimeChangedListener, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.InverseBindingListener inverseBindingListener2) {
        if (inverseBindingListener == null && inverseBindingListener2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            timePicker.setOnTimeChangedListener(new androidx.databinding.adapters.TimePickerBindingAdapter.AnonymousClass1(onTimeChangedListener, inverseBindingListener, inverseBindingListener2));
        }
    }

    @androidx.databinding.BindingAdapter({"android:minute"})
    public static void setMinute(android.widget.TimePicker timePicker, int i) {
        int minute;
        if (android.os.Build.VERSION.SDK_INT < 23) {
            if (timePicker.getCurrentMinute().intValue() != i) {
                timePicker.setCurrentHour(java.lang.Integer.valueOf(i));
            }
        } else {
            minute = timePicker.getMinute();
            if (minute != i) {
                timePicker.setMinute(i);
            }
        }
    }
}

package androidx.databinding.adapters;

@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:date", type = android.widget.CalendarView.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class CalendarViewBindingAdapter {

    /* renamed from: androidx.databinding.adapters.CalendarViewBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.CalendarView.OnDateChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChange;
        final /* synthetic */ android.widget.CalendarView.OnDateChangeListener val$onDayChange;

        public AnonymousClass1(android.widget.CalendarView.OnDateChangeListener onDateChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
            this.val$onDayChange = onDateChangeListener;
            this.val$attrChange = inverseBindingListener;
        }

        @Override // android.widget.CalendarView.OnDateChangeListener
        public void onSelectedDayChange(android.widget.CalendarView calendarView, int i, int i2, int i3) {
            android.widget.CalendarView.OnDateChangeListener onDateChangeListener = this.val$onDayChange;
            if (onDateChangeListener != null) {
                onDateChangeListener.onSelectedDayChange(calendarView, i, i2, i3);
            }
            this.val$attrChange.onChange();
        }
    }

    @androidx.databinding.BindingAdapter({"android:date"})
    public static void setDate(android.widget.CalendarView calendarView, long j) {
        if (calendarView.getDate() != j) {
            calendarView.setDate(j);
        }
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onSelectedDayChange", "android:dateAttrChanged"})
    public static void setListeners(android.widget.CalendarView calendarView, android.widget.CalendarView.OnDateChangeListener onDateChangeListener, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            calendarView.setOnDateChangeListener(new androidx.databinding.adapters.CalendarViewBindingAdapter.AnonymousClass1(onDateChangeListener, inverseBindingListener));
        }
    }
}

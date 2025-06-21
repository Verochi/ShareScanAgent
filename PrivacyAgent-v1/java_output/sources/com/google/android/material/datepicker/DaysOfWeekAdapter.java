package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class DaysOfWeekAdapter extends android.widget.BaseAdapter {
    private static final int CALENDAR_DAY_STYLE;
    private static final int NARROW_FORMAT = 4;

    @androidx.annotation.NonNull
    private final java.util.Calendar calendar;
    private final int daysInWeek;
    private final int firstDayOfWeek;

    static {
        CALENDAR_DAY_STYLE = android.os.Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public DaysOfWeekAdapter() {
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        this.calendar = utcCalendar;
        this.daysInWeek = utcCalendar.getMaximum(7);
        this.firstDayOfWeek = utcCalendar.getFirstDayOfWeek();
    }

    private int positionToDayOfWeek(int i) {
        int i2 = i + this.firstDayOfWeek;
        int i3 = this.daysInWeek;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    @androidx.annotation.Nullable
    public java.lang.Integer getItem(int i) {
        if (i >= this.daysInWeek) {
            return null;
        }
        return java.lang.Integer.valueOf(positionToDayOfWeek(i));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"WrongConstant"})
    public android.view.View getView(int i, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        android.widget.TextView textView = (android.widget.TextView) view;
        if (view == null) {
            textView = (android.widget.TextView) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.calendar.set(7, positionToDayOfWeek(i));
        textView.setText(this.calendar.getDisplayName(7, CALENDAR_DAY_STYLE, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(java.lang.String.format(viewGroup.getContext().getString(com.google.android.material.R.string.mtrl_picker_day_of_week_column_header), this.calendar.getDisplayName(7, 2, java.util.Locale.getDefault())));
        return textView;
    }
}

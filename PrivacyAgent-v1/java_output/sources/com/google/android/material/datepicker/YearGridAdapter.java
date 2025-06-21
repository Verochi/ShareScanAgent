package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class YearGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.material.datepicker.YearGridAdapter.ViewHolder> {
    private final com.google.android.material.datepicker.MaterialCalendar<?> materialCalendar;

    /* renamed from: com.google.android.material.datepicker.YearGridAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        final /* synthetic */ int val$year;

        public AnonymousClass1(int i) {
            this.val$year = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.datepicker.YearGridAdapter.this.materialCalendar.setCurrentMonth(com.google.android.material.datepicker.YearGridAdapter.this.materialCalendar.getCalendarConstraints().clamp(com.google.android.material.datepicker.Month.create(this.val$year, com.google.android.material.datepicker.YearGridAdapter.this.materialCalendar.getCurrentMonth().month)));
            com.google.android.material.datepicker.YearGridAdapter.this.materialCalendar.setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY);
        }
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        final android.widget.TextView textView;

        public ViewHolder(android.widget.TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(com.google.android.material.datepicker.MaterialCalendar<?> materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    @androidx.annotation.NonNull
    private android.view.View.OnClickListener createYearClickListener(int i) {
        return new com.google.android.material.datepicker.YearGridAdapter.AnonymousClass1(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    public int getPositionForYear(int i) {
        return i - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    public int getYearForPosition(int i) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@androidx.annotation.NonNull com.google.android.material.datepicker.YearGridAdapter.ViewHolder viewHolder, int i) {
        int yearForPosition = getYearForPosition(i);
        java.lang.String string = viewHolder.textView.getContext().getString(com.google.android.material.R.string.mtrl_picker_navigate_to_year_description);
        viewHolder.textView.setText(java.lang.String.format(java.util.Locale.getDefault(), com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(yearForPosition)));
        viewHolder.textView.setContentDescription(java.lang.String.format(string, java.lang.Integer.valueOf(yearForPosition)));
        com.google.android.material.datepicker.CalendarStyle calendarStyle = this.materialCalendar.getCalendarStyle();
        java.util.Calendar todayCalendar = com.google.android.material.datepicker.UtcDates.getTodayCalendar();
        com.google.android.material.datepicker.CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == yearForPosition ? calendarStyle.todayYear : calendarStyle.year;
        java.util.Iterator<java.lang.Long> it = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            todayCalendar.setTimeInMillis(it.next().longValue());
            if (todayCalendar.get(1) == yearForPosition) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder.textView);
        viewHolder.textView.setOnClickListener(createYearClickListener(yearForPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.YearGridAdapter.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        return new com.google.android.material.datepicker.YearGridAdapter.ViewHolder((android.widget.TextView) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R.layout.mtrl_calendar_year, viewGroup, false));
    }
}

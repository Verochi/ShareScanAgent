package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class MonthAdapter extends android.widget.BaseAdapter {
    static final int MAXIMUM_WEEKS = com.google.android.material.datepicker.UtcDates.getUtcCalendar().getMaximum(4);
    final com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    com.google.android.material.datepicker.CalendarStyle calendarStyle;
    final com.google.android.material.datepicker.DateSelector<?> dateSelector;
    final com.google.android.material.datepicker.Month month;
    private java.util.Collection<java.lang.Long> previouslySelectedDates;

    public MonthAdapter(com.google.android.material.datepicker.Month month, com.google.android.material.datepicker.DateSelector<?> dateSelector, com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
        this.previouslySelectedDates = dateSelector.getSelectedDays();
    }

    private void initializeStyles(android.content.Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new com.google.android.material.datepicker.CalendarStyle(context);
        }
    }

    private boolean isSelected(long j) {
        java.util.Iterator<java.lang.Long> it = this.dateSelector.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(j) == com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void updateSelectedState(@androidx.annotation.Nullable android.widget.TextView textView, long j) {
        com.google.android.material.datepicker.CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        if (this.calendarConstraints.getDateValidator().isValid(j)) {
            textView.setEnabled(true);
            calendarItemStyle = isSelected(j) ? this.calendarStyle.selectedDay : com.google.android.material.datepicker.UtcDates.getTodayCalendar().getTimeInMillis() == j ? this.calendarStyle.todayDay : this.calendarStyle.day;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.calendarStyle.invalidDay;
        }
        calendarItemStyle.styleItem(textView);
    }

    private void updateSelectedStateForDate(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView, long j) {
        if (com.google.android.material.datepicker.Month.create(j).equals(this.month)) {
            updateSelectedState((android.widget.TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(this.month.getDayOfMonth(j)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.month.daysInMonth + firstPositionInMonth();
    }

    @Override // android.widget.Adapter
    @androidx.annotation.Nullable
    public java.lang.Long getItem(int i) {
        if (i < this.month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return java.lang.Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public android.widget.TextView getView(int i, @androidx.annotation.Nullable android.view.View view, @androidx.annotation.NonNull android.view.ViewGroup viewGroup) {
        java.lang.Long item;
        initializeStyles(viewGroup.getContext());
        android.widget.TextView textView = (android.widget.TextView) view;
        if (view == null) {
            textView = (android.widget.TextView) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        if (firstPositionInMonth >= 0) {
            com.google.android.material.datepicker.Month month = this.month;
            if (firstPositionInMonth < month.daysInMonth) {
                int i2 = firstPositionInMonth + 1;
                textView.setTag(month);
                textView.setText(java.lang.String.format(textView.getResources().getConfiguration().locale, com.google.android.material.timepicker.TimeModel.NUMBER_FORMAT, java.lang.Integer.valueOf(i2)));
                long day = this.month.getDay(i2);
                if (this.month.year == com.google.android.material.datepicker.Month.current().year) {
                    textView.setContentDescription(com.google.android.material.datepicker.DateStrings.getMonthDayOfWeekDay(day));
                } else {
                    textView.setContentDescription(com.google.android.material.datepicker.DateStrings.getYearMonthDayOfWeekDay(day));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i);
                if (item != null) {
                    return textView;
                }
                updateSelectedState(textView, item.longValue());
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i);
        if (item != null) {
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean isFirstInRow(int i) {
        return i % this.month.daysInWeek == 0;
    }

    public boolean isLastInRow(int i) {
        return (i + 1) % this.month.daysInWeek == 0;
    }

    public int lastPositionInMonth() {
        return (this.month.daysFromStartOfWeekToFirstOfMonth() + this.month.daysInMonth) - 1;
    }

    public int positionToDay(int i) {
        return (i - this.month.daysFromStartOfWeekToFirstOfMonth()) + 1;
    }

    public void updateSelectedStates(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView) {
        java.util.Iterator<java.lang.Long> it = this.previouslySelectedDates.iterator();
        while (it.hasNext()) {
            updateSelectedStateForDate(materialCalendarGridView, it.next().longValue());
        }
        com.google.android.material.datepicker.DateSelector<?> dateSelector = this.dateSelector;
        if (dateSelector != null) {
            java.util.Iterator<java.lang.Long> it2 = dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                updateSelectedStateForDate(materialCalendarGridView, it2.next().longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    public boolean withinMonth(int i) {
        return i >= firstPositionInMonth() && i <= lastPositionInMonth();
    }
}

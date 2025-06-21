package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
class MonthsPagerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder> {

    @androidx.annotation.NonNull
    private final com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private final android.content.Context context;
    private final com.google.android.material.datepicker.DateSelector<?> dateSelector;
    private final int itemHeight;
    private final com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener onDayClickListener;

    /* renamed from: com.google.android.material.datepicker.MonthsPagerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.AdapterView.OnItemClickListener {
        final /* synthetic */ com.google.android.material.datepicker.MaterialCalendarGridView val$monthGrid;

        public AnonymousClass1(com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView) {
            this.val$monthGrid = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            if (this.val$monthGrid.getAdapter().withinMonth(i)) {
                com.google.android.material.datepicker.MonthsPagerAdapter.this.onDayClickListener.onDayClick(this.val$monthGrid.getAdapter().getItem(i).longValue());
            }
        }
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        final com.google.android.material.datepicker.MaterialCalendarGridView monthGrid;
        final android.widget.TextView monthTitle;

        public ViewHolder(@androidx.annotation.NonNull android.widget.LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            android.widget.TextView textView = (android.widget.TextView) linearLayout.findViewById(com.google.android.material.R.id.month_title);
            this.monthTitle = textView;
            androidx.core.view.ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (com.google.android.material.datepicker.MaterialCalendarGridView) linearLayout.findViewById(com.google.android.material.R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(@androidx.annotation.NonNull android.content.Context context, com.google.android.material.datepicker.DateSelector<?> dateSelector, @androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints calendarConstraints, com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener onDayClickListener) {
        com.google.android.material.datepicker.Month start = calendarConstraints.getStart();
        com.google.android.material.datepicker.Month end = calendarConstraints.getEnd();
        com.google.android.material.datepicker.Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new java.lang.IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new java.lang.IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int dayHeight = com.google.android.material.datepicker.MonthAdapter.MAXIMUM_WEEKS * com.google.android.material.datepicker.MaterialCalendar.getDayHeight(context);
        int dayHeight2 = com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(context) ? com.google.android.material.datepicker.MaterialCalendar.getDayHeight(context) : 0;
        this.context = context;
        this.itemHeight = dayHeight + dayHeight2;
        this.calendarConstraints = calendarConstraints;
        this.dateSelector = dateSelector;
        this.onDayClickListener = onDayClickListener;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.calendarConstraints.getStart().monthsLater(i).getStableId();
    }

    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.Month getPageMonth(int i) {
        return this.calendarConstraints.getStart().monthsLater(i);
    }

    @androidx.annotation.NonNull
    public java.lang.CharSequence getPageTitle(int i) {
        return getPageMonth(i).getLongName(this.context);
    }

    public int getPosition(@androidx.annotation.NonNull com.google.android.material.datepicker.Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@androidx.annotation.NonNull com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder viewHolder, int i) {
        com.google.android.material.datepicker.Month monthsLater = this.calendarConstraints.getStart().monthsLater(i);
        viewHolder.monthTitle.setText(monthsLater.getLongName(viewHolder.itemView.getContext()));
        com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView = (com.google.android.material.datepicker.MaterialCalendarGridView) viewHolder.monthGrid.findViewById(com.google.android.material.R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            com.google.android.material.datepicker.MonthAdapter monthAdapter = new com.google.android.material.datepicker.MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter((android.widget.ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new com.google.android.material.datepicker.MonthsPagerAdapter.AnonymousClass1(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @androidx.annotation.NonNull
    public com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder onCreateViewHolder(@androidx.annotation.NonNull android.view.ViewGroup viewGroup, int i) {
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.google.android.material.R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new androidx.recyclerview.widget.RecyclerView.LayoutParams(-1, this.itemHeight));
        return new com.google.android.material.datepicker.MonthsPagerAdapter.ViewHolder(linearLayout, true);
    }
}

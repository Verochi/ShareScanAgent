package com.google.android.material.datepicker;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class MaterialCalendar<S> extends com.google.android.material.datepicker.PickerFragment<S> {
    private static final java.lang.String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final java.lang.String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final java.lang.String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final java.lang.String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.CalendarConstraints calendarConstraints;
    private com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector;
    private com.google.android.material.datepicker.CalendarStyle calendarStyle;

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.Month current;

    @androidx.annotation.Nullable
    private com.google.android.material.datepicker.DateSelector<S> dateSelector;
    private android.view.View dayFrame;
    private androidx.recyclerview.widget.RecyclerView recyclerView;

    @androidx.annotation.StyleRes
    private int themeResId;
    private android.view.View yearFrame;
    private androidx.recyclerview.widget.RecyclerView yearSelector;

    @androidx.annotation.VisibleForTesting
    static final java.lang.Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";

    @androidx.annotation.VisibleForTesting
    static final java.lang.Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";

    @androidx.annotation.VisibleForTesting
    static final java.lang.Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";

    @androidx.annotation.VisibleForTesting
    static final java.lang.Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ int val$position;

        public AnonymousClass10(int i) {
            this.val$position = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.smoothScrollToPosition(this.val$position);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.android.material.datepicker.SmoothCalendarLayoutManager {
        final /* synthetic */ int val$orientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(android.content.Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.val$orientation = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state, @androidx.annotation.NonNull int[] iArr) {
            if (this.val$orientation == 0) {
                iArr[0] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getWidth();
                iArr[1] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getWidth();
            } else {
                iArr[0] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getHeight();
                iArr[1] = com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getHeight();
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$3, reason: invalid class name */
    public class AnonymousClass3 implements com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener {
        public AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
        public void onDayClick(long j) {
            if (com.google.android.material.datepicker.MaterialCalendar.this.calendarConstraints.getDateValidator().isValid(j)) {
                com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.select(j);
                java.util.Iterator<com.google.android.material.datepicker.OnSelectionChangedListener<S>> it = com.google.android.material.datepicker.MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.getSelection());
                }
                com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getAdapter().notifyDataSetChanged();
                if (com.google.android.material.datepicker.MaterialCalendar.this.yearSelector != null) {
                    com.google.android.material.datepicker.MaterialCalendar.this.yearSelector.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
        private final java.util.Calendar startItem = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        private final java.util.Calendar endItem = com.google.android.material.datepicker.UtcDates.getUtcCalendar();

        public AnonymousClass4() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State state) {
            if ((recyclerView.getAdapter() instanceof com.google.android.material.datepicker.YearGridAdapter) && (recyclerView.getLayoutManager() instanceof androidx.recyclerview.widget.GridLayoutManager)) {
                com.google.android.material.datepicker.YearGridAdapter yearGridAdapter = (com.google.android.material.datepicker.YearGridAdapter) recyclerView.getAdapter();
                androidx.recyclerview.widget.GridLayoutManager gridLayoutManager = (androidx.recyclerview.widget.GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.Pair<java.lang.Long, java.lang.Long> pair : com.google.android.material.datepicker.MaterialCalendar.this.dateSelector.getSelectedRanges()) {
                    java.lang.Long l = pair.first;
                    if (l != null && pair.second != null) {
                        this.startItem.setTimeInMillis(l.longValue());
                        this.endItem.setTimeInMillis(pair.second.longValue());
                        int positionForYear = yearGridAdapter.getPositionForYear(this.startItem.get(1));
                        int positionForYear2 = yearGridAdapter.getPositionForYear(this.endItem.get(1));
                        android.view.View findViewByPosition = gridLayoutManager.findViewByPosition(positionForYear);
                        android.view.View findViewByPosition2 = gridLayoutManager.findViewByPosition(positionForYear2);
                        int spanCount = positionForYear / gridLayoutManager.getSpanCount();
                        int spanCount2 = positionForYear2 / gridLayoutManager.getSpanCount();
                        int i = spanCount;
                        while (i <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i) != null) {
                                canvas.drawRect(i == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0, r9.getTop() + com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.year.getTopInset(), i == spanCount2 ? findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.year.getBottomInset(), com.google.android.material.datepicker.MaterialCalendar.this.calendarStyle.rangeFill);
                            }
                            i++;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$5, reason: invalid class name */
    public class AnonymousClass5 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass5() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setHintText(com.google.android.material.datepicker.MaterialCalendar.this.dayFrame.getVisibility() == 0 ? com.google.android.material.datepicker.MaterialCalendar.this.getString(com.google.android.material.R.string.mtrl_picker_toggle_to_year_selection) : com.google.android.material.datepicker.MaterialCalendar.this.getString(com.google.android.material.R.string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$6, reason: invalid class name */
    public class AnonymousClass6 extends androidx.recyclerview.widget.RecyclerView.OnScrollListener {
        final /* synthetic */ com.google.android.material.button.MaterialButton val$monthDropSelect;
        final /* synthetic */ com.google.android.material.datepicker.MonthsPagerAdapter val$monthsPagerAdapter;

        public AnonymousClass6(com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter, com.google.android.material.button.MaterialButton materialButton) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
            this.val$monthDropSelect = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
            if (i == 0) {
                recyclerView.announceForAccessibility(this.val$monthDropSelect.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView recyclerView, int i, int i2) {
            int findFirstVisibleItemPosition = i < 0 ? com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() : com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
            com.google.android.material.datepicker.MaterialCalendar.this.current = this.val$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition);
            this.val$monthDropSelect.setText(this.val$monthsPagerAdapter.getPageTitle(findFirstVisibleItemPosition));
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.material.datepicker.MaterialCalendar.this.toggleVisibleSelector();
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.MonthsPagerAdapter val$monthsPagerAdapter;

        public AnonymousClass8(com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            int findFirstVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < com.google.android.material.datepicker.MaterialCalendar.this.recyclerView.getAdapter().getItemCount()) {
                com.google.android.material.datepicker.MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.MonthsPagerAdapter val$monthsPagerAdapter;

        public AnonymousClass9(com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            int findLastVisibleItemPosition = com.google.android.material.datepicker.MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                com.google.android.material.datepicker.MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition));
            }
        }
    }

    public enum CalendarSelector {
        DAY,
        YEAR
    }

    public interface OnDayClickListener {
        void onDayClick(long j);
    }

    private void addActionsToMonthNavigation(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter) {
        com.google.android.material.button.MaterialButton materialButton = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R.id.month_navigation_fragment_toggle);
        materialButton.setTag(SELECTOR_TOGGLE_TAG);
        androidx.core.view.ViewCompat.setAccessibilityDelegate(materialButton, new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass5());
        com.google.android.material.button.MaterialButton materialButton2 = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R.id.month_navigation_previous);
        materialButton2.setTag(NAVIGATION_PREV_TAG);
        com.google.android.material.button.MaterialButton materialButton3 = (com.google.android.material.button.MaterialButton) view.findViewById(com.google.android.material.R.id.month_navigation_next);
        materialButton3.setTag(NAVIGATION_NEXT_TAG);
        this.yearFrame = view.findViewById(com.google.android.material.R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(com.google.android.material.R.id.mtrl_calendar_day_selector_frame);
        setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY);
        materialButton.setText(this.current.getLongName(view.getContext()));
        this.recyclerView.addOnScrollListener(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass6(monthsPagerAdapter, materialButton));
        materialButton.setOnClickListener(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass7());
        materialButton3.setOnClickListener(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass8(monthsPagerAdapter));
        materialButton2.setOnClickListener(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass9(monthsPagerAdapter));
    }

    @androidx.annotation.NonNull
    private androidx.recyclerview.widget.RecyclerView.ItemDecoration createItemDecoration() {
        return new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass4();
    }

    @androidx.annotation.Px
    public static int getDayHeight(@androidx.annotation.NonNull android.content.Context context) {
        return context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height);
    }

    @androidx.annotation.NonNull
    public static <T> com.google.android.material.datepicker.MaterialCalendar<T> newInstance(@androidx.annotation.NonNull com.google.android.material.datepicker.DateSelector<T> dateSelector, @androidx.annotation.StyleRes int i, @androidx.annotation.NonNull com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
        com.google.android.material.datepicker.MaterialCalendar<T> materialCalendar = new com.google.android.material.datepicker.MaterialCalendar<>();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void postSmoothRecyclerViewScroll(int i) {
        this.recyclerView.post(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass10(i));
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(@androidx.annotation.NonNull com.google.android.material.datepicker.OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    @androidx.annotation.Nullable
    public com.google.android.material.datepicker.CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    public com.google.android.material.datepicker.CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    @androidx.annotation.Nullable
    public com.google.android.material.datepicker.Month getCurrentMonth() {
        return this.current;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    @androidx.annotation.Nullable
    public com.google.android.material.datepicker.DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    @androidx.annotation.NonNull
    public androidx.recyclerview.widget.LinearLayoutManager getLayoutManager() {
        return (androidx.recyclerview.widget.LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (com.google.android.material.datepicker.DateSelector) bundle.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.current = (com.google.android.material.datepicker.Month) bundle.getParcelable(CURRENT_MONTH_KEY);
    }

    @Override // androidx.fragment.app.Fragment
    @androidx.annotation.NonNull
    public android.view.View onCreateView(@androidx.annotation.NonNull android.view.LayoutInflater layoutInflater, @androidx.annotation.Nullable android.view.ViewGroup viewGroup, @androidx.annotation.Nullable android.os.Bundle bundle) {
        int i;
        int i2;
        android.view.ContextThemeWrapper contextThemeWrapper = new android.view.ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new com.google.android.material.datepicker.CalendarStyle(contextThemeWrapper);
        android.view.LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        com.google.android.material.datepicker.Month start = this.calendarConstraints.getStart();
        if (com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            i = com.google.android.material.R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = com.google.android.material.R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        android.view.View inflate = cloneInContext.inflate(i, viewGroup, false);
        android.widget.GridView gridView = (android.widget.GridView) inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_days_of_week);
        androidx.core.view.ViewCompat.setAccessibilityDelegate(gridView, new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass1());
        gridView.setAdapter((android.widget.ListAdapter) new com.google.android.material.datepicker.DaysOfWeekAdapter());
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass2(getContext(), i2, false, i2));
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter = new com.google.android.material.datepicker.MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new com.google.android.material.datepicker.MaterialCalendar.AnonymousClass3());
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(com.google.android.material.R.integer.mtrl_calendar_year_selector_span);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) inflate.findViewById(com.google.android.material.R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager((android.content.Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new com.google.android.material.datepicker.YearGridAdapter(this));
            this.yearSelector.addItemDecoration(createItemDecoration());
        }
        if (inflate.findViewById(com.google.android.material.R.id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(inflate, monthsPagerAdapter);
        }
        if (!com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            new androidx.recyclerview.widget.PagerSnapHelper().attachToRecyclerView(this.recyclerView);
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.getPosition(this.current));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@androidx.annotation.NonNull android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    public void setCurrentMonth(com.google.android.material.datepicker.Month month) {
        com.google.android.material.datepicker.MonthsPagerAdapter monthsPagerAdapter = (com.google.android.material.datepicker.MonthsPagerAdapter) this.recyclerView.getAdapter();
        int position = monthsPagerAdapter.getPosition(month);
        int position2 = position - monthsPagerAdapter.getPosition(this.current);
        boolean z = java.lang.Math.abs(position2) > 3;
        boolean z2 = position2 > 0;
        this.current = month;
        if (z && z2) {
            this.recyclerView.scrollToPosition(position - 3);
            postSmoothRecyclerViewScroll(position);
        } else if (!z) {
            postSmoothRecyclerViewScroll(position);
        } else {
            this.recyclerView.scrollToPosition(position + 3);
            postSmoothRecyclerViewScroll(position);
        }
    }

    public void setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((com.google.android.material.datepicker.YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
        } else if (calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    public void toggleVisibleSelector() {
        com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector = this.calendarSelector;
        com.google.android.material.datepicker.MaterialCalendar.CalendarSelector calendarSelector2 = com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            setSelector(com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY);
        } else if (calendarSelector == com.google.android.material.datepicker.MaterialCalendar.CalendarSelector.DAY) {
            setSelector(calendarSelector2);
        }
    }
}

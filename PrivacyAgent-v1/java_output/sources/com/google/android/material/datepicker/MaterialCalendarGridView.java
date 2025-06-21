package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
final class MaterialCalendarGridView extends android.widget.GridView {
    private final java.util.Calendar dayCompute;
    private final boolean nestedScrollable;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendarGridView$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(android.content.Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        if (com.google.android.material.datepicker.MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(com.google.android.material.R.id.cancel_button);
            setNextFocusRightId(com.google.android.material.R.id.confirm_button);
        }
        this.nestedScrollable = com.google.android.material.datepicker.MaterialDatePicker.isNestedScrollable(getContext());
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this, new com.google.android.material.datepicker.MaterialCalendarGridView.AnonymousClass1());
    }

    private void gainFocus(int i, android.graphics.Rect rect) {
        if (i == 33) {
            setSelection(getAdapter().lastPositionInMonth());
        } else if (i == 130) {
            setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private static int horizontalMidPoint(@androidx.annotation.NonNull android.view.View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(@androidx.annotation.Nullable java.lang.Long l, @androidx.annotation.Nullable java.lang.Long l2, @androidx.annotation.Nullable java.lang.Long l3, @androidx.annotation.Nullable java.lang.Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @androidx.annotation.NonNull
    public android.widget.ListAdapter getAdapter2() {
        return (com.google.android.material.datepicker.MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@androidx.annotation.NonNull android.graphics.Canvas canvas) {
        int dayToPosition;
        int horizontalMidPoint;
        int dayToPosition2;
        int horizontalMidPoint2;
        int width;
        int i;
        com.google.android.material.datepicker.MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        com.google.android.material.datepicker.MonthAdapter adapter = getAdapter();
        com.google.android.material.datepicker.DateSelector<?> dateSelector = adapter.dateSelector;
        com.google.android.material.datepicker.CalendarStyle calendarStyle = adapter.calendarStyle;
        java.lang.Long item = adapter.getItem(adapter.firstPositionInMonth());
        java.lang.Long item2 = adapter.getItem(adapter.lastPositionInMonth());
        for (androidx.core.util.Pair<java.lang.Long, java.lang.Long> pair : dateSelector.getSelectedRanges()) {
            java.lang.Long l = pair.first;
            if (l != null) {
                if (pair.second != null) {
                    long longValue = l.longValue();
                    long longValue2 = pair.second.longValue();
                    if (!skipMonth(item, item2, java.lang.Long.valueOf(longValue), java.lang.Long.valueOf(longValue2))) {
                        boolean isLayoutRtl = com.google.android.material.internal.ViewUtils.isLayoutRtl(this);
                        if (longValue < item.longValue()) {
                            dayToPosition = adapter.firstPositionInMonth();
                            horizontalMidPoint = adapter.isFirstInRow(dayToPosition) ? 0 : !isLayoutRtl ? materialCalendarGridView.getChildAt(dayToPosition - 1).getRight() : materialCalendarGridView.getChildAt(dayToPosition - 1).getLeft();
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                            dayToPosition = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            horizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAt(dayToPosition));
                        }
                        if (longValue2 > item2.longValue()) {
                            dayToPosition2 = java.lang.Math.min(adapter.lastPositionInMonth(), getChildCount() - 1);
                            horizontalMidPoint2 = adapter.isLastInRow(dayToPosition2) ? getWidth() : !isLayoutRtl ? materialCalendarGridView.getChildAt(dayToPosition2).getRight() : materialCalendarGridView.getChildAt(dayToPosition2).getLeft();
                        } else {
                            materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                            dayToPosition2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                            horizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAt(dayToPosition2));
                        }
                        int itemId = (int) adapter.getItemId(dayToPosition);
                        int itemId2 = (int) adapter.getItemId(dayToPosition2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            android.view.View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + calendarStyle.day.getTopInset();
                            int bottom = childAt.getBottom() - calendarStyle.day.getBottomInset();
                            if (isLayoutRtl) {
                                int i2 = dayToPosition2 > numColumns2 ? 0 : horizontalMidPoint2;
                                width = numColumns > dayToPosition ? getWidth() : horizontalMidPoint;
                                i = i2;
                            } else {
                                i = numColumns > dayToPosition ? 0 : horizontalMidPoint;
                                width = dayToPosition2 > numColumns2 ? getWidth() : horizontalMidPoint2;
                            }
                            canvas.drawRect(i, top, width, bottom, calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (!super.onKeyDown(i, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != i) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.nestedScrollable) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(android.widget.ListAdapter listAdapter) {
        if (!(listAdapter instanceof com.google.android.material.datepicker.MonthAdapter)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("%1$s must have its Adapter set to a %2$s", com.google.android.material.datepicker.MaterialCalendarGridView.class.getCanonicalName(), com.google.android.material.datepicker.MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        if (i < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(i);
        }
    }
}

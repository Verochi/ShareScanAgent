package com.google.android.material.datepicker;

/* loaded from: classes22.dex */
final class CalendarStyle {

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle day;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle invalidDay;

    @androidx.annotation.NonNull
    final android.graphics.Paint rangeFill;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle selectedDay;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle selectedYear;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle todayDay;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle todayYear;

    @androidx.annotation.NonNull
    final com.google.android.material.datepicker.CalendarItemStyle year;

    public CalendarStyle(@androidx.annotation.NonNull android.content.Context context) {
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.resources.MaterialAttributes.resolveOrThrow(context, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.datepicker.MaterialCalendar.class.getCanonicalName()), com.google.android.material.R.styleable.MaterialCalendar);
        this.day = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_dayStyle, 0));
        this.invalidDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.selectedDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.todayDay = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_dayTodayStyle, 0));
        android.content.res.ColorStateList colorStateList = com.google.android.material.resources.MaterialResources.getColorStateList(context, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialCalendar_rangeFillColor);
        this.year = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_yearStyle, 0));
        this.selectedYear = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.todayYear = com.google.android.material.datepicker.CalendarItemStyle.create(context, obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialCalendar_yearTodayStyle, 0));
        android.graphics.Paint paint = new android.graphics.Paint();
        this.rangeFill = paint;
        paint.setColor(colorStateList.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}

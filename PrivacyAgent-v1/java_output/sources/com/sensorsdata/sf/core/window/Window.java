package com.sensorsdata.sf.core.window;

/* loaded from: classes19.dex */
public class Window {
    public static final java.lang.String UNIT_DAY = "DAY";
    public static final java.lang.String UNIT_HOUR = "HOUR";
    public static final java.lang.String UNIT_MINUTE = "MINUTE";
    public static final java.lang.String UNIT_MONTH = "MONTH";
    public static final java.lang.String UNIT_SECOND = "SECOND";
    public static final java.lang.String UNIT_WEEK = "WEEK";
    private int count;
    private long endTime;
    public int limit;
    public boolean natural;
    private long startTime;
    public java.lang.String unit;
    public int value;

    public void addCount() {
        this.count++;
    }

    public int changeToSecond(int i, java.lang.String str) {
        return android.text.TextUtils.equals(UNIT_MINUTE, str) ? changeToSecond(i * 60, UNIT_SECOND) : android.text.TextUtils.equals(UNIT_HOUR, str) ? changeToSecond(i * 60, UNIT_MINUTE) : android.text.TextUtils.equals(UNIT_DAY, str) ? changeToSecond(i * 24, UNIT_HOUR) : android.text.TextUtils.equals(UNIT_WEEK, str) ? changeToSecond(i * 7, UNIT_DAY) : android.text.TextUtils.equals(UNIT_MONTH, str) ? changeToSecond(i * 30, UNIT_DAY) : i;
    }

    public int getCount() {
        return this.count;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isFinished() {
        return java.lang.System.currentTimeMillis() > this.endTime;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setStartTime(long j) {
        this.startTime = j;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTimeInMillis(j);
        if (this.natural) {
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
        }
        if (android.text.TextUtils.equals(UNIT_SECOND, this.unit)) {
            this.endTime = j + (this.value * 1000);
            return;
        }
        if (android.text.TextUtils.equals(UNIT_MINUTE, this.unit)) {
            this.endTime = j + (this.value * 60000);
            return;
        }
        if (android.text.TextUtils.equals(UNIT_HOUR, this.unit)) {
            this.endTime = j + (this.value * 3600000);
            return;
        }
        if (android.text.TextUtils.equals(UNIT_DAY, this.unit)) {
            if (!this.natural) {
                this.endTime = j + (this.value * 86400000);
                return;
            } else {
                calendar.add(6, this.value - 1);
                this.endTime = calendar.getTimeInMillis();
                return;
            }
        }
        if (android.text.TextUtils.equals(UNIT_WEEK, this.unit)) {
            if (!this.natural) {
                this.endTime = j + (this.value * 604800000);
                return;
            }
            calendar.setFirstDayOfWeek(2);
            calendar.set(7, calendar.getActualMaximum(7));
            calendar.add(7, 1);
            calendar.add(3, this.value - 1);
            this.endTime = calendar.getTimeInMillis();
            return;
        }
        if (android.text.TextUtils.equals(UNIT_MONTH, this.unit)) {
            if (!this.natural) {
                this.endTime = j + (this.value * com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME);
                return;
            }
            calendar.add(2, this.value - 1);
            calendar.set(5, calendar.getActualMaximum(5));
            this.endTime = calendar.getTimeInMillis();
        }
    }

    public java.lang.String toString() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
        return "Window{count=" + this.count + ", value=" + this.value + ", unit='" + this.unit + "', natural=" + this.natural + ", limit=" + this.limit + ", startTime=" + simpleDateFormat.format(java.lang.Long.valueOf(this.startTime)) + ", endTime=" + simpleDateFormat.format(java.lang.Long.valueOf(this.endTime)) + '}';
    }
}

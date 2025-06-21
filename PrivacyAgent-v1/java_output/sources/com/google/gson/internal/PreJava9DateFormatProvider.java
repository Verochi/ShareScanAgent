package com.google.gson.internal;

/* loaded from: classes22.dex */
public class PreJava9DateFormatProvider {
    private static java.lang.String getDateFormatPattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i == 1) {
            return "MMMM d, y";
        }
        if (i == 2) {
            return "MMM d, y";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new java.lang.IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    private static java.lang.String getDatePartOfDateTimePattern(int i) {
        if (i == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i == 1) {
            return "MMMM d, yyyy";
        }
        if (i == 2) {
            return "MMM d, yyyy";
        }
        if (i == 3) {
            return "M/d/yy";
        }
        throw new java.lang.IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    private static java.lang.String getTimePartOfDateTimePattern(int i) {
        if (i == 0 || i == 1) {
            return "h:mm:ss a z";
        }
        if (i == 2) {
            return "h:mm:ss a";
        }
        if (i == 3) {
            return "h:mm a";
        }
        throw new java.lang.IllegalArgumentException("Unknown DateFormat style: " + i);
    }

    public static java.text.DateFormat getUSDateFormat(int i) {
        return new java.text.SimpleDateFormat(getDateFormatPattern(i), java.util.Locale.US);
    }

    public static java.text.DateFormat getUSDateTimeFormat(int i, int i2) {
        return new java.text.SimpleDateFormat(getDatePartOfDateTimePattern(i) + " " + getTimePartOfDateTimePattern(i2), java.util.Locale.US);
    }
}

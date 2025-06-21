package com.google.gson.internal.bind.util;

/* loaded from: classes22.dex */
public class ISO8601Utils {
    private static final java.lang.String UTC_ID = "UTC";
    private static final java.util.TimeZone TIMEZONE_UTC = java.util.TimeZone.getTimeZone(UTC_ID);

    private static boolean checkOffset(java.lang.String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static java.lang.String format(java.util.Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static java.lang.String format(java.util.Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static java.lang.String format(java.util.Date date, boolean z, java.util.TimeZone timeZone) {
        java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(timeZone, java.util.Locale.US);
        gregorianCalendar.setTime(date);
        java.lang.StringBuilder sb = new java.lang.StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = java.lang.Math.abs(i / 60);
            int abs2 = java.lang.Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int indexOfNonDigit(java.lang.String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(java.lang.StringBuilder sb, int i, int i2) {
        java.lang.String num = java.lang.Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:18:0x0050, B:20:0x0060, B:21:0x0062, B:23:0x006e, B:24:0x0070, B:26:0x0076, B:30:0x0080, B:35:0x0090, B:37:0x0098, B:42:0x00c9, B:44:0x00cf, B:46:0x00d6, B:47:0x0183, B:52:0x00e0, B:53:0x00fb, B:54:0x00fc, B:57:0x0118, B:59:0x0125, B:62:0x012e, B:64:0x014d, B:67:0x015c, B:68:0x017e, B:70:0x0181, B:71:0x0107, B:72:0x01b4, B:73:0x01bb, B:74:0x00b0, B:75:0x00b3), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:18:0x0050, B:20:0x0060, B:21:0x0062, B:23:0x006e, B:24:0x0070, B:26:0x0076, B:30:0x0080, B:35:0x0090, B:37:0x0098, B:42:0x00c9, B:44:0x00cf, B:46:0x00d6, B:47:0x0183, B:52:0x00e0, B:53:0x00fb, B:54:0x00fc, B:57:0x0118, B:59:0x0125, B:62:0x012e, B:64:0x014d, B:67:0x015c, B:68:0x017e, B:70:0x0181, B:71:0x0107, B:72:0x01b4, B:73:0x01bb, B:74:0x00b0, B:75:0x00b3), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.Date parse(java.lang.String str, java.text.ParsePosition parsePosition) throws java.text.ParseException {
        java.lang.String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        java.util.TimeZone timeZone;
        char charAt;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int parseInt = parseInt(str, index, i5);
            if (checkOffset(str, i5, '-')) {
                i5++;
            }
            int i6 = i5 + 2;
            int parseInt2 = parseInt(str, i5, i6);
            if (checkOffset(str, i6, '-')) {
                i6++;
            }
            int i7 = i6 + 2;
            int parseInt3 = parseInt(str, i6, i7);
            boolean checkOffset = checkOffset(str, i7, 'T');
            if (!checkOffset && str.length() <= i7) {
                java.util.GregorianCalendar gregorianCalendar = new java.util.GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (checkOffset) {
                int i8 = i7 + 1;
                int i9 = i8 + 2;
                int parseInt4 = parseInt(str, i8, i9);
                if (checkOffset(str, i9, ':')) {
                    i9++;
                }
                int i10 = i9 + 2;
                int parseInt5 = parseInt(str, i9, i10);
                if (checkOffset(str, i10, ':')) {
                    i10++;
                }
                if (str.length() > i10 && (charAt = str.charAt(i10)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i11 = i10 + 2;
                    i4 = parseInt(str, i10, i11);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (checkOffset(str, i11, '.')) {
                        int i12 = i11 + 1;
                        int indexOfNonDigit = indexOfNonDigit(str, i12 + 1);
                        int min = java.lang.Math.min(indexOfNonDigit, i12 + 3);
                        int parseInt6 = parseInt(str, i12, min);
                        int i13 = min - i12;
                        if (i13 == 1) {
                            parseInt6 *= 100;
                        } else if (i13 == 2) {
                            parseInt6 *= 10;
                        }
                        i2 = parseInt5;
                        i3 = parseInt6;
                        i = parseInt4;
                        i7 = indexOfNonDigit;
                    } else {
                        i2 = parseInt5;
                        i = parseInt4;
                        i7 = i11;
                        i3 = 0;
                    }
                    if (str.length() > i7) {
                        throw new java.lang.IllegalArgumentException("No time zone indicator");
                    }
                    char charAt2 = str.charAt(i7);
                    if (charAt2 == 'Z') {
                        timeZone = TIMEZONE_UTC;
                        length = i7 + 1;
                    } else {
                        if (charAt2 != '+' && charAt2 != '-') {
                            throw new java.lang.IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                        }
                        java.lang.String substring = str.substring(i7);
                        if (substring.length() < 5) {
                            substring = substring + org.apache.tools.tar.TarConstants.VERSION_POSIX;
                        }
                        length = i7 + substring.length();
                        if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                            java.lang.String str3 = "GMT" + substring;
                            java.util.TimeZone timeZone2 = java.util.TimeZone.getTimeZone(str3);
                            java.lang.String id = timeZone2.getID();
                            if (!id.equals(str3) && !id.replace(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR, "").equals(str3)) {
                                throw new java.lang.IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                            }
                            timeZone = timeZone2;
                        }
                        timeZone = TIMEZONE_UTC;
                    }
                    java.util.GregorianCalendar gregorianCalendar2 = new java.util.GregorianCalendar(timeZone);
                    gregorianCalendar2.setLenient(false);
                    gregorianCalendar2.set(1, parseInt);
                    gregorianCalendar2.set(2, parseInt2 - 1);
                    gregorianCalendar2.set(5, parseInt3);
                    gregorianCalendar2.set(11, i);
                    gregorianCalendar2.set(12, i2);
                    gregorianCalendar2.set(13, i4);
                    gregorianCalendar2.set(14, i3);
                    parsePosition.setIndex(length);
                    return gregorianCalendar2.getTime();
                }
                i2 = parseInt5;
                i3 = 0;
                i = parseInt4;
                i7 = i10;
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            i4 = 0;
            if (str.length() > i7) {
            }
        } catch (java.lang.IllegalArgumentException | java.lang.IndexOutOfBoundsException | java.lang.NumberFormatException e) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = kotlin.text.Typography.quote + str + kotlin.text.Typography.quote;
            }
            java.lang.String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            java.text.ParseException parseException = new java.text.ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static int parseInt(java.lang.String str, int i, int i2) throws java.lang.NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new java.lang.NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = java.lang.Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new java.lang.NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = java.lang.Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new java.lang.NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }
}

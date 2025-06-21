package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public final class DateUtils {
    public static final java.text.DateFormat DATE_HEADER_FORMAT;
    public static final java.lang.ThreadLocal<java.text.DateFormat> EN_US_DATE_FORMAT_MIN;
    public static final java.lang.ThreadLocal<java.text.DateFormat> EN_US_DATE_FORMAT_SEC;
    public static final java.lang.String ISO8601_DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final java.lang.String ISO8601_DATE_PATTERN = "yyyy-MM-dd";
    public static final java.lang.String ISO8601_TIME_PATTERN = "HH:mm:ss";
    public static final java.text.DateFormat a;
    public static final java.text.MessageFormat b;
    public static final double[] c;
    public static final java.lang.String[] d;
    public static final java.lang.String[] e;
    public static final java.text.ChoiceFormat f;
    public static final java.text.ChoiceFormat g;
    public static final java.lang.ThreadLocal<java.text.DateFormat> h;
    public static final java.util.regex.Pattern i;

    /* renamed from: org.apache.tools.ant.util.DateUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.text.DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.text.DateFormat initialValue() {
            return new java.text.SimpleDateFormat("MM/dd/yyyy hh:mm a", java.util.Locale.US);
        }
    }

    /* renamed from: org.apache.tools.ant.util.DateUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.lang.ThreadLocal<java.text.DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.text.DateFormat initialValue() {
            return new java.text.SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", java.util.Locale.US);
        }
    }

    /* renamed from: org.apache.tools.ant.util.DateUtils$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.lang.ThreadLocal<java.text.DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.text.DateFormat initialValue() {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
        }
    }

    static {
        java.util.Locale locale = java.util.Locale.US;
        DATE_HEADER_FORMAT = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ", locale);
        a = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss ", locale);
        java.text.MessageFormat messageFormat = new java.text.MessageFormat("{0}{1}");
        b = messageFormat;
        double[] dArr = {0.0d, 1.0d, 2.0d};
        c = dArr;
        java.lang.String[] strArr = {"", "1 minute ", "{0,number,###############} minutes "};
        d = strArr;
        java.lang.String[] strArr2 = {"0 seconds", "1 second", "{1,number} seconds"};
        e = strArr2;
        java.text.ChoiceFormat choiceFormat = new java.text.ChoiceFormat(dArr, strArr);
        f = choiceFormat;
        java.text.ChoiceFormat choiceFormat2 = new java.text.ChoiceFormat(dArr, strArr2);
        g = choiceFormat2;
        EN_US_DATE_FORMAT_MIN = new org.apache.tools.ant.util.DateUtils.AnonymousClass1();
        EN_US_DATE_FORMAT_SEC = new org.apache.tools.ant.util.DateUtils.AnonymousClass2();
        messageFormat.setFormat(0, choiceFormat);
        messageFormat.setFormat(1, choiceFormat2);
        h = new org.apache.tools.ant.util.DateUtils.AnonymousClass3();
        i = java.util.regex.Pattern.compile("^(\\d{4,}-\\d{2}-\\d{2})[Tt ](\\d{2}:\\d{2}(:\\d{2}(\\.\\d{3})?)?) ?(?:Z|([+-]\\d{2})(?::?(\\d{2}))?)?$");
    }

    public static java.text.DateFormat a(java.lang.String str) {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
        simpleDateFormat.setLenient(true);
        return simpleDateFormat;
    }

    public static java.lang.String format(long j, java.lang.String str) {
        return format(new java.util.Date(j), str);
    }

    public static java.lang.String format(java.util.Date date, java.lang.String str) {
        return a(str).format(date);
    }

    public static java.lang.String formatElapsedTime(long j) {
        long j2 = j / 1000;
        return b.format(new java.lang.Object[]{new java.lang.Long(j2 / 60), new java.lang.Long(j2 % 60)});
    }

    public static java.lang.String getDateForHeader() {
        java.lang.String str;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int offset = calendar.getTimeZone().getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14));
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(offset < 0 ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : "+");
        int abs = java.lang.Math.abs(offset);
        int i2 = abs / 3600000;
        int i3 = (abs / 60000) - (i2 * 60);
        if (i2 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(i2);
        if (i3 < 10) {
            stringBuffer.append("0");
        }
        stringBuffer.append(i3);
        java.text.DateFormat dateFormat = a;
        synchronized (dateFormat) {
            str = dateFormat.format(calendar.getTime()) + stringBuffer.toString();
        }
        return str;
    }

    public static int getPhaseOfMoon(java.util.Calendar calendar) {
        int i2 = calendar.get(6);
        int i3 = ((calendar.get(1) - 1900) % 19) + 1;
        int i4 = ((i3 * 11) + 18) % 30;
        if ((i4 == 25 && i3 > 11) || i4 == 24) {
            i4++;
        }
        return (((((i2 + i4) * 6) + 11) % 177) / 22) & 7;
    }

    public static java.util.Date parseDateFromHeader(java.lang.String str) throws java.text.ParseException {
        java.util.Date parse;
        java.text.DateFormat dateFormat = a;
        synchronized (dateFormat) {
            parse = dateFormat.parse(str);
        }
        return parse;
    }

    public static java.util.Date parseIso8601Date(java.lang.String str) throws java.text.ParseException {
        return new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str);
    }

    public static java.util.Date parseIso8601DateTime(java.lang.String str) throws java.text.ParseException {
        return new java.text.SimpleDateFormat(ISO8601_DATETIME_PATTERN).parse(str);
    }

    public static java.util.Date parseIso8601DateTimeOrDate(java.lang.String str) throws java.text.ParseException {
        try {
            return parseIso8601DateTime(str);
        } catch (java.text.ParseException unused) {
            return parseIso8601Date(str);
        }
    }

    public static java.util.Date parseLenientDateTime(java.lang.String str) throws java.text.ParseException {
        java.lang.String group;
        try {
            try {
                try {
                    return new java.util.Date(java.lang.Long.parseLong(str));
                } catch (java.text.ParseException unused) {
                    java.util.regex.Matcher matcher = i.matcher(str);
                    if (!matcher.find()) {
                        throw new java.text.ParseException(str, 0);
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(matcher.group(1));
                    sb.append(" ");
                    if (matcher.group(3) == null) {
                        group = matcher.group(2) + ":00";
                    } else {
                        group = matcher.group(2);
                    }
                    sb.append(group);
                    sb.append(matcher.group(4) == null ? ".000 " : " ");
                    sb.append(matcher.group(5) == null ? "+00" : matcher.group(5));
                    sb.append(matcher.group(6) == null ? org.apache.tools.tar.TarConstants.VERSION_POSIX : matcher.group(6));
                    return h.get().parse(sb.toString());
                }
            } catch (java.text.ParseException unused2) {
                return EN_US_DATE_FORMAT_SEC.get().parse(str);
            }
        } catch (java.lang.NumberFormatException unused3) {
            return EN_US_DATE_FORMAT_MIN.get().parse(str);
        }
    }
}

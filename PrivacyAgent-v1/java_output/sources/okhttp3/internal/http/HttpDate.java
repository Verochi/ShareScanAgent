package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class HttpDate {
    public static final long MAX_DATE = 253402300799999L;
    public static final java.lang.ThreadLocal<java.text.DateFormat> a = new okhttp3.internal.http.HttpDate.AnonymousClass1();
    public static final java.lang.String[] b;
    public static final java.text.DateFormat[] c;

    /* renamed from: okhttp3.internal.http.HttpDate$1, reason: invalid class name */
    public class AnonymousClass1 extends java.lang.ThreadLocal<java.text.DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.text.DateFormat initialValue() {
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", java.util.Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(okhttp3.internal.Util.UTC);
            return simpleDateFormat;
        }
    }

    static {
        java.lang.String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        b = strArr;
        c = new java.text.DateFormat[strArr.length];
    }

    public static java.lang.String format(java.util.Date date) {
        return a.get().format(date);
    }

    public static java.util.Date parse(java.lang.String str) {
        if (str.length() == 0) {
            return null;
        }
        java.text.ParsePosition parsePosition = new java.text.ParsePosition(0);
        java.util.Date parse = a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        java.lang.String[] strArr = b;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                java.text.DateFormat[] dateFormatArr = c;
                java.text.DateFormat dateFormat = dateFormatArr[i];
                if (dateFormat == null) {
                    dateFormat = new java.text.SimpleDateFormat(b[i], java.util.Locale.US);
                    dateFormat.setTimeZone(okhttp3.internal.Util.UTC);
                    dateFormatArr[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                java.util.Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }
}

package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class k {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
    public static final java.util.regex.Pattern b = java.util.regex.Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    public static class a {
        public int a;
        public int b;
        public int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    public static long a(java.lang.String str) {
        int c;
        int d;
        int i;
        com.alipay.android.phone.mrpc.core.k.a aVar;
        int i2;
        int i3;
        int i4;
        java.util.regex.Matcher matcher = a.matcher(str);
        if (matcher.find()) {
            i = b(matcher.group(1));
            c = c(matcher.group(2));
            d = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            java.util.regex.Matcher matcher2 = b.matcher(str);
            if (!matcher2.find()) {
                throw new java.lang.IllegalArgumentException();
            }
            c = c(matcher2.group(1));
            int b2 = b(matcher2.group(2));
            com.alipay.android.phone.mrpc.core.k.a e = e(matcher2.group(3));
            d = d(matcher2.group(4));
            i = b2;
            aVar = e;
        }
        if (d >= 2038) {
            i2 = 1;
            i3 = 0;
            i4 = 2038;
        } else {
            i2 = i;
            i3 = c;
            i4 = d;
        }
        android.text.format.Time time = new android.text.format.Time("UTC");
        time.set(aVar.c, aVar.b, aVar.a, i2, i3, i4);
        return time.toMillis(false);
    }

    public static int b(java.lang.String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(java.lang.String str) {
        int lowerCase = ((java.lang.Character.toLowerCase(str.charAt(0)) + java.lang.Character.toLowerCase(str.charAt(1))) + java.lang.Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new java.lang.IllegalArgumentException();
        }
    }

    public static int d(java.lang.String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        }
        if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        }
        if (str.length() == 4) {
            return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
        }
        return 1970;
    }

    public static com.alipay.android.phone.mrpc.core.k.a e(java.lang.String str) {
        int i;
        int charAt = str.charAt(0) - '0';
        if (str.charAt(1) != ':') {
            charAt = (charAt * 10) + (str.charAt(1) - '0');
            i = 2;
        } else {
            i = 1;
        }
        int i2 = i + 1 + 1 + 1 + 1;
        return new com.alipay.android.phone.mrpc.core.k.a(charAt, ((str.charAt(r2) - '0') * 10) + (str.charAt(r3) - '0'), ((str.charAt(i2) - '0') * 10) + (str.charAt(i2 + 1) - '0'));
    }
}

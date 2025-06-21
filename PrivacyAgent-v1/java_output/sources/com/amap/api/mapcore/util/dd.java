package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dd {
    private static java.lang.String a = "0123456789";

    public static class a {
        private java.lang.String a;
        private int b;
        private int c;

        public a() {
            this((byte) 0);
        }

        private a(byte b) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 11);
        }

        public a(java.lang.String str, int i) {
            this.b = 1103515245;
            this.c = 12345;
            this.a = a(str, i, str.length());
        }

        private char a(int i) {
            this.a.length();
            return this.a.charAt(i);
        }

        private int a(char c) {
            this.a.length();
            return this.a.indexOf(c);
        }

        private java.lang.String a(java.lang.String str, int i, int i2) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                int b = b(i);
                int i4 = b % length;
                i = b(b);
                int i5 = i % length;
                char charAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, charAt);
            }
            return stringBuffer.toString();
        }

        private int b(int i) {
            return (int) (((i * this.b) + this.c) & 2147483647L);
        }

        private java.lang.String b(int i, java.lang.String str) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int length = this.a.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                int a = a(str.charAt(i2));
                if (a < 0) {
                    break;
                }
                sb.append(a(((a + i) + i2) % length));
            }
            if (sb.length() == length2) {
                return sb.toString();
            }
            return null;
        }

        public final java.lang.String a(int i, java.lang.String str) {
            return b(i, str);
        }
    }

    public static java.lang.String a() {
        java.util.Random random = new java.util.Random();
        int nextInt = random.nextInt(10);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String format = java.lang.String.format(locale, "%05d", java.lang.Integer.valueOf(nextInt));
        int nextInt2 = random.nextInt(10);
        int nextInt3 = random.nextInt(100);
        return new com.amap.api.mapcore.util.dd.a(a, nextInt3).a(nextInt2, format) + java.lang.String.format(locale, "%01d", java.lang.Integer.valueOf(nextInt2)) + java.lang.String.format(locale, com.google.android.material.timepicker.TimeModel.ZERO_LEADING_NUMBER_FORMAT, java.lang.Integer.valueOf(nextInt3));
    }
}

package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
class TextFormatter {
    public java.text.MessageFormat a;
    public com.badlogic.gdx.utils.StringBuilder b = new com.badlogic.gdx.utils.StringBuilder();

    public TextFormatter(java.util.Locale locale, boolean z) {
        if (z) {
            this.a = new java.text.MessageFormat("", locale);
        }
    }

    public java.lang.String a(java.lang.String str, java.lang.Object... objArr) {
        java.text.MessageFormat messageFormat = this.a;
        if (messageFormat == null) {
            return c(str, objArr);
        }
        messageFormat.applyPattern(b(str));
        return this.a.format(objArr);
    }

    public final java.lang.String b(java.lang.String str) {
        int i = 0;
        this.b.setLength(0);
        int length = str.length();
        boolean z = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                this.b.append("''");
                z = true;
            } else if (charAt == '{') {
                int i2 = i + 1;
                while (i2 < length && str.charAt(i2) == '{') {
                    i2++;
                }
                int i3 = i2 - i;
                int i4 = i3 / 2;
                if (i4 > 0) {
                    this.b.append('\'');
                    do {
                        this.b.append('{');
                        i4--;
                    } while (i4 > 0);
                    this.b.append('\'');
                    z = true;
                }
                if (i3 % 2 != 0) {
                    this.b.append('{');
                }
                i = i2 - 1;
            } else {
                this.b.append(charAt);
            }
            i++;
        }
        return z ? this.b.toString() : str;
    }

    public final java.lang.String c(java.lang.String str, java.lang.Object... objArr) {
        this.b.setLength(0);
        int length = str.length();
        int i = 0;
        int i2 = -1;
        boolean z = false;
        while (i < length) {
            char charAt = str.charAt(i);
            if (i2 < 0) {
                if (charAt == '{') {
                    int i3 = i + 1;
                    if (i3 >= length || str.charAt(i3) != '{') {
                        i2 = 0;
                    } else {
                        this.b.append(charAt);
                        i = i3;
                    }
                    z = true;
                } else {
                    this.b.append(charAt);
                }
            } else if (charAt == '}') {
                if (i2 >= objArr.length) {
                    throw new java.lang.IllegalArgumentException("Argument index out of bounds: " + i2);
                }
                if (str.charAt(i - 1) == '{') {
                    throw new java.lang.IllegalArgumentException("Missing argument index after a left curly brace");
                }
                java.lang.Object obj = objArr[i2];
                if (obj == null) {
                    this.b.append(com.igexin.push.core.b.m);
                } else {
                    this.b.append(obj.toString());
                }
                i2 = -1;
            } else {
                if (charAt < '0' || charAt > '9') {
                    throw new java.lang.IllegalArgumentException("Unexpected '" + charAt + "' while parsing argument index");
                }
                i2 = (i2 * 10) + (charAt - '0');
            }
            i++;
        }
        if (i2 < 0) {
            return z ? this.b.toString() : str;
        }
        throw new java.lang.IllegalArgumentException("Unmatched braces in the pattern.");
    }
}

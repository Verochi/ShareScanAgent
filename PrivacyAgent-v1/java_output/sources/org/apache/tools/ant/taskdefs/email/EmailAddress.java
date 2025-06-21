package org.apache.tools.ant.taskdefs.email;

/* loaded from: classes25.dex */
public class EmailAddress {
    public java.lang.String a;
    public java.lang.String b;

    public EmailAddress() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0068, code lost:
    
        if (r1 != (r0 - 1)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EmailAddress(java.lang.String str) {
        int i;
        int length = str.length();
        if (length > 9 && ((str.charAt(0) == '<' || str.charAt(1) == '<') && (str.charAt(length - 1) == '>' || str.charAt(length - 2) == '>'))) {
            this.b = a(str, true);
            return;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '(') {
                i4++;
                i = i5 != 0 ? i + 1 : 0;
                i6 = i + 1;
            } else {
                if (charAt == ')') {
                    i4--;
                    if (i2 == 0) {
                        i5 = i + 1;
                        i3 = i;
                    }
                } else if (i4 == 0 && charAt == '<') {
                    i3 = i5 == 0 ? i : i3;
                    i5 = i + 1;
                } else if (i4 == 0 && charAt == '>') {
                }
            }
            i2 = i;
        }
        i2 = i2 == 0 ? length : i2;
        i3 = i3 == 0 ? length : i3;
        this.b = a(str.substring(i5, i2), true);
        java.lang.String a = a(str.substring(i6, i3), false);
        this.a = a;
        if (a.length() + this.b.length() > length) {
            this.a = null;
        }
    }

    public final java.lang.String a(java.lang.String str, boolean z) {
        boolean z2;
        boolean z3;
        int length = str.length();
        int i = 0;
        do {
            int i2 = length - 1;
            z2 = true;
            if (str.charAt(i2) == ')' || ((str.charAt(i2) == '>' && z) || ((str.charAt(i2) == '\"' && str.charAt(length - 2) != '\\') || str.charAt(i2) <= ' '))) {
                length--;
                z3 = true;
            } else {
                z3 = false;
            }
            if (str.charAt(i) == '(' || ((str.charAt(i) == '<' && z) || str.charAt(i) == '\"' || str.charAt(i) <= ' ')) {
                i++;
            } else {
                z2 = z3;
            }
        } while (z2);
        return str.substring(i, length);
    }

    public java.lang.String getAddress() {
        return this.b;
    }

    public java.lang.String getName() {
        return this.a;
    }

    public void setAddress(java.lang.String str) {
        this.b = str;
    }

    public void setName(java.lang.String str) {
        this.a = str;
    }

    public java.lang.String toString() {
        if (this.a == null) {
            return this.b;
        }
        return this.a + " <" + this.b + ">";
    }
}

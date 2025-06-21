package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public final class UrlTemplate {
    public final java.lang.String[] a;
    public final int[] b;
    public final java.lang.String[] c;
    public final int d;

    public UrlTemplate(java.lang.String[] strArr, int[] iArr, java.lang.String[] strArr2, int i) {
        this.a = strArr;
        this.b = iArr;
        this.c = strArr2;
        this.d = i;
    }

    public static int a(java.lang.String str, java.lang.String[] strArr, int[] iArr, java.lang.String[] strArr2) {
        java.lang.String str2;
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            if (indexOf == -1) {
                java.lang.String valueOf = java.lang.String.valueOf(strArr[i2]);
                java.lang.String valueOf2 = java.lang.String.valueOf(str.substring(i));
                strArr[i2] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new java.lang.String(valueOf);
                i = str.length();
            } else if (indexOf != i) {
                java.lang.String valueOf3 = java.lang.String.valueOf(strArr[i2]);
                java.lang.String valueOf4 = java.lang.String.valueOf(str.substring(i, indexOf));
                strArr[i2] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new java.lang.String(valueOf3);
                i = indexOf;
            } else if (str.startsWith("$$", i)) {
                strArr[i2] = java.lang.String.valueOf(strArr[i2]).concat("$");
                i += 2;
            } else {
                int i3 = i + 1;
                int indexOf2 = str.indexOf("$", i3);
                java.lang.String substring = str.substring(i3, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i2] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x")) {
                            str2 = str2.concat("d");
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring) {
                        case "Number":
                            iArr[i2] = 2;
                            break;
                        case "Time":
                            iArr[i2] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i2] = 3;
                            break;
                        default:
                            throw new java.lang.IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new java.lang.String("Invalid template: "));
                    }
                    strArr2[i2] = str2;
                }
                i2++;
                strArr[i2] = "";
                i = indexOf2 + 1;
            }
        }
        return i2;
    }

    public static com.google.android.exoplayer2.source.dash.manifest.UrlTemplate compile(java.lang.String str) {
        java.lang.String[] strArr = new java.lang.String[5];
        int[] iArr = new int[4];
        java.lang.String[] strArr2 = new java.lang.String[4];
        return new com.google.android.exoplayer2.source.dash.manifest.UrlTemplate(strArr, iArr, strArr2, a(str, strArr, iArr, strArr2));
    }

    public java.lang.String buildUri(java.lang.String str, long j, int i, long j2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        while (true) {
            int i3 = this.d;
            if (i2 >= i3) {
                sb.append(this.a[i3]);
                return sb.toString();
            }
            sb.append(this.a[i2]);
            int i4 = this.b[i2];
            if (i4 == 1) {
                sb.append(str);
            } else if (i4 == 2) {
                sb.append(java.lang.String.format(java.util.Locale.US, this.c[i2], java.lang.Long.valueOf(j)));
            } else if (i4 == 3) {
                sb.append(java.lang.String.format(java.util.Locale.US, this.c[i2], java.lang.Integer.valueOf(i)));
            } else if (i4 == 4) {
                sb.append(java.lang.String.format(java.util.Locale.US, this.c[i2], java.lang.Long.valueOf(j2)));
            }
            i2++;
        }
    }
}

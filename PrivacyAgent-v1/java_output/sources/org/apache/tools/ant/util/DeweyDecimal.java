package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class DeweyDecimal implements java.lang.Comparable<org.apache.tools.ant.util.DeweyDecimal> {
    public final int[] n;

    public DeweyDecimal(java.lang.String str) throws java.lang.NumberFormatException {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ".", true);
        this.n = new int[(stringTokenizer.countTokens() + 1) / 2];
        for (int i = 0; i < this.n.length; i++) {
            java.lang.String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() == 0) {
                throw new java.lang.NumberFormatException("Empty component in string");
            }
            this.n[i] = java.lang.Integer.parseInt(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                stringTokenizer.nextToken();
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new java.lang.NumberFormatException("DeweyDecimal ended in a '.'");
                }
            }
        }
    }

    public DeweyDecimal(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        this.n = iArr2;
        java.lang.System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
    }

    @Override // java.lang.Comparable
    public int compareTo(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        int max = java.lang.Math.max(deweyDecimal.n.length, this.n.length);
        int i = 0;
        while (i < max) {
            int[] iArr = this.n;
            int i2 = i < iArr.length ? iArr[i] : 0;
            int[] iArr2 = deweyDecimal.n;
            int i3 = i < iArr2.length ? iArr2[i] : 0;
            if (i2 != i3) {
                return i2 - i3;
            }
            i++;
        }
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof org.apache.tools.ant.util.DeweyDecimal) && isEqual((org.apache.tools.ant.util.DeweyDecimal) obj);
    }

    public int get(int i) {
        return this.n[i];
    }

    public int getSize() {
        return this.n.length;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isEqual(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        int max = java.lang.Math.max(deweyDecimal.n.length, this.n.length);
        int i = 0;
        while (i < max) {
            int[] iArr = this.n;
            int i2 = i < iArr.length ? iArr[i] : 0;
            int[] iArr2 = deweyDecimal.n;
            if ((i < iArr2.length ? iArr2[i] : 0) != i2) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean isGreaterThan(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        int max = java.lang.Math.max(deweyDecimal.n.length, this.n.length);
        int i = 0;
        while (i < max) {
            int[] iArr = this.n;
            int i2 = i < iArr.length ? iArr[i] : 0;
            int[] iArr2 = deweyDecimal.n;
            int i3 = i < iArr2.length ? iArr2[i] : 0;
            if (i3 > i2) {
                return false;
            }
            if (i3 < i2) {
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean isGreaterThanOrEqual(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        int max = java.lang.Math.max(deweyDecimal.n.length, this.n.length);
        int i = 0;
        while (i < max) {
            int[] iArr = this.n;
            int i2 = i < iArr.length ? iArr[i] : 0;
            int[] iArr2 = deweyDecimal.n;
            int i3 = i < iArr2.length ? iArr2[i] : 0;
            if (i3 > i2) {
                return false;
            }
            if (i3 < i2) {
                return true;
            }
            i++;
        }
        return true;
    }

    public boolean isLessThan(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        return !isGreaterThanOrEqual(deweyDecimal);
    }

    public boolean isLessThanOrEqual(org.apache.tools.ant.util.DeweyDecimal deweyDecimal) {
        return !isGreaterThan(deweyDecimal);
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < this.n.length; i++) {
            if (i != 0) {
                stringBuffer.append('.');
            }
            stringBuffer.append(this.n[i]);
        }
        return stringBuffer.toString();
    }
}

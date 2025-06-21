package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class TokenizedPattern {
    public static final org.apache.tools.ant.types.selectors.TokenizedPattern EMPTY_PATTERN = new org.apache.tools.ant.types.selectors.TokenizedPattern("", new java.lang.String[0]);
    public final java.lang.String a;
    public final java.lang.String[] b;

    public TokenizedPattern(java.lang.String str) {
        this(str, org.apache.tools.ant.types.selectors.SelectorUtils.e(str));
    }

    public TokenizedPattern(java.lang.String str, java.lang.String[] strArr) {
        this.a = str;
        this.b = strArr;
    }

    public boolean containsPattern(java.lang.String str) {
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.b;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(str)) {
                return true;
            }
            i++;
        }
    }

    public int depth() {
        return this.b.length;
    }

    public boolean endsWith(java.lang.String str) {
        java.lang.String[] strArr = this.b;
        return strArr.length > 0 && strArr[strArr.length - 1].equals(str);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof org.apache.tools.ant.types.selectors.TokenizedPattern) && this.a.equals(((org.apache.tools.ant.types.selectors.TokenizedPattern) obj).a);
    }

    public java.lang.String getPattern() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean matchPath(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, boolean z) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.c(this.b, tokenizedPath.b(), z);
    }

    public boolean matchStartOf(org.apache.tools.ant.types.selectors.TokenizedPath tokenizedPath, boolean z) {
        return org.apache.tools.ant.types.selectors.SelectorUtils.d(this.b, tokenizedPath.b(), z);
    }

    public org.apache.tools.ant.types.selectors.TokenizedPath rtrimWildcardTokens() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        while (true) {
            java.lang.String[] strArr = this.b;
            if (i >= strArr.length || org.apache.tools.ant.types.selectors.SelectorUtils.hasWildcards(strArr[i])) {
                break;
            }
            if (i > 0 && sb.charAt(sb.length() - 1) != java.io.File.separatorChar) {
                sb.append(java.io.File.separator);
            }
            sb.append(this.b[i]);
            i++;
        }
        if (i == 0) {
            return org.apache.tools.ant.types.selectors.TokenizedPath.EMPTY_PATH;
        }
        java.lang.String[] strArr2 = new java.lang.String[i];
        java.lang.System.arraycopy(this.b, 0, strArr2, 0, i);
        return new org.apache.tools.ant.types.selectors.TokenizedPath(sb.toString(), strArr2);
    }

    public java.lang.String toString() {
        return this.a;
    }

    public org.apache.tools.ant.types.selectors.TokenizedPattern withoutLastToken() {
        java.lang.String[] strArr = this.b;
        if (strArr.length == 0) {
            throw new java.lang.IllegalStateException("can't strip a token from nothing");
        }
        if (strArr.length == 1) {
            return EMPTY_PATTERN;
        }
        int lastIndexOf = this.a.lastIndexOf(strArr[strArr.length - 1]);
        java.lang.String[] strArr2 = this.b;
        java.lang.String[] strArr3 = new java.lang.String[strArr2.length - 1];
        java.lang.System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length - 1);
        return new org.apache.tools.ant.types.selectors.TokenizedPattern(this.a.substring(0, lastIndexOf), strArr3);
    }
}

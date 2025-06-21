package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public class UniqFilter extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
    public java.lang.String t = null;

    @Override // org.apache.tools.ant.filters.TokenFilter.Filter
    public java.lang.String filter(java.lang.String str) {
        java.lang.String str2 = this.t;
        if (str2 != null && str2.equals(str)) {
            return null;
        }
        this.t = str;
        return str;
    }
}

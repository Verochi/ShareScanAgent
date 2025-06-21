package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public class Native2AsciiFilter extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
    public boolean t;

    @Override // org.apache.tools.ant.filters.TokenFilter.Filter
    public java.lang.String filter(java.lang.String str) {
        return this.t ? org.apache.tools.ant.util.Native2AsciiUtils.ascii2native(str) : org.apache.tools.ant.util.Native2AsciiUtils.native2ascii(str);
    }

    public void setReverse(boolean z) {
        this.t = z;
    }
}

package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public class StringInputStream extends org.apache.tools.ant.util.ReaderInputStream {
    public StringInputStream(java.lang.String str) {
        super(new java.io.StringReader(str));
    }

    public StringInputStream(java.lang.String str, java.lang.String str2) {
        super(new java.io.StringReader(str), str2);
    }
}

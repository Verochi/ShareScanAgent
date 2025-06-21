package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class UnPackageNameMapper extends org.apache.tools.ant.util.GlobPatternMapper {
    @Override // org.apache.tools.ant.util.GlobPatternMapper
    public java.lang.String extractVariablePart(java.lang.String str) {
        return str.substring(this.prefixLength, str.length() - this.postfixLength).replace('.', java.io.File.separatorChar);
    }
}

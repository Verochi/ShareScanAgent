package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class PackageNameMapper extends org.apache.tools.ant.util.GlobPatternMapper {
    @Override // org.apache.tools.ant.util.GlobPatternMapper
    public java.lang.String extractVariablePart(java.lang.String str) {
        java.lang.String substring = str.substring(this.prefixLength, str.length() - this.postfixLength);
        if (getHandleDirSep()) {
            substring = substring.replace('/', '.').replace('\\', '.');
        }
        return substring.replace(java.io.File.separatorChar, '.');
    }
}

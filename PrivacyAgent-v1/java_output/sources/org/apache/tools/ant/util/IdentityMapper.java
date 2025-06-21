package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class IdentityMapper implements org.apache.tools.ant.util.FileNameMapper {
    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return new java.lang.String[]{str};
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
    }
}

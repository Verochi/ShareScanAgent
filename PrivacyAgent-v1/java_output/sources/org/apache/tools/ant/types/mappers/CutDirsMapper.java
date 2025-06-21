package org.apache.tools.ant.types.mappers;

/* loaded from: classes26.dex */
public class CutDirsMapper implements org.apache.tools.ant.util.FileNameMapper {
    public int n = 0;

    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        if (this.n <= 0) {
            throw new org.apache.tools.ant.BuildException("dirs must be set to a positive number");
        }
        char c = java.io.File.separatorChar;
        if (str == null) {
            return null;
        }
        java.lang.String replace = str.replace('/', c).replace('\\', c);
        int indexOf = replace.indexOf(c);
        for (int i = 1; indexOf > -1 && i < this.n; i++) {
            indexOf = replace.indexOf(c, indexOf + 1);
        }
        if (indexOf == -1) {
            return null;
        }
        return new java.lang.String[]{str.substring(indexOf + 1)};
    }

    public void setDirs(int i) {
        this.n = i;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
    }
}

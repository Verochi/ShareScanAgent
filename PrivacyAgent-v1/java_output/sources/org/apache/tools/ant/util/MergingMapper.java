package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class MergingMapper implements org.apache.tools.ant.util.FileNameMapper {
    protected java.lang.String[] mergedFile = null;

    public MergingMapper() {
    }

    public MergingMapper(java.lang.String str) {
        setTo(str);
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        return this.mergedFile;
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
        this.mergedFile = new java.lang.String[]{str};
    }
}

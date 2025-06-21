package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class DifferentSelector extends org.apache.tools.ant.types.selectors.MappingSelector {
    public static final org.apache.tools.ant.util.FileUtils x = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public boolean v = true;
    public boolean w = false;

    @Override // org.apache.tools.ant.types.selectors.MappingSelector
    public boolean selectionTest(java.io.File file, java.io.File file2) {
        if (file.exists() != file2.exists() || file.length() != file2.length()) {
            return true;
        }
        if (!this.v) {
            if (!(file2.lastModified() >= file.lastModified() - ((long) this.granularity) && file2.lastModified() <= file.lastModified() + ((long) this.granularity))) {
                return true;
            }
        }
        if (this.w) {
            return false;
        }
        try {
            return !x.contentEquals(file, file2);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("while comparing " + file + " and " + file2, e);
        }
    }

    public void setIgnoreContents(boolean z) {
        this.w = z;
    }

    public void setIgnoreFileTimes(boolean z) {
        this.v = z;
    }
}

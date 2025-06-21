package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Type implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public org.apache.tools.ant.types.resources.selectors.Type.FileDir n = null;
    public static final org.apache.tools.ant.types.resources.selectors.Type FILE = new org.apache.tools.ant.types.resources.selectors.Type(new org.apache.tools.ant.types.resources.selectors.Type.FileDir("file"));
    public static final org.apache.tools.ant.types.resources.selectors.Type DIR = new org.apache.tools.ant.types.resources.selectors.Type(new org.apache.tools.ant.types.resources.selectors.Type.FileDir("dir"));
    public static final org.apache.tools.ant.types.resources.selectors.Type ANY = new org.apache.tools.ant.types.resources.selectors.Type(new org.apache.tools.ant.types.resources.selectors.Type.FileDir(org.apache.commons.codec.language.bm.Languages.ANY));

    public static class FileDir extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {"file", "dir", org.apache.commons.codec.language.bm.Languages.ANY};

        public FileDir() {
        }

        public FileDir(java.lang.String str) {
            setValue(str);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }
    }

    public Type() {
    }

    public Type(org.apache.tools.ant.types.resources.selectors.Type.FileDir fileDir) {
        setType(fileDir);
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        org.apache.tools.ant.types.resources.selectors.Type.FileDir fileDir = this.n;
        if (fileDir == null) {
            throw new org.apache.tools.ant.BuildException("The type attribute is required.");
        }
        int index = fileDir.getIndex();
        if (index == 2) {
            return true;
        }
        if (resource.isDirectory()) {
            if (index == 1) {
                return true;
            }
        } else if (index == 0) {
            return true;
        }
        return false;
    }

    public void setType(org.apache.tools.ant.types.resources.selectors.Type.FileDir fileDir) {
        this.n = fileDir;
    }
}

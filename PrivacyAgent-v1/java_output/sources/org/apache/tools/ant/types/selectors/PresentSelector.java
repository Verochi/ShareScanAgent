package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class PresentSelector extends org.apache.tools.ant.types.selectors.BaseSelector {
    public java.io.File u = null;
    public org.apache.tools.ant.types.Mapper v = null;
    public org.apache.tools.ant.util.FileNameMapper w = null;
    public boolean x = true;

    public static class FilePresence extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"srconly", "both"};
        }
    }

    public void addConfigured(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (this.w != null || this.v != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        }
        this.w = fileNameMapper;
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.w != null || this.v != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.v = mapper;
        return mapper;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        java.lang.String str2;
        validate();
        java.lang.String[] mapFileName = this.w.mapFileName(str);
        if (mapFileName == null) {
            return false;
        }
        if (mapFileName.length == 1 && (str2 = mapFileName[0]) != null) {
            return org.apache.tools.ant.util.FileUtils.getFileUtils().resolveFile(this.u, str2).exists() == this.x;
        }
        throw new org.apache.tools.ant.BuildException("Invalid destination file results for " + this.u + " with filename " + str);
    }

    public void setPresent(org.apache.tools.ant.types.selectors.PresentSelector.FilePresence filePresence) {
        if (filePresence.getIndex() == 0) {
            this.x = false;
        }
    }

    public void setTargetdir(java.io.File file) {
        this.u = file;
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("{presentselector targetdir: ");
        java.io.File file = this.u;
        if (file == null) {
            sb.append("NOT YET SET");
        } else {
            sb.append(file.getName());
        }
        sb.append(" present: ");
        if (this.x) {
            sb.append("both");
        } else {
            sb.append("srconly");
        }
        org.apache.tools.ant.util.FileNameMapper fileNameMapper = this.w;
        if (fileNameMapper != null) {
            sb.append(fileNameMapper.toString());
        } else {
            org.apache.tools.ant.types.Mapper mapper = this.v;
            if (mapper != null) {
                sb.append(mapper.toString());
            }
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.u == null) {
            setError("The targetdir attribute is required.");
        }
        if (this.w == null) {
            org.apache.tools.ant.types.Mapper mapper = this.v;
            if (mapper == null) {
                this.w = new org.apache.tools.ant.util.IdentityMapper();
                return;
            }
            org.apache.tools.ant.util.FileNameMapper implementation = mapper.getImplementation();
            this.w = implementation;
            if (implementation == null) {
                setError("Could not set <mapper> element.");
            }
        }
    }
}

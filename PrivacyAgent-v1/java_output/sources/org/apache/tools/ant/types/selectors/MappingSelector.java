package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public abstract class MappingSelector extends org.apache.tools.ant.types.selectors.BaseSelector {
    public static final org.apache.tools.ant.util.FileUtils u = org.apache.tools.ant.util.FileUtils.getFileUtils();
    protected int granularity;
    protected java.io.File targetdir = null;
    protected org.apache.tools.ant.types.Mapper mapperElement = null;
    protected org.apache.tools.ant.util.FileNameMapper map = null;

    public MappingSelector() {
        org.apache.tools.ant.util.FileUtils fileUtils = u;
        this.granularity = (int) fileUtils.getFileTimestampGranularity();
        this.granularity = (int) fileUtils.getFileTimestampGranularity();
    }

    public void addConfigured(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (this.map != null || this.mapperElement != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        }
        this.map = fileNameMapper;
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.map != null || this.mapperElement != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS);
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.mapperElement = mapper;
        return mapper;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) {
        java.lang.String str2;
        validate();
        java.lang.String[] mapFileName = this.map.mapFileName(str);
        if (mapFileName == null) {
            return false;
        }
        if (mapFileName.length == 1 && (str2 = mapFileName[0]) != null) {
            return selectionTest(file2, u.resolveFile(this.targetdir, str2));
        }
        throw new org.apache.tools.ant.BuildException("Invalid destination file results for " + this.targetdir.getName() + " with filename " + str);
    }

    public abstract boolean selectionTest(java.io.File file, java.io.File file2);

    public void setGranularity(int i) {
        this.granularity = i;
    }

    public void setTargetdir(java.io.File file) {
        this.targetdir = file;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.targetdir == null) {
            setError("The targetdir attribute is required.");
        }
        if (this.map == null) {
            org.apache.tools.ant.types.Mapper mapper = this.mapperElement;
            if (mapper == null) {
                this.map = new org.apache.tools.ant.util.IdentityMapper();
                return;
            }
            org.apache.tools.ant.util.FileNameMapper implementation = mapper.getImplementation();
            this.map = implementation;
            if (implementation == null) {
                setError("Could not set <mapper> element.");
            }
        }
    }
}

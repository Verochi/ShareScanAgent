package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class UpToDate extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String u;
    public java.lang.String v;
    public java.io.File w;
    public java.io.File x;
    public java.util.Vector y = new java.util.Vector();
    public org.apache.tools.ant.types.resources.Union z = new org.apache.tools.ant.types.resources.Union();
    protected org.apache.tools.ant.types.Mapper mapperElement = null;

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public void addSrcfiles(org.apache.tools.ant.types.FileSet fileSet) {
        this.y.addElement(fileSet);
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.mapperElement != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.mapperElement = mapper;
        return mapper;
    }

    public org.apache.tools.ant.types.resources.Union createSrcResources() {
        return this.z;
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        boolean z;
        if (this.y.size() == 0 && this.z.size() == 0 && this.w == null) {
            throw new org.apache.tools.ant.BuildException("At least one srcfile or a nested <srcfiles> or <srcresources> element must be set.");
        }
        if ((this.y.size() > 0 || this.z.size() > 0) && this.w != null) {
            throw new org.apache.tools.ant.BuildException("Cannot specify both the srcfile attribute and a nested <srcfiles> or <srcresources> element.");
        }
        java.io.File file = this.x;
        if (file == null && this.mapperElement == null) {
            throw new org.apache.tools.ant.BuildException("The targetfile attribute or a nested mapper element must be set.");
        }
        if (file != null && !file.exists()) {
            log("The targetfile \"" + this.x.getAbsolutePath() + "\" does not exist.", 3);
            return false;
        }
        java.io.File file2 = this.w;
        if (file2 != null && !file2.exists()) {
            throw new org.apache.tools.ant.BuildException(this.w.getAbsolutePath() + " not found.");
        }
        if (this.w != null) {
            z = this.mapperElement != null ? new org.apache.tools.ant.util.SourceFileScanner(this).restrict(new java.lang.String[]{this.w.getAbsolutePath()}, null, null, this.mapperElement.getImplementation()).length == 0 : this.x.lastModified() >= this.w.lastModified();
            if (!z) {
                log(this.w.getAbsolutePath() + " is newer than (one of) its target(s).", 3);
            }
        } else {
            z = true;
        }
        java.util.Enumeration elements = this.y.elements();
        while (z && elements.hasMoreElements()) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) elements.nextElement();
            z = scanDir(fileSet.getDir(getProject()), fileSet.getDirectoryScanner(getProject()).getIncludedFiles());
        }
        if (!z) {
            return z;
        }
        org.apache.tools.ant.types.Resource[] listResources = this.z.listResources();
        if (listResources.length > 0) {
            return org.apache.tools.ant.util.ResourceUtils.selectOutOfDateSources(this, listResources, getMapper(), getProject()).length == 0;
        }
        return z;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("property attribute is required.", getLocation());
        }
        if (eval()) {
            getProject().setNewProperty(this.u, getValue());
            if (this.mapperElement != null) {
                log("All target files are up-to-date.", 3);
                return;
            }
            log("File \"" + this.x.getAbsolutePath() + "\" is up-to-date.", 3);
        }
    }

    public final org.apache.tools.ant.util.FileNameMapper getMapper() {
        org.apache.tools.ant.types.Mapper mapper = this.mapperElement;
        if (mapper != null) {
            return mapper.getImplementation();
        }
        org.apache.tools.ant.util.MergingMapper mergingMapper = new org.apache.tools.ant.util.MergingMapper();
        mergingMapper.setTo(this.x.getAbsolutePath());
        return mergingMapper;
    }

    public final java.lang.String getValue() {
        java.lang.String str = this.v;
        return str != null ? str : com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
    }

    public boolean scanDir(java.io.File file, java.lang.String[] strArr) {
        return new org.apache.tools.ant.util.SourceFileScanner(this).restrict(strArr, file, this.mapperElement == null ? null : file, getMapper()).length == 0;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public void setSrcfile(java.io.File file) {
        this.w = file;
    }

    public void setTargetFile(java.io.File file) {
        this.x = file;
    }

    public void setValue(java.lang.String str) {
        this.v = str;
    }
}

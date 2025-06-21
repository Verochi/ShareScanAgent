package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class Native2Ascii extends org.apache.tools.ant.taskdefs.MatchingTask {
    public org.apache.tools.ant.util.facade.FacadeTaskHelper A;
    public org.apache.tools.ant.types.Mapper z;
    public boolean u = false;
    public java.lang.String v = null;
    public java.io.File w = null;
    public java.io.File x = null;
    public java.lang.String y = null;
    public org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter B = null;

    public class ExtMapper implements org.apache.tools.ant.util.FileNameMapper {
        public ExtMapper() {
        }

        public /* synthetic */ ExtMapper(org.apache.tools.ant.taskdefs.optional.Native2Ascii native2Ascii, org.apache.tools.ant.taskdefs.optional.Native2Ascii.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public java.lang.String[] mapFileName(java.lang.String str) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                return new java.lang.String[]{str.substring(0, lastIndexOf) + org.apache.tools.ant.taskdefs.optional.Native2Ascii.this.y};
            }
            return new java.lang.String[]{str + org.apache.tools.ant.taskdefs.optional.Native2Ascii.this.y};
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setFrom(java.lang.String str) {
        }

        @Override // org.apache.tools.ant.util.FileNameMapper
        public void setTo(java.lang.String str) {
        }
    }

    public Native2Ascii() {
        this.A = null;
        this.A = new org.apache.tools.ant.util.facade.FacadeTaskHelper(org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapterFactory.getDefault());
    }

    public void add(org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter native2AsciiAdapter) {
        if (this.B != null) {
            throw new org.apache.tools.ant.BuildException("Can't have more than one native2ascii adapter");
        }
        this.B = native2AsciiAdapter;
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public org.apache.tools.ant.util.facade.ImplementationSpecificArgument createArg() {
        org.apache.tools.ant.util.facade.ImplementationSpecificArgument implementationSpecificArgument = new org.apache.tools.ant.util.facade.ImplementationSpecificArgument();
        this.A.addImplementationArgument(implementationSpecificArgument);
        return implementationSpecificArgument;
    }

    public org.apache.tools.ant.types.Path createImplementationClasspath() {
        return this.A.getImplementationClasspath(getProject());
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.z != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.z = mapper;
        return mapper;
    }

    public final void d(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.io.File file = new java.io.File(this.w, str);
        java.io.File file2 = new java.io.File(this.x, str2);
        if (file.equals(file2)) {
            throw new org.apache.tools.ant.BuildException("file " + file + " would overwrite its self");
        }
        java.lang.String parent = file2.getParent();
        if (parent != null) {
            java.io.File file3 = new java.io.File(parent);
            if (!file3.exists() && !file3.mkdirs() && !file3.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("cannot create parent directory " + parent);
            }
        }
        log("converting " + str, 3);
        org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapter native2AsciiAdapter = this.B;
        if (native2AsciiAdapter == null) {
            native2AsciiAdapter = org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapterFactory.getAdapter(this.A.getImplementation(), this, createImplementationClasspath());
        }
        if (!native2AsciiAdapter.convert(this, file, file2)) {
            throw new org.apache.tools.ant.BuildException("conversion failed");
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.w == null) {
            this.w = getProject().resolveFile(".");
        }
        java.io.File file = this.x;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The dest attribute must be set.");
        }
        if (this.w.equals(file) && this.y == null && this.z == null) {
            throw new org.apache.tools.ant.BuildException("The ext attribute or a mapper must be set if src and dest dirs are the same.");
        }
        org.apache.tools.ant.types.Mapper mapper = this.z;
        org.apache.tools.ant.util.FileNameMapper identityMapper = mapper == null ? this.y == null ? new org.apache.tools.ant.util.IdentityMapper() : new org.apache.tools.ant.taskdefs.optional.Native2Ascii.ExtMapper(this, null) : mapper.getImplementation();
        java.lang.String[] restrict = new org.apache.tools.ant.util.SourceFileScanner(this).restrict(getDirectoryScanner(this.w).getIncludedFiles(), this.w, this.x, identityMapper);
        int length = restrict.length;
        if (length == 0) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Converting ");
        sb.append(length);
        sb.append(" file");
        sb.append(length != 1 ? "s" : "");
        sb.append(" from ");
        log(sb.toString() + this.w + " to " + this.x);
        for (java.lang.String str : restrict) {
            java.lang.String[] mapFileName = identityMapper.mapFileName(str);
            if (mapFileName != null && mapFileName.length > 0) {
                d(str, mapFileName[0]);
            }
        }
    }

    public java.lang.String[] getCurrentArgs() {
        return this.A.getArgs();
    }

    public java.lang.String getEncoding() {
        return this.v;
    }

    public boolean getReverse() {
        return this.u;
    }

    public void setDest(java.io.File file) {
        this.x = file;
    }

    public void setEncoding(java.lang.String str) {
        this.v = str;
    }

    public void setExt(java.lang.String str) {
        this.y = str;
    }

    public void setImplementation(java.lang.String str) {
        if ("default".equals(str)) {
            this.A.setImplementation(org.apache.tools.ant.taskdefs.optional.native2ascii.Native2AsciiAdapterFactory.getDefault());
        } else {
            this.A.setImplementation(str);
        }
    }

    public void setReverse(boolean z) {
        this.u = z;
    }

    public void setSrc(java.io.File file) {
        this.w = file;
    }
}

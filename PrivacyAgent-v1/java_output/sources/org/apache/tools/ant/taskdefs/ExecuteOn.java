package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ExecuteOn extends org.apache.tools.ant.taskdefs.ExecTask {
    protected java.util.Vector<org.apache.tools.ant.types.AbstractFileSet> filesets = new java.util.Vector<>();
    public org.apache.tools.ant.types.resources.Union M = null;
    public boolean N = false;
    public boolean O = false;
    public boolean P = false;
    protected java.lang.String type = "file";
    protected org.apache.tools.ant.types.Commandline.Marker srcFilePos = null;
    public boolean Q = false;
    protected org.apache.tools.ant.types.Commandline.Marker targetFilePos = null;
    protected org.apache.tools.ant.types.Mapper mapperElement = null;
    protected org.apache.tools.ant.util.FileNameMapper mapper = null;
    protected java.io.File destDir = null;
    public int R = -1;
    public boolean S = true;
    public boolean T = false;
    public boolean U = true;
    public boolean V = false;
    protected boolean srcIsFirst = true;

    public static class FileDirBoth extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String DIR = "dir";
        public static final java.lang.String FILE = "file";

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"file", "dir", "both"};
        }
    }

    public static void f(java.lang.String[] strArr, java.lang.String[] strArr2, int i, java.lang.String str, java.lang.String str2) {
        if (str.length() == 0 && str2.length() == 0) {
            java.lang.System.arraycopy(strArr, 0, strArr2, i, strArr.length);
            return;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr2[i + i2] = str + strArr[i2] + str2;
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (this.M == null) {
            this.M = new org.apache.tools.ant.types.resources.Union();
        }
        this.M.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public void addDirset(org.apache.tools.ant.types.DirSet dirSet) {
        this.filesets.addElement(dirSet);
    }

    public void addFilelist(org.apache.tools.ant.types.FileList fileList) {
        add(fileList);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.filesets.addElement(fileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void checkConfiguration() {
        if ("execon".equals(getTaskName())) {
            log("!! execon is deprecated. Use apply instead. !!");
        }
        super.checkConfiguration();
        if (this.filesets.size() == 0 && this.M == null) {
            throw new org.apache.tools.ant.BuildException("no resources specified", getLocation());
        }
        if (this.targetFilePos != null && this.mapperElement == null) {
            throw new org.apache.tools.ant.BuildException("targetfile specified without mapper", getLocation());
        }
        if (this.destDir != null && this.mapperElement == null) {
            throw new org.apache.tools.ant.BuildException("dest specified without mapper", getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = this.mapperElement;
        if (mapper != null) {
            this.mapper = mapper.getImplementation();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public org.apache.tools.ant.taskdefs.ExecuteStreamHandler createHandler() throws org.apache.tools.ant.BuildException {
        return this.redirectorElement == null ? super.createHandler() : new org.apache.tools.ant.taskdefs.PumpStreamHandler();
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.mapperElement != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.mapperElement = mapper;
        return mapper;
    }

    public org.apache.tools.ant.types.Commandline.Marker createSrcfile() {
        if (this.srcFilePos == null) {
            org.apache.tools.ant.types.Commandline.Marker createMarker = this.cmdl.createMarker();
            this.srcFilePos = createMarker;
            return createMarker;
        }
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support multiple srcfile elements.", getLocation());
    }

    public org.apache.tools.ant.types.Commandline.Marker createTargetfile() {
        if (this.targetFilePos == null) {
            org.apache.tools.ant.types.Commandline.Marker createMarker = this.cmdl.createMarker();
            this.targetFilePos = createMarker;
            this.srcIsFirst = this.srcFilePos != null;
            return createMarker;
        }
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support multiple targetfile elements.", getLocation());
    }

    public final void g(java.lang.String str, org.apache.tools.ant.DirectoryScanner directoryScanner, java.io.File file) {
        int includedFilesCount = (!"dir".equals(str) ? directoryScanner.getIncludedFilesCount() : 0) + ("file".equals(str) ? 0 : directoryScanner.getIncludedDirsCount());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Skipping fileset for directory ");
        sb.append(file);
        sb.append(". It is ");
        sb.append(includedFilesCount > 0 ? "up to date." : "empty.");
        log(sb.toString(), this.T ? 2 : 3);
    }

    public java.lang.String[] getCommandline(java.lang.String str, java.io.File file) {
        return getCommandline(new java.lang.String[]{str}, new java.io.File[]{file});
    }

    public java.lang.String[] getCommandline(java.lang.String[] strArr, java.io.File[] fileArr) {
        char c = java.io.File.separatorChar;
        java.util.Vector vector = new java.util.Vector();
        if (this.targetFilePos != null) {
            java.util.HashSet hashSet = new java.util.HashSet();
            for (java.lang.String str : strArr) {
                java.lang.String[] mapFileName = this.mapper.mapFileName(str);
                if (mapFileName != null) {
                    for (int i = 0; i < mapFileName.length; i++) {
                        java.lang.String absolutePath = !this.N ? new java.io.File(this.destDir, mapFileName[i]).getAbsolutePath() : mapFileName[i];
                        if (this.P && c != '/') {
                            absolutePath = absolutePath.replace(c, '/');
                        }
                        if (!hashSet.contains(absolutePath)) {
                            vector.addElement(absolutePath);
                            hashSet.add(absolutePath);
                        }
                    }
                }
            }
        }
        java.lang.String[] strArr2 = (java.lang.String[]) vector.toArray(new java.lang.String[vector.size()]);
        if (!this.S) {
            strArr = new java.lang.String[0];
        }
        java.lang.String[] commandline = this.cmdl.getCommandline();
        java.lang.String[] strArr3 = new java.lang.String[commandline.length + strArr.length + strArr2.length];
        int length = commandline.length;
        org.apache.tools.ant.types.Commandline.Marker marker = this.srcFilePos;
        if (marker != null) {
            length = marker.getPosition();
        }
        org.apache.tools.ant.types.Commandline.Marker marker2 = this.targetFilePos;
        if (marker2 != null) {
            int position = marker2.getPosition();
            if (length < position || (length == position && this.srcIsFirst)) {
                java.lang.System.arraycopy(commandline, 0, strArr3, 0, length);
                java.lang.System.arraycopy(commandline, length, strArr3, strArr.length + length, position - length);
                f(strArr2, strArr3, strArr.length + position, this.targetFilePos.getPrefix(), this.targetFilePos.getSuffix());
                java.lang.System.arraycopy(commandline, position, strArr3, strArr.length + position + strArr2.length, commandline.length - position);
            } else {
                java.lang.System.arraycopy(commandline, 0, strArr3, 0, position);
                f(strArr2, strArr3, position, this.targetFilePos.getPrefix(), this.targetFilePos.getSuffix());
                java.lang.System.arraycopy(commandline, position, strArr3, strArr2.length + position, length - position);
                java.lang.System.arraycopy(commandline, length, strArr3, strArr.length + length + strArr2.length, commandline.length - length);
                length += strArr2.length;
            }
        } else {
            java.lang.System.arraycopy(commandline, 0, strArr3, 0, length);
            java.lang.System.arraycopy(commandline, length, strArr3, strArr.length + length, commandline.length - length);
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            java.lang.String absolutePath2 = this.N ? strArr[i2] : new java.io.File(fileArr[i2], strArr[i2]).getAbsolutePath();
            if (this.P && c != '/') {
                absolutePath2 = absolutePath2.replace(c, '/');
            }
            org.apache.tools.ant.types.Commandline.Marker marker3 = this.srcFilePos;
            if (marker3 != null && (marker3.getPrefix().length() > 0 || this.srcFilePos.getSuffix().length() > 0)) {
                absolutePath2 = this.srcFilePos.getPrefix() + absolutePath2 + this.srcFilePos.getSuffix();
            }
            strArr3[length + i2] = absolutePath2;
        }
        return strArr3;
    }

    public java.lang.String[] getDirs(java.io.File file, org.apache.tools.ant.DirectoryScanner directoryScanner) {
        return h(directoryScanner.getIncludedDirectories(), file);
    }

    public java.lang.String[] getFiles(java.io.File file, org.apache.tools.ant.DirectoryScanner directoryScanner) {
        return h(directoryScanner.getIncludedFiles(), file);
    }

    public java.lang.String[] getFilesAndDirs(org.apache.tools.ant.types.FileList fileList) {
        return h(fileList.getFiles(getProject()), fileList.getDir(getProject()));
    }

    public final java.lang.String[] h(java.lang.String[] strArr, java.io.File file) {
        return (this.mapper == null || this.V) ? strArr : new org.apache.tools.ant.util.SourceFileScanner(this).restrict(strArr, file, this.destDir, this.mapper);
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void runExec(org.apache.tools.ant.taskdefs.Execute execute) throws org.apache.tools.ant.BuildException {
        java.io.File file;
        try {
            try {
                java.util.Vector<java.lang.String> vector = new java.util.Vector<>();
                java.util.Vector<java.io.File> vector2 = new java.util.Vector<>();
                int size = this.filesets.size();
                int i = 0;
                boolean z = false;
                int i2 = 0;
                int i3 = 0;
                while (i < size) {
                    java.lang.String str = this.type;
                    org.apache.tools.ant.types.AbstractFileSet elementAt = this.filesets.elementAt(i);
                    if ((elementAt instanceof org.apache.tools.ant.types.DirSet) && !"dir".equals(this.type)) {
                        log("Found a nested dirset but type is " + this.type + ". Temporarily switching to type=\"dir\" on the assumption that you really did mean <dirset> not <fileset>.", 4);
                        str = "dir";
                    }
                    java.io.File dir = elementAt.getDir(getProject());
                    org.apache.tools.ant.DirectoryScanner directoryScanner = elementAt.getDirectoryScanner(getProject());
                    if (!"dir".equals(str)) {
                        java.lang.String[] files = getFiles(dir, directoryScanner);
                        int length = files.length;
                        int i4 = 0;
                        while (i4 < length) {
                            i2++;
                            vector.add(files[i4]);
                            vector2.add(dir);
                            i4++;
                            size = size;
                        }
                    }
                    int i5 = size;
                    if (!"file".equals(str)) {
                        for (java.lang.String str2 : getDirs(dir, directoryScanner)) {
                            i3++;
                            vector.add(str2);
                            vector2.add(dir);
                        }
                    }
                    if (vector.size() == 0 && this.Q) {
                        g(str, directoryScanner, dir);
                    } else if (!this.O) {
                        int size2 = vector.size();
                        java.lang.String[] strArr = new java.lang.String[size2];
                        vector.copyInto(strArr);
                        int i6 = 0;
                        while (i6 < size2) {
                            java.lang.String[] commandline = getCommandline(strArr[i6], dir);
                            log(org.apache.tools.ant.types.Commandline.describeCommand(commandline), 3);
                            execute.setCommandline(commandline);
                            if (this.redirectorElement != null) {
                                setupRedirector();
                                this.redirectorElement.configure(this.redirector, strArr[i6]);
                            }
                            if (this.redirectorElement != null || z) {
                                execute.setStreamHandler(this.redirector.createHandler());
                            }
                            runExecute(execute);
                            i6++;
                            z = true;
                        }
                        vector.removeAllElements();
                        vector2.removeAllElements();
                    }
                    i++;
                    size = i5;
                }
                org.apache.tools.ant.types.resources.Union union = this.M;
                if (union != null) {
                    java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
                    while (it.hasNext()) {
                        org.apache.tools.ant.types.Resource next = it.next();
                        if (next.isExists() || !this.U) {
                            java.lang.String name = next.getName();
                            org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) next.as(org.apache.tools.ant.types.resources.FileProvider.class);
                            if (fileProvider != null) {
                                org.apache.tools.ant.types.resources.FileResource asFileResource = org.apache.tools.ant.util.ResourceUtils.asFileResource(fileProvider);
                                file = asFileResource.getBaseDir();
                                if (file == null) {
                                    name = asFileResource.getFile().getAbsolutePath();
                                }
                            } else {
                                file = null;
                            }
                            if (h(new java.lang.String[]{name}, file).length != 0) {
                                if ((!next.isDirectory() || !next.isExists()) && !"dir".equals(this.type)) {
                                    i2++;
                                } else if (next.isDirectory() && !"file".equals(this.type)) {
                                    i3++;
                                }
                                vector2.add(file);
                                vector.add(name);
                                if (!this.O) {
                                    java.lang.String[] commandline2 = getCommandline(name, file);
                                    log(org.apache.tools.ant.types.Commandline.describeCommand(commandline2), 3);
                                    execute.setCommandline(commandline2);
                                    if (this.redirectorElement != null) {
                                        setupRedirector();
                                        this.redirectorElement.configure(this.redirector, name);
                                    }
                                    if (this.redirectorElement != null || z) {
                                        execute.setStreamHandler(this.redirector.createHandler());
                                    }
                                    runExecute(execute);
                                    vector.removeAllElements();
                                    vector2.removeAllElements();
                                    z = true;
                                }
                            }
                        }
                    }
                }
                if (this.O && (vector.size() > 0 || !this.Q)) {
                    runParallel(execute, vector, vector2);
                    z = true;
                }
                if (z) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Applied ");
                    sb.append(this.cmdl.getExecutable());
                    sb.append(" to ");
                    sb.append(i2);
                    sb.append(" file");
                    sb.append(i2 != 1 ? "s" : "");
                    sb.append(" and ");
                    sb.append(i3);
                    sb.append(" director");
                    sb.append(i3 != 1 ? "ies" : "y");
                    sb.append(".");
                    log(sb.toString(), this.T ? 2 : 3);
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Execute failed: " + e, e, getLocation());
            }
        } finally {
            logFlush();
            this.redirector.setAppendProperties(false);
            this.redirector.setProperties();
        }
    }

    public void runParallel(org.apache.tools.ant.taskdefs.Execute execute, java.util.Vector<java.lang.String> vector, java.util.Vector<java.io.File> vector2) throws java.io.IOException, org.apache.tools.ant.BuildException {
        int size = vector.size();
        java.lang.String[] strArr = new java.lang.String[size];
        vector.copyInto(strArr);
        java.io.File[] fileArr = new java.io.File[vector2.size()];
        vector2.copyInto(fileArr);
        if (this.R <= 0 || size == 0) {
            java.lang.String[] commandline = getCommandline(strArr, fileArr);
            log(org.apache.tools.ant.types.Commandline.describeCommand(commandline), 3);
            execute.setCommandline(commandline);
            if (this.redirectorElement != null) {
                setupRedirector();
                this.redirectorElement.configure(this.redirector, null);
                execute.setStreamHandler(this.redirector.createHandler());
            }
            runExecute(execute);
            return;
        }
        int size2 = vector.size();
        int i = 0;
        while (size2 > 0) {
            int min = java.lang.Math.min(size2, this.R);
            java.lang.String[] strArr2 = new java.lang.String[min];
            java.lang.System.arraycopy(strArr, i, strArr2, 0, min);
            java.io.File[] fileArr2 = new java.io.File[min];
            java.lang.System.arraycopy(fileArr, i, fileArr2, 0, min);
            java.lang.String[] commandline2 = getCommandline(strArr2, fileArr2);
            log(org.apache.tools.ant.types.Commandline.describeCommand(commandline2), 3);
            execute.setCommandline(commandline2);
            if (this.redirectorElement != null) {
                setupRedirector();
                this.redirectorElement.configure(this.redirector, null);
            }
            if (this.redirectorElement != null || i > 0) {
                execute.setStreamHandler(this.redirector.createHandler());
            }
            runExecute(execute);
            size2 -= min;
            i += min;
        }
    }

    public void setAddsourcefile(boolean z) {
        this.S = z;
    }

    public void setDest(java.io.File file) {
        this.destDir = file;
    }

    public void setForce(boolean z) {
        this.V = z;
    }

    public void setForwardslash(boolean z) {
        this.P = z;
    }

    public void setIgnoremissing(boolean z) {
        this.U = z;
    }

    public void setMaxParallel(int i) {
        this.R = i;
    }

    public void setParallel(boolean z) {
        this.O = z;
    }

    public void setRelative(boolean z) {
        this.N = z;
    }

    public void setSkipEmptyFilesets(boolean z) {
        this.Q = z;
    }

    public void setType(org.apache.tools.ant.taskdefs.ExecuteOn.FileDirBoth fileDirBoth) {
        this.type = fileDirBoth.getValue();
    }

    public void setVerbose(boolean z) {
        this.T = z;
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setupRedirector() {
        super.setupRedirector();
        this.redirector.setAppendProperties(true);
    }
}

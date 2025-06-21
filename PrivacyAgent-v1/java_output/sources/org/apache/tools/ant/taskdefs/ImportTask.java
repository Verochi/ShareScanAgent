package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ImportTask extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils z = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.String u;
    public boolean v;
    public java.lang.String w = org.apache.tools.ant.ProjectHelper.USE_PROJECT_NAME_AS_TARGET_PREFIX;
    public java.lang.String x = ".";
    public final org.apache.tools.ant.types.resources.Union y;

    public ImportTask() {
        org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
        this.y = union;
        union.setCache(true);
    }

    public static void h(java.lang.String str, java.lang.String str2, boolean z2) {
        org.apache.tools.ant.ProjectHelper.setCurrentTargetPrefix(str);
        org.apache.tools.ant.ProjectHelper.setCurrentPrefixSeparator(str2);
        org.apache.tools.ant.ProjectHelper.setInIncludeMode(z2);
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.y.add(resourceCollection);
    }

    public final org.apache.tools.ant.types.Resource c() {
        java.lang.String str = this.u;
        if (str == null) {
            return null;
        }
        if (f(str)) {
            return new org.apache.tools.ant.types.resources.FileResource(z.normalize(this.u));
        }
        java.io.File absoluteFile = new java.io.File(getLocation().getFileName()).getAbsoluteFile();
        if (absoluteFile.exists()) {
            return new org.apache.tools.ant.types.resources.FileResource(z.resolveFile(new java.io.File(absoluteFile.getParent()), this.u));
        }
        try {
            return new org.apache.tools.ant.types.resources.URLResource(new java.net.URL(new java.net.URL(getLocation().getFileName()), this.u));
        } catch (java.net.MalformedURLException e) {
            log(e.toString(), 3);
            throw new org.apache.tools.ant.BuildException("failed to resolve " + this.u + " relative to " + getLocation().getFileName());
        }
    }

    public final boolean d(org.apache.tools.ant.types.Resource resource, java.util.Vector<java.lang.Object> vector) {
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        java.io.File file = fileProvider != null ? fileProvider.getFile() : null;
        org.apache.tools.ant.types.resources.URLProvider uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) resource.as(org.apache.tools.ant.types.resources.URLProvider.class);
        java.net.URL url = uRLProvider != null ? uRLProvider.getURL() : null;
        java.util.Iterator<java.lang.Object> it = vector.iterator();
        while (it.hasNext()) {
            if (g(it.next(), resource, file, url)) {
                return true;
            }
        }
        return false;
    }

    public final void e(org.apache.tools.ant.ProjectHelper projectHelper, org.apache.tools.ant.types.Resource resource) {
        java.lang.String str;
        java.util.Vector<java.lang.Object> importStack = projectHelper.getImportStack();
        getProject().log("Importing file " + resource + " from " + getLocation().getFileName(), 3);
        if (!resource.isExists()) {
            java.lang.String str2 = "Cannot find " + resource + " imported from " + getLocation().getFileName();
            if (!this.v) {
                throw new org.apache.tools.ant.BuildException(str2);
            }
            getProject().log(str2, 3);
            return;
        }
        if (!isInIncludeMode() && d(resource, importStack)) {
            getProject().log("Skipped already imported file:\n   " + resource + "\n", 3);
            return;
        }
        java.lang.String currentTargetPrefix = org.apache.tools.ant.ProjectHelper.getCurrentTargetPrefix();
        boolean isInIncludeMode = org.apache.tools.ant.ProjectHelper.isInIncludeMode();
        java.lang.String currentPrefixSeparator = org.apache.tools.ant.ProjectHelper.getCurrentPrefixSeparator();
        try {
            try {
                if (!isInIncludeMode() || currentTargetPrefix == null || this.w == null) {
                    str = isInIncludeMode() ? this.w : !org.apache.tools.ant.ProjectHelper.USE_PROJECT_NAME_AS_TARGET_PREFIX.equals(this.w) ? this.w : currentTargetPrefix;
                } else {
                    str = currentTargetPrefix + currentPrefixSeparator + this.w;
                }
                h(str, this.x, isInIncludeMode());
                org.apache.tools.ant.ProjectHelper projectHelperForBuildFile = org.apache.tools.ant.ProjectHelperRepository.getInstance().getProjectHelperForBuildFile(resource);
                projectHelperForBuildFile.getImportStack().addAll(projectHelper.getImportStack());
                projectHelperForBuildFile.getExtensionStack().addAll(projectHelper.getExtensionStack());
                getProject().addReference("ant.projectHelper", projectHelperForBuildFile);
                projectHelperForBuildFile.parse(getProject(), resource);
                getProject().addReference("ant.projectHelper", projectHelper);
                projectHelper.getImportStack().clear();
                projectHelper.getImportStack().addAll(projectHelperForBuildFile.getImportStack());
                projectHelper.getExtensionStack().clear();
                projectHelper.getExtensionStack().addAll(projectHelperForBuildFile.getExtensionStack());
            } catch (org.apache.tools.ant.BuildException e) {
                throw org.apache.tools.ant.ProjectHelper.addLocationToBuildException(e, getLocation());
            }
        } finally {
            h(currentTargetPrefix, currentPrefixSeparator, isInIncludeMode);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.u == null && this.y.size() == 0) {
            throw new org.apache.tools.ant.BuildException("import requires file attribute or at least one nested resource");
        }
        if (getOwningTarget() == null || !"".equals(getOwningTarget().getName())) {
            throw new org.apache.tools.ant.BuildException("import only allowed as a top-level task");
        }
        org.apache.tools.ant.ProjectHelper projectHelper = (org.apache.tools.ant.ProjectHelper) getProject().getReference("ant.projectHelper");
        if (projectHelper == null) {
            throw new org.apache.tools.ant.BuildException("import requires support in ProjectHelper");
        }
        if (projectHelper.getImportStack().size() == 0) {
            throw new org.apache.tools.ant.BuildException("import requires support in ProjectHelper");
        }
        if (getLocation() == null || getLocation().getFileName() == null) {
            throw new org.apache.tools.ant.BuildException("Unable to get location of import task");
        }
        org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union(getProject(), this.y);
        org.apache.tools.ant.types.Resource c = c();
        if (c != null) {
            this.y.add(c);
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
        while (it.hasNext()) {
            e(projectHelper, it.next());
        }
    }

    public final boolean f(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        return file.isAbsolute() && file.exists();
    }

    public final boolean g(java.lang.Object obj, org.apache.tools.ant.types.Resource resource, java.io.File file, java.net.URL url) {
        org.apache.tools.ant.types.resources.URLProvider uRLProvider;
        org.apache.tools.ant.types.resources.FileProvider fileProvider;
        if (obj.equals(resource) || obj.equals(file) || obj.equals(url)) {
            return true;
        }
        if (!(obj instanceof org.apache.tools.ant.types.Resource)) {
            return false;
        }
        if (file == null || (fileProvider = (org.apache.tools.ant.types.resources.FileProvider) ((org.apache.tools.ant.types.Resource) obj).as(org.apache.tools.ant.types.resources.FileProvider.class)) == null || !fileProvider.getFile().equals(file)) {
            return (url == null || (uRLProvider = (org.apache.tools.ant.types.resources.URLProvider) ((org.apache.tools.ant.types.Resource) obj).as(org.apache.tools.ant.types.resources.URLProvider.class)) == null || !uRLProvider.getURL().equals(url)) ? false : true;
        }
        return true;
    }

    public final boolean isInIncludeMode() {
        return "include".equals(getTaskType());
    }

    public void setAs(java.lang.String str) {
        this.w = str;
    }

    public void setFile(java.lang.String str) {
        this.u = str;
    }

    public void setOptional(boolean z2) {
        this.v = z2;
    }

    public void setPrefixSeparator(java.lang.String str) {
        this.x = str;
    }
}

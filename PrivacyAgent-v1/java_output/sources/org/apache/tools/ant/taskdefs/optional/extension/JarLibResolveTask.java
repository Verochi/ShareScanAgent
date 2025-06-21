package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class JarLibResolveTask extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public org.apache.tools.ant.taskdefs.optional.extension.Extension v;
    public final java.util.ArrayList w = new java.util.ArrayList();
    public boolean x = true;
    public boolean y = true;

    public void addConfiguredAnt(org.apache.tools.ant.taskdefs.optional.extension.resolvers.AntResolver antResolver) {
        this.w.add(antResolver);
    }

    public void addConfiguredExtension(org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter extensionAdapter) {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("Can not specify extension to resolve multiple times.");
        }
        this.v = extensionAdapter.b();
    }

    public void addConfiguredLocation(org.apache.tools.ant.taskdefs.optional.extension.resolvers.LocationResolver locationResolver) {
        this.w.add(locationResolver);
    }

    public void addConfiguredUrl(org.apache.tools.ant.taskdefs.optional.extension.resolvers.URLResolver uRLResolver) {
        this.w.add(uRLResolver);
    }

    public final void c(java.io.File file) {
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException("File " + file + " does not exist");
        }
        if (!file.isFile()) {
            throw new org.apache.tools.ant.BuildException("File " + file + " is not a file");
        }
        if (!this.x) {
            getProject().log("Setting property to " + file + " without verifying library satisfies extension", 3);
            e(file);
            return;
        }
        getProject().log("Checking file " + file + " to see if it satisfies extension", 3);
        for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : org.apache.tools.ant.taskdefs.optional.extension.Extension.getAvailable(org.apache.tools.ant.taskdefs.optional.extension.ExtensionUtil.e(file))) {
            if (extension.isCompatibleWith(this.v)) {
                e(file);
                return;
            }
        }
        java.lang.String str = "File " + file + " skipped as it does not satisfy extension";
        getProject().log(str, 3);
        throw new org.apache.tools.ant.BuildException(str);
    }

    public final void d() {
        if (this.y) {
            throw new org.apache.tools.ant.BuildException("Unable to resolve extension to a file");
        }
        getProject().log("Unable to resolve extension to a file", 0);
    }

    public final void e(java.io.File file) {
        getProject().setNewProperty(this.u, file.getAbsolutePath());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        getProject().log("Resolving extension: " + this.v, 3);
        java.lang.String property = getProject().getProperty(this.u);
        if (property != null) {
            java.lang.String str = "Property Already set to: " + property;
            if (this.y) {
                throw new org.apache.tools.ant.BuildException(str);
            }
            getProject().log(str, 0);
            return;
        }
        int size = this.w.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver extensionResolver = (org.apache.tools.ant.taskdefs.optional.extension.ExtensionResolver) this.w.get(i);
            getProject().log("Searching for extension using Resolver:" + extensionResolver, 3);
            try {
                java.io.File resolve = extensionResolver.resolve(this.v, getProject());
                try {
                    c(resolve);
                    return;
                } catch (org.apache.tools.ant.BuildException e) {
                    getProject().log("File " + resolve + " returned by resolver failed to satisfy extension due to: " + e.getMessage(), 1);
                }
            } catch (org.apache.tools.ant.BuildException e2) {
                getProject().log("Failed to resolve extension to file using resolver " + extensionResolver + " due to: " + e2, 1);
            }
        }
        d();
    }

    public void setCheckExtension(boolean z) {
        this.x = z;
    }

    public void setFailOnError(boolean z) {
        this.y = z;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("Property attribute must be specified.");
        }
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("Extension element must be specified.");
        }
    }
}

package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Classloader extends org.apache.tools.ant.Task {
    public static final java.lang.String SYSTEM_LOADER_REF = "ant.coreLoader";
    public org.apache.tools.ant.types.Path v;
    public java.lang.String u = null;
    public boolean w = false;
    public boolean x = true;
    public java.lang.String y = null;

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(null);
        }
        return this.v.createPath();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        org.apache.tools.ant.types.Path path;
        java.lang.String str;
        try {
            java.lang.String str2 = "ant.coreLoader";
            if (com.tencent.open.SocialConstants.PARAM_ONLY.equals(getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH)) && ((str = this.u) == null || "ant.coreLoader".equals(str))) {
                log("Changing the system loader is disabled by build.sysclasspath=only", 1);
                return;
            }
            java.lang.String str3 = this.u;
            if (str3 != null) {
                str2 = str3;
            }
            java.lang.Object reference = getProject().getReference(str2);
            java.lang.Object obj = null;
            if (this.w) {
                reference = null;
            }
            if (reference != null && !(reference instanceof org.apache.tools.ant.AntClassLoader)) {
                log("Referenced object is not an AntClassLoader", 0);
                return;
            }
            org.apache.tools.ant.AntClassLoader antClassLoader = (org.apache.tools.ant.AntClassLoader) reference;
            boolean z = antClassLoader != null;
            if (antClassLoader == null) {
                if (this.y != null) {
                    java.lang.Object reference2 = getProject().getReference(this.y);
                    if (reference2 instanceof java.lang.ClassLoader) {
                        obj = reference2;
                    }
                }
                if (obj == null) {
                    obj = getClass().getClassLoader();
                }
                getProject().log("Setting parent loader " + this.u + " " + obj + " " + this.x, 4);
                antClassLoader = org.apache.tools.ant.AntClassLoader.newAntClassLoader((java.lang.ClassLoader) obj, getProject(), this.v, this.x);
                getProject().addReference(str2, antClassLoader);
                if (this.u == null) {
                    antClassLoader.addLoaderPackageRoot("org.apache.tools.ant.taskdefs.optional");
                    getProject().setCoreLoader(antClassLoader);
                }
            }
            if (!z || (path = this.v) == null) {
                return;
            }
            for (java.lang.String str4 : path.list()) {
                java.io.File file = new java.io.File(str4);
                if (file.exists()) {
                    log("Adding to class loader " + antClassLoader + " " + file.getAbsolutePath(), 4);
                    antClassLoader.addPathElement(file.getAbsolutePath());
                }
            }
        } catch (java.lang.Exception e) {
            log(org.apache.tools.ant.util.StringUtils.getStackTrace(e), 0);
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.v;
        if (path2 == null) {
            this.v = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        this.v = (org.apache.tools.ant.types.Path) reference.getReferencedObject(getProject());
    }

    public void setName(java.lang.String str) {
        this.u = str;
    }

    public void setParentFirst(boolean z) {
        this.x = z;
    }

    public void setParentName(java.lang.String str) {
        this.y = str;
    }

    public void setReset(boolean z) {
        this.w = z;
    }

    public void setReverse(boolean z) {
        this.x = !z;
    }
}

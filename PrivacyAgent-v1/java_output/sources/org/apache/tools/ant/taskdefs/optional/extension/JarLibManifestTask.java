package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public final class JarLibManifestTask extends org.apache.tools.ant.Task {
    public java.io.File u;
    public org.apache.tools.ant.taskdefs.optional.extension.Extension v;
    public final java.util.ArrayList w = new java.util.ArrayList();
    public final java.util.ArrayList x = new java.util.ArrayList();
    public final java.util.ArrayList y = new java.util.ArrayList();

    public void addConfiguredAttribute(org.apache.tools.ant.taskdefs.optional.extension.ExtraAttribute extraAttribute) {
        this.y.add(extraAttribute);
    }

    public void addConfiguredDepends(org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet extensionSet) {
        this.w.add(extensionSet);
    }

    public void addConfiguredExtension(org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter extensionAdapter) throws org.apache.tools.ant.BuildException {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("Can not have multiple extensions defined in one library.");
        }
        this.v = extensionAdapter.b();
    }

    public void addConfiguredOptions(org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet extensionSet) {
        this.x.add(extensionSet);
    }

    public final void c(java.util.jar.Attributes attributes, java.util.jar.Attributes.Name name, java.lang.String str, int i) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str);
            stringBuffer.append(i2);
            stringBuffer.append(' ');
        }
        attributes.put(name, stringBuffer.toString());
    }

    public final void d(java.util.jar.Attributes attributes) {
        java.util.Iterator it = this.y.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.extension.ExtraAttribute extraAttribute = (org.apache.tools.ant.taskdefs.optional.extension.ExtraAttribute) it.next();
            attributes.putValue(extraAttribute.a(), extraAttribute.b());
        }
    }

    public final void e(java.util.jar.Attributes attributes, java.lang.String str, java.util.ArrayList arrayList) throws org.apache.tools.ant.BuildException {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.taskdefs.optional.extension.Extension.addExtension((org.apache.tools.ant.taskdefs.optional.extension.Extension) arrayList.get(i), str + i + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, attributes);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        java.util.jar.Manifest manifest = new java.util.jar.Manifest();
        java.util.jar.Attributes mainAttributes = manifest.getMainAttributes();
        mainAttributes.put(java.util.jar.Attributes.Name.MANIFEST_VERSION, "1.0");
        mainAttributes.putValue("Created-By", "Apache Ant " + getProject().getProperty(org.apache.tools.ant.MagicNames.ANT_VERSION));
        d(mainAttributes);
        org.apache.tools.ant.taskdefs.optional.extension.Extension extension = this.v;
        if (extension != null) {
            org.apache.tools.ant.taskdefs.optional.extension.Extension.addExtension(extension, mainAttributes);
        }
        java.util.ArrayList f = f(this.w);
        c(mainAttributes, org.apache.tools.ant.taskdefs.optional.extension.Extension.EXTENSION_LIST, "lib", f.size());
        e(mainAttributes, "lib", f);
        java.util.ArrayList f2 = f(this.x);
        c(mainAttributes, org.apache.tools.ant.taskdefs.optional.extension.Extension.OPTIONAL_EXTENSION_LIST, "opt", f2.size());
        e(mainAttributes, "opt", f2);
        try {
            log("Generating manifest " + this.u.getAbsoluteFile(), 2);
            g(manifest);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        }
    }

    public final java.util.ArrayList f(java.util.ArrayList arrayList) throws org.apache.tools.ant.BuildException {
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : ((org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet) arrayList.get(i)).toExtensions(getProject())) {
                arrayList2.add(extension);
            }
        }
        return arrayList2;
    }

    public final void g(java.util.jar.Manifest manifest) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = null;
        try {
            java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(this.u);
            try {
                manifest.write(fileOutputStream2);
                fileOutputStream2.flush();
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public void setDestfile(java.io.File file) {
        this.u = file;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.u;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("Destfile attribute not specified.");
        }
        if (!file.exists() || this.u.isFile()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(this.u + " is not a file.");
    }
}

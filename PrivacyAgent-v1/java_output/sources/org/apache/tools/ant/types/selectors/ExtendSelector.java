package org.apache.tools.ant.types.selectors;

/* loaded from: classes26.dex */
public class ExtendSelector extends org.apache.tools.ant.types.selectors.BaseSelector {
    public java.lang.String u = null;
    public org.apache.tools.ant.types.selectors.FileSelector v = null;
    public java.util.Vector<org.apache.tools.ant.types.Parameter> w = new java.util.Vector<>();
    public org.apache.tools.ant.types.Path x = null;

    public void addParam(org.apache.tools.ant.types.Parameter parameter) {
        this.w.addElement(parameter);
    }

    public final org.apache.tools.ant.types.Path createClasspath() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    public final org.apache.tools.ant.types.Path getClasspath() {
        return this.x;
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector, org.apache.tools.ant.types.selectors.FileSelector
    public boolean isSelected(java.io.File file, java.lang.String str, java.io.File file2) throws org.apache.tools.ant.BuildException {
        validate();
        if (this.w.size() > 0 && (this.v instanceof org.apache.tools.ant.types.selectors.ExtendFileSelector)) {
            org.apache.tools.ant.types.Parameter[] parameterArr = new org.apache.tools.ant.types.Parameter[this.w.size()];
            this.w.copyInto(parameterArr);
            ((org.apache.tools.ant.types.selectors.ExtendFileSelector) this.v).setParameters(parameterArr);
        }
        return this.v.isSelected(file, str, file2);
    }

    public void selectorCreate() {
        java.lang.Class<?> cls;
        java.lang.String str = this.u;
        if (str == null || str.length() <= 0) {
            setError("There is no classname specified");
            return;
        }
        try {
            if (this.x == null) {
                cls = java.lang.Class.forName(this.u);
            } else {
                cls = java.lang.Class.forName(this.u, true, getProject().createClassLoader(this.x));
            }
            this.v = (org.apache.tools.ant.types.selectors.FileSelector) cls.asSubclass(org.apache.tools.ant.types.selectors.FileSelector.class).newInstance();
            org.apache.tools.ant.Project project = getProject();
            if (project != null) {
                project.setProjectReference(this.v);
            }
        } catch (java.lang.ClassNotFoundException unused) {
            setError("Selector " + this.u + " not initialized, no such class");
        } catch (java.lang.IllegalAccessException unused2) {
            setError("Selector " + this.u + " not initialized, class not accessible");
        } catch (java.lang.InstantiationException unused3) {
            setError("Selector " + this.u + " not initialized, could not create class");
        }
    }

    public void setClassname(java.lang.String str) {
        this.u = str;
    }

    public final void setClasspath(org.apache.tools.ant.types.Path path) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathref(org.apache.tools.ant.types.Reference reference) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        createClasspath().setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.selectors.BaseSelector
    public void verifySettings() {
        if (this.v == null) {
            selectorCreate();
        }
        java.lang.String str = this.u;
        if (str == null || str.length() < 1) {
            setError("The classname attribute is required");
            return;
        }
        org.apache.tools.ant.types.selectors.FileSelector fileSelector = this.v;
        if (fileSelector == null) {
            setError("Internal Error: The custom selector was not created");
        } else {
            if ((fileSelector instanceof org.apache.tools.ant.types.selectors.ExtendFileSelector) || this.w.size() <= 0) {
                return;
            }
            setError("Cannot set parameters on custom selector that does not implement ExtendFileSelector");
        }
    }
}

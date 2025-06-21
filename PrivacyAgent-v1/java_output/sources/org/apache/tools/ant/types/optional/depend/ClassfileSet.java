package org.apache.tools.ant.types.optional.depend;

/* loaded from: classes26.dex */
public class ClassfileSet extends org.apache.tools.ant.types.FileSet {
    public java.util.List<java.lang.String> D;
    public java.util.List<org.apache.tools.ant.types.FileSet> E;

    public static class ClassRoot {
        public java.lang.String a;

        public java.lang.String getClassname() {
            return this.a;
        }

        public void setClassname(java.lang.String str) {
            this.a = str;
        }
    }

    public ClassfileSet() {
        this.D = new java.util.ArrayList();
        this.E = new java.util.ArrayList();
    }

    public ClassfileSet(org.apache.tools.ant.types.optional.depend.ClassfileSet classfileSet) {
        super(classfileSet);
        this.D = new java.util.ArrayList();
        this.E = new java.util.ArrayList();
        this.D.addAll(classfileSet.D);
    }

    public void addConfiguredRoot(org.apache.tools.ant.types.optional.depend.ClassfileSet.ClassRoot classRoot) {
        this.D.add(classRoot.getClassname());
    }

    public void addRootFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.E.add(fileSet);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return new org.apache.tools.ant.types.optional.depend.ClassfileSet(isReference() ? (org.apache.tools.ant.types.optional.depend.ClassfileSet) getRef(getProject()) : this);
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) {
        if (isChecked()) {
            return;
        }
        super.dieOnCircularReference(stack, project);
        if (!isReference()) {
            java.util.Iterator<org.apache.tools.ant.types.FileSet> it = this.E.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(it.next(), stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public org.apache.tools.ant.DirectoryScanner getDirectoryScanner(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(project).getDirectoryScanner(project);
        }
        dieOnCircularReference(project);
        org.apache.tools.ant.types.optional.depend.DependScanner dependScanner = new org.apache.tools.ant.types.optional.depend.DependScanner(super.getDirectoryScanner(project));
        java.util.Vector<java.lang.String> vector = new java.util.Vector<>(this.D);
        for (org.apache.tools.ant.types.FileSet fileSet : this.E) {
            for (java.lang.String str : fileSet.getDirectoryScanner(project).getIncludedFiles()) {
                if (str.endsWith(".class")) {
                    vector.addElement(org.apache.tools.ant.util.StringUtils.removeSuffix(str, ".class").replace('/', '.').replace('\\', '.'));
                }
            }
            dependScanner.addBasedir(fileSet.getDir(project));
        }
        dependScanner.setBasedir(getDir(project));
        dependScanner.setRootClasses(vector);
        dependScanner.scan();
        return dependScanner;
    }

    public void setRootClass(java.lang.String str) {
        this.D.add(str);
    }
}

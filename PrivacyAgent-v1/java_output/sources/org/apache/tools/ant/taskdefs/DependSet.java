package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class DependSet extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.types.resources.selectors.ResourceSelector x = new org.apache.tools.ant.types.resources.selectors.Not(new org.apache.tools.ant.types.resources.selectors.Exists());
    public static final org.apache.tools.ant.types.resources.comparators.ResourceComparator y;
    public static final org.apache.tools.ant.types.resources.comparators.ResourceComparator z;
    public org.apache.tools.ant.types.resources.Union u = null;
    public org.apache.tools.ant.types.Path v = null;
    public boolean w;

    public static final class HideMissingBasedir implements org.apache.tools.ant.types.ResourceCollection {
        public org.apache.tools.ant.types.FileSet n;

        public HideMissingBasedir(org.apache.tools.ant.types.FileSet fileSet) {
            this.n = fileSet;
        }

        public /* synthetic */ HideMissingBasedir(org.apache.tools.ant.types.FileSet fileSet, org.apache.tools.ant.taskdefs.DependSet.AnonymousClass1 anonymousClass1) {
            this(fileSet);
        }

        public final boolean a() {
            java.io.File dir = this.n.getDir();
            return dir == null || dir.exists();
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            return a() ? this.n.iterator() : org.apache.tools.ant.types.resources.Resources.EMPTY_ITERATOR;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            if (a()) {
                return this.n.size();
            }
            return 0;
        }
    }

    public static final class NonExistent extends org.apache.tools.ant.types.resources.Restrict {
        public NonExistent(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
            super.add(resourceCollection);
            super.add(org.apache.tools.ant.taskdefs.DependSet.x);
        }

        public /* synthetic */ NonExistent(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.taskdefs.DependSet.AnonymousClass1 anonymousClass1) {
            this(resourceCollection);
        }
    }

    static {
        org.apache.tools.ant.types.resources.comparators.Date date = new org.apache.tools.ant.types.resources.comparators.Date();
        y = date;
        z = new org.apache.tools.ant.types.resources.comparators.Reverse(date);
    }

    public void addSrcfilelist(org.apache.tools.ant.types.FileList fileList) {
        createSources().add(fileList);
    }

    public void addSrcfileset(org.apache.tools.ant.types.FileSet fileSet) {
        createSources().add(fileSet);
    }

    public void addTargetfilelist(org.apache.tools.ant.types.FileList fileList) {
        createTargets().add(fileList);
    }

    public void addTargetfileset(org.apache.tools.ant.types.FileSet fileSet) {
        createTargets().add(new org.apache.tools.ant.taskdefs.DependSet.HideMissingBasedir(fileSet, null));
    }

    public synchronized org.apache.tools.ant.types.resources.Union createSources() {
        org.apache.tools.ant.types.resources.Union union;
        union = this.u;
        if (union == null) {
            union = new org.apache.tools.ant.types.resources.Union();
        }
        this.u = union;
        return union;
    }

    public synchronized org.apache.tools.ant.types.Path createTargets() {
        org.apache.tools.ant.types.Path path;
        path = this.v;
        if (path == null) {
            path = new org.apache.tools.ant.types.Path(getProject());
        }
        this.v = path;
        return path;
    }

    public final org.apache.tools.ant.types.Resource d(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        return f(resourceCollection, y);
    }

    public final org.apache.tools.ant.types.Resource e(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        return f(resourceCollection, z);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.resources.Union union = this.u;
        if (union == null) {
            throw new org.apache.tools.ant.BuildException("At least one set of source resources must be specified");
        }
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("At least one set of target files must be specified");
        }
        if (union.size() <= 0 || this.v.size() <= 0 || j(this.u, this.v)) {
            return;
        }
        log("Deleting all target files.", 3);
        if (this.w) {
            for (java.lang.String str : this.v.list()) {
                log("Deleting " + str);
            }
        }
        org.apache.tools.ant.taskdefs.Delete delete = new org.apache.tools.ant.taskdefs.Delete();
        delete.bindToOwner(this);
        delete.add(this.v);
        delete.perform();
    }

    public final org.apache.tools.ant.types.Resource f(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        org.apache.tools.ant.types.Resource next = it.next();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next2 = it.next();
            if (resourceComparator.compare(next, next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public final void g(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.types.resources.selectors.ResourceSelector resourceSelector) {
        org.apache.tools.ant.types.resources.Restrict restrict = new org.apache.tools.ant.types.resources.Restrict();
        restrict.add(resourceSelector);
        restrict.add(resourceCollection);
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = restrict.iterator();
        while (it.hasNext()) {
            log("Warning: " + it.next() + " modified in the future.", 1);
        }
    }

    public final void h(org.apache.tools.ant.types.ResourceCollection resourceCollection, java.lang.String str) {
        if (this.w) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
            while (it.hasNext()) {
                log("Expected " + str + " " + it.next().toLongString() + " is missing.");
            }
        }
    }

    public final void i(org.apache.tools.ant.types.Resource resource, java.lang.String str) {
        log(resource.toLongString() + " is " + str + ", modified at " + new java.util.Date(resource.getLastModified()), this.w ? 2 : 3);
    }

    public final boolean j(org.apache.tools.ant.types.ResourceCollection resourceCollection, org.apache.tools.ant.types.ResourceCollection resourceCollection2) {
        org.apache.tools.ant.types.resources.selectors.Date date = new org.apache.tools.ant.types.resources.selectors.Date();
        date.setMillis(java.lang.System.currentTimeMillis());
        date.setWhen(org.apache.tools.ant.types.TimeComparison.AFTER);
        date.setGranularity(0L);
        g(this.v, date);
        org.apache.tools.ant.types.ResourceCollection nonExistent = new org.apache.tools.ant.taskdefs.DependSet.NonExistent(this.v, null);
        int size = nonExistent.size();
        if (size > 0) {
            log(size + " nonexistent targets", 3);
            h(nonExistent, com.umeng.ccg.a.A);
            return false;
        }
        org.apache.tools.ant.types.Resource e = e(this.v);
        i(e, "oldest target file");
        g(this.u, date);
        org.apache.tools.ant.types.ResourceCollection nonExistent2 = new org.apache.tools.ant.taskdefs.DependSet.NonExistent(this.u, null);
        int size2 = nonExistent2.size();
        if (size2 <= 0) {
            org.apache.tools.ant.types.Resource d = d(this.u);
            i(d, "newest source");
            return e.getLastModified() >= d.getLastModified();
        }
        log(size2 + " nonexistent sources", 3);
        h(nonExistent2, com.tencent.open.SocialConstants.PARAM_SOURCE);
        return false;
    }

    public void setVerbose(boolean z2) {
        this.w = z2;
    }
}

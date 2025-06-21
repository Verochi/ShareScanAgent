package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Filter extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.lang.String v;
    public java.io.File w;

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.w;
        boolean z = file != null && this.u == null && this.v == null;
        boolean z2 = (file != null || this.u == null || this.v == null) ? false : true;
        if (!z && !z2) {
            throw new org.apache.tools.ant.BuildException("both token and value parameters, or only a filtersFile parameter is required", getLocation());
        }
        if (z2) {
            getProject().getGlobalFilterSet().addFilter(this.u, this.v);
        }
        if (z) {
            readFilters();
        }
    }

    public void readFilters() throws org.apache.tools.ant.BuildException {
        log("Reading filters from " + this.w, 3);
        getProject().getGlobalFilterSet().readFiltersFromFile(this.w);
    }

    public void setFiltersfile(java.io.File file) {
        this.w = file;
    }

    public void setToken(java.lang.String str) {
        this.u = str;
    }

    public void setValue(java.lang.String str) {
        this.v = str;
    }
}

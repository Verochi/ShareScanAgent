package org.apache.tools.ant.util.facade;

/* loaded from: classes26.dex */
public class FacadeTaskHelper {
    public java.util.List<org.apache.tools.ant.util.facade.ImplementationSpecificArgument> a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public org.apache.tools.ant.types.Path e;

    public FacadeTaskHelper(java.lang.String str) {
        this(str, null);
    }

    public FacadeTaskHelper(java.lang.String str, java.lang.String str2) {
        this.a = new java.util.ArrayList();
        this.d = str;
        this.c = str2;
    }

    public void addImplementationArgument(org.apache.tools.ant.util.facade.ImplementationSpecificArgument implementationSpecificArgument) {
        this.a.add(implementationSpecificArgument);
    }

    public java.lang.String[] getArgs() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.a.size());
        java.util.Iterator<org.apache.tools.ant.util.facade.ImplementationSpecificArgument> it = this.a.iterator();
        while (it.hasNext()) {
            java.lang.String[] parts = it.next().getParts(getImplementation());
            if (parts != null) {
                for (java.lang.String str : parts) {
                    arrayList.add(str);
                }
            }
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public java.lang.String getExplicitChoice() {
        return this.b;
    }

    public java.lang.String getImplementation() {
        java.lang.String str = this.b;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = this.c;
        return str2 != null ? str2 : this.d;
    }

    public org.apache.tools.ant.types.Path getImplementationClasspath(org.apache.tools.ant.Project project) {
        if (this.e == null) {
            this.e = new org.apache.tools.ant.types.Path(project);
        }
        return this.e;
    }

    public boolean hasBeenSet() {
        return (this.b == null && this.c == null) ? false : true;
    }

    public void setImplementation(java.lang.String str) {
        this.b = str;
    }

    public void setMagicValue(java.lang.String str) {
        this.c = str;
    }
}

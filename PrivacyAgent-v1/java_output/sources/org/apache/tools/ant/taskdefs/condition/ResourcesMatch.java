package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class ResourcesMatch implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.resources.Union n = null;
    public boolean t = false;

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null) {
            return;
        }
        org.apache.tools.ant.types.resources.Union union = this.n;
        if (union == null) {
            union = new org.apache.tools.ant.types.resources.Union();
        }
        this.n = union;
        union.add(resourceCollection);
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.resources.Union union = this.n;
        if (union == null) {
            throw new org.apache.tools.ant.BuildException("You must specify one or more nested resource collections");
        }
        if (union.size() > 1) {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.n.iterator();
            org.apache.tools.ant.types.Resource next = it.next();
            while (it.hasNext()) {
                org.apache.tools.ant.types.Resource next2 = it.next();
                try {
                    if (!org.apache.tools.ant.util.ResourceUtils.contentEquals(next, next2, this.t)) {
                        return false;
                    }
                    next = next2;
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("when comparing resources " + next.toString() + " and " + next2.toString(), e);
                }
            }
        }
        return true;
    }

    public void setAsText(boolean z) {
        this.t = z;
    }
}

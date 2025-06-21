package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Content extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    public boolean n = true;

    public boolean isBinary() {
        return this.n;
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        try {
            return org.apache.tools.ant.util.ResourceUtils.compareContent(resource, resource2, !this.n);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public void setBinary(boolean z) {
        this.n = z;
    }
}

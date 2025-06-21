package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Reverse extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    public org.apache.tools.ant.types.resources.comparators.ResourceComparator n;

    public Reverse() {
    }

    public Reverse(org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        add(resourceComparator);
    }

    public void add(org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        if (this.n != null) {
            throw new org.apache.tools.ant.BuildException("You must not nest more than one ResourceComparator for reversal.");
        }
        this.n = resourceComparator;
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.DataType
    public void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
            return;
        }
        org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator = this.n;
        if (resourceComparator != null) {
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(resourceComparator, stack, project);
        }
        setChecked(true);
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator = this.n;
        return (resourceComparator == null ? resource.compareTo(resource2) : resourceComparator.compare(resource, resource2)) * (-1);
    }
}

package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class DelegatedResourceComparator extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    public java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> n = null;

    public synchronized void add(org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (resourceComparator == null) {
            return;
        }
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list = this.n;
        if (list == null) {
            list = new java.util.Vector<>();
        }
        this.n = list;
        list.add(resourceComparator);
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
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list = this.n;
        if (list != null && !list.isEmpty()) {
            for (org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator : this.n) {
                if (resourceComparator instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(resourceComparator, stack, project);
                }
            }
        }
        setChecked(true);
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator, java.util.Comparator
    public synchronized boolean equals(java.lang.Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!(obj instanceof org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator)) {
            return false;
        }
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list = ((org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator) obj).n;
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list2 = this.n;
        if (list2 != null) {
            z = list2.equals(list);
        } else if (list != null) {
            z = false;
        }
        return z;
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list = this.n;
        return list == null ? 0 : list.hashCode();
    }

    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public synchronized int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        java.util.List<org.apache.tools.ant.types.resources.comparators.ResourceComparator> list = this.n;
        if (list != null && !list.isEmpty()) {
            java.util.Iterator<org.apache.tools.ant.types.resources.comparators.ResourceComparator> it = this.n.iterator();
            int i = 0;
            while (i == 0 && it.hasNext()) {
                i = it.next().resourceCompare(resource, resource2);
            }
            return i;
        }
        return resource.compareTo(resource2);
    }
}

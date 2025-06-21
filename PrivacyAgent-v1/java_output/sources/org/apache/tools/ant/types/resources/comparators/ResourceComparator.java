package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public abstract class ResourceComparator extends org.apache.tools.ant.types.DataType implements java.util.Comparator<org.apache.tools.ant.types.Resource> {
    @Override // java.util.Comparator
    public final int compare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        dieOnCircularReference();
        return (isReference() ? (org.apache.tools.ant.types.resources.comparators.ResourceComparator) getCheckedRef() : this).resourceCompare(resource, resource2);
    }

    public boolean equals(java.lang.Object obj) {
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (obj == null) {
            return false;
        }
        return obj == this || obj.getClass().equals(getClass());
    }

    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return getClass().hashCode();
    }

    public abstract int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2);
}

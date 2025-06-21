package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Sort extends org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper {
    public org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator v = new org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator();

    public synchronized void add(org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.v.add(resourceComparator);
        org.apache.tools.ant.types.resources.FailFast.c(this);
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper, org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        super.dieOnCircularReference(stack, project);
        if (!isReference()) {
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.v, stack, project);
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public synchronized java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = getResourceCollection().iterator();
        if (!it.hasNext()) {
            return java.util.Collections.emptySet();
        }
        java.util.List list = (java.util.List) org.apache.tools.ant.util.CollectionUtils.asCollection(it);
        java.util.Collections.sort(list, this.v);
        return list;
    }
}

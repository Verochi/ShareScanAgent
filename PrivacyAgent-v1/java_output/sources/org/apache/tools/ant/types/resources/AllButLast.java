package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class AllButLast extends org.apache.tools.ant.types.resources.SizeLimitCollection {
    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        int validCount = getValidCount();
        java.util.List list = (java.util.List) org.apache.tools.ant.util.CollectionUtils.asCollection(getResourceCollection().iterator());
        return list.subList(0, list.size() - validCount);
    }

    @Override // org.apache.tools.ant.types.resources.SizeLimitCollection, org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper, org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        int size;
        int validCount;
        size = getResourceCollection().size();
        validCount = getValidCount();
        return size > validCount ? size - validCount : 0;
    }
}

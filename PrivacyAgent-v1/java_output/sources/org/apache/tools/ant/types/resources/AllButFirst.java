package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class AllButFirst extends org.apache.tools.ant.types.resources.SizeLimitCollection {
    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        int validCount = getValidCount();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = getResourceCollection().iterator();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < validCount && it.hasNext(); i++) {
            it.next();
        }
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
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

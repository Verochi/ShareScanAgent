package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class First extends org.apache.tools.ant.types.resources.SizeLimitCollection {
    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        int validCount = getValidCount();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = getResourceCollection().iterator();
        java.util.ArrayList arrayList = new java.util.ArrayList(validCount);
        for (int i = 0; i < validCount && it.hasNext(); i++) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}

package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class Last extends org.apache.tools.ant.types.resources.SizeLimitCollection {
    @Override // org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper
    public java.util.Collection<org.apache.tools.ant.types.Resource> getCollection() {
        int validCount = getValidCount();
        org.apache.tools.ant.types.ResourceCollection resourceCollection = getResourceCollection();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = resourceCollection.iterator();
        int size = resourceCollection.size();
        int i = validCount;
        while (i < size) {
            it.next();
            i++;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(validCount);
        while (it.hasNext()) {
            arrayList.add(it.next());
            i++;
        }
        int size2 = arrayList.size();
        if (size2 == validCount || (size < validCount && size2 == size)) {
            return arrayList;
        }
        java.lang.String str = "Resource collection " + resourceCollection + " reports size " + size + " but returns " + i + " elements.";
        if (size2 <= validCount) {
            throw new org.apache.tools.ant.BuildException(str);
        }
        log(str, 1);
        return arrayList.subList(size2 - validCount, size2);
    }
}

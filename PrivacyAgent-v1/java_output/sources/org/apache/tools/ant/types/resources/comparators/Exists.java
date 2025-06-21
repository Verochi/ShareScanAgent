package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Exists extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        boolean isExists = resource.isExists();
        if (isExists == resource2.isExists()) {
            return 0;
        }
        return isExists ? 1 : -1;
    }
}

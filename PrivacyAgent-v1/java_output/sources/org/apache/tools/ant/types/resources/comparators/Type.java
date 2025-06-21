package org.apache.tools.ant.types.resources.comparators;

/* loaded from: classes26.dex */
public class Type extends org.apache.tools.ant.types.resources.comparators.ResourceComparator {
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(org.apache.tools.ant.types.Resource resource, org.apache.tools.ant.types.Resource resource2) {
        boolean isDirectory = resource.isDirectory();
        if (isDirectory == resource2.isDirectory()) {
            return 0;
        }
        return isDirectory ? 1 : -1;
    }
}

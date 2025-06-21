package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public abstract class SizeLimitCollection extends org.apache.tools.ant.types.resources.BaseResourceCollectionWrapper {
    public int v = 1;

    public synchronized int getCount() {
        return this.v;
    }

    public int getValidCount() {
        int count = getCount();
        if (count >= 0) {
            return count;
        }
        throw new org.apache.tools.ant.BuildException("size-limited collection count should be set to an int >= 0");
    }

    public synchronized void setCount(int i) {
        checkAttributesAllowed();
        this.v = i;
    }

    @Override // org.apache.tools.ant.types.resources.AbstractResourceCollectionWrapper, org.apache.tools.ant.types.ResourceCollection
    public synchronized int size() {
        int size;
        size = getResourceCollection().size();
        int validCount = getValidCount();
        if (size >= validCount) {
            size = validCount;
        }
        return size;
    }
}

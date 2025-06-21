package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Majority extends org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public boolean t;

    public Majority() {
        this.t = true;
    }

    public Majority(org.apache.tools.ant.types.resources.selectors.ResourceSelector[] resourceSelectorArr) {
        super(resourceSelectorArr);
        this.t = true;
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public synchronized boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        int selectorCount = selectorCount();
        boolean z = selectorCount % 2 == 0;
        int i = selectorCount / 2;
        java.util.Iterator<org.apache.tools.ant.types.resources.selectors.ResourceSelector> selectors = getSelectors();
        int i2 = 0;
        int i3 = 0;
        while (selectors.hasNext()) {
            if (selectors.next().isSelected(resource)) {
                i3++;
                if (i3 > i || (z && this.t && i3 == i)) {
                    return true;
                }
            } else {
                i2++;
                if (i2 > i || (z && !this.t && i2 == i)) {
                    return false;
                }
            }
        }
        return false;
    }

    public synchronized void setAllowtie(boolean z) {
        this.t = z;
    }
}

package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class And extends org.apache.tools.ant.types.resources.selectors.ResourceSelectorContainer implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public And() {
    }

    public And(org.apache.tools.ant.types.resources.selectors.ResourceSelector[] resourceSelectorArr) {
        super(resourceSelectorArr);
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        java.util.Iterator<org.apache.tools.ant.types.resources.selectors.ResourceSelector> selectors = getSelectors();
        while (selectors.hasNext()) {
            if (!selectors.next().isSelected(resource)) {
                return false;
            }
        }
        return true;
    }
}

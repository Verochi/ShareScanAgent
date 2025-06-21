package org.apache.tools.ant.types.resources.selectors;

/* loaded from: classes26.dex */
public class Compare extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.resources.selectors.ResourceSelector {
    public org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator n = new org.apache.tools.ant.types.resources.comparators.DelegatedResourceComparator();
    public org.apache.tools.ant.types.Quantifier t = org.apache.tools.ant.types.Quantifier.ALL;
    public org.apache.tools.ant.types.Comparison u = org.apache.tools.ant.types.Comparison.EQUAL;
    public org.apache.tools.ant.types.resources.Union v;

    public synchronized void add(org.apache.tools.ant.types.resources.comparators.ResourceComparator resourceComparator) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.n.add(resourceComparator);
        setChecked(false);
    }

    public final org.apache.tools.ant.BuildException b() {
        return new org.apache.tools.ant.BuildException(super.toString() + " the <control> element should be specified exactly once.");
    }

    public synchronized org.apache.tools.ant.types.ResourceCollection createControl() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        if (this.v != null) {
            throw b();
        }
        this.v = new org.apache.tools.ant.types.resources.Union();
        setChecked(false);
        return this.v;
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            org.apache.tools.ant.types.resources.Union union = this.v;
            if (union != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(union, stack, project);
            }
            org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(this.n, stack, project);
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.resources.selectors.ResourceSelector
    public synchronized boolean isSelected(org.apache.tools.ant.types.Resource resource) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.selectors.ResourceSelector) getCheckedRef()).isSelected(resource);
        }
        if (this.v == null) {
            throw b();
        }
        dieOnCircularReference();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.v.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if (this.u.evaluate(this.n.compare(resource, it.next()))) {
                i++;
            } else {
                i2++;
            }
        }
        return this.t.evaluate(i, i2);
    }

    public synchronized void setAgainst(org.apache.tools.ant.types.Quantifier quantifier) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.t = quantifier;
    }

    public synchronized void setWhen(org.apache.tools.ant.types.Comparison comparison) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.u = comparison;
    }
}

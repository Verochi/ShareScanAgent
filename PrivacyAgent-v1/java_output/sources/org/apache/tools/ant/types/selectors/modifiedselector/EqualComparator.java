package org.apache.tools.ant.types.selectors.modifiedselector;

/* loaded from: classes26.dex */
public class EqualComparator implements java.util.Comparator<java.lang.Object> {
    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        return obj == null ? obj2 == null ? 1 : 0 : !obj.equals(obj2) ? 1 : 0;
    }

    public java.lang.String toString() {
        return "EqualComparator";
    }
}

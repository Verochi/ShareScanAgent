package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FilterSetCollection {
    public java.util.List<org.apache.tools.ant.types.FilterSet> a = new java.util.ArrayList();

    public FilterSetCollection() {
    }

    public FilterSetCollection(org.apache.tools.ant.types.FilterSet filterSet) {
        addFilterSet(filterSet);
    }

    public void addFilterSet(org.apache.tools.ant.types.FilterSet filterSet) {
        this.a.add(filterSet);
    }

    public boolean hasFilters() {
        java.util.Iterator<org.apache.tools.ant.types.FilterSet> it = this.a.iterator();
        while (it.hasNext()) {
            if (it.next().hasFilters()) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String replaceTokens(java.lang.String str) {
        java.util.Iterator<org.apache.tools.ant.types.FilterSet> it = this.a.iterator();
        while (it.hasNext()) {
            str = it.next().replaceTokens(str);
        }
        return str;
    }
}

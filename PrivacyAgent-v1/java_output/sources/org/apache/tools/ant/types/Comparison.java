package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Comparison extends org.apache.tools.ant.types.EnumeratedAttribute {
    public static final java.lang.String[] b = {"equal", "greater", "less", "ne", "ge", "le", "eq", "gt", "lt", "more"};
    public static final org.apache.tools.ant.types.Comparison EQUAL = new org.apache.tools.ant.types.Comparison("equal");
    public static final org.apache.tools.ant.types.Comparison NOT_EQUAL = new org.apache.tools.ant.types.Comparison("ne");
    public static final org.apache.tools.ant.types.Comparison GREATER = new org.apache.tools.ant.types.Comparison("greater");
    public static final org.apache.tools.ant.types.Comparison LESS = new org.apache.tools.ant.types.Comparison("less");
    public static final org.apache.tools.ant.types.Comparison GREATER_EQUAL = new org.apache.tools.ant.types.Comparison("ge");
    public static final org.apache.tools.ant.types.Comparison LESS_EQUAL = new org.apache.tools.ant.types.Comparison("le");
    public static final int[] c = {0, 4, 5, 6};
    public static final int[] d = {2, 3, 5, 8};
    public static final int[] e = {1, 3, 4, 7, 9};

    public Comparison() {
    }

    public Comparison(java.lang.String str) {
        setValue(str);
    }

    public boolean evaluate(int i) {
        if (getIndex() != -1) {
            return java.util.Arrays.binarySearch(i < 0 ? d : i > 0 ? e : c, getIndex()) >= 0;
        }
        throw new org.apache.tools.ant.BuildException("Comparison value not set.");
    }

    @Override // org.apache.tools.ant.types.EnumeratedAttribute
    public java.lang.String[] getValues() {
        return b;
    }
}

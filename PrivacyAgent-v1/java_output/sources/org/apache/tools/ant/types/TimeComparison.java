package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class TimeComparison extends org.apache.tools.ant.types.EnumeratedAttribute {
    public static final java.lang.String[] b = {"before", "after", "equal"};
    public static final org.apache.tools.ant.util.FileUtils c = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.types.TimeComparison BEFORE = new org.apache.tools.ant.types.TimeComparison("before");
    public static final org.apache.tools.ant.types.TimeComparison AFTER = new org.apache.tools.ant.types.TimeComparison("after");
    public static final org.apache.tools.ant.types.TimeComparison EQUAL = new org.apache.tools.ant.types.TimeComparison("equal");

    public TimeComparison() {
    }

    public TimeComparison(java.lang.String str) {
        setValue(str);
    }

    public static int compare(long j, long j2) {
        return compare(j, j2, c.getFileTimestampGranularity());
    }

    public static int compare(long j, long j2, long j3) {
        long j4 = j - j2;
        long abs = java.lang.Math.abs(j4);
        if (abs > java.lang.Math.abs(j3)) {
            return (int) (j4 / abs);
        }
        return 0;
    }

    public boolean evaluate(long j, long j2) {
        return evaluate(j, j2, c.getFileTimestampGranularity());
    }

    public boolean evaluate(long j, long j2, long j3) {
        int index = getIndex();
        if (index != -1) {
            return index == 0 ? j - j3 < j2 : index == 1 ? j + j3 > j2 : java.lang.Math.abs(j - j2) <= j3;
        }
        throw new org.apache.tools.ant.BuildException("TimeComparison value not set.");
    }

    @Override // org.apache.tools.ant.types.EnumeratedAttribute
    public java.lang.String[] getValues() {
        return b;
    }
}

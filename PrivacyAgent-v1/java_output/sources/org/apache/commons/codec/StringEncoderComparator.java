package org.apache.commons.codec;

/* loaded from: classes24.dex */
public class StringEncoderComparator implements java.util.Comparator {
    public final org.apache.commons.codec.StringEncoder n;

    public StringEncoderComparator() {
        this.n = null;
    }

    public StringEncoderComparator(org.apache.commons.codec.StringEncoder stringEncoder) {
        this.n = stringEncoder;
    }

    @Override // java.util.Comparator
    public int compare(java.lang.Object obj, java.lang.Object obj2) {
        try {
            return ((java.lang.Comparable) this.n.encode(obj)).compareTo((java.lang.Comparable) this.n.encode(obj2));
        } catch (org.apache.commons.codec.EncoderException unused) {
            return 0;
        }
    }
}

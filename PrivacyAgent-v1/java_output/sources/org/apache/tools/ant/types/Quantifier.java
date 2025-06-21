package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Quantifier extends org.apache.tools.ant.types.EnumeratedAttribute {
    public static final org.apache.tools.ant.types.Quantifier ALL;
    public static final org.apache.tools.ant.types.Quantifier ANY;
    public static final org.apache.tools.ant.types.Quantifier MAJORITY;
    public static final org.apache.tools.ant.types.Quantifier NONE;
    public static final org.apache.tools.ant.types.Quantifier ONE;
    public static final java.lang.String[] b;
    public static final org.apache.tools.ant.types.Quantifier.Predicate c;
    public static final org.apache.tools.ant.types.Quantifier.Predicate d;
    public static final org.apache.tools.ant.types.Quantifier.Predicate e;
    public static final org.apache.tools.ant.types.Quantifier.Predicate f;
    public static final org.apache.tools.ant.types.Quantifier.Predicate g;
    public static final org.apache.tools.ant.types.Quantifier.Predicate[] h;

    /* renamed from: org.apache.tools.ant.types.Quantifier$1, reason: invalid class name */
    public static class AnonymousClass1 extends org.apache.tools.ant.types.Quantifier.Predicate {
        public AnonymousClass1() {
            super(null);
        }

        @Override // org.apache.tools.ant.types.Quantifier.Predicate
        public boolean a(int i, int i2) {
            return i2 == 0;
        }
    }

    /* renamed from: org.apache.tools.ant.types.Quantifier$2, reason: invalid class name */
    public static class AnonymousClass2 extends org.apache.tools.ant.types.Quantifier.Predicate {
        public AnonymousClass2() {
            super(null);
        }

        @Override // org.apache.tools.ant.types.Quantifier.Predicate
        public boolean a(int i, int i2) {
            return i > 0;
        }
    }

    /* renamed from: org.apache.tools.ant.types.Quantifier$3, reason: invalid class name */
    public static class AnonymousClass3 extends org.apache.tools.ant.types.Quantifier.Predicate {
        public AnonymousClass3() {
            super(null);
        }

        @Override // org.apache.tools.ant.types.Quantifier.Predicate
        public boolean a(int i, int i2) {
            return i == 1;
        }
    }

    /* renamed from: org.apache.tools.ant.types.Quantifier$4, reason: invalid class name */
    public static class AnonymousClass4 extends org.apache.tools.ant.types.Quantifier.Predicate {
        public AnonymousClass4() {
            super(null);
        }

        @Override // org.apache.tools.ant.types.Quantifier.Predicate
        public boolean a(int i, int i2) {
            return i > i2;
        }
    }

    /* renamed from: org.apache.tools.ant.types.Quantifier$5, reason: invalid class name */
    public static class AnonymousClass5 extends org.apache.tools.ant.types.Quantifier.Predicate {
        public AnonymousClass5() {
            super(null);
        }

        @Override // org.apache.tools.ant.types.Quantifier.Predicate
        public boolean a(int i, int i2) {
            return i == 0;
        }
    }

    public static abstract class Predicate {
        public Predicate() {
        }

        public /* synthetic */ Predicate(org.apache.tools.ant.types.Quantifier.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract boolean a(int i, int i2);
    }

    static {
        java.lang.String[] strArr = {"all", "each", "every", org.apache.commons.codec.language.bm.Languages.ANY, "some", "one", "majority", "most", "none"};
        b = strArr;
        ALL = new org.apache.tools.ant.types.Quantifier("all");
        ANY = new org.apache.tools.ant.types.Quantifier(org.apache.commons.codec.language.bm.Languages.ANY);
        ONE = new org.apache.tools.ant.types.Quantifier("one");
        MAJORITY = new org.apache.tools.ant.types.Quantifier("majority");
        NONE = new org.apache.tools.ant.types.Quantifier("none");
        org.apache.tools.ant.types.Quantifier.AnonymousClass1 anonymousClass1 = new org.apache.tools.ant.types.Quantifier.AnonymousClass1();
        c = anonymousClass1;
        org.apache.tools.ant.types.Quantifier.AnonymousClass2 anonymousClass2 = new org.apache.tools.ant.types.Quantifier.AnonymousClass2();
        d = anonymousClass2;
        org.apache.tools.ant.types.Quantifier.AnonymousClass3 anonymousClass3 = new org.apache.tools.ant.types.Quantifier.AnonymousClass3();
        e = anonymousClass3;
        org.apache.tools.ant.types.Quantifier.AnonymousClass4 anonymousClass4 = new org.apache.tools.ant.types.Quantifier.AnonymousClass4();
        f = anonymousClass4;
        org.apache.tools.ant.types.Quantifier.AnonymousClass5 anonymousClass5 = new org.apache.tools.ant.types.Quantifier.AnonymousClass5();
        g = anonymousClass5;
        org.apache.tools.ant.types.Quantifier.Predicate[] predicateArr = new org.apache.tools.ant.types.Quantifier.Predicate[strArr.length];
        h = predicateArr;
        predicateArr[0] = anonymousClass1;
        predicateArr[1] = anonymousClass1;
        predicateArr[2] = anonymousClass1;
        predicateArr[3] = anonymousClass2;
        predicateArr[4] = anonymousClass2;
        predicateArr[5] = anonymousClass3;
        predicateArr[6] = anonymousClass4;
        predicateArr[7] = anonymousClass4;
        predicateArr[8] = anonymousClass5;
    }

    public Quantifier() {
    }

    public Quantifier(java.lang.String str) {
        setValue(str);
    }

    public boolean evaluate(int i, int i2) {
        int index = getIndex();
        if (index != -1) {
            return h[index].a(i, i2);
        }
        throw new org.apache.tools.ant.BuildException("Quantifier value not set.");
    }

    public boolean evaluate(boolean[] zArr) {
        int i = 0;
        for (boolean z : zArr) {
            if (z) {
                i++;
            }
        }
        return evaluate(i, zArr.length - i);
    }

    @Override // org.apache.tools.ant.types.EnumeratedAttribute
    public java.lang.String[] getValues() {
        return b;
    }
}

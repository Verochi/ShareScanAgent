package androidx.core.text;

/* loaded from: classes.dex */
public final class TextDirectionHeuristicsCompat {
    public static final androidx.core.text.TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final androidx.core.text.TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final androidx.core.text.TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final androidx.core.text.TextDirectionHeuristicCompat LOCALE;
    public static final androidx.core.text.TextDirectionHeuristicCompat LTR = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, false);
    public static final androidx.core.text.TextDirectionHeuristicCompat RTL = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(null, true);
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    public static class AnyStrong implements androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
        static final androidx.core.text.TextDirectionHeuristicsCompat.AnyStrong INSTANCE_RTL = new androidx.core.text.TextDirectionHeuristicsCompat.AnyStrong(true);
        private final boolean mLookForRtl;

        private AnyStrong(boolean z) {
            this.mLookForRtl = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int isRtlText = androidx.core.text.TextDirectionHeuristicsCompat.isRtlText(java.lang.Character.getDirectionality(charSequence.charAt(i)));
                if (isRtlText != 0) {
                    if (isRtlText != 1) {
                        continue;
                        i++;
                    } else if (!this.mLookForRtl) {
                        return 1;
                    }
                } else if (this.mLookForRtl) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.mLookForRtl ? 1 : 0;
            }
            return 2;
        }
    }

    public static class FirstStrong implements androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm {
        static final androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong INSTANCE = new androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong();

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int checkRtl(java.lang.CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = androidx.core.text.TextDirectionHeuristicsCompat.isRtlTextOrFormat(java.lang.Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    public interface TextDirectionAlgorithm {
        int checkRtl(java.lang.CharSequence charSequence, int i, int i2);
    }

    public static abstract class TextDirectionHeuristicImpl implements androidx.core.text.TextDirectionHeuristicCompat {
        private final androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm mAlgorithm;

        public TextDirectionHeuristicImpl(androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm) {
            this.mAlgorithm = textDirectionAlgorithm;
        }

        private boolean doCheck(java.lang.CharSequence charSequence, int i, int i2) {
            int checkRtl = this.mAlgorithm.checkRtl(charSequence, i, i2);
            if (checkRtl == 0) {
                return true;
            }
            if (checkRtl != 1) {
                return defaultIsRtl();
            }
            return false;
        }

        public abstract boolean defaultIsRtl();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(java.lang.CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new java.lang.IllegalArgumentException();
            }
            return this.mAlgorithm == null ? defaultIsRtl() : doCheck(charSequence, i, i2);
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(char[] cArr, int i, int i2) {
            return isRtl(java.nio.CharBuffer.wrap(cArr), i, i2);
        }
    }

    public static class TextDirectionHeuristicInternal extends androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        public TextDirectionHeuristicInternal(androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.mDefaultIsRtl = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    public static class TextDirectionHeuristicLocale extends androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl {
        static final androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale INSTANCE = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public boolean defaultIsRtl() {
            return androidx.core.text.TextUtilsCompat.getLayoutDirectionFromLocale(java.util.Locale.getDefault()) == 1;
        }
    }

    static {
        androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong firstStrong = androidx.core.text.TextDirectionHeuristicsCompat.FirstStrong.INSTANCE;
        FIRSTSTRONG_LTR = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(firstStrong, false);
        FIRSTSTRONG_RTL = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(firstStrong, true);
        ANYRTL_LTR = new androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicInternal(androidx.core.text.TextDirectionHeuristicsCompat.AnyStrong.INSTANCE_RTL, false);
        LOCALE = androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
    }

    public static int isRtlText(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int isRtlTextOrFormat(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}

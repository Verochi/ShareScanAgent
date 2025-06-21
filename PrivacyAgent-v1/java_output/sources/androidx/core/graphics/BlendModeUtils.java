package androidx.core.graphics;

/* loaded from: classes.dex */
class BlendModeUtils {

    /* renamed from: androidx.core.graphics.BlendModeUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$core$graphics$BlendModeCompat;

        static {
            int[] iArr = new int[androidx.core.graphics.BlendModeCompat.values().length];
            $SwitchMap$androidx$core$graphics$BlendModeCompat = iArr;
            try {
                iArr[androidx.core.graphics.BlendModeCompat.CLEAR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SRC.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DST.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SRC_OVER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DST_OVER.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SRC_IN.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DST_IN.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SRC_OUT.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DST_OUT.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SRC_ATOP.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DST_ATOP.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.XOR.ordinal()] = 12;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.PLUS.ordinal()] = 13;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.MODULATE.ordinal()] = 14;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SCREEN.ordinal()] = 15;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.OVERLAY.ordinal()] = 16;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DARKEN.ordinal()] = 17;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.LIGHTEN.ordinal()] = 18;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.COLOR_DODGE.ordinal()] = 19;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.COLOR_BURN.ordinal()] = 20;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.HARD_LIGHT.ordinal()] = 21;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SOFT_LIGHT.ordinal()] = 22;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.DIFFERENCE.ordinal()] = 23;
            } catch (java.lang.NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.EXCLUSION.ordinal()] = 24;
            } catch (java.lang.NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.MULTIPLY.ordinal()] = 25;
            } catch (java.lang.NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.HUE.ordinal()] = 26;
            } catch (java.lang.NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.SATURATION.ordinal()] = 27;
            } catch (java.lang.NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.COLOR.ordinal()] = 28;
            } catch (java.lang.NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$androidx$core$graphics$BlendModeCompat[androidx.core.graphics.BlendModeCompat.LUMINOSITY.ordinal()] = 29;
            } catch (java.lang.NoSuchFieldError unused29) {
            }
        }
    }

    private BlendModeUtils() {
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RequiresApi(29)
    public static android.graphics.BlendMode obtainBlendModeFromCompat(@androidx.annotation.NonNull androidx.core.graphics.BlendModeCompat blendModeCompat) {
        android.graphics.BlendMode blendMode;
        android.graphics.BlendMode blendMode2;
        android.graphics.BlendMode blendMode3;
        android.graphics.BlendMode blendMode4;
        android.graphics.BlendMode blendMode5;
        android.graphics.BlendMode blendMode6;
        android.graphics.BlendMode blendMode7;
        android.graphics.BlendMode blendMode8;
        android.graphics.BlendMode blendMode9;
        android.graphics.BlendMode blendMode10;
        android.graphics.BlendMode blendMode11;
        android.graphics.BlendMode blendMode12;
        android.graphics.BlendMode blendMode13;
        android.graphics.BlendMode blendMode14;
        android.graphics.BlendMode blendMode15;
        android.graphics.BlendMode blendMode16;
        android.graphics.BlendMode blendMode17;
        android.graphics.BlendMode blendMode18;
        android.graphics.BlendMode blendMode19;
        android.graphics.BlendMode blendMode20;
        android.graphics.BlendMode blendMode21;
        android.graphics.BlendMode blendMode22;
        android.graphics.BlendMode blendMode23;
        android.graphics.BlendMode blendMode24;
        android.graphics.BlendMode blendMode25;
        android.graphics.BlendMode blendMode26;
        android.graphics.BlendMode blendMode27;
        android.graphics.BlendMode blendMode28;
        android.graphics.BlendMode blendMode29;
        switch (androidx.core.graphics.BlendModeUtils.AnonymousClass1.$SwitchMap$androidx$core$graphics$BlendModeCompat[blendModeCompat.ordinal()]) {
            case 1:
                blendMode = android.graphics.BlendMode.CLEAR;
                return blendMode;
            case 2:
                blendMode2 = android.graphics.BlendMode.SRC;
                return blendMode2;
            case 3:
                blendMode3 = android.graphics.BlendMode.DST;
                return blendMode3;
            case 4:
                blendMode4 = android.graphics.BlendMode.SRC_OVER;
                return blendMode4;
            case 5:
                blendMode5 = android.graphics.BlendMode.DST_OVER;
                return blendMode5;
            case 6:
                blendMode6 = android.graphics.BlendMode.SRC_IN;
                return blendMode6;
            case 7:
                blendMode7 = android.graphics.BlendMode.DST_IN;
                return blendMode7;
            case 8:
                blendMode8 = android.graphics.BlendMode.SRC_OUT;
                return blendMode8;
            case 9:
                blendMode9 = android.graphics.BlendMode.DST_OUT;
                return blendMode9;
            case 10:
                blendMode10 = android.graphics.BlendMode.SRC_ATOP;
                return blendMode10;
            case 11:
                blendMode11 = android.graphics.BlendMode.DST_ATOP;
                return blendMode11;
            case 12:
                blendMode12 = android.graphics.BlendMode.XOR;
                return blendMode12;
            case 13:
                blendMode13 = android.graphics.BlendMode.PLUS;
                return blendMode13;
            case 14:
                blendMode14 = android.graphics.BlendMode.MODULATE;
                return blendMode14;
            case 15:
                blendMode15 = android.graphics.BlendMode.SCREEN;
                return blendMode15;
            case 16:
                blendMode16 = android.graphics.BlendMode.OVERLAY;
                return blendMode16;
            case 17:
                blendMode17 = android.graphics.BlendMode.DARKEN;
                return blendMode17;
            case 18:
                blendMode18 = android.graphics.BlendMode.LIGHTEN;
                return blendMode18;
            case 19:
                blendMode19 = android.graphics.BlendMode.COLOR_DODGE;
                return blendMode19;
            case 20:
                blendMode20 = android.graphics.BlendMode.COLOR_BURN;
                return blendMode20;
            case 21:
                blendMode21 = android.graphics.BlendMode.HARD_LIGHT;
                return blendMode21;
            case 22:
                blendMode22 = android.graphics.BlendMode.SOFT_LIGHT;
                return blendMode22;
            case 23:
                blendMode23 = android.graphics.BlendMode.DIFFERENCE;
                return blendMode23;
            case 24:
                blendMode24 = android.graphics.BlendMode.EXCLUSION;
                return blendMode24;
            case 25:
                blendMode25 = android.graphics.BlendMode.MULTIPLY;
                return blendMode25;
            case 26:
                blendMode26 = android.graphics.BlendMode.HUE;
                return blendMode26;
            case 27:
                blendMode27 = android.graphics.BlendMode.SATURATION;
                return blendMode27;
            case 28:
                blendMode28 = android.graphics.BlendMode.COLOR;
                return blendMode28;
            case 29:
                blendMode29 = android.graphics.BlendMode.LUMINOSITY;
                return blendMode29;
            default:
                return null;
        }
    }

    @androidx.annotation.Nullable
    public static android.graphics.PorterDuff.Mode obtainPorterDuffFromCompat(@androidx.annotation.Nullable androidx.core.graphics.BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (androidx.core.graphics.BlendModeUtils.AnonymousClass1.$SwitchMap$androidx$core$graphics$BlendModeCompat[blendModeCompat.ordinal()]) {
            case 1:
                return android.graphics.PorterDuff.Mode.CLEAR;
            case 2:
                return android.graphics.PorterDuff.Mode.SRC;
            case 3:
                return android.graphics.PorterDuff.Mode.DST;
            case 4:
                return android.graphics.PorterDuff.Mode.SRC_OVER;
            case 5:
                return android.graphics.PorterDuff.Mode.DST_OVER;
            case 6:
                return android.graphics.PorterDuff.Mode.SRC_IN;
            case 7:
                return android.graphics.PorterDuff.Mode.DST_IN;
            case 8:
                return android.graphics.PorterDuff.Mode.SRC_OUT;
            case 9:
                return android.graphics.PorterDuff.Mode.DST_OUT;
            case 10:
                return android.graphics.PorterDuff.Mode.SRC_ATOP;
            case 11:
                return android.graphics.PorterDuff.Mode.DST_ATOP;
            case 12:
                return android.graphics.PorterDuff.Mode.XOR;
            case 13:
                return android.graphics.PorterDuff.Mode.ADD;
            case 14:
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            case 15:
                return android.graphics.PorterDuff.Mode.SCREEN;
            case 16:
                return android.graphics.PorterDuff.Mode.OVERLAY;
            case 17:
                return android.graphics.PorterDuff.Mode.DARKEN;
            case 18:
                return android.graphics.PorterDuff.Mode.LIGHTEN;
            default:
                return null;
        }
    }
}

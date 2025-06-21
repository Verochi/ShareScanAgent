package com.autonavi.base.ae.gmap.glyph;

/* loaded from: classes12.dex */
public class GlyphBreakIterator {
    public static final int BREAK_BY_CHARACTER_SEQUENCES = 2;
    public static final int BREAK_BY_WORDS = 1;
    public java.util.ArrayList<java.lang.Integer> breakResult = new java.util.ArrayList<>();
    public int mBreakMode;

    public GlyphBreakIterator(int i) {
        this.mBreakMode = i;
    }

    public int[] setText(java.lang.String str) {
        java.text.BreakIterator breakIterator = null;
        if (str.isEmpty()) {
            return null;
        }
        if (!this.breakResult.isEmpty()) {
            this.breakResult.clear();
        }
        int i = this.mBreakMode;
        if (i == 1) {
            breakIterator = java.text.BreakIterator.getWordInstance();
        } else if (i == 2) {
            breakIterator = java.text.BreakIterator.getCharacterInstance();
        }
        breakIterator.setText(str);
        int first = breakIterator.first();
        while (true) {
            int i2 = first;
            first = breakIterator.next();
            if (first == -1) {
                break;
            }
            this.breakResult.add(java.lang.Integer.valueOf(i2));
        }
        this.breakResult.add(java.lang.Integer.valueOf(str.length()));
        int size = this.breakResult.size();
        java.lang.Integer[] numArr = new java.lang.Integer[size];
        this.breakResult.toArray(numArr);
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = numArr[i3].intValue();
        }
        return iArr;
    }
}

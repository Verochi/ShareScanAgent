package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class ChineseUtil {
    public static java.lang.String halfToFull(java.lang.String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c > ' ' && c < 127) {
                charArray[i] = (char) (c + 65248);
            }
        }
        return new java.lang.String(charArray);
    }

    private static boolean isChinese(char c) {
        java.lang.Character.UnicodeBlock of = java.lang.Character.UnicodeBlock.of(c);
        return of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == java.lang.Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == java.lang.Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == java.lang.Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || of == java.lang.Character.UnicodeBlock.GENERAL_PUNCTUATION;
    }

    public static boolean isChinese(java.lang.String str) {
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }
}

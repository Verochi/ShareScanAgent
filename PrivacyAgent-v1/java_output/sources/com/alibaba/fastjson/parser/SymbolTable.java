package com.alibaba.fastjson.parser;

/* loaded from: classes.dex */
public class SymbolTable {
    private final int indexMask;
    private final com.alibaba.fastjson.parser.SymbolTable.Entry[] symbols;

    public static class Entry {
        final char[] chars;
        final int hashCode;
        final java.lang.String value;

        public Entry(java.lang.String str, int i) {
            this.value = str;
            this.chars = str.toCharArray();
            this.hashCode = i;
        }
    }

    public SymbolTable(int i) {
        this.indexMask = i - 1;
        this.symbols = new com.alibaba.fastjson.parser.SymbolTable.Entry[i];
        addSymbol("$ref", 0, 4, 1185263);
        addSymbol(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY, 0, 5, 62680954);
    }

    private static java.lang.String subString(java.lang.String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new java.lang.String(cArr);
    }

    public java.lang.String addSymbol(java.lang.String str, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        com.alibaba.fastjson.parser.SymbolTable.Entry entry = this.symbols[i4];
        if (entry != null) {
            return (i3 == entry.hashCode && i2 == entry.chars.length && str.regionMatches(i, entry.value, 0, i2)) ? entry.value : subString(str, i, i2);
        }
        if (i2 != str.length()) {
            str = subString(str, i, i2);
        }
        java.lang.String intern = str.intern();
        this.symbols[i4] = new com.alibaba.fastjson.parser.SymbolTable.Entry(intern, i3);
        return intern;
    }

    public java.lang.String addSymbol(char[] cArr, int i, int i2, int i3) {
        int i4 = this.indexMask & i3;
        com.alibaba.fastjson.parser.SymbolTable.Entry entry = this.symbols[i4];
        if (entry == null) {
            java.lang.String intern = new java.lang.String(cArr, i, i2).intern();
            this.symbols[i4] = new com.alibaba.fastjson.parser.SymbolTable.Entry(intern, i3);
            return intern;
        }
        boolean z = false;
        if (i3 == entry.hashCode && i2 == entry.chars.length) {
            int i5 = 0;
            while (true) {
                if (i5 >= i2) {
                    z = true;
                    break;
                }
                if (cArr[i + i5] != entry.chars[i5]) {
                    break;
                }
                i5++;
            }
        }
        return z ? entry.value : new java.lang.String(cArr, i, i2);
    }
}

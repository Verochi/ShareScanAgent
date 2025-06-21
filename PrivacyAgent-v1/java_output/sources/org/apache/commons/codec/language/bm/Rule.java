package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public class Rule {
    public static final java.lang.String ALL = "ALL";
    public static final org.apache.commons.codec.language.bm.Rule.RPattern ALL_STRINGS_RMATCHER = new org.apache.commons.codec.language.bm.Rule.AnonymousClass1();
    public static final java.util.Map<org.apache.commons.codec.language.bm.NameType, java.util.Map<org.apache.commons.codec.language.bm.RuleType, java.util.Map<java.lang.String, java.util.List<org.apache.commons.codec.language.bm.Rule>>>> e = new java.util.EnumMap(org.apache.commons.codec.language.bm.NameType.class);
    public final org.apache.commons.codec.language.bm.Rule.RPattern a;
    public final java.lang.String b;
    public final org.apache.commons.codec.language.bm.Rule.PhonemeExpr c;
    public final org.apache.commons.codec.language.bm.Rule.RPattern d;

    /* renamed from: org.apache.commons.codec.language.bm.Rule$1, reason: invalid class name */
    public static class AnonymousClass1 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return true;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$10, reason: invalid class name */
    public static class AnonymousClass10 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public java.util.regex.Pattern a;
        public final /* synthetic */ java.lang.String b;

        public AnonymousClass10(java.lang.String str) {
            this.b = str;
            this.a = java.util.regex.Pattern.compile(str);
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return this.a.matcher(charSequence).find();
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$2, reason: invalid class name */
    public static class AnonymousClass2 extends org.apache.commons.codec.language.bm.Rule {
        public final int f;
        public final java.lang.String g;
        public final /* synthetic */ int h;
        public final /* synthetic */ java.lang.String i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.String str, java.lang.String str2, java.lang.String str3, org.apache.commons.codec.language.bm.Rule.PhonemeExpr phonemeExpr, int i, java.lang.String str4) {
            super(str, str2, str3, phonemeExpr);
            this.h = i;
            this.i = str4;
            this.f = i;
            this.g = str4;
        }

        public java.lang.String toString() {
            return "Rule{line=" + this.f + ", loc='" + this.g + "'}";
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$3, reason: invalid class name */
    public static class AnonymousClass3 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$4, reason: invalid class name */
    public static class AnonymousClass4 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass4(java.lang.String str) {
            this.a = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return charSequence.equals(this.a);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$5, reason: invalid class name */
    public static class AnonymousClass5 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return org.apache.commons.codec.language.bm.Rule.m(charSequence, this.a);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$6, reason: invalid class name */
    public static class AnonymousClass6 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass6(java.lang.String str) {
            this.a = str;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return org.apache.commons.codec.language.bm.Rule.h(charSequence, this.a);
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$7, reason: invalid class name */
    public static class AnonymousClass7 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ boolean b;

        public AnonymousClass7(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return charSequence.length() == 1 && org.apache.commons.codec.language.bm.Rule.d(this.a, charSequence.charAt(0)) == this.b;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$8, reason: invalid class name */
    public static class AnonymousClass8 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ boolean b;

        public AnonymousClass8(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return charSequence.length() > 0 && org.apache.commons.codec.language.bm.Rule.d(this.a, charSequence.charAt(0)) == this.b;
        }
    }

    /* renamed from: org.apache.commons.codec.language.bm.Rule$9, reason: invalid class name */
    public static class AnonymousClass9 implements org.apache.commons.codec.language.bm.Rule.RPattern {
        public final /* synthetic */ java.lang.String a;
        public final /* synthetic */ boolean b;

        public AnonymousClass9(java.lang.String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.RPattern
        public boolean isMatch(java.lang.CharSequence charSequence) {
            return charSequence.length() > 0 && org.apache.commons.codec.language.bm.Rule.d(this.a, charSequence.charAt(charSequence.length() - 1)) == this.b;
        }
    }

    public static final class Phoneme implements org.apache.commons.codec.language.bm.Rule.PhonemeExpr {
        public static final java.util.Comparator<org.apache.commons.codec.language.bm.Rule.Phoneme> COMPARATOR = new org.apache.commons.codec.language.bm.Rule.Phoneme.AnonymousClass1();
        public final java.lang.CharSequence a;
        public final org.apache.commons.codec.language.bm.Languages.LanguageSet b;

        /* renamed from: org.apache.commons.codec.language.bm.Rule$Phoneme$1, reason: invalid class name */
        public static class AnonymousClass1 implements java.util.Comparator<org.apache.commons.codec.language.bm.Rule.Phoneme> {
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(org.apache.commons.codec.language.bm.Rule.Phoneme phoneme, org.apache.commons.codec.language.bm.Rule.Phoneme phoneme2) {
                for (int i = 0; i < phoneme.a.length(); i++) {
                    if (i >= phoneme2.a.length()) {
                        return 1;
                    }
                    int charAt = phoneme.a.charAt(i) - phoneme2.a.charAt(i);
                    if (charAt != 0) {
                        return charAt;
                    }
                }
                return phoneme.a.length() < phoneme2.a.length() ? -1 : 0;
            }
        }

        public Phoneme(java.lang.CharSequence charSequence, org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
            this.a = charSequence;
            this.b = languageSet;
        }

        public org.apache.commons.codec.language.bm.Rule.Phoneme append(java.lang.CharSequence charSequence) {
            return new org.apache.commons.codec.language.bm.Rule.Phoneme(this.a.toString() + charSequence.toString(), this.b);
        }

        public org.apache.commons.codec.language.bm.Languages.LanguageSet getLanguages() {
            return this.b;
        }

        public java.lang.CharSequence getPhonemeText() {
            return this.a;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public java.lang.Iterable<org.apache.commons.codec.language.bm.Rule.Phoneme> getPhonemes() {
            return java.util.Collections.singleton(this);
        }

        public org.apache.commons.codec.language.bm.Rule.Phoneme join(org.apache.commons.codec.language.bm.Rule.Phoneme phoneme) {
            return new org.apache.commons.codec.language.bm.Rule.Phoneme(this.a.toString() + phoneme.a.toString(), this.b.restrictTo(phoneme.b));
        }
    }

    public interface PhonemeExpr {
        java.lang.Iterable<org.apache.commons.codec.language.bm.Rule.Phoneme> getPhonemes();
    }

    public static final class PhonemeList implements org.apache.commons.codec.language.bm.Rule.PhonemeExpr {
        public final java.util.List<org.apache.commons.codec.language.bm.Rule.Phoneme> a;

        public PhonemeList(java.util.List<org.apache.commons.codec.language.bm.Rule.Phoneme> list) {
            this.a = list;
        }

        @Override // org.apache.commons.codec.language.bm.Rule.PhonemeExpr
        public java.util.List<org.apache.commons.codec.language.bm.Rule.Phoneme> getPhonemes() {
            return this.a;
        }
    }

    public interface RPattern {
        boolean isMatch(java.lang.CharSequence charSequence);
    }

    static {
        for (org.apache.commons.codec.language.bm.NameType nameType : org.apache.commons.codec.language.bm.NameType.values()) {
            java.util.EnumMap enumMap = new java.util.EnumMap(org.apache.commons.codec.language.bm.RuleType.class);
            for (org.apache.commons.codec.language.bm.RuleType ruleType : org.apache.commons.codec.language.bm.RuleType.values()) {
                java.util.HashMap hashMap = new java.util.HashMap();
                for (java.lang.String str : org.apache.commons.codec.language.bm.Languages.getInstance(nameType).getLanguages()) {
                    try {
                        hashMap.put(str, k(g(nameType, ruleType, str), e(nameType, ruleType, str)));
                    } catch (java.lang.IllegalStateException e2) {
                        throw new java.lang.IllegalStateException("Problem processing " + e(nameType, ruleType, str), e2);
                    }
                }
                if (!ruleType.equals(org.apache.commons.codec.language.bm.RuleType.RULES)) {
                    hashMap.put("common", k(g(nameType, ruleType, "common"), e(nameType, ruleType, "common")));
                }
                enumMap.put((java.util.EnumMap) ruleType, (org.apache.commons.codec.language.bm.RuleType) java.util.Collections.unmodifiableMap(hashMap));
            }
            e.put(nameType, java.util.Collections.unmodifiableMap(enumMap));
        }
    }

    public Rule(java.lang.String str, java.lang.String str2, java.lang.String str3, org.apache.commons.codec.language.bm.Rule.PhonemeExpr phonemeExpr) {
        this.b = str;
        this.a = l(str2 + "$");
        this.d = l("^" + str3);
        this.c = phonemeExpr;
    }

    public static boolean d(java.lang.CharSequence charSequence, char c) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public static java.lang.String e(org.apache.commons.codec.language.bm.NameType nameType, org.apache.commons.codec.language.bm.RuleType ruleType, java.lang.String str) {
        return java.lang.String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", nameType.getName(), ruleType.getName(), str);
    }

    public static java.util.Scanner f(java.lang.String str) {
        java.lang.String format = java.lang.String.format("org/apache/commons/codec/language/bm/%s.txt", str);
        java.io.InputStream resourceAsStream = org.apache.commons.codec.language.bm.Languages.class.getClassLoader().getResourceAsStream(format);
        if (resourceAsStream != null) {
            return new java.util.Scanner(resourceAsStream, "UTF-8");
        }
        throw new java.lang.IllegalArgumentException("Unable to load resource: " + format);
    }

    public static java.util.Scanner g(org.apache.commons.codec.language.bm.NameType nameType, org.apache.commons.codec.language.bm.RuleType ruleType, java.lang.String str) {
        java.lang.String e2 = e(nameType, ruleType, str);
        java.io.InputStream resourceAsStream = org.apache.commons.codec.language.bm.Languages.class.getClassLoader().getResourceAsStream(e2);
        if (resourceAsStream != null) {
            return new java.util.Scanner(resourceAsStream, "UTF-8");
        }
        throw new java.lang.IllegalArgumentException("Unable to load resource: " + e2);
    }

    public static java.util.List<org.apache.commons.codec.language.bm.Rule> getInstance(org.apache.commons.codec.language.bm.NameType nameType, org.apache.commons.codec.language.bm.RuleType ruleType, java.lang.String str) {
        java.util.List<org.apache.commons.codec.language.bm.Rule> list = e.get(nameType).get(ruleType).get(str);
        if (list != null) {
            return list;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.format("No rules found for %s, %s, %s.", nameType.getName(), ruleType.getName(), str));
    }

    public static java.util.List<org.apache.commons.codec.language.bm.Rule> getInstance(org.apache.commons.codec.language.bm.NameType nameType, org.apache.commons.codec.language.bm.RuleType ruleType, org.apache.commons.codec.language.bm.Languages.LanguageSet languageSet) {
        return getInstance(nameType, ruleType, languageSet.isSingleton() ? languageSet.getAny() : org.apache.commons.codec.language.bm.Languages.ANY);
    }

    public static boolean h(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        int length = charSequence.length() - 1;
        for (int length2 = charSequence2.length() - 1; length2 >= 0; length2--) {
            if (charSequence.charAt(length) != charSequence2.charAt(length2)) {
                return false;
            }
            length--;
        }
        return true;
    }

    public static org.apache.commons.codec.language.bm.Rule.Phoneme i(java.lang.String str) {
        int indexOf = str.indexOf("[");
        if (indexOf < 0) {
            return new org.apache.commons.codec.language.bm.Rule.Phoneme(str, org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE);
        }
        if (str.endsWith("]")) {
            return new org.apache.commons.codec.language.bm.Rule.Phoneme(str.substring(0, indexOf), org.apache.commons.codec.language.bm.Languages.LanguageSet.from(new java.util.HashSet(java.util.Arrays.asList(str.substring(indexOf + 1, str.length() - 1).split("[+]")))));
        }
        throw new java.lang.IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
    }

    public static org.apache.commons.codec.language.bm.Rule.PhonemeExpr j(java.lang.String str) {
        if (!str.startsWith("(")) {
            return i(str);
        }
        if (!str.endsWith(")")) {
            throw new java.lang.IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String substring = str.substring(1, str.length() - 1);
        for (java.lang.String str2 : substring.split("[|]")) {
            arrayList.add(i(str2));
        }
        if (substring.startsWith("|") || substring.endsWith("|")) {
            arrayList.add(new org.apache.commons.codec.language.bm.Rule.Phoneme("", org.apache.commons.codec.language.bm.Languages.ANY_LANGUAGE));
        }
        return new org.apache.commons.codec.language.bm.Rule.PhonemeList(arrayList);
    }

    public static java.util.List<org.apache.commons.codec.language.bm.Rule> k(java.util.Scanner scanner, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (true) {
            boolean z = false;
            while (scanner.hasNextLine()) {
                i++;
                java.lang.String nextLine = scanner.nextLine();
                if (z) {
                    if (nextLine.endsWith("*/")) {
                        break;
                    }
                } else if (nextLine.startsWith("/*")) {
                    z = true;
                } else {
                    int indexOf = nextLine.indexOf("//");
                    java.lang.String trim = (indexOf >= 0 ? nextLine.substring(0, indexOf) : nextLine).trim();
                    if (trim.length() == 0) {
                        continue;
                    } else if (trim.startsWith("#include")) {
                        java.lang.String trim2 = trim.substring(8).trim();
                        if (trim2.contains(" ")) {
                            java.lang.System.err.println("Warining: malformed import statement: " + nextLine);
                        } else {
                            arrayList.addAll(k(f(trim2), str + "->" + trim2));
                        }
                    } else {
                        java.lang.String[] split = trim.split("\\s+");
                        if (split.length != 4) {
                            java.lang.System.err.println("Warning: malformed rule statement split into " + split.length + " parts: " + nextLine);
                        } else {
                            try {
                                arrayList.add(new org.apache.commons.codec.language.bm.Rule.AnonymousClass2(n(split[0]), n(split[1]), n(split[2]), j(n(split[3])), i, str));
                            } catch (java.lang.IllegalArgumentException e2) {
                                throw new java.lang.IllegalStateException("Problem parsing line " + i, e2);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    public static org.apache.commons.codec.language.bm.Rule.RPattern l(java.lang.String str) {
        boolean startsWith = str.startsWith("^");
        boolean endsWith = str.endsWith("$");
        int length = str.length();
        if (endsWith) {
            length--;
        }
        java.lang.String substring = str.substring(startsWith ? 1 : 0, length);
        if (substring.contains("[")) {
            boolean startsWith2 = substring.startsWith("[");
            boolean endsWith2 = substring.endsWith("]");
            if (startsWith2 && endsWith2) {
                java.lang.String substring2 = substring.substring(1, substring.length() - 1);
                if (!substring2.contains("[")) {
                    boolean startsWith3 = substring2.startsWith("^");
                    if (startsWith3) {
                        substring2 = substring2.substring(1);
                    }
                    boolean z = !startsWith3;
                    if (startsWith && endsWith) {
                        return new org.apache.commons.codec.language.bm.Rule.AnonymousClass7(substring2, z);
                    }
                    if (startsWith) {
                        return new org.apache.commons.codec.language.bm.Rule.AnonymousClass8(substring2, z);
                    }
                    if (endsWith) {
                        return new org.apache.commons.codec.language.bm.Rule.AnonymousClass9(substring2, z);
                    }
                }
            }
        } else {
            if (startsWith && endsWith) {
                return substring.length() == 0 ? new org.apache.commons.codec.language.bm.Rule.AnonymousClass3() : new org.apache.commons.codec.language.bm.Rule.AnonymousClass4(substring);
            }
            if ((startsWith || endsWith) && substring.length() == 0) {
                return ALL_STRINGS_RMATCHER;
            }
            if (startsWith) {
                return new org.apache.commons.codec.language.bm.Rule.AnonymousClass5(substring);
            }
            if (endsWith) {
                return new org.apache.commons.codec.language.bm.Rule.AnonymousClass6(substring);
            }
        }
        return new org.apache.commons.codec.language.bm.Rule.AnonymousClass10(str);
    }

    public static boolean m(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        for (int i = 0; i < charSequence2.length(); i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static java.lang.String n(java.lang.String str) {
        if (str.startsWith("\"")) {
            str = str.substring(1);
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public org.apache.commons.codec.language.bm.Rule.RPattern getLContext() {
        return this.a;
    }

    public java.lang.String getPattern() {
        return this.b;
    }

    public org.apache.commons.codec.language.bm.Rule.PhonemeExpr getPhoneme() {
        return this.c;
    }

    public org.apache.commons.codec.language.bm.Rule.RPattern getRContext() {
        return this.d;
    }

    public boolean patternAndContextMatches(java.lang.CharSequence charSequence, int i) {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("Can not match pattern at negative indexes");
        }
        int length = this.b.length() + i;
        if (length > charSequence.length()) {
            return false;
        }
        return charSequence.subSequence(i, length).equals(this.b) && this.d.isMatch(charSequence.subSequence(length, charSequence.length())) && this.a.isMatch(charSequence.subSequence(0, i));
    }
}

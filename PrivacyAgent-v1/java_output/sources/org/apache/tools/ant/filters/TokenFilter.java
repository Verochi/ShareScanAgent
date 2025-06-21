package org.apache.tools.ant.filters;

/* loaded from: classes25.dex */
public class TokenFilter extends org.apache.tools.ant.filters.BaseFilterReader implements org.apache.tools.ant.filters.ChainableReader {
    public java.util.Vector<org.apache.tools.ant.filters.TokenFilter.Filter> u;
    public org.apache.tools.ant.util.Tokenizer v;
    public java.lang.String w;
    public java.lang.String x;
    public int y;

    public static abstract class ChainableReaderFilter extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.filters.ChainableReader, org.apache.tools.ant.filters.TokenFilter.Filter {
        public boolean n = true;

        @Override // org.apache.tools.ant.filters.ChainableReader
        public java.io.Reader chain(java.io.Reader reader) {
            org.apache.tools.ant.filters.TokenFilter tokenFilter = new org.apache.tools.ant.filters.TokenFilter(reader);
            if (!this.n) {
                tokenFilter.add(new org.apache.tools.ant.filters.TokenFilter.FileTokenizer());
            }
            tokenFilter.add(this);
            return tokenFilter;
        }

        public void setByLine(boolean z) {
            this.n = z;
        }
    }

    public static class ContainsRegex extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
        public org.apache.tools.ant.util.regexp.Regexp A;
        public java.lang.String t;
        public java.lang.String u;
        public org.apache.tools.ant.types.RegularExpression v;
        public org.apache.tools.ant.types.Substitution w;
        public boolean x = false;
        public java.lang.String y = "";
        public int z;

        public final void a() {
            if (this.x) {
                return;
            }
            this.z = org.apache.tools.ant.filters.TokenFilter.convertRegexOptions(this.y);
            if (this.t == null) {
                throw new org.apache.tools.ant.BuildException("Missing from in containsregex");
            }
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            this.v = regularExpression;
            regularExpression.setPattern(this.t);
            this.A = this.v.getRegexp(getProject());
            if (this.u == null) {
                return;
            }
            org.apache.tools.ant.types.Substitution substitution = new org.apache.tools.ant.types.Substitution();
            this.w = substitution;
            substitution.setExpression(this.u);
        }

        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            a();
            if (!this.A.matches(str, this.z)) {
                return null;
            }
            org.apache.tools.ant.types.Substitution substitution = this.w;
            return substitution == null ? str : this.A.substitute(str, substitution.getExpression(getProject()), this.z);
        }

        public void setFlags(java.lang.String str) {
            this.y = str;
        }

        public void setPattern(java.lang.String str) {
            this.t = str;
        }

        public void setReplace(java.lang.String str) {
            this.u = str;
        }
    }

    public static class ContainsString extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.filters.TokenFilter.Filter {
        public java.lang.String n;

        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            java.lang.String str2 = this.n;
            if (str2 == null) {
                throw new org.apache.tools.ant.BuildException("Missing contains in containsstring");
            }
            if (str.contains(str2)) {
                return str;
            }
            return null;
        }

        public void setContains(java.lang.String str) {
            this.n = str;
        }
    }

    public static class DeleteCharacters extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.filters.TokenFilter.Filter, org.apache.tools.ant.filters.ChainableReader {
        public java.lang.String n = "";

        /* renamed from: org.apache.tools.ant.filters.TokenFilter$DeleteCharacters$1, reason: invalid class name */
        public class AnonymousClass1 extends org.apache.tools.ant.filters.BaseFilterReader {
            public AnonymousClass1(java.io.Reader reader) {
                super(reader);
            }

            @Override // java.io.FilterReader, java.io.Reader
            public int read() throws java.io.IOException {
                int read;
                do {
                    read = ((java.io.FilterReader) this).in.read();
                    if (read == -1) {
                        return read;
                    }
                } while (org.apache.tools.ant.filters.TokenFilter.DeleteCharacters.this.b((char) read));
                return read;
            }
        }

        public final boolean b(char c) {
            for (int i = 0; i < this.n.length(); i++) {
                if (this.n.charAt(i) == c) {
                    return true;
                }
            }
            return false;
        }

        @Override // org.apache.tools.ant.filters.ChainableReader
        public java.io.Reader chain(java.io.Reader reader) {
            return new org.apache.tools.ant.filters.TokenFilter.DeleteCharacters.AnonymousClass1(reader);
        }

        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!b(charAt)) {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }

        public void setChars(java.lang.String str) {
            this.n = org.apache.tools.ant.filters.TokenFilter.resolveBackSlash(str);
        }
    }

    public static class FileTokenizer extends org.apache.tools.ant.util.FileTokenizer {
    }

    public interface Filter {
        java.lang.String filter(java.lang.String str);
    }

    public static class IgnoreBlank extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            if (str.trim().length() == 0) {
                return null;
            }
            return str;
        }
    }

    public static class ReplaceRegex extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
        public org.apache.tools.ant.util.regexp.Regexp A;
        public java.lang.String t;
        public java.lang.String u;
        public org.apache.tools.ant.types.RegularExpression v;
        public org.apache.tools.ant.types.Substitution w;
        public boolean x = false;
        public java.lang.String y = "";
        public int z;

        public final void a() {
            if (this.x) {
                return;
            }
            this.z = org.apache.tools.ant.filters.TokenFilter.convertRegexOptions(this.y);
            if (this.t == null) {
                throw new org.apache.tools.ant.BuildException("Missing pattern in replaceregex");
            }
            org.apache.tools.ant.types.RegularExpression regularExpression = new org.apache.tools.ant.types.RegularExpression();
            this.v = regularExpression;
            regularExpression.setPattern(this.t);
            this.A = this.v.getRegexp(getProject());
            if (this.u == null) {
                this.u = "";
            }
            org.apache.tools.ant.types.Substitution substitution = new org.apache.tools.ant.types.Substitution();
            this.w = substitution;
            substitution.setExpression(this.u);
        }

        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            a();
            return !this.A.matches(str, this.z) ? str : this.A.substitute(str, this.w.getExpression(getProject()), this.z);
        }

        public void setFlags(java.lang.String str) {
            this.y = str;
        }

        public void setPattern(java.lang.String str) {
            this.t = str;
        }

        public void setReplace(java.lang.String str) {
            this.u = str;
        }
    }

    public static class ReplaceString extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
        public java.lang.String t;
        public java.lang.String u;

        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            if (this.t == null) {
                throw new org.apache.tools.ant.BuildException("Missing from in stringreplace");
            }
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            int indexOf = str.indexOf(this.t);
            int i = 0;
            while (indexOf >= 0) {
                if (indexOf > i) {
                    stringBuffer.append(str.substring(i, indexOf));
                }
                java.lang.String str2 = this.u;
                if (str2 != null) {
                    stringBuffer.append(str2);
                }
                i = this.t.length() + indexOf;
                indexOf = str.indexOf(this.t, i);
            }
            if (str.length() > i) {
                stringBuffer.append(str.substring(i, str.length()));
            }
            return stringBuffer.toString();
        }

        public void setFrom(java.lang.String str) {
            this.t = str;
        }

        public void setTo(java.lang.String str) {
            this.u = str;
        }
    }

    public static class StringTokenizer extends org.apache.tools.ant.util.StringTokenizer {
    }

    public static class Trim extends org.apache.tools.ant.filters.TokenFilter.ChainableReaderFilter {
        @Override // org.apache.tools.ant.filters.TokenFilter.Filter
        public java.lang.String filter(java.lang.String str) {
            return str.trim();
        }
    }

    public TokenFilter() {
        this.u = new java.util.Vector<>();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0;
    }

    public TokenFilter(java.io.Reader reader) {
        super(reader);
        this.u = new java.util.Vector<>();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0;
    }

    public static int convertRegexOptions(java.lang.String str) {
        return org.apache.tools.ant.util.regexp.RegexpUtil.asOptions(str);
    }

    public static java.lang.String resolveBackSlash(java.lang.String str) {
        return org.apache.tools.ant.util.StringUtils.resolveBackSlash(str);
    }

    public void add(org.apache.tools.ant.filters.TokenFilter.Filter filter) {
        this.u.addElement(filter);
    }

    public void add(org.apache.tools.ant.util.Tokenizer tokenizer) {
        if (this.v != null) {
            throw new org.apache.tools.ant.BuildException("Only one tokenizer allowed");
        }
        this.v = tokenizer;
    }

    public void addContainsRegex(org.apache.tools.ant.filters.TokenFilter.ContainsRegex containsRegex) {
        this.u.addElement(containsRegex);
    }

    public void addContainsString(org.apache.tools.ant.filters.TokenFilter.ContainsString containsString) {
        this.u.addElement(containsString);
    }

    public void addDeleteCharacters(org.apache.tools.ant.filters.TokenFilter.DeleteCharacters deleteCharacters) {
        this.u.addElement(deleteCharacters);
    }

    public void addFileTokenizer(org.apache.tools.ant.filters.TokenFilter.FileTokenizer fileTokenizer) {
        add(fileTokenizer);
    }

    public void addIgnoreBlank(org.apache.tools.ant.filters.TokenFilter.IgnoreBlank ignoreBlank) {
        this.u.addElement(ignoreBlank);
    }

    public void addLineTokenizer(org.apache.tools.ant.util.LineTokenizer lineTokenizer) {
        add(lineTokenizer);
    }

    public void addReplaceRegex(org.apache.tools.ant.filters.TokenFilter.ReplaceRegex replaceRegex) {
        this.u.addElement(replaceRegex);
    }

    public void addReplaceString(org.apache.tools.ant.filters.TokenFilter.ReplaceString replaceString) {
        this.u.addElement(replaceString);
    }

    public void addStringTokenizer(org.apache.tools.ant.filters.TokenFilter.StringTokenizer stringTokenizer) {
        add(stringTokenizer);
    }

    public void addTrim(org.apache.tools.ant.filters.TokenFilter.Trim trim) {
        this.u.addElement(trim);
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public final java.io.Reader chain(java.io.Reader reader) {
        org.apache.tools.ant.filters.TokenFilter tokenFilter = new org.apache.tools.ant.filters.TokenFilter(reader);
        tokenFilter.u = this.u;
        tokenFilter.v = this.v;
        tokenFilter.w = this.w;
        tokenFilter.setProject(getProject());
        return tokenFilter;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws java.io.IOException {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.util.LineTokenizer();
        }
        while (true) {
            java.lang.String str = this.x;
            if (str != null && str.length() != 0) {
                char charAt = this.x.charAt(this.y);
                int i = this.y + 1;
                this.y = i;
                if (i == this.x.length()) {
                    this.x = null;
                }
                return charAt;
            }
            java.lang.String token = this.v.getToken(((java.io.FilterReader) this).in);
            this.x = token;
            if (token == null) {
                return -1;
            }
            java.util.Enumeration<org.apache.tools.ant.filters.TokenFilter.Filter> elements = this.u.elements();
            while (elements.hasMoreElements()) {
                java.lang.String filter = elements.nextElement().filter(this.x);
                this.x = filter;
                if (filter == null) {
                    break;
                }
            }
            this.y = 0;
            if (this.x != null && this.v.getPostToken().length() != 0) {
                if (this.w != null) {
                    this.x += this.w;
                } else {
                    this.x += this.v.getPostToken();
                }
            }
        }
    }

    public void setDelimOutput(java.lang.String str) {
        this.w = resolveBackSlash(str);
    }
}

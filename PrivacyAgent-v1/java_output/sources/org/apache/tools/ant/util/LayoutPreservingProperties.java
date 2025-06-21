package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class LayoutPreservingProperties extends java.util.Properties {
    private java.lang.String LS;
    private java.util.HashMap keyedPairLines;
    private java.util.ArrayList logicalLines;
    private boolean removeComments;

    public static class Blank extends org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine {
        public Blank() {
            super("");
        }
    }

    public class Comment extends org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine {
        public Comment(java.lang.String str) {
            super(str);
        }
    }

    public static abstract class LogicalLine {
        public java.lang.String n;

        public LogicalLine(java.lang.String str) {
            this.n = str;
        }

        public void a(java.lang.String str) {
            this.n = str;
        }

        public java.lang.String toString() {
            return this.n;
        }
    }

    public static class Pair extends org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine implements java.lang.Cloneable {
        public java.lang.String t;
        public java.lang.String u;
        public boolean v;

        public Pair(java.lang.String str) {
            super(str);
            f(str);
        }

        public Pair(java.lang.String str, java.lang.String str2) {
            this(str + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str2);
        }

        public final int b(java.lang.String str) {
            return d(str.replaceAll("\\\\\\\\", "__").replaceAll("\\\\=", "__").replaceAll("\\\\:", "__").replaceAll("\\\\ ", "__").replaceAll("\\\\t", "__"), " :=\t");
        }

        public java.lang.String c() {
            return this.t;
        }

        public java.lang.Object clone() {
            try {
                return super.clone();
            } catch (java.lang.CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final int d(java.lang.String str, java.lang.String str2) {
            if (str == null || str2 == null) {
                return -1;
            }
            int length = str.length() + 1;
            for (int i = 0; i < str2.length(); i++) {
                int indexOf = str.indexOf(str2.charAt(i));
                if (indexOf != -1 && indexOf < length) {
                    length = indexOf;
                }
            }
            if (length == str.length() + 1) {
                return -1;
            }
            return length;
        }

        public boolean e() {
            return this.v;
        }

        public final void f(java.lang.String str) {
            int b = b(str);
            if (b == -1) {
                this.t = str;
                this.u = null;
            } else {
                this.t = str.substring(0, b);
                this.u = str.substring(b + 1, str.length());
            }
            this.t = i(this.t, " \t\f");
        }

        public void g(boolean z) {
            this.v = z;
        }

        public void h(java.lang.String str) {
            this.u = str;
            a(this.t + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + str);
        }

        public final java.lang.String i(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                return null;
            }
            int i = 0;
            while (i < str.length() && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
            return i == str.length() ? "" : str.substring(i);
        }
    }

    public LayoutPreservingProperties() {
        this.LS = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        this.logicalLines = new java.util.ArrayList();
        this.keyedPairLines = new java.util.HashMap();
    }

    public LayoutPreservingProperties(java.util.Properties properties) {
        super(properties);
        this.LS = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        this.logicalLines = new java.util.ArrayList();
        this.keyedPairLines = new java.util.HashMap();
    }

    private java.lang.String escape(java.lang.String str, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        char[] cArr = new char[length];
        str.getChars(0, str.length(), cArr, 0);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length());
        boolean z2 = true;
        for (int i = 0; i < length; i++) {
            char c = cArr[i];
            if (c != ' ') {
                z2 = false;
            } else if (z || z2) {
                stringBuffer.append("\\");
            }
            int indexOf = "\t\f\r\n\\:=#!".indexOf(c);
            if (indexOf != -1) {
                stringBuffer.append("\\");
                stringBuffer.append("tfrn\\:=#!".substring(indexOf, indexOf + 1));
            } else if (c < ' ' || c > '~') {
                stringBuffer.append(escapeUnicode(c));
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }

    private java.lang.String escapeName(java.lang.String str) {
        return escape(str, true);
    }

    private java.lang.String escapeUnicode(char c) {
        return "\\" + ((java.lang.Object) org.apache.tools.ant.util.UnicodeUtil.EscapeUnicode(c));
    }

    private java.lang.String escapeValue(java.lang.String str) {
        return escape(str, false);
    }

    private void innerSetProperty(java.lang.String str, java.lang.String str2) {
        java.lang.String escapeValue = escapeValue(str2);
        if (this.keyedPairLines.containsKey(str)) {
            ((org.apache.tools.ant.util.LayoutPreservingProperties.Pair) this.logicalLines.get(((java.lang.Integer) this.keyedPairLines.get(str)).intValue())).h(escapeValue);
            return;
        }
        java.lang.String escapeName = escapeName(str);
        org.apache.tools.ant.util.LayoutPreservingProperties.Pair pair = new org.apache.tools.ant.util.LayoutPreservingProperties.Pair(escapeName, escapeValue);
        pair.g(true);
        this.keyedPairLines.put(escapeName, new java.lang.Integer(this.logicalLines.size()));
        this.logicalLines.add(pair);
    }

    private java.lang.String readFirstLine(java.io.PushbackReader pushbackReader) throws java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(80);
        int read = pushbackReader.read();
        this.LS = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        boolean z = false;
        while (true) {
            if (read >= 0) {
                if (z && read != 10) {
                    pushbackReader.unread(read);
                    break;
                }
                if (read == 13) {
                    this.LS = "\r";
                    z = true;
                } else if (read == 10) {
                    this.LS = z ? "\r\n" : "\n";
                } else {
                    stringBuffer.append((char) read);
                }
                read = pushbackReader.read();
            } else {
                break;
            }
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [org.apache.tools.ant.util.LayoutPreservingProperties$Blank] */
    /* JADX WARN: Type inference failed for: r0v13, types: [org.apache.tools.ant.util.LayoutPreservingProperties$Comment] */
    private java.lang.String readLines(java.io.InputStream inputStream) throws java.io.IOException {
        org.apache.tools.ant.util.LayoutPreservingProperties.Pair pair;
        java.io.PushbackReader pushbackReader = new java.io.PushbackReader(new java.io.InputStreamReader(inputStream, "ISO-8859-1"), 1);
        if (this.logicalLines.size() > 0) {
            this.logicalLines.add(new org.apache.tools.ant.util.LayoutPreservingProperties.Blank());
        }
        java.lang.String readFirstLine = readFirstLine(pushbackReader);
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(pushbackReader);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
        boolean z = false;
        boolean z2 = false;
        while (readFirstLine != null) {
            stringBuffer.append(readFirstLine);
            stringBuffer.append(this.LS);
            if (z) {
                readFirstLine = "\n" + readFirstLine;
            } else {
                z2 = readFirstLine.matches("^( |\t|\f)*(#|!).*");
            }
            if (!z2) {
                z = requiresContinuation(readFirstLine);
            }
            stringBuffer2.append(readFirstLine);
            if (!z) {
                if (z2) {
                    pair = new org.apache.tools.ant.util.LayoutPreservingProperties.Comment(stringBuffer2.toString());
                } else if (stringBuffer2.toString().trim().length() == 0) {
                    pair = new org.apache.tools.ant.util.LayoutPreservingProperties.Blank();
                } else {
                    org.apache.tools.ant.util.LayoutPreservingProperties.Pair pair2 = new org.apache.tools.ant.util.LayoutPreservingProperties.Pair(stringBuffer2.toString());
                    java.lang.String unescape = unescape(pair2.c());
                    if (this.keyedPairLines.containsKey(unescape)) {
                        remove(unescape);
                    }
                    this.keyedPairLines.put(unescape, java.lang.Integer.valueOf(this.logicalLines.size()));
                    pair = pair2;
                }
                this.logicalLines.add(pair);
                stringBuffer2.setLength(0);
            }
            readFirstLine = bufferedReader.readLine();
        }
        return stringBuffer.toString();
    }

    private void removeCommentsEndingAt(int i) {
        int i2 = i - 1;
        int i3 = i2;
        while (i3 > 0 && (this.logicalLines.get(i3) instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Blank)) {
            i3--;
        }
        if (!(this.logicalLines.get(i3) instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Comment)) {
            return;
        }
        while (i3 >= 0 && (this.logicalLines.get(i3) instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Comment)) {
            i3--;
        }
        while (true) {
            i3++;
            if (i3 > i2) {
                return;
            } else {
                this.logicalLines.set(i3, null);
            }
        }
    }

    private boolean requiresContinuation(java.lang.String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length - 1;
        while (length > 0 && charArray[length] == '\\') {
            length--;
        }
        return ((charArray.length - length) - 1) % 2 == 1;
    }

    private java.lang.String unescape(java.lang.String str) {
        int length = str.length() + 1;
        char[] cArr = new char[length];
        int i = 0;
        str.getChars(0, str.length(), cArr, 0);
        cArr[str.length()] = '\n';
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(str.length());
        while (i < length) {
            char c = cArr[i];
            if (c == '\n') {
                break;
            }
            if (c == '\\') {
                i++;
                char c2 = cArr[i];
                if (c2 == 'n') {
                    stringBuffer.append('\n');
                } else if (c2 == 'r') {
                    stringBuffer.append('\r');
                } else if (c2 == 'f') {
                    stringBuffer.append('\f');
                } else if (c2 == 't') {
                    stringBuffer.append('\t');
                } else if (c2 == 'u') {
                    char unescapeUnicode = unescapeUnicode(cArr, i + 1);
                    i += 4;
                    stringBuffer.append(unescapeUnicode);
                } else {
                    stringBuffer.append(c2);
                }
            } else {
                stringBuffer.append(c);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private char unescapeUnicode(char[] cArr, int i) {
        return (char) java.lang.Integer.parseInt(new java.lang.String(cArr, i, 4), 16);
    }

    @Override // java.util.Hashtable, java.util.Map
    public void clear() {
        super.clear();
        this.keyedPairLines.clear();
        this.logicalLines.clear();
    }

    @Override // java.util.Hashtable
    public java.lang.Object clone() {
        org.apache.tools.ant.util.LayoutPreservingProperties layoutPreservingProperties = (org.apache.tools.ant.util.LayoutPreservingProperties) super.clone();
        layoutPreservingProperties.keyedPairLines = (java.util.HashMap) this.keyedPairLines.clone();
        java.util.ArrayList arrayList = (java.util.ArrayList) this.logicalLines.clone();
        layoutPreservingProperties.logicalLines = arrayList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine logicalLine = (org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine) layoutPreservingProperties.logicalLines.get(i);
            if (logicalLine instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Pair) {
                layoutPreservingProperties.logicalLines.set(i, ((org.apache.tools.ant.util.LayoutPreservingProperties.Pair) logicalLine).clone());
            }
        }
        return layoutPreservingProperties;
    }

    public boolean isRemoveComments() {
        return this.removeComments;
    }

    public void listLines(java.io.PrintStream printStream) {
        printStream.println("-- logical lines --");
        java.util.Iterator it = this.logicalLines.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine logicalLine = (org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine) it.next();
            if (logicalLine instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Blank) {
                printStream.println("blank:   \"" + logicalLine + "\"");
            } else if (logicalLine instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Comment) {
                printStream.println("comment: \"" + logicalLine + "\"");
            } else if (logicalLine instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Pair) {
                printStream.println("pair:    \"" + logicalLine + "\"");
            }
        }
    }

    @Override // java.util.Properties
    public void load(java.io.InputStream inputStream) throws java.io.IOException {
        super.load(new java.io.ByteArrayInputStream(readLines(inputStream).getBytes("ISO-8859-1")));
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public java.lang.Object put(java.lang.Object obj, java.lang.Object obj2) throws java.lang.NullPointerException {
        java.lang.Object put = super.put(obj, obj2);
        innerSetProperty(obj.toString(), obj2.toString());
        return put;
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public java.lang.Object remove(java.lang.Object obj) {
        java.lang.Object remove = super.remove(obj);
        java.lang.Integer num = (java.lang.Integer) this.keyedPairLines.remove(obj);
        if (num != null) {
            if (this.removeComments) {
                removeCommentsEndingAt(num.intValue());
            }
            this.logicalLines.set(num.intValue(), null);
        }
        return remove;
    }

    public void saveAs(java.io.File file) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        store(fileOutputStream, (java.lang.String) null);
        fileOutputStream.close();
    }

    @Override // java.util.Properties
    public java.lang.Object setProperty(java.lang.String str, java.lang.String str2) throws java.lang.NullPointerException {
        java.lang.Object property = super.setProperty(str, str2);
        innerSetProperty(str, str2);
        return property;
    }

    public void setRemoveComments(boolean z) {
        this.removeComments = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    @Override // java.util.Properties
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void store(java.io.OutputStream outputStream, java.lang.String str) throws java.io.IOException {
        int i;
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(outputStream, "ISO-8859-1");
        int size = this.logicalLines.size();
        boolean z = false;
        if (str != null) {
            outputStreamWriter.write("#" + str + this.LS);
            if (size > 0 && (this.logicalLines.get(0) instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Comment) && str.equals(this.logicalLines.get(0).toString().substring(1))) {
                i = 1;
                if (size > i && (this.logicalLines.get(i) instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Comment)) {
                    try {
                        org.apache.tools.ant.util.DateUtils.parseDateFromHeader(this.logicalLines.get(i).toString().substring(1));
                        i++;
                    } catch (java.text.ParseException unused) {
                    }
                }
                outputStreamWriter.write("#" + org.apache.tools.ant.util.DateUtils.getDateForHeader() + this.LS);
                for (org.apache.tools.ant.util.LayoutPreservingProperties.LogicalLine logicalLine : this.logicalLines.subList(i, size)) {
                    if (logicalLine instanceof org.apache.tools.ant.util.LayoutPreservingProperties.Pair) {
                        if (((org.apache.tools.ant.util.LayoutPreservingProperties.Pair) logicalLine).e() && !z) {
                            outputStreamWriter.write(this.LS);
                            z = true;
                        }
                        outputStreamWriter.write(logicalLine.toString() + this.LS);
                    } else if (logicalLine != null) {
                        outputStreamWriter.write(logicalLine.toString() + this.LS);
                    }
                }
                outputStreamWriter.close();
            }
        }
        i = 0;
        if (size > i) {
            org.apache.tools.ant.util.DateUtils.parseDateFromHeader(this.logicalLines.get(i).toString().substring(1));
            i++;
        }
        outputStreamWriter.write("#" + org.apache.tools.ant.util.DateUtils.getDateForHeader() + this.LS);
        while (r7.hasNext()) {
        }
        outputStreamWriter.close();
    }
}

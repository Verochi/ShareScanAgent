package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class Commandline implements java.lang.Cloneable {
    protected static final java.lang.String DISCLAIMER;
    public static final boolean u = org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_9X);
    public java.util.List<org.apache.tools.ant.types.Commandline.Argument> n = new java.util.ArrayList();
    public java.lang.String t = null;

    public static class Argument extends org.apache.tools.ant.ProjectComponent {
        public java.lang.String[] n;
        public java.lang.String t = "";
        public java.lang.String u = "";

        public void copyFrom(org.apache.tools.ant.types.Commandline.Argument argument) {
            this.n = argument.n;
            this.t = argument.t;
            this.u = argument.u;
        }

        public java.lang.String[] getParts() {
            java.lang.String[] strArr = this.n;
            if (strArr == null || strArr.length == 0 || (this.t.length() == 0 && this.u.length() == 0)) {
                return this.n;
            }
            int length = this.n.length;
            java.lang.String[] strArr2 = new java.lang.String[length];
            for (int i = 0; i < length; i++) {
                strArr2[i] = this.t + this.n[i] + this.u;
            }
            return strArr2;
        }

        public void setFile(java.io.File file) {
            this.n = new java.lang.String[]{file.getAbsolutePath()};
        }

        public void setLine(java.lang.String str) {
            if (str == null) {
                return;
            }
            this.n = org.apache.tools.ant.types.Commandline.translateCommandline(str);
        }

        public void setPath(org.apache.tools.ant.types.Path path) {
            this.n = new java.lang.String[]{path.toString()};
        }

        public void setPathref(org.apache.tools.ant.types.Reference reference) {
            org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getProject());
            path.setRefid(reference);
            this.n = new java.lang.String[]{path.toString()};
        }

        public void setPrefix(java.lang.String str) {
            if (str == null) {
                str = "";
            }
            this.t = str;
        }

        public void setSuffix(java.lang.String str) {
            if (str == null) {
                str = "";
            }
            this.u = str;
        }

        public void setValue(java.lang.String str) {
            this.n = new java.lang.String[]{str};
        }
    }

    public class Marker {
        public int a;
        public int b = -1;
        public java.lang.String c = "";
        public java.lang.String d = "";

        public Marker(int i) {
            this.a = i;
        }

        public int getPosition() {
            if (this.b == -1) {
                this.b = org.apache.tools.ant.types.Commandline.this.t == null ? 0 : 1;
                for (int i = 0; i < this.a; i++) {
                    this.b += ((org.apache.tools.ant.types.Commandline.Argument) org.apache.tools.ant.types.Commandline.this.n.get(i)).getParts().length;
                }
            }
            return this.b;
        }

        public java.lang.String getPrefix() {
            return this.c;
        }

        public java.lang.String getSuffix() {
            return this.d;
        }

        public void setPrefix(java.lang.String str) {
            if (str == null) {
                str = "";
            }
            this.c = str;
        }

        public void setSuffix(java.lang.String str) {
            if (str == null) {
                str = "";
            }
            this.d = str;
        }
    }

    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = org.apache.tools.ant.util.StringUtils.LINE_SEP;
        sb.append(str);
        sb.append("The ' characters around the executable and arguments are");
        sb.append(str);
        sb.append("not part of the command.");
        sb.append(str);
        DISCLAIMER = sb.toString();
    }

    public Commandline() {
    }

    public Commandline(java.lang.String str) {
        java.lang.String[] translateCommandline = translateCommandline(str);
        if (translateCommandline == null || translateCommandline.length <= 0) {
            return;
        }
        setExecutable(translateCommandline[0]);
        for (int i = 1; i < translateCommandline.length; i++) {
            createArgument().setValue(translateCommandline[i]);
        }
    }

    public static java.lang.String describeArguments(org.apache.tools.ant.types.Commandline commandline) {
        return describeArguments(commandline.getArguments());
    }

    public static java.lang.String describeArguments(java.lang.String[] strArr) {
        return describeArguments(strArr, 0);
    }

    public static java.lang.String describeArguments(java.lang.String[] strArr, int i) {
        if (strArr == null || strArr.length <= i) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("argument");
        if (strArr.length > i) {
            stringBuffer.append("s");
        }
        stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        while (i < strArr.length) {
            stringBuffer.append("'");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("'");
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
            i++;
        }
        stringBuffer.append(DISCLAIMER);
        return stringBuffer.toString();
    }

    public static java.lang.String describeCommand(org.apache.tools.ant.types.Commandline commandline) {
        return describeCommand(commandline.getCommandline());
    }

    public static java.lang.String describeCommand(java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Executing '");
        stringBuffer.append(strArr[0]);
        stringBuffer.append("'");
        if (strArr.length > 1) {
            stringBuffer.append(" with ");
            stringBuffer.append(describeArguments(strArr, 1));
        } else {
            stringBuffer.append(DISCLAIMER);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String quoteArgument(java.lang.String str) {
        if (str.contains("\"")) {
            if (str.contains("'")) {
                throw new org.apache.tools.ant.BuildException("Can't handle single and double quotes in same argument");
            }
            return '\'' + str + '\'';
        }
        if (!str.contains("'") && !str.contains(" ") && (!u || !str.contains(com.alipay.sdk.m.u.i.b))) {
            return str;
        }
        return kotlin.text.Typography.quote + str + kotlin.text.Typography.quote;
    }

    public static java.lang.String toString(java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(quoteArgument(strArr[i]));
        }
        return sb.toString();
    }

    public static java.lang.String[] translateCommandline(java.lang.String str) {
        char c;
        if (str == null || str.length() == 0) {
            return new java.lang.String[0];
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, "\"' ", true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = false;
        loop0: while (true) {
            c = 0;
            while (stringTokenizer.hasMoreTokens()) {
                java.lang.String nextToken = stringTokenizer.nextToken();
                if (c != 1) {
                    if (c != 2) {
                        if ("'".equals(nextToken)) {
                            c = 1;
                        } else if ("\"".equals(nextToken)) {
                            c = 2;
                        } else if (!" ".equals(nextToken)) {
                            sb.append(nextToken);
                        } else if (z || sb.length() != 0) {
                            arrayList.add(sb.toString());
                            sb.setLength(0);
                        }
                        z = false;
                    } else {
                        if ("\"".equals(nextToken)) {
                            break;
                        }
                        sb.append(nextToken);
                    }
                } else {
                    if ("'".equals(nextToken)) {
                        break;
                    }
                    sb.append(nextToken);
                }
            }
            z = true;
        }
        if (z || sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        if (c != 1 && c != 2) {
            return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        }
        throw new org.apache.tools.ant.BuildException("unbalanced quotes in " + str);
    }

    public void addArguments(java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            createArgument().setValue(str);
        }
    }

    public void addArgumentsToList(java.util.ListIterator<java.lang.String> listIterator) {
        java.util.Iterator<org.apache.tools.ant.types.Commandline.Argument> it = this.n.iterator();
        while (it.hasNext()) {
            java.lang.String[] parts = it.next().getParts();
            if (parts != null) {
                for (java.lang.String str : parts) {
                    listIterator.add(str);
                }
            }
        }
    }

    public void addCommandToList(java.util.ListIterator<java.lang.String> listIterator) {
        java.lang.String str = this.t;
        if (str != null) {
            listIterator.add(str);
        }
        addArgumentsToList(listIterator);
    }

    public void clear() {
        this.t = null;
        this.n.clear();
    }

    public void clearArgs() {
        this.n.clear();
    }

    public java.lang.Object clone() {
        try {
            org.apache.tools.ant.types.Commandline commandline = (org.apache.tools.ant.types.Commandline) super.clone();
            commandline.n = new java.util.ArrayList(this.n);
            return commandline;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public org.apache.tools.ant.types.Commandline.Argument createArgument() {
        return createArgument(false);
    }

    public org.apache.tools.ant.types.Commandline.Argument createArgument(boolean z) {
        org.apache.tools.ant.types.Commandline.Argument argument = new org.apache.tools.ant.types.Commandline.Argument();
        if (z) {
            this.n.add(0, argument);
        } else {
            this.n.add(argument);
        }
        return argument;
    }

    public org.apache.tools.ant.types.Commandline.Marker createMarker() {
        return new org.apache.tools.ant.types.Commandline.Marker(this.n.size());
    }

    public java.lang.String describeArguments() {
        return describeArguments(this);
    }

    public java.lang.String describeCommand() {
        return describeCommand(this);
    }

    public java.lang.String[] getArguments() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.n.size() * 2);
        addArgumentsToList(arrayList.listIterator());
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public java.lang.String[] getCommandline() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        addCommandToList(linkedList.listIterator());
        return (java.lang.String[]) linkedList.toArray(new java.lang.String[linkedList.size()]);
    }

    public java.lang.String getExecutable() {
        return this.t;
    }

    public java.util.Iterator<org.apache.tools.ant.types.Commandline.Argument> iterator() {
        return this.n.iterator();
    }

    public void setExecutable(java.lang.String str) {
        setExecutable(str, true);
    }

    public void setExecutable(java.lang.String str, boolean z) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (z) {
            str = str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
        }
        this.t = str;
    }

    public int size() {
        return getCommandline().length;
    }

    public java.lang.String toString() {
        return toString(getCommandline());
    }
}

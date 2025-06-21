package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class AntStructure extends org.apache.tools.ant.Task {
    public static final java.lang.String w = java.lang.System.getProperty("line.separator");
    public java.io.File u;
    public org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter v = new org.apache.tools.ant.taskdefs.AntStructure.DTDPrinter(null);

    public static class DTDPrinter implements org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter {
        public final java.util.Hashtable<java.lang.String, java.lang.String> a;

        public DTDPrinter() {
            this.a = new java.util.Hashtable<>();
        }

        public /* synthetic */ DTDPrinter(org.apache.tools.ant.taskdefs.AntStructure.AnonymousClass1 anonymousClass1) {
            this();
        }

        public static final boolean a(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!b(str)) {
                    return false;
                }
            }
            return true;
        }

        public static final boolean b(java.lang.String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (!java.lang.Character.isLetterOrDigit(charAt) && charAt != '.' && charAt != '-' && charAt != '_' && charAt != ':') {
                    return false;
                }
            }
            return true;
        }

        public final void c(java.io.PrintWriter printWriter, java.util.Enumeration<java.lang.String> enumeration, java.util.Enumeration<java.lang.String> enumeration2) {
            printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
            printWriter.println("<!ENTITY % boolean \"(true|false|on|off|yes|no)\">");
            printWriter.print("<!ENTITY % tasks \"");
            boolean z = true;
            boolean z2 = true;
            while (enumeration.hasMoreElements()) {
                java.lang.String nextElement = enumeration.nextElement();
                if (z2) {
                    z2 = false;
                } else {
                    printWriter.print(" | ");
                }
                printWriter.print(nextElement);
            }
            printWriter.println("\">");
            printWriter.print("<!ENTITY % types \"");
            while (enumeration2.hasMoreElements()) {
                java.lang.String nextElement2 = enumeration2.nextElement();
                if (z) {
                    z = false;
                } else {
                    printWriter.print(" | ");
                }
                printWriter.print(nextElement2);
            }
            printWriter.println("\">");
            printWriter.println("");
            printWriter.print("<!ELEMENT project (target | extension-point | ");
            printWriter.print("%tasks;");
            printWriter.print(" | ");
            printWriter.print("%types;");
            printWriter.println(")*>");
            printWriter.println("<!ATTLIST project");
            printWriter.println("          name    CDATA #IMPLIED");
            printWriter.println("          default CDATA #IMPLIED");
            printWriter.println("          basedir CDATA #IMPLIED>");
            printWriter.println("");
        }

        public final void d(java.io.PrintWriter printWriter, java.lang.String str) {
            printWriter.print("<!ATTLIST ");
            printWriter.println(str);
            printWriter.println("          id                      ID    #IMPLIED");
            printWriter.println("          name                    CDATA #REQUIRED");
            printWriter.println("          if                      CDATA #IMPLIED");
            printWriter.println("          unless                  CDATA #IMPLIED");
            printWriter.println("          depends                 CDATA #IMPLIED");
            printWriter.println("          extensionOf             CDATA #IMPLIED");
            printWriter.println("          onMissingExtensionPoint CDATA #IMPLIED");
            printWriter.println("          description             CDATA #IMPLIED>");
            printWriter.println("");
        }

        /* JADX WARN: Code restructure failed: missing block: B:127:0x00e9, code lost:
        
            if (((java.lang.String) r9.elementAt(0)).equals("#PCDATA") != false) goto L36;
         */
        @Override // org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void printElementDecl(java.io.PrintWriter printWriter, org.apache.tools.ant.Project project, java.lang.String str, java.lang.Class<?> cls) {
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            java.util.Enumeration<java.lang.String> enumeration;
            if (this.a.containsKey(str)) {
                return;
            }
            this.a.put(str, "");
            try {
                org.apache.tools.ant.IntrospectionHelper helper = org.apache.tools.ant.IntrospectionHelper.getHelper(project, cls);
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("<!ELEMENT ");
                stringBuffer.append(str);
                stringBuffer.append(" ");
                if (org.apache.tools.ant.types.Reference.class.equals(cls)) {
                    stringBuffer.append("EMPTY>");
                    stringBuffer.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                    stringBuffer.append("<!ATTLIST ");
                    stringBuffer.append(str);
                    stringBuffer.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                    stringBuffer.append("          id ID #IMPLIED");
                    stringBuffer.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                    stringBuffer.append("          refid IDREF #IMPLIED");
                    stringBuffer.append(">");
                    stringBuffer.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                    printWriter.println(stringBuffer);
                    return;
                }
                java.util.Vector vector = new java.util.Vector();
                if (helper.supportsCharacters()) {
                    vector.addElement("#PCDATA");
                }
                java.lang.String str5 = "%tasks;";
                if (org.apache.tools.ant.TaskContainer.class.isAssignableFrom(cls)) {
                    vector.addElement("%tasks;");
                }
                java.util.Enumeration<java.lang.String> nestedElements = helper.getNestedElements();
                while (nestedElements.hasMoreElements()) {
                    vector.addElement(nestedElements.nextElement());
                }
                java.lang.String str6 = " | ";
                if (vector.isEmpty()) {
                    stringBuffer.append("EMPTY");
                    str2 = "%tasks;";
                } else {
                    stringBuffer.append("(");
                    int size = vector.size();
                    int i = 0;
                    while (i < size) {
                        if (i != 0) {
                            stringBuffer.append(" | ");
                        }
                        stringBuffer.append((java.lang.String) vector.elementAt(i));
                        i++;
                        str5 = str5;
                    }
                    str2 = str5;
                    stringBuffer.append(")");
                    if (size > 1) {
                    }
                    stringBuffer.append("*");
                }
                stringBuffer.append(">");
                printWriter.println(stringBuffer);
                java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer("<!ATTLIST ");
                stringBuffer2.append(str);
                stringBuffer2.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                stringBuffer2.append("          id ID #IMPLIED");
                java.util.Enumeration<java.lang.String> attributes = helper.getAttributes();
                while (attributes.hasMoreElements()) {
                    java.lang.String nextElement = attributes.nextElement();
                    if (!"id".equals(nextElement)) {
                        stringBuffer2.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                        stringBuffer2.append("          ");
                        stringBuffer2.append(nextElement);
                        stringBuffer2.append(" ");
                        java.lang.Class<?> attributeType = helper.getAttributeType(nextElement);
                        if (attributeType.equals(java.lang.Boolean.class) || attributeType.equals(java.lang.Boolean.TYPE)) {
                            str4 = str6;
                            enumeration = attributes;
                            stringBuffer2.append("%boolean;");
                            stringBuffer2.append(" ");
                        } else {
                            if (org.apache.tools.ant.types.Reference.class.isAssignableFrom(attributeType)) {
                                stringBuffer2.append("IDREF ");
                            } else if (org.apache.tools.ant.types.EnumeratedAttribute.class.isAssignableFrom(attributeType)) {
                                try {
                                    java.lang.String[] values = ((org.apache.tools.ant.types.EnumeratedAttribute) attributeType.newInstance()).getValues();
                                    if (values != null && values.length != 0 && a(values)) {
                                        stringBuffer2.append("(");
                                        for (int i2 = 0; i2 < values.length; i2++) {
                                            if (i2 != 0) {
                                                stringBuffer2.append(str6);
                                            }
                                            stringBuffer2.append(values[i2]);
                                        }
                                        stringBuffer2.append(") ");
                                    }
                                    stringBuffer2.append("CDATA ");
                                } catch (java.lang.IllegalAccessException unused) {
                                    stringBuffer2.append("CDATA ");
                                } catch (java.lang.InstantiationException unused2) {
                                    stringBuffer2.append("CDATA ");
                                }
                            } else if (java.lang.Enum.class.isAssignableFrom(attributeType)) {
                                try {
                                    java.lang.Object[] objArr = (java.lang.Object[]) attributeType.getMethod("values", null).invoke(null, null);
                                    if (objArr.length == 0) {
                                        stringBuffer2.append("CDATA ");
                                    } else {
                                        stringBuffer2.append('(');
                                        enumeration = attributes;
                                        int i3 = 0;
                                        while (i3 < objArr.length) {
                                            try {
                                                if (i3 != 0) {
                                                    stringBuffer2.append(str6);
                                                }
                                                str4 = str6;
                                            } catch (java.lang.Exception unused3) {
                                                str4 = str6;
                                            }
                                            try {
                                                stringBuffer2.append(attributeType.getMethod("name", null).invoke(objArr[i3], null));
                                                i3++;
                                                str6 = str4;
                                                objArr = objArr;
                                            } catch (java.lang.Exception unused4) {
                                                stringBuffer2.append("CDATA ");
                                                stringBuffer2.append("#IMPLIED");
                                                attributes = enumeration;
                                                str6 = str4;
                                            }
                                        }
                                        str4 = str6;
                                        stringBuffer2.append(") ");
                                    }
                                } catch (java.lang.Exception unused5) {
                                    str4 = str6;
                                    enumeration = attributes;
                                }
                            } else {
                                str4 = str6;
                                enumeration = attributes;
                                stringBuffer2.append("CDATA ");
                            }
                            str4 = str6;
                            enumeration = attributes;
                        }
                        stringBuffer2.append("#IMPLIED");
                        attributes = enumeration;
                        str6 = str4;
                    }
                }
                stringBuffer2.append(">");
                stringBuffer2.append(org.apache.tools.ant.taskdefs.AntStructure.w);
                printWriter.println(stringBuffer2);
                int size2 = vector.size();
                int i4 = 0;
                while (i4 < size2) {
                    java.lang.String str7 = (java.lang.String) vector.elementAt(i4);
                    if ("#PCDATA".equals(str7)) {
                        str3 = str2;
                    } else {
                        str3 = str2;
                        if (!str3.equals(str7) && !"%types;".equals(str7)) {
                            printElementDecl(printWriter, project, str7, helper.getElementType(str7));
                        }
                    }
                    i4++;
                    str2 = str3;
                }
            } catch (java.lang.Throwable unused6) {
            }
        }

        @Override // org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter
        public void printHead(java.io.PrintWriter printWriter, org.apache.tools.ant.Project project, java.util.Hashtable<java.lang.String, java.lang.Class<?>> hashtable, java.util.Hashtable<java.lang.String, java.lang.Class<?>> hashtable2) {
            c(printWriter, hashtable.keys(), hashtable2.keys());
        }

        @Override // org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter
        public void printTail(java.io.PrintWriter printWriter) {
            this.a.clear();
        }

        @Override // org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter
        public void printTargetDecl(java.io.PrintWriter printWriter) {
            printWriter.print("<!ELEMENT target (");
            printWriter.print("%tasks;");
            printWriter.print(" | ");
            printWriter.print("%types;");
            printWriter.println(")*>");
            printWriter.println("");
            d(printWriter, com.umeng.ccg.a.A);
            printWriter.println("<!ELEMENT extension-point EMPTY>");
            printWriter.println("");
            d(printWriter, "extension-point");
        }
    }

    public interface StructurePrinter {
        void printElementDecl(java.io.PrintWriter printWriter, org.apache.tools.ant.Project project, java.lang.String str, java.lang.Class<?> cls);

        void printHead(java.io.PrintWriter printWriter, org.apache.tools.ant.Project project, java.util.Hashtable<java.lang.String, java.lang.Class<?>> hashtable, java.util.Hashtable<java.lang.String, java.lang.Class<?>> hashtable2);

        void printTail(java.io.PrintWriter printWriter);

        void printTargetDecl(java.io.PrintWriter printWriter);
    }

    public void add(org.apache.tools.ant.taskdefs.AntStructure.StructurePrinter structurePrinter) {
        this.v = structurePrinter;
    }

    public boolean areNmtokens(java.lang.String[] strArr) {
        return org.apache.tools.ant.taskdefs.AntStructure.DTDPrinter.a(strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[Catch: all -> 0x001a, IOException -> 0x001d, LOOP:0: B:10:0x0069->B:12:0x006f, LOOP_END, TryCatch #3 {IOException -> 0x001d, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0031, B:10:0x0069, B:12:0x006f, B:14:0x008d, B:15:0x009d, B:17:0x00a3, B:19:0x00c1, B:24:0x00d0, B:25:0x00d7, B:29:0x0021), top: B:4:0x0005, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[Catch: all -> 0x001a, IOException -> 0x001d, LOOP:1: B:15:0x009d->B:17:0x00a3, LOOP_END, TryCatch #3 {IOException -> 0x001d, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0031, B:10:0x0069, B:12:0x006f, B:14:0x008d, B:15:0x009d, B:17:0x00a3, B:19:0x00c1, B:24:0x00d0, B:25:0x00d7, B:29:0x0021), top: B:4:0x0005, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0 A[Catch: all -> 0x001a, IOException -> 0x001d, TRY_ENTER, TryCatch #3 {IOException -> 0x001d, blocks: (B:5:0x0005, B:7:0x000c, B:9:0x0031, B:10:0x0069, B:12:0x006f, B:14:0x008d, B:15:0x009d, B:17:0x00a3, B:19:0x00c1, B:24:0x00d0, B:25:0x00d7, B:29:0x0021), top: B:4:0x0005, outer: #1 }] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("output attribute is required", getLocation());
        }
        java.io.PrintWriter printWriter = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(this.u);
                    try {
                        printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(fileOutputStream, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8));
                    } catch (java.io.UnsupportedEncodingException unused) {
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                        printWriter = new java.io.PrintWriter(new java.io.FileWriter(this.u));
                        this.v.printHead(printWriter, getProject(), new java.util.Hashtable<>(getProject().getTaskDefinitions()), new java.util.Hashtable<>(getProject().getDataTypeDefinitions()));
                        this.v.printTargetDecl(printWriter);
                        while (r1.hasNext()) {
                        }
                        while (r1.hasNext()) {
                        }
                        this.v.printTail(printWriter);
                        if (!printWriter.checkError()) {
                        }
                    }
                } catch (java.lang.Throwable th) {
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    throw th;
                }
            } catch (java.io.UnsupportedEncodingException unused2) {
                fileOutputStream = null;
            }
            this.v.printHead(printWriter, getProject(), new java.util.Hashtable<>(getProject().getTaskDefinitions()), new java.util.Hashtable<>(getProject().getDataTypeDefinitions()));
            this.v.printTargetDecl(printWriter);
            for (java.lang.String str : getProject().getCopyOfDataTypeDefinitions().keySet()) {
                this.v.printElementDecl(printWriter, getProject(), str, getProject().getDataTypeDefinitions().get(str));
            }
            for (java.lang.String str2 : getProject().getCopyOfTaskDefinitions().keySet()) {
                this.v.printElementDecl(printWriter, getProject(), str2, getProject().getTaskDefinitions().get(str2));
            }
            this.v.printTail(printWriter);
            if (!printWriter.checkError()) {
                throw new java.io.IOException("Encountered an error writing Ant structure");
            }
            printWriter.close();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Error writing " + this.u.getAbsolutePath(), e, getLocation());
        }
    }

    public boolean isNmtoken(java.lang.String str) {
        return org.apache.tools.ant.taskdefs.AntStructure.DTDPrinter.b(str);
    }

    public void setOutput(java.io.File file) {
        this.u = file;
    }
}

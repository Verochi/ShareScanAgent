package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class IPlanetEjbc {
    public java.io.File a;
    public java.io.File b;
    public java.io.File c;
    public java.lang.String d;
    public java.lang.String[] e;
    public java.io.File h;
    public javax.xml.parsers.SAXParser i;
    public java.lang.String l;
    public boolean f = false;
    public boolean g = false;
    public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcHandler j = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcHandler();
    public java.util.Hashtable k = new java.util.Hashtable();

    public static class Classname {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;

        public Classname(java.lang.String str) {
            if (str == null) {
                return;
            }
            this.a = str;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                this.c = str;
                this.b = "";
            } else {
                this.b = str.substring(0, lastIndexOf);
                this.c = str.substring(lastIndexOf + 1);
            }
        }

        public java.io.File a(java.io.File file) {
            return new java.io.File(file, this.a.replace('.', java.io.File.separatorChar) + ".class");
        }

        public java.lang.String b() {
            return this.c;
        }

        public java.lang.String c() {
            return this.b;
        }

        public java.lang.String d() {
            return this.a;
        }

        public java.lang.String e() {
            return this.a.replace('.', '_');
        }

        public java.lang.String toString() {
            return d();
        }
    }

    public class EjbInfo {
        public java.lang.String a;
        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname b;
        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname c;
        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname d;
        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname e;
        public java.lang.String f = "entity";
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public java.util.List<java.lang.String> j = new java.util.ArrayList();

        public EjbInfo(java.lang.String str) {
            this.a = str;
        }

        public void A(java.lang.String str) {
            B(new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname(str));
        }

        public void B(org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname) {
            this.e = classname;
        }

        public void C(java.lang.String str) {
            D(new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname(str));
        }

        public void D(org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname) {
            this.c = classname;
        }

        public final long E(java.io.File file) {
            java.io.File file2;
            java.io.File a = this.c.a(file);
            long lastModified = a.lastModified();
            if (lastModified == -1) {
                java.lang.System.out.println("The class " + this.c.d() + " couldn't be found on the classpath");
                return -1L;
            }
            java.io.File a2 = this.b.a(file);
            long lastModified2 = a2.lastModified();
            if (lastModified2 == -1) {
                java.lang.System.out.println("The class " + this.b.d() + " couldn't be found on the classpath");
                return -1L;
            }
            long max = java.lang.Math.max(lastModified, lastModified2);
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname = this.e;
            if (classname != null) {
                file2 = classname.a(file);
                long lastModified3 = file2.lastModified();
                if (lastModified3 == -1) {
                    java.lang.System.out.println("The class " + this.e.d() + "couldn't be found on the classpath");
                    return -1L;
                }
                max = java.lang.Math.max(max, lastModified3);
            } else {
                file2 = null;
            }
            java.io.File a3 = this.d.a(file);
            if (a3.lastModified() == -1) {
                java.lang.System.out.println("The class " + this.d.d() + " couldn't be found on the classpath");
                return -1L;
            }
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.k.put(this.c.d().replace('.', java.io.File.separatorChar) + ".class", a);
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.k.put(this.b.d().replace('.', java.io.File.separatorChar) + ".class", a2);
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.k.put(this.d.d().replace('.', java.io.File.separatorChar) + ".class", a3);
            if (file2 != null) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.k.put(this.e.d().replace('.', java.io.File.separatorChar) + ".class", file2);
            }
            return max;
        }

        public void b(java.lang.String str) {
            this.j.add(str);
        }

        public final void c(java.io.File file) throws org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException {
            if (this.b == null) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("A home interface was not found for the " + this.a + " EJB.");
            }
            if (this.c == null) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("A remote interface was not found for the " + this.a + " EJB.");
            }
            if (this.d == null) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("An EJB implementation class was not found for the " + this.a + " EJB.");
            }
            if (!this.f.equals("entity") && !this.f.equals("stateless") && !this.f.equals("stateful")) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("The beantype found (" + this.f + ") isn't valid in the " + this.a + " EJB.");
            }
            if (this.g && !this.f.equals("entity")) {
                java.lang.System.out.println("CMP stubs and skeletons may not be generated for a Session Bean -- the \"cmp\" attribute will be ignoredfor the " + this.a + " EJB.");
            }
            if (this.i && !this.f.equals("stateful")) {
                java.lang.System.out.println("Highly available stubs and skeletons may only be generated for a Stateful Session Bean -- the \"hasession\" attribute will be ignored for the " + this.a + " EJB.");
            }
            if (!this.c.a(file).exists()) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("The remote interface " + this.c.d() + " could not be found.");
            }
            if (!this.b.a(file).exists()) {
                throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("The home interface " + this.b.d() + " could not be found.");
            }
            if (this.d.a(file).exists()) {
                return;
            }
            throw org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbcException("The EJB implementation class " + this.d.d() + " could not be found.");
        }

        public final java.lang.String[] d() {
            java.lang.String[] strArr = this.h ? new java.lang.String[15] : new java.lang.String[9];
            java.lang.String str = this.c.c() + ".";
            java.lang.String b = this.c.b();
            java.lang.String str2 = this.b.c() + ".";
            java.lang.String b2 = this.b.b();
            java.lang.String str3 = this.d.c() + ".";
            java.lang.String e = this.d.e();
            strArr[0] = str3 + "ejb_fac_" + e;
            strArr[1] = str3 + "ejb_home_" + e;
            strArr[2] = str3 + "ejb_skel_" + e;
            strArr[3] = str + "ejb_kcp_skel_" + b;
            strArr[4] = str2 + "ejb_kcp_skel_" + b2;
            strArr[5] = str + "ejb_kcp_stub_" + b;
            strArr[6] = str2 + "ejb_kcp_stub_" + b2;
            strArr[7] = str + "ejb_stub_" + b;
            strArr[8] = str2 + "ejb_stub_" + b2;
            if (!this.h) {
                return strArr;
            }
            strArr[9] = "org.omg.stub." + str + "_" + b + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_STUB_SUFFIX;
            strArr[10] = "org.omg.stub." + str2 + "_" + b2 + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_STUB_SUFFIX;
            strArr[11] = "org.omg.stub." + str + "_ejb_RmiCorbaBridge_" + b + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_TIE_SUFFIX;
            strArr[12] = "org.omg.stub." + str2 + "_ejb_RmiCorbaBridge_" + b2 + org.apache.tools.ant.taskdefs.rmic.DefaultRmicAdapter.RMI_TIE_SUFFIX;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("ejb_RmiCorbaBridge_");
            sb.append(b);
            strArr[13] = sb.toString();
            strArr[14] = str2 + "ejb_RmiCorbaBridge_" + b2;
            return strArr;
        }

        public final long e(java.io.File file) {
            java.lang.String[] d = d();
            long time = new java.util.Date().getTime();
            boolean z = true;
            for (java.lang.String str : d) {
                java.lang.String str2 = str.replace('.', java.io.File.separatorChar) + ".class";
                java.io.File file2 = new java.io.File(file, str2);
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.k.put(str2, file2);
                z = z && file2.exists();
                if (z) {
                    time = java.lang.Math.min(time, file2.lastModified());
                }
            }
            if (z) {
                return time;
            }
            return -1L;
        }

        public java.lang.String f() {
            return this.f;
        }

        public boolean g() {
            return this.g;
        }

        public java.util.List h() {
            return this.j;
        }

        public boolean i() {
            return this.i;
        }

        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname j() {
            return this.b;
        }

        public boolean k() {
            return this.h;
        }

        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname l() {
            return this.d;
        }

        public java.lang.String m() {
            java.lang.String str = this.a;
            if (str != null) {
                return str;
            }
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname = this.d;
            return classname == null ? "[unnamed]" : classname.b();
        }

        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname n() {
            return this.c;
        }

        public boolean o(java.io.File file) {
            return e(file) < E(file);
        }

        public void p(java.lang.String str) {
            this.f = str.toLowerCase();
        }

        public void q(java.lang.String str) {
            r(str.equals("Container"));
        }

        public void r(boolean z) {
            this.g = z;
        }

        public void s(java.lang.String str) {
            t(str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE));
        }

        public void t(boolean z) {
            this.i = z;
        }

        public java.lang.String toString() {
            java.lang.String str = "EJB name: " + this.a + "\n\r              home:      " + this.b + "\n\r              remote:    " + this.c + "\n\r              impl:      " + this.d + "\n\r              primaryKey: " + this.e + "\n\r              beantype:  " + this.f + "\n\r              cmp:       " + this.g + "\n\r              iiop:      " + this.h + "\n\r              hasession: " + this.i;
            java.util.Iterator<java.lang.String> it = this.j.iterator();
            while (it.hasNext()) {
                str = str + "\n\r              CMP Descriptor: " + it.next();
            }
            return str;
        }

        public void u(java.lang.String str) {
            v(new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname(str));
        }

        public void v(org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname) {
            this.b = classname;
        }

        public void w(java.lang.String str) {
            x(str.equals(com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE));
        }

        public void x(boolean z) {
            this.h = z;
        }

        public void y(java.lang.String str) {
            z(new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname(str));
        }

        public void z(org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.Classname classname) {
            this.d = classname;
        }
    }

    public class EjbcException extends java.lang.Exception {
        public EjbcException(java.lang.String str) {
            super(str);
        }
    }

    public class EjbcHandler extends org.xml.sax.HandlerBase {
        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo v;
        public java.lang.String y;
        public java.lang.String z;
        public java.util.Map n = new java.util.HashMap();
        public java.util.Map t = new java.util.HashMap();
        public java.util.Map u = new java.util.HashMap();
        public boolean w = false;
        public java.lang.String x = "";

        public EjbcHandler() {
            c("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", "ejb-jar_1_1.dtd");
            c("-//Sun Microsystems, Inc.//DTD iAS Enterprise JavaBeans 1.0//EN", "IASEjb_jar_1_0.dtd");
        }

        public org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo[] a() {
            return (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo[]) this.u.values().toArray(new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo[this.u.size()]);
        }

        public final void b(java.lang.String str) {
            java.lang.String str2 = "\\ias-ejb-jar\\enterprise-beans\\" + this.z;
            if (this.x.equals(str2 + "\\ejb-name")) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo = (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo) this.u.get(str);
                this.v = ejbInfo;
                if (ejbInfo == null) {
                    org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo2 = org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbInfo(str);
                    this.v = ejbInfo2;
                    this.u.put(str, ejbInfo2);
                    return;
                }
                return;
            }
            if (this.x.equals(str2 + "\\iiop")) {
                this.v.w(str);
                return;
            }
            if (this.x.equals(str2 + "\\failover-required")) {
                this.v.s(str);
                return;
            }
            if (this.x.equals(str2 + "\\persistence-manager\\properties-file-location")) {
                this.v.b(str);
            }
        }

        public void c(java.lang.String str, java.lang.String str2) {
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.g("Registering: " + str2);
            if (str == null || str2 == null) {
                return;
            }
            if (java.lang.ClassLoader.getSystemResource(str2) != null) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.g("Found resource: " + str2);
                this.n.put(str, str2);
                return;
            }
            java.io.File file = new java.io.File(str2);
            if (file.exists() && file.isFile()) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.g("Found file: " + str2);
                this.t.put(str, str2);
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) throws org.xml.sax.SAXException {
            this.y += new java.lang.String(cArr).substring(i, i2 + i);
        }

        public final void d(java.lang.String str) {
            if (this.x.equals("\\ejb-jar\\display-name")) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.l = str;
                return;
            }
            java.lang.String str2 = "\\ejb-jar\\enterprise-beans\\" + this.z;
            if (this.x.equals(str2 + "\\ejb-name")) {
                org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo = (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo) this.u.get(str);
                this.v = ejbInfo;
                if (ejbInfo == null) {
                    org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo2 = org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.this.new EjbInfo(str);
                    this.v = ejbInfo2;
                    this.u.put(str, ejbInfo2);
                    return;
                }
                return;
            }
            if (this.x.equals(str2 + "\\home")) {
                this.v.u(str);
                return;
            }
            if (this.x.equals(str2 + "\\remote")) {
                this.v.C(str);
                return;
            }
            if (this.x.equals(str2 + "\\ejb-class")) {
                this.v.y(str);
                return;
            }
            if (this.x.equals(str2 + "\\prim-key-class")) {
                this.v.A(str);
                return;
            }
            if (this.x.equals(str2 + "\\session-type")) {
                this.v.p(str);
                return;
            }
            if (this.x.equals(str2 + "\\persistence-type")) {
                this.v.q(str);
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void endElement(java.lang.String str) throws org.xml.sax.SAXException {
            if (this.w) {
                b(this.y);
            } else {
                d(this.y);
            }
            int length = str.length() + 1;
            this.x = this.x.substring(0, this.x.length() - length);
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.EntityResolver
        public org.xml.sax.InputSource resolveEntity(java.lang.String str, java.lang.String str2) throws org.xml.sax.SAXException {
            java.io.InputStream fileInputStream;
            try {
                java.lang.String str3 = (java.lang.String) this.n.get(str);
                if (str3 != null) {
                    fileInputStream = java.lang.ClassLoader.getSystemResource(str3).openStream();
                } else {
                    java.lang.String str4 = (java.lang.String) this.t.get(str);
                    fileInputStream = str4 != null ? new java.io.FileInputStream(str4) : null;
                }
                return fileInputStream == null ? super.resolveEntity(str, str2) : new org.xml.sax.InputSource(fileInputStream);
            } catch (java.io.IOException unused) {
                return super.resolveEntity(str, str2);
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(java.lang.String str, org.xml.sax.AttributeList attributeList) throws org.xml.sax.SAXException {
            java.lang.String str2 = this.x + "\\" + str;
            this.x = str2;
            this.y = "";
            if (str2.equals("\\ejb-jar")) {
                this.w = false;
            } else if (this.x.equals("\\ias-ejb-jar")) {
                this.w = true;
            }
            if (str.equals(com.umeng.analytics.pro.f.aC) || str.equals("entity")) {
                this.z = str;
            }
        }
    }

    public static class RedirectOutput extends java.lang.Thread {
        public java.io.InputStream n;

        public RedirectOutput(java.io.InputStream inputStream) {
            this.n = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(this.n));
            while (true) {
                try {
                    try {
                        java.lang.String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            java.lang.System.out.println(readLine);
                        }
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                } finally {
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                }
            }
        }
    }

    public IPlanetEjbc(java.io.File file, java.io.File file2, java.io.File file3, java.lang.String str, javax.xml.parsers.SAXParser sAXParser) {
        this.a = file;
        this.b = file2;
        this.c = file3;
        this.d = str;
        this.i = sAXParser;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, java.io.File.pathSeparator);
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
            this.e = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        }
    }

    public static void h() {
        java.lang.System.out.println("java org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc \\");
        java.lang.System.out.println("  [OPTIONS] [EJB 1.1 descriptor] [iAS EJB descriptor]");
        java.lang.System.out.println("");
        java.lang.System.out.println("Where OPTIONS are:");
        java.lang.System.out.println("  -debug -- for additional debugging output");
        java.lang.System.out.println("  -keepsource -- to retain Java source files generated");
        java.lang.System.out.println("  -classpath [classpath] -- classpath used for compilation");
        java.lang.System.out.println("  -d [destination directory] -- directory for compiled classes");
        java.lang.System.out.println("");
        java.lang.System.out.println("If a classpath is not specified, the system classpath");
        java.lang.System.out.println("will be used.  If a destination directory is not specified,");
        java.lang.System.out.println("the current working directory will be used (classes will");
        java.lang.System.out.println("still be placed in subfolders which correspond to their");
        java.lang.System.out.println("package name).");
        java.lang.System.out.println("");
        java.lang.System.out.println("The EJB home interface, remote interface, and implementation");
        java.lang.System.out.println("class must be found in the destination directory.  In");
        java.lang.System.out.println("addition, the destination will look for the stubs and skeletons");
        java.lang.System.out.println("in the destination directory to ensure they are up to date.");
    }

    public static void main(java.lang.String[] strArr) {
        if (strArr.length < 2 || strArr.length > 8) {
            h();
            return;
        }
        java.io.File file = new java.io.File(strArr[strArr.length - 2]);
        java.io.File file2 = new java.io.File(strArr[strArr.length - 1]);
        java.lang.String str = null;
        java.io.File file3 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < strArr.length - 2) {
            if (strArr[i].equals("-classpath")) {
                i++;
                str = strArr[i];
            } else if (strArr[i].equals("-d")) {
                i++;
                file3 = new java.io.File(strArr[i]);
            } else if (strArr[i].equals("-debug")) {
                z = true;
            } else {
                if (!strArr[i].equals("-keepsource")) {
                    h();
                    return;
                }
                z2 = true;
            }
            i++;
        }
        java.lang.String property = str == null ? java.lang.System.getProperties().getProperty("java.class.path") : str;
        java.io.File file4 = file3 == null ? new java.io.File(java.lang.System.getProperties().getProperty("user.dir")) : file3;
        javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
        newInstance.setValidating(true);
        try {
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc iPlanetEjbc = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc(file, file2, file4, property, newInstance.newSAXParser());
            iPlanetEjbc.setDebugOutput(z);
            iPlanetEjbc.setRetainSource(z2);
            try {
                iPlanetEjbc.execute();
            } catch (java.io.IOException e) {
                java.lang.System.out.println("An IOException has occurred while reading the XML descriptors (" + e.getMessage() + ").");
            } catch (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException e2) {
                java.lang.System.out.println("An error has occurred while executing the ejbc utility (" + e2.getMessage() + ").");
            } catch (org.xml.sax.SAXException e3) {
                java.lang.System.out.println("A SAXException has occurred while reading the XML descriptors (" + e3.getMessage() + ").");
            }
        } catch (java.lang.Exception e4) {
            java.lang.System.out.println("An exception was generated while trying to ");
            java.lang.System.out.println("create a new SAXParser.");
            e4.printStackTrace();
        }
    }

    public void checkConfiguration() throws org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException {
        java.lang.String str = "";
        if (this.a == null) {
            str = "A standard XML descriptor file must be specified.  ";
        }
        if (this.b == null) {
            str = str + "An iAS-specific XML descriptor file must be specified.  ";
        }
        if (this.d == null) {
            str = str + "A classpath must be specified.    ";
        }
        if (this.i == null) {
            str = str + "An XML parser must be specified.    ";
        }
        java.io.File file = this.c;
        if (file == null) {
            str = str + "A destination directory must be specified.  ";
        } else if (!file.exists()) {
            str = str + "The destination directory specified does not exist.  ";
        } else if (!this.c.isDirectory()) {
            str = str + "The destination specified is not a directory.  ";
        }
        if (str.length() > 0) {
            throw new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException(str);
        }
    }

    public final java.lang.String[] d(org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.g) {
            arrayList.add("-debug");
        }
        if (ejbInfo.f().equals("stateless")) {
            arrayList.add("-sl");
        } else if (ejbInfo.f().equals("stateful")) {
            arrayList.add("-sf");
        }
        if (ejbInfo.k()) {
            arrayList.add("-iiop");
        }
        if (ejbInfo.g()) {
            arrayList.add("-cmp");
        }
        if (this.f) {
            arrayList.add("-gs");
        }
        if (ejbInfo.i()) {
            arrayList.add("-fo");
        }
        arrayList.add("-classpath");
        arrayList.add(this.d);
        arrayList.add("-d");
        arrayList.add(this.c.toString());
        arrayList.add(ejbInfo.j().d());
        arrayList.add(ejbInfo.n().d());
        arrayList.add(ejbInfo.l().d());
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public final void e(java.lang.String[] strArr) {
        java.lang.String sb;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.lang.String str : strArr) {
            stringBuffer.append(str);
            stringBuffer.append(" ");
        }
        if (this.h == null) {
            sb = "";
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(this.h.toString());
            java.lang.String str2 = java.io.File.separator;
            sb2.append(str2);
            sb2.append("bin");
            sb2.append(str2);
            sb = sb2.toString();
        }
        java.lang.String str3 = sb + "ejbc ";
        g(str3 + ((java.lang.Object) stringBuffer));
        try {
            java.lang.Process exec = java.lang.Runtime.getRuntime().exec(str3 + ((java.lang.Object) stringBuffer));
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.RedirectOutput redirectOutput = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.RedirectOutput(exec.getInputStream());
            org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.RedirectOutput redirectOutput2 = new org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.RedirectOutput(exec.getErrorStream());
            redirectOutput.start();
            redirectOutput2.start();
            exec.waitFor();
            exec.destroy();
        } catch (java.io.IOException e) {
            g("An IOException has occurred while trying to execute ejbc.");
            g(org.apache.tools.ant.util.StringUtils.getStackTrace(e));
        } catch (java.lang.InterruptedException unused) {
        }
    }

    public void execute() throws org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbcException, java.io.IOException, org.xml.sax.SAXException {
        checkConfiguration();
        org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo[] f = f();
        for (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo : f) {
            g("EJBInfo...");
            g(ejbInfo.toString());
        }
        for (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo2 : f) {
            ejbInfo2.c(this.c);
            if (ejbInfo2.o(this.c)) {
                g(ejbInfo2.m() + " must be recompiled using ejbc.");
                e(d(ejbInfo2));
            } else {
                g(ejbInfo2.m() + " is up to date.");
            }
        }
    }

    public final org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo[] f() throws java.io.IOException, org.xml.sax.SAXException {
        this.i.parse(this.a, this.j);
        this.i.parse(this.b, this.j);
        return this.j.a();
    }

    public final void g(java.lang.String str) {
        if (this.g) {
            java.lang.System.out.println(str);
        }
    }

    public java.lang.String[] getCmpDescriptors() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (org.apache.tools.ant.taskdefs.optional.ejb.IPlanetEjbc.EjbInfo ejbInfo : this.j.a()) {
            arrayList.addAll(ejbInfo.h());
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public java.lang.String getDisplayName() {
        return this.l;
    }

    public java.util.Hashtable getEjbFiles() {
        return this.k;
    }

    public void registerDTD(java.lang.String str, java.lang.String str2) {
        this.j.c(str, str2);
    }

    public void setDebugOutput(boolean z) {
        this.g = z;
    }

    public void setIasHomeDir(java.io.File file) {
        this.h = file;
    }

    public void setRetainSource(boolean z) {
        this.f = z;
    }
}

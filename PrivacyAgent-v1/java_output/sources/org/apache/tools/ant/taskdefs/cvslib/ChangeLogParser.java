package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
class ChangeLogParser {
    public final java.text.SimpleDateFormat a;
    public final java.text.SimpleDateFormat b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public int i;
    public final java.util.Hashtable j;
    public final boolean k;
    public final java.lang.String[] l;
    public final int[] m;

    public ChangeLogParser() {
        this(false, "", org.apache.tools.ant.util.CollectionUtils.EMPTY_LIST);
    }

    public ChangeLogParser(boolean z, java.lang.String str, java.util.List list) {
        java.util.Locale locale = java.util.Locale.US;
        this.a = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss", locale);
        this.b = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", locale);
        this.i = 1;
        this.j = new java.util.Hashtable();
        this.k = z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (str != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str);
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
            }
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((org.apache.tools.ant.taskdefs.AbstractCvsTask.Module) it.next()).getName());
        }
        java.lang.String[] strArr = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
        this.l = strArr;
        this.m = new int[strArr.length];
        int i = 0;
        while (true) {
            java.lang.String[] strArr2 = this.l;
            if (i >= strArr2.length) {
                java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone("UTC");
                this.a.setTimeZone(timeZone);
                this.b.setTimeZone(timeZone);
                return;
            }
            this.m[i] = strArr2[i].length();
            i++;
        }
    }

    public org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] a() {
        org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr = new org.apache.tools.ant.taskdefs.cvslib.CVSEntry[this.j.size()];
        java.util.Enumeration elements = this.j.elements();
        int i = 0;
        while (elements.hasMoreElements()) {
            cVSEntryArr[i] = (org.apache.tools.ant.taskdefs.cvslib.CVSEntry) elements.nextElement();
            i++;
        }
        return cVSEntryArr;
    }

    public final java.util.Date b(java.lang.String str) {
        try {
            try {
                return this.a.parse(str);
            } catch (java.text.ParseException unused) {
                return this.b.parse(str);
            }
        } catch (java.text.ParseException unused2) {
            throw new java.lang.IllegalStateException("Invalid date format: " + str);
        }
    }

    public final void c(java.lang.String str) {
        java.lang.String property = java.lang.System.getProperty("line.separator");
        if (str.equals("=============================================================================")) {
            this.f = this.f.substring(0, this.f.length() - property.length());
            i();
            this.i = 1;
            return;
        }
        if (str.equals("----------------------------")) {
            this.f = this.f.substring(0, this.f.length() - property.length());
            this.i = 5;
        } else {
            this.f += str + property;
        }
    }

    public final void d(java.lang.String str) {
        if (str.startsWith("date:")) {
            int indexOf = str.indexOf(59);
            this.d = str.substring(6, indexOf);
            int indexOf2 = str.indexOf("author: ", indexOf + 1);
            this.e = str.substring(8 + indexOf2, str.indexOf(59, indexOf2 + 1));
            this.i = 3;
            this.f = "";
        }
    }

    public final void e(java.lang.String str) {
        if (!this.k && str.startsWith("Working file:")) {
            this.c = str.substring(14, str.length());
            this.i = 4;
            return;
        }
        if (this.k && str.startsWith("RCS file:")) {
            int i = 0;
            int i2 = 0;
            while (true) {
                java.lang.String[] strArr = this.l;
                if (i2 >= strArr.length) {
                    break;
                }
                int indexOf = str.indexOf(strArr[i2]);
                if (indexOf >= 0) {
                    i = indexOf + this.m[i2] + 1;
                    break;
                }
                i2++;
            }
            int indexOf2 = str.indexOf(",v");
            if (indexOf2 == -1) {
                this.c = str.substring(i);
            } else {
                this.c = str.substring(i, indexOf2);
            }
            this.i = 4;
        }
    }

    public final void f(java.lang.String str) {
        if (!str.startsWith("revision ")) {
            throw new java.lang.IllegalStateException("Unexpected line from CVS: " + str);
        }
        this.h = str.substring(9);
        i();
        this.g = this.h;
        this.i = 2;
    }

    public final void g(java.lang.String str) {
        if (str.startsWith("revision")) {
            this.g = str.substring(9);
            this.i = 2;
        } else if (str.startsWith("======")) {
            this.i = 1;
        }
    }

    public void h() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public final void i() {
        org.apache.tools.ant.taskdefs.cvslib.CVSEntry cVSEntry;
        java.lang.String str = this.d + this.e + this.f;
        if (this.j.containsKey(str)) {
            cVSEntry = (org.apache.tools.ant.taskdefs.cvslib.CVSEntry) this.j.get(str);
        } else {
            cVSEntry = new org.apache.tools.ant.taskdefs.cvslib.CVSEntry(b(this.d), this.e, this.f);
            this.j.put(str, cVSEntry);
        }
        cVSEntry.addFile(this.c, this.g, this.h);
    }

    public void j(java.lang.String str) {
        int i = this.i;
        if (i == 1) {
            h();
            e(str);
            return;
        }
        if (i == 2) {
            d(str);
            return;
        }
        if (i == 3) {
            c(str);
        } else if (i == 4) {
            g(str);
        } else {
            if (i != 5) {
                return;
            }
            f(str);
        }
    }
}

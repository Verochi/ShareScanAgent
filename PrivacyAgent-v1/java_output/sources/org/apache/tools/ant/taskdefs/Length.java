package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Length extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.condition.Condition {
    public org.apache.tools.ant.types.resources.Resources A;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.Boolean w;
    public java.lang.String x = "all";
    public org.apache.tools.ant.types.Comparison y = org.apache.tools.ant.types.Comparison.EQUAL;
    public java.lang.Long z;

    public class AccumHandler extends org.apache.tools.ant.taskdefs.Length.Handler {
        public long c;

        public AccumHandler() {
            super(null);
            this.c = 0L;
        }

        public AccumHandler(java.io.PrintStream printStream) {
            super(printStream);
            this.c = 0L;
        }

        @Override // org.apache.tools.ant.taskdefs.Length.Handler
        public synchronized void c(org.apache.tools.ant.types.Resource resource) {
            long size = resource.getSize();
            if (size == -1) {
                org.apache.tools.ant.taskdefs.Length.this.log("Size unknown for " + resource.toString(), 1);
            } else {
                this.c += size;
            }
        }

        public long d() {
            return this.c;
        }
    }

    public class AllHandler extends org.apache.tools.ant.taskdefs.Length.AccumHandler {
        public AllHandler(java.io.PrintStream printStream) {
            super(printStream);
        }

        @Override // org.apache.tools.ant.taskdefs.Length.Handler
        public void a() {
            b().print(d());
            super.a();
        }
    }

    public class EachHandler extends org.apache.tools.ant.taskdefs.Length.Handler {
        public EachHandler(java.io.PrintStream printStream) {
            super(printStream);
        }

        @Override // org.apache.tools.ant.taskdefs.Length.Handler
        public void c(org.apache.tools.ant.types.Resource resource) {
            b().print(resource.toString());
            b().print(" : ");
            long size = resource.getSize();
            if (size == -1) {
                b().println("unknown");
            } else {
                b().println(size);
            }
        }
    }

    public static class FileMode extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {"each", "all"};

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }
    }

    public abstract class Handler {
        public java.io.PrintStream a;

        public Handler(java.io.PrintStream printStream) {
            this.a = printStream;
        }

        public void a() {
            org.apache.tools.ant.util.FileUtils.close(this.a);
        }

        public java.io.PrintStream b() {
            return this.a;
        }

        public abstract void c(org.apache.tools.ant.types.Resource resource);
    }

    public static class When extends org.apache.tools.ant.types.Comparison {
    }

    public static long c(java.lang.String str, boolean z) {
        if (z) {
            str = str.trim();
        }
        return str.length();
    }

    public synchronized void add(org.apache.tools.ant.types.FileSet fileSet) {
        add((org.apache.tools.ant.types.ResourceCollection) fileSet);
    }

    public synchronized void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null) {
            return;
        }
        org.apache.tools.ant.types.resources.Resources resources = this.A;
        if (resources == null) {
            resources = new org.apache.tools.ant.types.resources.Resources();
        }
        this.A = resources;
        resources.add(resourceCollection);
    }

    public final void d(org.apache.tools.ant.taskdefs.Length.Handler handler) {
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.A.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            if (!next.isExists()) {
                log(next + " does not exist", 1);
            }
            if (next.isDirectory()) {
                log(next + " is a directory; length may not be meaningful", 1);
            }
            handler.c(next);
        }
        handler.a();
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() {
        java.lang.Long l;
        validate();
        if (this.z == null) {
            throw new org.apache.tools.ant.BuildException("Use of the Length condition requires that the length attribute be set.");
        }
        if (com.anythink.expressad.foundation.h.i.g.equals(this.x)) {
            l = new java.lang.Long(c(this.v, getTrim()));
        } else {
            org.apache.tools.ant.taskdefs.Length.AccumHandler accumHandler = new org.apache.tools.ant.taskdefs.Length.AccumHandler();
            d(accumHandler);
            l = new java.lang.Long(accumHandler.d());
        }
        return this.y.evaluate(l.compareTo(this.z));
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        validate();
        java.io.PrintStream printStream = new java.io.PrintStream(this.u != null ? new org.apache.tools.ant.util.PropertyOutputStream(getProject(), this.u) : new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 2));
        if (com.anythink.expressad.foundation.h.i.g.equals(this.x)) {
            printStream.print(c(this.v, getTrim()));
            printStream.close();
        } else if ("each".equals(this.x)) {
            d(new org.apache.tools.ant.taskdefs.Length.EachHandler(printStream));
        } else if ("all".equals(this.x)) {
            d(new org.apache.tools.ant.taskdefs.Length.AllHandler(printStream));
        }
    }

    public boolean getTrim() {
        java.lang.Boolean bool = this.w;
        return bool != null && bool.booleanValue();
    }

    public synchronized void setFile(java.io.File file) {
        add(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public synchronized void setLength(long j) {
        this.z = new java.lang.Long(j);
    }

    public synchronized void setMode(org.apache.tools.ant.taskdefs.Length.FileMode fileMode) {
        this.x = fileMode.getValue();
    }

    public synchronized void setProperty(java.lang.String str) {
        this.u = str;
    }

    public synchronized void setResource(org.apache.tools.ant.types.Resource resource) {
        add(resource);
    }

    public synchronized void setString(java.lang.String str) {
        this.v = str;
        this.x = com.anythink.expressad.foundation.h.i.g;
    }

    public synchronized void setTrim(boolean z) {
        this.w = z ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE;
    }

    public synchronized void setWhen(org.apache.tools.ant.taskdefs.Length.When when) {
        setWhen((org.apache.tools.ant.types.Comparison) when);
    }

    public synchronized void setWhen(org.apache.tools.ant.types.Comparison comparison) {
        this.y = comparison;
    }

    public final void validate() {
        if (this.v != null) {
            if (this.A != null) {
                throw new org.apache.tools.ant.BuildException("the string length function is incompatible with the file/resource length function");
            }
            if (!com.anythink.expressad.foundation.h.i.g.equals(this.x)) {
                throw new org.apache.tools.ant.BuildException("the mode attribute is for use with the file/resource length function");
            }
            return;
        }
        if (this.A == null) {
            throw new org.apache.tools.ant.BuildException("you must set either the string attribute or specify one or more files using the file attribute or nested resource collections");
        }
        if ("each".equals(this.x) || "all".equals(this.x)) {
            if (this.w != null) {
                throw new org.apache.tools.ant.BuildException("the trim attribute is for use with the string length function only");
            }
        } else {
            throw new org.apache.tools.ant.BuildException("invalid mode setting for file/resource length function: \"" + this.x + "\"");
        }
    }
}

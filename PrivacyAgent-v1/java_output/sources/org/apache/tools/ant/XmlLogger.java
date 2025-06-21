package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class XmlLogger implements org.apache.tools.ant.BuildLogger {
    public static javax.xml.parsers.DocumentBuilder z = a();
    public java.io.PrintStream t;
    public int n = 4;
    public org.w3c.dom.Document u = z.newDocument();
    public java.util.Hashtable<org.apache.tools.ant.Task, org.apache.tools.ant.XmlLogger.TimedElement> v = new java.util.Hashtable<>();
    public java.util.Hashtable<org.apache.tools.ant.Target, org.apache.tools.ant.XmlLogger.TimedElement> w = new java.util.Hashtable<>();
    public java.util.Hashtable<java.lang.Thread, java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement>> x = new java.util.Hashtable<>();
    public org.apache.tools.ant.XmlLogger.TimedElement y = null;

    public static class TimedElement {
        public long a;
        public org.w3c.dom.Element b;

        public TimedElement() {
        }

        public /* synthetic */ TimedElement(org.apache.tools.ant.XmlLogger.AnonymousClass1 anonymousClass1) {
            this();
        }

        public java.lang.String toString() {
            return this.b.getTagName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.b.getAttribute("name");
        }
    }

    public static javax.xml.parsers.DocumentBuilder a() {
        try {
            return javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (java.lang.Exception e) {
            throw new java.lang.ExceptionInInitializerError(e);
        }
    }

    public final java.lang.String b(org.apache.tools.ant.BuildEvent buildEvent, java.lang.String str, java.lang.String str2) {
        return (buildEvent == null || buildEvent.getProject() == null || buildEvent.getProject().getProperty(str) == null) ? str2 : buildEvent.getProject().getProperty(str);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        java.io.OutputStreamWriter outputStreamWriter;
        this.y.b.setAttribute("time", org.apache.tools.ant.DefaultLogger.formatTime(java.lang.System.currentTimeMillis() - this.y.a));
        if (buildEvent.getException() != null) {
            this.y.b.setAttribute("error", buildEvent.getException().toString());
            org.w3c.dom.CDATASection createCDATASection = this.u.createCDATASection(org.apache.tools.ant.util.StringUtils.getStackTrace(buildEvent.getException()));
            org.w3c.dom.Element createElement = this.u.createElement("stacktrace");
            createElement.appendChild(createCDATASection);
            e(this.y.b, createElement);
        }
        java.lang.String b = b(buildEvent, "XmlLogger.file", "log.xml");
        java.lang.String b2 = b(buildEvent, "ant.XmlLogger.stylesheet.uri", "log.xsl");
        java.io.OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                java.io.OutputStream outputStream = this.t;
                if (outputStream == null) {
                    outputStream = new java.io.FileOutputStream(b);
                }
                outputStreamWriter = new java.io.OutputStreamWriter(outputStream, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            outputStreamWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            if (b2.length() > 0) {
                outputStreamWriter.write("<?xml-stylesheet type=\"text/xsl\" href=\"" + b2 + "\"?>\n\n");
            }
            new org.apache.tools.ant.util.DOMElementWriter().write(this.y.b, outputStreamWriter, 0, "\t");
            outputStreamWriter.flush();
            org.apache.tools.ant.util.FileUtils.close(outputStreamWriter);
            this.y = null;
        } catch (java.io.IOException e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException("Unable to write log file", e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            org.apache.tools.ant.util.FileUtils.close(outputStreamWriter2);
            throw th;
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void buildStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.XmlLogger.TimedElement timedElement = new org.apache.tools.ant.XmlLogger.TimedElement(null);
        this.y = timedElement;
        timedElement.a = java.lang.System.currentTimeMillis();
        this.y.b = this.u.createElement("build");
    }

    public final java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement> c() {
        java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement> stack = this.x.get(java.lang.Thread.currentThread());
        if (stack != null) {
            return stack;
        }
        java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement> stack2 = new java.util.Stack<>();
        this.x.put(java.lang.Thread.currentThread(), stack2);
        return stack2;
    }

    public final org.apache.tools.ant.XmlLogger.TimedElement d(org.apache.tools.ant.Task task) {
        org.apache.tools.ant.XmlLogger.TimedElement timedElement = this.v.get(task);
        if (timedElement != null) {
            return timedElement;
        }
        java.util.Enumeration<org.apache.tools.ant.Task> keys = this.v.keys();
        while (keys.hasMoreElements()) {
            org.apache.tools.ant.Task nextElement = keys.nextElement();
            if ((nextElement instanceof org.apache.tools.ant.UnknownElement) && ((org.apache.tools.ant.UnknownElement) nextElement).getTask() == task) {
                return this.v.get(nextElement);
            }
        }
        return null;
    }

    public final void e(org.w3c.dom.Node node, org.w3c.dom.Node node2) {
        synchronized (node) {
            node.appendChild(node2);
        }
    }

    @Override // org.apache.tools.ant.BuildListener
    public void messageLogged(org.apache.tools.ant.BuildEvent buildEvent) {
        int priority = buildEvent.getPriority();
        if (priority > this.n) {
            return;
        }
        org.w3c.dom.Element createElement = this.u.createElement("message");
        createElement.setAttribute("priority", priority != 0 ? priority != 1 ? priority != 2 ? "debug" : "info" : "warn" : "error");
        java.lang.Throwable exception = buildEvent.getException();
        if (4 <= this.n && exception != null) {
            org.w3c.dom.Node createCDATASection = this.u.createCDATASection(org.apache.tools.ant.util.StringUtils.getStackTrace(exception));
            org.w3c.dom.Node createElement2 = this.u.createElement("stacktrace");
            createElement2.appendChild(createCDATASection);
            e(this.y.b, createElement2);
        }
        createElement.appendChild(this.u.createCDATASection(buildEvent.getMessage()));
        org.apache.tools.ant.Task task = buildEvent.getTask();
        org.apache.tools.ant.Target target = buildEvent.getTarget();
        org.apache.tools.ant.XmlLogger.TimedElement d = task != null ? d(task) : null;
        if (d == null && target != null) {
            d = this.w.get(target);
        }
        if (d != null) {
            e(d.b, createElement);
        } else {
            e(this.y.b, createElement);
        }
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setEmacsMode(boolean z2) {
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setErrorPrintStream(java.io.PrintStream printStream) {
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setMessageOutputLevel(int i) {
        this.n = i;
    }

    @Override // org.apache.tools.ant.BuildLogger
    public void setOutputPrintStream(java.io.PrintStream printStream) {
        this.t = new java.io.PrintStream((java.io.OutputStream) printStream, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    @Override // org.apache.tools.ant.BuildListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void targetFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.XmlLogger.TimedElement timedElement;
        org.apache.tools.ant.Target target = buildEvent.getTarget();
        org.apache.tools.ant.XmlLogger.TimedElement timedElement2 = this.w.get(target);
        if (timedElement2 != null) {
            timedElement2.b.setAttribute("time", org.apache.tools.ant.DefaultLogger.formatTime(java.lang.System.currentTimeMillis() - timedElement2.a));
            java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement> c = c();
            if (!c.empty()) {
                org.apache.tools.ant.XmlLogger.TimedElement pop = c.pop();
                if (pop != timedElement2) {
                    throw new java.lang.RuntimeException("Mismatch - popped element = " + pop + " finished target element = " + timedElement2);
                }
                if (!c.empty()) {
                    timedElement = c.peek();
                    if (timedElement != null) {
                        e(this.y.b, timedElement2.b);
                    } else {
                        e(timedElement.b, timedElement2.b);
                    }
                }
            }
            timedElement = null;
            if (timedElement != null) {
            }
        }
        this.w.remove(target);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void targetStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.Target target = buildEvent.getTarget();
        org.apache.tools.ant.XmlLogger.TimedElement timedElement = new org.apache.tools.ant.XmlLogger.TimedElement(null);
        timedElement.a = java.lang.System.currentTimeMillis();
        timedElement.b = this.u.createElement(com.umeng.ccg.a.A);
        timedElement.b.setAttribute("name", target.getName());
        this.w.put(target, timedElement);
        c().push(timedElement);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskFinished(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.XmlLogger.TimedElement pop;
        org.apache.tools.ant.Task task = buildEvent.getTask();
        org.apache.tools.ant.XmlLogger.TimedElement timedElement = this.v.get(task);
        if (timedElement == null) {
            throw new java.lang.RuntimeException("Unknown task " + task + " not in " + this.v);
        }
        timedElement.b.setAttribute("time", org.apache.tools.ant.DefaultLogger.formatTime(java.lang.System.currentTimeMillis() - timedElement.a));
        org.apache.tools.ant.Target owningTarget = task.getOwningTarget();
        org.apache.tools.ant.XmlLogger.TimedElement timedElement2 = owningTarget != null ? this.w.get(owningTarget) : null;
        if (timedElement2 == null) {
            e(this.y.b, timedElement.b);
        } else {
            e(timedElement2.b, timedElement.b);
        }
        java.util.Stack<org.apache.tools.ant.XmlLogger.TimedElement> c = c();
        if (c.empty() || (pop = c.pop()) == timedElement) {
            this.v.remove(task);
            return;
        }
        throw new java.lang.RuntimeException("Mismatch - popped element = " + pop + " finished task element = " + timedElement);
    }

    @Override // org.apache.tools.ant.BuildListener
    public void taskStarted(org.apache.tools.ant.BuildEvent buildEvent) {
        org.apache.tools.ant.XmlLogger.TimedElement timedElement = new org.apache.tools.ant.XmlLogger.TimedElement(null);
        timedElement.a = java.lang.System.currentTimeMillis();
        timedElement.b = this.u.createElement("task");
        org.apache.tools.ant.Task task = buildEvent.getTask();
        java.lang.String taskName = buildEvent.getTask().getTaskName();
        if (taskName == null) {
            taskName = "";
        }
        timedElement.b.setAttribute("name", taskName);
        timedElement.b.setAttribute(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION, buildEvent.getTask().getLocation().toString());
        this.v.put(task, timedElement);
        c().push(timedElement);
    }
}

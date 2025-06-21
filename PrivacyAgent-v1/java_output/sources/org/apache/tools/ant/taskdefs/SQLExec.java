package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class SQLExec extends org.apache.tools.ant.taskdefs.JDBCTask {
    public org.apache.tools.ant.types.resources.Union K;
    public boolean c0;
    public int H = 0;
    public int I = 0;
    public java.sql.Connection J = null;
    public java.sql.Statement L = null;
    public java.io.File M = null;
    public java.lang.String N = "";
    public java.util.Vector O = new java.util.Vector();
    public java.lang.String P = com.alipay.sdk.m.u.i.b;
    public java.lang.String Q = "normal";
    public boolean R = false;
    public boolean S = true;
    public boolean T = true;
    public org.apache.tools.ant.types.Resource U = null;
    public java.lang.String V = null;
    public java.lang.String W = "abort";
    public java.lang.String X = null;
    public boolean Y = false;
    public boolean Z = false;
    public boolean a0 = true;
    public boolean b0 = true;
    public boolean d0 = true;
    public boolean e0 = false;
    public java.lang.String f0 = ",";
    public java.lang.String g0 = null;
    public boolean h0 = false;
    public java.lang.String i0 = null;
    public java.lang.String j0 = null;
    public java.lang.String k0 = null;
    public boolean l0 = false;

    public static class DelimiterType extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String NORMAL = "normal";
        public static final java.lang.String ROW = "row";

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"normal", "row"};
        }
    }

    public static class OnError extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"continue", "stop", "abort"};
        }
    }

    public class Transaction {
        public org.apache.tools.ant.types.Resource a = null;
        public java.lang.String b = "";

        public Transaction() {
        }

        public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
            if (resourceCollection.size() != 1) {
                throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported.");
            }
            setSrcResource(resourceCollection.iterator().next());
        }

        public void addText(java.lang.String str) {
            if (str != null) {
                this.b += str;
            }
        }

        public final void b(java.io.PrintStream printStream) throws java.io.IOException, java.sql.SQLException {
            java.io.InputStreamReader inputStreamReader;
            if (this.b.length() != 0) {
                org.apache.tools.ant.taskdefs.SQLExec.this.log("Executing commands", 2);
                org.apache.tools.ant.taskdefs.SQLExec.this.runStatements(new java.io.StringReader(this.b), printStream);
            }
            if (this.a == null) {
                return;
            }
            org.apache.tools.ant.taskdefs.SQLExec.this.log("Executing resource: " + this.a.toString(), 2);
            java.io.InputStream inputStream = null;
            java.io.InputStreamReader inputStreamReader2 = null;
            try {
                java.io.InputStream inputStream2 = this.a.getInputStream();
                try {
                    inputStreamReader2 = org.apache.tools.ant.taskdefs.SQLExec.this.X == null ? new java.io.InputStreamReader(inputStream2) : new java.io.InputStreamReader(inputStream2, org.apache.tools.ant.taskdefs.SQLExec.this.X);
                    org.apache.tools.ant.taskdefs.SQLExec.this.runStatements(inputStreamReader2, printStream);
                    org.apache.tools.ant.util.FileUtils.close(inputStream2);
                    org.apache.tools.ant.util.FileUtils.close(inputStreamReader2);
                } catch (java.lang.Throwable th) {
                    th = th;
                    inputStreamReader = inputStreamReader2;
                    inputStream = inputStream2;
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                    org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        }

        public void setSrc(java.io.File file) {
            if (file != null) {
                setSrcResource(new org.apache.tools.ant.types.resources.FileResource(file));
            }
        }

        public void setSrcResource(org.apache.tools.ant.types.Resource resource) {
            if (this.a != null) {
                throw new org.apache.tools.ant.BuildException("only one resource per transaction");
            }
            this.a = resource;
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null) {
            throw new org.apache.tools.ant.BuildException("Cannot add null ResourceCollection");
        }
        synchronized (this) {
            if (this.K == null) {
                this.K = new org.apache.tools.ant.types.resources.Union();
            }
        }
        this.K.add(resourceCollection);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public void addText(java.lang.String str) {
        this.N += str;
    }

    public org.apache.tools.ant.taskdefs.SQLExec.Transaction createTransaction() {
        org.apache.tools.ant.taskdefs.SQLExec.Transaction transaction = new org.apache.tools.ant.taskdefs.SQLExec.Transaction();
        this.O.addElement(transaction);
        return transaction;
    }

    public final void e() {
        if (isAutocommit() || getConnection() == null || !this.W.equals("abort")) {
            return;
        }
        try {
            getConnection().rollback();
        } catch (java.sql.SQLException unused) {
        }
    }

    public void execSQL(java.lang.String str, java.io.PrintStream printStream) throws java.sql.SQLException {
        if ("".equals(str.trim())) {
            return;
        }
        java.sql.ResultSet resultSet = null;
        try {
            try {
                this.I++;
                log("SQL: " + str, 3);
                boolean execute = getStatement().execute(str);
                int updateCount = getStatement().getUpdateCount();
                int i = 0;
                while (true) {
                    if (updateCount != -1) {
                        i += updateCount;
                    }
                    if (execute) {
                        resultSet = getStatement().getResultSet();
                        h(resultSet.getWarnings(), false);
                        resultSet.clearWarnings();
                        if (this.R) {
                            printResults(resultSet, printStream);
                        }
                    }
                    execute = getStatement().getMoreResults();
                    updateCount = getStatement().getUpdateCount();
                    if (!execute && updateCount == -1) {
                        break;
                    }
                }
                h(getStatement().getWarnings(), false);
                getStatement().clearWarnings();
                log(i + " rows affected", 3);
                if (i != -1) {
                    setRowCountProperty(i);
                }
                if (this.R && this.T) {
                    printStream.println(i + " rows affected");
                }
                h(getConnection().getWarnings(), true);
                getConnection().clearWarnings();
                this.H++;
                if (resultSet == null) {
                    return;
                }
            } catch (java.lang.Throwable th) {
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (java.sql.SQLException unused) {
                    }
                }
                throw th;
            }
        } catch (java.sql.SQLException e) {
            log("Failed to execute: " + str, 0);
            setErrorProperty();
            if (!this.W.equals("abort")) {
                log(e.toString(), 0);
            }
            if (!this.W.equals("continue")) {
                throw e;
            }
            if (resultSet == null) {
                return;
            }
        }
        try {
            resultSet.close();
        } catch (java.sql.SQLException unused2) {
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.sql.Connection connection;
        java.io.PrintStream wrapSystemOut;
        java.io.OutputStream appendOutputStream;
        org.apache.tools.ant.types.resources.Appendable appendable;
        java.util.Vector vector = (java.util.Vector) this.O.clone();
        java.lang.String str = this.N;
        java.lang.String trim = str.trim();
        this.N = trim;
        try {
            if (this.M == null && trim.length() == 0 && this.K == null && this.O.size() == 0) {
                throw new org.apache.tools.ant.BuildException("Source file or resource collection, transactions or sql statement must be set!", getLocation());
            }
            java.io.File file = this.M;
            if (file != null && !file.isFile()) {
                throw new org.apache.tools.ant.BuildException("Source file " + this.M + " is not a file!", getLocation());
            }
            org.apache.tools.ant.types.resources.Union union = this.K;
            if (union != null) {
                java.util.Iterator<org.apache.tools.ant.types.Resource> it = union.iterator();
                while (it.hasNext()) {
                    createTransaction().setSrcResource(it.next());
                }
            }
            org.apache.tools.ant.taskdefs.SQLExec.Transaction createTransaction = createTransaction();
            createTransaction.setSrc(this.M);
            createTransaction.addText(this.N);
            try {
                try {
                } catch (java.lang.Throwable th) {
                    try {
                        if (getStatement() != null) {
                            getStatement().close();
                        }
                    } catch (java.sql.SQLException unused) {
                    }
                    try {
                        if (getConnection() == null) {
                            throw th;
                        }
                        getConnection().close();
                        throw th;
                    } catch (java.sql.SQLException unused2) {
                        throw th;
                    }
                }
            } catch (java.sql.SQLException unused3) {
            }
            if (getConnection() == null) {
                return;
            }
            try {
                try {
                    wrapSystemOut = org.apache.tools.ant.util.KeepAliveOutputStream.wrapSystemOut();
                } catch (java.io.IOException e) {
                    e();
                    setErrorProperty();
                    if (this.W.equals("abort")) {
                        throw new org.apache.tools.ant.BuildException(e, getLocation());
                    }
                    try {
                        if (getStatement() != null) {
                            getStatement().close();
                        }
                    } catch (java.sql.SQLException unused4) {
                    }
                    if (getConnection() != null) {
                        connection = getConnection();
                    }
                }
            } catch (java.sql.SQLException e2) {
                e();
                setErrorProperty();
                if (this.W.equals("abort")) {
                    throw new org.apache.tools.ant.BuildException(e2, getLocation());
                }
                try {
                    if (getStatement() != null) {
                        getStatement().close();
                    }
                } catch (java.sql.SQLException unused5) {
                }
                if (getConnection() != null) {
                    connection = getConnection();
                }
            }
            try {
                if (this.U != null) {
                    log("Opening PrintStream to output Resource " + this.U, 3);
                    org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) this.U.as(org.apache.tools.ant.types.resources.FileProvider.class);
                    if (fileProvider != null) {
                        appendOutputStream = new java.io.FileOutputStream(fileProvider.getFile(), this.Y);
                    } else {
                        appendOutputStream = (!this.Y || (appendable = (org.apache.tools.ant.types.resources.Appendable) this.U.as(org.apache.tools.ant.types.resources.Appendable.class)) == null) ? null : appendable.getAppendOutputStream();
                        if (appendOutputStream == null) {
                            appendOutputStream = this.U.getOutputStream();
                            if (this.Y) {
                                log("Ignoring append=true for non-appendable resource " + this.U, 1);
                            }
                        }
                    }
                    wrapSystemOut = this.V != null ? new java.io.PrintStream((java.io.OutputStream) new java.io.BufferedOutputStream(appendOutputStream), false, this.V) : new java.io.PrintStream(new java.io.BufferedOutputStream(appendOutputStream));
                }
                java.util.Enumeration elements = this.O.elements();
                while (elements.hasMoreElements()) {
                    ((org.apache.tools.ant.taskdefs.SQLExec.Transaction) elements.nextElement()).b(wrapSystemOut);
                    if (!isAutocommit()) {
                        log("Committing transaction", 3);
                        getConnection().commit();
                    }
                }
                try {
                    if (getStatement() != null) {
                        getStatement().close();
                    }
                } catch (java.sql.SQLException unused6) {
                }
                if (getConnection() != null) {
                    connection = getConnection();
                    connection.close();
                }
                log(this.H + " of " + this.I + " SQL statements executed successfully");
            } finally {
                org.apache.tools.ant.util.FileUtils.close(wrapSystemOut);
            }
        } finally {
            this.O = vector;
            this.N = str;
        }
    }

    public final java.lang.String f(java.lang.String str) {
        if (this.g0 == null || str == null) {
            return str;
        }
        if (!this.l0 && !str.contains(this.f0) && !str.contains(this.g0)) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(this.g0);
        char charAt = this.g0.charAt(0);
        for (char c : str.toCharArray()) {
            if (c == charAt) {
                sb.append(charAt);
            }
            sb.append(c);
        }
        sb.append(this.g0);
        return sb.toString();
    }

    public final void g(java.sql.ResultSet resultSet, int i, java.io.PrintStream printStream) throws java.sql.SQLException {
        if (!this.c0 || resultSet.getMetaData().getColumnType(i) != 2004) {
            printStream.print(f(resultSet.getString(i)));
        } else if (resultSet.getBlob(i) != null) {
            new org.apache.tools.ant.taskdefs.StreamPumper(resultSet.getBlob(i).getBinaryStream(), printStream).run();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.JDBCTask
    public java.sql.Connection getConnection() {
        if (this.J == null) {
            java.sql.Connection connection = super.getConnection();
            this.J = connection;
            if (!isValidRdbms(connection)) {
                this.J = null;
            }
        }
        return this.J;
    }

    public boolean getExpandProperties() {
        return this.b0;
    }

    public java.sql.Statement getStatement() throws java.sql.SQLException {
        if (this.L == null) {
            java.sql.Statement createStatement = getConnection().createStatement();
            this.L = createStatement;
            createStatement.setEscapeProcessing(this.a0);
        }
        return this.L;
    }

    public final void h(java.sql.SQLWarning sQLWarning, boolean z) throws java.sql.SQLException {
        if (this.e0 || z) {
            for (java.sql.SQLWarning sQLWarning2 = sQLWarning; sQLWarning2 != null; sQLWarning2 = sQLWarning2.getNextWarning()) {
                log(sQLWarning2 + " sql warning", this.e0 ? 1 : 3);
            }
        }
        if (sQLWarning != null) {
            setWarningProperty();
        }
        if (this.h0 && sQLWarning != null) {
            throw sQLWarning;
        }
    }

    public int lastDelimiterPosition(java.lang.StringBuffer stringBuffer, java.lang.String str) {
        if (this.d0) {
            if ((this.Q.equals("normal") && org.apache.tools.ant.util.StringUtils.endsWith(stringBuffer, this.P)) || (this.Q.equals("row") && str.equals(this.P))) {
                return stringBuffer.length() - this.P.length();
            }
            return -1;
        }
        java.lang.String trim = this.P.trim();
        java.util.Locale locale = java.util.Locale.ENGLISH;
        java.lang.String lowerCase = trim.toLowerCase(locale);
        if (!this.Q.equals("normal")) {
            if (str.trim().toLowerCase(locale).equals(lowerCase)) {
                return stringBuffer.length() - str.length();
            }
            return -1;
        }
        int length = this.P.length() - 1;
        int length2 = stringBuffer.length() - 1;
        while (length2 >= 0 && java.lang.Character.isWhitespace(stringBuffer.charAt(length2))) {
            length2--;
        }
        if (length2 < length) {
            return -1;
        }
        while (length >= 0) {
            if (stringBuffer.substring(length2, length2 + 1).toLowerCase(java.util.Locale.ENGLISH).charAt(0) != lowerCase.charAt(length)) {
                return -1;
            }
            length2--;
            length--;
        }
        return length2 + 1;
    }

    @java.lang.Deprecated
    public void printResults(java.io.PrintStream printStream) throws java.sql.SQLException {
        java.sql.ResultSet resultSet = getStatement().getResultSet();
        try {
            printResults(resultSet, printStream);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void printResults(java.sql.ResultSet resultSet, java.io.PrintStream printStream) throws java.sql.SQLException {
        if (resultSet != null) {
            log("Processing new result set.", 3);
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (columnCount > 0) {
                if (this.S) {
                    printStream.print(f(metaData.getColumnName(1)));
                    for (int i = 2; i <= columnCount; i++) {
                        printStream.print(this.f0);
                        printStream.print(f(metaData.getColumnName(i)));
                    }
                    printStream.println();
                }
                while (resultSet.next()) {
                    g(resultSet, 1, printStream);
                    for (int i2 = 2; i2 <= columnCount; i2++) {
                        printStream.print(this.f0);
                        g(resultSet, i2, printStream);
                    }
                    printStream.println();
                    h(resultSet.getWarnings(), false);
                }
            }
        }
        printStream.println();
    }

    public void runStatements(java.io.Reader reader, java.io.PrintStream printStream) throws java.sql.SQLException, java.io.IOException {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(reader);
        while (true) {
            java.lang.String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            if (!this.Z) {
                readLine = readLine.trim();
            }
            if (this.b0) {
                readLine = getProject().replaceProperties(readLine);
            }
            if (!this.Z) {
                if (!readLine.startsWith("//") && !readLine.startsWith("--")) {
                    java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(readLine);
                    if (stringTokenizer.hasMoreTokens() && "REM".equalsIgnoreCase(stringTokenizer.nextToken())) {
                    }
                }
            }
            stringBuffer.append(this.Z ? "\n" : " ");
            stringBuffer.append(readLine);
            if (!this.Z && readLine.contains("--")) {
                stringBuffer.append("\n");
            }
            int lastDelimiterPosition = lastDelimiterPosition(stringBuffer, readLine);
            if (lastDelimiterPosition > -1) {
                execSQL(stringBuffer.substring(0, lastDelimiterPosition), printStream);
                stringBuffer.replace(0, stringBuffer.length(), "");
            }
        }
        if (stringBuffer.length() > 0) {
            execSQL(stringBuffer.toString(), printStream);
        }
    }

    public void setAppend(boolean z) {
        this.Y = z;
    }

    public void setCsvColumnSeparator(java.lang.String str) {
        this.f0 = str;
    }

    public void setCsvQuoteCharacter(java.lang.String str) {
        if (str != null && str.length() > 1) {
            throw new org.apache.tools.ant.BuildException("The quote character must be a single character.");
        }
        this.g0 = str;
    }

    public void setDelimiter(java.lang.String str) {
        this.P = str;
    }

    public void setDelimiterType(org.apache.tools.ant.taskdefs.SQLExec.DelimiterType delimiterType) {
        this.Q = delimiterType.getValue();
    }

    public void setEncoding(java.lang.String str) {
        this.X = str;
    }

    public final void setErrorProperty() {
        setProperty(this.i0, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
    }

    public void setErrorProperty(java.lang.String str) {
        this.i0 = str;
    }

    public void setEscapeProcessing(boolean z) {
        this.a0 = z;
    }

    public void setExpandProperties(boolean z) {
        this.b0 = z;
    }

    public void setForceCsvQuoteChar(boolean z) {
        this.l0 = z;
    }

    public void setKeepformat(boolean z) {
        this.Z = z;
    }

    public void setOnerror(org.apache.tools.ant.taskdefs.SQLExec.OnError onError) {
        this.W = onError.getValue();
    }

    public void setOutput(java.io.File file) {
        setOutput(new org.apache.tools.ant.types.resources.FileResource(getProject(), file));
    }

    public void setOutput(org.apache.tools.ant.types.Resource resource) {
        this.U = resource;
    }

    public void setOutputEncoding(java.lang.String str) {
        this.V = str;
    }

    public void setPrint(boolean z) {
        this.R = z;
    }

    public final void setProperty(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            getProject().setNewProperty(str, str2);
        }
    }

    public void setRawBlobs(boolean z) {
        this.c0 = z;
    }

    public final void setRowCountProperty(int i) {
        setProperty(this.k0, java.lang.Integer.toString(i));
    }

    public void setRowCountProperty(java.lang.String str) {
        this.k0 = str;
    }

    public void setShowWarnings(boolean z) {
        this.e0 = z;
    }

    public void setShowheaders(boolean z) {
        this.S = z;
    }

    public void setShowtrailers(boolean z) {
        this.T = z;
    }

    public void setSrc(java.io.File file) {
        this.M = file;
    }

    public void setStrictDelimiterMatching(boolean z) {
        this.d0 = z;
    }

    public void setTreatWarningsAsErrors(boolean z) {
        this.h0 = z;
    }

    public final void setWarningProperty() {
        setProperty(this.j0, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
    }

    public void setWarningProperty(java.lang.String str) {
        this.j0 = str;
    }
}

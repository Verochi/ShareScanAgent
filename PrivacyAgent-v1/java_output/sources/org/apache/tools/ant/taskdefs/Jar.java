package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Jar extends org.apache.tools.ant.taskdefs.Zip {
    public static final org.apache.tools.zip.ZipExtraField[] q0 = {org.apache.tools.zip.JarMarker.getInstance()};
    public org.apache.tools.ant.taskdefs.Manifest Z;
    public org.apache.tools.ant.taskdefs.Manifest a0;
    public org.apache.tools.ant.taskdefs.Manifest b0;
    public org.apache.tools.ant.taskdefs.Manifest c0;
    public org.apache.tools.ant.taskdefs.Jar.FilesetManifestConfig d0;
    public org.apache.tools.ant.taskdefs.Manifest f0;
    public java.lang.String g0;
    public java.io.File h0;
    public java.util.Vector<java.lang.String> l0;
    public org.apache.tools.ant.types.Path m0;
    public java.util.List<org.apache.tools.ant.types.spi.Service> Y = new java.util.ArrayList();
    public boolean e0 = true;
    public boolean i0 = false;
    public boolean j0 = false;
    public boolean k0 = false;
    public org.apache.tools.ant.taskdefs.Jar.StrictMode n0 = new org.apache.tools.ant.taskdefs.Jar.StrictMode(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
    public boolean o0 = false;
    public boolean p0 = false;

    /* renamed from: org.apache.tools.ant.taskdefs.Jar$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.Comparator<java.lang.Object> {
        @Override // java.util.Comparator
        public int compare(java.lang.Object obj, java.lang.Object obj2) {
            if ((obj instanceof java.lang.String) && (obj2 instanceof java.lang.String)) {
                return ((java.lang.String) obj2).length() - ((java.lang.String) obj).length();
            }
            return 0;
        }
    }

    public static class FilesetManifestConfig extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP, "merge", "mergewithoutmain"};
        }
    }

    public static class StrictMode extends org.apache.tools.ant.types.EnumeratedAttribute {
        public StrictMode() {
        }

        public StrictMode(java.lang.String str) {
            setValue(str);
        }

        public int getLogLevel() {
            return getValue().equals(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE) ? 3 : 1;
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"fail", "warn", org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE};
        }
    }

    public Jar() {
        this.archiveType = "jar";
        this.emptyBehavior = "create";
        setEncoding(net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8);
        setZip64Mode(org.apache.tools.ant.taskdefs.Zip.Zip64ModeAttribute.NEVER);
        this.l0 = new java.util.Vector<>();
    }

    public static java.lang.String findJarName(java.lang.String str, java.lang.String[] strArr) {
        if (strArr == null) {
            return new java.io.File(str).getName();
        }
        java.lang.String replace = str.replace(java.io.File.separatorChar, '/');
        java.util.TreeMap treeMap = new java.util.TreeMap(new org.apache.tools.ant.taskdefs.Jar.AnonymousClass1());
        for (int i = 0; i < strArr.length; i++) {
            if (replace.endsWith(strArr[i])) {
                java.lang.String str2 = strArr[i];
                treeMap.put(str2, str2);
            } else {
                int indexOf = strArr[i].indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                java.lang.String str3 = strArr[i];
                while (true) {
                    if (indexOf > -1) {
                        str3 = str3.substring(indexOf + 1);
                        if (replace.endsWith(str3)) {
                            treeMap.put(str3, strArr[i]);
                            break;
                        }
                        indexOf = str3.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    }
                }
            }
        }
        if (treeMap.size() == 0) {
            return null;
        }
        return (java.lang.String) treeMap.get(treeMap.firstKey());
    }

    public static void grabFilesAndDirs(java.lang.String str, java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2) throws java.io.IOException {
        org.apache.tools.zip.ZipFile zipFile;
        org.apache.tools.zip.ZipFile zipFile2 = null;
        try {
            zipFile = new org.apache.tools.zip.ZipFile(str, "utf-8");
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.util.Enumeration<org.apache.tools.zip.ZipEntry> entries = zipFile.getEntries();
            java.util.HashSet hashSet = new java.util.HashSet();
            while (entries.hasMoreElements()) {
                org.apache.tools.zip.ZipEntry nextElement = entries.nextElement();
                java.lang.String name = nextElement.getName();
                if (nextElement.isDirectory()) {
                    hashSet.add(name);
                } else if (name.indexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) == -1) {
                    list2.add(name);
                } else {
                    hashSet.add(name.substring(0, name.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1));
                }
            }
            list.addAll(hashSet);
            zipFile.close();
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
    }

    public void addConfiguredIndexJars(org.apache.tools.ant.types.Path path) {
        if (this.m0 == null) {
            this.m0 = new org.apache.tools.ant.types.Path(getProject());
        }
        this.m0.append(path);
    }

    public void addConfiguredManifest(org.apache.tools.ant.taskdefs.Manifest manifest) throws org.apache.tools.ant.taskdefs.ManifestException {
        org.apache.tools.ant.taskdefs.Manifest manifest2 = this.Z;
        if (manifest2 == null) {
            this.Z = manifest;
        } else {
            manifest2.merge(manifest, false, this.o0);
        }
        this.a0 = this.Z;
    }

    public void addConfiguredService(org.apache.tools.ant.types.spi.Service service) {
        service.check();
        this.Y.add(service);
    }

    public void addMetainf(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        zipFileSet.setPrefix("META-INF/");
        super.addFileset(zipFileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void cleanUp() {
        super.cleanUp();
        o();
        if (!this.doubleFilePass || !this.skipWriting) {
            this.f0 = null;
            this.Z = this.a0;
            this.b0 = null;
            this.c0 = null;
        }
        this.l0.removeAllElements();
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public boolean createEmptyZip(java.io.File file) throws org.apache.tools.ant.BuildException {
        org.apache.tools.zip.ZipOutputStream zipOutputStream;
        if (!this.k0) {
            return true;
        }
        if (this.emptyBehavior.equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
            if (!this.skipWriting) {
                log("Warning: skipping " + this.archiveType + " archive " + file + " because no files were included.", 1);
            }
            return true;
        }
        if (this.emptyBehavior.equals("fail")) {
            throw new org.apache.tools.ant.BuildException("Cannot create " + this.archiveType + " archive " + file + ": no files were included.", getLocation());
        }
        org.apache.tools.zip.ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                if (!this.skipWriting) {
                    log("Building MANIFEST-only jar: " + getDestFile().getAbsolutePath());
                }
                zipOutputStream = new org.apache.tools.zip.ZipOutputStream(getDestFile());
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            zipOutputStream.setEncoding(getEncoding());
            zipOutputStream.setUseZip64(getZip64Mode().getMode());
            if (isCompress()) {
                zipOutputStream.setMethod(8);
            } else {
                zipOutputStream.setMethod(0);
            }
            initZipOutputStream(zipOutputStream);
            finalizeZipOutputStream(zipOutputStream);
            org.apache.tools.ant.util.FileUtils.close(zipOutputStream);
            this.k0 = false;
            return true;
        } catch (java.io.IOException e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException("Could not create almost empty JAR archive (" + e.getMessage() + ")", e, getLocation());
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            org.apache.tools.ant.util.FileUtils.close(zipOutputStream2);
            this.k0 = false;
            throw th;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void finalizeZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
        if (this.i0) {
            p(zipOutputStream);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public org.apache.tools.ant.taskdefs.Zip.ArchiveState getResourcesToAdd(org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr, java.io.File file, boolean z) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Manifest u;
        boolean z2 = true;
        if (this.skipWriting) {
            org.apache.tools.ant.types.Resource[][] v = v(resourceCollectionArr);
            int i = 0;
            for (org.apache.tools.ant.types.Resource[] resourceArr : v) {
                i += resourceArr.length;
            }
            log("found a total of " + i + " manifests in " + v.length + " resource collections", 3);
            return new org.apache.tools.ant.taskdefs.Zip.ArchiveState(true, v);
        }
        if (file.exists()) {
            try {
                u = u(file);
                this.c0 = u;
            } catch (java.lang.Throwable th) {
                log("error while reading original manifest in file: " + file.toString() + " due to " + th.getMessage(), 1);
            }
            if (u != null) {
                if (!q().equals(this.c0)) {
                    log("Updating jar since jar manifest has changed", 3);
                }
                this.k0 = z;
                if (z && this.i0) {
                    try {
                        z2 = true ^ w(file);
                    } catch (java.io.IOException unused) {
                    }
                } else {
                    z2 = z;
                }
                return super.getResourcesToAdd(resourceCollectionArr, file, z2);
            }
            log("Updating jar since the current jar has no manifest", 3);
        }
        z = true;
        this.k0 = z;
        if (z) {
        }
        z2 = z;
        return super.getResourcesToAdd(resourceCollectionArr, file, z2);
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void initZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
        if (this.skipWriting) {
            return;
        }
        x(zipOutputStream, q());
        y(zipOutputStream);
    }

    public final void o() {
        java.lang.String property = java.lang.System.getProperty("line.separator");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        org.apache.tools.ant.taskdefs.Manifest manifest = this.Z;
        org.apache.tools.ant.taskdefs.Manifest.Section mainSection = manifest == null ? null : manifest.getMainSection();
        if (mainSection == null) {
            stringBuffer.append("No Implementation-Title set.");
            stringBuffer.append("No Implementation-Version set.");
            stringBuffer.append("No Implementation-Vendor set.");
        } else {
            if (mainSection.getAttribute("Implementation-Title") == null) {
                stringBuffer.append("No Implementation-Title set.");
            }
            if (mainSection.getAttribute("Implementation-Version") == null) {
                stringBuffer.append("No Implementation-Version set.");
            }
            if (mainSection.getAttribute("Implementation-Vendor") == null) {
                stringBuffer.append("No Implementation-Vendor set.");
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append(property);
            stringBuffer.append("Location: ");
            stringBuffer.append(getLocation());
            stringBuffer.append(property);
            if (this.n0.getValue().equalsIgnoreCase("fail")) {
                throw new org.apache.tools.ant.BuildException(stringBuffer.toString(), getLocation());
            }
            logWhenWriting(stringBuffer.toString(), this.n0.getLogLevel());
        }
    }

    public final void p(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        java.lang.String[] strArr;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(byteArrayOutputStream, net.lingala.zip4j.util.InternalZipConstants.CHARSET_UTF8));
        printWriter.println("JarIndex-Version: 1.0");
        printWriter.println();
        printWriter.println(this.zipFile.getName());
        writeIndexLikeList(new java.util.ArrayList<>(this.addedDirs.keySet()), this.l0, printWriter);
        printWriter.println();
        if (this.m0 != null) {
            org.apache.tools.ant.taskdefs.Manifest.Attribute attribute = q().getMainSection().getAttribute(org.apache.tools.ant.taskdefs.Manifest.ATTRIBUTE_CLASSPATH);
            if (attribute == null || attribute.getValue() == null) {
                strArr = null;
            } else {
                java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(attribute.getValue(), " ");
                strArr = new java.lang.String[stringTokenizer.countTokens()];
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    strArr[i] = stringTokenizer.nextToken();
                    i++;
                }
            }
            for (java.lang.String str : this.m0.list()) {
                java.lang.String findJarName = findJarName(str, strArr);
                if (findJarName != null) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    java.util.ArrayList arrayList2 = new java.util.ArrayList();
                    grabFilesAndDirs(str, arrayList, arrayList2);
                    if (arrayList.size() + arrayList2.size() > 0) {
                        printWriter.println(findJarName);
                        writeIndexLikeList(arrayList, arrayList2, printWriter);
                        printWriter.println();
                    }
                }
            }
        }
        if (printWriter.checkError()) {
            throw new java.io.IOException("Encountered an error writing jar index");
        }
        printWriter.close();
        java.io.InputStream byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            super.zipFile(byteArrayInputStream, zipOutputStream, "META-INF/INDEX.LIST", java.lang.System.currentTimeMillis(), null, 33188);
        } finally {
            org.apache.tools.ant.util.FileUtils.close(byteArrayInputStream);
        }
    }

    public final org.apache.tools.ant.taskdefs.Manifest q() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Manifest defaultManifest;
        java.io.File file;
        try {
            if (this.f0 == null && (file = this.h0) != null) {
                this.f0 = s(file);
            }
            boolean z = true;
            boolean z2 = !this.e0 && this.b0 != null && this.Z == null && this.f0 == null;
            if (z2) {
                defaultManifest = new org.apache.tools.ant.taskdefs.Manifest();
                defaultManifest.merge(this.b0, false, this.o0);
                defaultManifest.merge(org.apache.tools.ant.taskdefs.Manifest.getDefaultManifest(), true, this.o0);
            } else {
                defaultManifest = org.apache.tools.ant.taskdefs.Manifest.getDefaultManifest();
            }
            if (isInUpdateMode()) {
                defaultManifest.merge(this.c0, false, this.o0);
            }
            if (!z2) {
                defaultManifest.merge(this.b0, false, this.o0);
            }
            defaultManifest.merge(this.Z, !this.e0, this.o0);
            org.apache.tools.ant.taskdefs.Manifest manifest = this.f0;
            if (this.e0) {
                z = false;
            }
            defaultManifest.merge(manifest, z, this.o0);
            return defaultManifest;
        } catch (org.apache.tools.ant.taskdefs.ManifestException e) {
            log("Manifest is invalid: " + e.getMessage(), 0);
            throw new org.apache.tools.ant.BuildException("Invalid Manifest", e, getLocation());
        }
    }

    public final void r(java.io.File file, java.io.InputStream inputStream) throws java.io.IOException {
        org.apache.tools.ant.taskdefs.Manifest s2;
        java.io.File file2 = this.h0;
        if (file2 != null && file2.equals(file)) {
            log("Found manifest " + file, 3);
            try {
                if (inputStream != null) {
                    this.f0 = t(this.g0 == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, this.g0));
                    return;
                } else {
                    this.f0 = s(file);
                    return;
                }
            } catch (java.io.UnsupportedEncodingException e) {
                throw new org.apache.tools.ant.BuildException("Unsupported encoding while reading manifest: " + e.getMessage(), e);
            }
        }
        org.apache.tools.ant.taskdefs.Jar.FilesetManifestConfig filesetManifestConfig = this.d0;
        if (filesetManifestConfig == null || filesetManifestConfig.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
            return;
        }
        logWhenWriting("Found manifest to merge in file " + file, 3);
        try {
            if (inputStream != null) {
                s2 = t(this.g0 == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, this.g0));
            } else {
                s2 = s(file);
            }
            org.apache.tools.ant.taskdefs.Manifest manifest = this.b0;
            if (manifest == null) {
                this.b0 = s2;
            } else {
                manifest.merge(s2, false, this.o0);
            }
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new org.apache.tools.ant.BuildException("Unsupported encoding while reading manifest: " + e2.getMessage(), e2);
        } catch (org.apache.tools.ant.taskdefs.ManifestException e3) {
            log("Manifest in file " + file + " is invalid: " + e3.getMessage(), 0);
            throw new org.apache.tools.ant.BuildException("Invalid Manifest", e3, getLocation());
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void reset() {
        super.reset();
        this.emptyBehavior = "create";
        this.Z = null;
        this.d0 = null;
        this.e0 = false;
        this.h0 = null;
        this.i0 = false;
    }

    public final org.apache.tools.ant.taskdefs.Manifest s(java.io.File file) {
        java.io.InputStreamReader inputStreamReader = null;
        try {
            try {
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    inputStreamReader = this.g0 == null ? new java.io.InputStreamReader(fileInputStream) : new java.io.InputStreamReader(fileInputStream, this.g0);
                    return t(inputStreamReader);
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException("Unable to read manifest file: " + file + " (" + e.getMessage() + ")", e);
                }
            } catch (java.io.UnsupportedEncodingException e2) {
                throw new org.apache.tools.ant.BuildException("Unsupported encoding while reading manifest: " + e2.getMessage(), e2);
            }
        } finally {
            org.apache.tools.ant.util.FileUtils.close(inputStreamReader);
        }
    }

    public void setFilesetmanifest(org.apache.tools.ant.taskdefs.Jar.FilesetManifestConfig filesetManifestConfig) {
        this.d0 = filesetManifestConfig;
        this.e0 = filesetManifestConfig != null && "merge".equals(filesetManifestConfig.getValue());
        org.apache.tools.ant.taskdefs.Jar.FilesetManifestConfig filesetManifestConfig2 = this.d0;
        if (filesetManifestConfig2 == null || filesetManifestConfig2.getValue().equals(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_SKIP)) {
            return;
        }
        this.doubleFilePass = true;
    }

    public void setFlattenAttributes(boolean z) {
        this.p0 = z;
    }

    public void setIndex(boolean z) {
        this.i0 = z;
    }

    public void setIndexMetaInf(boolean z) {
        this.j0 = z;
    }

    public void setJarfile(java.io.File file) {
        setDestFile(file);
    }

    public void setManifest(java.io.File file) {
        if (file.exists()) {
            this.h0 = file;
            return;
        }
        throw new org.apache.tools.ant.BuildException("Manifest file: " + file + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX, getLocation());
    }

    public void setManifestEncoding(java.lang.String str) {
        this.g0 = str;
    }

    public void setMergeClassPathAttributes(boolean z) {
        this.o0 = z;
    }

    public void setStrict(org.apache.tools.ant.taskdefs.Jar.StrictMode strictMode) {
        this.n0 = strictMode;
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void setWhenempty(org.apache.tools.ant.taskdefs.Zip.WhenEmpty whenEmpty) {
        log("JARs are never empty, they contain at least a manifest file", 1);
    }

    public void setWhenmanifestonly(org.apache.tools.ant.taskdefs.Zip.WhenEmpty whenEmpty) {
        this.emptyBehavior = whenEmpty.getValue();
    }

    public final org.apache.tools.ant.taskdefs.Manifest t(java.io.Reader reader) {
        try {
            return new org.apache.tools.ant.taskdefs.Manifest(reader);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Unable to read manifest file (" + e.getMessage() + ")", e);
        } catch (org.apache.tools.ant.taskdefs.ManifestException e2) {
            log("Manifest is invalid: " + e2.getMessage(), 0);
            throw new org.apache.tools.ant.BuildException("Invalid Manifest: " + this.h0, e2, getLocation());
        }
    }

    public final org.apache.tools.ant.taskdefs.Manifest u(java.io.File file) throws java.io.IOException {
        java.util.zip.ZipFile zipFile = null;
        try {
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    java.util.zip.ZipEntry nextElement = entries.nextElement();
                    if (nextElement.getName().equalsIgnoreCase("META-INF/MANIFEST.MF")) {
                        org.apache.tools.ant.taskdefs.Manifest t = t(new java.io.InputStreamReader(zipFile2.getInputStream(nextElement), "UTF-8"));
                        try {
                            zipFile2.close();
                        } catch (java.io.IOException unused) {
                        }
                        return t;
                    }
                }
                try {
                    zipFile2.close();
                } catch (java.io.IOException unused2) {
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final org.apache.tools.ant.types.Resource[][] v(org.apache.tools.ant.types.ResourceCollection[] resourceCollectionArr) {
        org.apache.tools.ant.types.Resource[][] resourceArr = new org.apache.tools.ant.types.Resource[resourceCollectionArr.length][];
        for (int i = 0; i < resourceCollectionArr.length; i++) {
            org.apache.tools.ant.types.ResourceCollection resourceCollection = resourceCollectionArr[i];
            org.apache.tools.ant.types.Resource[][] grabResources = resourceCollection instanceof org.apache.tools.ant.types.FileSet ? grabResources(new org.apache.tools.ant.types.FileSet[]{(org.apache.tools.ant.types.FileSet) resourceCollection}) : grabNonFileSetResources(new org.apache.tools.ant.types.ResourceCollection[]{resourceCollection});
            int i2 = 0;
            while (true) {
                org.apache.tools.ant.types.Resource[] resourceArr2 = grabResources[0];
                if (i2 >= resourceArr2.length) {
                    break;
                }
                java.lang.String replace = resourceArr2[i2].getName().replace('\\', '/');
                org.apache.tools.ant.types.ResourceCollection resourceCollection2 = resourceCollectionArr[i];
                if (resourceCollection2 instanceof org.apache.tools.ant.types.ArchiveFileSet) {
                    org.apache.tools.ant.types.ArchiveFileSet archiveFileSet = (org.apache.tools.ant.types.ArchiveFileSet) resourceCollection2;
                    if (!"".equals(archiveFileSet.getFullpath(getProject()))) {
                        replace = archiveFileSet.getFullpath(getProject());
                    } else if (!"".equals(archiveFileSet.getPrefix(getProject()))) {
                        java.lang.String prefix = archiveFileSet.getPrefix(getProject());
                        if (!prefix.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) && !prefix.endsWith("\\")) {
                            prefix = prefix + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
                        }
                        replace = prefix + replace;
                    }
                }
                if (replace.equalsIgnoreCase("META-INF/MANIFEST.MF")) {
                    resourceArr[i] = new org.apache.tools.ant.types.Resource[]{grabResources[0][i2]};
                    break;
                }
                i2++;
            }
            if (resourceArr[i] == null) {
                resourceArr[i] = new org.apache.tools.ant.types.Resource[0];
            }
        }
        return resourceArr;
    }

    public final boolean w(java.io.File file) throws java.io.IOException {
        java.util.zip.ZipFile zipFile = null;
        try {
            java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    if (entries.nextElement().getName().equalsIgnoreCase("META-INF/INDEX.LIST")) {
                        try {
                            zipFile2.close();
                            return true;
                        } catch (java.io.IOException unused) {
                            return true;
                        }
                    }
                }
                try {
                    zipFile2.close();
                    return false;
                } catch (java.io.IOException unused2) {
                    return false;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final void writeIndexLikeList(java.util.List<java.lang.String> list, java.util.List<java.lang.String> list2, java.io.PrintWriter printWriter) {
        java.util.Collections.sort(list);
        java.util.Collections.sort(list2);
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            java.lang.String replace = it.next().replace('\\', '/');
            if (replace.startsWith("./")) {
                replace = replace.substring(2);
            }
            while (replace.startsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                replace = replace.substring(1);
            }
            int lastIndexOf = replace.lastIndexOf(47);
            if (lastIndexOf != -1) {
                replace = replace.substring(0, lastIndexOf);
            }
            if (this.j0 || !replace.startsWith("META-INF")) {
                printWriter.println(replace);
            }
        }
        java.util.Iterator<java.lang.String> it2 = list2.iterator();
        while (it2.hasNext()) {
            printWriter.println(it2.next());
        }
    }

    public final void x(org.apache.tools.zip.ZipOutputStream zipOutputStream, org.apache.tools.ant.taskdefs.Manifest manifest) throws java.io.IOException {
        java.util.Iterator it = java.util.Collections.list(manifest.getWarnings()).iterator();
        while (it.hasNext()) {
            log("Manifest warning: " + ((java.lang.String) it.next()), 1);
        }
        zipDir((org.apache.tools.ant.types.Resource) null, zipOutputStream, "META-INF/", 16877, q0);
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(byteArrayOutputStream, "UTF-8"));
        manifest.write(printWriter, this.p0);
        if (printWriter.checkError()) {
            throw new java.io.IOException("Encountered an error writing the manifest");
        }
        printWriter.close();
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            super.zipFile(byteArrayInputStream, zipOutputStream, "META-INF/MANIFEST.MF", java.lang.System.currentTimeMillis(), null, 33188);
            org.apache.tools.ant.util.FileUtils.close(byteArrayInputStream);
            super.initZipOutputStream(zipOutputStream);
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close(byteArrayInputStream);
            throw th;
        }
    }

    public final void y(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        java.io.InputStream inputStream;
        for (org.apache.tools.ant.types.spi.Service service : this.Y) {
            try {
                inputStream = service.getAsStream();
                try {
                    super.zipFile(inputStream, zipOutputStream, "META-INF/services/" + service.getType(), java.lang.System.currentTimeMillis(), null, 33188);
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                } catch (java.lang.Throwable th) {
                    th = th;
                    org.apache.tools.ant.util.FileUtils.close(inputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = null;
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void zipFile(java.io.InputStream inputStream, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, long j, java.io.File file, int i) throws java.io.IOException {
        if ("META-INF/MANIFEST.MF".equalsIgnoreCase(str)) {
            if (isFirstPass()) {
                r(file, inputStream);
            }
        } else {
            if (!"META-INF/INDEX.LIST".equalsIgnoreCase(str) || !this.i0) {
                if (this.i0 && !str.contains(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    this.l0.addElement(str);
                }
                super.zipFile(inputStream, zipOutputStream, str, j, file, i);
                return;
            }
            logWhenWriting("Warning: selected " + this.archiveType + " files include a META-INF/INDEX.LIST which will be replaced by a newly generated one.", 1);
        }
    }
}

package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Elf64Header extends com.getkeepsafe.relinker.elf.Elf.Header {
    public final com.getkeepsafe.relinker.elf.ElfParser a;

    public Elf64Header(boolean z, com.getkeepsafe.relinker.elf.ElfParser elfParser) throws java.io.IOException {
        this.bigEndian = z;
        this.a = elfParser;
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(z ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        this.type = elfParser.readHalf(allocate, 16L);
        this.phoff = elfParser.readLong(allocate, 32L);
        this.shoff = elfParser.readLong(allocate, 40L);
        this.phentsize = elfParser.readHalf(allocate, 54L);
        this.phnum = elfParser.readHalf(allocate, 56L);
        this.shentsize = elfParser.readHalf(allocate, 58L);
        this.shnum = elfParser.readHalf(allocate, 60L);
        this.shstrndx = elfParser.readHalf(allocate, 62L);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.DynamicStructure getDynamicStructure(long j, int i) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Dynamic64Structure(this.a, this, j, i);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.ProgramHeader getProgramHeader(long j) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Program64Header(this.a, this, j);
    }

    @Override // com.getkeepsafe.relinker.elf.Elf.Header
    public com.getkeepsafe.relinker.elf.Elf.SectionHeader getSectionHeader(int i) throws java.io.IOException {
        return new com.getkeepsafe.relinker.elf.Section64Header(this.a, this, i);
    }
}

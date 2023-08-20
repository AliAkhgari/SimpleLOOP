.class public Main
.super java/lang/Object
.method public static main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		new Main
		invokespecial Main/<init>()V
		return
.end method
.method public <init>()V
		.limit stack 128
		.limit locals 128
		aload 0
		invokespecial java/lang/Object/<init>()V
		new Array
		dup
		new java/util/ArrayList
		dup
		invokespecial java/util/ArrayList/<init>()V
		new Array
		dup
		ldc 10
		
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokespecial Array/<init>(ILjava/lang/Object;)V
		;varDec
		astore 1
		;end varDec
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		;varDec
		astore 2
		;end varDec
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		;varDec
		astore 3
		;end varDec
		
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		;binar
		astore 3
		;end binar
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		pop
		ldc 0
		istore 4
		Label1:
		iload 4
		aload 1
		getfield Array/elements Ljava/util/ArrayList;
		invokevirtual java/util/ArrayList/size()I
		if_icmpge Label2
		aload 1
		iload 4
		invokevirtual Array/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		;each
		astore 2
		;end each
		iinc 4 1
		aload 1
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		invokevirtual Array/setElement(ILjava/lang/Object;)V
		aload 1
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual Array/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		invokevirtual java/lang/Integer/intValue()I
		pop
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		ldc 1
		iadd
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		;binar
		astore 3
		;end binar
		aload 3
		invokevirtual java/lang/Integer/intValue()I
		pop
		goto Label1
		Label2:
		ldc 0
		invokestatic java/lang/Integer/valueOf(I)Ljava/lang/Integer;
		;binar
		astore 2
		;end binar
		aload 2
		invokevirtual java/lang/Integer/intValue()I
		pop
		ldc 0
		istore 5
		Label3:
		iload 5
		aload 1
		getfield Array/elements Ljava/util/ArrayList;
		invokevirtual java/util/ArrayList/size()I
		if_icmpge Label4
		aload 1
		iload 5
		invokevirtual Array/getElement(I)Ljava/lang/Object;
		checkcast java/lang/Integer
		;each
		astore 2
		;end each
		iinc 5 1
		getstatic java/lang/System/out Ljava/io/PrintStream;
		aload 2
		invokevirtual java/lang/Integer/intValue()I
		invokevirtual java/io/PrintStream/println(I)V
		goto Label3
		Label4:
		return
		.end method

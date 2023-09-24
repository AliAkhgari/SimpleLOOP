# SimpleLOOP

In this project, the objective is to create a compiler for an object-oriented programming (OOP) language named `SimpleLOOP`.

## Phases of Development

### Phase 1: Lexer
The first step involves defining the language's **grammar**, laying the foundation for syntax analysis and subsequent phases.

### Phase 2: Name Analysis
In this phase, we construct the **Abstract Syntax Tree (AST)** and meticulously handle potential errors, ensuring a robust and error-resilient language. This includes managing class redefinitions, variable conflicts, and inheritance cycle detection.

### Phase 3: Type-Checking
The third phase involves identifying and managing errors related to variable and class declarations, type mismatches, assignment validations, and ensuring the appropriateness of operands for operators. This contributes to building a reliable and type-safe language.

### Phase 4: Code Generation
The final phase involves translating the program into **bytecode** and generating `.class` files, leveraging the [jasmin](https://jasmin.sourceforge.net/) assembler to facilitate efficient execution of SimpleLOOP programs.

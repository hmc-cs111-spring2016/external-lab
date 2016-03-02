[ScalaCheck]: https://www.scalacheck.org/

# External DSLs

## Running the initial version of the code

You should be able to do `sbt run` to run an initial version of the calculator
interpreter. You should also be able to do `sbt test` to run some auto-generated
tests of the initial parser and interpreter.

### Working with ScalaIDE

You should be able to do `sbt eclipse` to generate a ScalaIDE project. Then, you
can import the project in the usual way. Once in ScalaIDE, you can run the
interpreter by opening the file `src/main/scala/calculator/calc.scala` and
running it.

**Running tests in ScalaIDE:** You can run the tests by opening a test file and
running it. Some of the tests are written with the 
[ScalaCheck testing library][ScalaCheck], which isn't integrated into Eclipse's
test runner (the thing with the green bar). The output from these tests will
appear in the console, instead.

## Extend the calculator language to add new features

Extend the code to implement the following grammar:
```
        n ∈ 𝒵 
e ∈ Expr ::= e + t | e - t | t
t ∈ Term ::= t * f | t / f | f
f ∈ Fact ::= n | ( e )
```

It's best to add features in the following order:

   1. subtraction
   2. multiplication
   3. division
   4. parenthetical expressions

When you add a new feature to a language, extend the implementation in the
following order:

   1. Intermediate representation
      1. Data structures, i.e., case classes
      2. Sugar (if you want)
   2. Parser
      1. Tests
      2. Implementation
   3. Semantics
      1. Tests
      2. Implementation

## Bonus
We probably won't have time to finish in class. But for future reference, here
are some other things to do to improve your calculator language.

### Better error-checking
Can you give better error-checking and error messages for the parser? For the
read-eval-print loop? You could also write one or more semantic checks: a pass
over the AST to check for errors, e.g., divide by literal 0.

### More features
You could add more features to the language, including

  - comparisons, e.g., `<`, `>`, `=`, etc.
  - constants, e.g., built-in names such as `π` or `e`
  - variables: assignment and use
  - functions (either with or without recursion)

Obviously, these latter features push the language towards general-purpose.

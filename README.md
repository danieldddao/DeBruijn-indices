# DeBruijn-indices

----------------------------------------------------------------------------------------------------------------------------
## Libraries
> Besides standard Java library, you will need antlr4-runtime library in order to build and execute parsers/lexers generated in Java:

> antlr4-runtime: http://www.antlr.org/download/antlr-runtime-4.5.3.jar
    
> API: http://www.antlr.org/api/Java/

----------------------------------------------------------------------------------------------------------------------------
## Grammar
> Grammars for standard lambda terms and De Bruijn terms are stored in `src/main/java/lambdaCalculus/project/grammar`:

> They are written using `ANTLR 4` parser generator for parsing the input terms.

> I defined grammar for a term as:
    
  > A term is either:
  > - variable (for standard lambda term) | number (for De Bruijn term)
  
  > - lambda abstraction
  
  > - application which is translated as **function SPACE argument**:
  1. If a function is a lambda abstraction, it must be inside parentheses. Otherwise, no parentheses needed. Examples:
    1. **(\x.y)** a
    2. **f g** a
    3. **f** a
  2. If a argument is a lambda abstraction or an application, it must be inside parentheses. Otherwise, no parentheses needed. Examples:
    1. f **(\x.x)**
    2. f **(x y)**
    3. f **x**

----------------------------------------------------------------------------------------------------------------------------
## Project's structure
    
> The code is stored in `/src/main/java/lambdaCalculus/project`. Inside the folder, it contains:

    1. Grammar folder as described above
    2. Definition folder contains the definition of standard lambda terms and de bruijn term
    3. Classes for term conversion, term printing, and tree
    
> The test code is stored in `/src/test/java/lambdaCalculus/project`:

    There're several test classes for testing the input terms, 
    conversion from DeBruijnLambda to StandardLambda and from StandardLambda to DeBruijnLambda, 
    and Autosubst.

-----------------------------------------------------------------------------------------------------------------------------
## Classes

> - DeBruijnLambda class and StandardLambda class:
   1. DeBruijnLambda contains the term and tree translated from the given input De Bruijn term.
   2. StandardLambda contains the term and tree translated from the given input standard lambda term.
   
> - Autosubst class contains the implementation of Autosubst's operations from the paper, "Autosubst: Reasoning with de Bruijn Terms and Parallel Substitutions by Steven Schäfer , Tobias Tebbi, and Gert Smolka"

> - Tree class contains the implementation of binary tree

> - TermConverter class contains the implementation of conversion from DeBruijnLambda to StandardLambda and from StandardLambda to DeBruijnLambda 

> - LambdaPrinter contains some methods for printing out the term and the tree of DeBruijnLambda, StandardLambda, and Autosubst

----------------------------------------------------------------------------------------------------------------------------
## Tutorial

######1. Setup:
    > - Given a standard lambda term INPUT, you first need to set up parsers and lexers. This can be done by calling `LambdaPrinter.setupLambda(String input)`. E.g.:
        - LambdaPrinter.setupLambda(myTerm) where `input` is the standard lambda term String input.
    
    > - Similarly, given a De Bruijn term INPUT, you first need to set up parsers and lexers. This can be done by calling `LambdaPrinter.setupDeBruijn(String input)` where `input` is the standard lambda term input. E.g.:
        - LambdaPrinter.setupDeBruijn(myTerm) where `input` is the standard lambda term String input.

######2. Printing Term and Tree:
After 1st step, the function will return:

* `StandardLambda` if you call **setupLambda** function. Then you can print out the term and the tree by calling `LambdaPrinter.printStandardLambdaTerm(StandardLambda standardLambda)` and `LambdaPrinter.printStandardLambdaTree(StandardLambda standardLambda)` respectively. 


<img width="297" alt="screenshot 2016-05-07 09 09 52" src="https://cloud.githubusercontent.com/assets/17075659/15092583/c8582da0-1433-11e6-814c-3c381fb19f85.png">


* Or `DeBruijnLambda` if you call **setupDeBruijn** function:
LambdaPrinter.setupLambda(myTerm) where `input` is the standard lambda term String input.

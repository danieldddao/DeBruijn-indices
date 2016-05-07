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

* Given a standard lambda term INPUT, you first need to set up parsers and lexers. This can be done by calling `LambdaPrinter.setupLambda(String input)`. E.g.:
    
    - **StandardLambda myStandardLambda = LambdaPrinter.setupLambda(myTerm)** where `myTerm` is the standard lambda term String input.
    
* Similarly, given a De Bruijn term INPUT, you first need to set up parsers and lexers. This can be done by calling `LambdaPrinter.setupDeBruijn(String input)` where `input` is the standard lambda term input. E.g.:
    
    - **DeBruijnLambda myDeBruijnLambda = LambdaPrinter.setupDeBruijn(myTerm)** where `myTerm` is the standard lambda term String input.

######2. Printing Term and Tree:
    After 1st step, the function will return:

* `StandardLambda` if you call **setupLambda** function. Then you can print out the term and the tree by calling `LambdaPrinter.printStandardLambdaTerm(StandardLambda standardLambda)` and `LambdaPrinter.printStandardLambdaTree(StandardLambda standardLambda)` respectively. It will print out the standard lambda term and tree like below:

    <img width="297" alt="screenshot 2016-05-07 09 09 52" src="https://cloud.githubusercontent.com/assets/17075659/15092583/c8582da0-1433-11e6-814c-3c381fb19f85.png">
    <img width="288" alt="screenshot 2016-05-07 09 10 21" src="https://cloud.githubusercontent.com/assets/17075659/15092579/c852bd66-1433-11e6-96e3-34cfaaec9605.png">
    
    <img width="248" alt="screenshot 2016-05-07 09 09 57" src="https://cloud.githubusercontent.com/assets/17075659/15092582/c855dbc2-1433-11e6-92cc-541774480320.png">
    <img width="232" alt="screenshot 2016-05-07 09 10 25" src="https://cloud.githubusercontent.com/assets/17075659/15092578/c849d0b6-1433-11e6-84a4-c5698ee8a886.png">
    

* Or `DeBruijnLambda` if you call **setupDeBruijn** function. Then you can print out the term and the tree by calling `LambdaPrinter.printDeBruijnTerm(DeBruijnLambda deBruijnLambda)` and `LambdaPrinter.printDeBruijnTree(DeBruijnLambda deBruijnLambda)` respectively. It will print out the De Bruijn term and tree like below:

    <img width="227" alt="screenshot 2016-05-07 09 10 00" src="https://cloud.githubusercontent.com/assets/17075659/15092581/c853e57e-1433-11e6-9d61-8bf9e15a4325.png">
    <img width="212" alt="screenshot 2016-05-07 09 10 30" src="https://cloud.githubusercontent.com/assets/17075659/15092577/c84182ee-1433-11e6-96e8-c71d532158b9.png">
    
    <img width="187" alt="screenshot 2016-05-07 09 10 06" src="https://cloud.githubusercontent.com/assets/17075659/15092580/c8536568-1433-11e6-8652-bf9832615009.png">
    <img width="162" alt="screenshot 2016-05-07 09 10 34" src="https://cloud.githubusercontent.com/assets/17075659/15092575/c83e1a32-1433-11e6-853f-99482a285ff0.png">


######3. Autosubst:
    Then you can use Autosubst to calculate substituation. Austosubst class supports both `StandardLambda` and `DeBruijnLambda`.
    
* To use Autosubst, you need to create an instance of the class Autosubst. For example:
    * Autosubst myautosubst = new Autosubst(myStandardLambda)

---
<img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15092576/c83ed3f0-1433-11e6-84eb-45ad07deb9dd.png">
<img width="363" alt="screenshot 2016-05-07 09 11 20" src="https://cloud.githubusercontent.com/assets/17075659/15092574/c83e2df6-1433-11e6-9418-f0ecced69a3e.png">
<img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15092572/c83c24f2-1433-11e6-95b9-98bdc25b1028.png">
<img width="451" alt="screenshot 2016-05-07 09 11 10" src="https://cloud.githubusercontent.com/assets/17075659/15092573/c83dab38-1433-11e6-8a65-7939b903d169.png">



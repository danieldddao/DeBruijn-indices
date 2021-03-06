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

> `\` is used as `λ`. E.g.: **\x.\y.x y = λx.λy.x y**

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
    
* The code is stored in `/src/main/java/lambdaCalculus/project`. Inside the folder, it contains:

    1. Grammar folder as described above
    2. Definition folder contains the definition of standard lambda terms and de bruijn term
    3. Classes for term conversion, term printing, and tree
    
* The test code is stored in `/src/test/java/lambdaCalculus/project`:

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
----------------------------------------------------------------------------------------------------------------------------
## Tutorial for Standard Lambda Terms:
> If you have a String input term where `\` is used as `λ`. E.g.: 

    String myTerm = "\x.y z";
    String myTerm = "z x t";

######1. (Required) Setup:

* Given a standard lambda term INPUT, you first need to set up parsers and lexers. This can be done by calling **LambdaPrinter.setupLambda(String input)**. E.g.:
    
    - **StandardLambda myStandardLambda = LambdaPrinter.setupLambda(myTerm)** where `myTerm` is the standard lambda term String input.

######2. (Optional) Printing Term and Tree:
> After 1st step, the function will return `StandardLambda`. 
* Then you can print out the term and the tree by calling `LambdaPrinter.printStandardLambdaTerm(StandardLambda standardLambda)` and `LambdaPrinter.printStandardLambdaTree(StandardLambda standardLambda)` respectively. E.g.:

  - **LambdaPrinter.printStandardLambdaTerm(myStandardLambda)** and **LambdaPrinter.printStandardLambdaTree(myStandardLambda)**. It will print out the standard lambda term and tree like below:

   <img width="227" alt="screenshot 2016-05-07 09 10 00" src="https://cloud.githubusercontent.com/assets/17075659/15092583/c8582da0-1433-11e6-814c-3c381fb19f85.png">
    <img width="187" alt="screenshot 2016-05-07 09 10 06" src="https://cloud.githubusercontent.com/assets/17075659/15092582/c855dbc2-1433-11e6-92cc-541774480320.png">
    
   <img width="212" alt="screenshot 2016-05-07 09 10 30" src="https://cloud.githubusercontent.com/assets/17075659/15092579/c852bd66-1433-11e6-96e3-34cfaaec9605.png">
    <img width="162" alt="screenshot 2016-05-07 09 10 34" src="https://cloud.githubusercontent.com/assets/17075659/15092578/c849d0b6-1433-11e6-84a4-c5698ee8a886.png">
    
######3. (Optional) Converting a term:
> To convert a `StandardLambda` to `DeBruijnLambda`, call the function **TermConverter.standardLambdaToDeBruijn(StandardLambda standardLambda)**, it will return a `DeBruijnLambda`. E.g.:
    
  - **DeBruijnLambda myDeBruijnLambda = TermConverter.standardLambdaToDeBruijn(myStandardLambda)**
    
  - And to print out the term and tree of **myDeBruijnLambda**, call `LambdaPrinter.printDeBruijnTerm(DeBruijnLambda deBruijnLambda)` and `LambdaPrinter.printDeBruijnTree(DeBruijnLambda deBruijnLambda)` respectively. E.g.:
    - **LambdaPrinter.printDeBruijnTerm(myDeBruijnLambda)** and **LambdaPrinter.printDeBruijnTree(myDeBruijnLambda)**. It will print out the De Bruijn term and tree like below:
    <img width="227" alt="screenshot 2016-05-07 09 10 00" src="https://cloud.githubusercontent.com/assets/17075659/15092581/c853e57e-1433-11e6-9d61-8bf9e15a4325.png">
    <img width="187" alt="screenshot 2016-05-07 09 10 06" src="https://cloud.githubusercontent.com/assets/17075659/15092580/c8536568-1433-11e6-8652-bf9832615009.png">
    
     <img width="212" alt="screenshot 2016-05-07 09 10 30" src="https://cloud.githubusercontent.com/assets/17075659/15092577/c84182ee-1433-11e6-96e8-c71d532158b9.png">
    <img width="162" alt="screenshot 2016-05-07 09 10 34" src="https://cloud.githubusercontent.com/assets/17075659/15092575/c83e1a32-1433-11e6-853f-99482a285ff0.png">

######4. (Optional) Autosubst:
* Then you can use Autosubst to calculate capture-avoiding substituation. Austosubst class supports both `StandardLambda` and `DeBruijnLambda`. Autosubst class will automatically calculate the substituation for all β-redexes and reduce the given term and tree to the normal form. 

* Autosubst class also returns full β-reduction steps by calling getLambdaFullReduction() which will return full β-reduction steps in Standard Lambda representation, and getDeBruijnFullReduction() which will return full β-reduction steps in De Bruijn representation.
    * One thing to note about full β-reduction steps in Standard Lambda representation: Those steps are converted from De Bruijn tree, so the name of variables is different in each step. Basically, the term in each step is α-equivalent to the term reduced from the step above it.
    
* To use Autosubst, you need to create an instance of the class Autosubst. For example:
    * **Autosubst myautosubst = new Autosubst(myStandardLambda)**
    * It will automatically calculate the substituation for all β-redexes and reduce the given term and tree to the normal form as well as return full β-reduction steps.
    * To print out the result term and tree in standard lambda representation, call **LambdaPrinter.printLambdaAutosubstTerm(StandardLambda standardLambda)** and **printLambdaAutosubstTree(StandardLambda standardLambda)** respectively. It will print out as below:

       <img width="451" alt="screenshot 2016-05-07 09 11 10" src="https://cloud.githubusercontent.com/assets/17075659/15092573/c83dab38-1433-11e6-8a65-7939b903d169.png">
       <img width="363" alt="screenshot 2016-05-07 09 11 20" src="https://cloud.githubusercontent.com/assets/17075659/15092574/c83e2df6-1433-11e6-9418-f0ecced69a3e.png">
    
    * To print out the result term and tree in De Bruijn representation, call **LambdaPrinter.printDeBruijnAutosubstTerm(DeBruijnLambda deBruijnLambda)** and **LambdaPrinter.printDeBruijnAutosubstTree(DeBruijnLambda deBruijnLambda)** respectively. It will print out as below:
    
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15092572/c83c24f2-1433-11e6-95b9-98bdc25b1028.png">
        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15092576/c83ed3f0-1433-11e6-84eb-45ad07deb9dd.png">
   
   * To print out full β-reduction steps, call **LambdaPrinter.printDeBruijnFullReductionSteps(Autosubst autosubst)** to print out full β-reduction steps in standard lambda representation, or **LambdaPrinter.printStandardLambdaFullReductionSteps(Autosubst autosubst)** to print out full β-reduction steps in De Bruijn representation. It will print out as below:
   
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15169420/c5c041ac-1700-11e6-8713-feeb7a78fa97.png">
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15169423/c5c15484-1700-11e6-941d-7a843c9f9e71.png">

        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15169424/c5c301c6-1700-11e6-8dde-0fb3dda9875e.png">
        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15169426/c5d56ac8-1700-11e6-88ad-73ffc691d592.png">

----------------------------------------------------------------------------------------------------------------------------
## Tutorial for De Bruijn Lambda Terms:
If you have a String input term where `\` is used as `λ`. E.g.: 

    String myTerm = "\.1 2";
    String myTerm = "0 1 2";

######1. (Required) Setup:

* Given a De Bruijn term INPUT, you first need to set up parsers and lexers. This can be done by calling `LambdaPrinter.setupDeBruijn(String input)` where `input` is the de bruijn term input. E.g.:
    
    - **DeBruijnLambda myDeBruijnLambda = LambdaPrinter.setupDeBruijn(myTerm)** where `myTerm` is the De Bruijn term String input.

######2. (Optional) Printing Term and Tree:
    After 1st step, the function will return `DeBruijnLambda`: 
* Then you can print out the term and the tree by calling `LambdaPrinter.printDeBruijnTerm(DeBruijnLambda deBruijnLambda)` and `LambdaPrinter.printDeBruijnTree(DeBruijnLambda deBruijnLambda)` respectively.
    - **LambdaPrinter.printDeBruijnTerm(myDeBruijnLambda)** and **LambdaPrinter.printDeBruijnTree(myDeBruijnLambda)**. It will print out the De Bruijn term and tree like below:

    <img width="227" alt="screenshot 2016-05-07 09 10 00" src="https://cloud.githubusercontent.com/assets/17075659/15092581/c853e57e-1433-11e6-9d61-8bf9e15a4325.png">
    <img width="187" alt="screenshot 2016-05-07 09 10 06" src="https://cloud.githubusercontent.com/assets/17075659/15092580/c8536568-1433-11e6-8652-bf9832615009.png">
    
    <img width="212" alt="screenshot 2016-05-07 09 10 30" src="https://cloud.githubusercontent.com/assets/17075659/15092577/c84182ee-1433-11e6-96e8-c71d532158b9.png">
    <img width="162" alt="screenshot 2016-05-07 09 10 34" src="https://cloud.githubusercontent.com/assets/17075659/15092575/c83e1a32-1433-11e6-853f-99482a285ff0.png">

######3. (Optional) Converting a term:
> To convert a `DeBruijnLambda` to `StandardLambda`, call the function **TermConverter.deBruijnToStandardLambda(DeBruijnLambda deBruijnLambda)**, it will return a `StandardLambda`. E.g.:
    
  - **StandardLambda myStandardLambda = TermConverter.deBruijnToStandardLambda(myDeBruijnLambda)**
    
  - And to print out the term and tree of **myStandardLambda**, call `LambdaPrinter.printStandardLambdaTerm(StandardLambda standardLambda)` and `LambdaPrinter.printStandardLambdaTree(StandardLambda standardLambda)` respectively. E.g.:
    - **LambdaPrinter.printStandardLambdaTerm(myStandardLambda)** and **LambdaPrinter.printStandardLambdaTree(myStandardLambda)**. It will print out the Standard Lambda term and tree like below:

    <img width="227" alt="screenshot 2016-05-07 09 10 00" src="https://cloud.githubusercontent.com/assets/17075659/15092583/c8582da0-1433-11e6-814c-3c381fb19f85.png">
    <img width="187" alt="screenshot 2016-05-07 09 10 06" src="https://cloud.githubusercontent.com/assets/17075659/15092582/c855dbc2-1433-11e6-92cc-541774480320.png">
    
     <img width="212" alt="screenshot 2016-05-07 09 10 30" src="https://cloud.githubusercontent.com/assets/17075659/15092579/c852bd66-1433-11e6-96e3-34cfaaec9605.png">
    <img width="162" alt="screenshot 2016-05-07 09 10 34" src="https://cloud.githubusercontent.com/assets/17075659/15092578/c849d0b6-1433-11e6-84a4-c5698ee8a886.png">

######4. (Optional) Autosubst:
* Then you can use Autosubst to calculate capture-avoiding substituation. Austosubst class supports both `StandardLambda` and `DeBruijnLambda`. Autosubst class will automatically calculate the substituation for all β-redexes and reduce the given term and tree to the normal form. 

* Autosubst class also returns full β-reduction steps by calling getLambdaFullReduction() which will return full β-reduction steps in Standard Lambda representation, and getDeBruijnFullReduction() which will return full β-reduction steps in De Bruijn representation.
    * One thing to note about full β-reduction steps in Standard Lambda representation: Those steps are converted from De Bruijn tree, so the name of variables is different in each step. Basically, the term in each step is α-equivalent to the term reduced from the step above it.
    
* To use Autosubst, you need to create an instance of the class Autosubst. For example:
    * **Autosubst myautosubst = new Autosubst(myStandardLambda)**
    * It will automatically calculate the substituation for all β-redexes and reduce the given term and tree to the normal form as well as return full β-reduction steps.
    * To print out the result term and tree in standard lambda representation, call **LambdaPrinter.printLambdaAutosubstTerm(StandardLambda standardLambda)** and **printLambdaAutosubstTree(StandardLambda standardLambda)** respectively. It will print out as below:

       <img width="451" alt="screenshot 2016-05-07 09 11 10" src="https://cloud.githubusercontent.com/assets/17075659/15092573/c83dab38-1433-11e6-8a65-7939b903d169.png">
       <img width="363" alt="screenshot 2016-05-07 09 11 20" src="https://cloud.githubusercontent.com/assets/17075659/15092574/c83e2df6-1433-11e6-9418-f0ecced69a3e.png">
    
    * To print out the result term and tree in De Bruijn representation, call **LambdaPrinter.printDeBruijnAutosubstTerm(DeBruijnLambda deBruijnLambda)** and **LambdaPrinter.printDeBruijnAutosubstTree(DeBruijnLambda deBruijnLambda)** respectively. It will print out as below:
   
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15092572/c83c24f2-1433-11e6-95b9-98bdc25b1028.png">
        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15092576/c83ed3f0-1433-11e6-84eb-45ad07deb9dd.png">
   
   * To print out full β-reduction steps, call **LambdaPrinter.printDeBruijnFullReductionSteps(Autosubst autosubst)** to print out full β-reduction steps in standard lambda representation, or **LambdaPrinter.printStandardLambdaFullReductionSteps(Autosubst autosubst)** to print out full β-reduction steps in De Bruijn representation. It will print out as below:
   
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15169420/c5c041ac-1700-11e6-8713-feeb7a78fa97.png">
        <img width="453" alt="screenshot 2016-05-07 09 11 15" src="https://cloud.githubusercontent.com/assets/17075659/15169423/c5c15484-1700-11e6-941d-7a843c9f9e71.png">

        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15169424/c5c301c6-1700-11e6-8dde-0fb3dda9875e.png">
        <img width="400" alt="screenshot 2016-05-07 09 11 25" src="https://cloud.githubusercontent.com/assets/17075659/15169426/c5d56ac8-1700-11e6-88ad-73ffc691d592.png">

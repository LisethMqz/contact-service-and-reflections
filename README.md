# CS Portfolio — Testing and QA

This repo holds my course artifacts that show how I test and think about quality. From Project One I included the Contact Service files. From Project Two I added my Summary and Reflections report. Together these pieces show unit testing, basic automation, and how I meet requirements with code.

## Artifacts

Project One  
Contact.java  
ContactService.java  
ContactTest.java  
ContactServiceTest.java

Project Two  
Summary_and_Reflections.pdf

## Reflection

How I make sure the code is functional and secure  
I write tests around the rules first and keep them running in continuous integration so regressions show up fast. I validate inputs, handle errors safely, keep secrets out of the codebase, update dependencies, and scan for known issues. Reliable behavior is proven by tests, not by hope.

How I read user needs and bring them into the program  
I turn requests into clear acceptance criteria and map each one to a test. When something is vague I ask for examples and edge cases and I add those to the suite so the intent is covered.

How I approach design  
I keep models simple, define clear boundaries, and design for testability. I separate logic from I O so it is easy to verify and refactor. I build in small slices, make a test pass, and clean up before moving on.

## How to review this repo

Start with the test classes to see the behavior I am protecting, then read the service code to see how the design supports those tests, and finish with the reflections to understand my overall process.

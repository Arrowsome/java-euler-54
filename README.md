# Project Euler Problem 54 Solution (WIP)

### Design & Ideas
For solving this one, I broke the solution in a few parts that connect together
1) A Parser that reads that could read from any source, for our app a TextFileParser subclass was enough. The app uses
polymorphism which promotes high flexibility and if someone decided to read game data from a another file type or source
, they would be able to subclass and replace Parser in seconds.
2) Basic components for the game inspired by real world objects and abstract ideas. Card class holds real world card data,
a Value enum represents all the possible values in real world and so on.
3) Business logic (in this case poker game rules) and comparing two players hands.
This part is done heavily but Hand class and at some point I was planning to use a Utility class like PokerUtils with static
methods to decide the ranking (FLUSH_ROYAL, FULL_HOUSE, ...) but I struggled to decide if that would help with testing or even
it's the right move to have YET ANOTHER class in app. At the end for Hand class tests I took the not so pleasing way of making
some of the private methods to protected.

---
### OOP Concepts

* **Inheritance**: class Parser is an abstract class that puts common logic and forces every subclass to follow closable
protocol.
* **Encapsulation**: each instance variable in every class is marked private and accessors/mutators have been defined.
* **Polymorphism**: Any other type of subclass could be used in case of TextFileParser without breaking or modifying different parts of app
* **Abstractions**: Proud of every class with their easy to access public methods except Hand class that struggled to break it up into another class or no.
e.g. PokerHelper (but that would be another private methoded class with one getRanking method that had no effect on testing)

---
### What I Would Change?

1. Having a CardUtil class that performs common tasks on a hand i.e. isConsecutive, allSameSuit, ... which might help with the
Hand class problem I suggested earlier.
2. I missed Automation test as I was not familiar with it at the moment.

---
### A Few Words About Me
I come with a Kotlin + Android background and recently decided to switch to Java and hopefully Spring framework. Despite
Java syntax being dreadful after some time the structure is more robust and a framework like spring lets developers to put
more time on business logic and solving * that matters instead of wasting times on struggling with an API from 2007.


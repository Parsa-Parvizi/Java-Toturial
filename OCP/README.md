The Student class and DistinctionDecider are both unchanged for any future changes in the distinction criteria.<br>
They are closed for modification.<br>
• Notice that every participant follows the SRP.<br>
• Suppose you need to consider a new stream, say commerce.<br>
Then you can create a new class such as CommerceStudent.<br>
Notice that in a case like this, you do not need to touch the ArtsStudent or ScienceStudent classes.<br>
• Similarly, when you consider different evaluation criteria for a different stream such as commerce,
you can add a new derived class such as CommerceDistinctionDecider
that implements the DistinctionDecider interface and you can set new distinction criteria for commerce students.
In this case, you do not need to alter any existing class in the DistinctionDecider hierarchy.<br>
Obviously, the client code needs to adopt this change.<br>
• Using this approach, you avoid an if-else chain (shown in demonstration 3).<br>
This chain could grow if you consider new streams such as commerce following the approach that is shown in demonstration
3. Remember that avoiding a big if-else chain is always considered a better practice.<br>
It is because avoiding the if-else chains lowers the cyclomatic complexity of a program and produces better code.<br>
(Cyclomatic complexity is a software metric to indicate the complexity of a program.
It indicates the number of paths through a particular piece of code.<br>
So, in simple terms, by lowering the cyclomatic complexity you make your code easily readable and testable.)<br>
I’ll finish this section with Robert C. Martin’s suggestion.<br>
In his book Clean Architecture, he gave us a simple formula:<br>
  if you want component A to protect from component B, component B should depend on component
    A. But why do we give component A such importance?
  It is because we may want to put the most important rules in it.
It is time to study the next principle.

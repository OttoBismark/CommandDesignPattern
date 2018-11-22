# CommandDesignPattern

Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or
log requests, and support undoable operations.

# Motivation

Sometimes it's necessary to issue requests to objects without knowing anything about the operation being
requested or the receiver of the request. For example, user interface toolkits include objects like buttons and
menus that carry out a request in response to user input. But the toolkit can't implement the request explicitly
in the button or menu, because only applications that use the toolkit know what should be done on which
object. As toolkit designers we have no way of knowing the receiver of the request or the operations that will
carry it out.
The Command pattern lets toolkit objects make requests of unspecified application objects by turning the
request itself into an object. This object can be stored and passed around like other objects. The key to this
pattern is an abstract Command class, which declares an interface for executing operations. In the simplest
form this interface includes an abstract Execute operation. Concrete Command subclasses specify a receiveraction
pair by storing the receiver as an instance variable and by implementing Execute to invoke the request.
The receiver has the knowledge required to carry out the request.

# Applicability

Use the Command pattern when you want to
- parameterize objects by an action to perform, as MenuItem objects did above. You can express such
parameterization in a procedural language with a callback function, that is, a function that's registered
somewhere to be called at a later point. Commands are an object-oriented replacement for callbacks.
- specify, queue, and execute requests at different times. A Command object can have a lifetime
independent of the original request. If the receiver of a request can be represented in an address spaceindependent
way, then you can transfer a command object for the request to a different process and
fulfill the request there.
- support undo. The Command's Execute operation can store state for reversing its effects in the
command itself. The Command interface must have an added Unexecute operation that reverses the
effects of a previous call to Execute. Executed commands are stored in a history list. Unlimited-level
undo and redo is achieved by traversing this list backwards and forwards calling Unexecute and
Execute, respectively.
- support logging changes so that they can be reapplied in case of a system crash. By augmenting the
Command interface with load and store operations, you can keep a persistent log of changes.
Recovering from a crash involves reloading logged commands from disk and reexecuting them with the
Execute operation.
- structure a system around high-level operations built on primitives operations. Such a structure is
common in information systems that support transactions. A transaction encapsulates a set of changes
to data. The Command pattern offers a way to model transactions. Commands have a common
interface, letting you invoke all transactions the same way. The pattern also makes it easy to extend the
system with new transactions.

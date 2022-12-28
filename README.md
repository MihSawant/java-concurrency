# Concurrency in Java
In this project, there are different code samples for writing **concurrent** code and testing
it in Java Language.

1. In [FirstRunnable](src/main/java/creating_runnable/FirstRunnable.java), I have created a simple Runnable object,
    which has been implemented using Lambda Expression, Then created
    a thread object and give it custom name and then run using _**start()**_ method.

    **_Use of run() method should not be done, otherwise the code will run inside main thread, and not
    in new thread that we create, So not to use run() for new threads._**
# Concurrency in Java
In this project, there are different code samples for writing **concurrent** code and testing
it in Java Language.

1. In [FirstRunnable](src/main/java/creating_runnable/FirstRunnable.java), I have created a simple Runnable object,
    which has been implemented using Lambda Expression, Then created
    a thread object and give it custom name and then run using _**start()**_ method.

    **_Use of run() method should not be done, otherwise the code will run inside main thread, and not
    in new thread that we create, So not to use run() for new threads._**

2. In [RaceCondition](src/main/java/race_condition/RaceCondition.java) example,
    I have created [Value](src/main/java/race_condition/Value.java) class that
    has one attribute num, we increment it using a method **_incrementValue()_**
    and have also a getter to fetch the value.
    Now, in the RaceCondition, firstly I have a runnable which loops 10 times and increments
    the value, next I create thread and then pass the runnable to it and then run. It returns
   expected output i.e. 10.
   
   But in other scenario, 10,000 Threads are created and each thread 
   runs runnable code, also **_join()_** method is used so that print statement
  which prints the value of num, is executed after finishing of threads, or 
 when threads complete after that it should print the value,
 The value which it prints is not expected result... It is closer to answer
 but not exactly the answer.  
_**The problem is that there is race condition in the code, num = num + 1, 
where there is both RW operation, Read and Write simultaneously by multiple
threads at same time, so it causes RC.**_  
**_To solve the problem we just simply have to create a key of any Object type put
the code that causes RC in synchronized block.   
Now the output is correct and as expected Value is = 100000._**
3. In [Sample](src/main/java/deadlock/Sample.java) class, I have three instance methods,
    keep(), take() and eat(), and two keys key1, key2 are used for synchronization.
   In [DinnersEating](src/main/java/deadlock/DinnersEating.java) class, two runnable methods
    are created calling keep() and take() respectively, _**Now the problem occurs when T1 executes
    the keep() method and calls take() inside, T2 calls eat() but key1 is not free and hence both
    threads are blocked. So it will keep running and now thread will get access to method as one
    is already running, causing Deadlock.**_
    


   
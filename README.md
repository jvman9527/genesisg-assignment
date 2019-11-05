# genesisg-assignment
Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). There can be multiple employees, but only one TL or PM. An incoming telephone call must be allocated to a fresher who is free. If no freshers are free, or if the current fresher is unable to solve the caller's problem (determined by a simple dice roll), he or she must escalate the call to technical lead. If the TL is not free or not able to handle it, then the call should be escalated to the PM.

# Usage
### run the [simple example](https://github.com/jvman9527/genesisg-assignment/blob/master/src/main/groovy/com/genesisg/ass/ignment/CallCenter.groovy#L76-L106) of call center
```./gradlew run```

### run the test and generate report
```./gradlew test```  
you can find reports in projectDir/build/reports directory

# Description
- Groovy to implement this assignment
- [actor model of gpars library](http://www.gpars.org/webapp/quickstart/index.html) to handle the multi-threading part
- [Spock](http://spockframework.org/spock/docs/1.3/all_in_one.html) to write the test


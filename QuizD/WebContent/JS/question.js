var ArrayList = Java.type("java.util.ArrayList");
var MCQS=new ArrayList;
var myclass=new Java.type("Quiz.querydb");
MCQS[0]=myclass.getData(1);
console.log(MCQS);



<%@page import="java.util.ArrayList"%>
<%@page import="Quiz.querydb"%>
<%@page import="Quiz.dataobj"%>
<%@page import="Quiz.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Quiz App</title>
</head>
<link href="https://fonts.googleapis.com/css2?family=Exo+2:wght@600&family=Exo:ital,wght@1,600&display=swap" rel="stylesheet">
<link rel ="stylesheet" href ="style.css">
<link rel ="stylesheet" href ="css/style.css">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<br>
<br>
<body bgcolor = "#E6E6FA">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expire", "0");
if(session.getAttribute("username")==null)
	response.sendRedirect("Login.jsp");

%>
<nav>
			<a href="#" class="logo"></a>
			<ul>

				<li><a href="LogOut">LogOut</a></li>
			</ul>
</nav>
	<div class="home-box custom-box">
            <h3>Instruction:</h3>
            <p>Total number of questions:<span class="total-question"></span></p>
            <p>20s is Allocated to every question</p>
            <p>Random Questions</p>
            <button type="button" class="btn" onclick="startQuiz()">Start Quiz</button>
        </div>
        <div class="quiz-box custom-box hide">
            <div class="header">
            <div class="question-number">
            </div>
                
                <div class="timer-box"></div>
                </div>

            <div class="question-text"></div>
            <div class="option-container">
            </div>
            <div class="next-question-button">
                <button type="button" class="btn" onclick="next()">Next</button>
            </div>
        </div>
        <div class="result-box custom-box hide">
            <h1>Quiz Result</h1>
            <table>
                <tr>
                    <td>Total Question</td>
                    <td><span class="total-question"></span></td>
                </tr>
                <tr>
                    <td>Attempt</td>
                    <td><span class="total-attempt"></span></td>
                </tr>
                <tr>
                    <td>Total correct</td>
                    <td><span class="total-correct"></span></td>
                </tr>
                <tr>
                    <td>Wrong</td>
                    <td><span class="total-wrong"></span></td>
                </tr>
                <tr>
                    <td>Percentage</td>
                    <td><span class="total-percentage"></span></td>
                </tr>
                <tr>
                    <td>Your Total Score</td>
                    <td><span class="total-score"></span></td>
                </tr>
            </table>
            <button type="button" class="btn" onclick="document.location='Welcome.jsp'">Try Again</button>
            <button type="button" class="btn" onclick="LogOut">Go To Home</button>
        </div>
        <script type="text/javascript">
    
    	let quiz=[];
    	let qs=[];
    	<%
    	querydb query=new querydb();
    	int courseId=Integer.parseInt(request.getParameter("course"));    	
    	//System.out.println(courseId);
    	ArrayList<dataobj> q=querydb.getData(courseId);
    	int correct=0;
    	int total=q.size();
    	for(int i=0;i<q.size();i++){
    		System.out.println(q.get(i).choice1);
    		int ans=Integer.parseInt(q.get(i).answer);
    		%>
    		var question='<%=q.get(i).question%>';
    		var choice1='<%=q.get(i).choice1%>';
    		var choice2='<%=q.get(i).choice2%>';
    		var choice3='<%=q.get(i).choice3%>';
    		var choice4='<%=q.get(i).choice4%>';
    		var answer='<%=ans%>';
    			qs={
    					q: question,
    				    options:[choice1,choice2,choice3,choice4],
    				    answer: answer-1
    			}
    		quiz.push(qs);
			
    		<%
    	}
    	
    	%>
    let questionNumber= document.querySelector(".question-number");
    let questionText= document.querySelector(".question-text");
    let optionContainer= document.querySelector(".option-container");
    let answersIndicatorContainer = document.querySelector(".answer-indicator");
    let homeBox =document.querySelector(".home-box");
    let quizBox =document.querySelector(".quiz-box");
    let resultBox =document.querySelector(".result-box");
    let time=document.querySelector(".timer-box");

    let questionCounter=0;
    let currentQuestion;
    let availableQuestions=[];
    let availableOptions = [];
    let correctAnswers=0;
    let attempt=0;
    let timer = 0;
    let interval = 0;
    function setAvailableQuestions(){
        let totalQuestion = quiz.length;
        for(let i=0; i<totalQuestion; i++){
            availableQuestions.push(quiz[i]);
        }
    }
    function getNewQuestion(){
        questionNumber.innerHTML="Question "+(questionCounter+1)+ "of" + quiz.length;

        let questionIndex = availableQuestions[Math.floor(Math.random()*availableQuestions.length)];
        currentQuestion=questionIndex;
        questionText.innerHTML=currentQuestion.q;

        let index1= availableQuestions.indexOf(questionIndex);
        availableQuestions.splice(index1,1);

        let optionLen=currentQuestion.options.length;
        for(let i=0; i<optionLen; i++){
            availableOptions.push(i);
        }
        optionContainer.innerHTML = '';
        let animationDelay=0.15;
        for(let i=0; i<optionLen; i++){

            let optionIndex= availableOptions[Math.floor(Math.random() * availableOptions.length)];
            let index2= availableOptions.indexOf(optionIndex);
            availableOptions.splice(index2,1);
            let option =document.createElement("div");
            option.innerHTML=currentQuestion.options[optionIndex];
            option.id=optionIndex;
            option.style.animationDelay = animationDelay+'s';
            animationDelay=animationDelay+0.15;
            option.className="option";
            optionContainer.appendChild(option);
            option.setAttribute("onclick","getResult(this)");

        }

        questionCounter++;
        timer=0;
    }

    function getResult(element){
        let id=parseInt(element.id);
        console.log(id+" "+currentQuestion.answer);
        if(id === currentQuestion.answer){
            element.classList.add("correct");
            correctAnswers++;
            console.log("correct:"+correctAnswers);

        }else{
            element.classList.add("wrong");
            let optionLen = optionContainer.children.length;
            for(let i=0;i<optionLen;i++){
                if(parseInt(optionContainer.children[i].id) === currentQuestion.answer){
                    optionContainer.children[i].classList.add("correct");
                }
            }
        }
        clearInterval(interval);
        attempt++;
        unclickableOptions();


    }
    function unclickableOptions(){
        let optionLen = optionContainer.children.length;
        for(let i=0; i<optionLen;i++){
            optionContainer.children[i].classList.add("already-answered");
        }
    }

    function next(){
        if(questionCounter === quiz.length){
            console.log("quiz over");
            clearInterval(interval);
            quizOver();
        }
        else{
            getNewQuestion();
            clearInterval(interval);
            interval = setInterval(countDown, 1000);
        }
    }
    function quizOver(){
        quizBox.classList.add("hide");
        resultBox.classList.remove("hide");
        quizResult();
    }
    function quizResult(){
        resultBox.querySelector(".total-question").innerHTML=quiz.length;
        resultBox.querySelector(".total-attempt").innerHTML=attempt;
        resultBox.querySelector(".total-correct").innerHTML=correctAnswers;
        resultBox.querySelector(".total-wrong").innerHTML=attempt-correctAnswers;
        resultBox.querySelector(".total-percentage").innerHTML=((correctAnswers/quiz.length)*100).toFixed()+"%";
        resultBox.querySelector(".total-score").innerHTML=correctAnswers+"/"+quiz.length;
        assign(correctAnswers);
    }
    function resetQuiz(){
        questionCounter=0;
        correctAnswers=0;
        attempt=0;
    }
    function tryAgainQuiz(){
        resultBox.classList.add("hide");
        quizBox.classList.remove("hide");
        resetQuiz();
    }
    function goToHome(){
        resultBox.classList.add("hide");
        homeBox.classList.remove("hide");
        resetQuiz();
    }
    function startQuiz(){
    	homeBox.classList.add("hide");
        quizBox.classList.remove("hide");
        interval = setInterval(countDown, 1000);
        setAvailableQuestions();
        getNewQuestion();
    }
    let countDown = () => {
        if (timer === 20) {
            clearInterval(interval);
            next();
        } else {
            timer++;
            time.innerText =20-timer;
        }
    }
    window.onload = function(){
        homeBox.querySelector(".total-question").innerHTML = quiz.length;
    }
    
    </script>
    
    </body>
</html>
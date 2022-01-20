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
}

function getResult(element){
    let id=parseInt(element.id);
    if(id === currentQuestion.answer){
        element.classList.add("correct");
        updateAnswerIndicator("correct");
        correctAnswers++;
        console.log("correct:"+correctAnswers);

    }else{
        element.classList.add("wrong");
        updateAnswerIndicator("wrong");
        let optionLen = optionContainer.children.length;
        for(let i=0;i<optionLen;i++){
            if(parseInt(optionContainer.children[i].id) === currentQuestion.answer){
                optionContainer.children[i].classList.add("correct");
            }
        }
    }
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
        quizOver();
    }
    else{
        getNewQuestion();
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
    startQuiz();
}
function goToHome(){
    resultBox.classList.add("hide");
    homeBox.classList.remove("hide");
    resetQuiz();
}
function startQuiz(){
	homeBox.classList.add("hide");
    quizBox.classList.remove("hide");
    setAvailableQuestions();
    getNewQuestion();
    answersIndicator();
}
window.onload = function(){
    homeBox.querySelector(".total-question").innerHTML = quiz.length;
}
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { AppService } from "../service/app.service";

interface question{
  name: string,
  oneAnswer: boolean,
  options: option[]
}

interface option{
  name: string,
  correct: boolean
}

@Component({
  selector: 'adm-comp',
  templateUrl: './admin.component.html'
})
export class AdminComponent{
  answer = '';
  testName = '';
  questionArray: question[] = [];

  constructor(private service: AppService, private router: Router){
  }

  addQuestion(){
    this.questionArray.push({name: '', oneAnswer: true, options: this.makeStartOption()});
  }

  addOption(id: number){
    this.questionArray[id].options.push({name: '', correct: false});
  }

  makeStartOption(){
    let optionsArray: option[] = [];
    let newOption: option = {name: '', correct: false};
    optionsArray.push(newOption);
    return optionsArray;
  }

  saveTest(){
    let questions = this.writeQuestionString();
    let jsonTest = `{
      "name": "${this.testName}",
      "questions": [
        ${questions}
      ]
    }`;
    this.service.saveTest(jsonTest)
    .subscribe((data: any) => {
      this.answer = data;
    })
  }

  writeQuestionString(): string{
    let jsonQuestions = '';
    for(let i = 0; i < this.questionArray.length; i++){
      let oneAnswer: boolean = this.isOneAnswer(i);
      let ending = (i < this.questionArray.length - 1) ? "," : "";
      let options = this.writeOptionString(i);
      let question = `{
      "name": "${this.questionArray[i].name}",
      "oneAnswer": ${oneAnswer},
      "options": [
        ${options}
      ]
      }${ending}`;
      jsonQuestions += question;
    }
    return jsonQuestions;
  }

  isOneAnswer(quesId: number): boolean{
    let trueOptions: number = 0;
    for(let i = 0; i < this.questionArray[quesId].options.length; i++){
      if(this.questionArray[quesId].options[i].correct) trueOptions++;
    }
    return (trueOptions > 1) ? false : true;
  }

  writeOptionString(quesId: number): string{
    let jsonOptions = '';
    for(let i = 0; i < this.questionArray[quesId].options.length; i++){
      let ending = (i < this.questionArray[quesId].options.length - 1) ? "," : "";
      let option = `{
        "name": "${this.questionArray[quesId].options[i].name}",
        "correct": ${this.questionArray[quesId].options[i].correct}
      }${ending}`
      jsonOptions += option;
    }
    return jsonOptions;
  }
}

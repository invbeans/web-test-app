import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AppService } from "../service/app.service";

interface test{
  id: number,
  name: string,
  questions: question[]
}
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
  selector: 'feed-comp',
  templateUrl: './feed.component.html'
})
export class FeedComponent implements OnInit{
  constructor(private service: AppService, private router: Router){}
  tests: test[] = [];
  ngOnInit(): void {
      this.service.getTestsInfo()
      .subscribe((data: any) => {
        this.tests = data;
      })
  }

}

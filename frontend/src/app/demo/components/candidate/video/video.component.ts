import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, OnInit } from '@angular/core';

@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.scss']
})
export class VideoComponent implements OnInit {
  public showVideo: boolean = false;
  // public videoURL: string = 'https://www.runoob.com/try/demo_source/movie.mp4';
  public videosInfo: any;
  public inputvalue: string;

  constructor(private http: HttpClient, private el: ElementRef) {

  }

  ngOnInit(): void {

  }

  searchVideo(question: string): void {
    console.log("123", question)
    this.http.get('https://731b-2408-832f-20b7-e5b1-f920-b6a4-4e99-4024.ngrok-free.app/candidate?question=' + question).subscribe(videosInfo => {
      this.videosInfo = videosInfo;
      this.videosInfo = this.videosInfo.filter(videoInfo => (typeof videoInfo?.url === 'string' && videoInfo.url))
      this.showVideo = true;
      this.videosInfo.forEach((videoInfo,i) => {
        setTimeout(() => {
          this.playBySeconds(videoInfo.start_ts, i);
        }, 1);
      });
      
    })
  }

  playBySeconds(num, index) {
    if (num && document.getElementById('videoPlayer' + index)) {
      let myVideo = document.getElementById('videoPlayer' + index);
      (myVideo as any).play();
      (myVideo as any).currentTime = num;
    }
  }
}

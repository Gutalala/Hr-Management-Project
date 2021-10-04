import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserResponse } from '../../model/UserResponse.model';
import { map } from 'rxjs/operators';
import { User } from 'src/app/model/User.model';

@Injectable({
  providedIn: 'root'
})
export class HttpServiceService {

  endPoint: string = "http://localhost:8080/login";
  errorData: {};
  user: User;
  userResponse: UserResponse;
  redirectUrl: string;
  constructor(private httpClient: HttpClient) { }

  login(username: string, password: string){
    let postData = {username: username, password: password};
    console.log(postData)
    return this.httpClient.post<UserResponse>(
      this.endPoint, postData,
      {
        headers:{
          "Allow-Cross-Origin-Origin": "*"
        }
      }
    ).pipe(
      map(userResponse => {
        this.userResponse = <UserResponse>userResponse;
        if(userResponse.status.success){
          localStorage.setItem('currentUser', JSON.stringify(userResponse.user));
        } else {
          localStorage.setItem('message', JSON.stringify(userResponse.status.message));
        }
        return userResponse;
      })
    );
  }

  isLoggedIn(){
    if(localStorage.getItem('currentUser')){
      return true;
    } else {
      return false;
    }
  }

  logout(){
    localStorage.removeItem('currentUser');
  }
}

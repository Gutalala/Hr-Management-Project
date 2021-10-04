import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {
  canActivate(){
    if (localStorage.getItem('currentUser') != null) { (3)
      return true;
    } else {
      window.alert("You don't have permission to view this page"); (4)
      return false;
    }
  }
}

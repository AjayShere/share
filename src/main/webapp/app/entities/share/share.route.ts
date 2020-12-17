import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IShare, Share } from 'app/shared/model/share.model';
import { ShareService } from './share.service';
import { ShareComponent } from './share.component';
import { ShareDetailComponent } from './share-detail.component';
import { ShareUpdateComponent } from './share-update.component';

@Injectable({ providedIn: 'root' })
export class ShareResolve implements Resolve<IShare> {
  constructor(private service: ShareService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IShare> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((share: HttpResponse<Share>) => {
          if (share.body) {
            return of(share.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Share());
  }
}

export const shareRoute: Routes = [
  {
    path: '',
    component: ShareComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Shares',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: ShareDetailComponent,
    resolve: {
      share: ShareResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Shares',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: ShareUpdateComponent,
    resolve: {
      share: ShareResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Shares',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: ShareUpdateComponent,
    resolve: {
      share: ShareResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'Shares',
    },
    canActivate: [UserRouteAccessService],
  },
];

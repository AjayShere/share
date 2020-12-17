import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShareMarketSharedModule } from 'app/shared/shared.module';
import { ShareComponent } from './share.component';
import { ShareDetailComponent } from './share-detail.component';
import { ShareUpdateComponent } from './share-update.component';
import { ShareDeleteDialogComponent } from './share-delete-dialog.component';
import { shareRoute } from './share.route';

@NgModule({
  imports: [ShareMarketSharedModule, RouterModule.forChild(shareRoute)],
  declarations: [ShareComponent, ShareDetailComponent, ShareUpdateComponent, ShareDeleteDialogComponent],
  entryComponents: [ShareDeleteDialogComponent],
})
export class ShareMarketShareModule {}

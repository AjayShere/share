import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IShare } from 'app/shared/model/share.model';
import { ShareService } from './share.service';

@Component({
  templateUrl: './share-delete-dialog.component.html',
})
export class ShareDeleteDialogComponent {
  share?: IShare;

  constructor(protected shareService: ShareService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.shareService.delete(id).subscribe(() => {
      this.eventManager.broadcast('shareListModification');
      this.activeModal.close();
    });
  }
}

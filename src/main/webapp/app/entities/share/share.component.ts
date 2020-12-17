import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IShare } from 'app/shared/model/share.model';
import { ShareService } from './share.service';
import { ShareDeleteDialogComponent } from './share-delete-dialog.component';

@Component({
  selector: 'radixile-share',
  templateUrl: './share.component.html',
})
export class ShareComponent implements OnInit, OnDestroy {
  shares?: IShare[];
  eventSubscriber?: Subscription;

  constructor(protected shareService: ShareService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll(): void {
    this.shareService.query().subscribe((res: HttpResponse<IShare[]>) => (this.shares = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInShares();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IShare): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInShares(): void {
    this.eventSubscriber = this.eventManager.subscribe('shareListModification', () => this.loadAll());
  }

  delete(share: IShare): void {
    const modalRef = this.modalService.open(ShareDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.share = share;
  }
}

import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { ShareMarketTestModule } from '../../../test.module';
import { ShareComponent } from 'app/entities/share/share.component';
import { ShareService } from 'app/entities/share/share.service';
import { Share } from 'app/shared/model/share.model';

describe('Component Tests', () => {
  describe('Share Management Component', () => {
    let comp: ShareComponent;
    let fixture: ComponentFixture<ShareComponent>;
    let service: ShareService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [ShareMarketTestModule],
        declarations: [ShareComponent],
      })
        .overrideTemplate(ShareComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ShareComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ShareService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Share(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.shares && comp.shares[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});

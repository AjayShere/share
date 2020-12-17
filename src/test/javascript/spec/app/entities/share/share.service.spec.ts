import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ShareService } from 'app/entities/share/share.service';
import { IShare, Share } from 'app/shared/model/share.model';

describe('Service Tests', () => {
  describe('Share Service', () => {
    let injector: TestBed;
    let service: ShareService;
    let httpMock: HttpTestingController;
    let elemDefault: IShare;
    let expectedResult: IShare | IShare[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ShareService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Share(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Share', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Share()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Share', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            bcsCode: 'BBBBBB',
            nseCode: 'BBBBBB',
            industry: 'BBBBBB',
            currentPrice: 'BBBBBB',
            marketCapitalization: 'BBBBBB',
            priceToEarning: 'BBBBBB',
            debtToEquity: 'BBBBBB',
            operatingCashFlow: 'BBBBBB',
            sales: 'BBBBBB',
            priceToBookValue: 'BBBBBB',
            returnOnCapitalEmployed: 'BBBBBB',
            returnOnEquity: 'BBBBBB',
            eps: 'BBBBBB',
            promoterHolding: 'BBBBBB',
            pledgedPercentage: 'BBBBBB',
            interestCoverageRatioPEGRatio: 'BBBBBB',
            priceToFreeCashFlowSalesGrowth: 'BBBBBB',
            salesGrowth: 'BBBBBB',
            profitGrowth3Years: 'BBBBBB',
            profitGrowth5Years: 'BBBBBB',
            averageReturnOnEquity3Years: 'BBBBBB',
            dividendYield: 'BBBBBB',
            industryPE: 'BBBBBB',
            freeCashFlow3Years: 'BBBBBB',
            cashFromOperationsLastYear: 'BBBBBB',
            freeCashFlowLastYear: 'BBBBBB',
            opm: 'BBBBBB',
            profitAfterTax: 'BBBBBB',
            eVEBITDA: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Share', () => {
        const returnedFromService = Object.assign(
          {
            name: 'BBBBBB',
            bcsCode: 'BBBBBB',
            nseCode: 'BBBBBB',
            industry: 'BBBBBB',
            currentPrice: 'BBBBBB',
            marketCapitalization: 'BBBBBB',
            priceToEarning: 'BBBBBB',
            debtToEquity: 'BBBBBB',
            operatingCashFlow: 'BBBBBB',
            sales: 'BBBBBB',
            priceToBookValue: 'BBBBBB',
            returnOnCapitalEmployed: 'BBBBBB',
            returnOnEquity: 'BBBBBB',
            eps: 'BBBBBB',
            promoterHolding: 'BBBBBB',
            pledgedPercentage: 'BBBBBB',
            interestCoverageRatioPEGRatio: 'BBBBBB',
            priceToFreeCashFlowSalesGrowth: 'BBBBBB',
            salesGrowth: 'BBBBBB',
            profitGrowth3Years: 'BBBBBB',
            profitGrowth5Years: 'BBBBBB',
            averageReturnOnEquity3Years: 'BBBBBB',
            dividendYield: 'BBBBBB',
            industryPE: 'BBBBBB',
            freeCashFlow3Years: 'BBBBBB',
            cashFromOperationsLastYear: 'BBBBBB',
            freeCashFlowLastYear: 'BBBBBB',
            opm: 'BBBBBB',
            profitAfterTax: 'BBBBBB',
            eVEBITDA: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Share', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});

import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IShare, Share } from 'app/shared/model/share.model';
import { ShareService } from './share.service';

@Component({
  selector: 'radixile-share-update',
  templateUrl: './share-update.component.html',
})
export class ShareUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    name: [],
    bcsCode: [],
    nseCode: [],
    industry: [],
    currentPrice: [],
    marketCapitalization: [],
    priceToEarning: [],
    debtToEquity: [],
    operatingCashFlow: [],
    sales: [],
    priceToBookValue: [],
    returnOnCapitalEmployed: [],
    returnOnEquity: [],
    eps: [],
    promoterHolding: [],
    pledgedPercentage: [],
    interestCoverageRatioPEGRatio: [],
    priceToFreeCashFlowSalesGrowth: [],
    salesGrowth: [],
    profitGrowth3Years: [],
    profitGrowth5Years: [],
    averageReturnOnEquity3Years: [],
    dividendYield: [],
    industryPE: [],
    freeCashFlow3Years: [],
    cashFromOperationsLastYear: [],
    freeCashFlowLastYear: [],
    opm: [],
    profitAfterTax: [],
    eVEBITDA: [],
  });

  constructor(protected shareService: ShareService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ share }) => {
      this.updateForm(share);
    });
  }

  updateForm(share: IShare): void {
    this.editForm.patchValue({
      id: share.id,
      name: share.name,
      bcsCode: share.bcsCode,
      nseCode: share.nseCode,
      industry: share.industry,
      currentPrice: share.currentPrice,
      marketCapitalization: share.marketCapitalization,
      priceToEarning: share.priceToEarning,
      debtToEquity: share.debtToEquity,
      operatingCashFlow: share.operatingCashFlow,
      sales: share.sales,
      priceToBookValue: share.priceToBookValue,
      returnOnCapitalEmployed: share.returnOnCapitalEmployed,
      returnOnEquity: share.returnOnEquity,
      eps: share.eps,
      promoterHolding: share.promoterHolding,
      pledgedPercentage: share.pledgedPercentage,
      interestCoverageRatioPEGRatio: share.interestCoverageRatioPEGRatio,
      priceToFreeCashFlowSalesGrowth: share.priceToFreeCashFlowSalesGrowth,
      salesGrowth: share.salesGrowth,
      profitGrowth3Years: share.profitGrowth3Years,
      profitGrowth5Years: share.profitGrowth5Years,
      averageReturnOnEquity3Years: share.averageReturnOnEquity3Years,
      dividendYield: share.dividendYield,
      industryPE: share.industryPE,
      freeCashFlow3Years: share.freeCashFlow3Years,
      cashFromOperationsLastYear: share.cashFromOperationsLastYear,
      freeCashFlowLastYear: share.freeCashFlowLastYear,
      opm: share.opm,
      profitAfterTax: share.profitAfterTax,
      eVEBITDA: share.eVEBITDA,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const share = this.createFromForm();
    if (share.id !== undefined) {
      this.subscribeToSaveResponse(this.shareService.update(share));
    } else {
      this.subscribeToSaveResponse(this.shareService.create(share));
    }
  }

  private createFromForm(): IShare {
    return {
      ...new Share(),
      id: this.editForm.get(['id'])!.value,
      name: this.editForm.get(['name'])!.value,
      bcsCode: this.editForm.get(['bcsCode'])!.value,
      nseCode: this.editForm.get(['nseCode'])!.value,
      industry: this.editForm.get(['industry'])!.value,
      currentPrice: this.editForm.get(['currentPrice'])!.value,
      marketCapitalization: this.editForm.get(['marketCapitalization'])!.value,
      priceToEarning: this.editForm.get(['priceToEarning'])!.value,
      debtToEquity: this.editForm.get(['debtToEquity'])!.value,
      operatingCashFlow: this.editForm.get(['operatingCashFlow'])!.value,
      sales: this.editForm.get(['sales'])!.value,
      priceToBookValue: this.editForm.get(['priceToBookValue'])!.value,
      returnOnCapitalEmployed: this.editForm.get(['returnOnCapitalEmployed'])!.value,
      returnOnEquity: this.editForm.get(['returnOnEquity'])!.value,
      eps: this.editForm.get(['eps'])!.value,
      promoterHolding: this.editForm.get(['promoterHolding'])!.value,
      pledgedPercentage: this.editForm.get(['pledgedPercentage'])!.value,
      interestCoverageRatioPEGRatio: this.editForm.get(['interestCoverageRatioPEGRatio'])!.value,
      priceToFreeCashFlowSalesGrowth: this.editForm.get(['priceToFreeCashFlowSalesGrowth'])!.value,
      salesGrowth: this.editForm.get(['salesGrowth'])!.value,
      profitGrowth3Years: this.editForm.get(['profitGrowth3Years'])!.value,
      profitGrowth5Years: this.editForm.get(['profitGrowth5Years'])!.value,
      averageReturnOnEquity3Years: this.editForm.get(['averageReturnOnEquity3Years'])!.value,
      dividendYield: this.editForm.get(['dividendYield'])!.value,
      industryPE: this.editForm.get(['industryPE'])!.value,
      freeCashFlow3Years: this.editForm.get(['freeCashFlow3Years'])!.value,
      cashFromOperationsLastYear: this.editForm.get(['cashFromOperationsLastYear'])!.value,
      freeCashFlowLastYear: this.editForm.get(['freeCashFlowLastYear'])!.value,
      opm: this.editForm.get(['opm'])!.value,
      profitAfterTax: this.editForm.get(['profitAfterTax'])!.value,
      eVEBITDA: this.editForm.get(['eVEBITDA'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IShare>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}

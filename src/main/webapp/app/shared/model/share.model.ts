export interface IShare {
  id?: number;
  name?: string;
  bcsCode?: string;
  nseCode?: string;
  industry?: string;
  currentPrice?: string;
  marketCapitalization?: string;
  priceToEarning?: string;
  debtToEquity?: string;
  operatingCashFlow?: string;
  sales?: string;
  priceToBookValue?: string;
  returnOnCapitalEmployed?: string;
  returnOnEquity?: string;
  eps?: string;
  promoterHolding?: string;
  pledgedPercentage?: string;
  interestCoverageRatioPEGRatio?: string;
  priceToFreeCashFlowSalesGrowth?: string;
  salesGrowth?: string;
  profitGrowth3Years?: string;
  profitGrowth5Years?: string;
  averageReturnOnEquity3Years?: string;
  dividendYield?: string;
  industryPE?: string;
  freeCashFlow3Years?: string;
  cashFromOperationsLastYear?: string;
  freeCashFlowLastYear?: string;
  opm?: string;
  profitAfterTax?: string;
  eVEBITDA?: string;
}

export class Share implements IShare {
  constructor(
    public id?: number,
    public name?: string,
    public bcsCode?: string,
    public nseCode?: string,
    public industry?: string,
    public currentPrice?: string,
    public marketCapitalization?: string,
    public priceToEarning?: string,
    public debtToEquity?: string,
    public operatingCashFlow?: string,
    public sales?: string,
    public priceToBookValue?: string,
    public returnOnCapitalEmployed?: string,
    public returnOnEquity?: string,
    public eps?: string,
    public promoterHolding?: string,
    public pledgedPercentage?: string,
    public interestCoverageRatioPEGRatio?: string,
    public priceToFreeCashFlowSalesGrowth?: string,
    public salesGrowth?: string,
    public profitGrowth3Years?: string,
    public profitGrowth5Years?: string,
    public averageReturnOnEquity3Years?: string,
    public dividendYield?: string,
    public industryPE?: string,
    public freeCashFlow3Years?: string,
    public cashFromOperationsLastYear?: string,
    public freeCashFlowLastYear?: string,
    public opm?: string,
    public profitAfterTax?: string,
    public eVEBITDA?: string
  ) {}
}

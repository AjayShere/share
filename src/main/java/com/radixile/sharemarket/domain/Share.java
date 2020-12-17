package com.radixile.sharemarket.domain;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A Share.
 */
@Entity
@Table(name = "share")
public class Share implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bcs_code")
    private String bcsCode;

    @Column(name = "nse_code")
    private String nseCode;

    @Column(name = "industry")
    private String industry;

    @Column(name = "current_price")
    private String currentPrice;

    @Column(name = "market_capitalization")
    private String marketCapitalization;

    @Column(name = "price_to_earning")
    private String priceToEarning;

    @Column(name = "debt_to_equity")
    private String debtToEquity;

    @Column(name = "operating_cash_flow")
    private String operatingCashFlow;

    @Column(name = "sales")
    private String sales;

    @Column(name = "price_to_book_value")
    private String priceToBookValue;

    @Column(name = "return_on_capital_employed")
    private String returnOnCapitalEmployed;

    @Column(name = "return_on_assets")
    private String returnOnAssets;

    @Column(name = "return_on_equity")
    private String returnOnEquity;

    @Column(name = "eps")
    private String eps;

    @Column(name = "promoter_holding")
    private String promoterHolding;

    @Column(name = "pledged_percentage")
    private String pledgedPercentage;

    @Column(name = "interest_coverage_ratio_peg_ratio")
    private String interestCoverageRatioPEGRatio;

    @Column(name = "price_to_free_cash_flow_sales_growth")
    private String priceToFreeCashFlowSalesGrowth;

    @Column(name = "sales_growth")
    private String salesGrowth;

    @Column(name = "profit_growth_3_years")
    private String profitGrowth3Years;

    @Column(name = "profit_growth_5_years")
    private String profitGrowth5Years;
	
    @Column(name = "average_return_on_equity_3_years")
    private String averageReturnOnEquity3Years;

    @Column(name = "dividend_yield")
    private String dividendYield;

    @Column(name = "industry_pe")
    private String industryPE;

    @Column(name = "free_cash_flow_3_years")
    private String freeCashFlow3Years;

    @Column(name = "cash_from_operations_last_year")
    private String cashFromOperationsLastYear;

    @Column(name = "free_cash_flow_last_year")
    private String freeCashFlowLastYear;

    @Column(name = "opm")
    private String opm;

    @Column(name = "profit_after_tax")
    private String profitAfterTax;

    @Column(name = "e_vebitda")
    private String eVEBITDA;

    @Column(name = "test1")
    private String test1;
    
    @Column(name = "test2")
    private String test2;


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Share name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBcsCode() {
        return bcsCode;
    }

    public Share bcsCode(String bcsCode) {
        this.bcsCode = bcsCode;
        return this;
    }

    public void setBcsCode(String bcsCode) {
        this.bcsCode = bcsCode;
    }

    public String getNseCode() {
        return nseCode;
    }

    public Share nseCode(String nseCode) {
        this.nseCode = nseCode;
        return this;
    }

    public void setNseCode(String nseCode) {
        this.nseCode = nseCode;
    }

    public String getIndustry() {
        return industry;
    }

    public Share industry(String industry) {
        this.industry = industry;
        return this;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public Share currentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
        return this;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public Share marketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
        return this;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public String getPriceToEarning() {
        return priceToEarning;
    }

    public Share priceToEarning(String priceToEarning) {
        this.priceToEarning = priceToEarning;
        return this;
    }

    public void setPriceToEarning(String priceToEarning) {
        this.priceToEarning = priceToEarning;
    }

    public String getDebtToEquity() {
        return debtToEquity;
    }

    public Share debtToEquity(String debtToEquity) {
        this.debtToEquity = debtToEquity;
        return this;
    }

    public void setDebtToEquity(String debtToEquity) {
        this.debtToEquity = debtToEquity;
    }

    public String getOperatingCashFlow() {
        return operatingCashFlow;
    }

    public Share operatingCashFlow(String operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
        return this;
    }

    public void setOperatingCashFlow(String operatingCashFlow) {
        this.operatingCashFlow = operatingCashFlow;
    }

    public String getSales() {
        return sales;
    }

    public Share sales(String sales) {
        this.sales = sales;
        return this;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPriceToBookValue() {
        return priceToBookValue;
    }

    public Share priceToBookValue(String priceToBookValue) {
        this.priceToBookValue = priceToBookValue;
        return this;
    }

    public void setPriceToBookValue(String priceToBookValue) {
        this.priceToBookValue = priceToBookValue;
    }

    public String getReturnOnCapitalEmployed() {
        return returnOnCapitalEmployed;
    }

    public Share returnOnCapitalEmployed(String returnOnCapitalEmployed) {
        this.returnOnCapitalEmployed = returnOnCapitalEmployed;
        return this;
    }

    public void setReturnOnCapitalEmployed(String returnOnCapitalEmployed) {
        this.returnOnCapitalEmployed = returnOnCapitalEmployed;
    }

    public String getReturnOnEquity() {
        return returnOnEquity;
    }

    public Share returnOnEquity(String returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
        return this;
    }

    public void setReturnOnEquity(String returnOnEquity) {
        this.returnOnEquity = returnOnEquity;
    }

    public String getEps() {
        return eps;
    }

    public Share eps(String eps) {
        this.eps = eps;
        return this;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getPromoterHolding() {
        return promoterHolding;
    }

    public Share promoterHolding(String promoterHolding) {
        this.promoterHolding = promoterHolding;
        return this;
    }

    public void setPromoterHolding(String promoterHolding) {
        this.promoterHolding = promoterHolding;
    }

    public String getPledgedPercentage() {
        return pledgedPercentage;
    }

    public Share pledgedPercentage(String pledgedPercentage) {
        this.pledgedPercentage = pledgedPercentage;
        return this;
    }

    public void setPledgedPercentage(String pledgedPercentage) {
        this.pledgedPercentage = pledgedPercentage;
    }

    public String getInterestCoverageRatioPEGRatio() {
        return interestCoverageRatioPEGRatio;
    }

    public Share interestCoverageRatioPEGRatio(String interestCoverageRatioPEGRatio) {
        this.interestCoverageRatioPEGRatio = interestCoverageRatioPEGRatio;
        return this;
    }

    public void setInterestCoverageRatioPEGRatio(String interestCoverageRatioPEGRatio) {
        this.interestCoverageRatioPEGRatio = interestCoverageRatioPEGRatio;
    }

    public String getPriceToFreeCashFlowSalesGrowth() {
        return priceToFreeCashFlowSalesGrowth;
    }

    public Share priceToFreeCashFlowSalesGrowth(String priceToFreeCashFlowSalesGrowth) {
        this.priceToFreeCashFlowSalesGrowth = priceToFreeCashFlowSalesGrowth;
        return this;
    }

    public void setPriceToFreeCashFlowSalesGrowth(String priceToFreeCashFlowSalesGrowth) {
        this.priceToFreeCashFlowSalesGrowth = priceToFreeCashFlowSalesGrowth;
    }

    public String getSalesGrowth() {
        return salesGrowth;
    }

    public Share salesGrowth(String salesGrowth) {
        this.salesGrowth = salesGrowth;
        return this;
    }

    public void setSalesGrowth(String salesGrowth) {
        this.salesGrowth = salesGrowth;
    }

    public String getProfitGrowth3Years() {
        return profitGrowth3Years;
    }

    public Share profitGrowth3Years(String profitGrowth3Years) {
        this.profitGrowth3Years = profitGrowth3Years;
        return this;
    }

    public void setProfitGrowth3Years(String profitGrowth3Years) {
        this.profitGrowth3Years = profitGrowth3Years;
    }

    public String getProfitGrowth5Years() {
        return profitGrowth5Years;
    }

    public Share profitGrowth5Years(String profitGrowth5Years) {
        this.profitGrowth5Years = profitGrowth5Years;
        return this;
    }

    public void setProfitGrowth5Years(String profitGrowth5Years) {
        this.profitGrowth5Years = profitGrowth5Years;
    }

    public String getAverageReturnOnEquity3Years() {
        return averageReturnOnEquity3Years;
    }

    public Share averageReturnOnEquity3Years(String averageReturnOnEquity3Years) {
        this.averageReturnOnEquity3Years = averageReturnOnEquity3Years;
        return this;
    }

    public void setAverageReturnOnEquity3Years(String averageReturnOnEquity3Years) {
        this.averageReturnOnEquity3Years = averageReturnOnEquity3Years;
    }

    public String getDividendYield() {
        return dividendYield;
    }

    public Share dividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
        return this;
    }

    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getIndustryPE() {
        return industryPE;
    }

    public Share industryPE(String industryPE) {
        this.industryPE = industryPE;
        return this;
    }

    public void setIndustryPE(String industryPE) {
        this.industryPE = industryPE;
    }

    public String getFreeCashFlow3Years() {
        return freeCashFlow3Years;
    }

    public Share freeCashFlow3Years(String freeCashFlow3Years) {
        this.freeCashFlow3Years = freeCashFlow3Years;
        return this;
    }

    public void setFreeCashFlow3Years(String freeCashFlow3Years) {
        this.freeCashFlow3Years = freeCashFlow3Years;
    }

    public String getCashFromOperationsLastYear() {
        return cashFromOperationsLastYear;
    }

    public Share cashFromOperationsLastYear(String cashFromOperationsLastYear) {
        this.cashFromOperationsLastYear = cashFromOperationsLastYear;
        return this;
    }

    public void setCashFromOperationsLastYear(String cashFromOperationsLastYear) {
        this.cashFromOperationsLastYear = cashFromOperationsLastYear;
    }

    public String getFreeCashFlowLastYear() {
        return freeCashFlowLastYear;
    }

    public Share freeCashFlowLastYear(String freeCashFlowLastYear) {
        this.freeCashFlowLastYear = freeCashFlowLastYear;
        return this;
    }

    public void setFreeCashFlowLastYear(String freeCashFlowLastYear) {
        this.freeCashFlowLastYear = freeCashFlowLastYear;
    }

    public String getOpm() {
        return opm;
    }

    public Share opm(String opm) {
        this.opm = opm;
        return this;
    }

    public void setOpm(String opm) {
        this.opm = opm;
    }

    public String getProfitAfterTax() {
        return profitAfterTax;
    }

    public Share profitAfterTax(String profitAfterTax) {
        this.profitAfterTax = profitAfterTax;
        return this;
    }

    public void setProfitAfterTax(String profitAfterTax) {
        this.profitAfterTax = profitAfterTax;
    }

    public String geteVEBITDA() {
        return eVEBITDA;
    }

    public Share eVEBITDA(String eVEBITDA) {
        this.eVEBITDA = eVEBITDA;
        return this;
    }

    public void seteVEBITDA(String eVEBITDA) {
        this.eVEBITDA = eVEBITDA;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Share)) {
            return false;
        }
        return id != null && id.equals(((Share) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Share{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", bcsCode='" + getBcsCode() + "'" +
            ", nseCode='" + getNseCode() + "'" +
            ", industry='" + getIndustry() + "'" +
            ", currentPrice='" + getCurrentPrice() + "'" +
            ", marketCapitalization='" + getMarketCapitalization() + "'" +
            ", priceToEarning='" + getPriceToEarning() + "'" +
            ", debtToEquity='" + getDebtToEquity() + "'" +
            ", operatingCashFlow='" + getOperatingCashFlow() + "'" +
            ", sales='" + getSales() + "'" +
            ", priceToBookValue='" + getPriceToBookValue() + "'" +
            ", returnOnCapitalEmployed='" + getReturnOnCapitalEmployed() + "'" +
            ", returnOnEquity='" + getReturnOnEquity() + "'" +
            ", eps='" + getEps() + "'" +
            ", promoterHolding='" + getPromoterHolding() + "'" +
            ", pledgedPercentage='" + getPledgedPercentage() + "'" +
            ", interestCoverageRatioPEGRatio='" + getInterestCoverageRatioPEGRatio() + "'" +
            ", priceToFreeCashFlowSalesGrowth='" + getPriceToFreeCashFlowSalesGrowth() + "'" +
            ", salesGrowth='" + getSalesGrowth() + "'" +
            ", profitGrowth3Years='" + getProfitGrowth3Years() + "'" +
            ", profitGrowth5Years='" + getProfitGrowth5Years() + "'" +
            ", averageReturnOnEquity3Years='" + getAverageReturnOnEquity3Years() + "'" +
            ", dividendYield='" + getDividendYield() + "'" +
            ", industryPE='" + getIndustryPE() + "'" +
            ", freeCashFlow3Years='" + getFreeCashFlow3Years() + "'" +
            ", cashFromOperationsLastYear='" + getCashFromOperationsLastYear() + "'" +
            ", freeCashFlowLastYear='" + getFreeCashFlowLastYear() + "'" +
            ", opm='" + getOpm() + "'" +
            ", profitAfterTax='" + getProfitAfterTax() + "'" +
            ", eVEBITDA='" + geteVEBITDA() + "'" +
            "}";
    }
}

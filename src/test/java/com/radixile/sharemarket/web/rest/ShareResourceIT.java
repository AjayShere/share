package com.radixile.sharemarket.web.rest;

import com.radixile.sharemarket.ShareMarketApp;
import com.radixile.sharemarket.domain.Share;
import com.radixile.sharemarket.repository.ShareRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ShareResource} REST controller.
 */
@SpringBootTest(classes = ShareMarketApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class ShareResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_BCS_CODE = "AAAAAAAAAA";
    private static final String UPDATED_BCS_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NSE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NSE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_INDUSTRY = "AAAAAAAAAA";
    private static final String UPDATED_INDUSTRY = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENT_PRICE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENT_PRICE = "BBBBBBBBBB";

    private static final String DEFAULT_MARKET_CAPITALIZATION = "AAAAAAAAAA";
    private static final String UPDATED_MARKET_CAPITALIZATION = "BBBBBBBBBB";

    private static final String DEFAULT_PRICE_TO_EARNING = "AAAAAAAAAA";
    private static final String UPDATED_PRICE_TO_EARNING = "BBBBBBBBBB";

    private static final String DEFAULT_DEBT_TO_EQUITY = "AAAAAAAAAA";
    private static final String UPDATED_DEBT_TO_EQUITY = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATING_CASH_FLOW = "AAAAAAAAAA";
    private static final String UPDATED_OPERATING_CASH_FLOW = "BBBBBBBBBB";

    private static final String DEFAULT_SALES = "AAAAAAAAAA";
    private static final String UPDATED_SALES = "BBBBBBBBBB";

    private static final String DEFAULT_PRICE_TO_BOOK_VALUE = "AAAAAAAAAA";
    private static final String UPDATED_PRICE_TO_BOOK_VALUE = "BBBBBBBBBB";

    private static final String DEFAULT_RETURN_ON_CAPITAL_EMPLOYED = "AAAAAAAAAA";
    private static final String UPDATED_RETURN_ON_CAPITAL_EMPLOYED = "BBBBBBBBBB";

    private static final String DEFAULT_RETURN_ON_EQUITY = "AAAAAAAAAA";
    private static final String UPDATED_RETURN_ON_EQUITY = "BBBBBBBBBB";

    private static final String DEFAULT_EPS = "AAAAAAAAAA";
    private static final String UPDATED_EPS = "BBBBBBBBBB";

    private static final String DEFAULT_PROMOTER_HOLDING = "AAAAAAAAAA";
    private static final String UPDATED_PROMOTER_HOLDING = "BBBBBBBBBB";

    private static final String DEFAULT_PLEDGED_PERCENTAGE = "AAAAAAAAAA";
    private static final String UPDATED_PLEDGED_PERCENTAGE = "BBBBBBBBBB";

    private static final String DEFAULT_INTEREST_COVERAGE_RATIO_PEG_RATIO = "AAAAAAAAAA";
    private static final String UPDATED_INTEREST_COVERAGE_RATIO_PEG_RATIO = "BBBBBBBBBB";

    private static final String DEFAULT_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH = "AAAAAAAAAA";
    private static final String UPDATED_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH = "BBBBBBBBBB";

    private static final String DEFAULT_SALES_GROWTH = "AAAAAAAAAA";
    private static final String UPDATED_SALES_GROWTH = "BBBBBBBBBB";

    private static final String DEFAULT_PROFIT_GROWTH_3_YEARS = "AAAAAAAAAA";
    private static final String UPDATED_PROFIT_GROWTH_3_YEARS = "BBBBBBBBBB";

    private static final String DEFAULT_PROFIT_GROWTH_5_YEARS = "AAAAAAAAAA";
    private static final String UPDATED_PROFIT_GROWTH_5_YEARS = "BBBBBBBBBB";

    private static final String DEFAULT_AVERAGE_RETURN_ON_EQUITY_3_YEARS = "AAAAAAAAAA";
    private static final String UPDATED_AVERAGE_RETURN_ON_EQUITY_3_YEARS = "BBBBBBBBBB";

    private static final String DEFAULT_DIVIDEND_YIELD = "AAAAAAAAAA";
    private static final String UPDATED_DIVIDEND_YIELD = "BBBBBBBBBB";

    private static final String DEFAULT_INDUSTRY_PE = "AAAAAAAAAA";
    private static final String UPDATED_INDUSTRY_PE = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_CASH_FLOW_3_YEARS = "AAAAAAAAAA";
    private static final String UPDATED_FREE_CASH_FLOW_3_YEARS = "BBBBBBBBBB";

    private static final String DEFAULT_CASH_FROM_OPERATIONS_LAST_YEAR = "AAAAAAAAAA";
    private static final String UPDATED_CASH_FROM_OPERATIONS_LAST_YEAR = "BBBBBBBBBB";

    private static final String DEFAULT_FREE_CASH_FLOW_LAST_YEAR = "AAAAAAAAAA";
    private static final String UPDATED_FREE_CASH_FLOW_LAST_YEAR = "BBBBBBBBBB";

    private static final String DEFAULT_OPM = "AAAAAAAAAA";
    private static final String UPDATED_OPM = "BBBBBBBBBB";

    private static final String DEFAULT_PROFIT_AFTER_TAX = "AAAAAAAAAA";
    private static final String UPDATED_PROFIT_AFTER_TAX = "BBBBBBBBBB";

    private static final String DEFAULT_E_VEBITDA = "AAAAAAAAAA";
    private static final String UPDATED_E_VEBITDA = "BBBBBBBBBB";

    @Autowired
    private ShareRepository shareRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restShareMockMvc;

    private Share share;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Share createEntity(EntityManager em) {
        Share share = new Share()
            .name(DEFAULT_NAME)
            .bcsCode(DEFAULT_BCS_CODE)
            .nseCode(DEFAULT_NSE_CODE)
            .industry(DEFAULT_INDUSTRY)
            .currentPrice(DEFAULT_CURRENT_PRICE)
            .marketCapitalization(DEFAULT_MARKET_CAPITALIZATION)
            .priceToEarning(DEFAULT_PRICE_TO_EARNING)
            .debtToEquity(DEFAULT_DEBT_TO_EQUITY)
            .operatingCashFlow(DEFAULT_OPERATING_CASH_FLOW)
            .sales(DEFAULT_SALES)
            .priceToBookValue(DEFAULT_PRICE_TO_BOOK_VALUE)
            .returnOnCapitalEmployed(DEFAULT_RETURN_ON_CAPITAL_EMPLOYED)
            .returnOnEquity(DEFAULT_RETURN_ON_EQUITY)
            .eps(DEFAULT_EPS)
            .promoterHolding(DEFAULT_PROMOTER_HOLDING)
            .pledgedPercentage(DEFAULT_PLEDGED_PERCENTAGE)
            .interestCoverageRatioPEGRatio(DEFAULT_INTEREST_COVERAGE_RATIO_PEG_RATIO)
            .priceToFreeCashFlowSalesGrowth(DEFAULT_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH)
            .salesGrowth(DEFAULT_SALES_GROWTH)
            .profitGrowth3Years(DEFAULT_PROFIT_GROWTH_3_YEARS)
            .profitGrowth5Years(DEFAULT_PROFIT_GROWTH_5_YEARS)
            .averageReturnOnEquity3Years(DEFAULT_AVERAGE_RETURN_ON_EQUITY_3_YEARS)
            .dividendYield(DEFAULT_DIVIDEND_YIELD)
            .industryPE(DEFAULT_INDUSTRY_PE)
            .freeCashFlow3Years(DEFAULT_FREE_CASH_FLOW_3_YEARS)
            .cashFromOperationsLastYear(DEFAULT_CASH_FROM_OPERATIONS_LAST_YEAR)
            .freeCashFlowLastYear(DEFAULT_FREE_CASH_FLOW_LAST_YEAR)
            .opm(DEFAULT_OPM)
            .profitAfterTax(DEFAULT_PROFIT_AFTER_TAX)
            .eVEBITDA(DEFAULT_E_VEBITDA);
        return share;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Share createUpdatedEntity(EntityManager em) {
        Share share = new Share()
            .name(UPDATED_NAME)
            .bcsCode(UPDATED_BCS_CODE)
            .nseCode(UPDATED_NSE_CODE)
            .industry(UPDATED_INDUSTRY)
            .currentPrice(UPDATED_CURRENT_PRICE)
            .marketCapitalization(UPDATED_MARKET_CAPITALIZATION)
            .priceToEarning(UPDATED_PRICE_TO_EARNING)
            .debtToEquity(UPDATED_DEBT_TO_EQUITY)
            .operatingCashFlow(UPDATED_OPERATING_CASH_FLOW)
            .sales(UPDATED_SALES)
            .priceToBookValue(UPDATED_PRICE_TO_BOOK_VALUE)
            .returnOnCapitalEmployed(UPDATED_RETURN_ON_CAPITAL_EMPLOYED)
            .returnOnEquity(UPDATED_RETURN_ON_EQUITY)
            .eps(UPDATED_EPS)
            .promoterHolding(UPDATED_PROMOTER_HOLDING)
            .pledgedPercentage(UPDATED_PLEDGED_PERCENTAGE)
            .interestCoverageRatioPEGRatio(UPDATED_INTEREST_COVERAGE_RATIO_PEG_RATIO)
            .priceToFreeCashFlowSalesGrowth(UPDATED_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH)
            .salesGrowth(UPDATED_SALES_GROWTH)
            .profitGrowth3Years(UPDATED_PROFIT_GROWTH_3_YEARS)
            .profitGrowth5Years(UPDATED_PROFIT_GROWTH_5_YEARS)
            .averageReturnOnEquity3Years(UPDATED_AVERAGE_RETURN_ON_EQUITY_3_YEARS)
            .dividendYield(UPDATED_DIVIDEND_YIELD)
            .industryPE(UPDATED_INDUSTRY_PE)
            .freeCashFlow3Years(UPDATED_FREE_CASH_FLOW_3_YEARS)
            .cashFromOperationsLastYear(UPDATED_CASH_FROM_OPERATIONS_LAST_YEAR)
            .freeCashFlowLastYear(UPDATED_FREE_CASH_FLOW_LAST_YEAR)
            .opm(UPDATED_OPM)
            .profitAfterTax(UPDATED_PROFIT_AFTER_TAX)
            .eVEBITDA(UPDATED_E_VEBITDA);
        return share;
    }

    @BeforeEach
    public void initTest() {
        share = createEntity(em);
    }

    @Test
    @Transactional
    public void createShare() throws Exception {
        int databaseSizeBeforeCreate = shareRepository.findAll().size();
        // Create the Share
        restShareMockMvc.perform(post("/api/shares").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(share)))
            .andExpect(status().isCreated());

        // Validate the Share in the database
        List<Share> shareList = shareRepository.findAll();
        assertThat(shareList).hasSize(databaseSizeBeforeCreate + 1);
        Share testShare = shareList.get(shareList.size() - 1);
        assertThat(testShare.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testShare.getBcsCode()).isEqualTo(DEFAULT_BCS_CODE);
        assertThat(testShare.getNseCode()).isEqualTo(DEFAULT_NSE_CODE);
        assertThat(testShare.getIndustry()).isEqualTo(DEFAULT_INDUSTRY);
        assertThat(testShare.getCurrentPrice()).isEqualTo(DEFAULT_CURRENT_PRICE);
        assertThat(testShare.getMarketCapitalization()).isEqualTo(DEFAULT_MARKET_CAPITALIZATION);
        assertThat(testShare.getPriceToEarning()).isEqualTo(DEFAULT_PRICE_TO_EARNING);
        assertThat(testShare.getDebtToEquity()).isEqualTo(DEFAULT_DEBT_TO_EQUITY);
        assertThat(testShare.getOperatingCashFlow()).isEqualTo(DEFAULT_OPERATING_CASH_FLOW);
        assertThat(testShare.getSales()).isEqualTo(DEFAULT_SALES);
        assertThat(testShare.getPriceToBookValue()).isEqualTo(DEFAULT_PRICE_TO_BOOK_VALUE);
        assertThat(testShare.getReturnOnCapitalEmployed()).isEqualTo(DEFAULT_RETURN_ON_CAPITAL_EMPLOYED);
        assertThat(testShare.getReturnOnEquity()).isEqualTo(DEFAULT_RETURN_ON_EQUITY);
        assertThat(testShare.getEps()).isEqualTo(DEFAULT_EPS);
        assertThat(testShare.getPromoterHolding()).isEqualTo(DEFAULT_PROMOTER_HOLDING);
        assertThat(testShare.getPledgedPercentage()).isEqualTo(DEFAULT_PLEDGED_PERCENTAGE);
        assertThat(testShare.getInterestCoverageRatioPEGRatio()).isEqualTo(DEFAULT_INTEREST_COVERAGE_RATIO_PEG_RATIO);
        assertThat(testShare.getPriceToFreeCashFlowSalesGrowth()).isEqualTo(DEFAULT_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH);
        assertThat(testShare.getSalesGrowth()).isEqualTo(DEFAULT_SALES_GROWTH);
        assertThat(testShare.getProfitGrowth3Years()).isEqualTo(DEFAULT_PROFIT_GROWTH_3_YEARS);
        assertThat(testShare.getProfitGrowth5Years()).isEqualTo(DEFAULT_PROFIT_GROWTH_5_YEARS);
        assertThat(testShare.getAverageReturnOnEquity3Years()).isEqualTo(DEFAULT_AVERAGE_RETURN_ON_EQUITY_3_YEARS);
        assertThat(testShare.getDividendYield()).isEqualTo(DEFAULT_DIVIDEND_YIELD);
        assertThat(testShare.getIndustryPE()).isEqualTo(DEFAULT_INDUSTRY_PE);
        assertThat(testShare.getFreeCashFlow3Years()).isEqualTo(DEFAULT_FREE_CASH_FLOW_3_YEARS);
        assertThat(testShare.getCashFromOperationsLastYear()).isEqualTo(DEFAULT_CASH_FROM_OPERATIONS_LAST_YEAR);
        assertThat(testShare.getFreeCashFlowLastYear()).isEqualTo(DEFAULT_FREE_CASH_FLOW_LAST_YEAR);
        assertThat(testShare.getOpm()).isEqualTo(DEFAULT_OPM);
        assertThat(testShare.getProfitAfterTax()).isEqualTo(DEFAULT_PROFIT_AFTER_TAX);
        assertThat(testShare.geteVEBITDA()).isEqualTo(DEFAULT_E_VEBITDA);
    }

    @Test
    @Transactional
    public void createShareWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = shareRepository.findAll().size();

        // Create the Share with an existing ID
        share.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restShareMockMvc.perform(post("/api/shares").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(share)))
            .andExpect(status().isBadRequest());

        // Validate the Share in the database
        List<Share> shareList = shareRepository.findAll();
        assertThat(shareList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllShares() throws Exception {
        // Initialize the database
        shareRepository.saveAndFlush(share);

        // Get all the shareList
        restShareMockMvc.perform(get("/api/shares?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(share.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].bcsCode").value(hasItem(DEFAULT_BCS_CODE)))
            .andExpect(jsonPath("$.[*].nseCode").value(hasItem(DEFAULT_NSE_CODE)))
            .andExpect(jsonPath("$.[*].industry").value(hasItem(DEFAULT_INDUSTRY)))
            .andExpect(jsonPath("$.[*].currentPrice").value(hasItem(DEFAULT_CURRENT_PRICE)))
            .andExpect(jsonPath("$.[*].marketCapitalization").value(hasItem(DEFAULT_MARKET_CAPITALIZATION)))
            .andExpect(jsonPath("$.[*].priceToEarning").value(hasItem(DEFAULT_PRICE_TO_EARNING)))
            .andExpect(jsonPath("$.[*].debtToEquity").value(hasItem(DEFAULT_DEBT_TO_EQUITY)))
            .andExpect(jsonPath("$.[*].operatingCashFlow").value(hasItem(DEFAULT_OPERATING_CASH_FLOW)))
            .andExpect(jsonPath("$.[*].sales").value(hasItem(DEFAULT_SALES)))
            .andExpect(jsonPath("$.[*].priceToBookValue").value(hasItem(DEFAULT_PRICE_TO_BOOK_VALUE)))
            .andExpect(jsonPath("$.[*].returnOnCapitalEmployed").value(hasItem(DEFAULT_RETURN_ON_CAPITAL_EMPLOYED)))
            .andExpect(jsonPath("$.[*].returnOnEquity").value(hasItem(DEFAULT_RETURN_ON_EQUITY)))
            .andExpect(jsonPath("$.[*].eps").value(hasItem(DEFAULT_EPS)))
            .andExpect(jsonPath("$.[*].promoterHolding").value(hasItem(DEFAULT_PROMOTER_HOLDING)))
            .andExpect(jsonPath("$.[*].pledgedPercentage").value(hasItem(DEFAULT_PLEDGED_PERCENTAGE)))
            .andExpect(jsonPath("$.[*].interestCoverageRatioPEGRatio").value(hasItem(DEFAULT_INTEREST_COVERAGE_RATIO_PEG_RATIO)))
            .andExpect(jsonPath("$.[*].priceToFreeCashFlowSalesGrowth").value(hasItem(DEFAULT_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH)))
            .andExpect(jsonPath("$.[*].salesGrowth").value(hasItem(DEFAULT_SALES_GROWTH)))
            .andExpect(jsonPath("$.[*].profitGrowth3Years").value(hasItem(DEFAULT_PROFIT_GROWTH_3_YEARS)))
            .andExpect(jsonPath("$.[*].profitGrowth5Years").value(hasItem(DEFAULT_PROFIT_GROWTH_5_YEARS)))
            .andExpect(jsonPath("$.[*].averageReturnOnEquity3Years").value(hasItem(DEFAULT_AVERAGE_RETURN_ON_EQUITY_3_YEARS)))
            .andExpect(jsonPath("$.[*].dividendYield").value(hasItem(DEFAULT_DIVIDEND_YIELD)))
            .andExpect(jsonPath("$.[*].industryPE").value(hasItem(DEFAULT_INDUSTRY_PE)))
            .andExpect(jsonPath("$.[*].freeCashFlow3Years").value(hasItem(DEFAULT_FREE_CASH_FLOW_3_YEARS)))
            .andExpect(jsonPath("$.[*].cashFromOperationsLastYear").value(hasItem(DEFAULT_CASH_FROM_OPERATIONS_LAST_YEAR)))
            .andExpect(jsonPath("$.[*].freeCashFlowLastYear").value(hasItem(DEFAULT_FREE_CASH_FLOW_LAST_YEAR)))
            .andExpect(jsonPath("$.[*].opm").value(hasItem(DEFAULT_OPM)))
            .andExpect(jsonPath("$.[*].profitAfterTax").value(hasItem(DEFAULT_PROFIT_AFTER_TAX)))
            .andExpect(jsonPath("$.[*].eVEBITDA").value(hasItem(DEFAULT_E_VEBITDA)));
    }
    
    @Test
    @Transactional
    public void getShare() throws Exception {
        // Initialize the database
        shareRepository.saveAndFlush(share);

        // Get the share
        restShareMockMvc.perform(get("/api/shares/{id}", share.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(share.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.bcsCode").value(DEFAULT_BCS_CODE))
            .andExpect(jsonPath("$.nseCode").value(DEFAULT_NSE_CODE))
            .andExpect(jsonPath("$.industry").value(DEFAULT_INDUSTRY))
            .andExpect(jsonPath("$.currentPrice").value(DEFAULT_CURRENT_PRICE))
            .andExpect(jsonPath("$.marketCapitalization").value(DEFAULT_MARKET_CAPITALIZATION))
            .andExpect(jsonPath("$.priceToEarning").value(DEFAULT_PRICE_TO_EARNING))
            .andExpect(jsonPath("$.debtToEquity").value(DEFAULT_DEBT_TO_EQUITY))
            .andExpect(jsonPath("$.operatingCashFlow").value(DEFAULT_OPERATING_CASH_FLOW))
            .andExpect(jsonPath("$.sales").value(DEFAULT_SALES))
            .andExpect(jsonPath("$.priceToBookValue").value(DEFAULT_PRICE_TO_BOOK_VALUE))
            .andExpect(jsonPath("$.returnOnCapitalEmployed").value(DEFAULT_RETURN_ON_CAPITAL_EMPLOYED))
            .andExpect(jsonPath("$.returnOnEquity").value(DEFAULT_RETURN_ON_EQUITY))
            .andExpect(jsonPath("$.eps").value(DEFAULT_EPS))
            .andExpect(jsonPath("$.promoterHolding").value(DEFAULT_PROMOTER_HOLDING))
            .andExpect(jsonPath("$.pledgedPercentage").value(DEFAULT_PLEDGED_PERCENTAGE))
            .andExpect(jsonPath("$.interestCoverageRatioPEGRatio").value(DEFAULT_INTEREST_COVERAGE_RATIO_PEG_RATIO))
            .andExpect(jsonPath("$.priceToFreeCashFlowSalesGrowth").value(DEFAULT_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH))
            .andExpect(jsonPath("$.salesGrowth").value(DEFAULT_SALES_GROWTH))
            .andExpect(jsonPath("$.profitGrowth3Years").value(DEFAULT_PROFIT_GROWTH_3_YEARS))
            .andExpect(jsonPath("$.profitGrowth5Years").value(DEFAULT_PROFIT_GROWTH_5_YEARS))
            .andExpect(jsonPath("$.averageReturnOnEquity3Years").value(DEFAULT_AVERAGE_RETURN_ON_EQUITY_3_YEARS))
            .andExpect(jsonPath("$.dividendYield").value(DEFAULT_DIVIDEND_YIELD))
            .andExpect(jsonPath("$.industryPE").value(DEFAULT_INDUSTRY_PE))
            .andExpect(jsonPath("$.freeCashFlow3Years").value(DEFAULT_FREE_CASH_FLOW_3_YEARS))
            .andExpect(jsonPath("$.cashFromOperationsLastYear").value(DEFAULT_CASH_FROM_OPERATIONS_LAST_YEAR))
            .andExpect(jsonPath("$.freeCashFlowLastYear").value(DEFAULT_FREE_CASH_FLOW_LAST_YEAR))
            .andExpect(jsonPath("$.opm").value(DEFAULT_OPM))
            .andExpect(jsonPath("$.profitAfterTax").value(DEFAULT_PROFIT_AFTER_TAX))
            .andExpect(jsonPath("$.eVEBITDA").value(DEFAULT_E_VEBITDA));
    }
    @Test
    @Transactional
    public void getNonExistingShare() throws Exception {
        // Get the share
        restShareMockMvc.perform(get("/api/shares/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateShare() throws Exception {
        // Initialize the database
        shareRepository.saveAndFlush(share);

        int databaseSizeBeforeUpdate = shareRepository.findAll().size();

        // Update the share
        Share updatedShare = shareRepository.findById(share.getId()).get();
        // Disconnect from session so that the updates on updatedShare are not directly saved in db
        em.detach(updatedShare);
        updatedShare
            .name(UPDATED_NAME)
            .bcsCode(UPDATED_BCS_CODE)
            .nseCode(UPDATED_NSE_CODE)
            .industry(UPDATED_INDUSTRY)
            .currentPrice(UPDATED_CURRENT_PRICE)
            .marketCapitalization(UPDATED_MARKET_CAPITALIZATION)
            .priceToEarning(UPDATED_PRICE_TO_EARNING)
            .debtToEquity(UPDATED_DEBT_TO_EQUITY)
            .operatingCashFlow(UPDATED_OPERATING_CASH_FLOW)
            .sales(UPDATED_SALES)
            .priceToBookValue(UPDATED_PRICE_TO_BOOK_VALUE)
            .returnOnCapitalEmployed(UPDATED_RETURN_ON_CAPITAL_EMPLOYED)
            .returnOnEquity(UPDATED_RETURN_ON_EQUITY)
            .eps(UPDATED_EPS)
            .promoterHolding(UPDATED_PROMOTER_HOLDING)
            .pledgedPercentage(UPDATED_PLEDGED_PERCENTAGE)
            .interestCoverageRatioPEGRatio(UPDATED_INTEREST_COVERAGE_RATIO_PEG_RATIO)
            .priceToFreeCashFlowSalesGrowth(UPDATED_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH)
            .salesGrowth(UPDATED_SALES_GROWTH)
            .profitGrowth3Years(UPDATED_PROFIT_GROWTH_3_YEARS)
            .profitGrowth5Years(UPDATED_PROFIT_GROWTH_5_YEARS)
            .averageReturnOnEquity3Years(UPDATED_AVERAGE_RETURN_ON_EQUITY_3_YEARS)
            .dividendYield(UPDATED_DIVIDEND_YIELD)
            .industryPE(UPDATED_INDUSTRY_PE)
            .freeCashFlow3Years(UPDATED_FREE_CASH_FLOW_3_YEARS)
            .cashFromOperationsLastYear(UPDATED_CASH_FROM_OPERATIONS_LAST_YEAR)
            .freeCashFlowLastYear(UPDATED_FREE_CASH_FLOW_LAST_YEAR)
            .opm(UPDATED_OPM)
            .profitAfterTax(UPDATED_PROFIT_AFTER_TAX)
            .eVEBITDA(UPDATED_E_VEBITDA);

        restShareMockMvc.perform(put("/api/shares").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedShare)))
            .andExpect(status().isOk());

        // Validate the Share in the database
        List<Share> shareList = shareRepository.findAll();
        assertThat(shareList).hasSize(databaseSizeBeforeUpdate);
        Share testShare = shareList.get(shareList.size() - 1);
        assertThat(testShare.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testShare.getBcsCode()).isEqualTo(UPDATED_BCS_CODE);
        assertThat(testShare.getNseCode()).isEqualTo(UPDATED_NSE_CODE);
        assertThat(testShare.getIndustry()).isEqualTo(UPDATED_INDUSTRY);
        assertThat(testShare.getCurrentPrice()).isEqualTo(UPDATED_CURRENT_PRICE);
        assertThat(testShare.getMarketCapitalization()).isEqualTo(UPDATED_MARKET_CAPITALIZATION);
        assertThat(testShare.getPriceToEarning()).isEqualTo(UPDATED_PRICE_TO_EARNING);
        assertThat(testShare.getDebtToEquity()).isEqualTo(UPDATED_DEBT_TO_EQUITY);
        assertThat(testShare.getOperatingCashFlow()).isEqualTo(UPDATED_OPERATING_CASH_FLOW);
        assertThat(testShare.getSales()).isEqualTo(UPDATED_SALES);
        assertThat(testShare.getPriceToBookValue()).isEqualTo(UPDATED_PRICE_TO_BOOK_VALUE);
        assertThat(testShare.getReturnOnCapitalEmployed()).isEqualTo(UPDATED_RETURN_ON_CAPITAL_EMPLOYED);
        assertThat(testShare.getReturnOnEquity()).isEqualTo(UPDATED_RETURN_ON_EQUITY);
        assertThat(testShare.getEps()).isEqualTo(UPDATED_EPS);
        assertThat(testShare.getPromoterHolding()).isEqualTo(UPDATED_PROMOTER_HOLDING);
        assertThat(testShare.getPledgedPercentage()).isEqualTo(UPDATED_PLEDGED_PERCENTAGE);
        assertThat(testShare.getInterestCoverageRatioPEGRatio()).isEqualTo(UPDATED_INTEREST_COVERAGE_RATIO_PEG_RATIO);
        assertThat(testShare.getPriceToFreeCashFlowSalesGrowth()).isEqualTo(UPDATED_PRICE_TO_FREE_CASH_FLOW_SALES_GROWTH);
        assertThat(testShare.getSalesGrowth()).isEqualTo(UPDATED_SALES_GROWTH);
        assertThat(testShare.getProfitGrowth3Years()).isEqualTo(UPDATED_PROFIT_GROWTH_3_YEARS);
        assertThat(testShare.getProfitGrowth5Years()).isEqualTo(UPDATED_PROFIT_GROWTH_5_YEARS);
        assertThat(testShare.getAverageReturnOnEquity3Years()).isEqualTo(UPDATED_AVERAGE_RETURN_ON_EQUITY_3_YEARS);
        assertThat(testShare.getDividendYield()).isEqualTo(UPDATED_DIVIDEND_YIELD);
        assertThat(testShare.getIndustryPE()).isEqualTo(UPDATED_INDUSTRY_PE);
        assertThat(testShare.getFreeCashFlow3Years()).isEqualTo(UPDATED_FREE_CASH_FLOW_3_YEARS);
        assertThat(testShare.getCashFromOperationsLastYear()).isEqualTo(UPDATED_CASH_FROM_OPERATIONS_LAST_YEAR);
        assertThat(testShare.getFreeCashFlowLastYear()).isEqualTo(UPDATED_FREE_CASH_FLOW_LAST_YEAR);
        assertThat(testShare.getOpm()).isEqualTo(UPDATED_OPM);
        assertThat(testShare.getProfitAfterTax()).isEqualTo(UPDATED_PROFIT_AFTER_TAX);
        assertThat(testShare.geteVEBITDA()).isEqualTo(UPDATED_E_VEBITDA);
    }

    @Test
    @Transactional
    public void updateNonExistingShare() throws Exception {
        int databaseSizeBeforeUpdate = shareRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restShareMockMvc.perform(put("/api/shares").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(share)))
            .andExpect(status().isBadRequest());

        // Validate the Share in the database
        List<Share> shareList = shareRepository.findAll();
        assertThat(shareList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteShare() throws Exception {
        // Initialize the database
        shareRepository.saveAndFlush(share);

        int databaseSizeBeforeDelete = shareRepository.findAll().size();

        // Delete the share
        restShareMockMvc.perform(delete("/api/shares/{id}", share.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Share> shareList = shareRepository.findAll();
        assertThat(shareList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

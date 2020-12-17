package com.radixile.sharemarket.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.radixile.sharemarket.web.rest.TestUtil;

public class ShareTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Share.class);
        Share share1 = new Share();
        share1.setId(1L);
        Share share2 = new Share();
        share2.setId(share1.getId());
        assertThat(share1).isEqualTo(share2);
        share2.setId(2L);
        assertThat(share1).isNotEqualTo(share2);
        share1.setId(null);
        assertThat(share1).isNotEqualTo(share2);
    }
}

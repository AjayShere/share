package com.radixile.sharemarket.repository;

import com.radixile.sharemarket.domain.Share;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Share entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ShareRepository extends JpaRepository<Share, Long> {
}

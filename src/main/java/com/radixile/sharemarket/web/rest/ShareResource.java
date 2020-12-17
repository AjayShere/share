package com.radixile.sharemarket.web.rest;

import com.radixile.sharemarket.domain.Share;
import com.radixile.sharemarket.repository.ShareRepository;
import com.radixile.sharemarket.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.radixile.sharemarket.domain.Share}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ShareResource {

    private final Logger log = LoggerFactory.getLogger(ShareResource.class);

    private static final String ENTITY_NAME = "share";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ShareRepository shareRepository;

    public ShareResource(ShareRepository shareRepository) {
        this.shareRepository = shareRepository;
    }

    /**
     * {@code POST  /shares} : Create a new share.
     *
     * @param share the share to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new share, or with status {@code 400 (Bad Request)} if the share has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/shares")
    public ResponseEntity<Share> createShare(@RequestBody Share share) throws URISyntaxException {
        log.debug("REST request to save Share : {}", share);
        if (share.getId() != null) {
            throw new BadRequestAlertException("A new share cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Share result = shareRepository.save(share);
        return ResponseEntity.created(new URI("/api/shares/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /shares} : Updates an existing share.
     *
     * @param share the share to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated share,
     * or with status {@code 400 (Bad Request)} if the share is not valid,
     * or with status {@code 500 (Internal Server Error)} if the share couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/shares")
    public ResponseEntity<Share> updateShare(@RequestBody Share share) throws URISyntaxException {
        log.debug("REST request to update Share : {}", share);
        if (share.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Share result = shareRepository.save(share);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, share.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /shares} : get all the shares.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of shares in body.
     */
    @GetMapping("/shares")
    public List<Share> getAllShares() {
        log.debug("REST request to get all Shares");
        return shareRepository.findAll();
    }

    /**
     * {@code GET  /shares/:id} : get the "id" share.
     *
     * @param id the id of the share to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the share, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/shares/{id}")
    public ResponseEntity<Share> getShare(@PathVariable Long id) {
        log.debug("REST request to get Share : {}", id);
        Optional<Share> share = shareRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(share);
    }

    /**
     * {@code DELETE  /shares/:id} : delete the "id" share.
     *
     * @param id the id of the share to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/shares/{id}")
    public ResponseEntity<Void> deleteShare(@PathVariable Long id) {
        log.debug("REST request to delete Share : {}", id);
        shareRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

package com.kamyesm.bitsystembackend.Controller;

import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignCreateRequest;
import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignPatchRequest;
import com.kamyesm.bitsystembackend.DTO.Campaign.CampaignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop/campaign")
public class CampaignController {

    @PostMapping("")
    public ResponseEntity<CampaignResponse> createCampaign(@RequestBody CampaignCreateRequest value) {
        return null;
    }

    @GetMapping("")
    public ResponseEntity<List<CampaignResponse>> getAllActiveCampaign() {
        return null;
    }

    @GetMapping("/{title}")
    public ResponseEntity<CampaignResponse> getCampaignByTitle(
            @PathVariable String title
    ) {
        return null;
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<?> delete(@PathVariable String title) {
        return null;
    }

    @PatchMapping("/{title}")
    public ResponseEntity<CampaignResponse> patch(@RequestBody CampaignPatchRequest value,
                                                  @PathVariable String title) {
        return null;
    }
}

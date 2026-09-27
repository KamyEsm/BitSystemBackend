package com.kamyesm.bitsystembackend.DTO.Campaign;

import lombok.*;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CampaignResponse {
    private String title;

    private String description;

    private String link;


    private List<String> images;

    private Instant startDate;

    private Instant endDate;

    private Integer discountPercentage;
}

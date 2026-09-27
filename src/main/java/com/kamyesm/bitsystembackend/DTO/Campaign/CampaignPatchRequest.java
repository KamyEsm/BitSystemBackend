package com.kamyesm.bitsystembackend.DTO.Campaign;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
@Builder
public class CampaignPatchRequest {

    private String title;

    private String description;

    private String link;


    private List<String> images;

    private Instant startDate;
    private Instant endDate;

    @Min(0)
    private Integer discountPercentage;
}

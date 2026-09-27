package com.kamyesm.bitsystembackend.DTO.Campaign;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CampaignCreateRequest {

    @NotBlank
    @Min(3)
    private String title;

    private String description;

    private String link;


    private List<String> images;

    @NotNull
    private Instant startDate;
    @NotNull
    private Instant endDate;

    @Min(0)
    private Integer discountPercentage;
}

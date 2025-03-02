package com.airbnb.home.domain;

import com.airbnb.shared.domain.AbstractAuditingEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "homestay_availability")
@IdClass(HomestayAvailabilityId.class)
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HomestayAvailability extends AbstractAuditingEntity<HomestayAvailabilityId> {

    @Id
    private Long homestayId;

    @Id
    private LocalDate date;

    @NonNull
    private boolean available;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "status")
    private Integer status;

    @Override
    public HomestayAvailabilityId getId() {
        return new HomestayAvailabilityId(homestayId, date);
    }
}

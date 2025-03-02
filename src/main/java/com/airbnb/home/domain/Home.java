package com.airbnb.home.domain;

import com.airbnb.shared.domain.AbstractAuditingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "home")
public class Home extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "homeSequenceGenerator")
    @SequenceGenerator(name = "homeSequenceGenerator", sequenceName = "home_generator", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @UuidGenerator
    @Column(name = "public_id", nullable = false)
    private UUID publicId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "guests")
    private int guests;

    @Column(name = "bedrooms")
    private int bedrooms;

    @Column(name = "beds")
    private int beds;

    @Column(name = "bathrooms")
    private int bathrooms;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private HomeCategory homeCategory;

    @Column(name = "location")
    private String location;

    @Column(name = "landlord_public_id")
    private UUID landlordPublicId;

    @OneToMany(mappedBy = "home", cascade = CascadeType.REMOVE)
    private Set<HomePicture> pictures = new HashSet<>();
}

package com.airbnb.home.domain;

import com.airbnb.shared.domain.AbstractAuditingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "home_picture")
public class HomePicture extends AbstractAuditingEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "homePictureSequenceGenerator")
    @SequenceGenerator(name = "homePictureSequenceGenerator", sequenceName = "home_picture_generator", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "home_picture_fk", referencedColumnName = "id")
    private Home home;

    @Lob
    @Column(name = "file", nullable = false)
    private byte[] file;

    @Column(name = "file_content_type")
    private String fileContentType;

    @Column(name = "is_cover")
    private boolean isCover;
}

package ge.unknown.entities;

import ge.unknown.entities.translation.TitleDescriptionTranslation;
import ge.unknown.enums.EFaqCategory;

import javax.persistence.*;

/**
 * Created by MJaniko on 4/15/2017.
 */
@Entity
@Table(name = "faq")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private EFaqCategory category;

    @Embedded
    private TitleDescriptionTranslation translation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EFaqCategory getCategory() {
        return category;
    }

    public void setCategory(EFaqCategory category) {
        this.category = category;
    }

    public TitleDescriptionTranslation getTranslation() {
        return translation;
    }

    public void setTranslation(TitleDescriptionTranslation translation) {
        this.translation = translation;
    }
}

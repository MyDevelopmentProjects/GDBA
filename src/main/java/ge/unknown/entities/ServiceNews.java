package ge.unknown.entities;

import ge.unknown.entities.translation.TitleDescriptionTranslation;
import javax.persistence.*;

@Entity
@Table(name = "service_news")
public class ServiceNews extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private TitleDescriptionTranslation details;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_id")
    private News news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public TitleDescriptionTranslation getDetails() {
        return details;
    }

    public void setDetails(TitleDescriptionTranslation details) {
        this.details = details;
    }
}

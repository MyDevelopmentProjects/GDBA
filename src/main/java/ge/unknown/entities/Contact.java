package ge.unknown.entities;

import javax.persistence.*;

/**
 * Created by MJaniko on 3/12/2017.
 */
@Entity
@Table(name = "contact")
public class Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "data")
    private String data;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

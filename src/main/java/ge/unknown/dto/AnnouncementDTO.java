package ge.unknown.dto;

/**
 * Created by Mikheil on 7/7/2017.
 */
public class AnnouncementDTO {

    private Long id;
    private String subject;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

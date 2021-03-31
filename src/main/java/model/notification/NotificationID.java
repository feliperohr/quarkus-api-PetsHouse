package model.notification;

import java.io.Serializable;

public class NotificationID implements Serializable {

    private Long pet_sitter_id;

    private Long task_id;

    public NotificationID() {
    }

    public Long getPet_sitter_id() {
        return pet_sitter_id;
    }

    public void setPet_sitter_id(Long pet_sitter_id) {
        this.pet_sitter_id = pet_sitter_id;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }
}

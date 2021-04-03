package service.notification;

import model.notification.Notification;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

import static javax.transaction.Transactional.TxType.REQUIRED;

@ApplicationScoped
@Transactional(REQUIRED)
public class NotificationService {

    public Notification findAllNotifications() {
        return null;
    }

    public Notification persistNotification(@Valid Notification notification) {
        return null;
    }

    public Notification deleteNotification(Long id) { return null; }

}

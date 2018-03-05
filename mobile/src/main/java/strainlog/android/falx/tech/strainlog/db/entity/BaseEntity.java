package strainlog.android.falx.tech.strainlog.db.entity;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * @author <a href="mailto:kschneider@codingfalx.de">Kristoffer Schneider alias falx<a>
 */

public class BaseEntity {
    @Id
    protected Long id;

    @NotNull
    protected Date created;
    @NotNull
    protected Date updated;


}
